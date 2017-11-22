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
package org.broadleafcommerce.common.sandbox.service;


@org.springframework.stereotype.Service("blSandBoxService")
public class SandBoxServiceImpl implements org.broadleafcommerce.common.sandbox.service.SandBoxService {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.class);

    @javax.annotation.Resource(name = "blSandBoxDao")
    protected org.broadleafcommerce.common.sandbox.dao.SandBoxDao sandBoxDao;

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveSandBoxById(java.lang.Long sandboxId) {
        return sandBoxDao.retrieve(sandboxId);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveAllSandBoxes() {
        return sandBoxDao.retrieveAllSandBoxes();
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesByType(org.broadleafcommerce.common.sandbox.domain.SandBoxType type) {
        return sandBoxDao.retrieveSandBoxesByType(type);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveUserSandBoxForParent(java.lang.Long authorId, java.lang.Long parentSandBoxId) {
        return sandBoxDao.retrieveUserSandBoxForParent(authorId, parentSandBoxId);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveSandBoxManagementById(java.lang.Long sandBoxId) {
        return sandBoxDao.retrieveSandBoxManagementById(sandBoxId);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrievePreviewSandBoxes(java.lang.Long authorId) {
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> returnList = new java.util.ArrayList<org.broadleafcommerce.common.sandbox.domain.SandBox>();
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> authorBoxes = sandBoxDao.retrieveSandBoxesForAuthor(authorId, org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER);
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> approvalBoxes = sandBoxDao.retrieveSandBoxesByType(org.broadleafcommerce.common.sandbox.domain.SandBoxType.APPROVAL);
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> defaultBoxes = sandBoxDao.retrieveSandBoxesByType(org.broadleafcommerce.common.sandbox.domain.SandBoxType.DEFAULT);
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> candidateBoxes = new java.util.ArrayList<org.broadleafcommerce.common.sandbox.domain.SandBox>();
        candidateBoxes.addAll(approvalBoxes);
        candidateBoxes.addAll(defaultBoxes);
        returnList.addAll(authorBoxes);
        for (org.broadleafcommerce.common.sandbox.domain.SandBox cb : candidateBoxes) {
            boolean match = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4759, false);
            for (org.broadleafcommerce.common.sandbox.domain.SandBox authorBox : authorBoxes) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4764, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4760, authorBox.getId().equals(cb.getId()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4763, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4761, ((authorBox.getParentSandBox()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4762, authorBox.getParentSandBox().getId().equals(cb.getId()))))))))) {
                    match = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4765, true);
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4767, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4766, match))))) {
                returnList.add(cb);
            }
        }
        return returnList;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveUserSandBox(java.lang.Long authorId, java.lang.Long overrideSandBoxId, java.lang.String sandBoxName) {
        org.broadleafcommerce.common.sandbox.domain.SandBox userSandbox;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4768, (overrideSandBoxId != null))) {
            userSandbox = retrieveSandBoxById(overrideSandBoxId);
        }else {
            userSandbox = retrieveSandBox(sandBoxName, org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4769, (userSandbox == null))) {
                userSandbox = createSandBox(sandBoxName, org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER);
            }
        }
        return userSandbox;
    }

    @java.lang.Override
    public java.util.Map<java.lang.Long, java.lang.String> retrieveAuthorNamesForSandBoxes(java.util.Set<java.lang.Long> sandBoxIds) {
        return sandBoxDao.retrieveAuthorNamesForSandBoxes(sandBoxIds);
    }

    @java.lang.Override
    public java.util.Map<java.lang.Long, java.lang.String> retrieveSandboxNamesForSandBoxes(java.util.Set<java.lang.Long> sandBoxIds) {
        return sandBoxDao.retrieveSandboxNamesForSandBoxes(sandBoxIds);
    }

    @java.lang.Override
    public synchronized org.broadleafcommerce.common.sandbox.domain.SandBox createSandBox(java.lang.String sandBoxName, org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType) {
        return sandBoxDao.createSandBox(sandBoxName, sandBoxType);
    }

    @java.lang.Override
    public synchronized org.broadleafcommerce.common.sandbox.domain.SandBox createUserSandBox(java.lang.Long authorId, org.broadleafcommerce.common.sandbox.domain.SandBox approvalSandBox) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4770, checkForExistingSandbox(org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER, approvalSandBox.getName(), authorId))) {
            return sandBoxDao.createUserSandBox(authorId, approvalSandBox);
        }
        return sandBoxDao.retrieveNamedSandBox(org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER, approvalSandBox.getName(), authorId);
    }

    @java.lang.Override
    public synchronized org.broadleafcommerce.common.sandbox.domain.SandBox createDefaultSandBox() {
        return sandBoxDao.createDefaultSandBox();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveSandBox(java.lang.String sandBoxName, org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType) {
        return sandBoxDao.retrieveNamedSandBox(sandBoxType, sandBoxName);
    }

    @java.lang.Override
    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveAllUserSandBoxes(java.lang.Long authorId) {
        return sandBoxDao.retrieveAllUserSandBoxes(authorId);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(org.broadleafcommerce.common.util.TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public void archiveChildSandboxes(java.lang.Long parentSandBoxId) {
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> childSandBoxes = retrieveChildSandBoxesByParentId(parentSandBoxId);
        for (org.broadleafcommerce.common.sandbox.domain.SandBox sandbox : childSandBoxes) {
            sandbox.setArchived('Y');
            sandBoxDao.merge(sandbox);
        }
    }

    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveChildSandBoxesByParentId(java.lang.Long parentSandBoxId) {
        return sandBoxDao.retrieveChildSandBoxesByParentId(parentSandBoxId);
    }

    @java.lang.Override
    public boolean checkForExistingApprovalSandboxWithName(java.lang.String sandboxName) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4771, checkForExistingSandbox(org.broadleafcommerce.common.sandbox.domain.SandBoxType.APPROVAL, sandboxName, null));
    }

    @java.lang.Override
    public boolean checkForExistingSandbox(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType, java.lang.String sandboxName, java.lang.Long authorId) {
        org.broadleafcommerce.common.sandbox.domain.SandBox sb = sandBoxDao.retrieveNamedSandBox(sandBoxType, sandboxName, authorId);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4772, (sb == null));
    }

    public static perturbation.location.PerturbationLocation __L4759;

    public static perturbation.location.PerturbationLocation __L4760;

    public static perturbation.location.PerturbationLocation __L4761;

    public static perturbation.location.PerturbationLocation __L4762;

    public static perturbation.location.PerturbationLocation __L4763;

    public static perturbation.location.PerturbationLocation __L4764;

    public static perturbation.location.PerturbationLocation __L4765;

    public static perturbation.location.PerturbationLocation __L4766;

    public static perturbation.location.PerturbationLocation __L4767;

    public static perturbation.location.PerturbationLocation __L4768;

    public static perturbation.location.PerturbationLocation __L4769;

    public static perturbation.location.PerturbationLocation __L4770;

    public static perturbation.location.PerturbationLocation __L4771;

    public static perturbation.location.PerturbationLocation __L4772;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:83)", 4759, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:85)", 4760, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:86)", 4761, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:86)", 4762, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:86)", 4763, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:85)", 4764, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:87)", 4765, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:90)", 4766, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:90)", 4767, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:101)", 4768, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:105)", 4769, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:130)", 4770, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:169)", 4771, "Boolean");
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.__L4772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/service/SandBoxServiceImpl.java:175)", 4772, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sandbox.service.SandBoxServiceImpl.initPerturbationLocation0();
    }
}

