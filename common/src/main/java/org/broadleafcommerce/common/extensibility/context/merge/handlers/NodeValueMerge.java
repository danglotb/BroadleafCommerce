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


public class NodeValueMerge extends org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler {
    protected java.lang.String delimiter = " ";

    protected java.lang.String regex = "[\\s\\n\\r]+";

    @java.lang.Override
    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> nodeList1, java.util.List<org.w3c.dom.Node> nodeList2, java.util.List<org.w3c.dom.Node> exhaustedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1478, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1476, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList1))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1477, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList2)))))) {
            return null;
        }
        org.w3c.dom.Node node1 = nodeList1.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1479, 0));
        org.w3c.dom.Node node2 = nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1480, 0));
        java.util.Set<java.lang.String> finalItems = getMergedNodeValues(node1, node2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.String> itr = finalItems.iterator();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1481, itr.hasNext())) {
            sb.append(itr.next());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1482, itr.hasNext())) {
                sb.append(getDelimiter());
            }
        } 
        node1.setNodeValue(sb.toString());
        node2.setNodeValue(sb.toString());
        org.w3c.dom.Node[] response = new org.w3c.dom.Node[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1483, nodeList2.size())];
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1484, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1487, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1485, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1486, response.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1488, (j++))) {
            response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1489, j)] = nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1490, j));
        }
        return response;
    }

    protected java.util.Set<java.lang.String> getMergedNodeValues(org.w3c.dom.Node node1, org.w3c.dom.Node node2) {
        java.lang.String[] items1 = node1.getNodeValue().split(getRegEx());
        java.lang.String[] items2 = node2.getNodeValue().split(getRegEx());
        java.util.Set<java.lang.String> finalItems = new java.util.LinkedHashSet<java.lang.String>();
        for (java.lang.String anItems1 : items1) {
            finalItems.add(anItems1.trim());
        }
        for (java.lang.String anItems2 : items2) {
            finalItems.add(anItems2.trim());
        }
        return finalItems;
    }

    public java.lang.String getDelimiter() {
        return delimiter;
    }

    public java.lang.String getRegEx() {
        return regex;
    }

    public static perturbation.location.PerturbationLocation __L1476;

    public static perturbation.location.PerturbationLocation __L1477;

    public static perturbation.location.PerturbationLocation __L1478;

    public static perturbation.location.PerturbationLocation __L1479;

    public static perturbation.location.PerturbationLocation __L1480;

    public static perturbation.location.PerturbationLocation __L1481;

    public static perturbation.location.PerturbationLocation __L1482;

    public static perturbation.location.PerturbationLocation __L1483;

    public static perturbation.location.PerturbationLocation __L1484;

    public static perturbation.location.PerturbationLocation __L1485;

    public static perturbation.location.PerturbationLocation __L1486;

    public static perturbation.location.PerturbationLocation __L1487;

    public static perturbation.location.PerturbationLocation __L1488;

    public static perturbation.location.PerturbationLocation __L1489;

    public static perturbation.location.PerturbationLocation __L1490;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:44)", 1476, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:44)", 1477, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:44)", 1478, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:47)", 1479, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:48)", 1480, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:52)", 1481, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:54)", 1482, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:61)", 1483, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:62)", 1484, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:62)", 1485, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:62)", 1486, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:62)", 1487, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:62)", 1488, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:63)", 1489, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.__L1490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeValueMerge.java:63)", 1490, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeValueMerge.initPerturbationLocation0();
    }
}

