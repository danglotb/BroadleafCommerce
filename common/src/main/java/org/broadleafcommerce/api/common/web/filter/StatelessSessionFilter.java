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
package org.broadleafcommerce.api.common.web.filter;


@org.springframework.stereotype.Component("blStatelessSessionFilter")
public class StatelessSessionFilter extends org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter {
    @java.lang.Override
    public void doFilterUnlessIgnored(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        org.broadleafcommerce.common.util.BLCRequestUtils.setOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(((javax.servlet.http.HttpServletRequest) (request)), ((javax.servlet.http.HttpServletResponse) (response))), java.lang.Boolean.FALSE);
        org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper wrapper = new org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper(((javax.servlet.http.HttpServletRequest) (request)));
        filterChain.doFilter(wrapper, response);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.api.common.web.filter.StatelessSessionFilter.__L0, org.broadleafcommerce.common.web.filter.FilterOrdered.PRE_SECURITY_HIGH);
    }

    public static perturbation.location.PerturbationLocation __L0;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.api.common.web.filter.StatelessSessionFilter.__L0 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/api/common/web/filter/StatelessSessionFilter.java:55)", 0, "Numerical");
    }

    static {
        org.broadleafcommerce.api.common.web.filter.StatelessSessionFilter.initPerturbationLocation0();
    }
}

