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
package org.broadleafcommerce.common.email.service;


public interface EmailService {
    public boolean sendTemplateEmail(java.lang.String emailAddress, org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, java.util.Map<java.lang.String, java.lang.Object> props);

    public boolean sendTemplateEmail(org.broadleafcommerce.common.email.domain.EmailTarget emailTarget, org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, java.util.Map<java.lang.String, java.lang.Object> props);

    public boolean sendBasicEmail(org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, org.broadleafcommerce.common.email.domain.EmailTarget emailTarget, java.util.Map<java.lang.String, java.lang.Object> props);
}

