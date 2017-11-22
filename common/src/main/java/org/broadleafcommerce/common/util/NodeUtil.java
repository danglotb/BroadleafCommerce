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
package org.broadleafcommerce.common.util;


public class NodeUtil {
    public static class NodeComparatorBySingleAttribute implements java.util.Comparator<org.w3c.dom.Node> {
        private java.lang.String attributeName;

        public NodeComparatorBySingleAttribute(java.lang.String attributeName) {
            this.attributeName = attributeName;
        }

        @java.lang.Override
        public int compare(org.w3c.dom.Node o1, org.w3c.dom.Node o2) {
            org.w3c.dom.NamedNodeMap attributes1 = o1.getAttributes();
            org.w3c.dom.NamedNodeMap attributes2 = o2.getAttributes();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6386, (attributes1 == null))) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6387, 1);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6388, (attributes2 == null))) {
                    return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6390, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6389, 1))));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6394, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6391, org.broadleafcommerce.common.util.NodeUtil.MO_TAB.equals(o1.getNodeName()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6393, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6392, org.broadleafcommerce.common.util.NodeUtil.MO_TAB.equals(o2.getNodeName()))))))))) {
                        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6396, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6395, 1))));
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6400, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6398, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6397, org.broadleafcommerce.common.util.NodeUtil.MO_TAB.equals(o1.getNodeName())))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6399, org.broadleafcommerce.common.util.NodeUtil.MO_TAB.equals(o2.getNodeName())))))) {
                            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6401, 1);
                        }else
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6405, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6402, org.broadleafcommerce.common.util.NodeUtil.MO_GROUP.equals(o1.getNodeName()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6404, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6403, org.broadleafcommerce.common.util.NodeUtil.MO_GROUP.equals(o2.getNodeName()))))))))) {
                                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6407, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6406, 1))));
                            }else
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6411, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6409, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6408, org.broadleafcommerce.common.util.NodeUtil.MO_GROUP.equals(o1.getNodeName())))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6410, org.broadleafcommerce.common.util.NodeUtil.MO_GROUP.equals(o2.getNodeName())))))) {
                                    return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6412, 1);
                                }





            org.w3c.dom.Node id1;
            org.w3c.dom.Node id2;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6415, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6413, org.broadleafcommerce.common.util.NodeUtil.MO_TAB.equals(o1.getNodeName()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6414, org.broadleafcommerce.common.util.NodeUtil.MO_TAB.equals(o2.getNodeName())))))) {
                id1 = attributes1.getNamedItem(org.broadleafcommerce.common.util.NodeUtil.TAB_NAME);
                id2 = attributes2.getNamedItem(org.broadleafcommerce.common.util.NodeUtil.TAB_NAME);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6418, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6416, org.broadleafcommerce.common.util.NodeUtil.MO_GROUP.equals(o1.getNodeName()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6417, org.broadleafcommerce.common.util.NodeUtil.MO_GROUP.equals(o2.getNodeName())))))) {
                    id1 = attributes1.getNamedItem(org.broadleafcommerce.common.util.NodeUtil.GROUP_NAME);
                    id2 = attributes2.getNamedItem(org.broadleafcommerce.common.util.NodeUtil.GROUP_NAME);
                }else {
                    id1 = attributes1.getNamedItem(attributeName);
                    id2 = attributes2.getNamedItem(attributeName);
                }

            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6421, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6419, (id1 == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6420, (id2 == null)))))) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6423, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6422, 1))));
            }
            java.lang.String idVal1 = id1.getNodeValue();
            java.lang.String idVal2 = id2.getNodeValue();
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6424, idVal1.compareTo(idVal2));
        }

        public static perturbation.location.PerturbationLocation __L6386;

        public static perturbation.location.PerturbationLocation __L6387;

        public static perturbation.location.PerturbationLocation __L6388;

        public static perturbation.location.PerturbationLocation __L6389;

        public static perturbation.location.PerturbationLocation __L6390;

        public static perturbation.location.PerturbationLocation __L6391;

        public static perturbation.location.PerturbationLocation __L6392;

        public static perturbation.location.PerturbationLocation __L6393;

        public static perturbation.location.PerturbationLocation __L6394;

        public static perturbation.location.PerturbationLocation __L6395;

        public static perturbation.location.PerturbationLocation __L6396;

        public static perturbation.location.PerturbationLocation __L6397;

        public static perturbation.location.PerturbationLocation __L6398;

        public static perturbation.location.PerturbationLocation __L6399;

        public static perturbation.location.PerturbationLocation __L6400;

        public static perturbation.location.PerturbationLocation __L6401;

        public static perturbation.location.PerturbationLocation __L6402;

        public static perturbation.location.PerturbationLocation __L6403;

        public static perturbation.location.PerturbationLocation __L6404;

        public static perturbation.location.PerturbationLocation __L6405;

        public static perturbation.location.PerturbationLocation __L6406;

        public static perturbation.location.PerturbationLocation __L6407;

        public static perturbation.location.PerturbationLocation __L6408;

        public static perturbation.location.PerturbationLocation __L6409;

        public static perturbation.location.PerturbationLocation __L6410;

        public static perturbation.location.PerturbationLocation __L6411;

        public static perturbation.location.PerturbationLocation __L6412;

        public static perturbation.location.PerturbationLocation __L6413;

        public static perturbation.location.PerturbationLocation __L6414;

        public static perturbation.location.PerturbationLocation __L6415;

        public static perturbation.location.PerturbationLocation __L6416;

        public static perturbation.location.PerturbationLocation __L6417;

        public static perturbation.location.PerturbationLocation __L6418;

        public static perturbation.location.PerturbationLocation __L6419;

        public static perturbation.location.PerturbationLocation __L6420;

        public static perturbation.location.PerturbationLocation __L6421;

        public static perturbation.location.PerturbationLocation __L6422;

        public static perturbation.location.PerturbationLocation __L6423;

        public static perturbation.location.PerturbationLocation __L6424;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:67)", 6386, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:68)", 6387, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:69)", 6388, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:70)", 6389, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:70)", 6390, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:71)", 6391, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:71)", 6392, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:71)", 6393, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:71)", 6394, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:72)", 6395, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:72)", 6396, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:73)", 6397, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:73)", 6398, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:73)", 6399, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:73)", 6400, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:74)", 6401, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:75)", 6402, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:75)", 6403, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:75)", 6404, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:75)", 6405, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:76)", 6406, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:76)", 6407, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:77)", 6408, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:77)", 6409, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:77)", 6410, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:77)", 6411, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:78)", 6412, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:82)", 6413, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:82)", 6414, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:82)", 6415, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:85)", 6416, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:85)", 6417, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:85)", 6418, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:93)", 6419, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:93)", 6420, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:93)", 6421, "Boolean");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:94)", 6422, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:94)", 6423, "Numerical");
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.__L6424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:98)", 6424, "Numerical");
        }

        static {
            org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute.initPerturbationLocation0();
        }
    }

    private static final java.lang.String TEXT_ELEMENT_NAME = "#text";

    private static final java.lang.String MO_GROUP = "mo:group";

    private static final java.lang.String GROUP_NAME = "groupName";

    private static final java.lang.String MO_TAB = "mo:tab";

    private static final java.lang.String TAB_NAME = "tabName";

    public static org.w3c.dom.Node[] filterByAttribute(org.w3c.dom.Node[] primaryNodes, java.lang.String attributeName) {
        java.util.ArrayList<org.w3c.dom.Node> filterList = new java.util.ArrayList<org.w3c.dom.Node>();
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6425, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6428, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6426, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6427, primaryNodes.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6429, (j++))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6431, ((primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6430, j)].getAttributes().getNamedItem(attributeName)) != null))) {
                filterList.add(primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6432, j)]);
            }
        }
        org.w3c.dom.Node[] filtered = filterList.toArray(new org.w3c.dom.Node[]{  });
        return filtered;
    }

    public static int findNode(org.w3c.dom.Node[] arrNodes, org.w3c.dom.Node testNode, java.lang.String attributeName, boolean sortArray) {
        org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute comparator = new org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute(attributeName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6433, sortArray)) {
            java.util.Arrays.sort(arrNodes, comparator);
        }
        int position = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6434, java.util.Arrays.binarySearch(arrNodes, testNode, comparator));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6435, position);
    }

    public static void mergeNodeLists(org.w3c.dom.Node targetNode, org.w3c.dom.NodeList list1, org.w3c.dom.NodeList list2, java.lang.String attributeName) {
        org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute comparator = new org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute(attributeName);
        java.util.TreeSet<org.w3c.dom.Node> resultSet = new java.util.TreeSet<org.w3c.dom.Node>(comparator);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6436, (list1 != null))) {
            for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6437, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6440, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6438, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6439, list1.getLength())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6441, (i++))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6444, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6443, org.broadleafcommerce.common.util.NodeUtil.TEXT_ELEMENT_NAME.equals(list1.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6442, i)).getNodeName())))))) {
                    resultSet.add(list1.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6445, i)));
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6446, (list2 != null))) {
            for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6447, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6450, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6448, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6449, list2.getLength())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6451, (i++))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6454, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.NodeUtil.__L6453, org.broadleafcommerce.common.util.NodeUtil.TEXT_ELEMENT_NAME.equals(list2.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6452, i)).getNodeName())))))) {
                    resultSet.add(list2.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.NodeUtil.__L6455, i)));
                }
            }
        }
        for (org.w3c.dom.Node node : resultSet) {
            targetNode.appendChild(node);
        }
    }

    public static perturbation.location.PerturbationLocation __L6425;

    public static perturbation.location.PerturbationLocation __L6426;

    public static perturbation.location.PerturbationLocation __L6427;

    public static perturbation.location.PerturbationLocation __L6428;

    public static perturbation.location.PerturbationLocation __L6429;

    public static perturbation.location.PerturbationLocation __L6430;

    public static perturbation.location.PerturbationLocation __L6431;

    public static perturbation.location.PerturbationLocation __L6432;

    public static perturbation.location.PerturbationLocation __L6433;

    public static perturbation.location.PerturbationLocation __L6434;

    public static perturbation.location.PerturbationLocation __L6435;

    public static perturbation.location.PerturbationLocation __L6436;

    public static perturbation.location.PerturbationLocation __L6437;

    public static perturbation.location.PerturbationLocation __L6438;

    public static perturbation.location.PerturbationLocation __L6439;

    public static perturbation.location.PerturbationLocation __L6440;

    public static perturbation.location.PerturbationLocation __L6441;

    public static perturbation.location.PerturbationLocation __L6442;

    public static perturbation.location.PerturbationLocation __L6443;

    public static perturbation.location.PerturbationLocation __L6444;

    public static perturbation.location.PerturbationLocation __L6445;

    public static perturbation.location.PerturbationLocation __L6446;

    public static perturbation.location.PerturbationLocation __L6447;

    public static perturbation.location.PerturbationLocation __L6448;

    public static perturbation.location.PerturbationLocation __L6449;

    public static perturbation.location.PerturbationLocation __L6450;

    public static perturbation.location.PerturbationLocation __L6451;

    public static perturbation.location.PerturbationLocation __L6452;

    public static perturbation.location.PerturbationLocation __L6453;

    public static perturbation.location.PerturbationLocation __L6454;

    public static perturbation.location.PerturbationLocation __L6455;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.NodeUtil.__L6425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:111)", 6425, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:111)", 6426, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:111)", 6427, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:111)", 6428, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:111)", 6429, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:112)", 6430, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:112)", 6431, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:113)", 6432, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:132)", 6433, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:135)", 6434, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:136)", 6435, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:151)", 6436, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:152)", 6437, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:152)", 6438, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:152)", 6439, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:152)", 6440, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:152)", 6441, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:153)", 6442, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:153)", 6443, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:153)", 6444, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:154)", 6445, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:158)", 6446, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:159)", 6447, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:159)", 6448, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:159)", 6449, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:159)", 6450, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:159)", 6451, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:160)", 6452, "Numerical");
        org.broadleafcommerce.common.util.NodeUtil.__L6453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:160)", 6453, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:160)", 6454, "Boolean");
        org.broadleafcommerce.common.util.NodeUtil.__L6455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/NodeUtil.java:161)", 6455, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.NodeUtil.initPerturbationLocation0();
    }
}

