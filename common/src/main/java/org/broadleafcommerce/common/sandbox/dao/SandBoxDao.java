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
package org.broadleafcommerce.common.sandbox.dao;


public interface SandBoxDao {
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieve(java.lang.Long id);

    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveAllSandBoxes();

    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesByType(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandboxType);

    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesForAuthor(java.lang.Long authorId);

    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveUserSandBoxForParent(java.lang.Long authorId, java.lang.Long parentSandBoxId);

    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveSandBoxManagementById(java.lang.Long sandBoxId);

    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveNamedSandBox(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandboxType, java.lang.String sandboxName);

    public java.util.Map<java.lang.Long, java.lang.String> retrieveAuthorNamesForSandBoxes(java.util.Set<java.lang.Long> sandBoxIds);

    public java.util.Map<java.lang.Long, java.lang.String> retrieveSandboxNamesForSandBoxes(java.util.Set<java.lang.Long> sandBoxIds);

    java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesForAuthor(java.lang.Long authorId, org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType);

    public org.broadleafcommerce.common.sandbox.domain.SandBox persist(org.broadleafcommerce.common.sandbox.domain.SandBox entity);

    public org.broadleafcommerce.common.sandbox.domain.SandBox createSandBox(java.lang.String sandBoxName, org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType);

    public org.broadleafcommerce.common.sandbox.domain.SandBox createUserSandBox(java.lang.Long authorId, org.broadleafcommerce.common.sandbox.domain.SandBox approvalSandBox);

    public org.broadleafcommerce.common.sandbox.domain.SandBox createDefaultSandBox();

    @java.lang.Deprecated
    java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveAllUserSandBoxes(java.lang.Long authorId);

    org.broadleafcommerce.common.sandbox.domain.SandBox merge(org.broadleafcommerce.common.sandbox.domain.SandBox userSandBox);

    java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveChildSandBoxesByParentId(java.lang.Long parentSandBoxId);

    org.broadleafcommerce.common.sandbox.domain.SandBox retrieveNamedSandBox(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType, java.lang.String sandboxName, java.lang.Long authorId);
}

