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


public class CompositeStatusHandler implements org.broadleafcommerce.common.vendor.service.monitor.StatusHandler {
    protected java.util.List<org.broadleafcommerce.common.vendor.service.monitor.StatusHandler> handlers = new java.util.ArrayList<org.broadleafcommerce.common.vendor.service.monitor.StatusHandler>();

    public void handleStatus(java.lang.String serviceName, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType status) {
        for (org.broadleafcommerce.common.vendor.service.monitor.StatusHandler statusHandler : handlers) {
            statusHandler.handleStatus(serviceName, status);
        }
    }

    public java.util.List<org.broadleafcommerce.common.vendor.service.monitor.StatusHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(java.util.List<org.broadleafcommerce.common.vendor.service.monitor.StatusHandler> handlers) {
        this.handlers = handlers;
    }
}

