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


public class DisableSupportLoggerAdapter implements org.broadleafcommerce.common.logging.SupportLoggerAdapter {
    @java.lang.Override
    public java.lang.String getName() {
        return null;
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
    }

    @java.lang.Override
    public void support(java.lang.String message) {
    }

    @java.lang.Override
    public void support(java.lang.String message, java.lang.Throwable t) {
    }

    @java.lang.Override
    public void lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent, java.lang.String message) {
    }

    @java.lang.Override
    public void debug(java.lang.String message) {
    }

    @java.lang.Override
    public void debug(java.lang.String message, java.lang.Throwable t) {
    }

    @java.lang.Override
    public void error(java.lang.String message) {
    }

    @java.lang.Override
    public void error(java.lang.String message, java.lang.Throwable t) {
    }

    @java.lang.Override
    public void fatal(java.lang.String message) {
    }

    @java.lang.Override
    public void fatal(java.lang.String message, java.lang.Throwable t) {
    }

    @java.lang.Override
    public void info(java.lang.String message) {
    }

    @java.lang.Override
    public void info(java.lang.String message, java.lang.Throwable t) {
    }

    @java.lang.Override
    public void warn(java.lang.String message) {
    }

    @java.lang.Override
    public void warn(java.lang.String message, java.lang.Throwable t) {
    }
}

