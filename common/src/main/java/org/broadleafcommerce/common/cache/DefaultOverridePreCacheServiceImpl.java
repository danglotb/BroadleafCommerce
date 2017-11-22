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


@org.springframework.stereotype.Service("blOverridePreCacheService")
public class DefaultOverridePreCacheServiceImpl implements org.broadleafcommerce.common.cache.OverridePreCacheService {
    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem> findElements(java.lang.String... cacheKeys) {
        return null;
    }

    @java.lang.Override
    public boolean isActiveForType(java.lang.String type) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.DefaultOverridePreCacheServiceImpl.__L240, false);
    }

    @java.lang.Override
    public boolean isActiveIsolatedSiteForType(java.lang.Long siteId, java.lang.String entityType) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.DefaultOverridePreCacheServiceImpl.__L241, false);
    }

    @java.lang.Override
    public void groomCacheBySiteOverride(java.lang.String entityType, java.lang.Long cloneId, boolean isRemove) {
    }

    @java.lang.Override
    public void groomCacheByTargetEntity(java.lang.String entityType, java.io.Serializable id) {
    }

    @java.lang.Override
    public void refreshCache() {
    }

    public static perturbation.location.PerturbationLocation __L240;

    public static perturbation.location.PerturbationLocation __L241;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.DefaultOverridePreCacheServiceImpl.__L240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/DefaultOverridePreCacheServiceImpl.java:41)", 240, "Boolean");
        org.broadleafcommerce.common.cache.DefaultOverridePreCacheServiceImpl.__L241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/DefaultOverridePreCacheServiceImpl.java:46)", 241, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.DefaultOverridePreCacheServiceImpl.initPerturbationLocation0();
    }
}

