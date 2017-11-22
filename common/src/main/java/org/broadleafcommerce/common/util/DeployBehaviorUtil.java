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
package org.broadleafcommerce.common.util;


@org.springframework.stereotype.Component("blDeployBehaviorUtil")
public class DeployBehaviorUtil {
    @org.springframework.beans.factory.annotation.Value("${enterprise.use.production.sandbox.mode:false}")
    protected boolean isProductionSandBoxMode;

    @org.springframework.beans.factory.annotation.Value("${mt.loaded.flag:false}")
    protected boolean isMtLoaded;

    public boolean isProductionSandBoxMode() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DeployBehaviorUtil.__L6281, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DeployBehaviorUtil.__L6279, isProductionSandBoxMode)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DeployBehaviorUtil.__L6280, isMtLoaded))));
    }

    public static perturbation.location.PerturbationLocation __L6279;

    public static perturbation.location.PerturbationLocation __L6280;

    public static perturbation.location.PerturbationLocation __L6281;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.DeployBehaviorUtil.__L6279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DeployBehaviorUtil.java:37)", 6279, "Boolean");
        org.broadleafcommerce.common.util.DeployBehaviorUtil.__L6280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DeployBehaviorUtil.java:37)", 6280, "Boolean");
        org.broadleafcommerce.common.util.DeployBehaviorUtil.__L6281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DeployBehaviorUtil.java:37)", 6281, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.DeployBehaviorUtil.initPerturbationLocation0();
    }
}

