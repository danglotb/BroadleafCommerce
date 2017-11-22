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


public interface PersistenceService {
    boolean validateEntityClassName(java.lang.String entityClassName);

    javax.persistence.EntityManager identifyEntityManager(java.lang.Class entityClass);

    javax.persistence.EntityManager identifyEntityManager(java.lang.Class entityClass, org.broadleafcommerce.common.persistence.TargetModeType targetModeType);

    org.springframework.transaction.PlatformTransactionManager identifyTransactionManager(java.lang.String className, org.broadleafcommerce.common.persistence.TargetModeType targetModeType);

    org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao identifyEJB3ConfigurationDao(java.lang.Class entityClass);

    javax.persistence.EntityManager identifyDefaultEntityManager(org.broadleafcommerce.common.persistence.TargetModeType targetModeType);

    org.springframework.transaction.PlatformTransactionManager identifyDefaultTransactionManager(org.broadleafcommerce.common.persistence.TargetModeType targetModeType);

    org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao identifyDefaultEJB3ConfigurationDao(org.broadleafcommerce.common.persistence.TargetModeType targetModeType);

    javax.persistence.EntityManager getEntityManager(java.util.Map<java.lang.String, java.lang.Object> managerMap);

    org.springframework.transaction.PlatformTransactionManager getTransactionManager(java.util.Map<java.lang.String, java.lang.Object> managerMap);

    org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao getEJB3ConfigurationDao(java.util.Map<java.lang.String, java.lang.Object> managerMap);

    @javax.annotation.Nullable
    java.lang.Class<?> getCeilingImplClassFromEntityManagers(java.lang.String className);
}

