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
package org.broadleafcommerce.common.config.domain;


public interface SystemProperty extends java.io.Serializable , org.broadleafcommerce.common.copy.MultiTenantCloneable<org.broadleafcommerce.common.config.domain.SystemProperty> {
    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public java.lang.String getName();

    public void setName(java.lang.String name);

    public java.lang.Boolean getOverrideGeneratedPropertyName();

    public void setOverrideGeneratedPropertyName(java.lang.Boolean overrideGeneratedPropertyName);

    public java.lang.String getValue();

    public void setValue(java.lang.String value);

    public org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType getPropertyType();

    public void setPropertyType(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType type);

    public java.lang.String getFriendlyName();

    public void setFriendlyName(java.lang.String friendlyName);

    public java.lang.String getFriendlyGroup();

    public void setFriendlyGroup(java.lang.String friendlyGroup);

    public java.lang.String getFriendlyTab();

    public void setFriendlyTab(java.lang.String friendlyTab);
}

