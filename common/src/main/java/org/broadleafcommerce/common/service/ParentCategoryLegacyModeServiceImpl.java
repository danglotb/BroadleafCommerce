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
package org.broadleafcommerce.common.service;


@org.springframework.stereotype.Service("blParentCategoryLegacyModeService")
public class ParentCategoryLegacyModeServiceImpl implements org.broadleafcommerce.common.service.ParentCategoryLegacyModeService , org.springframework.context.ApplicationContextAware {
    public static final java.lang.String USE_LEGACY_DEFAULT_CATEGORY_MODE = "use.legacy.default.category.mode";

    private static org.springframework.context.ApplicationContext applicationContext;

    private static org.broadleafcommerce.common.service.ParentCategoryLegacyModeService service;

    @org.springframework.beans.factory.annotation.Value(("${" + (org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.USE_LEGACY_DEFAULT_CATEGORY_MODE)) + ":false}")
    protected boolean useLegacyDefaultCategoryMode = false;

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        this.applicationContext = applicationContext;
    }

    @java.lang.Override
    public boolean isLegacyMode() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.__L5179, useLegacyDefaultCategoryMode);
    }

    public static org.broadleafcommerce.common.service.ParentCategoryLegacyModeService getLegacyModeService() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.__L5180, ((org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.applicationContext) == null))) {
            return null;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.__L5181, ((org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.service) == null))) {
            org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.service = ((org.broadleafcommerce.common.service.ParentCategoryLegacyModeService) (org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.applicationContext.getBean("blParentCategoryLegacyModeService")));
        }
        return org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.service;
    }

    public static perturbation.location.PerturbationLocation __L5179;

    public static perturbation.location.PerturbationLocation __L5180;

    public static perturbation.location.PerturbationLocation __L5181;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.__L5179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/ParentCategoryLegacyModeServiceImpl.java:46)", 5179, "Boolean");
        org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.__L5180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/ParentCategoryLegacyModeServiceImpl.java:50)", 5180, "Boolean");
        org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.__L5181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/ParentCategoryLegacyModeServiceImpl.java:53)", 5181, "Boolean");
    }

    static {
        org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.initPerturbationLocation0();
    }
}

