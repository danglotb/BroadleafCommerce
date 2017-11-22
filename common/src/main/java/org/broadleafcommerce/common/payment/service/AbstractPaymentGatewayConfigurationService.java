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


public class AbstractPaymentGatewayConfigurationService implements org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService {
    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration getConfiguration() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionService getTransactionService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionConfirmationService getTransactionConfirmationService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayReportingService getReportingService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayCreditCardService getCreditCardService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayCustomerService getCustomerService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewaySubscriptionService getSubscriptionService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayFraudService getFraudService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayHostedService getHostedService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayRollbackService getRollbackService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService getWebResponseService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayTransparentRedirectService getTransparentRedirectService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.service.PaymentGatewayClientTokenService getClientTokenService() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionHandler getCreditCardExtensionHandler() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionHandler getFieldExtensionHandler() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler getCreditCardTypesExtensionHandler() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }
}

