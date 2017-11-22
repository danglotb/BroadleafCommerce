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


@org.springframework.stereotype.Service("blISOService")
public class ISOServiceImpl implements org.broadleafcommerce.common.i18n.service.ISOService {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.i18n.service.ISOServiceImpl.class);

    @javax.annotation.Resource(name = "blISODao")
    protected org.broadleafcommerce.common.i18n.dao.ISODao isoDao;

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.i18n.domain.ISOCountry> findISOCountries() {
        return isoDao.findISOCountries();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.ISOCountry findISOCountryByAlpha2Code(java.lang.String alpha2) {
        return isoDao.findISOCountryByAlpha2Code(alpha2);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(org.broadleafcommerce.common.util.TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public org.broadleafcommerce.common.i18n.domain.ISOCountry save(org.broadleafcommerce.common.i18n.domain.ISOCountry isoCountry) {
        return isoDao.save(isoCountry);
    }
}

