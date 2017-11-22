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
package org.broadleafcommerce.common.web.payment.processor;


@org.springframework.stereotype.Service("blCreditCardTypesExtensionManager")
public class CreditCardTypesExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler> {
    public CreditCardTypesExtensionManager() {
        super(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler.class);
    }

    @java.lang.Override
    public boolean continueOnHandled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionManager.__L7392, true);
    }

    public static perturbation.location.PerturbationLocation __L7392;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionManager.__L7392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/processor/CreditCardTypesExtensionManager.java:36)", 7392, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionManager.initPerturbationLocation0();
    }
}

