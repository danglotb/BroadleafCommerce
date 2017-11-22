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


public abstract class AbstractGeneratedResourceHandler implements org.springframework.core.Ordered {
    public static final int DEFAULT_ORDER = 10000;

    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.class);

    @javax.annotation.Resource(name = "blStatisticsService")
    protected org.broadleafcommerce.common.cache.StatisticsService statisticsService;

    @javax.annotation.Resource(name = "blStreamingTransactionCapableUtil")
    protected org.broadleafcommerce.common.util.StreamingTransactionCapableUtil transUtil;

    @javax.annotation.Resource(name = "blResourceRequestExtensionManager")
    protected org.broadleafcommerce.common.web.resource.ResourceRequestExtensionManager extensionManager;

    protected net.sf.ehcache.Cache generatedResourceCache;

    public abstract boolean canHandle(java.lang.String path);

    public abstract org.springframework.core.io.Resource getFileContents(java.lang.String path, java.util.List<org.springframework.core.io.Resource> locations);

    public abstract boolean isCachedResourceExpired(org.broadleafcommerce.common.resource.GeneratedResource cachedResource, java.lang.String path, java.util.List<org.springframework.core.io.Resource> locations);

    public org.springframework.core.io.Resource getResource(final java.lang.String path, final java.util.List<org.springframework.core.io.Resource> locations) {
        net.sf.ehcache.Element e = getGeneratedResourceCache().get(path);
        org.springframework.core.io.Resource r = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7541, (e == null))) {
            statisticsService.addCacheStat(org.broadleafcommerce.common.cache.CacheStatType.GENERATED_RESOURCE_CACHE_HIT_RATE.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7542, false));
        }else {
            statisticsService.addCacheStat(org.broadleafcommerce.common.cache.CacheStatType.GENERATED_RESOURCE_CACHE_HIT_RATE.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7543, true));
        }
        boolean shouldGenerate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7544, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7547, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7545, (e == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7546, ((e.getObjectValue()) == null)))))) {
            shouldGenerate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7548, true);
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7551, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7549, ((e.getObjectValue()) instanceof org.broadleafcommerce.common.resource.GeneratedResource))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7550, isCachedResourceExpired(((org.broadleafcommerce.common.resource.GeneratedResource) (e.getObjectValue())), path, locations)))))) {
                shouldGenerate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7552, true);
            }else {
                r = ((org.springframework.core.io.Resource) (e.getObjectValue()));
            }

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7553, shouldGenerate)) {
            r = getFileContents(path, locations);
            e = new net.sf.ehcache.Element(path, r);
            getGeneratedResourceCache().put(e);
        }
        return r;
    }

    protected org.springframework.core.io.Resource getRawResource(java.lang.String path, java.util.List<org.springframework.core.io.Resource> locations) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder();
        extensionManager.getProxy().getOverrideResource(path, erh);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7554, ((erh.getContextMap().get(org.broadleafcommerce.common.web.resource.ResourceRequestExtensionHandler.RESOURCE_ATTR)) != null))) {
            return ((org.springframework.core.io.Resource) (erh.getContextMap().get(org.broadleafcommerce.common.web.resource.ResourceRequestExtensionHandler.RESOURCE_ATTR)));
        }
        for (org.springframework.core.io.Resource location : locations) {
            try {
                org.springframework.core.io.Resource resource = location.createRelative(path);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7557, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7555, resource.exists())) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7556, resource.isReadable()))))) {
                    return resource;
                }
            } catch (java.io.IOException ex) {
                org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.LOG.debug("Failed to create relative resource - trying next resource location", ex);
            }
        }
        return null;
    }

    protected java.lang.String getResourceContents(org.springframework.core.io.Resource resource) throws java.io.IOException {
        java.io.StringWriter writer = null;
        try {
            writer = new java.io.StringWriter();
            org.apache.commons.io.IOUtils.copy(resource.getInputStream(), writer, "UTF-8");
            return writer.toString();
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7558, (writer != null))) {
                writer.flush();
                writer.close();
            }
        }
    }

    protected net.sf.ehcache.Cache getGeneratedResourceCache() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7559, ((generatedResourceCache) == null))) {
            generatedResourceCache = net.sf.ehcache.CacheManager.getInstance().getCache("generatedResourceCache");
        }
        return generatedResourceCache;
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7560, org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.DEFAULT_ORDER);
    }

    public static perturbation.location.PerturbationLocation __L7541;

    public static perturbation.location.PerturbationLocation __L7542;

    public static perturbation.location.PerturbationLocation __L7543;

    public static perturbation.location.PerturbationLocation __L7544;

    public static perturbation.location.PerturbationLocation __L7545;

    public static perturbation.location.PerturbationLocation __L7546;

    public static perturbation.location.PerturbationLocation __L7547;

    public static perturbation.location.PerturbationLocation __L7548;

    public static perturbation.location.PerturbationLocation __L7549;

    public static perturbation.location.PerturbationLocation __L7550;

    public static perturbation.location.PerturbationLocation __L7551;

    public static perturbation.location.PerturbationLocation __L7552;

    public static perturbation.location.PerturbationLocation __L7553;

    public static perturbation.location.PerturbationLocation __L7554;

    public static perturbation.location.PerturbationLocation __L7555;

    public static perturbation.location.PerturbationLocation __L7556;

    public static perturbation.location.PerturbationLocation __L7557;

    public static perturbation.location.PerturbationLocation __L7558;

    public static perturbation.location.PerturbationLocation __L7559;

    public static perturbation.location.PerturbationLocation __L7560;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:96)", 7541, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:97)", 7542, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:99)", 7543, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:101)", 7544, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:102)", 7545, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:102)", 7546, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:102)", 7547, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:103)", 7548, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:104)", 7549, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:105)", 7550, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:104)", 7551, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:106)", 7552, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:111)", 7553, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:129)", 7554, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:136)", 7555, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:136)", 7556, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:136)", 7557, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:158)", 7558, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:166)", 7559, "Boolean");
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.__L7560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/resource/AbstractGeneratedResourceHandler.java:174)", 7560, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.resource.AbstractGeneratedResourceHandler.initPerturbationLocation0();
    }
}

