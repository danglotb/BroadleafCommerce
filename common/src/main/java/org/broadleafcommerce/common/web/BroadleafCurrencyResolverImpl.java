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


@org.springframework.stereotype.Component("blCurrencyResolver")
public class BroadleafCurrencyResolverImpl implements org.broadleafcommerce.common.web.BroadleafCurrencyResolver {
    private final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.class);

    public static java.lang.String CURRENCY_CODE_PARAM = "blCurrencyCode";

    public static java.lang.String CURRENCY_VAR = "blCurrency";

    @javax.annotation.Resource(name = "blCurrencyService")
    private org.broadleafcommerce.common.currency.service.BroadleafCurrencyService broadleafCurrencyService;

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto resolveCurrency(javax.servlet.http.HttpServletRequest request) {
        return resolveCurrency(new org.springframework.web.context.request.ServletWebRequest(request));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto resolveCurrency(org.springframework.web.context.request.WebRequest request) {
        org.broadleafcommerce.common.currency.domain.BroadleafCurrency desiredCurrency = null;
        desiredCurrency = ((org.broadleafcommerce.common.currency.domain.BroadleafCurrency) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7716, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7719, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7717, (desiredCurrency == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7718, ((org.broadleafcommerce.common.util.BLCRequestUtils.getURLorHeaderParameter(request, org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_CODE_PARAM)) != null)))))) {
            java.lang.String currencyCode = org.broadleafcommerce.common.util.BLCRequestUtils.getURLorHeaderParameter(request, org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_CODE_PARAM);
            desiredCurrency = broadleafCurrencyService.findCurrencyByCode(currencyCode);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7720, LOG.isTraceEnabled())) {
                LOG.trace(((("Attempt to find currency by param " + currencyCode) + " resulted in ") + desiredCurrency));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7723, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7721, (desiredCurrency == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7722, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request)))))) {
            desiredCurrency = ((org.broadleafcommerce.common.currency.domain.BroadleafCurrency) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7724, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7725, (desiredCurrency == null))) {
            org.broadleafcommerce.common.locale.domain.Locale locale = ((org.broadleafcommerce.common.locale.domain.Locale) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7726, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7727, (locale != null))) {
                desiredCurrency = locale.getDefaultCurrency();
            }
        }
        org.broadleafcommerce.common.currency.domain.BroadleafCurrency defaultCurrency = broadleafCurrencyService.findDefaultBroadleafCurrency();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7728, (desiredCurrency == null))) {
            desiredCurrency = defaultCurrency;
        }
        org.broadleafcommerce.common.currency.domain.BroadleafCurrency currencyToUse = defaultCurrency;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7729, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            request.setAttribute(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_VAR, currencyToUse, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7730, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
        }
        org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto dto = new org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto(currencyToUse, desiredCurrency);
        return dto;
    }

    public static perturbation.location.PerturbationLocation __L7716;

    public static perturbation.location.PerturbationLocation __L7717;

    public static perturbation.location.PerturbationLocation __L7718;

    public static perturbation.location.PerturbationLocation __L7719;

    public static perturbation.location.PerturbationLocation __L7720;

    public static perturbation.location.PerturbationLocation __L7721;

    public static perturbation.location.PerturbationLocation __L7722;

    public static perturbation.location.PerturbationLocation __L7723;

    public static perturbation.location.PerturbationLocation __L7724;

    public static perturbation.location.PerturbationLocation __L7725;

    public static perturbation.location.PerturbationLocation __L7726;

    public static perturbation.location.PerturbationLocation __L7727;

    public static perturbation.location.PerturbationLocation __L7728;

    public static perturbation.location.PerturbationLocation __L7729;

    public static perturbation.location.PerturbationLocation __L7730;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:73)", 7716, "Numerical");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:76)", 7717, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:76)", 7718, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:76)", 7719, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:79)", 7720, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:85)", 7721, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:85)", 7722, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:85)", 7723, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:86)", 7724, "Numerical");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:90)", 7725, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:91)", 7726, "Numerical");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:92)", 7727, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:99)", 7728, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:107)", 7729, "Boolean");
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.__L7730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafCurrencyResolverImpl.java:108)", 7730, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.initPerturbationLocation0();
    }
}

