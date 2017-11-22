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


@org.springframework.stereotype.Service("blStatisticsService")
public class StatisticsServiceImpl implements javax.management.DynamicMBean , org.broadleafcommerce.common.cache.StatisticsService , org.springframework.jmx.export.naming.SelfNaming {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.cache.StatisticsServiceImpl.class);

    @org.springframework.beans.factory.annotation.Value("${cache.stat.log.resolution}")
    protected java.lang.Long logResolution = ((long) (30000L));

    protected java.lang.String appName = "broadleaf";

    protected org.broadleafcommerce.common.cache.StatisticsServiceLogAdapter adapter;

    protected java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.CacheStat> cacheStats = java.util.Collections.synchronizedMap(new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.cache.CacheStat>());

    @java.lang.Override
    public void addCacheStat(java.lang.String key, boolean isHit) {
        org.broadleafcommerce.common.cache.CacheStat myStat = getCacheStat(key);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L265, isHit)) {
            myStat.incrementHit();
        }
        myStat.incrementRequest();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L268, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L266, ((myStat.getLastLogTime()) + (logResolution)))) < (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L267, org.broadleafcommerce.common.time.SystemTime.asMillis()))))) {
            myStat.setLastLogTime(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L269, org.broadleafcommerce.common.time.SystemTime.asMillis()));
            java.math.BigDecimal percentage = myStat.getHitRate();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L270, org.broadleafcommerce.common.cache.StatisticsServiceImpl.LOG.isInfoEnabled())) {
                org.broadleafcommerce.common.cache.StatisticsServiceImpl.LOG.info((((("Cache hit percentage for " + key) + " is: ") + (percentage.toString())) + "%"));
            }
        }
    }

    protected org.broadleafcommerce.common.cache.CacheStat getCacheStat(java.lang.String key) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L272, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L271, cacheStats.containsKey(key)))))) {
            org.broadleafcommerce.common.cache.CacheStat stat = new org.broadleafcommerce.common.cache.CacheStat();
            cacheStats.put(key, stat);
        }
        return cacheStats.get(key);
    }

    @java.lang.Override
    public java.lang.Long getLogResolution() {
        return logResolution;
    }

    @java.lang.Override
    public void setLogResolution(java.lang.Long logResolution) {
        this.logResolution = logResolution;
    }

    @java.lang.Override
    public void activateLogging() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L273, ((getAdapter()) != null))) {
            getAdapter().activateLogging(org.broadleafcommerce.common.cache.StatisticsServiceImpl.class);
        }
    }

    @java.lang.Override
    public void disableLogging() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L274, ((getAdapter()) != null))) {
            getAdapter().disableLogging(org.broadleafcommerce.common.cache.StatisticsServiceImpl.class);
        }
    }

    public java.lang.String getAppName() {
        return appName;
    }

    public void setAppName(java.lang.String appName) {
        this.appName = appName;
    }

    @java.lang.Override
    public java.lang.Object getAttribute(java.lang.String attribute) throws javax.management.AttributeNotFoundException, javax.management.MBeanException, javax.management.ReflectionException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L275, attribute.equals("LOG_RESOLUTION"))) {
            return getLogResolution();
        }
        return getCacheStat(attribute).getHitRate().doubleValue();
    }

    @java.lang.Override
    public void setAttribute(javax.management.Attribute attribute) throws javax.management.AttributeNotFoundException, javax.management.InvalidAttributeValueException, javax.management.MBeanException, javax.management.ReflectionException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L276, attribute.getName().equals("LOG_RESOLUTION"))) {
            setLogResolution(((java.lang.Long) (attribute.getValue())));
        }
    }

    @java.lang.Override
    public javax.management.AttributeList getAttributes(java.lang.String[] attributes) {
        javax.management.AttributeList list = new javax.management.AttributeList();
        for (java.util.Map.Entry<java.lang.String, org.broadleafcommerce.common.cache.CacheStat> stats : cacheStats.entrySet()) {
            list.add(new javax.management.Attribute(stats.getKey(), stats.getValue().getHitRate().doubleValue()));
        }
        return list;
    }

    @java.lang.Override
    public javax.management.AttributeList setAttributes(javax.management.AttributeList attributes) {
        for (java.lang.Object attr : attributes) {
            try {
                setAttribute(((javax.management.Attribute) (attr)));
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.cache.StatisticsServiceImpl.LOG.error(("cannot set attribute: " + (((javax.management.Attribute) (attr)).getName())), e);
            }
        }
        return attributes;
    }

    @java.lang.Override
    public java.lang.Object invoke(java.lang.String actionName, java.lang.Object[] params, java.lang.String[] signature) throws javax.management.MBeanException, javax.management.ReflectionException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L277, actionName.equals("activate"))) {
            activateLogging();
            return null;
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L278, actionName.equals("disable"))) {
                disableLogging();
                return null;
            }

        throw new javax.management.MBeanException(new java.lang.RuntimeException("Not Supported"));
    }

    @java.lang.Override
    public javax.management.ObjectName getObjectName() throws javax.management.MalformedObjectNameException {
        return org.springframework.jmx.support.ObjectNameManager.getInstance(("org.broadleafcommerce:name=StatisticsService." + (appName)));
    }

    @java.lang.Override
    public javax.management.MBeanInfo getMBeanInfo() {
        java.util.SortedSet<java.lang.String> names = new java.util.TreeSet<java.lang.String>();
        for (java.util.Map.Entry<java.lang.String, org.broadleafcommerce.common.cache.CacheStat> stats : cacheStats.entrySet()) {
            names.add(stats.getKey());
        }
        javax.management.MBeanAttributeInfo[] attrs = new javax.management.MBeanAttributeInfo[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L279, names.size())];
        java.util.Iterator<java.lang.String> it = names.iterator();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L280, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L283, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L281, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L282, attrs.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L284, (i++))) {
            java.lang.String name = it.next();
            attrs[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L285, i)] = new javax.management.MBeanAttributeInfo(name, "java.lang.Double", name, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L286, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L287, false), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L288, false));
        }
        attrs = org.apache.commons.lang3.ArrayUtils.add(attrs, new javax.management.MBeanAttributeInfo("LOG_RESOLUTION", "java.lang.Double", "LOG_RESOLUTION", perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L289, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L290, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L291, false)));
        javax.management.MBeanOperationInfo[] opers = new javax.management.MBeanOperationInfo[]{ new javax.management.MBeanOperationInfo("activate", "Activate statistic logging", null, "void", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L292, javax.management.MBeanOperationInfo.ACTION)), new javax.management.MBeanOperationInfo("disable", "Disable statistic logging", null, "void", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L293, javax.management.MBeanOperationInfo.ACTION)) };
        return new javax.management.MBeanInfo(("org.broadleafcommerce:name=StatisticsService." + (appName)), "Runtime Statistics", attrs, null, opers, null);
    }

    public org.broadleafcommerce.common.cache.StatisticsServiceLogAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(org.broadleafcommerce.common.cache.StatisticsServiceLogAdapter adapter) {
        this.adapter = adapter;
    }

    public static perturbation.location.PerturbationLocation __L265;

    public static perturbation.location.PerturbationLocation __L266;

    public static perturbation.location.PerturbationLocation __L267;

    public static perturbation.location.PerturbationLocation __L268;

    public static perturbation.location.PerturbationLocation __L269;

    public static perturbation.location.PerturbationLocation __L270;

    public static perturbation.location.PerturbationLocation __L271;

    public static perturbation.location.PerturbationLocation __L272;

    public static perturbation.location.PerturbationLocation __L273;

    public static perturbation.location.PerturbationLocation __L274;

    public static perturbation.location.PerturbationLocation __L275;

    public static perturbation.location.PerturbationLocation __L276;

    public static perturbation.location.PerturbationLocation __L277;

    public static perturbation.location.PerturbationLocation __L278;

    public static perturbation.location.PerturbationLocation __L279;

    public static perturbation.location.PerturbationLocation __L280;

    public static perturbation.location.PerturbationLocation __L281;

    public static perturbation.location.PerturbationLocation __L282;

    public static perturbation.location.PerturbationLocation __L283;

    public static perturbation.location.PerturbationLocation __L284;

    public static perturbation.location.PerturbationLocation __L285;

    public static perturbation.location.PerturbationLocation __L286;

    public static perturbation.location.PerturbationLocation __L287;

    public static perturbation.location.PerturbationLocation __L288;

    public static perturbation.location.PerturbationLocation __L289;

    public static perturbation.location.PerturbationLocation __L290;

    public static perturbation.location.PerturbationLocation __L291;

    public static perturbation.location.PerturbationLocation __L292;

    public static perturbation.location.PerturbationLocation __L293;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:68)", 265, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:72)", 266, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:72)", 267, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:72)", 268, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:73)", 269, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:75)", 270, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:82)", 271, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:82)", 272, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:101)", 273, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:108)", 274, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:123)", 275, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:131)", 276, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:161)", 277, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:164)", 278, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:182)", 279, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:184)", 280, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:184)", 281, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:184)", 282, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:184)", 283, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:184)", 284, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:186)", 285, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:190)", 286, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:191)", 287, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:192)", 288, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:198)", 289, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:199)", 290, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:200)", 291, "Boolean");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:208)", 292, "Numerical");
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.__L293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/StatisticsServiceImpl.java:214)", 293, "Numerical");
    }

    static {
        org.broadleafcommerce.common.cache.StatisticsServiceImpl.initPerturbationLocation0();
    }
}

