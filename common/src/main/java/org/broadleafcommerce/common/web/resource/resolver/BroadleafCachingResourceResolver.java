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
package org.broadleafcommerce.common.web.resource.resolver;


@org.springframework.stereotype.Component("blCacheResourceResolver")
public class BroadleafCachingResourceResolver extends org.springframework.web.servlet.resource.AbstractResourceResolver implements org.springframework.core.Ordered {
    public static final java.lang.String RESOLVED_RESOURCE_CACHE_KEY_PREFIX = "resolvedResource:";

    public static final java.lang.String RESOLVED_URL_PATH_CACHE_KEY_PREFIX = "resolvedUrlPath:";

    public static final java.lang.String RESOLVED_RESOURCE_CACHE_KEY_PREFIX_NULL = "resolvedResourceNull:";

    public static final java.lang.String RESOLVED_URL_PATH_CACHE_KEY_PREFIX_NULL = "resolvedUrlPathNull:";

    private static final java.lang.Object NULL_REFERENCE = new java.lang.Object();

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_CACHE_RESOURCE_RESOLVER;

    private final org.springframework.cache.Cache cache;

    @javax.annotation.Resource(name = "blSpringCacheManager")
    private org.springframework.cache.CacheManager cacheManager;

    @javax.annotation.Resource(name = "blBroadleafContextUtil")
    protected org.broadleafcommerce.common.web.resource.BroadleafContextUtil blcContextUtil;

    private static final java.lang.String DEFAULT_CACHE_NAME = "blResourceCacheElements";

    @org.springframework.beans.factory.annotation.Value("${resource.caching.enabled:true}")
    protected boolean resourceCachingEnabled;

    @org.springframework.beans.factory.annotation.Autowired
    public BroadleafCachingResourceResolver(@org.springframework.beans.factory.annotation.Qualifier("blSpringCacheManager")
    org.springframework.cache.CacheManager cacheManager) {
        this(cacheManager.getCache(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.DEFAULT_CACHE_NAME));
    }

    public BroadleafCachingResourceResolver(org.springframework.cache.Cache cache) {
        org.springframework.util.Assert.notNull(cache, "'cache' is required");
        this.cache = cache;
    }

    public org.springframework.cache.Cache getCache() {
        return this.cache;
    }

    @java.lang.Override
    protected org.springframework.core.io.Resource resolveResourceInternal(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        blcContextUtil.establishThinRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7477, resourceCachingEnabled)) {
            java.lang.String key = (computeKey(request, requestPath)) + (getThemePathFromBRC());
            org.springframework.core.io.Resource resource = this.cache.get(key, org.springframework.core.io.Resource.class);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7480, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7478, (resource != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7479, resource.exists()))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7481, logger.isTraceEnabled())) {
                    logger.trace("Found match");
                }
                return resource;
            }
            resource = chain.resolveResource(request, requestPath, locations);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7482, (resource != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7483, logger.isTraceEnabled())) {
                    logger.trace("Putting resolved resource in cache");
                }
                this.cache.put(key, resource);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7484, logger.isDebugEnabled())) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7485, (resource == null))) {
                    logger.debug(("Cache resolver, returned a null resource " + requestPath));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7487, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7486, resource.exists()))))) {
                        logger.debug(((("Cache resolver, returned a resource that doesn't exist " + requestPath) + " - ") + resource));
                    }

            }
            return resource;
        }else {
            return chain.resolveResource(request, requestPath, locations);
        }
    }

    protected java.lang.String computeKey(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath) {
        java.lang.StringBuilder key = new java.lang.StringBuilder(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.RESOLVED_RESOURCE_CACHE_KEY_PREFIX);
        key.append(requestPath);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7488, (request != null))) {
            java.lang.String encoding = request.getHeader("Accept-Encoding");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7491, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7489, (encoding != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7490, encoding.contains("gzip")))))) {
                key.append("+encoding=gzip");
            }
        }
        return key.toString();
    }

    @java.lang.Override
    protected java.lang.String resolveUrlPathInternal(java.lang.String resourceUrlPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7492, resourceCachingEnabled)) {
            java.lang.String response = null;
            java.lang.String notFoundKey = ((org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.RESOLVED_URL_PATH_CACHE_KEY_PREFIX_NULL) + resourceUrlPath) + (getThemePathFromBRC());
            java.lang.Object nullResource = getCache().get(notFoundKey, java.lang.Object.class);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7493, (nullResource != null))) {
                logNullReferenceUrlPatchMatch(resourceUrlPath);
                return null;
            }
            java.lang.String foundKey = ((org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.RESOLVED_URL_PATH_CACHE_KEY_PREFIX) + resourceUrlPath) + (getThemePathFromBRC());
            java.lang.String resolvedUrlPath = this.cache.get(foundKey, java.lang.String.class);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7494, (resolvedUrlPath != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7495, logger.isTraceEnabled())) {
                    logger.trace("Found match");
                }
                response = resolvedUrlPath;
            }else {
                resolvedUrlPath = chain.resolveUrlPath(resourceUrlPath, locations);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7496, (resolvedUrlPath != null))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7497, logger.isTraceEnabled())) {
                        logger.trace("Putting resolved resource URL path in cache");
                    }
                    this.cache.put(foundKey, resolvedUrlPath);
                    response = resolvedUrlPath;
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7498, (response == null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7499, logger.isTraceEnabled())) {
                    logger.trace(java.lang.String.format(("Putting resolved null reference url " + "path in cache for '%s'"), resourceUrlPath));
                }
                getCache().put(notFoundKey, org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.NULL_REFERENCE);
            }
            return response;
        }else {
            return chain.resolveUrlPath(resourceUrlPath, locations);
        }
    }

    private void logNullReferenceUrlPatchMatch(java.lang.String resourceUrlPath) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7500, logger.isTraceEnabled())) {
            logger.trace(java.lang.String.format("Found null reference url path match for '%s'", resourceUrlPath));
        }
    }

    protected java.lang.String getThemePathFromBRC() {
        java.lang.String themePath = null;
        org.broadleafcommerce.common.site.domain.Theme theme = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getTheme();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7501, (theme != null))) {
            themePath = theme.getPath();
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7502, (themePath == null)) ? "" : "-" + themePath;
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7503, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7504, order);
    }

    public static perturbation.location.PerturbationLocation __L7477;

    public static perturbation.location.PerturbationLocation __L7478;

    public static perturbation.location.PerturbationLocation __L7479;

    public static perturbation.location.PerturbationLocation __L7480;

    public static perturbation.location.PerturbationLocation __L7481;

    public static perturbation.location.PerturbationLocation __L7482;

    public static perturbation.location.PerturbationLocation __L7483;

    public static perturbation.location.PerturbationLocation __L7484;

    public static perturbation.location.PerturbationLocation __L7485;

    public static perturbation.location.PerturbationLocation __L7486;

    public static perturbation.location.PerturbationLocation __L7487;

    public static perturbation.location.PerturbationLocation __L7488;

    public static perturbation.location.PerturbationLocation __L7489;

    public static perturbation.location.PerturbationLocation __L7490;

    public static perturbation.location.PerturbationLocation __L7491;

    public static perturbation.location.PerturbationLocation __L7492;

    public static perturbation.location.PerturbationLocation __L7493;

    public static perturbation.location.PerturbationLocation __L7494;

    public static perturbation.location.PerturbationLocation __L7495;

    public static perturbation.location.PerturbationLocation __L7496;

    public static perturbation.location.PerturbationLocation __L7497;

    public static perturbation.location.PerturbationLocation __L7498;

    public static perturbation.location.PerturbationLocation __L7499;

    public static perturbation.location.PerturbationLocation __L7500;

    public static perturbation.location.PerturbationLocation __L7501;

    public static perturbation.location.PerturbationLocation __L7502;

    public static perturbation.location.PerturbationLocation __L7503;

    public static perturbation.location.PerturbationLocation __L7504;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:99)", 7477, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:103)", 7478, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:103)", 7479, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:103)", 7480, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:104)", 7481, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:111)", 7482, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:112)", 7483, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:118)", 7484, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:119)", 7485, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:121)", 7486, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:121)", 7487, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:142)", 7488, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:144)", 7489, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:144)", 7490, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:144)", 7491, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:154)", 7492, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:159)", 7493, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:166)", 7494, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:167)", 7495, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:173)", 7496, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:174)", 7497, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:182)", 7498, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:183)", 7499, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:196)", 7500, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:210)", 7501, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:213)", 7502, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:218)", 7503, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.__L7504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafCachingResourceResolver.java:222)", 7504, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BroadleafCachingResourceResolver.initPerturbationLocation0();
    }
}

