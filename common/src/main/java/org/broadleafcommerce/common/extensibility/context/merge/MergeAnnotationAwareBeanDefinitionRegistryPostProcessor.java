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


@org.springframework.stereotype.Component
public class MergeAnnotationAwareBeanDefinitionRegistryPostProcessor implements org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor {
    private static final java.lang.String ANNOTATED_POST_PROCESSOR_SUFFIX = "AnnotatedMergePostProcessor";

    @java.lang.Override
    public void postProcessBeanDefinitionRegistry(org.springframework.beans.factory.support.BeanDefinitionRegistry registry) throws org.springframework.beans.BeansException {
        java.util.Map<java.lang.String, org.springframework.beans.factory.config.BeanDefinition> clientAnnotatedBeanPostProcessors = new java.util.LinkedHashMap<>();
        java.util.Map<java.lang.String, org.springframework.beans.factory.config.BeanDefinition> clientBeanPostProcessors = new java.util.LinkedHashMap<>();
        for (java.lang.String name : registry.getBeanDefinitionNames()) {
            org.springframework.beans.factory.config.BeanDefinition beanDefinition = registry.getBeanDefinition(name);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1638, (beanDefinition instanceof org.springframework.beans.factory.annotation.AnnotatedBeanDefinition))) {
                org.springframework.core.type.MethodMetadata metadata = ((org.springframework.beans.factory.annotation.AnnotatedBeanDefinition) (beanDefinition)).getFactoryMethodMetadata();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1639, (metadata != null))) {
                    java.util.Map<java.lang.String, java.lang.Object> attributes = metadata.getAnnotationAttributes(org.broadleafcommerce.common.extensibility.context.merge.Merge.class.getName());
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1641, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1640, org.apache.commons.collections.MapUtils.isEmpty(attributes)))))) {
                        boolean isEarly = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1642, org.apache.commons.collections.MapUtils.getBooleanValue(attributes, "early"));
                        org.springframework.beans.factory.support.BeanDefinitionBuilder builder = org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1643, isEarly) ? org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.class : org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.class)).setScope(org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON).addPropertyValue("sourceRef", name).addPropertyValue("targetRef", attributes.get("targetRef")).addPropertyValue("placement", attributes.get("placement")).addPropertyValue("position", attributes.get("position"));
                        java.lang.Class<org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider> clazz = ((java.lang.Class<org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider>) (attributes.get("statusProvider")));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1644, ((org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider.class) != clazz))) {
                            try {
                                builder.addPropertyValue("statusProvider", clazz.newInstance());
                            } catch (java.lang.InstantiationException e) {
                                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
                            } catch (java.lang.IllegalAccessException e) {
                                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
                            }
                        }
                        org.springframework.beans.factory.config.BeanDefinition definition = builder.getBeanDefinition();
                        java.lang.String beanName = (((name + "_") + (attributes.get("targetRef"))) + (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1645, isEarly) ? "Early" : "Late")) + (org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.ANNOTATED_POST_PROCESSOR_SUFFIX);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1646, isBroadleafAnnotationBean(metadata))) {
                            registry.registerBeanDefinition(beanName, definition);
                        }else {
                            clientAnnotatedBeanPostProcessors.put(beanName, definition);
                        }
                    }
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1651, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1647, ((beanDefinition.getBeanClassName()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1650, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1648, beanDefinition.getBeanClassName().equals(org.broadleafcommerce.common.extensibility.context.merge.EarlyStageMergeBeanPostProcessor.class.getName()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1649, beanDefinition.getBeanClassName().equals(org.broadleafcommerce.common.extensibility.context.merge.LateStageMergeBeanPostProcessor.class.getName()))))))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1653, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1652, isBroadleafBean(beanDefinition)))))) {
                    registry.removeBeanDefinition(name);
                    clientBeanPostProcessors.put(name, beanDefinition);
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1654, org.apache.commons.collections4.MapUtils.isNotEmpty(clientBeanPostProcessors))) {
            for (java.util.Map.Entry<java.lang.String, org.springframework.beans.factory.config.BeanDefinition> entry : clientBeanPostProcessors.entrySet()) {
                registry.registerBeanDefinition(entry.getKey(), entry.getValue());
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1655, org.apache.commons.collections4.MapUtils.isNotEmpty(clientAnnotatedBeanPostProcessors))) {
            for (java.util.Map.Entry<java.lang.String, org.springframework.beans.factory.config.BeanDefinition> entry : clientAnnotatedBeanPostProcessors.entrySet()) {
                registry.registerBeanDefinition(entry.getKey(), entry.getValue());
            }
        }
    }

    protected boolean isBroadleafAnnotationBean(org.springframework.core.type.MethodMetadata metadata) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1658, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1656, metadata.getDeclaringClassName().contains("org.broadleafcommerce"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1657, metadata.getDeclaringClassName().contains("com.broadleafcommerce")))));
    }

    protected boolean isBroadleafBean(org.springframework.beans.factory.config.BeanDefinition beanDefinition) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1659, (beanDefinition instanceof org.springframework.beans.factory.annotation.AnnotatedBeanDefinition))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1660, isBroadleafAnnotationBean(((org.springframework.beans.factory.annotation.AnnotatedBeanDefinition) (beanDefinition)).getFactoryMethodMetadata()));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1663, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1661, (beanDefinition instanceof org.springframework.beans.factory.support.GenericBeanDefinition))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1662, ((((org.springframework.beans.factory.support.GenericBeanDefinition) (beanDefinition)).getResource()) != null)))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1664, ((org.springframework.beans.factory.support.GenericBeanDefinition) (beanDefinition)).getResource().getFilename().startsWith("bl-"));
            }

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1665, false);
    }

    @java.lang.Override
    public void postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory bf) throws org.springframework.beans.BeansException {
    }

    public static perturbation.location.PerturbationLocation __L1638;

    public static perturbation.location.PerturbationLocation __L1639;

    public static perturbation.location.PerturbationLocation __L1640;

    public static perturbation.location.PerturbationLocation __L1641;

    public static perturbation.location.PerturbationLocation __L1642;

    public static perturbation.location.PerturbationLocation __L1643;

    public static perturbation.location.PerturbationLocation __L1644;

    public static perturbation.location.PerturbationLocation __L1645;

    public static perturbation.location.PerturbationLocation __L1646;

    public static perturbation.location.PerturbationLocation __L1647;

    public static perturbation.location.PerturbationLocation __L1648;

    public static perturbation.location.PerturbationLocation __L1649;

    public static perturbation.location.PerturbationLocation __L1650;

    public static perturbation.location.PerturbationLocation __L1651;

    public static perturbation.location.PerturbationLocation __L1652;

    public static perturbation.location.PerturbationLocation __L1653;

    public static perturbation.location.PerturbationLocation __L1654;

    public static perturbation.location.PerturbationLocation __L1655;

    public static perturbation.location.PerturbationLocation __L1656;

    public static perturbation.location.PerturbationLocation __L1657;

    public static perturbation.location.PerturbationLocation __L1658;

    public static perturbation.location.PerturbationLocation __L1659;

    public static perturbation.location.PerturbationLocation __L1660;

    public static perturbation.location.PerturbationLocation __L1661;

    public static perturbation.location.PerturbationLocation __L1662;

    public static perturbation.location.PerturbationLocation __L1663;

    public static perturbation.location.PerturbationLocation __L1664;

    public static perturbation.location.PerturbationLocation __L1665;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:56)", 1638, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:58)", 1639, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:60)", 1640, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:60)", 1641, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:61)", 1642, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:63)", 1643, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:70)", 1644, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:83)", 1645, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:85)", 1646, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:98)", 1647, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:99)", 1648, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:100)", 1649, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:99)", 1650, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:98)", 1651, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:101)", 1652, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:101)", 1653, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:108)", 1654, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:114)", 1655, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:122)", 1656, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:123)", 1657, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:122)", 1658, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:127)", 1659, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:128)", 1660, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:129)", 1661, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:129)", 1662, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:129)", 1663, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:130)", 1664, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.__L1665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.java:133)", 1665, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.initPerturbationLocation0();
    }
}

