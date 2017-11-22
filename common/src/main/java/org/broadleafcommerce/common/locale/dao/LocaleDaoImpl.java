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
package org.broadleafcommerce.common.locale.dao;


@org.springframework.stereotype.Repository("blLocaleDao")
public class LocaleDaoImpl implements org.broadleafcommerce.common.locale.dao.LocaleDao {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.class);

    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale findLocaleByCode(java.lang.String localeCode) {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_LOCALE_BY_CODE");
        query.setParameter("localeCode", localeCode);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3276, true));
        java.util.List<org.broadleafcommerce.common.locale.domain.Locale> localeList = ((java.util.List<org.broadleafcommerce.common.locale.domain.Locale>) (query.getResultList()));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3279, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3277, localeList.size())) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3278, 1))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3282, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3280, localeList.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3281, 1))))) {
                org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.LOG.warn((("Locale code " + (org.broadleafcommerce.common.util.StringUtil.sanitize(localeCode))) + " exists for more than one locale"));
            }
            return localeList.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3283, 0));
        }
        return null;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale findDefaultLocale() {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_DEFAULT_LOCALE");
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3284, true));
        java.util.List<org.broadleafcommerce.common.locale.domain.Locale> localeList = ((java.util.List<org.broadleafcommerce.common.locale.domain.Locale>) (query.getResultList()));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3287, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3285, localeList.size())) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3286, 1))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3290, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3288, localeList.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3289, 1))))) {
                org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.LOG.warn("There is more than one default locale configured");
            }
            return localeList.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3291, 0));
        }
        return null;
    }

    public java.util.List<org.broadleafcommerce.common.locale.domain.Locale> findAllLocales() {
        javax.persistence.Query query = em.createNamedQuery("BC_READ_ALL_LOCALES");
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3292, true));
        return ((java.util.List<org.broadleafcommerce.common.locale.domain.Locale>) (query.getResultList()));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.locale.domain.Locale save(org.broadleafcommerce.common.locale.domain.Locale locale) {
        return em.merge(locale);
    }

    public static perturbation.location.PerturbationLocation __L3276;

    public static perturbation.location.PerturbationLocation __L3277;

    public static perturbation.location.PerturbationLocation __L3278;

    public static perturbation.location.PerturbationLocation __L3279;

    public static perturbation.location.PerturbationLocation __L3280;

    public static perturbation.location.PerturbationLocation __L3281;

    public static perturbation.location.PerturbationLocation __L3282;

    public static perturbation.location.PerturbationLocation __L3283;

    public static perturbation.location.PerturbationLocation __L3284;

    public static perturbation.location.PerturbationLocation __L3285;

    public static perturbation.location.PerturbationLocation __L3286;

    public static perturbation.location.PerturbationLocation __L3287;

    public static perturbation.location.PerturbationLocation __L3288;

    public static perturbation.location.PerturbationLocation __L3289;

    public static perturbation.location.PerturbationLocation __L3290;

    public static perturbation.location.PerturbationLocation __L3291;

    public static perturbation.location.PerturbationLocation __L3292;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:53)", 3276, "Boolean");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:55)", 3277, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:55)", 3278, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:55)", 3279, "Boolean");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:56)", 3280, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:56)", 3281, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:56)", 3282, "Boolean");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:59)", 3283, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:72)", 3284, "Boolean");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:74)", 3285, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:74)", 3286, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:74)", 3287, "Boolean");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:75)", 3288, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:75)", 3289, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:75)", 3290, "Boolean");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:78)", 3291, "Numerical");
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.__L3292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/dao/LocaleDaoImpl.java:89)", 3292, "Boolean");
    }

    static {
        org.broadleafcommerce.common.locale.dao.LocaleDaoImpl.initPerturbationLocation0();
    }
}

