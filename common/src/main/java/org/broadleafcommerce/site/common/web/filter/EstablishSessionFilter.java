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
package org.broadleafcommerce.site.common.web.filter;


@org.springframework.stereotype.Component("blEstablishSessionFilter")
public class EstablishSessionFilter extends org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter {
    @java.lang.Override
    public void doFilterUnlessIgnored(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8032, javax.servlet.http.HttpServletRequest.class.isAssignableFrom(request.getClass()))) {
            ((javax.servlet.http.HttpServletRequest) (request)).getSession();
        }
        filterChain.doFilter(request, response);
    }

    @java.lang.Override
    protected boolean isIgnored(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) {
        boolean response = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8033, super.isIgnored(httpServletRequest, httpServletResponse));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8035, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8034, response))))) {
            response = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8037, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8036, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(httpServletRequest))))));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8038, response);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8039, org.broadleafcommerce.common.web.filter.FilterOrdered.PRE_SECURITY_LOW);
    }

    public static perturbation.location.PerturbationLocation __L8032;

    public static perturbation.location.PerturbationLocation __L8033;

    public static perturbation.location.PerturbationLocation __L8034;

    public static perturbation.location.PerturbationLocation __L8035;

    public static perturbation.location.PerturbationLocation __L8036;

    public static perturbation.location.PerturbationLocation __L8037;

    public static perturbation.location.PerturbationLocation __L8038;

    public static perturbation.location.PerturbationLocation __L8039;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:42)", 8032, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:50)", 8033, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:51)", 8034, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:51)", 8035, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:53)", 8036, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:53)", 8037, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:55)", 8038, "Boolean");
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.__L8039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/site/common/web/filter/EstablishSessionFilter.java:60)", 8039, "Numerical");
    }

    static {
        org.broadleafcommerce.site.common.web.filter.EstablishSessionFilter.initPerturbationLocation0();
    }
}

