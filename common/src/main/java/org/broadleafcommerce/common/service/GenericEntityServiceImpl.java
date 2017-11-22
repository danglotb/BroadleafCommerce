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


@org.springframework.stereotype.Service("blGenericEntityService")
public class GenericEntityServiceImpl implements org.broadleafcommerce.common.service.GenericEntityService {
    @javax.annotation.Resource(name = "blGenericEntityDao")
    protected org.broadleafcommerce.common.dao.GenericEntityDao genericEntityDao;

    @java.lang.Override
    public java.lang.Object readGenericEntity(java.lang.String className, java.lang.Object id) {
        java.lang.Class<?> clazz = genericEntityDao.getImplClass(className);
        return genericEntityDao.readGenericEntity(clazz, id);
    }

    @java.lang.Override
    public <T> T readGenericEntity(java.lang.Class<T> clazz, java.lang.Object id) {
        return genericEntityDao.readGenericEntity(clazz, id);
    }

    @java.lang.Override
    public <T> T save(T object) {
        return genericEntityDao.save(object);
    }

    public void persist(java.lang.Object object) {
        genericEntityDao.persist(object);
    }

    @java.lang.Override
    public <T> java.lang.Long readCountGenericEntity(java.lang.Class<T> clazz) {
        return genericEntityDao.readCountGenericEntity(clazz);
    }

    @java.lang.Override
    public <T> java.util.List<T> readAllGenericEntity(java.lang.Class<T> clazz, int limit, int offset) {
        return genericEntityDao.readAllGenericEntity(clazz, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5169, limit), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5170, offset));
    }

    @java.lang.Override
    public java.util.List<java.lang.Long> readAllGenericEntityId(java.lang.Class<?> clazz) {
        return genericEntityDao.readAllGenericEntityId(clazz);
    }

    @java.lang.Override
    public java.io.Serializable getIdentifier(java.lang.Object entity) {
        return genericEntityDao.getIdentifier(entity);
    }

    @java.lang.Override
    public void flush() {
        genericEntityDao.flush();
    }

    @java.lang.Override
    public void clearAutoFlushMode() {
        genericEntityDao.clearAutoFlushMode();
    }

    @java.lang.Override
    public void enableAutoFlushMode() {
        genericEntityDao.enableAutoFlushMode();
    }

    @java.lang.Override
    public void clear() {
        genericEntityDao.clear();
    }

    @java.lang.Override
    public boolean sessionContains(java.lang.Object object) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5171, genericEntityDao.sessionContains(object));
    }

    @java.lang.Override
    public java.lang.Class<?> getCeilingImplClass(java.lang.String className) {
        return genericEntityDao.getCeilingImplClass(className);
    }

    @java.lang.Override
    public boolean idAssigned(java.lang.Object object) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5172, genericEntityDao.idAssigned(object));
    }

    @java.lang.Override
    public javax.persistence.EntityManager getEntityManager() {
        return genericEntityDao.getEntityManager();
    }

    @java.lang.Override
    public void remove(java.lang.Object object) {
        genericEntityDao.remove(object);
    }

    public static perturbation.location.PerturbationLocation __L5169;

    public static perturbation.location.PerturbationLocation __L5170;

    public static perturbation.location.PerturbationLocation __L5171;

    public static perturbation.location.PerturbationLocation __L5172;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericEntityServiceImpl.java:64)", 5169, "Numerical");
        org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericEntityServiceImpl.java:64)", 5170, "Numerical");
        org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericEntityServiceImpl.java:99)", 5171, "Boolean");
        org.broadleafcommerce.common.service.GenericEntityServiceImpl.__L5172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericEntityServiceImpl.java:109)", 5172, "Boolean");
    }

    static {
        org.broadleafcommerce.common.service.GenericEntityServiceImpl.initPerturbationLocation0();
    }
}

