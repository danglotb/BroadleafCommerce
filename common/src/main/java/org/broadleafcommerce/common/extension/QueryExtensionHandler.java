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
package org.broadleafcommerce.common.extension;


public interface QueryExtensionHandler extends org.broadleafcommerce.common.extension.ExtensionHandler {
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType setup(java.lang.Class<?> type, java.lang.String[] config);

    public org.broadleafcommerce.common.extension.ExtensionResultStatusType refineRetrieve(java.lang.Class<?> type, java.lang.String[] config, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Predicate> restrictions);

    public org.broadleafcommerce.common.extension.ExtensionResultStatusType refineOrder(java.lang.Class<?> type, java.lang.String[] config, javax.persistence.criteria.CriteriaBuilder builder, javax.persistence.criteria.CriteriaQuery criteria, javax.persistence.criteria.Root root, java.util.List<javax.persistence.criteria.Order> sorts);

    public org.broadleafcommerce.common.extension.ExtensionResultStatusType refineResults(java.lang.Class<?> type, java.lang.String[] config, java.util.List queryResults, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List> response);

    public org.broadleafcommerce.common.extension.ExtensionResultStatusType breakdown(java.lang.Class<?> type, java.lang.String[] config);
}

