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
package org.broadleafcommerce.common.web.device;


public class WebRequestDeviceType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.web.device.WebRequestDeviceType> TYPES = new java.util.LinkedHashMap<>();

    public static final org.broadleafcommerce.common.web.device.WebRequestDeviceType UNKNOWN = new org.broadleafcommerce.common.web.device.WebRequestDeviceType("UNKNOWN", "Unknown");

    public static final org.broadleafcommerce.common.web.device.WebRequestDeviceType NORMAL = new org.broadleafcommerce.common.web.device.WebRequestDeviceType("NORMAL", "Normal");

    public static final org.broadleafcommerce.common.web.device.WebRequestDeviceType MOBILE = new org.broadleafcommerce.common.web.device.WebRequestDeviceType("MOBILE", "Mobile");

    public static final org.broadleafcommerce.common.web.device.WebRequestDeviceType TABLET = new org.broadleafcommerce.common.web.device.WebRequestDeviceType("TABLET", "Tablet");

    private java.lang.String type;

    private java.lang.String friendlyType;

    WebRequestDeviceType() {
    }

    WebRequestDeviceType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7172, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7171, org.broadleafcommerce.common.web.device.WebRequestDeviceType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.web.device.WebRequestDeviceType.TYPES.put(type, this);
        }
    }

    public static org.broadleafcommerce.common.web.device.WebRequestDeviceType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.web.device.WebRequestDeviceType.TYPES.get(type);
    }

    @java.lang.Override
    public java.lang.String getType() {
        return type;
    }

    @java.lang.Override
    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return getFriendlyType();
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7175, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7173, (o != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7174, getClass().isAssignableFrom(o.getClass())))))) {
            final org.broadleafcommerce.common.web.device.WebRequestDeviceType other = ((org.broadleafcommerce.common.web.device.WebRequestDeviceType) (o));
            return new org.apache.commons.lang3.builder.EqualsBuilder().append(getType(), other.getType()).append(getFriendlyType(), other.getFriendlyType()).build();
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7176, false);
    }

    @java.lang.Override
    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7177, new org.apache.commons.lang3.builder.HashCodeBuilder().append(getFriendlyType()).append(getType()).build());
    }

    public static perturbation.location.PerturbationLocation __L7171;

    public static perturbation.location.PerturbationLocation __L7172;

    public static perturbation.location.PerturbationLocation __L7173;

    public static perturbation.location.PerturbationLocation __L7174;

    public static perturbation.location.PerturbationLocation __L7175;

    public static perturbation.location.PerturbationLocation __L7176;

    public static perturbation.location.PerturbationLocation __L7177;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:54)", 7171, "Boolean");
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:54)", 7172, "Boolean");
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:80)", 7173, "Boolean");
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:80)", 7174, "Boolean");
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:80)", 7175, "Boolean");
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:89)", 7176, "Boolean");
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.__L7177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/device/WebRequestDeviceType.java:94)", 7177, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.device.WebRequestDeviceType.initPerturbationLocation0();
    }
}

