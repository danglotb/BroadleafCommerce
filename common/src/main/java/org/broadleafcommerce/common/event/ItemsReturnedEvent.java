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
package org.broadleafcommerce.common.event;


public class ItemsReturnedEvent extends org.broadleafcommerce.common.event.BroadleafApplicationEvent {
    private static final long serialVersionUID = 1L;

    protected final java.util.Map<java.lang.Long, java.lang.Integer> itemsAndQuantitiesReturned;

    public ItemsReturnedEvent(java.lang.Long orderId, java.util.Map<java.lang.Long, java.lang.Integer> returnedItems) {
        super(orderId);
        org.springframework.util.Assert.notNull(orderId);
        org.springframework.util.Assert.notEmpty(returnedItems);
        this.itemsAndQuantitiesReturned = java.util.Collections.unmodifiableMap(returnedItems);
    }

    public java.lang.Long getOrderId() {
        return ((java.lang.Long) (super.getSource()));
    }

    public java.util.Map<java.lang.Long, java.lang.Integer> getItemsAndQuantitiesReturned() {
        return itemsAndQuantitiesReturned;
    }
}

