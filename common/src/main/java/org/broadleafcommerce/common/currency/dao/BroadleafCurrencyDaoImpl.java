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
package org.broadleafcommerce.common.currency.dao;


@org.springframework.stereotype.Repository("blCurrencyDao")
public class BroadleafCurrencyDaoImpl implements org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency findDefaultBroadleafCurrency() {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_DEFAULT_CURRENCY");
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L666, true));
        java.util.List<org.broadleafcommerce.common.currency.domain.BroadleafCurrency> currencyList = query.getResultList();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L669, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L667, currencyList.size())) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L668, 1))))) {
            return currencyList.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L670, 0));
        }
        return null;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency findCurrencyByCode(java.lang.String currencyCode) {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_CURRENCY_BY_CODE");
        query.setParameter("currencyCode", currencyCode);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L671, true));
        java.util.List<org.broadleafcommerce.common.currency.domain.BroadleafCurrency> currencyList = query.getResultList();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L674, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L672, currencyList.size())) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L673, 1))))) {
            return currencyList.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L675, 0));
        }
        return null;
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.currency.domain.BroadleafCurrency> getAllCurrencies() {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_ALL_CURRENCIES");
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L676, true));
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency save(org.broadleafcommerce.common.currency.domain.BroadleafCurrency currency) {
        return em.merge(currency);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency create() {
        return entityConfiguration.createEntityInstance(org.broadleafcommerce.common.currency.domain.BroadleafCurrency.class.getName(), org.broadleafcommerce.common.currency.domain.BroadleafCurrency.class);
    }

    public static perturbation.location.PerturbationLocation __L666;

    public static perturbation.location.PerturbationLocation __L667;

    public static perturbation.location.PerturbationLocation __L668;

    public static perturbation.location.PerturbationLocation __L669;

    public static perturbation.location.PerturbationLocation __L670;

    public static perturbation.location.PerturbationLocation __L671;

    public static perturbation.location.PerturbationLocation __L672;

    public static perturbation.location.PerturbationLocation __L673;

    public static perturbation.location.PerturbationLocation __L674;

    public static perturbation.location.PerturbationLocation __L675;

    public static perturbation.location.PerturbationLocation __L676;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:48)", 666, "Boolean");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:50)", 667, "Numerical");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:50)", 668, "Numerical");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:50)", 669, "Boolean");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:51)", 670, "Numerical");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:63)", 671, "Boolean");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:65)", 672, "Numerical");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:65)", 673, "Numerical");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:65)", 674, "Boolean");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:66)", 675, "Numerical");
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.__L676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/dao/BroadleafCurrencyDaoImpl.java:74)", 676, "Boolean");
    }

    static {
        org.broadleafcommerce.common.currency.dao.BroadleafCurrencyDaoImpl.initPerturbationLocation0();
    }
}

