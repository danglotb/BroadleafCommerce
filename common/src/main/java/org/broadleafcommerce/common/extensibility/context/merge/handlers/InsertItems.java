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


public class InsertItems extends org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.class);

    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> nodeList1, java.util.List<org.w3c.dom.Node> nodeList2, java.util.List<org.w3c.dom.Node> exhaustedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1330, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1328, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList1))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1329, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList2)))))) {
            return null;
        }
        java.util.List<org.w3c.dom.Node> usedNodes = new java.util.ArrayList<org.w3c.dom.Node>();
        org.w3c.dom.Node node1Parent = nodeList1.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1331, 0)).getParentNode();
        for (org.w3c.dom.Node aNodeList2 : nodeList2) {
            org.w3c.dom.Node tempNode = node1Parent.getOwnerDocument().importNode(aNodeList2.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1332, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1333, true));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1334, org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.LOG.isDebugEnabled())) {
                java.lang.StringBuffer sb = new java.lang.StringBuffer();
                sb.append("matching node for insertion: ");
                sb.append(tempNode.getNodeName());
                int attrLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1335, tempNode.getAttributes().getLength());
                for (int x = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1336, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1339, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1337, x)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1338, attrLength)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1340, (x++))) {
                    sb.append(" : (");
                    sb.append(tempNode.getAttributes().item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1341, x)).getNodeName());
                    sb.append("/");
                    sb.append(tempNode.getAttributes().item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1342, x)).getNodeValue());
                    sb.append(")");
                }
                org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.LOG.debug(sb.toString());
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1343, org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.LOG.isDebugEnabled())) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("inserting into parent: ");
                sb.append(node1Parent.getNodeName());
                int attrLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1344, node1Parent.getAttributes().getLength());
                for (int x = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1345, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1348, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1346, x)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1347, attrLength)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1349, (x++))) {
                    sb.append(" : (");
                    sb.append(node1Parent.getAttributes().item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1350, x)).getNodeName());
                    sb.append("/");
                    sb.append(node1Parent.getAttributes().item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1351, x)).getNodeValue());
                    sb.append(")");
                }
                org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.LOG.debug(sb.toString());
            }
            node1Parent.appendChild(tempNode);
            usedNodes.add(tempNode);
        }
        org.w3c.dom.Node[] response = new org.w3c.dom.Node[]{ nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1352, 0)).getParentNode() };
        return response;
    }

    public static perturbation.location.PerturbationLocation __L1328;

    public static perturbation.location.PerturbationLocation __L1329;

    public static perturbation.location.PerturbationLocation __L1330;

    public static perturbation.location.PerturbationLocation __L1331;

    public static perturbation.location.PerturbationLocation __L1332;

    public static perturbation.location.PerturbationLocation __L1333;

    public static perturbation.location.PerturbationLocation __L1334;

    public static perturbation.location.PerturbationLocation __L1335;

    public static perturbation.location.PerturbationLocation __L1336;

    public static perturbation.location.PerturbationLocation __L1337;

    public static perturbation.location.PerturbationLocation __L1338;

    public static perturbation.location.PerturbationLocation __L1339;

    public static perturbation.location.PerturbationLocation __L1340;

    public static perturbation.location.PerturbationLocation __L1341;

    public static perturbation.location.PerturbationLocation __L1342;

    public static perturbation.location.PerturbationLocation __L1343;

    public static perturbation.location.PerturbationLocation __L1344;

    public static perturbation.location.PerturbationLocation __L1345;

    public static perturbation.location.PerturbationLocation __L1346;

    public static perturbation.location.PerturbationLocation __L1347;

    public static perturbation.location.PerturbationLocation __L1348;

    public static perturbation.location.PerturbationLocation __L1349;

    public static perturbation.location.PerturbationLocation __L1350;

    public static perturbation.location.PerturbationLocation __L1351;

    public static perturbation.location.PerturbationLocation __L1352;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:40)", 1328, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:40)", 1329, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:40)", 1330, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:44)", 1331, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:46)", 1332, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:46)", 1333, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:47)", 1334, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:51)", 1335, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:52)", 1336, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:52)", 1337, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:52)", 1338, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:52)", 1339, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:52)", 1340, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:54)", 1341, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:56)", 1342, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:61)", 1343, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:65)", 1344, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:66)", 1345, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:66)", 1346, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:66)", 1347, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:66)", 1348, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:66)", 1349, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:68)", 1350, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:70)", 1351, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.__L1352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertItems.java:79)", 1352, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertItems.initPerturbationLocation0();
    }
}

