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


@java.lang.Deprecated
public class RuntimeEnvironmentPropertiesConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer implements org.springframework.beans.factory.InitializingBean {
    private class PlaceholderResolvingStringValueResolver implements org.springframework.util.StringValueResolver {
        private final org.springframework.util.PropertyPlaceholderHelper helper;

        private final org.springframework.util.PropertyPlaceholderHelper.PlaceholderResolver resolver;

        public PlaceholderResolvingStringValueResolver(java.util.Properties props) {
            this.helper = new org.springframework.util.PropertyPlaceholderHelper("${", "}", ":", true);
            this.resolver = new org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.PropertyPlaceholderConfigurerResolver(props);
        }

        @java.lang.Override
        public java.lang.String resolveStringValue(java.lang.String strVal) throws org.springframework.beans.BeansException {
            java.lang.String value = this.helper.replacePlaceholders(strVal, this.resolver);
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L494, value.equals("")) ? null : value;
        }
    }

    private class PropertyPlaceholderConfigurerResolver implements org.springframework.util.PropertyPlaceholderHelper.PlaceholderResolver {
        private final java.util.Properties props;

        private PropertyPlaceholderConfigurerResolver(java.util.Properties props) {
            this.props = props;
        }

        @java.lang.Override
        public java.lang.String resolvePlaceholder(java.lang.String placeholderName) {
            return org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.this.resolvePlaceholder(placeholderName, props, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L495, 1));
        }
    }

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.class);

    protected org.broadleafcommerce.common.logging.SupportLogger logger = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("UserOverride", this.getClass());

    protected static final java.lang.String SHARED_PROPERTY_OVERRIDE = "property-shared-override";

    protected static final java.lang.String PROPERTY_OVERRIDE = "property-override";

    protected static java.util.Set<java.lang.String> defaultEnvironments = new java.util.LinkedHashSet<>();

    protected static java.util.Set<org.springframework.core.io.Resource> blcPropertyLocations = new java.util.LinkedHashSet<>();

    protected static java.util.Set<org.springframework.core.io.Resource> defaultPropertyLocations = new java.util.LinkedHashSet<>();

    protected java.lang.String defaultEnvironment = "development";

    protected java.lang.String determinedEnvironment = null;

    protected org.broadleafcommerce.common.config.RuntimeEnvironmentKeyResolver keyResolver;

    protected java.util.Set<java.lang.String> environments = java.util.Collections.emptySet();

    protected java.util.Set<org.springframework.core.io.Resource> propertyLocations;

    protected java.util.Set<org.springframework.core.io.Resource> overridableProperyLocations;

    protected org.springframework.util.StringValueResolver stringValueResolver;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.context.ApplicationContext applicationContext;

    @javax.annotation.PostConstruct
    public void init() {
        java.lang.String originatingFile = ((org.springframework.beans.factory.support.BeanDefinitionRegistry) (applicationContext.getAutowireCapableBeanFactory())).getBeanDefinition("blConfiguration").getResourceDescription();
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.LOG.error(((("A blConfiguration bean was detected in " + originatingFile) + ". Any use of blConfiguration and the RuntimeEnvironmentProperitesConfigurer is deprecated and has unknown side-effects. Remove ") + "all instances blConfiguration from all applicationContext.xml files. Use either a FrameworkCommonPropertySource, ProfileAwarePropertySource or a @PropertySource annotation on an @Configuration class"));
    }

    @java.lang.Override
    public void afterPropertiesSet() throws java.io.IOException {
        setIgnoreUnresolvablePlaceholders(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L496, true));
        setNullValue("@null");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L501, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L497, ((environments) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L500, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L498, environments.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L499, 0)))))))) {
            environments = org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultEnvironments;
        }
        java.util.Set<org.springframework.core.io.Resource> combinedLocations = new java.util.LinkedHashSet<>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L503, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L502, org.apache.commons.collections.CollectionUtils.isEmpty(overridableProperyLocations)))))) {
            combinedLocations.addAll(overridableProperyLocations);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L505, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L504, org.apache.commons.collections.CollectionUtils.isEmpty(propertyLocations)))))) {
            combinedLocations.addAll(propertyLocations);
        }
        propertyLocations = combinedLocations;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L507, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L506, environments.contains(defaultEnvironment)))))) {
            throw new java.lang.AssertionError((("Default environment '" + (defaultEnvironment)) + "' not listed in environment list"));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L508, ((keyResolver) == null))) {
            keyResolver = new org.broadleafcommerce.common.config.SystemPropertyRuntimeEnvironmentKeyResolver();
        }
        java.lang.String environment = determineEnvironment();
        java.util.ArrayList<org.springframework.core.io.Resource> allLocations = new java.util.ArrayList<>();
        java.util.Set<java.util.Set<org.springframework.core.io.Resource>> testLocations = new java.util.LinkedHashSet<>();
        testLocations.add(propertyLocations);
        testLocations.add(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultPropertyLocations);
        for (org.springframework.core.io.Resource resource : createBroadleafResource()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L509, resource.exists())) {
                allLocations.add(resource);
            }
        }
        for (java.util.Set<org.springframework.core.io.Resource> locations : testLocations) {
            for (org.springframework.core.io.Resource resource : createSharedCommonResource(locations)) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L510, resource.exists())) {
                    allLocations.add(resource);
                }
            }
            for (org.springframework.core.io.Resource resource : createSharedPropertiesResource(environment, locations)) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L511, resource.exists())) {
                    allLocations.add(resource);
                }
            }
            for (org.springframework.core.io.Resource resource : createCommonResource(locations)) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L512, resource.exists())) {
                    allLocations.add(resource);
                }
            }
            for (org.springframework.core.io.Resource resource : createPropertiesResource(environment, locations)) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L513, resource.exists())) {
                    allLocations.add(resource);
                }
            }
        }
        org.springframework.core.io.Resource sharedPropertyOverride = createSharedOverrideResource();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L514, (sharedPropertyOverride != null))) {
            allLocations.add(sharedPropertyOverride);
        }
        org.springframework.core.io.Resource propertyOverride = createOverrideResource();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L515, (propertyOverride != null))) {
            allLocations.add(propertyOverride);
        }
        java.util.Properties props = new java.util.Properties();
        for (org.springframework.core.io.Resource resource : allLocations) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L516, resource.exists())) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L521, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L519, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L517, resource.equals(sharedPropertyOverride))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L518, resource.equals(propertyOverride)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L520, org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.LOG.isTraceEnabled()))))) {
                    props = new java.util.Properties(props);
                    props.load(resource.getInputStream());
                    for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : props.entrySet()) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L524, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L522, resource.equals(sharedPropertyOverride))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L523, resource.equals(propertyOverride)))))) {
                            logger.support(((("Read " + (entry.getKey())) + " from ") + (resource.getFilename())));
                        }else {
                            org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.LOG.trace(((("Read " + (entry.getKey())) + " from ") + (resource.getFilename())));
                        }
                    }
                }
            }else {
                org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.LOG.debug(("Unable to locate resource: " + (resource.getFilename())));
            }
        }
        setLocations(allLocations.toArray(new org.springframework.core.io.Resource[]{  }));
    }

    protected org.springframework.core.io.Resource[] createSharedPropertiesResource(java.lang.String environment, java.util.Set<org.springframework.core.io.Resource> locations) throws java.io.IOException {
        java.lang.String fileName = (environment.toString().toLowerCase()) + "-shared.properties";
        org.springframework.core.io.Resource[] resources = new org.springframework.core.io.Resource[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L525, locations.size())];
        int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L526, 0);
        for (org.springframework.core.io.Resource resource : locations) {
            resources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L527, index)] = resource.createRelative(fileName);
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L528, (index++));
        }
        return resources;
    }

    protected org.springframework.core.io.Resource[] createBroadleafResource() throws java.io.IOException {
        org.springframework.core.io.Resource[] resources = new org.springframework.core.io.Resource[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L529, org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations.size())];
        int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L530, 0);
        for (org.springframework.core.io.Resource resource : org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations) {
            resources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L531, index)] = resource.createRelative("common.properties");
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L532, (index++));
        }
        return resources;
    }

    protected org.springframework.core.io.Resource[] createSharedCommonResource(java.util.Set<org.springframework.core.io.Resource> locations) throws java.io.IOException {
        org.springframework.core.io.Resource[] resources = new org.springframework.core.io.Resource[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L533, locations.size())];
        int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L534, 0);
        for (org.springframework.core.io.Resource resource : locations) {
            resources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L535, index)] = resource.createRelative("common-shared.properties");
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L536, (index++));
        }
        return resources;
    }

    protected org.springframework.core.io.Resource[] createPropertiesResource(java.lang.String environment, java.util.Set<org.springframework.core.io.Resource> locations) throws java.io.IOException {
        java.lang.String fileName = (environment.toString().toLowerCase()) + ".properties";
        org.springframework.core.io.Resource[] resources = new org.springframework.core.io.Resource[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L537, locations.size())];
        int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L538, 0);
        for (org.springframework.core.io.Resource resource : locations) {
            resources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L539, index)] = resource.createRelative(fileName);
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L540, (index++));
        }
        return resources;
    }

    protected org.springframework.core.io.Resource[] createCommonResource(java.util.Set<org.springframework.core.io.Resource> locations) throws java.io.IOException {
        org.springframework.core.io.Resource[] resources = new org.springframework.core.io.Resource[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L541, locations.size())];
        int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L542, 0);
        for (org.springframework.core.io.Resource resource : locations) {
            resources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L543, index)] = resource.createRelative("common.properties");
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L544, (index++));
        }
        return resources;
    }

    protected org.springframework.core.io.Resource createSharedOverrideResource() throws java.io.IOException {
        java.lang.String path = java.lang.System.getProperty(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.SHARED_PROPERTY_OVERRIDE);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L545, org.apache.commons.lang3.StringUtils.isBlank(path)) ? null : new org.springframework.core.io.FileSystemResource(path);
    }

    protected org.springframework.core.io.Resource createOverrideResource() throws java.io.IOException {
        java.lang.String path = java.lang.System.getProperty(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.PROPERTY_OVERRIDE);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L546, org.apache.commons.lang3.StringUtils.isBlank(path)) ? null : new org.springframework.core.io.FileSystemResource(path);
    }

    public java.lang.String determineEnvironment() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L547, ((determinedEnvironment) != null))) {
            return determinedEnvironment;
        }
        determinedEnvironment = keyResolver.resolveRuntimeEnvironmentKey();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L548, ((determinedEnvironment) == null))) {
            org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.LOG.warn((("Unable to determine runtime environment, using default environment '" + (defaultEnvironment)) + "'"));
            determinedEnvironment = defaultEnvironment;
        }
        return determinedEnvironment.toLowerCase();
    }

    @java.lang.Override
    protected void processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactoryToProcess, java.util.Properties props) throws org.springframework.beans.BeansException {
        super.processProperties(beanFactoryToProcess, props);
        stringValueResolver = new org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.PlaceholderResolvingStringValueResolver(props);
    }

    public void setDefaultEnvironment(java.lang.String defaultEnvironment) {
        this.defaultEnvironment = defaultEnvironment;
    }

    public java.lang.String getDefaultEnvironment() {
        return defaultEnvironment;
    }

    public void setKeyResolver(org.broadleafcommerce.common.config.RuntimeEnvironmentKeyResolver keyResolver) {
        this.keyResolver = keyResolver;
    }

    public void setEnvironments(java.util.Set<java.lang.String> environments) {
        this.environments = environments;
    }

    public void setPropertyLocations(java.util.Set<org.springframework.core.io.Resource> propertyLocations) {
        this.propertyLocations = propertyLocations;
    }

    public void setOverridableProperyLocations(java.util.Set<org.springframework.core.io.Resource> overridableProperyLocations) {
        this.overridableProperyLocations = overridableProperyLocations;
    }

    public org.springframework.util.StringValueResolver getStringValueResolver() {
        return stringValueResolver;
    }

    public static perturbation.location.PerturbationLocation __L494;

    public static perturbation.location.PerturbationLocation __L495;

    public static perturbation.location.PerturbationLocation __L496;

    public static perturbation.location.PerturbationLocation __L497;

    public static perturbation.location.PerturbationLocation __L498;

    public static perturbation.location.PerturbationLocation __L499;

    public static perturbation.location.PerturbationLocation __L500;

    public static perturbation.location.PerturbationLocation __L501;

    public static perturbation.location.PerturbationLocation __L502;

    public static perturbation.location.PerturbationLocation __L503;

    public static perturbation.location.PerturbationLocation __L504;

    public static perturbation.location.PerturbationLocation __L505;

    public static perturbation.location.PerturbationLocation __L506;

    public static perturbation.location.PerturbationLocation __L507;

    public static perturbation.location.PerturbationLocation __L508;

    public static perturbation.location.PerturbationLocation __L509;

    public static perturbation.location.PerturbationLocation __L510;

    public static perturbation.location.PerturbationLocation __L511;

    public static perturbation.location.PerturbationLocation __L512;

    public static perturbation.location.PerturbationLocation __L513;

    public static perturbation.location.PerturbationLocation __L514;

    public static perturbation.location.PerturbationLocation __L515;

    public static perturbation.location.PerturbationLocation __L516;

    public static perturbation.location.PerturbationLocation __L517;

    public static perturbation.location.PerturbationLocation __L518;

    public static perturbation.location.PerturbationLocation __L519;

    public static perturbation.location.PerturbationLocation __L520;

    public static perturbation.location.PerturbationLocation __L521;

    public static perturbation.location.PerturbationLocation __L522;

    public static perturbation.location.PerturbationLocation __L523;

    public static perturbation.location.PerturbationLocation __L524;

    public static perturbation.location.PerturbationLocation __L525;

    public static perturbation.location.PerturbationLocation __L526;

    public static perturbation.location.PerturbationLocation __L527;

    public static perturbation.location.PerturbationLocation __L528;

    public static perturbation.location.PerturbationLocation __L529;

    public static perturbation.location.PerturbationLocation __L530;

    public static perturbation.location.PerturbationLocation __L531;

    public static perturbation.location.PerturbationLocation __L532;

    public static perturbation.location.PerturbationLocation __L533;

    public static perturbation.location.PerturbationLocation __L534;

    public static perturbation.location.PerturbationLocation __L535;

    public static perturbation.location.PerturbationLocation __L536;

    public static perturbation.location.PerturbationLocation __L537;

    public static perturbation.location.PerturbationLocation __L538;

    public static perturbation.location.PerturbationLocation __L539;

    public static perturbation.location.PerturbationLocation __L540;

    public static perturbation.location.PerturbationLocation __L541;

    public static perturbation.location.PerturbationLocation __L542;

    public static perturbation.location.PerturbationLocation __L543;

    public static perturbation.location.PerturbationLocation __L544;

    public static perturbation.location.PerturbationLocation __L545;

    public static perturbation.location.PerturbationLocation __L546;

    public static perturbation.location.PerturbationLocation __L547;

    public static perturbation.location.PerturbationLocation __L548;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:379)", 494, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:393)", 495, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:134)", 496, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:138)", 497, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:138)", 498, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:138)", 499, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:138)", 500, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:138)", 501, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:144)", 502, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:144)", 503, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:148)", 504, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:148)", 505, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:153)", 506, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:153)", 507, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:157)", 508, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:176)", 509, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:183)", 510, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:189)", 511, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:195)", 512, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:201)", 513, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:208)", 514, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:213)", 515, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:219)", 516, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:221)", 517, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:221)", 518, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:221)", 519, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:222)", 520, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:221)", 521, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:226)", 522, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:226)", 523, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:226)", 524, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:243)", 525, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:244)", 526, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:246)", 527, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:247)", 528, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:253)", 529, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:254)", 530, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:256)", 531, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:257)", 532, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:263)", 533, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:264)", 534, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:266)", 535, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:267)", 536, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:274)", 537, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:275)", 538, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:277)", 539, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:278)", 540, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:284)", 541, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:285)", 542, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:287)", 543, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:288)", 544, "Numerical");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:295)", 545, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:300)", 546, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:304)", 547, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.__L548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesConfigurer.java:309)", 548, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultEnvironments.add("production");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultEnvironments.add("staging");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultEnvironments.add("integrationqa");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultEnvironments.add("integrationdev");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultEnvironments.add("development");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations.add(new org.springframework.core.io.ClassPathResource("config/bc/"));
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations.add(new org.springframework.core.io.ClassPathResource("config/bc/admin/"));
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations.add(new org.springframework.core.io.ClassPathResource("config/bc/cms/"));
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations.add(new org.springframework.core.io.ClassPathResource("config/bc/web/"));
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.blcPropertyLocations.add(new org.springframework.core.io.ClassPathResource("config/bc/fw/"));
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.defaultPropertyLocations.add(new org.springframework.core.io.ClassPathResource("runtime-properties/"));
    }

    static {
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesConfigurer.initPerturbationLocation0();
    }
}

