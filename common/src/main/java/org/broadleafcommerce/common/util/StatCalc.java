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


public class StatCalc {
    private int count;

    private double sum;

    private double squareSum;

    private double max = java.lang.Double.NEGATIVE_INFINITY;

    private double min = java.lang.Double.POSITIVE_INFINITY;

    public void enter(double num) {
        perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StatCalc.__L6507, ((count)++));
        sum += num;
        squareSum += num * num;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StatCalc.__L6508, (num > (max))))
            max = num;

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StatCalc.__L6509, (num < (min))))
            min = num;

    }

    public int getCount() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StatCalc.__L6510, count);
    }

    public double getSum() {
        return sum;
    }

    public double getMean() {
        return (sum) / (count);
    }

    public double getStandardDeviation() {
        double mean = getMean();
        return java.lang.Math.sqrt((((squareSum) / (count)) - (mean * mean)));
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public static perturbation.location.PerturbationLocation __L6507;

    public static perturbation.location.PerturbationLocation __L6508;

    public static perturbation.location.PerturbationLocation __L6509;

    public static perturbation.location.PerturbationLocation __L6510;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.StatCalc.__L6507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StatCalc.java:30)", 6507, "Numerical");
        org.broadleafcommerce.common.util.StatCalc.__L6508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StatCalc.java:33)", 6508, "Boolean");
        org.broadleafcommerce.common.util.StatCalc.__L6509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StatCalc.java:35)", 6509, "Boolean");
        org.broadleafcommerce.common.util.StatCalc.__L6510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StatCalc.java:41)", 6510, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.StatCalc.initPerturbationLocation0();
    }
}

