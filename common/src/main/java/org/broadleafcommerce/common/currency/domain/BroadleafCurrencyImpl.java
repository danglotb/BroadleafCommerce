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


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_CURRENCY")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "blCMSElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "BroadleafCurrencyImpl_baseCurrency")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY) })
public class BroadleafCurrencyImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.currency.domain.BroadleafCurrency {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.Column(name = "CURRENCY_CODE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "BroadleafCurrencyImpl_Currency_Code", order = 1, group = "BroadleafCurrencyImpl_Details", prominent = true, gridOrder = 2000)
    protected java.lang.String currencyCode;

    @javax.persistence.Column(name = "FRIENDLY_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "BroadleafCurrencyImpl_Name", order = 2, group = "BroadleafCurrencyImpl_Details", prominent = true, gridOrder = 1000)
    protected java.lang.String friendlyName;

    @javax.persistence.Column(name = "DEFAULT_FLAG")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "BroadleafCurrencyImpl_Is_Default", group = "BroadleafCurrencyImpl_Details", excluded = true)
    protected java.lang.Boolean defaultFlag = ((boolean) (false));

    @javax.persistence.Transient
    protected java.util.Currency javaCurrency;

    @java.lang.Override
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }

    public java.util.Currency getJavaCurrency() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L679, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L677, ((javaCurrency) == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L678, ((getCurrencyCode()) != null)))))) {
            javaCurrency = java.util.Currency.getInstance(getCurrencyCode());
        }
        return javaCurrency;
    }

    @java.lang.Override
    public void setCurrencyCode(java.lang.String code) {
        this.currencyCode = code;
    }

    @java.lang.Override
    public java.lang.String getFriendlyName() {
        return friendlyName;
    }

    @java.lang.Override
    public void setFriendlyName(java.lang.String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @java.lang.Override
    public boolean getDefaultFlag() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L680, ((defaultFlag) == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L681, false);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L682, defaultFlag.booleanValue());
    }

    @java.lang.Override
    public void setDefaultFlag(boolean defaultFlag) {
        this.defaultFlag = new java.lang.Boolean(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L683, defaultFlag));
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L684, ((this) == o))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L685, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L686, (o == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L687, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L689, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L688, getClass().isAssignableFrom(o.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L690, false);
        }
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl currency = ((org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L695, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L691, ((currencyCode) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L693, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L692, currencyCode.equals(currency.currencyCode))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L694, ((currency.currencyCode) != null))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L696, false);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L697, true);
    }

    @java.lang.Override
    public int hashCode() {
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L701, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L698, ((currencyCode) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L699, currencyCode.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L700, 0)));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L702, result);
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L703, ((getFriendlyName()) != null))) {
            return (((getFriendlyName()) + " (") + (getCurrencyCode())) + ")";
        }else {
            return getCurrencyCode();
        }
    }

    public static perturbation.location.PerturbationLocation __L677;

    public static perturbation.location.PerturbationLocation __L678;

    public static perturbation.location.PerturbationLocation __L679;

    public static perturbation.location.PerturbationLocation __L680;

    public static perturbation.location.PerturbationLocation __L681;

    public static perturbation.location.PerturbationLocation __L682;

    public static perturbation.location.PerturbationLocation __L683;

    public static perturbation.location.PerturbationLocation __L684;

    public static perturbation.location.PerturbationLocation __L685;

    public static perturbation.location.PerturbationLocation __L686;

    public static perturbation.location.PerturbationLocation __L687;

    public static perturbation.location.PerturbationLocation __L688;

    public static perturbation.location.PerturbationLocation __L689;

    public static perturbation.location.PerturbationLocation __L690;

    public static perturbation.location.PerturbationLocation __L691;

    public static perturbation.location.PerturbationLocation __L692;

    public static perturbation.location.PerturbationLocation __L693;

    public static perturbation.location.PerturbationLocation __L694;

    public static perturbation.location.PerturbationLocation __L695;

    public static perturbation.location.PerturbationLocation __L696;

    public static perturbation.location.PerturbationLocation __L697;

    public static perturbation.location.PerturbationLocation __L698;

    public static perturbation.location.PerturbationLocation __L699;

    public static perturbation.location.PerturbationLocation __L700;

    public static perturbation.location.PerturbationLocation __L701;

    public static perturbation.location.PerturbationLocation __L702;

    public static perturbation.location.PerturbationLocation __L703;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:79)", 677, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:79)", 678, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:79)", 679, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:102)", 680, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:103)", 681, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:105)", 682, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:110)", 683, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:115)", 684, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:116)", 685, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:118)", 686, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:118)", 687, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:119)", 688, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:119)", 689, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:120)", 690, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:125)", 691, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:125)", 692, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:125)", 693, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:125)", 694, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:125)", 695, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:126)", 696, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:129)", 697, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:134)", 698, "Boolean");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:134)", 699, "Numerical");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:134)", 700, "Numerical");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:134)", 701, "Numerical");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:135)", 702, "Numerical");
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.__L703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/currency/domain/BroadleafCurrencyImpl.java:140)", 703, "Boolean");
    }

    static {
        org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.initPerturbationLocation0();
    }
}

