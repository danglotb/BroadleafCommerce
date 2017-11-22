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
package org.broadleafcommerce.common.util;


public class ValidationUtil {
    public static java.lang.String buildErrorMessage(java.util.Map<java.lang.String, java.util.List<java.lang.String>> propertyErrors, java.util.List<java.lang.String> globalErrors) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : propertyErrors.entrySet()) {
            java.util.Iterator<java.lang.String> itr = entry.getValue().iterator();
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ValidationUtil.__L6888, itr.hasNext())) {
                sb.append(entry.getKey());
                sb.append(" : ");
                java.lang.String errorMessage = itr.next();
                sb.append(org.broadleafcommerce.common.util.ValidationUtil.processMessage(errorMessage));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ValidationUtil.__L6889, itr.hasNext())) {
                    sb.append(" / ");
                }
            } 
            sb.append(";\n");
        }
        for (java.lang.String globalError : globalErrors) {
            sb.append(org.broadleafcommerce.common.util.ValidationUtil.processMessage(globalError));
            sb.append(";\n");
        }
        return "The entity has failed validation -\n" + (sb.toString());
    }

    public static java.lang.String processMessage(java.lang.String globalError) {
        java.lang.String friendlyName = org.broadleafcommerce.common.util.BLCMessageUtils.getMessage(globalError);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.ValidationUtil.__L6890, (friendlyName != null))) {
            return friendlyName;
        }
        return globalError;
    }

    public static perturbation.location.PerturbationLocation __L6888;

    public static perturbation.location.PerturbationLocation __L6889;

    public static perturbation.location.PerturbationLocation __L6890;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.ValidationUtil.__L6888 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ValidationUtil.java:33)", 6888, "Boolean");
        org.broadleafcommerce.common.util.ValidationUtil.__L6889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ValidationUtil.java:40)", 6889, "Boolean");
        org.broadleafcommerce.common.util.ValidationUtil.__L6890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/ValidationUtil.java:57)", 6890, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.ValidationUtil.initPerturbationLocation0();
    }
}

