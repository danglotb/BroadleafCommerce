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


@org.springframework.stereotype.Component("blTranslationFilter")
@org.broadleafcommerce.common.admin.condition.ConditionalOnNotAdmin
public class TranslationFilter extends org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter {
    @org.springframework.beans.factory.annotation.Autowired
    @org.springframework.beans.factory.annotation.Qualifier("blTranslationRequestProcessor")
    protected org.broadleafcommerce.common.web.filter.TranslationRequestProcessor translationRequestProcessor;

    @java.lang.Override
    public void doFilterUnlessIgnored(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        try {
            translationRequestProcessor.process(new org.springframework.web.context.request.ServletWebRequest(((javax.servlet.http.HttpServletRequest) (request)), ((javax.servlet.http.HttpServletResponse) (response))));
            filterChain.doFilter(request, response);
        } finally {
            translationRequestProcessor.postProcess(new org.springframework.web.context.request.ServletWebRequest(((javax.servlet.http.HttpServletRequest) (request)), ((javax.servlet.http.HttpServletResponse) (response))));
        }
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.filter.TranslationFilter.__L7246, org.broadleafcommerce.common.web.filter.FilterOrdered.POST_SECURITY_LOW);
    }

    public static perturbation.location.PerturbationLocation __L7246;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.TranslationFilter.__L7246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/TranslationFilter.java:61)", 7246, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.filter.TranslationFilter.initPerturbationLocation0();
    }
}

