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
package org.broadleafcommerce.common.persistence;


public class IdOverrideTableGenerator extends org.hibernate.id.enhanced.TableGenerator {
    public static final java.lang.String ENTITY_NAME_PARAM = "entity_name";

    public static final java.lang.String DEFAULT_TABLE_NAME = "SEQUENCE_GENERATOR";

    public static final java.lang.String DEFAULT_SEGMENT_COLUMN_NAME = "ID_NAME";

    public static final java.lang.String DEFAULT_VALUE_COLUMN_NAME = "ID_VAL";

    public static final int DEFAULT_INCREMENT_SIZE = 50;

    private static final java.util.Map<java.lang.String, java.lang.reflect.Field> FIELD_CACHE = org.apache.commons.collections.MapUtils.synchronizedMap(new java.util.HashMap<java.lang.String, java.lang.reflect.Field>());

    private java.lang.String entityName;

    private java.lang.reflect.Field getIdField(java.lang.Class<?> clazz) {
        java.lang.reflect.Field response = null;
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        for (java.lang.reflect.Field field : fields) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4352, ((field.getAnnotation(javax.persistence.Id.class)) != null))) {
                response = field;
                break;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4355, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4353, (response == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4354, ((clazz.getSuperclass()) != null)))))) {
            response = getIdField(clazz.getSuperclass());
        }
        return response;
    }

    @java.lang.Override
    public java.io.Serializable generate(org.hibernate.engine.spi.SessionImplementor session, java.lang.Object obj) {
        java.lang.String objName = obj.getClass().getName();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4357, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4356, org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.FIELD_CACHE.containsKey(objName)))))) {
            java.lang.reflect.Field field = getIdField(obj.getClass());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4358, (field == null))) {
                throw new java.lang.IllegalArgumentException((("Cannot specify IdOverrideTableGenerator for an entity (" + objName) + ") that does not have an Id field declared using the @Id annotation."));
            }
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4359, true));
            org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.FIELD_CACHE.put(objName, field);
        }
        java.lang.reflect.Field field = org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.FIELD_CACHE.get(objName);
        final java.io.Serializable id;
        try {
            id = ((java.io.Serializable) (field.get(obj)));
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4360, (id != null))) {
            return id;
        }
        return super.generate(session, obj);
    }

    @java.lang.Override
    public void configure(org.hibernate.type.Type type, java.util.Properties params, org.hibernate.dialect.Dialect dialect) throws org.hibernate.MappingException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4361, ((params.get("table_name")) == null))) {
            params.put("table_name", "SEQUENCE_GENERATOR");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4362, ((params.get("segment_column_name")) == null))) {
            params.put("segment_column_name", org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.DEFAULT_SEGMENT_COLUMN_NAME);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4363, ((params.get("value_column_name")) == null))) {
            params.put("value_column_name", org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.DEFAULT_VALUE_COLUMN_NAME);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4364, ((params.get("increment_size")) == null))) {
            params.put("increment_size", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4365, org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.DEFAULT_INCREMENT_SIZE));
        }
        super.configure(type, params, dialect);
        entityName = ((java.lang.String) (params.get(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.ENTITY_NAME_PARAM)));
    }

    public java.lang.String getEntityName() {
        return entityName;
    }

    public void setEntityName(java.lang.String entityName) {
        this.entityName = entityName;
    }

    public static perturbation.location.PerturbationLocation __L4352;

    public static perturbation.location.PerturbationLocation __L4353;

    public static perturbation.location.PerturbationLocation __L4354;

    public static perturbation.location.PerturbationLocation __L4355;

    public static perturbation.location.PerturbationLocation __L4356;

    public static perturbation.location.PerturbationLocation __L4357;

    public static perturbation.location.PerturbationLocation __L4358;

    public static perturbation.location.PerturbationLocation __L4359;

    public static perturbation.location.PerturbationLocation __L4360;

    public static perturbation.location.PerturbationLocation __L4361;

    public static perturbation.location.PerturbationLocation __L4362;

    public static perturbation.location.PerturbationLocation __L4363;

    public static perturbation.location.PerturbationLocation __L4364;

    public static perturbation.location.PerturbationLocation __L4365;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:56)", 4352, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:61)", 4353, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:61)", 4354, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:61)", 4355, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:77)", 4356, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:77)", 4357, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:79)", 4358, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:82)", 4359, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:92)", 4360, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:100)", 4361, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:104)", 4362, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:108)", 4363, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:112)", 4364, "Boolean");
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.__L4365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/IdOverrideTableGenerator.java:113)", 4365, "Numerical");
    }

    static {
        org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.initPerturbationLocation0();
    }
}

