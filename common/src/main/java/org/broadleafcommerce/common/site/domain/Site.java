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


public interface Site extends java.io.Serializable , org.broadleafcommerce.common.persistence.Status {
    public java.lang.Long getId();

    public void setId(java.lang.Long id);

    public java.lang.String getName();

    public void setName(java.lang.String name);

    @java.lang.Deprecated
    public java.lang.String getSiteIdentifierType();

    @java.lang.Deprecated
    public void setSiteIdentifierType(java.lang.String siteIdentifierType);

    public java.lang.String getSiteIdentifierValue();

    public void setSiteIdentifierValue(java.lang.String siteIdentifierValue);

    public org.broadleafcommerce.common.site.service.type.SiteResolutionType getSiteResolutionType();

    public void setSiteResolutionType(org.broadleafcommerce.common.site.service.type.SiteResolutionType siteResolutionType);

    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> getCatalogs();

    @java.lang.Deprecated
    public void setCatalogs(java.util.List<org.broadleafcommerce.common.site.domain.Catalog> catalogs);

    public org.broadleafcommerce.common.site.domain.Site clone();

    public org.broadleafcommerce.common.persistence.ArchiveStatus getArchiveStatus();

    public boolean isDeactivated();

    public void setDeactivated(boolean deactivated);

    @java.lang.Deprecated
    public boolean isTemplateSite();
}

