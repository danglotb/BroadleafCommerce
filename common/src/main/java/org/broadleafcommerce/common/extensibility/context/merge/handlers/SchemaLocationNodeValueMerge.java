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
package org.broadleafcommerce.common.extensibility.context.merge.handlers;


public class SchemaLocationNodeValueMerge extends org.broadleafcommerce.common.extensibility.context.merge.handlers.SpaceDelimitedNodeValueMerge {
    @java.lang.Override
    protected java.util.Set<java.lang.String> getMergedNodeValues(org.w3c.dom.Node node1, org.w3c.dom.Node node2) {
        java.lang.String node1Values = getSanitizedValue(node1.getNodeValue());
        java.lang.String node2Values = getSanitizedValue(node2.getNodeValue());
        java.util.Set<java.lang.String> finalItems = new java.util.LinkedHashSet<java.lang.String>();
        for (java.lang.String node1Value : node1Values.split(getRegEx())) {
            finalItems.add(node1Value.trim());
        }
        for (java.lang.String node2Value : node2Values.split(getRegEx())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.__L1516, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.__L1515, finalItems.contains(node2Value.trim())))))) {
                finalItems.add(node2Value.trim());
            }
        }
        return finalItems;
    }

    protected java.lang.String getSanitizedValue(java.lang.String attributeValue) {
        java.util.regex.Pattern springVersionPattern = java.util.regex.Pattern.compile("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)");
        java.util.regex.Matcher versionMatcher = springVersionPattern.matcher(attributeValue);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.__L1517, versionMatcher.find())) {
            java.lang.String match = versionMatcher.group();
            java.lang.String replacement = match.replaceAll("-[0-9]\\.[0-9]", "");
            attributeValue = attributeValue.replaceAll(match, replacement);
        } 
        return attributeValue;
    }

    public static perturbation.location.PerturbationLocation __L1515;

    public static perturbation.location.PerturbationLocation __L1516;

    public static perturbation.location.PerturbationLocation __L1517;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.__L1515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/SchemaLocationNodeValueMerge.java:52)", 1515, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.__L1516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/SchemaLocationNodeValueMerge.java:52)", 1516, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.__L1517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/SchemaLocationNodeValueMerge.java:73)", 1517, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationNodeValueMerge.initPerturbationLocation0();
    }
}

