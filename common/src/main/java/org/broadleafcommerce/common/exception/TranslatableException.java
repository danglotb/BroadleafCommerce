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


public abstract class TranslatableException extends java.lang.Exception {
    private static final long serialVersionUID = 1L;

    protected int code;

    protected java.lang.Object[] messageParams = null;

    public TranslatableException(int code, java.lang.String message) {
        this(code, message, null);
    }

    public TranslatableException(int code, java.lang.String message, java.lang.Object[] messageParams) {
        super(message);
        this.code = code;
        this.messageParams = messageParams;
    }

    public int getCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.exception.TranslatableException.__L1261, code);
    }

    public java.lang.String getMessageKey() {
        return ((getClass().getSimpleName()) + "_") + (code);
    }

    public java.lang.Object[] getMessageParameters() {
        return this.messageParams;
    }

    @java.lang.Override
    public java.lang.String getLocalizedMessage() {
        java.lang.String response = getMessage();
        try {
            java.lang.String exCode = getMessageKey();
            org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.TranslatableException.__L1264, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.TranslatableException.__L1262, (context != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.TranslatableException.__L1263, ((context.getMessageSource()) != null)))))) {
                response = context.getMessageSource().getMessage(exCode, this.messageParams, getMessage(), context.getJavaLocale());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.TranslatableException.__L1265, response.equals(exCode))) {
                    response = getMessage();
                }
            }
        } catch (org.springframework.context.NoSuchMessageException e) {
            response = getMessage();
        }
        return response;
    }

    @java.lang.Override
    public java.lang.String toString() {
        java.lang.String s = getClass().getName();
        java.lang.String message = getMessage();
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.exception.TranslatableException.__L1266, (message != null)) ? (s + ": ") + message : s;
    }

    public static perturbation.location.PerturbationLocation __L1261;

    public static perturbation.location.PerturbationLocation __L1262;

    public static perturbation.location.PerturbationLocation __L1263;

    public static perturbation.location.PerturbationLocation __L1264;

    public static perturbation.location.PerturbationLocation __L1265;

    public static perturbation.location.PerturbationLocation __L1266;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.exception.TranslatableException.__L1261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/TranslatableException.java:64)", 1261, "Numerical");
        org.broadleafcommerce.common.exception.TranslatableException.__L1262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/TranslatableException.java:102)", 1262, "Boolean");
        org.broadleafcommerce.common.exception.TranslatableException.__L1263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/TranslatableException.java:102)", 1263, "Boolean");
        org.broadleafcommerce.common.exception.TranslatableException.__L1264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/TranslatableException.java:102)", 1264, "Boolean");
        org.broadleafcommerce.common.exception.TranslatableException.__L1265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/TranslatableException.java:104)", 1265, "Boolean");
        org.broadleafcommerce.common.exception.TranslatableException.__L1266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/exception/TranslatableException.java:123)", 1266, "Boolean");
    }

    static {
        org.broadleafcommerce.common.exception.TranslatableException.initPerturbationLocation0();
    }
}

