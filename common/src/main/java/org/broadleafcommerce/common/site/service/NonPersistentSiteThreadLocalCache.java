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
package org.broadleafcommerce.common.site.service;


public class NonPersistentSiteThreadLocalCache {
    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache> SITES_CACHE = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache.class);

    protected java.util.Map<java.lang.Long, org.broadleafcommerce.common.site.domain.Site> sites = new java.util.HashMap<java.lang.Long, org.broadleafcommerce.common.site.domain.Site>();

    public static org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache getSitesCache() {
        return org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache.SITES_CACHE.get();
    }

    public static void setSitesCache(org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache sitesCache) {
        org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache.SITES_CACHE.set(sitesCache);
    }

    public java.util.Map<java.lang.Long, org.broadleafcommerce.common.site.domain.Site> getSites() {
        return sites;
    }

    public void setSites(java.util.Map<java.lang.Long, org.broadleafcommerce.common.site.domain.Site> sites) {
        this.sites = sites;
    }

    public void clear() {
        org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache.SITES_CACHE.remove();
    }
}

