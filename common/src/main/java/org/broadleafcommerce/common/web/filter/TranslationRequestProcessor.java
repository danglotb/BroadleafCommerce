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
package org.broadleafcommerce.common.web.filter;


@org.springframework.stereotype.Component("blTranslationRequestProcessor")
public class TranslationRequestProcessor extends org.broadleafcommerce.common.web.AbstractBroadleafWebRequestProcessor {
    @javax.annotation.Resource(name = "blTranslationService")
    protected org.broadleafcommerce.common.i18n.service.TranslationService translationService;

    protected boolean getTranslationEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.TranslationRequestProcessor.__L7247, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("i18n.translation.enabled"));
    }

    @java.lang.Override
    public void process(org.springframework.web.context.request.WebRequest request) {
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.setTranslationConsiderationContext(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.TranslationRequestProcessor.__L7248, getTranslationEnabled()));
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.setTranslationService(translationService);
    }

    public static perturbation.location.PerturbationLocation __L7247;

    public static perturbation.location.PerturbationLocation __L7248;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.TranslationRequestProcessor.__L7247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/TranslationRequestProcessor.java:43)", 7247, "Boolean");
        org.broadleafcommerce.common.web.filter.TranslationRequestProcessor.__L7248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/TranslationRequestProcessor.java:48)", 7248, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.filter.TranslationRequestProcessor.initPerturbationLocation0();
    }
}

