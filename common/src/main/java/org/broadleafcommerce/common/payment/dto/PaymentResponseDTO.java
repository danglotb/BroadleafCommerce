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
package org.broadleafcommerce.common.payment.dto;


public class PaymentResponseDTO {
    protected org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> customer;

    protected org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> shipTo;

    protected org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> billTo;

    protected org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> creditCard;

    protected java.util.List<org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>> giftCards;

    protected java.util.List<org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>> customerCredits;

    protected org.broadleafcommerce.common.payment.PaymentGatewayType paymentGatewayType;

    protected org.broadleafcommerce.common.payment.PaymentType paymentType;

    protected org.broadleafcommerce.common.payment.PaymentTransactionType paymentTransactionType;

    protected java.lang.String orderId;

    protected org.broadleafcommerce.common.money.Money amount;

    protected java.lang.String paymentToken;

    protected boolean successful = true;

    protected boolean valid = true;

    protected boolean completeCheckoutOnCallback = true;

    protected java.lang.String rawResponse;

    protected java.util.Map<java.lang.String, java.lang.String> responseMap;

    public PaymentResponseDTO(org.broadleafcommerce.common.payment.PaymentType paymentType, org.broadleafcommerce.common.payment.PaymentGatewayType gatewayType) {
        this.paymentType = paymentType;
        this.paymentGatewayType = gatewayType;
        this.giftCards = new java.util.ArrayList<org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>>();
        this.customerCredits = new java.util.ArrayList<org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>>();
        this.responseMap = new java.util.HashMap<java.lang.String, java.lang.String>();
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> customer() {
        customer = new org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>(this);
        return customer;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> creditCard() {
        creditCard = new org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>(this);
        return creditCard;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> shipTo() {
        shipTo = new org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>(this);
        return shipTo;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> billTo() {
        billTo = new org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>(this);
        return billTo;
    }

    public org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> giftCard() {
        org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> giftCardDTO = new org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>(this);
        giftCards.add(giftCardDTO);
        return giftCardDTO;
    }

    public org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> customerCredit() {
        org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> customerCreditDTO = new org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>(this);
        customerCredits.add(customerCreditDTO);
        return customerCreditDTO;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO responseMap(java.lang.String key, java.lang.String value) {
        responseMap.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO orderId(java.lang.String orderId) {
        this.orderId = orderId;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO amount(org.broadleafcommerce.common.money.Money amount) {
        this.amount = amount;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO paymentToken(java.lang.String paymentToken) {
        this.paymentToken = paymentToken;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO paymentTransactionType(org.broadleafcommerce.common.payment.PaymentTransactionType paymentTransactionType) {
        this.paymentTransactionType = paymentTransactionType;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO successful(boolean successful) {
        this.successful = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3812, successful);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO completeCheckoutOnCallback(boolean completeCheckoutOnCallback) {
        this.completeCheckoutOnCallback = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3813, completeCheckoutOnCallback);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO valid(boolean valid) {
        this.valid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3814, valid);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentResponseDTO rawResponse(java.lang.String rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> getCustomer() {
        return customer;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> getShipTo() {
        return shipTo;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> getBillTo() {
        return billTo;
    }

    public java.util.List<org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>> getGiftCards() {
        return giftCards;
    }

    public java.util.List<org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO>> getCustomerCredits() {
        return customerCredits;
    }

    public org.broadleafcommerce.common.payment.PaymentType getPaymentType() {
        return paymentType;
    }

    public org.broadleafcommerce.common.payment.PaymentGatewayType getPaymentGatewayType() {
        return paymentGatewayType;
    }

    public java.lang.String getOrderId() {
        return orderId;
    }

    public org.broadleafcommerce.common.money.Money getAmount() {
        return amount;
    }

    public java.lang.String getPaymentToken() {
        return paymentToken;
    }

    public org.broadleafcommerce.common.payment.PaymentTransactionType getPaymentTransactionType() {
        return paymentTransactionType;
    }

    public boolean isSuccessful() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3815, successful);
    }

    public boolean isValid() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3816, valid);
    }

    public boolean isCompleteCheckoutOnCallback() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3817, completeCheckoutOnCallback);
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentResponseDTO> getCreditCard() {
        return creditCard;
    }

    public java.lang.String getRawResponse() {
        return rawResponse;
    }

    public java.util.Map<java.lang.String, java.lang.String> getResponseMap() {
        return responseMap;
    }

    public static perturbation.location.PerturbationLocation __L3812;

    public static perturbation.location.PerturbationLocation __L3813;

    public static perturbation.location.PerturbationLocation __L3814;

    public static perturbation.location.PerturbationLocation __L3815;

    public static perturbation.location.PerturbationLocation __L3816;

    public static perturbation.location.PerturbationLocation __L3817;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentResponseDTO.java:208)", 3812, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentResponseDTO.java:213)", 3813, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentResponseDTO.java:218)", 3814, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentResponseDTO.java:272)", 3815, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentResponseDTO.java:276)", 3816, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.__L3817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentResponseDTO.java:280)", 3817, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.dto.PaymentResponseDTO.initPerturbationLocation0();
    }
}

