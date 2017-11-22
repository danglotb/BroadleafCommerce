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


public class LineItemDTO {
    protected org.broadleafcommerce.common.payment.dto.PaymentRequestDTO parent;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String name;

    protected java.lang.String description;

    protected java.lang.String shortDescription;

    protected java.lang.String systemId;

    protected java.lang.String category;

    protected java.lang.String quantity;

    protected java.lang.String amount;

    protected java.lang.String tax;

    protected java.lang.String itemTotal;

    protected java.lang.String total;

    public org.broadleafcommerce.common.payment.dto.PaymentRequestDTO done() {
        parent.lineItems.add(this);
        return parent;
    }

    public LineItemDTO(org.broadleafcommerce.common.payment.dto.PaymentRequestDTO parent) {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
        this.parent = parent;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO additionalField(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO name(java.lang.String name) {
        this.name = name;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO description(java.lang.String description) {
        this.description = description;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO shortDescription(java.lang.String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO systemId(java.lang.String systemId) {
        this.systemId = systemId;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO category(java.lang.String category) {
        this.category = category;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO quantity(java.lang.String quantity) {
        this.quantity = quantity;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO amount(java.lang.String amount) {
        this.amount = amount;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO tax(java.lang.String tax) {
        this.tax = tax;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO itemTotal(java.lang.String itemTotal) {
        this.itemTotal = itemTotal;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.LineItemDTO total(java.lang.String total) {
        this.total = total;
        return this;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalFields() {
        return additionalFields;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public java.lang.String getShortDescription() {
        return shortDescription;
    }

    public java.lang.String getSystemId() {
        return systemId;
    }

    public java.lang.String getCategory() {
        return category;
    }

    public java.lang.String getQuantity() {
        return quantity;
    }

    public java.lang.String getAmount() {
        return amount;
    }

    public java.lang.String getTax() {
        return tax;
    }

    public java.lang.String getItemTotal() {
        return itemTotal;
    }

    public java.lang.String getTotal() {
        return total;
    }
}

