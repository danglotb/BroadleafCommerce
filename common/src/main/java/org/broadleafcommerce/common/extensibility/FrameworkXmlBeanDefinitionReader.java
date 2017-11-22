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


public class FrameworkXmlBeanDefinitionReader extends org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader {
    public FrameworkXmlBeanDefinitionReader(org.springframework.beans.factory.support.BeanDefinitionRegistry registry) {
        super(registry);
    }

    @java.lang.Override
    public int registerBeanDefinitions(org.w3c.dom.Document doc, org.springframework.core.io.Resource resource) throws org.springframework.beans.factory.BeanDefinitionStoreException {
        java.util.Map<java.lang.String, org.springframework.beans.factory.config.BeanDefinition> implementationBeanDefinitions = new java.util.HashMap<>();
        for (java.lang.String name : getRegistry().getBeanDefinitionNames()) {
            org.springframework.beans.factory.config.BeanDefinition definition = getRegistry().getBeanDefinition(name);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2375, isConfigurationClassBean(definition))) {
                implementationBeanDefinitions.put(name, definition);
            }
        }
        int processedCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2376, super.registerBeanDefinitions(doc, resource));
        for (java.lang.String beanName : getRegistry().getBeanDefinitionNames()) {
            org.springframework.beans.factory.config.BeanDefinition beanDefinition = getRegistry().getBeanDefinition(beanName);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2377, isXMLBean(beanDefinition))) {
                ((org.springframework.beans.factory.support.GenericBeanDefinition) (beanDefinition)).setRole(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2378, org.springframework.beans.factory.config.BeanDefinition.ROLE_SUPPORT));
            }
        }
        for (java.util.Map.Entry<java.lang.String, org.springframework.beans.factory.config.BeanDefinition> entry : implementationBeanDefinitions.entrySet()) {
            org.springframework.beans.factory.config.BeanDefinition registeredBeanDefinition = getRegistry().getBeanDefinition(entry.getKey());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2382, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2379, (registeredBeanDefinition == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2381, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2380, java.util.Objects.equals(registeredBeanDefinition, entry.getValue()))))))))) {
                getRegistry().registerBeanDefinition(entry.getKey(), entry.getValue());
            }
        }
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2383, processedCount);
    }

    protected boolean isConfigurationClassBean(org.springframework.beans.factory.config.BeanDefinition definition) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2385, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2384, (definition instanceof org.springframework.beans.factory.support.GenericBeanDefinition)))));
    }

    public static perturbation.location.PerturbationLocation __L2375;

    public static perturbation.location.PerturbationLocation __L2376;

    public static perturbation.location.PerturbationLocation __L2377;

    public static perturbation.location.PerturbationLocation __L2378;

    public static perturbation.location.PerturbationLocation __L2379;

    public static perturbation.location.PerturbationLocation __L2380;

    public static perturbation.location.PerturbationLocation __L2381;

    public static perturbation.location.PerturbationLocation __L2382;

    public static perturbation.location.PerturbationLocation __L2383;

    public static perturbation.location.PerturbationLocation __L2384;

    public static perturbation.location.PerturbationLocation __L2385;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:59)", 2375, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:65)", 2376, "Numerical");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:70)", 2377, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:71)", 2378, "Numerical");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:80)", 2379, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:80)", 2380, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:80)", 2381, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:80)", 2382, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:85)", 2383, "Numerical");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:92)", 2384, "Boolean");
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.__L2385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/FrameworkXmlBeanDefinitionReader.java:92)", 2385, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.initPerturbationLocation0();
    }
}

