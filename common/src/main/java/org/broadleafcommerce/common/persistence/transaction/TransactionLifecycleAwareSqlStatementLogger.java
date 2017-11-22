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


public class TransactionLifecycleAwareSqlStatementLogger extends org.hibernate.engine.jdbc.spi.SqlStatementLogger {
    public TransactionLifecycleAwareSqlStatementLogger() {
    }

    public TransactionLifecycleAwareSqlStatementLogger(boolean logToStdout, boolean format) {
        super(logToStdout, format);
    }

    @java.lang.Override
    public void logStatement(java.lang.String statement, org.hibernate.engine.jdbc.internal.Formatter formatter) {
        super.logStatement(statement, formatter);
        org.broadleafcommerce.common.persistence.transaction.SqlStatementLoggable monitor = org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.getInstance();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleAwareSqlStatementLogger.__L4200, (monitor != null))) {
            monitor.log(statement);
        }
    }

    public static perturbation.location.PerturbationLocation __L4200;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleAwareSqlStatementLogger.__L4200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleAwareSqlStatementLogger.java:41)", 4200, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleAwareSqlStatementLogger.initPerturbationLocation0();
    }
}

