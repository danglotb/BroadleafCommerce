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


@org.springframework.stereotype.Component("blBLCJSUrlPathResolver")
public class BLCJSUrlPathResolver extends org.springframework.web.servlet.resource.AbstractResourceResolver implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.class);

    private static final java.lang.String BLC_JS_NAME = "BLC.js";

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_JS_PATH_RESOLVER;

    @java.lang.Override
    protected java.lang.String resolveUrlPathInternal(java.lang.String resourceUrlPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7462, resourceUrlPath.contains(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.BLC_JS_NAME))) {
            org.broadleafcommerce.common.site.domain.Site site = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getNonPersistentSite();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7465, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7463, (site != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7464, ((site.getId()) != null)))))) {
                return addVersion(resourceUrlPath, ("-" + (site.getId())));
            }else {
                return resourceUrlPath;
            }
        }
        return chain.resolveUrlPath(resourceUrlPath, locations);
    }

    @java.lang.Override
    protected org.springframework.core.io.Resource resolveResourceInternal(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        return chain.resolveResource(request, requestPath, locations);
    }

    protected java.lang.String addVersion(java.lang.String requestPath, java.lang.String version) {
        java.lang.String baseFilename = org.springframework.util.StringUtils.stripFilenameExtension(requestPath);
        java.lang.String extension = org.springframework.util.StringUtils.getFilenameExtension(requestPath);
        return ((baseFilename + version) + ".") + extension;
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7466, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7467, order);
    }

    public static perturbation.location.PerturbationLocation __L7462;

    public static perturbation.location.PerturbationLocation __L7463;

    public static perturbation.location.PerturbationLocation __L7464;

    public static perturbation.location.PerturbationLocation __L7465;

    public static perturbation.location.PerturbationLocation __L7466;

    public static perturbation.location.PerturbationLocation __L7467;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSUrlPathResolver.java:64)", 7462, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSUrlPathResolver.java:66)", 7463, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSUrlPathResolver.java:66)", 7464, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSUrlPathResolver.java:66)", 7465, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSUrlPathResolver.java:89)", 7466, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.__L7467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSUrlPathResolver.java:93)", 7467, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BLCJSUrlPathResolver.initPerturbationLocation0();
    }
}

