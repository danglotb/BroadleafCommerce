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
package org.broadleafcommerce.common.sitemap.service;


public class SiteMapGenerationResponse {
    private java.lang.String sitemapIndexFileName = "sitemap.xml";

    private java.util.List<java.lang.String> siteMapFilePaths = new java.util.ArrayList<java.lang.String>();

    private boolean hasError = false;

    private java.lang.String errorCode;

    public java.lang.String getSitemapIndexFileName() {
        return sitemapIndexFileName;
    }

    public void setSitemapIndexFileName(java.lang.String sitemapIndexFileName) {
        this.sitemapIndexFileName = sitemapIndexFileName;
    }

    public java.util.List<java.lang.String> getSiteMapFilePaths() {
        return siteMapFilePaths;
    }

    public void setSiteMapFilePaths(java.util.List<java.lang.String> siteMapFilePaths) {
        this.siteMapFilePaths = siteMapFilePaths;
    }

    public boolean isHasError() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse.__L5511, hasError);
    }

    public void setHasError(boolean hasError) {
        this.hasError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse.__L5512, hasError);
    }

    public java.lang.String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }

    public static perturbation.location.PerturbationLocation __L5511;

    public static perturbation.location.PerturbationLocation __L5512;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse.__L5511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapGenerationResponse.java:76)", 5511, "Boolean");
        org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse.__L5512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/SiteMapGenerationResponse.java:85)", 5512, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.SiteMapGenerationResponse.initPerturbationLocation0();
    }
}

