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
package org.broadleafcommerce.common.web.util;


public class StatusExposingServletResponse extends javax.servlet.http.HttpServletResponseWrapper {
    private int httpStatus = 200;

    public StatusExposingServletResponse(javax.servlet.http.HttpServletResponse response) {
        super(response);
    }

    @java.lang.Override
    public void sendError(int sc) throws java.io.IOException {
        httpStatus = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7686, sc);
        super.sendError(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7687, sc));
    }

    @java.lang.Override
    public void sendError(int sc, java.lang.String msg) throws java.io.IOException {
        httpStatus = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7688, sc);
        super.sendError(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7689, sc), msg);
    }

    @java.lang.Override
    public void setStatus(int sc) {
        httpStatus = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7690, sc);
        super.setStatus(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7691, sc));
    }

    @java.lang.Override
    public void reset() {
        super.reset();
        this.httpStatus = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7692, javax.servlet.http.HttpServletResponse.SC_OK);
    }

    @java.lang.Override
    public void setStatus(int status, java.lang.String string) {
        super.setStatus(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7693, status), string);
        this.httpStatus = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7694, status);
    }

    public int getStatus() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7695, httpStatus);
    }

    public static perturbation.location.PerturbationLocation __L7686;

    public static perturbation.location.PerturbationLocation __L7687;

    public static perturbation.location.PerturbationLocation __L7688;

    public static perturbation.location.PerturbationLocation __L7689;

    public static perturbation.location.PerturbationLocation __L7690;

    public static perturbation.location.PerturbationLocation __L7691;

    public static perturbation.location.PerturbationLocation __L7692;

    public static perturbation.location.PerturbationLocation __L7693;

    public static perturbation.location.PerturbationLocation __L7694;

    public static perturbation.location.PerturbationLocation __L7695;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:45)", 7686, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:46)", 7687, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:51)", 7688, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:52)", 7689, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:57)", 7690, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:58)", 7691, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:64)", 7692, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:69)", 7693, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:70)", 7694, "Numerical");
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.__L7695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/StatusExposingServletResponse.java:74)", 7695, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.util.StatusExposingServletResponse.initPerturbationLocation0();
    }
}

