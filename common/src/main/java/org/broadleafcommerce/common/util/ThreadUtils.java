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


public class ThreadUtils {
    public static void sleepUntil(int year, int month, int day, int hour, int min, int sec) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6763, year), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6764, month), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6765, day), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6766, hour), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6767, min), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6768, sec));
        long msFuture = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6769, cal.getTime().getTime());
        long msNow = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6770, java.lang.System.currentTimeMillis());
        long msSleep = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6773, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6771, msFuture)) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6772, msNow))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ThreadUtils.__L6776, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6774, msSleep)) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.ThreadUtils.__L6775, 0))))) {
            return ;
        }
        try {
            java.lang.Thread.sleep(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6779, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6777, msFuture)) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.ThreadUtils.__L6778, msNow)))));
        } catch (java.lang.InterruptedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static perturbation.location.PerturbationLocation __L6763;

    public static perturbation.location.PerturbationLocation __L6764;

    public static perturbation.location.PerturbationLocation __L6765;

    public static perturbation.location.PerturbationLocation __L6766;

    public static perturbation.location.PerturbationLocation __L6767;

    public static perturbation.location.PerturbationLocation __L6768;

    public static perturbation.location.PerturbationLocation __L6769;

    public static perturbation.location.PerturbationLocation __L6770;

    public static perturbation.location.PerturbationLocation __L6771;

    public static perturbation.location.PerturbationLocation __L6772;

    public static perturbation.location.PerturbationLocation __L6773;

    public static perturbation.location.PerturbationLocation __L6774;

    public static perturbation.location.PerturbationLocation __L6775;

    public static perturbation.location.PerturbationLocation __L6776;

    public static perturbation.location.PerturbationLocation __L6777;

    public static perturbation.location.PerturbationLocation __L6778;

    public static perturbation.location.PerturbationLocation __L6779;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.ThreadUtils.__L6763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:37)", 6763, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:37)", 6764, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:37)", 6765, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:37)", 6766, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:37)", 6767, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:37)", 6768, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:39)", 6769, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:40)", 6770, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:41)", 6771, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:41)", 6772, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:41)", 6773, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:43)", 6774, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:43)", 6775, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:43)", 6776, "Boolean");
        org.broadleafcommerce.common.util.ThreadUtils.__L6777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:48)", 6777, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:48)", 6778, "Numerical");
        org.broadleafcommerce.common.util.ThreadUtils.__L6779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ThreadUtils.java:48)", 6779, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.ThreadUtils.initPerturbationLocation0();
    }
}

