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


public class MergePersistenceUnitManager extends org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.class);

    protected java.util.HashMap<java.lang.String, javax.persistence.spi.PersistenceUnitInfo> mergedPus = new java.util.HashMap<>();

    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer> classTransformers = new java.util.ArrayList<>();

    @javax.annotation.Resource(name = "blMergedPersistenceXmlLocations")
    protected java.util.Set<java.lang.String> mergedPersistenceXmlLocations;

    @javax.annotation.Resource(name = "blMergedDataSources")
    protected java.util.Map<java.lang.String, javax.sql.DataSource> mergedDataSources;

    @javax.annotation.Resource(name = "blMergedClassTransformers")
    protected java.util.Set<org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer> mergedClassTransformers;

    @javax.annotation.Resource(name = "blEntityMarkerClassTransformer")
    protected org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer entityMarkerClassTransformer;

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier("blAutoDDLStatusExporter")
    protected org.springframework.jmx.export.MBeanExporter mBeanExporter;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.context.ApplicationContext applicationContext;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.core.env.Environment environment;

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.QueryConfiguration> queryConfigurations = new java.util.ArrayList<>();

    protected static boolean transformed = false;

    @java.lang.Override
    protected boolean isPersistenceUnitOverrideAllowed() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2260, true);
    }

    @javax.annotation.PostConstruct
    public void configureMergedItems() {
        java.lang.String[] tempLocations;
        try {
            java.lang.reflect.Field persistenceXmlLocations = org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager.class.getDeclaredField("persistenceXmlLocations");
            persistenceXmlLocations.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2261, true));
            tempLocations = ((java.lang.String[]) (persistenceXmlLocations.get(this)));
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
        for (java.lang.String legacyLocation : tempLocations) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2263, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2262, legacyLocation.endsWith("/persistence.xml")))))) {
                mergedPersistenceXmlLocations.add(legacyLocation);
            }
        }
        setPersistenceXmlLocations(mergedPersistenceXmlLocations.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2264, mergedPersistenceXmlLocations.size())]));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2266, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2265, mergedDataSources.isEmpty()))))) {
            setDataSources(mergedDataSources);
        }
    }

    @javax.annotation.PostConstruct
    public void configureClassTransformers() throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        classTransformers.addAll(mergedClassTransformers);
    }

    protected org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo getMergedUnit(java.lang.String persistenceUnitName, org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo newPU) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2268, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2267, mergedPus.containsKey(persistenceUnitName)))))) {
            mergedPus.put(persistenceUnitName, newPU);
        }
        return ((org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo) (mergedPus.get(persistenceUnitName)));
    }

    @java.lang.Override
    @java.lang.SuppressWarnings({ "unchecked", "ToArrayCallWithZeroLengthArrayArgument" })
    public void preparePersistenceUnitInfos() {
        super.preparePersistenceUnitInfos();
        try {
            boolean weaverRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2269, addTransformersToPersistenceUnits());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2273, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2270, weaverRegistered)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2272, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2271, org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.transformed)))))))) {
                exceptionIfEntityMarkerNotFound();
                triggerClassLoadForManagedClasses();
                java.util.List<java.lang.String> nonTransformedClasses = detectNonTransformedClasses();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2274, org.apache.commons.collections4.CollectionUtils.isNotEmpty(nonTransformedClasses))) {
                    exceptionWithNonTransformed(nonTransformedClasses);
                }
                org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.transformed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2275, true);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2276, org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.transformed)) {
                org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.LOG.info("Did not recycle through class transformation since this has already occurred");
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    protected boolean addTransformersToPersistenceUnits() throws java.lang.Exception {
        boolean weaverRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2277, true);
        for (javax.persistence.spi.PersistenceUnitInfo pui : mergedPus.values()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2280, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2278, pui.getProperties().containsKey(org.hibernate.ejb.AvailableSettings.USE_CLASS_ENHANCER))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2279, "true".equalsIgnoreCase(pui.getProperties().getProperty(org.hibernate.ejb.AvailableSettings.USE_CLASS_ENHANCER))))))) {
                pui.addTransformer(new org.hibernate.ejb.instrument.InterceptFieldClassFileTransformer(pui.getManagedClassNames()));
            }
            for (org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer transformer : classTransformers) {
                try {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2284, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2282, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2281, (transformer instanceof org.broadleafcommerce.common.extensibility.jpa.copy.NullClassTransformer)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2283, pui.getPersistenceUnitName().equals("blPU")))))) {
                        pui.addTransformer(transformer);
                    }
                } catch (java.lang.Exception e) {
                    weaverRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2285, handleClassTransformerRegistrationProblem(transformer, e));
                }
            }
        }
        weaverRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2287, addNamedQueriesToPersistenceUnits(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2286, weaverRegistered)));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2288, weaverRegistered);
    }

    protected boolean addNamedQueriesToPersistenceUnits(boolean weaverRegistered) throws java.lang.Exception {
        for (javax.persistence.spi.PersistenceUnitInfo pui : mergedPus.values()) {
            java.util.List<javax.persistence.NamedQuery> namedQueries = new java.util.ArrayList<>();
            java.util.List<javax.persistence.NamedNativeQuery> nativeQueries = new java.util.ArrayList<>();
            for (org.broadleafcommerce.common.extensibility.jpa.QueryConfiguration config : queryConfigurations) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2289, pui.getPersistenceUnitName().equals(config.getPersistenceUnit()))) {
                    javax.persistence.NamedQueries annotation = config.getClass().getAnnotation(javax.persistence.NamedQueries.class);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2290, (annotation != null))) {
                        namedQueries.addAll(java.util.Arrays.asList(annotation.value()));
                    }
                    javax.persistence.NamedNativeQueries annotation2 = config.getClass().getAnnotation(javax.persistence.NamedNativeQueries.class);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2291, (annotation2 != null))) {
                        nativeQueries.addAll(java.util.Arrays.asList(annotation2.value()));
                    }
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2296, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2293, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2292, namedQueries.isEmpty()))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2295, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2294, nativeQueries.isEmpty())))))))) {
                org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer transformer = new org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer(namedQueries, nativeQueries, pui.getManagedClassNames());
                try {
                    pui.addTransformer(transformer);
                } catch (java.lang.Exception e) {
                    weaverRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2297, handleClassTransformerRegistrationProblem(transformer, e));
                }
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2298, weaverRegistered);
    }

    protected boolean handleClassTransformerRegistrationProblem(org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer transformer, java.lang.Exception e) throws java.lang.Exception {
        boolean weaverRegistered;
        java.lang.Exception refined = org.broadleafcommerce.common.exception.ExceptionHelper.refineException(java.lang.IllegalStateException.class, java.lang.RuntimeException.class, e);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2299, (refined instanceof java.lang.IllegalStateException))) {
            org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.LOG.warn((((("A BroadleafClassTransformer is configured for this persistence unit, but Spring " + ("reported a problem (likely that a LoadTimeWeaver is not registered). As a result, " + "the Broadleaf Commerce ClassTransformer (")) + (transformer.getClass().getName())) + ") is ") + "not being registered with the persistence unit. To resove this add a -javaagent:/path/to/spring-instrument.jar to the JVM args of the server"));
            weaverRegistered = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2300, false);
        }else {
            throw refined;
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2301, weaverRegistered);
    }

    protected void exceptionWithNonTransformed(java.util.List<java.lang.String> nonTransformedClasses) throws java.lang.ClassNotFoundException {
        exceptionIfRootBeanDefinition(nonTransformedClasses);
        boolean devtoolsFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2302, detectSpringBootDevtools());
        java.lang.String msg = (((((((("The classes\n" + (java.util.Arrays.toString(nonTransformedClasses.toArray()))) + "\nare managed classes within the MergePersistenceUnitManager") + "\nbut were not detected as being transformed by the EntityMarkerClassTransformer. There can be multiple causes for this:") + "\n1. Session persistence is enabled in your servlet container (like Tomcat) and an entity object has been loaded by the container before") + " being loaded by the application\'s classloader. Ensure that session persistence is disabled; in Tomcat ensure that a <Manager pathname=\"\" /> element exists in your context.xml.") + "\n2. You are inadvertently using class scanning to find a ServletContainerInitializer class, and your servlet container is loading all classes before transformers have been registered.") + " If you are using a web.xml, ensure that there is an <absolute-ordering /> element somewhere in that file. If you are not using a web.xml and are using Spring Boot,") + " then you likely need to add one. See https://www.broadleafcommerce.com/docs/core/5.2/broadleaf-concepts/key-aspects-and-configuration/app-server-configuration/tomcat for the example web.xml") + "\n3. The classes are being used as apart of an @Bean method or in some other runtime capacity that is initialized prior to persistence manager startup";
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2303, devtoolsFound)) {
            msg += "\n4. Spring Boot Devtools is on the classpath and the Restarter capabilities are interfering. Spring Boot Devtools restarter functionality works by creating multiple ClassLoaders" + (((" and there is a check in InstrumentationLoadTimeWeaver to ensure that the ClassLoader for that class is the same as the ClassLoader for the entity class before" + " performing transformation. These ClassLoaders are different with Spring Devtools. You can attempt to disable just the Devtools restarter functionality while still utilizing") + " the other Devtools features by setting a JVM argument for spring.devtools.restart.enabled=false. See http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-restart-disable") + "\n for more information");
        }
        throw new java.lang.IllegalStateException(msg);
    }

    protected boolean detectSpringBootDevtools() {
        java.lang.String devtoolsClassname = "org.springframework.boot.devtools.restart.Restarter";
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2304, org.springframework.util.ClassUtils.isPresent(devtoolsClassname, getClass().getClassLoader()));
    }

    protected void exceptionIfRootBeanDefinition(java.util.List<java.lang.String> nonTransformedClasses) throws java.lang.ClassNotFoundException {
        java.util.List<org.springframework.beans.factory.config.BeanDefinition> incorrectEntityBeanDefs = new java.util.ArrayList<>();
        for (java.lang.String className : nonTransformedClasses) {
            java.lang.String[] beanIds = applicationContext.getBeanNamesForType(java.lang.Class.forName(className));
            for (java.lang.String beanId : beanIds) {
                incorrectEntityBeanDefs.add(((org.springframework.beans.factory.support.BeanDefinitionRegistry) (applicationContext.getAutowireCapableBeanFactory())).getBeanDefinition(beanId));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2305, org.apache.commons.collections4.CollectionUtils.isNotEmpty(incorrectEntityBeanDefs))) {
            java.lang.String msg = ("The following bean definitions for entity classes were detected in the Spring root ApplicationContext which prevents them from being correctly transformed. Ensure that bean definitions" + ((" for entity classes used for overriding are only in applicationContext-entity.xml-like files configured with the blMergedEntityContexts bean and do not undergo component scanning or any other" + " Spring ApplicationContext configuration.") + "\n")) + (java.util.Arrays.toString(incorrectEntityBeanDefs.toArray()));
            throw new java.lang.IllegalStateException(msg);
        }
    }

    protected java.util.List<java.lang.String> detectNonTransformedClasses() {
        java.util.List<java.lang.String> nonTransformedClasses = new java.util.ArrayList<>();
        for (javax.persistence.spi.PersistenceUnitInfo pui : mergedPus.values()) {
            for (java.lang.String managedClassName : pui.getManagedClassNames()) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2306, entityMarkerClassTransformer.getTransformedNonEntityClassNames().contains(managedClassName))) {
                    org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.LOG.warn(((((((("The class " + managedClassName) + " is marked as a managed class within the MergePersistenceUnitManager") + " but is not annotated with @Entity, @MappedSuperclass or @Embeddable.") + " This class is still referenced in a persistence.xml and is being transformed by") + " PersistenceUnit ClassTransformers which may result in problems downstream") + " and represents a potential misconfiguration. This class should be removed from") + " your persistence.xml"));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2308, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2307, entityMarkerClassTransformer.getTransformedEntityClassNames().contains(managedClassName)))))) {
                        nonTransformedClasses.add(managedClassName);
                    }

            }
        }
        return nonTransformedClasses;
    }

    protected java.util.List<java.lang.String> triggerClassLoadForManagedClasses() throws java.lang.ClassNotFoundException {
        java.util.List<java.lang.String> managedClassNames = new java.util.ArrayList<>();
        for (javax.persistence.spi.PersistenceUnitInfo pui : mergedPus.values()) {
            for (java.lang.String managedClassName : pui.getManagedClassNames()) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2310, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2309, managedClassNames.contains(managedClassName)))))) {
                    java.lang.Class.forName(managedClassName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2311, true), getClass().getClassLoader());
                    managedClassNames.add(managedClassName);
                }
            }
        }
        return managedClassNames;
    }

    protected void exceptionIfEntityMarkerNotFound() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2312, org.apache.commons.collections4.CollectionUtils.isNotEmpty(mergedClassTransformers))) {
            boolean foundEntityMarkerTransformer = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2314, ((org.apache.commons.collections4.IterableUtils.find(mergedClassTransformers, new org.apache.commons.collections4.Predicate<org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer>() {
                @java.lang.Override
                public boolean evaluate(org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer object) {
                    return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2313, org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.class.isAssignableFrom(object.getClass()));
                }
            })) != null));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2316, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2315, foundEntityMarkerTransformer))))) {
                org.springframework.beans.factory.config.BeanDefinition transformersBeanDef = ((org.springframework.beans.factory.support.BeanDefinitionRegistry) (applicationContext.getAutowireCapableBeanFactory())).getBeanDefinition("blMergedClassTransformers");
                java.lang.String msg = (((("The EntityMarkerClassTransformer was not detected as registered in the the list of blMergedClassTransformers. This is" + (" usually caused the blMergedClassTransformers being overridden in a different configuration. Without this transformer Broadleaf" + " is unable to validate whether or not class transformation happened as expected. This bean was registered as ")) + transformersBeanDef) + " but it should have been detected as registerd in bl-common-applicationContext.xml. Change the definition in ") + (transformersBeanDef.getResourceDescription())) + " to instead utilize the EarlyStageMergeBeanPostProcessor in XML or an @Merge(targetRef=\"blMergedClassTransformers\" early = true) in a Java configuration class";
                throw new java.lang.IllegalStateException(msg);
            }
        }
    }

    @java.lang.Override
    protected void postProcessPersistenceUnitInfo(org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo newPU) {
        super.postProcessPersistenceUnitInfo(newPU);
        org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState state = org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.getState();
        java.lang.String persistenceUnitName = newPU.getPersistenceUnitName();
        org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo pui = getMergedUnit(persistenceUnitName, newPU);
        java.util.List<java.lang.String> managedClassNames = newPU.getManagedClassNames();
        for (java.lang.String managedClassName : managedClassNames) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2318, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2317, pui.getManagedClassNames().contains(managedClassName)))))) {
                pui.addManagedClassName(managedClassName);
            }
        }
        java.util.List<java.lang.String> mappingFileNames = newPU.getMappingFileNames();
        for (java.lang.String mappingFileName : mappingFileNames) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2320, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2319, pui.getMappingFileNames().contains(mappingFileName)))))) {
                pui.addMappingFileName(mappingFileName);
            }
        }
        pui.setExcludeUnlistedClasses(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2321, newPU.excludeUnlistedClasses()));
        for (java.net.URL url : newPU.getJarFileUrls()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2326, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2323, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2322, pui.getJarFileUrls().contains(url)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2325, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2324, pui.getPersistenceUnitRootUrl().equals(url))))))))) {
                pui.addJarFileUrl(url);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2327, ((pui.getProperties()) == null))) {
            pui.setProperties(newPU.getProperties());
        }else {
            java.util.Properties props = newPU.getProperties();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2328, (props != null))) {
                for (java.lang.Object key : props.keySet()) {
                    pui.getProperties().put(key, props.get(key));
                    for (org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer transformer : classTransformers) {
                        try {
                            transformer.compileJPAProperties(props, key);
                        } catch (java.lang.Exception e) {
                            throw new java.lang.RuntimeException(e);
                        }
                    }
                }
            }
        }
        disableSchemaCreateIfApplicable(persistenceUnitName, pui);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2332, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2329, (state == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2331, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2330, state.isConfigurationOnly())))))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2333, ((newPU.getJtaDataSource()) != null))) {
                pui.setJtaDataSource(newPU.getJtaDataSource());
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2334, ((newPU.getNonJtaDataSource()) != null))) {
                pui.setNonJtaDataSource(newPU.getNonJtaDataSource());
            }
        }else {
            pui.getProperties().setProperty("hibernate.hbm2ddl.auto", "none");
            pui.getProperties().setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        }
        pui.setTransactionType(newPU.getTransactionType());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2335, ((newPU.getPersistenceProviderClassName()) != null))) {
            pui.setPersistenceProviderClassName(newPU.getPersistenceProviderClassName());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2336, ((newPU.getPersistenceProviderPackageName()) != null))) {
            pui.setPersistenceProviderPackageName(newPU.getPersistenceProviderPackageName());
        }
    }

    @java.lang.Override
    public javax.persistence.spi.PersistenceUnitInfo obtainPersistenceUnitInfo(java.lang.String persistenceUnitName) {
        return mergedPus.get(persistenceUnitName);
    }

    @java.lang.Override
    public javax.persistence.spi.PersistenceUnitInfo obtainDefaultPersistenceUnitInfo() {
        throw new java.lang.IllegalStateException("Default Persistence Unit is not supported. The persistence unit name must be specified at the entity manager factory.");
    }

    public java.util.List<org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer> getClassTransformers() {
        return classTransformers;
    }

    public void setClassTransformers(java.util.List<org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer> classTransformers) {
        this.classTransformers = classTransformers;
    }

    protected void disableSchemaCreateIfApplicable(java.lang.String persistenceUnitName, org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo pui) {
        java.lang.String autoDDLStatus = pui.getProperties().getProperty("hibernate.hbm2ddl.auto");
        boolean isCreate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2341, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2337, (autoDDLStatus != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2340, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2338, autoDDLStatus.equals("create"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2339, autoDDLStatus.equals("create-drop"))))))));
        boolean detectedCreate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2342, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2345, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2343, isCreate)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2344, ((mBeanExporter) != null)))))) {
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2346, mBeanExporter.getServer().isRegistered(javax.management.ObjectName.getInstance("bean:name=autoDDLCreateStatusTestBean")))) {
                    java.lang.Boolean response = ((java.lang.Boolean) (mBeanExporter.getServer().invoke(javax.management.ObjectName.getInstance("bean:name=autoDDLCreateStatusTestBean"), "getStartedWithCreate", new java.lang.Object[]{ persistenceUnitName }, new java.lang.String[]{ java.lang.String.class.getName() })));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2347, (response == null))) {
                        mBeanExporter.getServer().invoke(javax.management.ObjectName.getInstance("bean:name=autoDDLCreateStatusTestBean"), "setStartedWithCreate", new java.lang.Object[]{ persistenceUnitName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2348, true) }, new java.lang.String[]{ java.lang.String.class.getName(), java.lang.Boolean.class.getName() });
                    }else {
                        detectedCreate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2349, true);
                    }
                }
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.LOG.warn("Unable to query the mbean server for previous auto.ddl status", e);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2350, detectedCreate)) {
            pui.getProperties().setProperty("hibernate.hbm2ddl.auto", "none");
        }
    }

    public static perturbation.location.PerturbationLocation __L2260;

    public static perturbation.location.PerturbationLocation __L2261;

    public static perturbation.location.PerturbationLocation __L2262;

    public static perturbation.location.PerturbationLocation __L2263;

    public static perturbation.location.PerturbationLocation __L2264;

    public static perturbation.location.PerturbationLocation __L2265;

    public static perturbation.location.PerturbationLocation __L2266;

    public static perturbation.location.PerturbationLocation __L2267;

    public static perturbation.location.PerturbationLocation __L2268;

    public static perturbation.location.PerturbationLocation __L2269;

    public static perturbation.location.PerturbationLocation __L2270;

    public static perturbation.location.PerturbationLocation __L2271;

    public static perturbation.location.PerturbationLocation __L2272;

    public static perturbation.location.PerturbationLocation __L2273;

    public static perturbation.location.PerturbationLocation __L2274;

    public static perturbation.location.PerturbationLocation __L2275;

    public static perturbation.location.PerturbationLocation __L2276;

    public static perturbation.location.PerturbationLocation __L2277;

    public static perturbation.location.PerturbationLocation __L2278;

    public static perturbation.location.PerturbationLocation __L2279;

    public static perturbation.location.PerturbationLocation __L2280;

    public static perturbation.location.PerturbationLocation __L2281;

    public static perturbation.location.PerturbationLocation __L2282;

    public static perturbation.location.PerturbationLocation __L2283;

    public static perturbation.location.PerturbationLocation __L2284;

    public static perturbation.location.PerturbationLocation __L2285;

    public static perturbation.location.PerturbationLocation __L2286;

    public static perturbation.location.PerturbationLocation __L2287;

    public static perturbation.location.PerturbationLocation __L2288;

    public static perturbation.location.PerturbationLocation __L2289;

    public static perturbation.location.PerturbationLocation __L2290;

    public static perturbation.location.PerturbationLocation __L2291;

    public static perturbation.location.PerturbationLocation __L2292;

    public static perturbation.location.PerturbationLocation __L2293;

    public static perturbation.location.PerturbationLocation __L2294;

    public static perturbation.location.PerturbationLocation __L2295;

    public static perturbation.location.PerturbationLocation __L2296;

    public static perturbation.location.PerturbationLocation __L2297;

    public static perturbation.location.PerturbationLocation __L2298;

    public static perturbation.location.PerturbationLocation __L2299;

    public static perturbation.location.PerturbationLocation __L2300;

    public static perturbation.location.PerturbationLocation __L2301;

    public static perturbation.location.PerturbationLocation __L2302;

    public static perturbation.location.PerturbationLocation __L2303;

    public static perturbation.location.PerturbationLocation __L2304;

    public static perturbation.location.PerturbationLocation __L2305;

    public static perturbation.location.PerturbationLocation __L2306;

    public static perturbation.location.PerturbationLocation __L2307;

    public static perturbation.location.PerturbationLocation __L2308;

    public static perturbation.location.PerturbationLocation __L2309;

    public static perturbation.location.PerturbationLocation __L2310;

    public static perturbation.location.PerturbationLocation __L2311;

    public static perturbation.location.PerturbationLocation __L2312;

    public static perturbation.location.PerturbationLocation __L2313;

    public static perturbation.location.PerturbationLocation __L2314;

    public static perturbation.location.PerturbationLocation __L2315;

    public static perturbation.location.PerturbationLocation __L2316;

    public static perturbation.location.PerturbationLocation __L2317;

    public static perturbation.location.PerturbationLocation __L2318;

    public static perturbation.location.PerturbationLocation __L2319;

    public static perturbation.location.PerturbationLocation __L2320;

    public static perturbation.location.PerturbationLocation __L2321;

    public static perturbation.location.PerturbationLocation __L2322;

    public static perturbation.location.PerturbationLocation __L2323;

    public static perturbation.location.PerturbationLocation __L2324;

    public static perturbation.location.PerturbationLocation __L2325;

    public static perturbation.location.PerturbationLocation __L2326;

    public static perturbation.location.PerturbationLocation __L2327;

    public static perturbation.location.PerturbationLocation __L2328;

    public static perturbation.location.PerturbationLocation __L2329;

    public static perturbation.location.PerturbationLocation __L2330;

    public static perturbation.location.PerturbationLocation __L2331;

    public static perturbation.location.PerturbationLocation __L2332;

    public static perturbation.location.PerturbationLocation __L2333;

    public static perturbation.location.PerturbationLocation __L2334;

    public static perturbation.location.PerturbationLocation __L2335;

    public static perturbation.location.PerturbationLocation __L2336;

    public static perturbation.location.PerturbationLocation __L2337;

    public static perturbation.location.PerturbationLocation __L2338;

    public static perturbation.location.PerturbationLocation __L2339;

    public static perturbation.location.PerturbationLocation __L2340;

    public static perturbation.location.PerturbationLocation __L2341;

    public static perturbation.location.PerturbationLocation __L2342;

    public static perturbation.location.PerturbationLocation __L2343;

    public static perturbation.location.PerturbationLocation __L2344;

    public static perturbation.location.PerturbationLocation __L2345;

    public static perturbation.location.PerturbationLocation __L2346;

    public static perturbation.location.PerturbationLocation __L2347;

    public static perturbation.location.PerturbationLocation __L2348;

    public static perturbation.location.PerturbationLocation __L2349;

    public static perturbation.location.PerturbationLocation __L2350;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:114)", 2260, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:122)", 2261, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:128)", 2262, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:128)", 2263, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:133)", 2264, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:135)", 2265, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:135)", 2266, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:146)", 2267, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:146)", 2268, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:157)", 2269, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:160)", 2270, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:160)", 2271, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:160)", 2272, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:160)", 2273, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:166)", 2274, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:170)", 2275, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:172)", 2276, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:186)", 2277, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:188)", 2278, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:188)", 2279, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:188)", 2280, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:193)", 2281, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:193)", 2282, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:193)", 2283, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:193)", 2284, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:197)", 2285, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:201)", 2286, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:201)", 2287, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:204)", 2288, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:215)", 2289, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:217)", 2290, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:221)", 2291, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:226)", 2292, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:226)", 2293, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:226)", 2294, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:226)", 2295, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:226)", 2296, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:231)", 2297, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:235)", 2298, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:241)", 2299, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:246)", 2300, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:250)", 2301, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:260)", 2302, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:270)", 2303, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:285)", 2304, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:302)", 2305, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:325)", 2306, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:332)", 2307, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:332)", 2308, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:353)", 2309, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:353)", 2310, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:356)", 2311, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:369)", 2312, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:374)", 2313, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:370)", 2314, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:379)", 2315, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:379)", 2316, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:400)", 2317, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:400)", 2318, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:406)", 2319, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:406)", 2320, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:410)", 2321, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:414)", 2322, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:414)", 2323, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:414)", 2324, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:414)", 2325, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:414)", 2326, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:418)", 2327, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:422)", 2328, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:436)", 2329, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:436)", 2330, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:436)", 2331, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:436)", 2332, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:437)", 2333, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:440)", 2334, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:448)", 2335, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:451)", 2336, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:482)", 2337, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:482)", 2338, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:482)", 2339, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:482)", 2340, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:482)", 2341, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:483)", 2342, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:484)", 2343, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:484)", 2344, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:484)", 2345, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:486)", 2346, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:489)", 2347, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:491)", 2348, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:493)", 2349, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.__L2350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/MergePersistenceUnitManager.java:500)", 2350, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.MergePersistenceUnitManager.initPerturbationLocation0();
    }
}

