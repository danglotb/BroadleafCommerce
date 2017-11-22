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


public interface BroadleafFileService {
    public org.broadleafcommerce.common.file.domain.FileWorkArea initializeWorkArea();

    void closeWorkArea(org.broadleafcommerce.common.file.domain.FileWorkArea workArea);

    java.io.File getResource(java.lang.String name);

    java.io.File getResource(java.lang.String name, java.lang.Long timeout);

    java.io.File getLocalResource(java.lang.String fullUrl);

    java.io.File getSharedLocalResource(java.lang.String fullUrl);

    boolean checkForResourceOnClassPath(java.lang.String name);

    java.io.InputStream getClasspathResource(java.lang.String name);

    boolean removeResource(java.lang.String name);

    @java.lang.Deprecated
    void addOrUpdateResource(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.io.File file, boolean removeFilesFromWorkArea);

    java.lang.String addOrUpdateResourceForPath(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.io.File file, boolean removeFilesFromWorkArea);

    @java.lang.Deprecated
    void addOrUpdateResources(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, boolean removeFilesFromWorkArea);

    java.util.List<java.lang.String> addOrUpdateResourcesForPaths(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, boolean removeFilesFromWorkArea);

    @java.lang.Deprecated
    void addOrUpdateResources(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> files, boolean removeFilesFromWorkArea);

    java.util.List<java.lang.String> addOrUpdateResourcesForPaths(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> files, boolean removeFilesFromWorkArea);
}

