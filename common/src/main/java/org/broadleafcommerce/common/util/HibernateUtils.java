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


public class HibernateUtils {
    public static <T> T deproxy(T t) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.HibernateUtils.__L6356, (t instanceof org.hibernate.proxy.HibernateProxy))) {
            org.hibernate.proxy.HibernateProxy proxy = ((org.hibernate.proxy.HibernateProxy) (t));
            org.hibernate.proxy.LazyInitializer lazyInitializer = proxy.getHibernateLazyInitializer();
            return ((T) (lazyInitializer.getImplementation()));
        }
        return t;
    }

    public static perturbation.location.PerturbationLocation __L6356;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.HibernateUtils.__L6356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/HibernateUtils.java:38)", 6356, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.HibernateUtils.initPerturbationLocation0();
    }
}

