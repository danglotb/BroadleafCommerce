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
package org.broadleafcommerce.common.email.domain;


public interface EmailTrackingClicks extends java.io.Serializable {
    public abstract java.lang.Long getId();

    public abstract void setId(java.lang.Long id);

    public abstract java.util.Date getDateClicked();

    public abstract void setDateClicked(java.util.Date dateClicked);

    public abstract java.lang.String getDestinationUri();

    public abstract void setDestinationUri(java.lang.String destinationUri);

    public abstract java.lang.String getQueryString();

    public abstract void setQueryString(java.lang.String queryString);

    public abstract org.broadleafcommerce.common.email.domain.EmailTracking getEmailTracking();

    public abstract void setEmailTracking(org.broadleafcommerce.common.email.domain.EmailTracking emailTracking);

    public abstract java.lang.String getCustomerId();

    public abstract void setCustomerId(java.lang.String customerId);
}

