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
package org.broadleafcommerce.common.util.sql.importsql;


public class DemoSqlServerSingleLineSqlCommandExtractor extends org.hibernate.tool.hbm2ddl.SingleLineSqlCommandExtractor {
    private static final long serialVersionUID = 1L;

    private static final org.broadleafcommerce.common.logging.SupportLogger LOGGER = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("UserOverride", org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.class);

    private static final java.lang.String BOOLEANTRUEMATCH = "(?i)(true)(?=(?:[^']|'[^']*')*$)";

    private static final java.lang.String BOOLEANFALSEMATCH = "(?i)(false)(?=(?:[^']|'[^']*')*$)";

    private static final java.lang.String TIMESTAMPMATCH = "(?i)(current_date)";

    public static final java.lang.String DOUBLEBACKSLASHMATCH = "(\\\\\\\\)";

    public static final java.lang.String TRUE = "'TRUE'";

    public static final java.lang.String FALSE = "'FALSE'";

    public static final java.lang.String CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP";

    protected boolean alreadyRun = false;

    @java.lang.Override
    public java.lang.String[] extractCommands(java.io.Reader reader) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6025, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6024, alreadyRun))))) {
            alreadyRun = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6026, true);
            org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.LOGGER.support("Converting hibernate.hbm2ddl.import_files sql statements for compatibility with SQL Server");
        }
        java.lang.String[] statements = super.extractCommands(reader);
        handleReplacements(statements);
        return statements;
    }

    protected void handleReplacements(java.lang.String[] statements) {
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6027, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6030, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6028, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6029, statements.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6031, (j++))) {
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6032, j)] = replaceBoolean(statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6033, j)]);
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6034, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6035, j)].replaceAll(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX, "' + CHAR(13) + CHAR(10) + '");
        }
    }

    protected java.lang.String replaceBoolean(java.lang.String statement) {
        statement = statement.replaceAll(((org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH) + "\\s*[,]"), ((org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TRUE) + ","));
        statement = statement.replaceAll(((org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH) + "\\s*[,]"), ((org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.FALSE) + ","));
        statement = statement.replaceAll(((org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TIMESTAMPMATCH) + "\\s*[,]"), ((org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.CURRENT_TIMESTAMP) + ","));
        statement = statement.replaceAll((("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH)) + "\\s*[,]"), (("," + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TRUE)) + ","));
        statement = statement.replaceAll((("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH)) + "\\s*[,]"), (("," + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.FALSE)) + ","));
        statement = statement.replaceAll((("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TIMESTAMPMATCH)) + "\\s*[,]"), (("," + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.CURRENT_TIMESTAMP)) + ","));
        statement = statement.replaceAll(("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH)), ("," + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TRUE)));
        statement = statement.replaceAll(("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH)), ("," + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.FALSE)));
        statement = statement.replaceAll(("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TIMESTAMPMATCH)), ("," + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.CURRENT_TIMESTAMP)));
        statement = statement.replaceAll(("[=]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH)), ("=" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.TRUE)));
        statement = statement.replaceAll(("[=]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH)), ("=" + (org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.FALSE)));
        statement = statement.replaceAll(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH, "\\\\");
        return statement;
    }

    public static perturbation.location.PerturbationLocation __L6024;

    public static perturbation.location.PerturbationLocation __L6025;

    public static perturbation.location.PerturbationLocation __L6026;

    public static perturbation.location.PerturbationLocation __L6027;

    public static perturbation.location.PerturbationLocation __L6028;

    public static perturbation.location.PerturbationLocation __L6029;

    public static perturbation.location.PerturbationLocation __L6030;

    public static perturbation.location.PerturbationLocation __L6031;

    public static perturbation.location.PerturbationLocation __L6032;

    public static perturbation.location.PerturbationLocation __L6033;

    public static perturbation.location.PerturbationLocation __L6034;

    public static perturbation.location.PerturbationLocation __L6035;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:51)", 6024, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:51)", 6025, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:52)", 6026, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:63)", 6027, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:63)", 6028, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:63)", 6029, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:63)", 6030, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:63)", 6031, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:64)", 6032, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:64)", 6033, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:67)", 6034, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.__L6035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoSqlServerSingleLineSqlCommandExtractor.java:67)", 6035, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.initPerturbationLocation0();
    }
}

