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
package org.broadleafcommerce.common.util;


public class BroadleafMergeResourceBundleMessageSource extends org.springframework.context.support.ReloadableResourceBundleMessageSource {
    @javax.annotation.Resource(name = "blBroadleafMergeResourceExtensionManager")
    protected org.broadleafcommerce.common.util.BroadleafMergeResourceExtensionManager extensionManager;

    public BroadleafMergeResourceBundleMessageSource() {
        setDefaultEncoding("UTF-8");
    }

    @javax.annotation.Resource(name = "blMessageSourceBaseNames")
    @java.lang.Override
    public void setBasenames(java.lang.String... basenames) {
        org.apache.commons.collections.CollectionUtils.reverseArray(basenames);
        super.setBasenames(basenames);
    }

    @java.lang.Override
    protected java.text.MessageFormat resolveCode(java.lang.String code, java.util.Locale locale) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> messageHolder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<>();
        extensionManager.getProxy().resolveMessageSource(code, locale, messageHolder);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource.__L6229, org.apache.commons.lang.StringUtils.isNotBlank(messageHolder.getResult()))) {
            return createMessageFormat(messageHolder.getResult(), locale);
        }
        return super.resolveCode(code, locale);
    }

    @java.lang.Override
    protected java.lang.String resolveCodeWithoutArguments(java.lang.String code, java.util.Locale locale) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> messageHolder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<>();
        extensionManager.getProxy().resolveMessageSource(code, locale, messageHolder);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource.__L6230, org.apache.commons.lang.StringUtils.isNotBlank(messageHolder.getResult()))) {
            return messageHolder.getResult();
        }
        return super.resolveCodeWithoutArguments(code, locale);
    }

    public static perturbation.location.PerturbationLocation __L6229;

    public static perturbation.location.PerturbationLocation __L6230;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource.__L6229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BroadleafMergeResourceBundleMessageSource.java:86)", 6229, "Boolean");
        org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource.__L6230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BroadleafMergeResourceBundleMessageSource.java:97)", 6230, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource.initPerturbationLocation0();
    }
}

