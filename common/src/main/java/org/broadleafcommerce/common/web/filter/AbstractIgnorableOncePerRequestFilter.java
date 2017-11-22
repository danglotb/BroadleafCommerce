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
package org.broadleafcommerce.common.web.filter;


public abstract class AbstractIgnorableOncePerRequestFilter extends org.springframework.web.filter.OncePerRequestFilter implements org.springframework.core.Ordered {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.class);

    @java.lang.Override
    public void doFilterInternal(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7224, isIgnored(httpServletRequest, httpServletResponse))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7225, org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.LOG.trace(java.lang.String.format("%s filtering is disabled for %s", this.getClass().getName(), httpServletRequest.getRequestURI()));
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7226, org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.LOG.trace(java.lang.String.format("%s filtering is enabled for %s", this.getClass().getName(), httpServletRequest.getRequestURI()));
            }
            doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);
        }
    }

    protected boolean isIgnored(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) {
        boolean isUriSecurityIgnored = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7227, org.broadleafcommerce.common.util.BLCRequestUtils.isFilteringIgnoredForUri(new org.springframework.web.context.request.ServletWebRequest(httpServletRequest, httpServletResponse)));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7228, isUriSecurityIgnored);
    }

    protected abstract void doFilterInternalUnlessIgnored(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException;

    public static perturbation.location.PerturbationLocation __L7224;

    public static perturbation.location.PerturbationLocation __L7225;

    public static perturbation.location.PerturbationLocation __L7226;

    public static perturbation.location.PerturbationLocation __L7227;

    public static perturbation.location.PerturbationLocation __L7228;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableOncePerRequestFilter.java:49)", 7224, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableOncePerRequestFilter.java:50)", 7225, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableOncePerRequestFilter.java:55)", 7226, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableOncePerRequestFilter.java:63)", 7227, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.__L7228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableOncePerRequestFilter.java:64)", 7228, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter.initPerturbationLocation0();
    }
}

