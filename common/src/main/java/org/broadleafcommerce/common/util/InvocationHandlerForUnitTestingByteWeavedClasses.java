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


public class InvocationHandlerForUnitTestingByteWeavedClasses implements java.lang.reflect.InvocationHandler {
    protected java.lang.Object[] objectsForByteWeaving;

    public static <T> T createProxy(java.lang.Class<T> proxyType, java.lang.Class<?>[] interfaces, java.lang.Object[] objectsForByteWeaving) {
        java.lang.reflect.InvocationHandler handler = new org.broadleafcommerce.common.util.InvocationHandlerForUnitTestingByteWeavedClasses(objectsForByteWeaving);
        return ((T) (java.lang.reflect.Proxy.newProxyInstance(handler.getClass().getClassLoader(), interfaces, handler)));
    }

    public InvocationHandlerForUnitTestingByteWeavedClasses(java.lang.Object[] objectsForByteWeaving) {
        this.objectsForByteWeaving = objectsForByteWeaving;
    }

    @java.lang.Override
    public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
        for (java.lang.Object object : objectsForByteWeaving) {
            try {
                return method.invoke(object, args);
            } catch (java.lang.IllegalArgumentException exception) {
                continue;
            }
        }
        return null;
    }

    public java.lang.Object[] getObjectsForByteWeaving() {
        return objectsForByteWeaving;
    }

    public void setObjectsForByteWeaving(java.lang.Object[] objects) {
        this.objectsForByteWeaving = objects;
    }
}

