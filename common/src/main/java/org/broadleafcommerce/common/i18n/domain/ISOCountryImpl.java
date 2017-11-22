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
package org.broadleafcommerce.common.i18n.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_ISO_COUNTRY")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(friendlyName = "ISOCountryImpl_baseCountry")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY) })
public class ISOCountryImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.i18n.domain.ISOCountry {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.Column(name = "ALPHA_2")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "ISOCountryImpl_Alpha2", order = 1, group = "ISOCountryImpl_Details", prominent = true)
    protected java.lang.String alpha2;

    @javax.persistence.Column(name = "NAME")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "ISOCountryImpl_Name", order = 2, group = "ISOCountryImpl_Details", prominent = true)
    protected java.lang.String name;

    @javax.persistence.Column(name = "ALPHA_3")
    protected java.lang.String alpha3;

    @javax.persistence.Column(name = "NUMERIC_CODE")
    protected java.lang.Integer numericCode;

    @javax.persistence.Column(name = "STATUS")
    protected java.lang.String status;

    @java.lang.Override
    public java.lang.String getAlpha2() {
        return alpha2;
    }

    @java.lang.Override
    public void setAlpha2(java.lang.String alpha2) {
        this.alpha2 = alpha2;
    }

    @java.lang.Override
    public java.lang.String getName() {
        return name;
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String getAlpha3() {
        return alpha3;
    }

    @java.lang.Override
    public void setAlpha3(java.lang.String alpha3) {
        this.alpha3 = alpha3;
    }

    @java.lang.Override
    public java.lang.Integer getNumericCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2786, numericCode);
    }

    @java.lang.Override
    public void setNumericCode(java.lang.Integer numericCode) {
        this.numericCode = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2787, numericCode);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType getStatus() {
        return org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType.getInstance(status);
    }

    @java.lang.Override
    public void setStatus(org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType status) {
        this.status = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2788, (status == null))) ? null : status.getType();
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2789, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2790, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2791, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2792, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2794, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2793, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2795, false);

        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl other = ((org.broadleafcommerce.common.i18n.domain.ISOCountryImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2796, ((alpha2) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2797, ((other.alpha2) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2798, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2800, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2799, alpha2.equals(other.alpha2))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2801, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2802, ((name) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2803, ((other.name) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2804, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2806, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2805, name.equals(other.name))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2807, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2808, ((alpha3) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2809, ((other.alpha3) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2810, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2812, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2811, alpha3.equals(other.alpha3))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2813, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2814, ((numericCode) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2815, ((other.numericCode) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2816, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2819, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2818, numericCode.equals(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2817, other.numericCode)))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2820, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2821, ((status) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2822, ((other.status) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2823, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2825, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2824, status.equals(other.status))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2826, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2827, true);
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2828, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2829, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2837, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2832, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2830, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2831, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2836, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2833, ((alpha2) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2834, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2835, alpha2.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2845, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2840, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2838, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2839, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2844, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2841, ((name) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2842, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2843, name.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2853, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2848, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2846, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2847, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2852, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2849, ((alpha3) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2850, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2851, alpha3.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2861, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2856, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2854, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2855, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2860, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2857, ((numericCode) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2858, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2859, numericCode.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2869, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2864, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2862, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2863, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2868, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2865, ((status) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2866, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2867, status.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2870, result);
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getName();
    }

    public static perturbation.location.PerturbationLocation __L2786;

    public static perturbation.location.PerturbationLocation __L2787;

    public static perturbation.location.PerturbationLocation __L2788;

    public static perturbation.location.PerturbationLocation __L2789;

    public static perturbation.location.PerturbationLocation __L2790;

    public static perturbation.location.PerturbationLocation __L2791;

    public static perturbation.location.PerturbationLocation __L2792;

    public static perturbation.location.PerturbationLocation __L2793;

    public static perturbation.location.PerturbationLocation __L2794;

    public static perturbation.location.PerturbationLocation __L2795;

    public static perturbation.location.PerturbationLocation __L2796;

    public static perturbation.location.PerturbationLocation __L2797;

    public static perturbation.location.PerturbationLocation __L2798;

    public static perturbation.location.PerturbationLocation __L2799;

    public static perturbation.location.PerturbationLocation __L2800;

    public static perturbation.location.PerturbationLocation __L2801;

    public static perturbation.location.PerturbationLocation __L2802;

    public static perturbation.location.PerturbationLocation __L2803;

    public static perturbation.location.PerturbationLocation __L2804;

    public static perturbation.location.PerturbationLocation __L2805;

    public static perturbation.location.PerturbationLocation __L2806;

    public static perturbation.location.PerturbationLocation __L2807;

    public static perturbation.location.PerturbationLocation __L2808;

    public static perturbation.location.PerturbationLocation __L2809;

    public static perturbation.location.PerturbationLocation __L2810;

    public static perturbation.location.PerturbationLocation __L2811;

    public static perturbation.location.PerturbationLocation __L2812;

    public static perturbation.location.PerturbationLocation __L2813;

    public static perturbation.location.PerturbationLocation __L2814;

    public static perturbation.location.PerturbationLocation __L2815;

    public static perturbation.location.PerturbationLocation __L2816;

    public static perturbation.location.PerturbationLocation __L2817;

    public static perturbation.location.PerturbationLocation __L2818;

    public static perturbation.location.PerturbationLocation __L2819;

    public static perturbation.location.PerturbationLocation __L2820;

    public static perturbation.location.PerturbationLocation __L2821;

    public static perturbation.location.PerturbationLocation __L2822;

    public static perturbation.location.PerturbationLocation __L2823;

    public static perturbation.location.PerturbationLocation __L2824;

    public static perturbation.location.PerturbationLocation __L2825;

    public static perturbation.location.PerturbationLocation __L2826;

    public static perturbation.location.PerturbationLocation __L2827;

    public static perturbation.location.PerturbationLocation __L2828;

    public static perturbation.location.PerturbationLocation __L2829;

    public static perturbation.location.PerturbationLocation __L2830;

    public static perturbation.location.PerturbationLocation __L2831;

    public static perturbation.location.PerturbationLocation __L2832;

    public static perturbation.location.PerturbationLocation __L2833;

    public static perturbation.location.PerturbationLocation __L2834;

    public static perturbation.location.PerturbationLocation __L2835;

    public static perturbation.location.PerturbationLocation __L2836;

    public static perturbation.location.PerturbationLocation __L2837;

    public static perturbation.location.PerturbationLocation __L2838;

    public static perturbation.location.PerturbationLocation __L2839;

    public static perturbation.location.PerturbationLocation __L2840;

    public static perturbation.location.PerturbationLocation __L2841;

    public static perturbation.location.PerturbationLocation __L2842;

    public static perturbation.location.PerturbationLocation __L2843;

    public static perturbation.location.PerturbationLocation __L2844;

    public static perturbation.location.PerturbationLocation __L2845;

    public static perturbation.location.PerturbationLocation __L2846;

    public static perturbation.location.PerturbationLocation __L2847;

    public static perturbation.location.PerturbationLocation __L2848;

    public static perturbation.location.PerturbationLocation __L2849;

    public static perturbation.location.PerturbationLocation __L2850;

    public static perturbation.location.PerturbationLocation __L2851;

    public static perturbation.location.PerturbationLocation __L2852;

    public static perturbation.location.PerturbationLocation __L2853;

    public static perturbation.location.PerturbationLocation __L2854;

    public static perturbation.location.PerturbationLocation __L2855;

    public static perturbation.location.PerturbationLocation __L2856;

    public static perturbation.location.PerturbationLocation __L2857;

    public static perturbation.location.PerturbationLocation __L2858;

    public static perturbation.location.PerturbationLocation __L2859;

    public static perturbation.location.PerturbationLocation __L2860;

    public static perturbation.location.PerturbationLocation __L2861;

    public static perturbation.location.PerturbationLocation __L2862;

    public static perturbation.location.PerturbationLocation __L2863;

    public static perturbation.location.PerturbationLocation __L2864;

    public static perturbation.location.PerturbationLocation __L2865;

    public static perturbation.location.PerturbationLocation __L2866;

    public static perturbation.location.PerturbationLocation __L2867;

    public static perturbation.location.PerturbationLocation __L2868;

    public static perturbation.location.PerturbationLocation __L2869;

    public static perturbation.location.PerturbationLocation __L2870;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:103)", 2786, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:108)", 2787, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:118)", 2788, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:123)", 2789, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:124)", 2790, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:125)", 2791, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:126)", 2792, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:127)", 2793, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:127)", 2794, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:128)", 2795, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:130)", 2796, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:131)", 2797, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:132)", 2798, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:133)", 2799, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:133)", 2800, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:134)", 2801, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:135)", 2802, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:136)", 2803, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:137)", 2804, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:138)", 2805, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:138)", 2806, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:139)", 2807, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:140)", 2808, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:141)", 2809, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:142)", 2810, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:143)", 2811, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:143)", 2812, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:144)", 2813, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:145)", 2814, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:146)", 2815, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:147)", 2816, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:148)", 2817, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:148)", 2818, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:148)", 2819, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:149)", 2820, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:150)", 2821, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:151)", 2822, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:152)", 2823, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:153)", 2824, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:153)", 2825, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:154)", 2826, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:155)", 2827, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:160)", 2828, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:161)", 2829, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2830, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2831, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2832, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2833, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2834, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2835, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2836, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:162)", 2837, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2838, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2839, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2840, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2841, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2842, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2843 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2843, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2844 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2844, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:163)", 2845, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2846, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2847, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2848, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2849, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2850, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2851, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2852, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:164)", 2853, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2854, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2855, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2856, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2857, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2858, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2859, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2860, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:165)", 2861, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2862, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2863, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2864, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2865, "Boolean");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2866, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2867, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2868, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:166)", 2869, "Numerical");
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.__L2870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/i18n/domain/ISOCountryImpl.java:167)", 2870, "Numerical");
    }

    static {
        org.broadleafcommerce.common.i18n.domain.ISOCountryImpl.initPerturbationLocation0();
    }
}

