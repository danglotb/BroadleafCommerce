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


public class RepeatSubmitProtectionFilter implements javax.servlet.Filter {
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> requests = new java.util.HashMap<java.lang.String, java.util.List<java.lang.String>>(100);

    @java.lang.Override
    public void destroy() {
    }

    @java.lang.Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        boolean useSession = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7669, true);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7672, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7670, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7671, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getWebRequest()) != null)))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7674, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7673, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getWebRequest())))))) {
                useSession = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7675, false);
            }
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7677, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7676, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(((javax.servlet.http.HttpServletRequest) (request))))))))) {
                useSession = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7678, false);
            }

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7679, useSession)) {
            java.lang.String sessionId;
            java.lang.String requestURI;
            synchronized(requests) {
                sessionId = ((javax.servlet.http.HttpServletRequest) (request)).getSession().getId();
                requestURI = ((javax.servlet.http.HttpServletRequest) (request)).getRequestURI();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7682, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7680, requests.containsKey(sessionId))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7681, requests.get(sessionId).contains(requestURI)))))) {
                    ((javax.servlet.http.HttpServletResponse) (response)).setStatus(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7683, javax.servlet.http.HttpServletResponse.SC_NO_CONTENT));
                    return ;
                }
                java.util.List<java.lang.String> myRequests = requests.get(sessionId);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7684, (myRequests == null))) {
                    myRequests = new java.util.ArrayList<java.lang.String>();
                    requests.put(sessionId, myRequests);
                }
                myRequests.add(requestURI);
            }
            try {
                chain.doFilter(request, response);
            } finally {
                synchronized(requests) {
                    java.util.List<java.lang.String> myRequests = requests.get(sessionId);
                    myRequests.remove(requestURI);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7685, myRequests.isEmpty())) {
                        requests.remove(sessionId);
                    }
                }
            }
        }else {
            chain.doFilter(request, response);
        }
    }

    @java.lang.Override
    public void init(javax.servlet.FilterConfig arg0) throws javax.servlet.ServletException {
    }

    public static perturbation.location.PerturbationLocation __L7669;

    public static perturbation.location.PerturbationLocation __L7670;

    public static perturbation.location.PerturbationLocation __L7671;

    public static perturbation.location.PerturbationLocation __L7672;

    public static perturbation.location.PerturbationLocation __L7673;

    public static perturbation.location.PerturbationLocation __L7674;

    public static perturbation.location.PerturbationLocation __L7675;

    public static perturbation.location.PerturbationLocation __L7676;

    public static perturbation.location.PerturbationLocation __L7677;

    public static perturbation.location.PerturbationLocation __L7678;

    public static perturbation.location.PerturbationLocation __L7679;

    public static perturbation.location.PerturbationLocation __L7680;

    public static perturbation.location.PerturbationLocation __L7681;

    public static perturbation.location.PerturbationLocation __L7682;

    public static perturbation.location.PerturbationLocation __L7683;

    public static perturbation.location.PerturbationLocation __L7684;

    public static perturbation.location.PerturbationLocation __L7685;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:50)", 7669, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:51)", 7670, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:52)", 7671, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:51)", 7672, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:53)", 7673, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:53)", 7674, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:54)", 7675, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:56)", 7676, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:56)", 7677, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:57)", 7678, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:60)", 7679, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:66)", 7680, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:66)", 7681, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:66)", 7682, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:68)", 7683, "Numerical");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:72)", 7684, "Boolean");
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.__L7685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/RepeatSubmitProtectionFilter.java:84)", 7685, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.util.RepeatSubmitProtectionFilter.initPerturbationLocation0();
    }
}

