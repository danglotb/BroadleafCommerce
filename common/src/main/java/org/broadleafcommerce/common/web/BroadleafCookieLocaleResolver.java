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


public class BroadleafCookieLocaleResolver extends org.springframework.web.servlet.i18n.CookieLocaleResolver {
    @javax.annotation.Resource(name = "blLocaleService")
    private org.broadleafcommerce.common.locale.service.LocaleService localeService;

    @java.lang.Override
    protected java.util.Locale determineDefaultLocale(javax.servlet.http.HttpServletRequest request) {
        java.util.Locale defaultLocale = getDefaultLocale();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.__L7714, (defaultLocale == null))) {
            org.broadleafcommerce.common.locale.domain.Locale defaultBroadleafLocale = localeService.findDefaultLocale();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.__L7715, (defaultBroadleafLocale == null))) {
                return super.determineDefaultLocale(request);
            }else {
                return org.broadleafcommerce.common.web.BroadleafRequestContext.convertLocaleToJavaLocale(defaultBroadleafLocale);
            }
        }
        return defaultLocale;
    }

    public static perturbation.location.PerturbationLocation __L7714;

    public static perturbation.location.PerturbationLocation __L7715;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.__L7714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCookieLocaleResolver.java:43)", 7714, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.__L7715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCookieLocaleResolver.java:45)", 7715, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.initPerturbationLocation0();
    }
}

