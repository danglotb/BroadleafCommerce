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
package org.broadleafcommerce.common.enumeration.domain;


public interface DataDrivenEnumerationValue extends java.io.Serializable , org.broadleafcommerce.common.copy.MultiTenantCloneable<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> {
    public java.lang.String getDisplay();

    public void setDisplay(java.lang.String display);

    public java.lang.Boolean getHidden();

    public void setHidden(java.lang.Boolean hidden);

    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public java.lang.String getKey();

    public void setKey(java.lang.String key);

    public org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration getType();

    public void setType(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration type);
}

