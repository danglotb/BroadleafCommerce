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
package org.broadleafcommerce.common.resource.service;


public interface ResourceBundlingService {
    public org.springframework.core.io.Resource rebuildBundledResource(java.lang.String requestedBundleName);

    public java.lang.String resolveBundleResourceName(java.lang.String requestedBundleName, java.lang.String mappingPrefix, java.util.List<java.lang.String> files);

    org.springframework.core.io.Resource resolveBundleResource(java.lang.String versionedBundleResourceName);

    java.util.List<java.lang.String> getAdditionalBundleFiles(java.lang.String bundleName);

    boolean checkForRegisteredBundleFile(java.lang.String versionedBundleName);
}

