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
package org.broadleafcommerce.common.extension;


@org.springframework.stereotype.Service("blTemplateOnlyQueryExtensionManager")
public class TemplateOnlyQueryExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler> implements org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler {
    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation refineParameterRetrieve = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).refineParameterRetrieve(((java.lang.Class<?>) (params[0])), params[1], ((javax.persistence.criteria.CriteriaBuilder) (params[2])), ((javax.persistence.criteria.CriteriaQuery) (params[3])), ((javax.persistence.criteria.Root) (params[4])), ((java.util.List<javax.persistence.criteria.Predicate>) (params[5])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation refineQuery = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).refineQuery(((java.lang.Class<?>) (params[0])), params[1], ((javax.persistence.TypedQuery) (params[2])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation setup = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).setup(((java.lang.Class<?>) (params[0])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation breakdown = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).breakdown(((java.lang.Class<?>) (params[0])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation refineOrder = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).refineOrder(((java.lang.Class<?>) (params[0])), ((javax.persistence.criteria.CriteriaBuilder) (params[1])), ((javax.persistence.criteria.CriteriaQuery) (params[2])), ((javax.persistence.criteria.Root) (params[3])), ((java.util.List<javax.persistence.criteria.Order>) (params[4])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation isValidState = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).isValidState(((org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean>) (params[0])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation buildStatus = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).buildStatus(params[0], ((org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ItemStatus>) (params[1])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation filterResults = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler) (handler)).filterResults(((java.lang.Class<?>) (params[0])), params[1], ((java.util.List) (params[2])));
        }
    };

    public TemplateOnlyQueryExtensionManager() {
        super(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionHandler.class);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType refineParameterRetrieve(java.lang.Class<?> type, java.lang.Object testObject, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Predicate> restrictions) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.refineParameterRetrieve, type, testObject, builder, criteria, root, restrictions);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType refineQuery(java.lang.Class<?> type, java.lang.Object testObject, javax.persistence.TypedQuery query) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.refineQuery, type, testObject, query);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType setup(java.lang.Class<?> type) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.setup, type);
    }

    @java.lang.Override
    public boolean isEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.__L2494, true);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType breakdown(java.lang.Class<?> type) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.breakdown, type);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType refineOrder(java.lang.Class<?> type, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Order> sorts) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.refineOrder, type, builder, criteria, root, sorts);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType isValidState(org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> response) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.isValidState, response);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType buildStatus(java.lang.Object entity, org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ItemStatus> response) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.buildStatus, entity, response);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType filterResults(java.lang.Class<?> type, java.lang.Object testObject, java.util.List results) {
        return execute(org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.filterResults, type, testObject, results);
    }

    public static perturbation.location.PerturbationLocation __L2494;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.__L2494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/TemplateOnlyQueryExtensionManager.java:119)", 2494, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager.initPerturbationLocation0();
    }
}

