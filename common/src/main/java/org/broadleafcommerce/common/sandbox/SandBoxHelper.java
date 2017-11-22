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
package org.broadleafcommerce.common.sandbox;


public interface SandBoxHelper {
    public class OriginalIdResponse {
        private boolean recordFound = false;

        private java.lang.Long originalId;

        public boolean isRecordFound() {
            return recordFound;
        }

        public void setRecordFound(boolean recordFound) {
            this.recordFound = recordFound;
        }

        public java.lang.Long getOriginalId() {
            return originalId;
        }

        public void setOriginalId(java.lang.Long originalId) {
            this.originalId = originalId;
        }
    }

    java.util.List<java.lang.Long> mergeCloneIds(java.lang.Class<?> type, java.lang.Long... originalIds);

    void ignoreCloneCache(boolean ignoreCache);

    com.google.common.collect.BiMap<java.lang.Long, java.lang.Long> getSandBoxToOriginalMap(java.lang.Class<?> type, java.lang.Long... ids);

    java.lang.Long getSandBoxVersionId(java.lang.Class<?> linkedObjectType, java.lang.Long requestedParent);

    java.lang.Long getCascadedProductionStateId(java.lang.Class<?> linkedObjectType, java.lang.Long requestedParent);

    java.lang.Long retrieveCascadedState(java.lang.Class<?> ceilingImpl, java.lang.Long requestedParent, javax.persistence.EntityManager em);

    boolean isRelatedToParentCatalogIds(java.lang.Object entity, java.lang.Long... candidateRelatedIds);

    org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse getOriginalId(java.lang.Class<?> type, java.lang.Long id);

    org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse getProductionOriginalId(java.lang.Class<?> type, java.lang.Long id);

    java.lang.Long getOriginalId(java.lang.Object test);

    boolean isSandBoxable(java.lang.String className);

    boolean isPromote();

    boolean isReject();

    boolean isReplayOperation();

    void optionallyIncludeDeletedItemsInQueriesAndCollections(java.lang.Runnable runnable, boolean includeDeleted);

    java.lang.Long getProductionRecordIdIfApplicable(javax.persistence.EntityManager em, java.lang.Object startFieldValue);

    <T> T getTopMostOriginalRecord(T record);
}

