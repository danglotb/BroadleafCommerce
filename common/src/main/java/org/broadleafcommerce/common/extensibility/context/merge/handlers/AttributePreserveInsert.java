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


public class AttributePreserveInsert extends org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler {
    @java.lang.Override
    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> nodeList1, java.util.List<org.w3c.dom.Node> nodeList2, java.util.List<org.w3c.dom.Node> exhaustedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1284, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1282, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList1))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1283, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList2)))))) {
            return null;
        }
        org.w3c.dom.Node node1 = nodeList1.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1285, 0));
        org.w3c.dom.Node node2 = nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1286, 0));
        org.w3c.dom.NamedNodeMap attributes2 = node2.getAttributes();
        java.util.Comparator<java.lang.Object> nameCompare = new java.util.Comparator<java.lang.Object>() {
            @java.lang.Override
            public int compare(java.lang.Object arg0, java.lang.Object arg1) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1287, ((org.w3c.dom.Node) (arg0)).getNodeName().compareTo(((org.w3c.dom.Node) (arg1)).getNodeName()));
            }
        };
        org.w3c.dom.Node[] tempNodes = new org.w3c.dom.Node[]{  };
        tempNodes = exhaustedNodes.toArray(tempNodes);
        java.util.Arrays.sort(tempNodes, nameCompare);
        int length = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1288, attributes2.getLength());
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1289, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1292, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1290, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1291, length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1293, (j++))) {
            org.w3c.dom.Node temp = attributes2.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1294, j));
            int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1295, java.util.Arrays.binarySearch(tempNodes, temp, nameCompare));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1298, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1296, pos)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1297, 0))))) {
                org.w3c.dom.Attr clone = ((org.w3c.dom.Attr) (temp.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1299, true))));
                ((org.w3c.dom.Element) (node1)).setAttributeNode(((org.w3c.dom.Attr) (node1.getOwnerDocument().importNode(clone, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1300, true)))));
            }
        }
        return null;
    }

    public static perturbation.location.PerturbationLocation __L1282;

    public static perturbation.location.PerturbationLocation __L1283;

    public static perturbation.location.PerturbationLocation __L1284;

    public static perturbation.location.PerturbationLocation __L1285;

    public static perturbation.location.PerturbationLocation __L1286;

    public static perturbation.location.PerturbationLocation __L1287;

    public static perturbation.location.PerturbationLocation __L1288;

    public static perturbation.location.PerturbationLocation __L1289;

    public static perturbation.location.PerturbationLocation __L1290;

    public static perturbation.location.PerturbationLocation __L1291;

    public static perturbation.location.PerturbationLocation __L1292;

    public static perturbation.location.PerturbationLocation __L1293;

    public static perturbation.location.PerturbationLocation __L1294;

    public static perturbation.location.PerturbationLocation __L1295;

    public static perturbation.location.PerturbationLocation __L1296;

    public static perturbation.location.PerturbationLocation __L1297;

    public static perturbation.location.PerturbationLocation __L1298;

    public static perturbation.location.PerturbationLocation __L1299;

    public static perturbation.location.PerturbationLocation __L1300;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:40)", 1282, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:40)", 1283, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:40)", 1284, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:43)", 1285, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:44)", 1286, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:50)", 1287, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:56)", 1288, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:57)", 1289, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:57)", 1290, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:57)", 1291, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:57)", 1292, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:57)", 1293, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:58)", 1294, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:59)", 1295, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:60)", 1296, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:60)", 1297, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:60)", 1298, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:61)", 1299, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.__L1300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/AttributePreserveInsert.java:62)", 1300, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert.initPerturbationLocation0();
    }
}

