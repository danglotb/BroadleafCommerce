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
package org.broadleafcommerce.common.jmx;


public class ExplicitNameFactoryBean implements org.springframework.beans.factory.FactoryBean {
    private final java.lang.String name;

    private final java.lang.String suffix;

    public ExplicitNameFactoryBean(java.lang.String name, java.lang.String suffix) {
        this.name = name;
        this.suffix = suffix;
    }

    public java.lang.Object getObject() throws java.lang.Exception {
        return ((name) + "-") + (suffix);
    }

    @java.lang.SuppressWarnings("unchecked")
    public java.lang.Class getObjectType() {
        return java.lang.String.class;
    }

    public boolean isSingleton() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.ExplicitNameFactoryBean.__L3275, false);
    }

    public static perturbation.location.PerturbationLocation __L3275;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.jmx.ExplicitNameFactoryBean.__L3275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/ExplicitNameFactoryBean.java:47)", 3275, "Boolean");
    }

    static {
        org.broadleafcommerce.common.jmx.ExplicitNameFactoryBean.initPerturbationLocation0();
    }
}

