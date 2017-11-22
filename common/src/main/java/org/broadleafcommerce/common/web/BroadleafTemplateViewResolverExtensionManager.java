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
package org.broadleafcommerce.common.web;


@org.springframework.stereotype.Service("blBroadleafTemplateViewResolverExtensionManager")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class BroadleafTemplateViewResolverExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionHandler> {
    private java.util.List<org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionHandler> EMPTY_LIST = java.util.Collections.emptyList();

    public BroadleafTemplateViewResolverExtensionManager() {
        super(org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionHandler.class);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionHandler> getHandlers() {
        if (org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getAdmin()) {
            return EMPTY_LIST;
        }else {
            return super.getHandlers();
        }
    }

    @java.lang.Override
    public boolean continueOnHandled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionManager.__L7993, true);
    }

    public static perturbation.location.PerturbationLocation __L7993;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionManager.__L7993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTemplateViewResolverExtensionManager.java:60)", 7993, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafTemplateViewResolverExtensionManager.initPerturbationLocation0();
    }
}

