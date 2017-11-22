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
package org.broadleafcommerce.common.id.dao;


@org.springframework.stereotype.Repository("blIdGenerationDao")
public class IdGenerationDaoImpl implements org.broadleafcommerce.common.id.dao.IdGenerationDao {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.class);

    protected java.lang.Long defaultBatchSize = ((long) (100L));

    protected java.lang.Long defaultBatchStart = ((long) (1L));

    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.id.domain.IdGeneration findNextId(java.lang.String idType) throws java.lang.Exception, javax.persistence.OptimisticLockException {
        return findNextId(idType, null);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(value = "blTransactionManager", propagation = org.springframework.transaction.annotation.Propagation.REQUIRES_NEW)
    public org.broadleafcommerce.common.id.domain.IdGeneration findNextId(java.lang.String idType, java.lang.Long batchSize) throws java.lang.Exception, javax.persistence.OptimisticLockException {
        org.broadleafcommerce.common.id.domain.IdGeneration response;
        javax.persistence.Query query = em.createNamedQuery("BC_FIND_NEXT_ID");
        query.setParameter("idType", idType);
        try {
            org.broadleafcommerce.common.id.domain.IdGeneration idGeneration = ((org.broadleafcommerce.common.id.domain.IdGeneration) (query.getSingleResult()));
            response = ((org.broadleafcommerce.common.id.domain.IdGeneration) (entityConfiguration.createEntityInstance("org.broadleafcommerce.profile.core.domain.IdGeneration")));
            response.setBatchSize(idGeneration.getBatchSize());
            response.setBatchStart(idGeneration.getBatchStart());
            java.lang.Long originalBatchStart = idGeneration.getBatchStart();
            idGeneration.setBatchStart(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3146, (originalBatchStart + (idGeneration.getBatchSize()))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3147, ((idGeneration.getBegin()) != null))) {
                response.setBegin(idGeneration.getBegin());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3148, ((idGeneration.getBatchStart()) < (idGeneration.getBegin())))) {
                    idGeneration.setBatchStart(idGeneration.getBegin());
                    response.setBatchStart(idGeneration.getBatchStart());
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3149, ((idGeneration.getEnd()) != null))) {
                response.setEnd(idGeneration.getEnd());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3150, ((idGeneration.getBatchStart()) > (idGeneration.getEnd())))) {
                    response.setBatchSize(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3153, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3151, ((idGeneration.getEnd()) - originalBatchStart))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3152, 1)))));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3154, ((idGeneration.getBegin()) != null))) {
                        idGeneration.setBatchStart(idGeneration.getBegin());
                    }else {
                        idGeneration.setBatchStart(getDefaultBatchStart());
                    }
                }
            }
            response.setType(idGeneration.getType());
            em.merge(idGeneration);
            em.flush();
        } catch (javax.persistence.NoResultException nre) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3155, org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.LOG.isDebugEnabled())) {
                org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.LOG.debug((("No row found in idGenerator table for " + idType) + " creating row."));
            }
            response = ((org.broadleafcommerce.common.id.domain.IdGeneration) (entityConfiguration.createEntityInstance("org.broadleafcommerce.profile.core.domain.IdGeneration")));
            response.setType(idType);
            response.setBegin(null);
            response.setEnd(null);
            response.setBatchStart(getDefaultBatchStart());
            response.setBatchSize((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3156, (batchSize == null)) ? getDefaultBatchSize() : batchSize));
            try {
                em.persist(response);
                em.flush();
            } catch (javax.persistence.EntityExistsException e) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3157, org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.LOG.isWarnEnabled())) {
                    org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.LOG.warn((("Error inserting row id generation for idType " + idType) + ".  Requerying table."));
                }
            }
            return findNextId(idType);
        }
        return response;
    }

    public java.lang.Long getDefaultBatchSize() {
        return defaultBatchSize;
    }

    public void setDefaultBatchSize(java.lang.Long defaultBatchSize) {
        this.defaultBatchSize = defaultBatchSize;
    }

    public java.lang.Long getDefaultBatchStart() {
        return defaultBatchStart;
    }

    public void setDefaultBatchStart(java.lang.Long defaultBatchStart) {
        this.defaultBatchStart = defaultBatchStart;
    }

    public static perturbation.location.PerturbationLocation __L3146;

    public static perturbation.location.PerturbationLocation __L3147;

    public static perturbation.location.PerturbationLocation __L3148;

    public static perturbation.location.PerturbationLocation __L3149;

    public static perturbation.location.PerturbationLocation __L3150;

    public static perturbation.location.PerturbationLocation __L3151;

    public static perturbation.location.PerturbationLocation __L3152;

    public static perturbation.location.PerturbationLocation __L3153;

    public static perturbation.location.PerturbationLocation __L3154;

    public static perturbation.location.PerturbationLocation __L3155;

    public static perturbation.location.PerturbationLocation __L3156;

    public static perturbation.location.PerturbationLocation __L3157;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:69)", 3146, "Numerical");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:70)", 3147, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:72)", 3148, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:77)", 3149, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:79)", 3150, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:80)", 3151, "Numerical");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:80)", 3152, "Numerical");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:80)", 3153, "Numerical");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:81)", 3154, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:93)", 3155, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:101)", 3156, "Boolean");
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.__L3157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/dao/IdGenerationDaoImpl.java:106)", 3157, "Boolean");
    }

    static {
        org.broadleafcommerce.common.id.dao.IdGenerationDaoImpl.initPerturbationLocation0();
    }
}

