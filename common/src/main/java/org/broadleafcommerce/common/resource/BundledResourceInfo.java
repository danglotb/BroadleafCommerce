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
package org.broadleafcommerce.common.resource;


public class BundledResourceInfo {
    protected org.springframework.core.io.Resource resource;

    protected java.lang.String versionedBundleName;

    protected java.util.List<java.lang.String> bundledFilePaths;

    public BundledResourceInfo(org.springframework.core.io.Resource resource, java.lang.String versionedBundleName, java.util.List<java.lang.String> bundledFilePaths) {
        this.resource = resource;
        this.versionedBundleName = versionedBundleName;
        this.bundledFilePaths = bundledFilePaths;
    }

    public org.springframework.core.io.Resource getResource() {
        return resource;
    }

    public void setResource(org.springframework.core.io.Resource resource) {
        this.resource = resource;
    }

    public java.lang.String getVersionedBundleName() {
        return versionedBundleName;
    }

    public void setVersionedBundleName(java.lang.String versionedBundleName) {
        this.versionedBundleName = versionedBundleName;
    }

    public java.util.List<java.lang.String> getBundledFilePaths() {
        return bundledFilePaths;
    }

    public void setBundledFilePaths(java.util.List<java.lang.String> bundledFilePaths) {
        this.bundledFilePaths = bundledFilePaths;
    }
}

