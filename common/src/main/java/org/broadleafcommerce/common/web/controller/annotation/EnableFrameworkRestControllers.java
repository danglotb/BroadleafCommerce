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
package org.broadleafcommerce.common.web.controller.annotation;


@java.lang.annotation.Target(java.lang.annotation.ElementType.TYPE)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.context.annotation.ComponentScan(useDefaultFilters = false, basePackages = { "org.broadleafcommerce", "com.broadleafcommerce" }, includeFilters = @org.springframework.context.annotation.ComponentScan.Filter({ org.broadleafcommerce.common.web.controller.annotation.FrameworkRestController.class }), nameGenerator = org.broadleafcommerce.common.config.BroadleafBeanNameGenerator.class)
public @interface EnableFrameworkRestControllers {
    @org.springframework.core.annotation.AliasFor(annotation = org.springframework.context.annotation.ComponentScan.class, attribute = "excludeFilters")
    org.springframework.context.annotation.ComponentScan.Filter[] excludeFilters() default {  };
}

