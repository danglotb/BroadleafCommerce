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


public class ConfigurationOnlyState {
    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState> CONFIGURATIONONLYSTATE = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.class);

    protected boolean isConfigurationOnly;

    public static org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState getState() {
        return org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.CONFIGURATIONONLYSTATE.get();
    }

    public static void setState(org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState state) {
        org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.CONFIGURATIONONLYSTATE.set(state);
    }

    public boolean isConfigurationOnly() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.__L2166, isConfigurationOnly);
    }

    public void setConfigurationOnly(boolean configurationOnly) {
        isConfigurationOnly = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.__L2167, configurationOnly);
    }

    public static perturbation.location.PerturbationLocation __L2166;

    public static perturbation.location.PerturbationLocation __L2167;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.__L2166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/ConfigurationOnlyState.java:40)", 2166, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.__L2167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/ConfigurationOnlyState.java:44)", 2167, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.ConfigurationOnlyState.initPerturbationLocation0();
    }
}

