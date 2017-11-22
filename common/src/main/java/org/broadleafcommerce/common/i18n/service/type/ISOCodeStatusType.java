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
package org.broadleafcommerce.common.i18n.service.type;


public class ISOCodeStatusType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType>();

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType OFFICIALLY_ASSIGNED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("OFFICIALLY_ASSIGNED", "Officially assigned: assigned to a country, territory, or area of geographical interest.");

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType USER_ASSIGNED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("USER_ASSIGNED", "User-assigned: free for assignment at the disposal of users.");

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType EXCEPTIONALLY_RESERVED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("EXCEPTIONALLY_RESERVED", "Exceptionally reserved: reserved on request for restricted use.");

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType TRANSITIONALLY_RESERVED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("TRANSITIONALLY_RESERVED", "Transitionally reserved: deleted from ISO 3166-1 but reserved transitionally.");

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType INDETERMINATELY_RESERVED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("INDETERMINATELY_RESERVED", "Indeterminately reserved: used in coding systems associated with ISO 3166-1.");

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType NOT_USED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("NOT_USED", "Not used: not used in ISO 3166-1 in deference to intergovernmental intellectual property organisation names.");

    public static final org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType UNASSIGNED = new org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType("UNASSIGNED", "Unassigned: free for assignment by the ISO 3166/MA only.");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.TYPES.get(type);
    }

    public ISOCodeStatusType() {
    }

    public ISOCodeStatusType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2903, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2902, org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2904, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2905, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2913, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2908, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2906, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2907, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2912, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2909, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2910, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2911, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2914, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2915, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2916, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2917, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2918, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2920, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2919, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2921, false);

        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType other = ((org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2922, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2923, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2924, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2926, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2925, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2927, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2928, true);
    }

    public static perturbation.location.PerturbationLocation __L2902;

    public static perturbation.location.PerturbationLocation __L2903;

    public static perturbation.location.PerturbationLocation __L2904;

    public static perturbation.location.PerturbationLocation __L2905;

    public static perturbation.location.PerturbationLocation __L2906;

    public static perturbation.location.PerturbationLocation __L2907;

    public static perturbation.location.PerturbationLocation __L2908;

    public static perturbation.location.PerturbationLocation __L2909;

    public static perturbation.location.PerturbationLocation __L2910;

    public static perturbation.location.PerturbationLocation __L2911;

    public static perturbation.location.PerturbationLocation __L2912;

    public static perturbation.location.PerturbationLocation __L2913;

    public static perturbation.location.PerturbationLocation __L2914;

    public static perturbation.location.PerturbationLocation __L2915;

    public static perturbation.location.PerturbationLocation __L2916;

    public static perturbation.location.PerturbationLocation __L2917;

    public static perturbation.location.PerturbationLocation __L2918;

    public static perturbation.location.PerturbationLocation __L2919;

    public static perturbation.location.PerturbationLocation __L2920;

    public static perturbation.location.PerturbationLocation __L2921;

    public static perturbation.location.PerturbationLocation __L2922;

    public static perturbation.location.PerturbationLocation __L2923;

    public static perturbation.location.PerturbationLocation __L2924;

    public static perturbation.location.PerturbationLocation __L2925;

    public static perturbation.location.PerturbationLocation __L2926;

    public static perturbation.location.PerturbationLocation __L2927;

    public static perturbation.location.PerturbationLocation __L2928;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:71)", 2902, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:71)", 2903, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:78)", 2904, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:79)", 2905, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2906, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2907, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2908, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2909, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2910, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2911, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2912, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:80)", 2913, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:81)", 2914, "Numerical");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:86)", 2915, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:87)", 2916, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:88)", 2917, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:89)", 2918, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:90)", 2919, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:90)", 2920, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:91)", 2921, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:93)", 2922, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:94)", 2923, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:95)", 2924, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:96)", 2925, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:96)", 2926, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:97)", 2927, "Boolean");
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.__L2928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/type/ISOCodeStatusType.java:98)", 2928, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.initPerturbationLocation0();
    }
}

