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
package org.broadleafcommerce.common.cache.engine;


public class HydrationDescriptor {
    private java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor> hydratedMutators;

    private java.lang.reflect.Method[] idMutators;

    private java.lang.String cacheRegion;

    public java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor> getHydratedMutators() {
        return hydratedMutators;
    }

    public java.lang.reflect.Method[] getIdMutators() {
        return idMutators;
    }

    public java.lang.String getCacheRegion() {
        return cacheRegion;
    }

    public void setHydratedMutators(java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor> hydratedMutators) {
        this.hydratedMutators = hydratedMutators;
    }

    public void setIdMutators(java.lang.reflect.Method[] idMutators) {
        this.idMutators = idMutators;
    }

    public void setCacheRegion(java.lang.String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }
}

