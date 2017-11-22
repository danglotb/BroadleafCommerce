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


@org.springframework.core.annotation.Order(org.broadleafcommerce.common.web.filter.FilterOrdered.POST_SECURITY_MEDIUM)
public class EntityManagerFindValidationFilter extends org.springframework.web.filter.OncePerRequestFilter {
    @java.lang.Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        try {
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setInternalValidateFind(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.EntityManagerFindValidationFilter.__L7229, true));
            filterChain.doFilter(request, response);
        } finally {
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setInternalIgnoreFilters(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.EntityManagerFindValidationFilter.__L7230, false));
        }
    }

    public static perturbation.location.PerturbationLocation __L7229;

    public static perturbation.location.PerturbationLocation __L7230;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.EntityManagerFindValidationFilter.__L7229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/EntityManagerFindValidationFilter.java:57)", 7229, "Boolean");
        org.broadleafcommerce.common.web.filter.EntityManagerFindValidationFilter.__L7230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/EntityManagerFindValidationFilter.java:60)", 7230, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.filter.EntityManagerFindValidationFilter.initPerturbationLocation0();
    }
}

