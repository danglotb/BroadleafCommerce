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


public class PaymentGatewayRequestType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentGatewayRequestType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentGatewayRequestType>();

    public static final org.broadleafcommerce.common.payment.PaymentGatewayRequestType CREATE_CUSTOMER_PAYMENT_TR = new org.broadleafcommerce.common.payment.PaymentGatewayRequestType("CREATE_CUSTOMER_PAYMENT_TR", "Transparent Redirect Create Customer Payment Tokenization Request");

    public static final org.broadleafcommerce.common.payment.PaymentGatewayRequestType UPDATE_CUSTOMER_PAYMENT_TR = new org.broadleafcommerce.common.payment.PaymentGatewayRequestType("UPDATE_CUSTOMER_PAYMENT_TR", "Transparent Redirect Update Customer Payment Tokenization Request");

    public static final org.broadleafcommerce.common.payment.PaymentGatewayRequestType DETACHED_CREDIT_REFUND = new org.broadleafcommerce.common.payment.PaymentGatewayRequestType("DETACHED_CREDIT_REFUND", "Detached Credit Refund Request");

    public static final org.broadleafcommerce.common.payment.PaymentGatewayRequestType MANUAL_AUTHORIZATION = new org.broadleafcommerce.common.payment.PaymentGatewayRequestType("MANUAL_AUTHORIZATION", "Manual Authorization Request");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.PaymentGatewayRequestType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentGatewayRequestType.TYPES.get(type);
    }

    public static java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentGatewayRequestType> getTypes() {
        return org.broadleafcommerce.common.payment.PaymentGatewayRequestType.TYPES;
    }

    public PaymentGatewayRequestType() {
    }

    public PaymentGatewayRequestType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3971, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3970, org.broadleafcommerce.common.payment.PaymentGatewayRequestType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentGatewayRequestType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3972, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3973, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3981, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3976, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3974, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3975, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3980, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3977, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3978, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3979, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3982, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3983, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3984, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3985, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3986, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3988, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3987, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3989, false);

        org.broadleafcommerce.common.payment.PaymentGatewayRequestType other = ((org.broadleafcommerce.common.payment.PaymentGatewayRequestType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3990, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3991, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3992, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3994, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3993, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3995, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3996, true);
    }

    public static perturbation.location.PerturbationLocation __L3970;

    public static perturbation.location.PerturbationLocation __L3971;

    public static perturbation.location.PerturbationLocation __L3972;

    public static perturbation.location.PerturbationLocation __L3973;

    public static perturbation.location.PerturbationLocation __L3974;

    public static perturbation.location.PerturbationLocation __L3975;

    public static perturbation.location.PerturbationLocation __L3976;

    public static perturbation.location.PerturbationLocation __L3977;

    public static perturbation.location.PerturbationLocation __L3978;

    public static perturbation.location.PerturbationLocation __L3979;

    public static perturbation.location.PerturbationLocation __L3980;

    public static perturbation.location.PerturbationLocation __L3981;

    public static perturbation.location.PerturbationLocation __L3982;

    public static perturbation.location.PerturbationLocation __L3983;

    public static perturbation.location.PerturbationLocation __L3984;

    public static perturbation.location.PerturbationLocation __L3985;

    public static perturbation.location.PerturbationLocation __L3986;

    public static perturbation.location.PerturbationLocation __L3987;

    public static perturbation.location.PerturbationLocation __L3988;

    public static perturbation.location.PerturbationLocation __L3989;

    public static perturbation.location.PerturbationLocation __L3990;

    public static perturbation.location.PerturbationLocation __L3991;

    public static perturbation.location.PerturbationLocation __L3992;

    public static perturbation.location.PerturbationLocation __L3993;

    public static perturbation.location.PerturbationLocation __L3994;

    public static perturbation.location.PerturbationLocation __L3995;

    public static perturbation.location.PerturbationLocation __L3996;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:93)", 3970, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:93)", 3971, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:100)", 3972, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:101)", 3973, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3974, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3975, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3976, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3977, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3978, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3979, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3980, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:102)", 3981, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:103)", 3982, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:108)", 3983, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:109)", 3984, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:110)", 3985, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:111)", 3986, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:112)", 3987, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:112)", 3988, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:113)", 3989, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:115)", 3990, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:116)", 3991, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:117)", 3992, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:118)", 3993, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:118)", 3994, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:119)", 3995, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.__L3996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayRequestType.java:120)", 3996, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentGatewayRequestType.initPerturbationLocation0();
    }
}

