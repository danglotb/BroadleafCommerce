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
package org.broadleafcommerce.common.logging;


public class ProcessDetailLogger {
    private static final org.broadleafcommerce.common.logging.SupportLogger LOGGER = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("ProcessLogging", org.broadleafcommerce.common.logging.ProcessDetailLogger.class);

    private org.apache.commons.logging.Log processDetailLog;

    protected int listTemplateVariableMaxMemberCount = 30;

    protected int stringTemplateVariableMaxLength = 200;

    @org.springframework.beans.factory.annotation.Value("${ignore.no.process.detail.logger.configuration:false}")
    protected boolean ignoreNoProcessDetailLoggerConfiguration = false;

    @org.springframework.beans.factory.annotation.Value("${disable.all.process.detail.logging:false}")
    protected boolean disableAllProcessDetailLogging = false;

    public ProcessDetailLogger(java.lang.String logIdentifier) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3366, (!(disableAllProcessDetailLogging)))) {
            processDetailLog = org.apache.commons.logging.LogFactory.getLog(logIdentifier);
            if ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3367, (!(ignoreNoProcessDetailLoggerConfiguration)))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3368, (!(processDetailLog.isDebugEnabled()))))) {
                org.broadleafcommerce.common.logging.ProcessDetailLogger.LOGGER.support(("The system has detected that a ProcessDetailLogger instance was requested without " + ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("backing " + "logger configuration at the debug level. In this case, process detail logs may not be sent ") + "to the ") + "appropriate logging file, or may appear in an unwanted location, ") + "like the standard system log. You") + "can disable this log message by setting the ignore.no.process.detail.logger.configuration ") + "property to true. A") + "sample configuration for log4j (log4j.xml) that creates a rolling daily log looks like:\n\n") + "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n") + "<!DOCTYPE log4j:configuration SYSTEM \"log4j.dtd\">\n") + "<log4j:configuration xmlns:log4j=\"http://jakarta.apache.org/log4j/\">\n") + "<appender name=\"console\" class=\"org.apache.log4j.ConsoleAppender\">\n") + "<param name=\"Target\" value=\"System.out\" />\n") + "<layout class=\"org.apache.log4j.PatternLayout\">\n") + "<param name=\"ConversionPattern\" value=\"[%5p] %d${HH:mm:ss$} %c${1$} - ") + "%m%n\" />\n") + "</layout>\n") + "</appender>\n") + "<appender name=\"rollingDailyEnterpriseWorkflow\" class=\"org.apache.log4j") + ".DailyRollingFileAppender\">\n") + "<param name=\"file\" value=\"workflow.log\" />\n") + "<param name=\"DatePattern\" value=\"\'.\'yyyy-MM-dd\" />\n") + "<layout class=\"org.apache.log4j.PatternLayout\">\n") + "<param name=\"ConversionPattern\" value=\"[%5p] %d${HH:mm:ss$} %c${1$} - ") + "%m%n\" />\n") + "</layout>\n") + "</appender>\n") + "<logger name=\"com.broadleafcommerce.enterprise.workflow.process.detail\" ") + "additivity=\"false\">\n") + "<level value=\"debug\"/>\n") + "<appender-ref ref=\"rollingDailyEnterpriseWorkflow\"/>\n") + "</logger>\n") + "<root>\n") + "<priority value=\"warn\" />\n") + "<appender-ref ref=\"console\" />\n") + "</root>\n") + "</log4j:configuration>\n\n") + "A sample logback configuration looks like:\n\n") + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n") + "<configuration>\n") + "<include resource=\"org/springframework/boot/logging/logback/defaults.xml\" />\n") + "<property name=\"LOG_FILE\" value=\"${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}/}spring.log}\"/>\n") + "<include resource=\"org/springframework/boot/logging/logback/console-appender.xml\" />\n") + "<include resource=\"org/springframework/boot/logging/logback/file-appender.xml\" />\n") + "<root level=\"INFO\">\n") + "<appender-ref ref=\"CONSOLE\" />\n") + "<appender-ref ref=\"FILE\" />\n") + "</root>\n") + "<appender name=\"rollingDailyEnterpriseWorkflow\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n") + " <file>${WORKFLOW_LOG_FILE}</file>\n") + "<rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n") + "<fileNamePattern>${WORKFLOW_LOG_FILE}.%d{yyyy-MM-dd-HH-mm}.log</fileNamePattern>\n") + "<maxHistory>30</maxHistory>\n") + "</rollingPolicy>\n") + "<encoder>\n") + "<pattern>[%-5level] %d{MM-dd-yyyy HH:mm:ss} %logger{35} - %message%n</pattern>\n") + "</encoder>\n") + "</appender>\n") + "<logger name=\"com.broadleafcommerce.enterprise.workflow.process.detail\" level=\"DEBUG\">\n") + "<appender-ref ref=\"rollingDailyEnterpriseWorkflow\"/>\n") + "</logger>\n") + "</configuration>\n\n")));
            }
        }
    }

    public void logProcessDetail(java.lang.String logContext, java.lang.String messageTemplate, java.lang.Object... templateVariables) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3372, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3370, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3369, disableAllProcessDetailLogging))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3371, processDetailLog.isDebugEnabled()))))) {
            java.lang.String message = java.lang.String.format(messageTemplate, processVariables(templateVariables));
            logProcessDetail(logContext, message);
        }
    }

    public void logProcessDetail(java.lang.String logContext, java.lang.String message) {
        logProcessDetail(logContext, null, message);
    }

    public void logProcessDetail(java.lang.String logContext, java.lang.Throwable e, java.lang.String messageTemplate, java.lang.Object... templateVariables) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3376, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3374, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3373, disableAllProcessDetailLogging))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3375, processDetailLog.isDebugEnabled()))))) {
            java.lang.String message = java.lang.String.format(messageTemplate, processVariables(templateVariables));
            logProcessDetail(logContext, e, message);
        }
    }

    public void logProcessDetail(java.lang.String logContext, java.lang.Throwable e, java.lang.String message) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3380, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3378, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3377, disableAllProcessDetailLogging))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3379, processDetailLog.isDebugEnabled()))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3381, (e == null))) {
                processDetailLog.debug((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3382, (logContext == null)) ? message : (logContext + " ") + message));
            }else {
                processDetailLog.debug((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3383, (logContext == null)) ? message : (logContext + " ") + message), e);
            }
        }
    }

    protected java.lang.Object[] processVariables(java.lang.Object[] variables) {
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3384, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3387, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3385, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3386, variables.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3388, (j++))) {
            java.lang.Object[] temp = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3390, ((variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3389, j)]) != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3392, variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3391, j)].getClass().isArray())) {
                    temp = ((java.lang.Object[]) (variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3393, j)]));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3395, ((variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3394, j)]) instanceof java.util.Collection))) {
                        temp = ((java.util.Collection) (variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3396, j)])).toArray(new java.lang.Object[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3398, ((java.util.Collection) (variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3397, j)])).size())]);
                    }

            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3399, (temp != null))) {
                java.lang.String joined;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3402, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3400, temp.length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3401, listTemplateVariableMaxMemberCount))))) {
                    java.lang.Object[] shorten = new java.lang.Object[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3403, listTemplateVariableMaxMemberCount)];
                    java.lang.System.arraycopy(temp, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3404, 0), shorten, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3405, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3406, listTemplateVariableMaxMemberCount));
                    joined = org.apache.commons.lang3.StringUtils.join(shorten, ",");
                    joined += "...";
                }else {
                    joined = org.apache.commons.lang3.StringUtils.join(temp, ",");
                }
                variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3407, j)] = joined;
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3414, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3409, ((variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3408, j)]) instanceof java.lang.String))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3413, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3411, ((java.lang.String) (variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3410, j)])).length())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3412, stringTemplateVariableMaxLength)))))))) {
                variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3415, j)] = (((java.lang.String) (variables[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3416, j)])).substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3417, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3420, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3418, stringTemplateVariableMaxLength)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3419, 1)))))) + "...";
            }
        }
        return variables;
    }

    public int getListTemplateVariableMaxMemberCount() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3421, listTemplateVariableMaxMemberCount);
    }

    public void setListTemplateVariableMaxMemberCount(int listTemplateVariableMaxMemberCount) {
        this.listTemplateVariableMaxMemberCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3422, listTemplateVariableMaxMemberCount);
    }

    public int getStringTemplateVariableMaxLength() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3423, stringTemplateVariableMaxLength);
    }

    public void setStringTemplateVariableMaxLength(int stringTemplateVariableMaxLength) {
        this.stringTemplateVariableMaxLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3424, stringTemplateVariableMaxLength);
    }

    public static perturbation.location.PerturbationLocation __L3366;

    public static perturbation.location.PerturbationLocation __L3367;

    public static perturbation.location.PerturbationLocation __L3368;

    public static perturbation.location.PerturbationLocation __L3369;

    public static perturbation.location.PerturbationLocation __L3370;

    public static perturbation.location.PerturbationLocation __L3371;

    public static perturbation.location.PerturbationLocation __L3372;

    public static perturbation.location.PerturbationLocation __L3373;

    public static perturbation.location.PerturbationLocation __L3374;

    public static perturbation.location.PerturbationLocation __L3375;

    public static perturbation.location.PerturbationLocation __L3376;

    public static perturbation.location.PerturbationLocation __L3377;

    public static perturbation.location.PerturbationLocation __L3378;

    public static perturbation.location.PerturbationLocation __L3379;

    public static perturbation.location.PerturbationLocation __L3380;

    public static perturbation.location.PerturbationLocation __L3381;

    public static perturbation.location.PerturbationLocation __L3382;

    public static perturbation.location.PerturbationLocation __L3383;

    public static perturbation.location.PerturbationLocation __L3384;

    public static perturbation.location.PerturbationLocation __L3385;

    public static perturbation.location.PerturbationLocation __L3386;

    public static perturbation.location.PerturbationLocation __L3387;

    public static perturbation.location.PerturbationLocation __L3388;

    public static perturbation.location.PerturbationLocation __L3389;

    public static perturbation.location.PerturbationLocation __L3390;

    public static perturbation.location.PerturbationLocation __L3391;

    public static perturbation.location.PerturbationLocation __L3392;

    public static perturbation.location.PerturbationLocation __L3393;

    public static perturbation.location.PerturbationLocation __L3394;

    public static perturbation.location.PerturbationLocation __L3395;

    public static perturbation.location.PerturbationLocation __L3396;

    public static perturbation.location.PerturbationLocation __L3397;

    public static perturbation.location.PerturbationLocation __L3398;

    public static perturbation.location.PerturbationLocation __L3399;

    public static perturbation.location.PerturbationLocation __L3400;

    public static perturbation.location.PerturbationLocation __L3401;

    public static perturbation.location.PerturbationLocation __L3402;

    public static perturbation.location.PerturbationLocation __L3403;

    public static perturbation.location.PerturbationLocation __L3404;

    public static perturbation.location.PerturbationLocation __L3405;

    public static perturbation.location.PerturbationLocation __L3406;

    public static perturbation.location.PerturbationLocation __L3407;

    public static perturbation.location.PerturbationLocation __L3408;

    public static perturbation.location.PerturbationLocation __L3409;

    public static perturbation.location.PerturbationLocation __L3410;

    public static perturbation.location.PerturbationLocation __L3411;

    public static perturbation.location.PerturbationLocation __L3412;

    public static perturbation.location.PerturbationLocation __L3413;

    public static perturbation.location.PerturbationLocation __L3414;

    public static perturbation.location.PerturbationLocation __L3415;

    public static perturbation.location.PerturbationLocation __L3416;

    public static perturbation.location.PerturbationLocation __L3417;

    public static perturbation.location.PerturbationLocation __L3418;

    public static perturbation.location.PerturbationLocation __L3419;

    public static perturbation.location.PerturbationLocation __L3420;

    public static perturbation.location.PerturbationLocation __L3421;

    public static perturbation.location.PerturbationLocation __L3422;

    public static perturbation.location.PerturbationLocation __L3423;

    public static perturbation.location.PerturbationLocation __L3424;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:97)", 3366, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:99)", 3367, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:99)", 3368, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:175)", 3369, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:175)", 3370, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:175)", 3371, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:175)", 3372, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:200)", 3373, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:200)", 3374, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:200)", 3375, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:200)", 3376, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:214)", 3377, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:214)", 3378, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:214)", 3379, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:214)", 3380, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:215)", 3381, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:216)", 3382, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:218)", 3383, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3384 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:231)", 3384, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3385 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:231)", 3385, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:231)", 3386, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:231)", 3387, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:231)", 3388, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:233)", 3389, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:233)", 3390, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:234)", 3391, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:234)", 3392, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:235)", 3393, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:236)", 3394, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:236)", 3395, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:237)", 3396, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:237)", 3397, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:237)", 3398, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:240)", 3399, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:242)", 3400, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:242)", 3401, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:242)", 3402, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:243)", 3403, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:244)", 3404, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:244)", 3405, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:244)", 3406, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:250)", 3407, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3408, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3409, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3410, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3411, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3412, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3413, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:252)", 3414, "Boolean");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:253)", 3415, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:253)", 3416, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:253)", 3417, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:253)", 3418, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:253)", 3419, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:253)", 3420, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:260)", 3421, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:264)", 3422, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:268)", 3423, "Numerical");
        org.broadleafcommerce.common.logging.ProcessDetailLogger.__L3424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/logging/ProcessDetailLogger.java:272)", 3424, "Numerical");
    }

    static {
        org.broadleafcommerce.common.logging.ProcessDetailLogger.initPerturbationLocation0();
    }
}

