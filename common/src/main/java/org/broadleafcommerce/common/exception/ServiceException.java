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


public class ServiceException extends java.lang.Exception {
    private static final long serialVersionUID = -7084792578727995587L;

    protected ServiceException() {
        super();
    }

    public ServiceException(java.lang.String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ServiceException(java.lang.String message) {
        super(message);
    }

    public ServiceException(java.lang.Throwable cause) {
        super(cause);
    }

    public boolean containsCause(java.lang.Class<? extends java.lang.Throwable> clazz) {
        java.lang.Throwable current = this;
        do {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ServiceException.__L1258, clazz.isAssignableFrom(current.getClass()))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ServiceException.__L1259, true);
            }
            current = current.getCause();
        } while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ServiceException.__L1257, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ServiceException.__L1255, (current != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ServiceException.__L1256, ((current.getCause()) != null))))) );
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.ServiceException.__L1260, false);
    }

    public static perturbation.location.PerturbationLocation __L1255;

    public static perturbation.location.PerturbationLocation __L1256;

    public static perturbation.location.PerturbationLocation __L1257;

    public static perturbation.location.PerturbationLocation __L1258;

    public static perturbation.location.PerturbationLocation __L1259;

    public static perturbation.location.PerturbationLocation __L1260;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.exception.ServiceException.__L1255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ServiceException.java:61)", 1255, "Boolean");
        org.broadleafcommerce.common.exception.ServiceException.__L1256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ServiceException.java:61)", 1256, "Boolean");
        org.broadleafcommerce.common.exception.ServiceException.__L1257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ServiceException.java:61)", 1257, "Boolean");
        org.broadleafcommerce.common.exception.ServiceException.__L1258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ServiceException.java:57)", 1258, "Boolean");
        org.broadleafcommerce.common.exception.ServiceException.__L1259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ServiceException.java:58)", 1259, "Boolean");
        org.broadleafcommerce.common.exception.ServiceException.__L1260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/ServiceException.java:63)", 1260, "Boolean");
    }

    static {
        org.broadleafcommerce.common.exception.ServiceException.initPerturbationLocation0();
    }
}

