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


@org.springframework.context.annotation.Configuration("blCommonData")
@org.springframework.context.annotation.Conditional(org.broadleafcommerce.common.demo.ImportCondition.class)
public class ImportSQLConfig {
    @org.springframework.context.annotation.Bean
    @org.springframework.context.annotation.Conditional(org.broadleafcommerce.common.demo.DemoCondition.class)
    public org.broadleafcommerce.common.demo.AutoImportSql blCommonPreBasicData() {
        return new org.broadleafcommerce.common.demo.AutoImportSql(org.broadleafcommerce.common.demo.AutoImportPersistenceUnit.BL_PU, "config/bc/sql/demo/load_i18n_countries.sql", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.ImportSQLConfig.__L845, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_PRE_BASIC_DATA));
    }

    @org.springframework.context.annotation.Bean
    @org.springframework.context.annotation.Conditional(org.broadleafcommerce.common.demo.DemoCondition.class)
    public org.broadleafcommerce.common.demo.AutoImportSql blCommonBasicData() {
        return new org.broadleafcommerce.common.demo.AutoImportSql(org.broadleafcommerce.common.demo.AutoImportPersistenceUnit.BL_PU, "config/bc/sql/demo/load_admin_users.sql,config/bc/sql/demo/load_sitemap_data.sql", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.ImportSQLConfig.__L846, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_BASIC_DATA));
    }

    @org.springframework.context.annotation.Bean
    @org.springframework.context.annotation.Conditional({ org.broadleafcommerce.common.demo.MTCondition.class, org.broadleafcommerce.common.demo.DemoCondition.class })
    public org.broadleafcommerce.common.demo.AutoImportSql blCommonLateData() {
        return new org.broadleafcommerce.common.demo.AutoImportSql(org.broadleafcommerce.common.demo.AutoImportPersistenceUnit.BL_PU, "config/bc/sql/demo/fix_admin_user_data.sql,config/bc/sql/demo/fix_system_property_data.sql", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.ImportSQLConfig.__L847, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_LATE));
    }

    public static perturbation.location.PerturbationLocation __L845;

    public static perturbation.location.PerturbationLocation __L846;

    public static perturbation.location.PerturbationLocation __L847;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.demo.ImportSQLConfig.__L845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/ImportSQLConfig.java:34)", 845, "Numerical");
        org.broadleafcommerce.common.demo.ImportSQLConfig.__L846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/ImportSQLConfig.java:40)", 846, "Numerical");
        org.broadleafcommerce.common.demo.ImportSQLConfig.__L847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/ImportSQLConfig.java:46)", 847, "Numerical");
    }

    static {
        org.broadleafcommerce.common.demo.ImportSQLConfig.initPerturbationLocation0();
    }
}

