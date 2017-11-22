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
package org.broadleafcommerce.common.i18n.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_TRANSLATION")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blTranslationElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(populateToOneFields = org.broadleafcommerce.common.presentation.PopulateToOneFieldsEnum.TRUE, friendlyName = "TranslationImpl_baseTranslation")
@org.hibernate.annotations.Table(appliesTo = "BLC_TRANSLATION", indexes = { @org.hibernate.annotations.Index(name = "TRANSLATION_INDEX", columnNames = { "ENTITY_TYPE", "ENTITY_ID", "FIELD_NAME", "LOCALE_CODE" }) })
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.SANDBOX, skipOverlaps = true), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_CATALOG), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE) })
public class TranslationImpl implements java.io.Serializable , org.broadleafcommerce.common.i18n.domain.Translation {
    private static final long serialVersionUID = -122818474469147685L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "TranslationId")
    @org.hibernate.annotations.GenericGenerator(name = "TranslationId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "TranslationImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.i18n.domain.TranslationImpl") })
    @javax.persistence.Column(name = "TRANSLATION_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "ENTITY_TYPE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TranslationImpl_EntityType", prominent = true)
    protected java.lang.String entityType;

    @javax.persistence.Column(name = "ENTITY_ID")
    @org.broadleafcommerce.common.presentation.AdminPresentation(visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL)
    protected java.lang.String entityId;

    @javax.persistence.Column(name = "FIELD_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TranslationImpl_FieldName", prominent = true)
    protected java.lang.String fieldName;

    @javax.persistence.Column(name = "LOCALE_CODE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TranslationImpl_LocaleCode", prominent = true)
    protected java.lang.String localeCode;

    @javax.persistence.Column(name = "TRANSLATED_VALUE", length = (java.lang.Integer.MAX_VALUE) - 1)
    @javax.persistence.Lob
    @org.hibernate.annotations.Type(type = "org.hibernate.type.StringClobType")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TranslationImpl_TranslatedValue", prominent = true, requiredOverride = org.broadleafcommerce.common.presentation.RequiredOverride.REQUIRED)
    protected java.lang.String translatedValue;

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.TranslatedEntity getEntityType() {
        return org.broadleafcommerce.common.i18n.domain.TranslatedEntity.getInstanceFromFriendlyType(entityType);
    }

    @java.lang.Override
    public void setEntityType(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType) {
        this.entityType = entityType.getFriendlyType();
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
    public java.lang.String getEntityId() {
        return entityId;
    }

    @java.lang.Override
    public void setEntityId(java.lang.String entityId) {
        this.entityId = entityId;
    }

    @java.lang.Override
    public java.lang.String getFieldName() {
        return fieldName;
    }

    @java.lang.Override
    public void setFieldName(java.lang.String fieldName) {
        this.fieldName = fieldName;
    }

    @java.lang.Override
    public java.lang.String getLocaleCode() {
        return localeCode;
    }

    @java.lang.Override
    public void setLocaleCode(java.lang.String localeCode) {
        this.localeCode = localeCode;
    }

    @java.lang.Override
    public java.lang.String getTranslatedValue() {
        return translatedValue;
    }

    @java.lang.Override
    public void setTranslatedValue(java.lang.String translatedValue) {
        this.translatedValue = translatedValue;
    }

    @java.lang.Override
    public <G extends org.broadleafcommerce.common.i18n.domain.Translation> org.broadleafcommerce.common.copy.CreateResponse<G> createOrRetrieveCopyInstance(org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse = context.createOrRetrieveCopyInstance(this);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslationImpl.__L2899, createResponse.isAlreadyPopulated())) {
            return createResponse;
        }
        org.broadleafcommerce.common.i18n.domain.Translation cloned = createResponse.getClone();
        java.lang.Object referenceClone;
        try {
            referenceClone = context.getPreviousClone(java.lang.Class.forName(getEntityType().getType()), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.domain.TranslationImpl.__L2900, java.lang.Long.parseLong(entityId)));
        } catch (java.lang.ClassNotFoundException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
        java.lang.String convertedId = entityId;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.TranslationImpl.__L2901, (referenceClone != null))) {
            convertedId = java.lang.String.valueOf(context.getIdentifier(referenceClone));
        }
        cloned.setEntityId(convertedId);
        cloned.setFieldName(fieldName);
        cloned.setLocaleCode(localeCode);
        cloned.setTranslatedValue(translatedValue);
        cloned.setEntityType(getEntityType());
        return createResponse;
    }

    public static perturbation.location.PerturbationLocation __L2899;

    public static perturbation.location.PerturbationLocation __L2900;

    public static perturbation.location.PerturbationLocation __L2901;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.domain.TranslationImpl.__L2899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslationImpl.java:173)", 2899, "Boolean");
        org.broadleafcommerce.common.i18n.domain.TranslationImpl.__L2900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslationImpl.java:181)", 2900, "Numerical");
        org.broadleafcommerce.common.i18n.domain.TranslationImpl.__L2901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/TranslationImpl.java:186)", 2901, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.domain.TranslationImpl.initPerturbationLocation0();
    }
}

