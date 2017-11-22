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
package org.broadleafcommerce.common.site.dao;


@org.springframework.stereotype.Repository("blSiteDao")
public class SiteDaoImpl implements org.broadleafcommerce.common.site.dao.SiteDao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site create() {
        return ((org.broadleafcommerce.common.site.domain.Site) (entityConfiguration.createEntityInstance(org.broadleafcommerce.common.site.domain.Site.class.getName())));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieve(java.lang.Long id) {
        return em.find(org.broadleafcommerce.common.site.domain.SiteImpl.class, id);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog retrieveCatalog(java.lang.Long id) {
        return em.find(org.broadleafcommerce.common.site.domain.CatalogImpl.class, id);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog retrieveCatalogByName(java.lang.String name) {
        javax.persistence.TypedQuery<org.broadleafcommerce.common.site.domain.Catalog> catalogByName = new org.broadleafcommerce.common.util.dao.TypedQueryBuilder<>(org.broadleafcommerce.common.site.domain.Catalog.class, "c").addRestriction("c.name", "=", name).toQuery(em);
        java.util.List<org.broadleafcommerce.common.site.domain.Catalog> catalogs = catalogByName.getResultList();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5200, org.apache.commons.collections.CollectionUtils.isNotEmpty(catalogs))) {
            return catalogs.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5201, 0));
        }else {
            return null;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog createCatalog() {
        return ((org.broadleafcommerce.common.site.domain.Catalog) (entityConfiguration.createEntityInstance(org.broadleafcommerce.common.site.domain.Catalog.class.getName())));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.SiteCatalogXref createSiteCatalog() {
        return ((org.broadleafcommerce.common.site.domain.SiteCatalogXref) (entityConfiguration.createEntityInstance(org.broadleafcommerce.common.site.domain.SiteCatalogXref.class.getName())));
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Site> readAllActiveSites() {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.site.domain.Site> criteria = builder.createQuery(org.broadleafcommerce.common.site.domain.Site.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.site.domain.SiteImpl> site = criteria.from(org.broadleafcommerce.common.site.domain.SiteImpl.class);
        criteria.select(site);
        criteria.where(builder.and(builder.or(builder.isNull(site.get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(site.get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y')), builder.or(builder.isNull(site.get("deactivated").as(java.lang.Boolean.class)), builder.notEqual(site.get("deactivated").as(java.lang.Boolean.class), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5202, true)))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.site.domain.Site> query = em.createQuery(criteria);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5203, true));
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHE_REGION, "blSiteElementsQuery");
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByDomainOrDomainPrefix(java.lang.String domain, java.lang.String domainPrefix) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5204, (domain == null))) {
            return null;
        }
        java.util.List<org.broadleafcommerce.common.site.domain.Site> results = retrieveSitesByPotentialIdentifiers(domain, domainPrefix);
        for (org.broadleafcommerce.common.site.domain.Site currentSite : results) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5205, org.broadleafcommerce.common.site.service.type.SiteResolutionType.DOMAIN.equals(currentSite.getSiteResolutionType()))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5206, domain.equals(currentSite.getSiteIdentifierValue()))) {
                    return currentSite;
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5207, org.broadleafcommerce.common.site.service.type.SiteResolutionType.DOMAIN_PREFIX.equals(currentSite.getSiteResolutionType()))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5208, domainPrefix.equals(currentSite.getSiteIdentifierValue()))) {
                    return currentSite;
                }
            }
        }
        return null;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByIdentifier(java.lang.String identifier) {
        java.util.List<org.broadleafcommerce.common.site.domain.Site> sites = retrieveSitesByPotentialIdentifiers(identifier);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5209, org.apache.commons.collections.CollectionUtils.isNotEmpty(sites)) ? sites.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5210, 0)) : null;
    }

    public java.util.List<org.broadleafcommerce.common.site.domain.Site> retrieveSitesByPotentialIdentifiers(java.lang.String... potentialIdentifiers) {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.site.domain.Site> criteria = builder.createQuery(org.broadleafcommerce.common.site.domain.Site.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.site.domain.SiteImpl> site = criteria.from(org.broadleafcommerce.common.site.domain.SiteImpl.class);
        criteria.select(site);
        criteria.where(builder.and(site.get("siteIdentifierValue").as(java.lang.String.class).in(potentialIdentifiers), builder.and(builder.or(builder.isNull(site.get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(site.get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y')), builder.or(builder.isNull(site.get("deactivated").as(java.lang.Boolean.class)), builder.notEqual(site.get("deactivated").as(java.lang.Boolean.class), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5211, true))))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.site.domain.Site> query = em.createQuery(criteria);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5212, true));
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHE_REGION, "blSiteElementsQuery");
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site save(org.broadleafcommerce.common.site.domain.Site site) {
        return em.merge(site);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveDefaultSite() {
        return null;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog save(org.broadleafcommerce.common.site.domain.Catalog catalog) {
        return em.merge(catalog);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> retrieveAllCatalogs() {
        javax.persistence.TypedQuery<org.broadleafcommerce.common.site.domain.Catalog> q = new org.broadleafcommerce.common.util.dao.TypedQueryBuilder<>(org.broadleafcommerce.common.site.domain.Catalog.class, "c").toQuery(em);
        return q.getResultList();
    }

    public static perturbation.location.PerturbationLocation __L5200;

    public static perturbation.location.PerturbationLocation __L5201;

    public static perturbation.location.PerturbationLocation __L5202;

    public static perturbation.location.PerturbationLocation __L5203;

    public static perturbation.location.PerturbationLocation __L5204;

    public static perturbation.location.PerturbationLocation __L5205;

    public static perturbation.location.PerturbationLocation __L5206;

    public static perturbation.location.PerturbationLocation __L5207;

    public static perturbation.location.PerturbationLocation __L5208;

    public static perturbation.location.PerturbationLocation __L5209;

    public static perturbation.location.PerturbationLocation __L5210;

    public static perturbation.location.PerturbationLocation __L5211;

    public static perturbation.location.PerturbationLocation __L5212;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:73)", 5200, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:74)", 5201, "Numerical");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:101)", 5202, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:106)", 5203, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:114)", 5204, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:121)", 5205, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:122)", 5206, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:127)", 5207, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:128)", 5208, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:140)", 5209, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:140)", 5210, "Numerical");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:154)", 5211, "Boolean");
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.__L5212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/dao/SiteDaoImpl.java:159)", 5212, "Boolean");
    }

    static {
        org.broadleafcommerce.common.site.dao.SiteDaoImpl.initPerturbationLocation0();
    }
}

