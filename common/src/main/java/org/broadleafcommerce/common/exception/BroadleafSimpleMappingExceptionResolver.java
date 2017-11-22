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
package org.broadleafcommerce.common.exception;


@org.springframework.stereotype.Component("blSimpleMappingExceptionResolver")
public class BroadleafSimpleMappingExceptionResolver extends org.springframework.web.servlet.handler.SimpleMappingExceptionResolver {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.class);

    @org.springframework.beans.factory.annotation.Value("${exception.handler.enabled:false}")
    protected boolean exceptionHandlerEnabled;

    protected java.lang.String DEFAULT_ERROR_VIEW = "utility/error";

    @java.lang.Override
    protected org.springframework.web.servlet.ModelAndView doResolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object handler, java.lang.Exception ex) {
        java.lang.String viewName = getDefaultErrorView();
        java.lang.Integer statusCode = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1239, super.determineStatusCode(request, viewName));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1240, (statusCode != null))) {
            applyStatusCodeIfPossible(request, response, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1241, statusCode));
        }
        org.springframework.web.servlet.ModelAndView modelAndView = getModelAndView(viewName, ex, request);
        java.lang.String uuid = "";
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1242, ((request.getAttribute("exceptionUUID")) != null))) {
            uuid = request.getAttribute("exceptionUUID").toString();
        }
        modelAndView.getModel().put("exceptionUUID", uuid);
        return modelAndView;
    }

    @java.lang.Override
    public org.springframework.web.servlet.ModelAndView resolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.Object handler, java.lang.Exception ex) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1243, exceptionHandlerEnabled)) {
            java.lang.String uuid = java.util.UUID.randomUUID().toString();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1244, org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.LOG.isErrorEnabled())) {
                org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.LOG.error(java.lang.String.format("Error caught and handled.:%s", uuid), ex);
            }
            request.setAttribute("exceptionUUID", uuid);
            return doResolveException(request, response, handler, ex);
        }else {
            return null;
        }
    }

    public java.lang.String getDefaultErrorView() {
        return DEFAULT_ERROR_VIEW;
    }

    public static perturbation.location.PerturbationLocation __L1239;

    public static perturbation.location.PerturbationLocation __L1240;

    public static perturbation.location.PerturbationLocation __L1241;

    public static perturbation.location.PerturbationLocation __L1242;

    public static perturbation.location.PerturbationLocation __L1243;

    public static perturbation.location.PerturbationLocation __L1244;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafSimpleMappingExceptionResolver.java:59)", 1239, "Numerical");
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafSimpleMappingExceptionResolver.java:60)", 1240, "Boolean");
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafSimpleMappingExceptionResolver.java:61)", 1241, "Numerical");
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafSimpleMappingExceptionResolver.java:66)", 1242, "Boolean");
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafSimpleMappingExceptionResolver.java:77)", 1243, "Boolean");
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.__L1244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafSimpleMappingExceptionResolver.java:79)", 1244, "Boolean");
    }

    static {
        org.broadleafcommerce.common.exception.BroadleafSimpleMappingExceptionResolver.initPerturbationLocation0();
    }
}

