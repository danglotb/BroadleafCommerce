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


public abstract class AbstractRemoveBeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor , org.springframework.context.ApplicationContextAware {
    protected java.lang.String beanRef;

    protected java.lang.String targetRef;

    protected java.lang.String mapKey;

    protected java.lang.String mapKeyRef;

    protected org.springframework.context.ApplicationContext applicationContext;

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        this.applicationContext = applicationContext;
    }

    @java.lang.Override
    public java.lang.Object postProcessAfterInitialization(java.lang.Object bean, java.lang.String beanName) throws org.springframework.beans.BeansException {
        return bean;
    }

    @java.lang.Override
    public java.lang.Object postProcessBeforeInitialization(java.lang.Object bean, java.lang.String beanName) throws org.springframework.beans.BeansException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1564, beanName.equals(targetRef))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1567, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1565, (bean instanceof org.springframework.beans.factory.config.ListFactoryBean))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1566, (bean instanceof java.util.List)))))) {
                java.lang.Object beanToRemove = applicationContext.getBean(beanRef);
                try {
                    java.util.List sourceList;
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1568, (bean instanceof org.springframework.beans.factory.config.ListFactoryBean))) {
                        java.lang.reflect.Field field = org.springframework.beans.factory.config.ListFactoryBean.class.getDeclaredField("sourceList");
                        field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1569, true));
                        sourceList = ((java.util.List) (field.get(bean)));
                    }else {
                        sourceList = ((java.util.List) (bean));
                    }
                    java.util.Iterator itr = sourceList.iterator();
                    while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1570, itr.hasNext())) {
                        java.lang.Object member = itr.next();
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1571, member.equals(beanToRemove))) {
                            itr.remove();
                        }
                    } 
                } catch (java.lang.Exception e) {
                    throw new org.springframework.beans.factory.BeanCreationException(e.getMessage());
                }
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1574, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1572, (bean instanceof org.springframework.beans.factory.config.SetFactoryBean))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1573, (bean instanceof java.util.Set)))))) {
                    java.lang.Object beanToRemove = applicationContext.getBean(beanRef);
                    try {
                        java.util.Set sourceSet;
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1575, (bean instanceof org.springframework.beans.factory.config.SetFactoryBean))) {
                            java.lang.reflect.Field field = org.springframework.beans.factory.config.SetFactoryBean.class.getDeclaredField("sourceSet");
                            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1576, true));
                            sourceSet = ((java.util.Set) (field.get(bean)));
                        }else {
                            sourceSet = ((java.util.Set) (bean));
                        }
                        java.util.List tempList = new java.util.ArrayList(sourceSet);
                        java.util.Iterator itr = tempList.iterator();
                        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1577, itr.hasNext())) {
                            java.lang.Object member = itr.next();
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1578, member.equals(beanToRemove))) {
                                itr.remove();
                            }
                        } 
                        sourceSet.clear();
                        sourceSet.addAll(tempList);
                    } catch (java.lang.Exception e) {
                        throw new org.springframework.beans.factory.BeanCreationException(e.getMessage());
                    }
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1581, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1579, (bean instanceof org.springframework.beans.factory.config.MapFactoryBean))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1580, (bean instanceof java.util.Map)))))) {
                        try {
                            java.util.Map sourceMap;
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1582, (bean instanceof org.springframework.beans.factory.config.MapFactoryBean))) {
                                java.lang.reflect.Field field = org.springframework.beans.factory.config.MapFactoryBean.class.getDeclaredField("sourceMap");
                                field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1583, true));
                                sourceMap = ((java.util.Map) (field.get(bean)));
                            }else {
                                sourceMap = ((java.util.Map) (bean));
                            }
                            java.lang.Object key;
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1584, ((mapKey) != null))) {
                                key = mapKey;
                            }else {
                                key = applicationContext.getBean(mapKeyRef);
                            }
                            java.util.Map referenceMap = new java.util.LinkedHashMap(sourceMap);
                            for (java.lang.Object sourceKey : referenceMap.keySet()) {
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1585, sourceKey.equals(key))) {
                                    sourceMap.remove(key);
                                }
                            }
                        } catch (java.lang.Exception e) {
                            throw new org.springframework.beans.factory.BeanCreationException(e.getMessage());
                        }
                    }else {
                        throw new java.lang.IllegalArgumentException((((("Bean (" + beanName) + ") is specified as a merge target, ") + "but is not") + " of type ListFactoryBean, SetFactoryBean or MapFactoryBean"));
                    }


        }
        return bean;
    }

    public java.lang.String getBeanRef() {
        return beanRef;
    }

    public void setBeanRef(java.lang.String beanRef) {
        this.beanRef = beanRef;
    }

    public java.lang.String getTargetRef() {
        return targetRef;
    }

    public void setTargetRef(java.lang.String targetRef) {
        this.targetRef = targetRef;
    }

    public java.lang.String getMapKey() {
        return mapKey;
    }

    public void setMapKey(java.lang.String mapKey) {
        this.mapKey = mapKey;
    }

    public java.lang.String getMapKeyRef() {
        return mapKeyRef;
    }

    public void setMapKeyRef(java.lang.String mapKeyRef) {
        this.mapKeyRef = mapKeyRef;
    }

    public static perturbation.location.PerturbationLocation __L1564;

    public static perturbation.location.PerturbationLocation __L1565;

    public static perturbation.location.PerturbationLocation __L1566;

    public static perturbation.location.PerturbationLocation __L1567;

    public static perturbation.location.PerturbationLocation __L1568;

    public static perturbation.location.PerturbationLocation __L1569;

    public static perturbation.location.PerturbationLocation __L1570;

    public static perturbation.location.PerturbationLocation __L1571;

    public static perturbation.location.PerturbationLocation __L1572;

    public static perturbation.location.PerturbationLocation __L1573;

    public static perturbation.location.PerturbationLocation __L1574;

    public static perturbation.location.PerturbationLocation __L1575;

    public static perturbation.location.PerturbationLocation __L1576;

    public static perturbation.location.PerturbationLocation __L1577;

    public static perturbation.location.PerturbationLocation __L1578;

    public static perturbation.location.PerturbationLocation __L1579;

    public static perturbation.location.PerturbationLocation __L1580;

    public static perturbation.location.PerturbationLocation __L1581;

    public static perturbation.location.PerturbationLocation __L1582;

    public static perturbation.location.PerturbationLocation __L1583;

    public static perturbation.location.PerturbationLocation __L1584;

    public static perturbation.location.PerturbationLocation __L1585;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:84)", 1564, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:85)", 1565, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:85)", 1566, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:85)", 1567, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:89)", 1568, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:91)", 1569, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:97)", 1570, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:99)", 1571, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:106)", 1572, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:106)", 1573, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:106)", 1574, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:110)", 1575, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:112)", 1576, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:119)", 1577, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:121)", 1578, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:130)", 1579, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:130)", 1580, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:130)", 1581, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:133)", 1582, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:135)", 1583, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:141)", 1584, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.__L1585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractRemoveBeanPostProcessor.java:148)", 1585, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.AbstractRemoveBeanPostProcessor.initPerturbationLocation0();
    }
}

