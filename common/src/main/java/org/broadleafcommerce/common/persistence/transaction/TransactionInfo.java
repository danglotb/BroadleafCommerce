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
package org.broadleafcommerce.common.persistence.transaction;


public class TransactionInfo {
    protected java.lang.ref.WeakReference<javax.persistence.EntityManager> entityManager;

    protected java.lang.ref.WeakReference<org.springframework.transaction.TransactionDefinition> definition;

    protected java.lang.String beginStack;

    protected org.broadleafcommerce.common.persistence.transaction.CompressedItem compressedBeginStack;

    protected java.lang.ref.WeakReference<java.lang.Thread> thread;

    protected java.lang.String threadName;

    protected java.lang.String threadId;

    protected java.lang.Long startTime;

    protected java.util.concurrent.LinkedBlockingQueue<java.lang.String> queries;

    protected java.util.concurrent.LinkedBlockingQueue<org.broadleafcommerce.common.persistence.transaction.CompressedItem> compressedQueries;

    protected java.util.Map<java.lang.String, java.lang.String> additionalParams = new java.util.HashMap<java.lang.String, java.lang.String>();

    protected java.lang.String currentStackElement;

    protected java.lang.Long lastLogTime;

    protected java.lang.Long stuckThreadStartTime;

    protected java.lang.Boolean faultStateDetected = ((boolean) (false));

    protected java.lang.Boolean isCompressed = ((boolean) (true));

    protected java.lang.String requestContext;

    protected java.lang.Boolean isAbbreviated;

    protected java.lang.Integer abbreviatedLength;

    protected java.lang.Boolean decompressStatementForLog;

    protected java.lang.Integer maxQueryListLength;

    protected java.lang.Integer totalQueries = ((int) (0));

    public TransactionInfo() {
        initialize();
    }

    public TransactionInfo(javax.persistence.EntityManager em, org.springframework.transaction.TransactionDefinition definition, boolean isCompressed, boolean isAbbreviated, int abbreviatedLength, boolean decompressStatementForLog, int maxQueryListLength) {
        this.entityManager = new java.lang.ref.WeakReference<javax.persistence.EntityManager>(em);
        this.definition = new java.lang.ref.WeakReference<org.springframework.transaction.TransactionDefinition>(definition);
        this.isCompressed = isCompressed;
        this.isAbbreviated = isAbbreviated;
        this.abbreviatedLength = abbreviatedLength;
        this.decompressStatementForLog = decompressStatementForLog;
        this.maxQueryListLength = maxQueryListLength;
        queries = new java.util.concurrent.LinkedBlockingQueue<java.lang.String>((maxQueryListLength == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4147, (-1))) ? java.lang.Integer.MAX_VALUE : maxQueryListLength));
        compressedQueries = new java.util.concurrent.LinkedBlockingQueue<org.broadleafcommerce.common.persistence.transaction.CompressedItem>((maxQueryListLength == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4148, (-1))) ? java.lang.Integer.MAX_VALUE : maxQueryListLength));
        initialize();
    }

    public javax.persistence.EntityManager getEntityManager() {
        return entityManager.get();
    }

    public void setEntityManager(javax.persistence.EntityManager entityManager) {
        this.entityManager = new java.lang.ref.WeakReference<javax.persistence.EntityManager>(entityManager);
    }

    public org.springframework.transaction.TransactionDefinition getDefinition() {
        return definition.get();
    }

    public void setDefinition(org.springframework.transaction.TransactionDefinition definition) {
        this.definition = new java.lang.ref.WeakReference<org.springframework.transaction.TransactionDefinition>(definition);
    }

    public java.lang.String getBeginStack() {
        return beginStack;
    }

    public void setBeginStack(java.lang.String beginStack) {
        this.beginStack = beginStack;
    }

    public org.broadleafcommerce.common.persistence.transaction.CompressedItem getCompressedBeginStack() {
        return compressedBeginStack;
    }

    public void setCompressedBeginStack(org.broadleafcommerce.common.persistence.transaction.CompressedItem compressedBeginStack) {
        this.compressedBeginStack = compressedBeginStack;
    }

    public java.lang.Thread getThread() {
        return thread.get();
    }

    public void setThread(java.lang.Thread thread) {
        this.thread = new java.lang.ref.WeakReference<java.lang.Thread>(thread);
    }

    public java.lang.String getThreadName() {
        return threadName;
    }

    public void setThreadName(java.lang.String threadName) {
        this.threadName = threadName;
    }

    public java.lang.String getThreadId() {
        return threadId;
    }

    public void setThreadId(java.lang.String threadId) {
        this.threadId = threadId;
    }

    public java.lang.String getCurrentStackElement() {
        return currentStackElement;
    }

    public void setCurrentStackElement(java.lang.String currentStackElement) {
        this.currentStackElement = currentStackElement;
    }

    public java.lang.Long getLastLogTime() {
        return lastLogTime;
    }

    public void setLastLogTime(java.lang.Long lastLogTime) {
        this.lastLogTime = lastLogTime;
    }

    public java.lang.Long getStuckThreadStartTime() {
        return stuckThreadStartTime;
    }

    public void setStuckThreadStartTime(java.lang.Long stuckThreadStartTime) {
        this.stuckThreadStartTime = stuckThreadStartTime;
    }

    public java.lang.Long getStartTime() {
        return startTime;
    }

    public void setStartTime(java.lang.Long startTime) {
        this.startTime = startTime;
    }

    public java.util.Map<java.lang.String, java.lang.String> getAdditionalParams() {
        return additionalParams;
    }

    public void setAdditionalParams(java.util.Map<java.lang.String, java.lang.String> additionalParams) {
        this.additionalParams = additionalParams;
    }

    public java.util.concurrent.LinkedBlockingQueue<java.lang.String> getQueries() {
        return queries;
    }

    public void setQueries(java.util.concurrent.LinkedBlockingQueue<java.lang.String> queries) {
        this.queries = queries;
    }

    public java.util.concurrent.LinkedBlockingQueue<org.broadleafcommerce.common.persistence.transaction.CompressedItem> getCompressedQueries() {
        return compressedQueries;
    }

    public void setCompressedQueries(java.util.concurrent.LinkedBlockingQueue<org.broadleafcommerce.common.persistence.transaction.CompressedItem> compressedQueries) {
        this.compressedQueries = compressedQueries;
    }

    public java.lang.Boolean getDecompressStatementForLog() {
        return decompressStatementForLog;
    }

    public void setDecompressStatementForLog(java.lang.Boolean decompressStatementForLog) {
        this.decompressStatementForLog = decompressStatementForLog;
    }

    public java.lang.Boolean getFaultStateDetected() {
        return faultStateDetected;
    }

    public void setFaultStateDetected(java.lang.Boolean faultStateDetected) {
        this.faultStateDetected = faultStateDetected;
    }

    public java.lang.Boolean getAbbreviated() {
        return isAbbreviated;
    }

    public void setAbbreviated(java.lang.Boolean abbreviated) {
        isAbbreviated = abbreviated;
    }

    public java.lang.Integer getAbbreviatedLength() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4149, abbreviatedLength);
    }

    public void setAbbreviatedLength(java.lang.Integer abbreviatedLength) {
        this.abbreviatedLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4150, abbreviatedLength);
    }

    public java.lang.Integer getMaxQueryListLength() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4151, maxQueryListLength);
    }

    public void setMaxQueryListLength(java.lang.Integer maxQueryListLength) {
        this.maxQueryListLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4152, maxQueryListLength);
    }

    public void clear() {
        entityManager.clear();
        thread.clear();
        definition.clear();
    }

    public void logStatement(java.lang.String statement) {
        java.lang.String logItem = statement;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4155, ((isAbbreviated) && ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4153, logItem.length())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4154, abbreviatedLength)))))) {
            logItem = logItem.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4156, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4157, abbreviatedLength));
        }
        boolean isLogged = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4158, false);
        if (isCompressed) {
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4159, getCompressedQueries().isEmpty())) {
                    getCompressedQueries().add(new org.broadleafcommerce.common.persistence.transaction.CompressedItem((("\n" + logItem) + "\n"), decompressStatementForLog));
                }else {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4162, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4160, getCompressedQueries().remainingCapacity())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4161, 0))))) {
                        getCompressedQueries().poll();
                    }
                    getCompressedQueries().add(new org.broadleafcommerce.common.persistence.transaction.CompressedItem((logItem + "\n"), decompressStatementForLog));
                }
                isLogged = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4163, true);
            } catch (java.io.IOException e) {
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4165, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4164, isLogged))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4166, getQueries().isEmpty())) {
                getQueries().add((("\n" + logItem) + "\n"));
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4169, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4167, getQueries().remainingCapacity())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4168, 0))))) {
                    getQueries().poll();
                }
                getQueries().add((logItem + "\n"));
            }
        }
        lastLogTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4170, java.lang.System.currentTimeMillis());
        perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4171, ((totalQueries)++));
    }

    protected void initialize() {
        java.lang.RuntimeException e = new java.lang.RuntimeException();
        java.io.StringWriter sw = new java.io.StringWriter();
        e.printStackTrace(new java.io.PrintWriter(sw));
        boolean isLogged = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4172, false);
        if (isCompressed) {
            try {
                compressedBeginStack = new org.broadleafcommerce.common.persistence.transaction.CompressedItem(sw.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4173, true));
                isLogged = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4174, true);
            } catch (java.io.IOException e1) {
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4176, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4175, isLogged))))) {
            beginStack = sw.toString();
        }
        thread = new java.lang.ref.WeakReference<java.lang.Thread>(java.lang.Thread.currentThread());
        threadName = thread.get().getName();
        threadId = java.lang.String.valueOf(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4177, thread.get().getId()));
        startTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4178, java.lang.System.currentTimeMillis());
        lastLogTime = startTime;
        org.broadleafcommerce.common.web.BroadleafRequestContext context = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4179, (context != null))) {
            requestContext = context.createLightWeightCloneJson();
        }else {
            requestContext = "none";
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder("TransactionInfo{");
        sb.append("threadName='").append(threadName).append('\'').append("\n");
        sb.append(", threadId=").append(threadId).append("\n");
        javax.persistence.EntityManager em = getEntityManager();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4180, (em != null))) {
            sb.append(", entityManager='").append(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4181, em.hashCode())).append('\'').append("\n");
        }
        if (isCompressed) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4182, (!(decompressStatementForLog)))) {
                try {
                    java.lang.StringBuilder queryBuilder = new java.lang.StringBuilder();
                    for (org.broadleafcommerce.common.persistence.transaction.CompressedItem compressedItem : compressedQueries) {
                        queryBuilder.append(compressedItem.decompress());
                    }
                    org.broadleafcommerce.common.persistence.transaction.CompressedItem allQueries = new org.broadleafcommerce.common.persistence.transaction.CompressedItem(queryBuilder.toString(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4183, false));
                    sb.append(", queries=").append(allQueries);
                } catch (java.io.IOException e) {
                    sb.append(", queries='Unable to build compressed representation of queries because of an exception: ").append(e.getMessage()).append('\'');
                }
            }else {
                sb.append(", queries=").append(compressedQueries);
            }
        }else {
            sb.append(", queries=").append(queries);
        }
        sb.append(", totalQueries=").append(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4184, totalQueries)).append("\n");
        sb.append(", additionalParams=").append(additionalParams).append("\n");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4185, ((startTime) != null))) {
            java.util.Date start = new java.util.Date(getStartTime());
            sb.append(", startTime=").append(org.broadleafcommerce.common.util.FormatUtil.formatDateUsingW3C(start)).append("\n");
            java.lang.Long endTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4186, ((long) (java.lang.System.currentTimeMillis())));
            java.util.Date end = new java.util.Date(endTime);
            sb.append(", endTime=").append(org.broadleafcommerce.common.util.FormatUtil.formatDateUsingW3C(end)).append("\n");
            java.lang.Long duration = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4187, ((long) (endTime - (startTime))));
            long hours = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4188, java.util.concurrent.TimeUnit.MILLISECONDS.toHours(duration));
            long minutes = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4192, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4189, java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(duration))) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4191, java.util.concurrent.TimeUnit.HOURS.toMinutes(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4190, hours))))));
            long seconds = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4196, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4193, java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(duration))) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4195, java.util.concurrent.TimeUnit.MINUTES.toSeconds(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4194, minutes))))));
            java.lang.String durationString = java.lang.String.format("%d hour, %d min, %d sec", perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4197, hours), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4198, minutes), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4199, seconds));
            sb.append(", duration=").append(durationString).append("\n");
        }
        if (isCompressed) {
            sb.append(", beginStack='").append(compressedBeginStack).append('\'').append("\n");
        }else {
            sb.append(", beginStack='").append(beginStack).append('\'').append("\n");
        }
        sb.append(", requestContext='").append(requestContext).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static perturbation.location.PerturbationLocation __L4147;

    public static perturbation.location.PerturbationLocation __L4148;

    public static perturbation.location.PerturbationLocation __L4149;

    public static perturbation.location.PerturbationLocation __L4150;

    public static perturbation.location.PerturbationLocation __L4151;

    public static perturbation.location.PerturbationLocation __L4152;

    public static perturbation.location.PerturbationLocation __L4153;

    public static perturbation.location.PerturbationLocation __L4154;

    public static perturbation.location.PerturbationLocation __L4155;

    public static perturbation.location.PerturbationLocation __L4156;

    public static perturbation.location.PerturbationLocation __L4157;

    public static perturbation.location.PerturbationLocation __L4158;

    public static perturbation.location.PerturbationLocation __L4159;

    public static perturbation.location.PerturbationLocation __L4160;

    public static perturbation.location.PerturbationLocation __L4161;

    public static perturbation.location.PerturbationLocation __L4162;

    public static perturbation.location.PerturbationLocation __L4163;

    public static perturbation.location.PerturbationLocation __L4164;

    public static perturbation.location.PerturbationLocation __L4165;

    public static perturbation.location.PerturbationLocation __L4166;

    public static perturbation.location.PerturbationLocation __L4167;

    public static perturbation.location.PerturbationLocation __L4168;

    public static perturbation.location.PerturbationLocation __L4169;

    public static perturbation.location.PerturbationLocation __L4170;

    public static perturbation.location.PerturbationLocation __L4171;

    public static perturbation.location.PerturbationLocation __L4172;

    public static perturbation.location.PerturbationLocation __L4173;

    public static perturbation.location.PerturbationLocation __L4174;

    public static perturbation.location.PerturbationLocation __L4175;

    public static perturbation.location.PerturbationLocation __L4176;

    public static perturbation.location.PerturbationLocation __L4177;

    public static perturbation.location.PerturbationLocation __L4178;

    public static perturbation.location.PerturbationLocation __L4179;

    public static perturbation.location.PerturbationLocation __L4180;

    public static perturbation.location.PerturbationLocation __L4181;

    public static perturbation.location.PerturbationLocation __L4182;

    public static perturbation.location.PerturbationLocation __L4183;

    public static perturbation.location.PerturbationLocation __L4184;

    public static perturbation.location.PerturbationLocation __L4185;

    public static perturbation.location.PerturbationLocation __L4186;

    public static perturbation.location.PerturbationLocation __L4187;

    public static perturbation.location.PerturbationLocation __L4188;

    public static perturbation.location.PerturbationLocation __L4189;

    public static perturbation.location.PerturbationLocation __L4190;

    public static perturbation.location.PerturbationLocation __L4191;

    public static perturbation.location.PerturbationLocation __L4192;

    public static perturbation.location.PerturbationLocation __L4193;

    public static perturbation.location.PerturbationLocation __L4194;

    public static perturbation.location.PerturbationLocation __L4195;

    public static perturbation.location.PerturbationLocation __L4196;

    public static perturbation.location.PerturbationLocation __L4197;

    public static perturbation.location.PerturbationLocation __L4198;

    public static perturbation.location.PerturbationLocation __L4199;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:56)", 4147, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:57)", 4148, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:221)", 4149, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:225)", 4150, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:229)", 4151, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:233)", 4152, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:244)", 4153, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:244)", 4154, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:244)", 4155, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:245)", 4156, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:245)", 4157, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:247)", 4158, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:250)", 4159, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:253)", 4160, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:253)", 4161, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:253)", 4162, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:258)", 4163, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:263)", 4164, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:263)", 4165, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:264)", 4166, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:267)", 4167, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:267)", 4168, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:267)", 4169, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:273)", 4170, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:274)", 4171, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:281)", 4172, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:284)", 4173, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:285)", 4174, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:290)", 4175, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:290)", 4176, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:295)", 4177, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:296)", 4178, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:299)", 4179, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:312)", 4180, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:313)", 4181, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:316)", 4182, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:322)", 4183, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:333)", 4184, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:335)", 4185, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:338)", 4186, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:341)", 4187, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:342)", 4188, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:343)", 4189, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:343)", 4190, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:343)", 4191, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:343)", 4192, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:344)", 4193, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:344)", 4194, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:344)", 4195, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:344)", 4196, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:346)", 4197, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:347)", 4198, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.__L4199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionInfo.java:348)", 4199, "Numerical");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo.initPerturbationLocation0();
    }
}

