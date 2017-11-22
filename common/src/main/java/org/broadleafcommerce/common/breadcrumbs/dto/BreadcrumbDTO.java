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
package org.broadleafcommerce.common.breadcrumbs.dto;


public class BreadcrumbDTO {
    private java.lang.String text;

    private java.lang.String link;

    private org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType type;

    public java.lang.String getText() {
        return text;
    }

    public void setText(java.lang.String text) {
        this.text = text;
    }

    public java.lang.String getLink() {
        return link;
    }

    public void setLink(java.lang.String link) {
        this.link = link;
    }

    public java.lang.String getType() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO.__L80, ((type) != null))) {
            return type.getType();
        }
        return "";
    }

    public void setType(org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTOType type) {
        this.type = type;
    }

    public static perturbation.location.PerturbationLocation __L80;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO.__L80 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/breadcrumbs/dto/BreadcrumbDTO.java:48)", 80, "Boolean");
    }

    static {
        org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO.initPerturbationLocation0();
    }
}

