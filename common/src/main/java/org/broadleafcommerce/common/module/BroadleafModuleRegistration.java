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
package org.broadleafcommerce.common.module;


public interface BroadleafModuleRegistration {
    public enum BroadleafModuleEnum {
        ACCOUNT("Account"), ADMIN("Admin"), ADVANCED_CMS("Advanced CMS"), ADVANCED_INVENTORY("Advanced Inventory"), ADVANCED_OFFER("Advanced Offer"), AFFILIATE("Affilliate"), AMAZONS3("AmazonS3"), AVALARA("Avalara"), CART_RULES("Cart Rules"), CATALOG_ACCESS_POLICY("Catalog Access Policies"), CUSTOMER_SEGMENT("Customer Segment"), CUSTOM_FIELD("Custom Field"), GIFT_CARD_AND_CUSTOMER_CREDIT("Gift Cards and Customer Credit (AccountCredit)"), ENTERPRISE("Enterprise"), ENTERPRISE_SEARCH("Enterprise Search"), EXPORT("Export"), FREE_GEO_IP("FreeGeoIP"), I18N_ENTERPRISE("i18n Enterprise"), IMPORT("Import"), JOBS_AND_EVENTS("Jobs and Events"), MARKETPLACE("Marketplace"), MAX_MIND_GEO("MaxMindGeo"), MENU("Menu"), MERCHANDISING_GROUP("Merchandising Group"), MULTI_TENANT_SINGLE_SCHEMA("MultiTenant - SingleSchema"), OMS("OMS"), PAYPAL("Paypal"), PRICE_LIST("PriceList"), PROCESS("Process"), PRODUCT_TYPE("Product Type"), PUNCHOUT2GO("PunchOut2Go"), QUOTE("Quote"), REST_API("Broadleaf REST APIs"), SUBSCRIPTION("Subscription"), TAXCLOUD("TaxCloud"), THEME("Theme"), THYMELEAF2("Broadleaf Thymeleaf 2 Support"), THYMELEAF3("Broadleaf Thymeleaf 3 Support"), IGNORED("IGNORED");
        private final java.lang.String name;

        BroadleafModuleEnum(java.lang.String name) {
            this.name = name;
        }

        public boolean equalsModuleName(java.lang.String name) {
            return org.apache.commons.lang3.StringUtils.equals(name, this.name);
        }

        public java.lang.String getName() {
            return name;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return this.name;
        }
    }

    public java.lang.String getModuleName();
}

