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


public class TranslationBatchReadCache {
    public static final java.lang.String CACHE_NAME = "blBatchTranslationCache";

    protected static net.sf.ehcache.Cache getCache() {
        return net.sf.ehcache.CacheManager.getInstance().getCache(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.CACHE_NAME);
    }

    protected static java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation> getThreadlocalCache() {
        long threadId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3036, java.lang.Thread.currentThread().getId());
        net.sf.ehcache.Element cacheElement = org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache().get(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3037, threadId));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3038, (cacheElement == null)) ? null : ((java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>) (cacheElement.getObjectValue()));
    }

    public static void clearCache() {
        long threadId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3039, java.lang.Thread.currentThread().getId());
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache().remove(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3040, threadId));
    }

    public static boolean hasCache() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3041, ((org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache()) != null));
    }

    public static void addToCache(java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> translations) {
        long threadId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3042, java.lang.Thread.currentThread().getId());
        java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation> threadlocalCache = org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3043, (threadlocalCache == null))) {
            threadlocalCache = new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>();
        }
        java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation> additionalTranslations = org.broadleafcommerce.common.util.BLCMapUtils.keyedMap(translations, new org.broadleafcommerce.common.util.TypedClosure<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>() {
            @java.lang.Override
            public java.lang.String getKey(org.broadleafcommerce.common.i18n.domain.Translation translation) {
                return org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.buildCacheKey(translation);
            }
        });
        threadlocalCache.putAll(additionalTranslations);
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache().put(new net.sf.ehcache.Element(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3044, threadId), threadlocalCache));
    }

    public static org.broadleafcommerce.common.i18n.domain.Translation getFromCache(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String id, java.lang.String propertyName, java.lang.String localeCode) {
        java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation> threadlocalCache = org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache();
        org.broadleafcommerce.common.i18n.domain.Translation translation = threadlocalCache.get(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.buildCacheKey(entityType, id, propertyName, localeCode));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3047, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3045, (translation == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3046, org.apache.commons.lang.StringUtils.contains(localeCode, '_')))))) {
            java.lang.String languageWithoutCountryCode = localeCode.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3050, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3048, localeCode.indexOf('_'))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3049, 1)))));
            translation = threadlocalCache.get(org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.buildCacheKey(entityType, id, propertyName, languageWithoutCountryCode));
        }
        return translation;
    }

    protected static java.lang.String buildCacheKey(org.broadleafcommerce.common.i18n.domain.Translation translation) {
        return org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.buildCacheKey(translation.getEntityType(), translation.getEntityId(), translation.getFieldName(), translation.getLocaleCode());
    }

    protected static java.lang.String buildCacheKey(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String id, java.lang.String propertyName, java.lang.String localeCode) {
        return org.apache.commons.lang.StringUtils.join(new java.lang.String[]{ entityType.getType(), id, propertyName, localeCode }, "-");
    }

    public static perturbation.location.PerturbationLocation __L3036;

    public static perturbation.location.PerturbationLocation __L3037;

    public static perturbation.location.PerturbationLocation __L3038;

    public static perturbation.location.PerturbationLocation __L3039;

    public static perturbation.location.PerturbationLocation __L3040;

    public static perturbation.location.PerturbationLocation __L3041;

    public static perturbation.location.PerturbationLocation __L3042;

    public static perturbation.location.PerturbationLocation __L3043;

    public static perturbation.location.PerturbationLocation __L3044;

    public static perturbation.location.PerturbationLocation __L3045;

    public static perturbation.location.PerturbationLocation __L3046;

    public static perturbation.location.PerturbationLocation __L3047;

    public static perturbation.location.PerturbationLocation __L3048;

    public static perturbation.location.PerturbationLocation __L3049;

    public static perturbation.location.PerturbationLocation __L3050;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:54)", 3036, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:55)", 3037, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:56)", 3038, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:60)", 3039, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3040 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:61)", 3040, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3041 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:65)", 3041, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3042 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:69)", 3042, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:71)", 3043, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:85)", 3044, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:92)", 3045, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:92)", 3046, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:92)", 3047, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:93)", 3048, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:93)", 3049, "Numerical");
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.__L3050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationBatchReadCache.java:93)", 3050, "Numerical");
    }

    static {
        org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.initPerturbationLocation0();
    }
}

