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
package org.broadleafcommerce.common.classloader.release;


public class ThreadLocalManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.class);

    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.classloader.release.ThreadLocalManager> THREAD_LOCAL_MANAGER = new java.lang.ThreadLocal<org.broadleafcommerce.common.classloader.release.ThreadLocalManager>() {
        @java.lang.Override
        protected org.broadleafcommerce.common.classloader.release.ThreadLocalManager initialValue() {
            org.broadleafcommerce.common.classloader.release.ThreadLocalManager manager = new org.broadleafcommerce.common.classloader.release.ThreadLocalManager();
            java.lang.String checkOrphans = java.lang.System.getProperty("ThreadLocalManager.notify.orphans");
            if ("true".equals(checkOrphans)) {
                manager.marker = new java.lang.RuntimeException("Thread Local Manager is not empty - the following is the culprit call that setup the thread local but did not clear it.");
            }
            return manager;
        }
    };

    protected java.util.Map<java.lang.Long, java.lang.ThreadLocal> threadLocals = new java.util.LinkedHashMap<java.lang.Long, java.lang.ThreadLocal>();

    protected java.lang.RuntimeException marker = null;

    private static java.lang.Long count = ((long) (0L));

    private static final java.lang.Object threadLock = new java.lang.Object();

    public static void addThreadLocal(java.lang.ThreadLocal threadLocal) {
        java.lang.Long position;
        synchronized(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.threadLock) {
            (org.broadleafcommerce.common.classloader.release.ThreadLocalManager.count)++;
            position = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.count;
        }
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.THREAD_LOCAL_MANAGER.get().threadLocals.put(position, threadLocal);
    }

    public static <T> java.lang.ThreadLocal<T> createThreadLocal(final java.lang.Class<T> type) {
        return org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(type, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L294, true));
    }

    public static <T> java.lang.ThreadLocal<T> createThreadLocal(final java.lang.Class<T> type, final boolean createInitialValue) {
        java.lang.ThreadLocal<T> response = new java.lang.ThreadLocal<T>() {
            @java.lang.Override
            protected T initialValue() {
                org.broadleafcommerce.common.classloader.release.ThreadLocalManager.addThreadLocal(this);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L296, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L295, createInitialValue))))) {
                    return null;
                }
                try {
                    return type.newInstance();
                } catch (java.lang.InstantiationException e) {
                    throw new java.lang.RuntimeException(e);
                } catch (java.lang.IllegalAccessException e) {
                    throw new java.lang.RuntimeException(e);
                }
            }

            @java.lang.Override
            public void set(T value) {
                super.get();
                super.set(value);
            }
        };
        return response;
    }

    public static void remove() {
        for (java.util.Map.Entry<java.lang.Long, java.lang.ThreadLocal> entry : org.broadleafcommerce.common.classloader.release.ThreadLocalManager.THREAD_LOCAL_MANAGER.get().threadLocals.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L297, org.broadleafcommerce.common.classloader.release.ThreadLocalManager.LOG.isDebugEnabled())) {
                org.broadleafcommerce.common.classloader.release.ThreadLocalManager.LOG.debug((("Removing ThreadLocal #" + (entry.getKey())) + " from request thread."));
            }
            entry.getValue().remove();
        }
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.THREAD_LOCAL_MANAGER.get().threadLocals.clear();
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.THREAD_LOCAL_MANAGER.remove();
    }

    public static void remove(java.lang.ThreadLocal threadLocal) {
        java.lang.Long removePosition = null;
        for (java.util.Map.Entry<java.lang.Long, java.lang.ThreadLocal> entry : org.broadleafcommerce.common.classloader.release.ThreadLocalManager.THREAD_LOCAL_MANAGER.get().threadLocals.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L298, entry.getValue().equals(threadLocal))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L299, org.broadleafcommerce.common.classloader.release.ThreadLocalManager.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.classloader.release.ThreadLocalManager.LOG.debug((("Removing ThreadLocal #" + (entry.getKey())) + " from request thread."));
                }
                entry.getValue().remove();
                removePosition = entry.getKey();
            }
        }
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.THREAD_LOCAL_MANAGER.get().threadLocals.remove(removePosition);
    }

    @java.lang.Override
    public java.lang.String toString() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L303, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L301, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L300, threadLocals.isEmpty()))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L302, ((marker) != null)))))) {
            marker.printStackTrace();
        }
        return super.toString();
    }

    public static perturbation.location.PerturbationLocation __L294;

    public static perturbation.location.PerturbationLocation __L295;

    public static perturbation.location.PerturbationLocation __L296;

    public static perturbation.location.PerturbationLocation __L297;

    public static perturbation.location.PerturbationLocation __L298;

    public static perturbation.location.PerturbationLocation __L299;

    public static perturbation.location.PerturbationLocation __L300;

    public static perturbation.location.PerturbationLocation __L301;

    public static perturbation.location.PerturbationLocation __L302;

    public static perturbation.location.PerturbationLocation __L303;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:58)", 294, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:66)", 295, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:66)", 296, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:89)", 297, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:101)", 298, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:102)", 299, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:117)", 300, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:117)", 301, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:117)", 302, "Boolean");
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.__L303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/classloader/release/ThreadLocalManager.java:117)", 303, "Boolean");
    }

    static {
        org.broadleafcommerce.common.classloader.release.ThreadLocalManager.initPerturbationLocation0();
    }
}

