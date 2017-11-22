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


public class BigMemoryHydratedCacheManagerImpl extends org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.class);

    private static final org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl MANAGER = new org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl();

    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> cacheMemberNamesByEntity = java.util.Collections.synchronizedMap(new java.util.HashMap<java.lang.String, java.util.List<java.lang.String>>(100));

    private java.util.List<java.lang.String> removeKeys = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.String>(100));

    private net.sf.ehcache.Cache offHeap = null;

    public static org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl getInstance() {
        return org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.MANAGER;
    }

    private BigMemoryHydratedCacheManagerImpl() {
    }

    private synchronized net.sf.ehcache.Cache getHeap() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L124, ((offHeap) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L125, net.sf.ehcache.CacheManager.getInstance().cacheExists("hydrated-offheap-cache"))) {
                offHeap = net.sf.ehcache.CacheManager.getInstance().getCache("hydrated-offheap-cache");
            }else {
                net.sf.ehcache.config.CacheConfiguration config = new net.sf.ehcache.config.CacheConfiguration("hydrated-offheap-cache", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L126, 500)).eternal(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L127, true)).overflowToOffHeap(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L128, true)).maxMemoryOffHeap("1400M");
                net.sf.ehcache.Cache cache = new net.sf.ehcache.Cache(config);
                net.sf.ehcache.CacheManager.create().addCache(cache);
                offHeap = cache;
            }
        }
        return offHeap;
    }

    @java.lang.Override
    public java.lang.Object getHydratedCacheElementItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName) {
        net.sf.ehcache.Element element;
        java.lang.String myKey = (((((cacheRegion + '_') + cacheName) + '_') + elementItemName) + '_') + elementKey;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L129, removeKeys.contains(myKey))) {
            return null;
        }
        java.lang.Object response = null;
        element = getHeap().get(myKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L130, (element != null))) {
            response = element.getObjectValue();
        }
        return response;
    }

    @java.lang.Override
    public void addHydratedCacheElementItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName, java.lang.Object elementValue) {
        java.lang.String heapKey = (((((cacheRegion + '_') + cacheName) + '_') + elementItemName) + '_') + elementKey;
        java.lang.String nameKey = (((cacheRegion + '_') + cacheName) + '_') + elementKey;
        removeKeys.remove(nameKey);
        net.sf.ehcache.Element element = new net.sf.ehcache.Element(heapKey, elementValue);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L132, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L131, cacheMemberNamesByEntity.containsKey(nameKey)))))) {
            java.util.List<java.lang.String> myMembers = new java.util.ArrayList<java.lang.String>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L133, 50));
            myMembers.add(elementItemName);
            cacheMemberNamesByEntity.put(nameKey, myMembers);
        }else {
            java.util.List<java.lang.String> myMembers = cacheMemberNamesByEntity.get(nameKey);
            myMembers.add(elementItemName);
        }
        getHeap().put(element);
    }

    protected void removeCache(java.lang.String cacheRegion, java.io.Serializable key) {
        java.lang.String cacheName = cacheRegion;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L134, (key instanceof org.hibernate.cache.spi.CacheKey))) {
            cacheName = ((org.hibernate.cache.spi.CacheKey) (key)).getEntityOrRoleName();
            key = ((org.hibernate.cache.spi.CacheKey) (key)).getKey();
        }
        java.lang.String nameKey = (((cacheRegion + '_') + cacheName) + '_') + key;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L135, cacheMemberNamesByEntity.containsKey(nameKey))) {
            java.lang.String[] members = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L136, cacheMemberNamesByEntity.get(nameKey).size())];
            members = cacheMemberNamesByEntity.get(nameKey).toArray(members);
            for (java.lang.String myMember : members) {
                java.lang.String itemKey = (((cacheRegion + '_') + myMember) + '_') + key;
                removeKeys.add(itemKey);
            }
            cacheMemberNamesByEntity.remove(nameKey);
        }
    }

    protected void removeAll(java.lang.String cacheName) {
    }

    @java.lang.Override
    public void notifyElementEvicted(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) {
        removeCache(arg0.getName(), arg1.getKey());
    }

    @java.lang.Override
    public void notifyElementExpired(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) {
        removeCache(arg0.getName(), arg1.getKey());
    }

    @java.lang.Override
    public void notifyElementPut(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) throws net.sf.ehcache.CacheException {
    }

    @java.lang.Override
    public void notifyElementRemoved(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) throws net.sf.ehcache.CacheException {
        removeCache(arg0.getName(), arg1.getKey());
    }

    @java.lang.Override
    public void notifyElementUpdated(net.sf.ehcache.Ehcache arg0, net.sf.ehcache.Element arg1) throws net.sf.ehcache.CacheException {
        removeCache(arg0.getName(), arg1.getKey());
    }

    @java.lang.Override
    public void notifyRemoveAll(net.sf.ehcache.Ehcache arg0) {
        removeAll(arg0.getName());
    }

    public static perturbation.location.PerturbationLocation __L124;

    public static perturbation.location.PerturbationLocation __L125;

    public static perturbation.location.PerturbationLocation __L126;

    public static perturbation.location.PerturbationLocation __L127;

    public static perturbation.location.PerturbationLocation __L128;

    public static perturbation.location.PerturbationLocation __L129;

    public static perturbation.location.PerturbationLocation __L130;

    public static perturbation.location.PerturbationLocation __L131;

    public static perturbation.location.PerturbationLocation __L132;

    public static perturbation.location.PerturbationLocation __L133;

    public static perturbation.location.PerturbationLocation __L134;

    public static perturbation.location.PerturbationLocation __L135;

    public static perturbation.location.PerturbationLocation __L136;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:60)", 124, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:61)", 125, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:64)", 126, "Numerical");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:64)", 127, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:64)", 128, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:77)", 129, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:82)", 130, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:94)", 131, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:94)", 132, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:95)", 133, "Numerical");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:107)", 134, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:112)", 135, "Boolean");
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.__L136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/BigMemoryHydratedCacheManagerImpl.java:113)", 136, "Numerical");
    }

    static {
        org.broadleafcommerce.common.cache.engine.BigMemoryHydratedCacheManagerImpl.initPerturbationLocation0();
    }
}

