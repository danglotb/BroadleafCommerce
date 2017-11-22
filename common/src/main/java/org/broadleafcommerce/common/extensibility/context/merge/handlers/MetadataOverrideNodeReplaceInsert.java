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


public class MetadataOverrideNodeReplaceInsert extends org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert {
    protected boolean checkNode(java.util.List<org.w3c.dom.Node> usedNodes, org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node node) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1363, replaceNode(primaryNodes, node, "configurationKey", usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1364, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1365, replaceCeilingEntityNode(primaryNodes, node, usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1366, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1367, exactNodeExists(primaryNodes, node, usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1368, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1369, false);
    }

    public static perturbation.location.PerturbationLocation __L1363;

    public static perturbation.location.PerturbationLocation __L1364;

    public static perturbation.location.PerturbationLocation __L1365;

    public static perturbation.location.PerturbationLocation __L1366;

    public static perturbation.location.PerturbationLocation __L1367;

    public static perturbation.location.PerturbationLocation __L1368;

    public static perturbation.location.PerturbationLocation __L1369;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:40)", 1363, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:41)", 1364, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:44)", 1365, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:45)", 1366, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:48)", 1367, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:49)", 1368, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.__L1369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MetadataOverrideNodeReplaceInsert.java:52)", 1369, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MetadataOverrideNodeReplaceInsert.initPerturbationLocation0();
    }
}

