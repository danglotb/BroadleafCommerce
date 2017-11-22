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


public class EfficientLRUMap<K, V> implements java.util.Map<K, V> {
    private java.util.Map<K, V> concurrentMap;

    private java.util.Map<K, V> lruMap;

    private int maxEntries;

    private boolean usingLRUMap = false;

    public EfficientLRUMap(int maxEntries) {
        this.maxEntries = maxEntries;
        concurrentMap = new java.util.concurrent.ConcurrentHashMap<K, V>();
    }

    @java.lang.Override
    public int size() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6317, usingLRUMap)) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.EfficientLRUMap.__L6318, lruMap.size());
        }else {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.EfficientLRUMap.__L6319, concurrentMap.size());
        }
    }

    @java.lang.Override
    public boolean isEmpty() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6320, usingLRUMap)) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6321, lruMap.isEmpty());
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6322, concurrentMap.isEmpty());
        }
    }

    @java.lang.Override
    public boolean containsKey(java.lang.Object key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6323, usingLRUMap)) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6324, lruMap.containsKey(key));
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6325, concurrentMap.containsKey(key));
        }
    }

    @java.lang.Override
    public boolean containsValue(java.lang.Object value) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6326, usingLRUMap)) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6327, lruMap.containsValue(value));
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6328, concurrentMap.containsValue(value));
        }
    }

    @java.lang.Override
    public V get(java.lang.Object key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6329, usingLRUMap)) {
            return lruMap.get(key);
        }else {
            return concurrentMap.get(key);
        }
    }

    @java.lang.Override
    public V put(K key, V value) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6330, usingLRUMap)) {
            return lruMap.put(key, value);
        }else {
            V returnVal = concurrentMap.put(key, value);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6331, switchToLRUMap())) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6333, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6332, lruMap.containsKey(key)))))) {
                    lruMap.put(key, value);
                }
            }
            return returnVal;
        }
    }

    protected synchronized boolean switchToLRUMap() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6335, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6334, usingLRUMap))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6338, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.EfficientLRUMap.__L6336, size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.EfficientLRUMap.__L6337, maxEntries))))) {
                lruMap = java.util.Collections.synchronizedMap(new org.apache.commons.collections4.map.LRUMap<K, V>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.EfficientLRUMap.__L6339, maxEntries)));
                lruMap.putAll(concurrentMap);
                usingLRUMap = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6340, true);
                concurrentMap.clear();
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6341, usingLRUMap);
    }

    @java.lang.Override
    public V remove(java.lang.Object key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6342, usingLRUMap)) {
            return lruMap.remove(key);
        }else {
            return concurrentMap.remove(key);
        }
    }

    @java.lang.Override
    public void putAll(java.util.Map<? extends K, ? extends V> m) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6343, usingLRUMap)) {
            lruMap.putAll(m);
        }else {
            concurrentMap.putAll(m);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6344, switchToLRUMap())) {
                lruMap.putAll(m);
            }
        }
    }

    @java.lang.Override
    public void clear() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6345, usingLRUMap)) {
            resetInternalMap();
        }else {
            concurrentMap.clear();
        }
    }

    protected synchronized void resetInternalMap() {
        usingLRUMap = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6346, false);
        lruMap.clear();
    }

    @java.lang.Override
    public java.util.Set<K> keySet() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6347, usingLRUMap)) {
            return lruMap.keySet();
        }else {
            return concurrentMap.keySet();
        }
    }

    @java.lang.Override
    public java.util.Collection<V> values() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6348, usingLRUMap)) {
            return lruMap.values();
        }else {
            return concurrentMap.values();
        }
    }

    @java.lang.Override
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6349, usingLRUMap)) {
            return lruMap.entrySet();
        }else {
            return concurrentMap.entrySet();
        }
    }

    protected java.lang.Class getUnderlyingMapClass() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.EfficientLRUMap.__L6350, usingLRUMap)) {
            return lruMap.getClass();
        }else {
            return concurrentMap.getClass();
        }
    }

    public static perturbation.location.PerturbationLocation __L6317;

    public static perturbation.location.PerturbationLocation __L6318;

    public static perturbation.location.PerturbationLocation __L6319;

    public static perturbation.location.PerturbationLocation __L6320;

    public static perturbation.location.PerturbationLocation __L6321;

    public static perturbation.location.PerturbationLocation __L6322;

    public static perturbation.location.PerturbationLocation __L6323;

    public static perturbation.location.PerturbationLocation __L6324;

    public static perturbation.location.PerturbationLocation __L6325;

    public static perturbation.location.PerturbationLocation __L6326;

    public static perturbation.location.PerturbationLocation __L6327;

    public static perturbation.location.PerturbationLocation __L6328;

    public static perturbation.location.PerturbationLocation __L6329;

    public static perturbation.location.PerturbationLocation __L6330;

    public static perturbation.location.PerturbationLocation __L6331;

    public static perturbation.location.PerturbationLocation __L6332;

    public static perturbation.location.PerturbationLocation __L6333;

    public static perturbation.location.PerturbationLocation __L6334;

    public static perturbation.location.PerturbationLocation __L6335;

    public static perturbation.location.PerturbationLocation __L6336;

    public static perturbation.location.PerturbationLocation __L6337;

    public static perturbation.location.PerturbationLocation __L6338;

    public static perturbation.location.PerturbationLocation __L6339;

    public static perturbation.location.PerturbationLocation __L6340;

    public static perturbation.location.PerturbationLocation __L6341;

    public static perturbation.location.PerturbationLocation __L6342;

    public static perturbation.location.PerturbationLocation __L6343;

    public static perturbation.location.PerturbationLocation __L6344;

    public static perturbation.location.PerturbationLocation __L6345;

    public static perturbation.location.PerturbationLocation __L6346;

    public static perturbation.location.PerturbationLocation __L6347;

    public static perturbation.location.PerturbationLocation __L6348;

    public static perturbation.location.PerturbationLocation __L6349;

    public static perturbation.location.PerturbationLocation __L6350;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:59)", 6317, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:60)", 6318, "Numerical");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:62)", 6319, "Numerical");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:68)", 6320, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:69)", 6321, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:71)", 6322, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:77)", 6323, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:78)", 6324, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:80)", 6325, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:86)", 6326, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:87)", 6327, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:89)", 6328, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:95)", 6329, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:104)", 6330, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:108)", 6331, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:110)", 6332, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:110)", 6333, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:119)", 6334, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:119)", 6335, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:120)", 6336, "Numerical");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:120)", 6337, "Numerical");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:120)", 6338, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:121)", 6339, "Numerical");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:123)", 6340, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:127)", 6341, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:132)", 6342, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:144)", 6343, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:148)", 6344, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:157)", 6345, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:168)", 6346, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:174)", 6347, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:183)", 6348, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:192)", 6349, "Boolean");
        org.broadleafcommerce.common.util.EfficientLRUMap.__L6350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/EfficientLRUMap.java:200)", 6350, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.EfficientLRUMap.initPerturbationLocation0();
    }
}

