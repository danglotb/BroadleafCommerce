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


public abstract class MessageCreator {
    private org.springframework.mail.javamail.JavaMailSender mailSender;

    public MessageCreator(org.springframework.mail.javamail.JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage(final java.util.Map<java.lang.String, java.lang.Object> props) throws org.springframework.mail.MailException {
        org.springframework.mail.javamail.MimeMessagePreparator preparator = buildMimeMessagePreparator(props);
        this.mailSender.send(preparator);
    }

    public abstract java.lang.String buildMessageBody(org.broadleafcommerce.common.email.service.info.EmailInfo info, java.util.Map<java.lang.String, java.lang.Object> props);

    public org.springframework.mail.javamail.MimeMessagePreparator buildMimeMessagePreparator(final java.util.Map<java.lang.String, java.lang.Object> props) {
        org.springframework.mail.javamail.MimeMessagePreparator preparator = new org.springframework.mail.javamail.MimeMessagePreparator() {
            @java.lang.Override
            public void prepare(javax.mail.internet.MimeMessage mimeMessage) throws java.lang.Exception {
                org.broadleafcommerce.common.email.domain.EmailTarget emailUser = ((org.broadleafcommerce.common.email.domain.EmailTarget) (props.get(org.broadleafcommerce.common.email.service.message.EmailPropertyType.USER.getType())));
                org.broadleafcommerce.common.email.service.info.EmailInfo info = ((org.broadleafcommerce.common.email.service.info.EmailInfo) (props.get(org.broadleafcommerce.common.email.service.message.EmailPropertyType.INFO.getType())));
                boolean isMultipart = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1165, org.apache.commons.collections.CollectionUtils.isNotEmpty(info.getAttachments()));
                org.springframework.mail.javamail.MimeMessageHelper message = new org.springframework.mail.javamail.MimeMessageHelper(mimeMessage, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1166, isMultipart), info.getEncoding());
                message.setTo(emailUser.getEmailAddress());
                message.setFrom(info.getFromAddress());
                message.setSubject(info.getSubject());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1171, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1167, ((emailUser.getBCCAddresses()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1170, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1168, emailUser.getBCCAddresses().length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1169, 0)))))))) {
                    message.setBcc(emailUser.getBCCAddresses());
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1176, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1172, ((emailUser.getCCAddresses()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1175, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1173, emailUser.getCCAddresses().length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1174, 0)))))))) {
                    message.setCc(emailUser.getCCAddresses());
                }
                java.lang.String messageBody = info.getMessageBody();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1177, (messageBody == null))) {
                    messageBody = buildMessageBody(info, props);
                }
                message.setText(messageBody, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.MessageCreator.__L1178, true));
                for (org.broadleafcommerce.common.email.service.message.Attachment attachment : info.getAttachments()) {
                    javax.mail.util.ByteArrayDataSource dataSource = new javax.mail.util.ByteArrayDataSource(attachment.getData(), attachment.getMimeType());
                    message.addAttachment(attachment.getFilename(), dataSource);
                }
            }
        };
        return preparator;
    }

    public org.springframework.mail.javamail.JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(org.springframework.mail.javamail.JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static perturbation.location.PerturbationLocation __L1165;

    public static perturbation.location.PerturbationLocation __L1166;

    public static perturbation.location.PerturbationLocation __L1167;

    public static perturbation.location.PerturbationLocation __L1168;

    public static perturbation.location.PerturbationLocation __L1169;

    public static perturbation.location.PerturbationLocation __L1170;

    public static perturbation.location.PerturbationLocation __L1171;

    public static perturbation.location.PerturbationLocation __L1172;

    public static perturbation.location.PerturbationLocation __L1173;

    public static perturbation.location.PerturbationLocation __L1174;

    public static perturbation.location.PerturbationLocation __L1175;

    public static perturbation.location.PerturbationLocation __L1176;

    public static perturbation.location.PerturbationLocation __L1177;

    public static perturbation.location.PerturbationLocation __L1178;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:56)", 1165, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:57)", 1166, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:61)", 1167, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:61)", 1168, "Numerical");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:61)", 1169, "Numerical");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:61)", 1170, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:61)", 1171, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:64)", 1172, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:64)", 1173, "Numerical");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:64)", 1174, "Numerical");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:64)", 1175, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:64)", 1176, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:68)", 1177, "Boolean");
        org.broadleafcommerce.common.email.service.message.MessageCreator.__L1178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/MessageCreator.java:71)", 1178, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.service.message.MessageCreator.initPerturbationLocation0();
    }
}

