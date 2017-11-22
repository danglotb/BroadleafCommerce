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


@org.springframework.stereotype.Component("blThresholdCacheTranslationOverrideStrategy")
@org.springframework.context.annotation.Lazy
public class ThresholdCacheTranslationOverrideStrategy implements org.broadleafcommerce.common.i18n.service.TranslationOverrideStrategy {
    @javax.annotation.Resource(name = "blStatisticsService")
    protected org.broadleafcommerce.common.cache.StatisticsService statisticsService;

    @javax.annotation.Resource(name = "blTranslationDao")
    protected org.broadleafcommerce.common.i18n.dao.TranslationDao dao;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.broadleafcommerce.common.i18n.service.TranslationSupport translationSupport;

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.service.LocalePair getLocaleBasedOverride(java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String basicCacheKey) {
        java.lang.String specificPropertyKey = (property + "_") + localeCountryCode;
        java.lang.String generalPropertyKey = (property + "_") + localeCode;
        net.sf.ehcache.Element cacheResult = translationSupport.getCache().get(basicCacheKey);
        net.sf.ehcache.Element result;
        org.broadleafcommerce.common.i18n.service.LocalePair response = new org.broadleafcommerce.common.i18n.service.LocalePair();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3013, (cacheResult == null))) {
            statisticsService.addCacheStat(org.broadleafcommerce.common.cache.CacheStatType.TRANSLATION_CACHE_HIT_RATE.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3014, false));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3015, ((dao.countTranslationEntries(entityType, org.broadleafcommerce.common.extension.ResultType.STANDARD_CACHE)) < (translationSupport.getThresholdForFullCache())))) {
                java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>> propertyTranslationMap = new java.util.HashMap<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>>();
                java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem> convertedList = dao.readConvertedTranslationEntries(entityType, org.broadleafcommerce.common.extension.ResultType.STANDARD_CACHE);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3017, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3016, org.apache.commons.collections.CollectionUtils.isEmpty(convertedList)))))) {
                    for (org.broadleafcommerce.common.extension.StandardCacheItem standardCache : convertedList) {
                        org.broadleafcommerce.common.i18n.domain.Translation translation = ((org.broadleafcommerce.common.i18n.domain.Translation) (standardCache.getCacheItem()));
                        java.lang.String key = ((translation.getFieldName()) + "_") + (translation.getLocaleCode());
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3019, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3018, propertyTranslationMap.containsKey(key)))))) {
                            propertyTranslationMap.put(key, new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>());
                        }
                        propertyTranslationMap.get(key).put(translation.getEntityId(), standardCache);
                    }
                }
                net.sf.ehcache.Element newElement = new net.sf.ehcache.Element(basicCacheKey, propertyTranslationMap);
                translationSupport.getCache().put(newElement);
                result = newElement;
            }else {
                org.broadleafcommerce.common.i18n.domain.Translation translation = dao.readTranslation(entityType, entityId, property, localeCode, localeCountryCode, org.broadleafcommerce.common.extension.ResultType.CATALOG_ONLY);
                buildSingleItemResponse(response, translation);
                return response;
            }
        }else {
            result = cacheResult;
            statisticsService.addCacheStat(org.broadleafcommerce.common.cache.CacheStatType.TRANSLATION_CACHE_HIT_RATE.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3020, true));
        }
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>> propertyTranslationMap = ((java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>>) (result.getObjectValue()));
        org.broadleafcommerce.common.extension.StandardCacheItem specificTranslation = translationSupport.lookupTranslationFromMap(specificPropertyKey, propertyTranslationMap, entityId);
        org.broadleafcommerce.common.extension.StandardCacheItem generalTranslation = translationSupport.lookupTranslationFromMap(generalPropertyKey, propertyTranslationMap, entityId);
        response.setSpecificItem(specificTranslation);
        response.setGeneralItem(generalTranslation);
        return response;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.service.LocalePair getLocaleBasedTemplateValue(java.lang.String templateCacheKey, java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String specificPropertyKey, java.lang.String generalPropertyKey) {
        net.sf.ehcache.Element cacheResult = translationSupport.getCache().get(templateCacheKey);
        org.broadleafcommerce.common.i18n.service.LocalePair response = new org.broadleafcommerce.common.i18n.service.LocalePair();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3021, (cacheResult == null))) {
            statisticsService.addCacheStat(org.broadleafcommerce.common.cache.CacheStatType.TRANSLATION_CACHE_HIT_RATE.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3022, false));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3023, ((dao.countTranslationEntries(entityType, org.broadleafcommerce.common.extension.ResultType.TEMPLATE_CACHE)) < (translationSupport.getTemplateThresholdForFullCache())))) {
                java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>> propertyTranslationMap = new java.util.HashMap<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>>();
                java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> translationList = dao.readAllTranslationEntries(entityType, org.broadleafcommerce.common.extension.ResultType.TEMPLATE_CACHE);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3025, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3024, org.apache.commons.collections.CollectionUtils.isEmpty(translationList)))))) {
                    for (org.broadleafcommerce.common.i18n.domain.Translation translation : translationList) {
                        java.lang.String key = ((translation.getFieldName()) + "_") + (translation.getLocaleCode());
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3027, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3026, propertyTranslationMap.containsKey(key)))))) {
                            propertyTranslationMap.put(key, new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>());
                        }
                        propertyTranslationMap.get(key).put(translation.getEntityId(), translation);
                    }
                }
                translationSupport.getCache().put(new net.sf.ehcache.Element(templateCacheKey, propertyTranslationMap));
                org.broadleafcommerce.common.i18n.domain.Translation translation = translationSupport.findBestTemplateTranslation(specificPropertyKey, generalPropertyKey, propertyTranslationMap, entityId);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3028, (translation != null))) {
                    buildSingleItemResponse(response, translation);
                }
            }else {
                org.broadleafcommerce.common.i18n.domain.Translation translation = dao.readTranslation(entityType, entityId, property, localeCode, localeCountryCode, org.broadleafcommerce.common.extension.ResultType.TEMPLATE);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3029, (translation != null))) {
                    buildSingleItemResponse(response, translation);
                }
            }
        }else {
            statisticsService.addCacheStat(org.broadleafcommerce.common.cache.CacheStatType.TRANSLATION_CACHE_HIT_RATE.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3030, true));
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>> propertyTranslationMap = ((java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>>) (cacheResult.getObjectValue()));
            org.broadleafcommerce.common.i18n.domain.Translation bestTranslation = translationSupport.findBestTemplateTranslation(specificPropertyKey, generalPropertyKey, propertyTranslationMap, entityId);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3031, (bestTranslation != null))) {
                buildSingleItemResponse(response, bestTranslation);
            }
        }
        return response;
    }

    @java.lang.Override
    public boolean validateTemplateProcessing(java.lang.String standardCacheKey, java.lang.String templateCacheKey) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3033, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3032, standardCacheKey.equals(templateCacheKey)))));
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3034, 0);
    }

    protected void buildSingleItemResponse(org.broadleafcommerce.common.i18n.service.LocalePair response, org.broadleafcommerce.common.i18n.domain.Translation translation) {
        org.broadleafcommerce.common.extension.StandardCacheItem cacheItem = new org.broadleafcommerce.common.extension.StandardCacheItem();
        cacheItem.setItemStatus(org.broadleafcommerce.common.extension.ItemStatus.NORMAL);
        cacheItem.setCacheItem((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3035, (translation == null)) ? "" : translation));
        response.setSpecificItem(cacheItem);
    }

    public static perturbation.location.PerturbationLocation __L3013;

    public static perturbation.location.PerturbationLocation __L3014;

    public static perturbation.location.PerturbationLocation __L3015;

    public static perturbation.location.PerturbationLocation __L3016;

    public static perturbation.location.PerturbationLocation __L3017;

    public static perturbation.location.PerturbationLocation __L3018;

    public static perturbation.location.PerturbationLocation __L3019;

    public static perturbation.location.PerturbationLocation __L3020;

    public static perturbation.location.PerturbationLocation __L3021;

    public static perturbation.location.PerturbationLocation __L3022;

    public static perturbation.location.PerturbationLocation __L3023;

    public static perturbation.location.PerturbationLocation __L3024;

    public static perturbation.location.PerturbationLocation __L3025;

    public static perturbation.location.PerturbationLocation __L3026;

    public static perturbation.location.PerturbationLocation __L3027;

    public static perturbation.location.PerturbationLocation __L3028;

    public static perturbation.location.PerturbationLocation __L3029;

    public static perturbation.location.PerturbationLocation __L3030;

    public static perturbation.location.PerturbationLocation __L3031;

    public static perturbation.location.PerturbationLocation __L3032;

    public static perturbation.location.PerturbationLocation __L3033;

    public static perturbation.location.PerturbationLocation __L3034;

    public static perturbation.location.PerturbationLocation __L3035;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:79)", 3013, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:80)", 3014, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:81)", 3015, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:84)", 3016, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:84)", 3017, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:88)", 3018, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:88)", 3019, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:107)", 3020, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:125)", 3021, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:126)", 3022, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:127)", 3023, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:130)", 3024, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:130)", 3025, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:133)", 3026, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:133)", 3027, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:141)", 3028, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:146)", 3029, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:151)", 3030, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:154)", 3031, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:163)", 3032, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:163)", 3033, "Boolean");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:168)", 3034, "Numerical");
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.__L3035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/ThresholdCacheTranslationOverrideStrategy.java:174)", 3035, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.service.ThresholdCacheTranslationOverrideStrategy.initPerturbationLocation0();
    }
}

