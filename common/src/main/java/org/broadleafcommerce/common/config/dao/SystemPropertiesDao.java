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


public interface SystemPropertiesDao {
    public org.broadleafcommerce.common.config.domain.SystemProperty saveSystemProperty(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty);

    public void deleteSystemProperty(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty);

    public java.util.List<org.broadleafcommerce.common.config.domain.SystemProperty> readAllSystemProperties();

    public org.broadleafcommerce.common.config.domain.SystemProperty readSystemPropertyByName(java.lang.String name);

    public org.broadleafcommerce.common.config.domain.SystemProperty createNewSystemProperty();

    public org.broadleafcommerce.common.config.domain.SystemProperty readById(java.lang.Long id);

    public void removeFromCache(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty);
}

