/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2017 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.resource.service;


@org.springframework.stereotype.Service("blResourceBundlingService")
public class ResourceBundlingServiceImpl implements org.broadleafcommerce.common.resource.service.ResourceBundlingService {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.class);

    @javax.annotation.Resource(name = "blAdditionalBundleFiles")
    protected java.util.Map<java.lang.String, java.util.List<java.lang.String>> additionalBundleFiles;

    @javax.annotation.Resource(name = "blFileService")
    protected org.broadleafcommerce.common.file.service.BroadleafFileService fileService;

    protected org.springframework.web.servlet.resource.ResourceHttpRequestHandler jsResourceHandler;

    protected org.springframework.web.servlet.resource.ResourceHttpRequestHandler cssResourceHandler;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.context.ApplicationContext appctx;

    @javax.annotation.Resource(name = "blStatisticsService")
    protected org.broadleafcommerce.common.cache.StatisticsService statisticsService;

    private de.jkeylockmanager.manager.KeyLockManager keyLockManager = de.jkeylockmanager.manager.KeyLockManagers.newLock();

    private java.util.concurrent.ConcurrentHashMap<java.lang.String, org.broadleafcommerce.common.resource.BundledResourceInfo> createdBundles = new java.util.concurrent.ConcurrentHashMap<>();

    @org.springframework.context.event.EventListener
    public void initializeResources(org.springframework.context.event.ContextRefreshedEvent event) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4516, ((jsResourceHandler) == null))) {
            try {
                jsResourceHandler = appctx.getBean("blJsResources", org.springframework.web.servlet.resource.ResourceHttpRequestHandler.class);
            } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException e) {
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4517, ((cssResourceHandler) == null))) {
            try {
                cssResourceHandler = appctx.getBean("blCssResources", org.springframework.web.servlet.resource.ResourceHttpRequestHandler.class);
            } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException e) {
            }
        }
    }

    @java.lang.Override
    public org.springframework.core.io.Resource rebuildBundledResource(java.lang.String requestedBundleName) {
        java.lang.String resourceName = lookupBundlePath(requestedBundleName);
        org.broadleafcommerce.common.resource.BundledResourceInfo bundleInfo = createdBundles.get(resourceName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4518, (bundleInfo != null))) {
            createdBundles.remove(resourceName);
            org.springframework.web.servlet.resource.ResourceHttpRequestHandler resourceRequestHandler = findResourceHttpRequestHandler(requestedBundleName);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4519, (resourceRequestHandler != null))) {
                org.springframework.web.servlet.resource.ResourceResolverChain resolverChain = new org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain(resourceRequestHandler.getResourceResolvers());
                java.util.List<org.springframework.core.io.Resource> locations = resourceRequestHandler.getLocations();
                createBundleIfNeeded(bundleInfo.getVersionedBundleName(), bundleInfo.getBundledFilePaths(), resolverChain, locations);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4520, (resourceName != null)) ? getBundledResource(resourceName) : null;
    }

    @java.lang.Override
    public java.lang.String resolveBundleResourceName(java.lang.String requestedBundleName, java.lang.String mappingPrefix, java.util.List<java.lang.String> files) {
        org.springframework.web.servlet.resource.ResourceHttpRequestHandler resourceRequestHandler = findResourceHttpRequestHandler(requestedBundleName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4523, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4521, (resourceRequestHandler != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4522, org.apache.commons.collections4.CollectionUtils.isNotEmpty(files)))))) {
            org.springframework.web.servlet.resource.ResourceResolverChain resolverChain = new org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain(resourceRequestHandler.getResourceResolvers());
            java.util.List<org.springframework.core.io.Resource> locations = resourceRequestHandler.getLocations();
            java.lang.StringBuilder combinedPathString = new java.lang.StringBuilder();
            java.util.List<java.lang.String> filePaths = new java.util.ArrayList<>();
            for (java.lang.String file : files) {
                java.lang.String resourcePath = resolverChain.resolveUrlPath(file, locations);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4524, (resourcePath == null))) {
                    resourcePath = resolverChain.resolveUrlPath((mappingPrefix + file), locations);
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4525, (resourcePath != null))) {
                    filePaths.add(resourcePath);
                    combinedPathString.append(resourcePath);
                }else {
                    org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.LOG.warn(new java.lang.StringBuilder().append("Could not resolve resource path specified in bundle as [").append(file).append("] or as [").append((mappingPrefix + file)).append("]. Skipping file.").toString());
                }
            }
            int version = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4527, java.lang.Math.abs(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4526, combinedPathString.toString().hashCode())));
            java.lang.String versionedBundleName = mappingPrefix + (addVersion(requestedBundleName, ("-" + (java.lang.String.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4528, version))))));
            createBundleIfNeeded(versionedBundleName, filePaths, resolverChain, locations);
            return versionedBundleName;
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4529, org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.LOG.isWarnEnabled())) {
                org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.LOG.warn("");
            }
            return null;
        }
    }

    @java.lang.Override
    public org.springframework.core.io.Resource resolveBundleResource(java.lang.String versionedBundleResourceName) {
        return getBundledResource(lookupBundlePath(versionedBundleResourceName));
    }

    @java.lang.Override
    public boolean checkForRegisteredBundleFile(java.lang.String versionedBundleName) {
        versionedBundleName = lookupBundlePath(versionedBundleName);
        boolean bundleRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4530, createdBundles.containsKey(versionedBundleName));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4531, org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.LOG.isTraceEnabled())) {
            org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.LOG.trace((((("Checking for registered bundle file, versionedBundleName=\"" + versionedBundleName) + "\" bundleRegistered=\"") + bundleRegistered) + "\""));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4532, bundleRegistered);
    }

    protected org.springframework.core.io.Resource getBundledResource(java.lang.String versionedBundleName) {
        org.broadleafcommerce.common.resource.BundledResourceInfo bundledResourceInfo = createdBundles.get(versionedBundleName);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4533, (bundledResourceInfo != null)) ? bundledResourceInfo.getResource() : null;
    }

    protected java.lang.String lookupBundlePath(java.lang.String requestPath) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4534, requestPath.contains(".css"))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4536, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4535, requestPath.startsWith("/css/")))))) {
                requestPath = "/css/" + requestPath;
            }
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4537, requestPath.contains(".js"))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4539, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4538, requestPath.startsWith("/js/")))))) {
                    requestPath = "/js/" + requestPath;
                }
            }

        return requestPath;
    }

    protected void createBundleIfNeeded(final java.lang.String versionedBundleName, final java.util.List<java.lang.String> filePaths, final org.springframework.web.servlet.resource.ResourceResolverChain resolverChain, final java.util.List<org.springframework.core.io.Resource> locations) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4541, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4540, createdBundles.containsKey(versionedBundleName)))))) {
            keyLockManager.executeLocked(versionedBundleName, new de.jkeylockmanager.manager.LockCallback() {
                @java.lang.Override
                public void doInLock() {
                    org.springframework.core.io.Resource bundleResource = getBundledResource(versionedBundleName);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4545, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4542, (bundleResource == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4544, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4543, bundleResource.exists())))))))) {
                        bundleResource = createBundle(versionedBundleName, filePaths, resolverChain, locations);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4546, (bundleResource != null))) {
                            saveBundle(bundleResource);
                        }
                        org.springframework.core.io.Resource savedResource = readBundle(versionedBundleName);
                        org.broadleafcommerce.common.resource.BundledResourceInfo bundledResourceInfo = new org.broadleafcommerce.common.resource.BundledResourceInfo(savedResource, versionedBundleName, filePaths);
                        createdBundles.put(versionedBundleName, bundledResourceInfo);
                    }
                }
            });
        }
    }

    protected org.springframework.core.io.Resource createBundle(java.lang.String versionedBundleName, java.util.List<java.lang.String> filePaths, org.springframework.web.servlet.resource.ResourceResolverChain resolverChain, java.util.List<org.springframework.core.io.Resource> locations) {
        javax.servlet.http.HttpServletRequest req = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getRequest();
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            for (java.lang.String fileName : filePaths) {
                org.springframework.core.io.Resource r = resolverChain.resolveResource(req, fileName, locations);
                java.io.InputStream is = null;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4547, (r == null))) {
                    org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.LOG.warn(new java.lang.StringBuilder().append("Could not resolve resource specified in bundle as [").append(fileName).append("]. Turn on trace logging to determine resolution failure. Skipping file.").toString());
                }else {
                    try {
                        is = r.getInputStream();
                        org.springframework.util.StreamUtils.copy(is, baos);
                    } catch (java.io.IOException e) {
                        throw new java.lang.RuntimeException(e);
                    } finally {
                        org.apache.commons.io.IOUtils.closeQuietly(is);
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4548, versionedBundleName.endsWith(".js"))) {
                        baos.write(";".getBytes());
                    }
                    baos.write(java.lang.System.getProperty("line.separator").getBytes());
                }
            }
            bytes = baos.toByteArray();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(baos);
        }
        org.broadleafcommerce.common.resource.GeneratedResource r = new org.broadleafcommerce.common.resource.GeneratedResource(bytes, versionedBundleName);
        return r;
    }

    protected void saveBundle(org.springframework.core.io.Resource resource) {
        org.broadleafcommerce.common.file.domain.FileWorkArea tempWorkArea = fileService.initializeWorkArea();
        java.lang.String fileToSave = org.apache.commons.io.FilenameUtils.separatorsToSystem(getResourcePath(resource.getDescription()));
        java.lang.String tempFilename = org.apache.commons.io.FilenameUtils.concat(tempWorkArea.getFilePathLocation(), fileToSave);
        java.io.File tempFile = new java.io.File(tempFilename);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4550, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4549, tempFile.getParentFile().exists()))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4552, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4551, tempFile.getParentFile().mkdirs()))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4554, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4553, tempFile.getParentFile().exists()))))) {
                    throw new java.lang.RuntimeException(("Unable to create parent directories for file: " + tempFilename));
                }
            }
        }
        java.io.BufferedOutputStream out = null;
        java.io.InputStream ris = null;
        try {
            ris = resource.getInputStream();
            out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(tempFile));
            org.springframework.util.StreamUtils.copy(ris, out);
            ris.close();
            out.close();
            fileService.addOrUpdateResourceForPath(tempWorkArea, tempFile, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4555, true));
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(ris);
            org.apache.commons.io.IOUtils.closeQuietly(out);
            fileService.closeWorkArea(tempWorkArea);
        }
    }

    protected java.lang.String getCacheKey(java.lang.String unversionedBundleName, java.util.List<java.lang.String> files) {
        return unversionedBundleName;
    }

    protected java.lang.String getBundleName(java.lang.String bundleName, java.lang.String version) {
        java.lang.String bundleWithoutExtension = bundleName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4556, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4557, bundleName.lastIndexOf('.')));
        java.lang.String bundleExtension = bundleName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4558, bundleName.lastIndexOf('.')));
        java.lang.String versionedName = (bundleWithoutExtension + version) + bundleExtension;
        return versionedName;
    }

    protected java.lang.String getBundleVersion(java.util.LinkedHashMap<java.lang.String, org.springframework.core.io.Resource> foundResources) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, org.springframework.core.io.Resource> entry : foundResources.entrySet()) {
            sb.append(entry.getKey());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4559, ((entry.getValue()) instanceof org.broadleafcommerce.common.resource.GeneratedResource))) {
                sb.append(((org.broadleafcommerce.common.resource.GeneratedResource) (entry.getValue())).getHashRepresentation());
            }else {
                sb.append(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4560, entry.getValue().lastModified()));
            }
            sb.append("\r\n");
        }
        java.lang.String version = java.lang.String.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4561, sb.toString().hashCode()));
        return version;
    }

    @java.lang.Override
    public java.util.List<java.lang.String> getAdditionalBundleFiles(java.lang.String bundleName) {
        return additionalBundleFiles.get(bundleName);
    }

    public void setAdditionalBundleFiles(java.util.Map<java.lang.String, java.util.List<java.lang.String>> additionalBundleFiles) {
        this.additionalBundleFiles = additionalBundleFiles;
    }

    protected java.lang.String addVersion(java.lang.String requestPath, java.lang.String version) {
        java.lang.String baseFilename = org.springframework.util.StringUtils.stripFilenameExtension(requestPath);
        java.lang.String extension = org.springframework.util.StringUtils.getFilenameExtension(requestPath);
        return ((baseFilename + version) + ".") + extension;
    }

    protected org.springframework.core.io.Resource readBundle(java.lang.String versionedBundleName) {
        java.io.File bundleFile = fileService.getResource(("/" + (getResourcePath(versionedBundleName))));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4562, (bundleFile == null)) ? null : new org.springframework.core.io.FileSystemResource(bundleFile);
    }

    protected org.springframework.web.servlet.resource.ResourceHttpRequestHandler findResourceHttpRequestHandler(java.lang.String resourceName) {
        resourceName = resourceName.toLowerCase();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4563, isJavaScriptResource(resourceName))) {
            return jsResourceHandler;
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4564, isCSSResource(resourceName))) {
                return cssResourceHandler;
            }else {
                return null;
            }

    }

    protected boolean isJavaScriptResource(java.lang.String resourceName) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4567, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4565, (resourceName != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4566, resourceName.contains(".js")))));
    }

    protected boolean isCSSResource(java.lang.String resourceName) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4570, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4568, (resourceName != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4569, resourceName.contains(".css")))));
    }

    protected java.lang.String getResourcePath(java.lang.String name) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4571, name.startsWith("/"))) {
            return "bundles" + name;
        }else {
            return "bundles/" + name;
        }
    }

    public static perturbation.location.PerturbationLocation __L4516;

    public static perturbation.location.PerturbationLocation __L4517;

    public static perturbation.location.PerturbationLocation __L4518;

    public static perturbation.location.PerturbationLocation __L4519;

    public static perturbation.location.PerturbationLocation __L4520;

    public static perturbation.location.PerturbationLocation __L4521;

    public static perturbation.location.PerturbationLocation __L4522;

    public static perturbation.location.PerturbationLocation __L4523;

    public static perturbation.location.PerturbationLocation __L4524;

    public static perturbation.location.PerturbationLocation __L4525;

    public static perturbation.location.PerturbationLocation __L4526;

    public static perturbation.location.PerturbationLocation __L4527;

    public static perturbation.location.PerturbationLocation __L4528;

    public static perturbation.location.PerturbationLocation __L4529;

    public static perturbation.location.PerturbationLocation __L4530;

    public static perturbation.location.PerturbationLocation __L4531;

    public static perturbation.location.PerturbationLocation __L4532;

    public static perturbation.location.PerturbationLocation __L4533;

    public static perturbation.location.PerturbationLocation __L4534;

    public static perturbation.location.PerturbationLocation __L4535;

    public static perturbation.location.PerturbationLocation __L4536;

    public static perturbation.location.PerturbationLocation __L4537;

    public static perturbation.location.PerturbationLocation __L4538;

    public static perturbation.location.PerturbationLocation __L4539;

    public static perturbation.location.PerturbationLocation __L4540;

    public static perturbation.location.PerturbationLocation __L4541;

    public static perturbation.location.PerturbationLocation __L4542;

    public static perturbation.location.PerturbationLocation __L4543;

    public static perturbation.location.PerturbationLocation __L4544;

    public static perturbation.location.PerturbationLocation __L4545;

    public static perturbation.location.PerturbationLocation __L4546;

    public static perturbation.location.PerturbationLocation __L4547;

    public static perturbation.location.PerturbationLocation __L4548;

    public static perturbation.location.PerturbationLocation __L4549;

    public static perturbation.location.PerturbationLocation __L4550;

    public static perturbation.location.PerturbationLocation __L4551;

    public static perturbation.location.PerturbationLocation __L4552;

    public static perturbation.location.PerturbationLocation __L4553;

    public static perturbation.location.PerturbationLocation __L4554;

    public static perturbation.location.PerturbationLocation __L4555;

    public static perturbation.location.PerturbationLocation __L4556;

    public static perturbation.location.PerturbationLocation __L4557;

    public static perturbation.location.PerturbationLocation __L4558;

    public static perturbation.location.PerturbationLocation __L4559;

    public static perturbation.location.PerturbationLocation __L4560;

    public static perturbation.location.PerturbationLocation __L4561;

    public static perturbation.location.PerturbationLocation __L4562;

    public static perturbation.location.PerturbationLocation __L4563;

    public static perturbation.location.PerturbationLocation __L4564;

    public static perturbation.location.PerturbationLocation __L4565;

    public static perturbation.location.PerturbationLocation __L4566;

    public static perturbation.location.PerturbationLocation __L4567;

    public static perturbation.location.PerturbationLocation __L4568;

    public static perturbation.location.PerturbationLocation __L4569;

    public static perturbation.location.PerturbationLocation __L4570;

    public static perturbation.location.PerturbationLocation __L4571;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:116)", 4516, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:124)", 4517, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:137)", 4518, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:140)", 4519, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:147)", 4520, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:154)", 4521, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:154)", 4522, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:154)", 4523, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:163)", 4524, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:168)", 4525, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:181)", 4526, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:181)", 4527, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:182)", 4528, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:188)", 4529, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:203)", 4530, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:205)", 4531, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:208)", 4532, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:213)", 4533, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:217)", 4534, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:218)", 4535, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:218)", 4536, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:221)", 4537, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:222)", 4538, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:222)", 4539, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:231)", 4540, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:231)", 4541, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:237)", 4542, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:237)", 4543, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:237)", 4544, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:237)", 4545, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:239)", 4546, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:265)", 4547, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:282)", 4548, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:305)", 4549, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:305)", 4550, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:306)", 4551, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:306)", 4552, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:307)", 4553, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:307)", 4554, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:323)", 4555, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:338)", 4556, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:338)", 4557, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:339)", 4558, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:349)", 4559, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:352)", 4560, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:357)", 4561, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:384)", 4562, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:390)", 4563, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:392)", 4564, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:400)", 4565, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:400)", 4566, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:400)", 4567, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:404)", 4568, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:404)", 4569, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:404)", 4570, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.__L4571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceBundlingServiceImpl.java:413)", 4571, "Boolean");
    }

    static {
        org.broadleafcommerce.common.resource.service.ResourceBundlingServiceImpl.initPerturbationLocation0();
    }
}

