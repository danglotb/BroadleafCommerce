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


@java.lang.Deprecated
public class HydratedCacheManagerImpl implements net.sf.ehcache.event.CacheEventListener , org.broadleafcommerce.common.cache.engine.HydratedAnnotationManager , org.broadleafcommerce.common.cache.engine.HydratedCacheManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.class);

    private static final org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl MANAGER = new org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl();

    private java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydratedCache> hydratedCacheContainer = new java.util.Hashtable<java.lang.String, org.broadleafcommerce.common.cache.engine.HydratedCache>(100);

    private java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationDescriptor> hydrationDescriptors = new java.util.Hashtable<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationDescriptor>(100);

    public static org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl getInstance() {
        return org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.MANAGER;
    }

    private HydratedCacheManagerImpl() {
    }

    public void addHydratedCache(final org.broadleafcommerce.common.cache.engine.HydratedCache cache) {
        hydratedCacheContainer.put((((cache.getCacheRegion()) + "_") + (cache.getCacheName())), cache);
    }

    public org.broadleafcommerce.common.cache.engine.HydratedCache removeHydratedCache(final java.lang.String cacheRegion, final java.lang.String cacheName) {
        return hydratedCacheContainer.remove(((cacheRegion + "_") + cacheName));
    }

    public org.broadleafcommerce.common.cache.engine.HydratedCache getHydratedCache(final java.lang.String cacheRegion, final java.lang.String cacheName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L154, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L153, containsCache(cacheRegion, cacheName)))))) {
            org.broadleafcommerce.common.cache.engine.HydratedCache cache = new org.broadleafcommerce.common.cache.engine.HydratedCache(cacheRegion, cacheName);
            addHydratedCache(cache);
        }
        return hydratedCacheContainer.get(((cacheRegion + "_") + cacheName));
    }

    public boolean containsCache(java.lang.String cacheRegion, java.lang.String cacheName) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L155, hydratedCacheContainer.containsKey(((cacheRegion + "_") + cacheName)));
    }

    public org.broadleafcommerce.common.cache.engine.HydrationDescriptor getHydrationDescriptor(java.lang.Object entity) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L156, hydrationDescriptors.containsKey(entity.getClass().getName()))) {
            return hydrationDescriptors.get(entity.getClass().getName());
        }
        org.broadleafcommerce.common.cache.engine.HydrationDescriptor descriptor = new org.broadleafcommerce.common.cache.engine.HydrationDescriptor();
        java.lang.Class<?> topEntityClass = getTopEntityClass(entity);
        org.broadleafcommerce.common.cache.engine.HydrationScanner scanner = new org.broadleafcommerce.common.cache.engine.HydrationScanner(topEntityClass, entity.getClass());
        scanner.init();
        descriptor.setHydratedMutators(scanner.getCacheMutators());
        java.util.Map<java.lang.String, java.lang.reflect.Method[]> mutators = scanner.getIdMutators();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L159, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L157, mutators.size())) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L158, 1))))) {
            throw new java.lang.RuntimeException("Broadleaf Commerce Hydrated Cache currently only supports entities with a single @Id annotation.");
        }
        java.lang.reflect.Method[] singleMutators = mutators.values().iterator().next();
        descriptor.setIdMutators(singleMutators);
        java.lang.String cacheRegion = scanner.getCacheRegion();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L162, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L160, (cacheRegion == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L161, "".equals(cacheRegion)))))) {
            cacheRegion = topEntityClass.getName();
        }
        descriptor.setCacheRegion(cacheRegion);
        hydrationDescriptors.put(entity.getClass().getName(), descriptor);
        return descriptor;
    }

    public java.lang.Class<?> getTopEntityClass(java.lang.Object entity) {
        java.lang.Class<?> myClass = entity.getClass();
        java.lang.Class<?> superClass = entity.getClass().getSuperclass();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L165, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L163, (superClass != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L164, superClass.getName().startsWith("org.broadleaf")))))) {
            myClass = superClass;
            superClass = superClass.getSuperclass();
        } 
        return myClass;
    }

    public java.lang.Object getHydratedCacheElementItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName) {
        java.lang.Object response = null;
        org.broadleafcommerce.common.cache.engine.HydratedCache hydratedCache = getHydratedCache(cacheRegion, cacheName);
        org.broadleafcommerce.common.cache.engine.HydratedCacheElement element = hydratedCache.getCacheElement(cacheRegion, cacheName, elementKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L166, (element != null))) {
            response = element.getCacheElementItem(elementItemName, elementKey);
        }
        return response;
    }

    public void addHydratedCacheElementItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName, java.lang.Object elementValue) {
        org.broadleafcommerce.common.cache.engine.HydratedCache hydratedCache = getHydratedCache(cacheRegion, cacheName);
        org.broadleafcommerce.common.cache.engine.HydratedCacheElement element = hydratedCache.getCacheElement(cacheRegion, cacheName, elementKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L167, (element == null))) {
            element = new org.broadleafcommerce.common.cache.engine.HydratedCacheElement();
            hydratedCache.addCacheElement(cacheRegion, cacheName, elementKey, element);
        }
        element.putCacheElementItem(elementItemName, elementKey, elementValue);
    }

    public void dispose() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L168, org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.LOG.isInfoEnabled())) {
            org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.LOG.info("Disposing of all hydrated cache members");
        }
        hydratedCacheContainer.clear();
    }

    private void removeCache(java.lang.String cacheRegion, java.io.Serializable key) {
        java.lang.String cacheName = cacheRegion;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L169, (key instanceof org.hibernate.cache.spi.CacheKey))) {
            cacheName = ((org.hibernate.cache.spi.CacheKey) (key)).getEntityOrRoleName();
            key = ((org.hibernate.cache.spi.CacheKey) (key)).getKey();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L170, containsCache(cacheRegion, cacheName))) {
            org.broadleafcommerce.common.cache.engine.HydratedCache cache = hydratedCacheContainer.get(((cacheRegion + "_") + cacheName));
            java.lang.String myKey = (((cacheRegion + "_") + cacheName) + "_") + key;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L171, cache.containsKey(myKey))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L172, org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.LOG.isInfoEnabled())) {
                    org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.LOG.info(((((("Clearing hydrated cache for cache name: " + cacheRegion) + "_") + cacheName) + "_") + key));
                }
                cache.removeCacheElement(cacheRegion, cacheName, key);
            }
        }
    }

    private void removeAll(java.lang.String cacheName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L173, hydratedCacheContainer.containsKey(cacheName))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L174, org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.LOG.isInfoEnabled())) {
                org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.LOG.info(("Clearing all hydrated caches for cache name: " + cacheName));
            }
            hydratedCacheContainer.remove(cacheName);
        }
    }

    public void notifyElementEvicted(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) {
        removeCache(arg0.getName(), arg1.getKey());
    }

    public void notifyElementExpired(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) {
        removeCache(arg0.getName(), arg1.getKey());
    }

    public void notifyElementPut(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) throws net.sf.ehcache.CacheException {
    }

    public void notifyElementRemoved(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) throws net.sf.ehcache.CacheException {
        removeCache(arg0.getName(), arg1.getKey());
    }

    public void notifyElementUpdated(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) throws net.sf.ehcache.CacheException {
        removeCache(arg0.getName(), arg1.getKey());
    }

    public void notifyRemoveAll(net.sf.ehcache.Ehcache arg0) {
        removeAll(arg0.getName());
    }

    @java.lang.Override
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return this;
    }

    public static perturbation.location.PerturbationLocation __L153;

    public static perturbation.location.PerturbationLocation __L154;

    public static perturbation.location.PerturbationLocation __L155;

    public static perturbation.location.PerturbationLocation __L156;

    public static perturbation.location.PerturbationLocation __L157;

    public static perturbation.location.PerturbationLocation __L158;

    public static perturbation.location.PerturbationLocation __L159;

    public static perturbation.location.PerturbationLocation __L160;

    public static perturbation.location.PerturbationLocation __L161;

    public static perturbation.location.PerturbationLocation __L162;

    public static perturbation.location.PerturbationLocation __L163;

    public static perturbation.location.PerturbationLocation __L164;

    public static perturbation.location.PerturbationLocation __L165;

    public static perturbation.location.PerturbationLocation __L166;

    public static perturbation.location.PerturbationLocation __L167;

    public static perturbation.location.PerturbationLocation __L168;

    public static perturbation.location.PerturbationLocation __L169;

    public static perturbation.location.PerturbationLocation __L170;

    public static perturbation.location.PerturbationLocation __L171;

    public static perturbation.location.PerturbationLocation __L172;

    public static perturbation.location.PerturbationLocation __L173;

    public static perturbation.location.PerturbationLocation __L174;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:62)", 153, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:62)", 154, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:70)", 155, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:74)", 156, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:83)", 157, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:83)", 158, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:83)", 159, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:89)", 160, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:89)", 161, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:89)", 162, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:100)", 163, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:100)", 164, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:100)", 165, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:111)", 166, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:120)", 167, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:128)", 168, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:136)", 169, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:140)", 170, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:143)", 171, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:144)", 172, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:153)", 173, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.__L174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheManagerImpl.java:154)", 174, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.engine.HydratedCacheManagerImpl.initPerturbationLocation0();
    }
}

