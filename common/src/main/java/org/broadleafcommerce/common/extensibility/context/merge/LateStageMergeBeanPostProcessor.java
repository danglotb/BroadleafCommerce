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


public class LateStageMergeBeanPostProcessor extends org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor implements org.springframework.core.Ordered {
    protected int order = java.lang.Integer.MAX_VALUE;

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.__L1634, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.__L1635, order);
    }

    public static perturbation.location.PerturbationLocation __L1634;

    public static perturbation.location.PerturbationLocation __L1635;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.__L1634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/LateStageMergeBeanPostProcessor.java:42)", 1634, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.__L1635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/LateStageMergeBeanPostProcessor.java:52)", 1635, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.initPerturbationLocation0();
    }
}

