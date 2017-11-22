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
package org.broadleafcommerce.common.web.expression;


@org.springframework.stereotype.Component("blDataDrivenEnumVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class DataDrivenEnumVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @javax.annotation.Resource(name = "blDataDrivenEnumerationService")
    protected org.broadleafcommerce.common.enumeration.service.DataDrivenEnumerationService enumService;

    @java.lang.Override
    public java.lang.String getName() {
        return "enumeration";
    }

    public java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> getEnumValues(java.lang.String key) {
        return getEnumValues(key, null);
    }

    public java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> getEnumValues(java.lang.String key, final java.lang.String sort) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7204, org.apache.commons.lang3.StringUtils.isEmpty(key))) {
            throw new java.lang.IllegalArgumentException("No 'key' parameter was passed to find enumeration values");
        }
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration ddEnum = enumService.findEnumByKey(key);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7205, (ddEnum == null))) {
            throw new java.lang.IllegalArgumentException(("Could not find a data driven enumeration keyed by " + key));
        }
        java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> enumValues = new java.util.ArrayList<>(ddEnum.getEnumValues());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7206, org.apache.commons.lang3.StringUtils.isNotEmpty(sort))) {
            java.util.Collections.sort(enumValues, new java.util.Comparator<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue>() {
                @java.lang.Override
                public int compare(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue arg0, org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue arg1) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7207, sort.equals("ASCENDING"))) {
                        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7208, arg0.getDisplay().compareTo(arg1.getDisplay()));
                    }else {
                        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7209, arg1.getDisplay().compareTo(arg0.getDisplay()));
                    }
                }
            });
        }
        return enumValues;
    }

    public static perturbation.location.PerturbationLocation __L7204;

    public static perturbation.location.PerturbationLocation __L7205;

    public static perturbation.location.PerturbationLocation __L7206;

    public static perturbation.location.PerturbationLocation __L7207;

    public static perturbation.location.PerturbationLocation __L7208;

    public static perturbation.location.PerturbationLocation __L7209;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/DataDrivenEnumVariableExpression.java:70)", 7204, "Boolean");
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/DataDrivenEnumVariableExpression.java:75)", 7205, "Boolean");
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/DataDrivenEnumVariableExpression.java:80)", 7206, "Boolean");
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/DataDrivenEnumVariableExpression.java:85)", 7207, "Boolean");
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/DataDrivenEnumVariableExpression.java:86)", 7208, "Numerical");
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.__L7209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/DataDrivenEnumVariableExpression.java:88)", 7209, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression.initPerturbationLocation0();
    }
}

