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


public class DemoOracleSingleLineSqlCommandExtractor extends org.hibernate.tool.hbm2ddl.SingleLineSqlCommandExtractor {
    private static final org.broadleafcommerce.common.logging.SupportLogger LOGGER = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("UserOverride", org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.class);

    private static final java.lang.String BOOLEANTRUEMATCH = "(?i)(true)";

    private static final java.lang.String BOOLEANFALSEMATCH = "(?i)(false)";

    private static final java.lang.String TIMESTAMPMATCH = "(?<!\\{ts\\s)(\'\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\')";

    public static final java.lang.String TRUE = "1";

    public static final java.lang.String FALSE = "0";

    protected boolean alreadyRun = false;

    @java.lang.Override
    public java.lang.String[] extractCommands(java.io.Reader reader) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5952, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5951, alreadyRun))))) {
            alreadyRun = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5953, true);
            org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.LOGGER.support("Converting hibernate.hbm2ddl.import_files sql statements for compatibility with Oracle");
        }
        java.lang.String[] statements = super.extractCommands(reader);
        handleBooleans(statements);
        java.util.List<java.lang.String> stringList = new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(statements));
        int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5954, 0);
        for (java.lang.String statement : statements) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5955, statement.matches(".*[)]\\s*[,].*"))) {
                int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5958, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5956, statement.toUpperCase().indexOf("VALUES "))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5957, "VALUES ".length()))));
                java.lang.String prefix = statement.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5959, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5960, pos));
                stringList.remove(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5961, j));
                java.lang.String values = statement.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5962, pos), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5963, statement.length()));
                java.lang.String[] tokens = values.split("[)]\\s*[,]\\s*[(]");
                java.lang.String[] newStatements = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5964, tokens.length)];
                for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5965, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5968, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5966, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5967, tokens.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5969, (i++))) {
                    java.lang.String suffix = tokens[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5970, i)];
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5972, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5971, suffix.startsWith("(")))))) {
                        suffix = "(" + suffix;
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5974, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5973, suffix.endsWith(")")))))) {
                        suffix += ")";
                    }
                    newStatements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5975, i)] = prefix + suffix;
                }
                stringList.addAll(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5976, j), java.util.Arrays.asList(newStatements));
                j += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5977, tokens.length);
            }else {
                perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5978, (j++));
            }
        }
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.TIMESTAMPMATCH);
        statements = stringList.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5979, stringList.size())]);
        for (int x = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5980, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5983, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5981, x)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5982, statements.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5984, (x++))) {
            java.lang.String statement = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5985, x)];
            java.util.regex.Matcher matcher = pattern.matcher(statement);
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5986, matcher.find())) {
                java.lang.String date = matcher.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5987, 1));
                statement = ((((statement.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5988, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5989, statement.indexOf(date)))) + "{ts ") + date) + "}") + (statement.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5992, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5990, statement.indexOf(date))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5991, date.length())))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5993, statement.length())));
            } 
            statement = statement.replaceAll(org.broadleafcommerce.common.util.sql.importsql.DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX, "' || CHR(13) || CHR(10) || '");
            java.util.regex.Pattern charPattern = java.util.regex.Pattern.compile("CHAR\\((\\d+)\\)");
            java.util.regex.Matcher charMatcher = charPattern.matcher(statement);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5994, charMatcher.find())) {
                java.lang.String charCode = charMatcher.group(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5995, 1));
                statement = charMatcher.replaceAll((("CHR(" + charCode) + ")"));
            }
            statement = statement.replace("\\\\", "\\");
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5996, x)] = statement;
        }
        return statements;
    }

    protected void handleBooleans(java.lang.String[] statements) {
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5997, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6000, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5998, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5999, statements.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6001, (j++))) {
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6002, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6003, j)].replaceAll(((org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH) + "\\s*[,]"), ((org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.TRUE) + ","));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6004, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6005, j)].replaceAll(((org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH) + "\\s*[,]"), ((org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.FALSE) + ","));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6006, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6007, j)].replaceAll((("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH)) + "\\s*[,]"), (("," + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.TRUE)) + ","));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6008, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6009, j)].replaceAll((("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH)) + "\\s*[,]"), (("," + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.FALSE)) + ","));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6010, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6011, j)].replaceAll(("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH)), ("," + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.TRUE)));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6012, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6013, j)].replaceAll(("[,]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH)), ("," + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.FALSE)));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6014, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6015, j)].replaceAll(("[=]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANTRUEMATCH)), ("=" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.TRUE)));
            statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6016, j)] = statements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6017, j)].replaceAll(("[=]\\s*" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.BOOLEANFALSEMATCH)), ("=" + (org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.FALSE)));
        }
    }

    public static perturbation.location.PerturbationLocation __L5951;

    public static perturbation.location.PerturbationLocation __L5952;

    public static perturbation.location.PerturbationLocation __L5953;

    public static perturbation.location.PerturbationLocation __L5954;

    public static perturbation.location.PerturbationLocation __L5955;

    public static perturbation.location.PerturbationLocation __L5956;

    public static perturbation.location.PerturbationLocation __L5957;

    public static perturbation.location.PerturbationLocation __L5958;

    public static perturbation.location.PerturbationLocation __L5959;

    public static perturbation.location.PerturbationLocation __L5960;

    public static perturbation.location.PerturbationLocation __L5961;

    public static perturbation.location.PerturbationLocation __L5962;

    public static perturbation.location.PerturbationLocation __L5963;

    public static perturbation.location.PerturbationLocation __L5964;

    public static perturbation.location.PerturbationLocation __L5965;

    public static perturbation.location.PerturbationLocation __L5966;

    public static perturbation.location.PerturbationLocation __L5967;

    public static perturbation.location.PerturbationLocation __L5968;

    public static perturbation.location.PerturbationLocation __L5969;

    public static perturbation.location.PerturbationLocation __L5970;

    public static perturbation.location.PerturbationLocation __L5971;

    public static perturbation.location.PerturbationLocation __L5972;

    public static perturbation.location.PerturbationLocation __L5973;

    public static perturbation.location.PerturbationLocation __L5974;

    public static perturbation.location.PerturbationLocation __L5975;

    public static perturbation.location.PerturbationLocation __L5976;

    public static perturbation.location.PerturbationLocation __L5977;

    public static perturbation.location.PerturbationLocation __L5978;

    public static perturbation.location.PerturbationLocation __L5979;

    public static perturbation.location.PerturbationLocation __L5980;

    public static perturbation.location.PerturbationLocation __L5981;

    public static perturbation.location.PerturbationLocation __L5982;

    public static perturbation.location.PerturbationLocation __L5983;

    public static perturbation.location.PerturbationLocation __L5984;

    public static perturbation.location.PerturbationLocation __L5985;

    public static perturbation.location.PerturbationLocation __L5986;

    public static perturbation.location.PerturbationLocation __L5987;

    public static perturbation.location.PerturbationLocation __L5988;

    public static perturbation.location.PerturbationLocation __L5989;

    public static perturbation.location.PerturbationLocation __L5990;

    public static perturbation.location.PerturbationLocation __L5991;

    public static perturbation.location.PerturbationLocation __L5992;

    public static perturbation.location.PerturbationLocation __L5993;

    public static perturbation.location.PerturbationLocation __L5994;

    public static perturbation.location.PerturbationLocation __L5995;

    public static perturbation.location.PerturbationLocation __L5996;

    public static perturbation.location.PerturbationLocation __L5997;

    public static perturbation.location.PerturbationLocation __L5998;

    public static perturbation.location.PerturbationLocation __L5999;

    public static perturbation.location.PerturbationLocation __L6000;

    public static perturbation.location.PerturbationLocation __L6001;

    public static perturbation.location.PerturbationLocation __L6002;

    public static perturbation.location.PerturbationLocation __L6003;

    public static perturbation.location.PerturbationLocation __L6004;

    public static perturbation.location.PerturbationLocation __L6005;

    public static perturbation.location.PerturbationLocation __L6006;

    public static perturbation.location.PerturbationLocation __L6007;

    public static perturbation.location.PerturbationLocation __L6008;

    public static perturbation.location.PerturbationLocation __L6009;

    public static perturbation.location.PerturbationLocation __L6010;

    public static perturbation.location.PerturbationLocation __L6011;

    public static perturbation.location.PerturbationLocation __L6012;

    public static perturbation.location.PerturbationLocation __L6013;

    public static perturbation.location.PerturbationLocation __L6014;

    public static perturbation.location.PerturbationLocation __L6015;

    public static perturbation.location.PerturbationLocation __L6016;

    public static perturbation.location.PerturbationLocation __L6017;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:52)", 5951, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:52)", 5952, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:53)", 5953, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:62)", 5954, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:64)", 5955, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:65)", 5956, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:65)", 5957, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:65)", 5958, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:66)", 5959, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:66)", 5960, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:67)", 5961, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:68)", 5962, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:68)", 5963, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:70)", 5964, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:71)", 5965, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:71)", 5966, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:71)", 5967, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:71)", 5968, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:71)", 5969, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:72)", 5970, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:73)", 5971, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:73)", 5972, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:76)", 5973, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:76)", 5974, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:79)", 5975, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:81)", 5976, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:82)", 5977, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:84)", 5978, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:90)", 5979, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:91)", 5980, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:91)", 5981, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:91)", 5982, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:91)", 5983, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:91)", 5984, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:92)", 5985, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:94)", 5986, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:95)", 5987, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:96)", 5988, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:96)", 5989, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:97)", 5990, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:97)", 5991, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:97)", 5992, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:97)", 5993, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:105)", 5994, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:106)", 5995, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:113)", 5996, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:120)", 5997, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:120)", 5998, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L5999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:120)", 5999, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:120)", 6000, "Boolean");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:120)", 6001, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:122)", 6002, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:122)", 6003, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:123)", 6004, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:123)", 6005, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:126)", 6006, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:126)", 6007, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:127)", 6008, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:127)", 6009, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:130)", 6010, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:130)", 6011, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:131)", 6012, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:131)", 6013, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:134)", 6014, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:134)", 6015, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:135)", 6016, "Numerical");
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.__L6017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/sql/importsql/DemoOracleSingleLineSqlCommandExtractor.java:135)", 6017, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.sql.importsql.DemoOracleSingleLineSqlCommandExtractor.initPerturbationLocation0();
    }
}

