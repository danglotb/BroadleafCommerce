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


public class LoggingMailSender extends org.springframework.mail.javamail.JavaMailSenderImpl {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.email.service.LoggingMailSender.class);

    @java.lang.Override
    public void send(org.springframework.mail.javamail.MimeMessagePreparator[] mimeMessagePreparators) throws org.springframework.mail.MailException {
        for (org.springframework.mail.javamail.MimeMessagePreparator preparator : mimeMessagePreparators) {
            try {
                javax.mail.internet.MimeMessage mimeMessage = createMimeMessage();
                preparator.prepare(mimeMessage);
                org.broadleafcommerce.common.email.service.LoggingMailSender.LOG.info("\"Sending\" email: ");
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.LoggingMailSender.__L1214, ((mimeMessage.getContent()) instanceof javax.mail.internet.MimeMultipart))) {
                    javax.mail.internet.MimeMultipart msg = ((javax.mail.internet.MimeMultipart) (mimeMessage.getContent()));
                    javax.activation.DataHandler dh = msg.getBodyPart(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.LoggingMailSender.__L1215, 0)).getDataHandler();
                    java.io.ByteArrayOutputStream baos = null;
                    try {
                        baos = new java.io.ByteArrayOutputStream();
                        dh.writeTo(baos);
                    } catch (java.lang.Exception e) {
                    } finally {
                        try {
                            baos.close();
                        } catch (java.lang.Exception e) {
                            org.broadleafcommerce.common.email.service.LoggingMailSender.LOG.error("Couldn't close byte array output stream");
                        }
                    }
                }else {
                    org.broadleafcommerce.common.email.service.LoggingMailSender.LOG.info(mimeMessage.getContent());
                }
            } catch (java.lang.Exception e) {
                org.broadleafcommerce.common.email.service.LoggingMailSender.LOG.error("Could not create message", e);
            }
        }
    }

    public static perturbation.location.PerturbationLocation __L1214;

    public static perturbation.location.PerturbationLocation __L1215;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.LoggingMailSender.__L1214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/LoggingMailSender.java:45)", 1214, "Boolean");
        org.broadleafcommerce.common.email.service.LoggingMailSender.__L1215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/LoggingMailSender.java:47)", 1215, "Numerical");
    }

    static {
        org.broadleafcommerce.common.email.service.LoggingMailSender.initPerturbationLocation0();
    }
}

