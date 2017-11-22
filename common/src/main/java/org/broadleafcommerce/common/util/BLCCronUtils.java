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


public class BLCCronUtils {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.BLCCronUtils.class);

    public static java.util.Date getNextValidTime(java.lang.String cron) {
        java.util.Date nextValidTime = null;
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCronUtils.__L6097, org.apache.commons.lang3.StringUtils.isNotBlank(cron))) {
                nextValidTime = new org.quartz.CronExpression(cron).getNextValidTimeAfter(new java.util.Date());
            }
        } catch (java.text.ParseException e) {
            org.broadleafcommerce.common.util.BLCCronUtils.LOG.warn(("Unable to parse the given cron expression: " + cron), e);
        }
        return nextValidTime;
    }

    public static boolean isValidExpression(java.lang.String cron) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCronUtils.__L6100, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCronUtils.__L6098, org.apache.commons.lang3.StringUtils.isNotBlank(cron))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCronUtils.__L6099, org.quartz.CronExpression.isValidExpression(cron)))));
    }

    public static perturbation.location.PerturbationLocation __L6097;

    public static perturbation.location.PerturbationLocation __L6098;

    public static perturbation.location.PerturbationLocation __L6099;

    public static perturbation.location.PerturbationLocation __L6100;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCCronUtils.__L6097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCronUtils.java:46)", 6097, "Boolean");
        org.broadleafcommerce.common.util.BLCCronUtils.__L6098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCronUtils.java:63)", 6098, "Boolean");
        org.broadleafcommerce.common.util.BLCCronUtils.__L6099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCronUtils.java:63)", 6099, "Boolean");
        org.broadleafcommerce.common.util.BLCCronUtils.__L6100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCronUtils.java:63)", 6100, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCCronUtils.initPerturbationLocation0();
    }
}

