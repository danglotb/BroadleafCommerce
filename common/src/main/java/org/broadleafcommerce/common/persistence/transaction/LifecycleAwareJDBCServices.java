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


public class LifecycleAwareJDBCServices extends org.hibernate.engine.jdbc.internal.JdbcServicesImpl {
    @java.lang.Override
    public org.hibernate.engine.jdbc.spi.SqlStatementLogger getSqlStatementLogger() {
        org.hibernate.engine.jdbc.spi.SqlStatementLogger defaultLogger = super.getSqlStatementLogger();
        return new org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleAwareSqlStatementLogger(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices.__L4123, defaultLogger.isLogToStdout()), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices.__L4124, defaultLogger.isFormat()));
    }

    public static perturbation.location.PerturbationLocation __L4123;

    public static perturbation.location.PerturbationLocation __L4124;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices.__L4123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJDBCServices.java:36)", 4123, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices.__L4124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/LifecycleAwareJDBCServices.java:36)", 4124, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices.initPerturbationLocation0();
    }
}

