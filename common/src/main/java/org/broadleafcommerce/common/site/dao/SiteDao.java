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
package org.broadleafcommerce.common.site.dao;


public interface SiteDao {
    public org.broadleafcommerce.common.site.domain.Site create();

    public org.broadleafcommerce.common.site.domain.Site retrieve(java.lang.Long id);

    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByDomainOrDomainPrefix(java.lang.String domain, java.lang.String prefix);

    public org.broadleafcommerce.common.site.domain.Site retrieveSiteByIdentifier(java.lang.String identifier);

    public org.broadleafcommerce.common.site.domain.Site save(org.broadleafcommerce.common.site.domain.Site site);

    public org.broadleafcommerce.common.site.domain.Site retrieveDefaultSite();

    public java.util.List<org.broadleafcommerce.common.site.domain.Site> readAllActiveSites();

    public org.broadleafcommerce.common.site.domain.Catalog retrieveCatalog(java.lang.Long id);

    org.broadleafcommerce.common.site.domain.Catalog retrieveCatalogByName(java.lang.String name);

    public org.broadleafcommerce.common.site.domain.Catalog createCatalog();

    public org.broadleafcommerce.common.site.domain.SiteCatalogXref createSiteCatalog();

    public org.broadleafcommerce.common.site.domain.Catalog save(org.broadleafcommerce.common.site.domain.Catalog catalog);

    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> retrieveAllCatalogs();
}

