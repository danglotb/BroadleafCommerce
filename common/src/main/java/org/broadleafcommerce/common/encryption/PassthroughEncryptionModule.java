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
package org.broadleafcommerce.common.encryption;


public class PassthroughEncryptionModule implements org.broadleafcommerce.common.encryption.EncryptionModule {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.encryption.PassthroughEncryptionModule.class);

    protected org.broadleafcommerce.common.config.RuntimeEnvironmentKeyResolver keyResolver = new org.broadleafcommerce.common.config.SystemPropertyRuntimeEnvironmentKeyResolver();

    public PassthroughEncryptionModule() {
        if ("production".equals(keyResolver.resolveRuntimeEnvironmentKey())) {
            org.broadleafcommerce.common.encryption.PassthroughEncryptionModule.LOG.warn("This passthrough encryption module provides NO ENCRYPTION and should NOT be used in production.");
        }
    }

    @java.lang.Override
    public java.lang.String decrypt(java.lang.String cipherText) {
        return cipherText;
    }

    @java.lang.Override
    public java.lang.String encrypt(java.lang.String plainText) {
        return plainText;
    }

    @java.lang.Override
    public java.lang.Boolean matches(java.lang.String raw, java.lang.String encrypted) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.encryption.PassthroughEncryptionModule.__L1219, encrypted.equals(encrypt(raw)));
    }

    public static perturbation.location.PerturbationLocation __L1219;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.encryption.PassthroughEncryptionModule.__L1219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/encryption/PassthroughEncryptionModule.java:60)", 1219, "Boolean");
    }

    static {
        org.broadleafcommerce.common.encryption.PassthroughEncryptionModule.initPerturbationLocation0();
    }
}

