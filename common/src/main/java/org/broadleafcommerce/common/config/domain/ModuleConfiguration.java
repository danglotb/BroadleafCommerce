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


public interface ModuleConfiguration extends java.io.Serializable {
    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public java.lang.String getModuleName();

    public void setModuleName(java.lang.String name);

    public void setActiveStartDate(java.util.Date startDate);

    public java.util.Date getActiveStartDate();

    public void setActiveEndDate(java.util.Date startDate);

    public java.util.Date getActiveEndDate();

    public void setIsDefault(java.lang.Boolean isDefault);

    public java.lang.Boolean getIsDefault();

    public boolean isDefault();

    public void setPriority(java.lang.Integer priority);

    public java.lang.Integer getPriority();

    public org.broadleafcommerce.common.config.service.type.ModuleConfigurationType getModuleConfigurationType();

    public void setAuditable(org.broadleafcommerce.common.audit.Auditable auditable);

    public org.broadleafcommerce.common.audit.Auditable getAuditable();
}

