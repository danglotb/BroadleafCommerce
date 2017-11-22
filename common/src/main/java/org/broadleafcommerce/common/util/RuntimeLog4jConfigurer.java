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


@java.lang.Deprecated
public class RuntimeLog4jConfigurer {
    private java.lang.String log4jConfigLocation;

    public java.lang.String getLog4jConfigLocation() {
        return log4jConfigLocation;
    }

    public void setLog4jConfigLocation(java.lang.String log4jConfigLocation) {
        this.log4jConfigLocation = log4jConfigLocation;
        try {
            org.springframework.util.Log4jConfigurer.initLogging(log4jConfigLocation);
        } catch (java.io.FileNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}

