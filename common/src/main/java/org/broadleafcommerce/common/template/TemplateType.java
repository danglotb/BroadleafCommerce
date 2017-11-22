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
package org.broadleafcommerce.common.template;


public class TemplateType implements java.io.Serializable , java.lang.Comparable<org.broadleafcommerce.common.template.TemplateType> , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.template.TemplateType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.template.TemplateType>();

    public static final org.broadleafcommerce.common.template.TemplateType PRODUCT = new org.broadleafcommerce.common.template.TemplateType("PRODUCT", "Product", 1000);

    public static final org.broadleafcommerce.common.template.TemplateType CATEGORY = new org.broadleafcommerce.common.template.TemplateType("CATEGORY", "Category", 2000);

    public static final org.broadleafcommerce.common.template.TemplateType PAGE = new org.broadleafcommerce.common.template.TemplateType("PAGE", "Page", 3000);

    public static final org.broadleafcommerce.common.template.TemplateType SKU = new org.broadleafcommerce.common.template.TemplateType("SKU", "Sku", 4000);

    public static final org.broadleafcommerce.common.template.TemplateType OTHER = new org.broadleafcommerce.common.template.TemplateType("OTHER", "Other", java.lang.Integer.MAX_VALUE);

    private java.lang.String type;

    private java.lang.String friendlyType;

    private int order;

    public static org.broadleafcommerce.common.template.TemplateType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.template.TemplateType.TYPES.get(type);
    }

    public TemplateType() {
    }

    public TemplateType(final java.lang.String type, final java.lang.String friendlyType, int order) {
        this.friendlyType = friendlyType;
        setType(type);
        setOrder(order);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5585, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5584, org.broadleafcommerce.common.template.TemplateType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.template.TemplateType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.template.TemplateType.getInstance(type).getClass().getName())));
        }
    }

    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5586, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5587, order);
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5588, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5589, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5597, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5592, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5590, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5591, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5596, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5593, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5594, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5595, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5598, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5599, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5600, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5601, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5602, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5604, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5603, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5605, false);

        org.broadleafcommerce.common.template.TemplateType other = ((org.broadleafcommerce.common.template.TemplateType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5606, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5607, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5608, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5610, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5609, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5611, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.template.TemplateType.__L5612, true);
    }

    @java.lang.Override
    public int compareTo(org.broadleafcommerce.common.template.TemplateType arg0) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5615, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5613, this.order)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.template.TemplateType.__L5614, arg0.order))));
    }

    public static perturbation.location.PerturbationLocation __L5584;

    public static perturbation.location.PerturbationLocation __L5585;

    public static perturbation.location.PerturbationLocation __L5586;

    public static perturbation.location.PerturbationLocation __L5587;

    public static perturbation.location.PerturbationLocation __L5588;

    public static perturbation.location.PerturbationLocation __L5589;

    public static perturbation.location.PerturbationLocation __L5590;

    public static perturbation.location.PerturbationLocation __L5591;

    public static perturbation.location.PerturbationLocation __L5592;

    public static perturbation.location.PerturbationLocation __L5593;

    public static perturbation.location.PerturbationLocation __L5594;

    public static perturbation.location.PerturbationLocation __L5595;

    public static perturbation.location.PerturbationLocation __L5596;

    public static perturbation.location.PerturbationLocation __L5597;

    public static perturbation.location.PerturbationLocation __L5598;

    public static perturbation.location.PerturbationLocation __L5599;

    public static perturbation.location.PerturbationLocation __L5600;

    public static perturbation.location.PerturbationLocation __L5601;

    public static perturbation.location.PerturbationLocation __L5602;

    public static perturbation.location.PerturbationLocation __L5603;

    public static perturbation.location.PerturbationLocation __L5604;

    public static perturbation.location.PerturbationLocation __L5605;

    public static perturbation.location.PerturbationLocation __L5606;

    public static perturbation.location.PerturbationLocation __L5607;

    public static perturbation.location.PerturbationLocation __L5608;

    public static perturbation.location.PerturbationLocation __L5609;

    public static perturbation.location.PerturbationLocation __L5610;

    public static perturbation.location.PerturbationLocation __L5611;

    public static perturbation.location.PerturbationLocation __L5612;

    public static perturbation.location.PerturbationLocation __L5613;

    public static perturbation.location.PerturbationLocation __L5614;

    public static perturbation.location.PerturbationLocation __L5615;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.template.TemplateType.__L5584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:71)", 5584, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:71)", 5585, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:79)", 5586, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:83)", 5587, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:88)", 5588, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:89)", 5589, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5590, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5591, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5592, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5593, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5594, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5595, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5596, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:90)", 5597, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:91)", 5598, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:96)", 5599, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:97)", 5600, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:98)", 5601, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:99)", 5602, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:100)", 5603, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:100)", 5604, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:101)", 5605, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:103)", 5606, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:104)", 5607, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:105)", 5608, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:106)", 5609, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:106)", 5610, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:107)", 5611, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:108)", 5612, "Boolean");
        org.broadleafcommerce.common.template.TemplateType.__L5613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:113)", 5613, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:113)", 5614, "Numerical");
        org.broadleafcommerce.common.template.TemplateType.__L5615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/template/TemplateType.java:113)", 5615, "Numerical");
    }

    static {
        org.broadleafcommerce.common.template.TemplateType.initPerturbationLocation0();
    }
}

