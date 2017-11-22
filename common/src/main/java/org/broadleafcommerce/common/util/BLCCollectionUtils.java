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


public class BLCCollectionUtils {
    @java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> java.util.Collection<T> collect(java.util.Collection inputCollection, org.broadleafcommerce.common.util.TypedTransformer<T> transformer) {
        return org.apache.commons.collections.CollectionUtils.collect(inputCollection, transformer);
    }

    @java.lang.SuppressWarnings("rawtypes")
    public static <T> java.util.List<T> collectList(java.util.Collection inputCollection, org.broadleafcommerce.common.util.TypedTransformer<T> transformer) {
        java.util.List<T> returnList = new java.util.ArrayList<T>();
        for (java.lang.Object obj : inputCollection) {
            T transformed = transformer.transform(obj);
            returnList.add(transformed);
        }
        return returnList;
    }

    @java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T[] collectArray(java.util.Collection inputCollection, org.broadleafcommerce.common.util.TypedTransformer<T> transformer, java.lang.Class<T> clazz) {
        T[] returnArray = ((T[]) (java.lang.reflect.Array.newInstance(clazz, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6085, inputCollection.size()))));
        int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6086, 0);
        for (java.lang.Object obj : inputCollection) {
            T transformed = transformer.transform(obj);
            returnArray[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6087, (i++))] = transformed;
        }
        return returnArray;
    }

    public static <T> java.util.List<T> selectList(java.util.Collection<T> inputCollection, org.broadleafcommerce.common.util.TypedPredicate<T> predicate) {
        java.util.ArrayList<T> answer = new java.util.ArrayList<T>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6088, inputCollection.size()));
        org.apache.commons.collections.CollectionUtils.select(inputCollection, predicate, answer);
        return answer;
    }

    public static <T> java.util.List<T> createIfNull(java.util.List<T> list) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6089, (list == null)) ? new java.util.ArrayList<T>() : list;
    }

    public static <T extends java.util.Collection> T createChangeAwareCollection(final org.broadleafcommerce.common.util.WorkOnChange work, final java.util.Collection original) {
        T proxy = ((T) (java.lang.reflect.Proxy.newProxyInstance(org.broadleafcommerce.common.util.BLCCollectionUtils.class.getClassLoader(), org.springframework.util.ClassUtils.getAllInterfacesForClass(original.getClass()), new java.lang.reflect.InvocationHandler() {
            @java.lang.Override
            public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6094, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6092, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6090, method.getName().startsWith("add"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6091, method.getName().startsWith("remove")))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6093, method.getName().startsWith("clear")))))) {
                    work.doWork(original);
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6095, method.getName().equals("iterator"))) {
                    final java.util.Iterator itr = ((java.util.Iterator) (method.invoke(original, args)));
                    java.util.Iterator proxyItr = ((java.util.Iterator) (java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(), org.springframework.util.ClassUtils.getAllInterfacesForClass(itr.getClass()), new java.lang.reflect.InvocationHandler() {
                        @java.lang.Override
                        public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCCollectionUtils.__L6096, method.getName().equals("remove"))) {
                                work.doWork(original);
                            }
                            return method.invoke(itr, args);
                        }
                    })));
                    return proxyItr;
                }
                return method.invoke(original, args);
            }
        })));
        return proxy;
    }

    public static perturbation.location.PerturbationLocation __L6085;

    public static perturbation.location.PerturbationLocation __L6086;

    public static perturbation.location.PerturbationLocation __L6087;

    public static perturbation.location.PerturbationLocation __L6088;

    public static perturbation.location.PerturbationLocation __L6089;

    public static perturbation.location.PerturbationLocation __L6090;

    public static perturbation.location.PerturbationLocation __L6091;

    public static perturbation.location.PerturbationLocation __L6092;

    public static perturbation.location.PerturbationLocation __L6093;

    public static perturbation.location.PerturbationLocation __L6094;

    public static perturbation.location.PerturbationLocation __L6095;

    public static perturbation.location.PerturbationLocation __L6096;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:78)", 6085, "Numerical");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:79)", 6086, "Numerical");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:82)", 6087, "Numerical");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:96)", 6088, "Numerical");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:109)", 6089, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:126)", 6090, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:126)", 6091, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:126)", 6092, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:126)", 6093, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:126)", 6094, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:130)", 6095, "Boolean");
        org.broadleafcommerce.common.util.BLCCollectionUtils.__L6096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCCollectionUtils.java:135)", 6096, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCCollectionUtils.initPerturbationLocation0();
    }
}

