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
package org.broadleafcommerce.common.util;


public class PropertyDrivenBeanFactory {
    public static java.lang.Object createInstance(java.lang.String className) {
        return org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(className, new java.lang.String[]{  });
    }

    public static java.lang.Object createInstance(java.lang.String className, java.lang.String... constructorArgs) {
        try {
            java.lang.Object bean;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.__L6498, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.__L6497, org.apache.commons.lang.ArrayUtils.isEmpty(constructorArgs)))))) {
                bean = org.apache.commons.lang.reflect.ConstructorUtils.invokeExactConstructor(java.lang.Class.forName(className), constructorArgs);
            }else {
                bean = org.springframework.beans.BeanUtils.instantiateClass(java.lang.Class.forName(className));
            }
            return bean;
        } catch (java.lang.Exception e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
    }

    public static perturbation.location.PerturbationLocation __L6497;

    public static perturbation.location.PerturbationLocation __L6498;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.__L6497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PropertyDrivenBeanFactory.java:37)", 6497, "Boolean");
        org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.__L6498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PropertyDrivenBeanFactory.java:37)", 6498, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.initPerturbationLocation0();
    }
}

