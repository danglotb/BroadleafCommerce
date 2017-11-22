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
package org.broadleafcommerce.common.locale.util;


public class LocaleConverter implements org.springframework.core.convert.converter.Converter<java.lang.String, java.util.Locale> {
    @java.lang.Override
    public java.util.Locale convert(java.lang.String localeString) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3333, (localeString == null))) {
            return null;
        }
        java.lang.String[] components = localeString.split("_");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3336, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3334, components.length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3335, 1))))) {
            return new java.util.Locale(components[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3337, 0)]);
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3340, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3338, components.length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3339, 2))))) {
                return new java.util.Locale(components[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3341, 0)], components[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3342, 1)]);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3345, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3343, components.length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3344, 3))))) {
                    return new java.util.Locale(components[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3346, 0)], components[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3347, 1)], components[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleConverter.__L3348, 2)]);
                }


        return null;
    }

    public static perturbation.location.PerturbationLocation __L3333;

    public static perturbation.location.PerturbationLocation __L3334;

    public static perturbation.location.PerturbationLocation __L3335;

    public static perturbation.location.PerturbationLocation __L3336;

    public static perturbation.location.PerturbationLocation __L3337;

    public static perturbation.location.PerturbationLocation __L3338;

    public static perturbation.location.PerturbationLocation __L3339;

    public static perturbation.location.PerturbationLocation __L3340;

    public static perturbation.location.PerturbationLocation __L3341;

    public static perturbation.location.PerturbationLocation __L3342;

    public static perturbation.location.PerturbationLocation __L3343;

    public static perturbation.location.PerturbationLocation __L3344;

    public static perturbation.location.PerturbationLocation __L3345;

    public static perturbation.location.PerturbationLocation __L3346;

    public static perturbation.location.PerturbationLocation __L3347;

    public static perturbation.location.PerturbationLocation __L3348;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:28)", 3333, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:32)", 3334, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:32)", 3335, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:32)", 3336, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:33)", 3337, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:34)", 3338, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:34)", 3339, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:34)", 3340, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:35)", 3341, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:35)", 3342, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:36)", 3343, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:36)", 3344, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:36)", 3345, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:37)", 3346, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:37)", 3347, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleConverter.__L3348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleConverter.java:37)", 3348, "Numerical");
    }

    static {
        org.broadleafcommerce.common.locale.util.LocaleConverter.initPerturbationLocation0();
    }
}

