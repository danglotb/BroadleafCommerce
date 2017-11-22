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
package org.broadleafcommerce.common.web.resource.transformer;


@org.springframework.stereotype.Component("blCachingResourceTransformer")
public class BroadleafCachingResourceTransformer extends org.springframework.web.servlet.resource.CachingResourceTransformer implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.class);

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceTransformerOrder.BLC_CACHE_RESOURCE_TRANSFORMER;

    @javax.annotation.Resource(name = "blSpringCacheManager")
    private org.springframework.cache.CacheManager cacheManager;

    private static final java.lang.String DEFAULT_CACHE_NAME = "blResourceTransformerCacheElements";

    @org.springframework.beans.factory.annotation.Value("${resource.transformer.caching.enabled:true}")
    protected boolean resourceTransformerCachingEnabled;

    @org.springframework.beans.factory.annotation.Autowired
    public BroadleafCachingResourceTransformer(@org.springframework.beans.factory.annotation.Qualifier("blSpringCacheManager")
    org.springframework.cache.CacheManager cacheManager) {
        super(cacheManager, org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.DEFAULT_CACHE_NAME);
    }

    public BroadleafCachingResourceTransformer(org.springframework.cache.Cache cache) {
        super(cache);
    }

    @java.lang.Override
    public org.springframework.core.io.Resource transform(javax.servlet.http.HttpServletRequest request, org.springframework.core.io.Resource resource, org.springframework.web.servlet.resource.ResourceTransformerChain transformerChain) throws java.io.IOException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.__L7536, resourceTransformerCachingEnabled)) {
            return super.transform(request, resource, transformerChain);
        }else {
            return transformerChain.transform(request, resource);
        }
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.__L7537, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.__L7538, order);
    }

    public static perturbation.location.PerturbationLocation __L7536;

    public static perturbation.location.PerturbationLocation __L7537;

    public static perturbation.location.PerturbationLocation __L7538;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.__L7536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/transformer/BroadleafCachingResourceTransformer.java:75)", 7536, "Boolean");
        org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.__L7537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/transformer/BroadleafCachingResourceTransformer.java:84)", 7537, "Numerical");
        org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.__L7538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/transformer/BroadleafCachingResourceTransformer.java:88)", 7538, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.transformer.BroadleafCachingResourceTransformer.initPerturbationLocation0();
    }
}

