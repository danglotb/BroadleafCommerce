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
package org.broadleafcommerce.common.extension;


public class StandardCacheItem implements java.io.Serializable {
    private java.lang.String key;

    private java.lang.Object cacheItem;

    private org.broadleafcommerce.common.extension.ItemStatus itemStatus;

    public java.lang.Object getCacheItem() {
        return cacheItem;
    }

    public void setCacheItem(java.lang.Object cacheItem) {
        this.cacheItem = cacheItem;
    }

    public org.broadleafcommerce.common.extension.ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(org.broadleafcommerce.common.extension.ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public java.lang.String getKey() {
        return key;
    }

    public void setKey(java.lang.String key) {
        this.key = key;
    }
}

