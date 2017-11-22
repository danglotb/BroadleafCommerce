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
package org.broadleafcommerce.common.i18n.service;


@org.springframework.stereotype.Service("blTranslationService")
public class TranslationServiceImpl implements org.broadleafcommerce.common.i18n.service.TranslationService , org.broadleafcommerce.common.i18n.service.TranslationSupport {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.class);

    private static final org.broadleafcommerce.common.i18n.domain.Translation DELETED_TRANSLATION = new org.broadleafcommerce.common.i18n.domain.TranslationImpl();

    @javax.annotation.Resource(name = "blTranslationDao")
    protected org.broadleafcommerce.common.i18n.dao.TranslationDao dao;

    @javax.annotation.Resource(name = "blStatisticsService")
    protected org.broadleafcommerce.common.cache.StatisticsService statisticsService;

    @javax.annotation.Resource(name = "blSandBoxHelper")
    protected org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;

    protected net.sf.ehcache.Cache cache;

    @javax.annotation.Resource(name = "blTranslationServiceExtensionManager")
    protected org.broadleafcommerce.common.i18n.service.TranslationServiceExtensionManager extensionManager;

    @org.springframework.beans.factory.annotation.Value("${translation.thresholdForFullCache:1000}")
    protected int thresholdForFullCache;

    @org.springframework.beans.factory.annotation.Value("${translation.thresholdForFullCache:1000}")
    protected int templateThresholdForFullCache;

    @org.springframework.beans.factory.annotation.Value("${returnBlankTranslationForNotDefaultLocale:false}")
    protected boolean returnBlankTranslationForNotDefaultLocale;

    @javax.annotation.Resource(name = "blTranslationExceptionProperties")
    protected java.util.List<java.lang.String> translationExceptionProperties = new java.util.ArrayList<java.lang.String>();

    @javax.annotation.Resource(name = "blLocaleService")
    protected org.broadleafcommerce.common.locale.service.LocaleService localeService;

    @javax.annotation.Resource
    protected java.util.List<org.broadleafcommerce.common.i18n.service.TranslationOverrideStrategy> strategies;

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.i18n.domain.Translation save(org.broadleafcommerce.common.i18n.domain.Translation translation) {
        return dao.save(translation);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.i18n.domain.Translation save(java.lang.String entityType, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode, java.lang.String translatedValue) {
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity te = getEntityType(entityType);
        org.broadleafcommerce.common.i18n.domain.Translation translation = getTranslation(te, entityId, fieldName, localeCode);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3057, (translation == null))) {
            translation = dao.create();
            translation.setEntityType(te);
            translation.setEntityId(entityId);
            translation.setFieldName(fieldName);
            translation.setLocaleCode(localeCode);
        }
        translation.setTranslatedValue(translatedValue);
        return save(translation);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation findTranslationById(java.lang.Long id) {
        return dao.readTranslationById(id);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.i18n.domain.Translation update(java.lang.Long translationId, java.lang.String localeCode, java.lang.String translatedValue) {
        org.broadleafcommerce.common.i18n.domain.Translation t = dao.readTranslationById(translationId);
        org.broadleafcommerce.common.i18n.domain.Translation t2 = dao.readTranslation(t.getEntityType(), t.getEntityId(), t.getFieldName(), localeCode);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3060, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3058, (t2 != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3059, (t != t2)))))) {
            dao.delete(t2);
        }
        t.setLocaleCode(localeCode);
        t.setTranslatedValue(translatedValue);
        return save(t);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public void deleteTranslationById(java.lang.Long translationId) {
        org.broadleafcommerce.common.i18n.domain.Translation t = dao.readTranslationById(translationId);
        dao.delete(t);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation getTranslation(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entity, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode) {
        return dao.readTranslation(entity, entityId, fieldName, localeCode);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> getTranslations(java.lang.String ceilingEntityClassname, java.lang.String entityId, java.lang.String property) {
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType = getEntityType(ceilingEntityClassname);
        return dao.readTranslations(entityType, entityId, property);
    }

    @java.lang.Override
    public net.sf.ehcache.Cache getCache() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3061, ((cache) == null))) {
            cache = net.sf.ehcache.CacheManager.getInstance().getCache("blTranslationElements");
        }
        return cache;
    }

    @java.lang.Override
    public java.lang.String getTranslatedValue(java.lang.Object entity, java.lang.String property, java.util.Locale locale) {
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType = getEntityType(entity);
        java.lang.String entityId = dao.getEntityId(entityType, entity);
        java.lang.String localeCode = locale.getLanguage();
        java.lang.String localeCountryCode = localeCode;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3062, org.apache.commons.lang3.StringUtils.isNotBlank(locale.getCountry()))) {
            localeCountryCode += "_" + (locale.getCountry());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3063, org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.hasCache())) {
            org.broadleafcommerce.common.i18n.domain.Translation translation = org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getFromCache(entityType, entityId, property, localeCountryCode);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3064, (translation != null))) {
                return translation.getTranslatedValue();
            }else {
                return null;
            }
        }
        boolean isValidForCache = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3065, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3066, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> response = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean>();
            response.setResult(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3067, false));
            extensionManager.getProxy().isValidState(response);
            isValidForCache = ((boolean) (response.getResult()));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3072, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3069, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3068, org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().isProductionSandBox()))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3071, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3070, isValidForCache)))))))) {
            org.broadleafcommerce.common.i18n.domain.Translation translation = dao.readTranslation(entityType, entityId, property, localeCode, localeCountryCode, org.broadleafcommerce.common.extension.ResultType.CATALOG_ONLY);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3073, (translation != null))) {
                return translation.getTranslatedValue();
            }else {
                return null;
            }
        }
        return getOverrideTranslatedValue(property, entityType, entityId, localeCode, localeCountryCode);
    }

    @java.lang.Override
    public void removeTranslationFromCache(org.broadleafcommerce.common.i18n.domain.Translation translation) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3074, org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().isProductionSandBox())) {
            org.broadleafcommerce.common.extension.ResultType resultType = org.broadleafcommerce.common.extension.ResultType.STANDARD;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3075, ((extensionManager) != null))) {
                org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ResultType> response = new org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ResultType>();
                extensionManager.getProxy().getResultType(translation, response);
                resultType = response.getResult();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3076, ((org.broadleafcommerce.common.extension.ResultType.STANDARD) == resultType))) {
                    java.lang.String key = getCacheKey(resultType, translation.getEntityType());
                    org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.LOG.debug((("Removing key [" + key) + "] for STANDARD site"));
                    getCache().remove(key);
                }else {
                    java.util.List<java.lang.String> cacheKeysList = getCacheKeyListForTemplateSite(translation.getEntityType().getFriendlyType());
                    for (java.lang.String key : cacheKeysList) {
                        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.LOG.debug((("Removing key [" + key) + "] for TEMPLATE site"));
                        getCache().remove(key);
                    }
                }
            }
        }
    }

    protected java.lang.String getOverrideTranslatedValue(java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode) {
        boolean specificTranslationDeleted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3077, false);
        boolean generalTranslationDeleted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3078, false);
        org.broadleafcommerce.common.extension.StandardCacheItem specificTranslation = null;
        org.broadleafcommerce.common.extension.StandardCacheItem generalTranslation = null;
        java.lang.String specificPropertyKey = (property + "_") + localeCountryCode;
        java.lang.String generalPropertyKey = (property + "_") + localeCode;
        java.lang.String response = null;
        java.lang.String cacheKey = getCacheKey(org.broadleafcommerce.common.extension.ResultType.STANDARD, entityType);
        org.broadleafcommerce.common.i18n.service.LocalePair override = null;
        for (org.broadleafcommerce.common.i18n.service.TranslationOverrideStrategy strategy : strategies) {
            override = strategy.getLocaleBasedOverride(property, entityType, entityId, localeCode, localeCountryCode, cacheKey);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3079, (override != null))) {
                specificTranslation = override.getSpecificItem();
                generalTranslation = override.getGeneralItem();
                break;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3080, (override == null))) {
            throw new java.lang.IllegalStateException("Expected at least one TranslationOverrideStrategy to return a valid value");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3081, (specificTranslation != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3082, org.broadleafcommerce.common.extension.ItemStatus.DELETED.equals(specificTranslation.getItemStatus()))) {
                specificTranslationDeleted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3083, true);
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3084, ((specificTranslation.getCacheItem()) instanceof org.broadleafcommerce.common.i18n.domain.Translation))) {
                    response = ((org.broadleafcommerce.common.i18n.domain.Translation) (specificTranslation.getCacheItem())).getTranslatedValue();
                }else {
                    response = ((java.lang.String) (specificTranslation.getCacheItem()));
                }
                return replaceEmptyWithNullResponse(response);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3085, (generalTranslation != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3086, org.broadleafcommerce.common.extension.ItemStatus.DELETED.equals(generalTranslation.getItemStatus()))) {
                generalTranslationDeleted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3087, true);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3091, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3088, specificTranslationDeleted)) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3090, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3089, localeCountryCode.contains("_"))))))))) {
                    return null;
                }
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3092, ((generalTranslation.getCacheItem()) instanceof org.broadleafcommerce.common.i18n.domain.Translation))) {
                    response = ((org.broadleafcommerce.common.i18n.domain.Translation) (generalTranslation.getCacheItem())).getTranslatedValue();
                }else {
                    response = ((java.lang.String) (generalTranslation.getCacheItem()));
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3096, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3093, specificTranslationDeleted)) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3095, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3094, localeCountryCode.contains("_"))))))))) {
                    return replaceEmptyWithNullResponse(response);
                }
                generalTranslationDeleted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3097, true);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3098, specificTranslationDeleted)) {
            specificPropertyKey = generalPropertyKey;
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3099, generalTranslationDeleted)) {
                generalPropertyKey = specificPropertyKey;
            }

        java.lang.String templateResponse = getTemplateTranslatedValue(cacheKey, property, entityType, entityId, localeCode, localeCountryCode, specificPropertyKey, generalPropertyKey);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3100, (templateResponse != null))) {
            response = templateResponse;
        }
        return response;
    }

    protected java.lang.String replaceEmptyWithNullResponse(java.lang.String response) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3102, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3101, org.apache.commons.lang3.StringUtils.isEmpty(response)))))) {
            return response;
        }
        return null;
    }

    protected java.lang.String getTemplateTranslatedValue(java.lang.String standardCacheKey, java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String specificPropertyKey, java.lang.String generalPropertyKey) {
        java.lang.String cacheKey = getCacheKey(org.broadleafcommerce.common.extension.ResultType.TEMPLATE, entityType);
        org.broadleafcommerce.common.extension.StandardCacheItem translation = null;
        org.broadleafcommerce.common.i18n.service.LocalePair override = null;
        for (org.broadleafcommerce.common.i18n.service.TranslationOverrideStrategy strategy : strategies) {
            override = strategy.getLocaleBasedTemplateValue(cacheKey, property, entityType, entityId, localeCode, localeCountryCode, specificPropertyKey, generalPropertyKey);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3103, (override != null))) {
                translation = override.getSpecificItem();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3105, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3104, strategy.validateTemplateProcessing(standardCacheKey, cacheKey)))))) {
                    return null;
                }
                break;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3106, (override == null))) {
            throw new java.lang.IllegalStateException("Expected at least one TranslationOverrideStrategy to return a valid value");
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3107, (translation == null)) ? null : replaceEmptyWithNullResponse(((org.broadleafcommerce.common.i18n.domain.Translation) (translation.getCacheItem())).getTranslatedValue());
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.StandardCacheItem lookupTranslationFromMap(java.lang.String key, java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>> propertyTranslationMap, java.lang.String entityId) {
        org.broadleafcommerce.common.extension.StandardCacheItem cacheItem = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3108, propertyTranslationMap.containsKey(key))) {
            java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem> byEntity = propertyTranslationMap.get(key);
            cacheItem = byEntity.get(entityId);
        }
        return cacheItem;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation findBestTemplateTranslation(java.lang.String specificPropertyKey, java.lang.String generalPropertyKey, java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>> propertyTranslationMap, java.lang.String entityId) {
        org.broadleafcommerce.common.i18n.domain.Translation translation = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3109, propertyTranslationMap.containsKey(specificPropertyKey))) {
            java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation> byEntity = propertyTranslationMap.get(specificPropertyKey);
            translation = byEntity.get(entityId);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3112, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3110, (translation == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3111, propertyTranslationMap.containsKey(generalPropertyKey)))))) {
            java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation> byEntity = propertyTranslationMap.get(generalPropertyKey);
            translation = byEntity.get(entityId);
        }
        return translation;
    }

    protected org.broadleafcommerce.common.i18n.domain.TranslatedEntity getEntityType(java.lang.Class<?> entityClass) {
        for (java.util.Map.Entry<java.lang.String, org.broadleafcommerce.common.i18n.domain.TranslatedEntity> entry : org.broadleafcommerce.common.i18n.domain.TranslatedEntity.getTypes().entrySet()) {
            try {
                java.lang.Class<?> clazz = java.lang.Class.forName(entry.getKey());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3113, clazz.isAssignableFrom(entityClass))) {
                    return entry.getValue();
                }
            } catch (java.lang.ClassNotFoundException e) {
                throw new java.lang.IllegalArgumentException("TranslatedEntity type was not set to a known class", e);
            }
        }
        throw new java.lang.IllegalArgumentException(((entityClass.getName()) + " is not a known translatable class"));
    }

    protected org.broadleafcommerce.common.i18n.domain.TranslatedEntity getEntityType(java.lang.Object entity) {
        return getEntityType(entity.getClass());
    }

    protected org.broadleafcommerce.common.i18n.domain.TranslatedEntity getEntityType(java.lang.String className) {
        try {
            java.lang.Class<?> clazz = java.lang.Class.forName(className);
            return getEntityType(clazz);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.IllegalArgumentException((className + " is not a known translatable class"));
        }
    }

    @java.lang.Override
    public java.lang.String getCacheKey(org.broadleafcommerce.common.extension.ResultType resultType, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType) {
        java.lang.String cacheKey = org.apache.commons.lang3.StringUtils.join(new java.lang.String[]{ entityType.getFriendlyType() }, "|");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3114, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> result = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String>();
            extensionManager.getProxy().getCacheKey(cacheKey, resultType, result);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3115, ((result.getResult()) != null))) {
                cacheKey = result.getResult();
            }
        }
        return cacheKey;
    }

    @java.lang.Override
    public java.util.List<java.lang.String> getCacheKeyListForTemplateSite(java.lang.String propertyName) {
        java.util.List<java.lang.String> cacheKeyList = new java.util.ArrayList<>();
        java.lang.String cacheKey = org.apache.commons.lang3.StringUtils.join(new java.lang.String[]{ propertyName }, "|");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3116, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<java.lang.String>> result = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<java.lang.String>>();
            extensionManager.getProxy().getCacheKeyListForTemplateSite(cacheKey, result);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3117, ((result.getResult()) != null))) {
                cacheKeyList = result.getResult();
            }
        }
        return cacheKeyList;
    }

    @java.lang.Override
    public int getThresholdForFullCache() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3118, org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().isProductionSandBox())) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3119, thresholdForFullCache);
        }else {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3121, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3120, 1))));
        }
    }

    @java.lang.Override
    public void setThresholdForFullCache(int thresholdForFullCache) {
        this.thresholdForFullCache = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3122, thresholdForFullCache);
    }

    @java.lang.Override
    public int getTemplateThresholdForFullCache() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3123, org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().isProductionSandBox())) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3124, templateThresholdForFullCache);
        }else {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3126, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3125, 1))));
        }
    }

    @java.lang.Override
    public void setTemplateThresholdForFullCache(int templateThresholdForFullCache) {
        this.templateThresholdForFullCache = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3127, templateThresholdForFullCache);
    }

    @java.lang.Override
    public java.lang.String getDefaultTranslationValue(java.lang.Object entity, java.lang.String property, java.util.Locale locale, java.lang.String requestedDefaultValue) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3134, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3131, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3128, returnBlankTranslationForNotDefaultLocale)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3130, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3129, localeMatchesDefaultLocale(locale))))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3133, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3132, propertyInDefaultLocaleExceptionList(entity, property))))))))) {
            return "";
        }
        return requestedDefaultValue;
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> findAllTranslationEntries(org.broadleafcommerce.common.i18n.domain.TranslatedEntity translatedEntity, org.broadleafcommerce.common.extension.ResultType standard, java.util.List<java.lang.String> entityIds) {
        return dao.readAllTranslationEntries(translatedEntity, standard, entityIds);
    }

    protected boolean propertyInDefaultLocaleExceptionList(java.lang.Object entity, java.lang.String property) {
        org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType = getEntityType(entity);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3137, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3135, (entityType != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3136, ((entityType.getFriendlyType()) != null)))))) {
            for (java.lang.String exceptionProperty : translationExceptionProperties) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3138, property.matches(exceptionProperty))) {
                    return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3139, true);
                }
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3140, false);
    }

    protected boolean localeMatchesDefaultLocale(java.util.Locale locale) {
        java.lang.String defaultLanguage = org.broadleafcommerce.common.locale.util.LocaleUtil.findLanguageCode(localeService.findDefaultLocale());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3143, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3141, (defaultLanguage != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3142, (locale != null)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3144, defaultLanguage.equals(locale.getLanguage()));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3145, false);
    }

    public static perturbation.location.PerturbationLocation __L3057;

    public static perturbation.location.PerturbationLocation __L3058;

    public static perturbation.location.PerturbationLocation __L3059;

    public static perturbation.location.PerturbationLocation __L3060;

    public static perturbation.location.PerturbationLocation __L3061;

    public static perturbation.location.PerturbationLocation __L3062;

    public static perturbation.location.PerturbationLocation __L3063;

    public static perturbation.location.PerturbationLocation __L3064;

    public static perturbation.location.PerturbationLocation __L3065;

    public static perturbation.location.PerturbationLocation __L3066;

    public static perturbation.location.PerturbationLocation __L3067;

    public static perturbation.location.PerturbationLocation __L3068;

    public static perturbation.location.PerturbationLocation __L3069;

    public static perturbation.location.PerturbationLocation __L3070;

    public static perturbation.location.PerturbationLocation __L3071;

    public static perturbation.location.PerturbationLocation __L3072;

    public static perturbation.location.PerturbationLocation __L3073;

    public static perturbation.location.PerturbationLocation __L3074;

    public static perturbation.location.PerturbationLocation __L3075;

    public static perturbation.location.PerturbationLocation __L3076;

    public static perturbation.location.PerturbationLocation __L3077;

    public static perturbation.location.PerturbationLocation __L3078;

    public static perturbation.location.PerturbationLocation __L3079;

    public static perturbation.location.PerturbationLocation __L3080;

    public static perturbation.location.PerturbationLocation __L3081;

    public static perturbation.location.PerturbationLocation __L3082;

    public static perturbation.location.PerturbationLocation __L3083;

    public static perturbation.location.PerturbationLocation __L3084;

    public static perturbation.location.PerturbationLocation __L3085;

    public static perturbation.location.PerturbationLocation __L3086;

    public static perturbation.location.PerturbationLocation __L3087;

    public static perturbation.location.PerturbationLocation __L3088;

    public static perturbation.location.PerturbationLocation __L3089;

    public static perturbation.location.PerturbationLocation __L3090;

    public static perturbation.location.PerturbationLocation __L3091;

    public static perturbation.location.PerturbationLocation __L3092;

    public static perturbation.location.PerturbationLocation __L3093;

    public static perturbation.location.PerturbationLocation __L3094;

    public static perturbation.location.PerturbationLocation __L3095;

    public static perturbation.location.PerturbationLocation __L3096;

    public static perturbation.location.PerturbationLocation __L3097;

    public static perturbation.location.PerturbationLocation __L3098;

    public static perturbation.location.PerturbationLocation __L3099;

    public static perturbation.location.PerturbationLocation __L3100;

    public static perturbation.location.PerturbationLocation __L3101;

    public static perturbation.location.PerturbationLocation __L3102;

    public static perturbation.location.PerturbationLocation __L3103;

    public static perturbation.location.PerturbationLocation __L3104;

    public static perturbation.location.PerturbationLocation __L3105;

    public static perturbation.location.PerturbationLocation __L3106;

    public static perturbation.location.PerturbationLocation __L3107;

    public static perturbation.location.PerturbationLocation __L3108;

    public static perturbation.location.PerturbationLocation __L3109;

    public static perturbation.location.PerturbationLocation __L3110;

    public static perturbation.location.PerturbationLocation __L3111;

    public static perturbation.location.PerturbationLocation __L3112;

    public static perturbation.location.PerturbationLocation __L3113;

    public static perturbation.location.PerturbationLocation __L3114;

    public static perturbation.location.PerturbationLocation __L3115;

    public static perturbation.location.PerturbationLocation __L3116;

    public static perturbation.location.PerturbationLocation __L3117;

    public static perturbation.location.PerturbationLocation __L3118;

    public static perturbation.location.PerturbationLocation __L3119;

    public static perturbation.location.PerturbationLocation __L3120;

    public static perturbation.location.PerturbationLocation __L3121;

    public static perturbation.location.PerturbationLocation __L3122;

    public static perturbation.location.PerturbationLocation __L3123;

    public static perturbation.location.PerturbationLocation __L3124;

    public static perturbation.location.PerturbationLocation __L3125;

    public static perturbation.location.PerturbationLocation __L3126;

    public static perturbation.location.PerturbationLocation __L3127;

    public static perturbation.location.PerturbationLocation __L3128;

    public static perturbation.location.PerturbationLocation __L3129;

    public static perturbation.location.PerturbationLocation __L3130;

    public static perturbation.location.PerturbationLocation __L3131;

    public static perturbation.location.PerturbationLocation __L3132;

    public static perturbation.location.PerturbationLocation __L3133;

    public static perturbation.location.PerturbationLocation __L3134;

    public static perturbation.location.PerturbationLocation __L3135;

    public static perturbation.location.PerturbationLocation __L3136;

    public static perturbation.location.PerturbationLocation __L3137;

    public static perturbation.location.PerturbationLocation __L3138;

    public static perturbation.location.PerturbationLocation __L3139;

    public static perturbation.location.PerturbationLocation __L3140;

    public static perturbation.location.PerturbationLocation __L3141;

    public static perturbation.location.PerturbationLocation __L3142;

    public static perturbation.location.PerturbationLocation __L3143;

    public static perturbation.location.PerturbationLocation __L3144;

    public static perturbation.location.PerturbationLocation __L3145;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:111)", 3057, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:135)", 3058, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:135)", 3059, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:135)", 3060, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:164)", 3061, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:177)", 3062, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:181)", 3063, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:183)", 3064, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:191)", 3065, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:192)", 3066, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:194)", 3067, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:198)", 3068, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:198)", 3069, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:198)", 3070, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:198)", 3071, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:198)", 3072, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:201)", 3073, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:213)", 3074, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3075 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:215)", 3075, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:219)", 3076, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:237)", 3077, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:238)", 3078, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:248)", 3079, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:254)", 3080, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:258)", 3081, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:259)", 3082, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:260)", 3083, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:262)", 3084, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:271)", 3085, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:272)", 3086, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:273)", 3087, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:276)", 3088, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:276)", 3089, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:276)", 3090, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:276)", 3091, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:280)", 3092, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:287)", 3093, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:287)", 3094, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:287)", 3095, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:287)", 3096, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:291)", 3097, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:296)", 3098, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:299)", 3099, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:306)", 3100, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:313)", 3101, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:313)", 3102, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:326)", 3103, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:328)", 3104, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:328)", 3105, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:334)", 3106, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:337)", 3107, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:345)", 3108, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:355)", 3109, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:359)", 3110, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:359)", 3111, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:359)", 3112, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:370)", 3113, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:396)", 3114, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:399)", 3115, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:410)", 3116, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:413)", 3117, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:422)", 3118, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:423)", 3119, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:426)", 3120, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:426)", 3121, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:432)", 3122, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:437)", 3123, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:438)", 3124, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:441)", 3125, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:441)", 3126, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:447)", 3127, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3128, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3129, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3130, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3131, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3132, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3133, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:454)", 3134, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:480)", 3135, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:480)", 3136, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:480)", 3137, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:482)", 3138, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:483)", 3139, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:487)", 3140, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:498)", 3141, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:498)", 3142, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:498)", 3143, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:499)", 3144, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.__L3145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationServiceImpl.java:501)", 3145, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.service.TranslationServiceImpl.initPerturbationLocation0();
    }
}

