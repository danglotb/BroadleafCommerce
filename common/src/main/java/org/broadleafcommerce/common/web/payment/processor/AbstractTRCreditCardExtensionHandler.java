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


public abstract class AbstractTRCreditCardExtensionHandler extends org.broadleafcommerce.common.extension.AbstractExtensionHandler implements org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionHandler {
    @javax.annotation.Resource(name = "blPaymentGatewayResolver")
    protected org.broadleafcommerce.common.payment.service.PaymentGatewayResolver paymentGatewayResolver;

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType setFormActionKey(java.lang.StringBuilder key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7373, paymentGatewayResolver.isHandlerCompatible(getHandlerType()))) {
            key.delete(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7374, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7375, key.length()));
            key.append(getFormActionURLKey());
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED;
        }
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType setFormHiddenParamsKey(java.lang.StringBuilder key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7376, paymentGatewayResolver.isHandlerCompatible(getHandlerType()))) {
            key.delete(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7377, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7378, key.length()));
            key.append(getHiddenParamsKey());
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED;
        }
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType createTransparentRedirectForm(java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> formParameters, org.broadleafcommerce.common.payment.dto.PaymentRequestDTO requestDTO, java.util.Map<java.lang.String, java.lang.String> configurationSettings) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7379, paymentGatewayResolver.isHandlerCompatible(getHandlerType()))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7384, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7382, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7380, (formParameters != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7381, (requestDTO != null)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7383, (configurationSettings != null)))))) {
                for (java.lang.String config : configurationSettings.keySet()) {
                    requestDTO.additionalField(config, configurationSettings.get(config));
                }
                org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7385, org.broadleafcommerce.common.payment.PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR.equals(requestDTO.getGatewayRequestType()))) {
                    responseDTO = getTransparentRedirectService().createCustomerPaymentTokenForm(requestDTO);
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7386, org.broadleafcommerce.common.payment.PaymentGatewayRequestType.UPDATE_CUSTOMER_PAYMENT_TR.equals(requestDTO.getGatewayRequestType()))) {
                        responseDTO = getTransparentRedirectService().updateCustomerPaymentTokenForm(requestDTO);
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7387, getConfiguration().isPerformAuthorizeAndCapture())) {
                            responseDTO = getTransparentRedirectService().createAuthorizeAndCaptureForm(requestDTO);
                        }else {
                            responseDTO = getTransparentRedirectService().createAuthorizeForm(requestDTO);
                        }


                overrideCustomerPaymentReturnURLs(requestDTO, responseDTO);
                populateFormParameters(formParameters, responseDTO);
            }
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
        }
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }

    public org.broadleafcommerce.common.payment.PaymentGatewayType getHandlerType() {
        return getConfiguration().getGatewayType();
    }

    public abstract java.lang.String getFormActionURLKey();

    public abstract java.lang.String getHiddenParamsKey();

    public abstract org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration getConfiguration();

    public abstract org.broadleafcommerce.common.payment.service.PaymentGatewayTransparentRedirectService getTransparentRedirectService();

    public abstract void populateFormParameters(java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> formParameters, org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO);

    protected void overrideCustomerPaymentReturnURLs(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO requestDTO, org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7388, requestDTO.getAdditionalFields().containsKey(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_CREATE_TOKEN_RETURN_URL))) {
            java.lang.String createReturnKey = getTransparentRedirectService().getCreateCustomerPaymentTokenReturnURLFieldKey(responseDTO);
            java.lang.String override = ((java.lang.String) (requestDTO.getAdditionalFields().get(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_CREATE_TOKEN_RETURN_URL)));
            responseDTO.getResponseMap().put(createReturnKey, override);
            responseDTO.getResponseMap().remove(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_CREATE_TOKEN_RETURN_URL);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7389, requestDTO.getAdditionalFields().containsKey(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_CREATE_TOKEN_CANCEL_URL))) {
            java.lang.String createCancelKey = getTransparentRedirectService().getCreateCustomerPaymentTokenCancelURLFieldKey(responseDTO);
            java.lang.String override = ((java.lang.String) (requestDTO.getAdditionalFields().get(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_CREATE_TOKEN_CANCEL_URL)));
            responseDTO.getResponseMap().put(createCancelKey, override);
            responseDTO.getResponseMap().remove(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_CREATE_TOKEN_CANCEL_URL);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7390, requestDTO.getAdditionalFields().containsKey(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_UPDATE_TOKEN_RETURN_URL))) {
            java.lang.String updateReturnKey = getTransparentRedirectService().getUpdateCustomerPaymentTokenReturnURLFieldKey(responseDTO);
            java.lang.String override = ((java.lang.String) (requestDTO.getAdditionalFields().get(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_UPDATE_TOKEN_RETURN_URL)));
            responseDTO.getResponseMap().put(updateReturnKey, override);
            responseDTO.getResponseMap().remove(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_UPDATE_TOKEN_RETURN_URL);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7391, requestDTO.getAdditionalFields().containsKey(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_UPDATE_TOKEN_CANCEL_URL))) {
            java.lang.String updateCancelKey = getTransparentRedirectService().getUpdateCustomerPaymentTokenCancelURLFieldKey(responseDTO);
            java.lang.String override = ((java.lang.String) (requestDTO.getAdditionalFields().get(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_UPDATE_TOKEN_CANCEL_URL)));
            responseDTO.getResponseMap().put(updateCancelKey, override);
            responseDTO.getResponseMap().remove(org.broadleafcommerce.common.payment.TransparentRedirectConstants.OVERRIDE_UPDATE_TOKEN_CANCEL_URL);
        }
    }

    public static perturbation.location.PerturbationLocation __L7373;

    public static perturbation.location.PerturbationLocation __L7374;

    public static perturbation.location.PerturbationLocation __L7375;

    public static perturbation.location.PerturbationLocation __L7376;

    public static perturbation.location.PerturbationLocation __L7377;

    public static perturbation.location.PerturbationLocation __L7378;

    public static perturbation.location.PerturbationLocation __L7379;

    public static perturbation.location.PerturbationLocation __L7380;

    public static perturbation.location.PerturbationLocation __L7381;

    public static perturbation.location.PerturbationLocation __L7382;

    public static perturbation.location.PerturbationLocation __L7383;

    public static perturbation.location.PerturbationLocation __L7384;

    public static perturbation.location.PerturbationLocation __L7385;

    public static perturbation.location.PerturbationLocation __L7386;

    public static perturbation.location.PerturbationLocation __L7387;

    public static perturbation.location.PerturbationLocation __L7388;

    public static perturbation.location.PerturbationLocation __L7389;

    public static perturbation.location.PerturbationLocation __L7390;

    public static perturbation.location.PerturbationLocation __L7391;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:50)", 7373, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:51)", 7374, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:51)", 7375, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:61)", 7376, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:62)", 7377, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:62)", 7378, "Numerical");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:76)", 7379, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:77)", 7380, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:77)", 7381, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:77)", 7382, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:77)", 7383, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:77)", 7384, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:85)", 7385, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:87)", 7386, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:89)", 7387, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:127)", 7388, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:134)", 7389, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:141)", 7390, "Boolean");
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.__L7391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/AbstractTRCreditCardExtensionHandler.java:148)", 7391, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.processor.AbstractTRCreditCardExtensionHandler.initPerturbationLocation0();
    }
}

