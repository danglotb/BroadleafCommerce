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
package org.broadleafcommerce.common.web;


public interface BroadleafSiteResolver {
    public static final java.lang.String SELECTED_SITE_URL_PARAM = "selectedSite";

    @java.lang.Deprecated
    public org.broadleafcommerce.common.site.domain.Site resolveSite(javax.servlet.http.HttpServletRequest request) throws org.broadleafcommerce.common.exception.SiteNotFoundException;

    public org.broadleafcommerce.common.site.domain.Site resolveSite(org.springframework.web.context.request.WebRequest request) throws org.broadleafcommerce.common.exception.SiteNotFoundException;

    public org.broadleafcommerce.common.site.domain.Site resolveSite(final org.springframework.web.context.request.WebRequest request, final boolean allowNullSite) throws org.broadleafcommerce.common.exception.SiteNotFoundException;
}

