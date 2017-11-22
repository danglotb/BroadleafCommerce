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


public class NullEmailServiceImpl implements org.broadleafcommerce.common.email.service.EmailService {
    @java.lang.Override
    public boolean sendTemplateEmail(java.lang.String emailAddress, org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, java.util.Map<java.lang.String, java.lang.Object> props) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.NullEmailServiceImpl.__L1216, true);
    }

    @java.lang.Override
    public boolean sendTemplateEmail(org.broadleafcommerce.common.email.domain.EmailTarget emailTarget, org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, java.util.Map<java.lang.String, java.lang.Object> props) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.NullEmailServiceImpl.__L1217, true);
    }

    @java.lang.Override
    public boolean sendBasicEmail(org.broadleafcommerce.common.email.service.info.EmailInfo emailInfo, org.broadleafcommerce.common.email.domain.EmailTarget emailTarget, java.util.Map<java.lang.String, java.lang.Object> props) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.NullEmailServiceImpl.__L1218, true);
    }

    public static perturbation.location.PerturbationLocation __L1216;

    public static perturbation.location.PerturbationLocation __L1217;

    public static perturbation.location.PerturbationLocation __L1218;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.NullEmailServiceImpl.__L1216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/NullEmailServiceImpl.java:35)", 1216, "Boolean");
        org.broadleafcommerce.common.email.service.NullEmailServiceImpl.__L1217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/NullEmailServiceImpl.java:40)", 1217, "Boolean");
        org.broadleafcommerce.common.email.service.NullEmailServiceImpl.__L1218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/NullEmailServiceImpl.java:45)", 1218, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.service.NullEmailServiceImpl.initPerturbationLocation0();
    }
}

