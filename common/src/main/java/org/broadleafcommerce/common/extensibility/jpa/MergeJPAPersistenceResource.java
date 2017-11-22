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
package org.broadleafcommerce.common.extensibility.jpa;


public class MergeJPAPersistenceResource extends org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.class);

    private org.xml.sax.ErrorHandler handler = new org.springframework.util.xml.SimpleSaxErrorHandler(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.LOG);

    @java.lang.Override
    public org.springframework.core.io.Resource getMergedConfigResource(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] sources) throws org.springframework.beans.BeansException {
        org.springframework.core.io.Resource configResource = null;
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream merged = null;
        try {
            java.util.List<java.lang.String> mappingFiles = new java.util.ArrayList<>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2224, 20));
            org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] inMemoryStreams = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2225, sources.length)];
            for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2226, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2229, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2227, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2228, sources.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2230, (j++))) {
                byte[] sourceArray = buildArrayFromStream(sources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2231, j)]);
                compileMappingFiles(mappingFiles, sourceArray);
                inMemoryStreams[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2232, j)] = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(new java.io.ByteArrayInputStream(sourceArray), sources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2233, j)].getName());
            }
            merged = merge(inMemoryStreams);
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2234, false);
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2236, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2235, eof))))) {
                int temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2237, merged.read());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2241, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2238, temp)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2240, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2239, 1)))))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2242, true);
                }else {
                    baos.write(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2243, temp));
                }
            } 
            configResource = new org.springframework.core.io.ByteArrayResource(baos.toByteArray());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2244, org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.LOG.isDebugEnabled())) {
                org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.LOG.debug(("Merged config: \n" + (org.broadleafcommerce.common.util.StringUtil.sanitize(serialize(configResource)))));
            }
        } catch (org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } catch (org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } catch (java.io.IOException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } catch (org.xml.sax.SAXException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2245, (merged != null))) {
                try {
                    merged.close();
                } catch (java.lang.Throwable e) {
                    org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.LOG.error("Unable to merge source and patch locations", e);
                }
            }
        }
        return configResource;
    }

    private void compileMappingFiles(java.util.List<java.lang.String> mappingFiles, byte[] sourceArray) throws java.io.IOException, javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2246, true));
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2247, true));
        javax.xml.parsers.DocumentBuilder parser = dbf.newDocumentBuilder();
        parser.setErrorHandler(handler);
        org.w3c.dom.Document dom = parser.parse(new java.io.ByteArrayInputStream(sourceArray));
        org.w3c.dom.NodeList nodes = dom.getElementsByTagName("/persistence/persistence-unit/mapping-file");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2252, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2248, (nodes != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2251, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2249, nodes.getLength())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2250, 0)))))))) {
            int length = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2253, nodes.getLength());
            for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2254, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2257, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2255, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2256, length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2258, (j++))) {
                org.w3c.dom.Node node = nodes.item(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2259, j));
                mappingFiles.add(node.getNodeValue());
            }
        }
    }

    public static perturbation.location.PerturbationLocation __L2224;

    public static perturbation.location.PerturbationLocation __L2225;

    public static perturbation.location.PerturbationLocation __L2226;

    public static perturbation.location.PerturbationLocation __L2227;

    public static perturbation.location.PerturbationLocation __L2228;

    public static perturbation.location.PerturbationLocation __L2229;

    public static perturbation.location.PerturbationLocation __L2230;

    public static perturbation.location.PerturbationLocation __L2231;

    public static perturbation.location.PerturbationLocation __L2232;

    public static perturbation.location.PerturbationLocation __L2233;

    public static perturbation.location.PerturbationLocation __L2234;

    public static perturbation.location.PerturbationLocation __L2235;

    public static perturbation.location.PerturbationLocation __L2236;

    public static perturbation.location.PerturbationLocation __L2237;

    public static perturbation.location.PerturbationLocation __L2238;

    public static perturbation.location.PerturbationLocation __L2239;

    public static perturbation.location.PerturbationLocation __L2240;

    public static perturbation.location.PerturbationLocation __L2241;

    public static perturbation.location.PerturbationLocation __L2242;

    public static perturbation.location.PerturbationLocation __L2243;

    public static perturbation.location.PerturbationLocation __L2244;

    public static perturbation.location.PerturbationLocation __L2245;

    public static perturbation.location.PerturbationLocation __L2246;

    public static perturbation.location.PerturbationLocation __L2247;

    public static perturbation.location.PerturbationLocation __L2248;

    public static perturbation.location.PerturbationLocation __L2249;

    public static perturbation.location.PerturbationLocation __L2250;

    public static perturbation.location.PerturbationLocation __L2251;

    public static perturbation.location.PerturbationLocation __L2252;

    public static perturbation.location.PerturbationLocation __L2253;

    public static perturbation.location.PerturbationLocation __L2254;

    public static perturbation.location.PerturbationLocation __L2255;

    public static perturbation.location.PerturbationLocation __L2256;

    public static perturbation.location.PerturbationLocation __L2257;

    public static perturbation.location.PerturbationLocation __L2258;

    public static perturbation.location.PerturbationLocation __L2259;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:63)", 2224, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:64)", 2225, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:65)", 2226, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:65)", 2227, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:65)", 2228, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:65)", 2229, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:65)", 2230, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:66)", 2231, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:68)", 2232, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:68)", 2233, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:75)", 2234, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:76)", 2235, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:76)", 2236, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:77)", 2237, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:78)", 2238, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:78)", 2239, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:78)", 2240, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:78)", 2241, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:79)", 2242, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:81)", 2243, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:86)", 2244, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:100)", 2245, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:112)", 2246, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:114)", 2247, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:122)", 2248, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:122)", 2249, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:122)", 2250, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:122)", 2251, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:122)", 2252, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:123)", 2253, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:124)", 2254, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:124)", 2255, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:124)", 2256, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:124)", 2257, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:124)", 2258, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.__L2259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergeJPAPersistenceResource.java:125)", 2259, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.MergeJPAPersistenceResource.initPerturbationLocation0();
    }
}

