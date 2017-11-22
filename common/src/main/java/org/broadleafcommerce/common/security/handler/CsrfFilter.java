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
package org.broadleafcommerce.common.security.handler;


@java.lang.Deprecated
public class CsrfFilter extends org.springframework.web.filter.GenericFilterBean {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.security.handler.CsrfFilter.class);

    @javax.annotation.Resource(name = "blExploitProtectionService")
    protected org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;

    protected java.util.List<java.lang.String> excludedRequestPatterns;

    @java.lang.Override
    public void doFilter(javax.servlet.ServletRequest baseRequest, javax.servlet.ServletResponse baseResponse, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        javax.servlet.http.HttpServletRequest request = ((javax.servlet.http.HttpServletRequest) (baseRequest));
        javax.servlet.http.HttpServletResponse response = ((javax.servlet.http.HttpServletResponse) (baseResponse));
        boolean excludedRequestFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4801, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4806, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4802, ((excludedRequestPatterns) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4805, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4803, excludedRequestPatterns.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4804, 0)))))))) {
            for (java.lang.String pattern : excludedRequestPatterns) {
                org.springframework.security.web.util.matcher.RequestMatcher matcher = new org.springframework.security.web.util.matcher.AntPathRequestMatcher(pattern);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4807, matcher.matches(request))) {
                    excludedRequestFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4808, true);
                    break;
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4812, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4809, request.getMethod().equals("POST"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4811, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.CsrfFilter.__L4810, excludedRequestFound)))))))) {
            java.lang.String requestToken = request.getParameter(exploitProtectionService.getCsrfTokenParameter());
            try {
                exploitProtectionService.compareToken(requestToken);
            } catch (org.broadleafcommerce.common.exception.ServiceException e) {
                throw new javax.servlet.ServletException(e);
            }
        }
        chain.doFilter(request, response);
    }

    public java.util.List<java.lang.String> getExcludedRequestPatterns() {
        return excludedRequestPatterns;
    }

    public void setExcludedRequestPatterns(java.util.List<java.lang.String> excludedRequestPatterns) {
        this.excludedRequestPatterns = excludedRequestPatterns;
    }

    public static perturbation.location.PerturbationLocation __L4801;

    public static perturbation.location.PerturbationLocation __L4802;

    public static perturbation.location.PerturbationLocation __L4803;

    public static perturbation.location.PerturbationLocation __L4804;

    public static perturbation.location.PerturbationLocation __L4805;

    public static perturbation.location.PerturbationLocation __L4806;

    public static perturbation.location.PerturbationLocation __L4807;

    public static perturbation.location.PerturbationLocation __L4808;

    public static perturbation.location.PerturbationLocation __L4809;

    public static perturbation.location.PerturbationLocation __L4810;

    public static perturbation.location.PerturbationLocation __L4811;

    public static perturbation.location.PerturbationLocation __L4812;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:64)", 4801, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:65)", 4802, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:65)", 4803, "Numerical");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:65)", 4804, "Numerical");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:65)", 4805, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:65)", 4806, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:68)", 4807, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:69)", 4808, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:76)", 4809, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:76)", 4810, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:76)", 4811, "Boolean");
        org.broadleafcommerce.common.security.handler.CsrfFilter.__L4812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/CsrfFilter.java:76)", 4812, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.handler.CsrfFilter.initPerturbationLocation0();
    }
}

