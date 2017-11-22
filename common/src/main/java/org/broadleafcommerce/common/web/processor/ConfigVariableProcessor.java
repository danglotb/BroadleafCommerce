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
@org.springframework.stereotype.Component("blConfigVariableProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class ConfigVariableProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafVariableModifierProcessor {
    @java.lang.Override
    public java.lang.String getName() {
        return "config";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.processor.ConfigVariableProcessor.__L7411, 10000);
    }

    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.Object> populateModelVariables(java.lang.String tagName, java.util.Map<java.lang.String, java.lang.String> tagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.lang.String resultVar = tagAttributes.get("resultVar");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ConfigVariableProcessor.__L7412, (resultVar == null))) {
            resultVar = "value";
        }
        java.lang.String attributeName = tagAttributes.get("name");
        java.lang.String attributeValue = org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(attributeName);
        return com.google.common.collect.ImmutableMap.of(resultVar, ((java.lang.Object) (attributeValue)));
    }

    public static perturbation.location.PerturbationLocation __L7411;

    public static perturbation.location.PerturbationLocation __L7412;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.processor.ConfigVariableProcessor.__L7411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ConfigVariableProcessor.java:58)", 7411, "Numerical");
        org.broadleafcommerce.common.web.processor.ConfigVariableProcessor.__L7412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ConfigVariableProcessor.java:67)", 7412, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.processor.ConfigVariableProcessor.initPerturbationLocation0();
    }
}

