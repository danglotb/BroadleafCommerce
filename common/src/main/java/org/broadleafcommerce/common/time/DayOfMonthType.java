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
package org.broadleafcommerce.common.time;


public class DayOfMonthType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.time.DayOfMonthType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.time.DayOfMonthType>();

    public static final org.broadleafcommerce.common.time.DayOfMonthType ONE = new org.broadleafcommerce.common.time.DayOfMonthType("1", "01");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWO = new org.broadleafcommerce.common.time.DayOfMonthType("2", "02");

    public static final org.broadleafcommerce.common.time.DayOfMonthType THREE = new org.broadleafcommerce.common.time.DayOfMonthType("3", "03");

    public static final org.broadleafcommerce.common.time.DayOfMonthType FOUR = new org.broadleafcommerce.common.time.DayOfMonthType("4", "04");

    public static final org.broadleafcommerce.common.time.DayOfMonthType FIVE = new org.broadleafcommerce.common.time.DayOfMonthType("5", "05");

    public static final org.broadleafcommerce.common.time.DayOfMonthType SIX = new org.broadleafcommerce.common.time.DayOfMonthType("6", "06");

    public static final org.broadleafcommerce.common.time.DayOfMonthType SEVEN = new org.broadleafcommerce.common.time.DayOfMonthType("7", "07");

    public static final org.broadleafcommerce.common.time.DayOfMonthType EIGHT = new org.broadleafcommerce.common.time.DayOfMonthType("8", "08");

    public static final org.broadleafcommerce.common.time.DayOfMonthType NINE = new org.broadleafcommerce.common.time.DayOfMonthType("9", "09");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TEN = new org.broadleafcommerce.common.time.DayOfMonthType("10", "10");

    public static final org.broadleafcommerce.common.time.DayOfMonthType ELEVEN = new org.broadleafcommerce.common.time.DayOfMonthType("11", "11");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWELVE = new org.broadleafcommerce.common.time.DayOfMonthType("12", "12");

    public static final org.broadleafcommerce.common.time.DayOfMonthType THIRTEEN = new org.broadleafcommerce.common.time.DayOfMonthType("13", "13");

    public static final org.broadleafcommerce.common.time.DayOfMonthType FOURTEEN = new org.broadleafcommerce.common.time.DayOfMonthType("14", "14");

    public static final org.broadleafcommerce.common.time.DayOfMonthType FIFTEEN = new org.broadleafcommerce.common.time.DayOfMonthType("15", "15");

    public static final org.broadleafcommerce.common.time.DayOfMonthType SIXTEEN = new org.broadleafcommerce.common.time.DayOfMonthType("16", "16");

    public static final org.broadleafcommerce.common.time.DayOfMonthType SEVENTEEN = new org.broadleafcommerce.common.time.DayOfMonthType("17", "17");

    public static final org.broadleafcommerce.common.time.DayOfMonthType EIGHTEEN = new org.broadleafcommerce.common.time.DayOfMonthType("18", "18");

    public static final org.broadleafcommerce.common.time.DayOfMonthType NINETEEN = new org.broadleafcommerce.common.time.DayOfMonthType("19", "19");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTY = new org.broadleafcommerce.common.time.DayOfMonthType("20", "20");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYONE = new org.broadleafcommerce.common.time.DayOfMonthType("21", "21");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWNETYTWO = new org.broadleafcommerce.common.time.DayOfMonthType("22", "22");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYTHREE = new org.broadleafcommerce.common.time.DayOfMonthType("23", "23");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYFOUR = new org.broadleafcommerce.common.time.DayOfMonthType("24", "24");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYFIVE = new org.broadleafcommerce.common.time.DayOfMonthType("25", "25");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYSIX = new org.broadleafcommerce.common.time.DayOfMonthType("26", "26");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYSEVEN = new org.broadleafcommerce.common.time.DayOfMonthType("27", "27");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYEIGHT = new org.broadleafcommerce.common.time.DayOfMonthType("28", "28");

    public static final org.broadleafcommerce.common.time.DayOfMonthType TWENTYNINE = new org.broadleafcommerce.common.time.DayOfMonthType("29", "29");

    public static final org.broadleafcommerce.common.time.DayOfMonthType THIRTY = new org.broadleafcommerce.common.time.DayOfMonthType("30", "30");

    public static final org.broadleafcommerce.common.time.DayOfMonthType THIRTYONE = new org.broadleafcommerce.common.time.DayOfMonthType("31", "31");

    public static final org.broadleafcommerce.common.time.DayOfMonthType END_OF_MONTH = new org.broadleafcommerce.common.time.DayOfMonthType("END_OF_MONTH", "END_OF_MONTH");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.time.DayOfMonthType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.time.DayOfMonthType.TYPES.get(type);
    }

    public DayOfMonthType() {
    }

    public DayOfMonthType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5635, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5634, org.broadleafcommerce.common.time.DayOfMonthType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.time.DayOfMonthType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.time.DayOfMonthType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5636, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5637, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5645, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5640, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5638, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5639, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5644, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5641, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5642, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5643, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfMonthType.__L5646, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5647, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5648, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5649, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5650, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5652, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5651, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5653, false);

        org.broadleafcommerce.common.time.DayOfMonthType other = ((org.broadleafcommerce.common.time.DayOfMonthType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5654, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5655, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5656, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5658, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5657, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5659, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfMonthType.__L5660, true);
    }

    public static perturbation.location.PerturbationLocation __L5634;

    public static perturbation.location.PerturbationLocation __L5635;

    public static perturbation.location.PerturbationLocation __L5636;

    public static perturbation.location.PerturbationLocation __L5637;

    public static perturbation.location.PerturbationLocation __L5638;

    public static perturbation.location.PerturbationLocation __L5639;

    public static perturbation.location.PerturbationLocation __L5640;

    public static perturbation.location.PerturbationLocation __L5641;

    public static perturbation.location.PerturbationLocation __L5642;

    public static perturbation.location.PerturbationLocation __L5643;

    public static perturbation.location.PerturbationLocation __L5644;

    public static perturbation.location.PerturbationLocation __L5645;

    public static perturbation.location.PerturbationLocation __L5646;

    public static perturbation.location.PerturbationLocation __L5647;

    public static perturbation.location.PerturbationLocation __L5648;

    public static perturbation.location.PerturbationLocation __L5649;

    public static perturbation.location.PerturbationLocation __L5650;

    public static perturbation.location.PerturbationLocation __L5651;

    public static perturbation.location.PerturbationLocation __L5652;

    public static perturbation.location.PerturbationLocation __L5653;

    public static perturbation.location.PerturbationLocation __L5654;

    public static perturbation.location.PerturbationLocation __L5655;

    public static perturbation.location.PerturbationLocation __L5656;

    public static perturbation.location.PerturbationLocation __L5657;

    public static perturbation.location.PerturbationLocation __L5658;

    public static perturbation.location.PerturbationLocation __L5659;

    public static perturbation.location.PerturbationLocation __L5660;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.DayOfMonthType.__L5634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:96)", 5634, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:96)", 5635, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:105)", 5636, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:106)", 5637, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5638, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5639, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5640, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5641, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5642, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5643, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5644, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:107)", 5645, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:108)", 5646, "Numerical");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:113)", 5647, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:114)", 5648, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:115)", 5649, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:116)", 5650, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:117)", 5651, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:117)", 5652, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:118)", 5653, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:120)", 5654, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:121)", 5655, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:122)", 5656, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:123)", 5657, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:123)", 5658, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:124)", 5659, "Boolean");
        org.broadleafcommerce.common.time.DayOfMonthType.__L5660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfMonthType.java:125)", 5660, "Boolean");
    }

    static {
        org.broadleafcommerce.common.time.DayOfMonthType.initPerturbationLocation0();
    }
}

