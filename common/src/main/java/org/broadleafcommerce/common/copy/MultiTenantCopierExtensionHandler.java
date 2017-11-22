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
package org.broadleafcommerce.common.copy;


public interface MultiTenantCopierExtensionHandler extends org.broadleafcommerce.common.extension.ExtensionHandler {
    org.broadleafcommerce.common.extension.ExtensionResultStatusType transformCopy(org.broadleafcommerce.common.copy.MultiTenantCopyContext context, java.lang.Object from, java.lang.Object to);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType prepareForSave(org.broadleafcommerce.common.copy.MultiTenantCopyContext context, java.lang.Object from, java.lang.Object to);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType postSave(org.broadleafcommerce.common.copy.MultiTenantCopyContext context, java.lang.Object from, java.lang.Object to);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType shouldClone(org.broadleafcommerce.common.copy.MultiTenantCopyContext context, java.lang.Object from, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> result);
}

