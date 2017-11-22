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


public class EhcacheHydratedCacheManagerImpl extends org.broadleafcommerce.common.cache.engine.AbstractHydratedCacheManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.class);

    private static final org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl MANAGER = new org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl();

    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> cacheMembersByEntity = java.util.Collections.synchronizedMap(new java.util.HashMap<java.lang.String, java.util.List<java.lang.String>>(100));

    private net.sf.ehcache.Cache heap = null;

    public static org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl getInstance() {
        return org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.MANAGER;
    }

    private EhcacheHydratedCacheManagerImpl() {
    }

    private synchronized net.sf.ehcache.Cache getHeap() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L137, ((heap) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L138, net.sf.ehcache.CacheManager.getInstance().cacheExists("hydrated-cache"))) {
                heap = net.sf.ehcache.CacheManager.getInstance().getCache("hydrated-cache");
            }else {
                net.sf.ehcache.config.CacheConfiguration config = new net.sf.ehcache.config.CacheConfiguration("hydrated-cache", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L139, 0)).eternal(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L140, true)).overflowToDisk(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L141, false)).maxElementsInMemory(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L142, 100000));
                net.sf.ehcache.Cache cache = new net.sf.ehcache.Cache(config);
                net.sf.ehcache.CacheManager.create().addCache(cache);
                heap = cache;
            }
        }
        return heap;
    }

    @java.lang.Override
    public java.lang.Object getHydratedCacheElementItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName) {
        java.lang.Object response = null;
        net.sf.ehcache.Element element;
        java.lang.String myKey = (((((cacheRegion + '_') + cacheName) + '_') + elementItemName) + '_') + elementKey;
        element = getHeap().get(myKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L143, (element != null))) {
            response = element.getObjectValue();
        }
        return response;
    }

    @java.lang.Override
    public void addHydratedCacheElementItem(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable elementKey, java.lang.String elementItemName, java.lang.Object elementValue) {
        java.lang.String heapKey = (((((cacheRegion + '_') + cacheName) + '_') + elementItemName) + '_') + elementKey;
        java.lang.String nameKey = (((cacheRegion + '_') + cacheName) + '_') + elementKey;
        net.sf.ehcache.Element element = new net.sf.ehcache.Element(heapKey, elementValue);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L145, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L144, cacheMembersByEntity.containsKey(nameKey)))))) {
            java.util.List<java.lang.String> myMembers = new java.util.ArrayList<java.lang.String>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L146, 50));
            myMembers.add(elementItemName);
            cacheMembersByEntity.put(nameKey, myMembers);
        }else {
            java.util.List<java.lang.String> myMembers = cacheMembersByEntity.get(nameKey);
            myMembers.add(elementItemName);
        }
        getHeap().put(element);
    }

    protected void removeCache(java.lang.String cacheRegion, java.io.Serializable key) {
        java.lang.String cacheName = cacheRegion;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L147, (key instanceof org.hibernate.cache.spi.CacheKey))) {
            cacheName = ((org.hibernate.cache.spi.CacheKey) (key)).getEntityOrRoleName();
            key = ((org.hibernate.cache.spi.CacheKey) (key)).getKey();
        }
        java.lang.String nameKey = (((cacheRegion + '_') + cacheName) + '_') + key;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L148, cacheMembersByEntity.containsKey(nameKey))) {
            java.lang.String[] members = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L149, cacheMembersByEntity.get(nameKey).size())];
            members = cacheMembersByEntity.get(nameKey).toArray(members);
            for (java.lang.String myMember : members) {
                java.lang.String itemKey = (((((cacheRegion + '_') + cacheName) + '_') + myMember) + '_') + key;
                getHeap().remove(itemKey);
            }
            cacheMembersByEntity.remove(nameKey);
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

    public static perturbation.location.PerturbationLocation __L137;

    public static perturbation.location.PerturbationLocation __L138;

    public static perturbation.location.PerturbationLocation __L139;

    public static perturbation.location.PerturbationLocation __L140;

    public static perturbation.location.PerturbationLocation __L141;

    public static perturbation.location.PerturbationLocation __L142;

    public static perturbation.location.PerturbationLocation __L143;

    public static perturbation.location.PerturbationLocation __L144;

    public static perturbation.location.PerturbationLocation __L145;

    public static perturbation.location.PerturbationLocation __L146;

    public static perturbation.location.PerturbationLocation __L147;

    public static perturbation.location.PerturbationLocation __L148;

    public static perturbation.location.PerturbationLocation __L149;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:59)", 137, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:60)", 138, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:63)", 139, "Numerical");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:63)", 140, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:63)", 141, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:63)", 142, "Numerical");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:78)", 143, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:89)", 144, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:89)", 145, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:90)", 146, "Numerical");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:102)", 147, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:107)", 148, "Boolean");
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.__L149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/EhcacheHydratedCacheManagerImpl.java:108)", 149, "Numerical");
    }

    static {
        org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.initPerturbationLocation0();
    }
}

