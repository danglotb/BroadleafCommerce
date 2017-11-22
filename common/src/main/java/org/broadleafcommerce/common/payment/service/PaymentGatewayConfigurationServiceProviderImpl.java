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
package org.broadleafcommerce.common.payment.service;


@org.springframework.stereotype.Service("blPaymentGatewayConfigurationServiceProvider")
public class PaymentGatewayConfigurationServiceProviderImpl implements org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProvider {
    @javax.annotation.Resource(name = "blPaymentGatewayConfigurationServices")
    protected java.util.List<org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService> gatewayConfigurationServices;

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService getGatewayConfigurationService(org.broadleafcommerce.common.payment.PaymentGatewayType gatewayType) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProviderImpl.__L3843, (gatewayType == null))) {
            throw new java.lang.IllegalArgumentException("Gateway type cannot be null");
        }
        for (org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService config : getGatewayConfigurationServices()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProviderImpl.__L3844, config.getConfiguration().getGatewayType().equals(gatewayType))) {
                return config;
            }
        }
        throw new java.lang.IllegalArgumentException(("There is no gateway configured for " + (gatewayType.getFriendlyType())));
    }

    public java.util.List<org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService> getGatewayConfigurationServices() {
        return gatewayConfigurationServices;
    }

    public void setGatewayConfigurationServices(java.util.List<org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService> gatewayConfigurationServices) {
        this.gatewayConfigurationServices = gatewayConfigurationServices;
    }

    public static perturbation.location.PerturbationLocation __L3843;

    public static perturbation.location.PerturbationLocation __L3844;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProviderImpl.__L3843 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayConfigurationServiceProviderImpl.java:40)", 3843, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProviderImpl.__L3844 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayConfigurationServiceProviderImpl.java:44)", 3844, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProviderImpl.initPerturbationLocation0();
    }
}

