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


public class CreditCardTypeCheck {
    public static org.broadleafcommerce.common.payment.CreditCardType getCreditCardType(java.lang.String pan) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3901, pan.matches("(51)?(52)?(53)?(54)?(55)?[0-9]{14}"))) {
            return org.broadleafcommerce.common.payment.CreditCardType.MASTERCARD;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3904, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3902, pan.matches("4[0-9]{15}"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3903, pan.matches("4[0-9]{12}")))))) {
            return org.broadleafcommerce.common.payment.CreditCardType.VISA;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3905, pan.matches("(34)?(37)?[0-9]{13}"))) {
            return org.broadleafcommerce.common.payment.CreditCardType.AMEX;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3908, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3906, pan.matches("(300)?(301)?(302)?(303)?(304)?(305)?[0-9]{11}"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3907, pan.matches("(36)?(38)?[0-9]{12}")))))) {
            return org.broadleafcommerce.common.payment.CreditCardType.DINERSCLUB_CARTEBLANCHE;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3909, pan.matches("6011[0-9]{12}"))) {
            return org.broadleafcommerce.common.payment.CreditCardType.DISCOVER;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3910, pan.matches("(2014)?(2149)?[0-9]{11}"))) {
            return org.broadleafcommerce.common.payment.CreditCardType.ENROUTE;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3913, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3911, pan.matches("3[0-9]{15}"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3912, pan.matches("(2131)?(1800)?[0-9]{11}")))))) {
            return org.broadleafcommerce.common.payment.CreditCardType.JCB;
        }
        java.util.ArrayList<org.broadleafcommerce.common.payment.UnmaskRange> ranges = new java.util.ArrayList<org.broadleafcommerce.common.payment.UnmaskRange>();
        ranges.add(new org.broadleafcommerce.common.payment.UnmaskRange(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3914, org.broadleafcommerce.common.payment.UnmaskRange.BEGINNINGTYPE), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3915, 4)));
        org.broadleafcommerce.common.payment.AccountNumberMask mask = new org.broadleafcommerce.common.payment.AccountNumberMask(ranges, 'X');
        throw new java.lang.RuntimeException(("Unable to determine credit card type for pan :" + (mask.mask(pan))));
    }

    public static perturbation.location.PerturbationLocation __L3901;

    public static perturbation.location.PerturbationLocation __L3902;

    public static perturbation.location.PerturbationLocation __L3903;

    public static perturbation.location.PerturbationLocation __L3904;

    public static perturbation.location.PerturbationLocation __L3905;

    public static perturbation.location.PerturbationLocation __L3906;

    public static perturbation.location.PerturbationLocation __L3907;

    public static perturbation.location.PerturbationLocation __L3908;

    public static perturbation.location.PerturbationLocation __L3909;

    public static perturbation.location.PerturbationLocation __L3910;

    public static perturbation.location.PerturbationLocation __L3911;

    public static perturbation.location.PerturbationLocation __L3912;

    public static perturbation.location.PerturbationLocation __L3913;

    public static perturbation.location.PerturbationLocation __L3914;

    public static perturbation.location.PerturbationLocation __L3915;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:25)", 3901, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:28)", 3902, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:28)", 3903, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:28)", 3904, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:31)", 3905, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:34)", 3906, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:34)", 3907, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:34)", 3908, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:37)", 3909, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:40)", 3910, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:43)", 3911, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:43)", 3912, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:43)", 3913, "Boolean");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:48)", 3914, "Numerical");
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.__L3915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/CreditCardTypeCheck.java:48)", 3915, "Numerical");
    }

    static {
        org.broadleafcommerce.common.payment.CreditCardTypeCheck.initPerturbationLocation0();
    }
}

