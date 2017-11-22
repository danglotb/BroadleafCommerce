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


public class DemoHsqlSingleLineSqlCommandExtractor extends org.hibernate.tool.hbm2ddl.SingleLineSqlCommandExtractor {
    private static final org.broadleafcommerce.common.logging.SupportLogger LOGGER = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("UserOverride", org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.class);

    @java.lang.Override
    public java.lang.String[] extractCommands(java.io.Reader reader) {
        java.lang.String[] commands = super.extractCommands(reader);
        java.lang.String[] newCommands = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5947, commands.length)];
        int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5948, 0);
        for (java.lang.String command : commands) {
            java.lang.String newCommand = command;
            newCommand = newCommand.replaceAll(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX, "' || CHAR(13) || CHAR(10) || '");
            newCommand = newCommand.replaceAll(org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH, "\\\\");
            newCommand = newCommand.replaceAll("\\\\\"", "' || CHAR(34) || '");
            newCommands[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5949, i)] = newCommand;
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5950, (i++));
        }
        return newCommands;
    }

    public static perturbation.location.PerturbationLocation __L5947;

    public static perturbation.location.PerturbationLocation __L5948;

    public static perturbation.location.PerturbationLocation __L5949;

    public static perturbation.location.PerturbationLocation __L5950;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoHsqlSingleLineSqlCommandExtractor.java:39)", 5947, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoHsqlSingleLineSqlCommandExtractor.java:40)", 5948, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoHsqlSingleLineSqlCommandExtractor.java:53)", 5949, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.__L5950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoHsqlSingleLineSqlCommandExtractor.java:54)", 5950, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor.initPerturbationLocation0();
    }
}

