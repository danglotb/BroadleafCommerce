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
package org.broadleafcommerce.common.util.dao;


public class DynamicDaoHelperImpl implements org.broadleafcommerce.common.util.dao.DynamicDaoHelper {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.class);

    public static final java.lang.Object LOCK_OBJECT = new java.lang.Object();

    public static final java.util.Map<org.hibernate.SessionFactory, java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]>> POLYMORPHIC_ENTITY_CACHE = new org.apache.commons.collections4.map.LRUMap<>(1000);

    public static final java.util.Map<org.hibernate.SessionFactory, java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]>> POLYMORPHIC_ENTITY_CACHE_WO_EXCLUSIONS = new org.apache.commons.collections4.map.LRUMap<>(1000);

    public static final java.lang.String JAVASSIST_PROXY_KEY_PHRASE = "_$$_";

    public static java.lang.Class<?> getNonProxyImplementationClassIfNecessary(java.lang.Class<?> candidate) {
        java.lang.Class<?> response = candidate;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5821, javassist.util.proxy.ProxyFactory.isProxyClass(candidate))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5823, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5822, candidate.getName().contains(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.JAVASSIST_PROXY_KEY_PHRASE)))))) {
                throw new org.broadleafcommerce.common.exception.ProxyDetectionException(java.lang.String.format(("Cannot determine the original implementation class for " + "the javassist proxy. Expected to find the keyphrase (%s) in the proxy classname (%s)."), org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.JAVASSIST_PROXY_KEY_PHRASE, candidate.getName()));
            }
            java.lang.String implName = candidate.getName().substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5824, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5825, candidate.getName().lastIndexOf(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.JAVASSIST_PROXY_KEY_PHRASE)));
            try {
                response = java.lang.Class.forName(implName);
            } catch (java.lang.ClassNotFoundException e) {
                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
            }
        }
        return response;
    }

    @java.lang.Override
    public java.lang.Class<?>[] getAllPolymorphicEntitiesFromCeiling(java.lang.Class<?> ceilingClass, org.hibernate.SessionFactory sessionFactory, boolean includeUnqualifiedPolymorphicEntities, boolean useCache) {
        ceilingClass = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(ceilingClass);
        java.lang.Class<?>[] cache = null;
        synchronized(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.LOCK_OBJECT) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5826, useCache)) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5827, includeUnqualifiedPolymorphicEntities)) {
                    cache = getCachedPolymorphicEntityList(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.POLYMORPHIC_ENTITY_CACHE, sessionFactory, ceilingClass);
                }else {
                    cache = getCachedPolymorphicEntityList(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.POLYMORPHIC_ENTITY_CACHE_WO_EXCLUSIONS, sessionFactory, ceilingClass);
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5828, (cache == null))) {
                java.util.List<java.lang.Class<?>> entities = new java.util.ArrayList<>();
                for (java.lang.Object item : sessionFactory.getAllClassMetadata().values()) {
                    org.hibernate.metadata.ClassMetadata metadata = ((org.hibernate.metadata.ClassMetadata) (item));
                    java.lang.Class<?> mappedClass = metadata.getMappedClass();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5831, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5829, (mappedClass != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5830, ceilingClass.isAssignableFrom(mappedClass)))))) {
                        entities.add(mappedClass);
                    }
                }
                java.lang.Class<?>[] sortedEntities = sortEntities(ceilingClass, entities);
                java.util.List<java.lang.Class<?>> filteredSortedEntities = new java.util.ArrayList<>();
                for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5832, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5835, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5833, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5834, sortedEntities.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5836, (i++))) {
                    java.lang.Class<?> item = sortedEntities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5837, i)];
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5838, includeUnqualifiedPolymorphicEntities)) {
                        filteredSortedEntities.add(sortedEntities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5839, i)]);
                    }else {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5840, isExcludeClassFromPolymorphism(item))) {
                            continue;
                        }else {
                            filteredSortedEntities.add(sortedEntities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5841, i)]);
                        }
                    }
                }
                java.lang.Class<?>[] filteredEntities = new java.lang.Class<?>[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5842, filteredSortedEntities.size())];
                filteredEntities = filteredSortedEntities.toArray(filteredEntities);
                cache = filteredEntities;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5843, includeUnqualifiedPolymorphicEntities)) {
                    java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]> polymorphicEntityMap = buildPolymorphicEntityMap(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.POLYMORPHIC_ENTITY_CACHE.get(sessionFactory), ceilingClass, filteredEntities);
                    org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.POLYMORPHIC_ENTITY_CACHE.put(sessionFactory, polymorphicEntityMap);
                }else {
                    java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]> polymorphicEntityMap = buildPolymorphicEntityMap(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.POLYMORPHIC_ENTITY_CACHE_WO_EXCLUSIONS.get(sessionFactory), ceilingClass, filteredEntities);
                    org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.POLYMORPHIC_ENTITY_CACHE_WO_EXCLUSIONS.put(sessionFactory, polymorphicEntityMap);
                }
            }
        }
        return cache;
    }

    protected java.lang.Class<?>[] getCachedPolymorphicEntityList(java.util.Map<org.hibernate.SessionFactory, java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]>> polymorphicEntityCache, org.hibernate.SessionFactory sessionFactory, java.lang.Class<?> ceilingClass) {
        java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]> polymorphicEntityMap = polymorphicEntityCache.get(sessionFactory);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5844, (polymorphicEntityMap == null)) ? null : polymorphicEntityMap.get(ceilingClass);
    }

    protected java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]> buildPolymorphicEntityMap(java.util.Map<java.lang.Class<?>, java.lang.Class<?>[]> polymorphicEntityMap, java.lang.Class<?> ceilingClass, java.lang.Class<?>[] filteredEntities) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5845, (polymorphicEntityMap == null))) {
            polymorphicEntityMap = new org.apache.commons.collections4.map.LRUMap<>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5846, 1000));
        }
        polymorphicEntityMap.put(ceilingClass, filteredEntities);
        return polymorphicEntityMap;
    }

    @java.lang.Override
    public java.lang.Class<?>[] getUpDownInheritance(java.lang.Class<?> testClass, org.hibernate.SessionFactory sessionFactory, boolean includeUnqualifiedPolymorphicEntities, boolean useCache, org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao ejb3ConfigurationDao) {
        java.lang.Class<?>[] pEntities = getAllPolymorphicEntitiesFromCeiling(testClass, sessionFactory, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5847, includeUnqualifiedPolymorphicEntities), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5848, useCache));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5849, org.apache.commons.lang3.ArrayUtils.isEmpty(pEntities))) {
            return pEntities;
        }
        java.lang.Class<?> topConcreteClass = pEntities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5852, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5850, pEntities.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5851, 1))))];
        java.util.List<java.lang.Class<?>> temp = new java.util.ArrayList<>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5853, pEntities.length));
        temp.addAll(java.util.Arrays.asList(pEntities));
        java.util.Collections.reverse(temp);
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5854, false);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5856, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5855, eof))))) {
            java.lang.Class<?> superClass = topConcreteClass.getSuperclass();
            org.hibernate.mapping.PersistentClass persistentClass = ejb3ConfigurationDao.getConfiguration().getClassMapping(superClass.getName());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5857, (persistentClass == null))) {
                eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5858, true);
            }else {
                temp.add(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5859, 0), superClass);
                topConcreteClass = superClass;
            }
        } 
        return temp.toArray(new java.lang.Class<?>[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5860, temp.size())]);
    }

    @java.lang.Override
    public java.lang.Class<?>[] sortEntities(java.lang.Class<?> ceilingClass, java.util.List<java.lang.Class<?>> entities) {
        java.lang.Class<?>[] sortedEntities = new java.lang.Class<?>[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5861, entities.size())];
        java.util.List<java.lang.Class<?>> stageItems = new java.util.ArrayList<>();
        stageItems.add(ceilingClass);
        int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5862, 0);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5865, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5863, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5864, sortedEntities.length))))) {
            java.util.List<java.lang.Class<?>> newStageItems = new java.util.ArrayList<>();
            boolean topLevelClassFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5866, false);
            for (java.lang.Class<?> stageItem : stageItems) {
                java.util.Iterator<java.lang.Class<?>> itr = entities.iterator();
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5867, itr.hasNext())) {
                    java.lang.Class<?> entity = itr.next();
                    checkitem : {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5870, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5868, org.apache.commons.lang3.ArrayUtils.contains(entity.getInterfaces(), stageItem))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5869, entity.equals(stageItem)))))) {
                            topLevelClassFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5871, true);
                            break checkitem;
                        }
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5872, topLevelClassFound)) {
                            continue;
                        }
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5877, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5873, entity.getSuperclass().equals(stageItem))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5876, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5874, j)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5875, 0)))))))) {
                            break checkitem;
                        }
                        continue;
                    }
                    sortedEntities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5878, j)] = entity;
                    itr.remove();
                    perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5879, (j++));
                    newStageItems.add(entity);
                } 
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5880, newStageItems.isEmpty())) {
                throw new java.lang.IllegalArgumentException((("There was a gap in the inheritance hierarchy for (" + (ceilingClass.getName())) + ")"));
            }
            stageItems = newStageItems;
        } 
        org.apache.commons.lang3.ArrayUtils.reverse(sortedEntities);
        return sortedEntities;
    }

    @java.lang.Override
    public boolean isExcludeClassFromPolymorphism(java.lang.Class<?> clazz) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5882, java.lang.reflect.Modifier.isAbstract(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5881, clazz.getModifiers())))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5883, true);
        }
        org.broadleafcommerce.common.presentation.AdminPresentationClass adminPresentationClass = org.springframework.core.annotation.AnnotationUtils.findAnnotation(clazz, org.broadleafcommerce.common.presentation.AdminPresentationClass.class);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5884, (adminPresentationClass == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5885, false);
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5886, adminPresentationClass.excludeFromPolymorphism())) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5887, true);
            }

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5888, false);
    }

    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.Object> getIdMetadata(java.lang.Class<?> entityClass, org.hibernate.ejb.HibernateEntityManager entityManager) {
        entityClass = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(entityClass);
        java.util.Map<java.lang.String, java.lang.Object> response = new java.util.HashMap<>();
        org.hibernate.SessionFactory sessionFactory = entityManager.getSession().getSessionFactory();
        org.hibernate.metadata.ClassMetadata metadata = sessionFactory.getClassMetadata(entityClass);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5889, (metadata == null))) {
            return null;
        }
        java.lang.String idProperty = metadata.getIdentifierPropertyName();
        response.put("name", idProperty);
        org.hibernate.type.Type idType = metadata.getIdentifierType();
        response.put("type", idType);
        return response;
    }

    @java.lang.Override
    public java.util.List<java.lang.String> getPropertyNames(java.lang.Class<?> entityClass, org.hibernate.ejb.HibernateEntityManager entityManager) {
        entityClass = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(entityClass);
        org.hibernate.metadata.ClassMetadata metadata = getSessionFactory(entityManager).getClassMetadata(entityClass);
        java.util.List<java.lang.String> propertyNames = new java.util.ArrayList<>();
        java.util.Collections.addAll(propertyNames, metadata.getPropertyNames());
        return propertyNames;
    }

    @java.lang.Override
    public java.util.List<org.hibernate.type.Type> getPropertyTypes(java.lang.Class<?> entityClass, org.hibernate.ejb.HibernateEntityManager entityManager) {
        entityClass = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(entityClass);
        org.hibernate.metadata.ClassMetadata metadata = getSessionFactory(entityManager).getClassMetadata(entityClass);
        java.util.List<org.hibernate.type.Type> propertyTypes = new java.util.ArrayList<>();
        java.util.Collections.addAll(propertyTypes, metadata.getPropertyTypes());
        return propertyTypes;
    }

    @java.lang.Override
    public org.hibernate.SessionFactory getSessionFactory(org.hibernate.ejb.HibernateEntityManager entityManager) {
        return entityManager.getSession().getSessionFactory();
    }

    @java.lang.Override
    public java.io.Serializable getIdentifier(java.lang.Object entity, javax.persistence.EntityManager em) {
        java.lang.Class<?> entityClass = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(entity.getClass());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5890, ((entityClass.getAnnotation(javax.persistence.Entity.class)) != null))) {
            java.lang.reflect.Field idField = getIdField(entityClass, em);
            try {
                return ((java.io.Serializable) (idField.get(entity)));
            } catch (java.lang.IllegalAccessException e) {
                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
            }
        }
        return null;
    }

    @java.lang.Override
    public java.io.Serializable getIdentifier(java.lang.Object entity, org.hibernate.Session session) {
        java.lang.Class<?> entityClass = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(entity.getClass());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5891, ((entityClass.getAnnotation(javax.persistence.Entity.class)) != null))) {
            java.lang.reflect.Field idField = getIdField(entityClass, session);
            try {
                return ((java.io.Serializable) (idField.get(entity)));
            } catch (java.lang.IllegalAccessException e) {
                throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
            }
        }
        return null;
    }

    @java.lang.Override
    public java.lang.reflect.Field getIdField(java.lang.Class<?> clazz, javax.persistence.EntityManager em) {
        clazz = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz);
        org.hibernate.metadata.ClassMetadata metadata = em.unwrap(org.hibernate.Session.class).getSessionFactory().getClassMetadata(clazz);
        java.lang.reflect.Field idField = org.springframework.util.ReflectionUtils.findField(clazz, metadata.getIdentifierPropertyName());
        idField.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5892, true));
        return idField;
    }

    @java.lang.Override
    public java.lang.reflect.Field getIdField(java.lang.Class<?> clazz, org.hibernate.Session session) {
        clazz = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz);
        org.hibernate.metadata.ClassMetadata metadata = session.getSessionFactory().getClassMetadata(clazz);
        java.lang.reflect.Field idField = org.springframework.util.ReflectionUtils.findField(clazz, metadata.getIdentifierPropertyName());
        idField.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5893, true));
        return idField;
    }

    public static perturbation.location.PerturbationLocation __L5821;

    public static perturbation.location.PerturbationLocation __L5822;

    public static perturbation.location.PerturbationLocation __L5823;

    public static perturbation.location.PerturbationLocation __L5824;

    public static perturbation.location.PerturbationLocation __L5825;

    public static perturbation.location.PerturbationLocation __L5826;

    public static perturbation.location.PerturbationLocation __L5827;

    public static perturbation.location.PerturbationLocation __L5828;

    public static perturbation.location.PerturbationLocation __L5829;

    public static perturbation.location.PerturbationLocation __L5830;

    public static perturbation.location.PerturbationLocation __L5831;

    public static perturbation.location.PerturbationLocation __L5832;

    public static perturbation.location.PerturbationLocation __L5833;

    public static perturbation.location.PerturbationLocation __L5834;

    public static perturbation.location.PerturbationLocation __L5835;

    public static perturbation.location.PerturbationLocation __L5836;

    public static perturbation.location.PerturbationLocation __L5837;

    public static perturbation.location.PerturbationLocation __L5838;

    public static perturbation.location.PerturbationLocation __L5839;

    public static perturbation.location.PerturbationLocation __L5840;

    public static perturbation.location.PerturbationLocation __L5841;

    public static perturbation.location.PerturbationLocation __L5842;

    public static perturbation.location.PerturbationLocation __L5843;

    public static perturbation.location.PerturbationLocation __L5844;

    public static perturbation.location.PerturbationLocation __L5845;

    public static perturbation.location.PerturbationLocation __L5846;

    public static perturbation.location.PerturbationLocation __L5847;

    public static perturbation.location.PerturbationLocation __L5848;

    public static perturbation.location.PerturbationLocation __L5849;

    public static perturbation.location.PerturbationLocation __L5850;

    public static perturbation.location.PerturbationLocation __L5851;

    public static perturbation.location.PerturbationLocation __L5852;

    public static perturbation.location.PerturbationLocation __L5853;

    public static perturbation.location.PerturbationLocation __L5854;

    public static perturbation.location.PerturbationLocation __L5855;

    public static perturbation.location.PerturbationLocation __L5856;

    public static perturbation.location.PerturbationLocation __L5857;

    public static perturbation.location.PerturbationLocation __L5858;

    public static perturbation.location.PerturbationLocation __L5859;

    public static perturbation.location.PerturbationLocation __L5860;

    public static perturbation.location.PerturbationLocation __L5861;

    public static perturbation.location.PerturbationLocation __L5862;

    public static perturbation.location.PerturbationLocation __L5863;

    public static perturbation.location.PerturbationLocation __L5864;

    public static perturbation.location.PerturbationLocation __L5865;

    public static perturbation.location.PerturbationLocation __L5866;

    public static perturbation.location.PerturbationLocation __L5867;

    public static perturbation.location.PerturbationLocation __L5868;

    public static perturbation.location.PerturbationLocation __L5869;

    public static perturbation.location.PerturbationLocation __L5870;

    public static perturbation.location.PerturbationLocation __L5871;

    public static perturbation.location.PerturbationLocation __L5872;

    public static perturbation.location.PerturbationLocation __L5873;

    public static perturbation.location.PerturbationLocation __L5874;

    public static perturbation.location.PerturbationLocation __L5875;

    public static perturbation.location.PerturbationLocation __L5876;

    public static perturbation.location.PerturbationLocation __L5877;

    public static perturbation.location.PerturbationLocation __L5878;

    public static perturbation.location.PerturbationLocation __L5879;

    public static perturbation.location.PerturbationLocation __L5880;

    public static perturbation.location.PerturbationLocation __L5881;

    public static perturbation.location.PerturbationLocation __L5882;

    public static perturbation.location.PerturbationLocation __L5883;

    public static perturbation.location.PerturbationLocation __L5884;

    public static perturbation.location.PerturbationLocation __L5885;

    public static perturbation.location.PerturbationLocation __L5886;

    public static perturbation.location.PerturbationLocation __L5887;

    public static perturbation.location.PerturbationLocation __L5888;

    public static perturbation.location.PerturbationLocation __L5889;

    public static perturbation.location.PerturbationLocation __L5890;

    public static perturbation.location.PerturbationLocation __L5891;

    public static perturbation.location.PerturbationLocation __L5892;

    public static perturbation.location.PerturbationLocation __L5893;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:65)", 5821, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:69)", 5822, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:69)", 5823, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:74)", 5824, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:74)", 5825, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:90)", 5826, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:91)", 5827, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:97)", 5828, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:102)", 5829, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:102)", 5830, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:102)", 5831, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:110)", 5832, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:110)", 5833, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:110)", 5834, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:110)", 5835, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:110)", 5836, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:111)", 5837, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:112)", 5838, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:113)", 5839, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:115)", 5840, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:118)", 5841, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:123)", 5842, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5843 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:126)", 5843, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5844 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:143)", 5844, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:148)", 5845, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:149)", 5846, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:159)", 5847, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:159)", 5848, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:160)", 5849, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:163)", 5850, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:163)", 5851, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:163)", 5852, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:164)", 5853, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:167)", 5854, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:168)", 5855, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:168)", 5856, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:171)", 5857, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:172)", 5858, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:174)", 5859, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:179)", 5860, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:187)", 5861, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:190)", 5862, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:191)", 5863, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:191)", 5864, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:191)", 5865, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:193)", 5866, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:196)", 5867, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:199)", 5868, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:199)", 5869, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:199)", 5870, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:200)", 5871, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:204)", 5872, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:208)", 5873, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:208)", 5874, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:208)", 5875, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:208)", 5876, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:208)", 5877, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:214)", 5878, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:216)", 5879, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:220)", 5880, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:232)", 5881, "Numerical");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:232)", 5882, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:233)", 5883, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:238)", 5884, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:239)", 5885, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:240)", 5886, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:241)", 5887, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:243)", 5888, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:253)", 5889, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:291)", 5890, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:305)", 5891, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:321)", 5892, "Boolean");
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.__L5893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/DynamicDaoHelperImpl.java:330)", 5893, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.initPerturbationLocation0();
    }
}

