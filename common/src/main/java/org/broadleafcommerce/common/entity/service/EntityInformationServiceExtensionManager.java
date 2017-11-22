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


@org.springframework.stereotype.Service("blEntityInformationServiceExtensionManager")
public class EntityInformationServiceExtensionManager extends org.broadleafcommerce.common.extension.ExtensionManager<org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler> implements org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler {
    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation getDefaultCatalogIdForSite = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).getDefaultCatalogIdForSite(((org.broadleafcommerce.common.site.domain.Site) (params[0])), ((org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long>) (params[1])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation updateEntityInformationDto = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).updateEntityInformationDto(((org.broadleafcommerce.common.entity.dto.EntityInformationDto) (params[0])), params[1]);
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation getBaseProfileIdForSite = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).getBaseProfileIdForSite(((org.broadleafcommerce.common.site.domain.Site) (params[0])), ((org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long>) (params[1])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation getParentSiteForProfile = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).getParentSiteForProfile(((org.broadleafcommerce.common.site.domain.Site) (params[0])), ((org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.site.domain.Site>) (params[1])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation getOkayToUseSiteDiscriminator = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).getOkayToUseSiteDiscriminator(params[0], ((org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean>) (params[1])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation findAllCatalogs = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).findAllCatalogs(((org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.site.domain.Catalog>>) (params[0])));
        }
    };

    public static final org.broadleafcommerce.common.extension.ExtensionManagerOperation getChildSiteIdsForProfile = new org.broadleafcommerce.common.extension.ExtensionManagerOperation() {
        @java.lang.Override
        public org.broadleafcommerce.common.extension.ExtensionResultStatusType execute(org.broadleafcommerce.common.extension.ExtensionHandler handler, java.lang.Object... params) {
            return ((org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler) (handler)).getChildSiteIdsForProfile(((org.broadleafcommerce.common.site.domain.Site) (params[0])), ((org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.Set<java.lang.Long>>) (params[1])));
        }
    };

    public EntityInformationServiceExtensionManager() {
        super(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionHandler.class);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType updateEntityInformationDto(org.broadleafcommerce.common.entity.dto.EntityInformationDto dto, java.lang.Object entityInstance) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.updateEntityInformationDto, dto, entityInstance);
    }

    @java.lang.Override
    public boolean isEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.__L1222, true);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getBaseProfileIdForSite(org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> erh) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.getBaseProfileIdForSite, site, erh);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getParentSiteForProfile(org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.site.domain.Site> erh) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.getParentSiteForProfile, profile, erh);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getOkayToUseSiteDiscriminator(java.lang.Object o, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> erh) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator, o, erh);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType findAllCatalogs(org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.site.domain.Catalog>> erh) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.findAllCatalogs, erh);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getDefaultCatalogIdForSite(org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> erh) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite, site, erh);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.extension.ExtensionResultStatusType getChildSiteIdsForProfile(org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.Set<java.lang.Long>> erh) {
        return execute(org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.getChildSiteIdsForProfile, profile, erh);
    }

    public static perturbation.location.PerturbationLocation __L1222;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.__L1222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/entity/service/EntityInformationServiceExtensionManager.java:101)", 1222, "Boolean");
    }

    static {
        org.broadleafcommerce.common.entity.service.EntityInformationServiceExtensionManager.initPerturbationLocation0();
    }
}

