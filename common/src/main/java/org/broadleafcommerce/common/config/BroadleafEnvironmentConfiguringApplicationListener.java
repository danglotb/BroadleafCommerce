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


public class BroadleafEnvironmentConfiguringApplicationListener implements org.springframework.context.ApplicationContextInitializer<org.springframework.context.ConfigurableApplicationContext> {
    public static final java.lang.String PROPERTY_OVERRIDES_PROPERTY = "property-override";

    public static final java.lang.String PROPERTY_SHARED_OVERRIDES_PROPERTY = "property-shared-override";

    public static final java.lang.String DEPRECATED_RUNTIME_ENVIRONMENT_KEY = "runtime.environment";

    public static final java.lang.String FRAMEWORK_SOURCES_NAME = "broadleafFrameworkSources";

    public static final java.lang.String PROFILE_AWARE_SOURCES_NAME = "broadleafProfileAwareSources";

    public static final java.lang.String SHARED_OVERRIDE_SOURCES_NAME = "broadleafCommandlineArgumentSharedOverridesSource";

    public static final java.lang.String OVERRIDE_SOURCES_NAME = "broadleafCommandlineArgumentOverridesSource";

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.class);

    protected java.util.List<org.broadleafcommerce.common.config.FrameworkCommonClasspathPropertySource> getFrameworkSources() {
        return org.springframework.core.io.support.SpringFactoriesLoader.loadFactories(org.broadleafcommerce.common.config.FrameworkCommonClasspathPropertySource.class, null);
    }

    protected java.util.List<org.broadleafcommerce.common.config.BroadleafSharedOverrideProfileAwarePropertySource> getProfileAwareSources() {
        return org.springframework.core.io.support.SpringFactoriesLoader.loadFactories(org.broadleafcommerce.common.config.BroadleafSharedOverrideProfileAwarePropertySource.class, null);
    }

    @java.lang.Override
    public void initialize(org.springframework.context.ConfigurableApplicationContext applicationContext) {
        org.springframework.core.env.ConfigurableEnvironment env = applicationContext.getEnvironment();
        java.util.List<org.broadleafcommerce.common.config.FrameworkCommonClasspathPropertySource> frameworkSources = getFrameworkSources();
        for (org.broadleafcommerce.common.config.FrameworkCommonClasspathPropertySource source : frameworkSources) {
            java.lang.String configLocation = source.getClasspathFolder();
            org.springframework.core.io.Resource commonProp = createClasspathResource(configLocation, "common", null);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L473, commonProp.exists())) {
                addToEnvironment(env, java.util.Arrays.asList(commonProp), org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.FRAMEWORK_SOURCES_NAME, null);
            }
        }
        java.lang.String deprecatedRuntimeEnvironment = env.getProperty(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.DEPRECATED_RUNTIME_ENVIRONMENT_KEY);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L474, org.apache.commons.lang3.StringUtils.isNotBlank(deprecatedRuntimeEnvironment))) {
            org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.warn(((("The use of -Druntime.environment is deprecated in favor of Spring Profiles and will be removed in a future release. To specify a profile as a -D argument use -Dspring.profiles.active as a drop-in replacement" + " for -Druntime.environment. Adding ") + deprecatedRuntimeEnvironment) + " to the list of active Spring profiles."));
            env.addActiveProfile(deprecatedRuntimeEnvironment);
        }
        java.util.List<org.springframework.core.io.Resource> commonSharedResources = new java.util.ArrayList<>();
        java.util.List<org.springframework.core.io.Resource> commonResources = new java.util.ArrayList<>();
        java.util.List<org.springframework.core.io.Resource> profileSpecificSharedResources = new java.util.ArrayList<>();
        java.util.List<org.springframework.core.io.Resource> profileSpecificResources = new java.util.ArrayList<>();
        java.util.List<org.broadleafcommerce.common.config.BroadleafSharedOverrideProfileAwarePropertySource> profileAwareSources = getProfileAwareSources();
        for (org.broadleafcommerce.common.config.BroadleafSharedOverrideProfileAwarePropertySource source : profileAwareSources) {
            java.lang.String configLocation = source.getClasspathFolder();
            org.springframework.core.io.Resource commonSharedProp = createClasspathResource(configLocation, "common", "shared");
            commonSharedResources.add(commonSharedProp);
            org.springframework.core.io.Resource commonProp = createClasspathResource(configLocation, "common", null);
            commonResources.add(commonProp);
            java.lang.String[] activeProfiles = env.getActiveProfiles();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L475, org.apache.commons.lang3.ArrayUtils.isNotEmpty(activeProfiles))) {
                for (java.lang.String profile : activeProfiles) {
                    org.springframework.core.io.Resource profileSpecificSharedProps = createClasspathResource(configLocation, profile, "shared");
                    profileSpecificSharedResources.add(profileSpecificSharedProps);
                    org.springframework.core.io.Resource profileSpecificProps = createClasspathResource(configLocation, profile, null);
                    profileSpecificResources.add(profileSpecificProps);
                }
            }else {
                java.lang.String[] defaultProfiles = env.getDefaultProfiles();
                for (java.lang.String defaultProfile : defaultProfiles) {
                    org.springframework.core.io.Resource profileSpecificSharedProps = createClasspathResource(configLocation, defaultProfile, "shared");
                    profileSpecificSharedResources.add(profileSpecificSharedProps);
                    org.springframework.core.io.Resource profileSpecificProps = createClasspathResource(configLocation, defaultProfile, null);
                    profileSpecificResources.add(profileSpecificProps);
                }
                java.lang.String deprecatedDefaultProfile = getDeprecatedDefaultProfileKey();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L477, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L476, org.apache.commons.lang3.ArrayUtils.contains(defaultProfiles, deprecatedDefaultProfile)))))) {
                    org.springframework.core.io.Resource developmentSharedProps = createClasspathResource(configLocation, deprecatedDefaultProfile, "shared");
                    profileSpecificSharedResources.add(developmentSharedProps);
                    org.springframework.core.io.Resource developmentProps = createClasspathResource(configLocation, deprecatedDefaultProfile, null);
                    profileSpecificResources.add(developmentProps);
                    boolean deprecatedDefaultProfileFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L480, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L478, developmentSharedProps.exists())) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L479, developmentProps.exists()))));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L481, deprecatedDefaultProfileFound)) {
                        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.warn(((("The usage of " + (getDeprecatedDefaultProfileKey())) + ".properties is deprecated and will be removed in a future release. Use Spring's default profile properties of 'default.properties'.") + " Alternatively, set the 'spring.profiles.default' system property with -Dspring.profiles.default=development to change the default profile name that Spring runs in."));
                        env.setDefaultProfiles(org.apache.commons.lang3.ArrayUtils.add(defaultProfiles, deprecatedDefaultProfile));
                    }
                }
            }
        }
        addToEnvironment(env, commonSharedResources, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROFILE_AWARE_SOURCES_NAME, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.FRAMEWORK_SOURCES_NAME);
        addToEnvironment(env, commonResources, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROFILE_AWARE_SOURCES_NAME, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.FRAMEWORK_SOURCES_NAME);
        addToEnvironment(env, profileSpecificSharedResources, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROFILE_AWARE_SOURCES_NAME, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.FRAMEWORK_SOURCES_NAME);
        addToEnvironment(env, profileSpecificResources, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROFILE_AWARE_SOURCES_NAME, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.FRAMEWORK_SOURCES_NAME);
        java.lang.String sharedOverrideFileLocation = env.getProperty(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROPERTY_SHARED_OVERRIDES_PROPERTY);
        java.lang.String currentHighestPrecedenceProperties = org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROFILE_AWARE_SOURCES_NAME;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L482, org.apache.commons.lang3.StringUtils.isNotBlank(sharedOverrideFileLocation))) {
            org.springframework.core.io.Resource sharedOverrideFileResource = new org.springframework.core.io.FileSystemResource(sharedOverrideFileLocation);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L483, sharedOverrideFileResource.exists())) {
                addToEnvironment(env, java.util.Arrays.asList(sharedOverrideFileResource), org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.SHARED_OVERRIDE_SOURCES_NAME, org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROFILE_AWARE_SOURCES_NAME);
                currentHighestPrecedenceProperties = org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.SHARED_OVERRIDE_SOURCES_NAME;
            }else {
                org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.warn(java.lang.String.format("An environment property of %s was specified but the file path %s does not exist, not overriding properties", org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROPERTY_SHARED_OVERRIDES_PROPERTY, sharedOverrideFileLocation));
            }
        }
        java.lang.String overrideFileLocation = env.getProperty(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROPERTY_OVERRIDES_PROPERTY);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L484, org.apache.commons.lang3.StringUtils.isNotBlank(overrideFileLocation))) {
            org.springframework.core.io.Resource overrideFileResource = new org.springframework.core.io.FileSystemResource(overrideFileLocation);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L485, overrideFileResource.exists())) {
                addToEnvironment(env, java.util.Arrays.asList(overrideFileResource), org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.OVERRIDE_SOURCES_NAME, currentHighestPrecedenceProperties);
            }else {
                org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.warn(java.lang.String.format("An environment property of %s was specified but the file path %s does not exist, not overriding properties", org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.PROPERTY_OVERRIDES_PROPERTY, overrideFileLocation));
            }
        }
    }

    protected org.springframework.core.io.Resource createClasspathResource(java.lang.String rootLocation, java.lang.String propertyName, java.lang.String suffix) {
        suffix = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L486, org.apache.commons.lang3.StringUtils.isEmpty(suffix))) ? "" : "-" + suffix;
        java.lang.String fileName = (propertyName + suffix) + ".properties";
        return new org.springframework.core.io.ClassPathResource(org.apache.commons.io.FilenameUtils.concat(rootLocation, fileName));
    }

    protected void addToEnvironment(org.springframework.core.env.ConfigurableEnvironment environment, java.util.List<org.springframework.core.io.Resource> resources, java.lang.String compositeSourceName, java.lang.String addBeforeSourceName) {
        try {
            for (org.springframework.core.io.Resource resource : resources) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L488, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L487, resource.exists()))))) {
                    org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.debug(((resource.getDescription()) + " does not exist, skipping adding to the Environment"));
                    continue;
                }
                org.springframework.core.env.PropertySource<?> props = new org.springframework.core.io.support.ResourcePropertySource(resource);
                org.springframework.core.env.CompositePropertySource compositeSource = ((org.springframework.core.env.CompositePropertySource) (environment.getPropertySources().get(compositeSourceName)));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L489, (compositeSource == null))) {
                    compositeSource = new org.springframework.core.env.CompositePropertySource(compositeSourceName);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L490, (addBeforeSourceName == null))) {
                        environment.getPropertySources().addLast(compositeSource);
                    }else {
                        environment.getPropertySources().addBefore(addBeforeSourceName, compositeSource);
                    }
                    org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.debug((("Added new composite property source source " + (compositeSource.getName())) + " to the environment"));
                }
                compositeSource.addFirstPropertySource(props);
                org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.LOG.debug(java.lang.String.format("Added property source %s at the beginning of the composite source ", props.getName(), compositeSource.getName()));
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    protected java.lang.String getDeprecatedDefaultProfileKey() {
        return "development";
    }

    public static perturbation.location.PerturbationLocation __L473;

    public static perturbation.location.PerturbationLocation __L474;

    public static perturbation.location.PerturbationLocation __L475;

    public static perturbation.location.PerturbationLocation __L476;

    public static perturbation.location.PerturbationLocation __L477;

    public static perturbation.location.PerturbationLocation __L478;

    public static perturbation.location.PerturbationLocation __L479;

    public static perturbation.location.PerturbationLocation __L480;

    public static perturbation.location.PerturbationLocation __L481;

    public static perturbation.location.PerturbationLocation __L482;

    public static perturbation.location.PerturbationLocation __L483;

    public static perturbation.location.PerturbationLocation __L484;

    public static perturbation.location.PerturbationLocation __L485;

    public static perturbation.location.PerturbationLocation __L486;

    public static perturbation.location.PerturbationLocation __L487;

    public static perturbation.location.PerturbationLocation __L488;

    public static perturbation.location.PerturbationLocation __L489;

    public static perturbation.location.PerturbationLocation __L490;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:130)", 473, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:136)", 474, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:157)", 475, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:178)", 476, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:178)", 477, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:185)", 478, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:185)", 479, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:185)", 480, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:187)", 481, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:204)", 482, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:206)", 483, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:215)", 484, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:217)", 485, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:226)", 486, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:242)", 487, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:242)", 488, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:249)", 489, "Boolean");
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.__L490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/BroadleafEnvironmentConfiguringApplicationListener.java:251)", 490, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.BroadleafEnvironmentConfiguringApplicationListener.initPerturbationLocation0();
    }
}

