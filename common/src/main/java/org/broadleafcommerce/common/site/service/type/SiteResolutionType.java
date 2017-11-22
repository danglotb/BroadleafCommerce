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
package org.broadleafcommerce.common.site.service.type;


public class SiteResolutionType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.site.service.type.SiteResolutionType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.site.service.type.SiteResolutionType>();

    public static final org.broadleafcommerce.common.site.service.type.SiteResolutionType DOMAIN = new org.broadleafcommerce.common.site.service.type.SiteResolutionType("DOMAIN", "Domain");

    public static final org.broadleafcommerce.common.site.service.type.SiteResolutionType DOMAIN_PREFIX = new org.broadleafcommerce.common.site.service.type.SiteResolutionType("DOMAIN_PREFIX", "Domain Prefix");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.site.service.type.SiteResolutionType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.site.service.type.SiteResolutionType.TYPES.get(type);
    }

    public SiteResolutionType() {
    }

    public SiteResolutionType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5289, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5288, org.broadleafcommerce.common.site.service.type.SiteResolutionType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.site.service.type.SiteResolutionType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5290, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5291, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5299, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5294, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5292, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5293, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5298, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5295, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5296, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5297, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5300, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5301, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5302, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5303, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5304, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5306, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5305, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5307, false);

        org.broadleafcommerce.common.site.service.type.SiteResolutionType other = ((org.broadleafcommerce.common.site.service.type.SiteResolutionType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5308, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5309, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5310, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5312, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5311, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5313, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5314, true);
    }

    public static perturbation.location.PerturbationLocation __L5288;

    public static perturbation.location.PerturbationLocation __L5289;

    public static perturbation.location.PerturbationLocation __L5290;

    public static perturbation.location.PerturbationLocation __L5291;

    public static perturbation.location.PerturbationLocation __L5292;

    public static perturbation.location.PerturbationLocation __L5293;

    public static perturbation.location.PerturbationLocation __L5294;

    public static perturbation.location.PerturbationLocation __L5295;

    public static perturbation.location.PerturbationLocation __L5296;

    public static perturbation.location.PerturbationLocation __L5297;

    public static perturbation.location.PerturbationLocation __L5298;

    public static perturbation.location.PerturbationLocation __L5299;

    public static perturbation.location.PerturbationLocation __L5300;

    public static perturbation.location.PerturbationLocation __L5301;

    public static perturbation.location.PerturbationLocation __L5302;

    public static perturbation.location.PerturbationLocation __L5303;

    public static perturbation.location.PerturbationLocation __L5304;

    public static perturbation.location.PerturbationLocation __L5305;

    public static perturbation.location.PerturbationLocation __L5306;

    public static perturbation.location.PerturbationLocation __L5307;

    public static perturbation.location.PerturbationLocation __L5308;

    public static perturbation.location.PerturbationLocation __L5309;

    public static perturbation.location.PerturbationLocation __L5310;

    public static perturbation.location.PerturbationLocation __L5311;

    public static perturbation.location.PerturbationLocation __L5312;

    public static perturbation.location.PerturbationLocation __L5313;

    public static perturbation.location.PerturbationLocation __L5314;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:80)", 5288, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:80)", 5289, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:87)", 5290, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:88)", 5291, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5292, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5293, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5294, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5295, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5296, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5297, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5298, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:89)", 5299, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:90)", 5300, "Numerical");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:95)", 5301, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:96)", 5302, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:97)", 5303, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:98)", 5304, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:99)", 5305, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:99)", 5306, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:100)", 5307, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:102)", 5308, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:103)", 5309, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:104)", 5310, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:105)", 5311, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:105)", 5312, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:106)", 5313, "Boolean");
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.__L5314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/type/SiteResolutionType.java:107)", 5314, "Boolean");
    }

    static {
        org.broadleafcommerce.common.site.service.type.SiteResolutionType.initPerturbationLocation0();
    }
}

