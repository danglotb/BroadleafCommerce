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
package org.broadleafcommerce.common.web.processor;


@org.springframework.stereotype.Component("blFormProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class FormProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafModelModifierProcessor {
    @javax.annotation.Resource(name = "blExploitProtectionService")
    protected org.broadleafcommerce.common.security.service.ExploitProtectionService eps;

    @javax.annotation.Resource(name = "blStaleStateProtectionService")
    protected org.broadleafcommerce.common.security.service.StaleStateProtectionService spps;

    @java.lang.Override
    public java.lang.String getName() {
        return "form";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.processor.FormProcessor.__L7414, 1001);
    }

    @java.lang.Override
    public org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO getInjectedModelAndTagAttributes(java.lang.String rootTagName, java.util.Map<java.lang.String, java.lang.String> rootTagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.util.Map<java.lang.String, java.lang.String> formAttributes = new java.util.HashMap<>();
        formAttributes.putAll(rootTagAttributes);
        org.broadleafcommerce.presentation.model.BroadleafTemplateModel model = context.createModel();
        org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO dto = new org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7416, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7415, "GET".equalsIgnoreCase(formAttributes.get("method"))))))) {
            try {
                java.lang.String csrfToken = eps.getCSRFToken();
                java.lang.String stateVersionToken = null;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7417, spps.isEnabled())) {
                    stateVersionToken = spps.getStateVersionToken();
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7418, "multipart/form-data".equalsIgnoreCase(formAttributes.get("enctype")))) {
                    java.lang.String csrfQueryParameter = (("?" + (eps.getCsrfTokenParameter())) + "=") + csrfToken;
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7419, (stateVersionToken != null))) {
                        csrfQueryParameter += (("&" + (spps.getStateVersionTokenParameter())) + "=") + stateVersionToken;
                    }
                    java.lang.String actionValue = formAttributes.get("action");
                    actionValue += csrfQueryParameter;
                    formAttributes.put("action", actionValue);
                }else {
                    java.util.Map<java.lang.String, java.lang.String> csrfAttributes = new java.util.HashMap<>();
                    csrfAttributes.put("type", "hidden");
                    csrfAttributes.put("name", eps.getCsrfTokenParameter());
                    csrfAttributes.put("value", csrfToken);
                    org.broadleafcommerce.presentation.model.BroadleafTemplateElement csrfTag = context.createStandaloneElement("input", csrfAttributes, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7420, true));
                    model.addElement(csrfTag);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7421, (stateVersionToken != null))) {
                        java.util.Map<java.lang.String, java.lang.String> stateVersionAttributes = new java.util.HashMap<>();
                        stateVersionAttributes.put("type", "hidden");
                        stateVersionAttributes.put("name", spps.getStateVersionTokenParameter());
                        stateVersionAttributes.put("value", stateVersionToken);
                        org.broadleafcommerce.presentation.model.BroadleafTemplateElement stateVersionTag = context.createStandaloneElement("input", stateVersionAttributes, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7422, true));
                        model.addElement(stateVersionTag);
                    }
                    dto.setModel(model);
                }
            } catch (org.broadleafcommerce.common.exception.ServiceException e) {
                throw new java.lang.RuntimeException("Could not get a CSRF token for this session", e);
            }
        }
        dto.setFormParameters(formAttributes);
        dto.setReplacementTagName("form");
        return dto;
    }

    @java.lang.Override
    public boolean reprocessModel() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.FormProcessor.__L7423, true);
    }

    public static perturbation.location.PerturbationLocation __L7414;

    public static perturbation.location.PerturbationLocation __L7415;

    public static perturbation.location.PerturbationLocation __L7416;

    public static perturbation.location.PerturbationLocation __L7417;

    public static perturbation.location.PerturbationLocation __L7418;

    public static perturbation.location.PerturbationLocation __L7419;

    public static perturbation.location.PerturbationLocation __L7420;

    public static perturbation.location.PerturbationLocation __L7421;

    public static perturbation.location.PerturbationLocation __L7422;

    public static perturbation.location.PerturbationLocation __L7423;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:61)", 7414, "Numerical");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:73)", 7415, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:73)", 7416, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:77)", 7417, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:82)", 7418, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:84)", 7419, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:99)", 7420, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:102)", 7421, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:108)", 7422, "Boolean");
        org.broadleafcommerce.common.web.processor.FormProcessor.__L7423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/FormProcessor.java:125)", 7423, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.processor.FormProcessor.initPerturbationLocation0();
    }
}

