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


public class ServiceStatusType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType>();

    public static final org.broadleafcommerce.common.vendor.service.type.ServiceStatusType UP = new org.broadleafcommerce.common.vendor.service.type.ServiceStatusType("UP", "Up");

    public static final org.broadleafcommerce.common.vendor.service.type.ServiceStatusType DOWN = new org.broadleafcommerce.common.vendor.service.type.ServiceStatusType("DOWN", "Down");

    public static final org.broadleafcommerce.common.vendor.service.type.ServiceStatusType PAUSED = new org.broadleafcommerce.common.vendor.service.type.ServiceStatusType("PAUSED", "Paused");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.vendor.service.type.ServiceStatusType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.TYPES.get(type);
    }

    public ServiceStatusType() {
    }

    public ServiceStatusType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7000, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L6999, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7001, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7002, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7010, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7005, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7003, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7004, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7009, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7006, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7007, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7008, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7011, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7012, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7013, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7014, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7015, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7017, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7016, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7018, false);

        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType other = ((org.broadleafcommerce.common.vendor.service.type.ServiceStatusType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7019, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7020, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7021, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7023, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7022, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7024, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7025, true);
    }

    public static perturbation.location.PerturbationLocation __L6999;

    public static perturbation.location.PerturbationLocation __L7000;

    public static perturbation.location.PerturbationLocation __L7001;

    public static perturbation.location.PerturbationLocation __L7002;

    public static perturbation.location.PerturbationLocation __L7003;

    public static perturbation.location.PerturbationLocation __L7004;

    public static perturbation.location.PerturbationLocation __L7005;

    public static perturbation.location.PerturbationLocation __L7006;

    public static perturbation.location.PerturbationLocation __L7007;

    public static perturbation.location.PerturbationLocation __L7008;

    public static perturbation.location.PerturbationLocation __L7009;

    public static perturbation.location.PerturbationLocation __L7010;

    public static perturbation.location.PerturbationLocation __L7011;

    public static perturbation.location.PerturbationLocation __L7012;

    public static perturbation.location.PerturbationLocation __L7013;

    public static perturbation.location.PerturbationLocation __L7014;

    public static perturbation.location.PerturbationLocation __L7015;

    public static perturbation.location.PerturbationLocation __L7016;

    public static perturbation.location.PerturbationLocation __L7017;

    public static perturbation.location.PerturbationLocation __L7018;

    public static perturbation.location.PerturbationLocation __L7019;

    public static perturbation.location.PerturbationLocation __L7020;

    public static perturbation.location.PerturbationLocation __L7021;

    public static perturbation.location.PerturbationLocation __L7022;

    public static perturbation.location.PerturbationLocation __L7023;

    public static perturbation.location.PerturbationLocation __L7024;

    public static perturbation.location.PerturbationLocation __L7025;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L6999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:68)", 6999, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:68)", 7000, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:77)", 7001, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:78)", 7002, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7003, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7004, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7005, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7006, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7007, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7008, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7009, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:79)", 7010, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:80)", 7011, "Numerical");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:85)", 7012, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:86)", 7013, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:87)", 7014, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:88)", 7015, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:89)", 7016, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:89)", 7017, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:90)", 7018, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:92)", 7019, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:93)", 7020, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:94)", 7021, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:95)", 7022, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:95)", 7023, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:96)", 7024, "Boolean");
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.__L7025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/type/ServiceStatusType.java:97)", 7025, "Boolean");
    }

    static {
        org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.initPerturbationLocation0();
    }
}

