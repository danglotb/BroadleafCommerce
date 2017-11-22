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


public class BLCMapUtils {
    public static <K, CV extends java.lang.Iterable<V>, V> java.util.Map<K, V> keyedMap(CV values, org.broadleafcommerce.common.util.TypedClosure<K, V> closure) {
        java.util.Map<K, V> map = new java.util.HashMap<K, V>();
        for (V value : values) {
            K key = closure.getKey(value);
            map.put(key, value);
        }
        return map;
    }

    public static <K, V> java.util.Map<K, V> keyedMap(V[] values, org.broadleafcommerce.common.util.TypedClosure<K, V> closure) {
        java.util.Map<K, V> map = new java.util.HashMap<K, V>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCMapUtils.__L6156, (values != null))) {
            for (V value : values) {
                K key = closure.getKey(value);
                map.put(key, value);
            }
        }
        return map;
    }

    public static <K, CV extends java.lang.Iterable<V>, V> java.util.Map<K, java.util.List<V>> keyedListMap(CV values, org.broadleafcommerce.common.util.TypedClosure<K, V> closure) {
        java.util.Map<K, java.util.List<V>> map = new java.util.HashMap<K, java.util.List<V>>();
        for (V value : values) {
            K key = closure.getKey(value);
            java.util.List<V> list = map.get(key);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCMapUtils.__L6157, (list == null))) {
                list = new java.util.ArrayList<V>();
                map.put(key, list);
            }
            list.add(value);
        }
        return map;
    }

    public static <K, V> java.util.Map<K, V> valueSortedMap(java.util.Map<K, V> map, java.util.Comparator<java.util.Map.Entry<K, V>> comparator) {
        java.util.Set<java.util.Map.Entry<K, V>> valueSortedEntries = new java.util.TreeSet<java.util.Map.Entry<K, V>>(comparator);
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            valueSortedEntries.add(entry);
        }
        java.util.Map<K, V> sortedMap = new java.util.LinkedHashMap<K, V>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCMapUtils.__L6158, map.size()));
        for (java.util.Map.Entry<K, V> entry : valueSortedEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static perturbation.location.PerturbationLocation __L6156;

    public static perturbation.location.PerturbationLocation __L6157;

    public static perturbation.location.PerturbationLocation __L6158;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCMapUtils.__L6156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCMapUtils.java:78)", 6156, "Boolean");
        org.broadleafcommerce.common.util.BLCMapUtils.__L6157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCMapUtils.java:106)", 6157, "Boolean");
        org.broadleafcommerce.common.util.BLCMapUtils.__L6158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCMapUtils.java:123)", 6158, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.BLCMapUtils.initPerturbationLocation0();
    }
}

