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


public class ReflectiveWorkOnChange implements org.broadleafcommerce.common.util.WorkOnChange {
    private static java.util.Map<java.lang.String, java.lang.reflect.Method> methodCache = new org.broadleafcommerce.common.util.EfficientLRUMap<java.lang.String, java.lang.reflect.Method>(1000);

    private final java.lang.Object target;

    private final java.lang.String methodName;

    public ReflectiveWorkOnChange(java.lang.Object target, java.lang.String methodName) {
        this.target = target;
        this.methodName = methodName;
    }

    @java.lang.Override
    public void doWork(java.util.Collection changed) {
        java.lang.String key = (((((target.getClass().getName()) + ".") + (methodName)) + "(") + (changed.getClass().getName())) + ")";
        java.lang.reflect.Method method = org.broadleafcommerce.common.util.ReflectiveWorkOnChange.methodCache.get(key);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6499, (method == null))) {
            method = searchForMethod(target.getClass(), changed);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6500, (method != null))) {
                org.broadleafcommerce.common.util.ReflectiveWorkOnChange.methodCache.put(key, method);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6501, (method == null))) {
            throw new java.lang.IllegalArgumentException((((("Unable to find the method (" + (methodName)) + ") on the class (") + (target.getClass().getName())) + ")"));
        }
        try {
            method.invoke(target, changed);
        } catch (java.lang.IllegalAccessException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
    }

    protected java.lang.reflect.Method searchForMethod(java.lang.Class<?> targetClass, java.lang.Object test) {
        java.lang.reflect.Method method = org.springframework.util.ReflectionUtils.findMethod(target.getClass(), methodName, test.getClass());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6502, (method == null))) {
            java.lang.Class[] interfaces = org.springframework.util.ClassUtils.getAllInterfaces(test);
            for (java.lang.Class clazz : interfaces) {
                method = org.springframework.util.ReflectionUtils.findMethod(targetClass, methodName, clazz);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6503, (method != null))) {
                    break;
                }
            }
        }
        return method;
    }

    public static perturbation.location.PerturbationLocation __L6499;

    public static perturbation.location.PerturbationLocation __L6500;

    public static perturbation.location.PerturbationLocation __L6501;

    public static perturbation.location.PerturbationLocation __L6502;

    public static perturbation.location.PerturbationLocation __L6503;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ReflectiveWorkOnChange.java:53)", 6499, "Boolean");
        org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ReflectiveWorkOnChange.java:55)", 6500, "Boolean");
        org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ReflectiveWorkOnChange.java:59)", 6501, "Boolean");
        org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ReflectiveWorkOnChange.java:73)", 6502, "Boolean");
        org.broadleafcommerce.common.util.ReflectiveWorkOnChange.__L6503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ReflectiveWorkOnChange.java:77)", 6503, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.ReflectiveWorkOnChange.initPerturbationLocation0();
    }
}

