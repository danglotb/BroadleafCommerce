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
package org.broadleafcommerce.common.util;


public class StopWatch {
    private static final int STATE_UNSTARTED = 0;

    private static final int STATE_RUNNING = 1;

    private static final int STATE_STOPPED = 2;

    private static final int STATE_SUSPENDED = 3;

    private static final int STATE_UNSPLIT = 10;

    private static final int STATE_SPLIT = 11;

    private int runningState = org.broadleafcommerce.common.util.StopWatch.STATE_UNSTARTED;

    private int splitState = org.broadleafcommerce.common.util.StopWatch.STATE_UNSPLIT;

    private long startTime = ((long) (-1));

    private long stopTime = ((long) (-1));

    public StopWatch() {
        start();
        split();
    }

    public org.broadleafcommerce.common.util.StopWatch start() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6513, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6511, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6512, org.broadleafcommerce.common.util.StopWatch.STATE_STOPPED))))) {
            throw new java.lang.IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6516, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6514, this.runningState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6515, org.broadleafcommerce.common.util.StopWatch.STATE_UNSTARTED))))) {
            throw new java.lang.IllegalStateException("Stopwatch already started. ");
        }
        this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6518, ((long) (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6517, 1)))));
        this.startTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6519, java.lang.System.currentTimeMillis());
        this.runningState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6520, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING);
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch stop() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6527, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6523, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6521, this.runningState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6522, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6526, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6524, this.runningState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6525, org.broadleafcommerce.common.util.StopWatch.STATE_SUSPENDED)))))))) {
            throw new java.lang.IllegalStateException("Stopwatch is not running. ");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6530, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6528, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6529, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING))))) {
            this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6531, java.lang.System.currentTimeMillis());
        }
        this.runningState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6532, org.broadleafcommerce.common.util.StopWatch.STATE_STOPPED);
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch reset() {
        this.runningState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6533, org.broadleafcommerce.common.util.StopWatch.STATE_UNSTARTED);
        this.splitState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6534, org.broadleafcommerce.common.util.StopWatch.STATE_UNSPLIT);
        this.startTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6536, ((long) (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6535, 1)))));
        this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6538, ((long) (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6537, 1)))));
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch split() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6541, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6539, this.runningState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6540, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING))))) {
            throw new java.lang.IllegalStateException("Stopwatch is not running. ");
        }
        this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6542, java.lang.System.currentTimeMillis());
        this.splitState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6543, org.broadleafcommerce.common.util.StopWatch.STATE_SPLIT);
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch unsplit() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6546, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6544, this.splitState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6545, org.broadleafcommerce.common.util.StopWatch.STATE_SPLIT))))) {
            throw new java.lang.IllegalStateException("Stopwatch has not been split. ");
        }
        this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6548, ((long) (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6547, 1)))));
        this.splitState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6549, org.broadleafcommerce.common.util.StopWatch.STATE_UNSPLIT);
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch suspend() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6552, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6550, this.runningState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6551, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING))))) {
            throw new java.lang.IllegalStateException("Stopwatch must be running to suspend. ");
        }
        this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6553, java.lang.System.currentTimeMillis());
        this.runningState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6554, org.broadleafcommerce.common.util.StopWatch.STATE_SUSPENDED);
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch resume() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6557, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6555, this.runningState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6556, org.broadleafcommerce.common.util.StopWatch.STATE_SUSPENDED))))) {
            throw new java.lang.IllegalStateException("Stopwatch must be suspended to resume. ");
        }
        this.startTime += perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6560, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6558, java.lang.System.currentTimeMillis())) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6559, this.stopTime))));
        this.stopTime = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6562, ((long) (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6561, 1)))));
        this.runningState = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6563, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING);
        return this;
    }

    public long getTime() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6570, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6566, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6564, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6565, org.broadleafcommerce.common.util.StopWatch.STATE_STOPPED))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6569, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6567, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6568, org.broadleafcommerce.common.util.StopWatch.STATE_SUSPENDED)))))))) {
            return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6573, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6571, this.stopTime)) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6572, this.startTime))));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6576, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6574, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6575, org.broadleafcommerce.common.util.StopWatch.STATE_UNSTARTED))))) {
                return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6577, 0);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6580, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6578, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6579, org.broadleafcommerce.common.util.StopWatch.STATE_RUNNING))))) {
                    return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6583, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6581, java.lang.System.currentTimeMillis())) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6582, this.startTime))));
                }


        throw new java.lang.RuntimeException("Illegal running state has occured. ");
    }

    public long getSplitTime() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6586, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6584, this.splitState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6585, org.broadleafcommerce.common.util.StopWatch.STATE_SPLIT))))) {
            throw new java.lang.IllegalStateException("Stopwatch must be split to get the split time. ");
        }
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6589, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6587, this.stopTime)) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6588, this.startTime))));
    }

    public long getLapTime() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6592, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6590, this.splitState)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6591, org.broadleafcommerce.common.util.StopWatch.STATE_SPLIT))))) {
            throw new java.lang.IllegalStateException("Stopwatch must be split to get the lap time. ");
        }
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6595, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6593, java.lang.System.currentTimeMillis())) - (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6594, this.stopTime))));
    }

    public long getStartTime() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StopWatch.__L6598, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6596, this.runningState)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StopWatch.__L6597, org.broadleafcommerce.common.util.StopWatch.STATE_UNSTARTED))))) {
            throw new java.lang.IllegalStateException("Stopwatch has not been started");
        }
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6599, this.startTime);
    }

    public java.lang.String toString() {
        return org.apache.commons.lang.time.DurationFormatUtils.formatDurationHMS(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6600, getTime()));
    }

    public java.lang.String toSplitString() {
        return org.apache.commons.lang.time.DurationFormatUtils.formatDurationHMS(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6601, getSplitTime()));
    }

    public java.lang.String toLapString() {
        return org.apache.commons.lang.time.DurationFormatUtils.formatDurationHMS(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StopWatch.__L6602, getLapTime()));
    }

    public org.broadleafcommerce.common.util.StopWatch printString(java.lang.String msg) {
        java.lang.System.out.println(((msg + ": ") + (toString())));
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch printSplitString(java.lang.String msg) {
        java.lang.System.out.println(((msg + ": ") + (toSplitString())));
        return this;
    }

    public org.broadleafcommerce.common.util.StopWatch printLapString(java.lang.String msg) {
        java.lang.System.out.println(((msg + ": ") + (toLapString())));
        return this;
    }

    public static perturbation.location.PerturbationLocation __L6511;

    public static perturbation.location.PerturbationLocation __L6512;

    public static perturbation.location.PerturbationLocation __L6513;

    public static perturbation.location.PerturbationLocation __L6514;

    public static perturbation.location.PerturbationLocation __L6515;

    public static perturbation.location.PerturbationLocation __L6516;

    public static perturbation.location.PerturbationLocation __L6517;

    public static perturbation.location.PerturbationLocation __L6518;

    public static perturbation.location.PerturbationLocation __L6519;

    public static perturbation.location.PerturbationLocation __L6520;

    public static perturbation.location.PerturbationLocation __L6521;

    public static perturbation.location.PerturbationLocation __L6522;

    public static perturbation.location.PerturbationLocation __L6523;

    public static perturbation.location.PerturbationLocation __L6524;

    public static perturbation.location.PerturbationLocation __L6525;

    public static perturbation.location.PerturbationLocation __L6526;

    public static perturbation.location.PerturbationLocation __L6527;

    public static perturbation.location.PerturbationLocation __L6528;

    public static perturbation.location.PerturbationLocation __L6529;

    public static perturbation.location.PerturbationLocation __L6530;

    public static perturbation.location.PerturbationLocation __L6531;

    public static perturbation.location.PerturbationLocation __L6532;

    public static perturbation.location.PerturbationLocation __L6533;

    public static perturbation.location.PerturbationLocation __L6534;

    public static perturbation.location.PerturbationLocation __L6535;

    public static perturbation.location.PerturbationLocation __L6536;

    public static perturbation.location.PerturbationLocation __L6537;

    public static perturbation.location.PerturbationLocation __L6538;

    public static perturbation.location.PerturbationLocation __L6539;

    public static perturbation.location.PerturbationLocation __L6540;

    public static perturbation.location.PerturbationLocation __L6541;

    public static perturbation.location.PerturbationLocation __L6542;

    public static perturbation.location.PerturbationLocation __L6543;

    public static perturbation.location.PerturbationLocation __L6544;

    public static perturbation.location.PerturbationLocation __L6545;

    public static perturbation.location.PerturbationLocation __L6546;

    public static perturbation.location.PerturbationLocation __L6547;

    public static perturbation.location.PerturbationLocation __L6548;

    public static perturbation.location.PerturbationLocation __L6549;

    public static perturbation.location.PerturbationLocation __L6550;

    public static perturbation.location.PerturbationLocation __L6551;

    public static perturbation.location.PerturbationLocation __L6552;

    public static perturbation.location.PerturbationLocation __L6553;

    public static perturbation.location.PerturbationLocation __L6554;

    public static perturbation.location.PerturbationLocation __L6555;

    public static perturbation.location.PerturbationLocation __L6556;

    public static perturbation.location.PerturbationLocation __L6557;

    public static perturbation.location.PerturbationLocation __L6558;

    public static perturbation.location.PerturbationLocation __L6559;

    public static perturbation.location.PerturbationLocation __L6560;

    public static perturbation.location.PerturbationLocation __L6561;

    public static perturbation.location.PerturbationLocation __L6562;

    public static perturbation.location.PerturbationLocation __L6563;

    public static perturbation.location.PerturbationLocation __L6564;

    public static perturbation.location.PerturbationLocation __L6565;

    public static perturbation.location.PerturbationLocation __L6566;

    public static perturbation.location.PerturbationLocation __L6567;

    public static perturbation.location.PerturbationLocation __L6568;

    public static perturbation.location.PerturbationLocation __L6569;

    public static perturbation.location.PerturbationLocation __L6570;

    public static perturbation.location.PerturbationLocation __L6571;

    public static perturbation.location.PerturbationLocation __L6572;

    public static perturbation.location.PerturbationLocation __L6573;

    public static perturbation.location.PerturbationLocation __L6574;

    public static perturbation.location.PerturbationLocation __L6575;

    public static perturbation.location.PerturbationLocation __L6576;

    public static perturbation.location.PerturbationLocation __L6577;

    public static perturbation.location.PerturbationLocation __L6578;

    public static perturbation.location.PerturbationLocation __L6579;

    public static perturbation.location.PerturbationLocation __L6580;

    public static perturbation.location.PerturbationLocation __L6581;

    public static perturbation.location.PerturbationLocation __L6582;

    public static perturbation.location.PerturbationLocation __L6583;

    public static perturbation.location.PerturbationLocation __L6584;

    public static perturbation.location.PerturbationLocation __L6585;

    public static perturbation.location.PerturbationLocation __L6586;

    public static perturbation.location.PerturbationLocation __L6587;

    public static perturbation.location.PerturbationLocation __L6588;

    public static perturbation.location.PerturbationLocation __L6589;

    public static perturbation.location.PerturbationLocation __L6590;

    public static perturbation.location.PerturbationLocation __L6591;

    public static perturbation.location.PerturbationLocation __L6592;

    public static perturbation.location.PerturbationLocation __L6593;

    public static perturbation.location.PerturbationLocation __L6594;

    public static perturbation.location.PerturbationLocation __L6595;

    public static perturbation.location.PerturbationLocation __L6596;

    public static perturbation.location.PerturbationLocation __L6597;

    public static perturbation.location.PerturbationLocation __L6598;

    public static perturbation.location.PerturbationLocation __L6599;

    public static perturbation.location.PerturbationLocation __L6600;

    public static perturbation.location.PerturbationLocation __L6601;

    public static perturbation.location.PerturbationLocation __L6602;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.StopWatch.__L6511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:47)", 6511, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:47)", 6512, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:47)", 6513, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:50)", 6514, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:50)", 6515, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:50)", 6516, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:53)", 6517, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:53)", 6518, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:54)", 6519, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:55)", 6520, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6521, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6522, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6523, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6524, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6525, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6526, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:60)", 6527, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:63)", 6528, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:63)", 6529, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:63)", 6530, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:64)", 6531, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:66)", 6532, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:71)", 6533, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:72)", 6534, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:73)", 6535, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:73)", 6536, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6537 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:74)", 6537, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6538 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:74)", 6538, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6539 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:79)", 6539, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6540 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:79)", 6540, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6541 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:79)", 6541, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6542 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:82)", 6542, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6543 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:83)", 6543, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6544 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:88)", 6544, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6545 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:88)", 6545, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6546 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:88)", 6546, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6547 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:91)", 6547, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6548 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:91)", 6548, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6549 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:92)", 6549, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6550 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:97)", 6550, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6551 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:97)", 6551, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6552 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:97)", 6552, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6553 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:100)", 6553, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6554 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:101)", 6554, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6555 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:106)", 6555, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6556 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:106)", 6556, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6557 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:106)", 6557, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6558 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:109)", 6558, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6559 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:109)", 6559, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6560 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:109)", 6560, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6561 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:110)", 6561, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6562 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:110)", 6562, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:111)", 6563, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6564, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6565, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6566, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6567, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6568, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6569, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:116)", 6570, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:117)", 6571, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:117)", 6572, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:117)", 6573, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:118)", 6574, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:118)", 6575, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:118)", 6576, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:119)", 6577, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:120)", 6578, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:120)", 6579, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:120)", 6580, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:121)", 6581, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:121)", 6582, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:121)", 6583, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:127)", 6584, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:127)", 6585, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:127)", 6586, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:130)", 6587, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:130)", 6588, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:130)", 6589, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:134)", 6590, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:134)", 6591, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:134)", 6592, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:137)", 6593, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:137)", 6594, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:137)", 6595, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:141)", 6596, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:141)", 6597, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:141)", 6598, "Boolean");
        org.broadleafcommerce.common.util.StopWatch.__L6599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:144)", 6599, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:148)", 6600, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:152)", 6601, "Numerical");
        org.broadleafcommerce.common.util.StopWatch.__L6602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StopWatch.java:156)", 6602, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.StopWatch.initPerturbationLocation0();
    }
}

