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


public abstract class AbstractMergeBeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor , org.springframework.context.ApplicationContextAware {
    public static class BeanPackage {
        protected java.lang.String sourceRef;

        protected java.lang.String targetRef;

        protected org.broadleafcommerce.common.extensibility.context.merge.Placement placement = org.broadleafcommerce.common.extensibility.context.merge.Placement.APPEND;

        protected int position;

        protected org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider statusProvider;

        protected boolean bySource = false;

        public java.lang.String getSourceRef() {
            return sourceRef;
        }

        public void setSourceRef(java.lang.String sourceRef) {
            this.sourceRef = sourceRef;
        }

        public java.lang.String getTargetRef() {
            return targetRef;
        }

        public void setTargetRef(java.lang.String targetRef) {
            this.targetRef = targetRef;
        }

        public org.broadleafcommerce.common.extensibility.context.merge.Placement getPlacement() {
            return placement;
        }

        public void setPlacement(org.broadleafcommerce.common.extensibility.context.merge.Placement placement) {
            this.placement = placement;
        }

        public int getPosition() {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage.__L1518, position);
        }

        public void setPosition(int position) {
            this.position = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage.__L1519, position);
        }

        public org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider getStatusProvider() {
            return statusProvider;
        }

        public void setStatusProvider(org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider statusProvider) {
            this.statusProvider = statusProvider;
        }

        public static perturbation.location.PerturbationLocation __L1518;

        public static perturbation.location.PerturbationLocation __L1519;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage.__L1518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:114)", 1518, "Numerical");
            org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage.__L1519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:118)", 1519, "Numerical");
        }

        static {
            org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage.initPerturbationLocation0();
        }
    }

    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.class);

    protected org.springframework.context.ApplicationContext applicationContext;

    protected org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage defaultBeanPackage = new org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage();

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
        return processPackage(defaultBeanPackage, bean, beanName);
    }

    protected org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage constructBeanPackage(java.lang.String beanName, java.util.Map<java.lang.String, java.lang.Object> methodAnnotationAttributes) {
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage beanPackage = new org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage();
        beanPackage.setSourceRef(beanName);
        beanPackage.setTargetRef(((java.lang.String) (methodAnnotationAttributes.get("targetRef"))));
        beanPackage.setPlacement(((org.broadleafcommerce.common.extensibility.context.merge.Placement) (methodAnnotationAttributes.get("placement"))));
        beanPackage.setPosition(((java.lang.Integer) (methodAnnotationAttributes.get("position"))));
        java.lang.Class<org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider> clazz = ((java.lang.Class<org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider>) (methodAnnotationAttributes.get("statusProvider")));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1520, ((org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider.class) != clazz))) {
            try {
                beanPackage.setStatusProvider(clazz.newInstance());
            } catch (java.lang.InstantiationException e) {
                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
            } catch (java.lang.IllegalAccessException e) {
                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
            }
        }
        return beanPackage;
    }

    protected java.lang.Object processPackage(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage beanPackage, java.lang.Object bean, java.lang.String beanName) {
        java.lang.String sourceRef = beanPackage.getSourceRef();
        java.lang.String targetRef = beanPackage.getTargetRef();
        org.broadleafcommerce.common.extensibility.context.merge.Placement placement = beanPackage.getPlacement();
        int position = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1521, beanPackage.getPosition());
        org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider statusProvider = beanPackage.getStatusProvider();
        java.lang.Object sourceItem = null;
        java.lang.Object targetItem = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1522, beanName.equals(targetRef))) {
            targetItem = bean;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1524, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1523, org.apache.commons.lang3.StringUtils.isEmpty(sourceRef)))))) {
                sourceItem = applicationContext.getBean(sourceRef);
            }else {
                throw new java.lang.IllegalArgumentException("Must declare an source reference value. See #setCollectionRef()");
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1527, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1525, (sourceItem != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1526, (targetItem != null)))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1531, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1528, (statusProvider != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1530, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1529, statusProvider.isProcessingEnabled(targetItem, beanName, applicationContext))))))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1532, org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.LOG.isTraceEnabled())) {
                    org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.LOG.trace(java.lang.String.format(("Not performing post-processing on targetRef [%s] because the registered " + "status provider [%s] returned false"), targetRef, statusProvider.getClass().getSimpleName()));
                }
                return bean;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1535, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1533, (targetItem instanceof org.springframework.beans.factory.config.ListFactoryBean))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1534, (targetItem instanceof java.util.List)))))) {
                try {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1536, (sourceItem instanceof java.util.List))) {
                        addListToList(targetItem, sourceItem, placement, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1537, position));
                    }else {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1538, (sourceItem instanceof java.util.Collection))) {
                            throw new java.lang.IllegalArgumentException(java.lang.String.format(("Attempting to merge a collection of type " + ("%s into a target list. Only source collections of type ListFactoryBean or List " + "may be used.")), sourceItem.getClass().getName()));
                        }
                        addItemToList(targetItem, sourceItem, placement, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1539, position));
                    }
                } catch (java.lang.Exception e) {
                    throw new org.springframework.beans.factory.BeanCreationException(e.getMessage());
                }
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1542, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1540, (targetItem instanceof org.springframework.beans.factory.config.SetFactoryBean))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1541, (targetItem instanceof java.util.Set)))))) {
                    try {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1543, (sourceItem instanceof java.util.Set))) {
                            addSetToSet(targetItem, sourceItem, placement, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1544, position));
                        }else {
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1545, (sourceItem instanceof java.util.Collection))) {
                                throw new java.lang.IllegalArgumentException(java.lang.String.format(("Attempting to merge a collection of type " + ("%s into a target set. Only source collections of type SetFactoryBean or Set " + "may be used.")), sourceItem.getClass().getName()));
                            }
                            addItemToSet(targetItem, sourceItem, placement, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1546, position));
                        }
                    } catch (java.lang.Exception e) {
                        throw new org.springframework.beans.factory.BeanCreationException(e.getMessage());
                    }
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1549, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1547, (targetItem instanceof org.springframework.beans.factory.config.MapFactoryBean))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1548, (targetItem instanceof java.util.Map)))))) {
                        try {
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1550, (sourceItem instanceof java.util.Map))) {
                                addMapToMap(targetItem, ((java.util.Map) (sourceItem)), placement, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1551, position));
                            }else {
                                throw new java.lang.IllegalArgumentException(java.lang.String.format(("Attempting to merge an item of type " + ("%s into a target map. Only source items of type MapFactoryBean or Map " + "may be used.")), sourceItem.getClass().getName()));
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

    protected java.lang.Object processPackage(java.util.Map<java.lang.String, java.lang.Object> methodAnnotationAttributes, java.lang.Object bean, java.lang.String beanName) {
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage beanPackage = constructBeanPackage(beanName, methodAnnotationAttributes);
        return processPackage(beanPackage, bean, beanName);
    }

    protected void addMapToMap(java.lang.Object bean, java.util.Map sourceItem, org.broadleafcommerce.common.extensibility.context.merge.Placement placement, int position) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        java.util.Map sourcerMap = sourceItem;
        java.util.Map targetMap;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1552, (bean instanceof org.springframework.beans.factory.config.MapFactoryBean))) {
            java.lang.reflect.Field field = org.springframework.beans.factory.config.MapFactoryBean.class.getDeclaredField("sourceMap");
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1553, true));
            targetMap = ((java.util.Map) (field.get(bean)));
        }else {
            targetMap = ((java.util.Map) (bean));
        }
        java.util.LinkedHashMap tempMap = new java.util.LinkedHashMap();
        switch (placement) {
            case APPEND :
                tempMap.putAll(targetMap);
                tempMap.putAll(sourcerMap);
                break;
            case PREPEND :
                tempMap.putAll(sourcerMap);
                tempMap.putAll(targetMap);
                break;
            case SPECIFIC :
                boolean added = false;
                int j = 0;
                for (java.lang.Object key : targetMap.keySet()) {
                    if (j == position) {
                        tempMap.putAll(sourcerMap);
                        added = true;
                    }
                    tempMap.put(key, targetMap.get(key));
                    j++;
                }
                if (!added) {
                    tempMap.putAll(sourcerMap);
                }
                break;
        }
        targetMap.clear();
        targetMap.putAll(tempMap);
    }

    protected void addSetToSet(java.lang.Object bean, java.lang.Object sourceItem, org.broadleafcommerce.common.extensibility.context.merge.Placement placement, int position) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        java.util.Set sourceSet = ((java.util.Set) (sourceItem));
        java.util.Set targetSet;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1554, (bean instanceof org.springframework.beans.factory.config.SetFactoryBean))) {
            java.lang.reflect.Field field = org.springframework.beans.factory.config.SetFactoryBean.class.getDeclaredField("sourceSet");
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1555, true));
            targetSet = ((java.util.Set) (field.get(bean)));
        }else {
            targetSet = ((java.util.Set) (bean));
        }
        java.util.List tempList = new java.util.ArrayList(targetSet);
        switch (placement) {
            case APPEND :
                tempList.addAll(sourceSet);
                break;
            case PREPEND :
                tempList.addAll(0, sourceSet);
                break;
            case SPECIFIC :
                tempList.addAll(position, sourceSet);
                break;
        }
        targetSet.clear();
        targetSet.addAll(tempList);
    }

    protected void addItemToSet(java.lang.Object bean, java.lang.Object sourceItem, org.broadleafcommerce.common.extensibility.context.merge.Placement placement, int position) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        java.util.Set targetSet;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1556, (bean instanceof org.springframework.beans.factory.config.SetFactoryBean))) {
            java.lang.reflect.Field field = org.springframework.beans.factory.config.SetFactoryBean.class.getDeclaredField("sourceSet");
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1557, true));
            targetSet = ((java.util.Set) (field.get(bean)));
        }else {
            targetSet = ((java.util.Set) (bean));
        }
        java.util.List tempList = new java.util.ArrayList(targetSet);
        switch (placement) {
            case APPEND :
                tempList.add(sourceItem);
                break;
            case PREPEND :
                tempList.add(0, sourceItem);
                break;
            case SPECIFIC :
                tempList.add(position, sourceItem);
                break;
        }
        targetSet.clear();
        targetSet.addAll(tempList);
    }

    protected void addListToList(java.lang.Object bean, java.lang.Object sourceItem, org.broadleafcommerce.common.extensibility.context.merge.Placement placement, int position) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        java.util.List sourceList = ((java.util.List) (sourceItem));
        java.util.List targetList;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1558, (bean instanceof org.springframework.beans.factory.config.ListFactoryBean))) {
            java.lang.reflect.Field field = org.springframework.beans.factory.config.ListFactoryBean.class.getDeclaredField("sourceList");
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1559, true));
            targetList = ((java.util.List) (field.get(bean)));
        }else {
            targetList = ((java.util.List) (bean));
        }
        switch (placement) {
            case APPEND :
                targetList.addAll(sourceList);
                break;
            case PREPEND :
                targetList.addAll(0, sourceList);
                break;
            case SPECIFIC :
                targetList.addAll(position, sourceList);
                break;
        }
    }

    protected void addItemToList(java.lang.Object bean, java.lang.Object sourceItem, org.broadleafcommerce.common.extensibility.context.merge.Placement placement, int position) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        java.util.List targetList;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1560, (bean instanceof org.springframework.beans.factory.config.ListFactoryBean))) {
            java.lang.reflect.Field field = org.springframework.beans.factory.config.ListFactoryBean.class.getDeclaredField("sourceList");
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1561, true));
            targetList = ((java.util.List) (field.get(bean)));
        }else {
            targetList = ((java.util.List) (bean));
        }
        switch (placement) {
            case APPEND :
                targetList.add(sourceItem);
                break;
            case PREPEND :
                targetList.add(0, sourceItem);
                break;
            case SPECIFIC :
                targetList.add(position, sourceItem);
                break;
        }
    }

    @java.lang.Deprecated
    public java.lang.String getCollectionRef() {
        return defaultBeanPackage.getSourceRef();
    }

    @java.lang.Deprecated
    public void setCollectionRef(java.lang.String collectionRef) {
        defaultBeanPackage.setSourceRef(collectionRef);
    }

    public java.lang.String getSourceRef() {
        return defaultBeanPackage.getSourceRef();
    }

    public void setSourceRef(java.lang.String sourceRef) {
        defaultBeanPackage.setSourceRef(sourceRef);
    }

    public java.lang.String getTargetRef() {
        return defaultBeanPackage.getTargetRef();
    }

    public void setTargetRef(java.lang.String targetRef) {
        defaultBeanPackage.setTargetRef(targetRef);
    }

    public org.broadleafcommerce.common.extensibility.context.merge.Placement getPlacement() {
        return defaultBeanPackage.getPlacement();
    }

    public void setPlacement(org.broadleafcommerce.common.extensibility.context.merge.Placement placement) {
        defaultBeanPackage.setPlacement(placement);
    }

    public int getPosition() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1562, defaultBeanPackage.getPosition());
    }

    public void setPosition(int position) {
        defaultBeanPackage.setPosition(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1563, position));
    }

    public org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider getStatusProvider() {
        return defaultBeanPackage.getStatusProvider();
    }

    public void setStatusProvider(org.broadleafcommerce.common.extensibility.context.merge.MergeBeanStatusProvider statusProvider) {
        defaultBeanPackage.setStatusProvider(statusProvider);
    }

    public static perturbation.location.PerturbationLocation __L1520;

    public static perturbation.location.PerturbationLocation __L1521;

    public static perturbation.location.PerturbationLocation __L1522;

    public static perturbation.location.PerturbationLocation __L1523;

    public static perturbation.location.PerturbationLocation __L1524;

    public static perturbation.location.PerturbationLocation __L1525;

    public static perturbation.location.PerturbationLocation __L1526;

    public static perturbation.location.PerturbationLocation __L1527;

    public static perturbation.location.PerturbationLocation __L1528;

    public static perturbation.location.PerturbationLocation __L1529;

    public static perturbation.location.PerturbationLocation __L1530;

    public static perturbation.location.PerturbationLocation __L1531;

    public static perturbation.location.PerturbationLocation __L1532;

    public static perturbation.location.PerturbationLocation __L1533;

    public static perturbation.location.PerturbationLocation __L1534;

    public static perturbation.location.PerturbationLocation __L1535;

    public static perturbation.location.PerturbationLocation __L1536;

    public static perturbation.location.PerturbationLocation __L1537;

    public static perturbation.location.PerturbationLocation __L1538;

    public static perturbation.location.PerturbationLocation __L1539;

    public static perturbation.location.PerturbationLocation __L1540;

    public static perturbation.location.PerturbationLocation __L1541;

    public static perturbation.location.PerturbationLocation __L1542;

    public static perturbation.location.PerturbationLocation __L1543;

    public static perturbation.location.PerturbationLocation __L1544;

    public static perturbation.location.PerturbationLocation __L1545;

    public static perturbation.location.PerturbationLocation __L1546;

    public static perturbation.location.PerturbationLocation __L1547;

    public static perturbation.location.PerturbationLocation __L1548;

    public static perturbation.location.PerturbationLocation __L1549;

    public static perturbation.location.PerturbationLocation __L1550;

    public static perturbation.location.PerturbationLocation __L1551;

    public static perturbation.location.PerturbationLocation __L1552;

    public static perturbation.location.PerturbationLocation __L1553;

    public static perturbation.location.PerturbationLocation __L1554;

    public static perturbation.location.PerturbationLocation __L1555;

    public static perturbation.location.PerturbationLocation __L1556;

    public static perturbation.location.PerturbationLocation __L1557;

    public static perturbation.location.PerturbationLocation __L1558;

    public static perturbation.location.PerturbationLocation __L1559;

    public static perturbation.location.PerturbationLocation __L1560;

    public static perturbation.location.PerturbationLocation __L1561;

    public static perturbation.location.PerturbationLocation __L1562;

    public static perturbation.location.PerturbationLocation __L1563;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:158)", 1520, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:174)", 1521, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:178)", 1522, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:180)", 1523, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:180)", 1524, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:186)", 1525, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:186)", 1526, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:186)", 1527, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:187)", 1528, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:187)", 1529, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:187)", 1530, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:187)", 1531, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:188)", 1532, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:196)", 1533, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:196)", 1534, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:196)", 1535, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:198)", 1536, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:199)", 1537, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:201)", 1538, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:206)", 1539, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:211)", 1540, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:211)", 1541, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:211)", 1542, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:213)", 1543, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:214)", 1544, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:216)", 1545, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:221)", 1546, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:226)", 1547, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:226)", 1548, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:226)", 1549, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:228)", 1550, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:229)", 1551, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:256)", 1552, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:258)", 1553, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:296)", 1554, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:298)", 1555, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:321)", 1556, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:323)", 1557, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:347)", 1558, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:349)", 1559, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:369)", 1560, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:371)", 1561, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:474)", 1562, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.__L1563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/AbstractMergeBeanPostProcessor.java:484)", 1563, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.initPerturbationLocation0();
    }
}

