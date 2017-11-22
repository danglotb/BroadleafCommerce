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
package org.broadleafcommerce.common.file.service;


public class GloballySharedInputStream extends java.io.InputStream {
    private java.io.InputStream parentInputStream;

    public GloballySharedInputStream(java.io.InputStream parentInputStream) {
        this.parentInputStream = parentInputStream;
    }

    public int available() throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2663, parentInputStream.available());
    }

    public void close() throws java.io.IOException {
        parentInputStream.close();
    }

    public void mark(int arg0) {
        parentInputStream.mark(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2664, arg0));
    }

    public boolean markSupported() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2665, parentInputStream.markSupported());
    }

    public int read() throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2666, parentInputStream.read());
    }

    public int read(byte[] arg0, int arg1, int arg2) throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2669, parentInputStream.read(arg0, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2667, arg1), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2668, arg2)));
    }

    public int read(byte[] arg0) throws java.io.IOException {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2670, parentInputStream.read(arg0));
    }

    public void reset() throws java.io.IOException {
        parentInputStream.reset();
    }

    public long skip(long arg0) throws java.io.IOException {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2672, parentInputStream.skip(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2671, arg0)));
    }

    public static perturbation.location.PerturbationLocation __L2663;

    public static perturbation.location.PerturbationLocation __L2664;

    public static perturbation.location.PerturbationLocation __L2665;

    public static perturbation.location.PerturbationLocation __L2666;

    public static perturbation.location.PerturbationLocation __L2667;

    public static perturbation.location.PerturbationLocation __L2668;

    public static perturbation.location.PerturbationLocation __L2669;

    public static perturbation.location.PerturbationLocation __L2670;

    public static perturbation.location.PerturbationLocation __L2671;

    public static perturbation.location.PerturbationLocation __L2672;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:42)", 2663, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:50)", 2664, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:54)", 2665, "Boolean");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:58)", 2666, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:62)", 2667, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:62)", 2668, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:62)", 2669, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:66)", 2670, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:74)", 2671, "Numerical");
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.__L2672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/GloballySharedInputStream.java:74)", 2672, "Numerical");
    }

    static {
        org.broadleafcommerce.common.file.service.GloballySharedInputStream.initPerturbationLocation0();
    }
}

