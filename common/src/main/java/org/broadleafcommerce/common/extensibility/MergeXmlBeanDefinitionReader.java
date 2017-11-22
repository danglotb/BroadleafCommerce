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
package org.broadleafcommerce.common.extensibility;


public class MergeXmlBeanDefinitionReader extends org.springframework.beans.factory.xml.XmlBeanDefinitionReader {
    public static class BeanUtil {
        public static boolean isXMLBean(org.springframework.beans.factory.config.BeanDefinition beanDefinition) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2436, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2434, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2432, (beanDefinition instanceof org.springframework.beans.factory.support.GenericBeanDefinition))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2433, ((((org.springframework.beans.factory.support.GenericBeanDefinition) (beanDefinition)).getResource()) != null)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2435, ((org.springframework.beans.factory.support.GenericBeanDefinition) (beanDefinition)).getResource().getFilename().endsWith(".xml")))));
        }

        public static perturbation.location.PerturbationLocation __L2432;

        public static perturbation.location.PerturbationLocation __L2433;

        public static perturbation.location.PerturbationLocation __L2434;

        public static perturbation.location.PerturbationLocation __L2435;

        public static perturbation.location.PerturbationLocation __L2436;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:62)", 2432, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:63)", 2433, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:62)", 2434, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:64)", 2435, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.__L2436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:62)", 2436, "Boolean");
        }

        static {
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.initPerturbationLocation0();
        }
    }

    public static class MergeBeanDefinitionDocumentReader extends org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader {
        private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.class);

        @java.lang.Override
        protected void processBeanDefinition(org.w3c.dom.Element ele, org.springframework.beans.factory.xml.BeanDefinitionParserDelegate delegate) {
            java.lang.String beanId = getBeanId(ele);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2438, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2437, org.springframework.util.StringUtils.hasText(beanId)))))) {
                org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.LOG.debug("No explicit bean id defined, skipping any attempts at bean merging");
                super.processBeanDefinition(ele, delegate);
                return ;
            }
            org.springframework.beans.factory.config.BeanDefinition existingDefinition = null;
            try {
                existingDefinition = getReaderContext().getRegistry().getBeanDefinition(beanId);
            } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException e) {
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2441, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2439, (existingDefinition != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2440, isXMLBean(existingDefinition)))))) {
                org.springframework.beans.factory.config.BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2442, (bdHolder != null))) {
                    bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);
                    org.springframework.beans.factory.config.BeanDefinition finalDefinition = ((org.springframework.beans.factory.support.AbstractBeanDefinition) (existingDefinition)).cloneBeanDefinition();
                    org.springframework.beans.factory.config.BeanDefinition overridingDefinition = bdHolder.getBeanDefinition();
                    ((org.springframework.beans.factory.support.AbstractBeanDefinition) (finalDefinition)).overrideFrom(overridingDefinition);
                    bdHolder = new org.springframework.beans.factory.config.BeanDefinitionHolder(finalDefinition, bdHolder.getBeanName(), bdHolder.getAliases());
                    org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.LOG.info(java.lang.String.format("Merged the original definition of %s defined as %s with a new definition defined as %s", bdHolder.getBeanName(), existingDefinition, overridingDefinition));
                    try {
                        org.springframework.beans.factory.support.BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, getReaderContext().getRegistry());
                    } catch (org.springframework.beans.factory.BeanDefinitionStoreException ex) {
                        getReaderContext().error((("Failed to register bean definition with name '" + (bdHolder.getBeanName())) + "'"), ele, ex);
                    }
                    getReaderContext().fireComponentRegistered(new org.springframework.beans.factory.parsing.BeanComponentDefinition(bdHolder));
                }
            }else {
                org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.LOG.debug(java.lang.String.format("Skipping the merging of bean %s and delegating to the default Spring behavior", beanId));
                super.processBeanDefinition(ele, delegate);
            }
        }

        protected java.lang.String getBeanId(org.w3c.dom.Element ele) {
            java.lang.String id = ele.getAttribute(org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.ID_ATTRIBUTE);
            java.lang.String nameAttr = ele.getAttribute(org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.NAME_ATTRIBUTE);
            java.util.List<java.lang.String> aliases = new java.util.ArrayList<>();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2443, org.springframework.util.StringUtils.hasLength(nameAttr))) {
                java.lang.String[] nameArr = org.springframework.util.StringUtils.tokenizeToStringArray(nameAttr, org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS);
                aliases.addAll(java.util.Arrays.asList(nameArr));
            }
            java.lang.String beanName = id;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2448, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2445, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2444, org.springframework.util.StringUtils.hasText(beanName)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2447, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2446, aliases.isEmpty())))))))) {
                beanName = aliases.remove(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2449, 0));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2450, logger.isDebugEnabled())) {
                    logger.debug((((("No XML 'id' specified - using '" + beanName) + "' as bean name and ") + aliases) + " as aliases"));
                }
            }
            return beanName;
        }

        protected boolean isXMLBean(org.springframework.beans.factory.config.BeanDefinition beanDefinition) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2451, org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.isXMLBean(beanDefinition));
        }

        public static perturbation.location.PerturbationLocation __L2437;

        public static perturbation.location.PerturbationLocation __L2438;

        public static perturbation.location.PerturbationLocation __L2439;

        public static perturbation.location.PerturbationLocation __L2440;

        public static perturbation.location.PerturbationLocation __L2441;

        public static perturbation.location.PerturbationLocation __L2442;

        public static perturbation.location.PerturbationLocation __L2443;

        public static perturbation.location.PerturbationLocation __L2444;

        public static perturbation.location.PerturbationLocation __L2445;

        public static perturbation.location.PerturbationLocation __L2446;

        public static perturbation.location.PerturbationLocation __L2447;

        public static perturbation.location.PerturbationLocation __L2448;

        public static perturbation.location.PerturbationLocation __L2449;

        public static perturbation.location.PerturbationLocation __L2450;

        public static perturbation.location.PerturbationLocation __L2451;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:91)", 2437, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:91)", 2438, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:108)", 2439, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:108)", 2440, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:108)", 2441, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:112)", 2442, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:148)", 2443, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:154)", 2444, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:154)", 2445, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:154)", 2446, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:154)", 2447, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:154)", 2448, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:155)", 2449, "Numerical");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:156)", 2450, "Boolean");
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.__L2451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:165)", 2451, "Boolean");
        }

        static {
            org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.initPerturbationLocation0();
        }
    }

    public MergeXmlBeanDefinitionReader(org.springframework.beans.factory.support.BeanDefinitionRegistry registry) {
        super(registry);
        setDocumentReaderClass(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader.class);
    }

    protected boolean isXMLBean(org.springframework.beans.factory.config.BeanDefinition beanDefinition) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.__L2452, org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil.isXMLBean(beanDefinition));
    }

    public static perturbation.location.PerturbationLocation __L2452;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.__L2452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/MergeXmlBeanDefinitionReader.java:57)", 2452, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.initPerturbationLocation0();
    }
}

