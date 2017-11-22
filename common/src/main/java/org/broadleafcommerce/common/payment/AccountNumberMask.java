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


public class AccountNumberMask {
    private java.util.List<org.broadleafcommerce.common.payment.UnmaskRange> ranges;

    private char maskCharacter;

    public AccountNumberMask(java.util.List<org.broadleafcommerce.common.payment.UnmaskRange> ranges, char maskCharacter) {
        this.ranges = ranges;
        this.maskCharacter = maskCharacter;
    }

    public java.lang.String mask(java.lang.String accountNumber) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.AccountNumberMask.__L3857, (accountNumber == null))) {
            throw new java.lang.RuntimeException("account number is null");
        }
        char[] characters = accountNumber.toCharArray();
        char[] newCharacters = new char[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3858, characters.length)];
        java.util.Arrays.fill(newCharacters, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3859, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3860, newCharacters.length), maskCharacter);
        for (org.broadleafcommerce.common.payment.UnmaskRange range : ranges) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.AccountNumberMask.__L3863, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3861, range.getPositionType())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3862, org.broadleafcommerce.common.payment.UnmaskRange.BEGINNINGTYPE))))) {
                java.lang.System.arraycopy(characters, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3864, 0), newCharacters, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3865, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3866, range.getLength()));
            }else {
                java.lang.System.arraycopy(characters, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3869, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3867, characters.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3868, range.getLength())))), newCharacters, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3872, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3870, newCharacters.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3871, range.getLength())))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.AccountNumberMask.__L3873, range.getLength()));
            }
        }
        return new java.lang.String(newCharacters);
    }

    public static perturbation.location.PerturbationLocation __L3857;

    public static perturbation.location.PerturbationLocation __L3858;

    public static perturbation.location.PerturbationLocation __L3859;

    public static perturbation.location.PerturbationLocation __L3860;

    public static perturbation.location.PerturbationLocation __L3861;

    public static perturbation.location.PerturbationLocation __L3862;

    public static perturbation.location.PerturbationLocation __L3863;

    public static perturbation.location.PerturbationLocation __L3864;

    public static perturbation.location.PerturbationLocation __L3865;

    public static perturbation.location.PerturbationLocation __L3866;

    public static perturbation.location.PerturbationLocation __L3867;

    public static perturbation.location.PerturbationLocation __L3868;

    public static perturbation.location.PerturbationLocation __L3869;

    public static perturbation.location.PerturbationLocation __L3870;

    public static perturbation.location.PerturbationLocation __L3871;

    public static perturbation.location.PerturbationLocation __L3872;

    public static perturbation.location.PerturbationLocation __L3873;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:34)", 3857, "Boolean");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:38)", 3858, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:40)", 3859, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:40)", 3860, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:42)", 3861, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:42)", 3862, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:42)", 3863, "Boolean");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:43)", 3864, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:43)", 3865, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:43)", 3866, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3867, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3868, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3869, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3870, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3871, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3872, "Numerical");
        org.broadleafcommerce.common.payment.AccountNumberMask.__L3873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/AccountNumberMask.java:45)", 3873, "Numerical");
    }

    static {
        org.broadleafcommerce.common.payment.AccountNumberMask.initPerturbationLocation0();
    }
}

