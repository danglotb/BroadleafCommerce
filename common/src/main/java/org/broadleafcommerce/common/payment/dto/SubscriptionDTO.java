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
package org.broadleafcommerce.common.payment.dto;


public class SubscriptionDTO<T> {
    protected T parent;

    protected java.util.Map<java.lang.String, java.lang.Object> additionalFields;

    protected java.lang.String recurringAmount;

    protected java.lang.String frequency;

    protected java.lang.String numberOfInstallments;

    protected java.lang.String startDate;

    public SubscriptionDTO() {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
    }

    public SubscriptionDTO(T parent) {
        this.additionalFields = new java.util.HashMap<java.lang.String, java.lang.Object>();
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<T> additionalFields(java.lang.String key, java.lang.Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<T> recurringAmount(java.lang.String recurringAmount) {
        this.recurringAmount = recurringAmount;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<T> frequency(java.lang.String frequency) {
        this.frequency = frequency;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<T> numberOfInstallments(java.lang.String numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
        return this;
    }

    public org.broadleafcommerce.common.payment.dto.SubscriptionDTO<T> startDate(java.lang.String startDate) {
        this.startDate = startDate;
        return this;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalFields() {
        return additionalFields;
    }

    public java.lang.String getRecurringAmount() {
        return recurringAmount;
    }

    public java.lang.String getFrequency() {
        return frequency;
    }

    public java.lang.String getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public java.lang.String getStartDate() {
        return startDate;
    }

    public boolean subscriptionPopulated() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3829, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3827, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3825, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3823, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3821, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3818, ((getAdditionalFields()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3820, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3819, getAdditionalFields().isEmpty())))))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3822, ((getRecurringAmount()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3824, ((getFrequency()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3826, ((getNumberOfInstallments()) != null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3828, ((getStartDate()) != null)))));
    }

    public static perturbation.location.PerturbationLocation __L3818;

    public static perturbation.location.PerturbationLocation __L3819;

    public static perturbation.location.PerturbationLocation __L3820;

    public static perturbation.location.PerturbationLocation __L3821;

    public static perturbation.location.PerturbationLocation __L3822;

    public static perturbation.location.PerturbationLocation __L3823;

    public static perturbation.location.PerturbationLocation __L3824;

    public static perturbation.location.PerturbationLocation __L3825;

    public static perturbation.location.PerturbationLocation __L3826;

    public static perturbation.location.PerturbationLocation __L3827;

    public static perturbation.location.PerturbationLocation __L3828;

    public static perturbation.location.PerturbationLocation __L3829;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3818, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3819, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3820, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3821, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:107)", 3822, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3823, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:108)", 3824, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3825, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:109)", 3826, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3827, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:110)", 3828, "Boolean");
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.__L3829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/dto/SubscriptionDTO.java:106)", 3829, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.dto.SubscriptionDTO.initPerturbationLocation0();
    }
}

