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
package org.broadleafcommerce.common.security.service;


@org.springframework.stereotype.Service("blStaleStateProtectionService")
public class StaleStateProtectionServiceImpl implements org.broadleafcommerce.common.security.service.StaleStateProtectionService {
    public static final java.lang.String STATEVERSIONTOKEN = "stateVersionToken";

    public static final java.lang.String STATECHANGENOTIFICATIONTOKEN = "stateChangeNotificationToken";

    public static final java.lang.String STATEVERSIONTOKENPARAMETER = "stateVersionToken";

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.class);

    @org.springframework.beans.factory.annotation.Value("${stale.state.protection.enabled:false}")
    protected boolean staleStateProtectionEnabled = false;

    @java.lang.Override
    public void compareToken(java.lang.String passedToken) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4860, staleStateProtectionEnabled)) {
            javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4864, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4862, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4861, getStateVersionToken().equals(passedToken)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4863, ((request.getAttribute(getStateVersionTokenParameter())) == null)))))) {
                throw new org.broadleafcommerce.common.security.service.StaleStateServiceException((("Page version token mismatch (" + passedToken) + "). The request likely came from a stale page."));
            }else {
                request.setAttribute(getStateVersionTokenParameter(), "passed");
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4865, org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.LOG.debug("Validated page version token");
                }
            }
        }
    }

    @java.lang.Override
    public java.lang.String getStateVersionToken() {
        javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4866, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(request)))) {
            javax.servlet.http.HttpSession session = request.getSession();
            java.lang.String token = ((java.lang.String) (session.getAttribute(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATEVERSIONTOKEN)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4867, org.apache.commons.lang.StringUtils.isEmpty(token))) {
                try {
                    token = org.broadleafcommerce.common.security.RandomGenerator.generateRandomId("SHA1PRNG", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4868, 32));
                } catch (java.security.NoSuchAlgorithmException e) {
                    org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.LOG.error("Unable to generate random number", e);
                    throw new java.lang.RuntimeException("Unable to generate random number", e);
                }
                session.setAttribute(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATEVERSIONTOKEN, token);
            }
            return token;
        }
        return null;
    }

    @java.lang.Override
    public void invalidateState() {
        invalidateState(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4869, false));
    }

    @java.lang.Override
    public void invalidateState(boolean notify) {
        javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4870, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(request)))) {
            javax.servlet.http.HttpSession session = request.getSession();
            session.removeAttribute(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATEVERSIONTOKEN);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4871, notify)) {
                getStateVersionToken();
                request.setAttribute(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATECHANGENOTIFICATIONTOKEN, "true");
            }
        }
    }

    @java.lang.Override
    public boolean sendRedirectOnStateChange(javax.servlet.http.HttpServletResponse response, java.lang.String... stateChangeParams) throws java.io.IOException {
        javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (org.springframework.web.context.request.RequestContextHolder.getRequestAttributes())).getRequest();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4872, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(new org.springframework.web.context.request.ServletWebRequest(request)))) {
            java.lang.String notification = ((java.lang.String) (request.getAttribute(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATECHANGENOTIFICATIONTOKEN)));
            if (java.lang.Boolean.valueOf(notification)) {
                java.lang.String uri = request.getRequestURI();
                java.util.Enumeration<java.lang.String> params = request.getParameterNames();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Arrays.sort(stateChangeParams);
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4873, params.hasMoreElements())) {
                    java.lang.String param = params.nextElement();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4879, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4875, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4874, param.equals(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATEVERSIONTOKEN)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4878, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4876, java.util.Arrays.binarySearch(stateChangeParams, param))) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4877, 0)))))))) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4882, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4880, sb.length())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4881, 0))))) {
                            sb.append("?");
                        }else {
                            sb.append("&");
                        }
                        sb.append(param);
                        sb.append("=");
                        sb.append(request.getParameter(param));
                    }
                } 
                uri = uri + (sb.toString());
                java.lang.String encoded = response.encodeRedirectURL(uri);
                try {
                    org.broadleafcommerce.common.util.UrlUtil.validateUrl(encoded, request);
                } catch (java.io.IOException e) {
                    org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.LOG.error(("SECURITY FAILURE Bad redirect location: " + (org.broadleafcommerce.common.util.StringUtil.sanitize(encoded))), e);
                    response.sendError(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4883, 403));
                }
                response.sendRedirect(encoded);
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4884, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4885, false);
    }

    @java.lang.Override
    public boolean isEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4886, staleStateProtectionEnabled);
    }

    @java.lang.Override
    public java.lang.String getStateVersionTokenParameter() {
        return org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.STATEVERSIONTOKENPARAMETER;
    }

    public static perturbation.location.PerturbationLocation __L4860;

    public static perturbation.location.PerturbationLocation __L4861;

    public static perturbation.location.PerturbationLocation __L4862;

    public static perturbation.location.PerturbationLocation __L4863;

    public static perturbation.location.PerturbationLocation __L4864;

    public static perturbation.location.PerturbationLocation __L4865;

    public static perturbation.location.PerturbationLocation __L4866;

    public static perturbation.location.PerturbationLocation __L4867;

    public static perturbation.location.PerturbationLocation __L4868;

    public static perturbation.location.PerturbationLocation __L4869;

    public static perturbation.location.PerturbationLocation __L4870;

    public static perturbation.location.PerturbationLocation __L4871;

    public static perturbation.location.PerturbationLocation __L4872;

    public static perturbation.location.PerturbationLocation __L4873;

    public static perturbation.location.PerturbationLocation __L4874;

    public static perturbation.location.PerturbationLocation __L4875;

    public static perturbation.location.PerturbationLocation __L4876;

    public static perturbation.location.PerturbationLocation __L4877;

    public static perturbation.location.PerturbationLocation __L4878;

    public static perturbation.location.PerturbationLocation __L4879;

    public static perturbation.location.PerturbationLocation __L4880;

    public static perturbation.location.PerturbationLocation __L4881;

    public static perturbation.location.PerturbationLocation __L4882;

    public static perturbation.location.PerturbationLocation __L4883;

    public static perturbation.location.PerturbationLocation __L4884;

    public static perturbation.location.PerturbationLocation __L4885;

    public static perturbation.location.PerturbationLocation __L4886;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:59)", 4860, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:61)", 4861, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:61)", 4862, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:61)", 4863, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:61)", 4864, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:65)", 4865, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:75)", 4866, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:78)", 4867, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:80)", 4868, "Numerical");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4869 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:94)", 4869, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4870 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:100)", 4870, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4871 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:103)", 4871, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4872 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:113)", 4872, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4873 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:120)", 4873, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4874 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:122)", 4874, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4875 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:122)", 4875, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4876 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:122)", 4876, "Numerical");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4877 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:122)", 4877, "Numerical");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4878 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:122)", 4878, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4879 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:122)", 4879, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4880 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:123)", 4880, "Numerical");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4881 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:123)", 4881, "Numerical");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4882 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:123)", 4882, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4883 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:139)", 4883, "Numerical");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4884 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:142)", 4884, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4885 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:145)", 4885, "Boolean");
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.__L4886 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/service/StaleStateProtectionServiceImpl.java:150)", 4886, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.service.StaleStateProtectionServiceImpl.initPerturbationLocation0();
    }
}

