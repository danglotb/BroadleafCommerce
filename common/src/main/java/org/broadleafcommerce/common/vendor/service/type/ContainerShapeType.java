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
package org.broadleafcommerce.common.vendor.service.type;


public class ContainerShapeType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.vendor.service.type.ContainerShapeType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.vendor.service.type.ContainerShapeType>();

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.vendor.service.type.ContainerShapeType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.TYPES.get(type);
    }

    public ContainerShapeType() {
    }

    public ContainerShapeType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6946, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6945, org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6947, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6948, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6956, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6951, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6949, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6950, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6955, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6952, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6953, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6954, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6957, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6958, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6959, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6960, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6961, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6963, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6962, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6964, false);

        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType other = ((org.broadleafcommerce.common.vendor.service.type.ContainerShapeType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6965, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6966, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6967, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6969, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6968, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6970, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6971, true);
    }

    public static perturbation.location.PerturbationLocation __L6945;

    public static perturbation.location.PerturbationLocation __L6946;

    public static perturbation.location.PerturbationLocation __L6947;

    public static perturbation.location.PerturbationLocation __L6948;

    public static perturbation.location.PerturbationLocation __L6949;

    public static perturbation.location.PerturbationLocation __L6950;

    public static perturbation.location.PerturbationLocation __L6951;

    public static perturbation.location.PerturbationLocation __L6952;

    public static perturbation.location.PerturbationLocation __L6953;

    public static perturbation.location.PerturbationLocation __L6954;

    public static perturbation.location.PerturbationLocation __L6955;

    public static perturbation.location.PerturbationLocation __L6956;

    public static perturbation.location.PerturbationLocation __L6957;

    public static perturbation.location.PerturbationLocation __L6958;

    public static perturbation.location.PerturbationLocation __L6959;

    public static perturbation.location.PerturbationLocation __L6960;

    public static perturbation.location.PerturbationLocation __L6961;

    public static perturbation.location.PerturbationLocation __L6962;

    public static perturbation.location.PerturbationLocation __L6963;

    public static perturbation.location.PerturbationLocation __L6964;

    public static perturbation.location.PerturbationLocation __L6965;

    public static perturbation.location.PerturbationLocation __L6966;

    public static perturbation.location.PerturbationLocation __L6967;

    public static perturbation.location.PerturbationLocation __L6968;

    public static perturbation.location.PerturbationLocation __L6969;

    public static perturbation.location.PerturbationLocation __L6970;

    public static perturbation.location.PerturbationLocation __L6971;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:63)", 6945, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:63)", 6946, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:72)", 6947, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:73)", 6948, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6949, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6950, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6951, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6952, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6953, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6954, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6955, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:74)", 6956, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:75)", 6957, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:80)", 6958, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:81)", 6959, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:82)", 6960, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:83)", 6961, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:84)", 6962, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:84)", 6963, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:85)", 6964, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:87)", 6965, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:88)", 6966, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:89)", 6967, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:90)", 6968, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:90)", 6969, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:91)", 6970, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.__L6971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerShapeType.java:92)", 6971, "Boolean");
    }

    static {
        org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.initPerturbationLocation0();
    }
}

