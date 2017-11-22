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
package org.broadleafcommerce.common.jmx;


public class AspectUtil {
    public static java.lang.Object exposeRootBean(java.lang.Object managedBean) {
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.AspectUtil.__L3274, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.AspectUtil.__L3272, org.springframework.aop.support.AopUtils.isAopProxy(managedBean))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.AspectUtil.__L3273, (managedBean instanceof org.springframework.aop.framework.Advised)))))) {
                org.springframework.aop.framework.Advised advised = ((org.springframework.aop.framework.Advised) (managedBean));
                managedBean = advised.getTargetSource().getTarget();
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
        return managedBean;
    }

    public static perturbation.location.PerturbationLocation __L3272;

    public static perturbation.location.PerturbationLocation __L3273;

    public static perturbation.location.PerturbationLocation __L3274;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.jmx.AspectUtil.__L3272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/AspectUtil.java:27)", 3272, "Boolean");
        org.broadleafcommerce.common.jmx.AspectUtil.__L3273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/AspectUtil.java:27)", 3273, "Boolean");
        org.broadleafcommerce.common.jmx.AspectUtil.__L3274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/AspectUtil.java:27)", 3274, "Boolean");
    }

    static {
        org.broadleafcommerce.common.jmx.AspectUtil.initPerturbationLocation0();
    }
}

