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
package org.broadleafcommerce.common.config.dao;


@org.springframework.stereotype.Repository("blSystemPropertiesDao")
public class SystemPropertiesDaoImpl extends org.broadleafcommerce.common.cache.AbstractCacheMissAware implements org.broadleafcommerce.common.config.dao.SystemPropertiesDao {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.class);

    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @javax.annotation.Resource(name = "blSystemPropertyDaoQueryExtensionManager")
    protected org.broadleafcommerce.common.config.dao.SystemPropertyDaoQueryExtensionManager queryExtensionManager;

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.SystemProperty readById(java.lang.Long id) {
        return em.find(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, id);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.SystemProperty saveSystemProperty(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty) {
        return em.merge(systemProperty);
    }

    @java.lang.Override
    public void deleteSystemProperty(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty) {
        em.remove(systemProperty);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.config.domain.SystemProperty> readAllSystemProperties() {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.config.domain.SystemProperty> criteria = builder.createQuery(org.broadleafcommerce.common.config.domain.SystemProperty.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.config.domain.SystemPropertyImpl> handler = criteria.from(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class);
        criteria.select(handler);
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        java.util.List<javax.persistence.criteria.Order> sorts = new java.util.ArrayList<javax.persistence.criteria.Order>();
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L323, ((queryExtensionManager) != null))) {
                queryExtensionManager.getProxy().setup(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null);
                queryExtensionManager.getProxy().refineRetrieve(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null, builder, criteria, handler, restrictions);
                queryExtensionManager.getProxy().refineOrder(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null, builder, criteria, handler, sorts);
            }
            criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L324, restrictions.size())]));
            return em.createQuery(criteria).getResultList();
        } catch (javax.persistence.NoResultException e) {
            org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.LOG.error(e);
            return new java.util.ArrayList<org.broadleafcommerce.common.config.domain.SystemProperty>();
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L325, ((queryExtensionManager) != null))) {
                queryExtensionManager.getProxy().breakdown(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null);
            }
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.SystemProperty readSystemPropertyByName(final java.lang.String name) {
        return getCachedObject(org.broadleafcommerce.common.config.domain.SystemProperty.class, "blSystemPropertyNullCheckCache", "SYSTEM_PROPERTY_MISSING_CACHE_HIT_RATE", new org.broadleafcommerce.common.cache.PersistentRetrieval<org.broadleafcommerce.common.config.domain.SystemProperty>() {
            @java.lang.Override
            public org.broadleafcommerce.common.config.domain.SystemProperty retrievePersistentObject() {
                javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
                javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.config.domain.SystemProperty> criteria = builder.createQuery(org.broadleafcommerce.common.config.domain.SystemProperty.class);
                javax.persistence.criteria.Root<org.broadleafcommerce.common.config.domain.SystemPropertyImpl> handler = criteria.from(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class);
                criteria.select(handler);
                java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
                restrictions.add(builder.equal(handler.get("name"), name));
                try {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L326, ((queryExtensionManager) != null))) {
                        queryExtensionManager.getProxy().setup(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null);
                        queryExtensionManager.getProxy().refineRetrieve(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null, builder, criteria, handler, restrictions);
                    }
                    criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L327, restrictions.size())]));
                    javax.persistence.TypedQuery<org.broadleafcommerce.common.config.domain.SystemProperty> query = em.createQuery(criteria);
                    query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L328, true));
                    java.util.List<org.broadleafcommerce.common.config.domain.SystemProperty> response = query.getResultList();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L331, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L329, response.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L330, 0))))) {
                        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List> resultHolder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<>();
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L332, ((queryExtensionManager) != null))) {
                            org.broadleafcommerce.common.extension.ExtensionResultStatusType resultStatusType = queryExtensionManager.getProxy().refineResults(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null, response, resultHolder);
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L334, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L333, resultStatusType.equals(org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED)))))) {
                                return ((org.broadleafcommerce.common.config.domain.SystemProperty) (resultHolder.getResult().get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L335, 0))));
                            }
                        }
                        return response.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L336, 0));
                    }
                    return null;
                } finally {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L337, ((queryExtensionManager) != null))) {
                        queryExtensionManager.getProxy().breakdown(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.class, null);
                    }
                }
            }
        }, name, getSite());
    }

    @java.lang.Override
    public void removeFromCache(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty) {
        java.lang.String site = "";
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L340, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L338, (systemProperty instanceof org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L339, ((((org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator) (systemProperty)).getSiteDiscriminator()) != null)))))) {
            site = java.lang.String.valueOf(((org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator) (systemProperty)).getSiteDiscriminator());
        }
        super.removeItemFromCache("blSystemPropertyNullCheckCache", systemProperty.getName(), site);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.SystemProperty createNewSystemProperty() {
        return ((org.broadleafcommerce.common.config.domain.SystemProperty) (entityConfiguration.createEntityInstance(org.broadleafcommerce.common.config.domain.SystemProperty.class.getName())));
    }

    @java.lang.Override
    protected org.apache.commons.logging.Log getLogger() {
        return org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.LOG;
    }

    protected java.lang.String getSite() {
        java.lang.String site = "";
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L341, (brc != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L342, ((brc.getSite()) != null))) {
                site = java.lang.String.valueOf(brc.getSite().getId());
            }
        }
        return site;
    }

    public static perturbation.location.PerturbationLocation __L323;

    public static perturbation.location.PerturbationLocation __L324;

    public static perturbation.location.PerturbationLocation __L325;

    public static perturbation.location.PerturbationLocation __L326;

    public static perturbation.location.PerturbationLocation __L327;

    public static perturbation.location.PerturbationLocation __L328;

    public static perturbation.location.PerturbationLocation __L329;

    public static perturbation.location.PerturbationLocation __L330;

    public static perturbation.location.PerturbationLocation __L331;

    public static perturbation.location.PerturbationLocation __L332;

    public static perturbation.location.PerturbationLocation __L333;

    public static perturbation.location.PerturbationLocation __L334;

    public static perturbation.location.PerturbationLocation __L335;

    public static perturbation.location.PerturbationLocation __L336;

    public static perturbation.location.PerturbationLocation __L337;

    public static perturbation.location.PerturbationLocation __L338;

    public static perturbation.location.PerturbationLocation __L339;

    public static perturbation.location.PerturbationLocation __L340;

    public static perturbation.location.PerturbationLocation __L341;

    public static perturbation.location.PerturbationLocation __L342;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:92)", 323, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:97)", 324, "Numerical");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:103)", 325, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:123)", 326, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:127)", 327, "Numerical");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:130)", 328, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:132)", 329, "Numerical");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:132)", 330, "Numerical");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:132)", 331, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:134)", 332, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:136)", 333, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:136)", 334, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:137)", 335, "Numerical");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:140)", 336, "Numerical");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:144)", 337, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:155)", 338, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:155)", 339, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:155)", 340, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:174)", 341, "Boolean");
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.__L342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/SystemPropertiesDaoImpl.java:175)", 342, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl.initPerturbationLocation0();
    }
}

