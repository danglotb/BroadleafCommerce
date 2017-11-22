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


public interface SiteService {
    public org.broadleafcommerce.common.site.domain.Site createSite();

    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site retrieveSiteById(java.lang.Long id);

    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentSiteById(java.lang.Long id);

    public org.broadleafcommerce.common.site.domain.Site retrievePersistentSiteById(java.lang.Long id);

    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByDomainName(java.lang.String domain);

    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentSiteByDomainName(java.lang.String domain);

    public org.broadleafcommerce.common.site.domain.Site retrievePersistentSiteByDomainName(java.lang.String domain);

    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentSiteByIdentifer(java.lang.String identifier);

    public org.broadleafcommerce.common.site.domain.Site retrievePersistentSiteByIdentifier(java.lang.String identifier);

    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site save(org.broadleafcommerce.common.site.domain.Site site);

    public org.broadleafcommerce.common.site.domain.Site saveAndReturnNonPersisted(org.broadleafcommerce.common.site.domain.Site site);

    public org.broadleafcommerce.common.site.domain.Site saveAndReturnPersisted(org.broadleafcommerce.common.site.domain.Site site);

    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site retrieveDefaultSite();

    public org.broadleafcommerce.common.site.domain.Site retrieveNonPersistentDefaultSite();

    public org.broadleafcommerce.common.site.domain.Site retrievePersistentDefaultSite();

    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllActiveSites();

    public java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllNonPersistentActiveSites();

    public java.util.List<org.broadleafcommerce.common.site.domain.Site> findAllPersistentActiveSites();

    public org.broadleafcommerce.common.site.domain.Catalog findCatalogById(java.lang.Long id);

    org.broadleafcommerce.common.site.domain.Catalog findCatalogByName(java.lang.String name);

    public org.broadleafcommerce.common.site.domain.Catalog createCatalog();

    public org.broadleafcommerce.common.site.domain.SiteCatalogXref createSiteCatalog();

    public org.broadleafcommerce.common.site.domain.Catalog save(org.broadleafcommerce.common.site.domain.Catalog catalog);

    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> findAllCatalogs();
}

