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


@org.springframework.stereotype.Component("blStreamingTransactionCapableUtil")
@org.springframework.context.annotation.Scope(org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StreamingTransactionCapableUtil implements org.broadleafcommerce.common.util.StreamingTransactionCapable {
    private class Holder {
        private int val;

        public int getVal() {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6606, val);
        }

        public void setVal(int val) {
            this.val = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6607, val);
        }
    }

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.class);

    @javax.annotation.Resource(name = "blTransactionManager")
    protected org.springframework.transaction.PlatformTransactionManager platformTransactionManager;

    protected javax.persistence.EntityManager em;

    @org.springframework.beans.factory.annotation.Value("${streaming.transaction.lock.retry.max}")
    protected int retryMax = 10;

    @org.springframework.beans.factory.annotation.Value("${streaming.transaction.item.page.size}")
    protected int pageSize;

    @javax.annotation.PostConstruct
    public void init() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6608, ((getTransactionManager()) instanceof org.springframework.orm.jpa.JpaTransactionManager))) {
            em = ((org.springframework.orm.jpa.JpaTransactionManager) (getTransactionManager())).getEntityManagerFactory().createEntityManager();
        }
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runStreamingTransactionalOperation(final org.broadleafcommerce.common.util.StreamCapableTransactionalOperation streamOperation, java.lang.Class<G> exceptionType) throws G {
        runStreamingTransactionalOperation(streamOperation, exceptionType, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6609, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRED), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6610, org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT));
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runStreamingTransactionalOperation(final org.broadleafcommerce.common.util.StreamCapableTransactionalOperation streamOperation, java.lang.Class<G> exceptionType, int transactionBehavior, int isolationLevel) throws G {
        final java.lang.Long totalCount = streamOperation.retrieveTotalCount();
        final org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.Holder holder = new org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.Holder();
        holder.setVal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6611, 0));
        org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation = new org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter() {
            @java.lang.Override
            public void execute() throws java.lang.Throwable {
                pagedItems = streamOperation.retrievePage(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6612, holder.getVal()), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6613, pageSize));
                streamOperation.pagedExecute(pagedItems);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6617, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6615, ((java.util.Collection) (pagedItems[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6614, 0)])).size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6616, 0))))) {
                    holder.setVal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6618, totalCount.intValue()));
                }else {
                    holder.setVal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6622, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6619, holder.getVal())) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6621, ((java.util.Collection) (pagedItems[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6620, 0)])).size())))));
                }
            }
        };
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6623, ((holder.getVal()) < totalCount))) {
            runOptionalTransactionalOperation(operation, exceptionType, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6624, true), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6625, transactionBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6626, isolationLevel), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6627, false), getTransactionManager());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6628, ((em) != null))) {
                em.clear();
            }
            streamOperation.executeAfterCommit(((org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter) (operation)).getPagedItems());
        } 
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType) throws G {
        runOptionalTransactionalOperation(operation, exceptionType, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6629, true), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6630, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRED), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6631, org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6632, false), getTransactionManager());
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G {
        runOptionalTransactionalOperation(operation, exceptionType, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6633, true), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6634, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRED), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6635, org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6636, false), transactionManager);
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, int transactionBehavior, int isolationLevel) throws G {
        runOptionalTransactionalOperation(operation, exceptionType, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6637, true), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6638, transactionBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6639, isolationLevel), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6640, false), getTransactionManager());
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runOptionalTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, boolean useTransaction) throws G {
        runOptionalTransactionalOperation(operation, exceptionType, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6641, useTransaction), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6642, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRED), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6643, org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6644, false), getTransactionManager());
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runOptionalTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, boolean useTransaction, int transactionBehavior, int isolationLevel) throws G {
        runOptionalTransactionalOperation(operation, exceptionType, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6645, useTransaction), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6646, transactionBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6647, isolationLevel), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6648, false), getTransactionManager());
    }

    @java.lang.Override
    public void runOptionalEntityManagerInViewOperation(java.lang.Runnable runnable) {
        javax.persistence.EntityManagerFactory emf = ((org.springframework.orm.jpa.JpaTransactionManager) (getTransactionManager())).getEntityManagerFactory();
        boolean isEntityManagerInView = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6649, org.springframework.transaction.support.TransactionSynchronizationManager.hasResource(emf));
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6651, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6650, isEntityManagerInView))))) {
                javax.persistence.EntityManager em = emf.createEntityManager();
                org.springframework.orm.jpa.EntityManagerHolder emHolder = new org.springframework.orm.jpa.EntityManagerHolder(em);
                org.springframework.transaction.support.TransactionSynchronizationManager.bindResource(emf, emHolder);
            }
            runnable.run();
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6653, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6652, isEntityManagerInView))))) {
                org.springframework.orm.jpa.EntityManagerHolder emHolder = ((org.springframework.orm.jpa.EntityManagerHolder) (org.springframework.transaction.support.TransactionSynchronizationManager.unbindResource(emf)));
                org.springframework.orm.jpa.EntityManagerFactoryUtils.closeEntityManager(emHolder.getEntityManager());
            }
        }
    }

    @java.lang.Override
    public <G extends java.lang.Throwable> void runOptionalTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, boolean useTransaction, int transactionBehavior, int isolationLevel, boolean readOnly, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G {
        int maxCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6654, operation.retryMaxCountOverrideForLockAcquisitionFailure());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6658, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6655, maxCount)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6657, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6656, 1)))))))) {
            maxCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6659, retryMax);
        }
        int tryCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6660, 0);
        boolean retry = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6661, false);
        do {
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6669, (tryCount++));
            try {
                org.springframework.transaction.TransactionStatus status = null;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6670, useTransaction)) {
                    status = startTransaction(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6671, transactionBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6672, isolationLevel), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6673, readOnly), transactionManager);
                }
                boolean isError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6674, false);
                try {
                    operation.execute();
                    retry = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6675, false);
                } catch (java.lang.Throwable e) {
                    isError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6676, true);
                    org.broadleafcommerce.common.exception.ExceptionHelper.processException(exceptionType, java.lang.RuntimeException.class, e);
                } finally {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6677, useTransaction)) {
                        endTransaction(status, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6678, isError), exceptionType, transactionManager);
                    }
                }
            } catch (java.lang.RuntimeException e) {
                checkException : {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6679, operation.shouldRetryOnTransactionLockAcquisitionFailure())) {
                        java.lang.Exception result = org.broadleafcommerce.common.exception.ExceptionHelper.refineException(org.hibernate.exception.LockAcquisitionException.class, java.lang.RuntimeException.class, e);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6680, result.getClass().equals(org.hibernate.exception.LockAcquisitionException.class))) {
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6683, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6681, tryCount)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6682, maxCount))))) {
                                try {
                                    java.lang.Thread.sleep(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6684, 300));
                                } catch (java.lang.InterruptedException ie) {
                                }
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6685, org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.LOG.isDebugEnabled())) {
                                    org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.LOG.debug((("Unable to acquire a transaction lock. Retrying - count(" + tryCount) + ")."));
                                }
                                retry = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6686, true);
                                break checkException;
                            }
                            org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.LOG.warn((("Unable to acquire a transaction lock after " + maxCount) + " tries."));
                        }
                    }
                    throw e;
                }
            }
        } while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6668, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6666, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6664, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6662, tryCount)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6663, maxCount))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6665, retry))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6667, operation.shouldRetryOnTransactionLockAcquisitionFailure())))) );
    }

    @java.lang.Override
    public int getPageSize() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6687, pageSize);
    }

    @java.lang.Override
    public void setPageSize(int pageSize) {
        this.pageSize = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6688, pageSize);
    }

    @java.lang.Override
    public org.springframework.transaction.PlatformTransactionManager getTransactionManager() {
        return platformTransactionManager;
    }

    @java.lang.Override
    public void setTransactionManager(org.springframework.transaction.PlatformTransactionManager transactionManager) {
        this.platformTransactionManager = transactionManager;
        init();
    }

    @java.lang.Override
    public int getRetryMax() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6689, retryMax);
    }

    @java.lang.Override
    public void setRetryMax(int retryMax) {
        this.retryMax = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6690, retryMax);
    }

    protected <G extends java.lang.Throwable> void endTransaction(org.springframework.transaction.TransactionStatus status, boolean error, java.lang.Class<G> exceptionType, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G {
        try {
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6691, error));
        } catch (java.lang.Throwable e) {
            org.broadleafcommerce.common.exception.ExceptionHelper.processException(exceptionType, java.lang.RuntimeException.class, e);
        }
    }

    protected org.springframework.transaction.TransactionStatus startTransaction(int propagationBehavior, int isolationLevel, boolean isReadOnly, org.springframework.transaction.PlatformTransactionManager transactionManager) {
        org.springframework.transaction.TransactionStatus status;
        try {
            status = org.broadleafcommerce.common.util.TransactionUtils.createTransaction(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6692, propagationBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6693, isolationLevel), transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6694, isReadOnly));
        } catch (java.lang.RuntimeException e) {
            org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.LOG.error("Could not start transaction", e);
            throw e;
        }
        return status;
    }

    public static perturbation.location.PerturbationLocation __L6606;

    public static perturbation.location.PerturbationLocation __L6607;

    public static perturbation.location.PerturbationLocation __L6608;

    public static perturbation.location.PerturbationLocation __L6609;

    public static perturbation.location.PerturbationLocation __L6610;

    public static perturbation.location.PerturbationLocation __L6611;

    public static perturbation.location.PerturbationLocation __L6612;

    public static perturbation.location.PerturbationLocation __L6613;

    public static perturbation.location.PerturbationLocation __L6614;

    public static perturbation.location.PerturbationLocation __L6615;

    public static perturbation.location.PerturbationLocation __L6616;

    public static perturbation.location.PerturbationLocation __L6617;

    public static perturbation.location.PerturbationLocation __L6618;

    public static perturbation.location.PerturbationLocation __L6619;

    public static perturbation.location.PerturbationLocation __L6620;

    public static perturbation.location.PerturbationLocation __L6621;

    public static perturbation.location.PerturbationLocation __L6622;

    public static perturbation.location.PerturbationLocation __L6623;

    public static perturbation.location.PerturbationLocation __L6624;

    public static perturbation.location.PerturbationLocation __L6625;

    public static perturbation.location.PerturbationLocation __L6626;

    public static perturbation.location.PerturbationLocation __L6627;

    public static perturbation.location.PerturbationLocation __L6628;

    public static perturbation.location.PerturbationLocation __L6629;

    public static perturbation.location.PerturbationLocation __L6630;

    public static perturbation.location.PerturbationLocation __L6631;

    public static perturbation.location.PerturbationLocation __L6632;

    public static perturbation.location.PerturbationLocation __L6633;

    public static perturbation.location.PerturbationLocation __L6634;

    public static perturbation.location.PerturbationLocation __L6635;

    public static perturbation.location.PerturbationLocation __L6636;

    public static perturbation.location.PerturbationLocation __L6637;

    public static perturbation.location.PerturbationLocation __L6638;

    public static perturbation.location.PerturbationLocation __L6639;

    public static perturbation.location.PerturbationLocation __L6640;

    public static perturbation.location.PerturbationLocation __L6641;

    public static perturbation.location.PerturbationLocation __L6642;

    public static perturbation.location.PerturbationLocation __L6643;

    public static perturbation.location.PerturbationLocation __L6644;

    public static perturbation.location.PerturbationLocation __L6645;

    public static perturbation.location.PerturbationLocation __L6646;

    public static perturbation.location.PerturbationLocation __L6647;

    public static perturbation.location.PerturbationLocation __L6648;

    public static perturbation.location.PerturbationLocation __L6649;

    public static perturbation.location.PerturbationLocation __L6650;

    public static perturbation.location.PerturbationLocation __L6651;

    public static perturbation.location.PerturbationLocation __L6652;

    public static perturbation.location.PerturbationLocation __L6653;

    public static perturbation.location.PerturbationLocation __L6654;

    public static perturbation.location.PerturbationLocation __L6655;

    public static perturbation.location.PerturbationLocation __L6656;

    public static perturbation.location.PerturbationLocation __L6657;

    public static perturbation.location.PerturbationLocation __L6658;

    public static perturbation.location.PerturbationLocation __L6659;

    public static perturbation.location.PerturbationLocation __L6660;

    public static perturbation.location.PerturbationLocation __L6661;

    public static perturbation.location.PerturbationLocation __L6662;

    public static perturbation.location.PerturbationLocation __L6663;

    public static perturbation.location.PerturbationLocation __L6664;

    public static perturbation.location.PerturbationLocation __L6665;

    public static perturbation.location.PerturbationLocation __L6666;

    public static perturbation.location.PerturbationLocation __L6667;

    public static perturbation.location.PerturbationLocation __L6668;

    public static perturbation.location.PerturbationLocation __L6669;

    public static perturbation.location.PerturbationLocation __L6670;

    public static perturbation.location.PerturbationLocation __L6671;

    public static perturbation.location.PerturbationLocation __L6672;

    public static perturbation.location.PerturbationLocation __L6673;

    public static perturbation.location.PerturbationLocation __L6674;

    public static perturbation.location.PerturbationLocation __L6675;

    public static perturbation.location.PerturbationLocation __L6676;

    public static perturbation.location.PerturbationLocation __L6677;

    public static perturbation.location.PerturbationLocation __L6678;

    public static perturbation.location.PerturbationLocation __L6679;

    public static perturbation.location.PerturbationLocation __L6680;

    public static perturbation.location.PerturbationLocation __L6681;

    public static perturbation.location.PerturbationLocation __L6682;

    public static perturbation.location.PerturbationLocation __L6683;

    public static perturbation.location.PerturbationLocation __L6684;

    public static perturbation.location.PerturbationLocation __L6685;

    public static perturbation.location.PerturbationLocation __L6686;

    public static perturbation.location.PerturbationLocation __L6687;

    public static perturbation.location.PerturbationLocation __L6688;

    public static perturbation.location.PerturbationLocation __L6689;

    public static perturbation.location.PerturbationLocation __L6690;

    public static perturbation.location.PerturbationLocation __L6691;

    public static perturbation.location.PerturbationLocation __L6692;

    public static perturbation.location.PerturbationLocation __L6693;

    public static perturbation.location.PerturbationLocation __L6694;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:266)", 6606, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:270)", 6607, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:65)", 6608, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:73)", 6609, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:73)", 6610, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:82)", 6611, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:86)", 6612, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:86)", 6613, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:88)", 6614, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:88)", 6615, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:88)", 6616, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:88)", 6617, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:89)", 6618, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:91)", 6619, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:91)", 6620, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:91)", 6621, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:91)", 6622, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:95)", 6623, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:96)", 6624, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:96)", 6625, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:96)", 6626, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:96)", 6627, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:97)", 6628, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:109)", 6629, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:109)", 6630, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:109)", 6631, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:109)", 6632, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:115)", 6633, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:115)", 6634, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:115)", 6635, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:115)", 6636, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:121)", 6637, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:121)", 6638, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:121)", 6639, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:121)", 6640, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:127)", 6641, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:127)", 6642, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:127)", 6643, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:127)", 6644, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:133)", 6645, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:133)", 6646, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:133)", 6647, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:133)", 6648, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:139)", 6649, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:141)", 6650, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:141)", 6651, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:148)", 6652, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:148)", 6653, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:159)", 6654, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:160)", 6655, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:160)", 6656, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:160)", 6657, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:160)", 6658, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:161)", 6659, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:163)", 6660, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:164)", 6661, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6662, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6663, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6664, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6665, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6666, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6667, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:207)", 6668, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:166)", 6669, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:169)", 6670, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:170)", 6671, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:170)", 6672, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:170)", 6673, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:172)", 6674, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:175)", 6675, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:177)", 6676, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:180)", 6677, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:181)", 6678, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:186)", 6679, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:188)", 6680, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:189)", 6681, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:189)", 6682, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:189)", 6683, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:191)", 6684, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:195)", 6685, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:198)", 6686, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:212)", 6687, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:217)", 6688, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:233)", 6689, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:238)", 6690, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:243)", 6691, "Boolean");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:252)", 6692, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:252)", 6693, "Numerical");
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.__L6694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamingTransactionCapableUtil.java:253)", 6694, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.StreamingTransactionCapableUtil.initPerturbationLocation0();
    }
}

