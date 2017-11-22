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


public class CommonServiceIntegrator implements org.hibernate.integrator.spi.ServiceContributingIntegrator {
    @java.lang.Override
    public void prepareServices(org.hibernate.service.ServiceRegistryBuilder serviceRegistryBuilder) {
        serviceRegistryBuilder.addInitiator(org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJDBCServicesInitiator.INSTANCE);
    }

    @java.lang.Override
    public void integrate(org.hibernate.cfg.Configuration configuration, org.hibernate.engine.spi.SessionFactoryImplementor sessionFactory, org.hibernate.service.spi.SessionFactoryServiceRegistry serviceRegistry) {
    }

    @java.lang.Override
    public void integrate(org.hibernate.metamodel.source.MetadataImplementor metadata, org.hibernate.engine.spi.SessionFactoryImplementor sessionFactory, org.hibernate.service.spi.SessionFactoryServiceRegistry serviceRegistry) {
    }

    @java.lang.Override
    public void disintegrate(org.hibernate.engine.spi.SessionFactoryImplementor sessionFactory, org.hibernate.service.spi.SessionFactoryServiceRegistry serviceRegistry) {
    }
}

