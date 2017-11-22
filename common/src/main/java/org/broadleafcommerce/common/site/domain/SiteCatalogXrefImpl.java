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
package org.broadleafcommerce.common.site.domain;


@javax.persistence.Entity
@javax.persistence.Table(name = "BLC_SITE_CATALOG")
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSiteElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "SiteCatalogXrefImpl")
public class SiteCatalogXrefImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.site.domain.SiteCatalogXref {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "SiteCatalogXrefId")
    @org.hibernate.annotations.GenericGenerator(name = "SiteCatalogXrefId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SiteCatalogXrefImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.site.domain.SiteCatalogXrefImpl") })
    @javax.persistence.Column(name = "SITE_CATALOG_XREF_ID")
    protected java.lang.Long id;

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.site.domain.SiteImpl.class, optional = false)
    @javax.persistence.JoinColumn(name = "SITE_ID")
    protected org.broadleafcommerce.common.site.domain.Site site = new org.broadleafcommerce.common.site.domain.SiteImpl();

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.site.domain.CatalogImpl.class, optional = false)
    @javax.persistence.JoinColumn(name = "CATALOG_ID")
    protected org.broadleafcommerce.common.site.domain.Catalog catalog = new org.broadleafcommerce.common.site.domain.CatalogImpl();

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site getSite() {
        return site;
    }

    @java.lang.Override
    public void setSite(org.broadleafcommerce.common.site.domain.Site site) {
        this.site = site;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Catalog getCatalog() {
        return catalog;
    }

    @java.lang.Override
    public void setCatalog(org.broadleafcommerce.common.site.domain.Catalog catalog) {
        this.catalog = catalog;
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getCatalog().getName();
    }
}

