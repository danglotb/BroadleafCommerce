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


public class BroadleafRequestInterceptor implements org.springframework.web.context.request.WebRequestInterceptor {
    @javax.annotation.Resource(name = "blRequestProcessor")
    protected org.broadleafcommerce.common.web.BroadleafRequestProcessor requestProcessor;

    @java.lang.Override
    public void preHandle(org.springframework.web.context.request.WebRequest request) throws java.lang.Exception {
        requestProcessor.process(request);
    }

    @java.lang.Override
    public void postHandle(org.springframework.web.context.request.WebRequest request, org.springframework.ui.ModelMap model) throws java.lang.Exception {
    }

    @java.lang.Override
    public void afterCompletion(org.springframework.web.context.request.WebRequest request, java.lang.Exception ex) throws java.lang.Exception {
        requestProcessor.postProcess(request);
    }
}

