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


@org.springframework.stereotype.Component("blAssetURLVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class AssetURLVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @javax.annotation.Resource(name = "blStaticAssetPathService")
    protected org.broadleafcommerce.common.file.service.StaticAssetPathService staticAssetPathService;

    @java.lang.Override
    public java.lang.String getName() {
        return "cms";
    }

    public java.lang.String fixUrl(java.lang.String content) {
        boolean isSecure = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7178, false);
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7179, (brc != null))) {
            isSecure = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7180, brc.getRequest().isSecure());
        }
        return staticAssetPathService.convertAllAssetPathsInContent(content, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7181, isSecure));
    }

    public static perturbation.location.PerturbationLocation __L7178;

    public static perturbation.location.PerturbationLocation __L7179;

    public static perturbation.location.PerturbationLocation __L7180;

    public static perturbation.location.PerturbationLocation __L7181;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/AssetURLVariableExpression.java:59)", 7178, "Boolean");
        org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/AssetURLVariableExpression.java:61)", 7179, "Boolean");
        org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/AssetURLVariableExpression.java:62)", 7180, "Boolean");
        org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.__L7181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/AssetURLVariableExpression.java:64)", 7181, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.expression.AssetURLVariableExpression.initPerturbationLocation0();
    }
}

