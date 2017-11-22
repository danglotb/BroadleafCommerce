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
package org.broadleafcommerce.common.i18n.service;


@org.springframework.stereotype.Component("blSparseTranslationOverrideStrategy")
public class SparseTranslationOverrideStrategy implements org.broadleafcommerce.common.cache.OverridePreCacheInitializer , org.broadleafcommerce.common.i18n.service.TranslationOverrideStrategy {
    public static final int PRECACHED_SPARSE_OVERRIDE_ORDER = -1000;

    @javax.annotation.Resource(name = "blOverridePreCacheService")
    protected org.broadleafcommerce.common.cache.OverridePreCacheService preCachedSparseOverrideService;

    @javax.annotation.Resource(name = "blTemplateOnlyQueryExtensionManager")
    protected org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager extensionManager;

    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blTranslationDao")
    protected org.broadleafcommerce.common.i18n.dao.TranslationDao dao;

    org.broadleafcommerce.common.util.dao.DynamicDaoHelper helper = new org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl();

    @org.springframework.beans.factory.annotation.Value("${precached.sparse.override.translation.template.enabled:true}")
    protected boolean templateEnabled = true;

    @org.springframework.beans.factory.annotation.Value("${precached.sparse.override.translation.template.search.restrict.association:false}")
    protected boolean restrictAssociation = false;

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.service.LocalePair getLocaleBasedOverride(java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String basicCacheKey) {
        org.broadleafcommerce.common.i18n.service.LocalePair override = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2931, preCachedSparseOverrideService.isActiveForType(org.broadleafcommerce.common.i18n.domain.Translation.class.getName()))) {
            boolean isSpecificOnly = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2934, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2932, localeCode.equals(localeCountryCode))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2933, localeCode.contains("_")))));
            boolean isGeneralOnly = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2938, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2935, localeCode.equals(localeCountryCode))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2937, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2936, localeCode.contains("_"))))))));
            java.lang.String specificCacheKey = getCacheKey(entityType, entityId, property, localeCountryCode);
            java.lang.String generalCacheKey = getCacheKey(entityType, entityId, property, localeCode);
            java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem> overrides;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2939, isSpecificOnly)) {
                overrides = preCachedSparseOverrideService.findElements(specificCacheKey);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2940, isGeneralOnly)) {
                    overrides = preCachedSparseOverrideService.findElements(generalCacheKey);
                }else {
                    overrides = preCachedSparseOverrideService.findElements(specificCacheKey, generalCacheKey);
                }

            override = new org.broadleafcommerce.common.i18n.service.LocalePair();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2942, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2941, overrides.isEmpty()))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2946, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2943, isSpecificOnly)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2945, ((org.broadleafcommerce.common.extension.ItemStatus.NONE) != (overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2944, 0)).getItemStatus()))))))) {
                    org.broadleafcommerce.common.extension.StandardCacheItem specificTranslation = overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2947, 0));
                    override.setSpecificItem(specificTranslation);
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2951, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2948, isGeneralOnly)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2950, ((org.broadleafcommerce.common.extension.ItemStatus.NONE) != (overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2949, 0)).getItemStatus()))))))) {
                        org.broadleafcommerce.common.extension.StandardCacheItem generalTranslation = overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2952, 0));
                        override.setGeneralItem(generalTranslation);
                    }

                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2957, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2954, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2953, isSpecificOnly))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2956, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2955, isGeneralOnly)))))))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2959, ((org.broadleafcommerce.common.extension.ItemStatus.NONE) != (overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2958, 0)).getItemStatus())))) {
                        org.broadleafcommerce.common.extension.StandardCacheItem specificTranslation = overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2960, 0));
                        override.setSpecificItem(specificTranslation);
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2962, ((org.broadleafcommerce.common.extension.ItemStatus.NONE) != (overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2961, 1)).getItemStatus())))) {
                        org.broadleafcommerce.common.extension.StandardCacheItem generalTranslation = overrides.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2963, 1));
                        override.setGeneralItem(generalTranslation);
                    }
                }
            }
        }
        return override;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.service.LocalePair getLocaleBasedTemplateValue(java.lang.String templateCacheKey, java.lang.String property, org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String localeCode, java.lang.String localeCountryCode, java.lang.String specificPropertyKey, java.lang.String generalPropertyKey) {
        org.broadleafcommerce.common.i18n.service.LocalePair override = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2964, preCachedSparseOverrideService.isActiveForType(org.broadleafcommerce.common.i18n.domain.Translation.class.getName()))) {
            org.broadleafcommerce.common.site.domain.Site currentSite = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getNonPersistentSite();
            boolean isIsolatedActive = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2965, false);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2966, (currentSite != null))) {
                isIsolatedActive = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2967, preCachedSparseOverrideService.isActiveIsolatedSiteForType(currentSite.getId(), org.broadleafcommerce.common.i18n.domain.TranslationImpl.class.getName()));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2970, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2968, isIsolatedActive)) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2969, templateEnabled))))) {
                override = new org.broadleafcommerce.common.i18n.service.LocalePair();
                java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> templateVals;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2972, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2971, isIsolatedActive))))) {
                    templateVals = getTemplateTranslations(entityType, entityId, property, localeCode);
                }else {
                    templateVals = new java.util.ArrayList<org.broadleafcommerce.common.i18n.domain.Translation>();
                    org.broadleafcommerce.common.i18n.domain.Translation translation = dao.readTranslation(entityType, entityId, property, localeCode, localeCountryCode, org.broadleafcommerce.common.extension.ResultType.CATALOG_ONLY);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2973, (translation != null))) {
                        templateVals.add(translation);
                    }
                }
                java.util.List<java.lang.String> codesToMatch = new java.util.ArrayList<java.lang.String>();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2976, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2974, specificPropertyKey.endsWith(localeCountryCode))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2975, generalPropertyKey.endsWith(localeCountryCode)))))) {
                    codesToMatch.add(localeCountryCode);
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2979, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2977, specificPropertyKey.endsWith(localeCode))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2978, generalPropertyKey.endsWith(localeCode)))))) {
                        codesToMatch.add(localeCode);
                    }else {
                        codesToMatch.add(localeCountryCode);
                        codesToMatch.add(localeCode);
                    }

                for (java.lang.String code : codesToMatch) {
                    for (org.broadleafcommerce.common.i18n.domain.Translation templateVal : templateVals) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2980, templateVal.getLocaleCode().equals(code))) {
                            org.broadleafcommerce.common.extension.StandardCacheItem cacheItem = new org.broadleafcommerce.common.extension.StandardCacheItem();
                            cacheItem.setItemStatus(org.broadleafcommerce.common.extension.ItemStatus.NORMAL);
                            cacheItem.setCacheItem(templateVal);
                            override.setSpecificItem(cacheItem);
                            break;
                        }
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2981, ((override.getSpecificItem()) != null))) {
                        break;
                    }
                }
            }
        }
        return override;
    }

    @java.lang.Override
    public boolean isOverrideQualified(java.lang.Class<?> type) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2982, org.broadleafcommerce.common.i18n.domain.Translation.class.isAssignableFrom(type));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.StandardCacheItem initializeOverride(java.lang.Object entity) {
        java.lang.String key = getCacheKey(((org.broadleafcommerce.common.i18n.domain.Translation) (entity)));
        java.lang.String dto = ((org.broadleafcommerce.common.i18n.domain.Translation) (entity)).getTranslatedValue();
        org.broadleafcommerce.common.extension.StandardCacheItem cacheItem = new org.broadleafcommerce.common.extension.StandardCacheItem();
        org.broadleafcommerce.common.extension.ItemStatus status = org.broadleafcommerce.common.extension.ItemStatus.NORMAL;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2983, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ItemStatus> response = new org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ItemStatus>();
            org.broadleafcommerce.common.extension.ExtensionResultStatusType result = extensionManager.buildStatus(entity, response);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2986, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2984, ((org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED) != result))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2985, ((response.getResult()) != null)))))) {
                status = response.getResult();
            }
        }
        cacheItem.setItemStatus(status);
        cacheItem.setKey(key);
        cacheItem.setCacheItem(dto);
        return cacheItem;
    }

    @java.lang.Override
    public boolean validateTemplateProcessing(java.lang.String standardCacheKey, java.lang.String templateCacheKey) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2987, true);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2988, org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.PRECACHED_SPARSE_OVERRIDE_ORDER);
    }

    public boolean isTemplateEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2989, templateEnabled);
    }

    public void setTemplateEnabled(boolean templateEnabled) {
        this.templateEnabled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2990, templateEnabled);
    }

    public boolean isRestrictAssociation() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2991, restrictAssociation);
    }

    public void setRestrictAssociation(boolean restrictAssociation) {
        this.restrictAssociation = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2992, restrictAssociation);
    }

    protected java.util.List<org.broadleafcommerce.common.i18n.domain.Translation> getTemplateTranslations(org.broadleafcommerce.common.i18n.domain.TranslatedEntity entityType, java.lang.String entityId, java.lang.String property, java.lang.String localeCode) {
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.i18n.domain.Translation> criteria = builder.createQuery(org.broadleafcommerce.common.i18n.domain.Translation.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.i18n.domain.TranslationImpl> root = criteria.from(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        criteria.select(root);
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(root.get("entityType"), entityType.getFriendlyType()));
        restrictions.add(builder.equal(root.get("entityId"), entityId));
        restrictions.add(builder.equal(root.get("fieldName"), property));
        restrictions.add(builder.like(root.get("localeCode").as(java.lang.String.class), (localeCode + "%")));
        try {
            java.lang.Object testObject = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2993, restrictAssociation)) {
                try {
                    java.lang.Class<?> type = java.lang.Class.forName(entityType.getType());
                    org.hibernate.SessionFactory sessionFactory = ((org.hibernate.ejb.criteria.CriteriaBuilderImpl) (em.getCriteriaBuilder())).getEntityManagerFactory().getSessionFactory();
                    java.lang.Class<?>[] entities = helper.getAllPolymorphicEntitiesFromCeiling(type, sessionFactory, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2994, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2995, true));
                    java.util.Map<java.lang.String, java.lang.Object> idMetadata = helper.getIdMetadata(entities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2998, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2996, entities.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2997, 1))))], ((org.hibernate.ejb.HibernateEntityManager) (em)));
                    org.hibernate.type.Type idType = ((org.hibernate.type.Type) (idMetadata.get("type")));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2999, (idType instanceof org.hibernate.type.StringType))) {
                        testObject = em.find(entities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3002, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3000, entities.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3001, 1))))], entityId);
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3003, (idType instanceof org.hibernate.type.LongType))) {
                            testObject = em.find(entities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3006, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3004, entities.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3005, 1))))], perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3007, java.lang.Long.parseLong(entityId)));
                        }

                } catch (java.lang.ClassNotFoundException e) {
                    throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3008, ((extensionManager) != null))) {
                extensionManager.setup(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
                extensionManager.refineParameterRetrieve(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, testObject, builder, criteria, root, restrictions);
            }
            criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3009, restrictions.size())]));
            javax.persistence.TypedQuery<org.broadleafcommerce.common.i18n.domain.Translation> query = em.createQuery(criteria);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3010, ((extensionManager) != null))) {
                extensionManager.refineQuery(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, testObject, query);
            }
            query.setHint(org.hibernate.ejb.QueryHints.HINT_CACHEABLE, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3011, true));
            java.util.List response = query.getResultList();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3012, ((extensionManager) != null))) {
                extensionManager.filterResults(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class, testObject, response);
            }
            return response;
        } finally {
            extensionManager.breakdown(org.broadleafcommerce.common.i18n.domain.TranslationImpl.class);
        }
    }

    protected java.lang.String getCacheKey(org.broadleafcommerce.common.i18n.domain.Translation translation) {
        return getCacheKey(translation.getEntityType(), translation.getEntityId(), translation.getFieldName(), translation.getLocaleCode());
    }

    protected java.lang.String getCacheKey(org.broadleafcommerce.common.i18n.domain.TranslatedEntity type, java.lang.String entityId, java.lang.String fieldName, java.lang.String localeCode) {
        return org.apache.commons.lang3.StringUtils.join(new java.lang.String[]{ "translation", type.getType(), entityId, fieldName, localeCode }, "-");
    }

    public static perturbation.location.PerturbationLocation __L2931;

    public static perturbation.location.PerturbationLocation __L2932;

    public static perturbation.location.PerturbationLocation __L2933;

    public static perturbation.location.PerturbationLocation __L2934;

    public static perturbation.location.PerturbationLocation __L2935;

    public static perturbation.location.PerturbationLocation __L2936;

    public static perturbation.location.PerturbationLocation __L2937;

    public static perturbation.location.PerturbationLocation __L2938;

    public static perturbation.location.PerturbationLocation __L2939;

    public static perturbation.location.PerturbationLocation __L2940;

    public static perturbation.location.PerturbationLocation __L2941;

    public static perturbation.location.PerturbationLocation __L2942;

    public static perturbation.location.PerturbationLocation __L2943;

    public static perturbation.location.PerturbationLocation __L2944;

    public static perturbation.location.PerturbationLocation __L2945;

    public static perturbation.location.PerturbationLocation __L2946;

    public static perturbation.location.PerturbationLocation __L2947;

    public static perturbation.location.PerturbationLocation __L2948;

    public static perturbation.location.PerturbationLocation __L2949;

    public static perturbation.location.PerturbationLocation __L2950;

    public static perturbation.location.PerturbationLocation __L2951;

    public static perturbation.location.PerturbationLocation __L2952;

    public static perturbation.location.PerturbationLocation __L2953;

    public static perturbation.location.PerturbationLocation __L2954;

    public static perturbation.location.PerturbationLocation __L2955;

    public static perturbation.location.PerturbationLocation __L2956;

    public static perturbation.location.PerturbationLocation __L2957;

    public static perturbation.location.PerturbationLocation __L2958;

    public static perturbation.location.PerturbationLocation __L2959;

    public static perturbation.location.PerturbationLocation __L2960;

    public static perturbation.location.PerturbationLocation __L2961;

    public static perturbation.location.PerturbationLocation __L2962;

    public static perturbation.location.PerturbationLocation __L2963;

    public static perturbation.location.PerturbationLocation __L2964;

    public static perturbation.location.PerturbationLocation __L2965;

    public static perturbation.location.PerturbationLocation __L2966;

    public static perturbation.location.PerturbationLocation __L2967;

    public static perturbation.location.PerturbationLocation __L2968;

    public static perturbation.location.PerturbationLocation __L2969;

    public static perturbation.location.PerturbationLocation __L2970;

    public static perturbation.location.PerturbationLocation __L2971;

    public static perturbation.location.PerturbationLocation __L2972;

    public static perturbation.location.PerturbationLocation __L2973;

    public static perturbation.location.PerturbationLocation __L2974;

    public static perturbation.location.PerturbationLocation __L2975;

    public static perturbation.location.PerturbationLocation __L2976;

    public static perturbation.location.PerturbationLocation __L2977;

    public static perturbation.location.PerturbationLocation __L2978;

    public static perturbation.location.PerturbationLocation __L2979;

    public static perturbation.location.PerturbationLocation __L2980;

    public static perturbation.location.PerturbationLocation __L2981;

    public static perturbation.location.PerturbationLocation __L2982;

    public static perturbation.location.PerturbationLocation __L2983;

    public static perturbation.location.PerturbationLocation __L2984;

    public static perturbation.location.PerturbationLocation __L2985;

    public static perturbation.location.PerturbationLocation __L2986;

    public static perturbation.location.PerturbationLocation __L2987;

    public static perturbation.location.PerturbationLocation __L2988;

    public static perturbation.location.PerturbationLocation __L2989;

    public static perturbation.location.PerturbationLocation __L2990;

    public static perturbation.location.PerturbationLocation __L2991;

    public static perturbation.location.PerturbationLocation __L2992;

    public static perturbation.location.PerturbationLocation __L2993;

    public static perturbation.location.PerturbationLocation __L2994;

    public static perturbation.location.PerturbationLocation __L2995;

    public static perturbation.location.PerturbationLocation __L2996;

    public static perturbation.location.PerturbationLocation __L2997;

    public static perturbation.location.PerturbationLocation __L2998;

    public static perturbation.location.PerturbationLocation __L2999;

    public static perturbation.location.PerturbationLocation __L3000;

    public static perturbation.location.PerturbationLocation __L3001;

    public static perturbation.location.PerturbationLocation __L3002;

    public static perturbation.location.PerturbationLocation __L3003;

    public static perturbation.location.PerturbationLocation __L3004;

    public static perturbation.location.PerturbationLocation __L3005;

    public static perturbation.location.PerturbationLocation __L3006;

    public static perturbation.location.PerturbationLocation __L3007;

    public static perturbation.location.PerturbationLocation __L3008;

    public static perturbation.location.PerturbationLocation __L3009;

    public static perturbation.location.PerturbationLocation __L3010;

    public static perturbation.location.PerturbationLocation __L3011;

    public static perturbation.location.PerturbationLocation __L3012;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:144)", 2931, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:145)", 2932, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:145)", 2933, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:145)", 2934, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:146)", 2935, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:146)", 2936, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:146)", 2937, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:146)", 2938, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:150)", 2939, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:152)", 2940, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:158)", 2941, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:158)", 2942, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:159)", 2943, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:159)", 2944, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:159)", 2945, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:159)", 2946, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:160)", 2947, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:162)", 2948, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:162)", 2949, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:162)", 2950, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:162)", 2951, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:163)", 2952, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:166)", 2953, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:166)", 2954, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:166)", 2955, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:166)", 2956, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:166)", 2957, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:167)", 2958, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:167)", 2959, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:168)", 2960, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:171)", 2961, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:171)", 2962, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:172)", 2963, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:186)", 2964, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:188)", 2965, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:189)", 2966, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:190)", 2967, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:192)", 2968, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:192)", 2969, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:192)", 2970, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:195)", 2971, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:195)", 2972, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:201)", 2973, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:206)", 2974, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:206)", 2975, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:206)", 2976, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:208)", 2977, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:208)", 2978, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:208)", 2979, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:216)", 2980, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:224)", 2981, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:235)", 2982, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:244)", 2983, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:247)", 2984, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:247)", 2985, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:247)", 2986, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:259)", 2987, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:264)", 2988, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:268)", 2989, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:272)", 2990, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:276)", 2991, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:280)", 2992, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:295)", 2993, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:299)", 2994, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:299)", 2995, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:301)", 2996, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:301)", 2997, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:301)", 2998, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L2999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:303)", 2999, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:304)", 3000, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:304)", 3001, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:304)", 3002, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:305)", 3003, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:306)", 3004, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:306)", 3005, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:306)", 3006, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:306)", 3007, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:312)", 3008, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:316)", 3009, "Numerical");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:319)", 3010, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:322)", 3011, "Boolean");
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.__L3012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/service/SparseTranslationOverrideStrategy.java:324)", 3012, "Boolean");
    }

    static {
        org.broadleafcommerce.common.i18n.service.SparseTranslationOverrideStrategy.initPerturbationLocation0();
    }
}

