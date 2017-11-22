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


public class ProtoInsecureChannelProcessor extends org.springframework.security.web.access.channel.InsecureChannelProcessor {
    @java.lang.Override
    public void decide(org.springframework.security.web.FilterInvocation invocation, java.util.Collection<org.springframework.security.access.ConfigAttribute> config) throws java.io.IOException, javax.servlet.ServletException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4783, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4781, (invocation == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4782, (config == null)))))) {
            throw new java.lang.IllegalArgumentException("Nulls cannot be provided");
        }
        for (org.springframework.security.access.ConfigAttribute attribute : config) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4784, supports(attribute))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4787, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4785, ((invocation.getHttpRequest().getHeader("X-Forwarded-Proto")) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4786, "https".equalsIgnoreCase(invocation.getHttpRequest().getHeader("X-Forwarded-Proto"))))))) {
                    getEntryPoint().commence(invocation.getRequest(), invocation.getResponse());
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4790, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4788, ((invocation.getHttpRequest().getHeader("X-Forwarded-Proto")) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4789, "http".equalsIgnoreCase(invocation.getHttpRequest().getHeader("X-Forwarded-Proto"))))))) {
                        return ;
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4792, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4791, invocation.getHttpRequest().isSecure()))))) {
                            return ;
                        }else {
                            getEntryPoint().commence(invocation.getRequest(), invocation.getResponse());
                        }


            }
        }
    }

    public static perturbation.location.PerturbationLocation __L4781;

    public static perturbation.location.PerturbationLocation __L4782;

    public static perturbation.location.PerturbationLocation __L4783;

    public static perturbation.location.PerturbationLocation __L4784;

    public static perturbation.location.PerturbationLocation __L4785;

    public static perturbation.location.PerturbationLocation __L4786;

    public static perturbation.location.PerturbationLocation __L4787;

    public static perturbation.location.PerturbationLocation __L4788;

    public static perturbation.location.PerturbationLocation __L4789;

    public static perturbation.location.PerturbationLocation __L4790;

    public static perturbation.location.PerturbationLocation __L4791;

    public static perturbation.location.PerturbationLocation __L4792;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:51)", 4781, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:51)", 4782, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:51)", 4783, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:56)", 4784, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:57)", 4785, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:58)", 4786, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:57)", 4787, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:63)", 4788, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:64)", 4789, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:63)", 4790, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:66)", 4791, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.__L4792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoInsecureChannelProcessor.java:66)", 4792, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.channel.ProtoInsecureChannelProcessor.initPerturbationLocation0();
    }
}

