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
package org.broadleafcommerce.common.config.dao;


@org.springframework.stereotype.Repository("blModuleConfigurationDao")
public class ModuleConfigurationDaoImpl implements org.broadleafcommerce.common.config.dao.ModuleConfigurationDao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    protected java.lang.Long currentDateResolution = ((long) (10000L));

    protected java.util.Date cachedDate = org.broadleafcommerce.common.time.SystemTime.asDate();

    protected java.util.Date getCurrentDateAfterFactoringInDateResolution() {
        java.util.Date returnDate = org.broadleafcommerce.common.time.SystemTime.getCurrentDateWithinTimeResolution(cachedDate, currentDateResolution);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L318, (returnDate != (cachedDate)))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L319, org.broadleafcommerce.common.time.SystemTime.shouldCacheDate())) {
                cachedDate = returnDate;
            }
        }
        return returnDate;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.ModuleConfiguration readById(java.lang.Long id) {
        return em.find(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.class, id);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.ModuleConfiguration save(org.broadleafcommerce.common.config.domain.ModuleConfiguration config) {
        if (config.getIsDefault()) {
            javax.persistence.Query batchUpdate = em.createNamedQuery("BC_BATCH_UPDATE_MODULE_CONFIG_DEFAULT");
            batchUpdate.setParameter("configType", config.getModuleConfigurationType().getType());
            batchUpdate.executeUpdate();
        }
        return em.merge(config);
    }

    @java.lang.Override
    public void delete(org.broadleafcommerce.common.config.domain.ModuleConfiguration config) {
        ((org.broadleafcommerce.common.persistence.Status) (config)).setArchived('Y');
        em.merge(config);
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> readAllByType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType type) {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_MODULE_CONFIG_BY_TYPE");
        query.setParameter("configType", type.getType());
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L320, true));
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHE_REGION, "blConfigurationModuleElements");
        return query.getResultList();
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> readActiveByType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType type) {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_ACTIVE_MODULE_CONFIG_BY_TYPE");
        query.setParameter("configType", type.getType());
        java.util.Date myDate = getCurrentDateAfterFactoringInDateResolution();
        query.setParameter("currentDate", myDate);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L321, true));
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHE_REGION, "blConfigurationModuleElements");
        return query.getResultList();
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> readByType(java.lang.Class<? extends org.broadleafcommerce.common.config.domain.ModuleConfiguration> type) {
        javax.persistence.Query query = em.createQuery((("SELECT config FROM " + (type.getName())) + " config"));
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L322, true));
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHE_REGION, "blConfigurationModuleElements");
        return query.getResultList();
    }

    @java.lang.Override
    public java.lang.Long getCurrentDateResolution() {
        return currentDateResolution;
    }

    @java.lang.Override
    public void setCurrentDateResolution(java.lang.Long currentDateResolution) {
        this.currentDateResolution = currentDateResolution;
    }

    public static perturbation.location.PerturbationLocation __L318;

    public static perturbation.location.PerturbationLocation __L319;

    public static perturbation.location.PerturbationLocation __L320;

    public static perturbation.location.PerturbationLocation __L321;

    public static perturbation.location.PerturbationLocation __L322;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/ModuleConfigurationDaoImpl.java:51)", 318, "Boolean");
        org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/ModuleConfigurationDaoImpl.java:52)", 319, "Boolean");
        org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/ModuleConfigurationDaoImpl.java:85)", 320, "Boolean");
        org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/ModuleConfigurationDaoImpl.java:99)", 321, "Boolean");
        org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.__L322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/dao/ModuleConfigurationDaoImpl.java:109)", 322, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.dao.ModuleConfigurationDaoImpl.initPerturbationLocation0();
    }
}

