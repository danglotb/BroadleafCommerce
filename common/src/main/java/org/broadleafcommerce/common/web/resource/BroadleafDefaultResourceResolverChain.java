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


public class BroadleafDefaultResourceResolverChain implements org.springframework.web.servlet.resource.ResourceResolverChain {
    private final java.util.List<org.springframework.web.servlet.resource.ResourceResolver> resolvers = new java.util.ArrayList<org.springframework.web.servlet.resource.ResourceResolver>();

    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.class);

    private int index = -1;

    public BroadleafDefaultResourceResolverChain(java.util.List<? extends org.springframework.web.servlet.resource.ResourceResolver> resolvers) {
        if (resolvers != null) {
            this.resolvers.addAll(resolvers);
        }
    }

    @java.lang.Override
    public org.springframework.core.io.Resource resolveResource(javax.servlet.http.HttpServletRequest request, java.lang.String requestPath, java.util.List<? extends org.springframework.core.io.Resource> locations) {
        org.springframework.web.servlet.resource.ResourceResolver resolver = getNext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7586, (resolver == null))) {
            return null;
        }
        try {
            return resolver.resolveResource(request, requestPath, locations, this);
        } finally {
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7587, ((this.index)--));
        }
    }

    @java.lang.Override
    public java.lang.String resolveUrlPath(java.lang.String resourcePath, java.util.List<? extends org.springframework.core.io.Resource> locations) {
        org.springframework.web.servlet.resource.ResourceResolver resolver = getNext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7588, (resolver == null))) {
            return null;
        }
        try {
            java.lang.String returnPath = resolver.resolveUrlPath(resourcePath, locations, this);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7589, org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.LOG.trace(((((("The return path for " + resourcePath) + " from resolver ") + resolver) + " is ") + returnPath));
            }
            return returnPath;
        } finally {
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7590, ((this.index)--));
        }
    }

    private org.springframework.web.servlet.resource.ResourceResolver getNext() {
        org.springframework.util.Assert.state(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7593, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7591, this.index)) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7592, this.resolvers.size())))), "Current index exceeds the number of configured ResourceResolver's");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7598, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7594, this.index)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7597, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7595, this.resolvers.size())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7596, 1)))))))) {
            return null;
        }
        perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7599, ((this.index)++));
        return this.resolvers.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7600, this.index));
    }

    public static perturbation.location.PerturbationLocation __L7586;

    public static perturbation.location.PerturbationLocation __L7587;

    public static perturbation.location.PerturbationLocation __L7588;

    public static perturbation.location.PerturbationLocation __L7589;

    public static perturbation.location.PerturbationLocation __L7590;

    public static perturbation.location.PerturbationLocation __L7591;

    public static perturbation.location.PerturbationLocation __L7592;

    public static perturbation.location.PerturbationLocation __L7593;

    public static perturbation.location.PerturbationLocation __L7594;

    public static perturbation.location.PerturbationLocation __L7595;

    public static perturbation.location.PerturbationLocation __L7596;

    public static perturbation.location.PerturbationLocation __L7597;

    public static perturbation.location.PerturbationLocation __L7598;

    public static perturbation.location.PerturbationLocation __L7599;

    public static perturbation.location.PerturbationLocation __L7600;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:58)", 7586, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:64)", 7587, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:71)", 7588, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:76)", 7589, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:81)", 7590, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:87)", 7591, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:87)", 7592, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:87)", 7593, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:90)", 7594, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:90)", 7595, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:90)", 7596, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:90)", 7597, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:90)", 7598, "Boolean");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:94)", 7599, "Numerical");
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.__L7600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/BroadleafDefaultResourceResolverChain.java:95)", 7600, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain.initPerturbationLocation0();
    }
}

