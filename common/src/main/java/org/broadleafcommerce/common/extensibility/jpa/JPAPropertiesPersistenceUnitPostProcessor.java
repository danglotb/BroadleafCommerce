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
package org.broadleafcommerce.common.extensibility.jpa;


public class JPAPropertiesPersistenceUnitPostProcessor implements org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.class);

    protected java.util.Map<java.lang.String, java.lang.String> persistenceUnitProperties = new java.util.HashMap<>();

    protected java.util.Map<java.lang.String, java.lang.String> overrideProperties = new java.util.HashMap<>();

    @javax.annotation.Resource(name = "blCompositeAutoImportSql")
    protected org.broadleafcommerce.common.demo.CompositeAutoImportSql compositeAutoImportSql;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.hbm2ddl.auto}")
    protected java.lang.String blPUHibernateHbm2ddlAuto;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.dialect}")
    protected java.lang.String blPUHibernateDialect;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.show_sql}")
    protected java.lang.String blPUHibernateShow_sql;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.cache.use_second_level_cache}")
    protected java.lang.String blPUHibernateCacheUse_second_level_cache;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.cache.use_query_cache}")
    protected java.lang.String blPUHibernateCacheUse_query_cache;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.hbm2ddl.import_files}")
    protected java.lang.String blPUHibernateHbm2ddlImport_files;

    @org.springframework.beans.factory.annotation.Value("${blPU.hibernate.hbm2ddl.import_files_sql_extractor}")
    protected java.lang.String blPUHibernateHbm2ddlImport_files_sql_extractor;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.hbm2ddl.auto}")
    protected java.lang.String blCMSStorageHibernateHbm2ddlAuto;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.dialect}")
    protected java.lang.String blCMSStorageHibernateDialect;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.show_sql}")
    protected java.lang.String blCMSStorageHibernateShow_sql;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.cache.use_second_level_cache}")
    protected java.lang.String blCMSStorageHibernateCacheUse_second_level_cache;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.cache.use_query_cache}")
    protected java.lang.String blCMSStorageHibernateCacheUse_query_cache;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.hbm2ddl.import_files}")
    protected java.lang.String blCMSStorageHibernateHbm2ddlImport_files;

    @org.springframework.beans.factory.annotation.Value("${blCMSStorage.hibernate.hbm2ddl.import_files_sql_extractor}")
    protected java.lang.String blCMSStorageHibernateHbm2ddlImport_files_sql_extractor;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.hbm2ddl.auto}")
    protected java.lang.String blSecurePUHibernateHbm2ddlAuto;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.dialect}")
    protected java.lang.String blSecurePUHibernateDialect;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.show_sql}")
    protected java.lang.String blSecurePUHibernateShow_sql;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.cache.use_second_level_cache}")
    protected java.lang.String blSecurePUHibernateCacheUse_second_level_cache;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.cache.use_query_cache}")
    protected java.lang.String blSecurePUHibernateCacheUse_query_cache;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.hbm2ddl.import_files}")
    protected java.lang.String blSecurePUHibernateHbm2ddlImport_files;

    @org.springframework.beans.factory.annotation.Value("${blSecurePU.hibernate.hbm2ddl.import_files_sql_extractor}")
    protected java.lang.String blSecurePUHibernateHbm2ddlImport_files_sql_extractor;

    @javax.annotation.PostConstruct
    public void populatePresetProperties() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2169, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2168, blPUHibernateHbm2ddlAuto.startsWith("${"))))))
            persistenceUnitProperties.put("blPU.hibernate.hbm2ddl.auto", blPUHibernateHbm2ddlAuto);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2171, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2170, blPUHibernateDialect.startsWith("${"))))))
            persistenceUnitProperties.put("blPU.hibernate.dialect", blPUHibernateDialect);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2173, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2172, blPUHibernateShow_sql.startsWith("${"))))))
            persistenceUnitProperties.put("blPU.hibernate.show_sql", blPUHibernateShow_sql);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2175, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2174, blPUHibernateCacheUse_second_level_cache.startsWith("${"))))))
            persistenceUnitProperties.put("blPU.hibernate.cache.use_second_level_cache", blPUHibernateCacheUse_second_level_cache);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2177, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2176, blPUHibernateCacheUse_query_cache.startsWith("${"))))))
            persistenceUnitProperties.put("blPU.hibernate.cache.use_query_cache", blPUHibernateCacheUse_query_cache);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2182, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2179, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2178, blPUHibernateHbm2ddlImport_files.startsWith("${")))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2181, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2180, "null".equals(blPUHibernateHbm2ddlImport_files))))))))) {
            persistenceUnitProperties.put("blPU.hibernate.hbm2ddl.import_files", blPUHibernateHbm2ddlImport_files);
        }else {
            java.lang.String autoImportSql = compositeAutoImportSql.compileSqlFilePathList("blPU");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2183, org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.LOG.isInfoEnabled())) {
                java.util.Map<java.lang.String, java.util.List<org.broadleafcommerce.common.demo.AutoImportSql>> loggingMap = compositeAutoImportSql.constructAutoImportSqlMapForPU("blPU");
                org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.LOG.info("Auto-importing the following SQL files in order:");
                for (java.lang.String stage : loggingMap.keySet()) {
                    org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.LOG.info(stage);
                    for (org.broadleafcommerce.common.demo.AutoImportSql sqlFile : loggingMap.get(stage)) {
                        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.LOG.info(((("[order:" + (sqlFile.getOrder())) + "] ") + (sqlFile.getSqlFilePath())));
                    }
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2185, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2184, org.apache.commons.lang3.StringUtils.isEmpty(autoImportSql)))))) {
                persistenceUnitProperties.put("blPU.hibernate.hbm2ddl.import_files", autoImportSql);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2187, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2186, blPUHibernateHbm2ddlImport_files_sql_extractor.startsWith("${"))))))
            persistenceUnitProperties.put("blPU.hibernate.hbm2ddl.import_files_sql_extractor", blPUHibernateHbm2ddlImport_files_sql_extractor);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2189, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2188, blCMSStorageHibernateHbm2ddlAuto.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.hbm2ddl.auto", blCMSStorageHibernateHbm2ddlAuto);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2191, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2190, blCMSStorageHibernateDialect.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.dialect", blCMSStorageHibernateDialect);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2193, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2192, blCMSStorageHibernateShow_sql.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.show_sql", blCMSStorageHibernateShow_sql);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2195, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2194, blCMSStorageHibernateCacheUse_second_level_cache.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.cache.use_second_level_cache", blCMSStorageHibernateCacheUse_second_level_cache);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2197, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2196, blCMSStorageHibernateCacheUse_query_cache.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.cache.use_query_cache", blCMSStorageHibernateCacheUse_query_cache);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2199, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2198, blCMSStorageHibernateHbm2ddlImport_files.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.hbm2ddl.import_files", blCMSStorageHibernateHbm2ddlImport_files);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2201, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2200, blCMSStorageHibernateHbm2ddlImport_files_sql_extractor.startsWith("${"))))))
            persistenceUnitProperties.put("blCMSStorage.hibernate.hbm2ddl.import_files_sql_extractor", blCMSStorageHibernateHbm2ddlImport_files_sql_extractor);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2203, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2202, blSecurePUHibernateHbm2ddlAuto.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.hbm2ddl.auto", blSecurePUHibernateHbm2ddlAuto);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2205, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2204, blSecurePUHibernateDialect.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.dialect", blSecurePUHibernateDialect);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2207, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2206, blSecurePUHibernateShow_sql.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.show_sql", blSecurePUHibernateShow_sql);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2209, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2208, blSecurePUHibernateCacheUse_second_level_cache.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.cache.use_second_level_cache", blSecurePUHibernateCacheUse_second_level_cache);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2211, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2210, blSecurePUHibernateCacheUse_query_cache.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.cache.use_query_cache", blSecurePUHibernateCacheUse_query_cache);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2213, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2212, blSecurePUHibernateHbm2ddlImport_files.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.hbm2ddl.import_files", blSecurePUHibernateHbm2ddlImport_files);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2215, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2214, blSecurePUHibernateHbm2ddlImport_files_sql_extractor.startsWith("${"))))))
            persistenceUnitProperties.put("blSecurePU.hibernate.hbm2ddl.import_files_sql_extractor", blSecurePUHibernateHbm2ddlImport_files_sql_extractor);

        persistenceUnitProperties.putAll(overrideProperties);
    }

    @java.lang.Override
    public void postProcessPersistenceUnitInfo(org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo pui) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2216, ((persistenceUnitProperties) != null))) {
            java.lang.String puName = (pui.getPersistenceUnitName()) + ".";
            java.util.Set<java.lang.String> keys = persistenceUnitProperties.keySet();
            java.util.Properties props = pui.getProperties();
            for (java.lang.String key : keys) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2217, key.startsWith(puName))) {
                    java.lang.String value = persistenceUnitProperties.get(key);
                    java.lang.String newKey = key.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2218, puName.length()));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2219, "null".equalsIgnoreCase(value))) {
                        props.remove(newKey);
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2223, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2220, (value != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2222, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2221, "".equals(value))))))))) {
                            props.put(newKey, value);
                        }

                }
            }
            pui.setProperties(props);
        }
    }

    public void setPersistenceUnitProperties(java.util.Map<java.lang.String, java.lang.String> properties) {
        this.overrideProperties = properties;
    }

    public static perturbation.location.PerturbationLocation __L2168;

    public static perturbation.location.PerturbationLocation __L2169;

    public static perturbation.location.PerturbationLocation __L2170;

    public static perturbation.location.PerturbationLocation __L2171;

    public static perturbation.location.PerturbationLocation __L2172;

    public static perturbation.location.PerturbationLocation __L2173;

    public static perturbation.location.PerturbationLocation __L2174;

    public static perturbation.location.PerturbationLocation __L2175;

    public static perturbation.location.PerturbationLocation __L2176;

    public static perturbation.location.PerturbationLocation __L2177;

    public static perturbation.location.PerturbationLocation __L2178;

    public static perturbation.location.PerturbationLocation __L2179;

    public static perturbation.location.PerturbationLocation __L2180;

    public static perturbation.location.PerturbationLocation __L2181;

    public static perturbation.location.PerturbationLocation __L2182;

    public static perturbation.location.PerturbationLocation __L2183;

    public static perturbation.location.PerturbationLocation __L2184;

    public static perturbation.location.PerturbationLocation __L2185;

    public static perturbation.location.PerturbationLocation __L2186;

    public static perturbation.location.PerturbationLocation __L2187;

    public static perturbation.location.PerturbationLocation __L2188;

    public static perturbation.location.PerturbationLocation __L2189;

    public static perturbation.location.PerturbationLocation __L2190;

    public static perturbation.location.PerturbationLocation __L2191;

    public static perturbation.location.PerturbationLocation __L2192;

    public static perturbation.location.PerturbationLocation __L2193;

    public static perturbation.location.PerturbationLocation __L2194;

    public static perturbation.location.PerturbationLocation __L2195;

    public static perturbation.location.PerturbationLocation __L2196;

    public static perturbation.location.PerturbationLocation __L2197;

    public static perturbation.location.PerturbationLocation __L2198;

    public static perturbation.location.PerturbationLocation __L2199;

    public static perturbation.location.PerturbationLocation __L2200;

    public static perturbation.location.PerturbationLocation __L2201;

    public static perturbation.location.PerturbationLocation __L2202;

    public static perturbation.location.PerturbationLocation __L2203;

    public static perturbation.location.PerturbationLocation __L2204;

    public static perturbation.location.PerturbationLocation __L2205;

    public static perturbation.location.PerturbationLocation __L2206;

    public static perturbation.location.PerturbationLocation __L2207;

    public static perturbation.location.PerturbationLocation __L2208;

    public static perturbation.location.PerturbationLocation __L2209;

    public static perturbation.location.PerturbationLocation __L2210;

    public static perturbation.location.PerturbationLocation __L2211;

    public static perturbation.location.PerturbationLocation __L2212;

    public static perturbation.location.PerturbationLocation __L2213;

    public static perturbation.location.PerturbationLocation __L2214;

    public static perturbation.location.PerturbationLocation __L2215;

    public static perturbation.location.PerturbationLocation __L2216;

    public static perturbation.location.PerturbationLocation __L2217;

    public static perturbation.location.PerturbationLocation __L2218;

    public static perturbation.location.PerturbationLocation __L2219;

    public static perturbation.location.PerturbationLocation __L2220;

    public static perturbation.location.PerturbationLocation __L2221;

    public static perturbation.location.PerturbationLocation __L2222;

    public static perturbation.location.PerturbationLocation __L2223;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:129)", 2168, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:129)", 2169, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:130)", 2170, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:130)", 2171, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:131)", 2172, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:131)", 2173, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:132)", 2174, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:132)", 2175, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:133)", 2176, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:133)", 2177, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:134)", 2178, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:134)", 2179, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:134)", 2180, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:134)", 2181, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:134)", 2182, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:138)", 2183, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:149)", 2184, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:149)", 2185, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:153)", 2186, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:153)", 2187, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:155)", 2188, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:155)", 2189, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:156)", 2190, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:156)", 2191, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:157)", 2192, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:157)", 2193, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:158)", 2194, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:158)", 2195, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:159)", 2196, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:159)", 2197, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:160)", 2198, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:160)", 2199, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:161)", 2200, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:161)", 2201, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:163)", 2202, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:163)", 2203, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:164)", 2204, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:164)", 2205, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:165)", 2206, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:165)", 2207, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:166)", 2208, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:166)", 2209, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:167)", 2210, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:167)", 2211, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:168)", 2212, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:168)", 2213, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:169)", 2214, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:169)", 2215, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:176)", 2216, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:182)", 2217, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:184)", 2218, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:185)", 2219, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:187)", 2220, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:187)", 2221, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:187)", 2222, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.__L2223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/JPAPropertiesPersistenceUnitPostProcessor.java:187)", 2223, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.JPAPropertiesPersistenceUnitPostProcessor.initPerturbationLocation0();
    }
}

