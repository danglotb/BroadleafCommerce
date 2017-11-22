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
package org.broadleafcommerce.common.money;


public final class BankersRounding {
    public static final int DEFAULT_SCALE = 2;

    public static final java.math.BigDecimal ZERO = org.broadleafcommerce.common.money.BankersRounding.setScale(0);

    public static int getScaleForCurrency(java.util.Currency currency) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.BankersRounding.__L3547, (currency != null))) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3548, currency.getDefaultFractionDigits());
        }else {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3549, org.broadleafcommerce.common.money.BankersRounding.DEFAULT_SCALE);
        }
    }

    public static java.math.BigDecimal setScale(int scale, java.math.BigDecimal amount) {
        return amount.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3550, scale), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3551, java.math.BigDecimal.ROUND_HALF_EVEN));
    }

    public static java.math.BigDecimal setScale(int scale, double amount) {
        return org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3552, scale), new java.math.BigDecimal(amount));
    }

    public static double multiply(int scale, double multiplicand, double multiplier) {
        return org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3553, scale), multiplicand).multiply(org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3554, scale), multiplier)).doubleValue();
    }

    public static java.math.BigDecimal divide(int scale, java.math.BigDecimal dividend, java.math.BigDecimal divisor) {
        return dividend.divide(divisor, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3555, scale), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3556, java.math.BigDecimal.ROUND_HALF_EVEN));
    }

    public static double divide(int scale, double dividend, double divisor) {
        return org.broadleafcommerce.common.money.BankersRounding.divide(org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3557, scale), dividend), org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3558, scale), divisor)).doubleValue();
    }

    public static java.math.BigDecimal setScale(java.math.BigDecimal amount) {
        return org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3559, org.broadleafcommerce.common.money.BankersRounding.DEFAULT_SCALE), amount);
    }

    public static java.math.BigDecimal setScale(java.math.BigDecimal amount, int scale) {
        return org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3560, scale), amount);
    }

    public static java.math.BigDecimal setScale(double amount) {
        return org.broadleafcommerce.common.money.BankersRounding.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3561, org.broadleafcommerce.common.money.BankersRounding.DEFAULT_SCALE), new java.math.BigDecimal(amount));
    }

    public static java.math.BigDecimal divide(java.math.BigDecimal dividend, java.math.BigDecimal divisor) {
        return org.broadleafcommerce.common.money.BankersRounding.divide(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.BankersRounding.__L3562, org.broadleafcommerce.common.money.BankersRounding.DEFAULT_SCALE), dividend, divisor);
    }

    public static java.math.BigDecimal zeroAmount() {
        return org.broadleafcommerce.common.money.BankersRounding.ZERO;
    }

    public static perturbation.location.PerturbationLocation __L3547;

    public static perturbation.location.PerturbationLocation __L3548;

    public static perturbation.location.PerturbationLocation __L3549;

    public static perturbation.location.PerturbationLocation __L3550;

    public static perturbation.location.PerturbationLocation __L3551;

    public static perturbation.location.PerturbationLocation __L3552;

    public static perturbation.location.PerturbationLocation __L3553;

    public static perturbation.location.PerturbationLocation __L3554;

    public static perturbation.location.PerturbationLocation __L3555;

    public static perturbation.location.PerturbationLocation __L3556;

    public static perturbation.location.PerturbationLocation __L3557;

    public static perturbation.location.PerturbationLocation __L3558;

    public static perturbation.location.PerturbationLocation __L3559;

    public static perturbation.location.PerturbationLocation __L3560;

    public static perturbation.location.PerturbationLocation __L3561;

    public static perturbation.location.PerturbationLocation __L3562;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.money.BankersRounding.__L3547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:30)", 3547, "Boolean");
        org.broadleafcommerce.common.money.BankersRounding.__L3548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:31)", 3548, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:33)", 3549, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:38)", 3550, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:38)", 3551, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:42)", 3552, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:46)", 3553, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:46)", 3554, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:50)", 3555, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:50)", 3556, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:54)", 3557, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:54)", 3558, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:58)", 3559, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:62)", 3560, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:66)", 3561, "Numerical");
        org.broadleafcommerce.common.money.BankersRounding.__L3562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/BankersRounding.java:70)", 3562, "Numerical");
    }

    static {
        org.broadleafcommerce.common.money.BankersRounding.initPerturbationLocation0();
    }
}

