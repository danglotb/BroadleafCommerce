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
package org.broadleafcommerce.common.web.payment.controller;


public abstract class CustomerPaymentGatewayAbstractController extends org.broadleafcommerce.common.web.controller.BroadleafAbstractController {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.class);

    @javax.annotation.Resource(name = "blPaymentGatewayWebResponsePrintService")
    protected org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintService webResponsePrintService;

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier("blCustomerPaymentGatewayService")
    protected org.broadleafcommerce.common.payment.service.CustomerPaymentGatewayService customerPaymentGatewayService;

    public java.lang.Long applyCustomerTokenToProfile(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO) throws java.lang.IllegalArgumentException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7276, org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.isErrorEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7277, ((customerPaymentGatewayService) == null))) {
                org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.trace("applyCustomerTokenToProfile: CustomerPaymentGatewayService is null. Please check your configuration.");
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7278, ((customerPaymentGatewayService) != null))) {
            return customerPaymentGatewayService.createCustomerPaymentFromResponseDTO(responseDTO, getConfiguration());
        }
        return null;
    }

    public java.lang.String createCustomerPayment(org.springframework.ui.Model model, javax.servlet.http.HttpServletRequest request, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        try {
            org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO = getWebResponseService().translateWebResponse(request);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7279, org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.trace(("HTTPRequest translated to Raw Response: " + (responseDTO.getRawResponse())));
            }
            java.lang.Long customerPaymentId = applyCustomerTokenToProfile(responseDTO);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7280, (customerPaymentId != null))) {
                return getCustomerPaymentViewRedirect(java.lang.String.valueOf(customerPaymentId));
            }
        } catch (java.lang.Exception e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7281, org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.isErrorEnabled())) {
                org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.error(("HTTPRequest - " + (webResponsePrintService.printRequest(request))));
                org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.LOG.error((("An exception was caught either from processing the response or saving the resulting " + ("payment token to the customer's profile - delegating to the payment module to handle any other " + "exception processing. The error caught was: ")) + e));
            }
            handleProcessingException(e, redirectAttributes);
        }
        return getCustomerPaymentErrorRedirect();
    }

    public abstract org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService getWebResponseService();

    public abstract org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration getConfiguration();

    public abstract java.lang.String getCustomerPaymentViewRedirect(java.lang.String customerPaymentId);

    public abstract java.lang.String getCustomerPaymentErrorRedirect();

    public abstract void handleProcessingException(java.lang.Exception e, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public static perturbation.location.PerturbationLocation __L7276;

    public static perturbation.location.PerturbationLocation __L7277;

    public static perturbation.location.PerturbationLocation __L7278;

    public static perturbation.location.PerturbationLocation __L7279;

    public static perturbation.location.PerturbationLocation __L7280;

    public static perturbation.location.PerturbationLocation __L7281;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/CustomerPaymentGatewayAbstractController.java:62)", 7276, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/CustomerPaymentGatewayAbstractController.java:63)", 7277, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/CustomerPaymentGatewayAbstractController.java:68)", 7278, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/CustomerPaymentGatewayAbstractController.java:97)", 7279, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/CustomerPaymentGatewayAbstractController.java:103)", 7280, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.__L7281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/CustomerPaymentGatewayAbstractController.java:108)", 7281, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.controller.CustomerPaymentGatewayAbstractController.initPerturbationLocation0();
    }
}

