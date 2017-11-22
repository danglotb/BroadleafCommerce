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
package org.broadleafcommerce.common.util;


@java.lang.Deprecated
@org.springframework.stereotype.Service("blBLCSystemProperty")
public class BLCSystemProperty implements org.springframework.context.ApplicationContextAware {
    protected static org.springframework.context.ApplicationContext applicationContext;

    public static java.lang.String resolveSystemProperty(java.lang.String name) {
        return org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveSystemProperty(name);
    }

    public static java.lang.String resolveSystemProperty(java.lang.String name, java.lang.String defaultValue) {
        return org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveSystemProperty(name, defaultValue);
    }

    public static int resolveIntSystemProperty(java.lang.String name) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCSystemProperty.__L6218, org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveIntSystemProperty(name));
    }

    public static int resolveIntSystemProperty(java.lang.String name, int defaultValue) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCSystemProperty.__L6220, org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveIntSystemProperty(name, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCSystemProperty.__L6219, defaultValue)));
    }

    public static boolean resolveBooleanSystemProperty(java.lang.String name) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCSystemProperty.__L6221, org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveBooleanSystemProperty(name));
    }

    public static boolean resolveBooleanSystemProperty(java.lang.String name, boolean defaultValue) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCSystemProperty.__L6223, org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveBooleanSystemProperty(name, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCSystemProperty.__L6222, defaultValue)));
    }

    public static long resolveLongSystemProperty(java.lang.String name) {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.BLCSystemProperty.__L6224, org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveLongSystemProperty(name));
    }

    public static long resolveLongSystemProperty(java.lang.String name, long defaultValue) {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.BLCSystemProperty.__L6226, org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService().resolveLongSystemProperty(name, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.BLCSystemProperty.__L6225, defaultValue)));
    }

    protected static org.broadleafcommerce.common.config.service.SystemPropertiesService getSystemPropertiesService() {
        return ((org.broadleafcommerce.common.config.service.SystemPropertiesService) (org.broadleafcommerce.common.util.BLCSystemProperty.applicationContext.getBean("blSystemPropertiesService")));
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        org.broadleafcommerce.common.util.BLCSystemProperty.applicationContext = applicationContext;
    }

    public static perturbation.location.PerturbationLocation __L6218;

    public static perturbation.location.PerturbationLocation __L6219;

    public static perturbation.location.PerturbationLocation __L6220;

    public static perturbation.location.PerturbationLocation __L6221;

    public static perturbation.location.PerturbationLocation __L6222;

    public static perturbation.location.PerturbationLocation __L6223;

    public static perturbation.location.PerturbationLocation __L6224;

    public static perturbation.location.PerturbationLocation __L6225;

    public static perturbation.location.PerturbationLocation __L6226;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:61)", 6218, "Numerical");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:65)", 6219, "Numerical");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:65)", 6220, "Numerical");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:72)", 6221, "Boolean");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:76)", 6222, "Boolean");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:76)", 6223, "Boolean");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:83)", 6224, "Numerical");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:87)", 6225, "Numerical");
        org.broadleafcommerce.common.util.BLCSystemProperty.__L6226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCSystemProperty.java:87)", 6226, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.BLCSystemProperty.initPerturbationLocation0();
    }
}

