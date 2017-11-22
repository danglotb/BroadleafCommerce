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


public class BroadleafRequestContext {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.BroadleafRequestContext.class);

    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.web.BroadleafRequestContext> BROADLEAF_REQUEST_CONTEXT = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.web.BroadleafRequestContext.class);

    protected javax.servlet.http.HttpServletRequest request;

    protected javax.servlet.http.HttpServletResponse response;

    protected org.springframework.web.context.request.WebRequest webRequest;

    protected org.broadleafcommerce.common.sandbox.domain.SandBox sandBox;

    protected org.broadleafcommerce.common.locale.domain.Locale locale;

    protected java.util.TimeZone timeZone;

    protected org.broadleafcommerce.common.currency.domain.BroadleafCurrency broadleafCurrency;

    protected org.broadleafcommerce.common.currency.domain.BroadleafCurrency requestedCurrency;

    protected org.broadleafcommerce.common.site.domain.Site site;

    protected org.broadleafcommerce.common.site.domain.Theme theme;

    protected java.util.Locale javaLocale;

    protected java.util.Currency javaCurrency;

    protected org.broadleafcommerce.common.site.domain.Catalog currentCatalog;

    protected java.util.List<java.lang.Long> explicitCatalogs = new java.util.ArrayList<>();

    protected org.broadleafcommerce.common.site.domain.Site currentProfile;

    protected java.lang.Boolean ignoreSite = ((boolean) (false));

    protected java.util.Map<java.lang.String, java.lang.Object> additionalProperties = new java.util.HashMap<>();

    protected org.springframework.context.MessageSource messageSource;

    protected org.broadleafcommerce.common.RequestDTO requestDTO;

    protected java.lang.Boolean isAdmin = ((boolean) (false));

    protected java.lang.Long adminUserId;

    protected org.broadleafcommerce.common.web.DeployState deployState = org.broadleafcommerce.common.web.DeployState.UNDEFINED;

    protected org.broadleafcommerce.common.web.DeployBehavior deployBehavior = org.broadleafcommerce.common.web.DeployBehavior.UNDEFINED;

    protected java.lang.Boolean internalIgnoreFilters = ((boolean) (false));

    protected org.broadleafcommerce.common.web.ValidateProductionChangesState validateProductionChangesState = org.broadleafcommerce.common.web.ValidateProductionChangesState.UNDEFINED;

    protected org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState enforceEnterpriseCollectionBehaviorState = org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState.UNDEFINED;

    protected java.lang.Boolean internalValidateFind = ((boolean) (false));

    public static org.broadleafcommerce.common.web.BroadleafRequestContext getBroadleafRequestContext() {
        return org.broadleafcommerce.common.web.BroadleafRequestContext.BROADLEAF_REQUEST_CONTEXT.get();
    }

    public static void setBroadleafRequestContext(org.broadleafcommerce.common.web.BroadleafRequestContext broadleafRequestContext) {
        org.broadleafcommerce.common.web.BroadleafRequestContext.BROADLEAF_REQUEST_CONTEXT.set(broadleafRequestContext);
    }

    public static boolean hasLocale() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7753, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext()) != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7754, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getLocale()) != null))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7755, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7756, false);
    }

    public static boolean hasCurrency() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7757, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext()) != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7758, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getBroadleafCurrency()) != null))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7759, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7760, false);
    }

    public static org.broadleafcommerce.common.currency.domain.BroadleafCurrency getCurrency() {
        org.broadleafcommerce.common.currency.domain.BroadleafCurrency returnCurrency = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7761, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext()) != null))) {
            returnCurrency = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getBroadleafCurrency();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7762, (returnCurrency == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7763, org.broadleafcommerce.common.web.BroadleafRequestContext.LOG.isWarnEnabled())) {
                org.broadleafcommerce.common.web.BroadleafRequestContext.LOG.warn("BroadleafRequestContext.getCurrency() called but returned null");
            }
        }
        return returnCurrency;
    }

    public javax.servlet.http.HttpServletRequest getRequest() {
        return request;
    }

    public java.lang.Object getRequestAttribute(java.lang.String name) {
        java.lang.Object param = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7764, ((getRequest()) != null))) {
            param = getRequest().getAttribute(name);
        }
        return param;
    }

    public void setRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
        this.webRequest = new org.springframework.web.context.request.ServletWebRequest(request);
    }

    public javax.servlet.http.HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(javax.servlet.http.HttpServletResponse response) {
        this.response = response;
    }

    public void setWebRequest(org.springframework.web.context.request.WebRequest webRequest) {
        this.webRequest = webRequest;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7765, (webRequest instanceof org.springframework.web.context.request.ServletWebRequest))) {
            this.request = ((org.springframework.web.context.request.ServletWebRequest) (webRequest)).getRequest();
            setResponse(((org.springframework.web.context.request.ServletWebRequest) (webRequest)).getResponse());
        }
    }

    public org.springframework.web.context.request.WebRequest getWebRequest() {
        return webRequest;
    }

    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site getSite() {
        return getNonPersistentSite();
    }

    @java.lang.Deprecated
    public void setSite(org.broadleafcommerce.common.site.domain.Site site) {
        setNonPersistentSite(site);
    }

    public org.broadleafcommerce.common.site.domain.Site getNonPersistentSite() {
        return site;
    }

    public void setNonPersistentSite(org.broadleafcommerce.common.site.domain.Site site) {
        this.site = site;
    }

    public org.broadleafcommerce.common.sandbox.domain.SandBox getSandBox() {
        return sandBox;
    }

    public java.lang.Long getSandBoxId() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7766, ((sandBox) != null))) {
            return sandBox.getId();
        }
        return null;
    }

    public boolean isProductionSandBox() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7769, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7767, ((sandBox) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7768, ((org.broadleafcommerce.common.sandbox.domain.SandBoxType.PRODUCTION) == (sandBox.getSandBoxType()))))));
    }

    public void setSandBox(org.broadleafcommerce.common.sandbox.domain.SandBox sandBox) {
        this.sandBox = sandBox;
    }

    public org.broadleafcommerce.common.locale.domain.Locale getLocale() {
        return locale;
    }

    public java.util.Locale getJavaLocale() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7770, ((this.javaLocale) == null))) {
            this.javaLocale = convertLocaleToJavaLocale();
        }
        return this.javaLocale;
    }

    public java.util.Currency getJavaCurrency() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7771, ((javaCurrency) == null))) {
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7774, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7772, ((getBroadleafCurrency()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7773, ((getBroadleafCurrency().getCurrencyCode()) != null)))))) {
                    javaCurrency = getBroadleafCurrency().getJavaCurrency();
                }else {
                    javaCurrency = java.util.Currency.getInstance(getJavaLocale());
                }
            } catch (java.lang.IllegalArgumentException e) {
                org.broadleafcommerce.common.web.BroadleafRequestContext.LOG.warn(("There was an error processing the configured locale into the java currency. This is likely because the default" + ((" locale is set to something like 'en' (which is NOT apart of ISO 3166 and does not have a currency" + " associated with it) instead of 'en_US' (which IS apart of ISO 3166 and has a currency associated") + " with it). Because of this, the currency is now set to the default locale of the JVM")));
                org.broadleafcommerce.common.web.BroadleafRequestContext.LOG.warn(("To fully resolve this, update the default entry in the BLC_LOCALE table to take into account the" + (" country code as well as the language. Alternatively, you could also update the BLC_CURRENCY table" + " to contain a default currency.")));
                javaCurrency = java.util.Currency.getInstance(java.util.Locale.getDefault());
            }
        }
        return javaCurrency;
    }

    public void setLocale(org.broadleafcommerce.common.locale.domain.Locale locale) {
        this.locale = locale;
        this.javaLocale = convertLocaleToJavaLocale();
    }

    public java.lang.String getRequestURIWithoutContext() {
        return org.broadleafcommerce.common.util.BLCRequestUtils.getRequestURIWithoutContext(request);
    }

    protected java.util.Locale convertLocaleToJavaLocale() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7777, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7775, ((locale) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7776, ((locale.getLocaleCode()) == null)))))) {
            return java.util.Locale.getDefault();
        }else {
            return org.broadleafcommerce.common.web.BroadleafRequestContext.convertLocaleToJavaLocale(locale);
        }
    }

    public static java.util.Locale convertLocaleToJavaLocale(org.broadleafcommerce.common.locale.domain.Locale broadleafLocale) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7778, (broadleafLocale != null))) {
            return broadleafLocale.getJavaLocale();
        }
        return null;
    }

    public boolean isSecure() {
        boolean secure = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7779, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7780, ((request) != null))) {
            secure = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7783, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7781, "HTTPS".equalsIgnoreCase(request.getScheme()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7782, request.isSecure()))));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7784, secure);
    }

    public org.broadleafcommerce.common.site.domain.Theme getTheme() {
        return theme;
    }

    public void setTheme(org.broadleafcommerce.common.site.domain.Theme theme) {
        this.theme = theme;
    }

    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency getBroadleafCurrency() {
        return broadleafCurrency;
    }

    public void setBroadleafCurrency(org.broadleafcommerce.common.currency.domain.BroadleafCurrency broadleafCurrency) {
        this.broadleafCurrency = broadleafCurrency;
    }

    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency getRequestedBroadleafCurrency() {
        return requestedCurrency;
    }

    public void setRequestedBroadleafCurrency(org.broadleafcommerce.common.currency.domain.BroadleafCurrency requestedCurrency) {
        this.requestedCurrency = requestedCurrency;
    }

    public org.broadleafcommerce.common.site.domain.Catalog getCurrentCatalog() {
        return currentCatalog;
    }

    public void setCurrentCatalog(org.broadleafcommerce.common.site.domain.Catalog currentCatalog) {
        this.currentCatalog = currentCatalog;
    }

    public java.util.List<java.lang.Long> getExplicitCatalogs() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7785, ((explicitCatalogs) != null)) ? explicitCatalogs : new java.util.ArrayList<java.lang.Long>();
    }

    public void setExplicitCatalogs(java.util.List<java.lang.Long> explicitCatalogs) {
        this.explicitCatalogs = explicitCatalogs;
    }

    public org.broadleafcommerce.common.site.domain.Site getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(org.broadleafcommerce.common.site.domain.Site currentProfile) {
        this.currentProfile = currentProfile;
    }

    @java.lang.SuppressWarnings("unchecked")
    public static java.util.Map<java.lang.String, java.lang.String[]> getRequestParameterMap() {
        return org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getRequest().getParameterMap();
    }

    public java.lang.Boolean getIgnoreSite() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7788, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7786, ((ignoreSite) == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7787, false) : ignoreSite));
    }

    public void setIgnoreSite(java.lang.Boolean ignoreSite) {
        this.ignoreSite = ignoreSite;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(java.util.Map<java.lang.String, java.lang.Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public org.springframework.context.MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(org.springframework.context.MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public java.util.TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(java.util.TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public org.broadleafcommerce.common.RequestDTO getRequestDTO() {
        return requestDTO;
    }

    public void setRequestDTO(org.broadleafcommerce.common.RequestDTO requestDTO) {
        this.requestDTO = requestDTO;
    }

    public java.lang.Boolean getAdmin() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7791, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7789, ((isAdmin) == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7790, false) : isAdmin));
    }

    public void setAdmin(java.lang.Boolean admin) {
        isAdmin = admin;
    }

    public java.lang.Long getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(java.lang.Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    public java.lang.Boolean getInternalIgnoreFilters() {
        return internalIgnoreFilters;
    }

    public void setInternalIgnoreFilters(java.lang.Boolean internalIgnoreFilters) {
        this.internalIgnoreFilters = internalIgnoreFilters;
    }

    public java.lang.Boolean getInternalValidateFind() {
        return internalValidateFind;
    }

    public void setInternalValidateFind(java.lang.Boolean internalValidateFind) {
        this.internalValidateFind = internalValidateFind;
    }

    public org.broadleafcommerce.common.web.DeployState getDeployState() {
        return deployState;
    }

    public void setDeployState(org.broadleafcommerce.common.web.DeployState deployState) {
        this.deployState = deployState;
    }

    public org.broadleafcommerce.common.web.DeployBehavior getDeployBehavior() {
        return deployBehavior;
    }

    public void setDeployBehavior(org.broadleafcommerce.common.web.DeployBehavior deployBehavior) {
        this.deployBehavior = deployBehavior;
    }

    public org.broadleafcommerce.common.web.ValidateProductionChangesState getValidateProductionChangesState() {
        return validateProductionChangesState;
    }

    public void setValidateProductionChangesState(org.broadleafcommerce.common.web.ValidateProductionChangesState validateProductionChangesState) {
        this.validateProductionChangesState = validateProductionChangesState;
    }

    public org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState getEnforceEnterpriseCollectionBehaviorState() {
        return enforceEnterpriseCollectionBehaviorState;
    }

    public void setEnforceEnterpriseCollectionBehaviorState(org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState enforceEnterpriseCollectionBehaviorState) {
        this.enforceEnterpriseCollectionBehaviorState = enforceEnterpriseCollectionBehaviorState;
    }

    public org.broadleafcommerce.common.web.BroadleafRequestContext createLightWeightClone() {
        org.broadleafcommerce.common.web.BroadleafRequestContext context = new org.broadleafcommerce.common.web.BroadleafRequestContext();
        context.setIgnoreSite(ignoreSite);
        context.setSandBox(sandBox);
        context.setNonPersistentSite(site);
        context.setEnforceEnterpriseCollectionBehaviorState(enforceEnterpriseCollectionBehaviorState);
        context.setAdmin(isAdmin);
        context.setAdminUserId(adminUserId);
        context.setBroadleafCurrency(broadleafCurrency);
        context.setCurrentCatalog(currentCatalog);
        context.setCurrentProfile(currentProfile);
        context.setDeployBehavior(deployBehavior);
        context.setDeployState(deployState);
        context.setInternalIgnoreFilters(internalIgnoreFilters);
        context.setLocale(locale);
        context.setMessageSource(messageSource);
        context.setTheme(theme);
        context.setValidateProductionChangesState(validateProductionChangesState);
        context.setTimeZone(timeZone);
        return context;
    }

    public java.lang.String createLightWeightCloneJson() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("{\"ignoreSite\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7792, ((ignoreSite) == null)) ? null : ignoreSite));
        sb.append("\",\"sandBox\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7793, ((sandBox) == null)) ? null : sandBox.getId()));
        sb.append("\",\"nonPersistentSite\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7794, ((site) == null)) ? null : site.getId()));
        sb.append("\",\"enforceEnterpriseCollectionBehaviorState\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7795, ((enforceEnterpriseCollectionBehaviorState) == null)) ? null : enforceEnterpriseCollectionBehaviorState.toString()));
        sb.append("\",\"admin\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7796, ((isAdmin) == null)) ? null : isAdmin.toString()));
        sb.append("\",\"adminUserId\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7797, ((adminUserId) == null)) ? null : adminUserId));
        sb.append("\",\"broadleafCurrency\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7798, ((broadleafCurrency) == null)) ? null : broadleafCurrency.getCurrencyCode()));
        sb.append("\",\"currentCatalog\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7799, ((currentCatalog) == null)) ? null : currentCatalog.getId()));
        sb.append("\",\"currentProfile\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7800, ((currentProfile) == null)) ? null : currentProfile.getId()));
        sb.append("\",\"deployBehavior\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7801, ((deployBehavior) == null)) ? null : deployBehavior.toString()));
        sb.append("\",\"deployState\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7802, ((deployState) == null)) ? null : deployState.toString()));
        sb.append("\",\"internalIgnoreFilters\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7803, ((internalIgnoreFilters) == null)) ? null : internalIgnoreFilters.toString()));
        sb.append("\",\"locale\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7804, ((locale) == null)) ? null : locale.getLocaleCode()));
        sb.append("\",\"validateProductionChangesState\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7805, ((validateProductionChangesState) == null)) ? null : validateProductionChangesState.toString()));
        sb.append("\",\"timeZone\":\"");
        sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7806, ((timeZone) == null)) ? null : timeZone.getID()));
        sb.append("\"}");
        return sb.toString();
    }

    public static org.broadleafcommerce.common.web.BroadleafRequestContext createLightWeightCloneFromJson(java.lang.String Json, javax.persistence.EntityManager em) {
        org.broadleafcommerce.common.web.BroadleafRequestContext context = new org.broadleafcommerce.common.web.BroadleafRequestContext();
        com.fasterxml.jackson.core.JsonFactory factory = new com.fasterxml.jackson.core.JsonFactory();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper(factory);
        com.fasterxml.jackson.core.type.TypeReference<java.util.HashMap<java.lang.String, java.lang.String>> typeRef = new com.fasterxml.jackson.core.type.TypeReference<java.util.HashMap<java.lang.String, java.lang.String>>() {};
        java.util.HashMap<java.lang.String, java.lang.String> json;
        try {
            json = mapper.readValue(Json, typeRef);
        } catch (java.io.IOException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7808, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7807, json.get("ignoreSite").equals("null")))))) {
            context.setIgnoreSite(java.lang.Boolean.valueOf(json.get("ignoreSite")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7810, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7809, json.get("sandBox").equals("null")))))) {
            context.setSandBox(em.find(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.class, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7811, java.lang.Long.parseLong(json.get("sandBox")))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7813, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7812, json.get("nonPersistentSite").equals("null")))))) {
            context.setNonPersistentSite(em.find(org.broadleafcommerce.common.site.domain.SiteImpl.class, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7814, java.lang.Long.parseLong(json.get("nonPersistentSite")))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7816, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7815, json.get("enforceEnterpriseCollectionBehaviorState").equals("null")))))) {
            context.setEnforceEnterpriseCollectionBehaviorState(org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState.valueOf(json.get("enforceEnterpriseCollectionBehaviorState")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7818, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7817, json.get("admin").equals("null")))))) {
            context.setAdmin(java.lang.Boolean.valueOf(json.get("admin")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7820, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7819, json.get("adminUserId").equals("null")))))) {
            context.setAdminUserId(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7821, java.lang.Long.parseLong(json.get("adminUserId"))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7823, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7822, json.get("broadleafCurrency").equals("null")))))) {
            context.setBroadleafCurrency(em.find(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.class, json.get("broadleafCurrency")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7825, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7824, json.get("currentCatalog").equals("null")))))) {
            context.setCurrentCatalog(em.find(org.broadleafcommerce.common.site.domain.CatalogImpl.class, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7826, java.lang.Long.parseLong(json.get("currentCatalog")))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7828, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7827, json.get("currentProfile").equals("null")))))) {
            context.setCurrentProfile(em.find(org.broadleafcommerce.common.site.domain.SiteImpl.class, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7829, java.lang.Long.parseLong(json.get("currentProfile")))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7831, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7830, json.get("deployBehavior").equals("null")))))) {
            context.setDeployBehavior(org.broadleafcommerce.common.web.DeployBehavior.valueOf(json.get("deployBehavior")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7833, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7832, json.get("deployState").equals("null")))))) {
            context.setDeployState(org.broadleafcommerce.common.web.DeployState.valueOf(json.get("deployState")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7835, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7834, json.get("internalIgnoreFilters").equals("null")))))) {
            context.setInternalIgnoreFilters(java.lang.Boolean.valueOf(json.get("internalIgnoreFilters")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7837, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7836, json.get("locale").equals("null")))))) {
            context.setLocale(em.find(org.broadleafcommerce.common.locale.domain.LocaleImpl.class, json.get("locale")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7839, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7838, json.get("validateProductionChangesState").equals("null")))))) {
            context.setValidateProductionChangesState(org.broadleafcommerce.common.web.ValidateProductionChangesState.valueOf(json.get("validateProductionChangesState")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7841, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestContext.__L7840, json.get("timeZone").equals("null")))))) {
            context.setTimeZone(java.util.TimeZone.getTimeZone(json.get("timeZone")));
        }
        return context;
    }

    public static perturbation.location.PerturbationLocation __L7753;

    public static perturbation.location.PerturbationLocation __L7754;

    public static perturbation.location.PerturbationLocation __L7755;

    public static perturbation.location.PerturbationLocation __L7756;

    public static perturbation.location.PerturbationLocation __L7757;

    public static perturbation.location.PerturbationLocation __L7758;

    public static perturbation.location.PerturbationLocation __L7759;

    public static perturbation.location.PerturbationLocation __L7760;

    public static perturbation.location.PerturbationLocation __L7761;

    public static perturbation.location.PerturbationLocation __L7762;

    public static perturbation.location.PerturbationLocation __L7763;

    public static perturbation.location.PerturbationLocation __L7764;

    public static perturbation.location.PerturbationLocation __L7765;

    public static perturbation.location.PerturbationLocation __L7766;

    public static perturbation.location.PerturbationLocation __L7767;

    public static perturbation.location.PerturbationLocation __L7768;

    public static perturbation.location.PerturbationLocation __L7769;

    public static perturbation.location.PerturbationLocation __L7770;

    public static perturbation.location.PerturbationLocation __L7771;

    public static perturbation.location.PerturbationLocation __L7772;

    public static perturbation.location.PerturbationLocation __L7773;

    public static perturbation.location.PerturbationLocation __L7774;

    public static perturbation.location.PerturbationLocation __L7775;

    public static perturbation.location.PerturbationLocation __L7776;

    public static perturbation.location.PerturbationLocation __L7777;

    public static perturbation.location.PerturbationLocation __L7778;

    public static perturbation.location.PerturbationLocation __L7779;

    public static perturbation.location.PerturbationLocation __L7780;

    public static perturbation.location.PerturbationLocation __L7781;

    public static perturbation.location.PerturbationLocation __L7782;

    public static perturbation.location.PerturbationLocation __L7783;

    public static perturbation.location.PerturbationLocation __L7784;

    public static perturbation.location.PerturbationLocation __L7785;

    public static perturbation.location.PerturbationLocation __L7786;

    public static perturbation.location.PerturbationLocation __L7787;

    public static perturbation.location.PerturbationLocation __L7788;

    public static perturbation.location.PerturbationLocation __L7789;

    public static perturbation.location.PerturbationLocation __L7790;

    public static perturbation.location.PerturbationLocation __L7791;

    public static perturbation.location.PerturbationLocation __L7792;

    public static perturbation.location.PerturbationLocation __L7793;

    public static perturbation.location.PerturbationLocation __L7794;

    public static perturbation.location.PerturbationLocation __L7795;

    public static perturbation.location.PerturbationLocation __L7796;

    public static perturbation.location.PerturbationLocation __L7797;

    public static perturbation.location.PerturbationLocation __L7798;

    public static perturbation.location.PerturbationLocation __L7799;

    public static perturbation.location.PerturbationLocation __L7800;

    public static perturbation.location.PerturbationLocation __L7801;

    public static perturbation.location.PerturbationLocation __L7802;

    public static perturbation.location.PerturbationLocation __L7803;

    public static perturbation.location.PerturbationLocation __L7804;

    public static perturbation.location.PerturbationLocation __L7805;

    public static perturbation.location.PerturbationLocation __L7806;

    public static perturbation.location.PerturbationLocation __L7807;

    public static perturbation.location.PerturbationLocation __L7808;

    public static perturbation.location.PerturbationLocation __L7809;

    public static perturbation.location.PerturbationLocation __L7810;

    public static perturbation.location.PerturbationLocation __L7811;

    public static perturbation.location.PerturbationLocation __L7812;

    public static perturbation.location.PerturbationLocation __L7813;

    public static perturbation.location.PerturbationLocation __L7814;

    public static perturbation.location.PerturbationLocation __L7815;

    public static perturbation.location.PerturbationLocation __L7816;

    public static perturbation.location.PerturbationLocation __L7817;

    public static perturbation.location.PerturbationLocation __L7818;

    public static perturbation.location.PerturbationLocation __L7819;

    public static perturbation.location.PerturbationLocation __L7820;

    public static perturbation.location.PerturbationLocation __L7821;

    public static perturbation.location.PerturbationLocation __L7822;

    public static perturbation.location.PerturbationLocation __L7823;

    public static perturbation.location.PerturbationLocation __L7824;

    public static perturbation.location.PerturbationLocation __L7825;

    public static perturbation.location.PerturbationLocation __L7826;

    public static perturbation.location.PerturbationLocation __L7827;

    public static perturbation.location.PerturbationLocation __L7828;

    public static perturbation.location.PerturbationLocation __L7829;

    public static perturbation.location.PerturbationLocation __L7830;

    public static perturbation.location.PerturbationLocation __L7831;

    public static perturbation.location.PerturbationLocation __L7832;

    public static perturbation.location.PerturbationLocation __L7833;

    public static perturbation.location.PerturbationLocation __L7834;

    public static perturbation.location.PerturbationLocation __L7835;

    public static perturbation.location.PerturbationLocation __L7836;

    public static perturbation.location.PerturbationLocation __L7837;

    public static perturbation.location.PerturbationLocation __L7838;

    public static perturbation.location.PerturbationLocation __L7839;

    public static perturbation.location.PerturbationLocation __L7840;

    public static perturbation.location.PerturbationLocation __L7841;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:83)", 7753, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:84)", 7754, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:85)", 7755, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:88)", 7756, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:92)", 7757, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:93)", 7758, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:94)", 7759, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:97)", 7760, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:102)", 7761, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:106)", 7762, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:107)", 7763, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:157)", 7764, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:206)", 7765, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:264)", 7766, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:271)", 7767, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:271)", 7768, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:271)", 7769, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:287)", 7770, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:300)", 7771, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:302)", 7772, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:302)", 7773, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:302)", 7774, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:331)", 7775, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:331)", 7776, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:331)", 7777, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:339)", 7778, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:346)", 7779, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:347)", 7780, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:348)", 7781, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:348)", 7782, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:348)", 7783, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:350)", 7784, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:386)", 7785, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:407)", 7786, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:407)", 7787, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:407)", 7788, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:447)", 7789, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:447)", 7790, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:447)", 7791, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:587)", 7792, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:589)", 7793, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:591)", 7794, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:593)", 7795, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:595)", 7796, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:597)", 7797, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:599)", 7798, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:601)", 7799, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:603)", 7800, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:605)", 7801, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:607)", 7802, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:609)", 7803, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:611)", 7804, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:613)", 7805, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:615)", 7806, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:638)", 7807, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:638)", 7808, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:641)", 7809, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:641)", 7810, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:642)", 7811, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:644)", 7812, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:644)", 7813, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:645)", 7814, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:647)", 7815, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:647)", 7816, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:651)", 7817, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:651)", 7818, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:654)", 7819, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:654)", 7820, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:655)", 7821, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:657)", 7822, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:657)", 7823, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:660)", 7824, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:660)", 7825, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:661)", 7826, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:663)", 7827, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:663)", 7828, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:664)", 7829, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:666)", 7830, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:666)", 7831, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:669)", 7832, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:669)", 7833, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:672)", 7834, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:672)", 7835, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:675)", 7836, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:675)", 7837, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:678)", 7838, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:678)", 7839, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:681)", 7840, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestContext.__L7841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestContext.java:681)", 7841, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafRequestContext.initPerturbationLocation0();
    }
}

