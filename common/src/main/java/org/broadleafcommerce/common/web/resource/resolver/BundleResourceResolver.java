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


@org.springframework.stereotype.Component("blBundleResourceResolver")
public class BundleResourceResolver extends org.springframework.web.servlet.resource.AbstractResourceResolver implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.class);

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_BUNDLE_RESOURCE_RESOLVER;

    @javax.annotation.Resource(name = "blResourceBundlingService")
    protected org.broadleafcommerce.common.resource.service.ResourceBundlingService bundlingService;

    @java.lang.Override
    protected org.springframework.core.io.Resource resolveResourceInternal(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7521, (requestPath != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7522, isBundleFile(requestPath))) {
                org.springframework.core.io.Resource bundle = bundlingService.resolveBundleResource(requestPath);
                logTraceInformation(bundle);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7523, (bundle != null))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7525, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7524, bundle.exists()))))) {
                        bundle = bundlingService.rebuildBundledResource(requestPath);
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7526, (bundle != null))) {
                        return bundle;
                    }
                }
            }
        }
        return chain.resolveResource(request, requestPath, locations);
    }

    protected void logTraceInformation(org.springframework.core.io.Resource bundle) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7527, org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.LOG.isTraceEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7528, (bundle == null))) {
                org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.LOG.trace("Resolving bundle, bundle is null");
            }else {
                org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.LOG.trace(((("Resolving bundle, bundle is not null, bundle.exists() == " + (bundle.exists())) + " ,filename = ") + (bundle.getFilename())));
                try {
                    org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.LOG.trace(("Resolving bundle - File Path" + (bundle.getFile().getAbsolutePath())));
                } catch (java.io.IOException e) {
                    org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.LOG.error("IOException debugging bundle code", e);
                }
            }
        }
    }

    @java.lang.Override
    protected java.lang.String resolveUrlPathInternal(java.lang.String resourceUrlPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7529, (resourceUrlPath != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7530, isBundleFile(resourceUrlPath))) {
                return resourceUrlPath;
            }
        }
        return chain.resolveUrlPath(resourceUrlPath, locations);
    }

    protected boolean isBundleFile(java.lang.String requestPath) {
        boolean isBundle = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7531, bundlingService.checkForRegisteredBundleFile(requestPath));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7532, logger.isTraceEnabled())) {
            logger.trace((((("Checking isBundleFile, requestPath=\"" + requestPath) + "\" isBundle=\"") + isBundle) + "\""));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7533, isBundle);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7534, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7535, order);
    }

    public static perturbation.location.PerturbationLocation __L7521;

    public static perturbation.location.PerturbationLocation __L7522;

    public static perturbation.location.PerturbationLocation __L7523;

    public static perturbation.location.PerturbationLocation __L7524;

    public static perturbation.location.PerturbationLocation __L7525;

    public static perturbation.location.PerturbationLocation __L7526;

    public static perturbation.location.PerturbationLocation __L7527;

    public static perturbation.location.PerturbationLocation __L7528;

    public static perturbation.location.PerturbationLocation __L7529;

    public static perturbation.location.PerturbationLocation __L7530;

    public static perturbation.location.PerturbationLocation __L7531;

    public static perturbation.location.PerturbationLocation __L7532;

    public static perturbation.location.PerturbationLocation __L7533;

    public static perturbation.location.PerturbationLocation __L7534;

    public static perturbation.location.PerturbationLocation __L7535;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:57)", 7521, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:58)", 7522, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:62)", 7523, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:63)", 7524, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:63)", 7525, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:66)", 7526, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:77)", 7527, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:78)", 7528, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:95)", 7529, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:96)", 7530, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:106)", 7531, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:107)", 7532, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:110)", 7533, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:115)", 7534, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.__L7535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BundleResourceResolver.java:119)", 7535, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BundleResourceResolver.initPerturbationLocation0();
    }
}

