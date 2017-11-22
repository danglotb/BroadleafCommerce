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


public class JMSEmailServiceProducerImpl implements org.broadleafcommerce.common.email.service.jms.JMSEmailServiceProducer {
    private org.springframework.jms.core.JmsTemplate emailServiceTemplate;

    private javax.jms.Destination emailServiceDestination;

    public void send(final java.util.Map props) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.jms.JMSEmailServiceProducerImpl.__L1136, (props instanceof java.io.Serializable))) {
            final java.io.Serializable sProps = ((java.io.Serializable) (props));
            emailServiceTemplate.send(emailServiceDestination, new org.springframework.jms.core.MessageCreator() {
                public javax.jms.Message createMessage(javax.jms.Session session) throws javax.jms.JMSException {
                    javax.jms.ObjectMessage message = session.createObjectMessage(sProps);
                    org.broadleafcommerce.common.email.service.info.EmailInfo info = ((org.broadleafcommerce.common.email.service.info.EmailInfo) (props.get(org.broadleafcommerce.common.email.service.message.EmailPropertyType.INFO.getType())));
                    message.setJMSPriority(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.jms.JMSEmailServiceProducerImpl.__L1137, java.lang.Integer.parseInt(info.getSendAsyncPriority())));
                    return message;
                }
            });
        }else {
            throw new java.lang.IllegalArgumentException("The properties map must be Serializable");
        }
    }

    public org.springframework.jms.core.JmsTemplate getEmailServiceTemplate() {
        return emailServiceTemplate;
    }

    public void setEmailServiceTemplate(org.springframework.jms.core.JmsTemplate emailServiceTemplate) {
        this.emailServiceTemplate = emailServiceTemplate;
    }

    public javax.jms.Destination getEmailServiceDestination() {
        return emailServiceDestination;
    }

    public void setEmailServiceDestination(javax.jms.Destination emailServiceDestination) {
        this.emailServiceDestination = emailServiceDestination;
    }

    public static perturbation.location.PerturbationLocation __L1136;

    public static perturbation.location.PerturbationLocation __L1137;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.jms.JMSEmailServiceProducerImpl.__L1136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/jms/JMSEmailServiceProducerImpl.java:44)", 1136, "Boolean");
        org.broadleafcommerce.common.email.service.jms.JMSEmailServiceProducerImpl.__L1137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/jms/JMSEmailServiceProducerImpl.java:50)", 1137, "Numerical");
    }

    static {
        org.broadleafcommerce.common.email.service.jms.JMSEmailServiceProducerImpl.initPerturbationLocation0();
    }
}

