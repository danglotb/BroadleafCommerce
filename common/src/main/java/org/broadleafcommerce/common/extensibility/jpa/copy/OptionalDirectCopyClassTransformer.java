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
package org.broadleafcommerce.common.extensibility.jpa.copy;


public class OptionalDirectCopyClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer implements org.springframework.beans.factory.BeanFactoryAware {
    protected java.lang.String propertyName;

    protected org.springframework.beans.factory.config.ConfigurableBeanFactory beanFactory;

    public OptionalDirectCopyClassTransformer(java.lang.String moduleName) {
        super(moduleName);
    }

    @java.lang.Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) throws org.springframework.beans.BeansException {
        this.beanFactory = ((org.springframework.beans.factory.config.ConfigurableBeanFactory) (beanFactory));
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        java.lang.Boolean shouldProceed;
        try {
            java.lang.String value = beanFactory.resolveEmbeddedValue((("${" + (propertyName)) + ":false}"));
            shouldProceed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.__L2149, java.lang.Boolean.parseBoolean(value));
        } catch (java.lang.Exception e) {
            shouldProceed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.__L2150, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.__L2151, (!shouldProceed))) {
            return null;
        }
        return super.transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
    }

    public java.lang.String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(java.lang.String propertyName) {
        this.propertyName = propertyName;
    }

    public static perturbation.location.PerturbationLocation __L2149;

    public static perturbation.location.PerturbationLocation __L2150;

    public static perturbation.location.PerturbationLocation __L2151;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.__L2149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/OptionalDirectCopyClassTransformer.java:67)", 2149, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.__L2150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/OptionalDirectCopyClassTransformer.java:69)", 2150, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.__L2151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/OptionalDirectCopyClassTransformer.java:71)", 2151, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.copy.OptionalDirectCopyClassTransformer.initPerturbationLocation0();
    }
}

