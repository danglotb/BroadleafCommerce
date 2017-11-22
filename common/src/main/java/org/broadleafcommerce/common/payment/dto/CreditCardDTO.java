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


public class CreditCardDTO<T> {
    protected T parent;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String creditCardHolderName;

    protected java.lang.String creditCardType;

    protected java.lang.String creditCardNum;

    protected java.lang.String creditCardLastFour;

    protected java.lang.String creditCardExpDate;

    protected java.lang.String creditCardExpMonth;

    protected java.lang.String creditCardExpYear;

    protected java.lang.String creditCardCvv;

    public CreditCardDTO() {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
    }

    public CreditCardDTO(T parent) {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> additionalFields(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardHolderName(java.lang.String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardType(java.lang.String creditCardType) {
        this.creditCardType = creditCardType;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardNum(java.lang.String creditCardNum) {
        this.creditCardNum = creditCardNum;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardLastFour(java.lang.String creditCardLastFour) {
        this.creditCardLastFour = creditCardLastFour;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardExpDate(java.lang.String creditCardExpDate) {
        this.creditCardExpDate = creditCardExpDate;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardExpMonth(java.lang.String creditCardExpMonth) {
        this.creditCardExpMonth = creditCardExpMonth;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardExpYear(java.lang.String creditCardExpYear) {
        this.creditCardExpYear = creditCardExpYear;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CreditCardDTO<T> creditCardCvv(java.lang.String creditCardCvv) {
        this.creditCardCvv = creditCardCvv;
        return this;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalFields() {
        return additionalFields;
    }

    public java.lang.String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    public java.lang.String getCreditCardType() {
        return creditCardType;
    }

    public java.lang.String getCreditCardNum() {
        return creditCardNum;
    }

    public java.lang.String getCreditCardLastFour() {
        return creditCardLastFour;
    }

    public java.lang.String getCreditCardExpDate() {
        return creditCardExpDate;
    }

    public java.lang.String getCreditCardExpMonth() {
        return creditCardExpMonth;
    }

    public java.lang.String getCreditCardExpYear() {
        return creditCardExpYear;
    }

    public java.lang.String getCreditCardCvv() {
        return creditCardCvv;
    }

    public boolean creditCardPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3772, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3770, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3768, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3766, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3764, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3762, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3760, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3758, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3756, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3753, ((getAdditionalFields()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3755, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3754, getAdditionalFields().isEmpty())))))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3757, ((getCreditCardHolderName()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3759, ((getCreditCardType()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3761, ((getCreditCardNum()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3763, ((getCreditCardLastFour()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3765, ((getCreditCardExpDate()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3767, ((getCreditCardExpMonth()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3769, ((getCreditCardExpYear()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3771, ((getCreditCardCvv()) != null)))));
    }

    public static perturbation.location.PerturbationLocation __L3753;

    public static perturbation.location.PerturbationLocation __L3754;

    public static perturbation.location.PerturbationLocation __L3755;

    public static perturbation.location.PerturbationLocation __L3756;

    public static perturbation.location.PerturbationLocation __L3757;

    public static perturbation.location.PerturbationLocation __L3758;

    public static perturbation.location.PerturbationLocation __L3759;

    public static perturbation.location.PerturbationLocation __L3760;

    public static perturbation.location.PerturbationLocation __L3761;

    public static perturbation.location.PerturbationLocation __L3762;

    public static perturbation.location.PerturbationLocation __L3763;

    public static perturbation.location.PerturbationLocation __L3764;

    public static perturbation.location.PerturbationLocation __L3765;

    public static perturbation.location.PerturbationLocation __L3766;

    public static perturbation.location.PerturbationLocation __L3767;

    public static perturbation.location.PerturbationLocation __L3768;

    public static perturbation.location.PerturbationLocation __L3769;

    public static perturbation.location.PerturbationLocation __L3770;

    public static perturbation.location.PerturbationLocation __L3771;

    public static perturbation.location.PerturbationLocation __L3772;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3753, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3754, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3755, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3756, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:138)", 3757, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3758, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:139)", 3759, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3760, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:140)", 3761, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3762, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:141)", 3763, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3764, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:142)", 3765, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3766, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:143)", 3767, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3768, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:144)", 3769, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3770, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:145)", 3771, "Boolean");
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.__L3772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/CreditCardDTO.java:137)", 3772, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.dto.CreditCardDTO.initPerturbationLocation0();
    }
}

