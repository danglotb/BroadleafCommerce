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
package org.broadleafcommerce.common.i18n.dao;


@org.springframework.stereotype.Repository("blTranslationDao")
public class TranslationDaoImpl implements org.broadleafcommerce.common.i18n.dao.TranslationDao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @javax.annotation.Resource(name = "blTranslationServiceExtensionManager")
    protected org.broadleafcommerce.common.i18n.service.TranslationServiceExtensionManager extensionManager;

    @javax.annotation.Resource(name = "blSandBoxHelper")
    protected org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;

    protected org.broadleafcommerce.common.util.dao.DynamicDaoHelper dynamicDaoHelper = new org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl();

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation save(org.broadleafcommerce.common.i18n.domain.Translation translation) {
        return em.merge(translation);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation create() {
        return ((org.broadleafcommerce.common.i18n.domain.Translation) (entityConfiguration.createEntityInstance(org.broadleafcommerce.common.i18n.domain.Translation.class.getName())));
    }

    @java.lang.Override
    public void delete(org.broadleafcommerce.common.i18n.domain.Translation translation) {
        em.remove(translation);
    }

    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.Object> getIdPropertyMetadata(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entity) {
        java.lang.Class<?> implClass = entityConfiguration.lookupEntityClass(entity.getType());
        return dynamicDaoHelper.getIdMetadata(implClass, ((org.hibernate.ejb.HibernateEntityManager) (em)));
    }

    @java.lang.Override
    public java.lang.Class<?> getEntityImpl(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entity) {
        return entityConfiguration.lookupEntityClass(entity.getType());
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation readTranslationById(java.lang.Long translationId) {
        return em.find(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, translationId);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> readTranslations(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entity, java.lang.String entityId, java.lang.String fieldName) {
        entityId = getUpdatedEntityId(entity, entityId);
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.i18n.domain.Translation> criteria = builder.createQuery(org.broadleafcommerce.common.i18n.domain.Translation.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.i18n.domain.TranslationImpl> translation = criteria.from(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        criteria.select(translation);
        criteria.where(builder.equal(translation.get("entityType"), entity.getFriendlyType()), builder.equal(translation.get("entityId"), entityId), builder.equal(translation.get("fieldName"), fieldName));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.i18n.domain.Translation> query = em.createQuery(criteria);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2740, true));
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation readTranslation(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entity, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode) {
        entityId = getUpdatedEntityId(entity, entityId);
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.i18n.domain.Translation> criteria = builder.createQuery(org.broadleafcommerce.common.i18n.domain.Translation.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.i18n.domain.TranslationImpl> translation = criteria.from(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        criteria.select(translation);
        criteria.where(builder.equal(translation.get("entityType"), entity.getFriendlyType()), builder.equal(translation.get("entityId"), entityId), builder.equal(translation.get("fieldName"), fieldName), builder.equal(translation.get("localeCode"), localeCode));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.i18n.domain.Translation> query = em.createQuery(criteria);
        query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2741, true));
        java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> translations = query.getResultList();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2744, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2742, translations.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2743, 1))))) {
            throw new java.lang.IllegalStateException(((((((("Found multiple translations for: " + (entity.getFriendlyType())) + "|") + entityId) + "|") + fieldName) + "|") + localeCode));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2746, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2745, translations.isEmpty()))))) {
            return translations.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2747, 0));
        }
        return null;
    }

    @java.lang.Override
    public java.lang.String getEntityId(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.Object entity) {
        java.util.Map<java.lang.String, java.lang.Object> idMetadata = getIdPropertyMetadata(entityType);
        java.lang.String idProperty = ((java.lang.String) (idMetadata.get("name")));
        org.hibernate.type.Type idType = ((org.hibernate.type.Type) (idMetadata.get("type")));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2751, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2750, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2748, (idType instanceof org.hibernate.type.LongType))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2749, (idType instanceof org.hibernate.type.StringType))))))))) {
            throw new java.lang.UnsupportedOperationException("Only ID types of String and Long are currently supported");
        }
        java.lang.Object idValue;
        try {
            idValue = org.apache.commons.beanutils.PropertyUtils.getProperty(entity, idProperty);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Error reading id property", e);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2752, (idType instanceof org.hibernate.type.StringType))) {
            return ((java.lang.String) (idValue));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2753, (idType instanceof org.hibernate.type.LongType))) {
                return getUpdatedEntityId(entityType, ((java.lang.Long) (idValue)));
            }

        throw new java.lang.IllegalArgumentException(java.lang.String.format(("Could not retrieve value for id property. Object: [%s], " + "ID Property: [%s], ID Type: [%s]"), entity, idProperty, idType));
    }

    @java.lang.Override
    public java.lang.Long countTranslationEntries(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, org.broadleafcommerce.common.extension.ResultType stage) {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<java.lang.Long> criteria = builder.createQuery(java.lang.Long.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.i18n.domain.TranslationImpl> root = criteria.from(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        criteria.select(builder.count(root));
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(root.get("entityType"), entityType.getFriendlyType()));
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2754, ((extensionManager) != null))) {
                extensionManager.getProxy().setup(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage);
                extensionManager.getProxy().refineParameterRetrieve(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage, builder, criteria, root, restrictions);
            }
            criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2755, restrictions.size())]));
            javax.persistence.TypedQuery<java.lang.Long> query = em.createQuery(criteria);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2756, ((extensionManager) != null))) {
                extensionManager.getProxy().refineQuery(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage, query);
            }
            query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2757, true));
            return query.getSingleResult();
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2758, ((extensionManager) != null))) {
                extensionManager.getProxy().breakdown(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage);
            }
        }
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> readAllTranslationEntries(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, org.broadleafcommerce.common.extension.ResultType stage) {
        return readAllTranslationEntries(entityType, stage, null);
    }

    public java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> readAllTranslationEntries(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, org.broadleafcommerce.common.extension.ResultType stage, java.util.List<java.lang.String> entityIds) {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.i18n.domain.Translation> criteria = builder.createQuery(org.broadleafcommerce.common.i18n.domain.Translation.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.i18n.domain.TranslationImpl> root = criteria.from(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        criteria.select(root);
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(root.get("entityType"), entityType.getFriendlyType()));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2759, org.apache.commons.collections.CollectionUtils.isNotEmpty(entityIds))) {
            restrictions.add(root.get("entityId").in(entityIds));
        }
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2760, ((extensionManager) != null))) {
                extensionManager.getProxy().setup(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage);
                extensionManager.getProxy().refineParameterRetrieve(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage, builder, criteria, root, restrictions);
            }
            criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2761, restrictions.size())]));
            javax.persistence.TypedQuery<org.broadleafcommerce.common.i18n.domain.Translation> query = em.createQuery(criteria);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2762, ((extensionManager) != null))) {
                extensionManager.getProxy().refineQuery(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage, query);
            }
            query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2763, true));
            return query.getResultList();
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2764, ((extensionManager) != null))) {
                extensionManager.getProxy().breakdown(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage);
            }
        }
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem> readConvertedTranslationEntries(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, org.broadleafcommerce.common.extension.ResultType stage) {
        java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> results = readAllTranslationEntries(entityType, stage);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2765, ((extensionManager) == null))) {
            throw new java.lang.IllegalStateException("extensionManager cannot be null");
        }
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem>> response = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem>>();
        extensionManager.getProxy().buildStatus(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, results, response);
        return response.getResult();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.domain.Translation readTranslation(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode, java.lang.String localeCountryCode, org.broadleafcommerce.common.extension.ResultType stage) {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.i18n.domain.Translation> criteria = builder.createQuery(org.broadleafcommerce.common.i18n.domain.Translation.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.i18n.domain.TranslationImpl> root = criteria.from(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        criteria.select(root);
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(root.get("entityType"), entityType.getFriendlyType()));
        restrictions.add(builder.equal(root.get("entityId"), entityId));
        restrictions.add(builder.equal(root.get("fieldName"), fieldName));
        restrictions.add(builder.like(root.get("localeCode").as(java.lang.String.class), (localeCode + "%")));
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2766, ((extensionManager) != null))) {
                extensionManager.getProxy().setup(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage);
                extensionManager.getProxy().refineParameterRetrieve(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage, builder, criteria, root, restrictions);
            }
            criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2767, restrictions.size())]));
            javax.persistence.TypedQuery<org.broadleafcommerce.common.i18n.domain.Translation> query = em.createQuery(criteria);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2768, ((extensionManager) != null))) {
                extensionManager.getProxy().refineQuery(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage, query);
            }
            query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2769, true));
            java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> translations = query.getResultList();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2771, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2770, translations.isEmpty()))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2773, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2772, localeCode.equals(localeCountryCode)))))) {
                    return findBestTranslation(localeCountryCode, translations);
                }else {
                    return findSpecificTranslation(localeCountryCode, translations);
                }
            }else {
                return null;
            }
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2774, ((extensionManager) != null))) {
                extensionManager.getProxy().breakdown(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, stage);
            }
        }
    }

    protected java.lang.String getUpdatedEntityId(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId) {
        return getUpdatedEntityId(entityType, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2775, java.lang.Long.parseLong(entityId)));
    }

    protected java.lang.String getUpdatedEntityId(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.Long idValue) {
        org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse originalIdResponse = sandBoxHelper.getOriginalId(getEntityImpl(entityType), idValue);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2778, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2776, originalIdResponse.isRecordFound())) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2777, ((originalIdResponse.getOriginalId()) != null)))))) {
            idValue = originalIdResponse.getOriginalId();
            originalIdResponse = sandBoxHelper.getProductionOriginalId(getEntityImpl(entityType), idValue);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2782, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2779, originalIdResponse.isRecordFound())) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2781, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2780, originalIdResponse.getOriginalId().equals(idValue))))))))) {
                idValue = originalIdResponse.getOriginalId();
            }
        }
        return java.lang.String.valueOf(idValue);
    }

    protected org.broadleafcommerce.common.i18n.domain.Translation findBestTranslation(java.lang.String specificLocale, java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> translations) {
        for (org.broadleafcommerce.common.i18n.domain.Translation translation : translations) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2783, translation.getLocaleCode().equals(specificLocale))) {
                return translation;
            }
        }
        return translations.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2784, 0));
    }

    protected org.broadleafcommerce.common.i18n.domain.Translation findSpecificTranslation(java.lang.String localeCountryCode, java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> translations) {
        for (org.broadleafcommerce.common.i18n.domain.Translation translation : translations) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2785, translation.getLocaleCode().equals(localeCountryCode))) {
                return translation;
            }
        }
        return null;
    }

    public org.broadleafcommerce.common.util.dao.DynamicDaoHelper getDynamicDaoHelper() {
        return dynamicDaoHelper;
    }

    public void setDynamicDaoHelper(org.broadleafcommerce.common.util.dao.DynamicDaoHelper dynamicDaoHelper) {
        this.dynamicDaoHelper = dynamicDaoHelper;
    }

    public static perturbation.location.PerturbationLocation __L2740;

    public static perturbation.location.PerturbationLocation __L2741;

    public static perturbation.location.PerturbationLocation __L2742;

    public static perturbation.location.PerturbationLocation __L2743;

    public static perturbation.location.PerturbationLocation __L2744;

    public static perturbation.location.PerturbationLocation __L2745;

    public static perturbation.location.PerturbationLocation __L2746;

    public static perturbation.location.PerturbationLocation __L2747;

    public static perturbation.location.PerturbationLocation __L2748;

    public static perturbation.location.PerturbationLocation __L2749;

    public static perturbation.location.PerturbationLocation __L2750;

    public static perturbation.location.PerturbationLocation __L2751;

    public static perturbation.location.PerturbationLocation __L2752;

    public static perturbation.location.PerturbationLocation __L2753;

    public static perturbation.location.PerturbationLocation __L2754;

    public static perturbation.location.PerturbationLocation __L2755;

    public static perturbation.location.PerturbationLocation __L2756;

    public static perturbation.location.PerturbationLocation __L2757;

    public static perturbation.location.PerturbationLocation __L2758;

    public static perturbation.location.PerturbationLocation __L2759;

    public static perturbation.location.PerturbationLocation __L2760;

    public static perturbation.location.PerturbationLocation __L2761;

    public static perturbation.location.PerturbationLocation __L2762;

    public static perturbation.location.PerturbationLocation __L2763;

    public static perturbation.location.PerturbationLocation __L2764;

    public static perturbation.location.PerturbationLocation __L2765;

    public static perturbation.location.PerturbationLocation __L2766;

    public static perturbation.location.PerturbationLocation __L2767;

    public static perturbation.location.PerturbationLocation __L2768;

    public static perturbation.location.PerturbationLocation __L2769;

    public static perturbation.location.PerturbationLocation __L2770;

    public static perturbation.location.PerturbationLocation __L2771;

    public static perturbation.location.PerturbationLocation __L2772;

    public static perturbation.location.PerturbationLocation __L2773;

    public static perturbation.location.PerturbationLocation __L2774;

    public static perturbation.location.PerturbationLocation __L2775;

    public static perturbation.location.PerturbationLocation __L2776;

    public static perturbation.location.PerturbationLocation __L2777;

    public static perturbation.location.PerturbationLocation __L2778;

    public static perturbation.location.PerturbationLocation __L2779;

    public static perturbation.location.PerturbationLocation __L2780;

    public static perturbation.location.PerturbationLocation __L2781;

    public static perturbation.location.PerturbationLocation __L2782;

    public static perturbation.location.PerturbationLocation __L2783;

    public static perturbation.location.PerturbationLocation __L2784;

    public static perturbation.location.PerturbationLocation __L2785;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:116)", 2740, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:136)", 2741, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:138)", 2742, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:138)", 2743, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:138)", 2744, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:141)", 2745, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:141)", 2746, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:142)", 2747, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:153)", 2748, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:153)", 2749, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:153)", 2750, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:153)", 2751, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:164)", 2752, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:166)", 2753, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:183)", 2754, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:187)", 2755, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:190)", 2756, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:193)", 2757, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:196)", 2758, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:214)", 2759, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:218)", 2760, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:222)", 2761, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:225)", 2762, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:228)", 2763, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:231)", 2764, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:240)", 2765, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:260)", 2766, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:264)", 2767, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:267)", 2768, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:270)", 2769, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:273)", 2770, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:273)", 2771, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:274)", 2772, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:274)", 2773, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:283)", 2774, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:290)", 2775, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:295)", 2776, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:295)", 2777, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:295)", 2778, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:299)", 2779, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:299)", 2780, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:299)", 2781, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:299)", 2782, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:308)", 2783, "Boolean");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:312)", 2784, "Numerical");
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.__L2785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/dao/TranslationDaoImpl.java:317)", 2785, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.dao.TranslationDaoImpl.initPerturbationLocation0();
    }
}

