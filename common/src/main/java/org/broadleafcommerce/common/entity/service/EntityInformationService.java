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


public interface EntityInformationService {
    org.broadleafcommerce.common.entity.dto.EntityInformationDto buildEntityInformationForObject(java.lang.Object o);

    java.lang.Long getBaseProfileIdForSite(org.broadleafcommerce.common.site.domain.Site site);

    java.util.Set<java.lang.Long> getChildSiteIdsForProfile(org.broadleafcommerce.common.site.domain.Site profile);

    org.broadleafcommerce.common.site.domain.Site getParentSiteForProfile(org.broadleafcommerce.common.site.domain.Site profile);

    boolean getOkayToUseSiteDiscriminator(java.lang.Object o);

    java.util.List<org.broadleafcommerce.common.site.domain.Catalog> findAllCatalogs();

    java.lang.Long getDefaultCatalogIdForSite(org.broadleafcommerce.common.site.domain.Site site);
}

