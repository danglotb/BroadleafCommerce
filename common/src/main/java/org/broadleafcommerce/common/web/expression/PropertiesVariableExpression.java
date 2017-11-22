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


@org.springframework.stereotype.Component("blPropertiesVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class PropertiesVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @java.lang.Override
    public java.lang.String getName() {
        return "props";
    }

    public java.lang.String get(java.lang.String propertyName) {
        return org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(propertyName);
    }

    public int getAsInt(java.lang.String propertyName) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7211, org.broadleafcommerce.common.util.BLCSystemProperty.resolveIntSystemProperty(propertyName));
    }

    public boolean getAsBoolean(java.lang.String propertyName) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7212, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(propertyName));
    }

    public long getAsLong(java.lang.String propertyName) {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7213, org.broadleafcommerce.common.util.BLCSystemProperty.resolveLongSystemProperty(propertyName));
    }

    public boolean getForceShowIdColumns() {
        javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
        boolean forceShow = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7214, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("listGrid.forceShowIdColumns"));
        forceShow = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7217, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7215, forceShow)) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7216, "true".equals(request.getParameter("showIds"))))));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7218, forceShow);
    }

    public static perturbation.location.PerturbationLocation __L7211;

    public static perturbation.location.PerturbationLocation __L7212;

    public static perturbation.location.PerturbationLocation __L7213;

    public static perturbation.location.PerturbationLocation __L7214;

    public static perturbation.location.PerturbationLocation __L7215;

    public static perturbation.location.PerturbationLocation __L7216;

    public static perturbation.location.PerturbationLocation __L7217;

    public static perturbation.location.PerturbationLocation __L7218;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:55)", 7211, "Numerical");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:59)", 7212, "Boolean");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:63)", 7213, "Numerical");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:73)", 7214, "Boolean");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:74)", 7215, "Boolean");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:74)", 7216, "Boolean");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:74)", 7217, "Boolean");
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.__L7218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/PropertiesVariableExpression.java:76)", 7218, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.expression.PropertiesVariableExpression.initPerturbationLocation0();
    }
}

