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
package org.broadleafcommerce.common.i18n.domain;


public interface Translation extends java.io.Serializable , org.broadleafcommerce.common.copy.MultiTenantCloneable<org.broadleafcommerce.common.i18n.domain.Translation> {
    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public org.broadleafcommerce.common.i18n.domain.TranslatedEntity getEntityType();

    public void setEntityType(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType);

    public java.lang.String getEntityId();

    public void setEntityId(java.lang.String entityId);

    public java.lang.String getFieldName();

    public void setFieldName(java.lang.String fieldName);

    public java.lang.String getLocaleCode();

    public void setLocaleCode(java.lang.String localeCode);

    public java.lang.String getTranslatedValue();

    public void setTranslatedValue(java.lang.String translatedValue);
}

