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
package org.broadleafcommerce.common.module;


public class ModulePresentUtil {
    public static final java.util.List<org.broadleafcommerce.common.module.BroadleafModuleRegistration> MODULE_REGISTRATIONS = org.springframework.core.io.support.SpringFactoriesLoader.loadFactories(org.broadleafcommerce.common.module.BroadleafModuleRegistration.class, null);

    public static boolean isPresent(@javax.annotation.Nonnull
    final org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum moduleInQuestion) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3537, org.broadleafcommerce.common.module.ModulePresentUtil.isPresent(moduleInQuestion.getName()));
    }

    public static boolean allPresent(@javax.annotation.Nonnull
    final java.util.List<java.lang.String> modulesInQuestion) {
        for (java.lang.String module : modulesInQuestion) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3541, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3538, org.apache.commons.lang3.StringUtils.isEmpty(module))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3540, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3539, org.broadleafcommerce.common.module.ModulePresentUtil.isPresent(module))))))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3542, false);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3543, true);
    }

    public static boolean isPresent(@javax.annotation.Nonnull
    final java.lang.String moduleInQuestion) {
        for (org.broadleafcommerce.common.module.BroadleafModuleRegistration registration : org.broadleafcommerce.common.module.ModulePresentUtil.MODULE_REGISTRATIONS) {
            java.lang.String moduleName = registration.getModuleName();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3544, moduleInQuestion.equals(moduleName))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3545, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.module.ModulePresentUtil.__L3546, false);
    }

    public static perturbation.location.PerturbationLocation __L3537;

    public static perturbation.location.PerturbationLocation __L3538;

    public static perturbation.location.PerturbationLocation __L3539;

    public static perturbation.location.PerturbationLocation __L3540;

    public static perturbation.location.PerturbationLocation __L3541;

    public static perturbation.location.PerturbationLocation __L3542;

    public static perturbation.location.PerturbationLocation __L3543;

    public static perturbation.location.PerturbationLocation __L3544;

    public static perturbation.location.PerturbationLocation __L3545;

    public static perturbation.location.PerturbationLocation __L3546;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:53)", 3537, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:65)", 3538, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:65)", 3539, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:65)", 3540, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:65)", 3541, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:66)", 3542, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:69)", 3543, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:81)", 3544, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:82)", 3545, "Boolean");
        org.broadleafcommerce.common.module.ModulePresentUtil.__L3546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/module/ModulePresentUtil.java:86)", 3546, "Boolean");
    }

    static {
        org.broadleafcommerce.common.module.ModulePresentUtil.initPerturbationLocation0();
    }
}

