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
package org.broadleafcommerce.common.email.service.jms;


public class EmailServiceMDP implements javax.jms.MessageListener {
    @javax.annotation.Resource(name = "blMessageCreator")
    private org.broadleafcommerce.common.email.service.message.MessageCreator messageCreator;

    @java.lang.SuppressWarnings("unchecked")
    public void onMessage(javax.jms.Message message) {
        try {
            java.util.HashMap props = ((java.util.HashMap) (((javax.jms.ObjectMessage) (message)).getObject()));
            messageCreator.sendMessage(props);
        } catch (org.springframework.mail.MailAuthenticationException e) {
            throw new org.broadleafcommerce.common.email.service.exception.EmailException(e);
        } catch (org.springframework.mail.MailPreparationException e) {
            throw new org.broadleafcommerce.common.email.service.exception.EmailException(e);
        } catch (org.springframework.mail.MailParseException e) {
            throw new org.broadleafcommerce.common.email.service.exception.EmailException(e);
        } catch (org.springframework.mail.MailSendException e) {
            throw new org.broadleafcommerce.common.email.service.exception.EmailException(e);
        } catch (javax.jms.JMSException e) {
            throw new org.broadleafcommerce.common.email.service.exception.EmailException(e);
        }
    }
}

