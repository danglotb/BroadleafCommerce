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


public class EnvironmentFactoryBean implements org.springframework.beans.factory.FactoryBean {
    private java.lang.String className;

    public EnvironmentFactoryBean(java.lang.String className) {
        this.className = className;
    }

    public java.lang.Object getObject() throws java.lang.Exception {
        return java.lang.Class.forName(className).newInstance();
    }

    @java.lang.SuppressWarnings("unchecked")
    public java.lang.Class getObjectType() {
        try {
            return java.lang.Class.forName(className);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public boolean isSingleton() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EnvironmentFactoryBean.__L6351, false);
    }

    public static perturbation.location.PerturbationLocation __L6351;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.EnvironmentFactoryBean.__L6351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EnvironmentFactoryBean.java:44)", 6351, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.EnvironmentFactoryBean.initPerturbationLocation0();
    }
}

