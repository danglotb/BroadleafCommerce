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
package org.broadleafcommerce.core.web.resolver;


@org.springframework.stereotype.Service("blDatabaseResourceResolverExtensionManager")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class DatabaseResourceResolverExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionHandler> {
    public DatabaseResourceResolverExtensionManager() {
        super(org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionHandler.class);
    }

    @java.lang.Override
    public boolean continueOnHandled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionManager.__L8031, false);
    }

    public static perturbation.location.PerturbationLocation __L8031;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionManager.__L8031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/core/web/resolver/DatabaseResourceResolverExtensionManager.java:42)", 8031, "Boolean");
    }

    static {
        org.broadleafcommerce.core.web.resolver.DatabaseResourceResolverExtensionManager.initPerturbationLocation0();
    }
}

