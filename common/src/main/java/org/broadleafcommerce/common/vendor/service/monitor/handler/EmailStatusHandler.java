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
package org.broadleafcommerce.common.vendor.service.monitor.handler;


public class EmailStatusHandler implements org.broadleafcommerce.common.vendor.service.monitor.StatusHandler {
    @javax.annotation.Resource(name = "blEmailService")
    protected org.broadleafcommerce.common.email.service.EmailService emailService;

    protected org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo;

    protected org.broadleafcommerce.common.email.domain.EmailTarget emailTarget;

    public void handleStatus(java.lang.String serviceName, org.broadleafcommerce.common.vendor.service.type.ServiceStatusType status) {
        java.lang.String message = (serviceName + " is reporting a status of ") + (status.getType());
        org.broadleafcommerce.common.email.service.info.EmailInfo copy = emailInfo.clone();
        copy.setMessageBody(message);
        copy.setSubject(message);
        emailService.sendBasicEmail(copy, emailTarget, null);
    }

    public org.broadleafcommerce.common.email.service.info.EmailInfo getEmailInfo() {
        return emailInfo;
    }

    public void setEmailInfo(org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo) {
        this.emailInfo = emailInfo;
    }

    public org.broadleafcommerce.common.email.domain.EmailTarget getEmailTarget() {
        return emailTarget;
    }

    public void setEmailTarget(org.broadleafcommerce.common.email.domain.EmailTarget emailTarget) {
        this.emailTarget = emailTarget;
    }
}

