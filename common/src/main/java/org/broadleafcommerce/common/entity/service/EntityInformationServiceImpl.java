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
package org.broadleafcommerce.common.entity.service;


@org.springframework.stereotype.Service("blEntityInformationService")
public class EntityInformationServiceImpl implements org.broadleafcommerce.common.entity.service.EntityInformationService {
    @javax.annotation.Resource(name = "blEntityInformationServiceExtensionManager")
    protected org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager extensionManager;

    public org.broadleafcommerce.common.entity.dto.EntityInformationDto buildEntityInformationForObject(java.lang.Object o) {
        org.broadleafcommerce.common.entity.dto.EntityInformationDto dto = createEntityInformationDto(o);
        extensionManager.updateEntityInformationDto(dto, o);
        return dto;
    }

    @java.lang.Override
    public java.lang.Long getBaseProfileIdForSite(org.broadleafcommerce.common.site.domain.Site site) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long>();
        extensionManager.getBaseProfileIdForSite(site, erh);
        return erh.getResult();
    }

    @java.lang.Override
    public java.util.Set<java.lang.Long> getChildSiteIdsForProfile(org.broadleafcommerce.common.site.domain.Site profile) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.Set<java.lang.Long>> erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder<>();
        extensionManager.getProxy().getChildSiteIdsForProfile(profile, erh);
        return erh.getResult();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.site.domain.Site getParentSiteForProfile(org.broadleafcommerce.common.site.domain.Site profile) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.site.domain.Site> erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.site.domain.Site>();
        extensionManager.getParentSiteForProfile(profile, erh);
        return erh.getResult();
    }

    @java.lang.Override
    public boolean getOkayToUseSiteDiscriminator(java.lang.Object o) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean>();
        erh.setResult(java.lang.Boolean.FALSE);
        extensionManager.getOkayToUseSiteDiscriminator(o, erh);
        return erh.getResult();
    }

    @java.lang.Override
    public java.lang.Long getDefaultCatalogIdForSite(org.broadleafcommerce.common.site.domain.Site site) {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long>();
        extensionManager.getDefaultCatalogIdForSite(site, erh);
        return erh.getResult();
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.site.domain.Catalog> findAllCatalogs() {
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.site.domain.Catalog>> erh = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.site.domain.Catalog>>();
        extensionManager.findAllCatalogs(erh);
        return erh.getResult();
    }

    protected org.broadleafcommerce.common.entity.dto.EntityInformationDto createEntityInformationDto(java.lang.Object o) {
        return new org.broadleafcommerce.common.entity.dto.EntityInformationDto();
    }
}

