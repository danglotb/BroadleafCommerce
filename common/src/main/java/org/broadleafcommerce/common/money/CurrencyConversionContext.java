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
package org.broadleafcommerce.common.money;


public class CurrencyConversionContext {
    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.money.CurrencyConversionService> currencyConversionService = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.money.CurrencyConversionService.class, false);

    private static final java.lang.ThreadLocal<java.util.HashMap> currencyConversionContext = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(java.util.HashMap.class);

    public static java.util.HashMap getCurrencyConversionContext() {
        return org.broadleafcommerce.common.money.CurrencyConversionContext.currencyConversionContext.get();
    }

    public static void setCurrencyConversionContext(java.util.HashMap currencyConsiderationContext) {
        org.broadleafcommerce.common.money.CurrencyConversionContext.currencyConversionContext.set(currencyConsiderationContext);
    }

    public static org.broadleafcommerce.common.money.CurrencyConversionService getCurrencyConversionService() {
        return org.broadleafcommerce.common.money.CurrencyConversionContext.currencyConversionService.get();
    }

    public static void setCurrencyConversionService(org.broadleafcommerce.common.money.CurrencyConversionService currencyDeterminationService) {
        org.broadleafcommerce.common.money.CurrencyConversionContext.currencyConversionService.set(currencyDeterminationService);
    }
}

