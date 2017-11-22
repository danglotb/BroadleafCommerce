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


public class EJB3ConfigurationDaoImpl implements org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao {
    private org.hibernate.ejb.Ejb3Configuration configuration = null;

    protected javax.persistence.spi.PersistenceUnitInfo persistenceUnitInfo;

    public org.hibernate.ejb.Ejb3Configuration getConfiguration() {
        synchronized(this) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.EJB3ConfigurationDaoImpl.__L5894, ((configuration) == null))) {
                org.hibernate.ejb.Ejb3Configuration temp = new org.hibernate.ejb.Ejb3Configuration();
                java.lang.String previousValue = persistenceUnitInfo.getProperties().getProperty("hibernate.hbm2ddl.auto");
                persistenceUnitInfo.getProperties().setProperty("hibernate.hbm2ddl.auto", "none");
                configuration = temp.configure(persistenceUnitInfo, new java.util.HashMap());
                configuration.getHibernateConfiguration().buildSessionFactory();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.EJB3ConfigurationDaoImpl.__L5895, (previousValue != null))) {
                    persistenceUnitInfo.getProperties().setProperty("hibernate.hbm2ddl.auto", previousValue);
                }
            }
        }
        return configuration;
    }

    public javax.persistence.spi.PersistenceUnitInfo getPersistenceUnitInfo() {
        return persistenceUnitInfo;
    }

    public void setPersistenceUnitInfo(javax.persistence.spi.PersistenceUnitInfo persistenceUnitInfo) {
        this.persistenceUnitInfo = persistenceUnitInfo;
    }

    public static perturbation.location.PerturbationLocation __L5894;

    public static perturbation.location.PerturbationLocation __L5895;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.dao.EJB3ConfigurationDaoImpl.__L5894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/EJB3ConfigurationDaoImpl.java:39)", 5894, "Boolean");
        org.broadleafcommerce.common.util.dao.EJB3ConfigurationDaoImpl.__L5895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/EJB3ConfigurationDaoImpl.java:45)", 5895, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.dao.EJB3ConfigurationDaoImpl.initPerturbationLocation0();
    }
}

