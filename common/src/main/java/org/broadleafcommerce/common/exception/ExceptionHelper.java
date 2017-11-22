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
package org.broadleafcommerce.common.exception;


public class ExceptionHelper {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.exception.ExceptionHelper.class);

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> java.lang.RuntimeException refineException(java.lang.Class<G> refineType, java.lang.Class<J> wrapType, java.lang.String message, java.lang.Throwable e) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1245, refineType.isAssignableFrom(e.getClass()))) {
            return org.broadleafcommerce.common.exception.ExceptionHelper.wrapException(e, wrapType, message);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1246, ((e.getCause()) != null))) {
            return org.broadleafcommerce.common.exception.ExceptionHelper.refineException(refineType, wrapType, message, e.getCause());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1247, (e instanceof java.lang.reflect.UndeclaredThrowableException))) {
            return org.broadleafcommerce.common.exception.ExceptionHelper.refineException(refineType, wrapType, message, ((java.lang.reflect.UndeclaredThrowableException) (e)).getUndeclaredThrowable());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1248, (e instanceof java.lang.reflect.InvocationTargetException))) {
            return org.broadleafcommerce.common.exception.ExceptionHelper.refineException(refineType, wrapType, message, ((java.lang.reflect.InvocationTargetException) (e)).getTargetException());
        }
        return org.broadleafcommerce.common.exception.ExceptionHelper.wrapException(e, wrapType, message);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> java.lang.RuntimeException refineException(java.lang.Class<G> refineType, java.lang.Class<J> wrapType, java.lang.Throwable e) {
        return org.broadleafcommerce.common.exception.ExceptionHelper.refineException(refineType, wrapType, null, e);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> java.lang.RuntimeException refineException(java.lang.Class<J> wrapType, java.lang.Throwable e) {
        return org.broadleafcommerce.common.exception.ExceptionHelper.refineException(java.lang.RuntimeException.class, wrapType, null, e);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> java.lang.RuntimeException refineException(java.lang.Throwable e) {
        return org.broadleafcommerce.common.exception.ExceptionHelper.refineException(java.lang.RuntimeException.class, java.lang.RuntimeException.class, null, e);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> void processException(java.lang.Class<G> refineType, java.lang.Class<J> wrapType, java.lang.String message, java.lang.Throwable e) throws G {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1249, refineType.isAssignableFrom(e.getClass()))) {
            throw ((G) (e));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1250, ((e.getCause()) != null))) {
            org.broadleafcommerce.common.exception.ExceptionHelper.processException(refineType, wrapType, message, e.getCause());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1251, (e instanceof java.lang.reflect.UndeclaredThrowableException))) {
            org.broadleafcommerce.common.exception.ExceptionHelper.processException(refineType, wrapType, message, ((java.lang.reflect.UndeclaredThrowableException) (e)).getUndeclaredThrowable());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1252, (e instanceof java.lang.reflect.InvocationTargetException))) {
            org.broadleafcommerce.common.exception.ExceptionHelper.processException(refineType, wrapType, message, ((java.lang.reflect.InvocationTargetException) (e)).getTargetException());
        }
        throw org.broadleafcommerce.common.exception.ExceptionHelper.wrapException(e, wrapType, message);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> void processException(java.lang.Class<G> refineType, java.lang.Class<J> wrapType, java.lang.Throwable e) throws G {
        org.broadleafcommerce.common.exception.ExceptionHelper.processException(refineType, wrapType, null, e);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> void processException(java.lang.Class<J> wrapType, java.lang.Throwable e) throws G {
        org.broadleafcommerce.common.exception.ExceptionHelper.processException(java.lang.RuntimeException.class, wrapType, null, e);
    }

    public static <G extends java.lang.Throwable, J extends java.lang.RuntimeException> void processException(java.lang.Throwable e) throws G {
        org.broadleafcommerce.common.exception.ExceptionHelper.processException(java.lang.RuntimeException.class, java.lang.RuntimeException.class, null, e);
    }

    private static <J extends java.lang.RuntimeException> java.lang.RuntimeException wrapException(java.lang.Throwable e, java.lang.Class<J> wrapType, java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1253, (e instanceof java.lang.RuntimeException))) {
            return ((java.lang.RuntimeException) (e));
        }
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ExceptionHelper.__L1254, org.apache.commons.lang3.StringUtils.isEmpty(message))) {
                return wrapType.getConstructor(java.lang.Throwable.class).newInstance(e);
            }else {
                return wrapType.getConstructor(java.lang.String.class, java.lang.Throwable.class).newInstance(message, e);
            }
        } catch (java.lang.Exception e1) {
            org.broadleafcommerce.common.exception.ExceptionHelper.LOG.error("Could not wrap exception", e1);
            throw new java.lang.RuntimeException(e);
        }
    }

    public static perturbation.location.PerturbationLocation __L1245;

    public static perturbation.location.PerturbationLocation __L1246;

    public static perturbation.location.PerturbationLocation __L1247;

    public static perturbation.location.PerturbationLocation __L1248;

    public static perturbation.location.PerturbationLocation __L1249;

    public static perturbation.location.PerturbationLocation __L1250;

    public static perturbation.location.PerturbationLocation __L1251;

    public static perturbation.location.PerturbationLocation __L1252;

    public static perturbation.location.PerturbationLocation __L1253;

    public static perturbation.location.PerturbationLocation __L1254;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:35)", 1245, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:38)", 1246, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:41)", 1247, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:44)", 1248, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:63)", 1249, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:66)", 1250, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:69)", 1251, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:72)", 1252, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:91)", 1253, "Boolean");
        org.broadleafcommerce.common.exception.ExceptionHelper.__L1254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ExceptionHelper.java:95)", 1254, "Boolean");
    }

    static {
        org.broadleafcommerce.common.exception.ExceptionHelper.initPerturbationLocation0();
    }
}

