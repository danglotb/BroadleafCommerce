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
package org.broadleafcommerce.common.crossapp.service;


public interface CrossAppAuthService {
    public static java.lang.String AUTH_FROM_ADMIN_URL_PARAM = "blAuthToken";

    public static java.lang.String AUTH_FROM_ADMIN_SESSION_VAR = "blAuthedFromAdmin";

    public void useSiteAuthToken(java.lang.Long adminUserId, java.lang.String token) throws java.lang.IllegalArgumentException;

    public boolean isAuthedFromAdmin();

    public java.lang.Long getCurrentAuthedAdminId();

    public boolean hasCsrPermission();

    boolean hasQuotePermission();
}

