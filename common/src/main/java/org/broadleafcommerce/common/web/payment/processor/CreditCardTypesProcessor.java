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


@org.springframework.stereotype.Component("blCreditCardTypesProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class CreditCardTypesProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafVariableModifierProcessor {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.class);

    @javax.annotation.Resource(name = "blCreditCardTypesExtensionManager")
    protected org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionManager extensionManager;

    @java.lang.Override
    public java.lang.String getName() {
        return "credit_card_types";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7393, 100);
    }

    @java.lang.Override
    public boolean useGlobalScope() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7394, false);
    }

    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.Object> populateModelVariables(java.lang.String tagName, java.util.Map<java.lang.String, java.lang.String> tagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.util.Map<java.lang.String, java.lang.String> creditCardTypes = new java.util.HashMap<>();
        try {
            extensionManager.getProxy().populateCreditCardMap(creditCardTypes);
        } catch (java.lang.Exception e) {
            org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.LOG.warn("Unable to Populate Credit Card Types Map for this Payment Module, or card type is not needed.");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7396, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7395, creditCardTypes.isEmpty()))))) {
            return com.google.common.collect.ImmutableMap.of("paymentGatewayCardTypes", ((java.lang.Object) (creditCardTypes)));
        }else {
            return null;
        }
    }

    public static perturbation.location.PerturbationLocation __L7393;

    public static perturbation.location.PerturbationLocation __L7394;

    public static perturbation.location.PerturbationLocation __L7395;

    public static perturbation.location.PerturbationLocation __L7396;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/CreditCardTypesProcessor.java:74)", 7393, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/CreditCardTypesProcessor.java:79)", 7394, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/CreditCardTypesProcessor.java:92)", 7395, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.__L7396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/CreditCardTypesProcessor.java:92)", 7396, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesProcessor.initPerturbationLocation0();
    }
}

