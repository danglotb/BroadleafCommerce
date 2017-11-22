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
package org.broadleafcommerce.common.payment;


public class UnmaskRange {
    public static final int BEGINNINGTYPE = 0;

    public static final int ENDTYPE = 1;

    private int positionType;

    private int length;

    public UnmaskRange(int startPosition, int length) {
        this.positionType = startPosition;
        this.length = length;
    }

    public int getPositionType() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.UnmaskRange.__L4106, positionType);
    }

    public int getLength() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.payment.UnmaskRange.__L4107, length);
    }

    public static perturbation.location.PerturbationLocation __L4106;

    public static perturbation.location.PerturbationLocation __L4107;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.UnmaskRange.__L4106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/UnmaskRange.java:34)", 4106, "Numerical");
        org.broadleafcommerce.common.payment.UnmaskRange.__L4107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/UnmaskRange.java:38)", 4107, "Numerical");
    }

    static {
        org.broadleafcommerce.common.payment.UnmaskRange.initPerturbationLocation0();
    }
}

