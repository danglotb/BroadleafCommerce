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
package org.broadleafcommerce.common.sandbox.domain;


public interface SandBox extends java.io.Serializable , org.broadleafcommerce.common.persistence.Status {
    java.lang.Long getId();

    void setId(java.lang.Long id);

    java.lang.String getName();

    void setName(java.lang.String name);

    org.broadleafcommerce.common.sandbox.domain.SandBoxType getSandBoxType();

    void setSandBoxType(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType);

    java.lang.Long getAuthor();

    void setAuthor(java.lang.Long author);

    org.broadleafcommerce.common.sandbox.domain.SandBox getParentSandBox();

    void setParentSandBox(org.broadleafcommerce.common.sandbox.domain.SandBox parentSandBox);

    java.lang.String getColor();

    void setColor(java.lang.String color);

    java.util.Date getGoLiveDate();

    void setGoLiveDate(java.util.Date goLiveDate);

    java.util.List<java.lang.Long> getSandBoxIdsForUpwardHierarchy(boolean includeInherited);

    java.util.List<java.lang.Long> getSandBoxIdsForUpwardHierarchy(boolean includeInherited, boolean includeCurrent);

    java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> getChildSandBoxes();

    void setChildSandBoxes(java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> childSandBoxes);

    public boolean getIsInDefaultHierarchy();

    public void setArchived(java.lang.Character archived);

    public java.lang.Character getArchived();

    public boolean isActive();
}

