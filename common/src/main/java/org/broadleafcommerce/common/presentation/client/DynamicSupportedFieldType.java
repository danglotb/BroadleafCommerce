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
package org.broadleafcommerce.common.presentation.client;


public class DynamicSupportedFieldType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType>();

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType STRING = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("STRING", "String");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType HTML = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("HTML", "Rich Text");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType MONEY = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("MONEY", "Money");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType COLOR = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("COLOR", "Color");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType ASSET_LOOKUP = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("ASSET_LOOKUP", "Image");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType PRODUCT_LOOKUP = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product", "Product Lookup");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType CATEGORY_LOOKUP = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Category", "Category Lookup");

    public static final org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType DATE = new org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType("DATE", "Date");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.TYPES.get(type);
    }

    public DynamicSupportedFieldType() {
    }

    public DynamicSupportedFieldType(final java.lang.String type, final java.lang.String friendlyType) {
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.verifyLegalType(type);
        this.friendlyType = friendlyType;
        setType(type);
    }

    public static void verifyLegalType(java.lang.String type) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4485, type.contains("|"))) {
            type = type.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4486, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4487, type.indexOf('|')));
        }
        org.broadleafcommerce.common.presentation.client.SupportedFieldType.valueOf(type);
    }

    public static java.util.List<org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType> getTypes() {
        java.util.List<org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType> list = new java.util.ArrayList<org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType>(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4488, org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.TYPES.size()));
        for (java.util.Map.Entry<java.lang.String, org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType> entry : org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.TYPES.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4490, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4489, org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4491, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4492, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4500, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4495, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4493, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4494, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4499, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4496, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4497, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4498, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4501, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4502, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4503, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4504, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4505, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4507, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4506, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4508, false);

        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType other = ((org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4509, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4510, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4511, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4513, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4512, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4514, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4515, true);
    }

    public static perturbation.location.PerturbationLocation __L4485;

    public static perturbation.location.PerturbationLocation __L4486;

    public static perturbation.location.PerturbationLocation __L4487;

    public static perturbation.location.PerturbationLocation __L4488;

    public static perturbation.location.PerturbationLocation __L4489;

    public static perturbation.location.PerturbationLocation __L4490;

    public static perturbation.location.PerturbationLocation __L4491;

    public static perturbation.location.PerturbationLocation __L4492;

    public static perturbation.location.PerturbationLocation __L4493;

    public static perturbation.location.PerturbationLocation __L4494;

    public static perturbation.location.PerturbationLocation __L4495;

    public static perturbation.location.PerturbationLocation __L4496;

    public static perturbation.location.PerturbationLocation __L4497;

    public static perturbation.location.PerturbationLocation __L4498;

    public static perturbation.location.PerturbationLocation __L4499;

    public static perturbation.location.PerturbationLocation __L4500;

    public static perturbation.location.PerturbationLocation __L4501;

    public static perturbation.location.PerturbationLocation __L4502;

    public static perturbation.location.PerturbationLocation __L4503;

    public static perturbation.location.PerturbationLocation __L4504;

    public static perturbation.location.PerturbationLocation __L4505;

    public static perturbation.location.PerturbationLocation __L4506;

    public static perturbation.location.PerturbationLocation __L4507;

    public static perturbation.location.PerturbationLocation __L4508;

    public static perturbation.location.PerturbationLocation __L4509;

    public static perturbation.location.PerturbationLocation __L4510;

    public static perturbation.location.PerturbationLocation __L4511;

    public static perturbation.location.PerturbationLocation __L4512;

    public static perturbation.location.PerturbationLocation __L4513;

    public static perturbation.location.PerturbationLocation __L4514;

    public static perturbation.location.PerturbationLocation __L4515;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:73)", 4485, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:74)", 4486, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:74)", 4487, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:83)", 4488, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:100)", 4489, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:100)", 4490, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:109)", 4491, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:110)", 4492, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4493, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4494, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4495, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4496, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4497, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4498, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4499, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:111)", 4500, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:112)", 4501, "Numerical");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:117)", 4502, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:118)", 4503, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:119)", 4504, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:120)", 4505, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:121)", 4506, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:121)", 4507, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:122)", 4508, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:124)", 4509, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:125)", 4510, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:126)", 4511, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:127)", 4512, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:127)", 4513, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:128)", 4514, "Boolean");
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.__L4515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/presentation/client/DynamicSupportedFieldType.java:129)", 4515, "Boolean");
    }

    static {
        org.broadleafcommerce.common.presentation.client.DynamicSupportedFieldType.initPerturbationLocation0();
    }
}

