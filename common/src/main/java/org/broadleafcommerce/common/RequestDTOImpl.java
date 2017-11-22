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
package org.broadleafcommerce.common;


public class RequestDTOImpl implements java.io.Serializable , org.broadleafcommerce.common.RequestDTO {
    private static final long serialVersionUID = 1L;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "RequestDTOImpl_Request_URI")
    private java.lang.String requestURI;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "RequestDTOImpl_Full_Url")
    private java.lang.String fullUrlWithQueryString;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "RequestDTOImpl_Is_Secure")
    private java.lang.Boolean secure;

    java.util.Map<java.lang.String, java.lang.String> requestContextAttributes = new java.util.HashMap<java.lang.String, java.lang.String>();

    public RequestDTOImpl() {
    }

    public RequestDTOImpl(javax.servlet.http.HttpServletRequest request) {
        requestURI = request.getRequestURI();
        fullUrlWithQueryString = request.getRequestURL().toString();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(request.getQueryString())) {
            fullUrlWithQueryString += "?" + (request.getQueryString());
        }
        secure = ("HTTPS".equalsIgnoreCase(request.getScheme())) || (request.isSecure());
        for (java.lang.Object key : request.getParameterMap().keySet()) {
            java.lang.String paramKey = key.toString();
            requestContextAttributes.put(paramKey, request.getParameter(paramKey));
        }
    }

    public RequestDTOImpl(org.springframework.web.context.request.WebRequest request) {
        secure = request.isSecure();
        for (java.lang.String key : request.getParameterMap().keySet()) {
            requestContextAttributes.put(key, request.getParameter(key));
        }
    }

    @java.lang.Override
    public java.lang.String getRequestURI() {
        return requestURI;
    }

    @java.lang.Override
    public java.lang.String getFullUrLWithQueryString() {
        return fullUrlWithQueryString;
    }

    @java.lang.Override
    public java.lang.Boolean isSecure() {
        return secure;
    }

    public java.util.Map<java.lang.String, java.lang.String> getRequestContextAttributes() {
        return requestContextAttributes;
    }

    public void setRequestContextAttributes(java.util.Map<java.lang.String, java.lang.String> requestContextAttributes) {
        this.requestContextAttributes = requestContextAttributes;
    }

    public java.lang.String getFullUrlWithQueryString() {
        return fullUrlWithQueryString;
    }

    public void setFullUrlWithQueryString(java.lang.String fullUrlWithQueryString) {
        this.fullUrlWithQueryString = fullUrlWithQueryString;
    }

    public java.lang.Boolean getSecure() {
        return secure;
    }

    public void setSecure(java.lang.Boolean secure) {
        this.secure = secure;
    }

    public void setRequestURI(java.lang.String requestURI) {
        this.requestURI = requestURI;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getProperties() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.RequestDTOImpl.__L8009, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext()) != null))) {
            return org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getAdditionalProperties();
        }else {
            return null;
        }
    }

    public static perturbation.location.PerturbationLocation __L8009;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.RequestDTOImpl.__L8009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/RequestDTOImpl.java:127)", 8009, "Boolean");
    }

    static {
        org.broadleafcommerce.common.RequestDTOImpl.initPerturbationLocation0();
    }
}

