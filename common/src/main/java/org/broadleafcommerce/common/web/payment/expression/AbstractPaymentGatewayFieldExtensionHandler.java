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
package org.broadleafcommerce.common.web.payment.expression;


public abstract class AbstractPaymentGatewayFieldExtensionHandler extends org.broadleafcommerce.common.extension.AbstractExtensionHandler implements org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionHandler {
    @javax.annotation.Resource(name = "blPaymentGatewayResolver")
    protected org.broadleafcommerce.common.payment.service.PaymentGatewayResolver paymentGatewayResolver;

    public abstract java.lang.String getCreditCardHolderName();

    public abstract java.lang.String getCreditCardType();

    public abstract java.lang.String getCreditCardNum();

    public abstract java.lang.String getCreditCardExpDate();

    public abstract java.lang.String getCreditCardExpMonth();

    public abstract java.lang.String getCreditCardExpYear();

    public abstract java.lang.String getCreditCardCvv();

    public abstract java.lang.String getBillToAddressFirstName();

    public abstract java.lang.String getBillToAddressLastName();

    public abstract java.lang.String getBillToAddressCompanyName();

    public abstract java.lang.String getBillToAddressLine1();

    public abstract java.lang.String getBillToAddressLine2();

    public abstract java.lang.String getBillToAddressCityLocality();

    public abstract java.lang.String getBillToAddressStateRegion();

    public abstract java.lang.String getBillToAddressPostalCode();

    public abstract java.lang.String getBillToAddressCountryCode();

    public abstract java.lang.String getBillToAddressPhone();

    public abstract java.lang.String getBillToAddressEmail();

    public abstract java.lang.String getShipToAddressFirstName();

    public abstract java.lang.String getShipToAddressLastName();

    public abstract java.lang.String getShipToAddressCompanyName();

    public abstract java.lang.String getShipToAddressLine1();

    public abstract java.lang.String getShipToAddressLine2();

    public abstract java.lang.String getShipToAddressCityLocality();

    public abstract java.lang.String getShipToAddressStateRegion();

    public abstract java.lang.String getShipToAddressPostalCode();

    public abstract java.lang.String getShipToAddressCountryCode();

    public abstract java.lang.String getShipToAddressPhone();

    public abstract java.lang.String getShipToAddressEmail();

    public abstract org.broadleafcommerce.common.payment.PaymentGatewayType getHandlerType();

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType mapFieldName(java.lang.String fieldNameKey, java.util.Map<java.lang.String, java.lang.String> fieldNameMap) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7312, paymentGatewayResolver.isHandlerCompatible(getHandlerType()))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7313, "creditCard.creditCardHolderName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7314, ((getCreditCardHolderName()) != null)) ? getCreditCardHolderName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7315, "creditCard.creditCardType".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7316, ((getCreditCardType()) != null)) ? getCreditCardType() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7317, "creditCard.creditCardNum".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7318, ((getCreditCardNum()) != null)) ? getCreditCardNum() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7319, "creditCard.creditCardExpDate".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7320, ((getCreditCardExpDate()) != null)) ? getCreditCardExpDate() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7321, "creditCard.creditCardExpMonth".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7322, ((getCreditCardExpMonth()) != null)) ? getCreditCardExpMonth() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7323, "creditCard.creditCardExpYear".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7324, ((getCreditCardExpYear()) != null)) ? getCreditCardExpYear() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7325, "creditCard.creditCardCvv".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7326, ((getCreditCardCvv()) != null)) ? getCreditCardCvv() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7327, "billTo.addressFirstName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7328, ((getBillToAddressFirstName()) != null)) ? getBillToAddressFirstName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7329, "billTo.addressLastName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7330, ((getBillToAddressLastName()) != null)) ? getBillToAddressLastName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7331, "billTo.addressCompanyName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7332, ((getBillToAddressCompanyName()) != null)) ? getBillToAddressCompanyName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7333, "billTo.addressLine1".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7334, ((getBillToAddressLine1()) != null)) ? getBillToAddressLine1() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7335, "billTo.addressLine2".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7336, ((getBillToAddressLine2()) != null)) ? getBillToAddressLine2() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7337, "billTo.addressCityLocality".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7338, ((getBillToAddressCityLocality()) != null)) ? getBillToAddressCityLocality() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7339, "billTo.addressStateRegion".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7340, ((getBillToAddressStateRegion()) != null)) ? getBillToAddressStateRegion() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7341, "billTo.addressPostalCode".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7342, ((getBillToAddressPostalCode()) != null)) ? getBillToAddressPostalCode() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7343, "billTo.addressCountryCode".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7344, ((getBillToAddressCountryCode()) != null)) ? getBillToAddressCountryCode() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7345, "billTo.addressPhone".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7346, ((getBillToAddressPhone()) != null)) ? getBillToAddressPhone() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7347, "billTo.addressEmail".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7348, ((getBillToAddressEmail()) != null)) ? getBillToAddressEmail() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7349, "shipTo.addressFirstName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7350, ((getShipToAddressFirstName()) != null)) ? getShipToAddressFirstName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7351, "shipTo.addressLastName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7352, ((getShipToAddressLastName()) != null)) ? getShipToAddressLastName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7353, "shipTo.addressCompanyName".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7354, ((getShipToAddressCompanyName()) != null)) ? getShipToAddressCompanyName() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7355, "shipTo.addressLine1".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7356, ((getShipToAddressLine1()) != null)) ? getShipToAddressLine1() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7357, "shipTo.addressLine2".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7358, ((getShipToAddressLine2()) != null)) ? getShipToAddressLine2() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7359, "shipTo.addressCityLocality".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7360, ((getShipToAddressCityLocality()) != null)) ? getShipToAddressCityLocality() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7361, "shipTo.addressStateRegion".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7362, ((getShipToAddressStateRegion()) != null)) ? getShipToAddressStateRegion() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7363, "shipTo.addressPostalCode".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7364, ((getShipToAddressPostalCode()) != null)) ? getShipToAddressPostalCode() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7365, "shipTo.addressCountryCode".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7366, ((getShipToAddressCountryCode()) != null)) ? getShipToAddressCountryCode() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7367, "shipTo.addressPhone".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7368, ((getShipToAddressPhone()) != null)) ? getShipToAddressPhone() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7369, "shipTo.addressEmail".equals(fieldNameKey))) {
                fieldNameMap.put(fieldNameKey, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7370, ((getShipToAddressEmail()) != null)) ? getShipToAddressEmail() : fieldNameKey));
                return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
            }
            return org.broadleafcommerce.common.extension.ExtensionResultStatusType.HANDLED_CONTINUE;
        }
        return org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED;
    }

    public static perturbation.location.PerturbationLocation __L7312;

    public static perturbation.location.PerturbationLocation __L7313;

    public static perturbation.location.PerturbationLocation __L7314;

    public static perturbation.location.PerturbationLocation __L7315;

    public static perturbation.location.PerturbationLocation __L7316;

    public static perturbation.location.PerturbationLocation __L7317;

    public static perturbation.location.PerturbationLocation __L7318;

    public static perturbation.location.PerturbationLocation __L7319;

    public static perturbation.location.PerturbationLocation __L7320;

    public static perturbation.location.PerturbationLocation __L7321;

    public static perturbation.location.PerturbationLocation __L7322;

    public static perturbation.location.PerturbationLocation __L7323;

    public static perturbation.location.PerturbationLocation __L7324;

    public static perturbation.location.PerturbationLocation __L7325;

    public static perturbation.location.PerturbationLocation __L7326;

    public static perturbation.location.PerturbationLocation __L7327;

    public static perturbation.location.PerturbationLocation __L7328;

    public static perturbation.location.PerturbationLocation __L7329;

    public static perturbation.location.PerturbationLocation __L7330;

    public static perturbation.location.PerturbationLocation __L7331;

    public static perturbation.location.PerturbationLocation __L7332;

    public static perturbation.location.PerturbationLocation __L7333;

    public static perturbation.location.PerturbationLocation __L7334;

    public static perturbation.location.PerturbationLocation __L7335;

    public static perturbation.location.PerturbationLocation __L7336;

    public static perturbation.location.PerturbationLocation __L7337;

    public static perturbation.location.PerturbationLocation __L7338;

    public static perturbation.location.PerturbationLocation __L7339;

    public static perturbation.location.PerturbationLocation __L7340;

    public static perturbation.location.PerturbationLocation __L7341;

    public static perturbation.location.PerturbationLocation __L7342;

    public static perturbation.location.PerturbationLocation __L7343;

    public static perturbation.location.PerturbationLocation __L7344;

    public static perturbation.location.PerturbationLocation __L7345;

    public static perturbation.location.PerturbationLocation __L7346;

    public static perturbation.location.PerturbationLocation __L7347;

    public static perturbation.location.PerturbationLocation __L7348;

    public static perturbation.location.PerturbationLocation __L7349;

    public static perturbation.location.PerturbationLocation __L7350;

    public static perturbation.location.PerturbationLocation __L7351;

    public static perturbation.location.PerturbationLocation __L7352;

    public static perturbation.location.PerturbationLocation __L7353;

    public static perturbation.location.PerturbationLocation __L7354;

    public static perturbation.location.PerturbationLocation __L7355;

    public static perturbation.location.PerturbationLocation __L7356;

    public static perturbation.location.PerturbationLocation __L7357;

    public static perturbation.location.PerturbationLocation __L7358;

    public static perturbation.location.PerturbationLocation __L7359;

    public static perturbation.location.PerturbationLocation __L7360;

    public static perturbation.location.PerturbationLocation __L7361;

    public static perturbation.location.PerturbationLocation __L7362;

    public static perturbation.location.PerturbationLocation __L7363;

    public static perturbation.location.PerturbationLocation __L7364;

    public static perturbation.location.PerturbationLocation __L7365;

    public static perturbation.location.PerturbationLocation __L7366;

    public static perturbation.location.PerturbationLocation __L7367;

    public static perturbation.location.PerturbationLocation __L7368;

    public static perturbation.location.PerturbationLocation __L7369;

    public static perturbation.location.PerturbationLocation __L7370;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:76)", 7312, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:81)", 7313, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:83)", 7314, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:87)", 7315, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:89)", 7316, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:93)", 7317, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:95)", 7318, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:99)", 7319, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:101)", 7320, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:105)", 7321, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:107)", 7322, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:111)", 7323, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:113)", 7324, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:117)", 7325, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:119)", 7326, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:127)", 7327, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:129)", 7328, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:133)", 7329, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:135)", 7330, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:139)", 7331, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:141)", 7332, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:145)", 7333, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:147)", 7334, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:151)", 7335, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:153)", 7336, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7337 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:157)", 7337, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7338 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:159)", 7338, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7339 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:163)", 7339, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7340 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:165)", 7340, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7341 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:169)", 7341, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7342 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:171)", 7342, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7343 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:175)", 7343, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7344 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:177)", 7344, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7345 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:181)", 7345, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7346 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:183)", 7346, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7347 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:187)", 7347, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7348 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:189)", 7348, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7349 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:197)", 7349, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7350 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:199)", 7350, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7351 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:203)", 7351, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:205)", 7352, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:209)", 7353, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:211)", 7354, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:215)", 7355, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:217)", 7356, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:221)", 7357, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:223)", 7358, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:227)", 7359, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:229)", 7360, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:233)", 7361, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:235)", 7362, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:239)", 7363, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:241)", 7364, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:245)", 7365, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:247)", 7366, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:251)", 7367, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:253)", 7368, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:257)", 7369, "Boolean");
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.__L7370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/payment/expression/AbstractPaymentGatewayFieldExtensionHandler.java:259)", 7370, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.payment.expression.AbstractPaymentGatewayFieldExtensionHandler.initPerturbationLocation0();
    }
}

