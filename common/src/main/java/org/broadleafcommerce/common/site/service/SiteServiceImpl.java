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
package org.broadleafcommerce.common.site.service;


@org.springframework.stereotype.Service("blSiteService")
public class SiteServiceImpl implements org.broadleafcommerce.common.site.service.SiteService {
    @javax.annotation.Resource(name = "blStreamingTransactionCapableUtil")
    protected org.broadleafcommerce.common.util.StreamingTransactionCapableUtil transUtil;

    @javax.annotation.Resource(name = "blSiteDao")
    protected org.broadleafcommerce.common.site.dao.SiteDao siteDao;

    @javax.annotation.Resource(name = "blSiteServiceExtensionManager")
    protected org.broadleafcommerce.common.site.service.SiteServiceExtensionManager extensionManager;

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site createSite() {
        return siteDao.create();
    }

    @java.lang.Override
    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site retrieveSiteById(final java.lang.Long id) {
        return retrieveNonPersistentSiteById(id);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentSiteById(final java.lang.Long id) {
        return retrieveSiteById(id, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5315, false));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrievePersistentSiteById(final java.lang.Long id) {
        return retrieveSiteById(id, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5316, true));
    }

    protected org.broadleafcommerce.common.site.domain.Site retrieveSiteById(final java.lang.Long id, final boolean persistentResult) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5317, (id == null))) {
            return null;
        }
        final org.broadleafcommerce.common.site.domain.Site[] response = new org.broadleafcommerce.common.site.domain.Site[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5318, 1)];
        transUtil.runOptionalEntityManagerInViewOperation(new java.lang.Runnable() {
            @java.lang.Override
            public void run() {
                org.broadleafcommerce.common.site.domain.Site site = siteDao.retrieve(id);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5319, persistentResult)) {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5320, 0)] = site;
                }else {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5321, 0)] = getNonPersistentSite(site);
                }
            }
        });
        return response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5322, 0)];
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentSiteByIdentifer(java.lang.String identifier) {
        return retrieveSiteByIdentifier(identifier, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5323, false));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrievePersistentSiteByIdentifier(java.lang.String identifier) {
        return retrieveSiteByIdentifier(identifier, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5324, true));
    }

    protected org.broadleafcommerce.common.site.domain.Site retrieveSiteByIdentifier(final java.lang.String identifier, final boolean persistentResult) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5325, (identifier == null))) {
            return null;
        }
        final org.broadleafcommerce.common.site.domain.Site[] response = new org.broadleafcommerce.common.site.domain.Site[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5326, 1)];
        transUtil.runOptionalTransactionalOperation(new org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter() {
            @java.lang.Override
            public void execute() throws java.lang.Throwable {
                org.broadleafcommerce.common.site.domain.Site site = siteDao.retrieveSiteByIdentifier(identifier);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5327, persistentResult)) {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5328, 0)] = site;
                }else {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5329, 0)] = getNonPersistentSite(site);
                }
            }
        }, java.lang.RuntimeException.class, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5331, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5330, org.springframework.transaction.support.TransactionSynchronizationManager.hasResource(((org.springframework.orm.jpa.JpaTransactionManager) (transUtil.getTransactionManager())).getEntityManagerFactory()))))));
        return response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5332, 0)];
    }

    @java.lang.Override
    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByDomainName(final java.lang.String domainName) {
        return retrieveNonPersistentSiteByDomainName(domainName);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentSiteByDomainName(final java.lang.String domainName) {
        return retrieveSiteByDomainName(domainName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5333, false));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrievePersistentSiteByDomainName(final java.lang.String domainName) {
        return retrieveSiteByDomainName(domainName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5334, true));
    }

    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByDomainName(final java.lang.String domainName, final boolean persistentResult) {
        final org.broadleafcommerce.common.site.domain.Site[] response = new org.broadleafcommerce.common.site.domain.Site[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5335, 1)];
        transUtil.runOptionalEntityManagerInViewOperation(new java.lang.Runnable() {
            @java.lang.Override
            public void run() {
                java.lang.String domainPrefix = null;
                java.lang.String domain = domainName;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5336, (domainName != null))) {
                    int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5337, domainName.indexOf('.'));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5340, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5338, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5339, 0))))) {
                        domainPrefix = domainName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5341, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5342, pos));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5343, stripSubdomain(domainPrefix))) {
                            domain = domainName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5346, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5344, domainPrefix.length())) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5345, 1)))));
                        }
                    }else {
                        domainPrefix = domainName;
                    }
                }
                org.broadleafcommerce.common.site.domain.Site site = siteDao.retrieveSiteByDomainOrDomainPrefix(domain, domainPrefix);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5347, persistentResult)) {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5348, 0)] = site;
                }else {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5349, 0)] = getNonPersistentSite(site);
                }
            }
        });
        return response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5350, 0)];
    }

    protected boolean stripSubdomain(java.lang.String subDomain) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5351, (subDomain != null))) {
            java.lang.String propStripPrefixes = org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty("site.domain.resolver.strip.subdomains");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5352, (propStripPrefixes != null))) {
                java.lang.String[] prefixes = propStripPrefixes.split(",");
                for (java.lang.String prefix : prefixes) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5353, subDomain.equals(prefix))) {
                        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5354, true);
                    }
                }
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5355, false);
    }

    @java.lang.Override
    @java.lang.Deprecated
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.site.domain.Site save(org.broadleafcommerce.common.site.domain.Site site) {
        return saveAndReturnNonPersisted(site);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.site.domain.Site saveAndReturnNonPersisted(org.broadleafcommerce.common.site.domain.Site site) {
        return getNonPersistentSite(saveAndReturnPersisted(site));
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional("blTransactionManager")
    public org.broadleafcommerce.common.site.domain.Site saveAndReturnPersisted(org.broadleafcommerce.common.site.domain.Site site) {
        return siteDao.save(site);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog findCatalogById(java.lang.Long id) {
        return siteDao.retrieveCatalog(id);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog findCatalogByName(java.lang.String name) {
        return siteDao.retrieveCatalogByName(name);
    }

    @java.lang.Override
    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site retrieveDefaultSite() {
        return retrieveNonPersistentDefaultSite();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentDefaultSite() {
        return getNonPersistentSite(retrievePersistentDefaultSite());
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site retrievePersistentDefaultSite() {
        return retrieveDefaultSite(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5356, true));
    }

    protected org.broadleafcommerce.common.site.domain.Site retrieveDefaultSite(final boolean persistentResult) {
        final org.broadleafcommerce.common.site.domain.Site[] response = new org.broadleafcommerce.common.site.domain.Site[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5357, 1)];
        transUtil.runOptionalEntityManagerInViewOperation(new java.lang.Runnable() {
            @java.lang.Override
            public void run() {
                org.broadleafcommerce.common.site.domain.Site defaultSite = siteDao.retrieveDefaultSite();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5358, persistentResult)) {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5359, 0)] = defaultSite;
                }else {
                    response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5360, 0)] = getNonPersistentSite(defaultSite);
                }
            }
        });
        return response[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5361, 0)];
    }

    @java.lang.Override
    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllActiveSites() {
        return findAllNonPersistentActiveSites();
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllNonPersistentActiveSites() {
        return findAllSites(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5362, false));
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllPersistentActiveSites() {
        return findAllSites(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5363, true));
    }

    protected java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllSites(final boolean persistentResult) {
        final java.util.List<org.broadleafcommerce.common.site.domain.Site> response = new java.util.ArrayList<org.broadleafcommerce.common.site.domain.Site>();
        transUtil.runOptionalEntityManagerInViewOperation(new java.lang.Runnable() {
            @java.lang.Override
            public void run() {
                java.util.List<org.broadleafcommerce.common.site.domain.Site> sites = siteDao.readAllActiveSites();
                for (org.broadleafcommerce.common.site.domain.Site site : sites) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5364, persistentResult)) {
                        response.add(site);
                    }else {
                        response.add(getNonPersistentSite(site));
                    }
                }
            }
        });
        return response;
    }

    protected org.broadleafcommerce.common.site.domain.Site getNonPersistentSite(org.broadleafcommerce.common.site.domain.Site persistentSite) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5365, (persistentSite == null))) {
            return null;
        }
        org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache cache = org.broadleafcommerce.common.site.service.NonPersistentSiteThreadLocalCache.getSitesCache();
        org.broadleafcommerce.common.site.domain.Site clone = cache.getSites().get(persistentSite.getId());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5366, (clone == null))) {
            clone = persistentSite.clone();
            extensionManager.getProxy().contributeNonPersitentSiteProperties(persistentSite, clone);
            cache.getSites().put(persistentSite.getId(), clone);
        }
        return clone;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog createCatalog() {
        return siteDao.createCatalog();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.SiteCatalogXref createSiteCatalog() {
        return siteDao.createSiteCatalog();
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(org.broadleafcommerce.common.util.TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public org.broadleafcommerce.common.site.domain.Catalog save(org.broadleafcommerce.common.site.domain.Catalog catalog) {
        return siteDao.save(catalog);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> findAllCatalogs() {
        return siteDao.retrieveAllCatalogs();
    }

    public static perturbation.location.PerturbationLocation __L5315;

    public static perturbation.location.PerturbationLocation __L5316;

    public static perturbation.location.PerturbationLocation __L5317;

    public static perturbation.location.PerturbationLocation __L5318;

    public static perturbation.location.PerturbationLocation __L5319;

    public static perturbation.location.PerturbationLocation __L5320;

    public static perturbation.location.PerturbationLocation __L5321;

    public static perturbation.location.PerturbationLocation __L5322;

    public static perturbation.location.PerturbationLocation __L5323;

    public static perturbation.location.PerturbationLocation __L5324;

    public static perturbation.location.PerturbationLocation __L5325;

    public static perturbation.location.PerturbationLocation __L5326;

    public static perturbation.location.PerturbationLocation __L5327;

    public static perturbation.location.PerturbationLocation __L5328;

    public static perturbation.location.PerturbationLocation __L5329;

    public static perturbation.location.PerturbationLocation __L5330;

    public static perturbation.location.PerturbationLocation __L5331;

    public static perturbation.location.PerturbationLocation __L5332;

    public static perturbation.location.PerturbationLocation __L5333;

    public static perturbation.location.PerturbationLocation __L5334;

    public static perturbation.location.PerturbationLocation __L5335;

    public static perturbation.location.PerturbationLocation __L5336;

    public static perturbation.location.PerturbationLocation __L5337;

    public static perturbation.location.PerturbationLocation __L5338;

    public static perturbation.location.PerturbationLocation __L5339;

    public static perturbation.location.PerturbationLocation __L5340;

    public static perturbation.location.PerturbationLocation __L5341;

    public static perturbation.location.PerturbationLocation __L5342;

    public static perturbation.location.PerturbationLocation __L5343;

    public static perturbation.location.PerturbationLocation __L5344;

    public static perturbation.location.PerturbationLocation __L5345;

    public static perturbation.location.PerturbationLocation __L5346;

    public static perturbation.location.PerturbationLocation __L5347;

    public static perturbation.location.PerturbationLocation __L5348;

    public static perturbation.location.PerturbationLocation __L5349;

    public static perturbation.location.PerturbationLocation __L5350;

    public static perturbation.location.PerturbationLocation __L5351;

    public static perturbation.location.PerturbationLocation __L5352;

    public static perturbation.location.PerturbationLocation __L5353;

    public static perturbation.location.PerturbationLocation __L5354;

    public static perturbation.location.PerturbationLocation __L5355;

    public static perturbation.location.PerturbationLocation __L5356;

    public static perturbation.location.PerturbationLocation __L5357;

    public static perturbation.location.PerturbationLocation __L5358;

    public static perturbation.location.PerturbationLocation __L5359;

    public static perturbation.location.PerturbationLocation __L5360;

    public static perturbation.location.PerturbationLocation __L5361;

    public static perturbation.location.PerturbationLocation __L5362;

    public static perturbation.location.PerturbationLocation __L5363;

    public static perturbation.location.PerturbationLocation __L5364;

    public static perturbation.location.PerturbationLocation __L5365;

    public static perturbation.location.PerturbationLocation __L5366;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:63)", 5315, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:68)", 5316, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:75)", 5317, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:76)", 5318, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:81)", 5319, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:82)", 5320, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:84)", 5321, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:89)", 5322, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:94)", 5323, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:99)", 5324, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:105)", 5325, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:106)", 5326, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:111)", 5327, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:112)", 5328, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:114)", 5329, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:117)", 5330, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:117)", 5331, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:119)", 5332, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:130)", 5333, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:135)", 5334, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:142)", 5335, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:148)", 5336, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:149)", 5337, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:150)", 5338, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:150)", 5339, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:150)", 5340, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:151)", 5341, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:151)", 5342, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:152)", 5343, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:153)", 5344, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:153)", 5345, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:153)", 5346, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:161)", 5347, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:162)", 5348, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:164)", 5349, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:169)", 5350, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:179)", 5351, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:181)", 5352, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:184)", 5353, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:185)", 5354, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:190)", 5355, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:235)", 5356, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:242)", 5357, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:247)", 5358, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:248)", 5359, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:250)", 5360, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:255)", 5361, "Numerical");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:266)", 5362, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:271)", 5363, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:284)", 5364, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:296)", 5365, "Boolean");
        org.broadleafcommerce.common.site.service.SiteServiceImpl.__L5366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/site/service/SiteServiceImpl.java:301)", 5366, "Boolean");
    }

    static {
        org.broadleafcommerce.common.site.service.SiteServiceImpl.initPerturbationLocation0();
    }
}

