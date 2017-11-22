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


public class LateStageRemoveBeanPostProcessor extends org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor implements org.springframework.core.Ordered {
    protected int order = java.lang.Integer.MAX_VALUE;

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.LateStageRemoveBeanPostProcessor.__L1636, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.LateStageRemoveBeanPostProcessor.__L1637, order);
    }

    public static perturbation.location.PerturbationLocation __L1636;

    public static perturbation.location.PerturbationLocation __L1637;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.LateStageRemoveBeanPostProcessor.__L1636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/LateStageRemoveBeanPostProcessor.java:42)", 1636, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.LateStageRemoveBeanPostProcessor.__L1637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/LateStageRemoveBeanPostProcessor.java:52)", 1637, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.LateStageRemoveBeanPostProcessor.initPerturbationLocation0();
    }
}

