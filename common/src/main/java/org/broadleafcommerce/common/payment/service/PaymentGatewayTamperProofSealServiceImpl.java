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
package org.broadleafcommerce.common.payment.service;


@org.springframework.stereotype.Service("blPaymentGatewayTamperProofSealService")
public class PaymentGatewayTamperProofSealServiceImpl implements org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealService {
    @java.lang.Override
    public java.lang.String createTamperProofSeal(java.lang.String secretKey, java.lang.String customerId, java.lang.String orderId) throws java.security.InvalidKeyException, java.security.NoSuchAlgorithmException {
        org.apache.commons.codec.binary.Base64 encoder = new org.apache.commons.codec.binary.Base64(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3846, true));
        javax.crypto.Mac sha1Mac = javax.crypto.Mac.getInstance("HmacSHA1");
        javax.crypto.spec.SecretKeySpec publicKeySpec = new javax.crypto.spec.SecretKeySpec(secretKey.getBytes(), "HmacSHA1");
        sha1Mac.init(publicKeySpec);
        java.lang.String customerOrderString = customerId + orderId;
        byte[] publicBytes = sha1Mac.doFinal(customerOrderString.getBytes());
        java.lang.String publicDigest = encoder.encodeToString(publicBytes);
        return publicDigest.replaceAll("\\r|\\n", "");
    }

    @java.lang.Override
    public java.lang.Boolean verifySeal(java.lang.String seal, java.lang.String secretKey, java.lang.String customerId, java.lang.String orderId) throws java.security.InvalidKeyException, java.security.NoSuchAlgorithmException {
        java.lang.Boolean valid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3847, ((boolean) (false)));
        java.lang.String constructedSeal = createTamperProofSeal(secretKey, customerId, orderId);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3850, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3848, (seal != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3849, seal.equals(constructedSeal)))))) {
            valid = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3851, true);
        }
        return valid;
    }

    public static perturbation.location.PerturbationLocation __L3846;

    public static perturbation.location.PerturbationLocation __L3847;

    public static perturbation.location.PerturbationLocation __L3848;

    public static perturbation.location.PerturbationLocation __L3849;

    public static perturbation.location.PerturbationLocation __L3850;

    public static perturbation.location.PerturbationLocation __L3851;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayTamperProofSealServiceImpl.java:43)", 3846, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayTamperProofSealServiceImpl.java:57)", 3847, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayTamperProofSealServiceImpl.java:60)", 3848, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayTamperProofSealServiceImpl.java:60)", 3849, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayTamperProofSealServiceImpl.java:60)", 3850, "Boolean");
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.__L3851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/payment/service/PaymentGatewayTamperProofSealServiceImpl.java:61)", 3851, "Boolean");
    }

    static {
        org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealServiceImpl.initPerturbationLocation0();
    }
}

