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


public class SupportLogger {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.logging.SupportLogger.class);

    public static final java.lang.String FQCN_KEY = "SupportLogger.adapter.fqcn";

    private java.lang.String moduleName;

    private org.broadleafcommerce.common.logging.SupportLoggerAdapter adapter;

    public SupportLogger(java.lang.String moduleName, java.lang.String name) {
        this.moduleName = moduleName;
        java.lang.String fqcn = org.broadleafcommerce.common.logging.SupportLogger.getSupportLoggerAdapterFQCN();
        if (org.apache.commons.lang.StringUtils.isNotBlank(fqcn)) {
            try {
                adapter = ((org.broadleafcommerce.common.logging.SupportLoggerAdapter) (java.lang.Class.forName(fqcn).newInstance()));
                adapter.setName(name);
            } catch (java.lang.InstantiationException e) {
                org.broadleafcommerce.common.logging.SupportLogger.LOG.error((("Unable to create instance of SupportLogger [" + fqcn) + "] Creating default logger."), e);
            } catch (java.lang.IllegalAccessException e) {
                org.broadleafcommerce.common.logging.SupportLogger.LOG.error((("Unable to create instance of SupportLogger [" + fqcn) + "] Creating default logger."), e);
            } catch (java.lang.ClassNotFoundException e) {
                org.broadleafcommerce.common.logging.SupportLogger.LOG.error((("Unable to create instance of SupportLogger [" + fqcn) + "] Creating default logger."), e);
            }
        }
        if ((adapter) == null) {
            adapter = new org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter();
            adapter.setName(name);
        }
    }

    public void support(java.lang.Object message) {
        adapter.support((((moduleName) + " - ") + message));
    }

    public void support(java.lang.Object message, java.lang.Throwable t) {
        adapter.support((((moduleName) + " - ") + message), t);
    }

    public void lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent, java.lang.Object message) {
        adapter.lifecycle(lifeCycleEvent, ((((moduleName) + " - ") + (lifeCycleEvent.toString())) + (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SupportLogger.__L3428, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.SupportLogger.__L3427, org.apache.commons.lang.StringUtils.isEmpty(message.toString()))))) ? " - " + message : "")));
    }

    public void debug(java.lang.Object message) {
        adapter.debug((((moduleName) + " - ") + message));
    }

    public void debug(java.lang.Object message, java.lang.Throwable t) {
        adapter.debug((((moduleName) + " - ") + message), t);
    }

    public void error(java.lang.Object message) {
        adapter.error((((moduleName) + " - ") + message));
    }

    public void error(java.lang.Object message, java.lang.Throwable t) {
        adapter.error((((moduleName) + " - ") + message), t);
    }

    public void fatal(java.lang.Object message) {
        adapter.fatal((((moduleName) + " - ") + message));
    }

    public void fatal(java.lang.Object message, java.lang.Throwable t) {
        adapter.fatal((((moduleName) + " - ") + message), t);
    }

    public void info(java.lang.Object message) {
        adapter.info((((moduleName) + " - ") + message));
    }

    public void info(java.lang.Object message, java.lang.Throwable t) {
        adapter.info((((moduleName) + " - ") + message), t);
    }

    public void warn(java.lang.Object message) {
        adapter.warn((((moduleName) + " - ") + message));
    }

    public void warn(java.lang.Object message, java.lang.Throwable t) {
        adapter.warn((((moduleName) + " - ") + message), t);
    }

    public static java.lang.String getSupportLoggerAdapterFQCN() {
        return java.lang.System.getProperty(org.broadleafcommerce.common.logging.SupportLogger.FQCN_KEY);
    }

    public static perturbation.location.PerturbationLocation __L3427;

    public static perturbation.location.PerturbationLocation __L3428;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.logging.SupportLogger.__L3427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SupportLogger.java:109)", 3427, "Boolean");
        org.broadleafcommerce.common.logging.SupportLogger.__L3428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/SupportLogger.java:109)", 3428, "Boolean");
    }

    static {
        org.broadleafcommerce.common.logging.SupportLogger.initPerturbationLocation0();
    }
}

