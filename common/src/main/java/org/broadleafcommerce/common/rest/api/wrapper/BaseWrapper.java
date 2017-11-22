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
package org.broadleafcommerce.common.rest.api.wrapper;


public abstract class BaseWrapper implements org.springframework.context.ApplicationContextAware {
    @javax.xml.bind.annotation.XmlTransient
    protected org.springframework.context.ApplicationContext context;

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        context = applicationContext;
    }

    protected java.util.List<org.broadleafcommerce.common.rest.api.wrapper.MapElementWrapper> createElementWrappers(org.broadleafcommerce.common.domain.AdditionalFields model) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4617, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4614, ((model.getAdditionalFields()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4616, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4615, model.getAdditionalFields().isEmpty())))))))) {
            java.util.List<org.broadleafcommerce.common.rest.api.wrapper.MapElementWrapper> mapElementWrappers = new java.util.ArrayList<org.broadleafcommerce.common.rest.api.wrapper.MapElementWrapper>();
            for (java.lang.String key : model.getAdditionalFields().keySet()) {
                org.broadleafcommerce.common.rest.api.wrapper.MapElementWrapper mapElementWrapper = new org.broadleafcommerce.common.rest.api.wrapper.MapElementWrapper();
                mapElementWrapper.setKey(key);
                mapElementWrapper.setValue(model.getAdditionalFields().get(key));
                mapElementWrappers.add(mapElementWrapper);
            }
            return mapElementWrappers;
        }
        return null;
    }

    public void transferAdditionalFieldsFromWrapper(org.broadleafcommerce.common.rest.api.wrapper.WrapperAdditionalFields from, org.broadleafcommerce.common.domain.AdditionalFields to) {
        java.util.Map<java.lang.String, java.lang.String> destination = new java.util.HashMap<java.lang.String, java.lang.String>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4618, org.apache.commons.collections4.CollectionUtils.isNotEmpty(from.getAdditionalFields()))) {
            for (org.broadleafcommerce.common.rest.api.wrapper.MapElementWrapper elem : from.getAdditionalFields()) {
                destination.put(elem.key, elem.value);
            }
        }
        to.setAdditionalFields(destination);
    }

    public static perturbation.location.PerturbationLocation __L4614;

    public static perturbation.location.PerturbationLocation __L4615;

    public static perturbation.location.PerturbationLocation __L4616;

    public static perturbation.location.PerturbationLocation __L4617;

    public static perturbation.location.PerturbationLocation __L4618;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rest/api/wrapper/BaseWrapper.java:54)", 4614, "Boolean");
        org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rest/api/wrapper/BaseWrapper.java:54)", 4615, "Boolean");
        org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rest/api/wrapper/BaseWrapper.java:54)", 4616, "Boolean");
        org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rest/api/wrapper/BaseWrapper.java:54)", 4617, "Boolean");
        org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.__L4618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/rest/api/wrapper/BaseWrapper.java:76)", 4618, "Boolean");
    }

    static {
        org.broadleafcommerce.common.rest.api.wrapper.BaseWrapper.initPerturbationLocation0();
    }
}

