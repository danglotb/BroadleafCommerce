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


public class IgnorableOpenEntityManagerInViewFilter extends org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter implements org.springframework.core.Ordered {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.class);

    @java.lang.Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7231, isIgnored(request, response))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7232, org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.LOG.trace(java.lang.String.format("%s filtering is disabled for %s", this.getClass().getName(), request.getRequestURI()));
            }
            filterChain.doFilter(request, response);
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7233, org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.LOG.trace(java.lang.String.format("%s filtering is enabled for %s", this.getClass().getName(), request.getRequestURI()));
            }
            super.doFilterInternal(request, response, filterChain);
        }
    }

    protected boolean isIgnored(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) {
        boolean isUriSecurityIgnored = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7234, org.broadleafcommerce.common.util.BLCRequestUtils.isFilteringIgnoredForUri(new org.springframework.web.context.request.ServletWebRequest(httpServletRequest, httpServletResponse)));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7235, isUriSecurityIgnored);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7236, org.broadleafcommerce.common.web.filter.FilterOrdered.PRE_SECURITY_HIGH);
    }

    public static perturbation.location.PerturbationLocation __L7231;

    public static perturbation.location.PerturbationLocation __L7232;

    public static perturbation.location.PerturbationLocation __L7233;

    public static perturbation.location.PerturbationLocation __L7234;

    public static perturbation.location.PerturbationLocation __L7235;

    public static perturbation.location.PerturbationLocation __L7236;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/IgnorableOpenEntityManagerInViewFilter.java:45)", 7231, "Boolean");
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/IgnorableOpenEntityManagerInViewFilter.java:46)", 7232, "Boolean");
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/IgnorableOpenEntityManagerInViewFilter.java:51)", 7233, "Boolean");
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/IgnorableOpenEntityManagerInViewFilter.java:59)", 7234, "Boolean");
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/IgnorableOpenEntityManagerInViewFilter.java:60)", 7235, "Boolean");
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.__L7236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/IgnorableOpenEntityManagerInViewFilter.java:65)", 7236, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.initPerturbationLocation0();
    }
}

