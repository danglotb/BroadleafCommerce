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


public class TranslationConsiderationContext {
    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext> translationConsiderationContext = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.class);

    protected java.lang.Boolean enabled = ((boolean) (false));

    protected org.broadleafcommerce.common.i18n.service.TranslationService service;

    public static org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext getTranslationConsiderationContext() {
        return org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.translationConsiderationContext.get();
    }

    public static boolean hasTranslation() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3053, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3051, (((org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.isTranslationConsiderationContextEnabled()) != null) && (org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.isTranslationConsiderationContextEnabled())))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3052, ((org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.getTranslationService()) != null)))));
    }

    public static java.lang.Boolean isTranslationConsiderationContextEnabled() {
        java.lang.Boolean val = org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.translationConsiderationContext.get().enabled;
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3056, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3054, (val == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3055, false) : val));
    }

    public static void setTranslationConsiderationContext(java.lang.Boolean isEnabled) {
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.translationConsiderationContext.get().enabled = isEnabled;
    }

    public static org.broadleafcommerce.common.i18n.service.TranslationService getTranslationService() {
        return org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.translationConsiderationContext.get().service;
    }

    public static void setTranslationService(org.broadleafcommerce.common.i18n.service.TranslationService translationService) {
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.translationConsiderationContext.get().service = translationService;
    }

    public static void removeTranslationConsiderationContext() {
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.remove(org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.translationConsiderationContext);
    }

    public static perturbation.location.PerturbationLocation __L3051;

    public static perturbation.location.PerturbationLocation __L3052;

    public static perturbation.location.PerturbationLocation __L3053;

    public static perturbation.location.PerturbationLocation __L3054;

    public static perturbation.location.PerturbationLocation __L3055;

    public static perturbation.location.PerturbationLocation __L3056;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationConsiderationContext.java:36)", 3051, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationConsiderationContext.java:37)", 3052, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationConsiderationContext.java:36)", 3053, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationConsiderationContext.java:42)", 3054, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationConsiderationContext.java:42)", 3055, "Boolean");
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.__L3056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/TranslationConsiderationContext.java:42)", 3056, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.service.TranslationConsiderationContext.initPerturbationLocation0();
    }
}

