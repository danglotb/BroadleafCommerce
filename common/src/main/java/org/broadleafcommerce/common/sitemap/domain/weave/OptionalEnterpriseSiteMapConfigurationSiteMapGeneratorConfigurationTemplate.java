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
package org.broadleafcommerce.common.sitemap.domain.weave;


@java.lang.Deprecated
public abstract class OptionalEnterpriseSiteMapConfigurationSiteMapGeneratorConfigurationTemplate {
    @javax.persistence.OneToMany(mappedBy = "siteMapConfiguration", targetEntity = org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl.class, cascade = { javax.persistence.CascadeType.ALL }, orphanRemoval = true)
    @org.broadleafcommerce.common.presentation.AdminPresentationCollection(friendlyName = "SiteMapConfigurationImpl_Generator_Configurations", tab = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.TabName.General)
    @org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminatable(type = org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminatableType.SITE)
    protected java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration> siteMapGeneratorConfigurations = new java.util.ArrayList<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration>();
}

