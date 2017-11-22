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
@javax.persistence.Table(name = "BLC_CATALOG")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSiteElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "CatalogImpl")
@org.hibernate.annotations.SQLDelete(sql = "UPDATE BLC_CATALOG SET ARCHIVED = 'Y' WHERE CATALOG_ID = ?")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITEMARKER), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTI_PHASE_ADD) })
public class CatalogImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.site.domain.Catalog {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.site.domain.CatalogImpl.class);

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "CatalogId")
    @org.hibernate.annotations.GenericGenerator(name = "CatalogId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "CatalogImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.site.domain.CatalogImpl") })
    @javax.persistence.Column(name = "CATALOG_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "Catalog_Name", gridOrder = 1, order = 1, prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, translatable = true)
    protected java.lang.String name;

    @javax.persistence.OneToMany(targetEntity = org.broadleafcommerce.common.site.domain.SiteCatalogXrefImpl.class, mappedBy = "catalog", orphanRemoval = true)
    @org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST })
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSiteElements")
    @org.hibernate.annotations.BatchSize(size = 50)
    protected java.util.List<org.broadleafcommerce.common.site.domain.SiteCatalogXref> siteXrefs = new java.util.ArrayList<org.broadleafcommerce.common.site.domain.SiteCatalogXref>();

    @javax.persistence.Transient
    protected java.util.List<org.broadleafcommerce.common.site.domain.Site> sites = new java.util.ArrayList<org.broadleafcommerce.common.site.domain.Site>();

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
    public java.util.List<org.broadleafcommerce.common.site.domain.Site> getSites() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5213, sites.isEmpty())) {
            for (org.broadleafcommerce.common.site.domain.SiteCatalogXref xref : siteXrefs) {
                sites.add(xref.getSite());
            }
        }
        return java.util.Collections.unmodifiableList(sites);
    }

    @java.lang.Override
    public void setSites(java.util.List<org.broadleafcommerce.common.site.domain.Site> sites) {
        this.sites = sites;
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.SiteCatalogXref> getSiteXrefs() {
        return siteXrefs;
    }

    @java.lang.Override
    public void setSiteXrefs(java.util.List<org.broadleafcommerce.common.site.domain.SiteCatalogXref> siteXrefs) {
        this.siteXrefs = siteXrefs;
    }

    public void checkCloneable(org.broadleafcommerce.common.site.domain.Catalog catalog) throws java.lang.CloneNotSupportedException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method cloneMethod = catalog.getClass().getMethod("clone", new java.lang.Class[]{  });
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5217, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5214, cloneMethod.getDeclaringClass().getName().startsWith("org.broadleafcommerce"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5216, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5215, catalog.getClass().getName().startsWith("org.broadleafcommerce"))))))))) {
            throw new java.lang.CloneNotSupportedException("Custom extensions and implementations should implement clone.");
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog clone() {
        org.broadleafcommerce.common.site.domain.Catalog clone;
        try {
            clone = ((org.broadleafcommerce.common.site.domain.Catalog) (java.lang.Class.forName(this.getClass().getName()).newInstance()));
            try {
                checkCloneable(clone);
            } catch (java.lang.CloneNotSupportedException e) {
                org.broadleafcommerce.common.site.domain.CatalogImpl.LOG.warn(("Clone implementation missing in inheritance hierarchy outside of Broadleaf: " + (clone.getClass().getName())), e);
            }
            clone.setId(id);
            clone.setName(name);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
        return clone;
    }

    @java.lang.Override
    public int compareTo(org.broadleafcommerce.common.site.domain.Catalog other) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5218, name.compareTo(other.getName()));
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getName();
    }

    @java.lang.Override
    public java.lang.Character getArchived() {
        org.broadleafcommerce.common.persistence.ArchiveStatus temp;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5219, ((archiveStatus) == null))) {
            temp = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }else {
            temp = archiveStatus;
        }
        return temp.getArchived();
    }

    @java.lang.Override
    public void setArchived(java.lang.Character archived) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5220, ((archiveStatus) == null))) {
            archiveStatus = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }
        archiveStatus.setArchived(archived);
    }

    @java.lang.Override
    public boolean isActive() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5221, org.broadleafcommerce.common.site.domain.CatalogImpl.LOG.isDebugEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5222, ('Y' == (getArchived())))) {
                org.broadleafcommerce.common.site.domain.CatalogImpl.LOG.debug((("catalog, " + (id)) + ", inactive due to archived status"));
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5223, ('Y' != (getArchived())));
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5224, ((this) == o)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5225, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5227, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5226, (o instanceof org.broadleafcommerce.common.site.domain.CatalogImpl))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5228, false);

        org.broadleafcommerce.common.site.domain.CatalogImpl catalog = ((org.broadleafcommerce.common.site.domain.CatalogImpl) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5233, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5229, ((id) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5231, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5230, id.equals(catalog.id))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5232, ((catalog.id) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5234, false);

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5238, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5235, ((name) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5236, name.equals(catalog.name)) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5237, ((catalog.name) == null))));
    }

    @java.lang.Override
    public int hashCode() {
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5242, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5239, ((id) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5240, id.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5241, 0)));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5250, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5245, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5243, 31)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5244, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5249, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5246, ((name) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5247, name.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5248, 0))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.domain.CatalogImpl.__L5251, result);
    }

    public static perturbation.location.PerturbationLocation __L5213;

    public static perturbation.location.PerturbationLocation __L5214;

    public static perturbation.location.PerturbationLocation __L5215;

    public static perturbation.location.PerturbationLocation __L5216;

    public static perturbation.location.PerturbationLocation __L5217;

    public static perturbation.location.PerturbationLocation __L5218;

    public static perturbation.location.PerturbationLocation __L5219;

    public static perturbation.location.PerturbationLocation __L5220;

    public static perturbation.location.PerturbationLocation __L5221;

    public static perturbation.location.PerturbationLocation __L5222;

    public static perturbation.location.PerturbationLocation __L5223;

    public static perturbation.location.PerturbationLocation __L5224;

    public static perturbation.location.PerturbationLocation __L5225;

    public static perturbation.location.PerturbationLocation __L5226;

    public static perturbation.location.PerturbationLocation __L5227;

    public static perturbation.location.PerturbationLocation __L5228;

    public static perturbation.location.PerturbationLocation __L5229;

    public static perturbation.location.PerturbationLocation __L5230;

    public static perturbation.location.PerturbationLocation __L5231;

    public static perturbation.location.PerturbationLocation __L5232;

    public static perturbation.location.PerturbationLocation __L5233;

    public static perturbation.location.PerturbationLocation __L5234;

    public static perturbation.location.PerturbationLocation __L5235;

    public static perturbation.location.PerturbationLocation __L5236;

    public static perturbation.location.PerturbationLocation __L5237;

    public static perturbation.location.PerturbationLocation __L5238;

    public static perturbation.location.PerturbationLocation __L5239;

    public static perturbation.location.PerturbationLocation __L5240;

    public static perturbation.location.PerturbationLocation __L5241;

    public static perturbation.location.PerturbationLocation __L5242;

    public static perturbation.location.PerturbationLocation __L5243;

    public static perturbation.location.PerturbationLocation __L5244;

    public static perturbation.location.PerturbationLocation __L5245;

    public static perturbation.location.PerturbationLocation __L5246;

    public static perturbation.location.PerturbationLocation __L5247;

    public static perturbation.location.PerturbationLocation __L5248;

    public static perturbation.location.PerturbationLocation __L5249;

    public static perturbation.location.PerturbationLocation __L5250;

    public static perturbation.location.PerturbationLocation __L5251;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:124)", 5213, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:149)", 5214, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:149)", 5215, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:149)", 5216, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:149)", 5217, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:176)", 5218, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:187)", 5219, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:197)", 5220, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:205)", 5221, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:206)", 5222, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:210)", 5223, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:215)", 5224, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:215)", 5225, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:216)", 5226, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:216)", 5227, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:216)", 5228, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:220)", 5229, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:220)", 5230, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:220)", 5231, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:220)", 5232, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:220)", 5233, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:220)", 5234, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:221)", 5235, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:221)", 5236, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:221)", 5237, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:221)", 5238, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:226)", 5239, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:226)", 5240, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:226)", 5241, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:226)", 5242, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5243, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5244, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5245, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5246, "Boolean");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5247, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5248, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5249, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:227)", 5250, "Numerical");
        org.broadleafcommerce.common.site.domain.CatalogImpl.__L5251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/domain/CatalogImpl.java:228)", 5251, "Numerical");
    }

    static {
        org.broadleafcommerce.common.site.domain.CatalogImpl.initPerturbationLocation0();
    }
}

