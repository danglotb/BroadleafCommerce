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
package org.broadleafcommerce.common.email.dao;


@org.springframework.stereotype.Repository("blEmailReportingDao")
public class EmailReportingDaoImpl implements org.broadleafcommerce.common.email.dao.EmailReportingDao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    public java.lang.Long createTracking(java.lang.String emailAddress, java.lang.String type, java.lang.String extraValue) {
        org.broadleafcommerce.common.email.domain.EmailTracking tracking = ((org.broadleafcommerce.common.email.domain.EmailTracking) (entityConfiguration.createEntityInstance("org.broadleafcommerce.common.email.domain.EmailTracking")));
        tracking.setDateSent(org.broadleafcommerce.common.time.SystemTime.asDate());
        tracking.setEmailAddress(emailAddress);
        tracking.setType(type);
        em.persist(tracking);
        return tracking.getId();
    }

    public org.broadleafcommerce.common.email.domain.EmailTarget createTarget() {
        org.broadleafcommerce.common.email.domain.EmailTarget target = ((org.broadleafcommerce.common.email.domain.EmailTarget) (entityConfiguration.createEntityInstance("org.broadleafcommerce.common.email.domain.EmailTarget")));
        return target;
    }

    @java.lang.SuppressWarnings("unchecked")
    public org.broadleafcommerce.common.email.domain.EmailTracking retrieveTracking(java.lang.Long emailId) {
        return ((org.broadleafcommerce.common.email.domain.EmailTracking) (em.find(entityConfiguration.lookupEntityClass("org.broadleafcommerce.common.email.domain.EmailTracking"), emailId)));
    }

    public void recordOpen(java.lang.Long emailId, java.lang.String userAgent) {
        org.broadleafcommerce.common.email.domain.EmailTrackingOpens opens = ((org.broadleafcommerce.common.email.domain.EmailTrackingOpens) (entityConfiguration.createEntityInstance("org.broadleafcommerce.common.email.domain.EmailTrackingOpens")));
        opens.setEmailTracking(retrieveTracking(emailId));
        opens.setDateOpened(org.broadleafcommerce.common.time.SystemTime.asDate());
        opens.setUserAgent(userAgent);
        em.persist(opens);
    }

    public void recordClick(java.lang.Long emailId, java.lang.String customerId, java.lang.String destinationUri, java.lang.String queryString) {
        org.broadleafcommerce.common.email.domain.EmailTrackingClicks clicks = ((org.broadleafcommerce.common.email.domain.EmailTrackingClicks) (entityConfiguration.createEntityInstance("org.broadleafcommerce.common.email.domain.EmailTrackingClicks")));
        clicks.setEmailTracking(retrieveTracking(emailId));
        clicks.setDateClicked(org.broadleafcommerce.common.time.SystemTime.asDate());
        clicks.setDestinationUri(destinationUri);
        clicks.setQueryString(queryString);
        clicks.setCustomerId(customerId);
        em.persist(clicks);
    }
}

