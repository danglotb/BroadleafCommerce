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


public class CacheStat {
    protected java.util.concurrent.atomic.AtomicLong requestCount = new java.util.concurrent.atomic.AtomicLong(0L);

    protected java.util.concurrent.atomic.AtomicLong cacheHitCount = new java.util.concurrent.atomic.AtomicLong(0L);

    protected java.lang.Long lastLogTime = ((long) (org.broadleafcommerce.common.time.SystemTime.asMillis(true)));

    public java.lang.Long getCacheHitCount() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.cache.CacheStat.__L230, cacheHitCount.longValue());
    }

    public java.lang.Long getLastLogTime() {
        return lastLogTime;
    }

    public synchronized void setLastLogTime(java.lang.Long lastLogTime) {
        this.lastLogTime = lastLogTime;
    }

    public java.lang.Long getRequestCount() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.cache.CacheStat.__L231, requestCount.longValue());
    }

    public void incrementRequest() {
        requestCount.incrementAndGet();
    }

    public void incrementHit() {
        cacheHitCount.incrementAndGet();
    }

    public java.math.BigDecimal getHitRate() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.CacheStat.__L232, ((getRequestCount()) == 0))) {
            return new java.math.BigDecimal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L234, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L233, 1)))));
        }
        java.math.BigDecimal percentage = new java.math.BigDecimal(getCacheHitCount()).divide(new java.math.BigDecimal(getRequestCount()), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L235, 2), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L236, java.math.BigDecimal.ROUND_HALF_UP));
        percentage = percentage.multiply(new java.math.BigDecimal(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L237, 100))).setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L238, 2), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.CacheStat.__L239, java.math.BigDecimal.ROUND_HALF_UP));
        return percentage;
    }

    public static perturbation.location.PerturbationLocation __L230;

    public static perturbation.location.PerturbationLocation __L231;

    public static perturbation.location.PerturbationLocation __L232;

    public static perturbation.location.PerturbationLocation __L233;

    public static perturbation.location.PerturbationLocation __L234;

    public static perturbation.location.PerturbationLocation __L235;

    public static perturbation.location.PerturbationLocation __L236;

    public static perturbation.location.PerturbationLocation __L237;

    public static perturbation.location.PerturbationLocation __L238;

    public static perturbation.location.PerturbationLocation __L239;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.CacheStat.__L230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:35)", 230, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:47)", 231, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:59)", 232, "Boolean");
        org.broadleafcommerce.common.cache.CacheStat.__L233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:60)", 233, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:60)", 234, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:63)", 235, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:63)", 236, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:64)", 237, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:64)", 238, "Numerical");
        org.broadleafcommerce.common.cache.CacheStat.__L239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/CacheStat.java:64)", 239, "Numerical");
    }

    static {
        org.broadleafcommerce.common.cache.CacheStat.initPerturbationLocation0();
    }
}

