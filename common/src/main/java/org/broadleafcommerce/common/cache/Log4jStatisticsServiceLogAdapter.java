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
package org.broadleafcommerce.common.cache;


@java.lang.Deprecated
public class Log4jStatisticsServiceLogAdapter implements org.broadleafcommerce.common.cache.StatisticsServiceLogAdapter {
    @java.lang.Override
    public void activateLogging(java.lang.Class clazz) {
        org.apache.log4j.LogManager.getLogger(clazz).setLevel(org.apache.log4j.Level.INFO);
    }

    @java.lang.Override
    public void disableLogging(java.lang.Class clazz) {
        org.apache.log4j.LogManager.getLogger(org.broadleafcommerce.common.cache.StatisticsServiceImpl.class).setLevel(org.apache.log4j.Level.DEBUG);
    }
}

