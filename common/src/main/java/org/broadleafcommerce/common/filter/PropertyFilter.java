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
package org.broadleafcommerce.common.filter;


public class PropertyFilter extends org.broadleafcommerce.common.filter.Filter {
    protected boolean isJoinTableFilter = false;

    protected java.lang.String propertyName;

    public java.lang.Boolean getJoinTableFilter() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.filter.PropertyFilter.__L2737, isJoinTableFilter);
    }

    public void setJoinTableFilter(java.lang.Boolean joinTableFilter) {
        isJoinTableFilter = ((boolean) (joinTableFilter));
    }

    public java.lang.String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(java.lang.String propertyName) {
        this.propertyName = propertyName;
    }

    public static perturbation.location.PerturbationLocation __L2737;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.filter.PropertyFilter.__L2737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/filter/PropertyFilter.java:29)", 2737, "Boolean");
    }

    static {
        org.broadleafcommerce.common.filter.PropertyFilter.initPerturbationLocation0();
    }
}

