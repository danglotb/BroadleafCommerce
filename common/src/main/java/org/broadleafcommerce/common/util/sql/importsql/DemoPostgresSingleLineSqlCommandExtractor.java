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


public class DemoPostgresSingleLineSqlCommandExtractor extends org.hibernate.tool.hbm2ddl.SingleLineSqlCommandExtractor {
    public static final java.lang.String NEWLINE_REPLACEMENT_REGEX = "\\\\r\\\\n";

    private static final long serialVersionUID = 1L;

    private static final org.broadleafcommerce.common.logging.SupportLogger LOGGER = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("UserOverride", org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.class);

    @java.lang.Override
    public java.lang.String[] extractCommands(java.io.Reader reader) {
        java.lang.String[] commands = super.extractCommands(reader);
        java.lang.String[] newCommands = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6018, commands.length)];
        int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6019, 0);
        for (java.lang.String command : commands) {
            java.lang.String newCommand = command;
            newCommand = newCommand.replaceAll("''", "\"\"");
            newCommand = newCommand.replaceAll("('.*?')", "E$1");
            newCommand = newCommand.replaceAll("\"\"", "''");
            newCommand = newCommand.replaceAll(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX, "' || CHR(13) || CHR(10) || '");
            java.util.regex.Pattern charPattern = java.util.regex.Pattern.compile("CHAR\\((\\d+)\\)");
            java.util.regex.Matcher charMatcher = charPattern.matcher(newCommand);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6020, charMatcher.find())) {
                java.lang.String charCode = charMatcher.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6021, 1));
                newCommand = charMatcher.replaceAll((("CHR(" + charCode) + ")"));
            }
            newCommands[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6022, i)] = newCommand;
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6023, (i++));
        }
        return newCommands;
    }

    public static perturbation.location.PerturbationLocation __L6018;

    public static perturbation.location.PerturbationLocation __L6019;

    public static perturbation.location.PerturbationLocation __L6020;

    public static perturbation.location.PerturbationLocation __L6021;

    public static perturbation.location.PerturbationLocation __L6022;

    public static perturbation.location.PerturbationLocation __L6023;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoPostgresSingleLineSqlCommandExtractor.java:52)", 6018, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoPostgresSingleLineSqlCommandExtractor.java:53)", 6019, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoPostgresSingleLineSqlCommandExtractor.java:71)", 6020, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoPostgresSingleLineSqlCommandExtractor.java:72)", 6021, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoPostgresSingleLineSqlCommandExtractor.java:76)", 6022, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.__L6023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoPostgresSingleLineSqlCommandExtractor.java:77)", 6023, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.initPerturbationLocation0();
    }
}

