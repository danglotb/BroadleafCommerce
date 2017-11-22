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


public class NullBroadleafThemeResolver implements org.broadleafcommerce.common.web.BroadleafThemeResolver {
    private final org.broadleafcommerce.common.site.domain.Theme theme = new org.broadleafcommerce.common.site.domain.ThemeDTO();

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Theme resolveTheme(javax.servlet.http.HttpServletRequest request, org.broadleafcommerce.common.site.domain.Site site) {
        return resolveTheme(new org.springframework.web.context.request.ServletWebRequest(request));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Theme resolveTheme(org.springframework.web.context.request.WebRequest request) {
        return theme;
    }
}

