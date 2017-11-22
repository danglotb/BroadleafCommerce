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


public class VelocityMessageCreator extends org.broadleafcommerce.common.email.service.message.MessageCreator {
    private org.apache.velocity.app.VelocityEngine velocityEngine;

    private java.util.Map<java.lang.String, java.lang.Object> additionalConfigItems;

    public VelocityMessageCreator(org.apache.velocity.app.VelocityEngine velocityEngine, org.springframework.mail.javamail.JavaMailSender mailSender, java.util.Map<java.lang.String, java.lang.Object> additionalConfigItems) {
        super(mailSender);
        this.additionalConfigItems = additionalConfigItems;
        this.velocityEngine = velocityEngine;
    }

    @java.lang.Override
    public java.lang.String buildMessageBody(org.broadleafcommerce.common.email.service.info.EmailInfo info, java.util.Map<java.lang.String, java.lang.Object> props) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.__L1179, (props == null))) {
            props = new java.util.HashMap<java.lang.String, java.lang.Object>();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.__L1180, (props instanceof java.util.HashMap))) {
            java.util.HashMap<java.lang.String, java.lang.Object> hashProps = ((java.util.HashMap<java.lang.String, java.lang.Object>) (props));
            @java.lang.SuppressWarnings("unchecked")
            java.util.Map<java.lang.String, java.lang.Object> propsCopy = ((java.util.Map<java.lang.String, java.lang.Object>) (hashProps.clone()));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.__L1181, ((additionalConfigItems) != null))) {
                propsCopy.putAll(additionalConfigItems);
            }
            return org.springframework.ui.velocity.VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, info.getEmailTemplate(), info.getEncoding(), propsCopy);
        }
        throw new java.lang.IllegalArgumentException("Property map must be of type HashMap<String, Object>");
    }

    public org.apache.velocity.app.VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(org.apache.velocity.app.VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAdditionalConfigItems() {
        return additionalConfigItems;
    }

    public void setAdditionalConfigItems(java.util.Map<java.lang.String, java.lang.Object> additionalConfigItems) {
        this.additionalConfigItems = additionalConfigItems;
    }

    public static perturbation.location.PerturbationLocation __L1179;

    public static perturbation.location.PerturbationLocation __L1180;

    public static perturbation.location.PerturbationLocation __L1181;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.__L1179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/VelocityMessageCreator.java:41)", 1179, "Boolean");
        org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.__L1180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/VelocityMessageCreator.java:45)", 1180, "Boolean");
        org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.__L1181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/VelocityMessageCreator.java:49)", 1181, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.service.message.VelocityMessageCreator.initPerturbationLocation0();
    }
}

