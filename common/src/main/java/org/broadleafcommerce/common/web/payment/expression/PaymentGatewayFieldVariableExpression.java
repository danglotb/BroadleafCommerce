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
package org.broadleafcommerce.common.web.payment.expression;


@org.springframework.stereotype.Component("blpaymentGatewayFieldVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class PaymentGatewayFieldVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @javax.annotation.Resource(name = "blPaymentGatewayFieldExtensionManager")
    protected org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionManager extensionManager;

    @java.lang.Override
    public java.lang.String getName() {
        return "paymentGatewayField";
    }

    public java.lang.String mapName(java.lang.String fieldName) {
        java.util.Map<java.lang.String, java.lang.String> fieldNameMap = new java.util.HashMap<>();
        fieldNameMap.put(fieldName, fieldName);
        extensionManager.getProxy().mapFieldName(fieldName, fieldNameMap);
        return fieldNameMap.get(fieldName);
    }

    public org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionManager getExtensionManager() {
        return extensionManager;
    }

    public void setExtensionManager(org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionManager extensionManager) {
        this.extensionManager = extensionManager;
    }
}

