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


public class DayOfWeekType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.time.DayOfWeekType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.time.DayOfWeekType>();

    public static final org.broadleafcommerce.common.time.DayOfWeekType SUNDAY = new org.broadleafcommerce.common.time.DayOfWeekType("1", "Sunday");

    public static final org.broadleafcommerce.common.time.DayOfWeekType MONDAY = new org.broadleafcommerce.common.time.DayOfWeekType("2", "Monday");

    public static final org.broadleafcommerce.common.time.DayOfWeekType TUESDAY = new org.broadleafcommerce.common.time.DayOfWeekType("3", "Tuesday");

    public static final org.broadleafcommerce.common.time.DayOfWeekType WEDNESDAY = new org.broadleafcommerce.common.time.DayOfWeekType("4", "Wednesday");

    public static final org.broadleafcommerce.common.time.DayOfWeekType THURSDAY = new org.broadleafcommerce.common.time.DayOfWeekType("5", "Thursday");

    public static final org.broadleafcommerce.common.time.DayOfWeekType FRIDAY = new org.broadleafcommerce.common.time.DayOfWeekType("6", "Friday");

    public static final org.broadleafcommerce.common.time.DayOfWeekType SATURDAY = new org.broadleafcommerce.common.time.DayOfWeekType("7", "Saturday");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.time.DayOfWeekType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.time.DayOfWeekType.TYPES.get(type);
    }

    public DayOfWeekType() {
    }

    public DayOfWeekType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5662, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5661, org.broadleafcommerce.common.time.DayOfWeekType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.time.DayOfWeekType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.time.DayOfWeekType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5663, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5664, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5672, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5667, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5665, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5666, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5671, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5668, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5669, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5670, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.DayOfWeekType.__L5673, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5674, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5675, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5676, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5677, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5679, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5678, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5680, false);

        org.broadleafcommerce.common.time.DayOfWeekType other = ((org.broadleafcommerce.common.time.DayOfWeekType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5681, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5682, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5683, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5685, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5684, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5686, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.DayOfWeekType.__L5687, true);
    }

    public static perturbation.location.PerturbationLocation __L5661;

    public static perturbation.location.PerturbationLocation __L5662;

    public static perturbation.location.PerturbationLocation __L5663;

    public static perturbation.location.PerturbationLocation __L5664;

    public static perturbation.location.PerturbationLocation __L5665;

    public static perturbation.location.PerturbationLocation __L5666;

    public static perturbation.location.PerturbationLocation __L5667;

    public static perturbation.location.PerturbationLocation __L5668;

    public static perturbation.location.PerturbationLocation __L5669;

    public static perturbation.location.PerturbationLocation __L5670;

    public static perturbation.location.PerturbationLocation __L5671;

    public static perturbation.location.PerturbationLocation __L5672;

    public static perturbation.location.PerturbationLocation __L5673;

    public static perturbation.location.PerturbationLocation __L5674;

    public static perturbation.location.PerturbationLocation __L5675;

    public static perturbation.location.PerturbationLocation __L5676;

    public static perturbation.location.PerturbationLocation __L5677;

    public static perturbation.location.PerturbationLocation __L5678;

    public static perturbation.location.PerturbationLocation __L5679;

    public static perturbation.location.PerturbationLocation __L5680;

    public static perturbation.location.PerturbationLocation __L5681;

    public static perturbation.location.PerturbationLocation __L5682;

    public static perturbation.location.PerturbationLocation __L5683;

    public static perturbation.location.PerturbationLocation __L5684;

    public static perturbation.location.PerturbationLocation __L5685;

    public static perturbation.location.PerturbationLocation __L5686;

    public static perturbation.location.PerturbationLocation __L5687;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.DayOfWeekType.__L5661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:71)", 5661, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:71)", 5662, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:80)", 5663, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:81)", 5664, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5665, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5666, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5667, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5668, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5669, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5670, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5671, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:82)", 5672, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:83)", 5673, "Numerical");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:88)", 5674, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:89)", 5675, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:90)", 5676, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:91)", 5677, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:92)", 5678, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:92)", 5679, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:93)", 5680, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:95)", 5681, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:96)", 5682, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:97)", 5683, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:98)", 5684, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:98)", 5685, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:99)", 5686, "Boolean");
        org.broadleafcommerce.common.time.DayOfWeekType.__L5687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/DayOfWeekType.java:100)", 5687, "Boolean");
    }

    static {
        org.broadleafcommerce.common.time.DayOfWeekType.initPerturbationLocation0();
    }
}

