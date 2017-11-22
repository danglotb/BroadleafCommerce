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
package org.broadleafcommerce.common.file.service.type;


public class FileApplicationType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.file.service.type.FileApplicationType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.file.service.type.FileApplicationType>();

    public static final org.broadleafcommerce.common.file.service.type.FileApplicationType ALL = new org.broadleafcommerce.common.file.service.type.FileApplicationType("ALL", "All");

    public static final org.broadleafcommerce.common.file.service.type.FileApplicationType IMAGE = new org.broadleafcommerce.common.file.service.type.FileApplicationType("IMAGE", "Images");

    public static final org.broadleafcommerce.common.file.service.type.FileApplicationType STATIC = new org.broadleafcommerce.common.file.service.type.FileApplicationType("STATIC", "Static Assets");

    public static final org.broadleafcommerce.common.file.service.type.FileApplicationType SITE_MAP = new org.broadleafcommerce.common.file.service.type.FileApplicationType("SITEMAP", "Site Map");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.file.service.type.FileApplicationType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.file.service.type.FileApplicationType.TYPES.get(type);
    }

    public FileApplicationType() {
    }

    public FileApplicationType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2500, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2499, org.broadleafcommerce.common.file.service.type.FileApplicationType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.file.service.type.FileApplicationType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2501, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2502, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2510, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2505, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2503, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2504, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2509, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2506, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2507, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2508, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2511, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2512, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2513, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2514, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2515, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2517, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2516, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2518, false);

        org.broadleafcommerce.common.file.service.type.FileApplicationType other = ((org.broadleafcommerce.common.file.service.type.FileApplicationType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2519, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2520, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2521, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2523, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2522, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2524, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2525, true);
    }

    public static perturbation.location.PerturbationLocation __L2499;

    public static perturbation.location.PerturbationLocation __L2500;

    public static perturbation.location.PerturbationLocation __L2501;

    public static perturbation.location.PerturbationLocation __L2502;

    public static perturbation.location.PerturbationLocation __L2503;

    public static perturbation.location.PerturbationLocation __L2504;

    public static perturbation.location.PerturbationLocation __L2505;

    public static perturbation.location.PerturbationLocation __L2506;

    public static perturbation.location.PerturbationLocation __L2507;

    public static perturbation.location.PerturbationLocation __L2508;

    public static perturbation.location.PerturbationLocation __L2509;

    public static perturbation.location.PerturbationLocation __L2510;

    public static perturbation.location.PerturbationLocation __L2511;

    public static perturbation.location.PerturbationLocation __L2512;

    public static perturbation.location.PerturbationLocation __L2513;

    public static perturbation.location.PerturbationLocation __L2514;

    public static perturbation.location.PerturbationLocation __L2515;

    public static perturbation.location.PerturbationLocation __L2516;

    public static perturbation.location.PerturbationLocation __L2517;

    public static perturbation.location.PerturbationLocation __L2518;

    public static perturbation.location.PerturbationLocation __L2519;

    public static perturbation.location.PerturbationLocation __L2520;

    public static perturbation.location.PerturbationLocation __L2521;

    public static perturbation.location.PerturbationLocation __L2522;

    public static perturbation.location.PerturbationLocation __L2523;

    public static perturbation.location.PerturbationLocation __L2524;

    public static perturbation.location.PerturbationLocation __L2525;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:80)", 2499, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:80)", 2500, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:87)", 2501, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:88)", 2502, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2503, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2504, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2505, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2506, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2507, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2508, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2509, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:89)", 2510, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:90)", 2511, "Numerical");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:95)", 2512, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:96)", 2513, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:97)", 2514, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:98)", 2515, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:99)", 2516, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:99)", 2517, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:100)", 2518, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:102)", 2519, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:103)", 2520, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:104)", 2521, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:105)", 2522, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:105)", 2523, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:106)", 2524, "Boolean");
        org.broadleafcommerce.common.file.service.type.FileApplicationType.__L2525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/type/FileApplicationType.java:107)", 2525, "Boolean");
    }

    static {
        org.broadleafcommerce.common.file.service.type.FileApplicationType.initPerturbationLocation0();
    }
}

