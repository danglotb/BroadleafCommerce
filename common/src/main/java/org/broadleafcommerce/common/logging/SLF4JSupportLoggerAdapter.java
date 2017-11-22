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


public class SLF4JSupportLoggerAdapter extends org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter implements org.broadleafcommerce.common.logging.SupportLoggerAdapter {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.class);

    public static final java.lang.String DEFAULT_LEVEL_KEY = "SLF4JSupportLoggerAdapter.defaultLevel";

    private java.lang.String name;

    @java.lang.Override
    public void support(java.lang.String message) {
        mapSupportLevel(org.broadleafcommerce.common.util.StringUtil.sanitize(message), null);
    }

    @java.lang.Override
    public void support(java.lang.String message, java.lang.Throwable t) {
        mapSupportLevel(org.broadleafcommerce.common.util.StringUtil.sanitize(message), t);
    }

    @java.lang.Override
    public void lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent, java.lang.String message) {
        mapSupportLevel(org.broadleafcommerce.common.util.StringUtil.sanitize(message), null);
    }

    @java.lang.Override
    public void debug(java.lang.String message) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.debug(org.broadleafcommerce.common.util.StringUtil.sanitize(message));
    }

    @java.lang.Override
    public void debug(java.lang.String message, java.lang.Throwable t) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.debug(org.broadleafcommerce.common.util.StringUtil.sanitize(message), t);
    }

    @java.lang.Override
    public void error(java.lang.String message) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.error(org.broadleafcommerce.common.util.StringUtil.sanitize(message));
    }

    @java.lang.Override
    public void error(java.lang.String message, java.lang.Throwable t) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.error(org.broadleafcommerce.common.util.StringUtil.sanitize(message), t);
    }

    @java.lang.Override
    public void fatal(java.lang.String message) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.error(org.broadleafcommerce.common.util.StringUtil.sanitize(message));
    }

    @java.lang.Override
    public void fatal(java.lang.String message, java.lang.Throwable t) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.error(org.broadleafcommerce.common.util.StringUtil.sanitize(message), t);
    }

    @java.lang.Override
    public void info(java.lang.String message) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.info(org.broadleafcommerce.common.util.StringUtil.sanitize(message));
    }

    @java.lang.Override
    public void info(java.lang.String message, java.lang.Throwable t) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.info(org.broadleafcommerce.common.util.StringUtil.sanitize(message), t);
    }

    @java.lang.Override
    public void warn(java.lang.String message) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.warn(org.broadleafcommerce.common.util.StringUtil.sanitize(message));
    }

    @java.lang.Override
    public void warn(java.lang.String message, java.lang.Throwable t) {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.warn(org.broadleafcommerce.common.util.StringUtil.sanitize(message), t);
    }

    protected void mapSupportLevel(java.lang.String message, java.lang.Throwable t) {
        org.slf4j.Marker supportMarker = org.slf4j.MarkerFactory.getMarker(org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.SUPPORT);
        switch (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.__L3425, getSupportLevel())) {
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_ERROR :
                org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.error(supportMarker, message, t);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_INFO :
                org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.info(supportMarker, message, t);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_DEBUG :
                org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.debug(supportMarker, message, t);
                break;
            case org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_TRACE :
                org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.trace(supportMarker, message, t);
                break;
            default :
                org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.LOGGER.warn(supportMarker, message, t);
        }
    }

    public int getSupportLevel() {
        java.lang.String systemProperty = java.lang.System.getProperty(org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.DEFAULT_LEVEL_KEY, ((org.broadleafcommerce.common.logging.AbstractSupportLoggerAdapter.LOG_LEVEL_WARN) + ""));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.__L3426, java.lang.Integer.valueOf(systemProperty));
    }

    @java.lang.Override
    public java.lang.String getName() {
        return name;
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
        this.name = name;
    }

    public static perturbation.location.PerturbationLocation __L3425;

    public static perturbation.location.PerturbationLocation __L3426;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.__L3425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SLF4JSupportLoggerAdapter.java:116)", 3425, "Numerical");
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.__L3426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SLF4JSupportLoggerAdapter.java:137)", 3426, "Numerical");
    }

    static {
        org.broadleafcommerce.common.logging.SLF4JSupportLoggerAdapter.initPerturbationLocation0();
    }
}

