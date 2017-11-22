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
package org.broadleafcommerce.common.service;


@org.springframework.stereotype.Service("blPersistenceService")
public class PersistenceServiceImpl implements org.broadleafcommerce.common.service.PersistenceService , org.springframework.context.SmartLifecycle {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.service.PersistenceServiceImpl.class);

    protected static final java.lang.String ENTITY_MANAGER_KEY = "entityManager";

    protected static final java.lang.String TRANSACTION_MANAGER_KEY = "transactionManager";

    protected static final java.lang.String EJB3_CONFIG_DAO_KEY = "ejb3ConfigurationDao";

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @javax.annotation.Resource(name = "blTargetModeMaps")
    protected java.util.List<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> targetModeMaps;

    @javax.annotation.Resource(name = "blDefaultTargetModeMap")
    protected java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> defaultTargetModeMap;

    @javax.annotation.Resource(name = "blStreamingTransactionCapableUtil")
    protected org.broadleafcommerce.common.util.StreamingTransactionCapableUtil transUtil;

    @org.springframework.beans.factory.annotation.Autowired
    protected java.util.List<javax.persistence.EntityManager> entityManagers;

    private final java.util.Map<java.lang.String, javax.persistence.EntityManager> ENTITY_MANAGER_CACHE = new java.util.concurrent.ConcurrentHashMap<>();

    private final java.util.Map<java.lang.String, org.springframework.transaction.PlatformTransactionManager> TRANSACTION_MANAGER_CACHE = new java.util.concurrent.ConcurrentHashMap<>();

    private final java.util.Map<java.lang.String, org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao> EJB3_CONFIG_DAO_CACHE = new java.util.concurrent.ConcurrentHashMap<>();

    private org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl daoHelper = new org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl();

    @java.lang.Override
    public boolean isAutoStartup() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5182, true);
    }

    @java.lang.Override
    public void stop(java.lang.Runnable callback) {
        callback.run();
    }

    @java.lang.Override
    public void start() {
        initializeEntityManagerCache();
    }

    @java.lang.Override
    public void stop() {
    }

    @java.lang.Override
    public boolean isRunning() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5183, false);
    }

    @java.lang.Override
    public int getPhase() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5184, 0);
    }

    protected void initializeEntityManagerCache() {
        for (java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> targetModeMap : targetModeMaps) {
            for (final java.lang.String targetMode : targetModeMap.keySet()) {
                final java.util.Map<java.lang.String, java.lang.Object> managerMap = targetModeMap.get(targetMode);
                transUtil.runTransactionalOperation(new org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter() {
                    @java.lang.Override
                    public void execute() throws java.lang.Throwable {
                        populateCaches(targetMode, managerMap);
                    }
                }, java.lang.RuntimeException.class, getTransactionManager(managerMap));
            }
        }
    }

    protected void populateCaches(java.lang.String targetMode, java.util.Map<java.lang.String, java.lang.Object> managerMap) {
        final javax.persistence.EntityManager em = getEntityManager(managerMap);
        final org.springframework.transaction.PlatformTransactionManager txManager = getTransactionManager(managerMap);
        final org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao ejb3ConfigurationDao = getEJB3ConfigurationDao(managerMap);
        org.hibernate.SessionFactory sessionFactory = em.unwrap(org.hibernate.Session.class).getSessionFactory();
        for (java.lang.Object item : sessionFactory.getAllClassMetadata().values()) {
            org.hibernate.metadata.ClassMetadata metadata = ((org.hibernate.metadata.ClassMetadata) (item));
            java.lang.Class<?> mappedClass = metadata.getMappedClass();
            java.lang.String managerCacheKey = buildManagerCacheKey(targetMode, mappedClass);
            ENTITY_MANAGER_CACHE.put(managerCacheKey, em);
            TRANSACTION_MANAGER_CACHE.put(managerCacheKey, txManager);
            java.lang.String ejb3ConfigDaoCacheKey = buildEJB3ConfigDaoCacheKey(mappedClass);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5186, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5185, EJB3_CONFIG_DAO_CACHE.containsKey(ejb3ConfigDaoCacheKey)))))) {
                EJB3_CONFIG_DAO_CACHE.put(ejb3ConfigDaoCacheKey, ejb3ConfigurationDao);
            }
        }
    }

    @java.lang.Override
    public boolean validateEntityClassName(java.lang.String entityClassName) {
        java.lang.String cacheKey = buildManagerCacheKey(org.broadleafcommerce.common.persistence.TargetModeType.SANDBOX.getType(), entityClassName);
        boolean isValid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5187, ENTITY_MANAGER_CACHE.containsKey(cacheKey));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5189, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5188, isValid))))) {
            org.broadleafcommerce.common.service.PersistenceServiceImpl.LOG.warn("The system detected an entity class name submitted that is not present in the registered entities known to the system.");
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5190, isValid);
    }

    @java.lang.Override
    public javax.persistence.EntityManager identifyEntityManager(java.lang.Class entityClass) {
        return identifyEntityManager(entityClass, org.broadleafcommerce.common.persistence.TargetModeType.SANDBOX);
    }

    @java.lang.Override
    public javax.persistence.EntityManager identifyEntityManager(java.lang.Class entityClass, org.broadleafcommerce.common.persistence.TargetModeType targetModeType) {
        java.lang.String cacheKey = buildManagerCacheKey(targetModeType.getType(), entityClass);
        javax.persistence.EntityManager entityManager = ENTITY_MANAGER_CACHE.get(cacheKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5191, (entityManager == null))) {
            throw new java.lang.RuntimeException((("Unable to determine the EntityManager for the following " + "targetModeType and class pair: ") + cacheKey));
        }
        return entityManager;
    }

    @java.lang.Override
    public org.springframework.transaction.PlatformTransactionManager identifyTransactionManager(java.lang.String className, org.broadleafcommerce.common.persistence.TargetModeType targetModeType) {
        java.lang.String cacheKey = buildManagerCacheKey(targetModeType.getType(), className);
        org.springframework.transaction.PlatformTransactionManager txManager = TRANSACTION_MANAGER_CACHE.get(cacheKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5192, (txManager == null))) {
            throw new java.lang.RuntimeException((("Unable to determine the PlatformTransactionManager for the following " + "targetModeType and class pair: ") + cacheKey));
        }
        return txManager;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao identifyEJB3ConfigurationDao(java.lang.Class entityClass) {
        java.lang.String cacheKey = buildEJB3ConfigDaoCacheKey(entityClass);
        org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao ejb3ConfigurationDao = EJB3_CONFIG_DAO_CACHE.get(cacheKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5193, (ejb3ConfigurationDao == null))) {
            throw new java.lang.RuntimeException(("Unable to determine the EJB3ConfigurationDao for the following class: " + (entityClass.getName())));
        }
        return ejb3ConfigurationDao;
    }

    @java.lang.Override
    public javax.persistence.EntityManager identifyDefaultEntityManager(org.broadleafcommerce.common.persistence.TargetModeType targetModeType) {
        java.util.Map<java.lang.String, java.lang.Object> managerMap = defaultTargetModeMap.get(targetModeType.getType());
        return getEntityManager(managerMap);
    }

    @java.lang.Override
    public javax.persistence.EntityManager getEntityManager(java.util.Map<java.lang.String, java.lang.Object> managerMap) {
        return ((javax.persistence.EntityManager) (managerMap.get(org.broadleafcommerce.common.service.PersistenceServiceImpl.ENTITY_MANAGER_KEY)));
    }

    @java.lang.Override
    public org.springframework.transaction.PlatformTransactionManager identifyDefaultTransactionManager(org.broadleafcommerce.common.persistence.TargetModeType targetModeType) {
        java.util.Map<java.lang.String, java.lang.Object> managerMap = defaultTargetModeMap.get(targetModeType.getType());
        return getTransactionManager(managerMap);
    }

    @java.lang.Override
    public org.springframework.transaction.PlatformTransactionManager getTransactionManager(java.util.Map<java.lang.String, java.lang.Object> managerMap) {
        return ((org.springframework.transaction.PlatformTransactionManager) (managerMap.get(org.broadleafcommerce.common.service.PersistenceServiceImpl.TRANSACTION_MANAGER_KEY)));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao identifyDefaultEJB3ConfigurationDao(org.broadleafcommerce.common.persistence.TargetModeType targetModeType) {
        java.util.Map<java.lang.String, java.lang.Object> managerMap = defaultTargetModeMap.get(targetModeType.getType());
        return getEJB3ConfigurationDao(managerMap);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao getEJB3ConfigurationDao(java.util.Map<java.lang.String, java.lang.Object> managerMap) {
        return ((org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao) (managerMap.get(org.broadleafcommerce.common.service.PersistenceServiceImpl.EJB3_CONFIG_DAO_KEY)));
    }

    @java.lang.Override
    public java.lang.Class<?> getCeilingImplClassFromEntityManagers(java.lang.String className) {
        java.lang.Class<?> beanIdClass = getClassForName(className);
        for (javax.persistence.EntityManager em : entityManagers) {
            java.lang.Class<?>[] entitiesFromCeiling = daoHelper.getAllPolymorphicEntitiesFromCeiling(beanIdClass, em.unwrap(org.hibernate.Session.class).getSessionFactory(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5194, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5195, true));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5196, org.apache.commons.lang3.ArrayUtils.isNotEmpty(entitiesFromCeiling))) {
                return entitiesFromCeiling[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5199, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5197, entitiesFromCeiling.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5198, 1))))];
            }
        }
        return null;
    }

    protected java.lang.String buildManagerCacheKey(java.lang.String targetMode, java.lang.Class<?> clazz) {
        return buildManagerCacheKey(targetMode, clazz.getName());
    }

    protected java.lang.String buildManagerCacheKey(java.lang.String targetMode, java.lang.String className) {
        java.lang.String managedClassName = getManagedClassName(className);
        return (targetMode + "|") + managedClassName;
    }

    protected java.lang.String buildEJB3ConfigDaoCacheKey(java.lang.Class<?> clazz) {
        return getManagedClassName(clazz.getName());
    }

    protected java.lang.String getManagedClassName(java.lang.String className) {
        try {
            return entityConfiguration.lookupEntityClass(className).getName();
        } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException e) {
            return getCeilingImplClassFromEntityManagers(className).getName();
        }
    }

    protected java.lang.Class<?> getClassForName(java.lang.String className) {
        try {
            return java.lang.Class.forName(className);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static perturbation.location.PerturbationLocation __L5182;

    public static perturbation.location.PerturbationLocation __L5183;

    public static perturbation.location.PerturbationLocation __L5184;

    public static perturbation.location.PerturbationLocation __L5185;

    public static perturbation.location.PerturbationLocation __L5186;

    public static perturbation.location.PerturbationLocation __L5187;

    public static perturbation.location.PerturbationLocation __L5188;

    public static perturbation.location.PerturbationLocation __L5189;

    public static perturbation.location.PerturbationLocation __L5190;

    public static perturbation.location.PerturbationLocation __L5191;

    public static perturbation.location.PerturbationLocation __L5192;

    public static perturbation.location.PerturbationLocation __L5193;

    public static perturbation.location.PerturbationLocation __L5194;

    public static perturbation.location.PerturbationLocation __L5195;

    public static perturbation.location.PerturbationLocation __L5196;

    public static perturbation.location.PerturbationLocation __L5197;

    public static perturbation.location.PerturbationLocation __L5198;

    public static perturbation.location.PerturbationLocation __L5199;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:86)", 5182, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:106)", 5183, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:111)", 5184, "Numerical");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:144)", 5185, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:144)", 5186, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:153)", 5187, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:155)", 5188, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:155)", 5189, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:159)", 5190, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:172)", 5191, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:185)", 5192, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:198)", 5193, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:243)", 5194, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:243)", 5195, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:245)", 5196, "Boolean");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:246)", 5197, "Numerical");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:246)", 5198, "Numerical");
        org.broadleafcommerce.common.service.PersistenceServiceImpl.__L5199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/PersistenceServiceImpl.java:246)", 5199, "Numerical");
    }

    static {
        org.broadleafcommerce.common.service.PersistenceServiceImpl.initPerturbationLocation0();
    }
}

