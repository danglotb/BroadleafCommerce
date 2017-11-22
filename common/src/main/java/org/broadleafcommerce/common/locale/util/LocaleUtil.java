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


public final class LocaleUtil {
    public static java.lang.String findLanguageCode(org.broadleafcommerce.common.locale.domain.Locale locale) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3355, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3351, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3349, (locale != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3350, ((locale.getLocaleCode()) != null)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3354, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3352, locale.getLocaleCode().indexOf("_"))) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3353, 0)))))))) {
            int endIndex = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3356, locale.getLocaleCode().indexOf("_"));
            char[] localeCodeChars = locale.getLocaleCode().toCharArray();
            java.lang.StringBuffer sb = new java.lang.StringBuffer();
            for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3357, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3360, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3358, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3359, endIndex)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3361, (i++))) {
                sb.append(localeCodeChars[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.util.LocaleUtil.__L3362, i)]);
            }
            return sb.toString();
        }
        return null;
    }

    public static perturbation.location.PerturbationLocation __L3349;

    public static perturbation.location.PerturbationLocation __L3350;

    public static perturbation.location.PerturbationLocation __L3351;

    public static perturbation.location.PerturbationLocation __L3352;

    public static perturbation.location.PerturbationLocation __L3353;

    public static perturbation.location.PerturbationLocation __L3354;

    public static perturbation.location.PerturbationLocation __L3355;

    public static perturbation.location.PerturbationLocation __L3356;

    public static perturbation.location.PerturbationLocation __L3357;

    public static perturbation.location.PerturbationLocation __L3358;

    public static perturbation.location.PerturbationLocation __L3359;

    public static perturbation.location.PerturbationLocation __L3360;

    public static perturbation.location.PerturbationLocation __L3361;

    public static perturbation.location.PerturbationLocation __L3362;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3349, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3350, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3351, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3352, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3353, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3354, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:29)", 3355, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:30)", 3356, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:33)", 3357, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:33)", 3358, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:33)", 3359, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:33)", 3360, "Boolean");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:33)", 3361, "Numerical");
        org.broadleafcommerce.common.locale.util.LocaleUtil.__L3362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/util/LocaleUtil.java:34)", 3362, "Numerical");
    }

    static {
        org.broadleafcommerce.common.locale.util.LocaleUtil.initPerturbationLocation0();
    }
}

