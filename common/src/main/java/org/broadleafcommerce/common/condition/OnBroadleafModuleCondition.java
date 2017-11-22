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


public class OnBroadleafModuleCondition implements org.springframework.context.annotation.Condition {
    @java.lang.Override
    public boolean matches(org.springframework.context.annotation.ConditionContext context, org.springframework.core.type.AnnotatedTypeMetadata metadata) {
        org.springframework.util.MultiValueMap<java.lang.String, java.lang.Object> attributes = metadata.getAllAnnotationAttributes(org.broadleafcommerce.common.condition.ConditionalOnBroadleafModule.class.getName());
        java.util.List<java.lang.Object> modules = attributes.get("value");
        java.util.List<java.lang.Object> moduleNames = attributes.get("moduleName");
        java.util.List<java.lang.String> moduleNameStrings = new java.util.ArrayList<>();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L304, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L307, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L305, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L306, modules.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L308, (++i))) {
            org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum module = ((org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum) (modules.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L309, i))));
            java.lang.String moduleName = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L310, ((org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum.IGNORED) != module))) ? module.getName() : ((java.lang.String) (moduleNames.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L311, i))));
            moduleNameStrings.add(moduleName);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L312, org.broadleafcommerce.common.module.ModulePresentUtil.allPresent(moduleNameStrings));
    }

    public static perturbation.location.PerturbationLocation __L304;

    public static perturbation.location.PerturbationLocation __L305;

    public static perturbation.location.PerturbationLocation __L306;

    public static perturbation.location.PerturbationLocation __L307;

    public static perturbation.location.PerturbationLocation __L308;

    public static perturbation.location.PerturbationLocation __L309;

    public static perturbation.location.PerturbationLocation __L310;

    public static perturbation.location.PerturbationLocation __L311;

    public static perturbation.location.PerturbationLocation __L312;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:49)", 304, "Numerical");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:49)", 305, "Numerical");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:49)", 306, "Numerical");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:49)", 307, "Boolean");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:49)", 308, "Numerical");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:50)", 309, "Numerical");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:51)", 310, "Boolean");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:51)", 311, "Numerical");
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.__L312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/condition/OnBroadleafModuleCondition.java:54)", 312, "Boolean");
    }

    static {
        org.broadleafcommerce.common.condition.OnBroadleafModuleCondition.initPerturbationLocation0();
    }
}

