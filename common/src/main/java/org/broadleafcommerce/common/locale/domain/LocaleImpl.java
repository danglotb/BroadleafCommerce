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
package org.broadleafcommerce.common.locale.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_LOCALE")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "blCMSElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "LocaleImpl_baseLocale")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY) })
public class LocaleImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.locale.domain.Locale {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.Column(name = "LOCALE_CODE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "LocaleImpl_Locale_Code", order = 1, group = "LocaleImpl_Details", prominent = true, gridOrder = 2)
    protected java.lang.String localeCode;

    @javax.persistence.Column(name = "FRIENDLY_NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "LocaleImpl_Name", order = 2, group = "LocaleImpl_Details", prominent = true, gridOrder = 1)
    protected java.lang.String friendlyName;

    @javax.persistence.Column(name = "DEFAULT_FLAG")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "LocaleImpl_Is_Default", order = 3, group = "LocaleImpl_Details", prominent = false, gridOrder = 3)
    protected java.lang.Boolean defaultFlag = ((boolean) (false));

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl.class)
    @javax.persistence.JoinColumn(name = "CURRENCY_CODE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "LocaleImpl_Currency", order = 4, group = "LocaleImpl_Details", prominent = false)
    protected org.broadleafcommerce.common.currency.domain.BroadleafCurrency defaultCurrency;

    @javax.persistence.Column(name = "USE_IN_SEARCH_INDEX")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "LocaleImpl_Use_In_Search_Index", order = 5, group = "LocaleImpl_Details", prominent = false, gridOrder = 3)
    protected java.lang.Boolean useInSearchIndex = ((boolean) (false));

    @javax.persistence.Transient
    protected java.util.Locale javaLocale;

    @java.lang.Override
    public java.lang.String getLocaleCode() {
        return localeCode;
    }

    @java.lang.Override
    public void setLocaleCode(java.lang.String localeCode) {
        this.localeCode = localeCode;
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
    public void setDefaultFlag(java.lang.Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    @java.lang.Override
    public java.lang.Boolean getDefaultFlag() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3293, ((defaultFlag) == null))) {
            return java.lang.Boolean.FALSE;
        }else {
            return defaultFlag;
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.currency.domain.BroadleafCurrency getDefaultCurrency() {
        return defaultCurrency;
    }

    @java.lang.Override
    public void setDefaultCurrency(org.broadleafcommerce.common.currency.domain.BroadleafCurrency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    @java.lang.Override
    public java.lang.Boolean getUseCountryInSearchIndex() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3296, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3294, ((useInSearchIndex) == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3295, false) : useInSearchIndex));
    }

    @java.lang.Override
    public void setUseCountryInSearchIndex(java.lang.Boolean useInSearchIndex) {
        this.useInSearchIndex = useInSearchIndex;
    }

    public java.util.Locale getJavaLocale() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3299, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3297, ((javaLocale) == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3298, ((getLocaleCode()) != null)))))) {
            java.lang.String localeString = getLocaleCode();
            return org.springframework.util.StringUtils.parseLocaleString(localeString);
        }
        return javaLocale;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3300, ((this) == o))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3301, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3302, (o == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3303, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3305, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3304, getClass().isAssignableFrom(o.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3306, false);
        }
        org.broadleafcommerce.common.locale.domain.LocaleImpl locale = ((org.broadleafcommerce.common.locale.domain.LocaleImpl) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3311, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3307, ((localeCode) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3309, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3308, localeCode.equals(locale.localeCode))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3310, ((locale.localeCode) != null))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3312, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3317, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3313, ((friendlyName) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3315, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3314, friendlyName.equals(locale.friendlyName))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3316, ((locale.friendlyName) != null))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3318, false);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3319, true);
    }

    @java.lang.Override
    public int hashCode() {
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3323, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3320, ((localeCode) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3321, localeCode.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3322, 0)));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3331, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3326, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3324, 31)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3325, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3330, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3327, ((friendlyName) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3328, friendlyName.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3329, 0))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3332, result);
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getLocaleCode();
    }

    public static perturbation.location.PerturbationLocation __L3293;

    public static perturbation.location.PerturbationLocation __L3294;

    public static perturbation.location.PerturbationLocation __L3295;

    public static perturbation.location.PerturbationLocation __L3296;

    public static perturbation.location.PerturbationLocation __L3297;

    public static perturbation.location.PerturbationLocation __L3298;

    public static perturbation.location.PerturbationLocation __L3299;

    public static perturbation.location.PerturbationLocation __L3300;

    public static perturbation.location.PerturbationLocation __L3301;

    public static perturbation.location.PerturbationLocation __L3302;

    public static perturbation.location.PerturbationLocation __L3303;

    public static perturbation.location.PerturbationLocation __L3304;

    public static perturbation.location.PerturbationLocation __L3305;

    public static perturbation.location.PerturbationLocation __L3306;

    public static perturbation.location.PerturbationLocation __L3307;

    public static perturbation.location.PerturbationLocation __L3308;

    public static perturbation.location.PerturbationLocation __L3309;

    public static perturbation.location.PerturbationLocation __L3310;

    public static perturbation.location.PerturbationLocation __L3311;

    public static perturbation.location.PerturbationLocation __L3312;

    public static perturbation.location.PerturbationLocation __L3313;

    public static perturbation.location.PerturbationLocation __L3314;

    public static perturbation.location.PerturbationLocation __L3315;

    public static perturbation.location.PerturbationLocation __L3316;

    public static perturbation.location.PerturbationLocation __L3317;

    public static perturbation.location.PerturbationLocation __L3318;

    public static perturbation.location.PerturbationLocation __L3319;

    public static perturbation.location.PerturbationLocation __L3320;

    public static perturbation.location.PerturbationLocation __L3321;

    public static perturbation.location.PerturbationLocation __L3322;

    public static perturbation.location.PerturbationLocation __L3323;

    public static perturbation.location.PerturbationLocation __L3324;

    public static perturbation.location.PerturbationLocation __L3325;

    public static perturbation.location.PerturbationLocation __L3326;

    public static perturbation.location.PerturbationLocation __L3327;

    public static perturbation.location.PerturbationLocation __L3328;

    public static perturbation.location.PerturbationLocation __L3329;

    public static perturbation.location.PerturbationLocation __L3330;

    public static perturbation.location.PerturbationLocation __L3331;

    public static perturbation.location.PerturbationLocation __L3332;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:119)", 3293, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:138)", 3294, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:138)", 3295, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:138)", 3296, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:147)", 3297, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:147)", 3298, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:147)", 3299, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:156)", 3300, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:157)", 3301, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:159)", 3302, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:159)", 3303, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:160)", 3304, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:160)", 3305, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:161)", 3306, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:166)", 3307, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:166)", 3308, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:166)", 3309, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:166)", 3310, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:166)", 3311, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:167)", 3312, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:169)", 3313, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:169)", 3314, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:169)", 3315, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:169)", 3316, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:169)", 3317, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:170)", 3318, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:173)", 3319, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:178)", 3320, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:178)", 3321, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:178)", 3322, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:178)", 3323, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3324, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3325, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3326, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3327, "Boolean");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3328, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3329, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3330, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:179)", 3331, "Numerical");
        org.broadleafcommerce.common.locale.domain.LocaleImpl.__L3332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/locale/domain/LocaleImpl.java:180)", 3332, "Numerical");
    }

    static {
        org.broadleafcommerce.common.locale.domain.LocaleImpl.initPerturbationLocation0();
    }
}

