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


public class EarlyStageMergeBeanPostProcessor extends org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor implements org.springframework.core.PriorityOrdered {
    protected int order = java.lang.Integer.MIN_VALUE;

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.__L1614, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.__L1615, order);
    }

    public static perturbation.location.PerturbationLocation __L1614;

    public static perturbation.location.PerturbationLocation __L1615;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.__L1614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/EarlyStageMergeBeanPostProcessor.java:41)", 1614, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.__L1615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/EarlyStageMergeBeanPostProcessor.java:52)", 1615, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.initPerturbationLocation0();
    }
}

