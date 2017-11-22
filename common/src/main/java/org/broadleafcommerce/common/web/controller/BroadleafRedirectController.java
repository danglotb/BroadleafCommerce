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


public class BroadleafRedirectController {
    public java.lang.String redirect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.ui.Model model) {
        java.lang.String path = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafRedirectController.__L7078, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(request)))) {
            path = ((java.lang.String) (request.getSession().getAttribute("BLC_REDIRECT_URL")));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.BroadleafRedirectController.__L7079, (path == null))) {
            path = request.getContextPath();
        }
        return "ajaxredirect:" + path;
    }

    public static perturbation.location.PerturbationLocation __L7078;

    public static perturbation.location.PerturbationLocation __L7079;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.controller.BroadleafRedirectController.__L7078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafRedirectController.java:56)", 7078, "Boolean");
        org.broadleafcommerce.common.web.controller.BroadleafRedirectController.__L7079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/BroadleafRedirectController.java:60)", 7079, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.controller.BroadleafRedirectController.initPerturbationLocation0();
    }
}

