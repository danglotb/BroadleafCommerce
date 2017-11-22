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


public class SiteMapChangeFreqType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType>();

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType ALWAYS = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("ALWAYS", "always");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType HOURLY = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("HOURLY", "hourly");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType DAILY = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("DAILY", "daily");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType WEEKLY = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("WEEKLY", "weekly");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType MONTHLY = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("MONTHLY", "monthly");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType YEARLY = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("YEARLY", "yearly");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType NEVER = new org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType("NEVER", "never");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.TYPES.get(type);
    }

    public SiteMapChangeFreqType() {
    }

    public SiteMapChangeFreqType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5408, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5407, org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5409, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5410, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5418, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5413, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5411, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5412, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5417, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5414, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5415, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5416, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5419, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5420, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5421, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5422, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5423, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5425, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5424, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5426, false);

        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType other = ((org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5427, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5428, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5429, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5431, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5430, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5432, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5433, true);
    }

    public static perturbation.location.PerturbationLocation __L5407;

    public static perturbation.location.PerturbationLocation __L5408;

    public static perturbation.location.PerturbationLocation __L5409;

    public static perturbation.location.PerturbationLocation __L5410;

    public static perturbation.location.PerturbationLocation __L5411;

    public static perturbation.location.PerturbationLocation __L5412;

    public static perturbation.location.PerturbationLocation __L5413;

    public static perturbation.location.PerturbationLocation __L5414;

    public static perturbation.location.PerturbationLocation __L5415;

    public static perturbation.location.PerturbationLocation __L5416;

    public static perturbation.location.PerturbationLocation __L5417;

    public static perturbation.location.PerturbationLocation __L5418;

    public static perturbation.location.PerturbationLocation __L5419;

    public static perturbation.location.PerturbationLocation __L5420;

    public static perturbation.location.PerturbationLocation __L5421;

    public static perturbation.location.PerturbationLocation __L5422;

    public static perturbation.location.PerturbationLocation __L5423;

    public static perturbation.location.PerturbationLocation __L5424;

    public static perturbation.location.PerturbationLocation __L5425;

    public static perturbation.location.PerturbationLocation __L5426;

    public static perturbation.location.PerturbationLocation __L5427;

    public static perturbation.location.PerturbationLocation __L5428;

    public static perturbation.location.PerturbationLocation __L5429;

    public static perturbation.location.PerturbationLocation __L5430;

    public static perturbation.location.PerturbationLocation __L5431;

    public static perturbation.location.PerturbationLocation __L5432;

    public static perturbation.location.PerturbationLocation __L5433;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:72)", 5407, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:72)", 5408, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:79)", 5409, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:80)", 5410, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5411, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5412, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5413, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5414, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5415, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5416, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5417, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:81)", 5418, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:82)", 5419, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:87)", 5420, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:88)", 5421, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:89)", 5422, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:90)", 5423, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:91)", 5424, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:91)", 5425, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:92)", 5426, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:94)", 5427, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:95)", 5428, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:96)", 5429, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:97)", 5430, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:97)", 5431, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:98)", 5432, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.__L5433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapChangeFreqType.java:99)", 5433, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType.initPerturbationLocation0();
    }
}

