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


public interface PaymentGatewayConfigurationService {
    public org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration getConfiguration();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionService getTransactionService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionConfirmationService getTransactionConfirmationService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayReportingService getReportingService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayCreditCardService getCreditCardService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayCustomerService getCustomerService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewaySubscriptionService getSubscriptionService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayFraudService getFraudService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayHostedService getHostedService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayRollbackService getRollbackService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService getWebResponseService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayTransparentRedirectService getTransparentRedirectService();

    public org.broadleafcommerce.common.payment.service.PaymentGatewayClientTokenService getClientTokenService();

    public org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionHandler getCreditCardExtensionHandler();

    public org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionHandler getFieldExtensionHandler();

    public org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler getCreditCardTypesExtensionHandler();
}

