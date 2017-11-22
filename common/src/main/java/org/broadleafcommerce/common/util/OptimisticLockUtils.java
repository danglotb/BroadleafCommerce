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
package org.broadleafcommerce.common.util;


@lombok.extern.apachecommons.CommonsLog
public class OptimisticLockUtils {
    public interface UpdateOperation<T> {
        void update(T t);
    }

    public interface ValidatedUpdateOperation<T> extends org.broadleafcommerce.common.util.OptimisticLockUtils.UpdateOperation<T> {
        boolean isValid(T t);
    }

    public static <T> T performOptimisticLockUpdate(java.lang.String name, org.broadleafcommerce.common.util.OptimisticLockUtils.UpdateOperation<T> operation, java.lang.Class<? extends T> entityClass, java.lang.Object identifier, int maxRetryCount, org.springframework.transaction.PlatformTransactionManager transactionManager, javax.persistence.EntityManager entityManager) throws org.broadleafcommerce.common.exception.OptimisticLockInvalidStateException, org.broadleafcommerce.common.exception.OptimisticLockMaxRetryException {
        int retryCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6457, 0);
        boolean saveSuccessful = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6458, false);
        T entity = null;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6460, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6459, saveSuccessful))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6463, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6461, retryCount)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6462, maxRetryCount))))) {
                log.debug(((((("Max retry count was reached while trying to perform " + name) + " on ") + (entityClass.getSimpleName())) + " with id: ") + identifier));
                throw new org.broadleafcommerce.common.exception.OptimisticLockMaxRetryException(((((((((("Unable to perform " + name) + " on ") + (entityClass.getSimpleName())) + " with id: ") + identifier) + ". ") + "Tried ") + retryCount) + " times, but the version for this entity continues to be concurrently modified."));
            }
            try {
                entity = org.broadleafcommerce.common.util.OptimisticLockUtils.doTransactionalOptimisticUpdate(name, operation, entityClass, identifier, transactionManager, entityManager);
                saveSuccessful = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6464, true);
                log.debug((((((((name + " for ") + (entityClass.getSimpleName())) + " with ID: ") + identifier) + " performed ") + retryCount) + " retries."));
            } catch (javax.persistence.OptimisticLockException e) {
                log.debug(((("Optimistic locking failure. Concurrent modification detected when attempting to modify " + (entityClass.getSimpleName())) + " with id: ") + identifier));
            }
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6465, (retryCount++));
        } 
        return entity;
    }

    protected static <T> T doTransactionalOptimisticUpdate(java.lang.String name, org.broadleafcommerce.common.util.OptimisticLockUtils.UpdateOperation<T> operation, java.lang.Class<? extends T> entityClass, java.lang.Object identifier, org.springframework.transaction.PlatformTransactionManager transactionManager, javax.persistence.EntityManager entityManager) {
        org.springframework.transaction.TransactionStatus transactionStatus = org.broadleafcommerce.common.util.TransactionUtils.createTransaction(name, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6466, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRES_NEW), transactionManager);
        T entity;
        try {
            entity = entityManager.find(entityClass, identifier);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6470, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6467, (operation instanceof org.broadleafcommerce.common.util.OptimisticLockUtils.ValidatedUpdateOperation))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6469, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6468, ((org.broadleafcommerce.common.util.OptimisticLockUtils.ValidatedUpdateOperation<T>) (operation)).isValid(entity))))))))) {
                log.debug(((((("Entity state was found to be invalid while trying to perform " + name) + " on ") + (entityClass.getSimpleName())) + " with id: ") + identifier));
                throw new org.broadleafcommerce.common.exception.OptimisticLockInvalidStateException((((((("Unable to perform " + name) + " on ") + (entityClass.getSimpleName())) + " with id: ") + identifier) + ". Aborting update due to invalid state."));
            }
            operation.update(entity);
            entityManager.flush();
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(transactionStatus, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6471, false));
        } catch (java.lang.RuntimeException e) {
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(transactionStatus, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.OptimisticLockUtils.__L6472, true));
            throw e;
        }
        return entity;
    }

    public static perturbation.location.PerturbationLocation __L6457;

    public static perturbation.location.PerturbationLocation __L6458;

    public static perturbation.location.PerturbationLocation __L6459;

    public static perturbation.location.PerturbationLocation __L6460;

    public static perturbation.location.PerturbationLocation __L6461;

    public static perturbation.location.PerturbationLocation __L6462;

    public static perturbation.location.PerturbationLocation __L6463;

    public static perturbation.location.PerturbationLocation __L6464;

    public static perturbation.location.PerturbationLocation __L6465;

    public static perturbation.location.PerturbationLocation __L6466;

    public static perturbation.location.PerturbationLocation __L6467;

    public static perturbation.location.PerturbationLocation __L6468;

    public static perturbation.location.PerturbationLocation __L6469;

    public static perturbation.location.PerturbationLocation __L6470;

    public static perturbation.location.PerturbationLocation __L6471;

    public static perturbation.location.PerturbationLocation __L6472;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:91)", 6457, "Numerical");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:92)", 6458, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:94)", 6459, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:94)", 6460, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:95)", 6461, "Numerical");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:95)", 6462, "Numerical");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:95)", 6463, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:102)", 6464, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:108)", 6465, "Numerical");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:116)", 6466, "Numerical");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:121)", 6467, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:121)", 6468, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:121)", 6469, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:121)", 6470, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:128)", 6471, "Boolean");
        org.broadleafcommerce.common.util.OptimisticLockUtils.__L6472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/OptimisticLockUtils.java:131)", 6472, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.OptimisticLockUtils.initPerturbationLocation0();
    }
}

