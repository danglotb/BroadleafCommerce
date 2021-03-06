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
package org.broadleafcommerce.common.web.resource;


public class AbstractResourceRequestExtensionHandler extends org.broadleafcommerce.common.extension.AbstractExtensionHandler implements org.broadleafcommerce.common.web.resource.ResourceRequestExtensionHandler {
    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getModifiedResource(java.lang.String path, org.broadleafcommerce.common.extension.ExtensionResultHolder erh) {
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getOverrideResource(java.lang.String path, org.broadleafcommerce.common.extension.ExtensionResultHolder erh) {
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }
}

