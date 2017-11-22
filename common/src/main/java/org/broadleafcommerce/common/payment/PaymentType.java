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
package org.broadleafcommerce.common.payment;


public class PaymentType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentType>();

    public static final org.broadleafcommerce.common.payment.PaymentType GIFT_CARD = new org.broadleafcommerce.common.payment.PaymentType("GIFT_CARD", "Gift Card", false);

    public static final org.broadleafcommerce.common.payment.PaymentType CREDIT_CARD = new org.broadleafcommerce.common.payment.PaymentType("CREDIT_CARD", "Credit Card", true);

    public static final org.broadleafcommerce.common.payment.PaymentType BANK_ACCOUNT = new org.broadleafcommerce.common.payment.PaymentType("BANK_ACCOUNT", "Bank Account", false);

    public static final org.broadleafcommerce.common.payment.PaymentType CHECK = new org.broadleafcommerce.common.payment.PaymentType("CHECK", "Check", false);

    public static final org.broadleafcommerce.common.payment.PaymentType ELECTRONIC_CHECK = new org.broadleafcommerce.common.payment.PaymentType("ELECTRONIC_CHECK", "Electronic Check", false);

    public static final org.broadleafcommerce.common.payment.PaymentType WIRE = new org.broadleafcommerce.common.payment.PaymentType("WIRE", "Wire Transfer", false);

    public static final org.broadleafcommerce.common.payment.PaymentType MONEY_ORDER = new org.broadleafcommerce.common.payment.PaymentType("MONEY_ORDER", "Money Order", false);

    public static final org.broadleafcommerce.common.payment.PaymentType CUSTOMER_CREDIT = new org.broadleafcommerce.common.payment.PaymentType("CUSTOMER_CREDIT", "Customer Credit", false);

    public static final org.broadleafcommerce.common.payment.PaymentType COD = new org.broadleafcommerce.common.payment.PaymentType("COD", "Collect On Delivery", false);

    public static final org.broadleafcommerce.common.payment.PaymentType CUSTOMER_PAYMENT = new org.broadleafcommerce.common.payment.PaymentType("CUSTOMER_PAYMENT", "Customer Payment", true);

    public static final org.broadleafcommerce.common.payment.PaymentType PURCHASE_ORDER = new org.broadleafcommerce.common.payment.PaymentType("PURCHASE_ORDER", "Purchase Order", false);

    public static final org.broadleafcommerce.common.payment.PaymentType THIRD_PARTY_ACCOUNT = new org.broadleafcommerce.common.payment.PaymentType("THIRD_PARTY_ACCOUNT", "3rd-Party Account", true);

    private java.lang.String type;

    private java.lang.String friendlyType;

    private boolean isFinalPayment;

    public static org.broadleafcommerce.common.payment.PaymentType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentType.TYPES.get(type);
    }

    public PaymentType() {
    }

    public PaymentType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
        this.isFinalPayment = false;
    }

    public PaymentType(final java.lang.String type, final java.lang.String friendlyType, final boolean isFinalPayment) {
        this.friendlyType = friendlyType;
        this.isFinalPayment = isFinalPayment;
        setType(type);
    }

    public boolean getIsFinalPayment() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4078, isFinalPayment);
    }

    @java.lang.Override
    public java.lang.String getType() {
        return type;
    }

    @java.lang.Override
    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4080, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4079, org.broadleafcommerce.common.payment.PaymentType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4081, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4082, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4090, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4085, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4083, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4084, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4089, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4086, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4087, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4088, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentType.__L4091, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4092, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4093, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4094, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4095, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4097, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4096, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4098, false);

        org.broadleafcommerce.common.payment.PaymentType other = ((org.broadleafcommerce.common.payment.PaymentType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4099, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4100, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4101, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4103, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4102, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4104, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentType.__L4105, true);
    }

    public static perturbation.location.PerturbationLocation __L4078;

    public static perturbation.location.PerturbationLocation __L4079;

    public static perturbation.location.PerturbationLocation __L4080;

    public static perturbation.location.PerturbationLocation __L4081;

    public static perturbation.location.PerturbationLocation __L4082;

    public static perturbation.location.PerturbationLocation __L4083;

    public static perturbation.location.PerturbationLocation __L4084;

    public static perturbation.location.PerturbationLocation __L4085;

    public static perturbation.location.PerturbationLocation __L4086;

    public static perturbation.location.PerturbationLocation __L4087;

    public static perturbation.location.PerturbationLocation __L4088;

    public static perturbation.location.PerturbationLocation __L4089;

    public static perturbation.location.PerturbationLocation __L4090;

    public static perturbation.location.PerturbationLocation __L4091;

    public static perturbation.location.PerturbationLocation __L4092;

    public static perturbation.location.PerturbationLocation __L4093;

    public static perturbation.location.PerturbationLocation __L4094;

    public static perturbation.location.PerturbationLocation __L4095;

    public static perturbation.location.PerturbationLocation __L4096;

    public static perturbation.location.PerturbationLocation __L4097;

    public static perturbation.location.PerturbationLocation __L4098;

    public static perturbation.location.PerturbationLocation __L4099;

    public static perturbation.location.PerturbationLocation __L4100;

    public static perturbation.location.PerturbationLocation __L4101;

    public static perturbation.location.PerturbationLocation __L4102;

    public static perturbation.location.PerturbationLocation __L4103;

    public static perturbation.location.PerturbationLocation __L4104;

    public static perturbation.location.PerturbationLocation __L4105;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentType.__L4078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:87)", 4078, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:102)", 4079, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:102)", 4080, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:109)", 4081, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:110)", 4082, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4083, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4084, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4085, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4086, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4087, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4088, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4089, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:111)", 4090, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:112)", 4091, "Numerical");
        org.broadleafcommerce.common.payment.PaymentType.__L4092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:117)", 4092, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:118)", 4093, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:119)", 4094, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:120)", 4095, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:121)", 4096, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:121)", 4097, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:122)", 4098, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:124)", 4099, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:125)", 4100, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:126)", 4101, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:127)", 4102, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:127)", 4103, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:128)", 4104, "Boolean");
        org.broadleafcommerce.common.payment.PaymentType.__L4105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentType.java:129)", 4105, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentType.initPerturbationLocation0();
    }
}

