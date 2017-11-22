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
package org.broadleafcommerce.common.condition;


public class OnMissingBroadleafModuleCondition implements org.springframework.context.annotation.Condition {
    @java.lang.Override
    public boolean matches(org.springframework.context.annotation.ConditionContext context, org.springframework.core.type.AnnotatedTypeMetadata metadata) {
        java.util.Map<java.lang.String, java.lang.Object> attributes = metadata.getAnnotationAttributes(org.broadleafcommerce.common.condition.ConditionalOnMissingBroadleafModule.class.getName());
        org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum module = ((org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum) (attributes.get("value")));
        java.lang.String moduleName = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L313, ((org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum.IGNORED) != module))) ? module.getName() : ((java.lang.String) (attributes.get("moduleName")));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L317, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L314, org.apache.commons.lang3.StringUtils.isNotEmpty(moduleName))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L316, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L315, org.broadleafcommerce.common.module.ModulePresentUtil.isPresent(moduleName))))))));
    }

    public static perturbation.location.PerturbationLocation __L313;

    public static perturbation.location.PerturbationLocation __L314;

    public static perturbation.location.PerturbationLocation __L315;

    public static perturbation.location.PerturbationLocation __L316;

    public static perturbation.location.PerturbationLocation __L317;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnMissingBroadleafModuleCondition.java:38)", 313, "Boolean");
        org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnMissingBroadleafModuleCondition.java:40)", 314, "Boolean");
        org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnMissingBroadleafModuleCondition.java:40)", 315, "Boolean");
        org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnMissingBroadleafModuleCondition.java:40)", 316, "Boolean");
        org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.__L317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnMissingBroadleafModuleCondition.java:40)", 317, "Boolean");
    }

    static {
        org.broadleafcommerce.common.condition.OnMissingBroadleafModuleCondition.initPerturbationLocation0();
    }
}

