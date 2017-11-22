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


public class HourOfDayType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.time.HourOfDayType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.time.HourOfDayType>();

    public static final org.broadleafcommerce.common.time.HourOfDayType ZERO = new org.broadleafcommerce.common.time.HourOfDayType("0", "00");

    public static final org.broadleafcommerce.common.time.HourOfDayType ONE = new org.broadleafcommerce.common.time.HourOfDayType("1", "01");

    public static final org.broadleafcommerce.common.time.HourOfDayType TWO = new org.broadleafcommerce.common.time.HourOfDayType("2", "02");

    public static final org.broadleafcommerce.common.time.HourOfDayType THREE = new org.broadleafcommerce.common.time.HourOfDayType("3", "03");

    public static final org.broadleafcommerce.common.time.HourOfDayType FOUR = new org.broadleafcommerce.common.time.HourOfDayType("4", "04");

    public static final org.broadleafcommerce.common.time.HourOfDayType FIVE = new org.broadleafcommerce.common.time.HourOfDayType("5", "05");

    public static final org.broadleafcommerce.common.time.HourOfDayType SIX = new org.broadleafcommerce.common.time.HourOfDayType("6", "06");

    public static final org.broadleafcommerce.common.time.HourOfDayType SEVEN = new org.broadleafcommerce.common.time.HourOfDayType("7", "07");

    public static final org.broadleafcommerce.common.time.HourOfDayType EIGHT = new org.broadleafcommerce.common.time.HourOfDayType("8", "08");

    public static final org.broadleafcommerce.common.time.HourOfDayType NINE = new org.broadleafcommerce.common.time.HourOfDayType("9", "09");

    public static final org.broadleafcommerce.common.time.HourOfDayType TEN = new org.broadleafcommerce.common.time.HourOfDayType("10", "10");

    public static final org.broadleafcommerce.common.time.HourOfDayType ELEVEN = new org.broadleafcommerce.common.time.HourOfDayType("11", "11");

    public static final org.broadleafcommerce.common.time.HourOfDayType TWELVE = new org.broadleafcommerce.common.time.HourOfDayType("12", "12");

    public static final org.broadleafcommerce.common.time.HourOfDayType THIRTEEN = new org.broadleafcommerce.common.time.HourOfDayType("13", "13");

    public static final org.broadleafcommerce.common.time.HourOfDayType FOURTEEN = new org.broadleafcommerce.common.time.HourOfDayType("14", "14");

    public static final org.broadleafcommerce.common.time.HourOfDayType FIFTEEN = new org.broadleafcommerce.common.time.HourOfDayType("15", "15");

    public static final org.broadleafcommerce.common.time.HourOfDayType SIXTEEN = new org.broadleafcommerce.common.time.HourOfDayType("16", "16");

    public static final org.broadleafcommerce.common.time.HourOfDayType SEVENTEEN = new org.broadleafcommerce.common.time.HourOfDayType("17", "17");

    public static final org.broadleafcommerce.common.time.HourOfDayType EIGHTEEN = new org.broadleafcommerce.common.time.HourOfDayType("18", "18");

    public static final org.broadleafcommerce.common.time.HourOfDayType NINETEEN = new org.broadleafcommerce.common.time.HourOfDayType("19", "19");

    public static final org.broadleafcommerce.common.time.HourOfDayType TWENTY = new org.broadleafcommerce.common.time.HourOfDayType("20", "20");

    public static final org.broadleafcommerce.common.time.HourOfDayType TWENTYONE = new org.broadleafcommerce.common.time.HourOfDayType("21", "21");

    public static final org.broadleafcommerce.common.time.HourOfDayType TWNETYTWO = new org.broadleafcommerce.common.time.HourOfDayType("22", "22");

    public static final org.broadleafcommerce.common.time.HourOfDayType TWENTYTHREE = new org.broadleafcommerce.common.time.HourOfDayType("23", "23");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.time.HourOfDayType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.time.HourOfDayType.TYPES.get(type);
    }

    public HourOfDayType() {
    }

    public HourOfDayType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5691, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5690, org.broadleafcommerce.common.time.HourOfDayType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.time.HourOfDayType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.time.HourOfDayType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5692, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5693, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5701, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5696, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5694, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5695, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5700, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5697, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5698, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5699, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.HourOfDayType.__L5702, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5703, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5704, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5705, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5706, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5708, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5707, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5709, false);

        org.broadleafcommerce.common.time.HourOfDayType other = ((org.broadleafcommerce.common.time.HourOfDayType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5710, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5711, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5712, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5714, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5713, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5715, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.HourOfDayType.__L5716, true);
    }

    public static perturbation.location.PerturbationLocation __L5690;

    public static perturbation.location.PerturbationLocation __L5691;

    public static perturbation.location.PerturbationLocation __L5692;

    public static perturbation.location.PerturbationLocation __L5693;

    public static perturbation.location.PerturbationLocation __L5694;

    public static perturbation.location.PerturbationLocation __L5695;

    public static perturbation.location.PerturbationLocation __L5696;

    public static perturbation.location.PerturbationLocation __L5697;

    public static perturbation.location.PerturbationLocation __L5698;

    public static perturbation.location.PerturbationLocation __L5699;

    public static perturbation.location.PerturbationLocation __L5700;

    public static perturbation.location.PerturbationLocation __L5701;

    public static perturbation.location.PerturbationLocation __L5702;

    public static perturbation.location.PerturbationLocation __L5703;

    public static perturbation.location.PerturbationLocation __L5704;

    public static perturbation.location.PerturbationLocation __L5705;

    public static perturbation.location.PerturbationLocation __L5706;

    public static perturbation.location.PerturbationLocation __L5707;

    public static perturbation.location.PerturbationLocation __L5708;

    public static perturbation.location.PerturbationLocation __L5709;

    public static perturbation.location.PerturbationLocation __L5710;

    public static perturbation.location.PerturbationLocation __L5711;

    public static perturbation.location.PerturbationLocation __L5712;

    public static perturbation.location.PerturbationLocation __L5713;

    public static perturbation.location.PerturbationLocation __L5714;

    public static perturbation.location.PerturbationLocation __L5715;

    public static perturbation.location.PerturbationLocation __L5716;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.HourOfDayType.__L5690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:88)", 5690, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:88)", 5691, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:97)", 5692, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:98)", 5693, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5694, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5695, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5696, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5697, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5698, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5699, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5700, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:99)", 5701, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:100)", 5702, "Numerical");
        org.broadleafcommerce.common.time.HourOfDayType.__L5703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:105)", 5703, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:106)", 5704, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:107)", 5705, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:108)", 5706, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:109)", 5707, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:109)", 5708, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:110)", 5709, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:112)", 5710, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:113)", 5711, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:114)", 5712, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:115)", 5713, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:115)", 5714, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:116)", 5715, "Boolean");
        org.broadleafcommerce.common.time.HourOfDayType.__L5716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/HourOfDayType.java:117)", 5716, "Boolean");
    }

    static {
        org.broadleafcommerce.common.time.HourOfDayType.initPerturbationLocation0();
    }
}

