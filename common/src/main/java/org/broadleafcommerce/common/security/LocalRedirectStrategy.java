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


public class LocalRedirectStrategy implements org.springframework.security.web.RedirectStrategy {
    private boolean contextRelative = false;

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.security.LocalRedirectStrategy.class);

    private boolean enforcePortMatch = false;

    @java.lang.Override
    public void sendRedirect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.String url) throws java.io.IOException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5103, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5102, url.startsWith("/")))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5106, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5104, org.apache.commons.lang.StringUtils.equals(request.getParameter("successUrl"), url))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5105, org.apache.commons.lang.StringUtils.equals(request.getParameter("failureUrl"), url)))))) {
                validateRedirectUrl(request.getContextPath(), url, request.getServerName(), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5107, request.getServerPort()));
            }
        }
        java.lang.String redirectUrl = calculateRedirectUrl(request.getContextPath(), url);
        redirectUrl = response.encodeRedirectURL(redirectUrl);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5108, org.broadleafcommerce.common.security.LocalRedirectStrategy.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.security.LocalRedirectStrategy.LOG.debug((("Redirecting to '" + url) + "'"));
        }
        response.sendRedirect(redirectUrl);
    }

    protected java.lang.String calculateRedirectUrl(java.lang.String contextPath, java.lang.String url) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5113, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5110, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5109, url.startsWith("http://")))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5112, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5111, url.startsWith("https://"))))))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5114, this.contextRelative)) {
                return url;
            }
            return contextPath + url;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5116, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5115, this.contextRelative))))) {
            return url;
        }
        url = url.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5119, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5117, url.indexOf("://"))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5118, 3)))));
        url = url.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5122, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5120, url.indexOf(contextPath))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5121, contextPath.length())))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5128, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5125, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5123, url.length())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5124, 1))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5127, ((url.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5126, 0))) == '/')))))) {
            url = url.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5129, 1));
        }
        return url;
    }

    private void validateRedirectUrl(java.lang.String contextPath, java.lang.String url, java.lang.String requestServerName, int requestServerPort) throws java.net.MalformedURLException {
        java.net.URL urlObject = new java.net.URL(url);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5132, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5130, urlObject.getProtocol().equals("http"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5131, urlObject.getProtocol().equals("https")))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5133, org.apache.commons.lang.StringUtils.equals(requestServerName, urlObject.getHost()))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5139, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5135, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5134, enforcePortMatch))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5138, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5136, requestServerPort)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5137, urlObject.getPort())))))))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5142, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5140, org.apache.commons.lang.StringUtils.isEmpty(contextPath))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5141, urlObject.getPath().startsWith(("/" + contextPath))))))) {
                        return ;
                    }
                }
            }
        }
        java.lang.String errorMessage = "Invalid redirect url specified.  Must be of the form /<relative view> or http[s]://<server name>[:<server port>][/<context path>]/...";
        org.broadleafcommerce.common.security.LocalRedirectStrategy.LOG.warn(((errorMessage + ":  ") + url));
        throw new java.net.MalformedURLException(((errorMessage + ":  ") + url));
    }

    public void setEnforcePortMatch(boolean enforcePortMatch) {
        this.enforcePortMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5143, enforcePortMatch);
    }

    public void setContextRelative(boolean contextRelative) {
        this.contextRelative = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5144, contextRelative);
    }

    public static perturbation.location.PerturbationLocation __L5102;

    public static perturbation.location.PerturbationLocation __L5103;

    public static perturbation.location.PerturbationLocation __L5104;

    public static perturbation.location.PerturbationLocation __L5105;

    public static perturbation.location.PerturbationLocation __L5106;

    public static perturbation.location.PerturbationLocation __L5107;

    public static perturbation.location.PerturbationLocation __L5108;

    public static perturbation.location.PerturbationLocation __L5109;

    public static perturbation.location.PerturbationLocation __L5110;

    public static perturbation.location.PerturbationLocation __L5111;

    public static perturbation.location.PerturbationLocation __L5112;

    public static perturbation.location.PerturbationLocation __L5113;

    public static perturbation.location.PerturbationLocation __L5114;

    public static perturbation.location.PerturbationLocation __L5115;

    public static perturbation.location.PerturbationLocation __L5116;

    public static perturbation.location.PerturbationLocation __L5117;

    public static perturbation.location.PerturbationLocation __L5118;

    public static perturbation.location.PerturbationLocation __L5119;

    public static perturbation.location.PerturbationLocation __L5120;

    public static perturbation.location.PerturbationLocation __L5121;

    public static perturbation.location.PerturbationLocation __L5122;

    public static perturbation.location.PerturbationLocation __L5123;

    public static perturbation.location.PerturbationLocation __L5124;

    public static perturbation.location.PerturbationLocation __L5125;

    public static perturbation.location.PerturbationLocation __L5126;

    public static perturbation.location.PerturbationLocation __L5127;

    public static perturbation.location.PerturbationLocation __L5128;

    public static perturbation.location.PerturbationLocation __L5129;

    public static perturbation.location.PerturbationLocation __L5130;

    public static perturbation.location.PerturbationLocation __L5131;

    public static perturbation.location.PerturbationLocation __L5132;

    public static perturbation.location.PerturbationLocation __L5133;

    public static perturbation.location.PerturbationLocation __L5134;

    public static perturbation.location.PerturbationLocation __L5135;

    public static perturbation.location.PerturbationLocation __L5136;

    public static perturbation.location.PerturbationLocation __L5137;

    public static perturbation.location.PerturbationLocation __L5138;

    public static perturbation.location.PerturbationLocation __L5139;

    public static perturbation.location.PerturbationLocation __L5140;

    public static perturbation.location.PerturbationLocation __L5141;

    public static perturbation.location.PerturbationLocation __L5142;

    public static perturbation.location.PerturbationLocation __L5143;

    public static perturbation.location.PerturbationLocation __L5144;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:53)", 5102, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:53)", 5103, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:54)", 5104, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:54)", 5105, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:54)", 5106, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:55)", 5107, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:60)", 5108, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:75)", 5109, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:75)", 5110, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:75)", 5111, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:75)", 5112, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:75)", 5113, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:76)", 5114, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:82)", 5115, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:82)", 5116, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:86)", 5117, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:86)", 5118, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:86)", 5119, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:87)", 5120, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:87)", 5121, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:87)", 5122, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:89)", 5123, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:89)", 5124, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:89)", 5125, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:89)", 5126, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:89)", 5127, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:89)", 5128, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:90)", 5129, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:113)", 5130, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:113)", 5131, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:113)", 5132, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:114)", 5133, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:115)", 5134, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:115)", 5135, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:115)", 5136, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:115)", 5137, "Numerical");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:115)", 5138, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:115)", 5139, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:116)", 5140, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:116)", 5141, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:116)", 5142, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:135)", 5143, "Boolean");
        org.broadleafcommerce.common.security.LocalRedirectStrategy.__L5144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/LocalRedirectStrategy.java:145)", 5144, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.LocalRedirectStrategy.initPerturbationLocation0();
    }
}

