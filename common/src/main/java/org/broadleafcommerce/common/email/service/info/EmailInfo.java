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
package org.broadleafcommerce.common.email.service.info;


public class EmailInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.String emailType;

    private java.lang.String emailTemplate;

    private java.lang.String subject;

    private java.lang.String fromAddress;

    private java.lang.String messageBody;

    private java.lang.String encoding = "UTF8";

    private java.util.List<org.broadleafcommerce.common.email.service.message.Attachment> attachments = new java.util.ArrayList<org.broadleafcommerce.common.email.service.message.Attachment>();

    private java.lang.String sendEmailReliableAsync;

    private java.lang.String sendAsyncPriority;

    public java.lang.String getEmailType() {
        return emailType;
    }

    public void setEmailType(java.lang.String emailType) {
        this.emailType = emailType;
    }

    public java.lang.String getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(java.lang.String emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    public java.lang.String getSubject() {
        return subject;
    }

    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }

    public java.lang.String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(java.lang.String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public java.lang.String getSendEmailReliableAsync() {
        return sendEmailReliableAsync;
    }

    public void setSendEmailReliableAsync(java.lang.String sendEmailReliableAsync) {
        this.sendEmailReliableAsync = sendEmailReliableAsync;
    }

    public java.lang.String getSendAsyncPriority() {
        return sendAsyncPriority;
    }

    public void setSendAsyncPriority(java.lang.String sendAsyncPriority) {
        this.sendAsyncPriority = sendAsyncPriority;
    }

    public java.lang.String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(java.lang.String messageBody) {
        this.messageBody = messageBody;
    }

    public java.util.List<org.broadleafcommerce.common.email.service.message.Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(java.util.List<org.broadleafcommerce.common.email.service.message.Attachment> attachments) {
        this.attachments = attachments;
    }

    public java.lang.String getEncoding() {
        return encoding;
    }

    public void setEncoding(java.lang.String encoding) {
        this.encoding = encoding;
    }

    public synchronized org.broadleafcommerce.common.email.service.info.EmailInfo clone() {
        org.broadleafcommerce.common.email.service.info.EmailInfo info = new org.broadleafcommerce.common.email.service.info.EmailInfo();
        info.setAttachments(attachments);
        info.setEmailTemplate(emailTemplate);
        info.setEmailType(emailType);
        info.setFromAddress(fromAddress);
        info.setMessageBody(messageBody);
        info.setSendAsyncPriority(sendAsyncPriority);
        info.setSendEmailReliableAsync(sendEmailReliableAsync);
        info.setSubject(subject);
        info.setEncoding(encoding);
        return info;
    }
}

