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
package org.broadleafcommerce.common.cache;


public abstract class AbstractCacheMissAware {
    @javax.annotation.Resource(name = "blStatisticsService")
    protected org.broadleafcommerce.common.cache.StatisticsService statisticsService;

    protected net.sf.ehcache.Cache cache;

    private java.lang.Object nullObject = null;

    protected java.lang.String buildKey(java.lang.String... params) {
        org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        org.broadleafcommerce.common.sandbox.domain.SandBox sandBox = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L196, (context != null))) {
            sandBox = context.getSandBox();
        }
        java.lang.String key = org.apache.commons.lang.StringUtils.join(params, '_');
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L197, (sandBox != null))) {
            key = ((sandBox.getId()) + "_") + key;
        }
        return key;
    }

    protected <T> T getObjectFromCache(java.lang.String key, java.lang.String cacheName) {
        net.sf.ehcache.Element cacheElement = getCache(cacheName).get(key);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L198, (cacheElement != null))) {
            return ((T) (cacheElement.getValue()));
        }
        return null;
    }

    protected net.sf.ehcache.Cache getCache(java.lang.String cacheName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L199, ((cache) == null))) {
            cache = net.sf.ehcache.CacheManager.getInstance().getCache(cacheName);
        }
        return cache;
    }

    protected void removeItemFromCache(java.lang.String cacheName, java.lang.String... params) {
        java.lang.String key = buildKey(params);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L200, getLogger().isTraceEnabled())) {
            getLogger().trace((((("Evicting [" + key) + "] from the [") + cacheName) + "] cache."));
        }
        getCache(cacheName).remove(key);
    }

    protected void clearCache(java.lang.String cacheName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L201, getLogger().isTraceEnabled())) {
            getLogger().trace((("Evicting all keys from the [" + cacheName) + "] cache."));
        }
        getCache(cacheName).removeAll();
    }

    protected synchronized <T> T getNullObject(final java.lang.Class<T> responseClass) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L202, ((nullObject) == null))) {
            java.lang.Class<?>[] interfaces = ((java.lang.Class<?>[]) (org.apache.commons.lang.ArrayUtils.add(org.springframework.util.ClassUtils.getAllInterfacesForClass(responseClass), java.io.Serializable.class)));
            nullObject = java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, new java.lang.reflect.InvocationHandler() {
                @java.lang.Override
                public java.lang.Object invoke(java.lang.Object o, java.lang.reflect.Method method, java.lang.Object[] objects) throws java.lang.Throwable {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L203, method.getName().equals("equals"))) {
                        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L211, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L206, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L205, ((objects[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L204, 0)]) == null)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L210, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L208, objects[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L207, 0)].hashCode())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L209, 31)))))));
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L212, method.getName().equals("hashCode"))) {
                            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L213, 31);
                        }else
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L214, method.getName().equals("toString"))) {
                                return "Null_" + (responseClass.getSimpleName());
                            }


                    throw new java.lang.IllegalAccessException("Not a real object");
                }
            });
        }
        return ((T) (nullObject));
    }

    protected <T> T getCachedObject(java.lang.Class<T> responseClass, java.lang.String cacheName, java.lang.String statisticsName, org.broadleafcommerce.common.cache.PersistentRetrieval<T> retrieval, java.lang.String... params) {
        T nullResponse = getNullObject(responseClass);
        org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        java.lang.String key = buildKey(params);
        T response = null;
        boolean allowL2Cache = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L215, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L216, (context != null))) {
            allowL2Cache = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L219, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L217, context.isProductionSandBox())) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L218, ((context.getAdditionalProperties().containsKey("allowLevel2Cache")) && ((java.lang.Boolean) (context.getAdditionalProperties().get("allowLevel2Cache"))))))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L220, allowL2Cache)) {
            response = getObjectFromCache(key, cacheName);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L221, (response == null))) {
            response = retrieval.retrievePersistentObject();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L222, (response == null))) {
                response = nullResponse;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L225, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L223, allowL2Cache)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L224, response.equals(nullResponse)))))) {
                statisticsService.addCacheStat(statisticsName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L226, false));
                getCache(cacheName).put(new net.sf.ehcache.Element(key, response));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L227, getLogger().isTraceEnabled())) {
                    getLogger().trace((((("Caching [" + key) + "] as null in the [") + cacheName) + "] cache."));
                }
            }
        }else {
            statisticsService.addCacheStat(statisticsName, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L228, true));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L229, response.equals(nullResponse))) {
            return null;
        }
        return response;
    }

    protected abstract org.apache.commons.logging.Log getLogger();

    public static perturbation.location.PerturbationLocation __L196;

    public static perturbation.location.PerturbationLocation __L197;

    public static perturbation.location.PerturbationLocation __L198;

    public static perturbation.location.PerturbationLocation __L199;

    public static perturbation.location.PerturbationLocation __L200;

    public static perturbation.location.PerturbationLocation __L201;

    public static perturbation.location.PerturbationLocation __L202;

    public static perturbation.location.PerturbationLocation __L203;

    public static perturbation.location.PerturbationLocation __L204;

    public static perturbation.location.PerturbationLocation __L205;

    public static perturbation.location.PerturbationLocation __L206;

    public static perturbation.location.PerturbationLocation __L207;

    public static perturbation.location.PerturbationLocation __L208;

    public static perturbation.location.PerturbationLocation __L209;

    public static perturbation.location.PerturbationLocation __L210;

    public static perturbation.location.PerturbationLocation __L211;

    public static perturbation.location.PerturbationLocation __L212;

    public static perturbation.location.PerturbationLocation __L213;

    public static perturbation.location.PerturbationLocation __L214;

    public static perturbation.location.PerturbationLocation __L215;

    public static perturbation.location.PerturbationLocation __L216;

    public static perturbation.location.PerturbationLocation __L217;

    public static perturbation.location.PerturbationLocation __L218;

    public static perturbation.location.PerturbationLocation __L219;

    public static perturbation.location.PerturbationLocation __L220;

    public static perturbation.location.PerturbationLocation __L221;

    public static perturbation.location.PerturbationLocation __L222;

    public static perturbation.location.PerturbationLocation __L223;

    public static perturbation.location.PerturbationLocation __L224;

    public static perturbation.location.PerturbationLocation __L225;

    public static perturbation.location.PerturbationLocation __L226;

    public static perturbation.location.PerturbationLocation __L227;

    public static perturbation.location.PerturbationLocation __L228;

    public static perturbation.location.PerturbationLocation __L229;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:66)", 196, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:70)", 197, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:86)", 198, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:100)", 199, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:114)", 200, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:126)", 201, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:142)", 202, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:147)", 203, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 204, "Numerical");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 205, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 206, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 207, "Numerical");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 208, "Numerical");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 209, "Numerical");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 210, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:148)", 211, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:149)", 212, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:150)", 213, "Numerical");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:151)", 214, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:178)", 215, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:179)", 216, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:180)", 217, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:181)", 218, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:180)", 219, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:184)", 220, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:187)", 221, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:189)", 222, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:193)", 223, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:193)", 224, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:193)", 225, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:194)", 226, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:196)", 227, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:201)", 228, "Boolean");
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.__L229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/AbstractCacheMissAware.java:203)", 229, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.AbstractCacheMissAware.initPerturbationLocation0();
    }
}

