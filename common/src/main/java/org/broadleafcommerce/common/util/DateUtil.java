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


public class DateUtil {
    public static final long ONE_HOUR_MILLIS = ((long) ((60 * 60) * 1000));

    public static final long ONE_DAY_MILLIS = (org.broadleafcommerce.common.util.DateUtil.ONE_HOUR_MILLIS) * 24;

    public static final long ONE_WEEK_MILLIS = (org.broadleafcommerce.common.util.DateUtil.ONE_DAY_MILLIS) * 7;

    public static final long ONE_HOUR_SECONDS = ((long) (60 * 60));

    public static final long ONE_DAY_SECONDS = (org.broadleafcommerce.common.util.DateUtil.ONE_HOUR_SECONDS) * 24;

    public static final long ONE_WEEK_SECONDS = (org.broadleafcommerce.common.util.DateUtil.ONE_DAY_SECONDS) * 7;

    public static final long SIX_MONTHS_SECONDS = ((org.broadleafcommerce.common.util.DateUtil.ONE_DAY_SECONDS) * 6) * 30;

    public static boolean isActive(java.util.Date startDate, java.util.Date endDate, boolean includeTime) {
        java.lang.Long date = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.DateUtil.__L6232, ((long) (org.broadleafcommerce.common.time.SystemTime.asMillis(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6231, includeTime)))));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6240, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6239, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6235, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6233, (startDate == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6234, ((startDate.getTime()) >= date)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6238, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6236, (endDate != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6237, ((endDate.getTime()) < date)))))))))));
    }

    public static java.util.Date getCurrentDateAfterFactoringInDateResolution(java.util.Date cachedDate, java.lang.Long currentDateResolution) {
        java.util.Date returnDate = org.broadleafcommerce.common.time.SystemTime.getCurrentDateWithinTimeResolution(cachedDate, currentDateResolution);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6241, (returnDate != cachedDate))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DateUtil.__L6242, org.broadleafcommerce.common.time.SystemTime.shouldCacheDate())) {
                cachedDate.setTime(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.DateUtil.__L6243, returnDate.getTime()));
            }
        }
        return returnDate;
    }

    public static perturbation.location.PerturbationLocation __L6231;

    public static perturbation.location.PerturbationLocation __L6232;

    public static perturbation.location.PerturbationLocation __L6233;

    public static perturbation.location.PerturbationLocation __L6234;

    public static perturbation.location.PerturbationLocation __L6235;

    public static perturbation.location.PerturbationLocation __L6236;

    public static perturbation.location.PerturbationLocation __L6237;

    public static perturbation.location.PerturbationLocation __L6238;

    public static perturbation.location.PerturbationLocation __L6239;

    public static perturbation.location.PerturbationLocation __L6240;

    public static perturbation.location.PerturbationLocation __L6241;

    public static perturbation.location.PerturbationLocation __L6242;

    public static perturbation.location.PerturbationLocation __L6243;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.DateUtil.__L6231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:48)", 6231, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:48)", 6232, "Numerical");
        org.broadleafcommerce.common.util.DateUtil.__L6233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6233, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6234, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6235, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6236, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6237, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6238, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6239, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:49)", 6240, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:69)", 6241, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:70)", 6242, "Boolean");
        org.broadleafcommerce.common.util.DateUtil.__L6243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DateUtil.java:71)", 6243, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.DateUtil.initPerturbationLocation0();
    }
}

