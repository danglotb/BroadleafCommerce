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


public class MergeManager {
    public static final java.lang.String MERGE_DEFINITION_SYSTEM_PROPERTY = "org.broadleafcommerce.extensibility.context.merge.handlers.merge.properties";

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.class);

    private static javax.xml.parsers.DocumentBuilder builder;

    private org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] handlers;

    public MergeManager() throws org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException {
        try {
            java.util.Properties props = loadProperties();
            removeSkippedMergeComponents(props);
            setHandlers(props);
        } catch (java.io.IOException e) {
            throw new org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException(e);
        } catch (java.lang.ClassNotFoundException e) {
            throw new org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException(e);
        } catch (java.lang.IllegalAccessException e) {
            throw new org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException(e);
        } catch (java.lang.InstantiationException e) {
            throw new org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException(e);
        }
    }

    private void removeSkippedMergeComponents(java.util.Properties props) throws java.io.UnsupportedEncodingException {
        java.io.InputStream inputStream = null;
        java.io.InputStreamReader inputStreamReader = null;
        java.io.BufferedReader bufferedReader = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("/broadleaf-commmerce/skipMergeComponents.txt");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1666, (inputStream == null))) {
                return ;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1667, org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.isDebugEnabled())) {
                org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.debug("mergeClassOverrides file found.");
            }
            inputStreamReader = new java.io.InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new java.io.BufferedReader(inputStreamReader);
            java.lang.String line;
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1668, ((line = bufferedReader.readLine()) != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1669, org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.debug(("mergeComponentOverrides - overridding " + line));
                }
                removeSkipMergeComponents(props, line);
            } 
        } catch (java.io.IOException e) {
            org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.error("Error reading resource - /broadleaf-commmerce/skipMergeComponents.txt", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1670, (inputStream != null))) {
                org.apache.commons.io.IOUtils.closeQuietly(inputStream);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1671, (inputStreamReader != null))) {
                org.apache.commons.io.IOUtils.closeQuietly(inputStreamReader);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1672, (bufferedReader != null))) {
                org.apache.commons.io.IOUtils.closeQuietly(bufferedReader);
            }
        }
    }

    private void removeSkipMergeComponents(java.util.Properties props, java.lang.String componentName) {
        java.lang.String lookupName = ("@id='" + (componentName.trim())) + "'";
        java.lang.String key = findComponentKey(lookupName, props);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1673, (key != null))) {
            removeItemsMatchingKey(key, props);
            key = findComponentKey(lookupName, props);
        } 
    }

    private java.lang.String findComponentKey(java.lang.String componentIdStr, java.util.Properties props) {
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : props.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1674, (value instanceof java.lang.String))) {
                java.lang.String valueStr = ((java.lang.String) (value));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1675, valueStr.contains(componentIdStr))) {
                    java.lang.Object key = entry.getKey();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1676, (key instanceof java.lang.String))) {
                        return ((java.lang.String) (key));
                    }
                }
            }
        }
        return null;
    }

    private void removeItemsMatchingKey(java.lang.String firstKey, java.util.Properties props) {
        int dotPos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1677, firstKey.indexOf("."));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1680, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1678, dotPos)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1679, 0))))) {
            java.lang.String keyNumberToMatch = firstKey.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1681, dotPos));
            java.util.Iterator<java.lang.Object> iter = props.keySet().iterator();
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1682, iter.hasNext())) {
                java.lang.Object keyObj = iter.next();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1683, (keyObj instanceof java.lang.String))) {
                    java.lang.String keyStr = ((java.lang.String) (keyObj));
                    dotPos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1684, keyStr.indexOf("."));
                    java.lang.String keyNumber = keyStr.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1685, dotPos));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1686, keyNumber.equals(keyNumberToMatch))) {
                        iter.remove();
                    }
                }
            } 
        }
    }

    public org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream merge(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream stream1, org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream stream2) throws org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException {
        try {
            org.w3c.dom.Document doc1 = org.broadleafcommerce.common.extensibility.context.merge.MergeManager.builder.parse(stream1);
            org.w3c.dom.Document doc2 = org.broadleafcommerce.common.extensibility.context.merge.MergeManager.builder.parse(stream2);
            java.util.List<org.w3c.dom.Node> exhaustedNodes = new java.util.ArrayList<>();
            for (org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler handler : this.handlers) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1687, org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.debug(("Processing handler: " + (handler.getXPath())));
                }
                org.broadleafcommerce.common.extensibility.context.merge.MergePoint point = new org.broadleafcommerce.common.extensibility.context.merge.MergePoint(handler, doc1, doc2);
                org.w3c.dom.Node[] list = point.merge(exhaustedNodes);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1688, (list != null))) {
                    java.util.Collections.addAll(exhaustedNodes, list);
                }
            }
            javax.xml.transform.TransformerFactory tFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer xmlTransformer = tFactory.newTransformer();
            xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.VERSION, "1.0");
            xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");
            xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.BufferedWriter writer = null;
            try {
                javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc1);
                writer = new java.io.BufferedWriter(new java.io.OutputStreamWriter(baos, "UTF-8"));
                javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
                xmlTransformer.transform(source, result);
            } finally {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1689, (writer != null))) {
                    org.apache.commons.io.IOUtils.closeQuietly(writer);
                }
            }
            byte[] itemArray = baos.toByteArray();
            return new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(new java.io.ByteArrayInputStream(itemArray), stream2.getName(), stream1.getNames());
        } catch (java.lang.Exception e) {
            throw new org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException(e);
        }
    }

    private void setHandlers(java.util.Properties props) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        java.util.ArrayList<org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler> handlers = new java.util.ArrayList<>();
        for (java.lang.String key : props.stringPropertyNames()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1690, key.startsWith("handler."))) {
                org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler temp = ((org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler) (java.lang.Class.forName(props.getProperty(key)).newInstance()));
                java.lang.String name = key.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1691, 8), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1692, key.length()));
                temp.setName(name);
                java.lang.String priority = props.getProperty(("priority." + name));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1693, (priority != null))) {
                    temp.setPriority(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1694, java.lang.Integer.parseInt(priority)));
                }
                java.lang.String xpath = props.getProperty(("xpath." + name));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1695, (priority != null))) {
                    temp.setXPath(xpath);
                }
                handlers.add(temp);
            }
        }
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] explodedView = new org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[]{  };
        explodedView = handlers.toArray(explodedView);
        java.util.Comparator<java.lang.Object> nameCompare = new java.util.Comparator<java.lang.Object>() {
            @java.lang.Override
            public int compare(java.lang.Object arg0, java.lang.Object arg1) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1696, ((org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler) (arg0)).getName().compareTo(((org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler) (arg1)).getName()));
            }
        };
        java.util.Arrays.sort(explodedView, nameCompare);
        java.util.ArrayList<org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler> finalHandlers = new java.util.ArrayList<>();
        for (org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler temp : explodedView) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1697, temp.getName().contains("."))) {
                final java.lang.String parentName = temp.getName().substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1698, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1699, temp.getName().lastIndexOf(".")));
                int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1700, java.util.Arrays.binarySearch(explodedView, new org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandlerAdapter() {
                    @java.lang.Override
                    public java.lang.String getName() {
                        return parentName;
                    }
                }, nameCompare));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1703, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1701, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1702, 0))))) {
                    org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] parentHandlers = explodedView[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1704, pos)].getChildren();
                    org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] newHandlers = new org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1707, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1705, parentHandlers.length)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1706, 1))))];
                    java.lang.System.arraycopy(parentHandlers, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1708, 0), newHandlers, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1709, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1710, parentHandlers.length));
                    newHandlers[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1713, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1711, newHandlers.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1712, 1))))] = temp;
                    java.util.Arrays.sort(newHandlers);
                    explodedView[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1714, pos)].setChildren(newHandlers);
                }
            }else {
                finalHandlers.add(temp);
            }
        }
        this.handlers = new org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1715, 0)];
        this.handlers = finalHandlers.toArray(this.handlers);
        java.util.Arrays.sort(this.handlers);
    }

    private java.util.Properties loadProperties() throws java.io.IOException {
        java.util.Properties defaultProperties = new java.util.Properties();
        defaultProperties.load(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.class.getResourceAsStream("default.properties"));
        java.util.Properties props;
        java.lang.String overrideFileClassPath = java.lang.System.getProperty(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.MERGE_DEFINITION_SYSTEM_PROPERTY);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1716, (overrideFileClassPath != null))) {
            props = new java.util.Properties(defaultProperties);
            props.load(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.class.getClassLoader().getResourceAsStream(overrideFileClassPath));
        }else {
            props = defaultProperties;
        }
        return props;
    }

    public java.lang.String serialize(java.io.InputStream in) {
        java.io.InputStreamReader reader = null;
        int temp;
        java.lang.StringBuilder item = new java.lang.StringBuilder();
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1717, false);
        try {
            reader = new java.io.InputStreamReader(in);
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1719, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1718, eof))))) {
                temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1720, reader.read());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1724, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1721, temp)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1723, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1722, 1)))))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1725, true);
                }else {
                    item.append(perturbation.PerturbationEngine.pchar(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1726, ((char) (temp))));
                }
            } 
        } catch (java.io.IOException e) {
            org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.error("Unable to merge source and patch locations", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1727, (reader != null))) {
                try {
                    reader.close();
                } catch (java.lang.Throwable e) {
                    org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.error("Unable to merge source and patch locations", e);
                }
            }
        }
        return item.toString();
    }

    public static perturbation.location.PerturbationLocation __L1666;

    public static perturbation.location.PerturbationLocation __L1667;

    public static perturbation.location.PerturbationLocation __L1668;

    public static perturbation.location.PerturbationLocation __L1669;

    public static perturbation.location.PerturbationLocation __L1670;

    public static perturbation.location.PerturbationLocation __L1671;

    public static perturbation.location.PerturbationLocation __L1672;

    public static perturbation.location.PerturbationLocation __L1673;

    public static perturbation.location.PerturbationLocation __L1674;

    public static perturbation.location.PerturbationLocation __L1675;

    public static perturbation.location.PerturbationLocation __L1676;

    public static perturbation.location.PerturbationLocation __L1677;

    public static perturbation.location.PerturbationLocation __L1678;

    public static perturbation.location.PerturbationLocation __L1679;

    public static perturbation.location.PerturbationLocation __L1680;

    public static perturbation.location.PerturbationLocation __L1681;

    public static perturbation.location.PerturbationLocation __L1682;

    public static perturbation.location.PerturbationLocation __L1683;

    public static perturbation.location.PerturbationLocation __L1684;

    public static perturbation.location.PerturbationLocation __L1685;

    public static perturbation.location.PerturbationLocation __L1686;

    public static perturbation.location.PerturbationLocation __L1687;

    public static perturbation.location.PerturbationLocation __L1688;

    public static perturbation.location.PerturbationLocation __L1689;

    public static perturbation.location.PerturbationLocation __L1690;

    public static perturbation.location.PerturbationLocation __L1691;

    public static perturbation.location.PerturbationLocation __L1692;

    public static perturbation.location.PerturbationLocation __L1693;

    public static perturbation.location.PerturbationLocation __L1694;

    public static perturbation.location.PerturbationLocation __L1695;

    public static perturbation.location.PerturbationLocation __L1696;

    public static perturbation.location.PerturbationLocation __L1697;

    public static perturbation.location.PerturbationLocation __L1698;

    public static perturbation.location.PerturbationLocation __L1699;

    public static perturbation.location.PerturbationLocation __L1700;

    public static perturbation.location.PerturbationLocation __L1701;

    public static perturbation.location.PerturbationLocation __L1702;

    public static perturbation.location.PerturbationLocation __L1703;

    public static perturbation.location.PerturbationLocation __L1704;

    public static perturbation.location.PerturbationLocation __L1705;

    public static perturbation.location.PerturbationLocation __L1706;

    public static perturbation.location.PerturbationLocation __L1707;

    public static perturbation.location.PerturbationLocation __L1708;

    public static perturbation.location.PerturbationLocation __L1709;

    public static perturbation.location.PerturbationLocation __L1710;

    public static perturbation.location.PerturbationLocation __L1711;

    public static perturbation.location.PerturbationLocation __L1712;

    public static perturbation.location.PerturbationLocation __L1713;

    public static perturbation.location.PerturbationLocation __L1714;

    public static perturbation.location.PerturbationLocation __L1715;

    public static perturbation.location.PerturbationLocation __L1716;

    public static perturbation.location.PerturbationLocation __L1717;

    public static perturbation.location.PerturbationLocation __L1718;

    public static perturbation.location.PerturbationLocation __L1719;

    public static perturbation.location.PerturbationLocation __L1720;

    public static perturbation.location.PerturbationLocation __L1721;

    public static perturbation.location.PerturbationLocation __L1722;

    public static perturbation.location.PerturbationLocation __L1723;

    public static perturbation.location.PerturbationLocation __L1724;

    public static perturbation.location.PerturbationLocation __L1725;

    public static perturbation.location.PerturbationLocation __L1726;

    public static perturbation.location.PerturbationLocation __L1727;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:121)", 1666, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:125)", 1667, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:133)", 1668, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:134)", 1669, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:143)", 1670, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:146)", 1671, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:149)", 1672, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:166)", 1673, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:184)", 1674, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:186)", 1675, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:188)", 1676, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:206)", 1677, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:207)", 1678, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:207)", 1679, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:207)", 1680, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:208)", 1681, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:212)", 1682, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:214)", 1683, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:216)", 1684, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:217)", 1685, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:218)", 1686, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:245)", 1687, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:250)", 1688, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:270)", 1689, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:286)", 1690, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:288)", 1691, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:288)", 1692, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:291)", 1693, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:292)", 1694, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:295)", 1695, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:306)", 1696, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:312)", 1697, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:313)", 1698, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:313)", 1699, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:314)", 1700, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:320)", 1701, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:320)", 1702, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:320)", 1703, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:321)", 1704, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:322)", 1705, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:322)", 1706, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:322)", 1707, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:323)", 1708, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:323)", 1709, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:323)", 1710, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:324)", 1711, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:324)", 1712, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:324)", 1713, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:326)", 1714, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:333)", 1715, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:343)", 1716, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:357)", 1717, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:360)", 1718, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:360)", 1719, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:361)", 1720, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:362)", 1721, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:362)", 1722, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:362)", 1723, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:362)", 1724, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:363)", 1725, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:365)", 1726, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.__L1727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeManager.java:371)", 1727, "Boolean");
    }

    static {
        try {
            javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            org.broadleafcommerce.common.extensibility.context.merge.MergeManager.builder = dbf.newDocumentBuilder();
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            org.broadleafcommerce.common.extensibility.context.merge.MergeManager.LOG.error("Unable to create document builder", e);
            throw new java.lang.RuntimeException(e);
        }
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.MergeManager.initPerturbationLocation0();
    }
}

