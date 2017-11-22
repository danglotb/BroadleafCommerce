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


@javax.persistence.Entity
@javax.persistence.Table(name = "BLC_MODULE_CONFIGURATION")
@javax.persistence.EntityListeners({ org.broadleafcommerce.common.audit.AuditableListener.class })
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "blConfigurationModuleElements")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTI_PHASE_ADD) })
public abstract class AbstractModuleConfiguration implements org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation , org.broadleafcommerce.common.config.domain.ModuleConfiguration , org.broadleafcommerce.common.persistence.Status {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "ModuleConfigurationId")
    @org.hibernate.annotations.GenericGenerator(name = "ModuleConfigurationId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "ModuleConfigurationImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.config.domain" + ".AbstractModuleConfiguration") })
    @javax.persistence.Column(name = "MODULE_CONFIG_ID")
    @org.broadleafcommerce.common.presentation.AdminPresentation(visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL)
    protected java.lang.Long id;

    @javax.persistence.Column(name = "MODULE_NAME", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "AbstractModuleConfiguration_Module_Name", order = 2000, gridOrder = 2, prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, group = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.General)
    protected java.lang.String moduleName;

    @javax.persistence.Column(name = "ACTIVE_START_DATE", nullable = true)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "AbstractModuleConfiguration_Active_Start_Date", order = 3000, gridOrder = 3, prominent = true, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.DATE, group = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.ActiveDates)
    protected java.util.Date activeStartDate;

    @javax.persistence.Column(name = "ACTIVE_END_DATE", nullable = true)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "AbstractModuleConfiguration_Active_End_Date", order = 4000, gridOrder = 4, prominent = true, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.DATE, group = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.ActiveDates)
    protected java.util.Date activeEndDate;

    @javax.persistence.Column(name = "IS_DEFAULT", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "AbstractModuleConfiguration_Is_Default", order = 5000, gridOrder = 5, prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, group = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.Options)
    protected java.lang.Boolean isDefault = ((boolean) (false));

    @javax.persistence.Column(name = "CONFIG_TYPE", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "AbstractModuleConfiguration_Config_Type", order = 1000, gridOrder = 1, prominent = true, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.config.service.type.ModuleConfigurationType", requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.NOT_REQUIRED, readOnly = true, visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.FORM_HIDDEN)
    protected java.lang.String configType;

    @javax.persistence.Column(name = "MODULE_PRIORITY", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "AbstractModuleConfiguration_Priority", order = 6000, gridOrder = 6, prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, tooltip = "AbstractModuleConfiguration_Priority_Tooltip", group = org.broadleafcommerce.common.config.domain.AbstractModuleConfigurationAdminPresentation.GroupName.Options)
    protected java.lang.Integer priority = ((int) (100));

    @javax.persistence.Embedded
    protected org.broadleafcommerce.common.audit.Auditable auditable = new org.broadleafcommerce.common.audit.Auditable();

    @javax.persistence.Embedded
    protected org.broadleafcommerce.common.persistence.ArchiveStatus archiveStatus = new org.broadleafcommerce.common.persistence.ArchiveStatus();

    @java.lang.Override
    public java.lang.Long getId() {
        return this.id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getModuleName() {
        return moduleName;
    }

    @java.lang.Override
    public void setModuleName(java.lang.String name) {
        this.moduleName = name;
    }

    @java.lang.Override
    public java.lang.Boolean getIsDefault() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L343, ((this.isDefault) == null))) {
            this.isDefault = java.lang.Boolean.FALSE;
        }
        return this.isDefault;
    }

    @java.lang.Override
    public boolean isDefault() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L344, ((getIsDefault()) != null))) {
            return getIsDefault();
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L345, false);
    }

    @java.lang.Override
    public void setIsDefault(java.lang.Boolean isDefault) {
        this.isDefault = isDefault;
    }

    protected void setModuleConfigurationType(org.broadleafcommerce.common.config.service.type.ModuleConfigurationType moduleConfigurationType) {
        this.configType = moduleConfigurationType.getType();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.service.type.ModuleConfigurationType getModuleConfigurationType() {
        return org.broadleafcommerce.common.config.service.type.ModuleConfigurationType.getInstance(this.configType);
    }

    @java.lang.Override
    public void setAuditable(org.broadleafcommerce.common.audit.Auditable auditable) {
        this.auditable = auditable;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.audit.Auditable getAuditable() {
        return this.auditable;
    }

    @java.lang.Override
    public void setArchived(java.lang.Character archived) {
        archiveStatus.setArchived(archived);
    }

    @java.lang.Override
    public java.lang.Character getArchived() {
        org.broadleafcommerce.common.persistence.ArchiveStatus temp;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L346, ((archiveStatus) == null))) {
            temp = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }else {
            temp = archiveStatus;
        }
        return temp.getArchived();
    }

    @java.lang.Override
    public boolean isActive() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L350, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L348, org.broadleafcommerce.common.util.DateUtil.isActive(activeStartDate, activeEndDate, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L347, true)))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L349, ('Y' != (getArchived()))))));
    }

    @java.lang.Override
    public void setActiveStartDate(java.util.Date startDate) {
        this.activeStartDate = startDate;
    }

    @java.lang.Override
    public java.util.Date getActiveStartDate() {
        return this.activeStartDate;
    }

    @java.lang.Override
    public void setActiveEndDate(java.util.Date endDate) {
        this.activeEndDate = endDate;
    }

    @java.lang.Override
    public java.util.Date getActiveEndDate() {
        return this.activeEndDate;
    }

    @java.lang.Override
    public java.lang.Integer getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L351, priority);
    }

    @java.lang.Override
    public void setPriority(java.lang.Integer priority) {
        this.priority = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L352, priority);
    }

    public static perturbation.location.PerturbationLocation __L343;

    public static perturbation.location.PerturbationLocation __L344;

    public static perturbation.location.PerturbationLocation __L345;

    public static perturbation.location.PerturbationLocation __L346;

    public static perturbation.location.PerturbationLocation __L347;

    public static perturbation.location.PerturbationLocation __L348;

    public static perturbation.location.PerturbationLocation __L349;

    public static perturbation.location.PerturbationLocation __L350;

    public static perturbation.location.PerturbationLocation __L351;

    public static perturbation.location.PerturbationLocation __L352;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:154)", 343, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:162)", 344, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:165)", 345, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:203)", 346, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:213)", 347, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:213)", 348, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:213)", 349, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:213)", 350, "Boolean");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:238)", 351, "Numerical");
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.__L352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/AbstractModuleConfiguration.java:243)", 352, "Numerical");
    }

    static {
        org.broadleafcommerce.common.config.domain.AbstractModuleConfiguration.initPerturbationLocation0();
    }
}

