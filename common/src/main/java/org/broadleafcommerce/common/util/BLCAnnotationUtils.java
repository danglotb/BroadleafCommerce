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
public class BLCAnnotationUtils {
    @java.lang.Deprecated
    public static <A extends java.lang.annotation.Annotation> A getAnnotationFromClassOrInterface(java.lang.Class<A> annotationClass, java.lang.Class clazz) {
        java.lang.annotation.Annotation result = clazz.getAnnotation(annotationClass);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCAnnotationUtils.__L6076, (result == null))) {
            for (java.lang.Class inter : clazz.getInterfaces()) {
                result = inter.getAnnotation(annotationClass);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCAnnotationUtils.__L6077, (result != null))) {
                    break;
                }
            }
        }
        return ((A) (result));
    }

    public static perturbation.location.PerturbationLocation __L6076;

    public static perturbation.location.PerturbationLocation __L6077;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCAnnotationUtils.__L6076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCAnnotationUtils.java:56)", 6076, "Boolean");
        org.broadleafcommerce.common.util.BLCAnnotationUtils.__L6077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCAnnotationUtils.java:59)", 6077, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCAnnotationUtils.initPerturbationLocation0();
    }
}

