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
package org.broadleafcommerce.common.extensibility.context.merge;


@org.springframework.stereotype.Component("blMultiTenantMergeBeanStatusProvider")
public class MultiTenantMergeBeanStatusProvider implements org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider {
    @java.lang.Override
    public boolean isProcessingEnabled(java.lang.Object bean, java.lang.String beanName, org.springframework.context.ApplicationContext appCtx) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MultiTenantMergeBeanStatusProvider.__L1802, appCtx.containsBean("blMultiTenantFilterClassTransformer"));
    }

    public static perturbation.location.PerturbationLocation __L1802;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.MultiTenantMergeBeanStatusProvider.__L1802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MultiTenantMergeBeanStatusProvider.java:34)", 1802, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.MultiTenantMergeBeanStatusProvider.initPerturbationLocation0();
    }
}

