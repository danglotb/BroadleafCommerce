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


@org.springframework.stereotype.Component("blTransactionLifecycleMonitor")
public class TransactionLifecycleMonitor implements org.broadleafcommerce.common.event.BroadleafApplicationListener<org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent> , org.broadleafcommerce.common.persistence.transaction.SqlStatementLoggable , org.springframework.context.ApplicationContextAware , org.springframework.context.SmartLifecycle {
    private static org.broadleafcommerce.common.logging.SupportLogger logger = org.broadleafcommerce.common.logging.SupportLogManager.getLogger("TransactionLogging", org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.class);

    private static org.springframework.context.ApplicationContext context = null;

    private static org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor instance = null;

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    protected java.util.List<org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager> transactionManagers = null;

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    protected java.util.List<org.broadleafcommerce.common.persistence.transaction.TransactionInfoCustomModifier> modifiers = null;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.logging.threshold.millis:600000}")
    protected long loggingThreshold = 600000L;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.stuck.threshold.millis:300000}")
    protected long stuckThreshold = 300000L;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.logging.polling.resolution.millis:30000}")
    protected long loggingPollingResolution = 30000L;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.reporting.lag.threshold.millis:300000}")
    protected long loggingReportingLagThreshold = 300000L;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.info.count.max:5000}")
    protected int countMax = 5000;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.use.compression:true}")
    protected boolean useCompression = true;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.abbreviate.statements:true}")
    protected boolean abbreviateStatements = true;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.abbreviate.statements.length:200}")
    protected int abbreviateStatementsLength = 200;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.decompress.statement:false}")
    protected boolean decompressStatementForLog = false;

    @org.springframework.beans.factory.annotation.Value("${log.transaction.lifecycle.query.list.max.size:100}")
    protected int maxQueryListSize = 100;

    protected java.util.Map<java.lang.Integer, org.broadleafcommerce.common.persistence.transaction.TransactionInfo> infos = new java.util.concurrent.ConcurrentHashMap<>();

    protected boolean isStarted = false;

    protected boolean enabled = false;

    protected java.util.Timer timer = new java.util.Timer("TransactionLifecycleMonitorThread", true);

    public static org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor getInstance() {
        return org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.instance;
    }

    @javax.annotation.PostConstruct
    public synchronized void init() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4202, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4201, isStarted))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4203, ((org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.instance) == null))) {
                org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.instance = ((org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor) (org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.context.getBean("blTransactionLifecycleMonitor")));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4204, isAtLeastOneTransactionManagerEnabled())) {
                timer.schedule(new java.util.TimerTask() {
                    @java.lang.Override
                    public void run() {
                        groomInProgressTransactionInfos();
                    }
                }, perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4205, loggingPollingResolution), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4206, loggingPollingResolution));
                enabled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4207, true);
            }
            isStarted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4208, true);
        }
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.context = applicationContext;
    }

    @java.lang.Override
    public boolean isAutoStartup() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4209, true);
    }

    @java.lang.Override
    public void stop(java.lang.Runnable callback) {
        stop();
        callback.run();
    }

    @java.lang.Override
    public void start() {
    }

    @java.lang.Override
    public void stop() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4210, enabled)) {
            timer.cancel();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4212, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4211, infos.isEmpty()))))) {
                org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.support("Logging any in-progress TransactionInfo instances at the time of container shutdown");
                java.lang.Long currentTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4213, ((long) (java.lang.System.currentTimeMillis())));
                for (java.util.Map.Entry<java.lang.Integer, org.broadleafcommerce.common.persistence.transaction.TransactionInfo> entry : infos.entrySet()) {
                    org.broadleafcommerce.common.persistence.transaction.TransactionInfo info = entry.getValue();
                    org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.support(java.lang.String.format(("TRANSACTIONMONITOR(5) - This transaction was detected as in-progress at the time " + "of shutdown. The TransactionInfo has been alive for %s milliseconds. Logging TransactionInfo: \n%s"), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4214, (currentTime - (info.getStartTime()))), info.toString()));
                }
            }
        }
    }

    @java.lang.Override
    public boolean isRunning() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4215, isStarted);
    }

    @java.lang.Override
    public int getPhase() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4216, 0);
    }

    @java.lang.Override
    public boolean isAsynchronous() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4217, false);
    }

    @java.lang.Override
    public void onApplicationEvent(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent event) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4218, enabled)) {
            switch (event.getLifecycle()) {
                case BEGIN :
                    {
                        javax.persistence.EntityManager em = getEntityManagerFromTransactionObject(event.getParams()[0]);
                        if (em != null) {
                            if (((countMax) == (-1)) || ((infos.size()) <= (countMax))) {
                                org.broadleafcommerce.common.persistence.transaction.TransactionInfo info = new org.broadleafcommerce.common.persistence.transaction.TransactionInfo(em, ((org.springframework.transaction.TransactionDefinition) (event.getParams()[1])), useCompression, abbreviateStatements, abbreviateStatementsLength, decompressStatementForLog, maxQueryListSize);
                                if ((modifiers) != null) {
                                    for (org.broadleafcommerce.common.persistence.transaction.TransactionInfoCustomModifier modifier : modifiers) {
                                        modifier.modify(info);
                                    }
                                }
                                infos.put(em.hashCode(), info);
                            }else {
                                org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.debug(java.lang.String.format("Not monitoring new transaction. Current monitored transaction count exceeds maximum: %s", countMax));
                            }
                        }
                        break;
                    }
                case COMMIT :
                    {
                        finalizeTransaction(event);
                        break;
                    }
                case ROLLBACK :
                    {
                        finalizeTransaction(event);
                        break;
                    }
                case GET_TRANSACTION :
                    break;
                default :
                    throw new java.lang.UnsupportedOperationException(((event.getLifecycle().toString()) + " not supported"));
            }
        }
    }

    @java.lang.Override
    public void log(java.lang.String statement) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4219, enabled)) {
            org.broadleafcommerce.common.persistence.transaction.TransactionInfo info = getCurrentTransactionInfo();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4220, (info != null))) {
                info.logStatement(statement);
            }
        }
    }

    @java.lang.Override
    public java.lang.String decompressLogLine(java.lang.String compressedFromLog) throws java.io.IOException {
        java.lang.String fixed = compressedFromLog;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4221, fixed.contains(":"))) {
            fixed = fixed.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4224, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4222, fixed.indexOf(":"))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4223, 1)))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4225, fixed.length()));
        }
        fixed = fixed.trim();
        return org.broadleafcommerce.common.persistence.transaction.CompressedItem.decompress(org.springframework.security.crypto.codec.Base64.decode(fixed.getBytes()));
    }

    public long getLoggingThreshold() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4226, loggingThreshold);
    }

    public void setLoggingThreshold(long loggingThreshold) {
        this.loggingThreshold = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4227, loggingThreshold);
    }

    public long getStuckThreshold() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4228, stuckThreshold);
    }

    public void setStuckThreshold(long stuckThreshold) {
        this.stuckThreshold = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4229, stuckThreshold);
    }

    public long getLoggingPollingResolution() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4230, loggingPollingResolution);
    }

    public void setLoggingPollingResolution(long loggingPollingResolution) {
        this.loggingPollingResolution = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4231, loggingPollingResolution);
    }

    public long getLoggingReportingLagThreshold() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4232, loggingReportingLagThreshold);
    }

    public void setLoggingReportingLagThreshold(long loggingReportingLagThreshold) {
        this.loggingReportingLagThreshold = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4233, loggingReportingLagThreshold);
    }

    public int getCountMax() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4234, countMax);
    }

    public void setCountMax(int countMax) {
        this.countMax = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4235, countMax);
    }

    public boolean isUseCompression() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4236, useCompression);
    }

    public void setUseCompression(boolean useCompression) {
        this.useCompression = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4237, useCompression);
    }

    protected void groomInProgressTransactionInfos() {
        java.util.List<java.lang.Integer> infosToRemove = new java.util.ArrayList<>();
        try {
            java.util.Map<java.lang.Integer, org.broadleafcommerce.common.persistence.transaction.TransactionInfo> shallow = new java.util.HashMap<>();
            shallow.putAll(infos);
            for (java.util.Map.Entry<java.lang.Integer, org.broadleafcommerce.common.persistence.transaction.TransactionInfo> entry : shallow.entrySet()) {
                long currentTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4238, java.lang.System.currentTimeMillis());
                org.broadleafcommerce.common.persistence.transaction.TransactionInfo info = entry.getValue();
                java.lang.Thread thread = info.getThread();
                java.lang.StackTraceElement[] elements = compileThreadInformation(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4239, currentTime), info, thread);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4243, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4242, detectExpiry(infosToRemove, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4240, entry.getKey()), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4241, currentTime), info, elements)))))) {
                    detectLeakage(infosToRemove, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4244, entry.getKey()), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4245, currentTime), info);
                }
            }
        } finally {
            for (java.lang.Integer key : infosToRemove) {
                infos.remove(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4246, key));
            }
        }
    }

    protected boolean detectLeakage(java.util.List<java.lang.Integer> infosToRemove, java.lang.Integer key, long currentTime, org.broadleafcommerce.common.persistence.transaction.TransactionInfo info) {
        boolean removed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4247, false);
        boolean isPossiblyLeaked = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4250, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4248, (currentTime - (info.getLastLogTime())))) >= (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4249, loggingReportingLagThreshold))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4251, isPossiblyLeaked)) {
            try {
                info.setFaultStateDetected(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4252, true));
                org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.support(java.lang.String.format(("TRANSACTIONMONITOR(1) - The thread associated with the tested TransactionInfo is not " + ((("considered stuck, but the TransactionInfo has been alive for %s milliseconds and a SQL " + "statement has not been reported against the tracked EntityManager in %s milliseconds. ") + "This could indicate the thread has moved on and the transaction was not properly finalized. ") + "Logging TransactionInfo: \n%s")), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4253, (currentTime - (info.getStartTime()))), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4254, (currentTime - (info.getLastLogTime()))), info.toString()));
            } finally {
                infosToRemove.add(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4255, key));
                removed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4256, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4257, removed);
    }

    protected boolean detectExpiry(java.util.List<java.lang.Integer> infosToRemove, java.lang.Integer key, long currentTime, org.broadleafcommerce.common.persistence.transaction.TransactionInfo info, java.lang.StackTraceElement[] elements) {
        boolean removed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4258, false);
        boolean isExpired = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4261, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4259, (currentTime - (info.getStartTime())))) >= (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4260, loggingThreshold))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4262, isExpired)) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4263, ((info.getStuckThreadStartTime()) != null))) {
                boolean isStuck = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4266, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4264, (currentTime - (info.getStuckThreadStartTime())))) >= (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4265, stuckThreshold))));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4267, isStuck)) {
                    try {
                        java.lang.String currentStack = "UNKNOWN";
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4269, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4268, org.apache.commons.lang3.ArrayUtils.isEmpty(elements)))))) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("Stack\n");
                            for (java.lang.StackTraceElement element : elements) {
                                sb.append("\tat ");
                                sb.append(element);
                                sb.append("\n");
                            }
                            currentStack = sb.toString();
                        }
                        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.support(java.lang.String.format(("TRANSACTIONMONITOR(4) - The thread associated with the tested TransactionInfo may be " + ("stuck. The TransactionInfo has been alive for %s milliseconds and the associated thread stack " + "has not changed in %s milliseconds. Logging TransactionInfo and current stack: \n%s currentStack=\'%s\'")), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4270, (currentTime - (info.getStartTime()))), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4271, (currentTime - (info.getStuckThreadStartTime()))), info.toString(), currentStack));
                    } finally {
                        infosToRemove.add(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4272, key));
                        removed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4273, true);
                    }
                }
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4274, (!(info.getFaultStateDetected())))) {
                    org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.support(java.lang.String.format(("TRANSACTIONMONITOR(2) - The thread associated with the tested TransactionInfo is not " + ("considered stuck yet, but the TransactionInfo has been alive for %s milliseconds. " + "This could indicate a overly long transaction time. Logging TransactionInfo: \n%s")), perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4275, (currentTime - (info.getStartTime()))), info.toString()));
                }
            }
            info.setFaultStateDetected(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4276, true));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4277, removed);
    }

    protected java.lang.StackTraceElement[] compileThreadInformation(long currentTime, org.broadleafcommerce.common.persistence.transaction.TransactionInfo info, java.lang.Thread thread) {
        java.lang.StackTraceElement[] elements = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4280, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4278, (thread != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4279, thread.isAlive()))))) {
            elements = thread.getStackTrace();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4282, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4281, org.apache.commons.lang3.ArrayUtils.isEmpty(elements)))))) {
                java.lang.StackTraceElement top = elements[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4283, 0)];
                java.lang.String currentStackElement = top.toString();
                boolean isWaiting = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4286, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4284, ((thread.getState()) == (java.lang.Thread.State.WAITING)))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4285, ((thread.getState()) == (java.lang.Thread.State.TIMED_WAITING))))));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4292, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4289, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4287, ((info.getCurrentStackElement()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4288, info.getCurrentStackElement().equals(currentStackElement)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4291, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4290, isWaiting)))))))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4293, ((info.getStuckThreadStartTime()) == null))) {
                        info.setStuckThreadStartTime(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4294, currentTime));
                    }
                }else {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4295, ((info.getStuckThreadStartTime()) != null))) {
                        info.setStuckThreadStartTime(null);
                    }
                    info.setCurrentStackElement(currentStackElement);
                }
            }
        }
        return elements;
    }

    protected void finalizeTransaction(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleEvent event) {
        java.lang.String finalizationType = event.getLifecycle().name();
        org.springframework.transaction.support.DefaultTransactionStatus status = ((org.springframework.transaction.support.DefaultTransactionStatus) (event.getParams()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4296, 0)]));
        javax.persistence.EntityManager em = getEntityManagerFromTransactionObject(status.getTransaction());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4297, (em != null))) {
            java.lang.Integer hashcode = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4298, ((int) (em.hashCode())));
            org.broadleafcommerce.common.persistence.transaction.TransactionInfo info = infos.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4299, hashcode));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4300, (info != null))) {
                try {
                    java.lang.Throwable finalizationException = event.getException();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4301, (finalizationException != null))) {
                        info.setFaultStateDetected(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4302, true));
                        java.io.StringWriter sw = new java.io.StringWriter();
                        finalizationException.printStackTrace(new java.io.PrintWriter(sw));
                        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.logger.support(java.lang.String.format(((("TRANSACTIONMONITOR(3) - Exception during " + finalizationType) + " finalization. Logging ") + "TransactionInfo and finalization exception: \n%s finalizationStack=\'%s\'"), info.toString(), sw.toString()));
                    }
                } finally {
                    infos.remove(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4303, hashcode));
                }
            }
        }
    }

    protected javax.persistence.EntityManager getEntityManagerFromTransactionObject(java.lang.Object transactionObject) {
        javax.persistence.EntityManager response;
        try {
            java.lang.Class<?> jpaTransactionObject = transactionObject.getClass();
            java.lang.reflect.Method getEntityManagerHolder = jpaTransactionObject.getMethod("getEntityManagerHolder");
            getEntityManagerHolder.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4304, true));
            org.springframework.orm.jpa.EntityManagerHolder emh = ((org.springframework.orm.jpa.EntityManagerHolder) (getEntityManagerHolder.invoke(transactionObject)));
            response = emh.getEntityManager();
        } catch (java.lang.Exception e) {
            throw org.broadleafcommerce.common.exception.ExceptionHelper.refineException(e);
        }
        return response;
    }

    protected org.broadleafcommerce.common.persistence.transaction.TransactionInfo getCurrentTransactionInfo() {
        org.broadleafcommerce.common.persistence.transaction.TransactionInfo response = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4305, ((transactionManagers) != null))) {
            for (org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager transactionManager : transactionManagers) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4306, transactionManager.isEnabled())) {
                    org.springframework.orm.jpa.EntityManagerHolder emHolder = ((org.springframework.orm.jpa.EntityManagerHolder) (org.springframework.transaction.support.TransactionSynchronizationManager.getResource(transactionManager.getEntityManagerFactory())));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4311, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4309, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4307, (emHolder != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4308, emHolder.isOpen()))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4310, emHolder.isSynchronizedWithTransaction()))))) {
                        response = infos.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4312, emHolder.getEntityManager().hashCode()));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4313, (response != null))) {
                            break;
                        }
                    }
                }
            }
        }
        return response;
    }

    protected boolean isAtLeastOneTransactionManagerEnabled() {
        boolean enabled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4314, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4315, ((transactionManagers) != null))) {
            for (org.broadleafcommerce.common.persistence.transaction.LifecycleAwareJpaTransactionManager transactionManager : transactionManagers) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4316, transactionManager.isEnabled())) {
                    enabled = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4317, true);
                    break;
                }
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4318, enabled);
    }

    public static perturbation.location.PerturbationLocation __L4201;

    public static perturbation.location.PerturbationLocation __L4202;

    public static perturbation.location.PerturbationLocation __L4203;

    public static perturbation.location.PerturbationLocation __L4204;

    public static perturbation.location.PerturbationLocation __L4205;

    public static perturbation.location.PerturbationLocation __L4206;

    public static perturbation.location.PerturbationLocation __L4207;

    public static perturbation.location.PerturbationLocation __L4208;

    public static perturbation.location.PerturbationLocation __L4209;

    public static perturbation.location.PerturbationLocation __L4210;

    public static perturbation.location.PerturbationLocation __L4211;

    public static perturbation.location.PerturbationLocation __L4212;

    public static perturbation.location.PerturbationLocation __L4213;

    public static perturbation.location.PerturbationLocation __L4214;

    public static perturbation.location.PerturbationLocation __L4215;

    public static perturbation.location.PerturbationLocation __L4216;

    public static perturbation.location.PerturbationLocation __L4217;

    public static perturbation.location.PerturbationLocation __L4218;

    public static perturbation.location.PerturbationLocation __L4219;

    public static perturbation.location.PerturbationLocation __L4220;

    public static perturbation.location.PerturbationLocation __L4221;

    public static perturbation.location.PerturbationLocation __L4222;

    public static perturbation.location.PerturbationLocation __L4223;

    public static perturbation.location.PerturbationLocation __L4224;

    public static perturbation.location.PerturbationLocation __L4225;

    public static perturbation.location.PerturbationLocation __L4226;

    public static perturbation.location.PerturbationLocation __L4227;

    public static perturbation.location.PerturbationLocation __L4228;

    public static perturbation.location.PerturbationLocation __L4229;

    public static perturbation.location.PerturbationLocation __L4230;

    public static perturbation.location.PerturbationLocation __L4231;

    public static perturbation.location.PerturbationLocation __L4232;

    public static perturbation.location.PerturbationLocation __L4233;

    public static perturbation.location.PerturbationLocation __L4234;

    public static perturbation.location.PerturbationLocation __L4235;

    public static perturbation.location.PerturbationLocation __L4236;

    public static perturbation.location.PerturbationLocation __L4237;

    public static perturbation.location.PerturbationLocation __L4238;

    public static perturbation.location.PerturbationLocation __L4239;

    public static perturbation.location.PerturbationLocation __L4240;

    public static perturbation.location.PerturbationLocation __L4241;

    public static perturbation.location.PerturbationLocation __L4242;

    public static perturbation.location.PerturbationLocation __L4243;

    public static perturbation.location.PerturbationLocation __L4244;

    public static perturbation.location.PerturbationLocation __L4245;

    public static perturbation.location.PerturbationLocation __L4246;

    public static perturbation.location.PerturbationLocation __L4247;

    public static perturbation.location.PerturbationLocation __L4248;

    public static perturbation.location.PerturbationLocation __L4249;

    public static perturbation.location.PerturbationLocation __L4250;

    public static perturbation.location.PerturbationLocation __L4251;

    public static perturbation.location.PerturbationLocation __L4252;

    public static perturbation.location.PerturbationLocation __L4253;

    public static perturbation.location.PerturbationLocation __L4254;

    public static perturbation.location.PerturbationLocation __L4255;

    public static perturbation.location.PerturbationLocation __L4256;

    public static perturbation.location.PerturbationLocation __L4257;

    public static perturbation.location.PerturbationLocation __L4258;

    public static perturbation.location.PerturbationLocation __L4259;

    public static perturbation.location.PerturbationLocation __L4260;

    public static perturbation.location.PerturbationLocation __L4261;

    public static perturbation.location.PerturbationLocation __L4262;

    public static perturbation.location.PerturbationLocation __L4263;

    public static perturbation.location.PerturbationLocation __L4264;

    public static perturbation.location.PerturbationLocation __L4265;

    public static perturbation.location.PerturbationLocation __L4266;

    public static perturbation.location.PerturbationLocation __L4267;

    public static perturbation.location.PerturbationLocation __L4268;

    public static perturbation.location.PerturbationLocation __L4269;

    public static perturbation.location.PerturbationLocation __L4270;

    public static perturbation.location.PerturbationLocation __L4271;

    public static perturbation.location.PerturbationLocation __L4272;

    public static perturbation.location.PerturbationLocation __L4273;

    public static perturbation.location.PerturbationLocation __L4274;

    public static perturbation.location.PerturbationLocation __L4275;

    public static perturbation.location.PerturbationLocation __L4276;

    public static perturbation.location.PerturbationLocation __L4277;

    public static perturbation.location.PerturbationLocation __L4278;

    public static perturbation.location.PerturbationLocation __L4279;

    public static perturbation.location.PerturbationLocation __L4280;

    public static perturbation.location.PerturbationLocation __L4281;

    public static perturbation.location.PerturbationLocation __L4282;

    public static perturbation.location.PerturbationLocation __L4283;

    public static perturbation.location.PerturbationLocation __L4284;

    public static perturbation.location.PerturbationLocation __L4285;

    public static perturbation.location.PerturbationLocation __L4286;

    public static perturbation.location.PerturbationLocation __L4287;

    public static perturbation.location.PerturbationLocation __L4288;

    public static perturbation.location.PerturbationLocation __L4289;

    public static perturbation.location.PerturbationLocation __L4290;

    public static perturbation.location.PerturbationLocation __L4291;

    public static perturbation.location.PerturbationLocation __L4292;

    public static perturbation.location.PerturbationLocation __L4293;

    public static perturbation.location.PerturbationLocation __L4294;

    public static perturbation.location.PerturbationLocation __L4295;

    public static perturbation.location.PerturbationLocation __L4296;

    public static perturbation.location.PerturbationLocation __L4297;

    public static perturbation.location.PerturbationLocation __L4298;

    public static perturbation.location.PerturbationLocation __L4299;

    public static perturbation.location.PerturbationLocation __L4300;

    public static perturbation.location.PerturbationLocation __L4301;

    public static perturbation.location.PerturbationLocation __L4302;

    public static perturbation.location.PerturbationLocation __L4303;

    public static perturbation.location.PerturbationLocation __L4304;

    public static perturbation.location.PerturbationLocation __L4305;

    public static perturbation.location.PerturbationLocation __L4306;

    public static perturbation.location.PerturbationLocation __L4307;

    public static perturbation.location.PerturbationLocation __L4308;

    public static perturbation.location.PerturbationLocation __L4309;

    public static perturbation.location.PerturbationLocation __L4310;

    public static perturbation.location.PerturbationLocation __L4311;

    public static perturbation.location.PerturbationLocation __L4312;

    public static perturbation.location.PerturbationLocation __L4313;

    public static perturbation.location.PerturbationLocation __L4314;

    public static perturbation.location.PerturbationLocation __L4315;

    public static perturbation.location.PerturbationLocation __L4316;

    public static perturbation.location.PerturbationLocation __L4317;

    public static perturbation.location.PerturbationLocation __L4318;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:194)", 4201, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:194)", 4202, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:195)", 4203, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:198)", 4204, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:204)", 4205, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:204)", 4206, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:205)", 4207, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:207)", 4208, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:218)", 4209, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:234)", 4210, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:236)", 4211, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:236)", 4212, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:238)", 4213, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:243)", 4214, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:251)", 4215, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:256)", 4216, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:261)", 4217, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:266)", 4218, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:306)", 4219, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:308)", 4220, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:317)", 4221, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:318)", 4222, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:318)", 4223, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:318)", 4224, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:318)", 4225, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:326)", 4226, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:330)", 4227, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:334)", 4228, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:338)", 4229, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:342)", 4230, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:346)", 4231, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:350)", 4232, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:354)", 4233, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:358)", 4234, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:362)", 4235, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:366)", 4236, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:370)", 4237, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:379)", 4238, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:382)", 4239, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:383)", 4240, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:383)", 4241, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:383)", 4242, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:383)", 4243, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:384)", 4244, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:384)", 4245, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:389)", 4246, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:395)", 4247, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:396)", 4248, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:396)", 4249, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:396)", 4250, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:397)", 4251, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:399)", 4252, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:405)", 4253, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:405)", 4254, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:407)", 4255, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:408)", 4256, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:411)", 4257, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:415)", 4258, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:416)", 4259, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:416)", 4260, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:416)", 4261, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:417)", 4262, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:418)", 4263, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:419)", 4264, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:419)", 4265, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:419)", 4266, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:420)", 4267, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:423)", 4268, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:423)", 4269, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:436)", 4270, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:436)", 4271, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:438)", 4272, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:439)", 4273, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:443)", 4274, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:447)", 4275, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:450)", 4276, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:452)", 4277, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:457)", 4278, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4279 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:457)", 4279, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4280 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:457)", 4280, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4281 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:459)", 4281, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4282 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:459)", 4282, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4283 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:460)", 4283, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4284 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:463)", 4284, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4285 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:463)", 4285, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4286 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:463)", 4286, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4287 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:464)", 4287, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4288 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:464)", 4288, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4289 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:464)", 4289, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4290 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:464)", 4290, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4291 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:464)", 4291, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4292 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:464)", 4292, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4293 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:465)", 4293, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4294 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:466)", 4294, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4295 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:469)", 4295, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4296 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:481)", 4296, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4297 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:483)", 4297, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4298 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:484)", 4298, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4299 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:485)", 4299, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4300 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:486)", 4300, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:489)", 4301, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:490)", 4302, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:498)", 4303, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:509)", 4304, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:520)", 4305, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:522)", 4306, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4307 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:524)", 4307, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4308 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:524)", 4308, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4309 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:524)", 4309, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4310 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:524)", 4310, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4311 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:524)", 4311, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4312 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:525)", 4312, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4313 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:526)", 4313, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4314 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:537)", 4314, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4315 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:538)", 4315, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4316 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:540)", 4316, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4317 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:541)", 4317, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.__L4318 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/TransactionLifecycleMonitor.java:546)", 4318, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.TransactionLifecycleMonitor.initPerturbationLocation0();
    }
}

