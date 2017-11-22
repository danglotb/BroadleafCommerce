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


@org.springframework.stereotype.Component("blResourceBundleProcessor")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class ResourceBundleProcessor extends org.broadleafcommerce.presentation.dialect.AbstractBroadleafTagReplacementProcessor {
    @javax.annotation.Resource(name = "blResourceBundlingService")
    protected org.broadleafcommerce.common.resource.service.ResourceBundlingService bundlingService;

    protected boolean getBundleEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7424, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("bundle.enabled"));
    }

    @java.lang.Override
    public java.lang.String getName() {
        return "bundle";
    }

    @java.lang.Override
    public int getPrecedence() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7425, 10000);
    }

    @java.lang.Override
    public org.broadleafcommerce.presentation.model.BroadleafTemplateModel getReplacementModel(java.lang.String tagName, java.util.Map<java.lang.String, java.lang.String> tagAttributes, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.lang.String name = tagAttributes.get("name");
        java.lang.String mappingPrefix = tagAttributes.get("mapping-prefix");
        boolean async = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7426, tagAttributes.containsKey("async"));
        boolean defer = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7427, tagAttributes.containsKey("defer"));
        java.util.List<java.lang.String> files = new java.util.ArrayList<>();
        for (java.lang.String file : tagAttributes.get("files").split(",")) {
            files.add(file.trim());
        }
        java.util.List<java.lang.String> additionalBundleFiles = bundlingService.getAdditionalBundleFiles(name);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7428, (additionalBundleFiles != null))) {
            files.addAll(additionalBundleFiles);
        }
        org.broadleafcommerce.presentation.model.BroadleafTemplateModel model = context.createModel();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7429, getBundleEnabled())) {
            java.lang.String bundleResourceName = bundlingService.resolveBundleResourceName(name, mappingPrefix, files);
            java.lang.String bundleUrl = getBundleUrl(bundleResourceName, context);
            addElementToModel(bundleUrl, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7430, async), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7431, defer), context, model);
        }else {
            for (java.lang.String fileName : files) {
                fileName = fileName.trim();
                java.lang.String fullFileName = ((java.lang.String) (context.parseExpression(((("@{'" + mappingPrefix) + fileName) + "'}"))));
                addElementToModel(fullFileName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7432, async), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7433, defer), context, model);
            }
        }
        return model;
    }

    protected java.lang.String getBundleUrl(java.lang.String bundleName, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context) {
        java.lang.String bundleUrl = bundleName;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7435, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7434, org.apache.commons.lang3.StringUtils.startsWith(bundleUrl, "/")))))) {
            bundleUrl = "/" + bundleUrl;
        }
        javax.servlet.http.HttpServletRequest request = context.getRequest();
        java.lang.String contextPath = "";
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7436, (request != null))) {
            contextPath = request.getContextPath();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7437, org.apache.commons.lang3.StringUtils.isNotEmpty(contextPath))) {
            bundleUrl = contextPath + bundleUrl;
        }
        return bundleUrl;
    }

    protected void addElementToModel(java.lang.String src, boolean async, boolean defer, org.broadleafcommerce.presentation.model.BroadleafTemplateContext context, org.broadleafcommerce.presentation.model.BroadleafTemplateModel model) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7438, src.contains(";"))) {
            src = src.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7439, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7440, src.indexOf(';')));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7441, src.endsWith(".js"))) {
            model.addElement(context.createNonVoidElement("script", getScriptAttributes(src, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7442, async), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7443, defer)), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7444, true)));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7445, src.endsWith(".css"))) {
                model.addElement(context.createNonVoidElement("link", getLinkAttributes(src), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7446, true)));
            }else {
                throw new java.lang.IllegalArgumentException((("Unknown extension for: " + src) + " - only .js and .css are supported"));
            }

    }

    protected java.util.Map<java.lang.String, java.lang.String> getScriptAttributes(java.lang.String src, boolean async, boolean defer) {
        java.util.Map<java.lang.String, java.lang.String> attributes = new java.util.HashMap<>();
        attributes.put("type", "text/javascript");
        attributes.put("src", src);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7447, async)) {
            attributes.put("async", null);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7448, defer)) {
            attributes.put("defer", null);
        }
        return attributes;
    }

    protected java.util.Map<java.lang.String, java.lang.String> getLinkAttributes(java.lang.String src) {
        java.util.Map<java.lang.String, java.lang.String> attributes = new java.util.HashMap<>();
        attributes.put("rel", "stylesheet");
        attributes.put("href", src);
        return attributes;
    }

    public static perturbation.location.PerturbationLocation __L7424;

    public static perturbation.location.PerturbationLocation __L7425;

    public static perturbation.location.PerturbationLocation __L7426;

    public static perturbation.location.PerturbationLocation __L7427;

    public static perturbation.location.PerturbationLocation __L7428;

    public static perturbation.location.PerturbationLocation __L7429;

    public static perturbation.location.PerturbationLocation __L7430;

    public static perturbation.location.PerturbationLocation __L7431;

    public static perturbation.location.PerturbationLocation __L7432;

    public static perturbation.location.PerturbationLocation __L7433;

    public static perturbation.location.PerturbationLocation __L7434;

    public static perturbation.location.PerturbationLocation __L7435;

    public static perturbation.location.PerturbationLocation __L7436;

    public static perturbation.location.PerturbationLocation __L7437;

    public static perturbation.location.PerturbationLocation __L7438;

    public static perturbation.location.PerturbationLocation __L7439;

    public static perturbation.location.PerturbationLocation __L7440;

    public static perturbation.location.PerturbationLocation __L7441;

    public static perturbation.location.PerturbationLocation __L7442;

    public static perturbation.location.PerturbationLocation __L7443;

    public static perturbation.location.PerturbationLocation __L7444;

    public static perturbation.location.PerturbationLocation __L7445;

    public static perturbation.location.PerturbationLocation __L7446;

    public static perturbation.location.PerturbationLocation __L7447;

    public static perturbation.location.PerturbationLocation __L7448;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:130)", 7424, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:140)", 7425, "Numerical");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:147)", 7426, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:148)", 7427, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:155)", 7428, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:159)", 7429, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:163)", 7430, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:163)", 7431, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:168)", 7432, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:168)", 7433, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:188)", 7434, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:188)", 7435, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:194)", 7436, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:197)", 7437, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:205)", 7438, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:206)", 7439, "Numerical");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:206)", 7440, "Numerical");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:209)", 7441, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:210)", 7442, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:210)", 7443, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:210)", 7444, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:211)", 7445, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:212)", 7446, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:222)", 7447, "Boolean");
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.__L7448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/processor/ResourceBundleProcessor.java:225)", 7448, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.processor.ResourceBundleProcessor.initPerturbationLocation0();
    }
}

