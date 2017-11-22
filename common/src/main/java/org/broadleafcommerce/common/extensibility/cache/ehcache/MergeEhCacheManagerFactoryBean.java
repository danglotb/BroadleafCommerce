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
package org.broadleafcommerce.common.extensibility.cache.ehcache;


public class MergeEhCacheManagerFactoryBean extends org.springframework.cache.ehcache.EhCacheManagerFactoryBean implements org.springframework.context.ApplicationContextAware {
    private org.springframework.context.ApplicationContext applicationContext;

    @javax.annotation.Resource(name = "blMergedCacheConfigLocations")
    protected java.util.Set<java.lang.String> mergedCacheConfigLocations;

    protected java.util.List<org.springframework.core.io.Resource> configLocations;

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        this.applicationContext = applicationContext;
    }

    @java.lang.Override
    public void destroy() {
        super.destroy();
        try {
            net.sf.ehcache.CacheManager cacheManager = getObject();
            java.lang.reflect.Field cacheManagerTimer = net.sf.ehcache.CacheManager.class.getDeclaredField("cacheManagerTimer");
            cacheManagerTimer.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1267, true));
            java.lang.Object failSafeTimer = cacheManagerTimer.get(cacheManager);
            java.lang.reflect.Field timer = failSafeTimer.getClass().getDeclaredField("timer");
            timer.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1268, true));
            java.lang.Object time = timer.get(failSafeTimer);
            java.lang.reflect.Field thread = time.getClass().getDeclaredField("thread");
            thread.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1269, true));
            java.lang.Thread item = ((java.lang.Thread) (thread.get(time)));
            item.setContextClassLoader(java.lang.Thread.currentThread().getContextClassLoader().getParent());
        } catch (java.lang.NoSuchFieldException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @java.lang.Override
    public void afterPropertiesSet() {
        java.util.List<org.springframework.core.io.Resource> temp = new java.util.ArrayList<>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1273, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1270, ((mergedCacheConfigLocations) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1272, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1271, mergedCacheConfigLocations.isEmpty())))))))) {
            for (java.lang.String location : mergedCacheConfigLocations) {
                temp.add(applicationContext.getResource(location));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1277, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1274, ((configLocations) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1276, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1275, configLocations.isEmpty())))))))) {
            for (org.springframework.core.io.Resource resource : configLocations) {
                temp.add(resource);
            }
        }
        try {
            org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource merge = new org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource();
            org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] sources = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1278, temp.size())];
            int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1279, 0);
            for (org.springframework.core.io.Resource resource : temp) {
                sources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1280, j)] = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(resource.getInputStream(), resource.getURL().toString());
                perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1281, (j++));
            }
            setConfigLocation(merge.getMergedConfigResource(sources));
        } catch (java.lang.Exception e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge cache locations", e);
        }
        super.afterPropertiesSet();
    }

    public void setConfigLocations(java.util.List<org.springframework.core.io.Resource> configLocations) throws org.springframework.beans.BeansException {
        this.configLocations = configLocations;
    }

    public static perturbation.location.PerturbationLocation __L1267;

    public static perturbation.location.PerturbationLocation __L1268;

    public static perturbation.location.PerturbationLocation __L1269;

    public static perturbation.location.PerturbationLocation __L1270;

    public static perturbation.location.PerturbationLocation __L1271;

    public static perturbation.location.PerturbationLocation __L1272;

    public static perturbation.location.PerturbationLocation __L1273;

    public static perturbation.location.PerturbationLocation __L1274;

    public static perturbation.location.PerturbationLocation __L1275;

    public static perturbation.location.PerturbationLocation __L1276;

    public static perturbation.location.PerturbationLocation __L1277;

    public static perturbation.location.PerturbationLocation __L1278;

    public static perturbation.location.PerturbationLocation __L1279;

    public static perturbation.location.PerturbationLocation __L1280;

    public static perturbation.location.PerturbationLocation __L1281;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:56)", 1267, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:59)", 1268, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:62)", 1269, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:75)", 1270, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:75)", 1271, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:75)", 1272, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:75)", 1273, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:80)", 1274, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:80)", 1275, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:80)", 1276, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:80)", 1277, "Boolean");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:87)", 1278, "Numerical");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:88)", 1279, "Numerical");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:90)", 1280, "Numerical");
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.__L1281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/cache/ehcache/MergeEhCacheManagerFactoryBean.java:91)", 1281, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.cache.ehcache.MergeEhCacheManagerFactoryBean.initPerturbationLocation0();
    }
}

