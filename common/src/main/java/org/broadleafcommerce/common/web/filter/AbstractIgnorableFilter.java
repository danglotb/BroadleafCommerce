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
package org.broadleafcommerce.common.web.filter;


public abstract class AbstractIgnorableFilter extends org.springframework.web.filter.GenericFilterBean implements org.springframework.core.Ordered {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.class);

    @java.lang.Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7219, isIgnored(((javax.servlet.http.HttpServletRequest) (request)), ((javax.servlet.http.HttpServletResponse) (response))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7220, org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.LOG.trace(java.lang.String.format("%s filtering is disabled for %s", this.getClass().getName(), ((javax.servlet.http.HttpServletRequest) (request)).getRequestURI()));
            }
            chain.doFilter(request, response);
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7221, org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.LOG.trace(java.lang.String.format("%s filtering is enabled for %s", this.getClass().getName(), ((javax.servlet.http.HttpServletRequest) (request)).getRequestURI()));
            }
            doFilterUnlessIgnored(request, response, chain);
        }
    }

    protected boolean isIgnored(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) {
        boolean isUriSecurityIgnored = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7222, org.broadleafcommerce.common.util.BLCRequestUtils.isFilteringIgnoredForUri(new org.springframework.web.context.request.ServletWebRequest(httpServletRequest, httpServletResponse)));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7223, isUriSecurityIgnored);
    }

    public abstract void doFilterUnlessIgnored(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException;

    public static perturbation.location.PerturbationLocation __L7219;

    public static perturbation.location.PerturbationLocation __L7220;

    public static perturbation.location.PerturbationLocation __L7221;

    public static perturbation.location.PerturbationLocation __L7222;

    public static perturbation.location.PerturbationLocation __L7223;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableFilter.java:51)", 7219, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableFilter.java:52)", 7220, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableFilter.java:57)", 7221, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableFilter.java:65)", 7222, "Boolean");
        org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.__L7223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/filter/AbstractIgnorableFilter.java:66)", 7223, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.filter.AbstractIgnorableFilter.initPerturbationLocation0();
    }
}

