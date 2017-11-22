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
package org.broadleafcommerce.common.breadcrumbs.processor;


@org.springframework.stereotype.Component("blBreadcrumbProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class BreadcrumbProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafVariableModifierProcessor {
    @javax.annotation.Resource
    protected org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression breadcrumbVariableExpression;

    @java.lang.Override
    public java.lang.String getName() {
        return "breadcrumbs";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L108, 10000);
    }

    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.Object> populateModelVariables(java.lang.String tagName, java.util.Map<java.lang.String, java.lang.String> tagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.util.List<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO> dtos = breadcrumbVariableExpression.getBreadcrumbs();
        java.lang.String resultVar = tagAttributes.get("resultVar");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L109, (resultVar == null))) {
            resultVar = "breadcrumbs";
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L111, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L110, org.springframework.util.CollectionUtils.isEmpty(dtos)))))) {
            return com.google.common.collect.ImmutableMap.of(resultVar, ((java.lang.Object) (dtos)));
        }
        return null;
    }

    public static perturbation.location.PerturbationLocation __L108;

    public static perturbation.location.PerturbationLocation __L109;

    public static perturbation.location.PerturbationLocation __L110;

    public static perturbation.location.PerturbationLocation __L111;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/processor/BreadcrumbProcessor.java:55)", 108, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/processor/BreadcrumbProcessor.java:64)", 109, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/processor/BreadcrumbProcessor.java:68)", 110, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.__L111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/processor/BreadcrumbProcessor.java:68)", 111, "Boolean");
    }

    static {
        org.broadleafcommerce.common.breadcrumbs.processor.BreadcrumbProcessor.initPerturbationLocation0();
    }
}

