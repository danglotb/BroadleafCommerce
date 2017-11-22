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


public interface EntityInformationServiceExtensionHandler extends org.broadleafcommerce.common.extension.ExtensionHandler {
    org.broadleafcommerce.common.extension.ExtensionResultStatusType updateEntityInformationDto(org.broadleafcommerce.common.entity.dto.EntityInformationDto dto, java.lang.Object entityInstance);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getBaseProfileIdForSite(org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> erh);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getChildSiteIdsForProfile(org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.Set<java.lang.Long>> erh);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getParentSiteForProfile(org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.extension.ExtensionResultHolder<org.broadleafcommerce.common.site.domain.Site> erh);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getOkayToUseSiteDiscriminator(java.lang.Object o, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> erh);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType findAllCatalogs(org.broadleafcommerce.common.extension.ExtensionResultHolder<java.util.List<org.broadleafcommerce.common.site.domain.Catalog>> erh);

    org.broadleafcommerce.common.extension.ExtensionResultStatusType getDefaultCatalogIdForSite(org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Long> erh);
}

