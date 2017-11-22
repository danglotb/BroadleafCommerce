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
package org.broadleafcommerce.common.logging;


public class SystemSupportLoggerAdapter extends org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter implements org.broadleafcommerce.common.logging.SupportLoggerAdapter {
    public static final java.lang.String SHOW_DATE_TIME_KEY = "SystemSupportLoggerAdapter.showDateTime";

    public static final java.lang.String DATE_TIME_FORMAT_KEY = "SystemSupportLoggerAdapter.dateTimeFormat";

    public static final java.lang.String SHOW_THREAD_NAME_KEY = "SystemSupportLoggerAdapter.showThreadName";

    public static final java.lang.String SHOW_LOG_NAME_KEY = "SystemSupportLoggerAdapter.showLogName";

    public static final java.lang.String LEVEL_IN_BRACKETS_KEY = "SystemSupportLoggerAdapter.levelInBrackets";

    public static final java.lang.String SHOW_NON_SUPPORT_LEVELS_KEY = "SystemSupportLoggerAdapter.showNonSupportLevels";

    private java.lang.String name;

    @java.lang.Override
    public void support(java.lang.String message) {
        log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3429, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_SUPPORT), message, null);
    }

    @java.lang.Override
    public void support(java.lang.String message, java.lang.Throwable t) {
        log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3430, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_SUPPORT), message, t);
    }

    @java.lang.Override
    public void lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent, java.lang.String message) {
        log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3431, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_SUPPORT), message, null);
    }

    @java.lang.Override
    public void debug(java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3432, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3433, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_DEBUG), message, null);
        }
    }

    @java.lang.Override
    public void debug(java.lang.String message, java.lang.Throwable t) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3434, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3435, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_DEBUG), message, t);
        }
    }

    @java.lang.Override
    public void error(java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3436, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3437, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_ERROR), message, null);
        }
    }

    @java.lang.Override
    public void error(java.lang.String message, java.lang.Throwable t) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3438, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3439, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_ERROR), message, t);
        }
    }

    @java.lang.Override
    public void fatal(java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3440, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3441, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_FATAL), message, null);
        }
    }

    @java.lang.Override
    public void fatal(java.lang.String message, java.lang.Throwable t) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3442, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3443, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_FATAL), message, t);
        }
    }

    @java.lang.Override
    public void info(java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3444, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3445, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_INFO), message, null);
        }
    }

    @java.lang.Override
    public void info(java.lang.String message, java.lang.Throwable t) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3446, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3447, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_INFO), message, t);
        }
    }

    @java.lang.Override
    public void warn(java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3448, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3449, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_WARN), message, null);
        }
    }

    @java.lang.Override
    public void warn(java.lang.String message, java.lang.Throwable t) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3450, getShowNonSupportLevels())) {
            log(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3451, org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_WARN), message, t);
        }
    }

    protected void log(int level, java.lang.String message, java.lang.Throwable t) {
        java.lang.StringBuffer buf = new java.lang.StringBuffer(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3452, 32));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3453, getLevelInBrackets())) {
            buf.append('[');
        }
        switch (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3454, level)) {
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_TRACE :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.TRACE);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_DEBUG :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.DEBUG);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_INFO :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.INFO);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_WARN :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.WARN);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_ERROR :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.ERROR);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_FATAL :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.FATAL);
                break;
            default :
                buf.append(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.SUPPORT);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3455, getLevelInBrackets())) {
            buf.append(']');
            buf.append(' ');
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3458, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3456, getShowDateTime())) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3457, ((getDateFormatter()) != null)))))) {
            buf.append(getFormattedDate());
            buf.append(' ');
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3459, getShowThreadName())) {
            buf.append('[');
            buf.append(java.lang.Thread.currentThread().getName());
            buf.append("] ");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3460, getShowLogName())) {
            buf.append(java.lang.String.valueOf(name)).append(" - ");
        }
        buf.append(message);
        write(buf, t);
    }

    protected void write(java.lang.StringBuffer buf, java.lang.Throwable t) {
        java.lang.System.out.println(buf.toString());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3461, (t != null))) {
            t.printStackTrace(java.lang.System.out);
        }
        java.lang.System.out.flush();
    }

    protected java.lang.String getFormattedDate() {
        java.util.Date now = new java.util.Date();
        java.lang.String dateText;
        synchronized(getDateFormatter()) {
            dateText = getDateFormatter().format(now);
        }
        return dateText;
    }

    protected boolean getShowDateTime() {
        java.lang.String property = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.SHOW_DATE_TIME_KEY, "true");
        return java.lang.Boolean.valueOf(property);
    }

    protected java.text.DateFormat getDateFormatter() {
        java.lang.String property = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.DATE_TIME_FORMAT_KEY, "HH:mm:ss");
        return new java.text.SimpleDateFormat(property);
    }

    protected boolean getShowThreadName() {
        java.lang.String property = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.SHOW_THREAD_NAME_KEY, "false");
        return java.lang.Boolean.valueOf(property);
    }

    protected boolean getShowLogName() {
        java.lang.String property = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.SHOW_LOG_NAME_KEY, "true");
        return java.lang.Boolean.valueOf(property);
    }

    protected boolean getLevelInBrackets() {
        java.lang.String property = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.LEVEL_IN_BRACKETS_KEY, "true");
        return java.lang.Boolean.valueOf(property);
    }

    protected boolean getShowNonSupportLevels() {
        java.lang.String property = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.SHOW_NON_SUPPORT_LEVELS_KEY, "false");
        return java.lang.Boolean.valueOf(property);
    }

    @java.lang.Override
    public java.lang.String getName() {
        return name;
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
        this.name = name;
    }

    public static perturbation.location.PerturbationLocation __L3429;

    public static perturbation.location.PerturbationLocation __L3430;

    public static perturbation.location.PerturbationLocation __L3431;

    public static perturbation.location.PerturbationLocation __L3432;

    public static perturbation.location.PerturbationLocation __L3433;

    public static perturbation.location.PerturbationLocation __L3434;

    public static perturbation.location.PerturbationLocation __L3435;

    public static perturbation.location.PerturbationLocation __L3436;

    public static perturbation.location.PerturbationLocation __L3437;

    public static perturbation.location.PerturbationLocation __L3438;

    public static perturbation.location.PerturbationLocation __L3439;

    public static perturbation.location.PerturbationLocation __L3440;

    public static perturbation.location.PerturbationLocation __L3441;

    public static perturbation.location.PerturbationLocation __L3442;

    public static perturbation.location.PerturbationLocation __L3443;

    public static perturbation.location.PerturbationLocation __L3444;

    public static perturbation.location.PerturbationLocation __L3445;

    public static perturbation.location.PerturbationLocation __L3446;

    public static perturbation.location.PerturbationLocation __L3447;

    public static perturbation.location.PerturbationLocation __L3448;

    public static perturbation.location.PerturbationLocation __L3449;

    public static perturbation.location.PerturbationLocation __L3450;

    public static perturbation.location.PerturbationLocation __L3451;

    public static perturbation.location.PerturbationLocation __L3452;

    public static perturbation.location.PerturbationLocation __L3453;

    public static perturbation.location.PerturbationLocation __L3454;

    public static perturbation.location.PerturbationLocation __L3455;

    public static perturbation.location.PerturbationLocation __L3456;

    public static perturbation.location.PerturbationLocation __L3457;

    public static perturbation.location.PerturbationLocation __L3458;

    public static perturbation.location.PerturbationLocation __L3459;

    public static perturbation.location.PerturbationLocation __L3460;

    public static perturbation.location.PerturbationLocation __L3461;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:75)", 3429, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:86)", 3430, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:98)", 3431, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:103)", 3432, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:104)", 3433, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:110)", 3434, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:111)", 3435, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:117)", 3436, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:118)", 3437, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:124)", 3438, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:125)", 3439, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:131)", 3440, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:132)", 3441, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:138)", 3442, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:139)", 3443, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:145)", 3444, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:146)", 3445, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:152)", 3446, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:153)", 3447, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:159)", 3448, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:160)", 3449, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:166)", 3450, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:167)", 3451, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:173)", 3452, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:175)", 3453, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:180)", 3454, "Numerical");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:203)", 3455, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:209)", 3456, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:209)", 3457, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:209)", 3458, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:215)", 3459, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:222)", 3460, "Boolean");
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.__L3461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SystemSupportLoggerAdapter.java:235)", 3461, "Boolean");
    }

    static {
        org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.initPerturbationLocation0();
    }
}

