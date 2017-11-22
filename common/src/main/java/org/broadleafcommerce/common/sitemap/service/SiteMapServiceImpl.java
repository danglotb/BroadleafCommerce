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
package org.broadleafcommerce.common.sitemap.service;


@org.springframework.stereotype.Service("blSiteMapService")
public class SiteMapServiceImpl implements org.broadleafcommerce.common.sitemap.service.SiteMapService {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.class);

    protected static final java.lang.String ENCODING_EXTENSION = ".gz";

    protected java.lang.Boolean gzipSiteMapFiles;

    @javax.annotation.Resource(name = "blModuleConfigurationService")
    protected org.broadleafcommerce.common.config.service.ModuleConfigurationService moduleConfigurationService;

    @javax.annotation.Resource(name = "blSiteMapGenerators")
    protected java.util.List<org.broadleafcommerce.common.sitemap.service.SiteMapGenerator> siteMapGenerators = new java.util.ArrayList<org.broadleafcommerce.common.sitemap.service.SiteMapGenerator>();

    @javax.annotation.Resource(name = "blFileService")
    protected org.broadleafcommerce.common.file.service.BroadleafFileService broadleafFileService;

    @javax.annotation.Resource(name = "blBaseUrlResolver")
    protected org.broadleafcommerce.common.web.BaseUrlResolver baseUrlResolver;

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse generateSiteMap() throws java.io.IOException, org.broadleafcommerce.common.sitemap.exception.SiteMapException {
        org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse smgr = new org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse();
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration smc = findActiveSiteMapConfiguration();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5513, (smc == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5514, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isWarnEnabled())) {
                org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.warn("No SiteMap generated since no active configuration was found.");
            }
            smgr.setHasError(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5515, true));
            smgr.setErrorCode("No SiteMap Configuration Found");
            return smgr;
        }
        org.broadleafcommerce.common.file.domain.FileWorkArea fileWorkArea = broadleafFileService.initializeWorkArea();
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder siteMapBuilder = new org.broadleafcommerce.common.sitemap.service.SiteMapBuilder(smc, fileWorkArea, baseUrlResolver.getSiteBaseUrl(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5516, getGzipSiteMapFiles()));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5517, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
            org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace(("File work area initalized with path " + (fileWorkArea.getFilePathLocation())));
        }
        for (org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration currentConfiguration : smc.getSiteMapGeneratorConfigurations()) {
            if (currentConfiguration.isDisabled()) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5518, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace(("Skipping disabled sitemap generator configuration" + (currentConfiguration.getId())));
                }
                continue;
            }
            org.broadleafcommerce.common.sitemap.service.SiteMapGenerator generator = selectSiteMapGenerator(currentConfiguration);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5519, (generator != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5520, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace(("SiteMapGenerator found, adding entries" + (generator.getClass())));
                }
                generator.addSiteMapEntries(currentConfiguration, siteMapBuilder);
            }else {
                org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.warn(("No site map generator found to process generator configuration for " + (currentConfiguration.getSiteMapGeneratorType())));
            }
        }
        siteMapBuilder.persistSiteMap();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5521, getGzipSiteMapFiles())) {
            gzipAndDeleteFiles(fileWorkArea, siteMapBuilder.getIndexedFileNames(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5522, false));
            java.util.List<java.lang.String> indexFileNames = new java.util.ArrayList<java.lang.String>();
            for (java.lang.String fileName : siteMapBuilder.getIndexedFileNames()) {
                indexFileNames.add((fileName + (org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.ENCODING_EXTENSION)));
            }
            smgr.setSiteMapFilePaths(indexFileNames);
        }else {
            smgr.setSiteMapFilePaths(siteMapBuilder.getIndexedFileNames());
        }
        broadleafFileService.addOrUpdateResources(fileWorkArea, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5523, true));
        broadleafFileService.closeWorkArea(fileWorkArea);
        return smgr;
    }

    @java.lang.Override
    public java.io.File getSiteMapFile(java.lang.String fileName) throws java.io.IOException, org.broadleafcommerce.common.sitemap.exception.SiteMapException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5524, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
            org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace(("Method getSiteMapFile() invoked for " + fileName));
        }
        java.io.File siteMapFile = broadleafFileService.getResource(fileName, getSiteMapTimeoutInMillis());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5525, siteMapFile.exists())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5526, getAutoGenerateSiteMapAfterTimeout())) {
                long lastModified = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5527, siteMapFile.lastModified());
                long now = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5528, java.lang.System.currentTimeMillis());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5533, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5531, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5529, now)) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5530, lastModified))))) > (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5532, getSiteMapTimeoutInMillis().longValue()))))) {
                    generateSiteMap();
                    siteMapFile = broadleafFileService.getResource(fileName, getSiteMapTimeoutInMillis());
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5534, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace("Returning existing SiteMap");
            }
            return siteMapFile;
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5535, getCreateSiteMapIfNotFound())) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5536, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace("Generating SiteMap");
                }
                generateSiteMap();
                siteMapFile = broadleafFileService.getResource(fileName, getSiteMapTimeoutInMillis());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5537, siteMapFile.exists())) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5538, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
                        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace(("Returning SiteMap file " + fileName));
                    }
                }else {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5539, org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.isTraceEnabled())) {
                        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.trace((("Sitemap file " + fileName) + " not found after call to generate siteMap.xml"));
                    }
                }
                return siteMapFile;
            }else {
                return null;
            }
        }
    }

    protected org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration findActiveSiteMapConfiguration() {
        java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> configurations = moduleConfigurationService.findActiveConfigurationsByType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.SITE_MAP);
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration smc = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5543, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5540, (configurations != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5542, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5541, configurations.isEmpty())))))))) {
            for (org.broadleafcommerce.common.config.domain.ModuleConfiguration configuration : configurations) {
                if (configuration.getIsDefault()) {
                    smc = ((org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration) (configuration));
                    break;
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5544, (smc == null))) {
                smc = ((org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration) (configurations.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5545, 0))));
            }
        }
        return smc;
    }

    protected org.broadleafcommerce.common.sitemap.service.SiteMapGenerator selectSiteMapGenerator(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration smgc) {
        for (org.broadleafcommerce.common.sitemap.service.SiteMapGenerator siteMapGenerator : siteMapGenerators) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5546, siteMapGenerator.canHandleSiteMapConfiguration(smgc))) {
                return siteMapGenerator;
            }
        }
        return null;
    }

    protected void gzipAndDeleteFiles(org.broadleafcommerce.common.file.domain.FileWorkArea fileWorkArea, java.util.List<java.lang.String> fileNames, boolean shouldDeleteOriginal) {
        for (java.lang.String fileName : fileNames) {
            try {
                java.lang.String fileNameWithPath = org.apache.commons.io.FilenameUtils.normalize((((fileWorkArea.getFilePathLocation()) + (java.io.File.separator)) + fileName));
                java.io.FileInputStream fis = new java.io.FileInputStream(fileNameWithPath);
                java.io.FileOutputStream fos = new java.io.FileOutputStream((fileNameWithPath + (org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.ENCODING_EXTENSION)));
                java.util.zip.GZIPOutputStream gzipOS = new java.util.zip.GZIPOutputStream(fos);
                byte[] buffer = new byte[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5547, 1024)];
                int len;
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5551, ((len = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5548, fis.read(buffer))) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5550, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5549, 1)))))))) {
                    gzipOS.write(buffer, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5552, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5553, len));
                } 
                gzipOS.close();
                fos.close();
                fis.close();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5554, shouldDeleteOriginal)) {
                    java.io.File originalFile = new java.io.File(fileNameWithPath);
                    originalFile.delete();
                }
            } catch (java.io.IOException e) {
                org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.LOG.error("Error writing zip file.", e);
            }
        }
    }

    protected void gzipAndDeleteFiles(org.broadleafcommerce.common.file.domain.FileWorkArea fileWorkArea, java.util.List<java.lang.String> fileNames) {
        gzipAndDeleteFiles(fileWorkArea, fileNames, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5555, true));
    }

    public java.util.List<org.broadleafcommerce.common.sitemap.service.SiteMapGenerator> getSiteMapGenerators() {
        return siteMapGenerators;
    }

    public void setSiteMapGenerators(java.util.List<org.broadleafcommerce.common.sitemap.service.SiteMapGenerator> siteMapGenerators) {
        this.siteMapGenerators = siteMapGenerators;
    }

    public org.broadleafcommerce.common.config.service.ModuleConfigurationService getModuleConfigurationService() {
        return moduleConfigurationService;
    }

    public void setModuleConfigurationService(org.broadleafcommerce.common.config.service.ModuleConfigurationService moduleConfigurationService) {
        this.moduleConfigurationService = moduleConfigurationService;
    }

    protected boolean getGzipSiteMapFilesDefault() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5556, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("sitemap.gzip.files"));
    }

    public boolean getCreateSiteMapIfNotFound() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5557, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("sitemap.createIfNotFound"));
    }

    public boolean getAutoGenerateSiteMapAfterTimeout() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5559, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("sitemap.createIfTimeoutExpired", perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5558, false)));
    }

    public java.lang.Long getSiteMapTimeoutInMillis() {
        java.lang.Long cacheSeconds = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5560, ((long) (org.broadleafcommerce.common.util.BLCSystemProperty.resolveLongSystemProperty("sitemap.cache.seconds"))));
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5561, (cacheSeconds * 1000));
    }

    public void setGzipSiteMapFiles(java.lang.Boolean gzipSiteMapFiles) {
        this.gzipSiteMapFiles = gzipSiteMapFiles;
    }

    public boolean getGzipSiteMapFiles() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5562, ((this.gzipSiteMapFiles) != null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5563, this.gzipSiteMapFiles.booleanValue());
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5564, getGzipSiteMapFilesDefault());
        }
    }

    public static perturbation.location.PerturbationLocation __L5513;

    public static perturbation.location.PerturbationLocation __L5514;

    public static perturbation.location.PerturbationLocation __L5515;

    public static perturbation.location.PerturbationLocation __L5516;

    public static perturbation.location.PerturbationLocation __L5517;

    public static perturbation.location.PerturbationLocation __L5518;

    public static perturbation.location.PerturbationLocation __L5519;

    public static perturbation.location.PerturbationLocation __L5520;

    public static perturbation.location.PerturbationLocation __L5521;

    public static perturbation.location.PerturbationLocation __L5522;

    public static perturbation.location.PerturbationLocation __L5523;

    public static perturbation.location.PerturbationLocation __L5524;

    public static perturbation.location.PerturbationLocation __L5525;

    public static perturbation.location.PerturbationLocation __L5526;

    public static perturbation.location.PerturbationLocation __L5527;

    public static perturbation.location.PerturbationLocation __L5528;

    public static perturbation.location.PerturbationLocation __L5529;

    public static perturbation.location.PerturbationLocation __L5530;

    public static perturbation.location.PerturbationLocation __L5531;

    public static perturbation.location.PerturbationLocation __L5532;

    public static perturbation.location.PerturbationLocation __L5533;

    public static perturbation.location.PerturbationLocation __L5534;

    public static perturbation.location.PerturbationLocation __L5535;

    public static perturbation.location.PerturbationLocation __L5536;

    public static perturbation.location.PerturbationLocation __L5537;

    public static perturbation.location.PerturbationLocation __L5538;

    public static perturbation.location.PerturbationLocation __L5539;

    public static perturbation.location.PerturbationLocation __L5540;

    public static perturbation.location.PerturbationLocation __L5541;

    public static perturbation.location.PerturbationLocation __L5542;

    public static perturbation.location.PerturbationLocation __L5543;

    public static perturbation.location.PerturbationLocation __L5544;

    public static perturbation.location.PerturbationLocation __L5545;

    public static perturbation.location.PerturbationLocation __L5546;

    public static perturbation.location.PerturbationLocation __L5547;

    public static perturbation.location.PerturbationLocation __L5548;

    public static perturbation.location.PerturbationLocation __L5549;

    public static perturbation.location.PerturbationLocation __L5550;

    public static perturbation.location.PerturbationLocation __L5551;

    public static perturbation.location.PerturbationLocation __L5552;

    public static perturbation.location.PerturbationLocation __L5553;

    public static perturbation.location.PerturbationLocation __L5554;

    public static perturbation.location.PerturbationLocation __L5555;

    public static perturbation.location.PerturbationLocation __L5556;

    public static perturbation.location.PerturbationLocation __L5557;

    public static perturbation.location.PerturbationLocation __L5558;

    public static perturbation.location.PerturbationLocation __L5559;

    public static perturbation.location.PerturbationLocation __L5560;

    public static perturbation.location.PerturbationLocation __L5561;

    public static perturbation.location.PerturbationLocation __L5562;

    public static perturbation.location.PerturbationLocation __L5563;

    public static perturbation.location.PerturbationLocation __L5564;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:80)", 5513, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:81)", 5514, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:84)", 5515, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:90)", 5516, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:92)", 5517, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:97)", 5518, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:103)", 5519, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:104)", 5520, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:117)", 5521, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:118)", 5522, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:130)", 5523, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:138)", 5524, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:142)", 5525, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:144)", 5526, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:145)", 5527, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:146)", 5528, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:148)", 5529, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:148)", 5530, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:148)", 5531, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:148)", 5532, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:148)", 5533, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:153)", 5534, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:159)", 5535, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:160)", 5536, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:165)", 5537, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:166)", 5538, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:170)", 5539, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:185)", 5540, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:185)", 5541, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:185)", 5542, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:185)", 5543, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:193)", 5544, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:195)", 5545, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:210)", 5546, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:230)", 5547, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:232)", 5548, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:232)", 5549, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:232)", 5550, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:232)", 5551, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:233)", 5552, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:233)", 5553, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:240)", 5554, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:258)", 5555, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:279)", 5556, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:283)", 5557, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:287)", 5558, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:287)", 5559, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:291)", 5560, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:292)", 5561, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:301)", 5562, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:302)", 5563, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.__L5564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapServiceImpl.java:304)", 5564, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.SiteMapServiceImpl.initPerturbationLocation0();
    }
}

