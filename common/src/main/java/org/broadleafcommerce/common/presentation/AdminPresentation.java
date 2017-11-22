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
public @interface AdminPresentation {
    java.lang.String friendlyName() default "";

    java.lang.String addFriendlyName() default "";

    java.lang.String securityLevel() default "";

    int order() default 99999;

    int gridOrder() default 9999;

    org.broadleafcommerce.common.presentation.client.VisibilityEnum visibility() default org.broadleafcommerce.common.presentation.client.VisibilityEnum.VISIBLE_ALL;

    org.broadleafcommerce.common.presentation.client.SupportedFieldType fieldType() default org.broadleafcommerce.common.presentation.client.SupportedFieldType.UNKNOWN;

    org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType displayType() default org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType.NORMAL;

    boolean canLinkToExternalEntity() default true;

    java.lang.String group() default "General";

    @java.lang.Deprecated
    int groupOrder() default 99999;

    @java.lang.Deprecated
    boolean groupCollapsed() default false;

    @java.lang.Deprecated
    java.lang.String tab() default "General";

    @java.lang.Deprecated
    int tabOrder() default 99999;

    boolean largeEntry() default false;

    boolean prominent() default false;

    java.lang.String columnWidth() default "*";

    java.lang.String broadleafEnumeration() default "";

    boolean hideEnumerationIfEmpty() default false;

    @java.lang.Deprecated
    boolean allowNoValueEnumOption() default false;

    org.broadleafcommerce.common.presentation.client.SupportedFieldType fieldComponentRenderer() default org.broadleafcommerce.common.presentation.client.SupportedFieldType.UNKNOWN;

    boolean readOnly() default false;

    org.broadleafcommerce.common.presentation.ValidationConfiguration[] validationConfigurations() default {  };

    org.broadleafcommerce.common.presentation.RequiredOverride requiredOverride() default org.broadleafcommerce.common.presentation.RequiredOverride.IGNORED;

    boolean excluded() default false;

    java.lang.String tooltip() default "";

    java.lang.String helpText() default "";

    java.lang.String hint() default "";

    java.lang.String showIfProperty() default "";

    org.broadleafcommerce.common.presentation.FieldValueConfiguration[] showIfFieldEquals() default {  };

    java.lang.String currencyCodeField() default "";

    java.lang.String ruleIdentifier() default "";

    boolean translatable() default false;

    java.lang.String defaultValue() default "";

    java.lang.String associatedFieldName() default "";
}

