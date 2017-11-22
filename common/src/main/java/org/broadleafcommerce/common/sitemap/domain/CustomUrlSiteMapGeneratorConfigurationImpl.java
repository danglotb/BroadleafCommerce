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
package org.broadleafcommerce.common.sitemap.domain;


@javax.persistence.Entity
@javax.persistence.Table(name = "BLC_CUST_SITE_MAP_GEN_CFG")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "CustomUrlSiteMapGeneratorConfigurationImpl")
public class CustomUrlSiteMapGeneratorConfigurationImpl extends org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl implements org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration {
    private static final long serialVersionUID = 1L;

    @javax.persistence.OneToMany(mappedBy = "customUrlSiteMapGeneratorConfiguration", targetEntity = org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntryImpl.class, cascade = { javax.persistence.CascadeType.ALL }, orphanRemoval = true)
    @org.broadleafcommerce.common.presentation.AdminPresentationCollection(friendlyName = "CustomUrlSiteMapGeneratorConfigurationImpl_Custom_URL_Entries")
    protected java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry> customURLEntries = new java.util.ArrayList<org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry>();

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry> getCustomURLEntries() {
        return customURLEntries;
    }

    @java.lang.Override
    public void setCustomURLEntries(java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry> customURLEntries) {
        this.customURLEntries = customURLEntries;
    }
}

