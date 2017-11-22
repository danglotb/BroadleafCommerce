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


public class JsonResponse {
    protected java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<java.lang.String, java.lang.Object>();

    protected javax.servlet.http.HttpServletResponse response;

    public JsonResponse(javax.servlet.http.HttpServletResponse response) {
        this.response = response;
    }

    public org.broadleafcommerce.common.web.JsonResponse with(java.lang.String key, java.lang.Object value) {
        map.put(key, value);
        return this;
    }

    public java.lang.String done() {
        response.setHeader("Content-Type", "application/json");
        try {
            new com.fasterxml.jackson.databind.ObjectMapper().writeValue(response.getWriter(), map);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Could not serialize JSON", e);
        }
        return null;
    }
}

