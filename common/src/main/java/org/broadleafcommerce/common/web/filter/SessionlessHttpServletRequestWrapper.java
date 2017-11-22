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
package org.broadleafcommerce.common.web.filter;


public class SessionlessHttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
    public SessionlessHttpServletRequestWrapper(javax.servlet.http.HttpServletRequest request) {
        super(request);
    }

    @java.lang.Override
    public java.lang.String getRequestedSessionId() {
        return null;
    }

    @java.lang.Override
    public javax.servlet.http.HttpSession getSession(boolean create) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper.__L7245, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper.__L7244, create))))) {
            return null;
        }
        throw new java.lang.UnsupportedOperationException("You are in a sessionless environment and cannot get/create a HttpSession.");
    }

    @java.lang.Override
    public javax.servlet.http.HttpSession getSession() {
        throw new java.lang.UnsupportedOperationException("You are in a sessionless environment and cannot get/create a HttpSession.");
    }

    public static perturbation.location.PerturbationLocation __L7244;

    public static perturbation.location.PerturbationLocation __L7245;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper.__L7244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SessionlessHttpServletRequestWrapper.java:38)", 7244, "Boolean");
        org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper.__L7245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/SessionlessHttpServletRequestWrapper.java:38)", 7245, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper.initPerturbationLocation0();
    }
}

