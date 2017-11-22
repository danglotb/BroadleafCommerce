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
package org.broadleafcommerce.common.breadcrumbs.service;


@org.springframework.stereotype.Component("blBreadcrumbServiceExtensionManager")
public class BreadcrumbServiceExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler> {
    public static java.lang.String CONTEXT_PARAM_STRIPPED_URL = "STRIPPED_URL";

    public static java.lang.String CONTEXT_PARAM_STRIPPED_PARAMS = "STRIPPED_PARAMS";

    public BreadcrumbServiceExtensionManager() {
        super(org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler.class);
    }

    @java.lang.Override
    protected void sortHandlers() {
        super.sortHandlers();
        java.util.Collections.reverse(getHandlers());
    }
}

