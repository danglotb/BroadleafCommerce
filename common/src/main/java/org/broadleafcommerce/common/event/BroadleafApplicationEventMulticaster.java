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
package org.broadleafcommerce.common.event;


public class BroadleafApplicationEventMulticaster extends org.springframework.context.event.SimpleApplicationEventMulticaster implements org.springframework.context.ApplicationContextAware {
    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier("blApplicationEventMulticastTaskExecutor")
    private java.util.concurrent.Executor taskExecutor;

    protected org.springframework.context.ApplicationContext ctx;

    @java.lang.Override
    public void multicastEvent(final org.springframework.context.ApplicationEvent event) {
        java.util.concurrent.Executor executor = getTaskExecutor();
        for (final org.springframework.context.ApplicationListener<?> listener : getApplicationListeners(event, org.springframework.core.ResolvableType.forInstance(event))) {
            boolean isAsynchronous = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1228, false);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1229, (executor != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1232, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1230, org.broadleafcommerce.common.event.BroadleafApplicationListener.class.isAssignableFrom(listener.getClass()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1231, ((org.broadleafcommerce.common.event.BroadleafApplicationListener<? extends org.springframework.context.ApplicationEvent>) (listener)).isAsynchronous()))))) {
                    isAsynchronous = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1233, true);
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1234, isAsynchronous)) {
                executor.execute(new java.lang.Runnable() {
                    public void run() {
                        invokeListener(listener, event);
                    }
                });
            }else {
                invokeListener(listener, event);
            }
        }
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        this.ctx = applicationContext;
    }

    public java.util.concurrent.Executor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(java.util.concurrent.Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public static perturbation.location.PerturbationLocation __L1228;

    public static perturbation.location.PerturbationLocation __L1229;

    public static perturbation.location.PerturbationLocation __L1230;

    public static perturbation.location.PerturbationLocation __L1231;

    public static perturbation.location.PerturbationLocation __L1232;

    public static perturbation.location.PerturbationLocation __L1233;

    public static perturbation.location.PerturbationLocation __L1234;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:67)", 1228, "Boolean");
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:68)", 1229, "Boolean");
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:69)", 1230, "Boolean");
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:70)", 1231, "Boolean");
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:69)", 1232, "Boolean");
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:71)", 1233, "Boolean");
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.__L1234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/event/BroadleafApplicationEventMulticaster.java:75)", 1234, "Boolean");
    }

    static {
        org.broadleafcommerce.common.event.BroadleafApplicationEventMulticaster.initPerturbationLocation0();
    }
}

