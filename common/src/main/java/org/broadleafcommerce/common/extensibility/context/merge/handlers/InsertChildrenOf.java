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


public class InsertChildrenOf extends org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler {
    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> nodeList1, java.util.List<org.w3c.dom.Node> nodeList2, java.util.List<org.w3c.dom.Node> exhaustedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1309, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1307, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList1))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1308, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList2)))))) {
            return null;
        }
        org.w3c.dom.Node node1 = nodeList1.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1310, 0));
        org.w3c.dom.Node node2 = nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1311, 0));
        org.w3c.dom.NodeList list2 = node2.getChildNodes();
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1312, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1315, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1313, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1314, list2.getLength())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1316, (j++))) {
            node1.appendChild(node1.getOwnerDocument().importNode(list2.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1317, j)).cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1318, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1319, true)));
        }
        org.w3c.dom.Node[] response = new org.w3c.dom.Node[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1320, nodeList2.size())];
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1321, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1324, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1322, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1323, response.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1325, (j++))) {
            response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1326, j)] = nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1327, j));
        }
        return response;
    }

    public static perturbation.location.PerturbationLocation __L1307;

    public static perturbation.location.PerturbationLocation __L1308;

    public static perturbation.location.PerturbationLocation __L1309;

    public static perturbation.location.PerturbationLocation __L1310;

    public static perturbation.location.PerturbationLocation __L1311;

    public static perturbation.location.PerturbationLocation __L1312;

    public static perturbation.location.PerturbationLocation __L1313;

    public static perturbation.location.PerturbationLocation __L1314;

    public static perturbation.location.PerturbationLocation __L1315;

    public static perturbation.location.PerturbationLocation __L1316;

    public static perturbation.location.PerturbationLocation __L1317;

    public static perturbation.location.PerturbationLocation __L1318;

    public static perturbation.location.PerturbationLocation __L1319;

    public static perturbation.location.PerturbationLocation __L1320;

    public static perturbation.location.PerturbationLocation __L1321;

    public static perturbation.location.PerturbationLocation __L1322;

    public static perturbation.location.PerturbationLocation __L1323;

    public static perturbation.location.PerturbationLocation __L1324;

    public static perturbation.location.PerturbationLocation __L1325;

    public static perturbation.location.PerturbationLocation __L1326;

    public static perturbation.location.PerturbationLocation __L1327;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:35)", 1307, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:35)", 1308, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:35)", 1309, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:38)", 1310, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:39)", 1311, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:41)", 1312, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:41)", 1313, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:41)", 1314, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:41)", 1315, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:41)", 1316, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:42)", 1317, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:42)", 1318, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:42)", 1319, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:45)", 1320, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:46)", 1321, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:46)", 1322, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:46)", 1323, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:46)", 1324, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:46)", 1325, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:47)", 1326, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.__L1327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/InsertChildrenOf.java:47)", 1327, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.InsertChildrenOf.initPerturbationLocation0();
    }
}

