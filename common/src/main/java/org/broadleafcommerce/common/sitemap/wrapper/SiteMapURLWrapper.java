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


@javax.xml.bind.annotation.XmlRootElement(name = "url")
@javax.xml.bind.annotation.XmlType(propOrder = { "loc", "lastmod", "changefreq", "priority" })
public class SiteMapURLWrapper implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.String loc;

    protected java.lang.String lastmod;

    protected java.lang.String changefreq;

    protected java.lang.String priority;

    public void setLastModDate(java.util.Date lastModDate) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.__L5565, (lastModDate != null))) {
            lastmod = org.broadleafcommerce.common.util.FormatUtil.formatDateUsingW3C(lastModDate);
        }else {
            lastmod = org.broadleafcommerce.common.util.FormatUtil.formatDateUsingW3C(new java.util.Date());
        }
    }

    public void setPriorityType(org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType priorityType) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.__L5566, (priorityType != null))) {
            setPriority(priorityType.getType());
        }
    }

    public void setChangeFreqType(org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType changeFreqType) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.__L5567, (changeFreqType != null))) {
            setChangefreq(changeFreqType.getFriendlyType());
        }
    }

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

    public java.lang.String getChangefreq() {
        return changefreq;
    }

    @javax.xml.bind.annotation.XmlElement
    public void setChangefreq(java.lang.String changefreq) {
        this.changefreq = changefreq;
    }

    public java.lang.String getPriority() {
        return priority;
    }

    @javax.xml.bind.annotation.XmlElement
    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }

    public static perturbation.location.PerturbationLocation __L5565;

    public static perturbation.location.PerturbationLocation __L5566;

    public static perturbation.location.PerturbationLocation __L5567;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.__L5565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/wrapper/SiteMapURLWrapper.java:52)", 5565, "Boolean");
        org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.__L5566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/wrapper/SiteMapURLWrapper.java:60)", 5566, "Boolean");
        org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.__L5567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/wrapper/SiteMapURLWrapper.java:66)", 5567, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper.initPerturbationLocation0();
    }
}

