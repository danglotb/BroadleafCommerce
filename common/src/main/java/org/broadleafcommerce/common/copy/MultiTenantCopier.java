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
package org.broadleafcommerce.common.copy;


public abstract class MultiTenantCopier implements org.springframework.core.Ordered {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.copy.MultiTenantCopier.class);

    @javax.annotation.Resource(name = "blGenericEntityService")
    protected org.broadleafcommerce.common.service.GenericEntityService genericEntityService;

    @javax.annotation.Resource(name = "blMultiTenantCopierExtensionManager")
    protected org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager extensionManager;

    @javax.annotation.Resource(name = "blStreamingTransactionCapableUtil")
    protected org.broadleafcommerce.common.util.StreamingTransactionCapableUtil transUtil;

    protected int order = 0;

    protected java.util.List<java.util.regex.Matcher> classExcludeRegexList = new java.util.ArrayList<java.util.regex.Matcher>();

    public abstract void copyEntities(org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.Exception;

    @java.lang.Override
    public int getOrder() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L558, order);
    }

    public void setOrder(int order) {
        this.order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L559, order);
    }

    protected <T, G extends java.lang.Exception> void persistCopyObjectTree(org.broadleafcommerce.common.copy.CopyOperation<T, G> copyOperation, java.lang.Class<T> clazz, T original, org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws G {
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L560, ((context.getEquivalentId(clazz.getName(), genericEntityService.getIdentifier(original))) != null))) {
                return ;
            }
            context.clearOriginalIdentifiers();
            genericEntityService.clearAutoFlushMode();
            java.lang.Object copy = copyOperation.execute(original);
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setEnforceEnterpriseCollectionBehaviorState(org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState.FALSE);
            persistCopyObjectTreeInternal(copy, new java.util.HashSet<java.lang.Integer>(), context);
            genericEntityService.flush();
        } catch (java.lang.Exception e) {
            org.broadleafcommerce.common.copy.MultiTenantCopier.LOG.error("Unable to persist the copy object tree", e);
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        } finally {
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setEnforceEnterpriseCollectionBehaviorState(org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState.TRUE);
            context.clearOriginalIdentifiers();
            genericEntityService.enableAutoFlushMode();
        }
    }

    protected void persistCopyObjectTreeInternal(java.lang.Object copy, java.util.Set<java.lang.Integer> library, org.broadleafcommerce.common.copy.MultiTenantCopyContext context) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L565, (((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L562, library.contains(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L561, java.lang.System.identityHashCode(copy))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L564, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L563, (copy instanceof org.broadleafcommerce.common.copy.MultiTenantCloneable))))))) || (excludeFromCopyRegex(copy))))) {
            return ;
        }
        library.add(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L566, java.lang.System.identityHashCode(copy)));
        java.util.List<java.lang.Object[]> collections = new java.util.ArrayList<java.lang.Object[]>();
        java.lang.reflect.Field[] allFields = context.getAllFields(copy.getClass());
        for (java.lang.reflect.Field field : allFields) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L567, field.getName().equals("embeddableSiteDiscriminator"))) {
                continue;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L570, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L569, java.lang.reflect.Modifier.isStatic(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L568, field.getModifiers()))))))) {
                field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L571, true));
                java.lang.Object newTarget;
                try {
                    newTarget = field.get(copy);
                } catch (java.lang.IllegalAccessException e) {
                    throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L572, (newTarget != null))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L575, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L573, ((field.getAnnotation(javax.persistence.ManyToOne.class)) != null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L574, ((field.getAnnotation(javax.persistence.OneToOne.class)) != null)))))) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L577, library.contains(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L576, java.lang.System.identityHashCode(newTarget))))) {
                            persistNode(newTarget, context);
                            continue;
                        }
                        persistCopyObjectTreeInternal(newTarget, library, context);
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L580, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L578, ((field.getAnnotation(javax.persistence.ManyToMany.class)) != null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L579, ((field.getAnnotation(javax.persistence.OneToMany.class)) != null)))))) {
                            collections.add(new java.lang.Object[]{ field, newTarget });
                        }else
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L583, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L581, ((field.getType().getAnnotation(javax.persistence.Embeddable.class)) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L582, org.broadleafcommerce.common.copy.MultiTenantCloneable.class.isAssignableFrom(field.getType())))))) {
                                persistCopyObjectTreeInternal(newTarget, library, context);
                            }


                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L584, ((copy.getClass().getAnnotation(javax.persistence.Embeddable.class)) == null))) {
            persistNode(copy, context);
        }
        for (java.lang.Object[] collectionItem : collections) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L586, ((collectionItem[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L585, 1)]) instanceof java.util.Collection))) {
                java.util.Collection newCollection = ((java.util.Collection) (collectionItem[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L587, 1)]));
                for (java.lang.Object member : newCollection) {
                    persistCopyObjectTreeInternal(member, library, context);
                }
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L589, ((collectionItem[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L588, 1)]) instanceof java.util.Map))) {
                    java.util.Map newMap = ((java.util.Map) (collectionItem[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L590, 1)]));
                    for (java.lang.Object key : newMap.keySet()) {
                        persistCopyObjectTreeInternal(newMap.get(key), library, context);
                    }
                }else {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format(("During copy object persistence, " + ("an unrecognized type was detected for a OneToMany or ManyToMany field. The system currently only " + "recognizes Collection and Map. (%s.%s)")), copy.getClass().getName(), ((java.lang.reflect.Field) (collectionItem[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L591, 0)])).getName()));
                }

        }
    }

    protected java.lang.Boolean excludeFromCopyRegex(java.lang.Object copy) {
        for (java.util.regex.Matcher regex : classExcludeRegexList) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L592, regex.reset(copy.getClass().toString()).matches())) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L593, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L594, false);
    }

    protected void persistNode(final java.lang.Object copy, final org.broadleafcommerce.common.copy.MultiTenantCopyContext context) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L599, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L596, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L595, genericEntityService.sessionContains(copy)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L598, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L597, genericEntityService.idAssigned(copy))))))))) {
            final java.lang.Object original = genericEntityService.readGenericEntity(copy.getClass().getName(), context.removeOriginalIdentifier(copy));
            extensionManager.getProxy().transformCopy(context, original, copy);
            extensionManager.getProxy().prepareForSave(context, original, copy);
            org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(new org.broadleafcommerce.common.util.tenant.IdentityOperation<java.lang.Void, java.lang.RuntimeException>() {
                @java.lang.Override
                public java.lang.Void execute() {
                    genericEntityService.persist(copy);
                    extensionManager.getProxy().postSave(context, original, copy);
                    return null;
                }
            }, context.getToSite(), context.getToSite(), context.getToCatalog());
            context.storeEquivalentMapping(original.getClass().getName(), context.getIdentifier(original), context.getIdentifier(copy));
        }
    }

    protected <T extends org.broadleafcommerce.common.copy.MultiTenantCloneable> void copyEntitiesOfType(final java.lang.Class<T> clazz, final org.broadleafcommerce.common.site.domain.Site fromSite, final org.broadleafcommerce.common.site.domain.Catalog fromCatalog, final org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.CloneNotSupportedException, org.broadleafcommerce.common.exception.ServiceException {
        genericEntityService.flush();
        genericEntityService.clear();
        transUtil.runStreamingTransactionalOperation(new org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter() {
            @java.lang.Override
            public java.lang.Object[] retrievePage(int startPos, int pageSize) {
                try {
                    java.lang.Object[] temp = new java.lang.Object[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L600, 1)];
                    java.util.List<T> results = readAll(clazz, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L601, pageSize), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L602, startPos), fromSite, fromCatalog);
                    temp[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L603, 0)] = results;
                    return temp;
                } catch (org.broadleafcommerce.common.exception.ServiceException e) {
                    throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
                }
            }

            @java.lang.Override
            public void pagedExecute(java.lang.Object[] param) throws java.lang.Throwable {
                try {
                    java.util.List<T> results = ((java.util.List<T>) (param[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L604, 0)]));
                    for (T result : results) {
                        persistCopyObjectTree(new org.broadleafcommerce.common.copy.CopyOperation<T, java.lang.CloneNotSupportedException>() {
                            @java.lang.Override
                            public T execute(T original) throws java.lang.CloneNotSupportedException {
                                return ((T) (original.createOrRetrieveCopyInstance(context).getClone()));
                            }
                        }, clazz, result, context);
                    }
                } finally {
                    genericEntityService.clear();
                }
            }

            @java.lang.Override
            public java.lang.Long retrieveTotalCount() {
                try {
                    return readCount(clazz, fromSite, fromCatalog);
                } catch (org.broadleafcommerce.common.exception.ServiceException e) {
                    throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
                }
            }

            @java.lang.Override
            public boolean shouldRetryOnTransactionLockAcquisitionFailure() {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopier.__L605, true);
            }
        }, java.lang.RuntimeException.class);
    }

    protected <T> T save(org.broadleafcommerce.common.copy.MultiTenantCopyContext context, final T object) throws org.broadleafcommerce.common.exception.ServiceException {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(new org.broadleafcommerce.common.util.tenant.IdentityOperation<T, org.broadleafcommerce.common.exception.ServiceException>() {
            @java.lang.Override
            public T execute() throws org.broadleafcommerce.common.exception.ServiceException {
                return genericEntityService.save(object);
            }
        }, context.getToSite(), context.getToSite(), context.getToCatalog());
    }

    protected <T> java.lang.Long readCount(final java.lang.Class<T> clazz, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Catalog catalog) throws org.broadleafcommerce.common.exception.ServiceException {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(new org.broadleafcommerce.common.util.tenant.IdentityOperation<java.lang.Long, org.broadleafcommerce.common.exception.ServiceException>() {
            @java.lang.Override
            public java.lang.Long execute() throws org.broadleafcommerce.common.exception.ServiceException {
                return genericEntityService.readCountGenericEntity(clazz);
            }
        }, site, site, catalog);
    }

    protected <T> java.util.List<T> readAll(java.lang.Class<T> clazz, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Catalog catalog) throws org.broadleafcommerce.common.exception.ServiceException {
        return readAll(clazz, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L606, java.lang.Integer.MAX_VALUE), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L607, 0), site, catalog);
    }

    protected java.util.List<java.lang.Long> readAllIds(final java.lang.Class<?> clazz, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Catalog catalog) throws org.broadleafcommerce.common.exception.ServiceException {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(new org.broadleafcommerce.common.util.tenant.IdentityOperation<java.util.List<java.lang.Long>, org.broadleafcommerce.common.exception.ServiceException>() {
            @java.lang.Override
            public java.util.List<java.lang.Long> execute() throws org.broadleafcommerce.common.exception.ServiceException {
                return genericEntityService.readAllGenericEntityId(clazz);
            }
        }, site, site, catalog);
    }

    protected <T> java.util.List<T> readAll(final java.lang.Class<T> clazz, final int limit, final int offset, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Catalog catalog) throws org.broadleafcommerce.common.exception.ServiceException {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(new org.broadleafcommerce.common.util.tenant.IdentityOperation<java.util.List<T>, org.broadleafcommerce.common.exception.ServiceException>() {
            @java.lang.Override
            public java.util.List<T> execute() throws org.broadleafcommerce.common.exception.ServiceException {
                return genericEntityService.readAllGenericEntity(clazz, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L608, limit), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopier.__L609, offset));
            }
        }, site, site, catalog);
    }

    public static perturbation.location.PerturbationLocation __L558;

    public static perturbation.location.PerturbationLocation __L559;

    public static perturbation.location.PerturbationLocation __L560;

    public static perturbation.location.PerturbationLocation __L561;

    public static perturbation.location.PerturbationLocation __L562;

    public static perturbation.location.PerturbationLocation __L563;

    public static perturbation.location.PerturbationLocation __L564;

    public static perturbation.location.PerturbationLocation __L565;

    public static perturbation.location.PerturbationLocation __L566;

    public static perturbation.location.PerturbationLocation __L567;

    public static perturbation.location.PerturbationLocation __L568;

    public static perturbation.location.PerturbationLocation __L569;

    public static perturbation.location.PerturbationLocation __L570;

    public static perturbation.location.PerturbationLocation __L571;

    public static perturbation.location.PerturbationLocation __L572;

    public static perturbation.location.PerturbationLocation __L573;

    public static perturbation.location.PerturbationLocation __L574;

    public static perturbation.location.PerturbationLocation __L575;

    public static perturbation.location.PerturbationLocation __L576;

    public static perturbation.location.PerturbationLocation __L577;

    public static perturbation.location.PerturbationLocation __L578;

    public static perturbation.location.PerturbationLocation __L579;

    public static perturbation.location.PerturbationLocation __L580;

    public static perturbation.location.PerturbationLocation __L581;

    public static perturbation.location.PerturbationLocation __L582;

    public static perturbation.location.PerturbationLocation __L583;

    public static perturbation.location.PerturbationLocation __L584;

    public static perturbation.location.PerturbationLocation __L585;

    public static perturbation.location.PerturbationLocation __L586;

    public static perturbation.location.PerturbationLocation __L587;

    public static perturbation.location.PerturbationLocation __L588;

    public static perturbation.location.PerturbationLocation __L589;

    public static perturbation.location.PerturbationLocation __L590;

    public static perturbation.location.PerturbationLocation __L591;

    public static perturbation.location.PerturbationLocation __L592;

    public static perturbation.location.PerturbationLocation __L593;

    public static perturbation.location.PerturbationLocation __L594;

    public static perturbation.location.PerturbationLocation __L595;

    public static perturbation.location.PerturbationLocation __L596;

    public static perturbation.location.PerturbationLocation __L597;

    public static perturbation.location.PerturbationLocation __L598;

    public static perturbation.location.PerturbationLocation __L599;

    public static perturbation.location.PerturbationLocation __L600;

    public static perturbation.location.PerturbationLocation __L601;

    public static perturbation.location.PerturbationLocation __L602;

    public static perturbation.location.PerturbationLocation __L603;

    public static perturbation.location.PerturbationLocation __L604;

    public static perturbation.location.PerturbationLocation __L605;

    public static perturbation.location.PerturbationLocation __L606;

    public static perturbation.location.PerturbationLocation __L607;

    public static perturbation.location.PerturbationLocation __L608;

    public static perturbation.location.PerturbationLocation __L609;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:91)", 558, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:95)", 559, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:101)", 560, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:122)", 561, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:122)", 562, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:122)", 563, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:122)", 564, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:122)", 565, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:126)", 566, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:130)", 567, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:133)", 568, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:133)", 569, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:133)", 570, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:134)", 571, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:141)", 572, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:142)", 573, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:142)", 574, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:142)", 575, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:143)", 576, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:143)", 577, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:148)", 578, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:148)", 579, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:148)", 580, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:150)", 581, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:150)", 582, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:150)", 583, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:156)", 584, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:160)", 585, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:160)", 586, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:161)", 587, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:165)", 588, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:165)", 589, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:166)", 590, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:173)", 591, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:180)", 592, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:181)", 593, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:184)", 594, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:188)", 595, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:188)", 596, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:188)", 597, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:188)", 598, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:188)", 599, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:225)", 600, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:226)", 601, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:226)", 602, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:227)", 603, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:237)", 604, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:262)", 605, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:312)", 606, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:312)", 607, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:350)", 608, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopier.__L609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopier.java:350)", 609, "Numerical");
    }

    static {
        org.broadleafcommerce.common.copy.MultiTenantCopier.initPerturbationLocation0();
    }
}

