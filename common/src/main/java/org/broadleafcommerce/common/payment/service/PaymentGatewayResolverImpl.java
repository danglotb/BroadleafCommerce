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


@org.springframework.stereotype.Service("blPaymentGatewayResolver")
public class PaymentGatewayResolverImpl implements org.broadleafcommerce.common.payment.service.PaymentGatewayResolver {
    @java.lang.Override
    public boolean isHandlerCompatible(org.broadleafcommerce.common.payment.PaymentGatewayType handlerType) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayResolverImpl.__L3845, true);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.PaymentGatewayType resolvePaymentGateway(org.springframework.web.context.request.WebRequest request) {
        return null;
    }

    public static perturbation.location.PerturbationLocation __L3845;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.service.PaymentGatewayResolverImpl.__L3845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayResolverImpl.java:35)", 3845, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.service.PaymentGatewayResolverImpl.initPerturbationLocation0();
    }
}

