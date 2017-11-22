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


@org.springframework.stereotype.Component("blBreadcrumbVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class BreadcrumbVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @javax.annotation.Resource(name = "blBreadcrumbService")
    protected org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbService breadcrumbService;

    @java.lang.Override
    public java.lang.String getName() {
        return "breadcrumbs";
    }

    public java.util.List<org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO> getBreadcrumbs() {
        java.lang.String baseUrl = getBaseUrl();
        java.util.Map<java.lang.String, java.lang.String[]> params = getParams();
        return breadcrumbService.buildBreadcrumbDTOs(baseUrl, params);
    }

    protected java.lang.String getBaseUrl() {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.__L7201, (brc != null))) {
            return brc.getRequest().getRequestURI();
        }
        return "";
    }

    protected java.util.Map<java.lang.String, java.lang.String[]> getParams() {
        java.util.Map<java.lang.String, java.lang.String[]> paramMap = new java.util.HashMap<>();
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.__L7202, (brc != null))) {
            paramMap = org.broadleafcommerce.common.web.BroadleafRequestContext.getRequestParameterMap();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.__L7203, (paramMap != null))) {
                paramMap = new java.util.HashMap<>(paramMap);
            }
        }
        return paramMap;
    }

    public static perturbation.location.PerturbationLocation __L7201;

    public static perturbation.location.PerturbationLocation __L7202;

    public static perturbation.location.PerturbationLocation __L7203;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.__L7201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BreadcrumbVariableExpression.java:61)", 7201, "Boolean");
        org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.__L7202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BreadcrumbVariableExpression.java:71)", 7202, "Boolean");
        org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.__L7203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BreadcrumbVariableExpression.java:73)", 7203, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression.initPerturbationLocation0();
    }
}

