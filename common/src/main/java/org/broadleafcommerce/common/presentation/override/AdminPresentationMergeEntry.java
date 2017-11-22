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
package org.broadleafcommerce.common.presentation.override;


@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(java.lang.annotation.ElementType.TYPE)
public @interface AdminPresentationMergeEntry {
    java.lang.String propertyType();

    java.lang.String overrideValue() default "";

    double doubleOverrideValue() default java.lang.Double.MIN_VALUE;

    float floatOverrideValue() default java.lang.Float.MIN_VALUE;

    boolean booleanOverrideValue() default false;

    int intOverrideValue() default java.lang.Integer.MIN_VALUE;

    long longOverrideValue() default java.lang.Long.MIN_VALUE;

    java.lang.String[] stringArrayOverrideValue() default {  };

    double[] doubleArrayOverrideValue() default {  };

    float[] floatArrayOverrideValue() default {  };

    boolean[] booleanArrayOverrideValue() default {  };

    int[] intArrayOverrideValue() default {  };

    long[] longArrayOverrideValue() default {  };

    org.broadleafcommerce.common.presentation.ValidationConfiguration[] validationConfigurations() default {  };

    org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes operationTypes() default @org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes(addType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, fetchType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, inspectType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, removeType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC, updateType = org.broadleafcommerce.common.presentation.client.OperationType.BASIC);

    org.broadleafcommerce.common.presentation.OptionFilterParam[] optionFilterParams() default {  };

    org.broadleafcommerce.common.presentation.AdminPresentationMapKey[] keys() default {  };

    org.broadleafcommerce.common.presentation.FieldValueConfiguration[] showIfFieldEquals() default {  };
}

