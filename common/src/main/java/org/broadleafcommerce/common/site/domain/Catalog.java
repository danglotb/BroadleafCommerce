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


public interface Catalog extends java.io.Serializable , java.lang.Comparable<org.broadleafcommerce.common.site.domain.Catalog> , org.broadleafcommerce.common.persistence.Status {
    java.lang.Long getId();

    void setId(java.lang.Long id);

    java.lang.String getName();

    void setName(java.lang.String name);

    @java.lang.Deprecated
    java.util.List<org.broadleafcommerce.common.site.domain.Site> getSites();

    @java.lang.Deprecated
    void setSites(java.util.List<org.broadleafcommerce.common.site.domain.Site> sites);

    public java.util.List<org.broadleafcommerce.common.site.domain.SiteCatalogXref> getSiteXrefs();

    public void setSiteXrefs(java.util.List<org.broadleafcommerce.common.site.domain.SiteCatalogXref> siteXrefs);

    @java.lang.Override
    public int compareTo(org.broadleafcommerce.common.site.domain.Catalog other);

    org.broadleafcommerce.common.site.domain.Catalog clone();
}

