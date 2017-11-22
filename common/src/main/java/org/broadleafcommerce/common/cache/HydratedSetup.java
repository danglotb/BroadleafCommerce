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
package org.broadleafcommerce.common.cache;


public class HydratedSetup {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.cache.HydratedSetup.class);

    private static java.util.Map<java.lang.String, java.lang.String> inheritanceHierarchyRoots = java.util.Collections.synchronizedMap(new java.util.HashMap<java.lang.String, java.lang.String>());

    private static java.lang.String getInheritanceHierarchyRoot(java.lang.Class<?> myEntityClass) {
        java.lang.String myEntityName = myEntityClass.getName();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L242, org.broadleafcommerce.common.cache.HydratedSetup.inheritanceHierarchyRoots.containsKey(myEntityName))) {
            return org.broadleafcommerce.common.cache.HydratedSetup.inheritanceHierarchyRoots.get(myEntityName);
        }
        java.lang.Class<?> currentClass = myEntityClass;
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L243, false);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L245, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L244, eof))))) {
            java.lang.Class<?> superclass = currentClass.getSuperclass();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L249, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L246, superclass.equals(java.lang.Object.class))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L248, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L247, superclass.isAnnotationPresent(javax.persistence.Entity.class))))))))) {
                eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L250, true);
            }else {
                currentClass = superclass;
            }
        } 
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L252, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L251, currentClass.isAnnotationPresent(org.hibernate.annotations.Cache.class)))))) {
            currentClass = myEntityClass;
        }
        org.broadleafcommerce.common.cache.HydratedSetup.inheritanceHierarchyRoots.put(myEntityName, currentClass.getName());
        return org.broadleafcommerce.common.cache.HydratedSetup.inheritanceHierarchyRoots.get(myEntityName);
    }

    public static void populateFromCache(java.lang.Object entity) {
        org.broadleafcommerce.common.cache.HydratedSetup.populateFromCache(entity, null);
    }

    public static void populateFromCache(java.lang.Object entity, java.lang.String propertyName) {
        org.broadleafcommerce.common.cache.engine.HydratedCacheManager manager = org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.getConfiguredManager();
        org.broadleafcommerce.common.cache.engine.HydrationDescriptor descriptor = ((org.broadleafcommerce.common.cache.engine.HydratedAnnotationManager) (manager)).getHydrationDescriptor(entity);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L254, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L253, org.apache.commons.collections.MapUtils.isEmpty(descriptor.getHydratedMutators())))))) {
            java.lang.reflect.Method[] idMutators = descriptor.getIdMutators();
            java.lang.String cacheRegion = descriptor.getCacheRegion();
            for (java.lang.String field : descriptor.getHydratedMutators().keySet()) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L257, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L255, org.apache.commons.lang3.StringUtils.isEmpty(propertyName))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L256, field.equals(propertyName)))))) {
                    try {
                        java.io.Serializable entityId = ((java.io.Serializable) (idMutators[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.HydratedSetup.__L258, 0)].invoke(entity)));
                        java.lang.Object hydratedItem = manager.getHydratedCacheElementItem(cacheRegion, org.broadleafcommerce.common.cache.HydratedSetup.getInheritanceHierarchyRoot(entity.getClass()), entityId, field);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L259, (hydratedItem == null))) {
                            java.lang.reflect.Method factoryMethod = entity.getClass().getMethod(descriptor.getHydratedMutators().get(field).getFactoryMethod(), new java.lang.Class[]{  });
                            java.lang.Object fieldVal = factoryMethod.invoke(entity);
                            manager.addHydratedCacheElementItem(cacheRegion, org.broadleafcommerce.common.cache.HydratedSetup.getInheritanceHierarchyRoot(entity.getClass()), entityId, field, fieldVal);
                            hydratedItem = fieldVal;
                        }
                        descriptor.getHydratedMutators().get(field).getMutators()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.HydratedSetup.__L260, 1)].invoke(entity, hydratedItem);
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L263, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L261, ((e.getTargetException()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L262, ((e.getTargetException()) instanceof org.broadleafcommerce.common.cache.engine.CacheFactoryException)))))) {
                            org.broadleafcommerce.common.cache.HydratedSetup.LOG.warn(("Unable to setup the hydrated cache for an entity. " + (e.getTargetException().getMessage())));
                        }else {
                            throw new java.lang.RuntimeException((((("There was a problem while replacing a hydrated cache item - field(" + field) + ") : entity(") + (entity.getClass().getName())) + ')'), e);
                        }
                    } catch (java.lang.Exception e) {
                        throw new java.lang.RuntimeException((((("There was a problem while replacing a hydrated cache item - field(" + field) + ") : entity(") + (entity.getClass().getName())) + ')'), e);
                    }
                }
            }
        }
    }

    public static void addCacheItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName, java.lang.Object elementValue) {
        org.broadleafcommerce.common.cache.engine.HydratedCacheManager manager = org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.getConfiguredManager();
        manager.addHydratedCacheElementItem(cacheRegion, cacheName, elementKey, elementItemName, elementValue);
    }

    public static java.lang.Object getCacheItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName) {
        org.broadleafcommerce.common.cache.engine.HydratedCacheManager manager = org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.getConfiguredManager();
        return manager.getHydratedCacheElementItem(cacheRegion, cacheName, elementKey, elementItemName);
    }

    public static javax.persistence.EntityManager retrieveBoundEntityManager() {
        java.util.Map<java.lang.Object, java.lang.Object> resources = org.springframework.transaction.support.TransactionSynchronizationManager.getResourceMap();
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : resources.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.HydratedSetup.__L264, ((entry.getKey()) instanceof javax.persistence.EntityManagerFactory))) {
                javax.persistence.EntityManagerFactory emf = ((javax.persistence.EntityManagerFactory) (entry.getKey()));
                return ((org.springframework.orm.jpa.EntityManagerHolder) (entry.getValue())).getEntityManager();
            }
        }
        throw new java.lang.RuntimeException("Unable to restore skus from hydrated cache. Please make sure that the OpenEntityManagerInViewFilter is configured in web.xml for the blPU persistence unit.");
    }

    public static perturbation.location.PerturbationLocation __L242;

    public static perturbation.location.PerturbationLocation __L243;

    public static perturbation.location.PerturbationLocation __L244;

    public static perturbation.location.PerturbationLocation __L245;

    public static perturbation.location.PerturbationLocation __L246;

    public static perturbation.location.PerturbationLocation __L247;

    public static perturbation.location.PerturbationLocation __L248;

    public static perturbation.location.PerturbationLocation __L249;

    public static perturbation.location.PerturbationLocation __L250;

    public static perturbation.location.PerturbationLocation __L251;

    public static perturbation.location.PerturbationLocation __L252;

    public static perturbation.location.PerturbationLocation __L253;

    public static perturbation.location.PerturbationLocation __L254;

    public static perturbation.location.PerturbationLocation __L255;

    public static perturbation.location.PerturbationLocation __L256;

    public static perturbation.location.PerturbationLocation __L257;

    public static perturbation.location.PerturbationLocation __L258;

    public static perturbation.location.PerturbationLocation __L259;

    public static perturbation.location.PerturbationLocation __L260;

    public static perturbation.location.PerturbationLocation __L261;

    public static perturbation.location.PerturbationLocation __L262;

    public static perturbation.location.PerturbationLocation __L263;

    public static perturbation.location.PerturbationLocation __L264;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.HydratedSetup.__L242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:55)", 242, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:59)", 243, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:60)", 244, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:60)", 245, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:62)", 246, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:62)", 247, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:62)", 248, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:62)", 249, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:63)", 250, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:69)", 251, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:69)", 252, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:84)", 253, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:84)", 254, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:88)", 255, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:88)", 256, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:88)", 257, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:90)", 258, "Numerical");
        org.broadleafcommerce.common.cache.HydratedSetup.__L259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:92)", 259, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:98)", 260, "Numerical");
        org.broadleafcommerce.common.cache.HydratedSetup.__L261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:100)", 261, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:100)", 262, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:100)", 263, "Boolean");
        org.broadleafcommerce.common.cache.HydratedSetup.__L264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/HydratedSetup.java:126)", 264, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.HydratedSetup.initPerturbationLocation0();
    }
}

