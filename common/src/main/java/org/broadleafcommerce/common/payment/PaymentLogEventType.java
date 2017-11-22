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


public class PaymentLogEventType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentLogEventType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentLogEventType>();

    public static final org.broadleafcommerce.common.payment.PaymentLogEventType START = new org.broadleafcommerce.common.payment.PaymentLogEventType("START", "Start");

    public static final org.broadleafcommerce.common.payment.PaymentLogEventType FINISHED = new org.broadleafcommerce.common.payment.PaymentLogEventType("FINISHED", "Finished");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.PaymentLogEventType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentLogEventType.TYPES.get(type);
    }

    public PaymentLogEventType() {
    }

    public PaymentLogEventType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4025, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4024, org.broadleafcommerce.common.payment.PaymentLogEventType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentLogEventType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4026, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4027, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4035, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4030, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4028, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4029, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4034, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4031, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4032, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4033, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4036, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4037, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4038, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4039, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4040, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4042, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4041, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4043, false);

        org.broadleafcommerce.common.payment.PaymentLogEventType other = ((org.broadleafcommerce.common.payment.PaymentLogEventType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4044, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4045, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4046, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4048, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4047, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4049, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentLogEventType.__L4050, true);
    }

    public static perturbation.location.PerturbationLocation __L4024;

    public static perturbation.location.PerturbationLocation __L4025;

    public static perturbation.location.PerturbationLocation __L4026;

    public static perturbation.location.PerturbationLocation __L4027;

    public static perturbation.location.PerturbationLocation __L4028;

    public static perturbation.location.PerturbationLocation __L4029;

    public static perturbation.location.PerturbationLocation __L4030;

    public static perturbation.location.PerturbationLocation __L4031;

    public static perturbation.location.PerturbationLocation __L4032;

    public static perturbation.location.PerturbationLocation __L4033;

    public static perturbation.location.PerturbationLocation __L4034;

    public static perturbation.location.PerturbationLocation __L4035;

    public static perturbation.location.PerturbationLocation __L4036;

    public static perturbation.location.PerturbationLocation __L4037;

    public static perturbation.location.PerturbationLocation __L4038;

    public static perturbation.location.PerturbationLocation __L4039;

    public static perturbation.location.PerturbationLocation __L4040;

    public static perturbation.location.PerturbationLocation __L4041;

    public static perturbation.location.PerturbationLocation __L4042;

    public static perturbation.location.PerturbationLocation __L4043;

    public static perturbation.location.PerturbationLocation __L4044;

    public static perturbation.location.PerturbationLocation __L4045;

    public static perturbation.location.PerturbationLocation __L4046;

    public static perturbation.location.PerturbationLocation __L4047;

    public static perturbation.location.PerturbationLocation __L4048;

    public static perturbation.location.PerturbationLocation __L4049;

    public static perturbation.location.PerturbationLocation __L4050;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:67)", 4024, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:67)", 4025, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:74)", 4026, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:75)", 4027, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4028, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4029, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4030, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4031, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4032, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4033, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4034, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:76)", 4035, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:77)", 4036, "Numerical");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:82)", 4037, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:83)", 4038, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:84)", 4039, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4040 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:85)", 4040, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4041 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:86)", 4041, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4042 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:86)", 4042, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:87)", 4043, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:89)", 4044, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:90)", 4045, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:91)", 4046, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:92)", 4047, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:92)", 4048, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:93)", 4049, "Boolean");
        org.broadleafcommerce.common.payment.PaymentLogEventType.__L4050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentLogEventType.java:94)", 4050, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentLogEventType.initPerturbationLocation0();
    }
}

