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
package org.broadleafcommerce.common.presentation;


@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({ java.lang.annotation.ElementType.FIELD })
public @interface AdminPresentationCollection {
    java.lang.String friendlyName() default "";

    java.lang.String addFriendlyName() default "";

    java.lang.String securityLevel() default "";

    boolean excluded() default false;

    boolean readOnly() default false;

    boolean useServerSideInspectionCache() default true;

    org.broadleafcommerce.common.presentation.client.AddMethodType addType() default org.broadleafcommerce.common.presentation.client.AddMethodType.PERSIST;

    java.lang.String manyToField() default "";

    int order() default 99999;

    @java.lang.Deprecated
    java.lang.String tab() default "General";

    @java.lang.Deprecated
    int tabOrder() default 99999;

    java.lang.String[] customCriteria() default {  };

    org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes operationTypes() default @org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes(addType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, fetchType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, inspectType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, removeType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, updateType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC);

    java.lang.String showIfProperty() default "";

    org.broadleafcommerce.common.presentation.FieldValueConfiguration[] showIfFieldEquals() default {  };

    java.lang.String currencyCodeField() default "";

    java.lang.String sortProperty() default "";

    boolean sortAscending() default true;

    boolean lazyFetch() default true;

    boolean manualFetch() default false;

    java.lang.String group() default "";

    java.lang.String selectizeVisibleField() default "";
}

