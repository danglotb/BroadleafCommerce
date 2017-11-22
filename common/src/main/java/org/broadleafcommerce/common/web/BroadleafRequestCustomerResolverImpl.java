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
package org.broadleafcommerce.common.web;


@org.springframework.stereotype.Service("blRequestCustomerResolver")
public class BroadleafRequestCustomerResolverImpl implements org.broadleafcommerce.common.web.BroadleafRequestCustomerResolver , org.springframework.context.ApplicationContextAware {
    private static org.springframework.context.ApplicationContext applicationContext;

    protected static java.lang.String customerRequestAttributeName = "customer";

    @java.lang.Override
    public java.lang.Object getCustomer(javax.servlet.http.HttpServletRequest request) {
        return getCustomer(new org.springframework.web.context.request.ServletWebRequest(request));
    }

    @java.lang.Override
    public java.lang.Object getCustomer() {
        org.springframework.web.context.request.WebRequest request = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getWebRequest();
        return getCustomer(request);
    }

    @java.lang.Override
    public java.lang.Object getCustomer(org.springframework.web.context.request.WebRequest request) {
        return request.getAttribute(getCustomerRequestAttributeName(), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.__L7842, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
    }

    @java.lang.Override
    public void setCustomer(java.lang.Object customer) {
        org.springframework.web.context.request.WebRequest request = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getWebRequest();
        request.setAttribute(getCustomerRequestAttributeName(), customer, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.__L7843, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
    }

    @java.lang.Override
    public java.lang.String getCustomerRequestAttributeName() {
        return org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.customerRequestAttributeName;
    }

    @java.lang.Override
    public void setCustomerRequestAttributeName(java.lang.String customerRequestAttributeName) {
        org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.customerRequestAttributeName = customerRequestAttributeName;
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.applicationContext = applicationContext;
    }

    public static org.broadleafcommerce.common.web.BroadleafRequestCustomerResolver getRequestCustomerResolver() {
        return ((org.broadleafcommerce.common.web.BroadleafRequestCustomerResolver) (org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.applicationContext.getBean("blRequestCustomerResolver")));
    }

    public static perturbation.location.PerturbationLocation __L7842;

    public static perturbation.location.PerturbationLocation __L7843;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.__L7842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestCustomerResolverImpl.java:54)", 7842, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.__L7843 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestCustomerResolverImpl.java:60)", 7843, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.initPerturbationLocation0();
    }
}

