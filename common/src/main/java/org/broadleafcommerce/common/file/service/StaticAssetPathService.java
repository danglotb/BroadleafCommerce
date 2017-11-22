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
package org.broadleafcommerce.common.file.service;


public interface StaticAssetPathService {
    public java.lang.String convertAllAssetPathsInContent(java.lang.String content, boolean secureRequest);

    public java.lang.String convertAssetPath(java.lang.String assetPath, java.lang.String contextPath, boolean secureRequest);

    public java.lang.String getStaticAssetUrlPrefix();

    public void setStaticAssetUrlPrefix(java.lang.String prefix);

    public java.lang.String getStaticAssetEnvironmentUrlPrefix();

    public void setStaticAssetEnvironmentUrlPrefix(java.lang.String prefix);

    public java.lang.String getStaticAssetEnvironmentSecureUrlPrefix();
}

