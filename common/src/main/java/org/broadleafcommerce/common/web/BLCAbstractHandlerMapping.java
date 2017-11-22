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
package org.broadleafcommerce.common.web;


public abstract class BLCAbstractHandlerMapping extends org.springframework.web.servlet.handler.AbstractHandlerMapping {
    protected java.lang.String controllerName;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.core.env.Environment env;

    @java.lang.Override
    public java.lang.Object getDefaultHandler() {
        return null;
    }

    public java.lang.String getControllerName() {
        return controllerName;
    }

    public void setControllerName(java.lang.String controllerName) {
        this.controllerName = controllerName;
    }

    public boolean allowProductResolutionUsingIdParam() {
        return env.getProperty("allowProductResolutionUsingIdParam", boolean.class, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BLCAbstractHandlerMapping.__L7696, false));
    }

    public boolean allowCategoryResolutionUsingIdParam() {
        return env.getProperty("allowCategoryResolutionUsingIdParam", boolean.class, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BLCAbstractHandlerMapping.__L7697, false));
    }

    public static perturbation.location.PerturbationLocation __L7696;

    public static perturbation.location.PerturbationLocation __L7697;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BLCAbstractHandlerMapping.__L7696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BLCAbstractHandlerMapping.java:67)", 7696, "Boolean");
        org.broadleafcommerce.common.web.BLCAbstractHandlerMapping.__L7697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BLCAbstractHandlerMapping.java:71)", 7697, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.BLCAbstractHandlerMapping.initPerturbationLocation0();
    }
}

