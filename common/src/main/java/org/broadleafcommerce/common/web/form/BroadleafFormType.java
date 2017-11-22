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
package org.broadleafcommerce.common.web.form;


public class BroadleafFormType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.web.form.BroadleafFormType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.web.form.BroadleafFormType>();

    public static final org.broadleafcommerce.common.web.form.BroadleafFormType BILLING_FORM = new org.broadleafcommerce.common.web.form.BroadleafFormType("BILLING_FORM", "Billing Form");

    public static final org.broadleafcommerce.common.web.form.BroadleafFormType SHIPPING_FORM = new org.broadleafcommerce.common.web.form.BroadleafFormType("SHIPPING_FORM", "Shipping Form");

    public static final org.broadleafcommerce.common.web.form.BroadleafFormType PAYMENT_FORM = new org.broadleafcommerce.common.web.form.BroadleafFormType("PAYMENT_FORM", "Payment Form");

    public static final org.broadleafcommerce.common.web.form.BroadleafFormType CUSTOMER_ADDRESS_FORM = new org.broadleafcommerce.common.web.form.BroadleafFormType("CUSTOMER_ADDRESS_FORM", "Customer Address Form");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.web.form.BroadleafFormType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.web.form.BroadleafFormType.TYPES.get(type);
    }

    public BroadleafFormType() {
    }

    public BroadleafFormType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7250, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7249, org.broadleafcommerce.common.web.form.BroadleafFormType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.web.form.BroadleafFormType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7251, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7252, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7260, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7255, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7253, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7254, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7259, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7256, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7257, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7258, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7261, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7262, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7263, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7264, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7265, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7267, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7266, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7268, false);

        org.broadleafcommerce.common.web.form.BroadleafFormType other = ((org.broadleafcommerce.common.web.form.BroadleafFormType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7269, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7270, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7271, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7273, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7272, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7274, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.form.BroadleafFormType.__L7275, true);
    }

    public static perturbation.location.PerturbationLocation __L7249;

    public static perturbation.location.PerturbationLocation __L7250;

    public static perturbation.location.PerturbationLocation __L7251;

    public static perturbation.location.PerturbationLocation __L7252;

    public static perturbation.location.PerturbationLocation __L7253;

    public static perturbation.location.PerturbationLocation __L7254;

    public static perturbation.location.PerturbationLocation __L7255;

    public static perturbation.location.PerturbationLocation __L7256;

    public static perturbation.location.PerturbationLocation __L7257;

    public static perturbation.location.PerturbationLocation __L7258;

    public static perturbation.location.PerturbationLocation __L7259;

    public static perturbation.location.PerturbationLocation __L7260;

    public static perturbation.location.PerturbationLocation __L7261;

    public static perturbation.location.PerturbationLocation __L7262;

    public static perturbation.location.PerturbationLocation __L7263;

    public static perturbation.location.PerturbationLocation __L7264;

    public static perturbation.location.PerturbationLocation __L7265;

    public static perturbation.location.PerturbationLocation __L7266;

    public static perturbation.location.PerturbationLocation __L7267;

    public static perturbation.location.PerturbationLocation __L7268;

    public static perturbation.location.PerturbationLocation __L7269;

    public static perturbation.location.PerturbationLocation __L7270;

    public static perturbation.location.PerturbationLocation __L7271;

    public static perturbation.location.PerturbationLocation __L7272;

    public static perturbation.location.PerturbationLocation __L7273;

    public static perturbation.location.PerturbationLocation __L7274;

    public static perturbation.location.PerturbationLocation __L7275;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:67)", 7249, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:67)", 7250, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:74)", 7251, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:75)", 7252, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7253, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7254, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7255, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7256, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7257, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7258, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7259, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:76)", 7260, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:77)", 7261, "Numerical");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:82)", 7262, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:83)", 7263, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:84)", 7264, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:85)", 7265, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:86)", 7266, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:86)", 7267, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:87)", 7268, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:89)", 7269, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:90)", 7270, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:91)", 7271, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:92)", 7272, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:92)", 7273, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:93)", 7274, "Boolean");
        org.broadleafcommerce.common.web.form.BroadleafFormType.__L7275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/form/BroadleafFormType.java:94)", 7275, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.form.BroadleafFormType.initPerturbationLocation0();
    }
}

