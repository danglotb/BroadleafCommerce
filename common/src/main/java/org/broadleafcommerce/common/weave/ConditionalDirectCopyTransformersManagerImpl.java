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
package org.broadleafcommerce.common.weave;


@org.springframework.stereotype.Service("blConditionalDirectCopyTransformersManager")
public class ConditionalDirectCopyTransformersManagerImpl implements org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManager , org.springframework.beans.factory.BeanFactoryAware {
    @javax.annotation.Resource(name = "blConditionalDirectCopyTransformers")
    protected java.util.Map<java.lang.String, org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto> entityToPropertyMap;

    protected java.util.Map<java.lang.String, org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto> enabledEntities = new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto>();

    protected org.springframework.beans.factory.config.ConfigurableBeanFactory beanFactory;

    @javax.annotation.PostConstruct
    public void init() {
        for (java.util.Map.Entry<java.lang.String, org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto> entry : entityToPropertyMap.entrySet()) {
            if (isPropertyEnabled(entry.getValue().getConditionalProperty())) {
                enabledEntities.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @java.lang.Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) throws org.springframework.beans.BeansException {
        this.beanFactory = ((org.springframework.beans.factory.config.ConfigurableBeanFactory) (beanFactory));
    }

    @java.lang.Override
    public java.lang.Boolean isEntityEnabled(java.lang.String entityName) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.__L7037, enabledEntities.containsKey(entityName));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto getTransformMember(java.lang.String entityName) {
        return enabledEntities.get(entityName);
    }

    protected java.lang.Boolean isPropertyEnabled(java.lang.String propertyName) {
        java.lang.Boolean shouldProceed;
        try {
            java.lang.String value = beanFactory.resolveEmbeddedValue((("${" + propertyName) + ":false}"));
            shouldProceed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.__L7038, java.lang.Boolean.parseBoolean(value));
        } catch (java.lang.Exception e) {
            shouldProceed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.__L7039, false);
        }
        return shouldProceed;
    }

    public static perturbation.location.PerturbationLocation __L7037;

    public static perturbation.location.PerturbationLocation __L7038;

    public static perturbation.location.PerturbationLocation __L7039;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.__L7037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformersManagerImpl.java:61)", 7037, "Boolean");
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.__L7038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformersManagerImpl.java:73)", 7038, "Boolean");
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.__L7039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformersManagerImpl.java:75)", 7039, "Boolean");
    }

    static {
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManagerImpl.initPerturbationLocation0();
    }
}

