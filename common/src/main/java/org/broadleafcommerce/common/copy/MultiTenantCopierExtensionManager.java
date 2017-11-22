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


@org.springframework.stereotype.Service("blMultiTenantCopierExtensionManager")
public class MultiTenantCopierExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.common.copy.MultiTenantCopierExtensionHandler> {
    public MultiTenantCopierExtensionManager() {
        super(org.broadleafcommerce.common.copy.MultiTenantCopierExtensionHandler.class);
    }

    public boolean continueOnHandled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager.__L610, true);
    }

    public static perturbation.location.PerturbationLocation __L610;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager.__L610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopierExtensionManager.java:34)", 610, "Boolean");
    }

    static {
        org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager.initPerturbationLocation0();
    }
}

