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


public class NodeReplace extends org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert {
    @java.lang.Override
    protected boolean checkNode(java.util.List<org.w3c.dom.Node> usedNodes, org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node node) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1370, replaceNode(primaryNodes, node, usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1371, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1372, exactNodeExists(primaryNodes, node, usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1373, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1374, false);
    }

    protected boolean replaceNode(org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node testNode, java.util.List<org.w3c.dom.Node> usedNodes) {
        boolean foundItem = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1375, false);
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1376, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1379, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1377, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1378, primaryNodes.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1380, (j++))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1382, primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1381, j)].getNodeName().equals(testNode.getNodeName()))) {
                org.w3c.dom.Node newNode = primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1383, j)].getOwnerDocument().importNode(testNode.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1384, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1385, true));
                primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1386, j)].getParentNode().replaceChild(newNode, primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1387, j)]);
                usedNodes.add(testNode);
                foundItem = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1388, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1389, foundItem);
    }

    public static perturbation.location.PerturbationLocation __L1370;

    public static perturbation.location.PerturbationLocation __L1371;

    public static perturbation.location.PerturbationLocation __L1372;

    public static perturbation.location.PerturbationLocation __L1373;

    public static perturbation.location.PerturbationLocation __L1374;

    public static perturbation.location.PerturbationLocation __L1375;

    public static perturbation.location.PerturbationLocation __L1376;

    public static perturbation.location.PerturbationLocation __L1377;

    public static perturbation.location.PerturbationLocation __L1378;

    public static perturbation.location.PerturbationLocation __L1379;

    public static perturbation.location.PerturbationLocation __L1380;

    public static perturbation.location.PerturbationLocation __L1381;

    public static perturbation.location.PerturbationLocation __L1382;

    public static perturbation.location.PerturbationLocation __L1383;

    public static perturbation.location.PerturbationLocation __L1384;

    public static perturbation.location.PerturbationLocation __L1385;

    public static perturbation.location.PerturbationLocation __L1386;

    public static perturbation.location.PerturbationLocation __L1387;

    public static perturbation.location.PerturbationLocation __L1388;

    public static perturbation.location.PerturbationLocation __L1389;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:37)", 1370, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:38)", 1371, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:41)", 1372, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:42)", 1373, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:44)", 1374, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:48)", 1375, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:49)", 1376, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:49)", 1377, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:49)", 1378, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:49)", 1379, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:49)", 1380, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:50)", 1381, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:50)", 1382, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:51)", 1383, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:51)", 1384, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:51)", 1385, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:52)", 1386, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:52)", 1387, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:54)", 1388, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.__L1389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplace.java:58)", 1389, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplace.initPerturbationLocation0();
    }
}

