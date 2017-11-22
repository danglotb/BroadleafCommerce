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


public class Mod43CheckDigitUtil {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.class);

    private static final java.lang.String CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    public static boolean isValidCheckedValue(java.lang.String value) {
        boolean valid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6358, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6362, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6359, (value != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6361, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6360, "".equals(value))))))))) {
            java.lang.String code = value.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6363, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6366, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6364, value.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6365, 1)))));
            char checkDigit = value.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6369, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6367, value.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6368, 1))))).charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6370, 0));
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6371, ((org.broadleafcommerce.common.util.Mod43CheckDigitUtil.generateCheckDigit(code)) == checkDigit))) {
                    valid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6372, true);
                }
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.util.Mod43CheckDigitUtil.LOG.error("Error generating check digit.", e);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6373, valid);
    }

    public static char generateCheckDigit(java.lang.String data) {
        int sum = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6374, 0);
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6375, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6378, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6376, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6377, data.length())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6379, (++i))) {
            sum += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6381, org.broadleafcommerce.common.util.Mod43CheckDigitUtil.CHARSET.indexOf(data.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6380, i))));
        }
        int remainder = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6384, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6382, sum)) % (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6383, 43))));
        return org.broadleafcommerce.common.util.Mod43CheckDigitUtil.CHARSET.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6385, remainder));
    }

    public static perturbation.location.PerturbationLocation __L6358;

    public static perturbation.location.PerturbationLocation __L6359;

    public static perturbation.location.PerturbationLocation __L6360;

    public static perturbation.location.PerturbationLocation __L6361;

    public static perturbation.location.PerturbationLocation __L6362;

    public static perturbation.location.PerturbationLocation __L6363;

    public static perturbation.location.PerturbationLocation __L6364;

    public static perturbation.location.PerturbationLocation __L6365;

    public static perturbation.location.PerturbationLocation __L6366;

    public static perturbation.location.PerturbationLocation __L6367;

    public static perturbation.location.PerturbationLocation __L6368;

    public static perturbation.location.PerturbationLocation __L6369;

    public static perturbation.location.PerturbationLocation __L6370;

    public static perturbation.location.PerturbationLocation __L6371;

    public static perturbation.location.PerturbationLocation __L6372;

    public static perturbation.location.PerturbationLocation __L6373;

    public static perturbation.location.PerturbationLocation __L6374;

    public static perturbation.location.PerturbationLocation __L6375;

    public static perturbation.location.PerturbationLocation __L6376;

    public static perturbation.location.PerturbationLocation __L6377;

    public static perturbation.location.PerturbationLocation __L6378;

    public static perturbation.location.PerturbationLocation __L6379;

    public static perturbation.location.PerturbationLocation __L6380;

    public static perturbation.location.PerturbationLocation __L6381;

    public static perturbation.location.PerturbationLocation __L6382;

    public static perturbation.location.PerturbationLocation __L6383;

    public static perturbation.location.PerturbationLocation __L6384;

    public static perturbation.location.PerturbationLocation __L6385;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:30)", 6358, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:31)", 6359, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:31)", 6360, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:31)", 6361, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:31)", 6362, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:32)", 6363, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:32)", 6364, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:32)", 6365, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:32)", 6366, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:33)", 6367, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:33)", 6368, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:33)", 6369, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:33)", 6370, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:35)", 6371, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:36)", 6372, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:42)", 6373, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:47)", 6374, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:48)", 6375, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:48)", 6376, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:48)", 6377, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:48)", 6378, "Boolean");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:48)", 6379, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:49)", 6380, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:49)", 6381, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:51)", 6382, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:51)", 6383, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:51)", 6384, "Numerical");
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.__L6385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/Mod43CheckDigitUtil.java:52)", 6385, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.Mod43CheckDigitUtil.initPerturbationLocation0();
    }
}

