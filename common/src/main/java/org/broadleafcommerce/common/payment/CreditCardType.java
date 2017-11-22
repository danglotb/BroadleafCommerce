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


public class CreditCardType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.CreditCardType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.CreditCardType>();

    public static final org.broadleafcommerce.common.payment.CreditCardType MASTERCARD = new org.broadleafcommerce.common.payment.CreditCardType("MASTERCARD", "Master Card");

    public static final org.broadleafcommerce.common.payment.CreditCardType VISA = new org.broadleafcommerce.common.payment.CreditCardType("VISA", "Visa");

    public static final org.broadleafcommerce.common.payment.CreditCardType AMEX = new org.broadleafcommerce.common.payment.CreditCardType("AMEX", "American Express");

    public static final org.broadleafcommerce.common.payment.CreditCardType DINERSCLUB_CARTEBLANCHE = new org.broadleafcommerce.common.payment.CreditCardType("DINERSCLUB_CARTEBLANCHE", "Diner's Club / Carte Blanche");

    public static final org.broadleafcommerce.common.payment.CreditCardType DISCOVER = new org.broadleafcommerce.common.payment.CreditCardType("DISCOVER", "Discover");

    public static final org.broadleafcommerce.common.payment.CreditCardType ENROUTE = new org.broadleafcommerce.common.payment.CreditCardType("ENROUTE", "En Route");

    public static final org.broadleafcommerce.common.payment.CreditCardType JCB = new org.broadleafcommerce.common.payment.CreditCardType("JCB", "JCB");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.CreditCardType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.CreditCardType.TYPES.get(type);
    }

    public CreditCardType() {
    }

    public CreditCardType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3875, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3874, org.broadleafcommerce.common.payment.CreditCardType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.CreditCardType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3876, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3877, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3885, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3880, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3878, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3879, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3884, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3881, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3882, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3883, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardType.__L3886, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3887, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3888, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3889, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3890, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3892, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3891, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3893, false);

        org.broadleafcommerce.common.payment.CreditCardType other = ((org.broadleafcommerce.common.payment.CreditCardType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3894, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3895, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3896, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3898, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3897, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3899, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardType.__L3900, true);
    }

    public static perturbation.location.PerturbationLocation __L3874;

    public static perturbation.location.PerturbationLocation __L3875;

    public static perturbation.location.PerturbationLocation __L3876;

    public static perturbation.location.PerturbationLocation __L3877;

    public static perturbation.location.PerturbationLocation __L3878;

    public static perturbation.location.PerturbationLocation __L3879;

    public static perturbation.location.PerturbationLocation __L3880;

    public static perturbation.location.PerturbationLocation __L3881;

    public static perturbation.location.PerturbationLocation __L3882;

    public static perturbation.location.PerturbationLocation __L3883;

    public static perturbation.location.PerturbationLocation __L3884;

    public static perturbation.location.PerturbationLocation __L3885;

    public static perturbation.location.PerturbationLocation __L3886;

    public static perturbation.location.PerturbationLocation __L3887;

    public static perturbation.location.PerturbationLocation __L3888;

    public static perturbation.location.PerturbationLocation __L3889;

    public static perturbation.location.PerturbationLocation __L3890;

    public static perturbation.location.PerturbationLocation __L3891;

    public static perturbation.location.PerturbationLocation __L3892;

    public static perturbation.location.PerturbationLocation __L3893;

    public static perturbation.location.PerturbationLocation __L3894;

    public static perturbation.location.PerturbationLocation __L3895;

    public static perturbation.location.PerturbationLocation __L3896;

    public static perturbation.location.PerturbationLocation __L3897;

    public static perturbation.location.PerturbationLocation __L3898;

    public static perturbation.location.PerturbationLocation __L3899;

    public static perturbation.location.PerturbationLocation __L3900;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.CreditCardType.__L3874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:72)", 3874, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:72)", 3875, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:79)", 3876, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:80)", 3877, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3878, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3879, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3880, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3881, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3882, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3883, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3884, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:81)", 3885, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:82)", 3886, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardType.__L3887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:87)", 3887, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:88)", 3888, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:89)", 3889, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:90)", 3890, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:91)", 3891, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:91)", 3892, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:92)", 3893, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:94)", 3894, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:95)", 3895, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:96)", 3896, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:97)", 3897, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:97)", 3898, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:98)", 3899, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardType.__L3900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardType.java:99)", 3900, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.CreditCardType.initPerturbationLocation0();
    }
}

