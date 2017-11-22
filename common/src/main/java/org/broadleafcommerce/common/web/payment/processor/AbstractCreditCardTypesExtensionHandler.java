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
package org.broadleafcommerce.common.web.payment.processor;


public abstract class AbstractCreditCardTypesExtensionHandler extends org.broadleafcommerce.common.extension.AbstractExtensionHandler implements org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler {
    @javax.annotation.Resource(name = "blPaymentGatewayResolver")
    protected org.broadleafcommerce.common.payment.service.PaymentGatewayResolver paymentGatewayResolver;

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType populateCreditCardMap(java.util.Map<java.lang.String, java.lang.String> creditCardTypes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractCreditCardTypesExtensionHandler.__L7372, paymentGatewayResolver.isHandlerCompatible(getHandlerType()))) {
            setCardTypes(creditCardTypes);
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED;
        }
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }

    public abstract org.broadleafcommerce.common.payment.PaymentGatewayType getHandlerType();

    public abstract void setCardTypes(java.util.Map<java.lang.String, java.lang.String> creditCardTypes);

    public static perturbation.location.PerturbationLocation __L7372;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.processor.AbstractCreditCardTypesExtensionHandler.__L7372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractCreditCardTypesExtensionHandler.java:39)", 7372, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.processor.AbstractCreditCardTypesExtensionHandler.initPerturbationLocation0();
    }
}

