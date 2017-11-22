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


public interface TranslationOverrideStrategy extends org.springframework.core.Ordered {
    org.broadleafcommerce.common.i18n.service.LocalePair getLocaleBasedOverride(java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String basicCacheKey);

    org.broadleafcommerce.common.i18n.service.LocalePair getLocaleBasedTemplateValue(java.lang.String templateCacheKey, java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String specificPropertyKey, java.lang.String generalPropertyKey);

    boolean validateTemplateProcessing(java.lang.String standardCacheKey, java.lang.String templateCacheKey);
}

