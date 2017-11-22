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
package org.broadleafcommerce.common.i18n.service;


public class LocalePair {
    org.broadleafcommerce.common.extension.StandardCacheItem specificItem = null;

    org.broadleafcommerce.common.extension.StandardCacheItem generalItem = null;

    public org.broadleafcommerce.common.extension.StandardCacheItem getSpecificItem() {
        return specificItem;
    }

    public void setSpecificItem(org.broadleafcommerce.common.extension.StandardCacheItem specificItem) {
        this.specificItem = specificItem;
    }

    public org.broadleafcommerce.common.extension.StandardCacheItem getGeneralItem() {
        return generalItem;
    }

    public void setGeneralItem(org.broadleafcommerce.common.extension.StandardCacheItem generalItem) {
        this.generalItem = generalItem;
    }
}

