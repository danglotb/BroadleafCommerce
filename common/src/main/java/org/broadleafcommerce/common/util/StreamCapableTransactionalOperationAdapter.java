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
package org.broadleafcommerce.common.util;


public abstract class StreamCapableTransactionalOperationAdapter implements org.broadleafcommerce.common.util.StreamCapableTransactionalOperation {
    protected java.lang.Object[] pagedItems;

    @java.lang.Override
    public void pagedExecute(java.lang.Object[] param) throws java.lang.Throwable {
    }

    @java.lang.Override
    public void executeAfterCommit(java.lang.Object[] param) {
    }

    @java.lang.Override
    public void execute() throws java.lang.Throwable {
    }

    @java.lang.Override
    public java.lang.Object[] retrievePage(int startPos, int pageSize) {
        return null;
    }

    @java.lang.Override
    public java.lang.Long retrieveTotalCount() {
        return null;
    }

    public java.lang.Object[] getPagedItems() {
        return pagedItems;
    }

    public void setPagedItems(java.lang.Object[] pagedItems) {
        this.pagedItems = pagedItems;
    }

    @java.lang.Override
    public boolean shouldRetryOnTransactionLockAcquisitionFailure() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.__L6603, false);
    }

    @java.lang.Override
    public int retryMaxCountOverrideForLockAcquisitionFailure() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.__L6605, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.__L6604, 1))));
    }

    public static perturbation.location.PerturbationLocation __L6603;

    public static perturbation.location.PerturbationLocation __L6604;

    public static perturbation.location.PerturbationLocation __L6605;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.__L6603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamCapableTransactionalOperationAdapter.java:62)", 6603, "Boolean");
        org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.__L6604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamCapableTransactionalOperationAdapter.java:67)", 6604, "Numerical");
        org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.__L6605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StreamCapableTransactionalOperationAdapter.java:67)", 6605, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter.initPerturbationLocation0();
    }
}

