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


public class BroadleafResourceHttpRequestHandler extends org.springframework.web.servlet.resource.ResourceHttpRequestHandler {
    protected class OrderedComparator implements java.util.Comparator<java.lang.Object> {
        @java.lang.Override
        public int compare(java.lang.Object o1, java.lang.Object o2) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7603, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7601, (o1 instanceof org.springframework.core.Ordered))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7602, (o2 instanceof org.springframework.core.Ordered)))))) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7606, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7604, ((org.springframework.core.Ordered) (o1)).getOrder())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7605, ((org.springframework.core.Ordered) (o2)).getOrder()))));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7607, (o1 instanceof org.springframework.core.Ordered))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7610, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7608, ((org.springframework.core.Ordered) (o1)).getOrder())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7609, java.lang.Integer.MAX_VALUE))))) {
                    return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7611, 1);
                }else {
                    return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7613, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7612, 1))));
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7614, (o2 instanceof org.springframework.core.Ordered))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7617, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7615, ((org.springframework.core.Ordered) (o2)).getOrder())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7616, java.lang.Integer.MAX_VALUE))))) {
                    return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7619, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7618, 1))));
                }else {
                    return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7620, 1);
                }
            }
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7621, 0);
        }
    }

    @javax.annotation.Resource(name = "blBroadleafContextUtil")
    protected org.broadleafcommerce.common.web.resource.BroadleafContextUtil blcContextUtil;

    @javax.annotation.PostConstruct
    protected void sortCollections() {
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.OrderedComparator oc = new org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.OrderedComparator();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7622, ((getLocations()) != null))) {
            java.util.Collections.sort(getLocations(), oc);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7623, ((getResourceResolvers()) != null))) {
            java.util.Collections.sort(getResourceResolvers(), oc);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7624, ((getResourceTransformers()) != null))) {
            java.util.Collections.sort(getResourceTransformers(), oc);
        }
    }

    @java.lang.Override
    public void handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException {
        try {
            blcContextUtil.establishThinRequestContext();
            super.handleRequest(request, response);
        } finally {
            blcContextUtil.clearThinRequestContext();
        }
    }

    public static perturbation.location.PerturbationLocation __L7601;

    public static perturbation.location.PerturbationLocation __L7602;

    public static perturbation.location.PerturbationLocation __L7603;

    public static perturbation.location.PerturbationLocation __L7604;

    public static perturbation.location.PerturbationLocation __L7605;

    public static perturbation.location.PerturbationLocation __L7606;

    public static perturbation.location.PerturbationLocation __L7607;

    public static perturbation.location.PerturbationLocation __L7608;

    public static perturbation.location.PerturbationLocation __L7609;

    public static perturbation.location.PerturbationLocation __L7610;

    public static perturbation.location.PerturbationLocation __L7611;

    public static perturbation.location.PerturbationLocation __L7612;

    public static perturbation.location.PerturbationLocation __L7613;

    public static perturbation.location.PerturbationLocation __L7614;

    public static perturbation.location.PerturbationLocation __L7615;

    public static perturbation.location.PerturbationLocation __L7616;

    public static perturbation.location.PerturbationLocation __L7617;

    public static perturbation.location.PerturbationLocation __L7618;

    public static perturbation.location.PerturbationLocation __L7619;

    public static perturbation.location.PerturbationLocation __L7620;

    public static perturbation.location.PerturbationLocation __L7621;

    public static perturbation.location.PerturbationLocation __L7622;

    public static perturbation.location.PerturbationLocation __L7623;

    public static perturbation.location.PerturbationLocation __L7624;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:89)", 7601, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:89)", 7602, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:89)", 7603, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:90)", 7604, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:90)", 7605, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:90)", 7606, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:93)", 7607, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:94)", 7608, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:94)", 7609, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:94)", 7610, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:96)", 7611, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:98)", 7612, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:98)", 7613, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:102)", 7614, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:103)", 7615, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:103)", 7616, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:103)", 7617, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:105)", 7618, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:105)", 7619, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:107)", 7620, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:112)", 7621, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:52)", 7622, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:56)", 7623, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.__L7624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafResourceHttpRequestHandler.java:60)", 7624, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.resource.BroadleafResourceHttpRequestHandler.initPerturbationLocation0();
    }
}

