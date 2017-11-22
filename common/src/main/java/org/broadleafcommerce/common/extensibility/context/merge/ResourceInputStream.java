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
package org.broadleafcommerce.common.extensibility.context.merge;


public class ResourceInputStream extends java.io.InputStream {
    private final java.io.InputStream is;

    private java.util.List<java.lang.String> names = new java.util.ArrayList<>(20);

    public ResourceInputStream(java.io.InputStream is, java.lang.String name) {
        this.is = is;
        names.add(name);
    }

    public ResourceInputStream(java.io.InputStream is, java.lang.String name, java.util.List<java.lang.String> previousNames) {
        this.is = is;
        names.addAll(previousNames);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1803, (!(org.apache.commons.lang.StringUtils.isEmpty(name))))) {
            names.add(name);
        }
    }

    public java.util.List<java.lang.String> getNames() {
        return names;
    }

    public java.lang.String getName() {
        assert perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1806, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1804, names.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1805, 1))));
        return names.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1807, 0));
    }

    @java.lang.Override
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1808, 100));
        int size = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1809, names.size());
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1810, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1813, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1811, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1812, size)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1814, (j++))) {
            sb.append(names.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1815, j)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1820, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1816, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1819, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1817, size)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1818, 1)))))))) {
                sb.append(" : ");
            }
        }
        return sb.toString();
    }

    @java.lang.Override
    public int available() throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1825, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1821, ((is) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1823, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1822, 1)))) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1824, is.available())));
    }

    @java.lang.Override
    public void close() throws java.io.IOException {
        is.close();
    }

    @java.lang.Override
    public void mark(int i) {
        is.mark(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1826, i));
    }

    @java.lang.Override
    public boolean markSupported() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1827, is.markSupported());
    }

    @java.lang.Override
    public int read() throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1828, is.read());
    }

    @java.lang.Override
    public int read(byte[] bytes) throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1829, is.read(bytes));
    }

    @java.lang.Override
    public int read(byte[] bytes, int i, int i1) throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1832, is.read(bytes, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1830, i), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1831, i1)));
    }

    @java.lang.Override
    public void reset() throws java.io.IOException {
        is.reset();
    }

    @java.lang.Override
    public long skip(long l) throws java.io.IOException {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1834, is.skip(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1833, l)));
    }

    public static perturbation.location.PerturbationLocation __L1803;

    public static perturbation.location.PerturbationLocation __L1804;

    public static perturbation.location.PerturbationLocation __L1805;

    public static perturbation.location.PerturbationLocation __L1806;

    public static perturbation.location.PerturbationLocation __L1807;

    public static perturbation.location.PerturbationLocation __L1808;

    public static perturbation.location.PerturbationLocation __L1809;

    public static perturbation.location.PerturbationLocation __L1810;

    public static perturbation.location.PerturbationLocation __L1811;

    public static perturbation.location.PerturbationLocation __L1812;

    public static perturbation.location.PerturbationLocation __L1813;

    public static perturbation.location.PerturbationLocation __L1814;

    public static perturbation.location.PerturbationLocation __L1815;

    public static perturbation.location.PerturbationLocation __L1816;

    public static perturbation.location.PerturbationLocation __L1817;

    public static perturbation.location.PerturbationLocation __L1818;

    public static perturbation.location.PerturbationLocation __L1819;

    public static perturbation.location.PerturbationLocation __L1820;

    public static perturbation.location.PerturbationLocation __L1821;

    public static perturbation.location.PerturbationLocation __L1822;

    public static perturbation.location.PerturbationLocation __L1823;

    public static perturbation.location.PerturbationLocation __L1824;

    public static perturbation.location.PerturbationLocation __L1825;

    public static perturbation.location.PerturbationLocation __L1826;

    public static perturbation.location.PerturbationLocation __L1827;

    public static perturbation.location.PerturbationLocation __L1828;

    public static perturbation.location.PerturbationLocation __L1829;

    public static perturbation.location.PerturbationLocation __L1830;

    public static perturbation.location.PerturbationLocation __L1831;

    public static perturbation.location.PerturbationLocation __L1832;

    public static perturbation.location.PerturbationLocation __L1833;

    public static perturbation.location.PerturbationLocation __L1834;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:43)", 1803, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:53)", 1804, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:53)", 1805, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:53)", 1806, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:54)", 1807, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:59)", 1808, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:60)", 1809, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:61)", 1810, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:61)", 1811, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:61)", 1812, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:61)", 1813, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:61)", 1814, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:62)", 1815, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:63)", 1816, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:63)", 1817, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:63)", 1818, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:63)", 1819, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:63)", 1820, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:73)", 1821, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:73)", 1822, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:73)", 1823, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:73)", 1824, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:73)", 1825, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:83)", 1826, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:88)", 1827, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:93)", 1828, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:98)", 1829, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:103)", 1830, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:103)", 1831, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:103)", 1832, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:113)", 1833, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.__L1834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/ResourceInputStream.java:113)", 1834, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream.initPerturbationLocation0();
    }
}

