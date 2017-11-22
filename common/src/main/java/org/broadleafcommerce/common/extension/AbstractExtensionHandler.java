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
package org.broadleafcommerce.common.extension;


public abstract class AbstractExtensionHandler implements org.broadleafcommerce.common.extension.ExtensionHandler {
    protected int priority;

    protected boolean enabled = true;

    @java.lang.Override
    public int getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2453, priority);
    }

    public void setPriority(int priority) {
        this.priority = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2454, priority);
    }

    @java.lang.Override
    public boolean isEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2455, enabled);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2456, enabled);
    }

    public static perturbation.location.PerturbationLocation __L2453;

    public static perturbation.location.PerturbationLocation __L2454;

    public static perturbation.location.PerturbationLocation __L2455;

    public static perturbation.location.PerturbationLocation __L2456;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/AbstractExtensionHandler.java:40)", 2453, "Numerical");
        org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/AbstractExtensionHandler.java:44)", 2454, "Numerical");
        org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/AbstractExtensionHandler.java:49)", 2455, "Boolean");
        org.broadleafcommerce.common.extension.AbstractExtensionHandler.__L2456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/AbstractExtensionHandler.java:53)", 2456, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extension.AbstractExtensionHandler.initPerturbationLocation0();
    }
}

