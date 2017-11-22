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


@org.springframework.stereotype.Component("blSandBoxHelper")
public class DefaultSandBoxHelper implements org.broadleafcommerce.common.sandbox.SandBoxHelper {
    @java.lang.Override
    public java.lang.Long getSandBoxVersionId(java.lang.Class<?> linkedObjectType, java.lang.Long requestedParent) {
        return requestedParent;
    }

    @java.lang.Override
    public java.lang.Long getCascadedProductionStateId(java.lang.Class<?> linkedObjectType, java.lang.Long requestedParent) {
        return requestedParent;
    }

    @java.lang.Override
    public java.lang.Long retrieveCascadedState(java.lang.Class<?> ceilingImpl, java.lang.Long requestedParent, javax.persistence.EntityManager em) {
        return requestedParent;
    }

    @java.lang.Override
    public boolean isRelatedToParentCatalogIds(java.lang.Object entity, java.lang.Long... candidateRelatedIds) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4773, false);
    }

    @java.lang.Override
    public java.util.List<java.lang.Long> mergeCloneIds(java.lang.Class<?> type, java.lang.Long... originalIds) {
        return java.util.Arrays.asList(originalIds);
    }

    @java.lang.Override
    public com.google.common.collect.BiMap<java.lang.Long, java.lang.Long> getSandBoxToOriginalMap(java.lang.Class<?> type, java.lang.Long... originalIds) {
        return com.google.common.collect.HashBiMap.create();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse getOriginalId(java.lang.Class<?> type, java.lang.Long id) {
        org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse response = new org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse();
        response.setOriginalId(id);
        return response;
    }

    @java.lang.Override
    public java.lang.Long getOriginalId(java.lang.Object test) {
        return null;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse getProductionOriginalId(java.lang.Class<?> type, java.lang.Long id) {
        return null;
    }

    @java.lang.Override
    public boolean isSandBoxable(java.lang.String className) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4774, false);
    }

    @java.lang.Override
    public boolean isPromote() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4775, false);
    }

    @java.lang.Override
    public boolean isReject() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4776, false);
    }

    @java.lang.Override
    public boolean isReplayOperation() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4777, false);
    }

    @java.lang.Override
    public void optionallyIncludeDeletedItemsInQueriesAndCollections(java.lang.Runnable runnable, boolean includeDeleted) {
        runnable.run();
    }

    @java.lang.Override
    public java.lang.Long getProductionRecordIdIfApplicable(javax.persistence.EntityManager em, java.lang.Object startFieldValue) {
        return ((java.lang.Long) (em.unwrap(org.hibernate.Session.class).getIdentifier(startFieldValue)));
    }

    @java.lang.Override
    public <T> T getTopMostOriginalRecord(T record) {
        return record;
    }

    @java.lang.Override
    public void ignoreCloneCache(boolean ignoreCache) {
    }

    public static perturbation.location.PerturbationLocation __L4773;

    public static perturbation.location.PerturbationLocation __L4774;

    public static perturbation.location.PerturbationLocation __L4775;

    public static perturbation.location.PerturbationLocation __L4776;

    public static perturbation.location.PerturbationLocation __L4777;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/DefaultSandBoxHelper.java:55)", 4773, "Boolean");
        org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/DefaultSandBoxHelper.java:87)", 4774, "Boolean");
        org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/DefaultSandBoxHelper.java:92)", 4775, "Boolean");
        org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/DefaultSandBoxHelper.java:97)", 4776, "Boolean");
        org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.__L4777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/DefaultSandBoxHelper.java:102)", 4777, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sandbox.DefaultSandBoxHelper.initPerturbationLocation0();
    }
}

