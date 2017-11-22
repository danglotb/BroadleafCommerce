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


public class PaymentGatewayType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentGatewayType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentGatewayType>();

    public static final org.broadleafcommerce.common.payment.PaymentGatewayType TEMPORARY = new org.broadleafcommerce.common.payment.PaymentGatewayType("Temporary", "This is a temporary Order Payment");

    public static final org.broadleafcommerce.common.payment.PaymentGatewayType PASSTHROUGH = new org.broadleafcommerce.common.payment.PaymentGatewayType("Passthrough", "Passthrough Payment");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.PaymentGatewayType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentGatewayType.TYPES.get(type);
    }

    public PaymentGatewayType() {
    }

    public PaymentGatewayType(java.lang.String type, java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L3998, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L3997, org.broadleafcommerce.common.payment.PaymentGatewayType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentGatewayType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L3999, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4000, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4008, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4003, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4001, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4002, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4007, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4004, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4005, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4006, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4009, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4010, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4011, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4012, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4013, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4015, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4014, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4016, false);

        org.broadleafcommerce.common.payment.PaymentGatewayType other = ((org.broadleafcommerce.common.payment.PaymentGatewayType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4017, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4018, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4019, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4021, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4020, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4022, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentGatewayType.__L4023, true);
    }

    public static perturbation.location.PerturbationLocation __L3997;

    public static perturbation.location.PerturbationLocation __L3998;

    public static perturbation.location.PerturbationLocation __L3999;

    public static perturbation.location.PerturbationLocation __L4000;

    public static perturbation.location.PerturbationLocation __L4001;

    public static perturbation.location.PerturbationLocation __L4002;

    public static perturbation.location.PerturbationLocation __L4003;

    public static perturbation.location.PerturbationLocation __L4004;

    public static perturbation.location.PerturbationLocation __L4005;

    public static perturbation.location.PerturbationLocation __L4006;

    public static perturbation.location.PerturbationLocation __L4007;

    public static perturbation.location.PerturbationLocation __L4008;

    public static perturbation.location.PerturbationLocation __L4009;

    public static perturbation.location.PerturbationLocation __L4010;

    public static perturbation.location.PerturbationLocation __L4011;

    public static perturbation.location.PerturbationLocation __L4012;

    public static perturbation.location.PerturbationLocation __L4013;

    public static perturbation.location.PerturbationLocation __L4014;

    public static perturbation.location.PerturbationLocation __L4015;

    public static perturbation.location.PerturbationLocation __L4016;

    public static perturbation.location.PerturbationLocation __L4017;

    public static perturbation.location.PerturbationLocation __L4018;

    public static perturbation.location.PerturbationLocation __L4019;

    public static perturbation.location.PerturbationLocation __L4020;

    public static perturbation.location.PerturbationLocation __L4021;

    public static perturbation.location.PerturbationLocation __L4022;

    public static perturbation.location.PerturbationLocation __L4023;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L3997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:89)", 3997, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L3998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:89)", 3998, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L3999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:96)", 3999, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:97)", 4000, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4001, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4002, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4003, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4004, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4005, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4006, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4007, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:98)", 4008, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:99)", 4009, "Numerical");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:104)", 4010, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:105)", 4011, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:106)", 4012, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:107)", 4013, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:108)", 4014, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:108)", 4015, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:109)", 4016, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:111)", 4017, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:112)", 4018, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:113)", 4019, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:114)", 4020, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:114)", 4021, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:115)", 4022, "Boolean");
        org.broadleafcommerce.common.payment.PaymentGatewayType.__L4023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentGatewayType.java:116)", 4023, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentGatewayType.initPerturbationLocation0();
    }
}

