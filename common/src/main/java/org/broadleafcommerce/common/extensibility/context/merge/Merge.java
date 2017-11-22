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


@java.lang.annotation.Target(java.lang.annotation.ElementType.METHOD)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@org.springframework.context.annotation.Bean
public @interface Merge {
    @org.springframework.core.annotation.AliasFor("targetRef")
    java.lang.String value() default "";

    @org.springframework.core.annotation.AliasFor("value")
    java.lang.String targetRef() default "";

    org.broadleafcommerce.common.extensibility.context.merge.Placement placement() default org.broadleafcommerce.common.extensibility.context.merge.Placement.APPEND;

    int position() default 0;

    java.lang.Class<org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider> statusProvider() default org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider.class;

    boolean early() default false;
}

