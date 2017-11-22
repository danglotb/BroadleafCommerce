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
package org.broadleafcommerce.common.sitemap.service.type;


public class SiteMapPriorityType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType>();

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType ZERO = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.0", "0.0");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT1 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.1", "0.1");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT2 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.2", "0.2");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT3 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.3", "0.3");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT4 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.4", "0.4");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT5 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.5", "0.5");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT6 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.6", "0.6");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT7 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.7", "0.7");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT8 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.8", "0.8");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType POINT9 = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("0.9", "0.9");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType ONE = new org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType("1.0", "1.0");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.TYPES.get(type);
    }

    public SiteMapPriorityType() {
    }

    public SiteMapPriorityType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5462, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5461, org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5463, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5464, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5472, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5467, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5465, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5466, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5471, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5468, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5469, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5470, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5473, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5474, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5475, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5476, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5477, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5479, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5478, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5480, false);

        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType other = ((org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5481, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5482, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5483, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5485, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5484, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5486, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5487, true);
    }

    public static perturbation.location.PerturbationLocation __L5461;

    public static perturbation.location.PerturbationLocation __L5462;

    public static perturbation.location.PerturbationLocation __L5463;

    public static perturbation.location.PerturbationLocation __L5464;

    public static perturbation.location.PerturbationLocation __L5465;

    public static perturbation.location.PerturbationLocation __L5466;

    public static perturbation.location.PerturbationLocation __L5467;

    public static perturbation.location.PerturbationLocation __L5468;

    public static perturbation.location.PerturbationLocation __L5469;

    public static perturbation.location.PerturbationLocation __L5470;

    public static perturbation.location.PerturbationLocation __L5471;

    public static perturbation.location.PerturbationLocation __L5472;

    public static perturbation.location.PerturbationLocation __L5473;

    public static perturbation.location.PerturbationLocation __L5474;

    public static perturbation.location.PerturbationLocation __L5475;

    public static perturbation.location.PerturbationLocation __L5476;

    public static perturbation.location.PerturbationLocation __L5477;

    public static perturbation.location.PerturbationLocation __L5478;

    public static perturbation.location.PerturbationLocation __L5479;

    public static perturbation.location.PerturbationLocation __L5480;

    public static perturbation.location.PerturbationLocation __L5481;

    public static perturbation.location.PerturbationLocation __L5482;

    public static perturbation.location.PerturbationLocation __L5483;

    public static perturbation.location.PerturbationLocation __L5484;

    public static perturbation.location.PerturbationLocation __L5485;

    public static perturbation.location.PerturbationLocation __L5486;

    public static perturbation.location.PerturbationLocation __L5487;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:76)", 5461, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:76)", 5462, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:83)", 5463, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:84)", 5464, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5465, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5466, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5467, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5468, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5469, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5470, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5471, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:85)", 5472, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:86)", 5473, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:91)", 5474, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:92)", 5475, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:93)", 5476, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:94)", 5477, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:95)", 5478, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:95)", 5479, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:96)", 5480, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:98)", 5481, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:99)", 5482, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:100)", 5483, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:101)", 5484, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:101)", 5485, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:102)", 5486, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.__L5487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapPriorityType.java:103)", 5487, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType.initPerturbationLocation0();
    }
}

