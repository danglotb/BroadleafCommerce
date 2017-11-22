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
package org.broadleafcommerce.common.sitemap.controller;


public class BroadleafSiteMapController {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.class);

    @javax.annotation.Resource(name = "blSiteMapService")
    protected org.broadleafcommerce.common.sitemap.service.SiteMapService siteMapService;

    public org.springframework.core.io.FileSystemResource retrieveSiteMapFile(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException {
        java.io.File siteMapFile = siteMapService.getSiteMapFile(getRequestURIWithoutContext(request));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5370, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5367, (siteMapFile == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5369, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5368, siteMapFile.exists())))))))) {
            response.setStatus(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5371, 404));
            return null;
        }
        return new org.springframework.core.io.FileSystemResource(siteMapFile);
    }

    protected java.lang.String getRequestURIWithoutContext(javax.servlet.http.HttpServletRequest request) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5372, ((request.getContextPath()) != null))) {
            return request.getRequestURI().substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5373, request.getContextPath().length()));
        }else {
            return request.getRequestURI();
        }
    }

    public static perturbation.location.PerturbationLocation __L5367;

    public static perturbation.location.PerturbationLocation __L5368;

    public static perturbation.location.PerturbationLocation __L5369;

    public static perturbation.location.PerturbationLocation __L5370;

    public static perturbation.location.PerturbationLocation __L5371;

    public static perturbation.location.PerturbationLocation __L5372;

    public static perturbation.location.PerturbationLocation __L5373;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:57)", 5367, "Boolean");
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:57)", 5368, "Boolean");
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:57)", 5369, "Boolean");
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:57)", 5370, "Boolean");
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:58)", 5371, "Numerical");
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:65)", 5372, "Boolean");
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.__L5373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/controller/BroadleafSiteMapController.java:66)", 5373, "Numerical");
    }

    static {
        org.broadleafcommerce.common.sitemap.controller.BroadleafSiteMapController.initPerturbationLocation0();
    }
}

