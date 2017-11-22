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


public class TransactionUtils {
    public static final java.lang.String DEFAULT_TRANSACTION_MANAGER = "blTransactionManager";

    public static final java.lang.String EVENT_TRANSACTION_MANAGER = "blTransactionManagerEventInfo";

    public static final java.lang.String SECURE_TRANSACTION_MANAGER = "blTransactionManagerSecureInfo";

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.TransactionUtils.class);

    public static org.hibernate.Transaction createTransaction(org.hibernate.Session session) {
        return session.beginTransaction();
    }

    public static org.springframework.transaction.TransactionStatus createTransaction(java.lang.String name, int propagationBehavior, org.springframework.transaction.PlatformTransactionManager transactionManager) {
        return org.broadleafcommerce.common.util.TransactionUtils.createTransaction(name, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6780, propagationBehavior), transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6781, false));
    }

    public static org.springframework.transaction.TransactionStatus createTransaction(java.lang.String name, int propagationBehavior, org.springframework.transaction.PlatformTransactionManager transactionManager, boolean isReadOnly) {
        return org.broadleafcommerce.common.util.TransactionUtils.createTransaction(name, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6782, propagationBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6783, org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT), transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6784, isReadOnly));
    }

    public static org.springframework.transaction.TransactionStatus createTransaction(java.lang.String name, int propagationBehavior, int isolationLevel, org.springframework.transaction.PlatformTransactionManager transactionManager, boolean isReadOnly) {
        org.springframework.transaction.support.DefaultTransactionDefinition def = new org.springframework.transaction.support.DefaultTransactionDefinition();
        def.setName(name);
        def.setReadOnly(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6785, isReadOnly));
        def.setPropagationBehavior(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6786, propagationBehavior));
        def.setIsolationLevel(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6787, isolationLevel));
        return transactionManager.getTransaction(def);
    }

    public static org.springframework.transaction.TransactionStatus createTransaction(int propagationBehavior, org.springframework.transaction.PlatformTransactionManager transactionManager, boolean isReadOnly) {
        return org.broadleafcommerce.common.util.TransactionUtils.createTransaction(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6788, propagationBehavior), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6789, org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT), transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6790, isReadOnly));
    }

    public static org.springframework.transaction.TransactionStatus createTransaction(int propagationBehavior, int isolationLevel, org.springframework.transaction.PlatformTransactionManager transactionManager, boolean isReadOnly) {
        org.springframework.transaction.support.DefaultTransactionDefinition def = new org.springframework.transaction.support.DefaultTransactionDefinition();
        def.setReadOnly(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6791, isReadOnly));
        def.setPropagationBehavior(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6792, propagationBehavior));
        def.setIsolationLevel(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TransactionUtils.__L6793, isolationLevel));
        return transactionManager.getTransaction(def);
    }

    public static boolean isTransactionalEntityManager(javax.persistence.EntityManager em) {
        javax.persistence.EntityManager target = org.springframework.orm.jpa.EntityManagerFactoryUtils.doGetTransactionalEntityManager(em.getEntityManagerFactory(), em.getProperties(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6794, true));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6795, (target != null));
    }

    public static void finalizeTransaction(org.hibernate.Transaction transaction, boolean isError) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6796, isError)) {
            try {
                transaction.rollback();
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.util.TransactionUtils.LOG.error("Rolling back caused exception. Logging and continuing.", e);
            }
        }else {
            transaction.commit();
        }
    }

    public static void finalizeTransaction(org.springframework.transaction.TransactionStatus status, org.springframework.transaction.PlatformTransactionManager transactionManager, boolean isError) {
        boolean isActive = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6797, false);
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6799, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6798, status.isRollbackOnly()))))) {
                isActive = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6800, true);
            }
        } catch (java.lang.Exception e) {
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6804, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6801, isError)) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6803, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TransactionUtils.__L6802, isActive)))))))) {
            try {
                transactionManager.rollback(status);
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.util.TransactionUtils.LOG.error("Rolling back caused exception. Logging and continuing.", e);
            }
        }else {
            transactionManager.commit(status);
        }
    }

    public static perturbation.location.PerturbationLocation __L6780;

    public static perturbation.location.PerturbationLocation __L6781;

    public static perturbation.location.PerturbationLocation __L6782;

    public static perturbation.location.PerturbationLocation __L6783;

    public static perturbation.location.PerturbationLocation __L6784;

    public static perturbation.location.PerturbationLocation __L6785;

    public static perturbation.location.PerturbationLocation __L6786;

    public static perturbation.location.PerturbationLocation __L6787;

    public static perturbation.location.PerturbationLocation __L6788;

    public static perturbation.location.PerturbationLocation __L6789;

    public static perturbation.location.PerturbationLocation __L6790;

    public static perturbation.location.PerturbationLocation __L6791;

    public static perturbation.location.PerturbationLocation __L6792;

    public static perturbation.location.PerturbationLocation __L6793;

    public static perturbation.location.PerturbationLocation __L6794;

    public static perturbation.location.PerturbationLocation __L6795;

    public static perturbation.location.PerturbationLocation __L6796;

    public static perturbation.location.PerturbationLocation __L6797;

    public static perturbation.location.PerturbationLocation __L6798;

    public static perturbation.location.PerturbationLocation __L6799;

    public static perturbation.location.PerturbationLocation __L6800;

    public static perturbation.location.PerturbationLocation __L6801;

    public static perturbation.location.PerturbationLocation __L6802;

    public static perturbation.location.PerturbationLocation __L6803;

    public static perturbation.location.PerturbationLocation __L6804;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.TransactionUtils.__L6780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:62)", 6780, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:62)", 6781, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:66)", 6782, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:66)", 6783, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:66)", 6784, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:72)", 6785, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:73)", 6786, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:74)", 6787, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:79)", 6788, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:79)", 6789, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:79)", 6790, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:84)", 6791, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:85)", 6792, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:86)", 6793, "Numerical");
        org.broadleafcommerce.common.util.TransactionUtils.__L6794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:92)", 6794, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:93)", 6795, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:97)", 6796, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:109)", 6797, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:111)", 6798, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:111)", 6799, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:112)", 6800, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:117)", 6801, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:117)", 6802, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:117)", 6803, "Boolean");
        org.broadleafcommerce.common.util.TransactionUtils.__L6804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TransactionUtils.java:117)", 6804, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.TransactionUtils.initPerturbationLocation0();
    }
}

