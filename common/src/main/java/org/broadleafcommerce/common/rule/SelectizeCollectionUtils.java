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
package org.broadleafcommerce.common.rule;


public class SelectizeCollectionUtils {
    public static java.util.Collection intersection(final java.lang.Object a, final java.lang.Object b) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4655, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4653, (a == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4654, (b == null)))))) {
            return java.util.Collections.EMPTY_LIST;
        }
        java.lang.Iterable iterableA = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4656, (a instanceof java.lang.Iterable))) ? ((java.lang.Iterable) (a)) : java.util.Collections.singletonList(java.lang.String.valueOf(a));
        java.lang.Iterable iterableB = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4657, (b instanceof java.lang.Iterable))) ? ((java.lang.Iterable) (b)) : java.util.Collections.singletonList(java.lang.String.valueOf(b));
        return org.broadleafcommerce.common.rule.SelectizeCollectionUtils.intersectIterable(iterableA, iterableB);
    }

    private static java.util.Collection intersectIterable(final java.lang.Iterable a, final java.lang.Iterable b) {
        java.util.Collection response;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4666, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4664, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4661, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4659, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4658, org.apache.commons.collections4.IterableUtils.isEmpty(a)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4660, (a instanceof java.util.ArrayList)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4663, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4662, org.apache.commons.collections4.IterableUtils.isEmpty(b))))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4665, (b instanceof java.util.ArrayList)))))) {
            java.lang.Object aVal = ((java.util.ArrayList) (a)).get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4667, 0));
            java.lang.Object bVal = ((java.util.ArrayList) (b)).get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4668, 0));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4671, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4669, (aVal instanceof org.broadleafcommerce.common.value.ValueAssignable))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4670, (bVal instanceof java.lang.String)))))) {
                response = org.broadleafcommerce.common.rule.SelectizeCollectionUtils.valueAssignableIntersection(a, b);
            }else {
                response = org.apache.commons.collections4.CollectionUtils.intersection(a, b);
            }
        }else {
            response = org.apache.commons.collections4.CollectionUtils.intersection(a, b);
        }
        return response;
    }

    private static java.util.Collection<java.lang.String> valueAssignableIntersection(final java.lang.Iterable<org.broadleafcommerce.common.value.ValueAssignable> a, final java.lang.Iterable<java.lang.String> b) {
        java.util.List<java.lang.String> temp = new java.util.ArrayList<>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4673, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4672, org.apache.commons.collections4.IterableUtils.isEmpty(a)))))) {
            for (org.broadleafcommerce.common.value.ValueAssignable alist : a) {
                temp.add(((java.lang.String) (alist.getValue())));
            }
        }
        return org.apache.commons.collections4.CollectionUtils.intersection(temp, b);
    }

    public static perturbation.location.PerturbationLocation __L4653;

    public static perturbation.location.PerturbationLocation __L4654;

    public static perturbation.location.PerturbationLocation __L4655;

    public static perturbation.location.PerturbationLocation __L4656;

    public static perturbation.location.PerturbationLocation __L4657;

    public static perturbation.location.PerturbationLocation __L4658;

    public static perturbation.location.PerturbationLocation __L4659;

    public static perturbation.location.PerturbationLocation __L4660;

    public static perturbation.location.PerturbationLocation __L4661;

    public static perturbation.location.PerturbationLocation __L4662;

    public static perturbation.location.PerturbationLocation __L4663;

    public static perturbation.location.PerturbationLocation __L4664;

    public static perturbation.location.PerturbationLocation __L4665;

    public static perturbation.location.PerturbationLocation __L4666;

    public static perturbation.location.PerturbationLocation __L4667;

    public static perturbation.location.PerturbationLocation __L4668;

    public static perturbation.location.PerturbationLocation __L4669;

    public static perturbation.location.PerturbationLocation __L4670;

    public static perturbation.location.PerturbationLocation __L4671;

    public static perturbation.location.PerturbationLocation __L4672;

    public static perturbation.location.PerturbationLocation __L4673;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:51)", 4653, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:51)", 4654, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:51)", 4655, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:54)", 4656, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:55)", 4657, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4658, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4659, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4660, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4661, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4662, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4663, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4664, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4665, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:61)", 4666, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:65)", 4667, "Numerical");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:66)", 4668, "Numerical");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:67)", 4669, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:67)", 4670, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:67)", 4671, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:81)", 4672, "Boolean");
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.__L4673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rule/SelectizeCollectionUtils.java:81)", 4673, "Boolean");
    }

    static {
        org.broadleafcommerce.common.rule.SelectizeCollectionUtils.initPerturbationLocation0();
    }
}

