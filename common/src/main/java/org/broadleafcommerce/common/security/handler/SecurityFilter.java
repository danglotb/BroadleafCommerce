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


public class SecurityFilter extends org.springframework.web.filter.GenericFilterBean {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.security.handler.SecurityFilter.class);

    @javax.annotation.Resource(name = "blStaleStateProtectionService")
    protected org.broadleafcommerce.common.security.service.StaleStateProtectionService staleStateProtectionService;

    @javax.annotation.Resource(name = "blExploitProtectionService")
    protected org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;

    protected java.util.List<java.lang.String> excludedRequestPatterns;

    @java.lang.Override
    public void doFilter(javax.servlet.ServletRequest baseRequest, javax.servlet.ServletResponse baseResponse, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        javax.servlet.http.HttpServletRequest request = ((javax.servlet.http.HttpServletRequest) (baseRequest));
        javax.servlet.http.HttpServletResponse response = ((javax.servlet.http.HttpServletResponse) (baseResponse));
        boolean excludedRequestFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4813, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4818, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4814, ((excludedRequestPatterns) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4817, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4815, excludedRequestPatterns.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4816, 0)))))))) {
            for (java.lang.String pattern : excludedRequestPatterns) {
                org.springframework.security.web.util.matcher.RequestMatcher matcher = new org.springframework.security.web.util.matcher.AntPathRequestMatcher(pattern);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4819, matcher.matches(request))) {
                    excludedRequestFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4820, true);
                    break;
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4824, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4821, request.getMethod().equals("POST"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4823, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4822, excludedRequestFound)))))))) {
            java.lang.String requestToken = request.getParameter(exploitProtectionService.getCsrfTokenParameter());
            try {
                exploitProtectionService.compareToken(requestToken);
            } catch (org.broadleafcommerce.common.exception.ServiceException e) {
                throw new javax.servlet.ServletException(e);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4825, staleStateProtectionService.isEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4829, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4826, request.getMethod().equals("POST"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4828, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.handler.SecurityFilter.__L4827, excludedRequestFound)))))))) {
                java.lang.String requestToken = request.getParameter(staleStateProtectionService.getStateVersionTokenParameter());
                try {
                    staleStateProtectionService.compareToken(requestToken);
                } catch (org.broadleafcommerce.common.security.service.StaleStateServiceException e) {
                    throw new javax.servlet.ServletException(e);
                }
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

    public static perturbation.location.PerturbationLocation __L4813;

    public static perturbation.location.PerturbationLocation __L4814;

    public static perturbation.location.PerturbationLocation __L4815;

    public static perturbation.location.PerturbationLocation __L4816;

    public static perturbation.location.PerturbationLocation __L4817;

    public static perturbation.location.PerturbationLocation __L4818;

    public static perturbation.location.PerturbationLocation __L4819;

    public static perturbation.location.PerturbationLocation __L4820;

    public static perturbation.location.PerturbationLocation __L4821;

    public static perturbation.location.PerturbationLocation __L4822;

    public static perturbation.location.PerturbationLocation __L4823;

    public static perturbation.location.PerturbationLocation __L4824;

    public static perturbation.location.PerturbationLocation __L4825;

    public static perturbation.location.PerturbationLocation __L4826;

    public static perturbation.location.PerturbationLocation __L4827;

    public static perturbation.location.PerturbationLocation __L4828;

    public static perturbation.location.PerturbationLocation __L4829;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:73)", 4813, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:74)", 4814, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:74)", 4815, "Numerical");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:74)", 4816, "Numerical");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:74)", 4817, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:74)", 4818, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:77)", 4819, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:78)", 4820, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:85)", 4821, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:85)", 4822, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:85)", 4823, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:85)", 4824, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:94)", 4825, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:97)", 4826, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:97)", 4827, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:97)", 4828, "Boolean");
        org.broadleafcommerce.common.security.handler.SecurityFilter.__L4829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/handler/SecurityFilter.java:97)", 4829, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.handler.SecurityFilter.initPerturbationLocation0();
    }
}

