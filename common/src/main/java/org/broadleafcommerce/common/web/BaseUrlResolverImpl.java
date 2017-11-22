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
package org.broadleafcommerce.common.web;


public class BaseUrlResolverImpl implements org.broadleafcommerce.common.web.BaseUrlResolver {
    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.core.env.Environment env;

    @java.lang.Override
    public java.lang.String getSiteBaseUrl() {
        java.lang.String baseUrl = env.getProperty("site.baseurl");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7701, ((baseUrl.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7700, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7698, baseUrl.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7699, 1)))))) == '/'))) {
            return baseUrl.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7702, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7705, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7703, baseUrl.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7704, 1)))));
        }
        return baseUrl;
    }

    @java.lang.Override
    public java.lang.String getAdminBaseUrl() {
        java.lang.String baseUrl = env.getProperty("admin.baseurl");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7709, ((baseUrl.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7708, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7706, baseUrl.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7707, 1)))))) == '/'))) {
            return baseUrl.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7710, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7713, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7711, baseUrl.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7712, 1)))));
        }
        return baseUrl;
    }

    public static perturbation.location.PerturbationLocation __L7698;

    public static perturbation.location.PerturbationLocation __L7699;

    public static perturbation.location.PerturbationLocation __L7700;

    public static perturbation.location.PerturbationLocation __L7701;

    public static perturbation.location.PerturbationLocation __L7702;

    public static perturbation.location.PerturbationLocation __L7703;

    public static perturbation.location.PerturbationLocation __L7704;

    public static perturbation.location.PerturbationLocation __L7705;

    public static perturbation.location.PerturbationLocation __L7706;

    public static perturbation.location.PerturbationLocation __L7707;

    public static perturbation.location.PerturbationLocation __L7708;

    public static perturbation.location.PerturbationLocation __L7709;

    public static perturbation.location.PerturbationLocation __L7710;

    public static perturbation.location.PerturbationLocation __L7711;

    public static perturbation.location.PerturbationLocation __L7712;

    public static perturbation.location.PerturbationLocation __L7713;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:33)", 7698, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:33)", 7699, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:33)", 7700, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:33)", 7701, "Boolean");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:34)", 7702, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:34)", 7703, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:34)", 7704, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:34)", 7705, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:42)", 7706, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:42)", 7707, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:42)", 7708, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:42)", 7709, "Boolean");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:43)", 7710, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:43)", 7711, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:43)", 7712, "Numerical");
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.__L7713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BaseUrlResolverImpl.java:43)", 7713, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BaseUrlResolverImpl.initPerturbationLocation0();
    }
}

