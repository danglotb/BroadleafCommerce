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
package org.broadleafcommerce.common.config.service.type;


public class ModuleConfigurationType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.config.service.type.ModuleConfigurationType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.config.service.type.ModuleConfigurationType>();

    public static final org.broadleafcommerce.common.config.service.type.ModuleConfigurationType FULFILLMENT_PRICING = new org.broadleafcommerce.common.config.service.type.ModuleConfigurationType("FULFILLMENT_PRICING", "Fulfillment Pricing Module");

    public static final org.broadleafcommerce.common.config.service.type.ModuleConfigurationType TAX_CALCULATION = new org.broadleafcommerce.common.config.service.type.ModuleConfigurationType("TAX_CALCULATION", "Tax Calculation Module");

    public static final org.broadleafcommerce.common.config.service.type.ModuleConfigurationType ADDRESS_VERIFICATION = new org.broadleafcommerce.common.config.service.type.ModuleConfigurationType("ADDRESS_VERIFICATION", "Address Verification Module");

    public static final org.broadleafcommerce.common.config.service.type.ModuleConfigurationType PAYMENT_PROCESSOR = new org.broadleafcommerce.common.config.service.type.ModuleConfigurationType("PAYMENT_PROCESSOR", "Payment Processor Module");

    public static final org.broadleafcommerce.common.config.service.type.ModuleConfigurationType CDN_PROVIDER = new org.broadleafcommerce.common.config.service.type.ModuleConfigurationType("CDN_PROVIDER", "Content Delivery Network Module");

    public static final org.broadleafcommerce.common.config.service.type.ModuleConfigurationType SITE_MAP = new org.broadleafcommerce.common.config.service.type.ModuleConfigurationType("SITE_MAP", "Site Map Generator");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.config.service.type.ModuleConfigurationType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.TYPES.get(type);
    }

    public ModuleConfigurationType() {
    }

    public ModuleConfigurationType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L357, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L356, org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L358, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L359, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L367, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L362, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L360, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L361, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L366, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L363, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L364, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L365, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L368, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L369, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L370, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L371, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L372, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L374, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L373, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L375, false);

        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType other = ((org.broadleafcommerce.common.config.service.type.ModuleConfigurationType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L376, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L377, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L378, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L380, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L379, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L381, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L382, true);
    }

    public static perturbation.location.PerturbationLocation __L356;

    public static perturbation.location.PerturbationLocation __L357;

    public static perturbation.location.PerturbationLocation __L358;

    public static perturbation.location.PerturbationLocation __L359;

    public static perturbation.location.PerturbationLocation __L360;

    public static perturbation.location.PerturbationLocation __L361;

    public static perturbation.location.PerturbationLocation __L362;

    public static perturbation.location.PerturbationLocation __L363;

    public static perturbation.location.PerturbationLocation __L364;

    public static perturbation.location.PerturbationLocation __L365;

    public static perturbation.location.PerturbationLocation __L366;

    public static perturbation.location.PerturbationLocation __L367;

    public static perturbation.location.PerturbationLocation __L368;

    public static perturbation.location.PerturbationLocation __L369;

    public static perturbation.location.PerturbationLocation __L370;

    public static perturbation.location.PerturbationLocation __L371;

    public static perturbation.location.PerturbationLocation __L372;

    public static perturbation.location.PerturbationLocation __L373;

    public static perturbation.location.PerturbationLocation __L374;

    public static perturbation.location.PerturbationLocation __L375;

    public static perturbation.location.PerturbationLocation __L376;

    public static perturbation.location.PerturbationLocation __L377;

    public static perturbation.location.PerturbationLocation __L378;

    public static perturbation.location.PerturbationLocation __L379;

    public static perturbation.location.PerturbationLocation __L380;

    public static perturbation.location.PerturbationLocation __L381;

    public static perturbation.location.PerturbationLocation __L382;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:68)", 356, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:68)", 357, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:75)", 358, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:76)", 359, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 360, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 361, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 362, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 363, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 364, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 365, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 366, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:77)", 367, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:78)", 368, "Numerical");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:83)", 369, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:84)", 370, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:85)", 371, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:86)", 372, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:87)", 373, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:87)", 374, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:88)", 375, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:90)", 376, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:91)", 377, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:92)", 378, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:93)", 379, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:93)", 380, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:94)", 381, "Boolean");
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.__L382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/type/ModuleConfigurationType.java:95)", 382, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.initPerturbationLocation0();
    }
}

