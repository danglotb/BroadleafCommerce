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


public class GatewayCustomerDTO<T> {
    protected T parent;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String customerId;

    protected java.lang.String firstName;

    protected java.lang.String lastName;

    protected java.lang.String companyName;

    protected java.lang.String phone;

    protected java.lang.String mobile;

    protected java.lang.String fax;

    protected java.lang.String website;

    protected java.lang.String email;

    public GatewayCustomerDTO() {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
    }

    public GatewayCustomerDTO(T parent) {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> additionalFields(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> customerId(java.lang.String customerId) {
        this.customerId = customerId;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> firstName(java.lang.String firstName) {
        this.firstName = firstName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> lastName(java.lang.String lastName) {
        this.lastName = lastName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> companyName(java.lang.String companyName) {
        this.companyName = companyName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> phone(java.lang.String phone) {
        this.phone = phone;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> mobile(java.lang.String mobile) {
        this.mobile = mobile;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> fax(java.lang.String fax) {
        this.fax = fax;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> website(java.lang.String website) {
        this.website = website;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO<T> email(java.lang.String email) {
        this.email = email;
        return this;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalFields() {
        return additionalFields;
    }

    public java.lang.String getCustomerId() {
        return customerId;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public java.lang.String getCompanyName() {
        return companyName;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    public java.lang.String getMobile() {
        return mobile;
    }

    public java.lang.String getFax() {
        return fax;
    }

    public java.lang.String getWebsite() {
        return website;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public boolean customerPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3794, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3792, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3790, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3788, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3786, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3784, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3782, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3780, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3778, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3776, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3773, ((getAdditionalFields()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3775, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3774, getAdditionalFields().isEmpty())))))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3777, ((getCustomerId()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3779, ((getFirstName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3781, ((getLastName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3783, ((getCompanyName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3785, ((getPhone()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3787, ((getMobile()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3789, ((getFax()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3791, ((getWebsite()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3793, ((getEmail()) != null)))));
    }

    public static perturbation.location.PerturbationLocation __L3773;

    public static perturbation.location.PerturbationLocation __L3774;

    public static perturbation.location.PerturbationLocation __L3775;

    public static perturbation.location.PerturbationLocation __L3776;

    public static perturbation.location.PerturbationLocation __L3777;

    public static perturbation.location.PerturbationLocation __L3778;

    public static perturbation.location.PerturbationLocation __L3779;

    public static perturbation.location.PerturbationLocation __L3780;

    public static perturbation.location.PerturbationLocation __L3781;

    public static perturbation.location.PerturbationLocation __L3782;

    public static perturbation.location.PerturbationLocation __L3783;

    public static perturbation.location.PerturbationLocation __L3784;

    public static perturbation.location.PerturbationLocation __L3785;

    public static perturbation.location.PerturbationLocation __L3786;

    public static perturbation.location.PerturbationLocation __L3787;

    public static perturbation.location.PerturbationLocation __L3788;

    public static perturbation.location.PerturbationLocation __L3789;

    public static perturbation.location.PerturbationLocation __L3790;

    public static perturbation.location.PerturbationLocation __L3791;

    public static perturbation.location.PerturbationLocation __L3792;

    public static perturbation.location.PerturbationLocation __L3793;

    public static perturbation.location.PerturbationLocation __L3794;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3773, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3774, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3775, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3776, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:147)", 3777, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3778, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:148)", 3779, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3780, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:149)", 3781, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3782, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:150)", 3783, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3784, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:151)", 3785, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3786, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:152)", 3787, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3788, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:153)", 3789, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3790, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:154)", 3791, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3792, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:155)", 3793, "Boolean");
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.__L3794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/GatewayCustomerDTO.java:146)", 3794, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO.initPerturbationLocation0();
    }
}

