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


@org.springframework.stereotype.Service("blEmailService")
public class EmailServiceImpl implements org.broadleafcommerce.common.email.service.EmailService {
    @javax.annotation.Resource(name = "blEmailTrackingManager")
    protected org.broadleafcommerce.common.email.service.EmailTrackingManager emailTrackingManager;

    @javax.annotation.Resource(name = "blServerInfo")
    protected org.broadleafcommerce.common.email.service.info.ServerInfo serverInfo;

    protected org.broadleafcommerce.common.email.service.message.EmailServiceProducer emailServiceProducer;

    @javax.annotation.Resource(name = "blMessageCreator")
    protected org.broadleafcommerce.common.email.service.message.MessageCreator messageCreator;

    @javax.annotation.Resource(name = "blEmailReportingDao")
    protected org.broadleafcommerce.common.email.dao.EmailReportingDao emailReportingDao;

    public boolean sendTemplateEmail(org.broadleafcommerce.common.email.domain.EmailTarget emailTarget, org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, java.util.Map<java.lang.String, java.lang.Object> props) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1182, (props == null))) {
            props = new java.util.HashMap<java.lang.String, java.lang.Object>();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1183, (emailInfo == null))) {
            emailInfo = new org.broadleafcommerce.common.email.service.info.EmailInfo();
        }
        props.put(org.broadleafcommerce.common.email.service.message.EmailPropertyType.INFO.getType(), emailInfo);
        props.put(org.broadleafcommerce.common.email.service.message.EmailPropertyType.USER.getType(), emailTarget);
        java.lang.Long emailId = emailTrackingManager.createTrackedEmail(emailTarget.getEmailAddress(), emailInfo.getEmailType(), null);
        props.put("emailTrackingId", emailId);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1184, sendBasicEmail(emailInfo, emailTarget, props));
    }

    public boolean sendTemplateEmail(java.lang.String emailAddress, org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, java.util.Map<java.lang.String, java.lang.Object> props) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1186, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1185, (emailInfo instanceof org.broadleafcommerce.common.email.service.info.NullEmailInfo)))))) {
            org.broadleafcommerce.common.email.domain.EmailTarget emailTarget = emailReportingDao.createTarget();
            emailTarget.setEmailAddress(emailAddress);
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1187, sendTemplateEmail(emailTarget, emailInfo, props));
        }else {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1188, true);
        }
    }

    public boolean sendBasicEmail(org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, org.broadleafcommerce.common.email.domain.EmailTarget emailTarget, java.util.Map<java.lang.String, java.lang.Object> props) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1189, (props == null))) {
            props = new java.util.HashMap<java.lang.String, java.lang.Object>();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1190, (emailInfo == null))) {
            emailInfo = new org.broadleafcommerce.common.email.service.info.EmailInfo();
        }
        props.put(org.broadleafcommerce.common.email.service.message.EmailPropertyType.INFO.getType(), emailInfo);
        props.put(org.broadleafcommerce.common.email.service.message.EmailPropertyType.USER.getType(), emailTarget);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1191, java.lang.Boolean.parseBoolean(emailInfo.getSendEmailReliableAsync()))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1192, ((emailServiceProducer) == null))) {
                throw new org.broadleafcommerce.common.email.service.exception.EmailException("The property sendEmailReliableAsync on EmailInfo is true, but the EmailService does not have an instance of JMSEmailServiceProducer set.");
            }
            emailServiceProducer.send(props);
        }else {
            messageCreator.sendMessage(props);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1193, true);
    }

    public org.broadleafcommerce.common.email.service.EmailTrackingManager getEmailTrackingManager() {
        return emailTrackingManager;
    }

    public void setEmailTrackingManager(org.broadleafcommerce.common.email.service.EmailTrackingManager emailTrackingManager) {
        this.emailTrackingManager = emailTrackingManager;
    }

    public org.broadleafcommerce.common.email.service.info.ServerInfo getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(org.broadleafcommerce.common.email.service.info.ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    public org.broadleafcommerce.common.email.service.message.EmailServiceProducer getEmailServiceProducer() {
        return emailServiceProducer;
    }

    public void setEmailServiceProducer(org.broadleafcommerce.common.email.service.message.EmailServiceProducer emailServiceProducer) {
        this.emailServiceProducer = emailServiceProducer;
    }

    public org.broadleafcommerce.common.email.service.message.MessageCreator getMessageCreator() {
        return messageCreator;
    }

    public void setMessageCreator(org.broadleafcommerce.common.email.service.message.MessageCreator messageCreator) {
        this.messageCreator = messageCreator;
    }

    public static perturbation.location.PerturbationLocation __L1182;

    public static perturbation.location.PerturbationLocation __L1183;

    public static perturbation.location.PerturbationLocation __L1184;

    public static perturbation.location.PerturbationLocation __L1185;

    public static perturbation.location.PerturbationLocation __L1186;

    public static perturbation.location.PerturbationLocation __L1187;

    public static perturbation.location.PerturbationLocation __L1188;

    public static perturbation.location.PerturbationLocation __L1189;

    public static perturbation.location.PerturbationLocation __L1190;

    public static perturbation.location.PerturbationLocation __L1191;

    public static perturbation.location.PerturbationLocation __L1192;

    public static perturbation.location.PerturbationLocation __L1193;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:57)", 1182, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:60)", 1183, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:69)", 1184, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:73)", 1185, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:73)", 1186, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:76)", 1187, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:78)", 1188, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:83)", 1189, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:86)", 1190, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:93)", 1191, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:94)", 1192, "Boolean");
        org.broadleafcommerce.common.email.service.EmailServiceImpl.__L1193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailServiceImpl.java:102)", 1193, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.service.EmailServiceImpl.initPerturbationLocation0();
    }
}

