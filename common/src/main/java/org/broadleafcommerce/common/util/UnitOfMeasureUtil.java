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


public class UnitOfMeasureUtil {
    public static java.math.BigDecimal convertKilogramsToPounds(java.math.BigDecimal kilograms) {
        return kilograms.multiply(java.math.BigDecimal.valueOf(0.45359237));
    }

    public static java.math.BigDecimal convertPoundsToKilograms(java.math.BigDecimal pounds) {
        return pounds.multiply(java.math.BigDecimal.valueOf(2.20462262185));
    }

    public static java.math.BigDecimal convertPoundsToOunces(java.math.BigDecimal pounds) {
        return pounds.multiply(java.math.BigDecimal.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6810, 16)));
    }

    public static java.math.BigDecimal convertOuncesToPounds(java.math.BigDecimal ounces) {
        return ounces.multiply(java.math.BigDecimal.valueOf(0.0625));
    }

    public static java.math.BigDecimal convertFeetToMeters(java.math.BigDecimal feet) {
        return feet.multiply(java.math.BigDecimal.valueOf(0.3048));
    }

    public static java.math.BigDecimal convertMetersToFeet(java.math.BigDecimal meters) {
        return meters.multiply(java.math.BigDecimal.valueOf(3.28084));
    }

    public static java.math.BigDecimal convertInchesToFeet(java.math.BigDecimal inches) {
        return inches.multiply(java.math.BigDecimal.valueOf(0.083333));
    }

    public static java.math.BigDecimal convertFeetToInches(java.math.BigDecimal feet) {
        return feet.multiply(java.math.BigDecimal.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6811, 12)));
    }

    public static int findWholePounds(java.math.BigDecimal weight, org.broadleafcommerce.common.util.WeightUnitOfMeasureType type) {
        weight = org.broadleafcommerce.common.util.UnitOfMeasureUtil.findPounds(weight, type);
        int pounds = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6812, java.lang.Double.valueOf(java.lang.Math.floor(weight.doubleValue())).intValue());
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6813, pounds);
    }

    public static java.math.BigDecimal findPounds(java.math.BigDecimal weight, org.broadleafcommerce.common.util.WeightUnitOfMeasureType type) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6814, type.equals(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.KILOGRAMS))) {
            weight = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertKilogramsToPounds(weight);
        }
        return weight;
    }

    public static java.math.BigDecimal findRemainingOunces(java.math.BigDecimal weight, org.broadleafcommerce.common.util.WeightUnitOfMeasureType type) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6815, type.equals(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.KILOGRAMS))) {
            weight = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertKilogramsToPounds(weight);
        }
        double fractionalPounds = (weight.doubleValue()) - (java.lang.Math.floor(weight.doubleValue()));
        java.math.BigDecimal ounces = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertPoundsToOunces(java.math.BigDecimal.valueOf(fractionalPounds));
        return ounces;
    }

    public static java.math.BigDecimal findOunces(java.math.BigDecimal weight, org.broadleafcommerce.common.util.WeightUnitOfMeasureType type) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6816, type.equals(org.broadleafcommerce.common.util.WeightUnitOfMeasureType.KILOGRAMS))) {
            weight = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertKilogramsToPounds(weight);
        }
        java.math.BigDecimal ounces = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertPoundsToOunces(weight);
        return ounces;
    }

    public static java.math.BigDecimal findInches(java.math.BigDecimal dimension, org.broadleafcommerce.common.util.DimensionUnitOfMeasureType type) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6817, type.equals(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.CENTIMETERS))) {
            dimension = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertFeetToInches(org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertMetersToFeet(dimension.multiply(java.math.BigDecimal.valueOf(0.01))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6818, type.equals(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.METERS))) {
            dimension = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertFeetToInches(org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertMetersToFeet(dimension));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6819, type.equals(org.broadleafcommerce.common.util.DimensionUnitOfMeasureType.FEET))) {
            dimension = org.broadleafcommerce.common.util.UnitOfMeasureUtil.convertFeetToInches(dimension);
        }
        return dimension;
    }

    public static perturbation.location.PerturbationLocation __L6810;

    public static perturbation.location.PerturbationLocation __L6811;

    public static perturbation.location.PerturbationLocation __L6812;

    public static perturbation.location.PerturbationLocation __L6813;

    public static perturbation.location.PerturbationLocation __L6814;

    public static perturbation.location.PerturbationLocation __L6815;

    public static perturbation.location.PerturbationLocation __L6816;

    public static perturbation.location.PerturbationLocation __L6817;

    public static perturbation.location.PerturbationLocation __L6818;

    public static perturbation.location.PerturbationLocation __L6819;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:34)", 6810, "Numerical");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:54)", 6811, "Numerical");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:59)", 6812, "Numerical");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:60)", 6813, "Numerical");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:64)", 6814, "Boolean");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:71)", 6815, "Boolean");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:80)", 6816, "Boolean");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:88)", 6817, "Boolean");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:91)", 6818, "Boolean");
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.__L6819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UnitOfMeasureUtil.java:94)", 6819, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.UnitOfMeasureUtil.initPerturbationLocation0();
    }
}

