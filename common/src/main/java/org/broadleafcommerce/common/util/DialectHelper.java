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


@org.springframework.stereotype.Repository("blDialectHelper")
public class DialectHelper {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager defaultEntityManager;

    public org.hibernate.dialect.Dialect getHibernateDialect() {
        return getHibernateDialect(defaultEntityManager);
    }

    public org.hibernate.dialect.Dialect getHibernateDialect(javax.persistence.EntityManager em) {
        org.hibernate.engine.spi.SessionFactoryImplementor factory = ((org.hibernate.engine.spi.SessionFactoryImplementor) (em.unwrap(org.hibernate.Session.class).getSessionFactory()));
        return factory.getDialect();
    }

    public boolean isOracle() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6282, ((getHibernateDialect(defaultEntityManager)) instanceof org.hibernate.dialect.Oracle8iDialect));
    }

    public boolean isOracle(javax.persistence.EntityManager em) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6283, ((getHibernateDialect(em)) instanceof org.hibernate.dialect.Oracle8iDialect));
    }

    public boolean isPostgreSql() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6284, ((getHibernateDialect(defaultEntityManager)) instanceof org.hibernate.dialect.PostgreSQL81Dialect));
    }

    public boolean isPostgreSql(javax.persistence.EntityManager em) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6285, ((getHibernateDialect(em)) instanceof org.hibernate.dialect.PostgreSQL81Dialect));
    }

    public boolean isSqlServer() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6286, ((getHibernateDialect(defaultEntityManager)) instanceof org.hibernate.dialect.SQLServerDialect));
    }

    public boolean isSqlServer(javax.persistence.EntityManager em) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6287, ((getHibernateDialect(em)) instanceof org.hibernate.dialect.SQLServerDialect));
    }

    public boolean isMySql() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6288, ((getHibernateDialect(defaultEntityManager)) instanceof org.hibernate.dialect.MySQLDialect));
    }

    public boolean isMySql(javax.persistence.EntityManager em) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DialectHelper.__L6289, ((getHibernateDialect(em)) instanceof org.hibernate.dialect.MySQLDialect));
    }

    public static perturbation.location.PerturbationLocation __L6282;

    public static perturbation.location.PerturbationLocation __L6283;

    public static perturbation.location.PerturbationLocation __L6284;

    public static perturbation.location.PerturbationLocation __L6285;

    public static perturbation.location.PerturbationLocation __L6286;

    public static perturbation.location.PerturbationLocation __L6287;

    public static perturbation.location.PerturbationLocation __L6288;

    public static perturbation.location.PerturbationLocation __L6289;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.DialectHelper.__L6282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:53)", 6282, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:58)", 6283, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:63)", 6284, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:68)", 6285, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:72)", 6286, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:76)", 6287, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:80)", 6288, "Boolean");
        org.broadleafcommerce.common.util.DialectHelper.__L6289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DialectHelper.java:84)", 6289, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.DialectHelper.initPerturbationLocation0();
    }
}

