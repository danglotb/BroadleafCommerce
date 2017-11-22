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


public interface SparselyPopulatedQueryExtensionHandler extends org.broadleafcommerce.common.extension.ExtensionHandler {
    org.broadleafcommerce.common.extension.ExtensionResultStatusType refineRetrieve(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Predicate> restrictions);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType refineParameterRetrieve(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Predicate> restrictions);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType refineQuery(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType, javax.persistence.TypedQuery query);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType setup(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType breakdown(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType refineOrder(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Order> sorts);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType refineResults(java.lang.Class<?> type, org.broadleafcommerce.common.extension.ResultType resultType, java.util.List queryResults, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getResultType(java.lang.Object testObject, org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.extension.ResultType> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getCacheKey(java.lang.Object testObject, java.lang.String qualifier, org.broadleafcommerce.common.extension.ResultType resultType, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getCacheKey(java.lang.String qualifier, org.broadleafcommerce.common.extension.ResultType resultType, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getCacheKeyListForTemplateSite(java.lang.String qualifier, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<java.lang.String>> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType buildStatus(java.lang.Class<?> type, java.util.List queryResults, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.extension.StandardCacheItem>> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType isValidState(org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> response);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getNormalizedId(java.lang.Object testObject, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> response);
}

