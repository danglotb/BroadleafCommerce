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


@javax.xml.bind.annotation.XmlRootElement(name = "sitemap")
@javax.xml.bind.annotation.XmlType(propOrder = { "loc", "lastmod" })
public class SiteMapWrapper implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.String loc;

    protected java.lang.String lastmod;

    public java.lang.String getLoc() {
        return loc;
    }

    @javax.xml.bind.annotation.XmlElement
    public void setLoc(java.lang.String loc) {
        this.loc = loc;
    }

    public java.lang.String getLastmod() {
        return lastmod;
    }

    @javax.xml.bind.annotation.XmlElement
    public void setLastmod(java.lang.String lastmod) {
        this.lastmod = lastmod;
    }
}

