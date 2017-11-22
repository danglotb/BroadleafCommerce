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


public abstract class AbstractAuditableListener {
    public abstract void setAuditCreationAndUpdateData(java.lang.Object entity) throws java.lang.Exception;

    public abstract void setAuditUpdateData(java.lang.Object entity) throws java.lang.Exception;

    protected abstract void setAuditValueAgent(java.lang.reflect.Field field, java.lang.Object entity) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException;

    protected void setAuditCreationData(java.lang.Object entity, java.lang.Object auditableObject) throws java.lang.Exception {
        setAuditData(entity, auditableObject, "dateCreated", "createdBy");
    }

    protected void setAuditUpdateData(java.lang.Object entity, java.lang.Object auditableObject) throws java.lang.Exception {
        setAuditData(entity, auditableObject, "dateUpdated", "updatedBy");
    }

    protected void setAuditData(java.lang.Object entity, java.lang.Object auditableObject, java.lang.String dateField, java.lang.String userField) throws java.lang.Exception {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AbstractAuditableListener.__L1, entity.getClass().isAnnotationPresent(javax.persistence.Entity.class))) {
            java.lang.reflect.Field field = org.broadleafcommerce.common.util.BLCFieldUtils.getSingleField(entity.getClass(), getAuditableFieldName());
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AbstractAuditableListener.__L2, true));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AbstractAuditableListener.__L3, field.isAnnotationPresent(javax.persistence.Embedded.class))) {
                java.lang.Object auditable = field.get(entity);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AbstractAuditableListener.__L4, (auditable == null))) {
                    field.set(entity, auditableObject);
                    auditable = field.get(entity);
                }
                java.lang.reflect.Field temporalField = auditable.getClass().getDeclaredField(dateField);
                java.lang.reflect.Field agentField = auditable.getClass().getDeclaredField(userField);
                setAuditValueTemporal(temporalField, auditable);
                setAuditValueAgent(agentField, auditable);
            }
        }
    }

    protected void setAuditValueTemporal(java.lang.reflect.Field field, java.lang.Object entity) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        java.util.Calendar cal = org.broadleafcommerce.common.time.SystemTime.asCalendar();
        field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.AbstractAuditableListener.__L5, true));
        field.set(entity, cal.getTime());
    }

    protected java.lang.String getAuditableFieldName() {
        return "auditable";
    }

    public static perturbation.location.PerturbationLocation __L1;

    public static perturbation.location.PerturbationLocation __L2;

    public static perturbation.location.PerturbationLocation __L3;

    public static perturbation.location.PerturbationLocation __L4;

    public static perturbation.location.PerturbationLocation __L5;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.audit.AbstractAuditableListener.__L1 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AbstractAuditableListener.java:86)", 1, "Boolean");
        org.broadleafcommerce.common.audit.AbstractAuditableListener.__L2 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AbstractAuditableListener.java:88)", 2, "Boolean");
        org.broadleafcommerce.common.audit.AbstractAuditableListener.__L3 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AbstractAuditableListener.java:89)", 3, "Boolean");
        org.broadleafcommerce.common.audit.AbstractAuditableListener.__L4 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AbstractAuditableListener.java:91)", 4, "Boolean");
        org.broadleafcommerce.common.audit.AbstractAuditableListener.__L5 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/AbstractAuditableListener.java:112)", 5, "Boolean");
    }

    static {
        org.broadleafcommerce.common.audit.AbstractAuditableListener.initPerturbationLocation0();
    }
}

