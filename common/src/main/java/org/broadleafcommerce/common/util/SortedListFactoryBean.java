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
package org.broadleafcommerce.common.util;


public class SortedListFactoryBean extends org.springframework.beans.factory.config.ListFactoryBean {
    @java.lang.Override
    protected java.util.List createInstance() {
        java.util.List response = super.createInstance();
        java.util.Collections.sort(response, new java.util.Comparator<org.springframework.core.Ordered>() {
            @java.lang.Override
            public int compare(org.springframework.core.Ordered o1, org.springframework.core.Ordered o2) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.SortedListFactoryBean.__L6506, new java.lang.Integer(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.SortedListFactoryBean.__L6504, o1.getOrder())).compareTo(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.SortedListFactoryBean.__L6505, o2.getOrder())));
            }
        });
        return response;
    }

    public static perturbation.location.PerturbationLocation __L6504;

    public static perturbation.location.PerturbationLocation __L6505;

    public static perturbation.location.PerturbationLocation __L6506;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.SortedListFactoryBean.__L6504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/SortedListFactoryBean.java:38)", 6504, "Numerical");
        org.broadleafcommerce.common.util.SortedListFactoryBean.__L6505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/SortedListFactoryBean.java:38)", 6505, "Numerical");
        org.broadleafcommerce.common.util.SortedListFactoryBean.__L6506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/SortedListFactoryBean.java:38)", 6506, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.SortedListFactoryBean.initPerturbationLocation0();
    }
}

