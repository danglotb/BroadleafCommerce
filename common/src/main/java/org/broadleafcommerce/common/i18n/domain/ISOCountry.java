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


public interface ISOCountry extends java.io.Serializable {
    public java.lang.String getAlpha2();

    public void setAlpha2(java.lang.String alpha2);

    public java.lang.String getName();

    public void setName(java.lang.String name);

    public java.lang.String getAlpha3();

    public void setAlpha3(java.lang.String alpha3);

    public java.lang.Integer getNumericCode();

    public void setNumericCode(java.lang.Integer numericCode);

    public org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType getStatus();

    public void setStatus(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType status);
}

