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
package org.broadleafcommerce.common.security.channel;


public class ProtoChannelBeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor , org.springframework.core.Ordered {
    org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.class);

    protected java.util.List<org.springframework.security.web.access.channel.ChannelProcessor> channelProcessorOverrides;

    @java.lang.Override
    public java.lang.Object postProcessAfterInitialization(java.lang.Object bean, java.lang.String beanName) throws org.springframework.beans.BeansException {
        return bean;
    }

    @java.lang.Override
    public java.lang.Object postProcessBeforeInitialization(java.lang.Object bean, java.lang.String beanName) throws org.springframework.beans.BeansException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.__L4778, (bean instanceof org.springframework.security.web.access.channel.ChannelDecisionManagerImpl))) {
            try {
                org.springframework.security.web.access.channel.ChannelDecisionManagerImpl manager = ((org.springframework.security.web.access.channel.ChannelDecisionManagerImpl) (bean));
                java.lang.reflect.Field channelProcessors = manager.getClass().getDeclaredField("channelProcessors");
                channelProcessors.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.__L4779, true));
                java.util.List<org.springframework.security.web.access.channel.ChannelProcessor> list = ((java.util.List<org.springframework.security.web.access.channel.ChannelProcessor>) (channelProcessors.get(manager)));
                list.clear();
                manager.setChannelProcessors(channelProcessorOverrides);
                LOG.info(("Replacing the standard Spring Security channel processors with custom processors that look for a " + "'X-Forwarded-Proto' request header. This allows Spring Security to sit behind a load balancer with SSL termination."));
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        return bean;
    }

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.__L4780, 9999);
    }

    public java.util.List<org.springframework.security.web.access.channel.ChannelProcessor> getChannelProcessorOverrides() {
        return channelProcessorOverrides;
    }

    public void setChannelProcessorOverrides(java.util.List<org.springframework.security.web.access.channel.ChannelProcessor> channelProcessorOverrides) {
        this.channelProcessorOverrides = channelProcessorOverrides;
    }

    public static perturbation.location.PerturbationLocation __L4778;

    public static perturbation.location.PerturbationLocation __L4779;

    public static perturbation.location.PerturbationLocation __L4780;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.__L4778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoChannelBeanPostProcessor.java:83)", 4778, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.__L4779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoChannelBeanPostProcessor.java:87)", 4779, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.__L4780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoChannelBeanPostProcessor.java:102)", 4780, "Numerical");
    }

    static {
        org.broadleafcommerce.common.security.channel.ProtoChannelBeanPostProcessor.initPerturbationLocation0();
    }
}

