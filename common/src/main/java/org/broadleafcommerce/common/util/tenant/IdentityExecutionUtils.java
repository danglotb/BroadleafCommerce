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
package org.broadleafcommerce.common.util.tenant;


public class IdentityExecutionUtils {
    private static class TransactionContainer {
        org.springframework.transaction.TransactionStatus status;

        java.util.Map<java.lang.Object, java.lang.Object> usedResources;

        private TransactionContainer(org.springframework.transaction.TransactionStatus status, java.util.Map<java.lang.Object, java.lang.Object> usedResources) {
            this.status = status;
            this.usedResources = usedResources;
        }

        public org.springframework.transaction.TransactionStatus getStatus() {
            return status;
        }

        public void setStatus(org.springframework.transaction.TransactionStatus status) {
            this.status = status;
        }

        public java.util.Map<java.lang.Object, java.lang.Object> getUsedResources() {
            return usedResources;
        }

        public void setUsedResources(java.util.Map<java.lang.Object, java.lang.Object> usedResources) {
            this.usedResources = usedResources;
        }
    }

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.class);

    public static <T, G extends java.lang.Throwable> T runOperationByIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.site.domain.Catalog catalog, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G {
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext context = new org.broadleafcommerce.common.util.tenant.IdentityUtilContext();
        context.setIdentifier(site);
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext.setUtilContext(context);
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        org.broadleafcommerce.common.site.domain.Site previousSite = brc.getSite();
        org.broadleafcommerce.common.site.domain.Catalog previousCatalog = brc.getCurrentCatalog();
        org.broadleafcommerce.common.site.domain.Site previousProfile = brc.getCurrentProfile();
        boolean isNew = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6036, org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.initRequestContext(site, profile, catalog));
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.activateSession();
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.TransactionContainer container = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6037, (transactionManager != null))) {
            container = org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.establishTransaction(transactionManager);
        }
        boolean isError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6038, false);
        try {
            return operation.execute();
        } catch (java.lang.RuntimeException e) {
            isError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6039, true);
            throw e;
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6040, (container != null))) {
                org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.finalizeTransaction(transactionManager, container, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6041, isError));
            }
            org.broadleafcommerce.common.util.tenant.IdentityUtilContext.setUtilContext(null);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6042, isNew)) {
                org.broadleafcommerce.common.web.BroadleafRequestContext.setBroadleafRequestContext(null);
            }
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setSite(previousSite);
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setCurrentCatalog(previousCatalog);
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setCurrentProfile(previousProfile);
        }
    }

    public static <T, G extends java.lang.Throwable> T runOperationByIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Catalog catalog) throws G {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(operation, site, null, catalog, null);
    }

    public static <T, G extends java.lang.Throwable> T runOperationByIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.site.domain.Catalog catalog) throws G {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, catalog, null);
    }

    public static <T, G extends java.lang.Throwable> T runOperationByIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation, org.broadleafcommerce.common.site.domain.Site site) throws G {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(operation, site, null, null, null);
    }

    public static <T, G extends java.lang.Throwable> T runOperationByIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation, org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Site profile) throws G {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationByIdentifier(operation, site, profile, null);
    }

    public static <T, G extends java.lang.Throwable> T runOperationAndIgnoreIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation) throws G {
        return org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.runOperationAndIgnoreIdentifier(operation, null);
    }

    public static <T, G extends java.lang.Throwable> T runOperationAndIgnoreIdentifier(org.broadleafcommerce.common.util.tenant.IdentityOperation<T, G> operation, org.springframework.transaction.PlatformTransactionManager transactionManager) throws G {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        org.broadleafcommerce.common.site.domain.Site previousSite = brc.getSite();
        org.broadleafcommerce.common.site.domain.Catalog previousCatalog = brc.getCurrentCatalog();
        org.broadleafcommerce.common.site.domain.Site previousProfile = brc.getCurrentProfile();
        boolean isNew = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6043, org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.initRequestContext(null, null, null));
        boolean isIgnoringSite = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getIgnoreSite();
        org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setIgnoreSite(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6044, true));
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.activateSession();
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.TransactionContainer container = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6045, (transactionManager != null))) {
            container = org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.establishTransaction(transactionManager);
        }
        boolean isError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6046, false);
        try {
            return operation.execute();
        } catch (java.lang.RuntimeException e) {
            isError = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6047, true);
            throw e;
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6048, (container != null))) {
                org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.finalizeTransaction(transactionManager, container, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6049, isError));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6050, isNew)) {
                org.broadleafcommerce.common.web.BroadleafRequestContext.setBroadleafRequestContext(null);
            }
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setIgnoreSite(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6051, isIgnoringSite));
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setSite(previousSite);
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setCurrentCatalog(previousCatalog);
            org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().setCurrentProfile(previousProfile);
        }
    }

    private static boolean initRequestContext(org.broadleafcommerce.common.site.domain.Site site, org.broadleafcommerce.common.site.domain.Site profile, org.broadleafcommerce.common.site.domain.Catalog catalog) {
        boolean isNew = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6052, false);
        org.broadleafcommerce.common.web.BroadleafRequestContext requestContext = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6053, (requestContext == null))) {
            requestContext = new org.broadleafcommerce.common.web.BroadleafRequestContext();
            org.broadleafcommerce.common.web.BroadleafRequestContext.setBroadleafRequestContext(requestContext);
            isNew = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6054, true);
        }
        requestContext.setSite(site);
        requestContext.setCurrentCatalog(catalog);
        requestContext.setCurrentProfile(profile);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6055, (site != null))) {
            requestContext.setIgnoreSite(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6056, false));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6057, isNew);
    }

    private static void activateSession() {
        java.util.Map<java.lang.Object, java.lang.Object> resourceMap = org.springframework.transaction.support.TransactionSynchronizationManager.getResourceMap();
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : resourceMap.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6060, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6058, ((entry.getKey()) instanceof javax.persistence.EntityManagerFactory))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6059, ((entry.getValue()) instanceof org.springframework.orm.jpa.EntityManagerHolder)))))) {
                ((org.hibernate.ejb.HibernateEntityManager) (((org.springframework.orm.jpa.EntityManagerHolder) (entry.getValue())).getEntityManager())).getSession();
            }
        }
    }

    private static void finalizeTransaction(org.springframework.transaction.PlatformTransactionManager transactionManager, org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.TransactionContainer container, boolean error) {
        org.broadleafcommerce.common.util.TransactionUtils.finalizeTransaction(container.status, transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6061, error));
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : container.usedResources.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6063, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6062, org.springframework.transaction.support.TransactionSynchronizationManager.hasResource(entry.getKey())))))) {
                org.springframework.transaction.support.TransactionSynchronizationManager.bindResource(entry.getKey(), entry.getValue());
            }
        }
    }

    private static org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.TransactionContainer establishTransaction(org.springframework.transaction.PlatformTransactionManager transactionManager) {
        java.util.Map<java.lang.Object, java.lang.Object> usedResources = new java.util.HashMap<java.lang.Object, java.lang.Object>();
        java.util.Map<java.lang.Object, java.lang.Object> resources = org.springframework.transaction.support.TransactionSynchronizationManager.getResourceMap();
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : resources.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6068, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6066, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6064, ((entry.getKey()) instanceof javax.persistence.EntityManagerFactory))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6065, ((entry.getKey()) instanceof javax.sql.DataSource)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6067, org.springframework.transaction.support.TransactionSynchronizationManager.hasResource(entry.getKey())))))) {
                usedResources.put(entry.getKey(), entry.getValue());
            }
        }
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : usedResources.entrySet()) {
            org.springframework.transaction.support.TransactionSynchronizationManager.unbindResource(entry.getKey());
        }
        org.springframework.transaction.TransactionStatus status;
        try {
            status = org.broadleafcommerce.common.util.TransactionUtils.createTransaction(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6069, org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRES_NEW), transactionManager, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6070, false));
        } catch (java.lang.RuntimeException e) {
            throw e;
        }
        return new org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.TransactionContainer(status, usedResources);
    }

    public static perturbation.location.PerturbationLocation __L6036;

    public static perturbation.location.PerturbationLocation __L6037;

    public static perturbation.location.PerturbationLocation __L6038;

    public static perturbation.location.PerturbationLocation __L6039;

    public static perturbation.location.PerturbationLocation __L6040;

    public static perturbation.location.PerturbationLocation __L6041;

    public static perturbation.location.PerturbationLocation __L6042;

    public static perturbation.location.PerturbationLocation __L6043;

    public static perturbation.location.PerturbationLocation __L6044;

    public static perturbation.location.PerturbationLocation __L6045;

    public static perturbation.location.PerturbationLocation __L6046;

    public static perturbation.location.PerturbationLocation __L6047;

    public static perturbation.location.PerturbationLocation __L6048;

    public static perturbation.location.PerturbationLocation __L6049;

    public static perturbation.location.PerturbationLocation __L6050;

    public static perturbation.location.PerturbationLocation __L6051;

    public static perturbation.location.PerturbationLocation __L6052;

    public static perturbation.location.PerturbationLocation __L6053;

    public static perturbation.location.PerturbationLocation __L6054;

    public static perturbation.location.PerturbationLocation __L6055;

    public static perturbation.location.PerturbationLocation __L6056;

    public static perturbation.location.PerturbationLocation __L6057;

    public static perturbation.location.PerturbationLocation __L6058;

    public static perturbation.location.PerturbationLocation __L6059;

    public static perturbation.location.PerturbationLocation __L6060;

    public static perturbation.location.PerturbationLocation __L6061;

    public static perturbation.location.PerturbationLocation __L6062;

    public static perturbation.location.PerturbationLocation __L6063;

    public static perturbation.location.PerturbationLocation __L6064;

    public static perturbation.location.PerturbationLocation __L6065;

    public static perturbation.location.PerturbationLocation __L6066;

    public static perturbation.location.PerturbationLocation __L6067;

    public static perturbation.location.PerturbationLocation __L6068;

    public static perturbation.location.PerturbationLocation __L6069;

    public static perturbation.location.PerturbationLocation __L6070;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:60)", 6036, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:65)", 6037, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:69)", 6038, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:73)", 6039, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6040 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:76)", 6040, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6041 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:77)", 6041, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6042 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:80)", 6042, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:116)", 6043, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:118)", 6044, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:123)", 6045, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:126)", 6046, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:130)", 6047, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:133)", 6048, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:134)", 6049, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:137)", 6050, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:140)", 6051, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:148)", 6052, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:151)", 6053, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:154)", 6054, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:161)", 6055, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:162)", 6056, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:165)", 6057, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:171)", 6058, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:171)", 6059, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:171)", 6060, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:179)", 6061, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:181)", 6062, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:181)", 6063, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:191)", 6064, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:191)", 6065, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:191)", 6066, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:192)", 6067, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:191)", 6068, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:202)", 6069, "Numerical");
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.__L6070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityExecutionUtils.java:203)", 6070, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.tenant.IdentityExecutionUtils.initPerturbationLocation0();
    }
}

