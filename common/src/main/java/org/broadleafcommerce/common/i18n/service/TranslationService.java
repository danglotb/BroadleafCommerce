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


public interface TranslationService {
    public org.broadleafcommerce.common.i18n.domain.Translation save(org.broadleafcommerce.common.i18n.domain.Translation translation);

    public org.broadleafcommerce.common.i18n.domain.Translation save(java.lang.String entityType, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode, java.lang.String translatedValue);

    public org.broadleafcommerce.common.i18n.domain.Translation update(java.lang.Long translationId, java.lang.String localeCode, java.lang.String translatedValue);

    public void deleteTranslationById(java.lang.Long translationId);

    public java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> getTranslations(java.lang.String ceilingEntityClassname, java.lang.String entityId, java.lang.String property);

    public org.broadleafcommerce.common.i18n.domain.Translation getTranslation(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entity, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode);

    public java.lang.String getTranslatedValue(java.lang.Object entity, java.lang.String property, java.util.Locale locale);

    void removeTranslationFromCache(org.broadleafcommerce.common.i18n.domain.Translation translation);

    org.broadleafcommerce.common.i18n.domain.Translation findTranslationById(java.lang.Long id);

    net.sf.ehcache.Cache getCache();

    java.lang.String getDefaultTranslationValue(java.lang.Object entity, java.lang.String property, java.util.Locale locale, java.lang.String requestedDefaultValue);

    java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> findAllTranslationEntries(org.broadleafcommerce.common.i18n.domain.TranslatedEntity translatedEntity, org.broadleafcommerce.common.extension.ResultType standard, java.util.List<java.lang.String> entityIds);
}

