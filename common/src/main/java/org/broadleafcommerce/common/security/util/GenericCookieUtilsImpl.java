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
package org.broadleafcommerce.common.security.util;


@org.springframework.stereotype.Component("blCookieUtils")
public class GenericCookieUtilsImpl implements org.broadleafcommerce.common.security.util.CookieUtils {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.class);

    protected final java.lang.String COOKIE_INVALIDATION_PLACEHOLDER_VALUE = "CookieInvalidationPlaceholderValue";

    @java.lang.Override
    public java.lang.Boolean shouldUseSecureCookieIfApplicable() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4888, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("cookies.use.secure", perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4887, false)));
    }

    @java.lang.Override
    public java.lang.String getCookieValue(javax.servlet.http.HttpServletRequest request, java.lang.String cookieName) {
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4889, (cookies != null))) {
            for (javax.servlet.http.Cookie cookie : cookies) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4890, cookieName.equals(cookie.getName()))) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @java.lang.Override
    public void setCookieValue(javax.servlet.http.HttpServletResponse response, java.lang.String cookieName, java.lang.String cookieValue, java.lang.String path, java.lang.Integer maxAge, java.lang.Boolean isSecure) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4891, org.apache.commons.lang3.StringUtils.isBlank(cookieValue))) {
            cookieValue = COOKIE_INVALIDATION_PLACEHOLDER_VALUE;
            maxAge = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4892, 0);
        }
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(cookieName, cookieValue);
        cookie.setPath(path);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4893, (maxAge != null))) {
            cookie.setMaxAge(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4894, maxAge));
        }
        if (shouldUseSecureCookieIfApplicable()) {
            cookie.setSecure(isSecure);
        }else {
            cookie.setSecure(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4895, false));
            org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.LOG.info("HTTP cookie set regardless of the value of isSecure.");
        }
        final java.lang.StringBuffer sb = new java.lang.StringBuffer();
        org.broadleafcommerce.common.security.util.ServerCookie.appendCookieValue(sb, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4896, cookie.getVersion()), cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getDomain(), cookie.getComment(), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4897, cookie.getMaxAge()), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4898, cookie.getSecure()), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4899, true));
        org.owasp.esapi.ESAPI.httpUtilities().addHeader(response, "Set-Cookie", sb.toString());
    }

    @java.lang.Override
    public void setCookieValue(javax.servlet.http.HttpServletResponse response, java.lang.String cookieName, java.lang.String cookieValue) {
        setCookieValue(response, cookieName, cookieValue, "/", null, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4900, false));
    }

    @java.lang.Override
    public void invalidateCookie(javax.servlet.http.HttpServletResponse response, java.lang.String cookieName) {
        setCookieValue(response, cookieName, "", "/", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4901, 0), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4902, false));
    }

    public static perturbation.location.PerturbationLocation __L4887;

    public static perturbation.location.PerturbationLocation __L4888;

    public static perturbation.location.PerturbationLocation __L4889;

    public static perturbation.location.PerturbationLocation __L4890;

    public static perturbation.location.PerturbationLocation __L4891;

    public static perturbation.location.PerturbationLocation __L4892;

    public static perturbation.location.PerturbationLocation __L4893;

    public static perturbation.location.PerturbationLocation __L4894;

    public static perturbation.location.PerturbationLocation __L4895;

    public static perturbation.location.PerturbationLocation __L4896;

    public static perturbation.location.PerturbationLocation __L4897;

    public static perturbation.location.PerturbationLocation __L4898;

    public static perturbation.location.PerturbationLocation __L4899;

    public static perturbation.location.PerturbationLocation __L4900;

    public static perturbation.location.PerturbationLocation __L4901;

    public static perturbation.location.PerturbationLocation __L4902;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:39)", 4887, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:39)", 4888, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:46)", 4889, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:48)", 4890, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:59)", 4891, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:61)", 4892, "Numerical");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:66)", 4893, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:67)", 4894, "Numerical");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:73)", 4895, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:79)", 4896, "Numerical");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:81)", 4897, "Numerical");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:81)", 4898, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:81)", 4899, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:91)", 4900, "Boolean");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:96)", 4901, "Numerical");
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.__L4902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/GenericCookieUtilsImpl.java:96)", 4902, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl.initPerturbationLocation0();
    }
}

