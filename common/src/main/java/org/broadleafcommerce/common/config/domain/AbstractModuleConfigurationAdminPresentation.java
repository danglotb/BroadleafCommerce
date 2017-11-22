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
package org.broadleafcommerce.common.config.domain;


@org.broadleafcommerce.common.presentation.AdminPresentationClass(excludeFromPolymorphism = true, friendlyName = "AbstractModuleConfiguration", tabs = { @org.broadleafcommerce.common.presentation.AdminTabPresentation(name = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.TabName.General, order = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.TabOrder.General, groups = { @org.broadleafcommerce.common.presentation.AdminGroupPresentation(name = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.General, order = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupOrder.General, untitled = true), @org.broadleafcommerce.common.presentation.AdminGroupPresentation(name = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.ActiveDates, order = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupOrder.ActiveDates, column = 1), @org.broadleafcommerce.common.presentation.AdminGroupPresentation(name = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.Options, order = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupOrder.Options, column = 1) }) })
public interface AbstractModuleConfigurationAdminPresentation {
    public static class TabName {
        public static final java.lang.String General = "General";
    }

    public static class TabOrder {
        public static final int General = 1000;

        public static final int History = 2000;
    }

    public static class GroupName {
        public static final java.lang.String General = "General";

        public static final java.lang.String ActiveDates = "AbstractModuleConfiguration_Active_Dates";

        public static final java.lang.String Options = "AbstractModuleConfiguration_Options";
    }

    public static class GroupOrder {
        public static final int General = 1000;

        public static final int ActiveDates = 2000;

        public static final int Options = 3000;

        public static final int RuleConfiguration = 4000;

        public static final int Advanced = 1000;

        public static final int CombineStack = 2000;

        public static final int QualifierRuleRestriction = 3000;

        public static final int TargetRuleRestriction = 4000;

        public static final int Codes = 1000;
    }
}

