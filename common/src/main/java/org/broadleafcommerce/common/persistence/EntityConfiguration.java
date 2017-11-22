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
package org.broadleafcommerce.common.persistence;


@org.springframework.stereotype.Component("blEntityConfiguration")
public class EntityConfiguration implements org.springframework.context.ApplicationContextAware {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.persistence.EntityConfiguration.class);

    private org.springframework.context.ApplicationContext webApplicationContext;

    private final java.util.HashMap<java.lang.String, java.lang.Class<?>> entityMap = new java.util.HashMap<java.lang.String, java.lang.Class<?>>(50);

    private org.springframework.context.ApplicationContext applicationcontext;

    private org.springframework.core.io.Resource[] entityContexts;

    @javax.annotation.Resource(name = "blMergedEntityContexts")
    protected java.util.Set<java.lang.String> mergedEntityContexts;

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        this.webApplicationContext = applicationContext;
    }

    @javax.annotation.PostConstruct
    public void configureMergedItems() {
        java.util.Set<org.springframework.core.io.Resource> temp = new java.util.LinkedHashSet<org.springframework.core.io.Resource>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4343, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4340, ((mergedEntityContexts) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4342, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4341, mergedEntityContexts.isEmpty())))))))) {
            for (java.lang.String location : mergedEntityContexts) {
                temp.add(webApplicationContext.getResource(location));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4344, ((entityContexts) != null))) {
            for (org.springframework.core.io.Resource resource : entityContexts) {
                temp.add(resource);
            }
        }
        entityContexts = temp.toArray(new org.springframework.core.io.Resource[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4345, temp.size())]);
        applicationcontext = new org.springframework.context.support.GenericXmlApplicationContext(entityContexts);
    }

    public java.lang.Class<?> lookupEntityClass(java.lang.String beanId) {
        java.lang.Class<?> clazz;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4346, entityMap.containsKey(beanId))) {
            clazz = entityMap.get(beanId);
        }else {
            java.lang.Object object = applicationcontext.getBean(beanId);
            clazz = object.getClass();
            entityMap.put(beanId, clazz);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4347, org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.debug((((("Returning class (" + (clazz.getName())) + ") configured with bean id (") + (org.broadleafcommerce.common.util.StringUtil.sanitize(beanId))) + ')'));
        }
        return clazz;
    }

    public java.lang.String[] getEntityBeanNames() {
        return applicationcontext.getBeanDefinitionNames();
    }

    public <T> java.lang.Class<T> lookupEntityClass(java.lang.String beanId, java.lang.Class<T> resultClass) {
        java.lang.Class<T> clazz;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4348, entityMap.containsKey(beanId))) {
            clazz = ((java.lang.Class<T>) (entityMap.get(beanId)));
        }else {
            java.lang.Object object = applicationcontext.getBean(beanId);
            clazz = ((java.lang.Class<T>) (object.getClass()));
            entityMap.put(beanId, clazz);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4349, org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.debug((((("Returning class (" + (clazz.getName())) + ") configured with bean id (") + beanId) + ')'));
        }
        return clazz;
    }

    public java.lang.Object createEntityInstance(java.lang.String beanId) {
        java.lang.Object bean = applicationcontext.getBean(beanId);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4350, org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.debug((((("Returning instance of class (" + (bean.getClass().getName())) + ") configured with bean id (") + beanId) + ')'));
        }
        return bean;
    }

    public <T> T createEntityInstance(java.lang.String beanId, java.lang.Class<T> resultClass) {
        T bean = ((T) (applicationcontext.getBean(beanId)));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.EntityConfiguration.__L4351, org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.persistence.EntityConfiguration.LOG.debug((((("Returning instance of class (" + (bean.getClass().getName())) + ") configured with bean id (") + beanId) + ')'));
        }
        return bean;
    }

    public org.springframework.core.io.Resource[] getEntityContexts() {
        return entityContexts;
    }

    public void setEntityContexts(org.springframework.core.io.Resource[] entityContexts) {
        this.entityContexts = entityContexts;
    }

    public static perturbation.location.PerturbationLocation __L4340;

    public static perturbation.location.PerturbationLocation __L4341;

    public static perturbation.location.PerturbationLocation __L4342;

    public static perturbation.location.PerturbationLocation __L4343;

    public static perturbation.location.PerturbationLocation __L4344;

    public static perturbation.location.PerturbationLocation __L4345;

    public static perturbation.location.PerturbationLocation __L4346;

    public static perturbation.location.PerturbationLocation __L4347;

    public static perturbation.location.PerturbationLocation __L4348;

    public static perturbation.location.PerturbationLocation __L4349;

    public static perturbation.location.PerturbationLocation __L4350;

    public static perturbation.location.PerturbationLocation __L4351;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:56)", 4340, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:56)", 4341, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:56)", 4342, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:56)", 4343, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:61)", 4344, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:66)", 4345, "Numerical");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:72)", 4346, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:79)", 4347, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:91)", 4348, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:98)", 4349, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:106)", 4350, "Boolean");
        org.broadleafcommerce.common.persistence.EntityConfiguration.__L4351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/EntityConfiguration.java:114)", 4351, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.EntityConfiguration.initPerturbationLocation0();
    }
}

