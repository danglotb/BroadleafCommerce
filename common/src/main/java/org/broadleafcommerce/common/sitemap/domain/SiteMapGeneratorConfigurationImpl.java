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
@javax.persistence.Table(name = "BLC_SITE_MAP_GEN_CFG")
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "SiteMapGeneratorConfigurationImpl")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE) })
public class SiteMapGeneratorConfigurationImpl implements org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "GeneratorConfigurationId")
    @org.hibernate.annotations.GenericGenerator(name = "GeneratorConfigurationId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SiteMapGeneratorConfigurationImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl") })
    @javax.persistence.Column(name = "GEN_CONFIG_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "DISABLED", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapGeneratorConfigurationImpl_Disabled", gridOrder = 2, prominent = true)
    protected java.lang.Boolean disabled = ((boolean) (false));

    @javax.persistence.Column(name = "CHANGE_FREQ", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapGeneratorConfigurationImpl_Change_Freq", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType", gridOrder = 3, prominent = true)
    protected java.lang.String changeFreq;

    @javax.persistence.Column(name = "PRIORITY", nullable = true)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapGeneratorConfigurationImpl_Priority", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType", gridOrder = 4, prominent = true)
    protected java.lang.String priority;

    @javax.persistence.Column(name = "GENERATOR_TYPE", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteMapGeneratorConfigurationImpl_Generator_Type", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType", gridOrder = 1, prominent = true)
    protected java.lang.String generatorType;

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl.class, optional = false)
    @javax.persistence.JoinColumn(name = "MODULE_CONFIG_ID")
    protected org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration siteMapConfiguration;

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.Boolean isDisabled() {
        return disabled;
    }

    @java.lang.Override
    public void setDisabled(java.lang.Boolean disabled) {
        this.disabled = disabled;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType getSiteMapChangeFreq() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5397, ((changeFreq) != null))) {
            return org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.getInstance(this.changeFreq);
        }else {
            return null;
        }
    }

    @java.lang.Override
    public void setSiteMapChangeFreq(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType siteMapChangeFreq) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5398, (siteMapChangeFreq != null))) {
            this.changeFreq = siteMapChangeFreq.getType();
        }else {
            this.changeFreq = null;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType getSiteMapPriority() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5399, ((priority) != null))) {
            return org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.getInstance(this.priority);
        }else {
            return null;
        }
    }

    @java.lang.Override
    public void setSiteMapPriority(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType siteMapPriority) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5400, (siteMapPriority != null))) {
            this.priority = siteMapPriority.getType();
        }else {
            this.priority = null;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType getSiteMapGeneratorType() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5401, ((generatorType) != null))) {
            return org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.getInstance(this.generatorType);
        }else {
            return null;
        }
    }

    @java.lang.Override
    public void setSiteMapGeneratorType(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType siteMapGeneratorType) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5402, (siteMapGeneratorType != null))) {
            this.generatorType = siteMapGeneratorType.getType();
        }else {
            this.generatorType = null;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration getSiteMapConfiguration() {
        return siteMapConfiguration;
    }

    @java.lang.Override
    public void setSiteMapConfiguration(org.broadleafcommerce.common.sitemap.domain.SiteMapConfiguration siteMapConfiguration) {
        this.siteMapConfiguration = siteMapConfiguration;
    }

    public static perturbation.location.PerturbationLocation __L5397;

    public static perturbation.location.PerturbationLocation __L5398;

    public static perturbation.location.PerturbationLocation __L5399;

    public static perturbation.location.PerturbationLocation __L5400;

    public static perturbation.location.PerturbationLocation __L5401;

    public static perturbation.location.PerturbationLocation __L5402;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapGeneratorConfigurationImpl.java:116)", 5397, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapGeneratorConfigurationImpl.java:125)", 5398, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapGeneratorConfigurationImpl.java:134)", 5399, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapGeneratorConfigurationImpl.java:143)", 5400, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapGeneratorConfigurationImpl.java:152)", 5401, "Boolean");
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.__L5402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/domain/SiteMapGeneratorConfigurationImpl.java:161)", 5402, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.initPerturbationLocation0();
    }
}

