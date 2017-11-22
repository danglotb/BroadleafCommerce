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
package org.broadleafcommerce.common.sitemap.wrapper;


@javax.xml.bind.annotation.XmlRootElement(name = "urlset")
public class SiteMapURLSetWrapper implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private java.util.List<org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper> siteMapUrlWrappers = new java.util.ArrayList<org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper>();

    public java.util.List<org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper> getSiteMapUrlWrappers() {
        return siteMapUrlWrappers;
    }

    @javax.xml.bind.annotation.XmlElement(name = "url")
    public void setSiteMapUrlWrappers(java.util.List<org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper> siteMapUrlWrappers) {
        this.siteMapUrlWrappers = siteMapUrlWrappers;
    }
}

