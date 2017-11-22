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


@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "baseSite", tabs = { @org.broadleafcommerce.common.presentation.AdminTabPresentation(name = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.TabName.General, order = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.TabOrder.General, groups = { @org.broadleafcommerce.common.presentation.AdminGroupPresentation(name = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupName.General, order = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupOrder.General, untitled = true), @org.broadleafcommerce.common.presentation.AdminGroupPresentation(name = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupName.Security, order = org.broadleafcommerce.common.site.domain.SiteAdminPresentation.GroupOrder.Security) }) })
public interface SiteAdminPresentation {
    public static class TabName {
        public static final java.lang.String General = "General";
    }

    public static class TabOrder {
        public static final int General = 1000;
    }

    public static class GroupName {
        public static final java.lang.String General = "General";

        public static final java.lang.String Security = "SiteImpl_Security_Description";
    }

    public static class GroupOrder {
        public static final int General = 1000;

        public static final int Security = 4000;
    }
}

