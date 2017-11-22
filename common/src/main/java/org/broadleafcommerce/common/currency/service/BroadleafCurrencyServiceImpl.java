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
package org.broadleafcommerce.common.currency.service;


@org.springframework.stereotype.Service("blCurrencyService")
public class BroadleafCurrencyServiceImpl implements org.broadleafcommerce.common.currency.service.BroadleafCurrencyService {
    @javax.annotation.Resource(name = "blCurrencyDao")
    protected org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDao currencyDao;

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency findDefaultBroadleafCurrency() {
        return currencyDao.findDefaultBroadleafCurrency();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency findCurrencyByCode(java.lang.String currencyCode) {
        return currencyDao.findCurrencyByCode(currencyCode);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.currency.domain.BroadleafCurrency> getAllCurrencies() {
        return currencyDao.getAllCurrencies();
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(org.broadleafcommerce.common.util.TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency save(org.broadleafcommerce.common.currency.domain.BroadleafCurrency currency) {
        return currencyDao.save(currency);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency create() {
        return currencyDao.create();
    }
}

