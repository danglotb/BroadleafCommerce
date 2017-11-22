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
package org.broadleafcommerce.common.rule;


public abstract class AbstractRuleProcessor<T> implements org.broadleafcommerce.common.rule.RuleProcessor<T> {
    protected final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(this.getClass());

    protected org.mvel2.ParserContext parserContext;

    protected java.util.Map<java.lang.String, java.lang.String> contextClassNames = new java.util.HashMap<java.lang.String, java.lang.String>();

    protected org.mvel2.ParserContext getParserContext() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.AbstractRuleProcessor.__L4619, ((parserContext) == null))) {
            parserContext = new org.mvel2.ParserContext();
            parserContext.addImport("MVEL", org.mvel2.MVEL.class);
            parserContext.addImport("MvelHelper", org.broadleafcommerce.common.rule.MvelHelper.class);
        }
        return parserContext;
    }

    protected java.lang.Boolean executeExpression(java.lang.String expression, java.util.Map<java.lang.String, java.lang.Object> vars) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.AbstractRuleProcessor.__L4620, org.broadleafcommerce.common.rule.MvelHelper.evaluateRule(expression, vars));
    }

    public java.util.Map<java.lang.String, java.lang.String> getContextClassNames() {
        return contextClassNames;
    }

    public void setContextClassNames(java.util.Map<java.lang.String, java.lang.String> contextClassNames) {
        this.contextClassNames = contextClassNames;
    }

    public static perturbation.location.PerturbationLocation __L4619;

    public static perturbation.location.PerturbationLocation __L4620;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.rule.AbstractRuleProcessor.__L4619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/AbstractRuleProcessor.java:42)", 4619, "Boolean");
        org.broadleafcommerce.common.rule.AbstractRuleProcessor.__L4620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/AbstractRuleProcessor.java:59)", 4620, "Boolean");
    }

    static {
        org.broadleafcommerce.common.rule.AbstractRuleProcessor.initPerturbationLocation0();
    }
}

