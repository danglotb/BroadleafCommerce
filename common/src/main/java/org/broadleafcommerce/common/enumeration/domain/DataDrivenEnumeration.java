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


public interface DataDrivenEnumeration extends java.io.Serializable , org.broadleafcommerce.common.copy.MultiTenantCloneable<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration> {
    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public java.lang.String getKey();

    public void setKey(java.lang.String key);

    public java.lang.Boolean getModifiable();

    public void setModifiable(java.lang.Boolean modifiable);

    public java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> getEnumValues();

    public void setEnumValues(java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> enumValues);

    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> getOrderItems();

    @java.lang.Deprecated
    public void setOrderItems(java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> orderItems);
}

