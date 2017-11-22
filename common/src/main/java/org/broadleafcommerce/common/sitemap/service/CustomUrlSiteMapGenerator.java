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


@org.springframework.stereotype.Component("blCustomSiteMapGenerator")
public class CustomUrlSiteMapGenerator implements org.broadleafcommerce.common.sitemap.service.SiteMapGenerator {
    public boolean canHandleSiteMapConfiguration(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration siteMapGeneratorConfiguration) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5488, org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType.CUSTOM.equals(siteMapGeneratorConfiguration.getSiteMapGeneratorType()));
    }

    @java.lang.Override
    public void addSiteMapEntries(org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration smgc, org.broadleafcommerce.common.sitemap.service.SiteMapBuilder siteMapBuilder) {
        for (org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry urlEntry : ((org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfiguration) (smgc)).getCustomURLEntries()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5489, org.apache.commons.lang3.StringUtils.isEmpty(urlEntry.getLocation()))) {
                continue;
            }
            org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper siteMapUrl = new org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper();
            siteMapUrl.setLoc(generateUri(siteMapBuilder, urlEntry));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5490, ((urlEntry.getSiteMapChangeFreq()) != null))) {
                siteMapUrl.setChangeFreqType(urlEntry.getSiteMapChangeFreq());
            }else {
                siteMapUrl.setChangeFreqType(smgc.getSiteMapChangeFreq());
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5491, ((urlEntry.getSiteMapPriority()) != null))) {
                siteMapUrl.setPriorityType(urlEntry.getSiteMapPriority());
            }else {
                siteMapUrl.setPriorityType(smgc.getSiteMapPriority());
            }
            siteMapUrl.setLastModDate(generateDate(urlEntry));
            siteMapBuilder.addUrl(siteMapUrl);
        }
    }

    protected java.lang.String generateUri(org.broadleafcommerce.common.sitemap.service.SiteMapBuilder smb, org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry urlEntry) {
        java.lang.String url = urlEntry.getLocation();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5492, url.contains("://"))) {
            return url;
        }else {
            return org.broadleafcommerce.common.file.service.BroadleafFileUtils.appendUnixPaths(smb.getBaseUrl(), url);
        }
    }

    protected java.util.Date generateDate(org.broadleafcommerce.common.sitemap.domain.SiteMapUrlEntry urlEntry) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5493, ((urlEntry.getLastMod()) != null))) {
            return urlEntry.getLastMod();
        }else {
            return new java.util.Date();
        }
    }

    public static perturbation.location.PerturbationLocation __L5488;

    public static perturbation.location.PerturbationLocation __L5489;

    public static perturbation.location.PerturbationLocation __L5490;

    public static perturbation.location.PerturbationLocation __L5491;

    public static perturbation.location.PerturbationLocation __L5492;

    public static perturbation.location.PerturbationLocation __L5493;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/CustomUrlSiteMapGenerator.java:50)", 5488, "Boolean");
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/CustomUrlSiteMapGenerator.java:56)", 5489, "Boolean");
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/CustomUrlSiteMapGenerator.java:65)", 5490, "Boolean");
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/CustomUrlSiteMapGenerator.java:72)", 5491, "Boolean");
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/CustomUrlSiteMapGenerator.java:87)", 5492, "Boolean");
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.__L5493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sitemap/service/CustomUrlSiteMapGenerator.java:95)", 5493, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sitemap.service.CustomUrlSiteMapGenerator.initPerturbationLocation0();
    }
}

