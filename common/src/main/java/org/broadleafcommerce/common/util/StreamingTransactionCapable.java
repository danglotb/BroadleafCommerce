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


public interface StreamingTransactionCapable {
    int getPageSize();

    void setPageSize(int pageSize);

    int getRetryMax();

    void setRetryMax(int retryMax);

    <G extends java.lang.Throwable> void runStreamingTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation streamOperation, java.lang.Class<G> exceptionType) throws G;

    <G extends java.lang.Throwable> void runTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G;

    <G extends java.lang.Throwable> void runStreamingTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation streamOperation, java.lang.Class<G> exceptionType, int transactionBehavior, int isolationLevel) throws G;

    <G extends java.lang.Throwable> void runTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType) throws G;

    <G extends java.lang.Throwable> void runTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, int transactionBehavior, int isolationLevel) throws G;

    <G extends java.lang.Throwable> void runOptionalTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, boolean useTransaction) throws G;

    <G extends java.lang.Throwable> void runOptionalTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, boolean useTransaction, int transactionBehavior, int isolationLevel) throws G;

    <G extends java.lang.Throwable> void runOptionalTransactionalOperation(org.broadleafcommerce.common.util.StreamCapableTransactionalOperation operation, java.lang.Class<G> exceptionType, boolean useTransaction, int transactionBehavior, int isolationLevel, boolean readOnly, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G;

    org.springframework.transaction.PlatformTransactionManager getTransactionManager();

    void setTransactionManager(org.springframework.transaction.PlatformTransactionManager transactionManager);

    void runOptionalEntityManagerInViewOperation(java.lang.Runnable runnable);
}

