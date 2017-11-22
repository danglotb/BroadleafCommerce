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
package org.broadleafcommerce.common.config;


public class BroadleafBeanNameGenerator extends org.springframework.context.annotation.AnnotationBeanNameGenerator {
    public static final java.lang.String BROADLEAF_BEAN_PREFIX = "bl";

    @java.lang.Override
    public java.lang.String generateBeanName(org.springframework.beans.factory.config.BeanDefinition definition, org.springframework.beans.factory.support.BeanDefinitionRegistry registry) {
        java.lang.String beanName = super.generateBeanName(definition, registry);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.__L471, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.__L470, beanName.startsWith(org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.BROADLEAF_BEAN_PREFIX)))))) {
            beanName = (org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.BROADLEAF_BEAN_PREFIX) + (org.springframework.util.StringUtils.capitalize(beanName));
        }
        return beanName;
    }

    public static perturbation.location.PerturbationLocation __L470;

    public static perturbation.location.PerturbationLocation __L471;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.__L470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafBeanNameGenerator.java:46)", 470, "Boolean");
        org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.__L471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafBeanNameGenerator.java:46)", 471, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.initPerturbationLocation0();
    }
}

