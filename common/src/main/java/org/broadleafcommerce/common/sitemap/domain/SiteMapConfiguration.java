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


public interface SiteMapConfiguration extends org.broadleafcommerce.common.config.domain.ModuleConfiguration {
    java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration> getSiteMapGeneratorConfigurations();

    void setSiteMapGeneratorConfigurations(java.util.List<org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration> siteMapGeneratorConfigurations);

    java.lang.Integer getMaximumUrlEntriesPerFile();

    void setMaximumUrlEntriesPerFile(java.lang.Integer maximumUrlEntriesPerFile);

    java.lang.String fixSiteUrlPath(java.lang.String siteUrlPath);

    java.lang.String getSiteMapFileName();

    void setSiteMapFileName(java.lang.String siteMapFileName);

    java.lang.String getIndexedSiteMapFileName();

    void setIndexedSiteMapFileName(java.lang.String fileName);

    java.lang.String getSiteMapIndexFilePattern();

    void setIndexedSiteMapFilePattern(java.lang.String filePattern);
}

