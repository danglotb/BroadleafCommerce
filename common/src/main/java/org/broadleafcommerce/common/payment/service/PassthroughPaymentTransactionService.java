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


@org.springframework.stereotype.Service("blPassthroughPaymentTransactionService")
public class PassthroughPaymentTransactionService extends org.broadleafcommerce.common.payment.service.AbstractPaymentGatewayTransactionService {
    @java.lang.Override
    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO authorize(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentRequestDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO response = new org.broadleafcommerce.common.payment.dto.PaymentResponseDTO(paymentRequestDTO.getPaymentType(), org.broadleafcommerce.common.payment.PaymentGatewayType.PASSTHROUGH).paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType.AUTHORIZE).amount(new org.broadleafcommerce.common.money.Money(paymentRequestDTO.getTransactionTotal())).successful(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3837, true));
        return response;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO capture(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentRequestDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO response = new org.broadleafcommerce.common.payment.dto.PaymentResponseDTO(paymentRequestDTO.getPaymentType(), org.broadleafcommerce.common.payment.PaymentGatewayType.PASSTHROUGH).paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType.CAPTURE).amount(new org.broadleafcommerce.common.money.Money(paymentRequestDTO.getTransactionTotal())).successful(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3838, true));
        return response;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO authorizeAndCapture(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentRequestDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO response = new org.broadleafcommerce.common.payment.dto.PaymentResponseDTO(paymentRequestDTO.getPaymentType(), org.broadleafcommerce.common.payment.PaymentGatewayType.PASSTHROUGH).paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType.AUTHORIZE_AND_CAPTURE).amount(new org.broadleafcommerce.common.money.Money(paymentRequestDTO.getTransactionTotal())).successful(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3839, true));
        return response;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO reverseAuthorize(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentRequestDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO response = new org.broadleafcommerce.common.payment.dto.PaymentResponseDTO(paymentRequestDTO.getPaymentType(), org.broadleafcommerce.common.payment.PaymentGatewayType.PASSTHROUGH).paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType.REVERSE_AUTH).amount(new org.broadleafcommerce.common.money.Money(paymentRequestDTO.getTransactionTotal())).successful(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3840, true));
        return response;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO refund(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentRequestDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO response = new org.broadleafcommerce.common.payment.dto.PaymentResponseDTO(paymentRequestDTO.getPaymentType(), org.broadleafcommerce.common.payment.PaymentGatewayType.PASSTHROUGH).paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType.REFUND).amount(new org.broadleafcommerce.common.money.Money(paymentRequestDTO.getTransactionTotal())).successful(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3841, true));
        return response;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO voidPayment(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentRequestDTO) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO response = new org.broadleafcommerce.common.payment.dto.PaymentResponseDTO(paymentRequestDTO.getPaymentType(), org.broadleafcommerce.common.payment.PaymentGatewayType.PASSTHROUGH).paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType.VOID).amount(new org.broadleafcommerce.common.money.Money(paymentRequestDTO.getTransactionTotal())).successful(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3842, true));
        return response;
    }

    public static perturbation.location.PerturbationLocation __L3837;

    public static perturbation.location.PerturbationLocation __L3838;

    public static perturbation.location.PerturbationLocation __L3839;

    public static perturbation.location.PerturbationLocation __L3840;

    public static perturbation.location.PerturbationLocation __L3841;

    public static perturbation.location.PerturbationLocation __L3842;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PassthroughPaymentTransactionService.java:36)", 3837, "Boolean");
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PassthroughPaymentTransactionService.java:45)", 3838, "Boolean");
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PassthroughPaymentTransactionService.java:54)", 3839, "Boolean");
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PassthroughPaymentTransactionService.java:63)", 3840, "Boolean");
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PassthroughPaymentTransactionService.java:72)", 3841, "Boolean");
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.__L3842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PassthroughPaymentTransactionService.java:81)", 3842, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.service.PassthroughPaymentTransactionService.initPerturbationLocation0();
    }
}

