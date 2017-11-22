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


public class FilterDefinition {
    protected java.lang.String name;

    protected java.util.List<org.broadleafcommerce.common.filter.FilterParameter> params = new java.util.ArrayList<org.broadleafcommerce.common.filter.FilterParameter>();

    protected java.lang.String entityImplementationClassName;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.util.List<org.broadleafcommerce.common.filter.FilterParameter> getParams() {
        return params;
    }

    public void setParams(java.util.List<org.broadleafcommerce.common.filter.FilterParameter> params) {
        this.params = params;
    }

    public java.lang.String getEntityImplementationClassName() {
        return entityImplementationClassName;
    }

    public void setEntityImplementationClassName(java.lang.String entityImplementationClassName) {
        this.entityImplementationClassName = entityImplementationClassName;
    }

    public org.broadleafcommerce.common.filter.FilterDefinition copy() {
        org.broadleafcommerce.common.filter.FilterDefinition copy = new org.broadleafcommerce.common.filter.FilterDefinition();
        copy.setName(name);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.filter.FilterDefinition.__L2736, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.filter.FilterDefinition.__L2735, org.apache.commons.collections.CollectionUtils.isEmpty(params)))))) {
            copy.getParams().addAll(params);
        }
        copy.setEntityImplementationClassName(entityImplementationClassName);
        return copy;
    }

    public static perturbation.location.PerturbationLocation __L2735;

    public static perturbation.location.PerturbationLocation __L2736;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.filter.FilterDefinition.__L2735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/filter/FilterDefinition.java:63)", 2735, "Boolean");
        org.broadleafcommerce.common.filter.FilterDefinition.__L2736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/filter/FilterDefinition.java:63)", 2736, "Boolean");
    }

    static {
        org.broadleafcommerce.common.filter.FilterDefinition.initPerturbationLocation0();
    }
}

