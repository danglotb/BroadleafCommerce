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


@org.springframework.stereotype.Component("blLocaleResolver")
public class BroadleafLocaleResolverImpl implements org.broadleafcommerce.common.web.BroadleafLocaleResolver {
    private final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.class);

    public static java.lang.String LOCALE_VAR = "blLocale";

    public static java.lang.String LOCALE_CODE_PARAM = "blLocaleCode";

    public static java.lang.String LOCALE_PULLED_FROM_SESSION = "blLocalePulledFromSession";

    @javax.annotation.Resource(name = "blLocaleService")
    private org.broadleafcommerce.common.locale.service.LocaleService localeService;

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale resolveLocale(javax.servlet.http.HttpServletRequest request) {
        return resolveLocale(new org.springframework.web.context.request.ServletWebRequest(request));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale resolveLocale(org.springframework.web.context.request.WebRequest request) {
        org.broadleafcommerce.common.locale.domain.Locale locale = null;
        locale = ((org.broadleafcommerce.common.locale.domain.Locale) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7731, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7734, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7732, (locale == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7733, ((org.broadleafcommerce.common.util.BLCRequestUtils.getURLorHeaderParameter(request, org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_CODE_PARAM)) != null)))))) {
            java.lang.String localeCode = org.broadleafcommerce.common.util.BLCRequestUtils.getURLorHeaderParameter(request, org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_CODE_PARAM);
            locale = localeService.findLocaleByCode(localeCode);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7735, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
                request.removeAttribute(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7736, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7737, LOG.isTraceEnabled())) {
                LOG.trace(((("Attempt to find locale by param " + localeCode) + " resulted in ") + locale));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7740, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7738, (locale == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7739, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request)))))) {
            locale = ((org.broadleafcommerce.common.locale.domain.Locale) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7741, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7742, LOG.isTraceEnabled())) {
                LOG.trace(("Attempt to find locale from session resulted in " + locale));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7743, (locale != null))) {
                request.setAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_PULLED_FROM_SESSION, java.lang.Boolean.TRUE, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7744, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7745, (locale == null))) {
            locale = localeService.findDefaultLocale();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7746, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
                request.removeAttribute(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7747, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7748, LOG.isTraceEnabled())) {
                LOG.trace(("Locale set to default locale " + locale));
            }
        }
        request.setAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_VAR, locale, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7749, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        java.util.Locale javaLocale = org.broadleafcommerce.common.web.BroadleafRequestContext.convertLocaleToJavaLocale(locale);
        request.setAttribute(org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME, javaLocale, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7750, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7751, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            request.setAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_VAR, locale, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7752, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
        }
        return locale;
    }

    public static perturbation.location.PerturbationLocation __L7731;

    public static perturbation.location.PerturbationLocation __L7732;

    public static perturbation.location.PerturbationLocation __L7733;

    public static perturbation.location.PerturbationLocation __L7734;

    public static perturbation.location.PerturbationLocation __L7735;

    public static perturbation.location.PerturbationLocation __L7736;

    public static perturbation.location.PerturbationLocation __L7737;

    public static perturbation.location.PerturbationLocation __L7738;

    public static perturbation.location.PerturbationLocation __L7739;

    public static perturbation.location.PerturbationLocation __L7740;

    public static perturbation.location.PerturbationLocation __L7741;

    public static perturbation.location.PerturbationLocation __L7742;

    public static perturbation.location.PerturbationLocation __L7743;

    public static perturbation.location.PerturbationLocation __L7744;

    public static perturbation.location.PerturbationLocation __L7745;

    public static perturbation.location.PerturbationLocation __L7746;

    public static perturbation.location.PerturbationLocation __L7747;

    public static perturbation.location.PerturbationLocation __L7748;

    public static perturbation.location.PerturbationLocation __L7749;

    public static perturbation.location.PerturbationLocation __L7750;

    public static perturbation.location.PerturbationLocation __L7751;

    public static perturbation.location.PerturbationLocation __L7752;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:71)", 7731, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:74)", 7732, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:74)", 7733, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:74)", 7734, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:77)", 7735, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:78)", 7736, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:80)", 7737, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:86)", 7738, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:86)", 7739, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:86)", 7740, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:87)", 7741, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:88)", 7742, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:92)", 7743, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:93)", 7744, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:99)", 7745, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:101)", 7746, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:102)", 7747, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:104)", 7748, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:110)", 7749, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:112)", 7750, "Numerical");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:114)", 7751, "Boolean");
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.__L7752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafLocaleResolverImpl.java:115)", 7752, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.initPerturbationLocation0();
    }
}

