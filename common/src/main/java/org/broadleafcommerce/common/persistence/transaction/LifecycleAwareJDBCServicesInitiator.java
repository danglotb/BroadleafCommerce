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
package org.broadleafcommerce.common.persistence.transaction;


public class LifecycleAwareJDBCServicesInitiator implements org.hibernate.service.spi.BasicServiceInitiator<org.hibernate.engine.jdbc.spi.JdbcServices> {
    public static final org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServicesInitiator INSTANCE = new org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServicesInitiator();

    @java.lang.Override
    public org.hibernate.engine.jdbc.spi.JdbcServices initiateService(java.util.Map configurationValues, org.hibernate.service.spi.ServiceRegistryImplementor registry) {
        return new org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServices();
    }

    @java.lang.Override
    public java.lang.Class<org.hibernate.engine.jdbc.spi.JdbcServices> getServiceInitiated() {
        return org.hibernate.engine.jdbc.spi.JdbcServices.class;
    }
}

