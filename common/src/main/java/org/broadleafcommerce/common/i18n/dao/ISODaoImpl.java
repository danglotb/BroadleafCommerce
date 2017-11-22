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
package org.broadleafcommerce.common.i18n.dao;


@org.springframework.stereotype.Repository("blISODao")
public class ISODaoImpl implements org.broadleafcommerce.common.i18n.dao.ISODao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    public org.broadleafcommerce.common.i18n.domain.ISOCountry findISOCountryByAlpha2Code(java.lang.String alpha2) {
        return ((org.broadleafcommerce.common.i18n.domain.ISOCountry) (em.find(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.class, alpha2)));
    }

    @java.lang.SuppressWarnings("unchecked")
    public java.util.List<org.broadleafcommerce.common.i18n.domain.ISOCountry> findISOCountries() {
        javax.persistence.Query query = em.createNamedQuery("BC_FIND_ISO_COUNTRIES");
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.ISODaoImpl.__L2738, true));
        return query.getResultList();
    }

    public org.broadleafcommerce.common.i18n.domain.ISOCountry save(org.broadleafcommerce.common.i18n.domain.ISOCountry isoCountry) {
        return em.merge(isoCountry);
    }

    public static perturbation.location.PerturbationLocation __L2738;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.dao.ISODaoImpl.__L2738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/ISODaoImpl.java:50)", 2738, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.dao.ISODaoImpl.initPerturbationLocation0();
    }
}

