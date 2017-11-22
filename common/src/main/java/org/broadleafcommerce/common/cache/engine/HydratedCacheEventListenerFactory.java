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
package org.broadleafcommerce.common.cache.engine;


public class HydratedCacheEventListenerFactory extends net.sf.ehcache.event.CacheEventListenerFactory {
    private static org.broadleafcommerce.common.cache.engine.HydratedCacheManager manager = null;

    @java.lang.Override
    public net.sf.ehcache.event.CacheEventListener createCacheEventListener(java.util.Properties props) {
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.__L152, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.__L150, (props == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.__L151, props.isEmpty()))))) {
                org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.manager = org.broadleafcommerce.common.cache.engine.EhcacheHydratedCacheManagerImpl.getInstance();
            }else {
                java.lang.String managerClass = props.getProperty("managerClass");
                java.lang.Class<?> clazz = java.lang.Class.forName(managerClass);
                java.lang.reflect.Method method = clazz.getDeclaredMethod("getInstance");
                org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.manager = ((org.broadleafcommerce.common.cache.engine.HydratedCacheManager) (method.invoke(null)));
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Unable to create a CacheEventListener instance", e);
        }
        return ((net.sf.ehcache.event.CacheEventListener) (org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.manager));
    }

    public static org.broadleafcommerce.common.cache.engine.HydratedCacheManager getConfiguredManager() {
        return org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.manager;
    }

    public static perturbation.location.PerturbationLocation __L150;

    public static perturbation.location.PerturbationLocation __L151;

    public static perturbation.location.PerturbationLocation __L152;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.__L150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheEventListenerFactory.java:38)", 150, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.__L151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheEventListenerFactory.java:38)", 151, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.__L152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydratedCacheEventListenerFactory.java:38)", 152, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.engine.HydratedCacheEventListenerFactory.initPerturbationLocation0();
    }
}

