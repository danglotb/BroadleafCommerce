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
package org.broadleafcommerce.common.config;


public class PostAutoConfigurationDefferedImportSelector implements org.springframework.context.annotation.DeferredImportSelector {
    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public java.lang.String[] selectImports(org.springframework.core.type.AnnotationMetadata importingClassMetadata) {
        org.springframework.util.MultiValueMap<java.lang.String, java.lang.Object> attributes = importingClassMetadata.getAllAnnotationAttributes(org.broadleafcommerce.common.config.PostAutoConfigurationImport.class.getName(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.PostAutoConfigurationDefferedImportSelector.__L492, true));
        java.lang.Object importAttributes = attributes.get("value");
        java.util.List<java.lang.String> imports = new java.util.ArrayList<>();
        for (java.lang.String[] classes : ((java.util.List<java.lang.String[]>) (importAttributes))) {
            imports.addAll(java.util.Arrays.asList(classes));
        }
        return imports.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.PostAutoConfigurationDefferedImportSelector.__L493, imports.size())]);
    }

    public static perturbation.location.PerturbationLocation __L492;

    public static perturbation.location.PerturbationLocation __L493;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.PostAutoConfigurationDefferedImportSelector.__L492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/PostAutoConfigurationDefferedImportSelector.java:52)", 492, "Boolean");
        org.broadleafcommerce.common.config.PostAutoConfigurationDefferedImportSelector.__L493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/PostAutoConfigurationDefferedImportSelector.java:58)", 493, "Numerical");
    }

    static {
        org.broadleafcommerce.common.config.PostAutoConfigurationDefferedImportSelector.initPerturbationLocation0();
    }
}

