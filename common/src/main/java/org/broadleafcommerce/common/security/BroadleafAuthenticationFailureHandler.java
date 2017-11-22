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
package org.broadleafcommerce.common.security;


public class BroadleafAuthenticationFailureHandler extends org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler {
    private java.lang.String defaultFailureUrl;

    public BroadleafAuthenticationFailureHandler() {
        super();
    }

    public BroadleafAuthenticationFailureHandler(java.lang.String defaultFailureUrl) {
        super(defaultFailureUrl);
        this.defaultFailureUrl = defaultFailureUrl;
    }

    @java.lang.Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.AuthenticationException exception) throws java.io.IOException, javax.servlet.ServletException {
        java.lang.String failureUrlParam = org.broadleafcommerce.common.util.StringUtil.cleanseUrlString(request.getParameter("failureUrl"));
        java.lang.String successUrlParam = org.broadleafcommerce.common.util.StringUtil.cleanseUrlString(request.getParameter("successUrl"));
        java.lang.String failureUrl = org.apache.commons.lang.StringUtils.trimToNull(failureUrlParam);
        failureUrl = validateUrlParam(failureUrl);
        successUrlParam = validateUrlParam(successUrlParam);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5091, (failureUrl == null))) {
            failureUrl = org.apache.commons.lang.StringUtils.trimToNull(defaultFailureUrl);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5092, (failureUrl != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5093, org.apache.commons.lang.StringUtils.isNotEmpty(successUrlParam))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5095, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5094, failureUrl.contains("?")))))) {
                    failureUrl += "?successUrl=" + successUrlParam;
                }else {
                    failureUrl += "&successUrl=" + successUrlParam;
                }
            }
            saveException(request, exception);
            getRedirectStrategy().sendRedirect(request, response, failureUrl);
        }else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

    public java.lang.String validateUrlParam(java.lang.String url) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5096, (url != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5101, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5099, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5097, url.contains("http"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5098, url.contains("www")))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5100, url.contains(".")))))) {
                return null;
            }
        }
        return url;
    }

    public static perturbation.location.PerturbationLocation __L5091;

    public static perturbation.location.PerturbationLocation __L5092;

    public static perturbation.location.PerturbationLocation __L5093;

    public static perturbation.location.PerturbationLocation __L5094;

    public static perturbation.location.PerturbationLocation __L5095;

    public static perturbation.location.PerturbationLocation __L5096;

    public static perturbation.location.PerturbationLocation __L5097;

    public static perturbation.location.PerturbationLocation __L5098;

    public static perturbation.location.PerturbationLocation __L5099;

    public static perturbation.location.PerturbationLocation __L5100;

    public static perturbation.location.PerturbationLocation __L5101;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:54)", 5091, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:57)", 5092, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:58)", 5093, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:59)", 5094, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:59)", 5095, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:73)", 5096, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:74)", 5097, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:74)", 5098, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:74)", 5099, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:74)", 5100, "Boolean");
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.__L5101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/BroadleafAuthenticationFailureHandler.java:74)", 5101, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.BroadleafAuthenticationFailureHandler.initPerturbationLocation0();
    }
}

