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
package org.broadleafcommerce.common.vendor.service.cache;


public class ServiceResponseCache {
    public java.lang.Object processRequest(org.aspectj.lang.ProceedingJoinPoint call) throws java.lang.Throwable {
        org.broadleafcommerce.common.vendor.service.cache.CacheRequest cacheRequest = ((org.broadleafcommerce.common.vendor.service.cache.CacheRequest) (call.getArgs()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6918, 0)]));
        net.sf.ehcache.Cache cache = ((org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCacheable) (call.getTarget())).getCache();
        java.util.List<java.io.Serializable> cacheItemResponses = new java.util.ArrayList<java.io.Serializable>();
        java.util.Iterator<org.broadleafcommerce.common.vendor.service.cache.CacheItemRequest> itr = cacheRequest.getCacheItemRequests().iterator();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6919, itr.hasNext())) {
            org.broadleafcommerce.common.vendor.service.cache.CacheItemRequest itemRequest = itr.next();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6921, cache.isKeyInCache(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6920, itemRequest.key())))) {
                cacheItemResponses.add(cache.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6922, itemRequest.key())).getValue());
                itr.remove();
            }
        } 
        org.broadleafcommerce.common.vendor.service.cache.CacheResponse returnValue = ((org.broadleafcommerce.common.vendor.service.cache.CacheResponse) (call.proceed()));
        java.lang.Object[] responses = new java.lang.Object[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6925, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6923, cacheItemResponses.size())) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6924, returnValue.getCacheItemResponses().length))))];
        responses = cacheItemResponses.toArray(responses);
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6926, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6929, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6927, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6928, returnValue.getCacheItemResponses().length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6930, (j++))) {
            net.sf.ehcache.Element element = new net.sf.ehcache.Element(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6932, cacheRequest.getCacheItemRequests().get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6931, j)).key()), returnValue.getCacheItemResponses()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6933, j)]);
            cache.put(element);
        }
        java.lang.System.arraycopy(returnValue.getCacheItemResponses(), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6934, 0), responses, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6935, cacheItemResponses.size()), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6936, returnValue.getCacheItemResponses().length));
        returnValue.setCacheItemResponses(responses);
        return returnValue;
    }

    public static perturbation.location.PerturbationLocation __L6918;

    public static perturbation.location.PerturbationLocation __L6919;

    public static perturbation.location.PerturbationLocation __L6920;

    public static perturbation.location.PerturbationLocation __L6921;

    public static perturbation.location.PerturbationLocation __L6922;

    public static perturbation.location.PerturbationLocation __L6923;

    public static perturbation.location.PerturbationLocation __L6924;

    public static perturbation.location.PerturbationLocation __L6925;

    public static perturbation.location.PerturbationLocation __L6926;

    public static perturbation.location.PerturbationLocation __L6927;

    public static perturbation.location.PerturbationLocation __L6928;

    public static perturbation.location.PerturbationLocation __L6929;

    public static perturbation.location.PerturbationLocation __L6930;

    public static perturbation.location.PerturbationLocation __L6931;

    public static perturbation.location.PerturbationLocation __L6932;

    public static perturbation.location.PerturbationLocation __L6933;

    public static perturbation.location.PerturbationLocation __L6934;

    public static perturbation.location.PerturbationLocation __L6935;

    public static perturbation.location.PerturbationLocation __L6936;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:37)", 6918, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:41)", 6919, "Boolean");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:43)", 6920, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:43)", 6921, "Boolean");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:44)", 6922, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:50)", 6923, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:50)", 6924, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:50)", 6925, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:52)", 6926, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:52)", 6927, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:52)", 6928, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:52)", 6929, "Boolean");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:52)", 6930, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:53)", 6931, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:53)", 6932, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:53)", 6933, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:56)", 6934, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:56)", 6935, "Numerical");
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.__L6936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/cache/ServiceResponseCache.java:56)", 6936, "Numerical");
    }

    static {
        org.broadleafcommerce.common.vendor.service.cache.ServiceResponseCache.initPerturbationLocation0();
    }
}

