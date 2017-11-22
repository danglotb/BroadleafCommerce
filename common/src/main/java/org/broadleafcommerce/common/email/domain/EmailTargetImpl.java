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
package org.broadleafcommerce.common.email.domain;


public class EmailTargetImpl implements org.broadleafcommerce.common.email.domain.EmailTarget {
    private static final long serialVersionUID = 1L;

    protected java.lang.String[] bccAddresses;

    protected java.lang.String[] ccAddresses;

    protected java.lang.String emailAddress;

    public java.lang.String[] getBCCAddresses() {
        return bccAddresses;
    }

    public java.lang.String[] getCCAddresses() {
        return ccAddresses;
    }

    public java.lang.String getEmailAddress() {
        return emailAddress;
    }

    public void setBCCAddresses(java.lang.String[] bccAddresses) {
        this.bccAddresses = bccAddresses;
    }

    public void setCCAddresses(java.lang.String[] ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L863, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L864, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L869, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L867, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L865, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L866, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L868, java.util.Arrays.hashCode(bccAddresses)))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L874, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L872, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L870, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L871, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L873, java.util.Arrays.hashCode(ccAddresses)))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L882, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L877, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L875, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L876, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L881, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L878, ((emailAddress) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L879, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L880, emailAddress.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L883, result);
    }

    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L884, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L885, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L886, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L887, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L889, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L888, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L890, false);

        org.broadleafcommerce.common.email.domain.EmailTargetImpl other = ((org.broadleafcommerce.common.email.domain.EmailTargetImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L892, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L891, java.util.Arrays.equals(bccAddresses, other.bccAddresses))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L893, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L895, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L894, java.util.Arrays.equals(ccAddresses, other.ccAddresses))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L896, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L897, ((emailAddress) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L898, ((other.emailAddress) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L899, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L901, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L900, emailAddress.equals(other.emailAddress))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L902, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L903, true);
    }

    public static perturbation.location.PerturbationLocation __L863;

    public static perturbation.location.PerturbationLocation __L864;

    public static perturbation.location.PerturbationLocation __L865;

    public static perturbation.location.PerturbationLocation __L866;

    public static perturbation.location.PerturbationLocation __L867;

    public static perturbation.location.PerturbationLocation __L868;

    public static perturbation.location.PerturbationLocation __L869;

    public static perturbation.location.PerturbationLocation __L870;

    public static perturbation.location.PerturbationLocation __L871;

    public static perturbation.location.PerturbationLocation __L872;

    public static perturbation.location.PerturbationLocation __L873;

    public static perturbation.location.PerturbationLocation __L874;

    public static perturbation.location.PerturbationLocation __L875;

    public static perturbation.location.PerturbationLocation __L876;

    public static perturbation.location.PerturbationLocation __L877;

    public static perturbation.location.PerturbationLocation __L878;

    public static perturbation.location.PerturbationLocation __L879;

    public static perturbation.location.PerturbationLocation __L880;

    public static perturbation.location.PerturbationLocation __L881;

    public static perturbation.location.PerturbationLocation __L882;

    public static perturbation.location.PerturbationLocation __L883;

    public static perturbation.location.PerturbationLocation __L884;

    public static perturbation.location.PerturbationLocation __L885;

    public static perturbation.location.PerturbationLocation __L886;

    public static perturbation.location.PerturbationLocation __L887;

    public static perturbation.location.PerturbationLocation __L888;

    public static perturbation.location.PerturbationLocation __L889;

    public static perturbation.location.PerturbationLocation __L890;

    public static perturbation.location.PerturbationLocation __L891;

    public static perturbation.location.PerturbationLocation __L892;

    public static perturbation.location.PerturbationLocation __L893;

    public static perturbation.location.PerturbationLocation __L894;

    public static perturbation.location.PerturbationLocation __L895;

    public static perturbation.location.PerturbationLocation __L896;

    public static perturbation.location.PerturbationLocation __L897;

    public static perturbation.location.PerturbationLocation __L898;

    public static perturbation.location.PerturbationLocation __L899;

    public static perturbation.location.PerturbationLocation __L900;

    public static perturbation.location.PerturbationLocation __L901;

    public static perturbation.location.PerturbationLocation __L902;

    public static perturbation.location.PerturbationLocation __L903;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:96)", 863, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:97)", 864, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:98)", 865, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:98)", 866, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:98)", 867, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:98)", 868, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:98)", 869, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:99)", 870, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:99)", 871, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:99)", 872, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:99)", 873, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:99)", 874, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 875, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 876, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 877, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 878, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 879, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 880, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 881, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:100)", 882, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:101)", 883, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:105)", 884, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:106)", 885, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:107)", 886, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:108)", 887, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:109)", 888, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:109)", 889, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:110)", 890, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:112)", 891, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:112)", 892, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:113)", 893, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:114)", 894, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:114)", 895, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:115)", 896, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:116)", 897, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:117)", 898, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:118)", 899, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:119)", 900, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:119)", 901, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:120)", 902, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.__L903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTargetImpl.java:121)", 903, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.domain.EmailTargetImpl.initPerturbationLocation0();
    }
}

