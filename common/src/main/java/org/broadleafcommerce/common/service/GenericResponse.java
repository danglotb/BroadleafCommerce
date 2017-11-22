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
package org.broadleafcommerce.common.service;


public class GenericResponse {
    private java.util.List<java.lang.String> errorCodes = new java.util.ArrayList<java.lang.String>();

    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> errorCodeMap = new java.util.HashMap<java.lang.String, java.util.List<java.lang.String>>();

    public boolean getHasErrors() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.GenericResponse.__L5175, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.GenericResponse.__L5173, errorCodes.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.GenericResponse.__L5174, 0))));
    }

    public java.util.List<java.lang.String> getErrorCodesList() {
        return errorCodes;
    }

    public void addErrorCode(java.lang.String errorCode) {
        errorCodes.add(errorCode);
        errorCodeMap.put(errorCode, new java.util.ArrayList<java.lang.String>());
    }

    public void addErrorCode(java.lang.String errorCode, java.util.List<java.lang.String> arguments) {
        errorCodes.add(errorCode);
        errorCodeMap.put(errorCode, arguments);
    }

    public java.lang.Object[] getErrorCodeArguments(java.lang.String errorCode) {
        java.util.List<java.lang.String> errorCodes = errorCodeMap.get(errorCode);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.service.GenericResponse.__L5176, (errorCodes == null))) {
            return new java.lang.Object[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.GenericResponse.__L5177, 0)];
        }else {
            return errorCodes.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.service.GenericResponse.__L5178, 0)]);
        }
    }

    public static perturbation.location.PerturbationLocation __L5173;

    public static perturbation.location.PerturbationLocation __L5174;

    public static perturbation.location.PerturbationLocation __L5175;

    public static perturbation.location.PerturbationLocation __L5176;

    public static perturbation.location.PerturbationLocation __L5177;

    public static perturbation.location.PerturbationLocation __L5178;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.service.GenericResponse.__L5173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericResponse.java:35)", 5173, "Numerical");
        org.broadleafcommerce.common.service.GenericResponse.__L5174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericResponse.java:35)", 5174, "Numerical");
        org.broadleafcommerce.common.service.GenericResponse.__L5175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericResponse.java:35)", 5175, "Boolean");
        org.broadleafcommerce.common.service.GenericResponse.__L5176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericResponse.java:54)", 5176, "Boolean");
        org.broadleafcommerce.common.service.GenericResponse.__L5177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericResponse.java:55)", 5177, "Numerical");
        org.broadleafcommerce.common.service.GenericResponse.__L5178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/service/GenericResponse.java:57)", 5178, "Numerical");
    }

    static {
        org.broadleafcommerce.common.service.GenericResponse.initPerturbationLocation0();
    }
}

