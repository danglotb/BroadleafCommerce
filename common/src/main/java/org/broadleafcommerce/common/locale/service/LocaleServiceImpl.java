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
package org.broadleafcommerce.common.locale.service;


@org.springframework.stereotype.Service("blLocaleService")
public class LocaleServiceImpl implements org.broadleafcommerce.common.locale.service.LocaleService {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.locale.service.LocaleServiceImpl.class);

    @javax.annotation.Resource(name = "blLocaleDao")
    protected org.broadleafcommerce.common.locale.dao.LocaleDao localeDao;

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale findLocaleByCode(java.lang.String localeCode) {
        return localeDao.findLocaleByCode(localeCode);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale findDefaultLocale() {
        return localeDao.findDefaultLocale();
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.locale.domain.Locale> findAllLocales() {
        return localeDao.findAllLocales();
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.locale.domain.Locale save(org.broadleafcommerce.common.locale.domain.Locale locale) {
        return localeDao.save(locale);
    }
}

