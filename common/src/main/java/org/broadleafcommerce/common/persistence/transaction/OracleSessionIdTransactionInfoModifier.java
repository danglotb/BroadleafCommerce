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


public class OracleSessionIdTransactionInfoModifier implements org.broadleafcommerce.common.persistence.transaction.TransactionInfoCustomModifier {
    @java.lang.Override
    public void modify(org.broadleafcommerce.common.persistence.transaction.TransactionInfo info) {
        javax.persistence.EntityManager em = info.getEntityManager();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4136, (em != null))) {
            java.lang.Integer sid = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4143, em.unwrap(org.hibernate.Session.class).doReturningWork(new org.hibernate.jdbc.ReturningWork<java.lang.Integer>() {
                @java.lang.Override
                public java.lang.Integer execute(java.sql.Connection connection) throws java.sql.SQLException {
                    java.sql.Statement statement = null;
                    java.sql.ResultSet resultSet = null;
                    try {
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery("SELECT sys_context('userenv','sid') FROM dual");
                        java.lang.Integer response = null;
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4137, resultSet.next())) {
                            response = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4139, resultSet.getInt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4138, 1)));
                        }
                        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4140, response);
                    } finally {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4141, (resultSet != null))) {
                            try {
                                resultSet.close();
                            } catch (java.lang.Throwable e) {
                            }
                        }
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4142, (statement != null))) {
                            try {
                                statement.close();
                            } catch (java.lang.Throwable e) {
                            }
                        }
                    }
                }
            }));
            info.getAdditionalParams().put("sessionid", (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4144, (sid == null)) ? "UNKNOWN" : java.lang.String.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4145, sid))));
        }
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4146, 0);
    }

    public static perturbation.location.PerturbationLocation __L4136;

    public static perturbation.location.PerturbationLocation __L4137;

    public static perturbation.location.PerturbationLocation __L4138;

    public static perturbation.location.PerturbationLocation __L4139;

    public static perturbation.location.PerturbationLocation __L4140;

    public static perturbation.location.PerturbationLocation __L4141;

    public static perturbation.location.PerturbationLocation __L4142;

    public static perturbation.location.PerturbationLocation __L4143;

    public static perturbation.location.PerturbationLocation __L4144;

    public static perturbation.location.PerturbationLocation __L4145;

    public static perturbation.location.PerturbationLocation __L4146;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:39)", 4136, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:49)", 4137, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:50)", 4138, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:50)", 4139, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:52)", 4140, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:54)", 4141, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:59)", 4142, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:40)", 4143, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:67)", 4144, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:67)", 4145, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.__L4146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/OracleSessionIdTransactionInfoModifier.java:73)", 4146, "Numerical");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.OracleSessionIdTransactionInfoModifier.initPerturbationLocation0();
    }
}

