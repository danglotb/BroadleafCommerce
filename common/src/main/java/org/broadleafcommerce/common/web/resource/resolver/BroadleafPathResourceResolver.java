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
package org.broadleafcommerce.common.web.resource.resolver;


@org.springframework.stereotype.Component("blPathResourceResolver")
public class BroadleafPathResourceResolver extends org.springframework.web.servlet.resource.PathResourceResolver implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver.class);

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceResolverOrder.BLC_PATH_RESOURCE_RESOLVER;

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver.__L7505, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver.__L7506, order);
    }

    public static perturbation.location.PerturbationLocation __L7505;

    public static perturbation.location.PerturbationLocation __L7506;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver.__L7505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafPathResourceResolver.java:41)", 7505, "Numerical");
        org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver.__L7506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/resolver/BroadleafPathResourceResolver.java:45)", 7506, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.resolver.BroadleafPathResourceResolver.initPerturbationLocation0();
    }
}

