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
package org.broadleafcommerce.common.util;


public class BLCRequestUtils {
    private static java.lang.String OK_TO_USE_SESSION = "blOkToUseSession";

    private static java.lang.String URI_IS_FILTER_IGNORED = "blUriIsFilterIgnored";

    public static boolean isOKtoUseSession(org.springframework.web.context.request.WebRequest request) {
        java.lang.Boolean useSessionForRequestProcessing = ((java.lang.Boolean) (request.getAttribute(org.broadleafcommerce.common.util.BLCRequestUtils.OK_TO_USE_SESSION, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6178, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6179, (useSessionForRequestProcessing == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6180, true);
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6181, useSessionForRequestProcessing.booleanValue());
        }
    }

    public static boolean isFilteringIgnoredForUri(org.springframework.web.context.request.WebRequest request) {
        java.lang.Boolean ignoreUri = ((java.lang.Boolean) (request.getAttribute(org.broadleafcommerce.common.util.BLCRequestUtils.URI_IS_FILTER_IGNORED, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6182, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6183, (ignoreUri == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6184, false);
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6185, ignoreUri.booleanValue());
        }
    }

    public static java.lang.Object getSessionAttributeIfOk(org.springframework.web.context.request.WebRequest request, java.lang.String attribute) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6186, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            return request.getAttribute(attribute, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6187, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
        }
        return null;
    }

    public static boolean setSessionAttributeIfOk(org.springframework.web.context.request.WebRequest request, java.lang.String attribute, java.lang.Object value) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6188, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            request.setAttribute(attribute, value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6189, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6190, true);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6191, false);
    }

    public static void setOKtoUseSession(org.springframework.web.context.request.WebRequest request, java.lang.Boolean value) {
        request.setAttribute(org.broadleafcommerce.common.util.BLCRequestUtils.OK_TO_USE_SESSION, value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6192, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
    }

    public static void setIsFilteringIgnoredForUri(org.springframework.web.context.request.WebRequest request, java.lang.Boolean value) {
        request.setAttribute(org.broadleafcommerce.common.util.BLCRequestUtils.URI_IS_FILTER_IGNORED, value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6193, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
    }

    public static java.lang.String getURLorHeaderParameter(org.springframework.web.context.request.WebRequest request, java.lang.String varName) {
        java.lang.String returnValue = request.getHeader(varName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6194, (returnValue == null))) {
            returnValue = request.getParameter(varName);
        }
        return returnValue;
    }

    public static java.lang.String getRequestedServerPrefix() {
        javax.servlet.http.HttpServletRequest request = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getRequest();
        java.lang.String scheme = request.getScheme();
        java.lang.StringBuilder serverPrefix = new java.lang.StringBuilder(scheme);
        serverPrefix.append("://");
        serverPrefix.append(request.getServerName());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6205, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6199, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6195, scheme.equalsIgnoreCase("http"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6198, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6196, request.getServerPort())) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6197, 80)))))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6204, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6200, scheme.equalsIgnoreCase("https"))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6203, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6201, request.getServerPort())) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6202, 443))))))))))) {
            serverPrefix.append(":");
            serverPrefix.append(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6206, request.getServerPort()));
        }
        return serverPrefix.toString();
    }

    public static java.lang.String getRequestURIWithoutContext(javax.servlet.http.HttpServletRequest request) {
        java.lang.String requestURIWithoutContext = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6209, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6207, (request != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6208, ((request.getRequestURI()) != null)))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6210, ((request.getContextPath()) != null))) {
                requestURIWithoutContext = request.getRequestURI().substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6211, request.getContextPath().length()));
            }else {
                requestURIWithoutContext = request.getRequestURI();
            }
            int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6212, requestURIWithoutContext.indexOf(";"));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCRequestUtils.__L6215, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6213, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6214, 0))))) {
                requestURIWithoutContext = requestURIWithoutContext.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6216, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCRequestUtils.__L6217, pos));
            }
        }
        return requestURIWithoutContext;
    }

    public static perturbation.location.PerturbationLocation __L6178;

    public static perturbation.location.PerturbationLocation __L6179;

    public static perturbation.location.PerturbationLocation __L6180;

    public static perturbation.location.PerturbationLocation __L6181;

    public static perturbation.location.PerturbationLocation __L6182;

    public static perturbation.location.PerturbationLocation __L6183;

    public static perturbation.location.PerturbationLocation __L6184;

    public static perturbation.location.PerturbationLocation __L6185;

    public static perturbation.location.PerturbationLocation __L6186;

    public static perturbation.location.PerturbationLocation __L6187;

    public static perturbation.location.PerturbationLocation __L6188;

    public static perturbation.location.PerturbationLocation __L6189;

    public static perturbation.location.PerturbationLocation __L6190;

    public static perturbation.location.PerturbationLocation __L6191;

    public static perturbation.location.PerturbationLocation __L6192;

    public static perturbation.location.PerturbationLocation __L6193;

    public static perturbation.location.PerturbationLocation __L6194;

    public static perturbation.location.PerturbationLocation __L6195;

    public static perturbation.location.PerturbationLocation __L6196;

    public static perturbation.location.PerturbationLocation __L6197;

    public static perturbation.location.PerturbationLocation __L6198;

    public static perturbation.location.PerturbationLocation __L6199;

    public static perturbation.location.PerturbationLocation __L6200;

    public static perturbation.location.PerturbationLocation __L6201;

    public static perturbation.location.PerturbationLocation __L6202;

    public static perturbation.location.PerturbationLocation __L6203;

    public static perturbation.location.PerturbationLocation __L6204;

    public static perturbation.location.PerturbationLocation __L6205;

    public static perturbation.location.PerturbationLocation __L6206;

    public static perturbation.location.PerturbationLocation __L6207;

    public static perturbation.location.PerturbationLocation __L6208;

    public static perturbation.location.PerturbationLocation __L6209;

    public static perturbation.location.PerturbationLocation __L6210;

    public static perturbation.location.PerturbationLocation __L6211;

    public static perturbation.location.PerturbationLocation __L6212;

    public static perturbation.location.PerturbationLocation __L6213;

    public static perturbation.location.PerturbationLocation __L6214;

    public static perturbation.location.PerturbationLocation __L6215;

    public static perturbation.location.PerturbationLocation __L6216;

    public static perturbation.location.PerturbationLocation __L6217;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:44)", 6178, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:45)", 6179, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:47)", 6180, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:49)", 6181, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:54)", 6182, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:55)", 6183, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:57)", 6184, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:59)", 6185, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:68)", 6186, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:69)", 6187, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:80)", 6188, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:81)", 6189, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:82)", 6190, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:84)", 6191, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:93)", 6192, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:97)", 6193, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:107)", 6194, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6195, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6196, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6197, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6198, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6199, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6200, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6201, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6202, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6203, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6204, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:124)", 6205, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:126)", 6206, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:134)", 6207, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:134)", 6208, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:134)", 6209, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:135)", 6210, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:136)", 6211, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:142)", 6212, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:143)", 6213, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:143)", 6214, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:143)", 6215, "Boolean");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:144)", 6216, "Numerical");
        org.broadleafcommerce.common.util.BLCRequestUtils.__L6217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCRequestUtils.java:144)", 6217, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.BLCRequestUtils.initPerturbationLocation0();
    }
}

