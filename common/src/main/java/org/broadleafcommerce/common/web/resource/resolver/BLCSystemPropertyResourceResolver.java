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


@org.springframework.stereotype.Component("blSystemPropertyJSResolver")
public class BLCSystemPropertyResourceResolver extends org.springframework.web.servlet.resource.AbstractResourceResolver implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.class);

    protected static final java.lang.String BLC_SYSTEM_PROPERTY_FILE = "BLC-system-property.js";

    protected static final java.nio.charset.Charset DEFAULT_CHARSET = java.nio.charset.Charset.forName("UTF-8");

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_SYSTEM_PROPERTY_RESOURCE_RESOLVER;

    @javax.annotation.Resource(name = "blBaseUrlResolver")
    org.broadleafcommerce.common.web.BaseUrlResolver urlResolver;

    @java.lang.Override
    protected java.lang.String resolveUrlPathInternal(java.lang.String resourceUrlPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        return chain.resolveUrlPath(resourceUrlPath, locations);
    }

    @java.lang.Override
    protected org.springframework.core.io.Resource resolveResourceInternal(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations, org.springframework.web.servlet.resource.ResourceResolverChain chain) {
        org.springframework.core.io.Resource resource = chain.resolveResource(request, requestPath, locations);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7468, requestPath.equalsIgnoreCase(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.BLC_SYSTEM_PROPERTY_FILE))) {
            try {
                resource = convertResource(resource, requestPath);
            } catch (java.io.IOException ioe) {
                org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.LOG.error(("Exception modifying " + (org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.BLC_SYSTEM_PROPERTY_FILE)), ioe);
            }
        }
        return resource;
    }

    protected org.springframework.core.io.Resource convertResource(org.springframework.core.io.Resource origResource, java.lang.String resourceFileName) throws java.io.IOException {
        byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(origResource.getInputStream());
        java.lang.String content = new java.lang.String(bytes, org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.DEFAULT_CHARSET);
        java.lang.String newContent = content;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7470, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7469, org.springframework.util.StringUtils.isEmpty(content)))))) {
            java.lang.String regexKey = "\\\"BLC_PROP:(.*)\\\"";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(regexKey);
            java.util.regex.Matcher m = p.matcher(content);
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7471, m.find())) {
                java.lang.String matchedPlaceholder = m.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7472, 0));
                java.lang.String propertyName = m.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7473, 1));
                java.lang.String propVal = org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(propertyName);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7474, (propVal == null))) {
                    propVal = "";
                }
                newContent = newContent.replaceAll(matchedPlaceholder, (('"' + propVal) + '"'));
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
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7475, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7476, order);
    }

    public static perturbation.location.PerturbationLocation __L7468;

    public static perturbation.location.PerturbationLocation __L7469;

    public static perturbation.location.PerturbationLocation __L7470;

    public static perturbation.location.PerturbationLocation __L7471;

    public static perturbation.location.PerturbationLocation __L7472;

    public static perturbation.location.PerturbationLocation __L7473;

    public static perturbation.location.PerturbationLocation __L7474;

    public static perturbation.location.PerturbationLocation __L7475;

    public static perturbation.location.PerturbationLocation __L7476;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:77)", 7468, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:93)", 7469, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:93)", 7470, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:98)", 7471, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:99)", 7472, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:100)", 7473, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:103)", 7474, "Boolean");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:122)", 7475, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.__L7476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BLCSystemPropertyResourceResolver.java:126)", 7476, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BLCSystemPropertyResourceResolver.initPerturbationLocation0();
    }
}

