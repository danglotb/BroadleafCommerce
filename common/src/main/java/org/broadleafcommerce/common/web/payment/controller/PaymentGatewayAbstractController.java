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


public abstract class PaymentGatewayAbstractController extends org.broadleafcommerce.common.web.controller.BroadleafAbstractController {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.class);

    public static final java.lang.String PAYMENT_PROCESSING_ERROR = "PAYMENT_PROCESSING_ERROR";

    protected static java.lang.String baseRedirect = "redirect:/";

    protected static java.lang.String baseErrorView = "/error";

    protected static java.lang.String baseOrderReviewRedirect = "redirect:/checkout";

    protected static java.lang.String baseConfirmationRedirect = "redirect:/confirmation";

    protected static java.lang.String baseCartRedirect = "redirect:/cart";

    protected static java.lang.String processingErrorMessage = "cart.paymentProcessingError";

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier("blPaymentGatewayCheckoutService")
    protected org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService paymentGatewayCheckoutService;

    @javax.annotation.Resource(name = "blPaymentGatewayWebResponsePrintService")
    protected org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintService webResponsePrintService;

    public java.lang.Long applyPaymentToOrder(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO) throws java.lang.IllegalArgumentException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7282, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isErrorEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7283, ((paymentGatewayCheckoutService) == null))) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace("applyPaymentToOrder: PaymentCheckoutService is null. Please check your configuration.");
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7284, ((paymentGatewayCheckoutService) != null))) {
            return paymentGatewayCheckoutService.applyPaymentToOrder(responseDTO, getConfiguration());
        }
        return null;
    }

    public java.lang.String initiateCheckout(java.lang.Long orderId) throws java.lang.Exception {
        java.lang.String orderNumber = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7285, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isErrorEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7286, ((paymentGatewayCheckoutService) == null))) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace("initiateCheckout: PaymentCheckoutService is null. Please check your configuration.");
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7289, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7287, ((paymentGatewayCheckoutService) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7288, (orderId != null)))))) {
            orderNumber = paymentGatewayCheckoutService.initiateCheckout(orderId);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7290, (orderNumber == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7291, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace((("The result from calling initiateCheckout with paymentCheckoutService and orderId: " + orderId) + " is null"));
            }
        }
        return orderNumber;
    }

    public java.lang.String lookupOrderNumberFromOrderId(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO) {
        java.lang.String orderNumber = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7292, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isErrorEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7293, ((paymentGatewayCheckoutService) == null))) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace("lookupOrderNumberFromOrderId: PaymentCheckoutService is null. Please check your configuration.");
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7294, ((paymentGatewayCheckoutService) != null))) {
            orderNumber = paymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7295, (orderNumber == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7296, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace("The result from calling lookupOrderNumberFromOrderId is null");
            }
        }
        return orderNumber;
    }

    public java.lang.String process(org.springframework.ui.Model model, javax.servlet.http.HttpServletRequest request, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        java.lang.Long orderPaymentId = null;
        try {
            org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO = getWebResponseService().translateWebResponse(request);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7297, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace(("HTTPRequest translated to Raw Response: " + (responseDTO.getRawResponse())));
            }
            orderPaymentId = applyPaymentToOrder(responseDTO);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7299, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7298, responseDTO.isSuccessful()))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7300, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace(("The Response DTO is marked as unsuccessful. Delegating to the " + "payment module to handle an unsuccessful transaction"));
                }
                handleUnsuccessfulTransaction(model, redirectAttributes, responseDTO);
                return getErrorViewRedirect();
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7302, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7301, responseDTO.isValid()))))) {
                throw new org.broadleafcommerce.common.vendor.service.exception.PaymentException(("The validity of the response cannot be confirmed." + "Check the Tamper Proof Seal for more details."));
            }
            java.lang.String orderId = responseDTO.getOrderId();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7303, (orderId == null))) {
                throw new java.lang.RuntimeException("Order ID must be set on the Payment Response DTO");
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7304, responseDTO.isCompleteCheckoutOnCallback())) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7305, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace((("The Response DTO for this Gateway is configured to complete checkout on callback. " + "Initiating Checkout with Order ID: ") + orderId));
                }
                java.lang.String orderNumber = initiateCheckout(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7306, java.lang.Long.parseLong(orderId)));
                return getConfirmationViewRedirect(orderNumber);
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7307, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.trace((("The Gateway is configured to not complete checkout. " + "Redirecting to the Order Review Page for Order ID: ") + orderId));
                }
                return getOrderReviewRedirect();
            }
        } catch (java.lang.Exception e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7308, org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.isErrorEnabled())) {
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.error(("HTTPRequest - " + (webResponsePrintService.printRequest(request))));
                org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.LOG.error(("An exception was caught either from processing the response and applying the payment to " + (("the order, or an activity in the checkout workflow threw an exception. Attempting to " + "mark the payment as invalid and delegating to the payment module to handle any other ") + "exception processing")), e);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7311, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7309, ((paymentGatewayCheckoutService) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7310, (orderPaymentId != null)))))) {
                paymentGatewayCheckoutService.markPaymentAsInvalid(orderPaymentId);
            }
            handleProcessingException(e, redirectAttributes);
        }
        return getErrorViewRedirect();
    }

    public abstract void handleProcessingException(java.lang.Exception e, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public abstract void handleUnsuccessfulTransaction(org.springframework.ui.Model model, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes, org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public abstract java.lang.String getGatewayContextKey();

    public abstract org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService getWebResponseService();

    public abstract org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration getConfiguration();

    public abstract java.lang.String returnEndpoint(org.springframework.ui.Model model, javax.servlet.http.HttpServletRequest request, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes, java.util.Map<java.lang.String, java.lang.String> pathVars) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public abstract java.lang.String errorEndpoint(org.springframework.ui.Model model, javax.servlet.http.HttpServletRequest request, final org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes, java.util.Map<java.lang.String, java.lang.String> pathVars) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    protected java.lang.String getErrorViewRedirect() {
        return ((org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.baseRedirect) + (getGatewayContextKey())) + (org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.baseErrorView);
    }

    protected java.lang.String getCartViewRedirect() {
        return org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.baseCartRedirect;
    }

    public java.lang.String getOrderReviewRedirect() {
        return org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.baseOrderReviewRedirect;
    }

    public java.lang.String getBaseConfirmationRedirect() {
        return org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.baseConfirmationRedirect;
    }

    protected java.lang.String getConfirmationViewRedirect(java.lang.String orderNumber) {
        return ((getBaseConfirmationRedirect()) + "/") + orderNumber;
    }

    public static java.lang.String getProcessingErrorMessage() {
        return org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.processingErrorMessage;
    }

    public static perturbation.location.PerturbationLocation __L7282;

    public static perturbation.location.PerturbationLocation __L7283;

    public static perturbation.location.PerturbationLocation __L7284;

    public static perturbation.location.PerturbationLocation __L7285;

    public static perturbation.location.PerturbationLocation __L7286;

    public static perturbation.location.PerturbationLocation __L7287;

    public static perturbation.location.PerturbationLocation __L7288;

    public static perturbation.location.PerturbationLocation __L7289;

    public static perturbation.location.PerturbationLocation __L7290;

    public static perturbation.location.PerturbationLocation __L7291;

    public static perturbation.location.PerturbationLocation __L7292;

    public static perturbation.location.PerturbationLocation __L7293;

    public static perturbation.location.PerturbationLocation __L7294;

    public static perturbation.location.PerturbationLocation __L7295;

    public static perturbation.location.PerturbationLocation __L7296;

    public static perturbation.location.PerturbationLocation __L7297;

    public static perturbation.location.PerturbationLocation __L7298;

    public static perturbation.location.PerturbationLocation __L7299;

    public static perturbation.location.PerturbationLocation __L7300;

    public static perturbation.location.PerturbationLocation __L7301;

    public static perturbation.location.PerturbationLocation __L7302;

    public static perturbation.location.PerturbationLocation __L7303;

    public static perturbation.location.PerturbationLocation __L7304;

    public static perturbation.location.PerturbationLocation __L7305;

    public static perturbation.location.PerturbationLocation __L7306;

    public static perturbation.location.PerturbationLocation __L7307;

    public static perturbation.location.PerturbationLocation __L7308;

    public static perturbation.location.PerturbationLocation __L7309;

    public static perturbation.location.PerturbationLocation __L7310;

    public static perturbation.location.PerturbationLocation __L7311;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:76)", 7282, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:77)", 7283, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:82)", 7284, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:90)", 7285, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:91)", 7286, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:96)", 7287, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:96)", 7288, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:96)", 7289, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:100)", 7290, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:101)", 7291, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:111)", 7292, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:112)", 7293, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:117)", 7294, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:121)", 7295, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:122)", 7296, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:173)", 7297, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:179)", 7298, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:179)", 7299, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:180)", 7300, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:189)", 7301, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:189)", 7302, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:195)", 7303, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:199)", 7304, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:200)", 7305, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:205)", 7306, "Numerical");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:208)", 7307, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:218)", 7308, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:227)", 7309, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:227)", 7310, "Boolean");
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.__L7311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/controller/PaymentGatewayAbstractController.java:227)", 7311, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.controller.PaymentGatewayAbstractController.initPerturbationLocation0();
    }
}

