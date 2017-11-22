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
package org.broadleafcommerce.common.config;


public interface FrameworkCommonClasspathPropertySource {
    public static final int BROADLEAF_COMMON_ORDER = -8000;

    public static final int PROFILE_ORDER = -7000;

    public static final int PROFILE_WEB_ORDER = -6000;

    public static final int FRAMEWORK_ORDER = -5000;

    public static final int FRAMEWORK_WEB_ORDER = -4000;

    public static final int OPEN_ADMIN_ORDER = -3000;

    public static final int ADMIN_MODULE_ORDER = -2000;

    public static final int CMS_ORDER = -1000;

    public static final int DEFAULT_ORDER = 1000;

    java.lang.String getClasspathFolder();
}

