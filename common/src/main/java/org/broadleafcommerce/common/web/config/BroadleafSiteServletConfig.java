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
package org.broadleafcommerce.common.web.config;


@org.springframework.context.annotation.Configuration
@org.broadleafcommerce.common.admin.condition.ConditionalOnNotAdmin
public class BroadleafSiteServletConfig extends org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter {
    @java.lang.Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        org.springframework.web.servlet.i18n.LocaleChangeInterceptor localeInterceptor = new org.springframework.web.servlet.i18n.LocaleChangeInterceptor();
        localeInterceptor.setParamName("blLocaleCode");
        registry.addInterceptor(localeInterceptor);
    }

    @org.springframework.context.annotation.Bean
    public org.springframework.web.servlet.LocaleResolver localeResolver() {
        org.springframework.web.servlet.i18n.CookieLocaleResolver resolver = new org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver();
        resolver.setCookieHttpOnly(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig.__L7054, true));
        resolver.setDefaultLocale(java.util.Locale.ENGLISH);
        return resolver;
    }

    public static perturbation.location.PerturbationLocation __L7054;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig.__L7054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/config/BroadleafSiteServletConfig.java:51)", 7054, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig.initPerturbationLocation0();
    }
}

