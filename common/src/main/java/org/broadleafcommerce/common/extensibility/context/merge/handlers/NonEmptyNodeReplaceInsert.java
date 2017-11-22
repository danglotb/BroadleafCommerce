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


public class NonEmptyNodeReplaceInsert extends org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert {
    @java.lang.Override
    protected boolean replaceNode(org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node testNode, final java.lang.String attribute, java.util.List<org.w3c.dom.Node> usedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1491, ((testNode.getAttributes().getNamedItem(attribute)) == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1492, false);
        }
        java.util.ArrayList<org.w3c.dom.Node> filterList = new java.util.ArrayList<org.w3c.dom.Node>();
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1493, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1496, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1494, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1495, primaryNodes.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1497, (j++))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1499, ((primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1498, j)].getAttributes().getNamedItem(attribute)) != null))) {
                filterList.add(primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1500, j)]);
            }
        }
        org.w3c.dom.Node[] filtered = new org.w3c.dom.Node[]{  };
        filtered = filterList.toArray(filtered);
        java.util.Comparator<org.w3c.dom.Node> idCompare = new java.util.Comparator<org.w3c.dom.Node>() {
            public int compare(org.w3c.dom.Node arg0, org.w3c.dom.Node arg1) {
                org.w3c.dom.Node id1 = arg0.getAttributes().getNamedItem(attribute);
                org.w3c.dom.Node id2 = arg1.getAttributes().getNamedItem(attribute);
                java.lang.String idVal1 = id1.getNodeValue();
                java.lang.String idVal2 = id2.getNodeValue();
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1501, idVal1.compareTo(idVal2));
            }
        };
        java.util.Arrays.sort(filtered, idCompare);
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1502, java.util.Arrays.binarySearch(filtered, testNode, idCompare));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1505, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1503, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1504, 0))))) {
            evaluate : {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1507, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1506, testNode.hasChildNodes()))))) {
                    break evaluate;
                }
                org.w3c.dom.Node newNode = filtered[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1508, pos)].getOwnerDocument().importNode(testNode.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1509, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1510, true));
                filtered[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1511, pos)].getParentNode().replaceChild(newNode, filtered[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1512, pos)]);
            }
            usedNodes.add(testNode);
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1513, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1514, false);
    }

    public static perturbation.location.PerturbationLocation __L1491;

    public static perturbation.location.PerturbationLocation __L1492;

    public static perturbation.location.PerturbationLocation __L1493;

    public static perturbation.location.PerturbationLocation __L1494;

    public static perturbation.location.PerturbationLocation __L1495;

    public static perturbation.location.PerturbationLocation __L1496;

    public static perturbation.location.PerturbationLocation __L1497;

    public static perturbation.location.PerturbationLocation __L1498;

    public static perturbation.location.PerturbationLocation __L1499;

    public static perturbation.location.PerturbationLocation __L1500;

    public static perturbation.location.PerturbationLocation __L1501;

    public static perturbation.location.PerturbationLocation __L1502;

    public static perturbation.location.PerturbationLocation __L1503;

    public static perturbation.location.PerturbationLocation __L1504;

    public static perturbation.location.PerturbationLocation __L1505;

    public static perturbation.location.PerturbationLocation __L1506;

    public static perturbation.location.PerturbationLocation __L1507;

    public static perturbation.location.PerturbationLocation __L1508;

    public static perturbation.location.PerturbationLocation __L1509;

    public static perturbation.location.PerturbationLocation __L1510;

    public static perturbation.location.PerturbationLocation __L1511;

    public static perturbation.location.PerturbationLocation __L1512;

    public static perturbation.location.PerturbationLocation __L1513;

    public static perturbation.location.PerturbationLocation __L1514;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:41)", 1491, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:42)", 1492, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:46)", 1493, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:46)", 1494, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:46)", 1495, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:46)", 1496, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:46)", 1497, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:47)", 1498, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:47)", 1499, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:48)", 1500, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:60)", 1501, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:64)", 1502, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:65)", 1503, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:65)", 1504, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:65)", 1505, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:67)", 1506, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:67)", 1507, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:70)", 1508, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:70)", 1509, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:70)", 1510, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:71)", 1511, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:71)", 1512, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:74)", 1513, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.__L1514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NonEmptyNodeReplaceInsert.java:76)", 1514, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NonEmptyNodeReplaceInsert.initPerturbationLocation0();
    }
}

