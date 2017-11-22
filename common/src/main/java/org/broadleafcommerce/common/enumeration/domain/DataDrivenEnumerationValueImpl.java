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
@javax.persistence.Table(name = "BLC_DATA_DRVN_ENUM_VAL")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "DataDrivenEnumerationValueImpl_friendyName")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.SANDBOX, skipOverlaps = true), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE) })
public class DataDrivenEnumerationValueImpl implements org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "DataDrivenEnumerationValueId")
    @org.hibernate.annotations.GenericGenerator(name = "DataDrivenEnumerationValueId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "DataDrivenEnumerationValueImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl") })
    @javax.persistence.Column(name = "ENUM_VAL_ID")
    protected java.lang.Long id;

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl.class, cascade = javax.persistence.CascadeType.REFRESH)
    @javax.persistence.JoinColumn(name = "ENUM_TYPE")
    protected org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration type;

    @javax.persistence.Column(name = "ENUM_KEY")
    @org.hibernate.annotations.Index(name = "ENUM_VAL_KEY_INDEX", columnNames = { "ENUM_KEY" })
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "DataDrivenEnumerationValueImpl_Key", order = 1, gridOrder = 1, prominent = true)
    protected java.lang.String key;

    @javax.persistence.Column(name = "DISPLAY")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "DataDrivenEnumerationValueImpl_Display", order = 2, gridOrder = 2, prominent = true)
    protected java.lang.String display;

    @javax.persistence.Column(name = "HIDDEN")
    @org.hibernate.annotations.Index(name = "HIDDEN_INDEX", columnNames = { "HIDDEN" })
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "DataDrivenEnumerationValueImpl_Hidden", order = 3, gridOrder = 3, prominent = true)
    protected java.lang.Boolean hidden = ((boolean) (false));

    @java.lang.Override
    public java.lang.String getDisplay() {
        return display;
    }

    @java.lang.Override
    public void setDisplay(java.lang.String display) {
        this.display = display;
    }

    @java.lang.Override
    public java.lang.Boolean getHidden() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.__L1225, ((hidden) == null))) {
            return java.lang.Boolean.FALSE;
        }else {
            return hidden;
        }
    }

    @java.lang.Override
    public void setHidden(java.lang.Boolean hidden) {
        this.hidden = hidden;
    }

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
    public org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration getType() {
        return type;
    }

    @java.lang.Override
    public void setType(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration type) {
        this.type = type;
    }

    @java.lang.Override
    public <G extends org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue> org.broadleafcommerce.common.copy.CreateResponse<G> createOrRetrieveCopyInstance(org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse = context.createOrRetrieveCopyInstance(this);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.__L1226, createResponse.isAlreadyPopulated())) {
            return createResponse;
        }
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue cloned = createResponse.getClone();
        cloned.setKey(key);
        cloned.setDisplay(display);
        cloned.setHidden(hidden);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.__L1227, ((type) != null))) {
            cloned.setType(type.createOrRetrieveCopyInstance(context).getClone());
        }
        return createResponse;
    }

    public static perturbation.location.PerturbationLocation __L1225;

    public static perturbation.location.PerturbationLocation __L1226;

    public static perturbation.location.PerturbationLocation __L1227;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.__L1225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/enumeration/domain/DataDrivenEnumerationValueImpl.java:103)", 1225, "Boolean");
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.__L1226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/enumeration/domain/DataDrivenEnumerationValueImpl.java:148)", 1226, "Boolean");
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.__L1227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/enumeration/domain/DataDrivenEnumerationValueImpl.java:155)", 1227, "Boolean");
    }

    static {
        org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl.initPerturbationLocation0();
    }
}

