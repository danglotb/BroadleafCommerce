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
package org.broadleafcommerce.common.time;


public class DefaultTimeSource implements org.broadleafcommerce.common.time.TimeSource {
    public long timeInMillis() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.DefaultTimeSource.__L5688, java.lang.System.currentTimeMillis());
    }

    public static perturbation.location.PerturbationLocation __L5688;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.DefaultTimeSource.__L5688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DefaultTimeSource.java:23)", 5688, "Numerical");
    }

    static {
        org.broadleafcommerce.common.time.DefaultTimeSource.initPerturbationLocation0();
    }
}

