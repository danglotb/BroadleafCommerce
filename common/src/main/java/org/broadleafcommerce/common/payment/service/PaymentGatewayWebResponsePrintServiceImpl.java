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
package org.broadleafcommerce.common.payment.service;


@org.springframework.stereotype.Service("blPaymentGatewayWebResponsePrintService")
public class PaymentGatewayWebResponsePrintServiceImpl implements org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintService {
    public static final java.lang.String REQUEST_ATTRIBUTES = "attributes";

    public static final java.lang.String REQUEST_PARAMETERS = "parameters";

    @java.lang.Override
    public java.lang.String printRequest(javax.servlet.http.HttpServletRequest request) {
        java.lang.StringBuilder builder = new java.lang.StringBuilder();
        java.util.Enumeration enAttr = request.getAttributeNames();
        builder.append("{");
        builder.append(((("\"" + (org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.REQUEST_ATTRIBUTES)) + "\"") + ": {"));
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3852, enAttr.hasMoreElements())) {
            java.lang.String attributeName = ((java.lang.String) (enAttr.nextElement()));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3853, ((request.getAttribute(attributeName)) instanceof java.lang.String))) {
                builder.append("\"");
                builder.append(attributeName);
                builder.append("\"");
                builder.append(":");
                builder.append("\"");
                builder.append(request.getAttribute(attributeName).toString());
                builder.append("\"");
                builder.append(",");
            }
        } 
        builder.deleteCharAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3854, builder.lastIndexOf(",")));
        builder.append("},");
        builder.append(((("\"" + (org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.REQUEST_PARAMETERS)) + "\"") + ": {"));
        java.util.Enumeration enParams = request.getParameterNames();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3855, enParams.hasMoreElements())) {
            java.lang.String paramName = ((java.lang.String) (enParams.nextElement()));
            builder.append("\"");
            builder.append(paramName);
            builder.append("\"");
            builder.append(":");
            builder.append("\"");
            builder.append(request.getParameter(paramName));
            builder.append("\"");
            builder.append(",");
        } 
        builder.deleteCharAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3856, builder.lastIndexOf(",")));
        builder.append("}");
        builder.append("}");
        return builder.toString();
    }

    public static perturbation.location.PerturbationLocation __L3852;

    public static perturbation.location.PerturbationLocation __L3853;

    public static perturbation.location.PerturbationLocation __L3854;

    public static perturbation.location.PerturbationLocation __L3855;

    public static perturbation.location.PerturbationLocation __L3856;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayWebResponsePrintServiceImpl.java:44)", 3852, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayWebResponsePrintServiceImpl.java:46)", 3853, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayWebResponsePrintServiceImpl.java:57)", 3854, "Numerical");
        org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayWebResponsePrintServiceImpl.java:61)", 3855, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.__L3856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayWebResponsePrintServiceImpl.java:72)", 3856, "Numerical");
    }

    static {
        org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintServiceImpl.initPerturbationLocation0();
    }
}

