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
package org.broadleafcommerce.common.persistence.transaction;


public class TransactionLifecycleEvent extends org.springframework.context.ApplicationEvent {
    protected org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle lifecycle;

    protected java.lang.Object[] params;

    protected java.lang.Throwable e;

    public TransactionLifecycleEvent(java.lang.Object source, org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle lifecycle, java.lang.Throwable e, java.lang.Object... params) {
        super(source);
        this.lifecycle = lifecycle;
        this.e = e;
        this.params = params;
    }

    public java.lang.Object[] getParams() {
        return params;
    }

    public org.broadleafcommerce.common.persistence.transaction.TransactionLifecycle getLifecycle() {
        return lifecycle;
    }

    public java.lang.Throwable getException() {
        return e;
    }
}

