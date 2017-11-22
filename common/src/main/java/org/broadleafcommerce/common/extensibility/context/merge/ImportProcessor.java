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


public class ImportProcessor {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.class);

    private static final java.lang.String IMPORT_PATH = "/beans/import";

    protected org.springframework.core.io.ResourceLoader loader;

    protected javax.xml.parsers.DocumentBuilder builder;

    protected javax.xml.xpath.XPath xPath;

    public ImportProcessor(org.springframework.core.io.ResourceLoader loader) {
        this.loader = loader;
        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        try {
            builder = dbf.newDocumentBuilder();
            javax.xml.xpath.XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
            xPath = factory.newXPath();
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.LOG.error("Unable to create document builder", e);
            throw new java.lang.RuntimeException(e);
        }
    }

    public org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] extract(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] sources) throws org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1618, (sources == null))) {
            return null;
        }
        try {
            org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator resourceList = new org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator();
            resourceList.addAll(java.util.Arrays.asList(sources));
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1619, resourceList.hasNext())) {
                org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream myStream = resourceList.nextResource();
                org.w3c.dom.Document doc = builder.parse(myStream);
                org.w3c.dom.NodeList nodeList = ((org.w3c.dom.NodeList) (xPath.evaluate(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.IMPORT_PATH, doc, javax.xml.xpath.XPathConstants.NODESET)));
                int length = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1620, nodeList.getLength());
                for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1621, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1624, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1622, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1623, length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1625, (j++))) {
                    org.w3c.dom.Element element = ((org.w3c.dom.Element) (nodeList.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1626, j))));
                    org.springframework.core.io.Resource resource = loader.getResource(element.getAttribute("resource"));
                    org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream ris = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(resource.getInputStream(), resource.getURL().toString());
                    resourceList.addEmbeddedResource(ris);
                    element.getParentNode().removeChild(element);
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1629, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1627, length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1628, 0))))) {
                    javax.xml.transform.TransformerFactory tFactory = javax.xml.transform.TransformerFactory.newInstance();
                    javax.xml.transform.Transformer xmlTransformer = tFactory.newTransformer();
                    xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.VERSION, "1.0");
                    xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
                    xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");
                    xmlTransformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
                    javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
                    java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                    java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.OutputStreamWriter(baos));
                    javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
                    xmlTransformer.transform(source, result);
                    byte[] itemArray = baos.toByteArray();
                    resourceList.set(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1632, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1630, resourceList.getPosition())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1631, 1)))), new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(new java.io.ByteArrayInputStream(itemArray), null, myStream.getNames()));
                }else {
                    myStream.reset();
                }
            } 
            return resourceList.toArray(new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1633, resourceList.size())]);
        } catch (java.lang.Exception e) {
            throw new org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException(e);
        }
    }

    public static perturbation.location.PerturbationLocation __L1618;

    public static perturbation.location.PerturbationLocation __L1619;

    public static perturbation.location.PerturbationLocation __L1620;

    public static perturbation.location.PerturbationLocation __L1621;

    public static perturbation.location.PerturbationLocation __L1622;

    public static perturbation.location.PerturbationLocation __L1623;

    public static perturbation.location.PerturbationLocation __L1624;

    public static perturbation.location.PerturbationLocation __L1625;

    public static perturbation.location.PerturbationLocation __L1626;

    public static perturbation.location.PerturbationLocation __L1627;

    public static perturbation.location.PerturbationLocation __L1628;

    public static perturbation.location.PerturbationLocation __L1629;

    public static perturbation.location.PerturbationLocation __L1630;

    public static perturbation.location.PerturbationLocation __L1631;

    public static perturbation.location.PerturbationLocation __L1632;

    public static perturbation.location.PerturbationLocation __L1633;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:79)", 1618, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:85)", 1619, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:89)", 1620, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:90)", 1621, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:90)", 1622, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:90)", 1623, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:90)", 1624, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:90)", 1625, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:91)", 1626, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:97)", 1627, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:97)", 1628, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:97)", 1629, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:113)", 1630, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:113)", 1631, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:113)", 1632, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.__L1633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ImportProcessor.java:119)", 1633, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.ImportProcessor.initPerturbationLocation0();
    }
}

