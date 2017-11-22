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


public class WeightUnitOfMeasureType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.util.WeightUnitOfMeasureType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.util.WeightUnitOfMeasureType>();

    public static final org.broadleafcommerce.common.util.WeightUnitOfMeasureType POUNDS = new org.broadleafcommerce.common.util.WeightUnitOfMeasureType("POUNDS", "Pounds");

    public static final org.broadleafcommerce.common.util.WeightUnitOfMeasureType KILOGRAMS = new org.broadleafcommerce.common.util.WeightUnitOfMeasureType("KILOGRAMS", "Kilograms");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.util.WeightUnitOfMeasureType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.util.WeightUnitOfMeasureType.TYPES.get(type);
    }

    public WeightUnitOfMeasureType() {
    }

    public WeightUnitOfMeasureType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6892, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6891, org.broadleafcommerce.common.util.WeightUnitOfMeasureType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.util.WeightUnitOfMeasureType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6893, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6894, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6902, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6897, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6895, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6896, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6901, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6898, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6899, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6900, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6903, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6904, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6905, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6906, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6907, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6909, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6908, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6910, false);

        org.broadleafcommerce.common.util.WeightUnitOfMeasureType other = ((org.broadleafcommerce.common.util.WeightUnitOfMeasureType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6911, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6912, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6913, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6915, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6914, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6916, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6917, true);
    }

    public static perturbation.location.PerturbationLocation __L6891;

    public static perturbation.location.PerturbationLocation __L6892;

    public static perturbation.location.PerturbationLocation __L6893;

    public static perturbation.location.PerturbationLocation __L6894;

    public static perturbation.location.PerturbationLocation __L6895;

    public static perturbation.location.PerturbationLocation __L6896;

    public static perturbation.location.PerturbationLocation __L6897;

    public static perturbation.location.PerturbationLocation __L6898;

    public static perturbation.location.PerturbationLocation __L6899;

    public static perturbation.location.PerturbationLocation __L6900;

    public static perturbation.location.PerturbationLocation __L6901;

    public static perturbation.location.PerturbationLocation __L6902;

    public static perturbation.location.PerturbationLocation __L6903;

    public static perturbation.location.PerturbationLocation __L6904;

    public static perturbation.location.PerturbationLocation __L6905;

    public static perturbation.location.PerturbationLocation __L6906;

    public static perturbation.location.PerturbationLocation __L6907;

    public static perturbation.location.PerturbationLocation __L6908;

    public static perturbation.location.PerturbationLocation __L6909;

    public static perturbation.location.PerturbationLocation __L6910;

    public static perturbation.location.PerturbationLocation __L6911;

    public static perturbation.location.PerturbationLocation __L6912;

    public static perturbation.location.PerturbationLocation __L6913;

    public static perturbation.location.PerturbationLocation __L6914;

    public static perturbation.location.PerturbationLocation __L6915;

    public static perturbation.location.PerturbationLocation __L6916;

    public static perturbation.location.PerturbationLocation __L6917;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:67)", 6891, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:67)", 6892, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:74)", 6893, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:75)", 6894, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6895, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6896, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6897, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6898, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6899, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6900, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6901, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:76)", 6902, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:77)", 6903, "Numerical");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:82)", 6904, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:83)", 6905, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:84)", 6906, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:85)", 6907, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:86)", 6908, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:86)", 6909, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:87)", 6910, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:89)", 6911, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:90)", 6912, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:91)", 6913, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:92)", 6914, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:92)", 6915, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:93)", 6916, "Boolean");
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.__L6917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/WeightUnitOfMeasureType.java:94)", 6917, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.WeightUnitOfMeasureType.initPerturbationLocation0();
    }
}

