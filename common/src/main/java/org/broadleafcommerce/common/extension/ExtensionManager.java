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
package org.broadleafcommerce.common.extension;


public abstract class ExtensionManager<T extends org.broadleafcommerce.common.extension.ExtensionHandler> implements java.lang.reflect.InvocationHandler {
    protected boolean handlersSorted = false;

    protected static java.lang.String LOCK_OBJECT = new java.lang.String("EM_LOCK");

    protected T extensionHandler;

    protected java.util.List<T> handlers = new java.util.ArrayList<T>();

    @java.lang.SuppressWarnings("unchecked")
    public ExtensionManager(java.lang.Class<T> _clazz) {
        extensionHandler = ((T) (java.lang.reflect.Proxy.newProxyInstance(_clazz.getClassLoader(), new java.lang.Class[]{ _clazz }, this)));
    }

    public T getProxy() {
        return extensionHandler;
    }

    public java.util.List<T> getHandlers() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2458, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2457, handlersSorted))))) {
            synchronized(org.broadleafcommerce.common.extension.ExtensionManager.LOCK_OBJECT) {
                sortHandlers();
            }
        }
        return handlers;
    }

    @java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
    protected void sortHandlers() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2460, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2459, handlersSorted))))) {
            java.util.Comparator fieldCompare = new org.apache.commons.beanutils.BeanComparator("priority");
            java.util.Collections.sort(handlers, fieldCompare);
            handlersSorted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2461, true);
        }
    }

    public boolean registerHandler(T handler) {
        synchronized(org.broadleafcommerce.common.extension.ExtensionManager.LOCK_OBJECT) {
            boolean add = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2462, true);
            for (T item : this.handlers) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2463, item.getClass().equals(handler.getClass()))) {
                    add = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2464, false);
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2465, add)) {
                this.handlers.add(handler);
                handlersSorted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2466, false);
            }
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2467, add);
        }
    }

    public void setHandlers(java.util.List<T> handlers) {
        this.handlers = handlers;
    }

    public boolean shouldContinue(org.broadleafcommerce.common.extension.ExtensionResultStatusType result, org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.reflect.Method method, java.lang.Object[] args) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2468, (result != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2469, org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_STOP.equals(result))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2470, false);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2474, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2471, org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED.equals(result))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2473, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2472, continueOnHandled())))))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2475, false);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2476, true);
    }

    public boolean continueOnHandled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2477, false);
    }

    public int getPriority() {
        throw new java.lang.UnsupportedOperationException();
    }

    @java.lang.Override
    public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
        boolean notHandled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2478, true);
        for (org.broadleafcommerce.common.extension.ExtensionHandler handler : getHandlers()) {
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2479, handler.isEnabled())) {
                    org.broadleafcommerce.common.extension.ExtensionResultStatusType result = ((org.broadleafcommerce.common.extension.ExtensionResultStatusType) (method.invoke(handler, args)));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2481, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2480, org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED.equals(result)))))) {
                        notHandled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2482, false);
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2484, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2483, shouldContinue(result, handler, method, args)))))) {
                        break;
                    }
                }
            } catch (java.lang.reflect.InvocationTargetException e) {
                throw e.getCause();
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2485, notHandled)) {
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
        }else {
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED;
        }
    }

    protected org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionManagerOperation operation, java.lang.Object... params) {
        boolean notHandled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2486, true);
        for (org.broadleafcommerce.common.extension.ExtensionHandler handler : getHandlers()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2487, handler.isEnabled())) {
                org.broadleafcommerce.common.extension.ExtensionResultStatusType result = operation.execute(handler, params);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2489, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2488, org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED.equals(result)))))) {
                    notHandled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2490, false);
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2492, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2491, shouldContinue(result, handler, null, null)))))) {
                    break;
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extension.ExtensionManager.__L2493, notHandled)) {
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
        }else {
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED;
        }
    }

    public static perturbation.location.PerturbationLocation __L2457;

    public static perturbation.location.PerturbationLocation __L2458;

    public static perturbation.location.PerturbationLocation __L2459;

    public static perturbation.location.PerturbationLocation __L2460;

    public static perturbation.location.PerturbationLocation __L2461;

    public static perturbation.location.PerturbationLocation __L2462;

    public static perturbation.location.PerturbationLocation __L2463;

    public static perturbation.location.PerturbationLocation __L2464;

    public static perturbation.location.PerturbationLocation __L2465;

    public static perturbation.location.PerturbationLocation __L2466;

    public static perturbation.location.PerturbationLocation __L2467;

    public static perturbation.location.PerturbationLocation __L2468;

    public static perturbation.location.PerturbationLocation __L2469;

    public static perturbation.location.PerturbationLocation __L2470;

    public static perturbation.location.PerturbationLocation __L2471;

    public static perturbation.location.PerturbationLocation __L2472;

    public static perturbation.location.PerturbationLocation __L2473;

    public static perturbation.location.PerturbationLocation __L2474;

    public static perturbation.location.PerturbationLocation __L2475;

    public static perturbation.location.PerturbationLocation __L2476;

    public static perturbation.location.PerturbationLocation __L2477;

    public static perturbation.location.PerturbationLocation __L2478;

    public static perturbation.location.PerturbationLocation __L2479;

    public static perturbation.location.PerturbationLocation __L2480;

    public static perturbation.location.PerturbationLocation __L2481;

    public static perturbation.location.PerturbationLocation __L2482;

    public static perturbation.location.PerturbationLocation __L2483;

    public static perturbation.location.PerturbationLocation __L2484;

    public static perturbation.location.PerturbationLocation __L2485;

    public static perturbation.location.PerturbationLocation __L2486;

    public static perturbation.location.PerturbationLocation __L2487;

    public static perturbation.location.PerturbationLocation __L2488;

    public static perturbation.location.PerturbationLocation __L2489;

    public static perturbation.location.PerturbationLocation __L2490;

    public static perturbation.location.PerturbationLocation __L2491;

    public static perturbation.location.PerturbationLocation __L2492;

    public static perturbation.location.PerturbationLocation __L2493;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extension.ExtensionManager.__L2457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:77)", 2457, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:77)", 2458, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:87)", 2459, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:87)", 2460, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:90)", 2461, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:107)", 2462, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:109)", 2463, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:110)", 2464, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:113)", 2465, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:115)", 2466, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:118)", 2467, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:136)", 2468, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:137)", 2469, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:138)", 2470, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:141)", 2471, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:141)", 2472, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:141)", 2473, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:141)", 2474, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:142)", 2475, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:145)", 2476, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:154)", 2477, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:169)", 2478, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:172)", 2479, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:174)", 2480, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:174)", 2481, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:175)", 2482, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:177)", 2483, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:177)", 2484, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:185)", 2485, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:202)", 2486, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:204)", 2487, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:206)", 2488, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:206)", 2489, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:207)", 2490, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:209)", 2491, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:209)", 2492, "Boolean");
        org.broadleafcommerce.common.extension.ExtensionManager.__L2493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extension/ExtensionManager.java:214)", 2493, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extension.ExtensionManager.initPerturbationLocation0();
    }
}

