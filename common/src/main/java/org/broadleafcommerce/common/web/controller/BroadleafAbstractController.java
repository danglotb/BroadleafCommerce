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


public abstract class BroadleafAbstractController {
    protected boolean isAjaxRequest(javax.servlet.http.HttpServletRequest request) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7055, org.broadleafcommerce.common.web.controller.BroadleafControllerUtility.isAjaxRequest(request));
    }

    protected java.lang.String getContextPath(javax.servlet.http.HttpServletRequest request) {
        java.lang.String ctxPath = request.getContextPath();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7056, org.apache.commons.lang3.StringUtils.isBlank(ctxPath))) {
            return "/";
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7058, ((ctxPath.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7057, 0))) != '/'))) {
                ctxPath = '/' + ctxPath;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7062, ((ctxPath.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7061, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7059, ctxPath.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7060, 1)))))) != '/'))) {
                ctxPath = ctxPath + '/';
            }
            return ctxPath;
        }
    }

    protected <T> void addDeepLink(org.springframework.web.servlet.ModelAndView model, org.broadleafcommerce.common.web.deeplink.DeepLinkService<T> service, T item) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7063, (service == null))) {
            return ;
        }
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7064, ((brc.getSandBox()) != null))) {
            java.util.List<org.broadleafcommerce.common.web.deeplink.DeepLink> links = service.getLinks(item);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7067, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7065, links.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7066, 1))))) {
                model.addObject("adminDeepLink", links.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7068, 0)));
            }else {
                model.addObject("adminDeepLink", links);
            }
        }
    }

    protected java.lang.String jsonResponse(javax.servlet.http.HttpServletResponse response, java.util.Map<?, ?> responseMap) throws com.fasterxml.jackson.core.JsonGenerationException, com.fasterxml.jackson.databind.JsonMappingException, java.io.IOException {
        response.setHeader("Content-Type", "application/json");
        new com.fasterxml.jackson.databind.ObjectMapper().writeValue(response.getWriter(), responseMap);
        return null;
    }

    public static perturbation.location.PerturbationLocation __L7055;

    public static perturbation.location.PerturbationLocation __L7056;

    public static perturbation.location.PerturbationLocation __L7057;

    public static perturbation.location.PerturbationLocation __L7058;

    public static perturbation.location.PerturbationLocation __L7059;

    public static perturbation.location.PerturbationLocation __L7060;

    public static perturbation.location.PerturbationLocation __L7061;

    public static perturbation.location.PerturbationLocation __L7062;

    public static perturbation.location.PerturbationLocation __L7063;

    public static perturbation.location.PerturbationLocation __L7064;

    public static perturbation.location.PerturbationLocation __L7065;

    public static perturbation.location.PerturbationLocation __L7066;

    public static perturbation.location.PerturbationLocation __L7067;

    public static perturbation.location.PerturbationLocation __L7068;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:58)", 7055, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:71)", 7056, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:74)", 7057, "Numerical");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:74)", 7058, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:77)", 7059, "Numerical");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:77)", 7060, "Numerical");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:77)", 7061, "Numerical");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:77)", 7062, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:87)", 7063, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:92)", 7064, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:94)", 7065, "Numerical");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:94)", 7066, "Numerical");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:94)", 7067, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.__L7068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafAbstractController.java:95)", 7068, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.controller.BroadleafAbstractController.initPerturbationLocation0();
    }
}

