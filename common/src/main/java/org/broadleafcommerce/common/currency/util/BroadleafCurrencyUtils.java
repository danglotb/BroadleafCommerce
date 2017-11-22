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
package org.broadleafcommerce.common.currency.util;


public class BroadleafCurrencyUtils {
    protected static final java.util.Map<java.lang.String, java.text.NumberFormat> FORMAT_CACHE = new java.util.concurrent.ConcurrentHashMap<java.lang.String, java.text.NumberFormat>();

    public static final java.math.MathContext ROUND_FLOOR_MATH_CONTEXT = new java.math.MathContext(0, java.math.RoundingMode.FLOOR);

    public static org.broadleafcommerce.common.money.Money getMoney(java.math.BigDecimal amount, org.broadleafcommerce.common.currency.domain.BroadleafCurrency currency) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L705, (amount == null))) {
            return null;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L706, (currency != null))) {
            return new org.broadleafcommerce.common.money.Money(amount, currency.getCurrencyCode());
        }else {
            return new org.broadleafcommerce.common.money.Money(amount, org.broadleafcommerce.common.money.Money.defaultCurrency());
        }
    }

    public static org.broadleafcommerce.common.money.Money getMoney(java.math.BigDecimal amount) {
        return org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getMoney(amount, null);
    }

    public static org.broadleafcommerce.common.money.Money getMoney(org.broadleafcommerce.common.currency.domain.BroadleafCurrency currency) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L707, (currency != null))) {
            return new org.broadleafcommerce.common.money.Money(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L708, 0), currency.getCurrencyCode());
        }else {
            return new org.broadleafcommerce.common.money.Money();
        }
    }

    public static java.util.Currency getCurrency(org.broadleafcommerce.common.money.Money money) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L709, (money == null))) {
            return org.broadleafcommerce.common.money.Money.defaultCurrency();
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L710, ((money.getCurrency()) == null)) ? org.broadleafcommerce.common.money.Money.defaultCurrency() : money.getCurrency();
    }

    public static java.util.Currency getCurrency(org.broadleafcommerce.common.currency.domain.BroadleafCurrency currency) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L711, (currency == null)) ? org.broadleafcommerce.common.money.Money.defaultCurrency() : java.util.Currency.getInstance(currency.getCurrencyCode());
    }

    public static org.broadleafcommerce.common.money.Money getUnitAmount(org.broadleafcommerce.common.money.Money difference) {
        java.util.Currency currency = org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getCurrency(difference);
        java.math.BigDecimal divisor = new java.math.BigDecimal(java.lang.Math.pow(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L712, 10), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L713, currency.getDefaultFractionDigits())));
        java.math.BigDecimal unitAmount = new java.math.BigDecimal("1").divide(divisor);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L714, difference.lessThan(java.math.BigDecimal.ZERO))) {
            unitAmount = unitAmount.negate();
        }
        return new org.broadleafcommerce.common.money.Money(unitAmount, currency);
    }

    public static org.broadleafcommerce.common.money.Money getUnitAmount(org.broadleafcommerce.common.currency.domain.BroadleafCurrency blCurrency) {
        java.util.Currency currency = org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getCurrency(blCurrency);
        java.math.BigDecimal divisor = new java.math.BigDecimal(java.lang.Math.pow(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L715, 10), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L716, currency.getDefaultFractionDigits())));
        java.math.BigDecimal unitAmount = new java.math.BigDecimal("1").divide(divisor);
        return new org.broadleafcommerce.common.money.Money(unitAmount, currency);
    }

    public static int calculateRemainder(org.broadleafcommerce.common.money.Money totalAmount, int quantity) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L723, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L719, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L717, (totalAmount == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L718, totalAmount.isZero()))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L722, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L720, quantity)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L721, 0)))))))) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L724, 0);
        }
        java.math.BigDecimal multiplier = new java.math.BigDecimal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L725, 10)).pow(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L726, totalAmount.getAmount().scale()));
        java.math.BigDecimal amount = totalAmount.getAmount().multiply(multiplier);
        java.math.BigDecimal remainder = amount.remainder(new java.math.BigDecimal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L727, quantity)), org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.ROUND_FLOOR_MATH_CONTEXT);
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L729, perturbation.PerturbationEngine.pBigInteger(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L728, remainder.toBigInteger()).intValue());
    }

    public static java.text.NumberFormat getNumberFormatFromCache(java.util.Locale locale, java.util.Currency currency) {
        java.lang.String key = (locale.toString()) + (currency.getCurrencyCode());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L731, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L730, org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.FORMAT_CACHE.containsKey(key)))))) {
            java.text.NumberFormat format = java.text.NumberFormat.getCurrencyInstance(locale);
            format.setCurrency(currency);
            org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.FORMAT_CACHE.put(key, format);
        }
        return org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.FORMAT_CACHE.get(key);
    }

    public static perturbation.location.PerturbationLocation __L705;

    public static perturbation.location.PerturbationLocation __L706;

    public static perturbation.location.PerturbationLocation __L707;

    public static perturbation.location.PerturbationLocation __L708;

    public static perturbation.location.PerturbationLocation __L709;

    public static perturbation.location.PerturbationLocation __L710;

    public static perturbation.location.PerturbationLocation __L711;

    public static perturbation.location.PerturbationLocation __L712;

    public static perturbation.location.PerturbationLocation __L713;

    public static perturbation.location.PerturbationLocation __L714;

    public static perturbation.location.PerturbationLocation __L715;

    public static perturbation.location.PerturbationLocation __L716;

    public static perturbation.location.PerturbationLocation __L717;

    public static perturbation.location.PerturbationLocation __L718;

    public static perturbation.location.PerturbationLocation __L719;

    public static perturbation.location.PerturbationLocation __L720;

    public static perturbation.location.PerturbationLocation __L721;

    public static perturbation.location.PerturbationLocation __L722;

    public static perturbation.location.PerturbationLocation __L723;

    public static perturbation.location.PerturbationLocation __L724;

    public static perturbation.location.PerturbationLocation __L725;

    public static perturbation.location.PerturbationLocation __L726;

    public static perturbation.location.PerturbationLocation __L727;

    public static perturbation.location.PerturbationLocation __L728;

    public static perturbation.location.PerturbationLocation __L729;

    public static perturbation.location.PerturbationLocation __L730;

    public static perturbation.location.PerturbationLocation __L731;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:46)", 705, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:50)", 706, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:62)", 707, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:63)", 708, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:70)", 709, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:73)", 710, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:77)", 711, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:88)", 712, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:88)", 713, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:91)", 714, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:105)", 715, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:105)", 716, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 717, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 718, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 719, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 720, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 721, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 722, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:119)", 723, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:120)", 724, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:124)", 725, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:124)", 726, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:127)", 727, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:128)", 728, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:128)", 729, "Numerical");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:141)", 730, "Boolean");
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.__L731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/util/BroadleafCurrencyUtils.java:141)", 731, "Boolean");
    }

    static {
        org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.initPerturbationLocation0();
    }
}

