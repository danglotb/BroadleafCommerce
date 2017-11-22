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


public class UrlUtil {
    public static java.lang.String generateUrlKey(java.lang.String toConvert) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6869, (toConvert != null))) {
            toConvert = toConvert.replaceAll(" ", "-");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6870, toConvert.matches(".*?\\W.*?"))) {
                java.lang.String result = toConvert.replaceAll("[^\\w-]+", "");
                return org.apache.commons.lang.StringUtils.uncapitalize(result);
            }else {
                return org.apache.commons.lang.StringUtils.uncapitalize(toConvert);
            }
        }
        return toConvert;
    }

    public static java.lang.String fixRedirectUrl(java.lang.String contextPath, java.lang.String url) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6873, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UrlUtil.__L6871, url.indexOf("//"))) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UrlUtil.__L6872, 0))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6877, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6874, (contextPath != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6876, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6875, "".equals(contextPath))))))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6879, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6878, url.startsWith("/")))))) {
                    url = "/" + url;
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6881, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6880, url.startsWith(contextPath)))))) {
                    url = contextPath + url;
                }
            }
        }
        return url;
    }

    public static void validateUrl(java.lang.String url, javax.servlet.http.HttpServletRequest request) throws java.io.IOException {
        java.lang.String serverName = request.getServerName();
        java.lang.String port = ":" + (request.getServerPort());
        java.lang.String scheme = (request.getScheme()) + "://";
        java.lang.String relativeUrl = url.replace(scheme, "").replace(serverName, "").replace(port, "");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6887, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6883, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6882, "/".equals(relativeUrl)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6886, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6885, org.owasp.esapi.ESAPI.validator().isValidRedirectLocation("Redirect", relativeUrl, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UrlUtil.__L6884, false)))))))))) {
            throw new java.io.IOException("Redirect failed");
        }
    }

    public static perturbation.location.PerturbationLocation __L6869;

    public static perturbation.location.PerturbationLocation __L6870;

    public static perturbation.location.PerturbationLocation __L6871;

    public static perturbation.location.PerturbationLocation __L6872;

    public static perturbation.location.PerturbationLocation __L6873;

    public static perturbation.location.PerturbationLocation __L6874;

    public static perturbation.location.PerturbationLocation __L6875;

    public static perturbation.location.PerturbationLocation __L6876;

    public static perturbation.location.PerturbationLocation __L6877;

    public static perturbation.location.PerturbationLocation __L6878;

    public static perturbation.location.PerturbationLocation __L6879;

    public static perturbation.location.PerturbationLocation __L6880;

    public static perturbation.location.PerturbationLocation __L6881;

    public static perturbation.location.PerturbationLocation __L6882;

    public static perturbation.location.PerturbationLocation __L6883;

    public static perturbation.location.PerturbationLocation __L6884;

    public static perturbation.location.PerturbationLocation __L6885;

    public static perturbation.location.PerturbationLocation __L6886;

    public static perturbation.location.PerturbationLocation __L6887;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.UrlUtil.__L6869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:29)", 6869, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:31)", 6870, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:51)", 6871, "Numerical");
        org.broadleafcommerce.common.util.UrlUtil.__L6872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:51)", 6872, "Numerical");
        org.broadleafcommerce.common.util.UrlUtil.__L6873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:51)", 6873, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:53)", 6874, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:53)", 6875, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:53)", 6876, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:53)", 6877, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:54)", 6878, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:54)", 6879, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:57)", 6880, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:57)", 6881, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:83)", 6882, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:83)", 6883, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:83)", 6884, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:83)", 6885, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:83)", 6886, "Boolean");
        org.broadleafcommerce.common.util.UrlUtil.__L6887 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UrlUtil.java:83)", 6887, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.UrlUtil.initPerturbationLocation0();
    }
}

