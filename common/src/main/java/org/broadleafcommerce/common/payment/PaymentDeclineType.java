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


public class PaymentDeclineType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentDeclineType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentDeclineType>();

    public static final org.broadleafcommerce.common.payment.PaymentDeclineType SOFT = new org.broadleafcommerce.common.payment.PaymentDeclineType("SOFT", "Soft decline");

    public static final org.broadleafcommerce.common.payment.PaymentDeclineType HARD = new org.broadleafcommerce.common.payment.PaymentDeclineType("HARD", "Hard decline");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.PaymentDeclineType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentDeclineType.TYPES.get(type);
    }

    public PaymentDeclineType() {
    }

    public PaymentDeclineType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3944, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3943, org.broadleafcommerce.common.payment.PaymentDeclineType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentDeclineType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3945, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3946, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3954, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3949, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3947, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3948, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3953, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3950, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3951, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3952, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3955, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3956, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3957, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3958, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3959, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3961, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3960, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3962, false);

        org.broadleafcommerce.common.payment.PaymentDeclineType other = ((org.broadleafcommerce.common.payment.PaymentDeclineType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3963, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3964, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3965, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3967, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3966, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3968, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentDeclineType.__L3969, true);
    }

    public static perturbation.location.PerturbationLocation __L3943;

    public static perturbation.location.PerturbationLocation __L3944;

    public static perturbation.location.PerturbationLocation __L3945;

    public static perturbation.location.PerturbationLocation __L3946;

    public static perturbation.location.PerturbationLocation __L3947;

    public static perturbation.location.PerturbationLocation __L3948;

    public static perturbation.location.PerturbationLocation __L3949;

    public static perturbation.location.PerturbationLocation __L3950;

    public static perturbation.location.PerturbationLocation __L3951;

    public static perturbation.location.PerturbationLocation __L3952;

    public static perturbation.location.PerturbationLocation __L3953;

    public static perturbation.location.PerturbationLocation __L3954;

    public static perturbation.location.PerturbationLocation __L3955;

    public static perturbation.location.PerturbationLocation __L3956;

    public static perturbation.location.PerturbationLocation __L3957;

    public static perturbation.location.PerturbationLocation __L3958;

    public static perturbation.location.PerturbationLocation __L3959;

    public static perturbation.location.PerturbationLocation __L3960;

    public static perturbation.location.PerturbationLocation __L3961;

    public static perturbation.location.PerturbationLocation __L3962;

    public static perturbation.location.PerturbationLocation __L3963;

    public static perturbation.location.PerturbationLocation __L3964;

    public static perturbation.location.PerturbationLocation __L3965;

    public static perturbation.location.PerturbationLocation __L3966;

    public static perturbation.location.PerturbationLocation __L3967;

    public static perturbation.location.PerturbationLocation __L3968;

    public static perturbation.location.PerturbationLocation __L3969;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:67)", 3943, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:67)", 3944, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:74)", 3945, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:75)", 3946, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3947, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3948, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3949, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3950, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3951, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3952, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3953, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:76)", 3954, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:77)", 3955, "Numerical");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:82)", 3956, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:83)", 3957, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:84)", 3958, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:85)", 3959, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:86)", 3960, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:86)", 3961, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:87)", 3962, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:89)", 3963, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:90)", 3964, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:91)", 3965, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:92)", 3966, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:92)", 3967, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:93)", 3968, "Boolean");
        org.broadleafcommerce.common.payment.PaymentDeclineType.__L3969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentDeclineType.java:94)", 3969, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentDeclineType.initPerturbationLocation0();
    }
}

