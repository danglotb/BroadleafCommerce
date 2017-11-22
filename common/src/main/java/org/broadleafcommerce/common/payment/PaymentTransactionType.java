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


public class PaymentTransactionType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentTransactionType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentTransactionType>();

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType AUTHORIZE = new org.broadleafcommerce.common.payment.PaymentTransactionType("AUTHORIZE", "Authorize");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType CAPTURE = new org.broadleafcommerce.common.payment.PaymentTransactionType("CAPTURE", "Capture");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType AUTHORIZE_AND_CAPTURE = new org.broadleafcommerce.common.payment.PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Authorize and Capture");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType SETTLED = new org.broadleafcommerce.common.payment.PaymentTransactionType("SETTLED", "Settled");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType REFUND = new org.broadleafcommerce.common.payment.PaymentTransactionType("REFUND", "Refund");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType DETACHED_CREDIT = new org.broadleafcommerce.common.payment.PaymentTransactionType("DETACHED_CREDIT", "Detached Credit");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType VOID = new org.broadleafcommerce.common.payment.PaymentTransactionType("VOID", "Void");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType REVERSE_AUTH = new org.broadleafcommerce.common.payment.PaymentTransactionType("REVERSE_AUTH", "Reverse Auth");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType UNCONFIRMED = new org.broadleafcommerce.common.payment.PaymentTransactionType("UNCONFIRMED", "Not Confirmed");

    public static final org.broadleafcommerce.common.payment.PaymentTransactionType PENDING = new org.broadleafcommerce.common.payment.PaymentTransactionType("PENDING", "Pending Authorize or Authorize and Capture");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.PaymentTransactionType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentTransactionType.TYPES.get(type);
    }

    public PaymentTransactionType() {
    }

    public PaymentTransactionType(java.lang.String type, java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4052, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4051, org.broadleafcommerce.common.payment.PaymentTransactionType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentTransactionType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4053, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4054, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4062, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4057, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4055, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4056, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4061, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4058, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4059, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4060, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4063, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4064, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4065, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4066, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4067, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4069, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4068, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4070, false);

        org.broadleafcommerce.common.payment.PaymentTransactionType other = ((org.broadleafcommerce.common.payment.PaymentTransactionType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4071, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4072, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4073, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4075, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4074, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4076, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentTransactionType.__L4077, true);
    }

    public static perturbation.location.PerturbationLocation __L4051;

    public static perturbation.location.PerturbationLocation __L4052;

    public static perturbation.location.PerturbationLocation __L4053;

    public static perturbation.location.PerturbationLocation __L4054;

    public static perturbation.location.PerturbationLocation __L4055;

    public static perturbation.location.PerturbationLocation __L4056;

    public static perturbation.location.PerturbationLocation __L4057;

    public static perturbation.location.PerturbationLocation __L4058;

    public static perturbation.location.PerturbationLocation __L4059;

    public static perturbation.location.PerturbationLocation __L4060;

    public static perturbation.location.PerturbationLocation __L4061;

    public static perturbation.location.PerturbationLocation __L4062;

    public static perturbation.location.PerturbationLocation __L4063;

    public static perturbation.location.PerturbationLocation __L4064;

    public static perturbation.location.PerturbationLocation __L4065;

    public static perturbation.location.PerturbationLocation __L4066;

    public static perturbation.location.PerturbationLocation __L4067;

    public static perturbation.location.PerturbationLocation __L4068;

    public static perturbation.location.PerturbationLocation __L4069;

    public static perturbation.location.PerturbationLocation __L4070;

    public static perturbation.location.PerturbationLocation __L4071;

    public static perturbation.location.PerturbationLocation __L4072;

    public static perturbation.location.PerturbationLocation __L4073;

    public static perturbation.location.PerturbationLocation __L4074;

    public static perturbation.location.PerturbationLocation __L4075;

    public static perturbation.location.PerturbationLocation __L4076;

    public static perturbation.location.PerturbationLocation __L4077;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:220)", 4051, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:220)", 4052, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:227)", 4053, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:228)", 4054, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4055, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4056, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4057, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4058, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4059, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4060, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4061, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:229)", 4062, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:230)", 4063, "Numerical");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:235)", 4064, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:236)", 4065, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:237)", 4066, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:238)", 4067, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:239)", 4068, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:239)", 4069, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:240)", 4070, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:242)", 4071, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:243)", 4072, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:244)", 4073, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:245)", 4074, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4075 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:245)", 4075, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:246)", 4076, "Boolean");
        org.broadleafcommerce.common.payment.PaymentTransactionType.__L4077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentTransactionType.java:247)", 4077, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentTransactionType.initPerturbationLocation0();
    }
}

