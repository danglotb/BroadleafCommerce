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


public class ContainerSizeType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.vendor.service.type.ContainerSizeType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.vendor.service.type.ContainerSizeType>();

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.vendor.service.type.ContainerSizeType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.TYPES.get(type);
    }

    public ContainerSizeType() {
    }

    public ContainerSizeType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6973, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6972, org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6974, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6975, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6983, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6978, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6976, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6977, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6982, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6979, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6980, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6981, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6984, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6985, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6986, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6987, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6988, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6990, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6989, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6991, false);

        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType other = ((org.broadleafcommerce.common.vendor.service.type.ContainerSizeType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6992, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6993, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6994, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6996, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6995, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6997, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6998, true);
    }

    public static perturbation.location.PerturbationLocation __L6972;

    public static perturbation.location.PerturbationLocation __L6973;

    public static perturbation.location.PerturbationLocation __L6974;

    public static perturbation.location.PerturbationLocation __L6975;

    public static perturbation.location.PerturbationLocation __L6976;

    public static perturbation.location.PerturbationLocation __L6977;

    public static perturbation.location.PerturbationLocation __L6978;

    public static perturbation.location.PerturbationLocation __L6979;

    public static perturbation.location.PerturbationLocation __L6980;

    public static perturbation.location.PerturbationLocation __L6981;

    public static perturbation.location.PerturbationLocation __L6982;

    public static perturbation.location.PerturbationLocation __L6983;

    public static perturbation.location.PerturbationLocation __L6984;

    public static perturbation.location.PerturbationLocation __L6985;

    public static perturbation.location.PerturbationLocation __L6986;

    public static perturbation.location.PerturbationLocation __L6987;

    public static perturbation.location.PerturbationLocation __L6988;

    public static perturbation.location.PerturbationLocation __L6989;

    public static perturbation.location.PerturbationLocation __L6990;

    public static perturbation.location.PerturbationLocation __L6991;

    public static perturbation.location.PerturbationLocation __L6992;

    public static perturbation.location.PerturbationLocation __L6993;

    public static perturbation.location.PerturbationLocation __L6994;

    public static perturbation.location.PerturbationLocation __L6995;

    public static perturbation.location.PerturbationLocation __L6996;

    public static perturbation.location.PerturbationLocation __L6997;

    public static perturbation.location.PerturbationLocation __L6998;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:63)", 6972, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:63)", 6973, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:72)", 6974, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:73)", 6975, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6976, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6977, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6978, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6979, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6980, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6981, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6982, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:74)", 6983, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:75)", 6984, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:80)", 6985, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:81)", 6986, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:82)", 6987, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:83)", 6988, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:84)", 6989, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:84)", 6990, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:85)", 6991, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:87)", 6992, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:88)", 6993, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:89)", 6994, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:90)", 6995, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:90)", 6996, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:91)", 6997, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.__L6998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ContainerSizeType.java:92)", 6998, "Boolean");
    }

    static {
        org.broadleafcommerce.common.vendor.service.type.ContainerSizeType.initPerturbationLocation0();
    }
}

