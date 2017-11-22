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


public class BLCNumberUtils {
    public static java.lang.Long toLong(java.lang.Object objectToConvert) {
        java.lang.Long convertedLongValue;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCNumberUtils.__L6161, (objectToConvert instanceof java.lang.Integer))) {
            convertedLongValue = new java.lang.Long(((java.lang.Integer) (objectToConvert)));
        }else {
            convertedLongValue = ((java.lang.Long) (objectToConvert));
        }
        return convertedLongValue;
    }

    public static perturbation.location.PerturbationLocation __L6161;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCNumberUtils.__L6161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCNumberUtils.java:36)", 6161, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCNumberUtils.initPerturbationLocation0();
    }
}

