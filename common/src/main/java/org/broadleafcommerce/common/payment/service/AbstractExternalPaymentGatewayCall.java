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
package org.broadleafcommerce.common.payment.service;


public abstract class AbstractExternalPaymentGatewayCall<T, R> implements org.broadleafcommerce.common.payment.service.FailureCountExposable , org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable<T> {
    protected java.lang.Integer failureCount = ((int) (0));

    protected java.lang.Boolean isUp = ((boolean) (true));

    public synchronized void clearStatus() {
        isUp = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3830, true);
        failureCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3831, 0);
    }

    public synchronized void incrementFailure() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3834, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3832, failureCount)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3833, getFailureReportingThreshold()))))) {
            isUp = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3835, false);
        }else {
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3836, ((failureCount)++));
        }
    }

    @java.lang.Override
    public synchronized org.broadleafcommerce.common.vendor.service.type.ServiceStatusType getServiceStatus() {
        if (isUp) {
            return org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.UP;
        }else {
            return org.broadleafcommerce.common.vendor.service.type.ServiceStatusType.DOWN;
        }
    }

    @java.lang.Override
    public R process(T paymentRequest) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException {
        R response;
        try {
            response = communicateWithVendor(paymentRequest);
        } catch (java.lang.Exception e) {
            incrementFailure();
            throw new org.broadleafcommerce.common.vendor.service.exception.PaymentException(e);
        }
        clearStatus();
        return response;
    }

    public abstract R communicateWithVendor(T paymentRequest) throws java.lang.Exception;

    public abstract java.lang.Integer getFailureReportingThreshold();

    public static perturbation.location.PerturbationLocation __L3830;

    public static perturbation.location.PerturbationLocation __L3831;

    public static perturbation.location.PerturbationLocation __L3832;

    public static perturbation.location.PerturbationLocation __L3833;

    public static perturbation.location.PerturbationLocation __L3834;

    public static perturbation.location.PerturbationLocation __L3835;

    public static perturbation.location.PerturbationLocation __L3836;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:49)", 3830, "Boolean");
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:50)", 3831, "Numerical");
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:54)", 3832, "Numerical");
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:54)", 3833, "Numerical");
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:54)", 3834, "Boolean");
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:55)", 3835, "Boolean");
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.__L3836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/AbstractExternalPaymentGatewayCall.java:57)", 3836, "Numerical");
    }

    static {
        org.broadleafcommerce.common.payment.service.AbstractExternalPaymentGatewayCall.initPerturbationLocation0();
    }
}

