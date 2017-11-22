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


public class LiberalNodeReplaceInsert extends org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert {
    protected boolean checkNode(java.util.List<org.w3c.dom.Node> usedNodes, org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node node) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1353, replaceNode(primaryNodes, node, "id", usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1354, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1355, replaceNode(primaryNodes, node, "name", usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1356, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1357, replaceNode(primaryNodes, node, "class", usedNodes))) {
            usedNodes.add(node);
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1358, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1359, exactNodeExists(primaryNodes, node, usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1360, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1361, false);
    }

    public static perturbation.location.PerturbationLocation __L1353;

    public static perturbation.location.PerturbationLocation __L1354;

    public static perturbation.location.PerturbationLocation __L1355;

    public static perturbation.location.PerturbationLocation __L1356;

    public static perturbation.location.PerturbationLocation __L1357;

    public static perturbation.location.PerturbationLocation __L1358;

    public static perturbation.location.PerturbationLocation __L1359;

    public static perturbation.location.PerturbationLocation __L1360;

    public static perturbation.location.PerturbationLocation __L1361;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:37)", 1353, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:38)", 1354, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:41)", 1355, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:42)", 1356, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:44)", 1357, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:46)", 1358, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:49)", 1359, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:50)", 1360, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.__L1361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/LiberalNodeReplaceInsert.java:52)", 1361, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.LiberalNodeReplaceInsert.initPerturbationLocation0();
    }
}

