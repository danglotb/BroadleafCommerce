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


public interface SupportLoggerAdapter {
    public java.lang.String getName();

    public void setName(java.lang.String name);

    public void support(java.lang.String message);

    public void support(java.lang.String message, java.lang.Throwable t);

    public void lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent, java.lang.String message);

    public void debug(java.lang.String message);

    public void debug(java.lang.String message, java.lang.Throwable t);

    public void error(java.lang.String message);

    public void error(java.lang.String message, java.lang.Throwable t);

    public void fatal(java.lang.String message);

    public void fatal(java.lang.String message, java.lang.Throwable t);

    public void info(java.lang.String message);

    public void info(java.lang.String message, java.lang.Throwable t);

    public void warn(java.lang.String message);

    public void warn(java.lang.String message, java.lang.Throwable t);
}

