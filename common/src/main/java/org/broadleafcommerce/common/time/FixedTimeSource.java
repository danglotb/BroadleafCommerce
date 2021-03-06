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


public class FixedTimeSource implements org.broadleafcommerce.common.time.TimeSource {
    private final long timeInMillis;

    public FixedTimeSource(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public long timeInMillis() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.time.FixedTimeSource.__L5689, timeInMillis);
    }

    public static perturbation.location.PerturbationLocation __L5689;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.FixedTimeSource.__L5689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/FixedTimeSource.java:29)", 5689, "Numerical");
    }

    static {
        org.broadleafcommerce.common.time.FixedTimeSource.initPerturbationLocation0();
    }
}

