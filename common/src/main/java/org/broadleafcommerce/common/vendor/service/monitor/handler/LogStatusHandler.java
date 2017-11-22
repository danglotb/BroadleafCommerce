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
package org.broadleafcommerce.common.vendor.service.monitor.handler;


public class LogStatusHandler implements org.broadleafcommerce.common.vendor.service.monitor.StatusHandler {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.class);

    public void handleStatus(java.lang.String serviceName, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType status) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.__L6937, status.equals(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.DOWN))) {
            org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.LOG.error((serviceName + " is reporting a status of DOWN"));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.__L6938, status.equals(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.PAUSED))) {
                org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.LOG.warn((serviceName + " is reporting a status of PAUSED"));
            }else {
                org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.LOG.info((serviceName + " is reporting a status of UP"));
            }

    }

    public static perturbation.location.PerturbationLocation __L6937;

    public static perturbation.location.PerturbationLocation __L6938;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.__L6937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/handler/LogStatusHandler.java:30)", 6937, "Boolean");
        org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.__L6938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/handler/LogStatusHandler.java:32)", 6938, "Boolean");
    }

    static {
        org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler.initPerturbationLocation0();
    }
}

