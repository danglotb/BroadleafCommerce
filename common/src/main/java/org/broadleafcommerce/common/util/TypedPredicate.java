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


@java.lang.SuppressWarnings("unchecked")
public abstract class TypedPredicate<T> implements org.apache.commons.collections.Predicate {
    protected java.lang.Class<T> clazz;

    public TypedPredicate() {
        clazz = ((java.lang.Class<T>) (((java.lang.reflect.ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
    }

    public boolean evaluate(java.lang.Object value) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TypedPredicate.__L6807, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TypedPredicate.__L6805, (value == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TypedPredicate.__L6806, clazz.isAssignableFrom(value.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TypedPredicate.__L6808, eval(((T) (value))));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TypedPredicate.__L6809, false);
    }

    public abstract boolean eval(T value);

    public static perturbation.location.PerturbationLocation __L6805;

    public static perturbation.location.PerturbationLocation __L6806;

    public static perturbation.location.PerturbationLocation __L6807;

    public static perturbation.location.PerturbationLocation __L6808;

    public static perturbation.location.PerturbationLocation __L6809;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.TypedPredicate.__L6805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TypedPredicate.java:42)", 6805, "Boolean");
        org.broadleafcommerce.common.util.TypedPredicate.__L6806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TypedPredicate.java:42)", 6806, "Boolean");
        org.broadleafcommerce.common.util.TypedPredicate.__L6807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TypedPredicate.java:42)", 6807, "Boolean");
        org.broadleafcommerce.common.util.TypedPredicate.__L6808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TypedPredicate.java:43)", 6808, "Boolean");
        org.broadleafcommerce.common.util.TypedPredicate.__L6809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TypedPredicate.java:45)", 6809, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.TypedPredicate.initPerturbationLocation0();
    }
}

