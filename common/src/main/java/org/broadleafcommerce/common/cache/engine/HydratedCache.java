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
public class HydratedCache extends java.util.Hashtable<java.lang.String, java.lang.Object> {
    private static final long serialVersionUID = 1L;

    private java.lang.String cacheName;

    private java.lang.String cacheRegion;

    public HydratedCache(java.lang.String cacheRegion, java.lang.String cacheName) {
        this.cacheRegion = cacheRegion;
        this.cacheName = cacheName;
    }

    public java.lang.String getCacheName() {
        return cacheName;
    }

    public java.lang.String getCacheRegion() {
        return cacheRegion;
    }

    public void setCacheRegion(java.lang.String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    public org.broadleafcommerce.common.cache.engine.HydratedCacheElement getCacheElement(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable key) {
        return ((org.broadleafcommerce.common.cache.engine.HydratedCacheElement) (get(((((cacheRegion + "_") + cacheName) + "_") + key))));
    }

    public org.broadleafcommerce.common.cache.engine.HydratedCacheElement removeCacheElement(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable key) {
        java.lang.String myKey = (((cacheRegion + "_") + cacheName) + "_") + key;
        return ((org.broadleafcommerce.common.cache.engine.HydratedCacheElement) (remove(myKey)));
    }

    public void addCacheElement(java.lang.String cacheRegion, java.lang.String cacheName, java.io.Serializable key, java.lang.Object value) {
        java.lang.String myKey = (((cacheRegion + "_") + cacheName) + "_") + key;
        put(myKey, value);
    }
}

