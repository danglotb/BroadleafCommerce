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


@org.springframework.stereotype.Component("blTransparentRedirectCreditCardFormProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class TransparentRedirectCreditCardFormProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafModelModifierProcessor {
    @javax.annotation.Resource(name = "blTRCreditCardExtensionManager")
    protected org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionManager extensionManager;

    public org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionManager getExtensionManager() {
        return extensionManager;
    }

    public void setExtensionManager(org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionManager extensionManager) {
        this.extensionManager = extensionManager;
    }

    @java.lang.Override
    public java.lang.String getName() {
        return "transparent_credit_card_form";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7398, 1);
    }

    @java.lang.Override
    public org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO getInjectedModelAndTagAttributes(java.lang.String rootTagName, java.util.Map<java.lang.String, java.lang.String> rootTagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO requestDTO = ((org.broadleafcommerce.common.payment.dto.PaymentRequestDTO) (context.parseExpression(rootTagAttributes.get("paymentRequestDTO"))));
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> formParameters = new java.util.HashMap<>();
        java.util.Map<java.lang.String, java.lang.String> configurationSettings = new java.util.HashMap<>();
        java.util.Map<java.lang.String, java.lang.String> keysToKeep = new java.util.HashMap<>();
        for (java.lang.String key : rootTagAttributes.keySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7399, key.startsWith("config-"))) {
                final int trimLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7400, "config-".length());
                java.lang.String configParam = key.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7401, trimLength));
                configurationSettings.put(configParam, rootTagAttributes.get(key));
            }else {
                keysToKeep.put(key, rootTagAttributes.get(key));
            }
        }
        keysToKeep.remove("paymentRequestDTO");
        try {
            extensionManager.getProxy().createTransparentRedirectForm(formParameters, requestDTO, configurationSettings);
        } catch (org.broadleafcommerce.common.vendor.service.exception.PaymentException e) {
            throw new java.lang.RuntimeException("Unable to Create the Transparent Redirect Form", e);
        }
        java.lang.StringBuilder formActionKey = new java.lang.StringBuilder("formActionKey");
        java.lang.StringBuilder formHiddenParamsKey = new java.lang.StringBuilder("formHiddenParamsKey");
        extensionManager.getProxy().setFormActionKey(formActionKey);
        extensionManager.getProxy().setFormHiddenParamsKey(formHiddenParamsKey);
        java.lang.String actionUrl = "";
        java.util.Map<java.lang.String, java.lang.String> actionValue = formParameters.get(formActionKey.toString());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7406, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7402, (actionValue != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7405, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7403, actionValue.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7404, 0)))))))) {
            java.lang.String key = ((java.lang.String) (actionValue.keySet().toArray()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7407, 0)]));
            actionUrl = actionValue.get(key);
        }
        keysToKeep.put("action", actionUrl);
        org.broadleafcommerce.presentation.model.BroadleafTemplateModel model = context.createModel();
        java.util.Map<java.lang.String, java.lang.String> hiddenFields = formParameters.get(formHiddenParamsKey.toString());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7408, org.apache.commons.collections.MapUtils.isNotEmpty(hiddenFields))) {
            for (java.lang.String key : hiddenFields.keySet()) {
                java.util.Map<java.lang.String, java.lang.String> attributes = new java.util.HashMap<>();
                attributes.put("type", "hidden");
                attributes.put("name", key);
                attributes.put("value", hiddenFields.get(key));
                org.broadleafcommerce.presentation.model.BroadleafTemplateElement input = context.createStandaloneElement("input", attributes, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7409, true));
                model.addElement(input);
            }
        }
        return new org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO(model, keysToKeep, "form");
    }

    @java.lang.Override
    public boolean reprocessModel() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7410, true);
    }

    public static perturbation.location.PerturbationLocation __L7398;

    public static perturbation.location.PerturbationLocation __L7399;

    public static perturbation.location.PerturbationLocation __L7400;

    public static perturbation.location.PerturbationLocation __L7401;

    public static perturbation.location.PerturbationLocation __L7402;

    public static perturbation.location.PerturbationLocation __L7403;

    public static perturbation.location.PerturbationLocation __L7404;

    public static perturbation.location.PerturbationLocation __L7405;

    public static perturbation.location.PerturbationLocation __L7406;

    public static perturbation.location.PerturbationLocation __L7407;

    public static perturbation.location.PerturbationLocation __L7408;

    public static perturbation.location.PerturbationLocation __L7409;

    public static perturbation.location.PerturbationLocation __L7410;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:92)", 7398, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:105)", 7399, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:106)", 7400, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:107)", 7401, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:130)", 7402, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:130)", 7403, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:130)", 7404, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:130)", 7405, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:130)", 7406, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:131)", 7407, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:139)", 7408, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:145)", 7409, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.__L7410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/TransparentRedirectCreditCardFormProcessor.java:154)", 7410, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.processor.TransparentRedirectCreditCardFormProcessor.initPerturbationLocation0();
    }
}

