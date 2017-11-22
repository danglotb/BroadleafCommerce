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


public class AnnotationJmxAttributeSource extends org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource {
    private final java.lang.String appName;

    public AnnotationJmxAttributeSource(java.lang.String appName) {
        this.appName = appName;
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public org.springframework.jmx.export.metadata.ManagedResource getManagedResource(java.lang.Class beanClass) throws org.springframework.jmx.export.metadata.InvalidMetadataException {
        org.springframework.jmx.export.metadata.ManagedResource resource = super.getManagedResource(beanClass);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.__L3271, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.__L3269, (resource != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.__L3270, ((appName) != null)))))) {
            java.lang.String objectName = resource.getObjectName();
            objectName += "." + (appName);
            resource.setObjectName(objectName);
        }
        return resource;
    }

    public static perturbation.location.PerturbationLocation __L3269;

    public static perturbation.location.PerturbationLocation __L3270;

    public static perturbation.location.PerturbationLocation __L3271;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.__L3269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/AnnotationJmxAttributeSource.java:40)", 3269, "Boolean");
        org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.__L3270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/AnnotationJmxAttributeSource.java:40)", 3270, "Boolean");
        org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.__L3271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/jmx/AnnotationJmxAttributeSource.java:40)", 3271, "Boolean");
    }

    static {
        org.broadleafcommerce.common.jmx.AnnotationJmxAttributeSource.initPerturbationLocation0();
    }
}

