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
package org.broadleafcommerce.common.i18n.service;


public class DynamicTranslationProvider {
    public static java.lang.String getValue(java.lang.Object obj, java.lang.String field, final java.lang.String defaultValue) {
        java.lang.String valueToReturn = defaultValue;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.DynamicTranslationProvider.__L2929, org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.hasTranslation())) {
            org.broadleafcommerce.common.i18n.service.TranslationService translationService = org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.getTranslationService();
            java.util.Locale locale = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getJavaLocale();
            java.lang.String translatedValue = translationService.getTranslatedValue(obj, field, locale);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.DynamicTranslationProvider.__L2930, org.apache.commons.lang3.StringUtils.isNotBlank(translatedValue))) {
                valueToReturn = translatedValue;
            }else {
                valueToReturn = translationService.getDefaultTranslationValue(obj, field, locale, defaultValue);
            }
        }
        return valueToReturn;
    }

    public static perturbation.location.PerturbationLocation __L2929;

    public static perturbation.location.PerturbationLocation __L2930;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.DynamicTranslationProvider.__L2929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/DynamicTranslationProvider.java:44)", 2929, "Boolean");
        org.broadleafcommerce.common.i18n.service.DynamicTranslationProvider.__L2930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/DynamicTranslationProvider.java:49)", 2930, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.service.DynamicTranslationProvider.initPerturbationLocation0();
    }
}

