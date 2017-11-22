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
package org.broadleafcommerce.common.email.service.message;


public class NullMessageCreator extends org.broadleafcommerce.common.email.service.message.MessageCreator {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.email.service.message.NullMessageCreator.class);

    public NullMessageCreator(org.springframework.mail.javamail.JavaMailSender mailSender) {
        super(mailSender);
    }

    @java.lang.Override
    public java.lang.String buildMessageBody(org.broadleafcommerce.common.email.service.info.EmailInfo info, java.util.Map<java.lang.String, java.lang.Object> props) {
        return info.getEmailTemplate();
    }

    @java.lang.Override
    public void sendMessage(final java.util.Map<java.lang.String, java.lang.Object> props) throws org.springframework.mail.MailException {
        org.broadleafcommerce.common.email.service.message.NullMessageCreator.LOG.warn("NullMessageCreator is defined -- specify a real message creator to send emails");
    }
}

