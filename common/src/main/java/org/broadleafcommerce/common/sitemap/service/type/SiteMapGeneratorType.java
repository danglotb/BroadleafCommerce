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


public class SiteMapGeneratorType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType>();

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType CATEGORY = new org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType("CATEGORY", "Category");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType PRODUCT = new org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType("PRODUCT", "Product");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType SKU = new org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType("SKU", "Sku");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType PAGE = new org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType("PAGE", "Page");

    public static final org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType CUSTOM = new org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType("CUSTOM", "Custom");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.TYPES.get(type);
    }

    public SiteMapGeneratorType() {
    }

    public SiteMapGeneratorType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5435, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5434, org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5436, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5437, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5445, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5440, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5438, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5439, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5444, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5441, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5442, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5443, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5446, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5447, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5448, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5449, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5450, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5452, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5451, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5453, false);

        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType other = ((org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5454, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5455, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5456, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5458, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5457, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5459, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5460, true);
    }

    public static perturbation.location.PerturbationLocation __L5434;

    public static perturbation.location.PerturbationLocation __L5435;

    public static perturbation.location.PerturbationLocation __L5436;

    public static perturbation.location.PerturbationLocation __L5437;

    public static perturbation.location.PerturbationLocation __L5438;

    public static perturbation.location.PerturbationLocation __L5439;

    public static perturbation.location.PerturbationLocation __L5440;

    public static perturbation.location.PerturbationLocation __L5441;

    public static perturbation.location.PerturbationLocation __L5442;

    public static perturbation.location.PerturbationLocation __L5443;

    public static perturbation.location.PerturbationLocation __L5444;

    public static perturbation.location.PerturbationLocation __L5445;

    public static perturbation.location.PerturbationLocation __L5446;

    public static perturbation.location.PerturbationLocation __L5447;

    public static perturbation.location.PerturbationLocation __L5448;

    public static perturbation.location.PerturbationLocation __L5449;

    public static perturbation.location.PerturbationLocation __L5450;

    public static perturbation.location.PerturbationLocation __L5451;

    public static perturbation.location.PerturbationLocation __L5452;

    public static perturbation.location.PerturbationLocation __L5453;

    public static perturbation.location.PerturbationLocation __L5454;

    public static perturbation.location.PerturbationLocation __L5455;

    public static perturbation.location.PerturbationLocation __L5456;

    public static perturbation.location.PerturbationLocation __L5457;

    public static perturbation.location.PerturbationLocation __L5458;

    public static perturbation.location.PerturbationLocation __L5459;

    public static perturbation.location.PerturbationLocation __L5460;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:77)", 5434, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:77)", 5435, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:84)", 5436, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:85)", 5437, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5438, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5439, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5440, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5441, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5442, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5443, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5444, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:86)", 5445, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:87)", 5446, "Numerical");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:92)", 5447, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:93)", 5448, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:94)", 5449, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:95)", 5450, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:96)", 5451, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:96)", 5452, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:97)", 5453, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:99)", 5454, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:100)", 5455, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:101)", 5456, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:102)", 5457, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:102)", 5458, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:103)", 5459, "Boolean");
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.__L5460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/type/SiteMapGeneratorType.java:104)", 5460, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.initPerturbationLocation0();
    }
}

