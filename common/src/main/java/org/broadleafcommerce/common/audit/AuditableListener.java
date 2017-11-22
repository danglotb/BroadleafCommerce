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
package org.broadleafcommerce.common.audit;


public class AuditableListener extends org.broadleafcommerce.common.audit.AbstractAuditableListener {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.audit.AuditableListener.class);

    @javax.persistence.PrePersist
    @java.lang.Override
    public void setAuditCreationAndUpdateData(java.lang.Object entity) throws java.lang.Exception {
        setAuditCreationData(entity, new org.broadleafcommerce.common.audit.Auditable());
        setAuditUpdateData(entity, new org.broadleafcommerce.common.audit.Auditable());
    }

    @javax.persistence.PreUpdate
    @java.lang.Override
    public void setAuditUpdateData(java.lang.Object entity) throws java.lang.Exception {
        setAuditUpdateData(entity, new org.broadleafcommerce.common.audit.Auditable());
    }

    @java.lang.Override
    protected void setAuditValueAgent(java.lang.reflect.Field field, java.lang.Object entity) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L69, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L67, ((context != null) && (context.getAdmin())))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L68, ((context.getAdminUserId()) != null)))))) {
                field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L70, true));
                field.set(entity, context.getAdminUserId());
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L73, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L71, (context != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L72, ((context.getWebRequest()) != null)))))) {
                    java.lang.Long customerId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.audit.AuditableListener.__L74, ((long) (0L)));
                    java.lang.Object customer = org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver().getCustomer();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L75, (customer != null))) {
                        java.lang.Class<?> customerClass = customer.getClass();
                        java.lang.reflect.Field userNameField = org.broadleafcommerce.common.util.BLCFieldUtils.getSingleField(customerClass, "username");
                        userNameField.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L76, true));
                        java.lang.String username = ((java.lang.String) (userNameField.get(customer)));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L77, (username != null))) {
                            java.lang.reflect.Field idField = org.broadleafcommerce.common.util.BLCFieldUtils.getSingleField(customerClass, "id");
                            idField.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L78, true));
                            customerId = ((java.lang.Long) (idField.get(customer)));
                        }
                    }
                    field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AuditableListener.__L79, true));
                    field.set(entity, customerId);
                }

        } catch (java.lang.Exception e) {
            org.broadleafcommerce.common.audit.AuditableListener.LOG.error("Error setting audit field.", e);
        }
    }

    public static perturbation.location.PerturbationLocation __L67;

    public static perturbation.location.PerturbationLocation __L68;

    public static perturbation.location.PerturbationLocation __L69;

    public static perturbation.location.PerturbationLocation __L70;

    public static perturbation.location.PerturbationLocation __L71;

    public static perturbation.location.PerturbationLocation __L72;

    public static perturbation.location.PerturbationLocation __L73;

    public static perturbation.location.PerturbationLocation __L74;

    public static perturbation.location.PerturbationLocation __L75;

    public static perturbation.location.PerturbationLocation __L76;

    public static perturbation.location.PerturbationLocation __L77;

    public static perturbation.location.PerturbationLocation __L78;

    public static perturbation.location.PerturbationLocation __L79;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.audit.AuditableListener.__L67 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:52)", 67, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L68 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:52)", 68, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L69 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:52)", 69, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L70 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:53)", 70, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L71 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:55)", 71, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L72 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:55)", 72, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L73 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:55)", 73, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L74 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:56)", 74, "Numerical");
        org.broadleafcommerce.common.audit.AuditableListener.__L75 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:59)", 75, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L76 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:62)", 76, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L77 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:64)", 77, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L78 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:67)", 78, "Boolean");
        org.broadleafcommerce.common.audit.AuditableListener.__L79 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AuditableListener.java:72)", 79, "Boolean");
    }

    static {
        org.broadleafcommerce.common.audit.AuditableListener.initPerturbationLocation0();
    }
}

