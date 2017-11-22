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


public class AbstractPaymentGatewayConfiguration implements org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration {
    @java.lang.Override
    public boolean isPerformAuthorizeAndCapture() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public void setPerformAuthorizeAndCapture(boolean performAuthorizeAndCapture) {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public int getFailureReportingThreshold() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public void setFailureReportingThreshold(int failureReportingThreshold) {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesAuthorize() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesCapture() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesAuthorizeAndCapture() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesReverseAuthorize() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesVoid() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesRefund() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesPartialCapture() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesMultipleShipment() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesRecurringPayment() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesSavedCustomerPayment() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public boolean handlesMultiplePayments() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }

    @java.lang.Override
    public org.broadleafcommerce.common.payment.PaymentGatewayType getGatewayType() {
        throw new java.lang.UnsupportedOperationException("Not Implemented");
    }
}

