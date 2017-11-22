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


public class HydrationItemDescriptor {
    private java.lang.String factoryMethod;

    private java.lang.reflect.Method[] mutators;

    public java.lang.String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(java.lang.String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public java.lang.reflect.Method[] getMutators() {
        return mutators;
    }

    public void setMutators(java.lang.reflect.Method[] mutators) {
        this.mutators = mutators;
    }
}

