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
package org.broadleafcommerce.common.dao;


@org.springframework.stereotype.Repository("blGenericEntityDao")
public class GenericEntityDaoImpl implements org.broadleafcommerce.common.dao.GenericEntityDao , org.springframework.context.ApplicationContextAware {
    private static org.springframework.context.ApplicationContext applicationContext;

    private static org.broadleafcommerce.common.dao.GenericEntityDaoImpl dao;

    @javax.persistence.PersistenceContext(unitName = "blPU")
    protected javax.persistence.EntityManager em;

    @javax.annotation.Resource(name = "blEntityConfiguration")
    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    @javax.annotation.Resource(name = "blStreamingTransactionCapableUtil")
    protected org.broadleafcommerce.common.util.StreamingTransactionCapableUtil transactionUtil;

    protected org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl daoHelper = new org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl();

    public static org.broadleafcommerce.common.dao.GenericEntityDaoImpl getGenericEntityDao() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L732, ((org.broadleafcommerce.common.dao.GenericEntityDaoImpl.applicationContext) == null))) {
            return null;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L733, ((org.broadleafcommerce.common.dao.GenericEntityDaoImpl.dao) == null))) {
            org.broadleafcommerce.common.dao.GenericEntityDaoImpl.dao = ((org.broadleafcommerce.common.dao.GenericEntityDaoImpl) (org.broadleafcommerce.common.dao.GenericEntityDaoImpl.applicationContext.getBean("blGenericEntityDao")));
        }
        return org.broadleafcommerce.common.dao.GenericEntityDaoImpl.dao;
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        this.applicationContext = applicationContext;
    }

    @java.lang.Override
    public <T> T readGenericEntity(java.lang.Class<T> clazz, java.lang.Object id) {
        clazz = ((java.lang.Class<T>) (org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz)));
        java.util.Map<java.lang.String, java.lang.Object> md = daoHelper.getIdMetadata(clazz, ((org.hibernate.ejb.HibernateEntityManager) (em)));
        org.hibernate.type.AbstractSingleColumnStandardBasicType type = ((org.hibernate.type.AbstractSingleColumnStandardBasicType) (md.get("type")));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L734, (type instanceof org.hibernate.type.LongType))) {
            id = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L735, java.lang.Long.parseLong(java.lang.String.valueOf(id)));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L736, (type instanceof org.hibernate.type.IntegerType))) {
                id = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L737, java.lang.Integer.parseInt(java.lang.String.valueOf(id)));
            }

        return em.find(clazz, id);
    }

    @java.lang.Override
    public <T> java.lang.Long readCountGenericEntity(java.lang.Class<T> clazz) {
        clazz = ((java.lang.Class<T>) (org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz)));
        javax.persistence.TypedQuery<java.lang.Long> q = new org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T>(clazz, "root").toCountQuery(em);
        return q.getSingleResult();
    }

    @java.lang.Override
    public <T> java.util.List<T> readAllGenericEntity(java.lang.Class<T> clazz, int limit, int offset) {
        clazz = ((java.lang.Class<T>) (org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz)));
        javax.persistence.TypedQuery<T> q = new org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T>(clazz, "root").toQuery(em);
        q.setMaxResults(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L738, limit));
        q.setFirstResult(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L739, offset));
        return q.getResultList();
    }

    @java.lang.Override
    public <T> java.util.List<T> readAllGenericEntity(java.lang.Class<T> clazz) {
        clazz = ((java.lang.Class<T>) (org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz)));
        javax.persistence.TypedQuery<T> q = new org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T>(clazz, "root").toQuery(em);
        return q.getResultList();
    }

    @java.lang.Override
    public java.util.List<java.lang.Long> readAllGenericEntityId(java.lang.Class<?> clazz) {
        clazz = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz);
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<java.lang.Long> criteria = builder.createQuery(java.lang.Long.class);
        javax.persistence.criteria.Root root = criteria.from(clazz);
        criteria.select(root.get(getIdField(clazz).getName()).as(java.lang.Long.class));
        criteria.orderBy(builder.asc(root.get(getIdField(clazz).getName())));
        return em.createQuery(criteria).getResultList();
    }

    @java.lang.Override
    public java.lang.Class<?> getImplClass(java.lang.String className) {
        java.lang.Class<?> clazz = null;
        try {
            clazz = entityConfiguration.lookupEntityClass(className);
        } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException e) {
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L740, (clazz == null))) {
            clazz = getCeilingImplClass(className);
        }
        return clazz;
    }

    @java.lang.Override
    public java.lang.Class<?> getCeilingImplClass(final java.lang.String className) {
        final java.lang.Class<?>[] clazz = new java.lang.Class<?>[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L741, 1)];
        try {
            clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L742, 0)] = java.lang.Class.forName(className);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
        transactionUtil.runOptionalTransactionalOperation(new org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter() {
            @java.lang.Override
            public void execute() throws java.lang.Throwable {
                java.lang.Class<?>[] entitiesFromCeiling = daoHelper.getAllPolymorphicEntitiesFromCeiling(clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L743, 0)], em.unwrap(org.hibernate.Session.class).getSessionFactory(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L744, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L745, true));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L750, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L746, (entitiesFromCeiling == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L749, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L747, entitiesFromCeiling.length)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L748, 1)))))))) {
                    clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L751, 0)] = org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl.getNonProxyImplementationClassIfNecessary(clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L752, 0)]);
                    entitiesFromCeiling = daoHelper.getAllPolymorphicEntitiesFromCeiling(clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L753, 0)], em.unwrap(org.hibernate.Session.class).getSessionFactory(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L754, true), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L755, true));
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L760, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L756, (entitiesFromCeiling == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L759, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L757, entitiesFromCeiling.length)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L758, 1)))))))) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Unable to find ceiling implementation for the requested class name (%s)", className));
                }
                clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L761, 0)] = entitiesFromCeiling[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L764, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L762, entitiesFromCeiling.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L763, 1))))];
            }
        }, java.lang.RuntimeException.class, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L766, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L765, org.broadleafcommerce.common.util.TransactionUtils.isTransactionalEntityManager(em))))));
        return clazz[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L767, 0)];
    }

    @java.lang.Override
    public java.io.Serializable getIdentifier(java.lang.Object entity) {
        return daoHelper.getIdentifier(entity, em);
    }

    protected java.lang.reflect.Field getIdField(java.lang.Class<?> clazz) {
        return daoHelper.getIdField(clazz, em);
    }

    @java.lang.Override
    public <T> T save(T object) {
        return em.merge(object);
    }

    @java.lang.Override
    public void persist(java.lang.Object object) {
        em.persist(object);
    }

    @java.lang.Override
    public void remove(java.lang.Object object) {
        em.remove(object);
    }

    @java.lang.Override
    public void flush() {
        em.flush();
    }

    @java.lang.Override
    public void clearAutoFlushMode() {
        em.unwrap(org.hibernate.Session.class).setFlushMode(org.hibernate.FlushMode.MANUAL);
    }

    @java.lang.Override
    public void enableAutoFlushMode() {
        em.unwrap(org.hibernate.Session.class).setFlushMode(org.hibernate.FlushMode.AUTO);
    }

    @java.lang.Override
    public void clear() {
        em.clear();
    }

    @java.lang.Override
    public boolean sessionContains(java.lang.Object object) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L768, em.contains(object));
    }

    @java.lang.Override
    public boolean idAssigned(java.lang.Object object) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L769, ((getIdentifier(object)) != null));
    }

    @java.lang.Override
    public javax.persistence.EntityManager getEntityManager() {
        return em;
    }

    public static perturbation.location.PerturbationLocation __L732;

    public static perturbation.location.PerturbationLocation __L733;

    public static perturbation.location.PerturbationLocation __L734;

    public static perturbation.location.PerturbationLocation __L735;

    public static perturbation.location.PerturbationLocation __L736;

    public static perturbation.location.PerturbationLocation __L737;

    public static perturbation.location.PerturbationLocation __L738;

    public static perturbation.location.PerturbationLocation __L739;

    public static perturbation.location.PerturbationLocation __L740;

    public static perturbation.location.PerturbationLocation __L741;

    public static perturbation.location.PerturbationLocation __L742;

    public static perturbation.location.PerturbationLocation __L743;

    public static perturbation.location.PerturbationLocation __L744;

    public static perturbation.location.PerturbationLocation __L745;

    public static perturbation.location.PerturbationLocation __L746;

    public static perturbation.location.PerturbationLocation __L747;

    public static perturbation.location.PerturbationLocation __L748;

    public static perturbation.location.PerturbationLocation __L749;

    public static perturbation.location.PerturbationLocation __L750;

    public static perturbation.location.PerturbationLocation __L751;

    public static perturbation.location.PerturbationLocation __L752;

    public static perturbation.location.PerturbationLocation __L753;

    public static perturbation.location.PerturbationLocation __L754;

    public static perturbation.location.PerturbationLocation __L755;

    public static perturbation.location.PerturbationLocation __L756;

    public static perturbation.location.PerturbationLocation __L757;

    public static perturbation.location.PerturbationLocation __L758;

    public static perturbation.location.PerturbationLocation __L759;

    public static perturbation.location.PerturbationLocation __L760;

    public static perturbation.location.PerturbationLocation __L761;

    public static perturbation.location.PerturbationLocation __L762;

    public static perturbation.location.PerturbationLocation __L763;

    public static perturbation.location.PerturbationLocation __L764;

    public static perturbation.location.PerturbationLocation __L765;

    public static perturbation.location.PerturbationLocation __L766;

    public static perturbation.location.PerturbationLocation __L767;

    public static perturbation.location.PerturbationLocation __L768;

    public static perturbation.location.PerturbationLocation __L769;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:61)", 732, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:64)", 733, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:92)", 734, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:93)", 735, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:94)", 736, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:95)", 737, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:112)", 738, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:113)", 739, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:144)", 740, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:152)", 741, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:154)", 742, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:162)", 743, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:162)", 744, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:162)", 745, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:163)", 746, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:163)", 747, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:163)", 748, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:163)", 749, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:163)", 750, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:164)", 751, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:164)", 752, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:165)", 753, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:165)", 754, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:165)", 755, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:167)", 756, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:167)", 757, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:167)", 758, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:167)", 759, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:167)", 760, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:170)", 761, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:170)", 762, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:170)", 763, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:170)", 764, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:172)", 765, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:172)", 766, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:173)", 767, "Numerical");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:222)", 768, "Boolean");
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.__L769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dao/GenericEntityDaoImpl.java:227)", 769, "Boolean");
    }

    static {
        org.broadleafcommerce.common.dao.GenericEntityDaoImpl.initPerturbationLocation0();
    }
}

