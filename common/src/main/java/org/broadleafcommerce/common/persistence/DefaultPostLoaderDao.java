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


@org.springframework.stereotype.Component("blPostLoaderDao")
public class DefaultPostLoaderDao implements org.broadleafcommerce.common.persistence.PostLoaderDao , org.springframework.context.ApplicationContextAware {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.class);

    private static org.springframework.context.ApplicationContext applicationContext;

    private static org.broadleafcommerce.common.persistence.PostLoaderDao postLoaderDao;

    @javax.annotation.Resource(name = "blPersistenceService")
    protected org.broadleafcommerce.common.service.PersistenceService persistenceService;

    public static org.broadleafcommerce.common.persistence.PostLoaderDao getPostLoaderDao() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.__L4337, ((org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.applicationContext) == null))) {
            return null;
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.__L4338, ((org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.postLoaderDao) == null))) {
                org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.postLoaderDao = ((org.broadleafcommerce.common.persistence.PostLoaderDao) (org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.applicationContext.getBean("blPostLoaderDao")));
            }

        return org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.postLoaderDao;
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.applicationContext = applicationContext;
    }

    @java.lang.Override
    public <T> T find(java.lang.Class<T> clazz, java.lang.Object id) {
        javax.persistence.EntityManager em = getEntityManager(clazz);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.__L4339, (em == null)) ? null : em.find(clazz, id);
    }

    @java.lang.Override
    public <T> T findSandboxEntity(java.lang.Class<T> clazz, java.lang.Object id) {
        return find(clazz, id);
    }

    protected javax.persistence.EntityManager getEntityManager(java.lang.Class clazz) {
        return persistenceService.identifyEntityManager(clazz);
    }

    public static perturbation.location.PerturbationLocation __L4337;

    public static perturbation.location.PerturbationLocation __L4338;

    public static perturbation.location.PerturbationLocation __L4339;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.__L4337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/DefaultPostLoaderDao.java:46)", 4337, "Boolean");
        org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.__L4338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/DefaultPostLoaderDao.java:48)", 4338, "Boolean");
        org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.__L4339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/DefaultPostLoaderDao.java:74)", 4339, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.DefaultPostLoaderDao.initPerturbationLocation0();
    }
}

