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
package org.broadleafcommerce.common.web;


@org.springframework.stereotype.Component("blRequestFilter")
@org.broadleafcommerce.common.admin.condition.ConditionalOnNotAdmin
public class BroadleafRequestFilter extends org.broadleafcommerce.common.web.filter.AbstractIgnorableOncePerRequestFilter {
    private final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(getClass());

    public static java.lang.String REQUEST_DTO_PARAM_NAME = "blRequestDTO";

    public static final java.lang.String ADMIN_USER_ID_PARAM_NAME = "blAdminUserId";

    private static final java.lang.String BLC_ADMIN_GWT = "org.broadleafcommerce.admin";

    private static final java.lang.String BLC_ADMIN_PREFIX = "blcadmin";

    private static final java.lang.String BLC_ADMIN_SERVICE = ".service";

    private java.util.Set<java.lang.String> ignoreSuffixes;

    @org.springframework.beans.factory.annotation.Autowired
    @org.springframework.beans.factory.annotation.Qualifier("blRequestProcessor")
    protected org.broadleafcommerce.common.web.BroadleafRequestProcessor requestProcessor;

    @java.lang.Override
    protected void doFilterInternalUnlessIgnored(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7845, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7844, shouldProcessURL(request, request.getRequestURI())))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7846, LOG.isTraceEnabled())) {
                LOG.trace(java.lang.String.format("%s not processing URL %s", getClass().getName(), request.getRequestURI()));
            }
            filterChain.doFilter(request, response);
            return ;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7847, LOG.isTraceEnabled())) {
            java.lang.String requestURIWithoutContext;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7848, ((request.getContextPath()) != null))) {
                requestURIWithoutContext = request.getRequestURI().substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7849, request.getContextPath().length()));
            }else {
                requestURIWithoutContext = request.getRequestURI();
            }
            int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7850, requestURIWithoutContext.indexOf(";"));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7853, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7851, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7852, 0))))) {
                requestURIWithoutContext = requestURIWithoutContext.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7854, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7855, pos));
            }
            LOG.trace(("Process URL Filter Begin " + requestURIWithoutContext));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7856, ((request.getAttribute(org.broadleafcommerce.common.web.BroadleafRequestFilter.REQUEST_DTO_PARAM_NAME)) == null))) {
            request.setAttribute(org.broadleafcommerce.common.web.BroadleafRequestFilter.REQUEST_DTO_PARAM_NAME, new org.broadleafcommerce.common.RequestDTOImpl(request));
        }
        try {
            requestProcessor.process(new org.springframework.web.context.request.ServletWebRequest(request, response));
            filterChain.doFilter(request, response);
        } catch (org.broadleafcommerce.common.web.exception.HaltFilterChainException e) {
            return ;
        } catch (org.broadleafcommerce.common.exception.SiteNotFoundException e) {
            LOG.warn("Could not resolve a site for the given request, returning not found");
            response.setStatus(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7857, javax.servlet.http.HttpServletResponse.SC_NOT_FOUND));
        } finally {
            requestProcessor.postProcess(new org.springframework.web.context.request.ServletWebRequest(request, response));
        }
    }

    protected boolean shouldProcessURL(javax.servlet.http.HttpServletRequest request, java.lang.String requestURI) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7859, shouldProcessURL(request, requestURI, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7858, false)));
    }

    protected boolean shouldProcessURL(javax.servlet.http.HttpServletRequest request, java.lang.String requestURI, boolean ignoreSessionCheck) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7864, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7862, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7860, requestURI.contains(org.broadleafcommerce.common.web.BroadleafRequestFilter.BLC_ADMIN_GWT))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7861, requestURI.endsWith(org.broadleafcommerce.common.web.BroadleafRequestFilter.BLC_ADMIN_SERVICE)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7863, requestURI.contains(org.broadleafcommerce.common.web.BroadleafRequestFilter.BLC_ADMIN_PREFIX)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7865, false);
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7871, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7869, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7867, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7866, ignoreSessionCheck))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7868, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(request))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7870, org.broadleafcommerce.common.module.ModulePresentUtil.isPresent(org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum.ENTERPRISE)))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7872, false);
            }

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7873, true);
    }

    protected java.util.Set getIgnoreSuffixes() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7876, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7874, ((ignoreSuffixes) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7875, ignoreSuffixes.isEmpty()))))) {
            java.lang.String[] ignoreSuffixList = new java.lang.String[]{ ".aif", ".aiff", ".asf", ".avi", ".bin", ".bmp", ".css", ".doc", ".eps", ".gif", ".hqx", ".js", ".jpg", ".jpeg", ".mid", ".midi", ".mov", ".mp3", ".mpg", ".mpeg", ".p65", ".pdf", ".pic", ".pict", ".png", ".ppt", ".psd", ".qxd", ".ram", ".ra", ".rm", ".sea", ".sit", ".stk", ".swf", ".tif", ".tiff", ".txt", ".rtf", ".vob", ".wav", ".wmf", ".xls", ".zip" };
            ignoreSuffixes = new java.util.HashSet<>(java.util.Arrays.asList(ignoreSuffixList));
        }
        return ignoreSuffixes;
    }

    @java.lang.Override
    protected boolean shouldNotFilterErrorDispatch() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7877, false);
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7878, org.broadleafcommerce.common.web.filter.FilterOrdered.PRE_SECURITY_LOW);
    }

    public static perturbation.location.PerturbationLocation __L7844;

    public static perturbation.location.PerturbationLocation __L7845;

    public static perturbation.location.PerturbationLocation __L7846;

    public static perturbation.location.PerturbationLocation __L7847;

    public static perturbation.location.PerturbationLocation __L7848;

    public static perturbation.location.PerturbationLocation __L7849;

    public static perturbation.location.PerturbationLocation __L7850;

    public static perturbation.location.PerturbationLocation __L7851;

    public static perturbation.location.PerturbationLocation __L7852;

    public static perturbation.location.PerturbationLocation __L7853;

    public static perturbation.location.PerturbationLocation __L7854;

    public static perturbation.location.PerturbationLocation __L7855;

    public static perturbation.location.PerturbationLocation __L7856;

    public static perturbation.location.PerturbationLocation __L7857;

    public static perturbation.location.PerturbationLocation __L7858;

    public static perturbation.location.PerturbationLocation __L7859;

    public static perturbation.location.PerturbationLocation __L7860;

    public static perturbation.location.PerturbationLocation __L7861;

    public static perturbation.location.PerturbationLocation __L7862;

    public static perturbation.location.PerturbationLocation __L7863;

    public static perturbation.location.PerturbationLocation __L7864;

    public static perturbation.location.PerturbationLocation __L7865;

    public static perturbation.location.PerturbationLocation __L7866;

    public static perturbation.location.PerturbationLocation __L7867;

    public static perturbation.location.PerturbationLocation __L7868;

    public static perturbation.location.PerturbationLocation __L7869;

    public static perturbation.location.PerturbationLocation __L7870;

    public static perturbation.location.PerturbationLocation __L7871;

    public static perturbation.location.PerturbationLocation __L7872;

    public static perturbation.location.PerturbationLocation __L7873;

    public static perturbation.location.PerturbationLocation __L7874;

    public static perturbation.location.PerturbationLocation __L7875;

    public static perturbation.location.PerturbationLocation __L7876;

    public static perturbation.location.PerturbationLocation __L7877;

    public static perturbation.location.PerturbationLocation __L7878;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7844 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:78)", 7844, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:78)", 7845, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:79)", 7846, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:86)", 7847, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:89)", 7848, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:90)", 7849, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:96)", 7850, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:97)", 7851, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:97)", 7852, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:97)", 7853, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:98)", 7854, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:98)", 7855, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:104)", 7856, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:115)", 7857, "Numerical");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:133)", 7858, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:133)", 7859, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:137)", 7860, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:137)", 7861, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:137)", 7862, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:137)", 7863, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:137)", 7864, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:138)", 7865, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:139)", 7866, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:139)", 7867, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:139)", 7868, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:139)", 7869, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:140)", 7870, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:139)", 7871, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:143)", 7872, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:145)", 7873, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:158)", 7874, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:158)", 7875, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:158)", 7876, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:167)", 7877, "Boolean");
        org.broadleafcommerce.common.web.BroadleafRequestFilter.__L7878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafRequestFilter.java:172)", 7878, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafRequestFilter.initPerturbationLocation0();
    }
}

