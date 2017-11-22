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
package org.broadleafcommerce.common.payment.dto;


public class CustomerCreditDTO<T> {
    protected T parent;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String customerCreditAccountNum;

    protected java.lang.String customerCreditAccountMasked;

    public CustomerCreditDTO() {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
    }

    public CustomerCreditDTO(T parent) {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

    public org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<T> additionalFields(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<T> customerCreditAccountNum(java.lang.String customerCreditAccountNum) {
        this.customerCreditAccountNum = customerCreditAccountNum;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.CustomerCreditDTO<T> customerCreditAccountMasked(java.lang.String customerCreditAccountMasked) {
        this.customerCreditAccountMasked = customerCreditAccountMasked;
        return this;
    }
}

