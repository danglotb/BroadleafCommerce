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
package org.broadleafcommerce.common.web.resource.resolver;


public class BroadleafResourceResolverOrder {
    public static int THEME_FILE_URL_RESOLVER = -1000;

    public static int BLC_JS_PATH_RESOLVER = -2000;

    public static int BLC_CACHE_RESOURCE_RESOLVER = 1000;

    public static int BLC_VERSION_RESOURCE_RESOLVER = 2000;

    public static int BLC_BUNDLE_RESOURCE_RESOLVER = 10000;

    public static int BLC_JS_RESOURCE_RESOLVER = 11000;

    public static int BLC_SYSTEM_PROPERTY_RESOURCE_RESOLVER = 12000;

    public static int BLC_THEME_FILE_RESOLVER = 13000;

    public static int BLC_PATH_RESOURCE_RESOLVER = java.lang.Integer.MAX_VALUE;
}

