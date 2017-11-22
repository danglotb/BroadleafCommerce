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


public interface TRCreditCardExtensionHandler extends org.broadleafcommerce.common.extension.ExtensionHandler {
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType createTransparentRedirectForm(java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> formParameters, org.broadleafcommerce.common.payment.dto.PaymentRequestDTO requestDTO, java.util.Map<java.lang.String, java.lang.String> configurationSettings) throws org.broadleafcommerce.common.vendor.service.exception.PaymentException;

    public org.broadleafcommerce.common.extension.ExtensionResultStatusType setFormActionKey(java.lang.StringBuilder key);

    public org.broadleafcommerce.common.extension.ExtensionResultStatusType setFormHiddenParamsKey(java.lang.StringBuilder key);
}

