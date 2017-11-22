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
@javax.persistence.Table(name = "BLC_SYSTEM_PROPERTY")
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.SANDBOX) })
public class SystemPropertyImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.config.domain.SystemProperty , org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "SystemPropertyId")
    @org.hibernate.annotations.GenericGenerator(name = "SystemPropertyId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SystemPropertyImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.config.domain.SystemPropertyImpl") })
    @javax.persistence.Column(name = "BLC_SYSTEM_PROPERTY_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "PROPERTY_NAME", nullable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SystemPropertyImpl_name", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.General, order = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.FieldOrder.ATTRIBUTE_NAME, prominent = true, gridOrder = 1000, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED, validationConfigurations = @org.broadleafcommerce.common.presentation.ValidationConfiguration(validationImplementation = "blSystemPropertyAttributeNameValidator"))
    protected java.lang.String name;

    @javax.persistence.Column(name = "OVERRIDE_GENERATED_PROP_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "FieldImpl_overrideGeneratedPropertyName", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.General)
    protected java.lang.Boolean overrideGeneratedPropertyName = ((boolean) (false));

    @javax.persistence.Column(name = "PROPERTY_VALUE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SystemPropertyImpl_value", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.General, order = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.FieldOrder.VALUE, prominent = true, gridOrder = 3000, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED)
    protected java.lang.String value;

    @javax.persistence.Column(name = "PROPERTY_TYPE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SystemPropertyImpl_propertyType", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.General, order = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.FieldOrder.PROPERTY_TYPE, prominent = true, gridOrder = 2000, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType", requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED)
    protected java.lang.String propertyType;

    @javax.persistence.Column(name = "FRIENDLY_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SystemPropertyImpl_friendlyName", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.General, order = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.FieldOrder.FRIENDLY_NAME)
    protected java.lang.String friendlyName;

    @javax.persistence.Column(name = "FRIENDLY_GROUP")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SystemPropertyImpl_friendlyGroup", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.Placement, order = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.FieldOrder.GROUP_NAME)
    protected java.lang.String friendlyGroup;

    @javax.persistence.Column(name = "FRIENDLY_TAB")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SystemPropertyImpl_friendlyTab", group = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.GroupName.Placement, order = org.broadleafcommerce.common.config.domain.SystemPropertyAdminPresentation.FieldOrder.TAB_NAME)
    protected java.lang.String friendlyTab;

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getName() {
        return name;
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.Boolean getOverrideGeneratedPropertyName() {
        return overrideGeneratedPropertyName;
    }

    @java.lang.Override
    public void setOverrideGeneratedPropertyName(java.lang.Boolean overrideGeneratedPropertyName) {
        this.overrideGeneratedPropertyName = overrideGeneratedPropertyName;
    }

    @java.lang.Override
    public java.lang.String getValue() {
        return value;
    }

    @java.lang.Override
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @java.lang.Override
    public java.lang.String getFriendlyName() {
        return friendlyName;
    }

    @java.lang.Override
    public void setFriendlyName(java.lang.String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @java.lang.Override
    public java.lang.String getFriendlyGroup() {
        return friendlyGroup;
    }

    @java.lang.Override
    public void setFriendlyGroup(java.lang.String friendlyGroup) {
        this.friendlyGroup = friendlyGroup;
    }

    @java.lang.Override
    public java.lang.String getFriendlyTab() {
        return friendlyTab;
    }

    @java.lang.Override
    public void setFriendlyTab(java.lang.String friendlyTab) {
        this.friendlyTab = friendlyTab;
    }

    public org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType getPropertyType() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.__L353, ((propertyType) != null))) {
            org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType returnType = org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.getInstance(propertyType);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.__L354, (returnType != null))) {
                return returnType;
            }
        }
        return org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.STRING_TYPE;
    }

    public void setPropertyType(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType propertyType) {
        this.propertyType = propertyType.getType();
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getName();
    }

    @java.lang.Override
    public <G extends org.broadleafcommerce.common.config.domain.SystemProperty> org.broadleafcommerce.common.copy.CreateResponse<G> createOrRetrieveCopyInstance(org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse = context.createOrRetrieveCopyInstance(this);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.domain.SystemPropertyImpl.__L355, createResponse.isAlreadyPopulated())) {
            return createResponse;
        }
        org.broadleafcommerce.common.config.domain.SystemProperty cloned = createResponse.getClone();
        cloned.setFriendlyGroup(friendlyGroup);
        cloned.setFriendlyName(friendlyName);
        cloned.setFriendlyTab(friendlyTab);
        cloned.setName(name);
        cloned.setValue(value);
        cloned.setPropertyType(getPropertyType());
        return createResponse;
    }

    public static perturbation.location.PerturbationLocation __L353;

    public static perturbation.location.PerturbationLocation __L354;

    public static perturbation.location.PerturbationLocation __L355;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.domain.SystemPropertyImpl.__L353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/SystemPropertyImpl.java:190)", 353, "Boolean");
        org.broadleafcommerce.common.config.domain.SystemPropertyImpl.__L354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/SystemPropertyImpl.java:192)", 354, "Boolean");
        org.broadleafcommerce.common.config.domain.SystemPropertyImpl.__L355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/domain/SystemPropertyImpl.java:211)", 355, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.domain.SystemPropertyImpl.initPerturbationLocation0();
    }
}

