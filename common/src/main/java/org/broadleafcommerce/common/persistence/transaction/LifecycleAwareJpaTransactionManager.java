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
package org.broadleafcommerce.common.persistence.transaction;


public class LifecycleAwareJpaTransactionManager extends org.springframework.orm.jpa.JpaTransactionManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.class);

    @org.springframework.beans.factory.annotation.Value("${transaction.lifecycle.events.enabled:false}")
    protected boolean defaultLogEvents = false;

    protected java.lang.Boolean logEvents = null;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.context.ApplicationEventPublisher publisher;

    @java.lang.Override
    protected java.lang.Object doGetTransaction() {
        java.lang.Object transaction = super.doGetTransaction();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4125, isEnabled())) {
            try {
                publisher.publishEvent(new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent(this, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle.GET_TRANSACTION, null, transaction));
            } catch (java.lang.Throwable e) {
                org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.LOG.error("Problem while publishing GET_TRANSACTION lifecycle event. Exception is logged but not bubbled.", e);
            }
        }
        return transaction;
    }

    @java.lang.Override
    protected void doBegin(java.lang.Object transaction, org.springframework.transaction.TransactionDefinition definition) {
        super.doBegin(transaction, definition);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4126, isEnabled())) {
            try {
                publisher.publishEvent(new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent(this, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle.BEGIN, null, transaction, definition));
            } catch (java.lang.Throwable e) {
                org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.LOG.error("Problem while publishing BEGIN lifecycle event. Exception is logged but not bubbled.", e);
            }
        }
    }

    @java.lang.Override
    protected void doCommit(org.springframework.transaction.support.DefaultTransactionStatus status) {
        try {
            super.doCommit(status);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4127, isEnabled())) {
                try {
                    publisher.publishEvent(new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent(this, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle.COMMIT, null, status));
                } catch (java.lang.Throwable e) {
                    org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.LOG.error("Problem while publishing COMMIT lifecycle event. Exception is logged but not bubbled.", e);
                }
            }
        } catch (java.lang.RuntimeException e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4128, isEnabled())) {
                try {
                    publisher.publishEvent(new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent(this, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle.COMMIT, e, status));
                } catch (java.lang.Throwable ex) {
                    org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.LOG.error("Problem while publishing COMMIT lifecycle event. Exception is logged but not bubbled.", ex);
                }
            }
            throw e;
        }
    }

    @java.lang.Override
    protected void doRollback(org.springframework.transaction.support.DefaultTransactionStatus status) {
        try {
            super.doRollback(status);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4129, isEnabled())) {
                try {
                    publisher.publishEvent(new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent(this, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle.ROLLBACK, null, status));
                } catch (java.lang.Throwable e) {
                    org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.LOG.error("Problem while publishing ROLLBACK lifecycle event. Exception is logged but not bubbled.", e);
                }
            }
        } catch (java.lang.RuntimeException e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4130, isEnabled())) {
                try {
                    publisher.publishEvent(new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent(this, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle.ROLLBACK, e, status));
                } catch (java.lang.Throwable ex) {
                    org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.LOG.error("Problem while publishing ROLLBACK lifecycle event. Exception is logged but not bubbled.", ex);
                }
            }
            throw e;
        }
    }

    public java.lang.Boolean getLogEvents() {
        return logEvents;
    }

    public void setLogEvents(java.lang.Boolean logEvents) {
        this.logEvents = logEvents;
    }

    public boolean isEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4135, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4131, (((logEvents) != null) && (logEvents)))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4134, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4132, ((logEvents) == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4133, defaultLogEvents)))))));
    }

    public static perturbation.location.PerturbationLocation __L4125;

    public static perturbation.location.PerturbationLocation __L4126;

    public static perturbation.location.PerturbationLocation __L4127;

    public static perturbation.location.PerturbationLocation __L4128;

    public static perturbation.location.PerturbationLocation __L4129;

    public static perturbation.location.PerturbationLocation __L4130;

    public static perturbation.location.PerturbationLocation __L4131;

    public static perturbation.location.PerturbationLocation __L4132;

    public static perturbation.location.PerturbationLocation __L4133;

    public static perturbation.location.PerturbationLocation __L4134;

    public static perturbation.location.PerturbationLocation __L4135;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:53)", 4125, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:66)", 4126, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:79)", 4127, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:87)", 4128, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:102)", 4129, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:110)", 4130, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:130)", 4131, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:130)", 4132, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:130)", 4133, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:130)", 4134, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.__L4135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJpaTransactionManager.java:130)", 4135, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager.initPerturbationLocation0();
    }
}

