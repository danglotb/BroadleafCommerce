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
package org.broadleafcommerce.common.entity.dto;


public class EntityInformationDto {
    private java.lang.Long profileId;

    private java.lang.Long catalogId;

    private java.lang.Long owningSiteId;

    private java.lang.Long catalogOwner;

    private java.lang.Boolean isOwnerToCatalogRelationshipActive;

    public java.lang.Long getProfileId() {
        return profileId;
    }

    public void setProfileId(java.lang.Long profileId) {
        this.profileId = profileId;
    }

    public java.lang.Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(java.lang.Long catalogId) {
        this.catalogId = catalogId;
    }

    public java.lang.Long getOwningSiteId() {
        return owningSiteId;
    }

    public void setOwningSiteId(java.lang.Long owningSiteId) {
        this.owningSiteId = owningSiteId;
    }

    public boolean isProfileEntity() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.entity.dto.EntityInformationDto.__L1220, ((getProfileId()) != null));
    }

    public boolean isCatalogEntity() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.entity.dto.EntityInformationDto.__L1221, ((getCatalogId()) != null));
    }

    public java.lang.Long getCatalogOwner() {
        return catalogOwner;
    }

    public void setCatalogOwner(java.lang.Long catalogOwner) {
        this.catalogOwner = catalogOwner;
    }

    public java.lang.Boolean getOwnerToCatalogRelationshipActive() {
        return isOwnerToCatalogRelationshipActive;
    }

    public void setOwnerToCatalogRelationshipActive(java.lang.Boolean ownerToCatalogRelationshipActive) {
        isOwnerToCatalogRelationshipActive = ownerToCatalogRelationshipActive;
    }

    public static perturbation.location.PerturbationLocation __L1220;

    public static perturbation.location.PerturbationLocation __L1221;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.entity.dto.EntityInformationDto.__L1220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/entity/dto/EntityInformationDto.java:106)", 1220, "Boolean");
        org.broadleafcommerce.common.entity.dto.EntityInformationDto.__L1221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/entity/dto/EntityInformationDto.java:114)", 1221, "Boolean");
    }

    static {
        org.broadleafcommerce.common.entity.dto.EntityInformationDto.initPerturbationLocation0();
    }
}

