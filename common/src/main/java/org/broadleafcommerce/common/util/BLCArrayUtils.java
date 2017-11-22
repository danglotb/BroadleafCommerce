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


public class BLCArrayUtils {
    public static <T> boolean contains(T[] array, org.broadleafcommerce.common.util.TypedPredicate<T> predicate) {
        for (T o : array) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCArrayUtils.__L6078, predicate.evaluate(o))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCArrayUtils.__L6079, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCArrayUtils.__L6080, false);
    }

    public static <T> java.util.ArrayList<T> asList(T[] array) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCArrayUtils.__L6081, (array == null))) {
            return null;
        }
        java.util.ArrayList<T> list = new java.util.ArrayList<T>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCArrayUtils.__L6082, array.length));
        for (T e : array) {
            list.add(e);
        }
        return list;
    }

    public static <T, O> java.util.ArrayList<T> collect(java.lang.Object[] array, org.broadleafcommerce.common.util.TypedTransformer<T> transformer) {
        java.util.ArrayList<T> list = new java.util.ArrayList<T>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCArrayUtils.__L6083, array.length));
        for (java.lang.Object o : array) {
            list.add(transformer.transform(o));
        }
        return list;
    }

    public static <T, O> java.util.HashSet<T> collectSet(java.lang.Object[] array, org.broadleafcommerce.common.util.TypedTransformer<T> transformer) {
        java.util.HashSet<T> set = new java.util.HashSet<T>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCArrayUtils.__L6084, array.length));
        for (java.lang.Object o : array) {
            set.add(transformer.transform(o));
        }
        return set;
    }

    public static perturbation.location.PerturbationLocation __L6078;

    public static perturbation.location.PerturbationLocation __L6079;

    public static perturbation.location.PerturbationLocation __L6080;

    public static perturbation.location.PerturbationLocation __L6081;

    public static perturbation.location.PerturbationLocation __L6082;

    public static perturbation.location.PerturbationLocation __L6083;

    public static perturbation.location.PerturbationLocation __L6084;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:42)", 6078, "Boolean");
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:43)", 6079, "Boolean");
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:46)", 6080, "Boolean");
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:57)", 6081, "Boolean");
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:60)", 6082, "Numerical");
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:75)", 6083, "Numerical");
        org.broadleafcommerce.common.util.BLCArrayUtils.__L6084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCArrayUtils.java:90)", 6084, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.BLCArrayUtils.initPerturbationLocation0();
    }
}

