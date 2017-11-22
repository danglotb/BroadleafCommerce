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


public interface CurrentOrderPaymentRequestService {
    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO getPaymentRequestFromCurrentOrder();

    public void addOrderAttributeToCurrentOrder(java.lang.String orderAttributeKey, java.lang.String orderAttributeValue) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public void addOrderAttributeToOrder(java.lang.Long orderId, java.lang.String orderAttributeKey, java.lang.String orderAttributeValue) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public java.lang.String retrieveOrderAttributeFromCurrentOrder(java.lang.String orderAttributeKey);

    public java.lang.String retrieveOrderAttributeFromOrder(java.lang.Long orderId, java.lang.String orderAttributeKey);
}

