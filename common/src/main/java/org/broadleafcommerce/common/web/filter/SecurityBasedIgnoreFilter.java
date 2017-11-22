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


@org.springframework.stereotype.Component("blSecurityBasedIgnoreFilter")
public class SecurityBasedIgnoreFilter extends org.springframework.web.filter.GenericFilterBean implements org.springframework.core.Ordered {
    org.springframework.security.web.FilterChainProxy springSecurity = null;

    @org.springframework.context.event.EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
    public void init(org.springframework.context.event.ContextRefreshedEvent event) {
        try {
            springSecurity = ((org.springframework.security.web.FilterChainProxy) (event.getApplicationContext().getBean("springSecurityFilterChain")));
        } catch (org.springframework.beans.BeansException e) {
        }
    }

    @java.lang.Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7237, ((springSecurity) != null))) {
            java.util.List<org.springframework.security.web.SecurityFilterChain> securityChains = springSecurity.getFilterChains();
            for (org.springframework.security.web.SecurityFilterChain chain : securityChains) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7240, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7238, chain.matches(((javax.servlet.http.HttpServletRequest) (request))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7239, chain.getFilters().isEmpty()))))) {
                    org.broadleafcommerce.common.util.BLCRequestUtils.setIsFilteringIgnoredForUri(new org.springframework.web.context.request.ServletWebRequest(((javax.servlet.http.HttpServletRequest) (request)), ((javax.servlet.http.HttpServletResponse) (response))), java.lang.Boolean.TRUE);
                    break;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7243, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7241, org.broadleafcommerce.common.web.filter.FilterOrdered.PRE_SECURITY_HIGH)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7242, 500))));
    }

    public static perturbation.location.PerturbationLocation __L7237;

    public static perturbation.location.PerturbationLocation __L7238;

    public static perturbation.location.PerturbationLocation __L7239;

    public static perturbation.location.PerturbationLocation __L7240;

    public static perturbation.location.PerturbationLocation __L7241;

    public static perturbation.location.PerturbationLocation __L7242;

    public static perturbation.location.PerturbationLocation __L7243;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:68)", 7237, "Boolean");
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:71)", 7238, "Boolean");
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:71)", 7239, "Boolean");
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:71)", 7240, "Boolean");
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:82)", 7241, "Numerical");
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:82)", 7242, "Numerical");
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.__L7243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SecurityBasedIgnoreFilter.java:82)", 7243, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.filter.SecurityBasedIgnoreFilter.initPerturbationLocation0();
    }
}

