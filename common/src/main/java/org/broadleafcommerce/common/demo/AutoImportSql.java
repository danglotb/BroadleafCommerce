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
package org.broadleafcommerce.common.demo;


public class AutoImportSql implements org.springframework.core.Ordered {
    protected java.lang.String sqlFilePath;

    protected int order = org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_LATE;

    protected java.lang.String persistenceUnit;

    public AutoImportSql() {
    }

    public AutoImportSql(java.lang.String persistenceUnit, java.lang.String sqlFilePath, int order) {
        this.persistenceUnit = persistenceUnit;
        this.sqlFilePath = sqlFilePath;
        this.order = order;
    }

    public java.lang.String getSqlFilePath() {
        return sqlFilePath;
    }

    public void setSqlFilePath(java.lang.String sqlFilePath) {
        this.sqlFilePath = sqlFilePath;
    }

    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.AutoImportSql.__L770, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.AutoImportSql.__L771, order);
    }

    public java.lang.String getPersistenceUnit() {
        return persistenceUnit;
    }

    public void setPersistenceUnit(java.lang.String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    public static perturbation.location.PerturbationLocation __L770;

    public static perturbation.location.PerturbationLocation __L771;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.demo.AutoImportSql.__L770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/AutoImportSql.java:59)", 770, "Numerical");
        org.broadleafcommerce.common.demo.AutoImportSql.__L771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/AutoImportSql.java:63)", 771, "Numerical");
    }

    static {
        org.broadleafcommerce.common.demo.AutoImportSql.initPerturbationLocation0();
    }
}

