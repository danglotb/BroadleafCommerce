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


public class MonthType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.time.MonthType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.time.MonthType>();

    public static final org.broadleafcommerce.common.time.MonthType JANUARY = new org.broadleafcommerce.common.time.MonthType("1", "January");

    public static final org.broadleafcommerce.common.time.MonthType FEBRUARY = new org.broadleafcommerce.common.time.MonthType("2", "February");

    public static final org.broadleafcommerce.common.time.MonthType MARCH = new org.broadleafcommerce.common.time.MonthType("3", "March");

    public static final org.broadleafcommerce.common.time.MonthType APRIL = new org.broadleafcommerce.common.time.MonthType("4", "April");

    public static final org.broadleafcommerce.common.time.MonthType MAY = new org.broadleafcommerce.common.time.MonthType("5", "May");

    public static final org.broadleafcommerce.common.time.MonthType JUNE = new org.broadleafcommerce.common.time.MonthType("6", "June");

    public static final org.broadleafcommerce.common.time.MonthType JULY = new org.broadleafcommerce.common.time.MonthType("7", "July");

    public static final org.broadleafcommerce.common.time.MonthType AUGUST = new org.broadleafcommerce.common.time.MonthType("8", "August");

    public static final org.broadleafcommerce.common.time.MonthType SEPTEMBER = new org.broadleafcommerce.common.time.MonthType("9", "September");

    public static final org.broadleafcommerce.common.time.MonthType OCTOBER = new org.broadleafcommerce.common.time.MonthType("10", "October");

    public static final org.broadleafcommerce.common.time.MonthType NOVEMBER = new org.broadleafcommerce.common.time.MonthType("11", "November");

    public static final org.broadleafcommerce.common.time.MonthType DECEMBER = new org.broadleafcommerce.common.time.MonthType("12", "December");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.time.MonthType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.time.MonthType.TYPES.get(type);
    }

    public MonthType() {
    }

    public MonthType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5745, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5744, org.broadleafcommerce.common.time.MonthType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.time.MonthType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.time.MonthType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5746, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5747, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5755, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5750, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5748, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5749, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5754, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5751, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5752, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5753, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MonthType.__L5756, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5757, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5758, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5759, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5760, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5762, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5761, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5763, false);

        org.broadleafcommerce.common.time.MonthType other = ((org.broadleafcommerce.common.time.MonthType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5764, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5765, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5766, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5768, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5767, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5769, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MonthType.__L5770, true);
    }

    public static perturbation.location.PerturbationLocation __L5744;

    public static perturbation.location.PerturbationLocation __L5745;

    public static perturbation.location.PerturbationLocation __L5746;

    public static perturbation.location.PerturbationLocation __L5747;

    public static perturbation.location.PerturbationLocation __L5748;

    public static perturbation.location.PerturbationLocation __L5749;

    public static perturbation.location.PerturbationLocation __L5750;

    public static perturbation.location.PerturbationLocation __L5751;

    public static perturbation.location.PerturbationLocation __L5752;

    public static perturbation.location.PerturbationLocation __L5753;

    public static perturbation.location.PerturbationLocation __L5754;

    public static perturbation.location.PerturbationLocation __L5755;

    public static perturbation.location.PerturbationLocation __L5756;

    public static perturbation.location.PerturbationLocation __L5757;

    public static perturbation.location.PerturbationLocation __L5758;

    public static perturbation.location.PerturbationLocation __L5759;

    public static perturbation.location.PerturbationLocation __L5760;

    public static perturbation.location.PerturbationLocation __L5761;

    public static perturbation.location.PerturbationLocation __L5762;

    public static perturbation.location.PerturbationLocation __L5763;

    public static perturbation.location.PerturbationLocation __L5764;

    public static perturbation.location.PerturbationLocation __L5765;

    public static perturbation.location.PerturbationLocation __L5766;

    public static perturbation.location.PerturbationLocation __L5767;

    public static perturbation.location.PerturbationLocation __L5768;

    public static perturbation.location.PerturbationLocation __L5769;

    public static perturbation.location.PerturbationLocation __L5770;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.MonthType.__L5744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:76)", 5744, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:76)", 5745, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:85)", 5746, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:86)", 5747, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5748, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5749, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5750, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5751, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5752, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5753, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5754, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:87)", 5755, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:88)", 5756, "Numerical");
        org.broadleafcommerce.common.time.MonthType.__L5757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:93)", 5757, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:94)", 5758, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:95)", 5759, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:96)", 5760, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:97)", 5761, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:97)", 5762, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:98)", 5763, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:100)", 5764, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:101)", 5765, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:102)", 5766, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:103)", 5767, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:103)", 5768, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:104)", 5769, "Boolean");
        org.broadleafcommerce.common.time.MonthType.__L5770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MonthType.java:105)", 5770, "Boolean");
    }

    static {
        org.broadleafcommerce.common.time.MonthType.initPerturbationLocation0();
    }
}

