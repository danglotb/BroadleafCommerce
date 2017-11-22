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
package org.broadleafcommerce.common.extensibility.jpa;


public class ORMConfigPersistenceUnitPostProcessor implements org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor {
    @org.springframework.beans.factory.annotation.Autowired(required = false)
    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.ORMConfigDto> configs = new java.util.ArrayList<>();

    @java.lang.Override
    public void postProcessPersistenceUnitInfo(org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo pui) {
        java.lang.String puName = pui.getPersistenceUnitName();
        for (org.broadleafcommerce.common.extensibility.jpa.ORMConfigDto config : configs) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.__L2351, puName.equals(config.getPuName()))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.__L2352, org.apache.commons.collections4.CollectionUtils.isNotEmpty(config.getClassNames()))) {
                    pui.getManagedClassNames().addAll(config.getClassNames());
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.__L2353, org.apache.commons.collections4.CollectionUtils.isNotEmpty(config.getMappingFiles()))) {
                    pui.getMappingFileNames().addAll(config.getMappingFiles());
                }
            }
        }
    }

    public static perturbation.location.PerturbationLocation __L2351;

    public static perturbation.location.PerturbationLocation __L2352;

    public static perturbation.location.PerturbationLocation __L2353;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.__L2351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/ORMConfigPersistenceUnitPostProcessor.java:43)", 2351, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.__L2352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/ORMConfigPersistenceUnitPostProcessor.java:44)", 2352, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.__L2353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/ORMConfigPersistenceUnitPostProcessor.java:47)", 2353, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.ORMConfigPersistenceUnitPostProcessor.initPerturbationLocation0();
    }
}

