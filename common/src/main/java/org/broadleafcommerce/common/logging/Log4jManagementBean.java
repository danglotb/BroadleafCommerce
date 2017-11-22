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


@java.lang.Deprecated
@org.springframework.jmx.export.annotation.ManagedResource(objectName = "org.broadleafcommerce:name=Log4JManangement", description = "Logging Management", currencyTimeLimit = 15)
public class Log4jManagementBean {
    @org.springframework.jmx.export.annotation.ManagedOperation(description = "Activate info level")
    @org.springframework.jmx.export.annotation.ManagedOperationParameters({ @org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "category", description = "the log4j category to set") })
    public void activateInfo(java.lang.String category) {
        org.apache.log4j.LogManager.getLogger(category).setLevel(org.apache.log4j.Level.INFO);
    }

    @org.springframework.jmx.export.annotation.ManagedOperation(description = "Activate debug level")
    @org.springframework.jmx.export.annotation.ManagedOperationParameters({ @org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "category", description = "the log4j category to set") })
    public void activateDebug(java.lang.String category) {
        org.apache.log4j.LogManager.getLogger(category).setLevel(org.apache.log4j.Level.DEBUG);
    }

    @org.springframework.jmx.export.annotation.ManagedOperation(description = "Activate warn level")
    @org.springframework.jmx.export.annotation.ManagedOperationParameters({ @org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "category", description = "the log4j category to set") })
    public void activateWarn(java.lang.String category) {
        org.apache.log4j.LogManager.getLogger(category).setLevel(org.apache.log4j.Level.WARN);
    }

    @org.springframework.jmx.export.annotation.ManagedOperation(description = "Activate error level")
    @org.springframework.jmx.export.annotation.ManagedOperationParameters({ @org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "category", description = "the log4j category to set") })
    public void activateError(java.lang.String category) {
        org.apache.log4j.LogManager.getLogger(category).setLevel(org.apache.log4j.Level.ERROR);
    }

    @org.springframework.jmx.export.annotation.ManagedOperation(description = "Activate fatal level")
    @org.springframework.jmx.export.annotation.ManagedOperationParameters({ @org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "category", description = "the log4j category to set") })
    public void activateFatal(java.lang.String category) {
        org.apache.log4j.LogManager.getLogger(category).setLevel(org.apache.log4j.Level.FATAL);
    }

    @org.springframework.jmx.export.annotation.ManagedOperation(description = "Retrieve the category log level")
    @org.springframework.jmx.export.annotation.ManagedOperationParameters({ @org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "category", description = "the log4j category") })
    public java.lang.String getLevel(java.lang.String category) {
        return org.apache.log4j.LogManager.getLogger(category).getLevel().toString();
    }
}

