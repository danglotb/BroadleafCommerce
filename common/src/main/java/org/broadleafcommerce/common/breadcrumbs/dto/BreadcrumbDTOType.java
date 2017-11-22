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
package org.broadleafcommerce.common.breadcrumbs.dto;


public class BreadcrumbDTOType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType>();

    public static final org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType HOME = new org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType("HOME", "Home");

    public static final org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType CATEGORY = new org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType("CATEGORY", "Category");

    public static final org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType PRODUCT = new org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType("PRODUCT", "Product");

    public static final org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType SEARCH = new org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType("SEARCH", "Search");

    public static final org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType PAGE = new org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType("PAGE", "Page");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.TYPES.get(type);
    }

    public BreadcrumbDTOType() {
    }

    public BreadcrumbDTOType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L82, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L81, org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L83, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L84, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L92, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L87, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L85, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L86, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L91, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L88, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L89, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L90, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L93, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L94, ((this) == obj))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L95, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L96, (obj == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L97, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L99, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L98, getClass().isAssignableFrom(obj.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L100, false);
        }
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType other = ((org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L101, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L102, ((other.type) != null))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L103, false);
            }
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L105, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L104, type.equals(other.type)))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L106, false);
            }

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L107, true);
    }

    public static perturbation.location.PerturbationLocation __L81;

    public static perturbation.location.PerturbationLocation __L82;

    public static perturbation.location.PerturbationLocation __L83;

    public static perturbation.location.PerturbationLocation __L84;

    public static perturbation.location.PerturbationLocation __L85;

    public static perturbation.location.PerturbationLocation __L86;

    public static perturbation.location.PerturbationLocation __L87;

    public static perturbation.location.PerturbationLocation __L88;

    public static perturbation.location.PerturbationLocation __L89;

    public static perturbation.location.PerturbationLocation __L90;

    public static perturbation.location.PerturbationLocation __L91;

    public static perturbation.location.PerturbationLocation __L92;

    public static perturbation.location.PerturbationLocation __L93;

    public static perturbation.location.PerturbationLocation __L94;

    public static perturbation.location.PerturbationLocation __L95;

    public static perturbation.location.PerturbationLocation __L96;

    public static perturbation.location.PerturbationLocation __L97;

    public static perturbation.location.PerturbationLocation __L98;

    public static perturbation.location.PerturbationLocation __L99;

    public static perturbation.location.PerturbationLocation __L100;

    public static perturbation.location.PerturbationLocation __L101;

    public static perturbation.location.PerturbationLocation __L102;

    public static perturbation.location.PerturbationLocation __L103;

    public static perturbation.location.PerturbationLocation __L104;

    public static perturbation.location.PerturbationLocation __L105;

    public static perturbation.location.PerturbationLocation __L106;

    public static perturbation.location.PerturbationLocation __L107;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L81 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:74)", 81, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L82 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:74)", 82, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L83 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:81)", 83, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L84 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:82)", 84, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L85 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 85, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L86 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 86, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L87 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 87, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L88 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 88, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L89 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 89, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L90 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 90, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L91 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 91, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L92 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:83)", 92, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L93 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:84)", 93, "Numerical");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L94 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:89)", 94, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L95 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:90)", 95, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L96 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:92)", 96, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L97 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:93)", 97, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L98 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:95)", 98, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L99 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:95)", 99, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:96)", 100, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:100)", 101, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:101)", 102, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:102)", 103, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:104)", 104, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:104)", 105, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:105)", 106, "Boolean");
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.__L107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTOType.java:107)", 107, "Boolean");
    }

    static {
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType.initPerturbationLocation0();
    }
}

