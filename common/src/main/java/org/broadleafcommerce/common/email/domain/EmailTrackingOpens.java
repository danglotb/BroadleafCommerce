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


public interface EmailTrackingOpens extends java.io.Serializable {
    public abstract java.lang.Long getId();

    public abstract void setId(java.lang.Long id);

    public abstract java.util.Date getDateOpened();

    public abstract void setDateOpened(java.util.Date dateOpened);

    public abstract java.lang.String getUserAgent();

    public abstract void setUserAgent(java.lang.String userAgent);

    public abstract org.broadleafcommerce.common.email.domain.EmailTracking getEmailTracking();

    public abstract void setEmailTracking(org.broadleafcommerce.common.email.domain.EmailTracking emailTracking);
}

