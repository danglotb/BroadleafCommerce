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


public class PaymentRequestDTO {
    protected org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> customer;

    protected org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> shipTo;

    protected org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> billTo;

    protected org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> creditCard;

    protected org.broadleafcommerce.common.payment.dto.SubscriptionDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> subscription;

    protected java.util.List<org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>> giftCards;

    protected java.util.List<org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>> customerCredits;

    protected java.util.List<org.broadleafcommerce.common.payment.dto.LineItemDTO> lineItems;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String orderId;

    protected java.lang.String orderCurrencyCode;

    protected java.lang.String orderDescription;

    protected java.lang.String orderSubtotal;

    protected java.lang.String shippingTotal;

    protected java.lang.String taxTotal;

    protected java.lang.String transactionTotal;

    protected org.broadleafcommerce.common.payment.PaymentType paymentType;

    protected org.broadleafcommerce.common.payment.PaymentGatewayRequestType gatewayRequestType;

    protected boolean completeCheckoutOnCallback = true;

    public PaymentRequestDTO() {
        this.giftCards = new java.util.ArrayList<org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>>();
        this.customerCredits = new java.util.ArrayList<org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>>();
        this.lineItems = new java.util.ArrayList<org.broadleafcommerce.common.payment.dto.LineItemDTO>();
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> customer() {
        customer = new org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        return customer;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> creditCard() {
        creditCard = new org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        return creditCard;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> subscription() {
        subscription = new org.broadleafcommerce.common.payment.dto.SubscriptionDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        return subscription;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> shipTo() {
        shipTo = new org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        return shipTo;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> billTo() {
        billTo = new org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        return billTo;
    }

    public org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> giftCard() {
        org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> giftCardDTO = new org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        giftCards.add(giftCardDTO);
        return giftCardDTO;
    }

    public org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> customerCredit() {
        org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> customerCreditDTO = new org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>(this);
        customerCredits.add(customerCreditDTO);
        return customerCreditDTO;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO lineItem() {
        return new org.broadleafcommerce.common.payment.dto.LineItemDTO(this);
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO additionalField(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO orderId(java.lang.String orderId) {
        this.orderId = orderId;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO orderCurrencyCode(java.lang.String orderCurrencyCode) {
        this.orderCurrencyCode = orderCurrencyCode;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO orderDescription(java.lang.String orderDescription) {
        this.orderDescription = orderDescription;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO orderSubtotal(java.lang.String orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO shippingTotal(java.lang.String shippingTotal) {
        this.shippingTotal = shippingTotal;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO taxTotal(java.lang.String taxTotal) {
        this.taxTotal = taxTotal;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO transactionTotal(java.lang.String transactionTotal) {
        this.transactionTotal = transactionTotal;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO paymentType(org.broadleafcommerce.common.payment.PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO gatewayRequestType(org.broadleafcommerce.common.payment.PaymentGatewayRequestType gatewayRequestType) {
        this.gatewayRequestType = gatewayRequestType;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO completeCheckoutOnCallback(boolean completeCheckoutOnCallback) {
        this.completeCheckoutOnCallback = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3795, completeCheckoutOnCallback);
        return this;
    }

    public java.util.List<org.broadleafcommerce.common.payment.dto.LineItemDTO> getLineItems() {
        return lineItems;
    }

    public java.util.List<org.broadleafcommerce.common.payment.dto.GiftCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>> getGiftCards() {
        return giftCards;
    }

    public java.util.List<org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO>> getCustomerCredits() {
        return customerCredits;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> getShipTo() {
        return shipTo;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> getBillTo() {
        return billTo;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> getCreditCard() {
        return creditCard;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> getSubscription() {
        return subscription;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<org.broadleafcommerce.common.payment.dto.PaymentRequestDTO> getCustomer() {
        return customer;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalFields() {
        return additionalFields;
    }

    public java.lang.String getOrderId() {
        return orderId;
    }

    public java.lang.String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public java.lang.String getOrderDescription() {
        return orderDescription;
    }

    public java.lang.String getOrderSubtotal() {
        return orderSubtotal;
    }

    public java.lang.String getShippingTotal() {
        return shippingTotal;
    }

    public java.lang.String getTaxTotal() {
        return taxTotal;
    }

    public java.lang.String getTransactionTotal() {
        return transactionTotal;
    }

    public org.broadleafcommerce.common.payment.PaymentType getPaymentType() {
        return paymentType;
    }

    public org.broadleafcommerce.common.payment.PaymentGatewayRequestType getGatewayRequestType() {
        return gatewayRequestType;
    }

    public boolean isCompleteCheckoutOnCallback() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3796, completeCheckoutOnCallback);
    }

    public boolean shipToPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3799, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3797, ((getShipTo()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3798, getShipTo().addressPopulated()))));
    }

    public boolean billToPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3802, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3800, ((getBillTo()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3801, getBillTo().addressPopulated()))));
    }

    public boolean creditCardPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3805, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3803, ((getCreditCard()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3804, getCreditCard().creditCardPopulated()))));
    }

    public boolean customerPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3808, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3806, ((getCustomer()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3807, getCustomer().customerPopulated()))));
    }

    public boolean subscriptionPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3811, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3809, ((getSubscription()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3810, getSubscription().subscriptionPopulated()))));
    }

    public static perturbation.location.PerturbationLocation __L3795;

    public static perturbation.location.PerturbationLocation __L3796;

    public static perturbation.location.PerturbationLocation __L3797;

    public static perturbation.location.PerturbationLocation __L3798;

    public static perturbation.location.PerturbationLocation __L3799;

    public static perturbation.location.PerturbationLocation __L3800;

    public static perturbation.location.PerturbationLocation __L3801;

    public static perturbation.location.PerturbationLocation __L3802;

    public static perturbation.location.PerturbationLocation __L3803;

    public static perturbation.location.PerturbationLocation __L3804;

    public static perturbation.location.PerturbationLocation __L3805;

    public static perturbation.location.PerturbationLocation __L3806;

    public static perturbation.location.PerturbationLocation __L3807;

    public static perturbation.location.PerturbationLocation __L3808;

    public static perturbation.location.PerturbationLocation __L3809;

    public static perturbation.location.PerturbationLocation __L3810;

    public static perturbation.location.PerturbationLocation __L3811;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:238)", 3795, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:315)", 3796, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:319)", 3797, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:319)", 3798, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:319)", 3799, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:323)", 3800, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:323)", 3801, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:323)", 3802, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:327)", 3803, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:327)", 3804, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:327)", 3805, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:331)", 3806, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:331)", 3807, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:331)", 3808, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:335)", 3809, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:335)", 3810, "Boolean");
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.__L3811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/PaymentRequestDTO.java:335)", 3811, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.dto.PaymentRequestDTO.initPerturbationLocation0();
    }
}

