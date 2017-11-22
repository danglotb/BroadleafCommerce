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
package org.broadleafcommerce.common.util;


public class BLCPaymentMethodUtils {
    public static java.util.List<java.lang.String> getExpirationMonthOptions() {
        java.text.DateFormatSymbols dateFormatter;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6162, org.broadleafcommerce.common.web.BroadleafRequestContext.hasLocale())) {
            java.util.Locale locale = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getJavaLocale();
            dateFormatter = new java.text.DateFormatSymbols(locale);
        }else {
            dateFormatter = new java.text.DateFormatSymbols();
        }
        java.util.List<java.lang.String> expirationMonths = new java.util.ArrayList<>();
        java.text.NumberFormat formatter = new java.text.DecimalFormat("00");
        java.lang.String[] months = dateFormatter.getMonths();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6163, 1); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6166, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6164, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6165, months.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6167, (i++))) {
            expirationMonths.add((((formatter.format(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6168, i))) + " - ") + (months[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6171, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6169, i)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6170, 1))))])));
        }
        return expirationMonths;
    }

    public static java.util.List<java.lang.String> getExpirationYearOptions() {
        java.util.List<java.lang.String> expirationYears = new java.util.ArrayList<>();
        org.joda.time.DateTime dateTime = new org.joda.time.DateTime();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6172, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6175, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6173, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6174, 10)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6176, (i++))) {
            expirationYears.add(((dateTime.plusYears(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6177, i)).getYear()) + ""));
        }
        return expirationYears;
    }

    public static perturbation.location.PerturbationLocation __L6162;

    public static perturbation.location.PerturbationLocation __L6163;

    public static perturbation.location.PerturbationLocation __L6164;

    public static perturbation.location.PerturbationLocation __L6165;

    public static perturbation.location.PerturbationLocation __L6166;

    public static perturbation.location.PerturbationLocation __L6167;

    public static perturbation.location.PerturbationLocation __L6168;

    public static perturbation.location.PerturbationLocation __L6169;

    public static perturbation.location.PerturbationLocation __L6170;

    public static perturbation.location.PerturbationLocation __L6171;

    public static perturbation.location.PerturbationLocation __L6172;

    public static perturbation.location.PerturbationLocation __L6173;

    public static perturbation.location.PerturbationLocation __L6174;

    public static perturbation.location.PerturbationLocation __L6175;

    public static perturbation.location.PerturbationLocation __L6176;

    public static perturbation.location.PerturbationLocation __L6177;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:46)", 6162, "Boolean");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:55)", 6163, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:55)", 6164, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:55)", 6165, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:55)", 6166, "Boolean");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:55)", 6167, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:56)", 6168, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:56)", 6169, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:56)", 6170, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:56)", 6171, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:70)", 6172, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:70)", 6173, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:70)", 6174, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:70)", 6175, "Boolean");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:70)", 6176, "Numerical");
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.__L6177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCPaymentMethodUtils.java:71)", 6177, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.BLCPaymentMethodUtils.initPerturbationLocation0();
    }
}

