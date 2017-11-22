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
package org.broadleafcommerce.common.breadcrumbs.service;


@org.springframework.stereotype.Service("blBreadcrumbService")
public class BreadcrumbServiceImpl implements org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbService {
    @javax.annotation.Resource(name = "blBreadcrumbServiceExtensionManager")
    protected org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager extensionManager;

    public java.util.List<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO> buildBreadcrumbDTOs(java.lang.String baseUrl, java.util.Map<java.lang.String, java.lang.String[]> params) {
        java.util.List<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO> dtos = new java.util.ArrayList<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceImpl.__L112, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO>> holder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO>>();
            holder.setResult(dtos);
            extensionManager.getProxy().modifyBreadcrumbList(baseUrl, params, holder);
            dtos = holder.getResult();
        }
        return dtos;
    }

    public static perturbation.location.PerturbationLocation __L112;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceImpl.__L112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/service/BreadcrumbServiceImpl.java:39)", 112, "Boolean");
    }

    static {
        org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceImpl.initPerturbationLocation0();
    }
}

