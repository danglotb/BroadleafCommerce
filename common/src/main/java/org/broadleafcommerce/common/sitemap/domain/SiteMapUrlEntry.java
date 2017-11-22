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


public interface SiteMapUrlEntry extends java.io.Serializable {
    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public java.lang.String getLocation();

    public void setLocation(java.lang.String location);

    public java.util.Date getLastMod();

    public void setLastMod(java.util.Date date);

    public org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType getSiteMapChangeFreq();

    public void setSiteMapChangeFreq(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType siteMapChangeFreq);

    public org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType getSiteMapPriority();

    public void setSiteMapPriority(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType siteMapPriority);

    public org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration getCustomUrlSiteMapGeneratorConfiguration();

    public void setCustomUrlSiteMapGeneratorConfiguration(org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration customUrlSiteMapGeneratorConfiguration);
}

