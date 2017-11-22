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
package org.broadleafcommerce.common.config.service;


@org.springframework.stereotype.Component("blSystemPropertiesPropertySourceRegistrar")
public class SystemPropertiesPropertySourceRegistrar {
    protected static class SystemPropertyPropertySource extends org.springframework.core.env.PropertySource<org.broadleafcommerce.common.config.service.SystemPropertiesService> {
        public SystemPropertyPropertySource(java.lang.String name, org.broadleafcommerce.common.config.service.SystemPropertiesService source) {
            super(name, source);
        }

        @java.lang.Override
        public java.lang.Object getProperty(java.lang.String name) {
            org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.originatedFromEnvironment.set(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource.__L410, true));
            java.lang.Object property = source.resolveSystemProperty(name);
            org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.originatedFromEnvironment.set(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource.__L411, false));
            return property;
        }

        public static perturbation.location.PerturbationLocation __L410;

        public static perturbation.location.PerturbationLocation __L411;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource.__L410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesPropertySourceRegistrar.java:66)", 410, "Boolean");
            org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource.__L411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesPropertySourceRegistrar.java:68)", 411, "Boolean");
        }

        static {
            org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource.initPerturbationLocation0();
        }
    }

    @org.springframework.beans.factory.annotation.Autowired
    protected org.broadleafcommerce.common.config.service.SystemPropertiesService propsSvc;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.core.env.Environment env;

    @org.springframework.context.event.EventListener
    public void registerSystemPropertySource(org.springframework.context.event.ContextRefreshedEvent refreshed) {
        org.springframework.core.env.ConfigurableEnvironment mutableEnv = ((org.springframework.core.env.ConfigurableEnvironment) (env));
        mutableEnv.getPropertySources().addFirst(new org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.PROPERTY_SOURCE_NAME, propsSvc));
    }
}

