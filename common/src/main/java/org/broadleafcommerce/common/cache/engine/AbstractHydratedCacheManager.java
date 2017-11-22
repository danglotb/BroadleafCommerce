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
package org.broadleafcommerce.common.cache.engine;


public abstract class AbstractHydratedCacheManager implements net.sf.ehcache.event.CacheEventListener , org.broadleafcommerce.common.cache.engine.HydratedAnnotationManager , org.broadleafcommerce.common.cache.engine.HydratedCacheManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.class);

    private java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationDescriptor> hydrationDescriptors = java.util.Collections.synchronizedMap(new java.util.HashMap(100));

    @java.lang.Override
    public org.broadleafcommerce.common.cache.engine.HydrationDescriptor getHydrationDescriptor(java.lang.Object entity) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L113, hydrationDescriptors.containsKey(entity.getClass().getName()))) {
            return hydrationDescriptors.get(entity.getClass().getName());
        }
        org.broadleafcommerce.common.cache.engine.HydrationDescriptor descriptor = new org.broadleafcommerce.common.cache.engine.HydrationDescriptor();
        java.lang.Class<?> topEntityClass = getTopEntityClass(entity);
        org.broadleafcommerce.common.cache.engine.HydrationScanner scanner = new org.broadleafcommerce.common.cache.engine.HydrationScanner(topEntityClass, entity.getClass());
        scanner.init();
        descriptor.setHydratedMutators(scanner.getCacheMutators());
        java.util.Map<java.lang.String, java.lang.reflect.Method[]> mutators = scanner.getIdMutators();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L116, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L114, mutators.size())) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L115, 1))))) {
            throw new java.lang.RuntimeException("Broadleaf Commerce Hydrated Cache currently only supports entities with a single @Id annotation.");
        }
        java.lang.reflect.Method[] singleMutators = mutators.values().iterator().next();
        descriptor.setIdMutators(singleMutators);
        java.lang.String cacheRegion = scanner.getCacheRegion();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L119, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L117, (cacheRegion == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L118, "".equals(cacheRegion)))))) {
            cacheRegion = topEntityClass.getName();
        }
        descriptor.setCacheRegion(cacheRegion);
        hydrationDescriptors.put(entity.getClass().getName(), descriptor);
        return descriptor;
    }

    protected java.lang.Class<?> getTopEntityClass(java.lang.Object entity) {
        java.lang.Class<?> myClass = entity.getClass();
        java.lang.Class<?> superClass = entity.getClass().getSuperclass();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L122, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L120, (superClass != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L121, superClass.getName().startsWith("org.broadleaf")))))) {
            myClass = superClass;
            superClass = superClass.getSuperclass();
        } 
        return myClass;
    }

    @java.lang.Override
    public void dispose() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L123, org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.LOG.isInfoEnabled())) {
            org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.LOG.info("Disposing of all hydrated cache members");
        }
        hydrationDescriptors.clear();
    }

    @java.lang.Override
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return this;
    }

    public static perturbation.location.PerturbationLocation __L113;

    public static perturbation.location.PerturbationLocation __L114;

    public static perturbation.location.PerturbationLocation __L115;

    public static perturbation.location.PerturbationLocation __L116;

    public static perturbation.location.PerturbationLocation __L117;

    public static perturbation.location.PerturbationLocation __L118;

    public static perturbation.location.PerturbationLocation __L119;

    public static perturbation.location.PerturbationLocation __L120;

    public static perturbation.location.PerturbationLocation __L121;

    public static perturbation.location.PerturbationLocation __L122;

    public static perturbation.location.PerturbationLocation __L123;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:40)", 113, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:49)", 114, "Numerical");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:49)", 115, "Numerical");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:49)", 116, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:55)", 117, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:55)", 118, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:55)", 119, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:66)", 120, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:66)", 121, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:66)", 122, "Boolean");
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.__L123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/AbstractHydratedCacheManager.java:75)", 123, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager.initPerturbationLocation0();
    }
}

