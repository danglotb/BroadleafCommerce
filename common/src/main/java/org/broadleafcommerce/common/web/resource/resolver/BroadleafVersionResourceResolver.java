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


@org.springframework.stereotype.Component("blVersionResourceResolver")
public class BroadleafVersionResourceResolver extends org.springframework.web.servlet.resource.VersionResourceResolver implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.class);

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_VERSION_RESOURCE_RESOLVER;

    @org.springframework.beans.factory.annotation.Value("${resource.versioning.enabled:true}")
    protected boolean resourceVersioningEnabled;

    @javax.annotation.Resource(name = "blResourceBundlingService")
    protected org.broadleafcommerce.common.resource.service.ResourceBundlingService bundlingService;

    @javax.annotation.Resource(name = "blVersionResourceResolverStrategyMap")
    protected java.util.Map<java.lang.String, org.springframework.web.servlet.resource.VersionStrategy> versionStrategyMap;

    @java.lang.Override
    protected org.springframework.core.io.Resource resolveResourceInternal(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7510, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7507, resourceVersioningEnabled)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7509, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7508, bundlingService.checkForRegisteredBundleFile(requestPath))))))))) {
            return super.resolveResourceInternal(request, requestPath, locations, chain);
        }else {
            return chain.resolveResource(request, requestPath, locations);
        }
    }

    @java.lang.Override
    protected java.lang.String resolveUrlPathInternal(java.lang.String resourceUrlPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7514, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7511, resourceVersioningEnabled)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7513, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7512, bundlingService.checkForRegisteredBundleFile(resourceUrlPath))))))))) {
            java.lang.String result = super.resolveUrlPathInternal(resourceUrlPath, locations, chain);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7515, (result == null))) {
                return chain.resolveUrlPath(resourceUrlPath, locations);
            }else {
                return result;
            }
        }else {
            return chain.resolveUrlPath(resourceUrlPath, locations);
        }
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7516, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7517, order);
    }

    @javax.annotation.PostConstruct
    public void initIt() throws java.lang.Exception {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7520, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7518, ((getStrategyMap()) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7519, getStrategyMap().isEmpty()))))) {
            setStrategyMap(versionStrategyMap);
        }
    }

    public static perturbation.location.PerturbationLocation __L7507;

    public static perturbation.location.PerturbationLocation __L7508;

    public static perturbation.location.PerturbationLocation __L7509;

    public static perturbation.location.PerturbationLocation __L7510;

    public static perturbation.location.PerturbationLocation __L7511;

    public static perturbation.location.PerturbationLocation __L7512;

    public static perturbation.location.PerturbationLocation __L7513;

    public static perturbation.location.PerturbationLocation __L7514;

    public static perturbation.location.PerturbationLocation __L7515;

    public static perturbation.location.PerturbationLocation __L7516;

    public static perturbation.location.PerturbationLocation __L7517;

    public static perturbation.location.PerturbationLocation __L7518;

    public static perturbation.location.PerturbationLocation __L7519;

    public static perturbation.location.PerturbationLocation __L7520;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:68)", 7507, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:68)", 7508, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:68)", 7509, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:68)", 7510, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:78)", 7511, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:78)", 7512, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:78)", 7513, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:78)", 7514, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:83)", 7515, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:95)", 7516, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:99)", 7517, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:104)", 7518, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:104)", 7519, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.__L7520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafVersionResourceResolver.java:104)", 7520, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BroadleafVersionResourceResolver.initPerturbationLocation0();
    }
}

