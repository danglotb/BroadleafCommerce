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
package org.broadleafcommerce.common.web.resource.transformer;


@org.springframework.stereotype.Component("blMinifyResourceTransformer")
public class MinifyResourceTransformer implements org.springframework.core.Ordered , org.springframework.web.servlet.resource.ResourceTransformer {
    @javax.annotation.Resource(name = "blResourceMinificationService")
    protected org.broadleafcommerce.common.resource.service.ResourceMinificationService minifyService;

    private int order = org.broadleafcommerce.common.web.resource.resolver.BroadleafResourceTransformerOrder.BLC_MINIFY_RESOURCE_TRANSFORMER;

    @java.lang.Override
    public org.springframework.core.io.Resource transform(javax.servlet.http.HttpServletRequest request, org.springframework.core.io.Resource resource, org.springframework.web.servlet.resource.ResourceTransformerChain transformerChain) throws java.io.IOException {
        org.springframework.core.io.Resource transformed = transformerChain.transform(request, resource);
        return minifyService.minify(transformed);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.transformer.MinifyResourceTransformer.__L7539, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.transformer.MinifyResourceTransformer.__L7540, order);
    }

    public static perturbation.location.PerturbationLocation __L7539;

    public static perturbation.location.PerturbationLocation __L7540;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.transformer.MinifyResourceTransformer.__L7539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/transformer/MinifyResourceTransformer.java:61)", 7539, "Numerical");
        org.broadleafcommerce.common.web.resource.transformer.MinifyResourceTransformer.__L7540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/transformer/MinifyResourceTransformer.java:65)", 7540, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.transformer.MinifyResourceTransformer.initPerturbationLocation0();
    }
}

