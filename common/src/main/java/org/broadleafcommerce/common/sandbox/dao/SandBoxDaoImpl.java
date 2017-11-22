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


@org.springframework.stereotype.Repository("blSandBoxDao")
public class SandBoxDaoImpl implements org.broadleafcommerce.common.sandbox.dao.SandBoxDao {
    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager sandBoxEntityManager;

    @javax.annotation.Resource(name = "blTransactionManager")
    protected org.springframework.orm.jpa.JpaTransactionManager transactionManager;

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieve(java.lang.Long id) {
        return sandBoxEntityManager.find(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.class, id);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveAllSandBoxes() {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        criteria.where(builder.and(builder.or(builder.isNotNull(sandbox.get("sandBox").get("name")), builder.notEqual(sandbox.get("sandBox").get("name").as(java.lang.String.class), "")), builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y'))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        return query.getResultList();
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesByType(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandboxType) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        criteria.where(builder.and(builder.equal(sandbox.get("sandBox").get("sandboxType"), sandboxType.getType()), builder.or(builder.isNotNull(sandbox.get("sandBox").get("name")), builder.notEqual(sandbox.get("sandBox").get("name").as(java.lang.String.class), "")), builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y'))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        return query.getResultList();
    }

    @java.lang.Override
    @java.lang.Deprecated
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveAllUserSandBoxes(java.lang.Long authorId) {
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = new org.broadleafcommerce.common.util.dao.TypedQueryBuilder<org.broadleafcommerce.common.sandbox.domain.SandBox>(org.broadleafcommerce.common.sandbox.domain.SandBox.class, "sb").addRestriction("sb.author", "=", authorId).addRestriction("sb.sandboxType", "=", org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER.getType()).addRestriction("sb.archiveStatus.archived", "==", null).addRestriction("sb.archiveStatus.archived", "!=", "Y").addRestriction("sb.name", "!=", "").toQuery(sandBoxEntityManager);
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox merge(org.broadleafcommerce.common.sandbox.domain.SandBox userSandBox) {
        org.broadleafcommerce.common.sandbox.domain.SandBox response = sandBoxEntityManager.merge(userSandBox);
        sandBoxEntityManager.flush();
        return response;
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveChildSandBoxesByParentId(java.lang.Long parentSandBoxId) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        criteria.where(builder.and(sandbox.get("sandBox").get("parentSandBox").in(parentSandBoxId), builder.or(builder.isNotNull(sandbox.get("sandBox").get("name")), builder.notEqual(sandbox.get("sandBox").get("name").as(java.lang.String.class), "")), builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y'))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveUserSandBoxForParent(java.lang.Long authorId, java.lang.Long parentSandBoxId) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(sandbox.get("sandBox").get("sandboxType"), org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER.getType()));
        restrictions.add(builder.or(builder.equal(sandbox.get("sandBox").get("author"), authorId), builder.isNull(sandbox.get("sandBox").get("author"))));
        restrictions.add(builder.equal(sandbox.get("sandBox").get("parentSandBox").get("id"), parentSandBoxId));
        restrictions.add(builder.or(builder.isNotNull(sandbox.get("sandBox").get("name")), builder.notEqual(sandbox.get("sandBox").get("name").as(java.lang.String.class), "")));
        restrictions.add(builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y')));
        criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4674, restrictions.size())]));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> results = query.getResultList();
        org.broadleafcommerce.common.sandbox.domain.SandBox response;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4679, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4675, (results == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4678, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4676, results.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4677, 0)))))))) {
            response = null;
        }else {
            response = results.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4680, 0));
        }
        return response;
    }

    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveSandBoxManagementById(java.lang.Long sandBoxId) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        criteria.where(builder.and(builder.equal(sandbox.get("sandBox").get("id"), sandBoxId), builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y'))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> results = query.getResultList();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4685, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4681, (results == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4684, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4682, results.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4683, 0)))))))) {
            return null;
        }
        return results.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4686, 0));
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveNamedSandBox(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandboxType, java.lang.String sandboxName) {
        return retrieveNamedSandBox(sandboxType, sandboxName, null);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox retrieveNamedSandBox(org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType, java.lang.String sandboxName, java.lang.Long authorId) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(sandbox.get("sandBox").get("sandboxType"), sandBoxType.getType()));
        restrictions.add(builder.equal(sandbox.get("sandBox").get("name"), sandboxName));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4687, (authorId != null))) {
            restrictions.add(builder.equal(sandbox.get("sandBox").get("author"), authorId));
        }
        restrictions.add(builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y')));
        criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4688, restrictions.size())]));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4693, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4689, ((query.getResultList()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4692, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4690, query.getResultList().size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4691, 1)))))))) {
            return query.getSingleResult();
        }else {
            return null;
        }
    }

    @java.lang.Override
    public java.util.Map<java.lang.Long, java.lang.String> retrieveAuthorNamesForSandBoxes(java.util.Set<java.lang.Long> sandBoxIds) {
        javax.persistence.Query query = sandBoxEntityManager.createQuery(("SELECT sb.sandBox.id, au.name " + (((("FROM org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl sb, " + "org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl au ") + "WHERE sb.sandBox.author = au.id ") + "AND sb.sandBox.id IN :sandBoxIds ") + "AND (sb.sandBox.archiveStatus.archived IS NULL OR sb.sandBox.archiveStatus.archived = 'N')")));
        query.setParameter("sandBoxIds", sandBoxIds);
        java.util.List<java.lang.Object[]> results = query.getResultList();
        java.util.Map<java.lang.Long, java.lang.String> map = new java.util.HashMap<java.lang.Long, java.lang.String>();
        for (java.lang.Object[] result : results) {
            map.put(((java.lang.Long) (result[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4694, 0)])), ((java.lang.String) (result[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4695, 1)])));
        }
        return map;
    }

    @java.lang.Override
    public java.util.Map<java.lang.Long, java.lang.String> retrieveSandboxNamesForSandBoxes(java.util.Set<java.lang.Long> sandBoxIds) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        criteria.where(builder.and(builder.in(sandbox.get("sandBox").get("id")).value(sandBoxIds), builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y'))));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> results = query.getResultList();
        java.util.Map<java.lang.Long, java.lang.String> map = new java.util.HashMap<java.lang.Long, java.lang.String>();
        for (org.broadleafcommerce.common.sandbox.domain.SandBox result : results) {
            map.put(result.getId(), result.getName());
        }
        return map;
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesForAuthor(java.lang.Long authorId) {
        return retrieveSandBoxesForAuthor(authorId, null);
    }

    @java.lang.Override
    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> retrieveSandBoxesForAuthor(java.lang.Long authorId, org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType) {
        javax.persistence.criteria.CriteriaBuilder builder = sandBoxEntityManager.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> criteria = builder.createQuery(org.broadleafcommerce.common.sandbox.domain.SandBox.class);
        javax.persistence.criteria.Root<org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl> sandbox = criteria.from(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);
        criteria.select(sandbox.get("sandBox").as(org.broadleafcommerce.common.sandbox.domain.SandBox.class));
        java.util.List<javax.persistence.criteria.Predicate> restrictions = new java.util.ArrayList<javax.persistence.criteria.Predicate>();
        restrictions.add(builder.equal(sandbox.get("sandBox").get("author"), authorId));
        restrictions.add(builder.or(builder.isNotNull(sandbox.get("sandBox").get("name")), builder.notEqual(sandbox.get("sandBox").get("name").as(java.lang.String.class), "")));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4696, (sandBoxType != null))) {
            restrictions.add(builder.equal(sandbox.get("sandBox").get("sandboxType"), sandBoxType.getType()));
        }
        restrictions.add(builder.or(builder.isNull(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.String.class)), builder.notEqual(sandbox.get("sandBox").get("archiveStatus").get("archived").as(java.lang.Character.class), 'Y')));
        criteria.where(restrictions.toArray(new javax.persistence.criteria.Predicate[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4697, restrictions.size())]));
        javax.persistence.TypedQuery<org.broadleafcommerce.common.sandbox.domain.SandBox> query = sandBoxEntityManager.createQuery(criteria);
        return query.getResultList();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox persist(org.broadleafcommerce.common.sandbox.domain.SandBox entity) {
        sandBoxEntityManager.persist(entity);
        sandBoxEntityManager.flush();
        return entity;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox createSandBox(java.lang.String sandBoxName, org.broadleafcommerce.common.sandbox.domain.SandBoxType sandBoxType) {
        org.springframework.transaction.TransactionStatus status = org.broadleafcommerce.common.util.TransactionUtils.createTransaction("createSandBox", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4698, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRES_NEW), transactionManager);
        try {
            org.broadleafcommerce.common.sandbox.domain.SandBox approvalSandbox = retrieveNamedSandBox(sandBoxType, sandBoxName);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4699, (approvalSandbox == null))) {
                approvalSandbox = new org.broadleafcommerce.common.sandbox.domain.SandBoxImpl();
                approvalSandbox.setName(sandBoxName);
                approvalSandbox.setSandBoxType(sandBoxType);
                approvalSandbox = persist(approvalSandbox);
                org.broadleafcommerce.common.sandbox.domain.SandBoxManagement mgmt = new org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl();
                mgmt.setSandBox(approvalSandbox);
                sandBoxEntityManager.persist(mgmt);
                sandBoxEntityManager.flush();
            }
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4700, false));
            return approvalSandbox;
        } catch (java.lang.Exception ex) {
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4701, true));
            throw new java.lang.RuntimeException(ex);
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox createUserSandBox(java.lang.Long authorId, org.broadleafcommerce.common.sandbox.domain.SandBox approvalSandBox) {
        org.springframework.transaction.TransactionStatus status = org.broadleafcommerce.common.util.TransactionUtils.createTransaction("createSandBox", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4702, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRES_NEW), transactionManager);
        try {
            org.broadleafcommerce.common.sandbox.domain.SandBox userSandBox = new org.broadleafcommerce.common.sandbox.domain.SandBoxImpl();
            userSandBox.setName(approvalSandBox.getName());
            userSandBox.setAuthor(authorId);
            userSandBox.setParentSandBox(approvalSandBox);
            userSandBox.setSandBoxType(org.broadleafcommerce.common.sandbox.domain.SandBoxType.USER);
            userSandBox = persist(userSandBox);
            org.broadleafcommerce.common.sandbox.domain.SandBoxManagement mgmt = new org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl();
            mgmt.setSandBox(userSandBox);
            sandBoxEntityManager.persist(mgmt);
            sandBoxEntityManager.flush();
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4703, false));
            return userSandBox;
        } catch (java.lang.Exception ex) {
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4704, true));
            throw new java.lang.RuntimeException(ex);
        }
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox createDefaultSandBox() {
        org.springframework.transaction.TransactionStatus status = org.broadleafcommerce.common.util.TransactionUtils.createTransaction("createSandBox", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4705, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRES_NEW), transactionManager);
        try {
            org.broadleafcommerce.common.sandbox.domain.SandBox defaultSB = new org.broadleafcommerce.common.sandbox.domain.SandBoxImpl();
            defaultSB.setName("Default");
            defaultSB.setSandBoxType(org.broadleafcommerce.common.sandbox.domain.SandBoxType.DEFAULT);
            defaultSB.setColor("#20C0F0");
            defaultSB = persist(defaultSB);
            org.broadleafcommerce.common.sandbox.domain.SandBoxManagement mgmt = new org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl();
            mgmt.setSandBox(defaultSB);
            sandBoxEntityManager.persist(mgmt);
            sandBoxEntityManager.flush();
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4706, false));
            return defaultSB;
        } catch (java.lang.Exception ex) {
            org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4707, true));
            throw new java.lang.RuntimeException(ex);
        }
    }

    public static perturbation.location.PerturbationLocation __L4674;

    public static perturbation.location.PerturbationLocation __L4675;

    public static perturbation.location.PerturbationLocation __L4676;

    public static perturbation.location.PerturbationLocation __L4677;

    public static perturbation.location.PerturbationLocation __L4678;

    public static perturbation.location.PerturbationLocation __L4679;

    public static perturbation.location.PerturbationLocation __L4680;

    public static perturbation.location.PerturbationLocation __L4681;

    public static perturbation.location.PerturbationLocation __L4682;

    public static perturbation.location.PerturbationLocation __L4683;

    public static perturbation.location.PerturbationLocation __L4684;

    public static perturbation.location.PerturbationLocation __L4685;

    public static perturbation.location.PerturbationLocation __L4686;

    public static perturbation.location.PerturbationLocation __L4687;

    public static perturbation.location.PerturbationLocation __L4688;

    public static perturbation.location.PerturbationLocation __L4689;

    public static perturbation.location.PerturbationLocation __L4690;

    public static perturbation.location.PerturbationLocation __L4691;

    public static perturbation.location.PerturbationLocation __L4692;

    public static perturbation.location.PerturbationLocation __L4693;

    public static perturbation.location.PerturbationLocation __L4694;

    public static perturbation.location.PerturbationLocation __L4695;

    public static perturbation.location.PerturbationLocation __L4696;

    public static perturbation.location.PerturbationLocation __L4697;

    public static perturbation.location.PerturbationLocation __L4698;

    public static perturbation.location.PerturbationLocation __L4699;

    public static perturbation.location.PerturbationLocation __L4700;

    public static perturbation.location.PerturbationLocation __L4701;

    public static perturbation.location.PerturbationLocation __L4702;

    public static perturbation.location.PerturbationLocation __L4703;

    public static perturbation.location.PerturbationLocation __L4704;

    public static perturbation.location.PerturbationLocation __L4705;

    public static perturbation.location.PerturbationLocation __L4706;

    public static perturbation.location.PerturbationLocation __L4707;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:162)", 4674, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:169)", 4675, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:169)", 4676, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:169)", 4677, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:169)", 4678, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:169)", 4679, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:172)", 4680, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:191)", 4681, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:191)", 4682, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:191)", 4683, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:191)", 4684, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:191)", 4685, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:194)", 4686, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:212)", 4687, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:220)", 4688, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:223)", 4689, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:223)", 4690, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:223)", 4691, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:223)", 4692, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:223)", 4693, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:244)", 4694, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:244)", 4695, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:291)", 4696, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:298)", 4697, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:313)", 4698, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:316)", 4699, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:327)", 4700, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:330)", 4701, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:338)", 4702, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:352)", 4703, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:355)", 4704, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:363)", 4705, "Numerical");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:376)", 4706, "Boolean");
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.__L4707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/dao/SandBoxDaoImpl.java:379)", 4707, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sandbox.dao.SandBoxDaoImpl.initPerturbationLocation0();
    }
}

