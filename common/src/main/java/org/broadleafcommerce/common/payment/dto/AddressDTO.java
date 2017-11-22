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


public class AddressDTO<T> {
    protected T parent;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String addressFirstName;

    protected java.lang.String addressLastName;

    protected java.lang.String addressFullName;

    protected java.lang.String addressCompanyName;

    protected java.lang.String addressLine1;

    protected java.lang.String addressLine2;

    protected java.lang.String addressCityLocality;

    protected java.lang.String addressStateRegion;

    protected java.lang.String addressPostalCode;

    protected java.lang.String addressCountryCode;

    protected java.lang.String addressPhone;

    protected java.lang.String addressEmail;

    public AddressDTO() {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
    }

    public AddressDTO(T parent) {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> additionalFields(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressFirstName(java.lang.String addressFirstName) {
        this.addressFirstName = addressFirstName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressLastName(java.lang.String addressLastName) {
        this.addressLastName = addressLastName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressFullName(java.lang.String addressFullName) {
        this.addressFullName = addressFullName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressCompanyName(java.lang.String addressCompanyName) {
        this.addressCompanyName = addressCompanyName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressLine1(java.lang.String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressLine2(java.lang.String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressCityLocality(java.lang.String addressCityLocality) {
        this.addressCityLocality = addressCityLocality;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressStateRegion(java.lang.String addressStateRegion) {
        this.addressStateRegion = addressStateRegion;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressPostalCode(java.lang.String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressCountryCode(java.lang.String addressCountryCode) {
        this.addressCountryCode = addressCountryCode;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressPhone(java.lang.String addressPhone) {
        this.addressPhone = addressPhone;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.AddressDTO<T> addressEmail(java.lang.String addressEmail) {
        this.addressEmail = addressEmail;
        return this;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalFields() {
        return additionalFields;
    }

    public java.lang.String getAddressFirstName() {
        return addressFirstName;
    }

    public java.lang.String getAddressLastName() {
        return addressLastName;
    }

    public java.lang.String getAddressFullName() {
        return addressFullName;
    }

    public java.lang.String getAddressCompanyName() {
        return addressCompanyName;
    }

    public java.lang.String getAddressLine1() {
        return addressLine1;
    }

    public java.lang.String getAddressLine2() {
        return addressLine2;
    }

    public java.lang.String getAddressCityLocality() {
        return addressCityLocality;
    }

    public java.lang.String getAddressStateRegion() {
        return addressStateRegion;
    }

    public java.lang.String getAddressPostalCode() {
        return addressPostalCode;
    }

    public java.lang.String getAddressCountryCode() {
        return addressCountryCode;
    }

    public java.lang.String getAddressPhone() {
        return addressPhone;
    }

    public java.lang.String getAddressEmail() {
        return addressEmail;
    }

    public boolean addressPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3752, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3750, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3748, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3746, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3744, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3742, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3740, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3738, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3736, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3734, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3732, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3730, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3727, ((getAdditionalFields()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3729, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3728, getAdditionalFields().isEmpty())))))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3731, ((getAddressFirstName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3733, ((getAddressLastName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3735, ((getAddressCompanyName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3737, ((getAddressLine1()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3739, ((getAddressLine2()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3741, ((getAddressCityLocality()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3743, ((getAddressStateRegion()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3745, ((getAddressPostalCode()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3747, ((getAddressCountryCode()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3749, ((getAddressPhone()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.AddressDTO.__L3751, ((getAddressEmail()) != null)))));
    }

    public static perturbation.location.PerturbationLocation __L3727;

    public static perturbation.location.PerturbationLocation __L3728;

    public static perturbation.location.PerturbationLocation __L3729;

    public static perturbation.location.PerturbationLocation __L3730;

    public static perturbation.location.PerturbationLocation __L3731;

    public static perturbation.location.PerturbationLocation __L3732;

    public static perturbation.location.PerturbationLocation __L3733;

    public static perturbation.location.PerturbationLocation __L3734;

    public static perturbation.location.PerturbationLocation __L3735;

    public static perturbation.location.PerturbationLocation __L3736;

    public static perturbation.location.PerturbationLocation __L3737;

    public static perturbation.location.PerturbationLocation __L3738;

    public static perturbation.location.PerturbationLocation __L3739;

    public static perturbation.location.PerturbationLocation __L3740;

    public static perturbation.location.PerturbationLocation __L3741;

    public static perturbation.location.PerturbationLocation __L3742;

    public static perturbation.location.PerturbationLocation __L3743;

    public static perturbation.location.PerturbationLocation __L3744;

    public static perturbation.location.PerturbationLocation __L3745;

    public static perturbation.location.PerturbationLocation __L3746;

    public static perturbation.location.PerturbationLocation __L3747;

    public static perturbation.location.PerturbationLocation __L3748;

    public static perturbation.location.PerturbationLocation __L3749;

    public static perturbation.location.PerturbationLocation __L3750;

    public static perturbation.location.PerturbationLocation __L3751;

    public static perturbation.location.PerturbationLocation __L3752;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3727, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3728, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3729, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3730, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:177)", 3731, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3732, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:178)", 3733, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3734, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:179)", 3735, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3736, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:180)", 3737, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3738, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:181)", 3739, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3740, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:182)", 3741, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3742, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:183)", 3743, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3744, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:184)", 3745, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3746, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:185)", 3747, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3748, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:186)", 3749, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3750, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:187)", 3751, "Boolean");
        org.broadleafcommerce.common.payment.dto.AddressDTO.__L3752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/AddressDTO.java:176)", 3752, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.dto.AddressDTO.initPerturbationLocation0();
    }
}

