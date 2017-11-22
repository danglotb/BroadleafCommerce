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


public class NullBroadleafSiteResolver implements org.broadleafcommerce.common.web.BroadleafSiteResolver {
    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site resolveSite(javax.servlet.http.HttpServletRequest request) {
        return resolveSite(new org.springframework.web.context.request.ServletWebRequest(request));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site resolveSite(org.springframework.web.context.request.WebRequest request) {
        return resolveSite(request, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.NullBroadleafSiteResolver.__L8008, false));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site resolveSite(org.springframework.web.context.request.WebRequest request, boolean allowNullSite) throws org.broadleafcommerce.common.exception.SiteNotFoundException {
        return null;
    }

    public static perturbation.location.PerturbationLocation __L8008;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.NullBroadleafSiteResolver.__L8008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/NullBroadleafSiteResolver.java:42)", 8008, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.NullBroadleafSiteResolver.initPerturbationLocation0();
    }
}

