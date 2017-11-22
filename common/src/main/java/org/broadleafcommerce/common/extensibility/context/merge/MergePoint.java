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
package org.broadleafcommerce.common.extensibility.context.merge;


public class MergePoint {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.class);

    private org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler handler;

    private org.w3c.dom.Document doc1;

    private org.w3c.dom.Document doc2;

    private javax.xml.xpath.XPath xPath;

    public MergePoint(org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler handler, org.w3c.dom.Document doc1, org.w3c.dom.Document doc2) {
        this.handler = handler;
        this.doc1 = doc1;
        this.doc2 = doc2;
        javax.xml.xpath.XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
        xPath = factory.newXPath();
    }

    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> exhaustedNodes) throws javax.xml.transform.TransformerException, javax.xml.xpath.XPathExpressionException {
        return merge(handler, exhaustedNodes);
    }

    private org.w3c.dom.Node[] merge(org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler handler, java.util.List<org.w3c.dom.Node> exhaustedNodes) throws javax.xml.transform.TransformerException, javax.xml.xpath.XPathExpressionException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1728, org.broadleafcommerce.common.extensibility.context.merge.MergePoint.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.extensibility.context.merge.MergePoint.LOG.debug(("Processing handler: " + (handler.getXPath())));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1729, ((handler.getChildren()) != null))) {
            org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] children = handler.getChildren();
            for (org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler aChildren : children) {
                org.w3c.dom.Node[] temp = merge(aChildren, exhaustedNodes);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1730, (temp != null))) {
                    java.util.Collections.addAll(exhaustedNodes, temp);
                }
            }
        }
        java.lang.String[] xPaths = handler.getXPath().split(" ");
        java.util.List<org.w3c.dom.Node> nodeList1 = new java.util.ArrayList<org.w3c.dom.Node>();
        java.util.List<org.w3c.dom.Node> nodeList2 = new java.util.ArrayList<org.w3c.dom.Node>();
        for (java.lang.String xPathVal : xPaths) {
            org.w3c.dom.NodeList temp1 = ((org.w3c.dom.NodeList) (xPath.evaluate(xPathVal, doc1, javax.xml.xpath.XPathConstants.NODESET)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1731, (temp1 != null))) {
                int length = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1732, temp1.getLength());
                for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1733, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1736, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1734, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1735, length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1737, (j++))) {
                    nodeList1.add(temp1.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1738, j)));
                }
            }
            org.w3c.dom.NodeList temp2 = ((org.w3c.dom.NodeList) (xPath.evaluate(xPathVal, doc2, javax.xml.xpath.XPathConstants.NODESET)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1739, (temp2 != null))) {
                int length = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1740, temp2.getLength());
                for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1741, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1744, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1742, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1743, length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1745, (j++))) {
                    nodeList2.add(temp2.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1746, j)));
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1749, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1747, (nodeList1 != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1748, (nodeList2 != null)))))) {
            return handler.merge(nodeList1, nodeList2, exhaustedNodes);
        }
        return null;
    }

    public static perturbation.location.PerturbationLocation __L1728;

    public static perturbation.location.PerturbationLocation __L1729;

    public static perturbation.location.PerturbationLocation __L1730;

    public static perturbation.location.PerturbationLocation __L1731;

    public static perturbation.location.PerturbationLocation __L1732;

    public static perturbation.location.PerturbationLocation __L1733;

    public static perturbation.location.PerturbationLocation __L1734;

    public static perturbation.location.PerturbationLocation __L1735;

    public static perturbation.location.PerturbationLocation __L1736;

    public static perturbation.location.PerturbationLocation __L1737;

    public static perturbation.location.PerturbationLocation __L1738;

    public static perturbation.location.PerturbationLocation __L1739;

    public static perturbation.location.PerturbationLocation __L1740;

    public static perturbation.location.PerturbationLocation __L1741;

    public static perturbation.location.PerturbationLocation __L1742;

    public static perturbation.location.PerturbationLocation __L1743;

    public static perturbation.location.PerturbationLocation __L1744;

    public static perturbation.location.PerturbationLocation __L1745;

    public static perturbation.location.PerturbationLocation __L1746;

    public static perturbation.location.PerturbationLocation __L1747;

    public static perturbation.location.PerturbationLocation __L1748;

    public static perturbation.location.PerturbationLocation __L1749;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:78)", 1728, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:81)", 1729, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:85)", 1730, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:95)", 1731, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:96)", 1732, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:97)", 1733, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:97)", 1734, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:97)", 1735, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:97)", 1736, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:97)", 1737, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:98)", 1738, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:102)", 1739, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:103)", 1740, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:104)", 1741, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:104)", 1742, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:104)", 1743, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:104)", 1744, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:104)", 1745, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:105)", 1746, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:109)", 1747, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:109)", 1748, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.__L1749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergePoint.java:109)", 1749, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.MergePoint.initPerturbationLocation0();
    }
}

