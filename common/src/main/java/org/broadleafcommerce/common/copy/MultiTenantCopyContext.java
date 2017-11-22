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


public class MultiTenantCopyContext {
    public static final java.lang.String[] BROADLEAF_PACKAGE_PREFIXES = new java.lang.String[]{ "org.broadleafcommerce", "com.broadleafcommerce" };

    protected org.broadleafcommerce.common.site.domain.Catalog fromCatalog;

    protected org.broadleafcommerce.common.site.domain.Catalog toCatalog;

    protected org.broadleafcommerce.common.site.domain.Site fromSite;

    protected org.broadleafcommerce.common.site.domain.Site toSite;

    protected org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager extensionManager;

    protected com.google.common.collect.BiMap<java.lang.Integer, java.lang.String> currentEquivalentMap = com.google.common.collect.HashBiMap.create();

    protected java.util.Map<java.lang.Integer, java.lang.Object> currentCloneMap = new java.util.HashMap<java.lang.Integer, java.lang.Object>();

    protected java.util.Map<java.lang.String, java.util.Map<java.lang.Object, java.lang.Object>> equivalentsMap;

    protected org.broadleafcommerce.common.service.GenericEntityService genericEntityService;

    protected java.util.List<org.broadleafcommerce.common.copy.DeferredOperation> deferredOperations = new java.util.ArrayList<org.broadleafcommerce.common.copy.DeferredOperation>();

    public MultiTenantCopyContext(org.broadleafcommerce.common.site.domain.Catalog fromCatalog, org.broadleafcommerce.common.site.domain.Catalog toCatalog, org.broadleafcommerce.common.site.domain.Site fromSite, org.broadleafcommerce.common.site.domain.Site toSite, org.broadleafcommerce.common.service.GenericEntityService genericEntityService, org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager extensionManager) {
        equivalentsMap = new java.util.HashMap<java.lang.String, java.util.Map<java.lang.Object, java.lang.Object>>();
        this.fromCatalog = fromCatalog;
        this.toCatalog = toCatalog;
        this.fromSite = fromSite;
        this.toSite = toSite;
        this.genericEntityService = genericEntityService;
        this.extensionManager = extensionManager;
    }

    public <T> T getClonedVersion(final java.lang.Class<T> clazz, final java.lang.Object originalId) {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(new org.broadleafcommerce.common.util.tenant.IdentityOperation<T, java.lang.RuntimeException>() {
            @java.lang.Override
            @java.lang.SuppressWarnings("unchecked")
            public T execute() {
                java.lang.Object cloneId = getEquivalentId(clazz.getName(), originalId);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L611, (cloneId == null))) {
                    return null;
                }
                return ((T) (genericEntityService.readGenericEntity(clazz.getName(), cloneId)));
            }
        }, getToSite(), getToSite(), getToCatalog());
    }

    public java.lang.Object getEquivalentId(java.lang.String className, java.lang.Object fromId) {
        java.lang.String ceilingImpl = genericEntityService.getCeilingImplClass(className).getName();
        java.util.Map<java.lang.Object, java.lang.Object> keys = equivalentsMap.get(ceilingImpl);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L612, (keys == null)) ? null : keys.get(fromId);
    }

    public void storeEquivalentMapping(java.lang.String className, java.lang.Object fromId, java.lang.Object toId) {
        java.lang.String ceilingImpl = genericEntityService.getCeilingImplClass(className).getName();
        java.util.Map<java.lang.Object, java.lang.Object> keys = equivalentsMap.get(ceilingImpl);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L613, (keys == null))) {
            keys = new java.util.HashMap<java.lang.Object, java.lang.Object>();
            equivalentsMap.put(ceilingImpl, keys);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L614, keys.containsKey(fromId))) {
            throw new java.lang.IllegalArgumentException((((("Object [" + className) + ":") + fromId) + "] has already been cloned."));
        }
        keys.put(fromId, toId);
    }

    public java.lang.Long getIdentifier(java.lang.Object entity) {
        return ((java.lang.Long) (genericEntityService.getIdentifier(entity)));
    }

    public org.broadleafcommerce.common.site.domain.Catalog getFromCatalog() {
        return fromCatalog;
    }

    public org.broadleafcommerce.common.site.domain.Catalog getToCatalog() {
        return toCatalog;
    }

    public org.broadleafcommerce.common.site.domain.Site getFromSite() {
        return fromSite;
    }

    public org.broadleafcommerce.common.site.domain.Site getToSite() {
        return toSite;
    }

    public <G> org.broadleafcommerce.common.copy.CreateResponse<G> createOrRetrieveCopyInstance(java.lang.Object instance) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse;
        org.broadleafcommerce.common.web.BroadleafRequestContext context = setupContext();
        validateOriginal(instance);
        java.lang.Class<?> instanceClass = instance.getClass();
        createResponse = handleEmbedded(instanceClass);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L615, (createResponse == null))) {
            createResponse = handleStandardEntity(instance, context, instanceClass);
        }
        tearDownContext(context);
        return createResponse;
    }

    public void clearOriginalIdentifiers() {
        currentEquivalentMap.clear();
        currentCloneMap.clear();
    }

    public java.lang.Object removeOriginalIdentifier(java.lang.Object copy) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L617, currentEquivalentMap.containsKey(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L616, java.lang.System.identityHashCode(copy))))) {
            currentCloneMap.remove(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L618, java.lang.System.identityHashCode(copy)));
            java.lang.String valKey = currentEquivalentMap.remove(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L619, java.lang.System.identityHashCode(copy)));
            return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L624, java.lang.Long.parseLong(valKey.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L622, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L620, valKey.indexOf("_"))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L621, 1)))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L623, valKey.length()))));
        }
        return null;
    }

    public java.lang.reflect.Field[] getAllFields(java.lang.Class<?> targetClass) {
        java.lang.reflect.Field[] allFields = new java.lang.reflect.Field[]{  };
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L625, false);
        java.lang.Class<?> currentClass = targetClass;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L627, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L626, eof))))) {
            java.lang.reflect.Field[] fields = currentClass.getDeclaredFields();
            allFields = ((java.lang.reflect.Field[]) (org.apache.commons.lang.ArrayUtils.addAll(allFields, fields)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L628, ((currentClass.getSuperclass()) != null))) {
                currentClass = currentClass.getSuperclass();
            }else {
                eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L629, true);
            }
        } 
        return allFields;
    }

    public java.lang.Object getPreviousClone(java.lang.Class<?> instanceClass, java.lang.Long originalId) {
        java.lang.Object previousClone;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L630, currentEquivalentMap.inverse().containsKey((((instanceClass.getName()) + "_") + originalId)))) {
            previousClone = currentCloneMap.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L631, currentEquivalentMap.inverse().get((((instanceClass.getName()) + "_") + originalId))));
        }else {
            previousClone = getClonedVersion(instanceClass, originalId);
        }
        return previousClone;
    }

    public void addDeferredOperation(org.broadleafcommerce.common.copy.DeferredOperation operation) {
        deferredOperations.add(operation);
    }

    public void addDeferredOperations(java.util.List<org.broadleafcommerce.common.copy.DeferredOperation> operations) {
        deferredOperations.addAll(operations);
    }

    public java.util.List<org.broadleafcommerce.common.copy.DeferredOperation> getDeferredOperations() {
        return deferredOperations;
    }

    protected boolean checkCloneStatus(java.lang.Object instance) {
        boolean shouldClone = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L632, true);
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean> shouldCloneHolder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.Boolean>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L633, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultStatusType status = extensionManager.getProxy().shouldClone(this, instance, shouldCloneHolder);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L634, ((org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED) != status))) {
                shouldClone = ((boolean) (shouldCloneHolder.getResult()));
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L635, shouldClone);
    }

    protected void validateOriginal(java.lang.Object instance) throws java.lang.CloneNotSupportedException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L638, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L636, (instance instanceof org.broadleafcommerce.common.persistence.Status))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L637, ('Y' == (((org.broadleafcommerce.common.persistence.Status) (instance)).getArchived()))))))) {
            throw new java.lang.CloneNotSupportedException("Attempting to clone an archived instance");
        }
    }

    protected void tearDownContext(org.broadleafcommerce.common.web.BroadleafRequestContext context) {
        context.setCurrentCatalog(getFromCatalog());
        context.setCurrentProfile(getFromSite());
        context.setSite(getFromSite());
    }

    protected org.broadleafcommerce.common.web.BroadleafRequestContext setupContext() {
        org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        context.setCurrentCatalog(getToCatalog());
        context.setCurrentProfile(getToSite());
        context.setSite(getToSite());
        return context;
    }

    protected <G> G createNewInstance(java.lang.Class<?> instanceClass) {
        G response;
        try {
            response = ((G) (instanceClass.newInstance()));
        } catch (java.lang.InstantiationException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        } catch (java.lang.IllegalAccessException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
        return response;
    }

    protected <G> org.broadleafcommerce.common.copy.CreateResponse<G> handleStandardEntity(java.lang.Object instance, org.broadleafcommerce.common.web.BroadleafRequestContext context, java.lang.Class<?> instanceClass) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse;
        java.lang.Long originalId = getIdentifier(instance);
        java.lang.Object previousClone = getPreviousClone(instanceClass, originalId);
        G response;
        boolean alreadyPopulate;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L639, (previousClone != null))) {
            response = ((G) (previousClone));
            alreadyPopulate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L640, true);
        }else {
            boolean shouldClone = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L641, checkCloneStatus(instance));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L643, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L642, shouldClone))))) {
                response = ((G) (instance));
                alreadyPopulate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L644, true);
            }else {
                alreadyPopulate = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L645, false);
                response = performCopy(instance, instanceClass, originalId);
            }
        }
        createResponse = new org.broadleafcommerce.common.copy.CreateResponse<G>(response, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L646, alreadyPopulate));
        return createResponse;
    }

    protected <G> org.broadleafcommerce.common.copy.CreateResponse<G> handleEmbedded(java.lang.Class<?> instanceClass) {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L647, ((instanceClass.getAnnotation(javax.persistence.Embeddable.class)) != null))) {
            G response = createNewInstance(instanceClass);
            createResponse = new org.broadleafcommerce.common.copy.CreateResponse<G>(response, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L648, false));
        }
        return createResponse;
    }

    protected <G> G performCopy(java.lang.Object instance, java.lang.Class<?> instanceClass, java.lang.Long originalId) throws java.lang.CloneNotSupportedException {
        G response = createNewInstance(instanceClass);
        validateClone(response);
        currentEquivalentMap.put(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L649, java.lang.System.identityHashCode(response)), (((instanceClass.getName()) + "_") + originalId));
        currentCloneMap.put(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L650, java.lang.System.identityHashCode(response)), response);
        try {
            for (java.lang.reflect.Field field : getAllFields(instanceClass)) {
                field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L651, true));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L654, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L652, ((field.getType().getAnnotation(javax.persistence.Embeddable.class)) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L653, org.broadleafcommerce.common.copy.MultiTenantCloneable.class.isAssignableFrom(field.getType())))))) {
                    java.lang.Object embeddable = field.get(instance);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L655, (embeddable != null))) {
                        field.set(response, ((org.broadleafcommerce.common.copy.MultiTenantCloneable) (embeddable)).createOrRetrieveCopyInstance(this).getClone());
                    }
                }
            }
        } catch (java.lang.IllegalAccessException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
        return response;
    }

    protected void validateClone(java.lang.Object cloned) throws java.lang.CloneNotSupportedException {
        java.lang.reflect.Method cloneMethod;
        try {
            cloneMethod = cloned.getClass().getMethod("createOrRetrieveCopyInstance", new java.lang.Class[]{ org.broadleafcommerce.common.copy.MultiTenantCopyContext.class });
        } catch (java.lang.NoSuchMethodException e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
        boolean cloneMethodLocal = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L656, false);
        for (java.lang.String prefix : org.broadleafcommerce.common.copy.MultiTenantCopyContext.BROADLEAF_PACKAGE_PREFIXES) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L657, cloneMethod.getDeclaringClass().getName().startsWith(prefix))) {
                cloneMethodLocal = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L658, true);
                break;
            }
        }
        boolean cloneClassLocal = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L659, false);
        for (java.lang.String prefix : org.broadleafcommerce.common.copy.MultiTenantCopyContext.BROADLEAF_PACKAGE_PREFIXES) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L660, cloned.getClass().getName().startsWith(prefix))) {
                cloneClassLocal = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L661, true);
                break;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L665, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L662, cloneMethodLocal)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L664, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L663, cloneClassLocal)))))))) {
            throw new java.lang.CloneNotSupportedException(((((("The system is attempting to clone " + (cloned.getClass().getName())) + " and has determined the custom extension does not implement clone. This class should implement ") + "clone, and inside first call super.clone() to get back an instance of your class (") + (cloned.getClass().getName())) + "), and then finish populating this instance with your custom fields before passing back the finished object."));
        }
    }

    public static perturbation.location.PerturbationLocation __L611;

    public static perturbation.location.PerturbationLocation __L612;

    public static perturbation.location.PerturbationLocation __L613;

    public static perturbation.location.PerturbationLocation __L614;

    public static perturbation.location.PerturbationLocation __L615;

    public static perturbation.location.PerturbationLocation __L616;

    public static perturbation.location.PerturbationLocation __L617;

    public static perturbation.location.PerturbationLocation __L618;

    public static perturbation.location.PerturbationLocation __L619;

    public static perturbation.location.PerturbationLocation __L620;

    public static perturbation.location.PerturbationLocation __L621;

    public static perturbation.location.PerturbationLocation __L622;

    public static perturbation.location.PerturbationLocation __L623;

    public static perturbation.location.PerturbationLocation __L624;

    public static perturbation.location.PerturbationLocation __L625;

    public static perturbation.location.PerturbationLocation __L626;

    public static perturbation.location.PerturbationLocation __L627;

    public static perturbation.location.PerturbationLocation __L628;

    public static perturbation.location.PerturbationLocation __L629;

    public static perturbation.location.PerturbationLocation __L630;

    public static perturbation.location.PerturbationLocation __L631;

    public static perturbation.location.PerturbationLocation __L632;

    public static perturbation.location.PerturbationLocation __L633;

    public static perturbation.location.PerturbationLocation __L634;

    public static perturbation.location.PerturbationLocation __L635;

    public static perturbation.location.PerturbationLocation __L636;

    public static perturbation.location.PerturbationLocation __L637;

    public static perturbation.location.PerturbationLocation __L638;

    public static perturbation.location.PerturbationLocation __L639;

    public static perturbation.location.PerturbationLocation __L640;

    public static perturbation.location.PerturbationLocation __L641;

    public static perturbation.location.PerturbationLocation __L642;

    public static perturbation.location.PerturbationLocation __L643;

    public static perturbation.location.PerturbationLocation __L644;

    public static perturbation.location.PerturbationLocation __L645;

    public static perturbation.location.PerturbationLocation __L646;

    public static perturbation.location.PerturbationLocation __L647;

    public static perturbation.location.PerturbationLocation __L648;

    public static perturbation.location.PerturbationLocation __L649;

    public static perturbation.location.PerturbationLocation __L650;

    public static perturbation.location.PerturbationLocation __L651;

    public static perturbation.location.PerturbationLocation __L652;

    public static perturbation.location.PerturbationLocation __L653;

    public static perturbation.location.PerturbationLocation __L654;

    public static perturbation.location.PerturbationLocation __L655;

    public static perturbation.location.PerturbationLocation __L656;

    public static perturbation.location.PerturbationLocation __L657;

    public static perturbation.location.PerturbationLocation __L658;

    public static perturbation.location.PerturbationLocation __L659;

    public static perturbation.location.PerturbationLocation __L660;

    public static perturbation.location.PerturbationLocation __L661;

    public static perturbation.location.PerturbationLocation __L662;

    public static perturbation.location.PerturbationLocation __L663;

    public static perturbation.location.PerturbationLocation __L664;

    public static perturbation.location.PerturbationLocation __L665;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:77)", 611, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:90)", 612, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:96)", 613, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:101)", 614, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:142)", 615, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:155)", 616, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:155)", 617, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:156)", 618, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:157)", 619, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:158)", 620, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:158)", 621, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:158)", 622, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:158)", 623, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:158)", 624, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:165)", 625, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:167)", 626, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:167)", 627, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:170)", 628, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:173)", 629, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:182)", 630, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:183)", 631, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:203)", 632, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:205)", 633, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:208)", 634, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:212)", 635, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:216)", 636, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:216)", 637, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:216)", 638, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:253)", 639, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:255)", 640, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:257)", 641, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:258)", 642, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:258)", 643, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:260)", 644, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:262)", 645, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:266)", 646, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:272)", 647, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:274)", 648, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:282)", 649, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:283)", 650, "Numerical");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:286)", 651, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:287)", 652, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:287)", 653, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:287)", 654, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:289)", 655, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:314)", 656, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:316)", 657, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:317)", 658, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:321)", 659, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:323)", 660, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:324)", 661, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:328)", 662, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:328)", 663, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:328)", 664, "Boolean");
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.__L665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/copy/MultiTenantCopyContext.java:328)", 665, "Boolean");
    }

    static {
        org.broadleafcommerce.common.copy.MultiTenantCopyContext.initPerturbationLocation0();
    }
}

