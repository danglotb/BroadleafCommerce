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
@javax.persistence.Table(name = "BLC_SITE_MAP_URL_ENTRY")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "SiteMapURLEntryImpl")
public class SiteMapUrlEntryImpl implements org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "URLEntryId")
    @org.hibernate.annotations.GenericGenerator(name = "URLEntryId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SiteMapURLEntryImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.sitemap.domain.SiteMapURLEntryImpl") })
    @javax.persistence.Column(name = "URL_ENTRY_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "LOCATION", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapURLEntryImpl_Location", gridOrder = 1, prominent = true)
    protected java.lang.String location;

    @javax.persistence.Column(name = "LAST_MODIFIED", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapURLEntryImpl_Last_Modified", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.DATE, gridOrder = 2, prominent = true)
    protected java.util.Date lastModified = new java.util.Date();

    @javax.persistence.Column(name = "CHANGE_FREQ", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapURLEntryImpl_Change_Freq", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType", gridOrder = 3, prominent = true)
    protected java.lang.String changeFreq;

    @javax.persistence.Column(name = "PRIORITY", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapURLEntryImpl_Priority", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType", gridOrder = 4, prominent = true)
    protected java.lang.String priority;

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl.class, optional = false)
    @javax.persistence.JoinColumn(name = "GEN_CONFIG_ID")
    protected org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration customUrlSiteMapGeneratorConfiguration;

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getLocation() {
        return location;
    }

    @java.lang.Override
    public void setLocation(java.lang.String location) {
        this.location = location;
    }

    @java.lang.Override
    public java.util.Date getLastMod() {
        return lastModified;
    }

    @java.lang.Override
    public void setLastMod(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType getSiteMapChangeFreq() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5403, ((changeFreq) != null))) {
            return org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.getInstance(this.changeFreq);
        }else {
            return null;
        }
    }

    @java.lang.Override
    public void setSiteMapChangeFreq(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType siteMapChangeFreq) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5404, (siteMapChangeFreq != null))) {
            this.changeFreq = siteMapChangeFreq.getType();
        }else {
            this.changeFreq = null;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType getSiteMapPriority() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5405, ((priority) != null))) {
            return org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.getInstance(this.priority);
        }else {
            return null;
        }
    }

    @java.lang.Override
    public void setSiteMapPriority(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType siteMapPriority) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5406, (siteMapPriority != null))) {
            this.priority = siteMapPriority.getType();
        }else {
            this.priority = null;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration getCustomUrlSiteMapGeneratorConfiguration() {
        return customUrlSiteMapGeneratorConfiguration;
    }

    @java.lang.Override
    public void setCustomUrlSiteMapGeneratorConfiguration(org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration customUrlSiteMapGeneratorConfiguration) {
        this.customUrlSiteMapGeneratorConfiguration = customUrlSiteMapGeneratorConfiguration;
    }

    public static perturbation.location.PerturbationLocation __L5403;

    public static perturbation.location.PerturbationLocation __L5404;

    public static perturbation.location.PerturbationLocation __L5405;

    public static perturbation.location.PerturbationLocation __L5406;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapUrlEntryImpl.java:117)", 5403, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapUrlEntryImpl.java:126)", 5404, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapUrlEntryImpl.java:135)", 5405, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.__L5406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapUrlEntryImpl.java:144)", 5406, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.initPerturbationLocation0();
    }
}

