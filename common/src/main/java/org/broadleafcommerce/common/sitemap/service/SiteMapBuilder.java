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


public class SiteMapBuilder {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.class);

    protected org.broadleafcommerce.common.file.domain.FileWorkArea fileWorkArea;

    protected org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration siteMapConfig;

    protected org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLSetWrapper currentURLSetWrapper;

    protected java.util.List<java.lang.String> indexedFileNames = new java.util.ArrayList<java.lang.String>();

    protected java.lang.String baseUrl;

    protected boolean gzipSiteMapFiles = true;

    public SiteMapBuilder(org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration siteMapConfig, org.broadleafcommerce.common.file.domain.FileWorkArea fileWorkArea, java.lang.String baseUrl, boolean gzipSiteMapFiles) {
        this.fileWorkArea = fileWorkArea;
        this.siteMapConfig = siteMapConfig;
        this.currentURLSetWrapper = new org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLSetWrapper();
        this.baseUrl = baseUrl;
        this.gzipSiteMapFiles = gzipSiteMapFiles;
    }

    public void addUrl(org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper urlWrapper) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5496, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5494, currentURLSetWrapper.getSiteMapUrlWrappers().size())) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5495, siteMapConfig.getMaximumUrlEntriesPerFile()))))) {
            persistIndexedURLSetWrapper(currentURLSetWrapper);
            currentURLSetWrapper = new org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLSetWrapper();
        }
        currentURLSetWrapper.getSiteMapUrlWrappers().add(urlWrapper);
    }

    protected void persistXMLDocument(java.lang.String fileName, java.lang.Object xmlObject) {
        try {
            javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(xmlObject.getClass());
            javax.xml.bind.Marshaller m = context.createMarshaller();
            m.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5497, true));
            m.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5498, true));
            java.io.File file = new java.io.File(((fileWorkArea.getFilePathLocation()) + fileName));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5499, org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.LOG.trace(("Persisting SiteMap document " + (file.getAbsolutePath())));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5501, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5500, file.exists()))))) {
                file.createNewFile();
            }
            java.io.Writer writer = new java.io.BufferedWriter(new java.io.FileWriter(file.getAbsoluteFile()));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            m.marshal(xmlObject, writer);
            writer.close();
        } catch (java.io.IOException ioe) {
            org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.LOG.error("IOException occurred persisting XML Document", ioe);
            throw new java.lang.RuntimeException("Error persisting XML document when trying to build Sitemap", ioe);
        } catch (javax.xml.bind.JAXBException je) {
            org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.LOG.error("JAXBException occurred persisting XML Document", je);
            throw new java.lang.RuntimeException("Error persisting XML document when trying to build Sitemap", je);
        }
    }

    protected void persistIndexedURLSetWrapper(org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLSetWrapper urlSetWrapper) {
        java.lang.String indexedFileName = createNextIndexedFileName();
        indexedFileNames.add(indexedFileName);
        persistXMLDocument(indexedFileName, urlSetWrapper);
    }

    protected void persistNonIndexedSiteMap() {
        indexedFileNames.add(siteMapConfig.getSiteMapFileName());
        persistXMLDocument(siteMapConfig.getSiteMapFileName(), currentURLSetWrapper);
    }

    protected void persistIndexedSiteMap() {
        java.lang.String now = org.broadleafcommerce.common.util.FormatUtil.formatDateUsingW3C(new java.util.Date());
        persistIndexedURLSetWrapper(currentURLSetWrapper);
        org.broadleafcommerce.common.sitemap.wrapper.SiteMapIndexWrapper siteMapIndexWrapper = new org.broadleafcommerce.common.sitemap.wrapper.SiteMapIndexWrapper();
        for (java.lang.String fileName : indexedFileNames) {
            org.broadleafcommerce.common.sitemap.wrapper.SiteMapWrapper siteMapWrapper = new org.broadleafcommerce.common.sitemap.wrapper.SiteMapWrapper();
            java.lang.String fileLoc = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5502, gzipSiteMapFiles)) {
                fileLoc = org.broadleafcommerce.common.file.service.BroadleafFileUtils.appendUnixPaths(baseUrl, (fileName + ".gz"));
            }else {
                fileLoc = org.broadleafcommerce.common.file.service.BroadleafFileUtils.appendUnixPaths(baseUrl, fileName);
            }
            siteMapWrapper.setLoc(fileLoc);
            siteMapWrapper.setLastmod(now);
            siteMapIndexWrapper.getSiteMapWrappers().add(siteMapWrapper);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5503, org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.LOG.isTraceEnabled())) {
            org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.LOG.trace("Persisting sitemap.xml file for indexed site map ");
        }
        indexedFileNames.add(siteMapConfig.getIndexedSiteMapFileName());
        persistXMLDocument(siteMapConfig.getIndexedSiteMapFileName(), siteMapIndexWrapper);
    }

    protected java.lang.String createNextIndexedFileName() {
        java.lang.String pattern = siteMapConfig.getSiteMapIndexFilePattern();
        int indexFileNumber = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5506, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5504, indexedFileNames.size())) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5505, 1))));
        java.lang.String fileName = pattern.replaceFirst("###", java.lang.String.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5507, indexFileNumber)));
        return fileName;
    }

    protected void persistSiteMap() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5510, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5508, indexedFileNames.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5509, 0))))) {
            persistIndexedSiteMap();
        }else {
            persistNonIndexedSiteMap();
        }
    }

    public java.util.List<java.lang.String> getIndexedFileNames() {
        return indexedFileNames;
    }

    public java.lang.String getBaseUrl() {
        return baseUrl;
    }

    public static perturbation.location.PerturbationLocation __L5494;

    public static perturbation.location.PerturbationLocation __L5495;

    public static perturbation.location.PerturbationLocation __L5496;

    public static perturbation.location.PerturbationLocation __L5497;

    public static perturbation.location.PerturbationLocation __L5498;

    public static perturbation.location.PerturbationLocation __L5499;

    public static perturbation.location.PerturbationLocation __L5500;

    public static perturbation.location.PerturbationLocation __L5501;

    public static perturbation.location.PerturbationLocation __L5502;

    public static perturbation.location.PerturbationLocation __L5503;

    public static perturbation.location.PerturbationLocation __L5504;

    public static perturbation.location.PerturbationLocation __L5505;

    public static perturbation.location.PerturbationLocation __L5506;

    public static perturbation.location.PerturbationLocation __L5507;

    public static perturbation.location.PerturbationLocation __L5508;

    public static perturbation.location.PerturbationLocation __L5509;

    public static perturbation.location.PerturbationLocation __L5510;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:74)", 5494, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:74)", 5495, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:74)", 5496, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:92)", 5497, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:93)", 5498, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:96)", 5499, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:100)", 5500, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:100)", 5501, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:153)", 5502, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:163)", 5503, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:179)", 5504, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:179)", 5505, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:179)", 5506, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:180)", 5507, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:185)", 5508, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:185)", 5509, "Numerical");
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.__L5510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapBuilder.java:185)", 5510, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.SiteMapBuilder.initPerturbationLocation0();
    }
}

