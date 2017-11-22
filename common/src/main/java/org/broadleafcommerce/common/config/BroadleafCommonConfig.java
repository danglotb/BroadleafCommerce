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
package org.broadleafcommerce.common.config;


@org.springframework.context.annotation.Configuration
public class BroadleafCommonConfig {
    @org.springframework.context.annotation.Bean
    @org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean(name = "blJpaVendorAdapter")
    public org.springframework.orm.jpa.JpaVendorAdapter blJpaVendorAdapter() {
        org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter vendorAdapter = new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter();
        vendorAdapter.setPrepareConnection(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafCommonConfig.__L472, false));
        return vendorAdapter;
    }

    public static perturbation.location.PerturbationLocation __L472;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.BroadleafCommonConfig.__L472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafCommonConfig.java:47)", 472, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.BroadleafCommonConfig.initPerturbationLocation0();
    }
}

