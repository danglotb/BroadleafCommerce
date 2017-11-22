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
package org.broadleafcommerce.common.i18n.domain;


public class TranslatedEntity implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.TranslatedEntity> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.i18n.domain.TranslatedEntity>();

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity PRODUCT = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.Product", "Product");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity SKU = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.Sku", "Sku");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity CATEGORY = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.Category", "Category");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity PRODUCT_OPTION = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.ProductOption", "ProdOption");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity PRODUCT_OPTION_VALUE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.ProductOptionValue", "ProdOptionVal");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity SITE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.common.site.domain.Site", "Site");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity STATIC_ASSET = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.cms.file.domain.StaticAsset", "StaticAsset");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity SEARCH_FACET = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.search.domain.SearchFacet", "SearchFacet");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity FULFILLMENT_OPTION = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.order.domain.FulfillmentOption", "FulfillmentOption");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity OFFER = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.offer.domain.Offer", "Offer");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity CHALLENGE_QUESTION = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.profile.core.domain.ChallengeQuestion", "ChallengeQuestion");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity SKU_ATTRIBUTE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.SkuAttribute", "SkuAttribute");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity PRODUCT_ATTRIBUTE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.ProductAttribute", "ProductAttribute");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity CATEGORY_ATTRIBUTE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.catalog.domain.CategoryAttribute", "CategoryAttribute");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity CUSTOMER_ATTRIBUTE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.profile.core.domain.CustomerAttribute", "CustomerAttribute");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity PAGE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.cms.page.domain.Page", "Page");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity PAGE_TEMPLATE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.cms.page.domain.PageTemplate", "PageTemplate");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity STRUCTURED_CONTENT_TYPE = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.cms.structure.domain.StructuredContentType", "StructuredContentType");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity COUNTRY = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.profile.core.domain.Country", "Country");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity COUNTRY_SUBDIVISION = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.profile.core.domain.CountrySubdivision", "CountrySubdivision");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity COUNTRY_SUBDIVISION_CATEGORY = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.profile.core.domain.CountrySubdivisionCategory", "CountrySubdivisionCategory");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity CATALOG = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.common.site.domain.Catalog", "Catalog");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity STRUCTURED_CONTENT = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.cms.structure.domain.StructuredContent", "StructuredContent");

    public static final org.broadleafcommerce.common.i18n.domain.TranslatedEntity FIELD = new org.broadleafcommerce.common.i18n.domain.TranslatedEntity("org.broadleafcommerce.core.search.domain.Field", "Field");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.i18n.domain.TranslatedEntity getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.i18n.domain.TranslatedEntity.TYPES.get(type);
    }

    public static org.broadleafcommerce.common.i18n.domain.TranslatedEntity getInstanceFromFriendlyType(final java.lang.String friendlyType) {
        for (java.util.Map.Entry<java.lang.String, org.broadleafcommerce.common.i18n.domain.TranslatedEntity> entry : org.broadleafcommerce.common.i18n.domain.TranslatedEntity.TYPES.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2871, entry.getValue().getFriendlyType().equals(friendlyType))) {
                return entry.getValue();
            }
        }
        return null;
    }

    public TranslatedEntity() {
    }

    public TranslatedEntity(final java.lang.String type, final java.lang.String friendlyType) {
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

    public static java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.TranslatedEntity> getTypes() {
        return org.broadleafcommerce.common.i18n.domain.TranslatedEntity.TYPES;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2873, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2872, org.broadleafcommerce.common.i18n.domain.TranslatedEntity.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.i18n.domain.TranslatedEntity.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2874, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2875, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2883, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2878, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2876, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2877, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2882, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2879, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2880, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2881, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2884, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2885, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2886, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2887, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2888, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2890, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2889, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2891, false);

        org.broadleafcommerce.common.i18n.domain.TranslatedEntity other = ((org.broadleafcommerce.common.i18n.domain.TranslatedEntity) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2892, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2893, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2894, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2896, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2895, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2897, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2898, true);
    }

    public static perturbation.location.PerturbationLocation __L2871;

    public static perturbation.location.PerturbationLocation __L2872;

    public static perturbation.location.PerturbationLocation __L2873;

    public static perturbation.location.PerturbationLocation __L2874;

    public static perturbation.location.PerturbationLocation __L2875;

    public static perturbation.location.PerturbationLocation __L2876;

    public static perturbation.location.PerturbationLocation __L2877;

    public static perturbation.location.PerturbationLocation __L2878;

    public static perturbation.location.PerturbationLocation __L2879;

    public static perturbation.location.PerturbationLocation __L2880;

    public static perturbation.location.PerturbationLocation __L2881;

    public static perturbation.location.PerturbationLocation __L2882;

    public static perturbation.location.PerturbationLocation __L2883;

    public static perturbation.location.PerturbationLocation __L2884;

    public static perturbation.location.PerturbationLocation __L2885;

    public static perturbation.location.PerturbationLocation __L2886;

    public static perturbation.location.PerturbationLocation __L2887;

    public static perturbation.location.PerturbationLocation __L2888;

    public static perturbation.location.PerturbationLocation __L2889;

    public static perturbation.location.PerturbationLocation __L2890;

    public static perturbation.location.PerturbationLocation __L2891;

    public static perturbation.location.PerturbationLocation __L2892;

    public static perturbation.location.PerturbationLocation __L2893;

    public static perturbation.location.PerturbationLocation __L2894;

    public static perturbation.location.PerturbationLocation __L2895;

    public static perturbation.location.PerturbationLocation __L2896;

    public static perturbation.location.PerturbationLocation __L2897;

    public static perturbation.location.PerturbationLocation __L2898;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:71)", 2871, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:107)", 2872, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:107)", 2873, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:114)", 2874, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:115)", 2875, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2876, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2877, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2878, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2879, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2880, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2881, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2882, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:116)", 2883, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:117)", 2884, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:122)", 2885, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:123)", 2886, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:124)", 2887, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:125)", 2888, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:126)", 2889, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:126)", 2890, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:127)", 2891, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:129)", 2892, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:130)", 2893, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:131)", 2894, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:132)", 2895, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:132)", 2896, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:133)", 2897, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.__L2898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslatedEntity.java:134)", 2898, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity.initPerturbationLocation0();
    }
}

