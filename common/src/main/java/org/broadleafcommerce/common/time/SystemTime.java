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
package org.broadleafcommerce.common.time;


public class SystemTime {
    private static final org.broadleafcommerce.common.time.TimeSource defaultTimeSource = new org.broadleafcommerce.common.time.DefaultTimeSource();

    private static org.broadleafcommerce.common.time.TimeSource globalTimeSource = null;

    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.time.TimeSource> localTimeSource = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.time.TimeSource.class, false);

    public static org.broadleafcommerce.common.time.TimeSource getTimeSource() {
        org.broadleafcommerce.common.time.TimeSource applicableTimeSource;
        org.broadleafcommerce.common.time.TimeSource localTS = org.broadleafcommerce.common.time.SystemTime.localTimeSource.get();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5771, (localTS != null))) {
            applicableTimeSource = localTS;
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5772, ((org.broadleafcommerce.common.time.SystemTime.globalTimeSource) != null))) {
                applicableTimeSource = org.broadleafcommerce.common.time.SystemTime.globalTimeSource;
            }else {
                applicableTimeSource = org.broadleafcommerce.common.time.SystemTime.defaultTimeSource;
            }

        return applicableTimeSource;
    }

    public static void setGlobalTimeSource(final org.broadleafcommerce.common.time.TimeSource globalTS) {
        org.broadleafcommerce.common.time.SystemTime.globalTimeSource = globalTS;
    }

    public static void resetGlobalTimeSource() {
        org.broadleafcommerce.common.time.SystemTime.setGlobalTimeSource(null);
    }

    public static void setLocalTimeSource(final org.broadleafcommerce.common.time.TimeSource localTS) {
        org.broadleafcommerce.common.time.SystemTime.localTimeSource.set(localTS);
    }

    public static void resetLocalTimeSource() {
        org.broadleafcommerce.common.time.SystemTime.localTimeSource.remove();
    }

    public static void reset() {
        org.broadleafcommerce.common.time.SystemTime.resetGlobalTimeSource();
        org.broadleafcommerce.common.time.SystemTime.resetLocalTimeSource();
    }

    public static long asMillis() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5774, org.broadleafcommerce.common.time.SystemTime.asMillis(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5773, true)));
    }

    public static long asMillis(boolean includeTime) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5775, includeTime)) {
            return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5776, org.broadleafcommerce.common.time.SystemTime.getTimeSource().timeInMillis());
        }
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5778, org.broadleafcommerce.common.time.SystemTime.asCalendar(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5777, includeTime)).getTimeInMillis());
    }

    public static java.util.Date asDate() {
        return org.broadleafcommerce.common.time.SystemTime.asDate(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5779, true));
    }

    public static java.util.Date asDate(boolean includeTime) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5780, includeTime)) {
            return new java.util.Date(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5781, org.broadleafcommerce.common.time.SystemTime.asMillis()));
        }
        return org.broadleafcommerce.common.time.SystemTime.asCalendar(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5782, includeTime)).getTime();
    }

    public static java.util.Calendar asCalendar() {
        return org.broadleafcommerce.common.time.SystemTime.asCalendar(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5783, true));
    }

    public static java.util.Calendar asCalendar(boolean includeTime) {
        return org.broadleafcommerce.common.time.SystemTime.asCalendar(java.util.Locale.getDefault(), java.util.TimeZone.getDefault(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5784, includeTime));
    }

    public static java.util.Calendar asCalendar(java.util.Locale locale) {
        return org.broadleafcommerce.common.time.SystemTime.asCalendar(locale, java.util.TimeZone.getDefault(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5785, true));
    }

    public static java.util.Calendar asCalendar(java.util.TimeZone timeZone) {
        return org.broadleafcommerce.common.time.SystemTime.asCalendar(java.util.Locale.getDefault(), timeZone, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5786, true));
    }

    public static boolean shouldCacheDate() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5787, ((org.broadleafcommerce.common.time.SystemTime.getTimeSource()) instanceof org.broadleafcommerce.common.time.FixedTimeSource))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5788, false);
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5789, true);
        }
    }

    public static java.util.Date getCurrentDateWithinTimeResolution(java.util.Date cachedDate, java.lang.Long dateResolutionMillis) {
        java.util.Date returnDate = org.broadleafcommerce.common.time.SystemTime.asDate();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5792, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5790, (cachedDate == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5791, ((org.broadleafcommerce.common.time.SystemTime.getTimeSource()) instanceof org.broadleafcommerce.common.time.FixedTimeSource)))))) {
            return returnDate;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5795, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5793, returnDate.getTime())) > (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5794, ((cachedDate.getTime()) + dateResolutionMillis)))))) {
            return returnDate;
        }else {
            return cachedDate;
        }
    }

    public static java.util.Calendar asCalendar(java.util.Locale locale, java.util.TimeZone timeZone, boolean includeTime) {
        java.util.Calendar calendar = java.util.Calendar.getInstance(timeZone, locale);
        calendar.setTimeInMillis(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.SystemTime.__L5796, org.broadleafcommerce.common.time.SystemTime.asMillis()));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5798, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.SystemTime.__L5797, includeTime))))) {
            calendar.set(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5799, java.util.Calendar.HOUR_OF_DAY), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5800, 0));
            calendar.set(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5801, java.util.Calendar.MINUTE), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5802, 0));
            calendar.set(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5803, java.util.Calendar.SECOND), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5804, 0));
            calendar.set(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5805, java.util.Calendar.MILLISECOND), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.SystemTime.__L5806, 0));
        }
        return calendar;
    }

    public static perturbation.location.PerturbationLocation __L5771;

    public static perturbation.location.PerturbationLocation __L5772;

    public static perturbation.location.PerturbationLocation __L5773;

    public static perturbation.location.PerturbationLocation __L5774;

    public static perturbation.location.PerturbationLocation __L5775;

    public static perturbation.location.PerturbationLocation __L5776;

    public static perturbation.location.PerturbationLocation __L5777;

    public static perturbation.location.PerturbationLocation __L5778;

    public static perturbation.location.PerturbationLocation __L5779;

    public static perturbation.location.PerturbationLocation __L5780;

    public static perturbation.location.PerturbationLocation __L5781;

    public static perturbation.location.PerturbationLocation __L5782;

    public static perturbation.location.PerturbationLocation __L5783;

    public static perturbation.location.PerturbationLocation __L5784;

    public static perturbation.location.PerturbationLocation __L5785;

    public static perturbation.location.PerturbationLocation __L5786;

    public static perturbation.location.PerturbationLocation __L5787;

    public static perturbation.location.PerturbationLocation __L5788;

    public static perturbation.location.PerturbationLocation __L5789;

    public static perturbation.location.PerturbationLocation __L5790;

    public static perturbation.location.PerturbationLocation __L5791;

    public static perturbation.location.PerturbationLocation __L5792;

    public static perturbation.location.PerturbationLocation __L5793;

    public static perturbation.location.PerturbationLocation __L5794;

    public static perturbation.location.PerturbationLocation __L5795;

    public static perturbation.location.PerturbationLocation __L5796;

    public static perturbation.location.PerturbationLocation __L5797;

    public static perturbation.location.PerturbationLocation __L5798;

    public static perturbation.location.PerturbationLocation __L5799;

    public static perturbation.location.PerturbationLocation __L5800;

    public static perturbation.location.PerturbationLocation __L5801;

    public static perturbation.location.PerturbationLocation __L5802;

    public static perturbation.location.PerturbationLocation __L5803;

    public static perturbation.location.PerturbationLocation __L5804;

    public static perturbation.location.PerturbationLocation __L5805;

    public static perturbation.location.PerturbationLocation __L5806;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.SystemTime.__L5771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:36)", 5771, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:38)", 5772, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:68)", 5773, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:68)", 5774, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:72)", 5775, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:73)", 5776, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:75)", 5777, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:75)", 5778, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:79)", 5779, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:83)", 5780, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:84)", 5781, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:86)", 5782, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:90)", 5783, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:94)", 5784, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:98)", 5785, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:102)", 5786, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:112)", 5787, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:113)", 5788, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:115)", 5789, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:131)", 5790, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:131)", 5791, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:131)", 5792, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:135)", 5793, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:135)", 5794, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:135)", 5795, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:144)", 5796, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:145)", 5797, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:145)", 5798, "Boolean");
        org.broadleafcommerce.common.time.SystemTime.__L5799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:146)", 5799, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:146)", 5800, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:147)", 5801, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:147)", 5802, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:148)", 5803, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:148)", 5804, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:149)", 5805, "Numerical");
        org.broadleafcommerce.common.time.SystemTime.__L5806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/SystemTime.java:149)", 5806, "Numerical");
    }

    static {
        org.broadleafcommerce.common.time.SystemTime.initPerturbationLocation0();
    }
}

