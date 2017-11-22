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
package org.broadleafcommerce.common.presentation;


public class RuleIdentifier {
    public static final java.lang.String CUSTOMER = "CUSTOMER_FIELDS";

    public static final java.lang.String FULFILLMENTGROUP = "FULFILLMENT_GROUP_FIELDS";

    public static final java.lang.String LOCALE = "LOCALE_FIELDS";

    public static final java.lang.String ORDER = "ORDER_FIELDS";

    public static final java.lang.String ORDERITEM = "ORDER_ITEM_FIELDS";

    public static final java.lang.String SKU = "SKU_FIELDS";

    public static final java.lang.String TIME = "TIME_FIELDS";

    public static final java.lang.String REQUEST = "REQUEST_FIELDS";

    public static final java.lang.String PRICING_CONTEXT = "PRICING_CONTEXT_FIELDS";

    public static final java.lang.String PRODUCT = "PRODUCT_FIELDS";

    public static final java.lang.String CATEGORY = "CATEGORY_FIELDS";

    public static final java.lang.String TRANSACTION = "TRANSACTION_FIELDS";

    public static final java.lang.String CUSTOMER_ENTITY_KEY = "customer";

    public static final java.lang.String FULFILLMENTGROUP_ENTITY_KEY = "fulfillmentGroup";

    public static final java.lang.String LOCALE_ENTITY_KEY = "locale";

    public static final java.lang.String ORDER_ENTITY_KEY = "order";

    public static final java.lang.String ORDERITEM_ENTITY_KEY = "orderItem";

    public static final java.lang.String SKU_ENTITY_KEY = "sku";

    public static final java.lang.String TIME_ENTITY_KEY = "time";

    public static final java.lang.String REQUEST_ENTITY_KEY = "request";

    public static final java.lang.String PRICING_CONTEXT_ENTITY_KEY = "pricingContext";

    public static final java.lang.String PRODUCT_ENTITY_KEY = "product";

    public static final java.lang.String CATEGORY_ENTITY_KEY = "category";

    public static final java.lang.String TRANSACTION_KEY = "transaction";

    public static final java.lang.String CUSTOMER_FIELD_KEY = "CUSTOMER";

    public static final java.lang.String LOCALE_FIELD_KEY = "LOCALE";

    public static final java.lang.String ORDER_FIELD_KEY = "ORDER";

    public static final java.lang.String FULFILLMENT_GROUP_FIELD_KEY = "FULFILLMENT_GROUP";

    public static final java.lang.String TIME_FIELD_KEY = "TIME";

    public static final java.lang.String REQUEST_FIELD_KEY = "REQUEST";

    public static final java.lang.String PRICING_CONTEXT_FIELD_KEY = "PRICING_CONTEXT";

    public static final java.lang.String PRODUCT_FIELD_KEY = "PRODUCT";

    public static final java.lang.String CATEGORY_FIELD_KEY = "CATEGORY";

    public static java.util.Map<java.lang.String, java.lang.String> ENTITY_KEY_MAP = new java.util.HashMap<java.lang.String, java.lang.String>();

    static {
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.CUSTOMER, org.broadleafcommerce.common.presentation.RuleIdentifier.CUSTOMER_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.FULFILLMENTGROUP, org.broadleafcommerce.common.presentation.RuleIdentifier.FULFILLMENTGROUP_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.LOCALE, org.broadleafcommerce.common.presentation.RuleIdentifier.LOCALE_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.ORDER, org.broadleafcommerce.common.presentation.RuleIdentifier.ORDER_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.ORDERITEM, org.broadleafcommerce.common.presentation.RuleIdentifier.ORDERITEM_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.SKU, org.broadleafcommerce.common.presentation.RuleIdentifier.SKU_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.TIME, org.broadleafcommerce.common.presentation.RuleIdentifier.TIME_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.REQUEST, org.broadleafcommerce.common.presentation.RuleIdentifier.REQUEST_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.PRODUCT, org.broadleafcommerce.common.presentation.RuleIdentifier.PRODUCT_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.CATEGORY, org.broadleafcommerce.common.presentation.RuleIdentifier.CATEGORY_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.PRICING_CONTEXT, org.broadleafcommerce.common.presentation.RuleIdentifier.PRICING_CONTEXT_ENTITY_KEY);
        org.broadleafcommerce.common.presentation.RuleIdentifier.ENTITY_KEY_MAP.put(org.broadleafcommerce.common.presentation.RuleIdentifier.TRANSACTION, org.broadleafcommerce.common.presentation.RuleIdentifier.TRANSACTION_KEY);
    }
}

