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


@org.springframework.stereotype.Component("blRequestProcessor")
public class BroadleafRequestProcessor extends org.broadleafcommerce.common.web.AbstractBroadleafWebRequestProcessor {
    protected final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(getClass());

    private static java.lang.String REQUEST_DTO_PARAM_NAME = org.broadleafcommerce.common.web.BroadleafRequestFilter.REQUEST_DTO_PARAM_NAME;

    public static java.lang.String REPROCESS_PARAM_NAME = "REPROCESS_BLC_REQUEST";

    private static final java.lang.String SITE_STRICT_VALIDATE_PRODUCTION_CHANGES_KEY = "site.strict.validate.production.changes";

    public static final java.lang.String SITE_DISABLE_SANDBOX_PREVIEW = "site.disable.sandbox.preview";

    private static final java.lang.String SANDBOX_ID_PARAM = "blSandboxId";

    @javax.annotation.Resource(name = "blSiteResolver")
    protected org.broadleafcommerce.common.web.BroadleafSiteResolver siteResolver;

    @javax.annotation.Resource(name = "blLocaleResolver")
    protected org.broadleafcommerce.common.web.BroadleafLocaleResolver localeResolver;

    @javax.annotation.Resource(name = "blCurrencyResolver")
    protected org.broadleafcommerce.common.web.BroadleafCurrencyResolver currencyResolver;

    @javax.annotation.Resource(name = "blSandBoxResolver")
    protected org.broadleafcommerce.common.web.BroadleafSandBoxResolver sandboxResolver;

    @javax.annotation.Resource(name = "blThemeResolver")
    protected org.broadleafcommerce.common.web.BroadleafThemeResolver themeResolver;

    @javax.annotation.Resource(name = "messageSource")
    protected org.springframework.context.MessageSource messageSource;

    @javax.annotation.Resource(name = "blTimeZoneResolver")
    protected org.broadleafcommerce.common.web.BroadleafTimeZoneResolver broadleafTimeZoneResolver;

    @javax.annotation.Resource(name = "blBaseUrlResolver")
    protected org.broadleafcommerce.common.web.BaseUrlResolver baseUrlResolver;

    @javax.annotation.Resource(name = "blSandBoxService")
    protected org.broadleafcommerce.common.sandbox.service.SandBoxService sandBoxService;

    @org.springframework.beans.factory.annotation.Value("${thymeleaf.threadLocalCleanup.enabled}")
    protected boolean thymeleafThreadLocalCleanupEnabled = true;

    @org.springframework.beans.factory.annotation.Value(("${" + (org.broadleafcommerce.common.web.BroadleafRequestProcessor.SITE_STRICT_VALIDATE_PRODUCTION_CHANGES_KEY)) + ":false}")
    protected boolean siteStrictValidateProductionChanges = false;

    @org.springframework.beans.factory.annotation.Value(("${" + (org.broadleafcommerce.common.web.BroadleafRequestProcessor.SITE_DISABLE_SANDBOX_PREVIEW)) + ":false}")
    protected boolean siteDisableSandboxPreview = false;

    @javax.annotation.Resource(name = "blDeployBehaviorUtil")
    protected org.broadleafcommerce.common.util.DeployBehaviorUtil deployBehaviorUtil;

    @javax.annotation.Resource(name = "blEntityExtensionManagers")
    protected java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.ExtensionManager> entityExtensionManagers;

    @java.lang.Override
    public void process(org.springframework.web.context.request.WebRequest request) {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = new org.broadleafcommerce.common.web.BroadleafRequestContext();
        brc.getAdditionalProperties().putAll(entityExtensionManagers);
        org.broadleafcommerce.common.site.domain.Site site = siteResolver.resolveSite(request);
        brc.setNonPersistentSite(site);
        brc.setWebRequest(request);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7879, (site == null))) {
            brc.setIgnoreSite(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7880, true));
        }
        brc.setAdmin(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7881, false));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7882, siteStrictValidateProductionChanges)) {
            brc.setValidateProductionChangesState(org.broadleafcommerce.common.web.ValidateProductionChangesState.SITE);
        }else {
            brc.setValidateProductionChangesState(org.broadleafcommerce.common.web.ValidateProductionChangesState.UNDEFINED);
        }
        org.broadleafcommerce.common.web.BroadleafRequestContext.setBroadleafRequestContext(brc);
        org.broadleafcommerce.common.locale.domain.Locale locale = localeResolver.resolveLocale(request);
        brc.setLocale(locale);
        java.util.TimeZone timeZone = broadleafTimeZoneResolver.resolveTimeZone(request);
        org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto currencyDto = currencyResolver.resolveCurrency(request);
        org.broadleafcommerce.common.RequestDTO requestDTO = ((org.broadleafcommerce.common.RequestDTO) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafRequestProcessor.REQUEST_DTO_PARAM_NAME, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7883, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7884, (requestDTO == null))) {
            requestDTO = new org.broadleafcommerce.common.RequestDTOImpl(request);
        }
        org.broadleafcommerce.common.sandbox.domain.SandBox currentSandbox = sandboxResolver.resolveSandBox(request, site);
        java.lang.Boolean reprocessRequest = ((java.lang.Boolean) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafRequestProcessor.REPROCESS_PARAM_NAME, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7885, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7886, ((reprocessRequest != null) && reprocessRequest))) {
            LOG.debug("Reprocessing request");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7887, (request instanceof org.springframework.web.context.request.ServletWebRequest))) {
                javax.servlet.http.HttpServletRequest hsr = ((org.springframework.web.context.request.ServletWebRequest) (request)).getRequest();
                clearBroadleafSessionAttrs(request);
                java.lang.StringBuffer url = hsr.getRequestURL();
                javax.servlet.http.HttpServletResponse response = ((org.springframework.web.context.request.ServletWebRequest) (request)).getResponse();
                try {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7889, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7888, isUrlValid(url.toString())))))) {
                        LOG.error(("SECURITY FAILURE Bad redirect location: " + (org.broadleafcommerce.common.util.StringUtil.sanitize(url.toString()))));
                        response.sendError(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7890, 403));
                        return ;
                    }
                    java.lang.String sandboxId = hsr.getParameter(org.broadleafcommerce.common.web.BroadleafRequestProcessor.SANDBOX_ID_PARAM);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7891, isSandboxIdValid(sandboxId))) {
                        java.lang.String queryString = (("?" + (org.broadleafcommerce.common.web.BroadleafRequestProcessor.SANDBOX_ID_PARAM)) + "=") + sandboxId;
                        url.append(queryString);
                    }
                    response.sendRedirect(url.toString());
                } catch (java.io.IOException e) {
                    throw new java.lang.RuntimeException(e);
                }
                throw new org.broadleafcommerce.common.web.exception.HaltFilterChainException("Reprocess required, redirecting user");
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7895, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7893, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7892, siteDisableSandboxPreview))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7894, (currentSandbox != null)))))) {
            org.broadleafcommerce.common.web.SandBoxContext previewSandBoxContext = new org.broadleafcommerce.common.web.SandBoxContext();
            previewSandBoxContext.setSandBoxId(currentSandbox.getId());
            previewSandBoxContext.setPreviewMode(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7896, true));
            org.broadleafcommerce.common.web.SandBoxContext.setSandBoxContext(previewSandBoxContext);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7897, (currencyDto != null))) {
            brc.setBroadleafCurrency(currencyDto.getCurrencyToUse());
            brc.setRequestedBroadleafCurrency(currencyDto.getRequestedCurrency());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7900, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7898, (currentSandbox != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7899, ((currentSandbox.getChildSandBoxes()) != null)))))) {
            currentSandbox.getChildSandBoxes().size();
        }
        brc.setSandBox(currentSandbox);
        brc.setDeployBehavior((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7901, deployBehaviorUtil.isProductionSandBoxMode()) ? org.broadleafcommerce.common.web.DeployBehavior.CLONE_PARENT : org.broadleafcommerce.common.web.DeployBehavior.OVERWRITE_PARENT));
        org.broadleafcommerce.common.site.domain.Theme theme = themeResolver.resolveTheme(request);
        brc.setTheme(theme);
        brc.setMessageSource(messageSource);
        brc.setTimeZone(timeZone);
        brc.setRequestDTO(requestDTO);
        java.util.Map<java.lang.String, java.lang.Object> ruleMap = ((java.util.Map<java.lang.String, java.lang.Object>) (request.getAttribute("blRuleMap", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7902, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7903, (ruleMap == null))) {
            LOG.trace("Creating ruleMap and adding in Locale.");
            ruleMap = new java.util.HashMap<java.lang.String, java.lang.Object>();
            request.setAttribute("blRuleMap", ruleMap, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7904, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        }else {
            LOG.trace("Using pre-existing ruleMap - added by non standard BLC process.");
        }
        ruleMap.put("locale", locale);
        java.lang.String adminUserId = request.getParameter(org.broadleafcommerce.common.web.BroadleafRequestFilter.ADMIN_USER_ID_PARAM_NAME);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7905, org.apache.commons.lang3.StringUtils.isNotBlank(adminUserId))) {
            brc.setAdminUserId(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7906, java.lang.Long.parseLong(adminUserId)));
        }
    }

    protected boolean isUrlValid(java.lang.String url) {
        boolean isValid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7907, false);
        java.lang.String siteBaseUrl = (baseUrlResolver.getSiteBaseUrl()) + "/";
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7908, org.apache.commons.lang3.StringUtils.equals(url, siteBaseUrl))) {
            isValid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7909, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7910, isValid);
    }

    protected boolean isSandboxIdValid(java.lang.String sandboxId) {
        boolean isValid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7911, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7912, org.apache.commons.lang3.StringUtils.isNotEmpty(sandboxId))) {
            java.lang.Long id = java.lang.Long.valueOf(sandboxId);
            org.broadleafcommerce.common.sandbox.domain.SandBox sandbox = sandBoxService.retrieveSandBoxById(id);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7913, (sandbox != null))) {
                isValid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7914, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7915, isValid);
    }

    @java.lang.Override
    public void postProcess(org.springframework.web.context.request.WebRequest request) {
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.remove();
    }

    protected void clearBroadleafSessionAttrs(org.springframework.web.context.request.WebRequest request) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7916, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            request.removeAttribute(org.broadleafcommerce.common.web.BroadleafLocaleResolverImpl.LOCALE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7917, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            request.removeAttribute(org.broadleafcommerce.common.web.BroadleafCurrencyResolverImpl.CURRENCY_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7918, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            request.removeAttribute(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.TIMEZONE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7919, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            request.removeAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolver.SANDBOX_ID_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7920, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            request.removeAttribute("_blc_anonymousCustomer", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7921, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            request.removeAttribute("_blc_anonymousCustomerId", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7922, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
        }
    }

    public static perturbation.location.PerturbationLocation __L7879;

    public static perturbation.location.PerturbationLocation __L7880;

    public static perturbation.location.PerturbationLocation __L7881;

    public static perturbation.location.PerturbationLocation __L7882;

    public static perturbation.location.PerturbationLocation __L7883;

    public static perturbation.location.PerturbationLocation __L7884;

    public static perturbation.location.PerturbationLocation __L7885;

    public static perturbation.location.PerturbationLocation __L7886;

    public static perturbation.location.PerturbationLocation __L7887;

    public static perturbation.location.PerturbationLocation __L7888;

    public static perturbation.location.PerturbationLocation __L7889;

    public static perturbation.location.PerturbationLocation __L7890;

    public static perturbation.location.PerturbationLocation __L7891;

    public static perturbation.location.PerturbationLocation __L7892;

    public static perturbation.location.PerturbationLocation __L7893;

    public static perturbation.location.PerturbationLocation __L7894;

    public static perturbation.location.PerturbationLocation __L7895;

    public static perturbation.location.PerturbationLocation __L7896;

    public static perturbation.location.PerturbationLocation __L7897;

    public static perturbation.location.PerturbationLocation __L7898;

    public static perturbation.location.PerturbationLocation __L7899;

    public static perturbation.location.PerturbationLocation __L7900;

    public static perturbation.location.PerturbationLocation __L7901;

    public static perturbation.location.PerturbationLocation __L7902;

    public static perturbation.location.PerturbationLocation __L7903;

    public static perturbation.location.PerturbationLocation __L7904;

    public static perturbation.location.PerturbationLocation __L7905;

    public static perturbation.location.PerturbationLocation __L7906;

    public static perturbation.location.PerturbationLocation __L7907;

    public static perturbation.location.PerturbationLocation __L7908;

    public static perturbation.location.PerturbationLocation __L7909;

    public static perturbation.location.PerturbationLocation __L7910;

    public static perturbation.location.PerturbationLocation __L7911;

    public static perturbation.location.PerturbationLocation __L7912;

    public static perturbation.location.PerturbationLocation __L7913;

    public static perturbation.location.PerturbationLocation __L7914;

    public static perturbation.location.PerturbationLocation __L7915;

    public static perturbation.location.PerturbationLocation __L7916;

    public static perturbation.location.PerturbationLocation __L7917;

    public static perturbation.location.PerturbationLocation __L7918;

    public static perturbation.location.PerturbationLocation __L7919;

    public static perturbation.location.PerturbationLocation __L7920;

    public static perturbation.location.PerturbationLocation __L7921;

    public static perturbation.location.PerturbationLocation __L7922;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:122)", 7879, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:123)", 7880, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:125)", 7881, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:127)", 7882, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:140)", 7883, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:141)", 7884, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:149)", 7885, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:150)", 7886, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:152)", 7887, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:161)", 7888, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:161)", 7889, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:163)", 7890, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:169)", 7891, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:183)", 7892, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:183)", 7893, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:183)", 7894, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:183)", 7895, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:186)", 7896, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:189)", 7897, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:195)", 7898, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:195)", 7899, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:195)", 7900, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:200)", 7901, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:209)", 7902, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:210)", 7903, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:213)", 7904, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:220)", 7905, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:222)", 7906, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:228)", 7907, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:231)", 7908, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:232)", 7909, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:235)", 7910, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:239)", 7911, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:241)", 7912, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:246)", 7913, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:247)", 7914, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:251)", 7915, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:260)", 7916, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:261)", 7917, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:262)", 7918, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:263)", 7919, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:264)", 7920, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:267)", 7921, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.__L7922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestProcessor.java:268)", 7922, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafRequestProcessor.initPerturbationLocation0();
    }
}

