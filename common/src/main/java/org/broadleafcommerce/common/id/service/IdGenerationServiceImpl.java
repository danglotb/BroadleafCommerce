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
package org.broadleafcommerce.common.id.service;


@org.springframework.stereotype.Service("blIdGenerationService")
public class IdGenerationServiceImpl implements org.broadleafcommerce.common.id.service.IdGenerationService {
    private class Id {
        public java.lang.Long nextId;

        public java.lang.Long batchSize;

        public Id(java.lang.Long nextId, java.lang.Long batchSize) {
            this.nextId = nextId;
            this.batchSize = batchSize;
        }
    }

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.class);

    @javax.annotation.Resource(name = "blIdGenerationDao")
    protected org.broadleafcommerce.common.id.dao.IdGenerationDao idGenerationDao;

    protected java.util.Map<java.lang.String, org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.Id> idTypeIdMap = new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.Id>();

    @java.lang.Override
    public java.lang.Long findNextId(java.lang.String idType) {
        return findNextId(idType, null);
    }

    @java.lang.Override
    public java.lang.Long findNextId(java.lang.String idType, java.lang.Long batchSize) {
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.Id id;
        synchronized(idTypeIdMap) {
            id = idTypeIdMap.get(idType);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3255, (id == null))) {
                id = idTypeIdMap.get(idType);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3256, (id == null))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3257, org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.LOG.isDebugEnabled())) {
                        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.LOG.debug("Getting the initial id from the database.");
                    }
                    org.broadleafcommerce.common.id.domain.IdGeneration idGeneration = getCurrentIdRange(idType, batchSize);
                    id = new org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.Id(idGeneration.getBatchStart(), idGeneration.getBatchSize());
                }
                idTypeIdMap.put(idType, id);
            }
        }
        synchronized(id) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3258, ((id.batchSize) == 0L))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3259, org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.LOG.debug(("Updating batch size for idType " + idType));
                }
                org.broadleafcommerce.common.id.domain.IdGeneration idGeneration = getCurrentIdRange(idType, batchSize);
                id.nextId = idGeneration.getBatchStart();
                id.batchSize = idGeneration.getBatchSize();
            }
            java.lang.Long retId = (id.nextId)++;
            (id.batchSize)--;
            return retId;
        }
    }

    private org.broadleafcommerce.common.id.domain.IdGeneration getCurrentIdRange(java.lang.String idType, java.lang.Long batchSize) {
        org.broadleafcommerce.common.id.domain.IdGeneration idGeneration = null;
        int retryCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3260, 0);
        boolean stale = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3261, true);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3262, stale)) {
            try {
                idGeneration = idGenerationDao.findNextId(idType, batchSize);
                stale = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3263, false);
            } catch (javax.persistence.OptimisticLockException e) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3264, org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.LOG.isWarnEnabled())) {
                    org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.LOG.warn((("Error saving batch start for " + idType) + ".  Requerying table."));
                }
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(("Unable to retrieve id range for " + idType), e);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3267, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3265, retryCount)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3266, 10))))) {
                throw new java.lang.RuntimeException((((("Unable to retrieve id range for " + idType) + ". Tried ") + retryCount) + " times, but the version for this entity continues to be concurrently modified."));
            }
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3268, (retryCount++));
        } 
        return idGeneration;
    }

    public static perturbation.location.PerturbationLocation __L3255;

    public static perturbation.location.PerturbationLocation __L3256;

    public static perturbation.location.PerturbationLocation __L3257;

    public static perturbation.location.PerturbationLocation __L3258;

    public static perturbation.location.PerturbationLocation __L3259;

    public static perturbation.location.PerturbationLocation __L3260;

    public static perturbation.location.PerturbationLocation __L3261;

    public static perturbation.location.PerturbationLocation __L3262;

    public static perturbation.location.PerturbationLocation __L3263;

    public static perturbation.location.PerturbationLocation __L3264;

    public static perturbation.location.PerturbationLocation __L3265;

    public static perturbation.location.PerturbationLocation __L3266;

    public static perturbation.location.PerturbationLocation __L3267;

    public static perturbation.location.PerturbationLocation __L3268;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:52)", 3255, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:55)", 3256, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:56)", 3257, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:67)", 3258, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:68)", 3259, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:84)", 3260, "Numerical");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:85)", 3261, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:86)", 3262, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:89)", 3263, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:92)", 3264, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:98)", 3265, "Numerical");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:98)", 3266, "Numerical");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:98)", 3267, "Boolean");
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.__L3268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/service/IdGenerationServiceImpl.java:101)", 3268, "Numerical");
    }

    static {
        org.broadleafcommerce.common.id.service.IdGenerationServiceImpl.initPerturbationLocation0();
    }
}

