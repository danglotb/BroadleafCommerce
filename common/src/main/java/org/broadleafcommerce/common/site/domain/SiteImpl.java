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
package org.broadleafcommerce.common.site.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_SITE")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "blSiteElements")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITEMARKER), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTI_PHASE_ADD) })
public class SiteImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.site.domain.Site , org.broadleafcommerce.common.site.domain.SiteAdminPresentation {
    private static final long serialVersionUID = 1L;

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.site.domain.SiteImpl.class);

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "SiteId")
    @org.hibernate.annotations.GenericGenerator(name = "SiteId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SiteImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.site.domain.SiteImpl") })
    @javax.persistence.Column(name = "SITE_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteImpl_Site_Name", order = 1000, gridOrder = 1, prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, translatable = true, group = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupName.General)
    protected java.lang.String name;

    @javax.persistence.Column(name = "SITE_IDENTIFIER_TYPE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteImpl_Site_Identifier_Type", order = 2000, gridOrder = 2, prominent = true, broadleafEnumeration = "org.broadleafcommerce.common.site.service.type.SiteResolutionType", requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, group = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupName.General)
    protected java.lang.String siteIdentifierType;

    @javax.persistence.Column(name = "SITE_IDENTIFIER_VALUE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteImpl_Site_Identifier_Value", order = 3000, gridOrder = 3, prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, group = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupName.General)
    @org.hibernate.annotations.Index(name = "BLC_SITE_ID_VAL_INDEX", columnNames = { "SITE_IDENTIFIER_VALUE" })
    protected java.lang.String siteIdentifierValue;

    @javax.persistence.Column(name = "DEACTIVATED")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SiteImpl_Deactivated", order = 4000, gridOrder = 4, excluded = false, defaultValue = "false", group = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupName.General)
    protected java.lang.Boolean deactivated = ((boolean) (false));

    @javax.persistence.ManyToMany(targetEntity = org.broadleafcommerce.common.site.domain.CatalogImpl.class, cascade = { javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.DETACH, javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
    @javax.persistence.JoinTable(name = "BLC_SITE_CATALOG", joinColumns = @javax.persistence.JoinColumn(name = "SITE_ID"), inverseJoinColumns = @javax.persistence.JoinColumn(name = "CATALOG_ID"))
    @org.hibernate.annotations.BatchSize(size = 50)
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSiteElements")
    @org.broadleafcommerce.common.presentation.AdminPresentation(excluded = true)
    protected java.util.List<org.broadleafcommerce.common.site.domain.Catalog> catalogs = new java.util.ArrayList<org.broadleafcommerce.common.site.domain.Catalog>();

    @javax.persistence.Embedded
    protected org.broadleafcommerce.common.persistence.ArchiveStatus archiveStatus = new org.broadleafcommerce.common.persistence.ArchiveStatus();

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getName() {
        return org.broadleafcommerce.common.i18n.service.DynamicTranslationProvider.getValue(this, "name", name);
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String getSiteIdentifierType() {
        return siteIdentifierType;
    }

    @java.lang.Override
    public void setSiteIdentifierType(java.lang.String siteIdentifierType) {
        this.siteIdentifierType = siteIdentifierType;
    }

    @java.lang.Override
    public java.lang.String getSiteIdentifierValue() {
        return siteIdentifierValue;
    }

    @java.lang.Override
    public void setSiteIdentifierValue(java.lang.String siteIdentifierValue) {
        this.siteIdentifierValue = siteIdentifierValue;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.service.type.SiteResolutionType getSiteResolutionType() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5252, ((siteIdentifierType) == null)) ? null : org.broadleafcommerce.common.site.service.type.SiteResolutionType.getInstance(siteIdentifierType);
    }

    @java.lang.Override
    public void setSiteResolutionType(org.broadleafcommerce.common.site.service.type.SiteResolutionType siteResolutionType) {
        this.siteIdentifierType = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5253, (siteResolutionType == null))) ? null : siteResolutionType.getType();
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> getCatalogs() {
        return catalogs;
    }

    @java.lang.Override
    public void setCatalogs(java.util.List<org.broadleafcommerce.common.site.domain.Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    @java.lang.Override
    public java.lang.Character getArchived() {
        org.broadleafcommerce.common.persistence.ArchiveStatus temp;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5254, ((archiveStatus) == null))) {
            temp = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }else {
            temp = archiveStatus;
        }
        return temp.getArchived();
    }

    @java.lang.Override
    public void setArchived(java.lang.Character archived) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5255, ((archiveStatus) == null))) {
            archiveStatus = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }
        archiveStatus.setArchived(archived);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.persistence.ArchiveStatus getArchiveStatus() {
        return archiveStatus;
    }

    @java.lang.Override
    public boolean isActive() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5256, org.broadleafcommerce.common.site.domain.SiteImpl.LOG.isDebugEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5257, isDeactivated())) {
                org.broadleafcommerce.common.site.domain.SiteImpl.LOG.debug((("site, " + (id)) + ", inactive due to deactivated property"));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5258, ('Y' == (getArchived())))) {
                org.broadleafcommerce.common.site.domain.SiteImpl.LOG.debug((("site, " + (id)) + ", inactive due to archived status"));
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5262, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5260, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5259, isDeactivated()))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5261, ('Y' != (getArchived()))))));
    }

    @java.lang.Override
    public boolean isDeactivated() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5263, ((deactivated) == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5264, false);
        }else {
            return deactivated;
        }
    }

    @java.lang.Override
    public void setDeactivated(boolean deactivated) {
        this.deactivated = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5265, deactivated);
    }

    @java.lang.Override
    public boolean isTemplateSite() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5266, false);
    }

    public void checkCloneable(org.broadleafcommerce.common.site.domain.Site site) throws java.lang.CloneNotSupportedException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method cloneMethod = site.getClass().getMethod("clone", new java.lang.Class[]{  });
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5270, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5267, cloneMethod.getDeclaringClass().getName().startsWith("org.broadleafcommerce"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5269, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5268, site.getClass().getName().startsWith("org.broadleafcommerce"))))))))) {
            throw new java.lang.CloneNotSupportedException("Custom extensions and implementations should implement clone.");
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site clone() {
        org.broadleafcommerce.common.site.domain.Site clone;
        try {
            clone = ((org.broadleafcommerce.common.site.domain.Site) (java.lang.Class.forName(this.getClass().getName()).newInstance()));
            try {
                checkCloneable(clone);
            } catch (java.lang.CloneNotSupportedException e) {
                org.broadleafcommerce.common.site.domain.SiteImpl.LOG.warn(("Clone implementation missing in inheritance hierarchy outside of Broadleaf: " + (clone.getClass().getName())), e);
            }
            clone.setId(id);
            clone.setName(name);
            clone.setDeactivated(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5271, isDeactivated()));
            clone.setSiteResolutionType(getSiteResolutionType());
            clone.setSiteIdentifierValue(getSiteIdentifierValue());
            ((org.broadleafcommerce.common.persistence.Status) (clone)).setArchived(getArchived());
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
        return clone;
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getName();
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5272, ((this) == o)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5273, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5275, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5274, (o instanceof org.broadleafcommerce.common.site.domain.SiteImpl))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5276, false);

        org.broadleafcommerce.common.site.domain.SiteImpl site = ((org.broadleafcommerce.common.site.domain.SiteImpl) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5281, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5279, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5277, ((id) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5278, ((site.id) != null)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5280, id.equals(site.id))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5282, true);

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5283, false);
    }

    @java.lang.Override
    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.SiteImpl.__L5287, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.SiteImpl.__L5284, ((id) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.SiteImpl.__L5285, id.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.SiteImpl.__L5286, 0)));
    }

    public static perturbation.location.PerturbationLocation __L5252;

    public static perturbation.location.PerturbationLocation __L5253;

    public static perturbation.location.PerturbationLocation __L5254;

    public static perturbation.location.PerturbationLocation __L5255;

    public static perturbation.location.PerturbationLocation __L5256;

    public static perturbation.location.PerturbationLocation __L5257;

    public static perturbation.location.PerturbationLocation __L5258;

    public static perturbation.location.PerturbationLocation __L5259;

    public static perturbation.location.PerturbationLocation __L5260;

    public static perturbation.location.PerturbationLocation __L5261;

    public static perturbation.location.PerturbationLocation __L5262;

    public static perturbation.location.PerturbationLocation __L5263;

    public static perturbation.location.PerturbationLocation __L5264;

    public static perturbation.location.PerturbationLocation __L5265;

    public static perturbation.location.PerturbationLocation __L5266;

    public static perturbation.location.PerturbationLocation __L5267;

    public static perturbation.location.PerturbationLocation __L5268;

    public static perturbation.location.PerturbationLocation __L5269;

    public static perturbation.location.PerturbationLocation __L5270;

    public static perturbation.location.PerturbationLocation __L5271;

    public static perturbation.location.PerturbationLocation __L5272;

    public static perturbation.location.PerturbationLocation __L5273;

    public static perturbation.location.PerturbationLocation __L5274;

    public static perturbation.location.PerturbationLocation __L5275;

    public static perturbation.location.PerturbationLocation __L5276;

    public static perturbation.location.PerturbationLocation __L5277;

    public static perturbation.location.PerturbationLocation __L5278;

    public static perturbation.location.PerturbationLocation __L5279;

    public static perturbation.location.PerturbationLocation __L5280;

    public static perturbation.location.PerturbationLocation __L5281;

    public static perturbation.location.PerturbationLocation __L5282;

    public static perturbation.location.PerturbationLocation __L5283;

    public static perturbation.location.PerturbationLocation __L5284;

    public static perturbation.location.PerturbationLocation __L5285;

    public static perturbation.location.PerturbationLocation __L5286;

    public static perturbation.location.PerturbationLocation __L5287;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:172)", 5252, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:177)", 5253, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:193)", 5254, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:203)", 5255, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:216)", 5256, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:217)", 5257, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:220)", 5258, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:224)", 5259, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:224)", 5260, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:224)", 5261, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:224)", 5262, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:229)", 5263, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:230)", 5264, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:238)", 5265, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:243)", 5266, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:248)", 5267, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:248)", 5268, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:248)", 5269, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:248)", 5270, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:266)", 5271, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:284)", 5272, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:284)", 5273, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:285)", 5274, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:285)", 5275, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:285)", 5276, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:289)", 5277, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:289)", 5278, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:289)", 5279, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:289)", 5280, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:289)", 5281, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:289)", 5282, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:291)", 5283, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:296)", 5284, "Boolean");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:296)", 5285, "Numerical");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:296)", 5286, "Numerical");
        org.broadleafcommerce.common.site.domain.SiteImpl.__L5287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/SiteImpl.java:296)", 5287, "Numerical");
    }

    static {
        org.broadleafcommerce.common.site.domain.SiteImpl.initPerturbationLocation0();
    }
}

