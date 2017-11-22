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
package org.broadleafcommerce.common.util.dao;


public class QueryUtils {
    private static final org.broadleafcommerce.common.persistence.ArchiveStatus statusNotArchived = new org.broadleafcommerce.common.persistence.ArchiveStatus();

    public static void effectiveDate(javax.persistence.criteria.CriteriaBuilder builder, java.util.List<javax.persistence.criteria.Predicate> restrictions, javax.persistence.criteria.Path datesPath, java.lang.String startDateFieldName, java.lang.String endDateFieldName) {
        java.util.Date now = new java.util.Date();
        javax.persistence.criteria.Path<java.util.Date> activeStartDate = datesPath.<java.util.Date>get(startDateFieldName);
        javax.persistence.criteria.Path<java.util.Date> activeEndDate = datesPath.<java.util.Date>get(endDateFieldName);
        restrictions.add(builder.isNotNull(activeStartDate));
        restrictions.add(builder.lessThanOrEqualTo(activeStartDate, now));
        javax.persistence.criteria.Predicate notExpired = builder.or(builder.isNull(activeEndDate), builder.greaterThan(activeEndDate, now));
        restrictions.add(notExpired);
    }

    public static void notArchived(javax.persistence.criteria.CriteriaBuilder builder, java.util.List<javax.persistence.criteria.Predicate> restrictions, javax.persistence.criteria.Path archivedPath, java.lang.String archivedFieldName) {
        javax.persistence.criteria.Path<org.broadleafcommerce.common.persistence.ArchiveStatus> archiveValue = archivedPath.<org.broadleafcommerce.common.persistence.ArchiveStatus>get(archivedFieldName);
        javax.persistence.criteria.Predicate archivedNull = builder.isNull(archiveValue);
        javax.persistence.criteria.Predicate notArchived = builder.equal(archiveValue, org.broadleafcommerce.common.util.dao.QueryUtils.statusNotArchived);
        restrictions.add(builder.or(archivedNull, notArchived));
    }
}

