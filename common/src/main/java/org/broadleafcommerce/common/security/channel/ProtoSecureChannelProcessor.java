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


public class ProtoSecureChannelProcessor extends org.springframework.security.web.access.channel.SecureChannelProcessor {
    @java.lang.Override
    public void decide(org.springframework.security.web.FilterInvocation invocation, java.util.Collection<org.springframework.security.access.ConfigAttribute> config) throws java.io.IOException, javax.servlet.ServletException {
        org.springframework.util.Assert.isTrue(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4795, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4793, (invocation != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4794, (config != null))))), "Nulls cannot be provided");
        for (org.springframework.security.access.ConfigAttribute attribute : config) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4796, supports(attribute))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4799, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4797, ((invocation.getHttpRequest().getHeader("X-Forwarded-Proto")) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4798, "https".equalsIgnoreCase(invocation.getHttpRequest().getHeader("X-Forwarded-Proto"))))))) {
                    return ;
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4800, invocation.getHttpRequest().isSecure())) {
                        return ;
                    }else {
                        getEntryPoint().commence(invocation.getRequest(), invocation.getResponse());
                    }

            }
        }
    }

    public static perturbation.location.PerturbationLocation __L4793;

    public static perturbation.location.PerturbationLocation __L4794;

    public static perturbation.location.PerturbationLocation __L4795;

    public static perturbation.location.PerturbationLocation __L4796;

    public static perturbation.location.PerturbationLocation __L4797;

    public static perturbation.location.PerturbationLocation __L4798;

    public static perturbation.location.PerturbationLocation __L4799;

    public static perturbation.location.PerturbationLocation __L4800;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:52)", 4793, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:52)", 4794, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:52)", 4795, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:55)", 4796, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:56)", 4797, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:57)", 4798, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:56)", 4799, "Boolean");
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.__L4800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/channel/ProtoSecureChannelProcessor.java:59)", 4800, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.channel.ProtoSecureChannelProcessor.initPerturbationLocation0();
    }
}

