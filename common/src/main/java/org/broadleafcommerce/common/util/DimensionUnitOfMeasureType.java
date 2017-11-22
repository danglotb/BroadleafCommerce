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


public class DimensionUnitOfMeasureType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.util.DimensionUnitOfMeasureType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.util.DimensionUnitOfMeasureType>();

    public static final org.broadleafcommerce.common.util.DimensionUnitOfMeasureType CENTIMETERS = new org.broadleafcommerce.common.util.DimensionUnitOfMeasureType("CENTIMETERS", "Centimeters");

    public static final org.broadleafcommerce.common.util.DimensionUnitOfMeasureType METERS = new org.broadleafcommerce.common.util.DimensionUnitOfMeasureType("METERS", "Meters");

    public static final org.broadleafcommerce.common.util.DimensionUnitOfMeasureType INCHES = new org.broadleafcommerce.common.util.DimensionUnitOfMeasureType("INCHES", "Inches");

    public static final org.broadleafcommerce.common.util.DimensionUnitOfMeasureType FEET = new org.broadleafcommerce.common.util.DimensionUnitOfMeasureType("FEET", "Feet");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.util.DimensionUnitOfMeasureType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.TYPES.get(type);
    }

    public DimensionUnitOfMeasureType() {
    }

    public DimensionUnitOfMeasureType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6291, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6290, org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6292, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6293, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6301, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6296, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6294, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6295, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6300, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6297, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6298, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6299, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6302, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6303, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6304, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6305, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6306, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6308, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6307, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6309, false);

        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType other = ((org.broadleafcommerce.common.util.DimensionUnitOfMeasureType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6310, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6311, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6312, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6314, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6313, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6315, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6316, true);
    }

    public static perturbation.location.PerturbationLocation __L6290;

    public static perturbation.location.PerturbationLocation __L6291;

    public static perturbation.location.PerturbationLocation __L6292;

    public static perturbation.location.PerturbationLocation __L6293;

    public static perturbation.location.PerturbationLocation __L6294;

    public static perturbation.location.PerturbationLocation __L6295;

    public static perturbation.location.PerturbationLocation __L6296;

    public static perturbation.location.PerturbationLocation __L6297;

    public static perturbation.location.PerturbationLocation __L6298;

    public static perturbation.location.PerturbationLocation __L6299;

    public static perturbation.location.PerturbationLocation __L6300;

    public static perturbation.location.PerturbationLocation __L6301;

    public static perturbation.location.PerturbationLocation __L6302;

    public static perturbation.location.PerturbationLocation __L6303;

    public static perturbation.location.PerturbationLocation __L6304;

    public static perturbation.location.PerturbationLocation __L6305;

    public static perturbation.location.PerturbationLocation __L6306;

    public static perturbation.location.PerturbationLocation __L6307;

    public static perturbation.location.PerturbationLocation __L6308;

    public static perturbation.location.PerturbationLocation __L6309;

    public static perturbation.location.PerturbationLocation __L6310;

    public static perturbation.location.PerturbationLocation __L6311;

    public static perturbation.location.PerturbationLocation __L6312;

    public static perturbation.location.PerturbationLocation __L6313;

    public static perturbation.location.PerturbationLocation __L6314;

    public static perturbation.location.PerturbationLocation __L6315;

    public static perturbation.location.PerturbationLocation __L6316;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:69)", 6290, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:69)", 6291, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:76)", 6292, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:77)", 6293, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6294, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6295, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6296, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6297, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6298, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6299, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6300, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:78)", 6301, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:79)", 6302, "Numerical");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:84)", 6303, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:85)", 6304, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:86)", 6305, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:87)", 6306, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:88)", 6307, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:88)", 6308, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:89)", 6309, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:91)", 6310, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:92)", 6311, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:93)", 6312, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:94)", 6313, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:94)", 6314, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:95)", 6315, "Boolean");
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.__L6316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DimensionUnitOfMeasureType.java:96)", 6316, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.initPerturbationLocation0();
    }
}

