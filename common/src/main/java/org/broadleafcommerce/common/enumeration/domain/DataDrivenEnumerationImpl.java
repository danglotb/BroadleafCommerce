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
package org.broadleafcommerce.common.enumeration.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_DATA_DRVN_ENUM")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(populateToOneFields = org.broadleafcommerce.common.presentation.PopulateToOneFieldsEnum.TRUE, friendlyName = "DataDrivenEnumerationImpl_friendyName")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.SANDBOX, skipOverlaps = true), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE) })
public class DataDrivenEnumerationImpl implements org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "DataDrivenEnumerationId")
    @org.hibernate.annotations.GenericGenerator(name = "DataDrivenEnumerationId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "DataDrivenEnumerationImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl") })
    @javax.persistence.Column(name = "ENUM_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "ENUM_KEY")
    @org.hibernate.annotations.Index(name = "ENUM_KEY_INDEX", columnNames = { "KEY" })
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "DataDrivenEnumerationImpl_Key", order = 1, gridOrder = 1, prominent = true)
    protected java.lang.String key;

    @javax.persistence.Column(name = "MODIFIABLE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "DataDrivenEnumerationImpl_Modifiable", order = 2, gridOrder = 2, prominent = true)
    protected java.lang.Boolean modifiable = ((boolean) (false));

    @javax.persistence.OneToMany(mappedBy = "type", targetEntity = org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.class, cascade = { javax.persistence.CascadeType.ALL })
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
    @org.broadleafcommerce.common.presentation.AdminPresentationCollection(addType = org.broadleafcommerce.common.presentation.client.AddMethodType.PERSIST, friendlyName = "DataDrivenEnumerationImpl_Enum_Values", order = 3)
    protected java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> enumValues = new java.util.ArrayList<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue>();

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getKey() {
        return key;
    }

    @java.lang.Override
    public void setKey(java.lang.String key) {
        this.key = key;
    }

    @java.lang.Override
    public java.lang.Boolean getModifiable() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl.__L1223, ((modifiable) == null))) {
            return java.lang.Boolean.FALSE;
        }else {
            return modifiable;
        }
    }

    @java.lang.Override
    public void setModifiable(java.lang.Boolean modifiable) {
        this.modifiable = modifiable;
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> getEnumValues() {
        return enumValues;
    }

    @java.lang.Override
    public void setEnumValues(java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> enumValues) {
        this.enumValues = enumValues;
    }

    @java.lang.Override
    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> getOrderItems() {
        return enumValues;
    }

    @java.lang.Override
    @java.lang.Deprecated
    public void setOrderItems(java.util.List<org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> orderItems) {
        this.enumValues = orderItems;
    }

    @java.lang.Override
    public <G extends org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration> org.broadleafcommerce.common.copy.CreateResponse<G> createOrRetrieveCopyInstance(org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse = context.createOrRetrieveCopyInstance(this);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl.__L1224, createResponse.isAlreadyPopulated())) {
            return createResponse;
        }
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration cloned = createResponse.getClone();
        cloned.setKey(key);
        cloned.setModifiable(modifiable);
        for (org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue value : enumValues) {
            org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue clonedValue = value.createOrRetrieveCopyInstance(context).getClone();
            cloned.getEnumValues().add(clonedValue);
        }
        return createResponse;
    }

    public static perturbation.location.PerturbationLocation __L1223;

    public static perturbation.location.PerturbationLocation __L1224;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl.__L1223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/enumeration/domain/DataDrivenEnumerationImpl.java:111)", 1223, "Boolean");
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl.__L1224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/enumeration/domain/DataDrivenEnumerationImpl.java:149)", 1224, "Boolean");
    }

    static {
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl.initPerturbationLocation0();
    }
}

