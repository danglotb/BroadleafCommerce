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
package org.broadleafcommerce.common.vendor.service.monitor;


public class ServiceMonitor {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.class);

    protected java.util.Map<org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable, org.broadleafcommerce.common.vendor.service.monitor.StatusHandler> serviceHandlers = new java.util.HashMap<org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable, org.broadleafcommerce.common.vendor.service.monitor.StatusHandler>();

    protected org.broadleafcommerce.common.vendor.service.monitor.StatusHandler defaultHandler = new org.broadleafcommerce.common.vendor.service.monitor.handler.LogStatusHandler();

    protected java.util.Map<org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType> statusMap = new java.util.HashMap<org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType>();

    public synchronized void init() {
        for (org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable statusDetectable : serviceHandlers.keySet()) {
            checkService(statusDetectable);
        }
    }

    public java.lang.Object checkServiceAOP(org.aspectj.lang.ProceedingJoinPoint call) throws java.lang.Throwable {
        try {
            checkService(((org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable) (call.getThis())));
        } catch (java.lang.Throwable e) {
            org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.LOG.error("Could not check service status", e);
        }
        return call.proceed();
    }

    public void checkService(org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable statusDetectable) {
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType type = statusDetectable.getServiceStatus();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6940, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6939, statusMap.containsKey(statusDetectable)))))) {
            statusMap.put(statusDetectable, type);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6941, type.equals(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.DOWN))) {
                handleStatusChange(statusDetectable, type);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6943, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6942, statusMap.get(statusDetectable).equals(type)))))) {
            handleStatusChange(statusDetectable, type);
            statusMap.put(statusDetectable, type);
        }
    }

    protected void handleStatusChange(org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable serviceStatus, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType serviceStatusType) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6944, serviceHandlers.containsKey(serviceStatus))) {
            serviceHandlers.get(serviceStatus).handleStatus(serviceStatus.getServiceName(), serviceStatusType);
        }else {
            defaultHandler.handleStatus(serviceStatus.getServiceName(), serviceStatusType);
        }
    }

    public java.util.Map<org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable, org.broadleafcommerce.common.vendor.service.monitor.StatusHandler> getServiceHandlers() {
        return serviceHandlers;
    }

    public void setServiceHandlers(java.util.Map<org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable, org.broadleafcommerce.common.vendor.service.monitor.StatusHandler> serviceHandlers) {
        this.serviceHandlers = serviceHandlers;
    }

    public org.broadleafcommerce.common.vendor.service.monitor.StatusHandler getDefaultHandler() {
        return defaultHandler;
    }

    public void setDefaultHandler(org.broadleafcommerce.common.vendor.service.monitor.StatusHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    public static perturbation.location.PerturbationLocation __L6939;

    public static perturbation.location.PerturbationLocation __L6940;

    public static perturbation.location.PerturbationLocation __L6941;

    public static perturbation.location.PerturbationLocation __L6942;

    public static perturbation.location.PerturbationLocation __L6943;

    public static perturbation.location.PerturbationLocation __L6944;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/ServiceMonitor.java:54)", 6939, "Boolean");
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/ServiceMonitor.java:54)", 6940, "Boolean");
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/ServiceMonitor.java:56)", 6941, "Boolean");
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/ServiceMonitor.java:60)", 6942, "Boolean");
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/ServiceMonitor.java:60)", 6943, "Boolean");
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.__L6944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/monitor/ServiceMonitor.java:67)", 6944, "Boolean");
    }

    static {
        org.broadleafcommerce.common.vendor.service.monitor.ServiceMonitor.initPerturbationLocation0();
    }
}

