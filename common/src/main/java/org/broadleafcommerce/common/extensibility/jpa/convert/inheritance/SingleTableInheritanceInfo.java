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
package org.broadleafcommerce.common.extensibility.jpa.convert.inheritance;


public class SingleTableInheritanceInfo {
    protected java.lang.String className;

    protected java.lang.String discriminatorName;

    protected javax.persistence.DiscriminatorType discriminatorType;

    protected int discriminatorLength;

    public java.lang.String getClassName() {
        return className;
    }

    public void setClassName(java.lang.String className) {
        this.className = className;
    }

    public java.lang.String getDiscriminatorName() {
        return discriminatorName;
    }

    public void setDiscriminatorName(java.lang.String discriminatorName) {
        this.discriminatorName = discriminatorName;
    }

    public javax.persistence.DiscriminatorType getDiscriminatorType() {
        return discriminatorType;
    }

    public void setDiscriminatorType(javax.persistence.DiscriminatorType discriminatorType) {
        this.discriminatorType = discriminatorType;
    }

    public int getDiscriminatorLength() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1862, discriminatorLength);
    }

    public void setDiscriminatorLength(int discriminatorLength) {
        this.discriminatorLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1863, discriminatorLength);
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1864, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1865, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1873, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1868, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1866, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1867, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1872, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1869, ((className) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1870, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1871, className.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1874, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1875, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1876, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1877, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1878, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1880, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1879, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1881, false);

        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo other = ((org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1882, ((className) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1883, ((other.className) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1884, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1886, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1885, className.equals(other.className))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1887, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1888, true);
    }

    public static perturbation.location.PerturbationLocation __L1862;

    public static perturbation.location.PerturbationLocation __L1863;

    public static perturbation.location.PerturbationLocation __L1864;

    public static perturbation.location.PerturbationLocation __L1865;

    public static perturbation.location.PerturbationLocation __L1866;

    public static perturbation.location.PerturbationLocation __L1867;

    public static perturbation.location.PerturbationLocation __L1868;

    public static perturbation.location.PerturbationLocation __L1869;

    public static perturbation.location.PerturbationLocation __L1870;

    public static perturbation.location.PerturbationLocation __L1871;

    public static perturbation.location.PerturbationLocation __L1872;

    public static perturbation.location.PerturbationLocation __L1873;

    public static perturbation.location.PerturbationLocation __L1874;

    public static perturbation.location.PerturbationLocation __L1875;

    public static perturbation.location.PerturbationLocation __L1876;

    public static perturbation.location.PerturbationLocation __L1877;

    public static perturbation.location.PerturbationLocation __L1878;

    public static perturbation.location.PerturbationLocation __L1879;

    public static perturbation.location.PerturbationLocation __L1880;

    public static perturbation.location.PerturbationLocation __L1881;

    public static perturbation.location.PerturbationLocation __L1882;

    public static perturbation.location.PerturbationLocation __L1883;

    public static perturbation.location.PerturbationLocation __L1884;

    public static perturbation.location.PerturbationLocation __L1885;

    public static perturbation.location.PerturbationLocation __L1886;

    public static perturbation.location.PerturbationLocation __L1887;

    public static perturbation.location.PerturbationLocation __L1888;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:59)", 1862, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:63)", 1863, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:68)", 1864, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:69)", 1865, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1866, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1867, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1868, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1869, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1870, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1871, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1872, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:70)", 1873, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:71)", 1874, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:76)", 1875, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:77)", 1876, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:78)", 1877, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:79)", 1878, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:80)", 1879, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:80)", 1880, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:81)", 1881, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:83)", 1882, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:84)", 1883, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:85)", 1884, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:86)", 1885, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:86)", 1886, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:87)", 1887, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.__L1888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceInfo.java:88)", 1888, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo.initPerturbationLocation0();
    }
}

