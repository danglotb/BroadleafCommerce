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


public interface TranslationSupport {
    org.broadleafcommerce.common.extension.StandardCacheItem lookupTranslationFromMap(java.lang.String key, java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.extension.StandardCacheItem>> propertyTranslationMap, java.lang.String entityId);

    net.sf.ehcache.Cache getCache();

    java.util.List<java.lang.String> getCacheKeyListForTemplateSite(java.lang.String propertyName);

    int getThresholdForFullCache();

    void setThresholdForFullCache(int thresholdForFullCache);

    int getTemplateThresholdForFullCache();

    void setTemplateThresholdForFullCache(int templateThresholdForFullCache);

    org.broadleafcommerce.common.i18n.domain.Translation findBestTemplateTranslation(java.lang.String specificPropertyKey, java.lang.String generalPropertyKey, java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.broadleafcommerce.common.i18n.domain.Translation>> propertyTranslationMap, java.lang.String entityId);

    java.lang.String getCacheKey(org.broadleafcommerce.common.extension.ResultType resultType, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType);
}

