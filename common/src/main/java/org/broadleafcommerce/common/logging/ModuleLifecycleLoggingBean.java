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
package org.broadleafcommerce.common.logging;


public class ModuleLifecycleLoggingBean {
    private java.lang.String moduleName;

    private org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent;

    public ModuleLifecycleLoggingBean() {
    }

    public ModuleLifecycleLoggingBean(java.lang.String moduleName, org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent) {
        this.moduleName = moduleName;
        this.lifeCycleEvent = lifeCycleEvent;
    }

    @javax.annotation.PostConstruct
    public void init() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.__L3365, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.__L3363, ((moduleName) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.__L3364, ((lifeCycleEvent) == null)))))) {
            throw new java.lang.IllegalArgumentException("Must supply the moduleName and lifeCycleEvent properties!");
        }
        org.broadleafcommerce.common.logging.SupportLogger logger = org.broadleafcommerce.common.logging.SupportLogManager.getLogger(moduleName, org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.class);
        logger.lifecycle(lifeCycleEvent, "");
    }

    public org.broadleafcommerce.common.logging.LifeCycleEvent getLifeCycleEvent() {
        return lifeCycleEvent;
    }

    public void setLifeCycleEvent(org.broadleafcommerce.common.logging.LifeCycleEvent lifeCycleEvent) {
        this.lifeCycleEvent = lifeCycleEvent;
    }

    public java.lang.String getModuleName() {
        return moduleName;
    }

    public void setModuleName(java.lang.String moduleName) {
        this.moduleName = moduleName;
    }

    public static perturbation.location.PerturbationLocation __L3363;

    public static perturbation.location.PerturbationLocation __L3364;

    public static perturbation.location.PerturbationLocation __L3365;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.__L3363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ModuleLifecycleLoggingBean.java:49)", 3363, "Boolean");
        org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.__L3364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ModuleLifecycleLoggingBean.java:49)", 3364, "Boolean");
        org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.__L3365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ModuleLifecycleLoggingBean.java:49)", 3365, "Boolean");
    }

    static {
        org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean.initPerturbationLocation0();
    }
}

