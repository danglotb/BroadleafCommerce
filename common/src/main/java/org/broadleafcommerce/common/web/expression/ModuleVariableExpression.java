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


@org.springframework.stereotype.Component("blModuleVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class ModuleVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @java.lang.Override
    public java.lang.String getName() {
        return "module";
    }

    public boolean isPresent(java.lang.String moduleInQuestion) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.ModuleVariableExpression.__L7210, org.broadleafcommerce.common.module.ModulePresentUtil.isPresent(moduleInQuestion));
    }

    public static perturbation.location.PerturbationLocation __L7210;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.expression.ModuleVariableExpression.__L7210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/ModuleVariableExpression.java:40)", 7210, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.expression.ModuleVariableExpression.initPerturbationLocation0();
    }
}

