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
package org.broadleafcommerce.common.web.controller;


public class BroadleafControllerUtility {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.class);

    public static final java.lang.String BLC_REDIRECT_ATTRIBUTE = "blc_redirect";

    public static final java.lang.String BLC_AJAX_PARAMETER = "blcAjax";

    public static boolean isAjaxRequest(javax.servlet.http.HttpServletRequest request) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7069, org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.isAjaxRequest(new org.springframework.web.context.request.ServletWebRequest(request)));
    }

    public static boolean isAjaxRequest(org.springframework.web.context.request.WebRequest request) {
        java.lang.String ajaxParameter = request.getParameter(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.BLC_AJAX_PARAMETER);
        java.lang.String requestedWithHeader = request.getHeader("X-Requested-With");
        boolean result = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7074, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7072, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7070, (ajaxParameter != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7071, "true".equals(ajaxParameter)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7073, "XMLHttpRequest".equals(requestedWithHeader)))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7075, org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.LOG.isTraceEnabled())) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder().append("Request URL: [").append(request.getContextPath()).append("]").append(" - ").append("ajaxParam: [").append(java.lang.String.valueOf(ajaxParameter)).append("]").append(" - ").append("X-Requested-With: [").append(requestedWithHeader).append("]").append(" - ").append("Returning: [").append(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7076, result)).append("]");
            org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.LOG.trace(sb.toString());
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7077, result);
    }

    public static perturbation.location.PerturbationLocation __L7069;

    public static perturbation.location.PerturbationLocation __L7070;

    public static perturbation.location.PerturbationLocation __L7071;

    public static perturbation.location.PerturbationLocation __L7072;

    public static perturbation.location.PerturbationLocation __L7073;

    public static perturbation.location.PerturbationLocation __L7074;

    public static perturbation.location.PerturbationLocation __L7075;

    public static perturbation.location.PerturbationLocation __L7076;

    public static perturbation.location.PerturbationLocation __L7077;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:57)", 7069, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:63)", 7070, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:63)", 7071, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:63)", 7072, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:64)", 7073, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:63)", 7074, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7075 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:66)", 7075, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:74)", 7076, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.__L7077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafControllerUtility.java:78)", 7077, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.initPerturbationLocation0();
    }
}

