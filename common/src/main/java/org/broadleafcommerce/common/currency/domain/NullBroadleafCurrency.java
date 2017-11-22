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
package org.broadleafcommerce.common.currency.domain;


public class NullBroadleafCurrency implements org.broadleafcommerce.common.currency.domain.BroadleafCurrency {
    private static final long serialVersionUID = 7926395625817119455L;

    @java.lang.Override
    public java.lang.String getCurrencyCode() {
        return null;
    }

    @java.lang.Override
    public void setCurrencyCode(java.lang.String code) {
    }

    @java.lang.Override
    public java.lang.String getFriendlyName() {
        return null;
    }

    @java.lang.Override
    public void setFriendlyName(java.lang.String friendlyName) {
    }

    @java.lang.Override
    public boolean getDefaultFlag() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.NullBroadleafCurrency.__L704, false);
    }

    @java.lang.Override
    public void setDefaultFlag(boolean defaultFlag) {
    }

    @java.lang.Override
    public java.util.Currency getJavaCurrency() {
        return null;
    }

    public static perturbation.location.PerturbationLocation __L704;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.currency.domain.NullBroadleafCurrency.__L704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/NullBroadleafCurrency.java:47)", 704, "Boolean");
    }

    static {
        org.broadleafcommerce.common.currency.domain.NullBroadleafCurrency.initPerturbationLocation0();
    }
}

