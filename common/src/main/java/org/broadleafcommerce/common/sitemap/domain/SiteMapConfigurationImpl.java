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
package org.broadleafcommerce.common.sitemap.domain;


@javax.persistence.Entity
@javax.persistence.Table(name = "BLC_SITE_MAP_CFG")
public class SiteMapConfigurationImpl extends org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration implements org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation , org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration {
    private static final long serialVersionUID = 1L;

    private static java.lang.Integer DEFAULT_MAX_URL_ENTRIES = ((int) (50000));

    private static java.lang.String DEFAULT_SITE_MAP_FILE_NAME = "sitemap.xml";

    @javax.persistence.Column(name = "MAX_URL_ENTRIES_PER_FILE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(excluded = true)
    protected java.lang.Integer maximumURLEntriesPerFile;

    @javax.persistence.OneToMany(mappedBy = "siteMapConfiguration", targetEntity = org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.class, cascade = { javax.persistence.CascadeType.ALL }, orphanRemoval = true, fetch = javax.persistence.FetchType.EAGER)
    @org.broadleafcommerce.common.presentation.AdminPresentationCollection(friendlyName = "SiteMapConfigurationImpl_Generator_Configurations", tab = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.TabName.General)
    @org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminatable(type = org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminatableType.SITE)
    protected java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration> siteMapGeneratorConfigurations = new java.util.ArrayList<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration>();

    @javax.persistence.Column(name = "SITE_MAP_FILE_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL)
    protected java.lang.String siteMapFileName;

    @javax.persistence.Column(name = "INDEXED_SITE_MAP_FILE_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL)
    protected java.lang.String indexedSiteMapFileName;

    @javax.persistence.Column(name = "INDEXED_SITE_MAP_FILE_PATTERN")
    @org.broadleafcommerce.common.presentation.AdminPresentation(visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL)
    protected java.lang.String indexedSiteMapFilePattern;

    public SiteMapConfigurationImpl() {
        super();
        super.setModuleConfigurationType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.SITE_MAP);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration> getSiteMapGeneratorConfigurations() {
        return siteMapGeneratorConfigurations;
    }

    @java.lang.Override
    public void setSiteMapGeneratorConfigurations(java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration> siteMapGeneratorConfigurations) {
        this.siteMapGeneratorConfigurations = siteMapGeneratorConfigurations;
    }

    @java.lang.Override
    public java.lang.Integer getMaximumUrlEntriesPerFile() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5374, ((maximumURLEntriesPerFile) == null))) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5375, org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.DEFAULT_MAX_URL_ENTRIES);
        }else {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5376, maximumURLEntriesPerFile.intValue());
        }
    }

    @java.lang.Override
    public void setMaximumUrlEntriesPerFile(java.lang.Integer maximumSiteMapURLEntriesPerFile) {
        this.maximumURLEntriesPerFile = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5377, maximumSiteMapURLEntriesPerFile);
    }

    @java.lang.Override
    public java.lang.String fixSiteUrlPath(java.lang.String siteUrlPath) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5378, (siteUrlPath == null))) {
            return siteUrlPath;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5379, siteUrlPath.endsWith("/"))) {
            return siteUrlPath.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5380, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5383, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5381, siteUrlPath.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5382, 1)))));
        }
        return siteUrlPath;
    }

    @java.lang.Override
    public java.lang.String getSiteMapFileName() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5384, org.apache.commons.lang3.StringUtils.isEmpty(siteMapFileName))) {
            return org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.DEFAULT_SITE_MAP_FILE_NAME;
        }else {
            return siteMapFileName;
        }
    }

    @java.lang.Override
    public void setSiteMapFileName(java.lang.String siteMapFileName) {
        this.siteMapFileName = siteMapFileName;
    }

    @java.lang.Override
    public java.lang.String getIndexedSiteMapFileName() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5385, org.apache.commons.lang3.StringUtils.isEmpty(indexedSiteMapFileName))) {
            return getSiteMapFileName();
        }
        return indexedSiteMapFileName;
    }

    @java.lang.Override
    public void setIndexedSiteMapFileName(java.lang.String fileName) {
        this.indexedSiteMapFileName = fileName;
    }

    @java.lang.Override
    public java.lang.String getSiteMapIndexFilePattern() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5389, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5387, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5386, org.apache.commons.lang3.StringUtils.isEmpty(indexedSiteMapFilePattern)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5388, indexedSiteMapFilePattern.contains("###")))))) {
            return indexedSiteMapFilePattern;
        }
        java.lang.String siteMapFileName = getSiteMapFileName();
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5390, siteMapFileName.indexOf(".xml"));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5393, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5391, pos)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5392, 0))))) {
            return ((siteMapFileName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5394, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5395, pos))) + "###") + (siteMapFileName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5396, pos)));
        }else {
            return "sitemap###.xml";
        }
    }

    @java.lang.Override
    public void setIndexedSiteMapFilePattern(java.lang.String indexedSiteMapFilePattern) {
        this.indexedSiteMapFilePattern = indexedSiteMapFilePattern;
    }

    public static perturbation.location.PerturbationLocation __L5374;

    public static perturbation.location.PerturbationLocation __L5375;

    public static perturbation.location.PerturbationLocation __L5376;

    public static perturbation.location.PerturbationLocation __L5377;

    public static perturbation.location.PerturbationLocation __L5378;

    public static perturbation.location.PerturbationLocation __L5379;

    public static perturbation.location.PerturbationLocation __L5380;

    public static perturbation.location.PerturbationLocation __L5381;

    public static perturbation.location.PerturbationLocation __L5382;

    public static perturbation.location.PerturbationLocation __L5383;

    public static perturbation.location.PerturbationLocation __L5384;

    public static perturbation.location.PerturbationLocation __L5385;

    public static perturbation.location.PerturbationLocation __L5386;

    public static perturbation.location.PerturbationLocation __L5387;

    public static perturbation.location.PerturbationLocation __L5388;

    public static perturbation.location.PerturbationLocation __L5389;

    public static perturbation.location.PerturbationLocation __L5390;

    public static perturbation.location.PerturbationLocation __L5391;

    public static perturbation.location.PerturbationLocation __L5392;

    public static perturbation.location.PerturbationLocation __L5393;

    public static perturbation.location.PerturbationLocation __L5394;

    public static perturbation.location.PerturbationLocation __L5395;

    public static perturbation.location.PerturbationLocation __L5396;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:95)", 5374, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:96)", 5375, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:98)", 5376, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:104)", 5377, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:109)", 5378, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:112)", 5379, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:113)", 5380, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:113)", 5381, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:113)", 5382, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:113)", 5383, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:120)", 5384, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:134)", 5385, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:147)", 5386, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:147)", 5387, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:148)", 5388, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:147)", 5389, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:153)", 5390, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:154)", 5391, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:154)", 5392, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:154)", 5393, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:155)", 5394, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:155)", 5395, "Numerical");
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.__L5396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapConfigurationImpl.java:155)", 5396, "Numerical");
    }

    static {
        org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.initPerturbationLocation0();
    }
}

