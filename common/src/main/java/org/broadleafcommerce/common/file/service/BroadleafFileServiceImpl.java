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
package org.broadleafcommerce.common.file.service;


@org.springframework.stereotype.Service("blFileService")
public class BroadleafFileServiceImpl implements org.broadleafcommerce.common.file.service.BroadleafFileService {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.class);

    @javax.annotation.Resource(name = "blFileServiceProviders")
    protected java.util.List<org.broadleafcommerce.common.file.service.FileServiceProvider> fileServiceProviders = new java.util.ArrayList<org.broadleafcommerce.common.file.service.FileServiceProvider>();

    @javax.annotation.Resource(name = "blDefaultFileServiceProvider")
    protected org.broadleafcommerce.common.file.service.FileServiceProvider defaultFileServiceProvider;

    private static final java.lang.String DEFAULT_STORAGE_DIRECTORY = java.lang.System.getProperty("java.io.tmpdir");

    @org.springframework.beans.factory.annotation.Value("${file.service.temp.file.base.directory}")
    protected java.lang.String tempFileSystemBaseDirectory;

    @org.springframework.beans.factory.annotation.Value("${asset.server.max.generated.file.system.directories}")
    protected int maxGeneratedDirectoryDepth = 2;

    @org.springframework.beans.factory.annotation.Value("${asset.server.file.classpath.directory}")
    protected java.lang.String fileServiceClasspathDirectory;

    @javax.annotation.Resource(name = "blBroadleafFileServiceExtensionManager")
    protected org.broadleafcommerce.common.file.service.BroadleafFileServiceExtensionManager extensionManager;

    @java.lang.Override
    public org.broadleafcommerce.common.file.domain.FileWorkArea initializeWorkArea() {
        java.lang.String baseDirectory = getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2526, false));
        java.lang.String tempDirectory = getTempDirectory(baseDirectory);
        org.broadleafcommerce.common.file.domain.FileWorkArea fw = new org.broadleafcommerce.common.file.domain.FileWorkArea();
        fw.setFilePathLocation(tempDirectory);
        java.io.File tmpDir = new java.io.File(tempDirectory);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2528, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2527, tmpDir.exists()))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2529, org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.LOG.trace(("Creating temp directory named " + tempDirectory));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2531, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2530, tmpDir.mkdirs()))))) {
                throw new org.broadleafcommerce.common.file.FileServiceException(("Unable to create temporary working directory for " + tempDirectory));
            }
        }
        return fw;
    }

    @java.lang.Override
    public void closeWorkArea(org.broadleafcommerce.common.file.domain.FileWorkArea fwArea) {
        java.io.File tempDirectory = new java.io.File(fwArea.getFilePathLocation());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2532, tempDirectory.exists())) {
            org.apache.commons.io.FileUtils.deleteQuietly(tempDirectory);
        }
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2533, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2536, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2534, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2535, maxGeneratedDirectoryDepth)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2537, (i++))) {
            tempDirectory = tempDirectory.getParentFile();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2539, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2538, tempDirectory.delete()))))) {
                break;
            }
        }
    }

    @java.lang.Override
    public java.io.File getResource(java.lang.String name) {
        return selectFileServiceProvider().getResource(name);
    }

    protected java.io.File getLocalResource(java.lang.String resourceName, boolean skipSite) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2540, skipSite)) {
            java.lang.String baseDirectory = getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2541, skipSite));
            java.lang.String systemResourcePath = org.apache.commons.io.FilenameUtils.separatorsToSystem(resourceName);
            java.lang.String filePath = org.apache.commons.io.FilenameUtils.normalize(((baseDirectory + (java.io.File.separator)) + systemResourcePath));
            return new java.io.File(filePath);
        }else {
            java.lang.String baseDirectory = getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2542, true));
            org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> holder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String>();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2543, ((extensionManager) != null))) {
                org.broadleafcommerce.common.extension.ExtensionResultStatusType result = extensionManager.getProxy().processPathForSite(baseDirectory, resourceName, holder);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2545, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2544, org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED.equals(result)))))) {
                    return new java.io.File(holder.getResult());
                }
            }
            return getLocalResource(resourceName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2546, true));
        }
    }

    @java.lang.Override
    public java.io.File getLocalResource(java.lang.String resourceName) {
        return getLocalResource(resourceName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2547, false));
    }

    @java.lang.Override
    public java.io.File getSharedLocalResource(java.lang.String resourceName) {
        return getLocalResource(resourceName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2548, true));
    }

    @java.lang.Override
    public java.io.File getResource(java.lang.String name, java.lang.Long localTimeout) {
        java.io.File returnFile = getLocalResource(name);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2551, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2549, (returnFile != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2550, returnFile.exists()))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2552, (localTimeout != null))) {
                long lastModified = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2553, returnFile.lastModified());
                long now = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2554, java.lang.System.currentTimeMillis());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2559, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2557, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2555, now)) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2556, lastModified))))) <= (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2558, localTimeout.longValue()))))) {
                    return returnFile;
                }
            }else {
                return returnFile;
            }
        }
        return getResource(name);
    }

    @java.lang.Override
    public boolean checkForResourceOnClassPath(java.lang.String name) {
        org.springframework.core.io.ClassPathResource resource = lookupResourceOnClassPath(name);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2562, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2560, (resource != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2561, resource.exists()))));
    }

    protected org.springframework.core.io.ClassPathResource lookupResourceOnClassPath(java.lang.String name) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2566, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2563, ((fileServiceClasspathDirectory) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2565, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2564, "".equals(fileServiceClasspathDirectory))))))))) {
            try {
                java.lang.String resourceName = org.apache.commons.io.FilenameUtils.separatorsToUnix(org.apache.commons.io.FilenameUtils.normalize((((fileServiceClasspathDirectory) + '/') + name)));
                org.springframework.core.io.ClassPathResource resource = new org.springframework.core.io.ClassPathResource(resourceName);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2567, resource.exists())) {
                    return resource;
                }
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.LOG.error("Error getting resource from classpath", e);
            }
        }
        return null;
    }

    @java.lang.Override
    public java.io.InputStream getClasspathResource(java.lang.String name) {
        try {
            org.springframework.core.io.ClassPathResource resource = lookupResourceOnClassPath(name);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2570, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2568, (resource != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2569, resource.exists()))))) {
                java.io.InputStream assetFile = resource.getInputStream();
                java.io.BufferedInputStream bufferedStream = new java.io.BufferedInputStream(assetFile);
                org.broadleafcommerce.common.file.service.GloballySharedInputStream globallySharedStream = new org.broadleafcommerce.common.file.service.GloballySharedInputStream(bufferedStream);
                globallySharedStream.mark(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2571, 0));
                return globallySharedStream;
            }else {
                return null;
            }
        } catch (java.lang.Exception e) {
            org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.LOG.error("Error getting resource from classpath", e);
        }
        return null;
    }

    @java.lang.Override
    public boolean removeResource(final java.lang.String resourceName) {
        boolean response = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2572, selectFileServiceProvider().removeResource(resourceName));
        java.lang.String baseDirectory = getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2573, true));
        removeLocalCacheFiles(resourceName, baseDirectory);
        baseDirectory = getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2574, false));
        removeLocalCacheFiles(resourceName, baseDirectory);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2575, response);
    }

    @java.lang.Override
    public void addOrUpdateResource(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.io.File file, boolean removeFilesFromWorkArea) {
        addOrUpdateResourcesForPaths(workArea, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2576, removeFilesFromWorkArea));
    }

    @java.lang.Override
    public java.lang.String addOrUpdateResourceForPath(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.io.File file, boolean removeFilesFromWorkArea) {
        java.util.List<java.io.File> files = new java.util.ArrayList<java.io.File>();
        files.add(file);
        return addOrUpdateResourcesForPaths(workArea, files, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2577, removeFilesFromWorkArea)).get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2578, 0));
    }

    @java.lang.Override
    public void addOrUpdateResources(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, boolean removeFilesFromWorkArea) {
        addOrUpdateResourcesForPaths(workArea, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2579, removeFilesFromWorkArea));
    }

    @java.lang.Override
    public java.util.List<java.lang.String> addOrUpdateResourcesForPaths(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, boolean removeFilesFromWorkArea) {
        java.io.File folder = new java.io.File(workArea.getFilePathLocation());
        java.util.List<java.io.File> fileList = new java.util.ArrayList<java.io.File>();
        buildFileList(folder, fileList);
        return addOrUpdateResourcesForPaths(workArea, fileList, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2580, removeFilesFromWorkArea));
    }

    @java.lang.Override
    public void addOrUpdateResources(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> files, boolean removeFilesFromWorkArea) {
        addOrUpdateResourcesForPaths(workArea, files, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2581, removeFilesFromWorkArea));
    }

    @java.lang.Override
    public java.util.List<java.lang.String> addOrUpdateResourcesForPaths(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> files, boolean removeFilesFromWorkArea) {
        checkFiles(workArea, files);
        return selectFileServiceProvider().addOrUpdateResourcesForPaths(workArea, files, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2582, removeFilesFromWorkArea));
    }

    protected void removeLocalCacheFiles(final java.lang.String resourceName, java.lang.String baseDirectory) {
        java.lang.String systemResourcePath = org.apache.commons.io.FilenameUtils.separatorsToSystem(resourceName);
        java.lang.String filePath = org.apache.commons.io.FilenameUtils.normalize(((baseDirectory + (java.io.File.separator)) + systemResourcePath));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2583, filePath.contains("."))) {
            filePath = filePath.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2584, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2585, filePath.lastIndexOf(".")));
        }
        filePath += "---";
        final java.lang.String checkPath = filePath;
        java.io.File dir = new java.io.File(baseDirectory);
        java.io.File[] children = dir.listFiles(new java.io.FileFilter() {
            @java.lang.Override
            public boolean accept(java.io.File pathname) {
                java.lang.String name = pathname.getAbsolutePath();
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2586, name.startsWith(checkPath));
            }
        });
        for (java.io.File cache : children) {
            org.apache.commons.io.FileUtils.deleteQuietly(cache);
        }
    }

    protected org.broadleafcommerce.common.file.service.FileServiceProvider selectFileServiceProvider() {
        return defaultFileServiceProvider;
    }

    protected void checkFiles(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> fileList) {
        for (java.io.File file : fileList) {
            java.lang.String fileName = file.getAbsolutePath();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2588, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2587, fileName.startsWith(workArea.getFilePathLocation())))))) {
                throw new org.broadleafcommerce.common.file.FileServiceException(((("File operation attempted on file that is not in provided work area. " + fileName) + ".  Work area = ") + (workArea.getFilePathLocation())));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2590, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2589, file.exists()))))) {
                throw new org.broadleafcommerce.common.file.FileServiceException(("Add or Update Resource called with filename that does not exist.  " + fileName));
            }
        }
    }

    protected java.lang.String getBaseDirectory(boolean skipSite) {
        java.lang.String path = "";
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2591, org.apache.commons.lang3.StringUtils.isBlank(tempFileSystemBaseDirectory))) {
            path = org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.DEFAULT_STORAGE_DIRECTORY;
        }else {
            path = tempFileSystemBaseDirectory;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2593, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2592, skipSite))))) {
            org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2596, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2594, (brc != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2595, ((brc.getSite()) != null)))))) {
                java.lang.String siteDirectory = "site-" + (brc.getSite().getId());
                java.lang.String siteHash = org.apache.commons.codec.digest.DigestUtils.md5Hex(siteDirectory);
                path = org.apache.commons.io.FilenameUtils.concat(path, siteHash.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2597, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2598, 2)));
                path = org.apache.commons.io.FilenameUtils.concat(path, siteDirectory);
            }
        }
        return path;
    }

    protected java.lang.String getTempDirectory(java.lang.String baseDirectory) {
        assert perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2599, (baseDirectory != null));
        java.util.Random random = new java.util.Random();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2600, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2603, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2601, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2602, maxGeneratedDirectoryDepth)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2604, (i++))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2607, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2605, i)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2606, 4))))) {
                org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.LOG.warn((("Property asset.server.max.generated.file.system.directories set to high, currently set to " + (maxGeneratedDirectoryDepth)) + " ignoring and only creating 4 levels."));
                break;
            }
            int num = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2609, random.nextInt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2608, 256)));
            baseDirectory = org.apache.commons.io.FilenameUtils.concat(baseDirectory, java.lang.Integer.toHexString(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2610, num)));
        }
        return org.apache.commons.io.FilenameUtils.concat(baseDirectory, buildThreadIdString());
    }

    protected java.lang.String buildThreadIdString() {
        return java.lang.Long.toHexString(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2611, java.lang.Thread.currentThread().getId()));
    }

    protected void buildFileList(java.io.File file, java.util.Collection<java.io.File> fileList) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2612, file.isDirectory())) {
            java.io.File[] children = file.listFiles();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2613, (children != null))) {
                for (java.io.File child : children) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2614, child.isDirectory())) {
                        buildFileList(child, fileList);
                    }else {
                        fileList.add(child);
                    }
                }
            }
        }else {
            fileList.add(file);
        }
    }

    public java.lang.String getTempFileSystemBaseDirectory() {
        return tempFileSystemBaseDirectory;
    }

    public void setTempFileSystemBaseDirectory(java.lang.String tempFileSystemBaseDirectory) {
        this.tempFileSystemBaseDirectory = tempFileSystemBaseDirectory;
    }

    public java.util.List<org.broadleafcommerce.common.file.service.FileServiceProvider> getFileServiceProviders() {
        return fileServiceProviders;
    }

    public void setFileServiceProviders(java.util.List<org.broadleafcommerce.common.file.service.FileServiceProvider> fileServiceProviders) {
        this.fileServiceProviders = fileServiceProviders;
    }

    public int getMaxGeneratedDirectoryDepth() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2615, maxGeneratedDirectoryDepth);
    }

    public void setMaxGeneratedDirectoryDepth(int maxGeneratedDirectoryDepth) {
        this.maxGeneratedDirectoryDepth = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2616, maxGeneratedDirectoryDepth);
    }

    public org.broadleafcommerce.common.file.service.FileServiceProvider getDefaultFileServiceProvider() {
        return defaultFileServiceProvider;
    }

    public void setDefaultFileServiceProvider(org.broadleafcommerce.common.file.service.FileServiceProvider defaultFileServiceProvider) {
        this.defaultFileServiceProvider = defaultFileServiceProvider;
    }

    public static perturbation.location.PerturbationLocation __L2526;

    public static perturbation.location.PerturbationLocation __L2527;

    public static perturbation.location.PerturbationLocation __L2528;

    public static perturbation.location.PerturbationLocation __L2529;

    public static perturbation.location.PerturbationLocation __L2530;

    public static perturbation.location.PerturbationLocation __L2531;

    public static perturbation.location.PerturbationLocation __L2532;

    public static perturbation.location.PerturbationLocation __L2533;

    public static perturbation.location.PerturbationLocation __L2534;

    public static perturbation.location.PerturbationLocation __L2535;

    public static perturbation.location.PerturbationLocation __L2536;

    public static perturbation.location.PerturbationLocation __L2537;

    public static perturbation.location.PerturbationLocation __L2538;

    public static perturbation.location.PerturbationLocation __L2539;

    public static perturbation.location.PerturbationLocation __L2540;

    public static perturbation.location.PerturbationLocation __L2541;

    public static perturbation.location.PerturbationLocation __L2542;

    public static perturbation.location.PerturbationLocation __L2543;

    public static perturbation.location.PerturbationLocation __L2544;

    public static perturbation.location.PerturbationLocation __L2545;

    public static perturbation.location.PerturbationLocation __L2546;

    public static perturbation.location.PerturbationLocation __L2547;

    public static perturbation.location.PerturbationLocation __L2548;

    public static perturbation.location.PerturbationLocation __L2549;

    public static perturbation.location.PerturbationLocation __L2550;

    public static perturbation.location.PerturbationLocation __L2551;

    public static perturbation.location.PerturbationLocation __L2552;

    public static perturbation.location.PerturbationLocation __L2553;

    public static perturbation.location.PerturbationLocation __L2554;

    public static perturbation.location.PerturbationLocation __L2555;

    public static perturbation.location.PerturbationLocation __L2556;

    public static perturbation.location.PerturbationLocation __L2557;

    public static perturbation.location.PerturbationLocation __L2558;

    public static perturbation.location.PerturbationLocation __L2559;

    public static perturbation.location.PerturbationLocation __L2560;

    public static perturbation.location.PerturbationLocation __L2561;

    public static perturbation.location.PerturbationLocation __L2562;

    public static perturbation.location.PerturbationLocation __L2563;

    public static perturbation.location.PerturbationLocation __L2564;

    public static perturbation.location.PerturbationLocation __L2565;

    public static perturbation.location.PerturbationLocation __L2566;

    public static perturbation.location.PerturbationLocation __L2567;

    public static perturbation.location.PerturbationLocation __L2568;

    public static perturbation.location.PerturbationLocation __L2569;

    public static perturbation.location.PerturbationLocation __L2570;

    public static perturbation.location.PerturbationLocation __L2571;

    public static perturbation.location.PerturbationLocation __L2572;

    public static perturbation.location.PerturbationLocation __L2573;

    public static perturbation.location.PerturbationLocation __L2574;

    public static perturbation.location.PerturbationLocation __L2575;

    public static perturbation.location.PerturbationLocation __L2576;

    public static perturbation.location.PerturbationLocation __L2577;

    public static perturbation.location.PerturbationLocation __L2578;

    public static perturbation.location.PerturbationLocation __L2579;

    public static perturbation.location.PerturbationLocation __L2580;

    public static perturbation.location.PerturbationLocation __L2581;

    public static perturbation.location.PerturbationLocation __L2582;

    public static perturbation.location.PerturbationLocation __L2583;

    public static perturbation.location.PerturbationLocation __L2584;

    public static perturbation.location.PerturbationLocation __L2585;

    public static perturbation.location.PerturbationLocation __L2586;

    public static perturbation.location.PerturbationLocation __L2587;

    public static perturbation.location.PerturbationLocation __L2588;

    public static perturbation.location.PerturbationLocation __L2589;

    public static perturbation.location.PerturbationLocation __L2590;

    public static perturbation.location.PerturbationLocation __L2591;

    public static perturbation.location.PerturbationLocation __L2592;

    public static perturbation.location.PerturbationLocation __L2593;

    public static perturbation.location.PerturbationLocation __L2594;

    public static perturbation.location.PerturbationLocation __L2595;

    public static perturbation.location.PerturbationLocation __L2596;

    public static perturbation.location.PerturbationLocation __L2597;

    public static perturbation.location.PerturbationLocation __L2598;

    public static perturbation.location.PerturbationLocation __L2599;

    public static perturbation.location.PerturbationLocation __L2600;

    public static perturbation.location.PerturbationLocation __L2601;

    public static perturbation.location.PerturbationLocation __L2602;

    public static perturbation.location.PerturbationLocation __L2603;

    public static perturbation.location.PerturbationLocation __L2604;

    public static perturbation.location.PerturbationLocation __L2605;

    public static perturbation.location.PerturbationLocation __L2606;

    public static perturbation.location.PerturbationLocation __L2607;

    public static perturbation.location.PerturbationLocation __L2608;

    public static perturbation.location.PerturbationLocation __L2609;

    public static perturbation.location.PerturbationLocation __L2610;

    public static perturbation.location.PerturbationLocation __L2611;

    public static perturbation.location.PerturbationLocation __L2612;

    public static perturbation.location.PerturbationLocation __L2613;

    public static perturbation.location.PerturbationLocation __L2614;

    public static perturbation.location.PerturbationLocation __L2615;

    public static perturbation.location.PerturbationLocation __L2616;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:98)", 2526, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:105)", 2527, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:105)", 2528, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:106)", 2529, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:109)", 2530, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:109)", 2531, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:125)", 2532, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:129)", 2533, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:129)", 2534, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:129)", 2535, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:129)", 2536, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:129)", 2537, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:131)", 2538, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:131)", 2539, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:143)", 2540, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:144)", 2541, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:150)", 2542, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:152)", 2543, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:154)", 2544, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:154)", 2545, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:158)", 2546, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:164)", 2547, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:169)", 2548, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:175)", 2549, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:175)", 2550, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:175)", 2551, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:176)", 2552, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:177)", 2553, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:178)", 2554, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:179)", 2555, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:179)", 2556, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:179)", 2557, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:179)", 2558, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:179)", 2559, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:193)", 2560, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:193)", 2561, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:193)", 2562, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:197)", 2563, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:197)", 2564, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:197)", 2565, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:197)", 2566, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:201)", 2567, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:215)", 2568, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:215)", 2569, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:215)", 2570, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:224)", 2571, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:240)", 2572, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:244)", 2573, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:247)", 2574, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:249)", 2575, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:257)", 2576, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:268)", 2577, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:268)", 2578, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:276)", 2579, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:284)", 2580, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:289)", 2581, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:295)", 2582, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:301)", 2583, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:302)", 2584, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:302)", 2585, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:311)", 2586, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:334)", 2587, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:334)", 2588, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:338)", 2589, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:338)", 2590, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:351)", 2591, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:357)", 2592, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:357)", 2593, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:360)", 2594, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:360)", 2595, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:360)", 2596, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:363)", 2597, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:363)", 2598, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:376)", 2599, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:381)", 2600, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:381)", 2601, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:381)", 2602, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:381)", 2603, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:381)", 2604, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:382)", 2605, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:382)", 2606, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:382)", 2607, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:388)", 2608, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:388)", 2609, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:389)", 2610, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:396)", 2611, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:406)", 2612, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:408)", 2613, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:410)", 2614, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:439)", 2615, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.__L2616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileServiceImpl.java:443)", 2616, "Numerical");
    }

    static {
        org.broadleafcommerce.common.file.service.BroadleafFileServiceImpl.initPerturbationLocation0();
    }
}

