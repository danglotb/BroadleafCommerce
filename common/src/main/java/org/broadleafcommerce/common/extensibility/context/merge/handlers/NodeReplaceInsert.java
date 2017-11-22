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


public class NodeReplaceInsert extends org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.class);

    private static final java.util.Comparator<org.w3c.dom.Node> NODE_COMPARATOR = new java.util.Comparator<org.w3c.dom.Node>() {
        @java.lang.Override
        public int compare(org.w3c.dom.Node arg0, org.w3c.dom.Node arg1) {
            int response = -1;
            if (arg0.isSameNode(arg1)) {
                response = 0;
            }
            if (response != 0) {
                boolean eof = false;
                org.w3c.dom.Node parentNode = arg0;
                while (!eof) {
                    parentNode = parentNode.getParentNode();
                    if (parentNode == null) {
                        eof = true;
                    }else
                        if (arg1.isSameNode(parentNode)) {
                            response = 0;
                            eof = true;
                        }

                } 
            }
            return response;
        }
    };

    private static java.lang.String CEILING_ENTITY = "ceilingEntity";

    @java.lang.Override
    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> nodeList1, java.util.List<org.w3c.dom.Node> nodeList2, java.util.List<org.w3c.dom.Node> exhaustedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1392, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1390, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList1))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1391, org.apache.commons.collections.CollectionUtils.isEmpty(nodeList2)))))) {
            return null;
        }
        org.w3c.dom.Node[] primaryNodes = new org.w3c.dom.Node[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1393, nodeList1.size())];
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1394, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1397, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1395, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1396, primaryNodes.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1398, (j++))) {
            primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1399, j)] = nodeList1.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1400, j));
        }
        java.util.ArrayList<org.w3c.dom.Node> list = new java.util.ArrayList<org.w3c.dom.Node>();
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1401, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1404, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1402, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1403, nodeList2.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1405, (j++))) {
            list.add(nodeList2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1406, j)));
        }
        java.util.List<org.w3c.dom.Node> usedNodes = matchNodes(exhaustedNodes, primaryNodes, list);
        org.w3c.dom.Node[] response = new org.w3c.dom.Node[]{  };
        response = usedNodes.toArray(response);
        return response;
    }

    private boolean exhaustedNodesContains(java.util.List<org.w3c.dom.Node> exhaustedNodes, org.w3c.dom.Node node) {
        boolean contains = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1407, false);
        for (org.w3c.dom.Node exhaustedNode : exhaustedNodes) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1410, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1408, org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.NODE_COMPARATOR.compare(exhaustedNode, node))) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1409, 0))))) {
                contains = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1411, true);
                break;
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1412, contains);
    }

    private java.util.List<org.w3c.dom.Node> matchNodes(java.util.List<org.w3c.dom.Node> exhaustedNodes, org.w3c.dom.Node[] primaryNodes, java.util.ArrayList<org.w3c.dom.Node> list) {
        java.util.List<org.w3c.dom.Node> usedNodes = new java.util.ArrayList<org.w3c.dom.Node>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1413, 20));
        java.util.Iterator<org.w3c.dom.Node> itr = list.iterator();
        org.w3c.dom.Node parentNode = primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1414, 0)].getParentNode();
        org.w3c.dom.Document ownerDocument = parentNode.getOwnerDocument();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1415, itr.hasNext())) {
            org.w3c.dom.Node node = itr.next();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1419, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1416, org.w3c.dom.Element.class.isAssignableFrom(node.getClass()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1418, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1417, exhaustedNodesContains(exhaustedNodes, node))))))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1420, org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.LOG.isDebugEnabled())) {
                    java.lang.StringBuffer sb = new java.lang.StringBuffer();
                    sb.append("matching node for replacement: ");
                    sb.append(node.getNodeName());
                    int attrLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1421, node.getAttributes().getLength());
                    for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1422, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1425, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1423, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1424, attrLength)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1426, (j++))) {
                        sb.append(" : (");
                        sb.append(node.getAttributes().item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1427, j)).getNodeName());
                        sb.append("/");
                        sb.append(node.getAttributes().item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1428, j)).getNodeValue());
                        sb.append(")");
                    }
                    org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.LOG.debug(sb.toString());
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1430, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1429, checkNode(usedNodes, primaryNodes, node)))))) {
                    org.w3c.dom.Node newNode = ownerDocument.importNode(node.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1431, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1432, true));
                    parentNode.appendChild(newNode);
                    usedNodes.add(node);
                }
            }
        } 
        return usedNodes;
    }

    protected boolean checkNode(java.util.List<org.w3c.dom.Node> usedNodes, org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node node) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1433, replaceNode(primaryNodes, node, "id", usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1434, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1435, replaceNode(primaryNodes, node, "name", usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1436, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1437, exactNodeExists(primaryNodes, node, usedNodes))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1438, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1439, false);
    }

    protected boolean exactNodeExists(org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node testNode, java.util.List<org.w3c.dom.Node> usedNodes) {
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1440, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1443, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1441, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1442, primaryNodes.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1444, (j++))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1446, primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1445, j)].isEqualNode(testNode))) {
                usedNodes.add(primaryNodes[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1447, j)]);
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1448, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1449, false);
    }

    protected boolean replaceNode(org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node testNode, final java.lang.String attribute, java.util.List<org.w3c.dom.Node> usedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1450, ((testNode.getAttributes().getNamedItem(attribute)) == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1451, false);
        }
        org.w3c.dom.Node[] filtered = org.broadleafcommerce.common.util.NodeUtil.filterByAttribute(primaryNodes, attribute);
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1453, org.broadleafcommerce.common.util.NodeUtil.findNode(filtered, testNode, attribute, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1452, true)));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1456, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1454, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1455, 0))))) {
            org.w3c.dom.Node foundNode = filtered[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1457, pos)];
            org.w3c.dom.Node newNode = foundNode.getOwnerDocument().importNode(testNode.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1458, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1459, true));
            foundNode.getParentNode().replaceChild(newNode, foundNode);
            usedNodes.add(testNode);
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1460, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1461, false);
    }

    protected boolean replaceCeilingEntityNode(org.w3c.dom.Node[] primaryNodes, org.w3c.dom.Node testNode, java.util.List<org.w3c.dom.Node> usedNodes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1462, ((testNode.getAttributes().getNamedItem(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.CEILING_ENTITY)) == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1463, false);
        }
        org.w3c.dom.Node[] filtered = org.broadleafcommerce.common.util.NodeUtil.filterByAttribute(primaryNodes, org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.CEILING_ENTITY);
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1465, org.broadleafcommerce.common.util.NodeUtil.findNode(filtered, testNode, org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.CEILING_ENTITY, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1464, true)));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1468, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1466, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1467, 0))))) {
            org.w3c.dom.Node foundNode = filtered[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1469, pos)];
            org.w3c.dom.Node targetNode = foundNode.getOwnerDocument().importNode(foundNode.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1470, false)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1471, false));
            org.w3c.dom.Node newTestNode = foundNode.getOwnerDocument().importNode(testNode.cloneNode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1472, true)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1473, true));
            org.broadleafcommerce.common.util.NodeUtil.mergeNodeLists(targetNode, newTestNode.getChildNodes(), foundNode.getChildNodes(), "name");
            foundNode.getParentNode().replaceChild(targetNode, foundNode);
            usedNodes.add(testNode);
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1474, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1475, false);
    }

    public static perturbation.location.PerturbationLocation __L1390;

    public static perturbation.location.PerturbationLocation __L1391;

    public static perturbation.location.PerturbationLocation __L1392;

    public static perturbation.location.PerturbationLocation __L1393;

    public static perturbation.location.PerturbationLocation __L1394;

    public static perturbation.location.PerturbationLocation __L1395;

    public static perturbation.location.PerturbationLocation __L1396;

    public static perturbation.location.PerturbationLocation __L1397;

    public static perturbation.location.PerturbationLocation __L1398;

    public static perturbation.location.PerturbationLocation __L1399;

    public static perturbation.location.PerturbationLocation __L1400;

    public static perturbation.location.PerturbationLocation __L1401;

    public static perturbation.location.PerturbationLocation __L1402;

    public static perturbation.location.PerturbationLocation __L1403;

    public static perturbation.location.PerturbationLocation __L1404;

    public static perturbation.location.PerturbationLocation __L1405;

    public static perturbation.location.PerturbationLocation __L1406;

    public static perturbation.location.PerturbationLocation __L1407;

    public static perturbation.location.PerturbationLocation __L1408;

    public static perturbation.location.PerturbationLocation __L1409;

    public static perturbation.location.PerturbationLocation __L1410;

    public static perturbation.location.PerturbationLocation __L1411;

    public static perturbation.location.PerturbationLocation __L1412;

    public static perturbation.location.PerturbationLocation __L1413;

    public static perturbation.location.PerturbationLocation __L1414;

    public static perturbation.location.PerturbationLocation __L1415;

    public static perturbation.location.PerturbationLocation __L1416;

    public static perturbation.location.PerturbationLocation __L1417;

    public static perturbation.location.PerturbationLocation __L1418;

    public static perturbation.location.PerturbationLocation __L1419;

    public static perturbation.location.PerturbationLocation __L1420;

    public static perturbation.location.PerturbationLocation __L1421;

    public static perturbation.location.PerturbationLocation __L1422;

    public static perturbation.location.PerturbationLocation __L1423;

    public static perturbation.location.PerturbationLocation __L1424;

    public static perturbation.location.PerturbationLocation __L1425;

    public static perturbation.location.PerturbationLocation __L1426;

    public static perturbation.location.PerturbationLocation __L1427;

    public static perturbation.location.PerturbationLocation __L1428;

    public static perturbation.location.PerturbationLocation __L1429;

    public static perturbation.location.PerturbationLocation __L1430;

    public static perturbation.location.PerturbationLocation __L1431;

    public static perturbation.location.PerturbationLocation __L1432;

    public static perturbation.location.PerturbationLocation __L1433;

    public static perturbation.location.PerturbationLocation __L1434;

    public static perturbation.location.PerturbationLocation __L1435;

    public static perturbation.location.PerturbationLocation __L1436;

    public static perturbation.location.PerturbationLocation __L1437;

    public static perturbation.location.PerturbationLocation __L1438;

    public static perturbation.location.PerturbationLocation __L1439;

    public static perturbation.location.PerturbationLocation __L1440;

    public static perturbation.location.PerturbationLocation __L1441;

    public static perturbation.location.PerturbationLocation __L1442;

    public static perturbation.location.PerturbationLocation __L1443;

    public static perturbation.location.PerturbationLocation __L1444;

    public static perturbation.location.PerturbationLocation __L1445;

    public static perturbation.location.PerturbationLocation __L1446;

    public static perturbation.location.PerturbationLocation __L1447;

    public static perturbation.location.PerturbationLocation __L1448;

    public static perturbation.location.PerturbationLocation __L1449;

    public static perturbation.location.PerturbationLocation __L1450;

    public static perturbation.location.PerturbationLocation __L1451;

    public static perturbation.location.PerturbationLocation __L1452;

    public static perturbation.location.PerturbationLocation __L1453;

    public static perturbation.location.PerturbationLocation __L1454;

    public static perturbation.location.PerturbationLocation __L1455;

    public static perturbation.location.PerturbationLocation __L1456;

    public static perturbation.location.PerturbationLocation __L1457;

    public static perturbation.location.PerturbationLocation __L1458;

    public static perturbation.location.PerturbationLocation __L1459;

    public static perturbation.location.PerturbationLocation __L1460;

    public static perturbation.location.PerturbationLocation __L1461;

    public static perturbation.location.PerturbationLocation __L1462;

    public static perturbation.location.PerturbationLocation __L1463;

    public static perturbation.location.PerturbationLocation __L1464;

    public static perturbation.location.PerturbationLocation __L1465;

    public static perturbation.location.PerturbationLocation __L1466;

    public static perturbation.location.PerturbationLocation __L1467;

    public static perturbation.location.PerturbationLocation __L1468;

    public static perturbation.location.PerturbationLocation __L1469;

    public static perturbation.location.PerturbationLocation __L1470;

    public static perturbation.location.PerturbationLocation __L1471;

    public static perturbation.location.PerturbationLocation __L1472;

    public static perturbation.location.PerturbationLocation __L1473;

    public static perturbation.location.PerturbationLocation __L1474;

    public static perturbation.location.PerturbationLocation __L1475;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:75)", 1390, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:75)", 1391, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:75)", 1392, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:78)", 1393, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:79)", 1394, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:79)", 1395, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:79)", 1396, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:79)", 1397, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:79)", 1398, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:80)", 1399, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:80)", 1400, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:84)", 1401, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:84)", 1402, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:84)", 1403, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:84)", 1404, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:84)", 1405, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:85)", 1406, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:96)", 1407, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:98)", 1408, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:98)", 1409, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:98)", 1410, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:99)", 1411, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:104)", 1412, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:108)", 1413, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:110)", 1414, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:112)", 1415, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:114)", 1416, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:114)", 1417, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:114)", 1418, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:114)", 1419, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:116)", 1420, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:120)", 1421, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:121)", 1422, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:121)", 1423, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:121)", 1424, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:121)", 1425, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:121)", 1426, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:123)", 1427, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:125)", 1428, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:130)", 1429, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:130)", 1430, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:132)", 1431, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:132)", 1432, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:143)", 1433, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:144)", 1434, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:147)", 1435, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:148)", 1436, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:151)", 1437, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:152)", 1438, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:154)", 1439, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:158)", 1440, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:158)", 1441, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:158)", 1442, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:158)", 1443, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:158)", 1444, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:159)", 1445, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:159)", 1446, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:160)", 1447, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:161)", 1448, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:164)", 1449, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:168)", 1450, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:169)", 1451, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:174)", 1452, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:174)", 1453, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:176)", 1454, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:176)", 1455, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:176)", 1456, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:177)", 1457, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:179)", 1458, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:179)", 1459, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:182)", 1460, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:184)", 1461, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:201)", 1462, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:202)", 1463, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:207)", 1464, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:207)", 1465, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:209)", 1466, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:209)", 1467, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:209)", 1468, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:210)", 1469, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:212)", 1470, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:212)", 1471, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:213)", 1472, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:213)", 1473, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:217)", 1474, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.__L1475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/NodeReplaceInsert.java:220)", 1475, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.NodeReplaceInsert.initPerturbationLocation0();
    }
}

