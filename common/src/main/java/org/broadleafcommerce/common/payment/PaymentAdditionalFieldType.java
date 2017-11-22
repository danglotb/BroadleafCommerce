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


public class PaymentAdditionalFieldType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.payment.PaymentAdditionalFieldType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.payment.PaymentAdditionalFieldType>();

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType NAME_ON_CARD = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("NAME_ON_CARD", "Cardholders Name");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType CARD_TYPE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("CARD_TYPE", "Card Type");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType EXP_DATE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("EXP_DATE", "Expiration Date");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType EXP_MONTH = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("EXP_MONTH", "Expiration Month");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType EXP_YEAR = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("EXP_YEAR", "Expiration Year");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType PAYMENT_TYPE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("PAYMENT_TYPE", "Type of OrderPayment");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType GATEWAY_TYPE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("GATEWAY_TYPE", "Gateway Type");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType NAME_ON_ACCOUNT = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("NAME_ON_ACCOUNT", "Name on Account");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType ACCOUNT_TYPE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("ACCOUNT_TYPE", "Account Type");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType LAST_FOUR = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("LAST_FOUR", "Last Four Digits ofAccount or CC");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType GIFT_CARD_NUM = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("GIFT_CARD_NUM", "Gift Card Number");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType EMAIL = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("EMAIL", "Email");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType ACCOUNT_CREDIT_NUM = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("ACCOUNT_CREDIT_NUM", "Account Credit Number");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType AUTH_CODE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("AUTH_CODE", "Authorization Code");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType REQUEST_ID = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("REQUEST_ID", "Request Id");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType SUBSCRIPTION_ID = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("SUBSCRIPTION_ID", "Subscription Id");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType SUBSCRIPTION_TITLE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("SUBSCRIPTION_TITLE", "Subscription Title");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType TOKEN = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("TOKEN", "Payment Token");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType DECLINE_TYPE = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("DECLINE_TYPE", "Decline Type");

    public static final org.broadleafcommerce.common.payment.PaymentAdditionalFieldType PAYMENT_NAME = new org.broadleafcommerce.common.payment.PaymentAdditionalFieldType("PAYMENT_NAME", "Payment Name");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.payment.PaymentAdditionalFieldType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.TYPES.get(type);
    }

    public PaymentAdditionalFieldType() {
    }

    public PaymentAdditionalFieldType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3917, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3916, org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3918, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3919, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3927, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3922, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3920, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3921, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3926, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3923, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3924, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3925, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3928, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3929, ((this) == obj))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3930, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3931, (obj == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3932, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3934, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3933, getClass().isAssignableFrom(obj.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3935, false);
        }
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType other = ((org.broadleafcommerce.common.payment.PaymentAdditionalFieldType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3936, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3937, ((other.type) != null))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3938, false);
            }
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3940, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3939, type.equals(other.type)))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3941, false);
            }

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3942, true);
    }

    public static perturbation.location.PerturbationLocation __L3916;

    public static perturbation.location.PerturbationLocation __L3917;

    public static perturbation.location.PerturbationLocation __L3918;

    public static perturbation.location.PerturbationLocation __L3919;

    public static perturbation.location.PerturbationLocation __L3920;

    public static perturbation.location.PerturbationLocation __L3921;

    public static perturbation.location.PerturbationLocation __L3922;

    public static perturbation.location.PerturbationLocation __L3923;

    public static perturbation.location.PerturbationLocation __L3924;

    public static perturbation.location.PerturbationLocation __L3925;

    public static perturbation.location.PerturbationLocation __L3926;

    public static perturbation.location.PerturbationLocation __L3927;

    public static perturbation.location.PerturbationLocation __L3928;

    public static perturbation.location.PerturbationLocation __L3929;

    public static perturbation.location.PerturbationLocation __L3930;

    public static perturbation.location.PerturbationLocation __L3931;

    public static perturbation.location.PerturbationLocation __L3932;

    public static perturbation.location.PerturbationLocation __L3933;

    public static perturbation.location.PerturbationLocation __L3934;

    public static perturbation.location.PerturbationLocation __L3935;

    public static perturbation.location.PerturbationLocation __L3936;

    public static perturbation.location.PerturbationLocation __L3937;

    public static perturbation.location.PerturbationLocation __L3938;

    public static perturbation.location.PerturbationLocation __L3939;

    public static perturbation.location.PerturbationLocation __L3940;

    public static perturbation.location.PerturbationLocation __L3941;

    public static perturbation.location.PerturbationLocation __L3942;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:84)", 3916, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:84)", 3917, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:91)", 3918, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:92)", 3919, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3920, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3921, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3922, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3923, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3924, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3925, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3926, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:93)", 3927, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:94)", 3928, "Numerical");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:99)", 3929, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:100)", 3930, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:102)", 3931, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:103)", 3932, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:105)", 3933, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:105)", 3934, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:106)", 3935, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:109)", 3936, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:110)", 3937, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:111)", 3938, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:113)", 3939, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:113)", 3940, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:114)", 3941, "Boolean");
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.__L3942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/PaymentAdditionalFieldType.java:116)", 3942, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.PaymentAdditionalFieldType.initPerturbationLocation0();
    }
}

