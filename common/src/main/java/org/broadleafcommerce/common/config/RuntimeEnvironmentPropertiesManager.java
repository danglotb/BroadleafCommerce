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
public class RuntimeEnvironmentPropertiesManager implements org.springframework.beans.factory.BeanFactoryAware {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.class);

    protected org.springframework.beans.factory.config.ConfigurableBeanFactory beanFactory;

    protected java.lang.String prefix;

    public java.lang.String getPrefix() {
        return prefix;
    }

    public java.lang.String setPrefix(java.lang.String prefix) {
        return this.prefix = prefix;
    }

    public java.lang.String getProperty(java.lang.String key, java.lang.String suffix) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L549, (key == null))) {
            return null;
        }
        java.lang.String name = ((((prefix) + ".") + key) + ".") + suffix;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L550, ((prefix) == null))) {
            name = (key + ".") + suffix;
        }
        java.lang.String rv = beanFactory.resolveEmbeddedValue((("${" + name) + "}"));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L553, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L551, (rv == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L552, rv.equals((("${" + name) + "}"))))))) {
            org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.LOG.warn(((("property ${" + name) + "} not found, Reverting to property without suffix") + suffix));
            rv = getProperty(key);
        }
        return rv;
    }

    public java.lang.String getProperty(java.lang.String key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L554, (key == null))) {
            return null;
        }
        java.lang.String name = ((prefix) + ".") + key;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L555, ((prefix) == null))) {
            name = key;
        }
        java.lang.String rv = beanFactory.resolveEmbeddedValue((("${" + name) + "}"));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L556, rv.equals((("${" + name) + "}")))) {
            return null;
        }
        return rv;
    }

    @java.lang.Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) throws org.springframework.beans.BeansException {
        this.beanFactory = ((org.springframework.beans.factory.config.ConfigurableBeanFactory) (beanFactory));
    }

    public static perturbation.location.PerturbationLocation __L549;

    public static perturbation.location.PerturbationLocation __L550;

    public static perturbation.location.PerturbationLocation __L551;

    public static perturbation.location.PerturbationLocation __L552;

    public static perturbation.location.PerturbationLocation __L553;

    public static perturbation.location.PerturbationLocation __L554;

    public static perturbation.location.PerturbationLocation __L555;

    public static perturbation.location.PerturbationLocation __L556;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:49)", 549, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:53)", 550, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:58)", 551, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:58)", 552, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:58)", 553, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:67)", 554, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:71)", 555, "Boolean");
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.__L556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/RuntimeEnvironmentPropertiesManager.java:75)", 556, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.RuntimeEnvironmentPropertiesManager.initPerturbationLocation0();
    }
}

