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
package org.broadleafcommerce.common.dao;


public interface GenericEntityDao {
    public <T> T readGenericEntity(java.lang.Class<T> clazz, java.lang.Object id);

    public java.lang.Class<?> getImplClass(java.lang.String className);

    java.lang.Class<?> getCeilingImplClass(java.lang.String className);

    public <T> T save(T object);

    void persist(java.lang.Object object);

    void remove(java.lang.Object object);

    public <T> java.lang.Long readCountGenericEntity(java.lang.Class<T> clazz);

    public <T> java.util.List<T> readAllGenericEntity(java.lang.Class<T> clazz, int limit, int offset);

    <T> java.util.List<T> readAllGenericEntity(java.lang.Class<T> clazz);

    java.util.List<java.lang.Long> readAllGenericEntityId(java.lang.Class<?> clazz);

    java.io.Serializable getIdentifier(java.lang.Object entity);

    void flush();

    void clearAutoFlushMode();

    void enableAutoFlushMode();

    void clear();

    boolean sessionContains(java.lang.Object object);

    boolean idAssigned(java.lang.Object object);

    javax.persistence.EntityManager getEntityManager();
}

