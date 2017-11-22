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


@org.springframework.stereotype.Component("blBLCJSResolver")
public class BLCJSResourceResolver extends org.springframework.web.servlet.resource.AbstractResourceResolver implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.class);

    private static final java.lang.String BLC_JS_NAME = "BLC.js";

    protected static final java.nio.charset.Charset DEFAULT_CHARSET = java.nio.charset.Charset.forName("UTF-8");

    @javax.annotation.Resource(name = "blBaseUrlResolver")
    org.broadleafcommerce.common.web.BaseUrlResolver urlResolver;

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_JS_RESOURCE_RESOLVER;

    protected static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(\\S*)BLC((\\S{0})|([-]{1,2}[0-9]+)|([-]{1,2}[0-9]+(-[0-9]+)+)).js");

    @java.lang.Override
    protected java.lang.String resolveUrlPathInternal(java.lang.String resourceUrlPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        return chain.resolveUrlPath(resourceUrlPath, locations);
    }

    @java.lang.Override
    protected org.springframework.core.io.Resource resolveResourceInternal(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7451, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7449, (requestPath != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7450, requestPath.contains("BLC")))))) {
            java.util.regex.Matcher matcher = org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.pattern.matcher(requestPath);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7452, matcher.find())) {
                requestPath = (matcher.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7453, 1))) + "BLC.js";
                org.springframework.core.io.Resource resource = chain.resolveResource(request, "BLC.js", locations);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7454, (resource == null))) {
                    requestPath = (matcher.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7455, 1))) + "BLC.js";
                    resource = chain.resolveResource(request, requestPath, locations);
                }
                try {
                    resource = convertResource(resource, requestPath);
                } catch (java.io.IOException ioe) {
                    org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.LOG.error(("Exception modifying " + (org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.BLC_JS_NAME)), ioe);
                }
                return resource;
            }
        }
        return chain.resolveResource(request, requestPath, locations);
    }

    protected org.springframework.core.io.Resource convertResource(org.springframework.core.io.Resource origResource, java.lang.String resourceFileName) throws java.io.IOException {
        byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(origResource.getInputStream());
        java.lang.String content = new java.lang.String(bytes, org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.DEFAULT_CHARSET);
        java.lang.String newContent = content;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7457, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7456, org.springframework.util.StringUtils.isEmpty(content)))))) {
            javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
            newContent = newContent.replace("//BLC-SERVLET-CONTEXT", request.getContextPath());
            java.lang.String siteBaseUrl = urlResolver.getSiteBaseUrl();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7459, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7458, org.springframework.util.StringUtils.isEmpty(siteBaseUrl)))))) {
                newContent = newContent.replace("//BLC-SITE-BASEURL", siteBaseUrl);
            }
        }
        return new org.broadleafcommerce.common.resource.GeneratedResource(newContent.getBytes(), resourceFileName);
    }

    protected java.lang.String addVersion(java.lang.String requestPath, java.lang.String version) {
        java.lang.String baseFilename = org.springframework.util.StringUtils.stripFilenameExtension(requestPath);
        java.lang.String extension = org.springframework.util.StringUtils.getFilenameExtension(requestPath);
        return ((baseFilename + version) + ".") + extension;
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7460, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7461, order);
    }

    public static perturbation.location.PerturbationLocation __L7449;

    public static perturbation.location.PerturbationLocation __L7450;

    public static perturbation.location.PerturbationLocation __L7451;

    public static perturbation.location.PerturbationLocation __L7452;

    public static perturbation.location.PerturbationLocation __L7453;

    public static perturbation.location.PerturbationLocation __L7454;

    public static perturbation.location.PerturbationLocation __L7455;

    public static perturbation.location.PerturbationLocation __L7456;

    public static perturbation.location.PerturbationLocation __L7457;

    public static perturbation.location.PerturbationLocation __L7458;

    public static perturbation.location.PerturbationLocation __L7459;

    public static perturbation.location.PerturbationLocation __L7460;

    public static perturbation.location.PerturbationLocation __L7461;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:81)", 7449, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:81)", 7450, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:81)", 7451, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:83)", 7452, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:84)", 7453, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:86)", 7454, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:87)", 7455, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:107)", 7456, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:107)", 7457, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:112)", 7458, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:112)", 7459, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:128)", 7460, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.__L7461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCJSResourceResolver.java:132)", 7461, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver.initPerturbationLocation0();
    }
}

