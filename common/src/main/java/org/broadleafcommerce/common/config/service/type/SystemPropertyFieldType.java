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
package org.broadleafcommerce.common.config.service.type;


public class SystemPropertyFieldType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType>();

    public static final org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType INT_TYPE = new org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType("INT_TYPE", "Integer value");

    public static final org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType LONG_TYPE = new org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType("LONG_TYPE", "Long value");

    public static final org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType DOUBLE_TYPE = new org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType("DOUBLE_TYPE", "Double value");

    public static final org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType BOOLEAN_TYPE = new org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType("BOOLEAN_TYPE", "Boolean value");

    public static final org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType STRING_TYPE = new org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType("STRING", "String value");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.TYPES.get(type);
    }

    public SystemPropertyFieldType() {
    }

    public SystemPropertyFieldType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    @java.lang.Override
    public java.lang.String getType() {
        return type;
    }

    @java.lang.Override
    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L384, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L383, org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L385, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L386, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L394, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L389, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L387, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L388, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L393, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L390, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L391, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L392, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L395, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L396, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L397, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L398, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L399, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L401, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L400, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L402, false);

        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType other = ((org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L403, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L404, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L405, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L407, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L406, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L408, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L409, true);
    }

    public static perturbation.location.PerturbationLocation __L383;

    public static perturbation.location.PerturbationLocation __L384;

    public static perturbation.location.PerturbationLocation __L385;

    public static perturbation.location.PerturbationLocation __L386;

    public static perturbation.location.PerturbationLocation __L387;

    public static perturbation.location.PerturbationLocation __L388;

    public static perturbation.location.PerturbationLocation __L389;

    public static perturbation.location.PerturbationLocation __L390;

    public static perturbation.location.PerturbationLocation __L391;

    public static perturbation.location.PerturbationLocation __L392;

    public static perturbation.location.PerturbationLocation __L393;

    public static perturbation.location.PerturbationLocation __L394;

    public static perturbation.location.PerturbationLocation __L395;

    public static perturbation.location.PerturbationLocation __L396;

    public static perturbation.location.PerturbationLocation __L397;

    public static perturbation.location.PerturbationLocation __L398;

    public static perturbation.location.PerturbationLocation __L399;

    public static perturbation.location.PerturbationLocation __L400;

    public static perturbation.location.PerturbationLocation __L401;

    public static perturbation.location.PerturbationLocation __L402;

    public static perturbation.location.PerturbationLocation __L403;

    public static perturbation.location.PerturbationLocation __L404;

    public static perturbation.location.PerturbationLocation __L405;

    public static perturbation.location.PerturbationLocation __L406;

    public static perturbation.location.PerturbationLocation __L407;

    public static perturbation.location.PerturbationLocation __L408;

    public static perturbation.location.PerturbationLocation __L409;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:67)", 383, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:67)", 384, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:74)", 385, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:75)", 386, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 387, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 388, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 389, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 390, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 391, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 392, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 393, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:76)", 394, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:77)", 395, "Numerical");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:82)", 396, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:83)", 397, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:84)", 398, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:85)", 399, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:86)", 400, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:86)", 401, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:87)", 402, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:89)", 403, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:90)", 404, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:91)", 405, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:92)", 406, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:92)", 407, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:93)", 408, "Boolean");
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.__L409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/SystemPropertyFieldType.java:94)", 409, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.initPerturbationLocation0();
    }
}

