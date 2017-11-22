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


public abstract class BroadleafException extends java.lang.Exception implements org.broadleafcommerce.common.exception.RootCauseAccessor {
    private java.lang.Throwable rootCause;

    public BroadleafException() {
        super();
    }

    public BroadleafException(java.lang.String message, java.lang.Throwable cause) {
        super(message, cause);
        if (cause != null) {
            rootCause = findRootCause(cause);
        }else {
            rootCause = this;
        }
    }

    private java.lang.Throwable findRootCause(java.lang.Throwable cause) {
        java.lang.Throwable rootCause = cause;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafException.__L1237, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafException.__L1235, (rootCause != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafException.__L1236, ((rootCause.getCause()) != null)))))) {
            rootCause = rootCause.getCause();
        } 
        return rootCause;
    }

    public BroadleafException(java.lang.String message) {
        super(message);
        this.rootCause = this;
    }

    public BroadleafException(java.lang.Throwable cause) {
        super(cause);
        if (cause != null) {
            rootCause = findRootCause(cause);
        }
    }

    public java.lang.Throwable getRootCause() {
        return rootCause;
    }

    public java.lang.String getRootCauseMessage() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.BroadleafException.__L1238, ((rootCause) != null))) {
            return rootCause.getMessage();
        }else {
            return getMessage();
        }
    }

    public static perturbation.location.PerturbationLocation __L1235;

    public static perturbation.location.PerturbationLocation __L1236;

    public static perturbation.location.PerturbationLocation __L1237;

    public static perturbation.location.PerturbationLocation __L1238;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.exception.BroadleafException.__L1235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafException.java:44)", 1235, "Boolean");
        org.broadleafcommerce.common.exception.BroadleafException.__L1236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafException.java:44)", 1236, "Boolean");
        org.broadleafcommerce.common.exception.BroadleafException.__L1237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafException.java:44)", 1237, "Boolean");
        org.broadleafcommerce.common.exception.BroadleafException.__L1238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/BroadleafException.java:68)", 1238, "Boolean");
    }

    static {
        org.broadleafcommerce.common.exception.BroadleafException.initPerturbationLocation0();
    }
}

