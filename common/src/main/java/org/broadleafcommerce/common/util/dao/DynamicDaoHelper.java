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


public interface DynamicDaoHelper {
    java.util.Map<java.lang.String, java.lang.Object> getIdMetadata(java.lang.Class<?> entityClass, org.hibernate.ejb.HibernateEntityManager entityManager);

    java.util.List<java.lang.String> getPropertyNames(java.lang.Class<?> entityClass, org.hibernate.ejb.HibernateEntityManager entityManager);

    java.util.List<org.hibernate.type.Type> getPropertyTypes(java.lang.Class<?> entityClass, org.hibernate.ejb.HibernateEntityManager entityManager);

    org.hibernate.SessionFactory getSessionFactory(org.hibernate.ejb.HibernateEntityManager entityManager);

    java.lang.Class<?>[] getAllPolymorphicEntitiesFromCeiling(java.lang.Class<?> ceilingClass, org.hibernate.SessionFactory sessionFactory, boolean includeUnqualifiedPolymorphicEntities, boolean useCache);

    java.lang.Class<?>[] sortEntities(java.lang.Class<?> ceilingClass, java.util.List<java.lang.Class<?>> entities);

    boolean isExcludeClassFromPolymorphism(java.lang.Class<?> clazz);

    java.io.Serializable getIdentifier(java.lang.Object entity, javax.persistence.EntityManager em);

    java.io.Serializable getIdentifier(java.lang.Object entity, org.hibernate.Session session);

    java.lang.reflect.Field getIdField(java.lang.Class<?> clazz, javax.persistence.EntityManager em);

    java.lang.reflect.Field getIdField(java.lang.Class<?> clazz, org.hibernate.Session session);

    java.lang.Class<?>[] getUpDownInheritance(java.lang.Class<?> testClass, org.hibernate.SessionFactory sessionFactory, boolean includeUnqualifiedPolymorphicEntities, boolean useCache, org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao ejb3ConfigurationDao);
}

