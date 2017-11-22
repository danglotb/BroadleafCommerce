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


public class BLCMoneyFormatUtils {
    public static java.lang.String formatPrice(org.broadleafcommerce.common.money.Money price) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCMoneyFormatUtils.__L6159, (price == null))) {
            return "Not Available";
        }
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCMoneyFormatUtils.__L6160, ((brc.getJavaLocale()) != null))) {
            return org.broadleafcommerce.common.currency.util.BroadleafCurrencyUtils.getNumberFormatFromCache(brc.getJavaLocale(), price.getCurrency()).format(price.getAmount());
        }else {
            return "$ " + (price.getAmount().toString());
        }
    }

    public static perturbation.location.PerturbationLocation __L6159;

    public static perturbation.location.PerturbationLocation __L6160;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCMoneyFormatUtils.__L6159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCMoneyFormatUtils.java:38)", 6159, "Boolean");
        org.broadleafcommerce.common.util.BLCMoneyFormatUtils.__L6160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCMoneyFormatUtils.java:43)", 6160, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCMoneyFormatUtils.initPerturbationLocation0();
    }
}

