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
package org.broadleafcommerce.common.web.resource;


@org.springframework.stereotype.Service("blBroadleafContextUtil")
public class BroadleafContextUtil {
    @javax.annotation.Resource(name = "blSiteResolver")
    protected org.broadleafcommerce.common.web.BroadleafSiteResolver siteResolver;

    @javax.annotation.Resource(name = "blSandBoxResolver")
    protected org.broadleafcommerce.common.web.BroadleafSandBoxResolver sbResolver;

    @javax.annotation.Resource(name = "blThemeResolver")
    protected org.broadleafcommerce.common.web.BroadleafThemeResolver themeResolver;

    @javax.annotation.Resource(name = "blDeployBehaviorUtil")
    protected org.broadleafcommerce.common.util.DeployBehaviorUtil deployBehaviorUtil;

    protected boolean versioningEnabled = false;

    public void establishThinRequestContext() {
        establishThinRequestContextInternal(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7561, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7562, true));
    }

    public void establishThinRequestContextWithoutSandBox() {
        establishThinRequestContextInternal(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7563, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7564, false));
    }

    public void establishThinRequestContextWithoutThemeOrSandbox() {
        establishThinRequestContextInternal(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7565, false), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7566, false));
    }

    protected void establishThinRequestContextInternal(boolean includeTheme, boolean includeSandBox) {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7567, ((brc.getRequest()) == null))) {
            javax.servlet.http.HttpServletRequest req = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
            javax.servlet.http.HttpSession session = req.getSession(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7568, false));
            org.springframework.security.core.context.SecurityContext ctx = readSecurityContextFromSession(session);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7569, (ctx != null))) {
                org.springframework.security.core.context.SecurityContextHolder.setContext(ctx);
            }
            brc.setRequest(req);
        }
        org.springframework.web.context.request.WebRequest wr = brc.getWebRequest();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7570, ((brc.getNonPersistentSite()) == null))) {
            brc.setNonPersistentSite(siteResolver.resolveSite(wr, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7571, true)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7572, includeSandBox)) {
                brc.setSandBox(sbResolver.resolveSandBox(wr, brc.getNonPersistentSite()));
            }
            brc.setDeployBehavior((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7573, deployBehaviorUtil.isProductionSandBoxMode()) ? org.broadleafcommerce.common.web.DeployBehavior.CLONE_PARENT : org.broadleafcommerce.common.web.DeployBehavior.OVERWRITE_PARENT));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7574, includeTheme)) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7575, ((brc.getTheme()) == null))) {
                brc.setTheme(themeResolver.resolveTheme(wr));
            }
        }
    }

    public void clearThinRequestContext() {
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.remove();
    }

    protected java.lang.String getContextName(javax.servlet.http.HttpServletRequest request) {
        java.lang.String contextName = request.getServerName();
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7576, contextName.indexOf('.'));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7579, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7577, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7578, 0))))) {
            contextName = contextName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7580, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7581, contextName.indexOf('.')));
        }
        return contextName;
    }

    protected org.springframework.security.core.context.SecurityContext readSecurityContextFromSession(javax.servlet.http.HttpSession httpSession) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7582, (httpSession == null))) {
            return null;
        }
        java.lang.Object ctxFromSession = httpSession.getAttribute(org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7583, (ctxFromSession == null))) {
            return null;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7585, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7584, (ctxFromSession instanceof org.springframework.security.core.context.SecurityContext)))))) {
            return null;
        }
        return ((org.springframework.security.core.context.SecurityContext) (ctxFromSession));
    }

    public static perturbation.location.PerturbationLocation __L7561;

    public static perturbation.location.PerturbationLocation __L7562;

    public static perturbation.location.PerturbationLocation __L7563;

    public static perturbation.location.PerturbationLocation __L7564;

    public static perturbation.location.PerturbationLocation __L7565;

    public static perturbation.location.PerturbationLocation __L7566;

    public static perturbation.location.PerturbationLocation __L7567;

    public static perturbation.location.PerturbationLocation __L7568;

    public static perturbation.location.PerturbationLocation __L7569;

    public static perturbation.location.PerturbationLocation __L7570;

    public static perturbation.location.PerturbationLocation __L7571;

    public static perturbation.location.PerturbationLocation __L7572;

    public static perturbation.location.PerturbationLocation __L7573;

    public static perturbation.location.PerturbationLocation __L7574;

    public static perturbation.location.PerturbationLocation __L7575;

    public static perturbation.location.PerturbationLocation __L7576;

    public static perturbation.location.PerturbationLocation __L7577;

    public static perturbation.location.PerturbationLocation __L7578;

    public static perturbation.location.PerturbationLocation __L7579;

    public static perturbation.location.PerturbationLocation __L7580;

    public static perturbation.location.PerturbationLocation __L7581;

    public static perturbation.location.PerturbationLocation __L7582;

    public static perturbation.location.PerturbationLocation __L7583;

    public static perturbation.location.PerturbationLocation __L7584;

    public static perturbation.location.PerturbationLocation __L7585;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:70)", 7561, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:70)", 7562, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:78)", 7563, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:78)", 7564, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:86)", 7565, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:86)", 7566, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:101)", 7567, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:103)", 7568, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:105)", 7569, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:113)", 7570, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:114)", 7571, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:115)", 7572, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:118)", 7573, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:121)", 7574, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:122)", 7575, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:134)", 7576, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:135)", 7577, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:135)", 7578, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:135)", 7579, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:136)", 7580, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:136)", 7581, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:143)", 7582, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:148)", 7583, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:152)", 7584, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.__L7585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafContextUtil.java:152)", 7585, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.resource.BroadleafContextUtil.initPerturbationLocation0();
    }
}

