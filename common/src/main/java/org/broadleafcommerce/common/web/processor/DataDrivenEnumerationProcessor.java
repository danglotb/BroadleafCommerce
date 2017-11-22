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
package org.broadleafcommerce.common.web.processor;


@java.lang.Deprecated
@org.springframework.stereotype.Component("blDataDrivenEnumerationProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class DataDrivenEnumerationProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafVariableModifierProcessor {
    @javax.annotation.Resource(name = "blDataDrivenEnumerationService")
    protected org.broadleafcommerce.common.enumeration.service.DataDrivenEnumerationService enumService;

    @javax.annotation.Resource
    protected org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression ddeVariableExpression;

    @java.lang.Override
    public java.lang.String getName() {
        return "enumeration";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.processor.DataDrivenEnumerationProcessor.__L7413, 10000);
    }

    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.Object> populateModelVariables(java.lang.String tagName, java.util.Map<java.lang.String, java.lang.String> tagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> enumValues = ddeVariableExpression.getEnumValues(tagAttributes.get("key"), tagAttributes.get("sort"));
        return com.google.common.collect.ImmutableMap.of("enumValues", ((java.lang.Object) (enumValues)));
    }

    public static perturbation.location.PerturbationLocation __L7413;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.processor.DataDrivenEnumerationProcessor.__L7413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/DataDrivenEnumerationProcessor.java:68)", 7413, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.processor.DataDrivenEnumerationProcessor.initPerturbationLocation0();
    }
}

