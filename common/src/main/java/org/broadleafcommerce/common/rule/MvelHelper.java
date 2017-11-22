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


public class MvelHelper {
    private static final java.util.Map<java.lang.String, java.io.Serializable> DEFAULT_EXPRESSION_CACHE = new org.broadleafcommerce.common.util.EfficientLRUMap<java.lang.String, java.io.Serializable>(5000);

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.rule.MvelHelper.class);

    private static boolean TEST_MODE = false;

    public static final java.lang.String BLC_RULE_MAP_PARAM = "blRuleMap";

    public static final java.lang.String REQUEST_DTO = "blRequestDTO";

    public static java.lang.Object convertField(java.lang.String type, java.lang.String fieldValue) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4621, (fieldValue == null))) {
            return null;
        }
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4622, type.equals(org.broadleafcommerce.common.presentation.client.SupportedFieldType.BOOLEAN.toString()))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4623, java.lang.Boolean.parseBoolean(fieldValue));
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4624, type.equals(org.broadleafcommerce.common.presentation.client.SupportedFieldType.DATE.toString()))) {
                    return org.broadleafcommerce.common.util.FormatUtil.getTimeZoneFormat().parse(fieldValue);
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4625, type.equals(org.broadleafcommerce.common.presentation.client.SupportedFieldType.INTEGER.toString()))) {
                        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.rule.MvelHelper.__L4626, java.lang.Integer.parseInt(fieldValue));
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4629, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4627, type.equals(org.broadleafcommerce.common.presentation.client.SupportedFieldType.MONEY.toString()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4628, type.equals(org.broadleafcommerce.common.presentation.client.SupportedFieldType.DECIMAL.toString())))))) {
                            return new java.math.BigDecimal(fieldValue);
                        }



        } catch (java.text.ParseException e) {
            throw new java.lang.RuntimeException(e);
        }
        throw new java.lang.IllegalArgumentException((("Unrecognized type(" + type) + ") for map field conversion."));
    }

    public static java.lang.Object toUpperCase(java.lang.String value) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4630, (value == null))) {
            return null;
        }
        return value.toUpperCase();
    }

    public static boolean evaluateRule(java.lang.String rule, java.util.Map<java.lang.String, java.lang.Object> ruleParameters) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4631, org.broadleafcommerce.common.rule.MvelHelper.evaluateRule(rule, ruleParameters, org.broadleafcommerce.common.rule.MvelHelper.DEFAULT_EXPRESSION_CACHE));
    }

    public static boolean evaluateRule(java.lang.String rule, java.util.Map<java.lang.String, java.lang.Object> ruleParameters, java.util.Map<java.lang.String, java.io.Serializable> expressionCache) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4632, org.broadleafcommerce.common.rule.MvelHelper.evaluateRule(rule, ruleParameters, expressionCache, null));
    }

    public static boolean evaluateRule(java.lang.String rule, java.util.Map<java.lang.String, java.lang.Object> ruleParameters, java.util.Map<java.lang.String, java.io.Serializable> expressionCache, java.util.Map<java.lang.String, java.lang.Class<?>> additionalContextImports) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4635, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4633, (rule == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4634, "".equals(rule)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4636, true);
        }else {
            java.io.Serializable exp = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4637, (expressionCache != null))) {
                exp = expressionCache.get(rule);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4638, (exp == null))) {
                org.mvel2.ParserContext context = new org.mvel2.ParserContext();
                context.addImport("MVEL", org.mvel2.MVEL.class);
                context.addImport("MvelHelper", org.broadleafcommerce.common.rule.MvelHelper.class);
                context.addImport("CollectionUtils", org.broadleafcommerce.common.rule.SelectizeCollectionUtils.class);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4639, org.apache.commons.collections4.MapUtils.isNotEmpty(additionalContextImports))) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.Class<?>> entry : additionalContextImports.entrySet()) {
                        context.addImport(entry.getKey(), entry.getValue());
                    }
                }
                java.lang.String modifiedRule = org.broadleafcommerce.common.rule.MvelHelper.modifyExpression(rule, ruleParameters, context);
                synchronized(expressionCache) {
                    exp = org.mvel2.MVEL.compileExpression(modifiedRule, context);
                    expressionCache.put(rule, exp);
                }
            }
            java.util.Map<java.lang.String, java.lang.Object> mvelParameters = new java.util.HashMap<java.lang.String, java.lang.Object>();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4640, (ruleParameters != null))) {
                for (java.lang.String parameter : ruleParameters.keySet()) {
                    mvelParameters.put(parameter, ruleParameters.get(parameter));
                }
            }
            try {
                java.lang.Object test = org.mvel2.MVEL.executeExpression(exp, mvelParameters);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4641, (test == null))) {
                    return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4642, true);
                }
                return ((java.lang.Boolean) (test));
            } catch (java.lang.Exception e) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4646, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4644, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4643, org.broadleafcommerce.common.rule.MvelHelper.TEST_MODE))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4645, org.broadleafcommerce.common.rule.MvelHelper.LOG.isInfoEnabled()))))) {
                    org.broadleafcommerce.common.rule.MvelHelper.LOG.info((("Unable to parse and/or execute the mvel expression (" + (org.broadleafcommerce.common.util.StringUtil.sanitize(rule))) + "). Reporting to the logs and returning false for the match expression"), e);
                }
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4647, false);
            }
        }
    }

    protected static java.lang.String modifyExpression(java.lang.String rule, java.util.Map<java.lang.String, java.lang.Object> ruleParameters, org.mvel2.ParserContext context) {
        java.lang.String modifiedExpression = rule;
        for (java.lang.String attributeMap : org.broadleafcommerce.common.rule.MvelHelper.getRuleAttributeMaps()) {
            modifiedExpression = modifiedExpression.replaceAll((attributeMap + "\\(\\)\\[(.*?)\\](?!\\.\\?value)"), (attributeMap + "().?get($1).?value"));
        }
        return modifiedExpression;
    }

    protected static java.lang.String[] getRuleAttributeMaps() {
        return new java.lang.String[]{ "getProductAttributes", "getCategoryAttributesMap", "getSkuAttributes", "getOrderItemAttributes", "getCustomerAttributes", "getAdditionalAttributes", "getAdditionalFields" };
    }

    public static void setTestMode(boolean testMode) {
        org.broadleafcommerce.common.rule.MvelHelper.TEST_MODE = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4648, testMode);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> buildMvelParameters() {
        java.util.Map<java.lang.String, java.lang.Object> mvelParameters = new java.util.HashMap<java.lang.String, java.lang.Object>();
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4651, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4649, (brc != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4650, ((brc.getRequest()) != null)))))) {
            org.broadleafcommerce.common.TimeDTO timeDto = new org.broadleafcommerce.common.TimeDTO(org.broadleafcommerce.common.time.SystemTime.asCalendar());
            javax.servlet.http.HttpServletRequest request = brc.getRequest();
            org.broadleafcommerce.common.RequestDTO requestDto = brc.getRequestDTO();
            mvelParameters.put("time", timeDto);
            mvelParameters.put("request", requestDto);
            java.util.Map<java.lang.String, java.lang.Object> blcRuleMap = ((java.util.Map<java.lang.String, java.lang.Object>) (request.getAttribute(org.broadleafcommerce.common.rule.MvelHelper.BLC_RULE_MAP_PARAM)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.MvelHelper.__L4652, (blcRuleMap != null))) {
                for (java.lang.String mapKey : blcRuleMap.keySet()) {
                    mvelParameters.put(mapKey, blcRuleMap.get(mapKey));
                }
            }
        }
        return mvelParameters;
    }

    public static perturbation.location.PerturbationLocation __L4621;

    public static perturbation.location.PerturbationLocation __L4622;

    public static perturbation.location.PerturbationLocation __L4623;

    public static perturbation.location.PerturbationLocation __L4624;

    public static perturbation.location.PerturbationLocation __L4625;

    public static perturbation.location.PerturbationLocation __L4626;

    public static perturbation.location.PerturbationLocation __L4627;

    public static perturbation.location.PerturbationLocation __L4628;

    public static perturbation.location.PerturbationLocation __L4629;

    public static perturbation.location.PerturbationLocation __L4630;

    public static perturbation.location.PerturbationLocation __L4631;

    public static perturbation.location.PerturbationLocation __L4632;

    public static perturbation.location.PerturbationLocation __L4633;

    public static perturbation.location.PerturbationLocation __L4634;

    public static perturbation.location.PerturbationLocation __L4635;

    public static perturbation.location.PerturbationLocation __L4636;

    public static perturbation.location.PerturbationLocation __L4637;

    public static perturbation.location.PerturbationLocation __L4638;

    public static perturbation.location.PerturbationLocation __L4639;

    public static perturbation.location.PerturbationLocation __L4640;

    public static perturbation.location.PerturbationLocation __L4641;

    public static perturbation.location.PerturbationLocation __L4642;

    public static perturbation.location.PerturbationLocation __L4643;

    public static perturbation.location.PerturbationLocation __L4644;

    public static perturbation.location.PerturbationLocation __L4645;

    public static perturbation.location.PerturbationLocation __L4646;

    public static perturbation.location.PerturbationLocation __L4647;

    public static perturbation.location.PerturbationLocation __L4648;

    public static perturbation.location.PerturbationLocation __L4649;

    public static perturbation.location.PerturbationLocation __L4650;

    public static perturbation.location.PerturbationLocation __L4651;

    public static perturbation.location.PerturbationLocation __L4652;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.rule.MvelHelper.__L4621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:76)", 4621, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:80)", 4622, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:81)", 4623, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:82)", 4624, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:84)", 4625, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:85)", 4626, "Numerical");
        org.broadleafcommerce.common.rule.MvelHelper.__L4627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:86)", 4627, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:86)", 4628, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:86)", 4629, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:96)", 4630, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:116)", 4631, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:128)", 4632, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:143)", 4633, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:143)", 4634, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:143)", 4635, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:144)", 4636, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:148)", 4637, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:151)", 4638, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:156)", 4639, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:172)", 4640, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:180)", 4641, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:182)", 4642, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:188)", 4643, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:188)", 4644, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:188)", 4645, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:188)", 4646, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:192)", 4647, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:246)", 4648, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:260)", 4649, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:260)", 4650, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:260)", 4651, "Boolean");
        org.broadleafcommerce.common.rule.MvelHelper.__L4652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/MvelHelper.java:268)", 4652, "Boolean");
    }

    static {
        java.lang.System.setProperty("mvel2.disable.jit", "true");
    }

    static {
        org.broadleafcommerce.common.rule.MvelHelper.initPerturbationLocation0();
    }
}

