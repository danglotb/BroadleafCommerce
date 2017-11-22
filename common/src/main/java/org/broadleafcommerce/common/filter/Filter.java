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


public class Filter {
    java.lang.String name;

    java.lang.String condition;

    java.lang.String entityImplementationClassName;

    java.util.List<java.lang.String> indexColumnNames;

    public java.lang.String getCondition() {
        return condition;
    }

    public void setCondition(java.lang.String condition) {
        this.condition = condition;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getEntityImplementationClassName() {
        return entityImplementationClassName;
    }

    public void setEntityImplementationClassName(java.lang.String entityImplementationClassName) {
        this.entityImplementationClassName = entityImplementationClassName;
    }

    public java.util.List<java.lang.String> getIndexColumnNames() {
        return indexColumnNames;
    }

    public void setIndexColumnNames(java.util.List<java.lang.String> indexColumnNames) {
        this.indexColumnNames = indexColumnNames;
    }

    public org.broadleafcommerce.common.filter.Filter copy() {
        org.broadleafcommerce.common.filter.Filter copy = new org.broadleafcommerce.common.filter.Filter();
        copy.setName(name);
        copy.setCondition(condition);
        copy.setEntityImplementationClassName(entityImplementationClassName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.filter.Filter.__L2734, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.filter.Filter.__L2733, org.apache.commons.collections.CollectionUtils.isEmpty(indexColumnNames)))))) {
            copy.setIndexColumnNames(new java.util.ArrayList<java.lang.String>(indexColumnNames));
        }
        return copy;
    }

    public static perturbation.location.PerturbationLocation __L2733;

    public static perturbation.location.PerturbationLocation __L2734;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.filter.Filter.__L2733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/filter/Filter.java:74)", 2733, "Boolean");
        org.broadleafcommerce.common.filter.Filter.__L2734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/filter/Filter.java:74)", 2734, "Boolean");
    }

    static {
        org.broadleafcommerce.common.filter.Filter.initPerturbationLocation0();
    }
}

