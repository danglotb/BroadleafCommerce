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


@org.springframework.stereotype.Repository("blSequenceGeneratorCorruptionDetection")
public class SequenceGeneratorCorruptionDetection implements org.springframework.context.ApplicationListener<org.springframework.context.event.ContextRefreshedEvent> {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.class);

    @javax.annotation.Resource(name = "blTargetModeMaps")
    protected java.util.List<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> targetModeMaps;

    @javax.annotation.Resource(name = "blPersistenceService")
    protected org.broadleafcommerce.common.service.PersistenceService persistenceService;

    @javax.annotation.Resource(name = "blStreamingTransactionCapableUtil")
    protected org.broadleafcommerce.common.util.StreamingTransactionCapableUtil transUtil;

    @org.springframework.beans.factory.annotation.Value("${detect.sequence.generator.inconsistencies}")
    protected boolean detectSequenceGeneratorInconsistencies = true;

    @org.springframework.beans.factory.annotation.Value("${auto.correct.sequence.generator.inconsistencies}")
    protected boolean automaticallyCorrectInconsistencies = false;

    @org.springframework.beans.factory.annotation.Value("${default.schema.sequence.generator}")
    protected java.lang.String defaultSchemaSequenceGenerator = "";

    @java.lang.Override
    public void onApplicationEvent(org.springframework.context.event.ContextRefreshedEvent event) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4384, detectSequenceGeneratorInconsistencies)) {
            for (java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> targetModeMap : targetModeMaps) {
                for (final java.lang.String targetMode : targetModeMap.keySet()) {
                    final java.util.Map<java.lang.String, java.lang.Object> managerMap = targetModeMap.get(targetMode);
                    org.springframework.transaction.PlatformTransactionManager txManager = persistenceService.getTransactionManager(managerMap);
                    transUtil.runTransactionalOperation(new org.broadleafcommerce.common.util.StreamCapableTransactionalOperationAdapter() {
                        @java.lang.Override
                        public void execute() throws java.lang.Throwable {
                            javax.persistence.EntityManager em = persistenceService.getEntityManager(managerMap);
                            org.hibernate.Session hibernateSession = em.unwrap(org.hibernate.Session.class);
                            patchSequenceGeneratorInconsistencies(em, hibernateSession);
                        }
                    }, java.lang.RuntimeException.class, txManager);
                }
            }
        }
    }

    protected void patchSequenceGeneratorInconsistencies(javax.persistence.EntityManager em, org.hibernate.Session session) {
        org.hibernate.SessionFactory sessionFactory = session.getSessionFactory();
        for (java.lang.Object item : sessionFactory.getAllClassMetadata().values()) {
            org.hibernate.metadata.ClassMetadata metadata = ((org.hibernate.metadata.ClassMetadata) (item));
            java.lang.String idProperty = metadata.getIdentifierPropertyName();
            java.lang.Class<?> mappedClass = metadata.getMappedClass();
            java.lang.reflect.Field idField;
            try {
                idField = mappedClass.getDeclaredField(idProperty);
            } catch (java.lang.NoSuchFieldException e) {
                continue;
            }
            idField.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4385, true));
            org.hibernate.annotations.GenericGenerator genericAnnot = idField.getAnnotation(org.hibernate.annotations.GenericGenerator.class);
            javax.persistence.TableGenerator tableAnnot = idField.getAnnotation(javax.persistence.TableGenerator.class);
            java.lang.String segmentValue = null;
            java.lang.String tableName = null;
            java.lang.String segmentColumnName = null;
            java.lang.String valueColumnName = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4388, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4386, (genericAnnot != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4387, genericAnnot.strategy().equals(org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.class.getName())))))) {
                for (org.hibernate.annotations.Parameter param : genericAnnot.parameters()) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4389, param.name().equals("segment_value"))) {
                        segmentValue = param.value();
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4390, param.name().equals("table_name"))) {
                        tableName = param.value();
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4391, param.name().equals("segment_column_name"))) {
                        segmentColumnName = param.value();
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4392, param.name().equals("value_column_name"))) {
                        valueColumnName = param.value();
                    }
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4393, org.apache.commons.lang.StringUtils.isBlank(tableName))) {
                    tableName = org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.DEFAULT_TABLE_NAME;
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4394, org.apache.commons.lang.StringUtils.isBlank(segmentColumnName))) {
                    segmentColumnName = org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.DEFAULT_SEGMENT_COLUMN_NAME;
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4395, org.apache.commons.lang.StringUtils.isBlank(valueColumnName))) {
                    valueColumnName = org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.DEFAULT_VALUE_COLUMN_NAME;
                }
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4396, (tableAnnot != null))) {
                    segmentValue = tableAnnot.pkColumnValue();
                    tableName = tableAnnot.table();
                    segmentColumnName = tableAnnot.pkColumnName();
                    valueColumnName = tableAnnot.valueColumnName();
                }

            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4407, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4404, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4401, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4398, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4397, org.apache.commons.lang.StringUtils.isEmpty(segmentValue)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4400, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4399, org.apache.commons.lang.StringUtils.isEmpty(tableName))))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4403, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4402, org.apache.commons.lang.StringUtils.isEmpty(segmentColumnName))))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4406, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4405, org.apache.commons.lang.StringUtils.isEmpty(valueColumnName))))))))) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("select ");
                sb2.append(valueColumnName);
                sb2.append(" from ");
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4412, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4409, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4408, tableName.contains(".")))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4411, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4410, org.apache.commons.lang.StringUtils.isEmpty(defaultSchemaSequenceGenerator))))))))) {
                    sb2.append(defaultSchemaSequenceGenerator);
                    sb2.append(".");
                }
                sb2.append(tableName);
                sb2.append(" where ");
                sb2.append(segmentColumnName);
                sb2.append(" = '");
                sb2.append(segmentValue);
                sb2.append("'");
                java.lang.Long maxSequenceId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4413, ((long) (0L)));
                boolean sequenceEntryExists = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4414, false);
                java.util.List results2 = em.createNativeQuery(sb2.toString()).getResultList();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4418, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4415, org.apache.commons.collections.CollectionUtils.isNotEmpty(results2))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4417, ((results2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4416, 0))) != null)))))) {
                    maxSequenceId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4420, ((java.lang.Number) (results2.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4419, 0)))).longValue());
                    sequenceEntryExists = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4421, true);
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4422, org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.debug(((((("Detecting id sequence state between " + (mappedClass.getName())) + " and ") + segmentValue) + " in ") + tableName));
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("select max(");
                sb.append(idField.getName());
                sb.append(") from ");
                sb.append(mappedClass.getName());
                sb.append(" entity");
                java.util.List results;
                org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4423, (context == null))) {
                    context = new org.broadleafcommerce.common.web.BroadleafRequestContext();
                    org.broadleafcommerce.common.web.BroadleafRequestContext.setBroadleafRequestContext(context);
                }
                try {
                    context.setInternalIgnoreFilters(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4424, true));
                    results = em.createQuery(sb.toString()).getResultList();
                } finally {
                    context.setInternalIgnoreFilters(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4425, false));
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4429, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4426, org.apache.commons.collections.CollectionUtils.isNotEmpty(results))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4428, ((results.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4427, 0))) != null)))))) {
                    org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.debug(java.lang.String.format("Checking for sequence corruption on entity %s", segmentValue));
                    java.lang.Long maxEntityId = org.broadleafcommerce.common.util.BLCNumberUtils.toLong(results.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4430, 0)));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4431, (maxEntityId > maxSequenceId))) {
                        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.error(java.lang.String.format(("The sequence value for %s in %s was found as %d (or an entry did not exist) but the actual max sequence in" + " %s's table was found as %d"), segmentValue, tableName, maxSequenceId, mappedClass.getName(), maxEntityId));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4432, automaticallyCorrectInconsistencies)) {
                            long newMaxId = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4433, (maxEntityId + 10));
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4434, sequenceEntryExists)) {
                                java.lang.String log = java.lang.String.format(("Correcting sequences for entity %s.  Updating the sequence value" + " to %d"), mappedClass.getName(), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4435, newMaxId));
                                org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.warn(log);
                                java.lang.StringBuilder updateQuery = new java.lang.StringBuilder();
                                updateQuery.append("update ");
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4440, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4437, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4436, tableName.contains(".")))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4439, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4438, org.apache.commons.lang.StringUtils.isEmpty(defaultSchemaSequenceGenerator))))))))) {
                                    sb2.append(defaultSchemaSequenceGenerator);
                                    sb2.append(".");
                                }
                                updateQuery.append(tableName);
                                updateQuery.append(" set ");
                                updateQuery.append(valueColumnName);
                                updateQuery.append(" = ");
                                updateQuery.append(java.lang.String.valueOf(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4441, newMaxId)));
                                updateQuery.append(" where ");
                                updateQuery.append(segmentColumnName);
                                updateQuery.append(" = '");
                                updateQuery.append(segmentValue);
                                updateQuery.append("'");
                                int response = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4442, em.createNativeQuery(updateQuery.toString()).executeUpdate());
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4445, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4443, response)) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4444, 0))))) {
                                    throw new java.lang.RuntimeException(((("Unable to update " + tableName) + " with the sequence generator id for ") + segmentValue));
                                }
                            }else {
                                java.lang.String log = java.lang.String.format(("Correcting sequences for entity %s. Did not find an entry in" + " %s, inserting the new sequence value as %d"), mappedClass.getName(), tableName, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4446, newMaxId));
                                org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.warn(log);
                                java.lang.StringBuilder insertQuery = new java.lang.StringBuilder();
                                insertQuery.append("insert into ");
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4451, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4448, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4447, tableName.contains(".")))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4450, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4449, org.apache.commons.lang.StringUtils.isEmpty(defaultSchemaSequenceGenerator))))))))) {
                                    sb2.append(defaultSchemaSequenceGenerator);
                                    sb2.append(".");
                                }
                                insertQuery.append(tableName);
                                insertQuery.append(((((" (" + segmentColumnName) + ",") + valueColumnName) + ")"));
                                insertQuery.append((((("values ('" + segmentValue) + "','") + (java.lang.String.valueOf(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4452, newMaxId)))) + "')"));
                                int response = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4453, em.createNativeQuery(insertQuery.toString()).executeUpdate());
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4456, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4454, response)) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4455, 0))))) {
                                    throw new java.lang.RuntimeException(((("Unable to update " + tableName) + " with the sequence generator id for ") + segmentValue));
                                }
                            }
                        }else {
                            java.lang.String reason = (((((((((((((("A data inconsistency has been detected between the " + tableName) + " table and one or more entity tables for which it manages current max primary key values.\n") + "The inconsistency was detected between the managed class (") + (mappedClass.getName())) + ") and the identifier (") + segmentValue) + ") in ") + tableName) + ". Broadleaf\n") + "has stopped startup of the application in order to allow you to resolve the issue and avoid possible data corruption. If you wish to disable this detection, you may\n") + "set the \'detect.sequence.generator.inconsistencies\' property to false in your application\'s common.properties or common-shared.properties. If you would like for this component\n") + "to autocorrect these problems by setting the sequence generator value to a value greater than the max entity id, then set the \'auto.correct.sequence.generator.inconsistencies\'\n") + "property to true in your application\'s common.properties or common-shared.properties. If you would like to provide a default schema to be used to qualify table names used in the\n") + "queries for this detection, set the \'default.schema.sequence.generator\' property in your application\'s common.properties or common-shared.properties. Also, if you are upgrading\n") + "from 1.6 or below, please refer to http://docs.broadleafcommerce.org/current/1.6-to-2.0-Migration.html for important information regarding migrating your SEQUENCE_GENERATOR table.";
                            org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.LOG.error("Broadleaf Commerce failed to start", new java.lang.RuntimeException(reason));
                            java.lang.System.exit(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4457, 1));
                        }
                    }
                }
            }
        }
    }

    public static perturbation.location.PerturbationLocation __L4384;

    public static perturbation.location.PerturbationLocation __L4385;

    public static perturbation.location.PerturbationLocation __L4386;

    public static perturbation.location.PerturbationLocation __L4387;

    public static perturbation.location.PerturbationLocation __L4388;

    public static perturbation.location.PerturbationLocation __L4389;

    public static perturbation.location.PerturbationLocation __L4390;

    public static perturbation.location.PerturbationLocation __L4391;

    public static perturbation.location.PerturbationLocation __L4392;

    public static perturbation.location.PerturbationLocation __L4393;

    public static perturbation.location.PerturbationLocation __L4394;

    public static perturbation.location.PerturbationLocation __L4395;

    public static perturbation.location.PerturbationLocation __L4396;

    public static perturbation.location.PerturbationLocation __L4397;

    public static perturbation.location.PerturbationLocation __L4398;

    public static perturbation.location.PerturbationLocation __L4399;

    public static perturbation.location.PerturbationLocation __L4400;

    public static perturbation.location.PerturbationLocation __L4401;

    public static perturbation.location.PerturbationLocation __L4402;

    public static perturbation.location.PerturbationLocation __L4403;

    public static perturbation.location.PerturbationLocation __L4404;

    public static perturbation.location.PerturbationLocation __L4405;

    public static perturbation.location.PerturbationLocation __L4406;

    public static perturbation.location.PerturbationLocation __L4407;

    public static perturbation.location.PerturbationLocation __L4408;

    public static perturbation.location.PerturbationLocation __L4409;

    public static perturbation.location.PerturbationLocation __L4410;

    public static perturbation.location.PerturbationLocation __L4411;

    public static perturbation.location.PerturbationLocation __L4412;

    public static perturbation.location.PerturbationLocation __L4413;

    public static perturbation.location.PerturbationLocation __L4414;

    public static perturbation.location.PerturbationLocation __L4415;

    public static perturbation.location.PerturbationLocation __L4416;

    public static perturbation.location.PerturbationLocation __L4417;

    public static perturbation.location.PerturbationLocation __L4418;

    public static perturbation.location.PerturbationLocation __L4419;

    public static perturbation.location.PerturbationLocation __L4420;

    public static perturbation.location.PerturbationLocation __L4421;

    public static perturbation.location.PerturbationLocation __L4422;

    public static perturbation.location.PerturbationLocation __L4423;

    public static perturbation.location.PerturbationLocation __L4424;

    public static perturbation.location.PerturbationLocation __L4425;

    public static perturbation.location.PerturbationLocation __L4426;

    public static perturbation.location.PerturbationLocation __L4427;

    public static perturbation.location.PerturbationLocation __L4428;

    public static perturbation.location.PerturbationLocation __L4429;

    public static perturbation.location.PerturbationLocation __L4430;

    public static perturbation.location.PerturbationLocation __L4431;

    public static perturbation.location.PerturbationLocation __L4432;

    public static perturbation.location.PerturbationLocation __L4433;

    public static perturbation.location.PerturbationLocation __L4434;

    public static perturbation.location.PerturbationLocation __L4435;

    public static perturbation.location.PerturbationLocation __L4436;

    public static perturbation.location.PerturbationLocation __L4437;

    public static perturbation.location.PerturbationLocation __L4438;

    public static perturbation.location.PerturbationLocation __L4439;

    public static perturbation.location.PerturbationLocation __L4440;

    public static perturbation.location.PerturbationLocation __L4441;

    public static perturbation.location.PerturbationLocation __L4442;

    public static perturbation.location.PerturbationLocation __L4443;

    public static perturbation.location.PerturbationLocation __L4444;

    public static perturbation.location.PerturbationLocation __L4445;

    public static perturbation.location.PerturbationLocation __L4446;

    public static perturbation.location.PerturbationLocation __L4447;

    public static perturbation.location.PerturbationLocation __L4448;

    public static perturbation.location.PerturbationLocation __L4449;

    public static perturbation.location.PerturbationLocation __L4450;

    public static perturbation.location.PerturbationLocation __L4451;

    public static perturbation.location.PerturbationLocation __L4452;

    public static perturbation.location.PerturbationLocation __L4453;

    public static perturbation.location.PerturbationLocation __L4454;

    public static perturbation.location.PerturbationLocation __L4455;

    public static perturbation.location.PerturbationLocation __L4456;

    public static perturbation.location.PerturbationLocation __L4457;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:79)", 4384, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:111)", 4385, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:118)", 4386, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:118)", 4387, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:118)", 4388, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:121)", 4389, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:124)", 4390, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:127)", 4391, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:130)", 4392, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:137)", 4393, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:140)", 4394, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:143)", 4395, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:146)", 4396, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4397, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4398, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4399, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4400, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4401, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4402, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4403, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4404, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4405, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4406, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:153)", 4407, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:158)", 4408, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:158)", 4409, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:158)", 4410, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:158)", 4411, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:158)", 4412, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:169)", 4413, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:170)", 4414, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:172)", 4415, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:172)", 4416, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:172)", 4417, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:172)", 4418, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:173)", 4419, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:173)", 4420, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:174)", 4421, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:177)", 4422, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:190)", 4423, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:195)", 4424, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:198)", 4425, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:201)", 4426, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:201)", 4427, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:201)", 4428, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:201)", 4429, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:203)", 4430, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:204)", 4431, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:207)", 4432, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:208)", 4433, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:209)", 4434, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:212)", 4435, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:217)", 4436, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:217)", 4437, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:217)", 4438, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:217)", 4439, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:217)", 4440, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:225)", 4441, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:232)", 4442, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:233)", 4443, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:233)", 4444, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:233)", 4445, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:239)", 4446, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:244)", 4447, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:244)", 4448, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:244)", 4449, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:244)", 4450, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:244)", 4451, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:250)", 4452, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:252)", 4453, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:253)", 4454, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:253)", 4455, "Numerical");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:253)", 4456, "Boolean");
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.__L4457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/SequenceGeneratorCorruptionDetection.java:267)", 4457, "Numerical");
    }

    static {
        org.broadleafcommerce.common.persistence.SequenceGeneratorCorruptionDetection.initPerturbationLocation0();
    }
}

