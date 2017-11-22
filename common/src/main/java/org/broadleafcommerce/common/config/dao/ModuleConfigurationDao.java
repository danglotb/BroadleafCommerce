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
package org.broadleafcommerce.common.config.dao;


public interface ModuleConfigurationDao {
    public org.broadleafcommerce.common.config.domain.ModuleConfiguration readById(java.lang.Long id);

    public org.broadleafcommerce.common.config.domain.ModuleConfiguration save(org.broadleafcommerce.common.config.domain.ModuleConfiguration config);

    public void delete(org.broadleafcommerce.common.config.domain.ModuleConfiguration config);

    public java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> readAllByType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType type);

    public java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> readActiveByType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType type);

    public java.util.List<org.broadleafcommerce.common.config.domain.ModuleConfiguration> readByType(java.lang.Class<? extends org.broadleafcommerce.common.config.domain.ModuleConfiguration> type);

    public java.lang.Long getCurrentDateResolution();

    public void setCurrentDateResolution(java.lang.Long currentDateResolution);
}

