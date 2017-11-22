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


public interface PaymentGatewayConfiguration {
    public boolean isPerformAuthorizeAndCapture();

    public void setPerformAuthorizeAndCapture(boolean performAuthorizeAndCapture);

    public int getFailureReportingThreshold();

    public void setFailureReportingThreshold(int failureReportingThreshold);

    public boolean handlesAuthorize();

    public boolean handlesCapture();

    public boolean handlesAuthorizeAndCapture();

    public boolean handlesReverseAuthorize();

    public boolean handlesVoid();

    public boolean handlesRefund();

    public boolean handlesPartialCapture();

    public boolean handlesMultipleShipment();

    public boolean handlesRecurringPayment();

    public boolean handlesSavedCustomerPayment();

    public boolean handlesMultiplePayments();

    public org.broadleafcommerce.common.payment.PaymentGatewayType getGatewayType();
}

