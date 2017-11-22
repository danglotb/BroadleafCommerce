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
package org.broadleafcommerce.common.sandbox.domain;


public class SandBoxType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.sandbox.domain.SandBoxType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.sandbox.domain.SandBoxType>();

    public static final org.broadleafcommerce.common.sandbox.domain.SandBoxType USER = new org.broadleafcommerce.common.sandbox.domain.SandBoxType("USER", "User", 3);

    public static final org.broadleafcommerce.common.sandbox.domain.SandBoxType APPROVAL = new org.broadleafcommerce.common.sandbox.domain.SandBoxType("APPROVAL", "Approval", 2);

    public static final org.broadleafcommerce.common.sandbox.domain.SandBoxType DEFAULT = new org.broadleafcommerce.common.sandbox.domain.SandBoxType("DEFAULT", "Default", 2);

    public static final org.broadleafcommerce.common.sandbox.domain.SandBoxType PRODUCTION = new org.broadleafcommerce.common.sandbox.domain.SandBoxType("PRODUCTION", "Production", 1);

    private java.lang.String type;

    private java.lang.String friendlyType;

    private java.lang.Integer priority;

    public static org.broadleafcommerce.common.sandbox.domain.SandBoxType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.sandbox.domain.SandBoxType.TYPES.get(type);
    }

    public SandBoxType() {
    }

    public SandBoxType(final java.lang.String type, final java.lang.String friendlyType, final java.lang.Integer priority) {
        this.friendlyType = friendlyType;
        this.priority = priority;
        setType(type);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    public java.lang.Integer getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4731, priority);
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4733, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4732, org.broadleafcommerce.common.sandbox.domain.SandBoxType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.sandbox.domain.SandBoxType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.sandbox.domain.SandBoxType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4734, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4735, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4743, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4738, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4736, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4737, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4742, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4739, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4740, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4741, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4744, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4745, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4746, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4747, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4748, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4750, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4749, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4751, false);

        org.broadleafcommerce.common.sandbox.domain.SandBoxType other = ((org.broadleafcommerce.common.sandbox.domain.SandBoxType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4752, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4753, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4754, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4756, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4755, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4757, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4758, true);
    }

    public static perturbation.location.PerturbationLocation __L4731;

    public static perturbation.location.PerturbationLocation __L4732;

    public static perturbation.location.PerturbationLocation __L4733;

    public static perturbation.location.PerturbationLocation __L4734;

    public static perturbation.location.PerturbationLocation __L4735;

    public static perturbation.location.PerturbationLocation __L4736;

    public static perturbation.location.PerturbationLocation __L4737;

    public static perturbation.location.PerturbationLocation __L4738;

    public static perturbation.location.PerturbationLocation __L4739;

    public static perturbation.location.PerturbationLocation __L4740;

    public static perturbation.location.PerturbationLocation __L4741;

    public static perturbation.location.PerturbationLocation __L4742;

    public static perturbation.location.PerturbationLocation __L4743;

    public static perturbation.location.PerturbationLocation __L4744;

    public static perturbation.location.PerturbationLocation __L4745;

    public static perturbation.location.PerturbationLocation __L4746;

    public static perturbation.location.PerturbationLocation __L4747;

    public static perturbation.location.PerturbationLocation __L4748;

    public static perturbation.location.PerturbationLocation __L4749;

    public static perturbation.location.PerturbationLocation __L4750;

    public static perturbation.location.PerturbationLocation __L4751;

    public static perturbation.location.PerturbationLocation __L4752;

    public static perturbation.location.PerturbationLocation __L4753;

    public static perturbation.location.PerturbationLocation __L4754;

    public static perturbation.location.PerturbationLocation __L4755;

    public static perturbation.location.PerturbationLocation __L4756;

    public static perturbation.location.PerturbationLocation __L4757;

    public static perturbation.location.PerturbationLocation __L4758;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:69)", 4731, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:74)", 4732, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:74)", 4733, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:83)", 4734, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:84)", 4735, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4736, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4737, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4738, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4739, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4740, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4741, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4742, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:85)", 4743, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:86)", 4744, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:91)", 4745, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:92)", 4746, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:93)", 4747, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:94)", 4748, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:95)", 4749, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:95)", 4750, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:96)", 4751, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:98)", 4752, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:99)", 4753, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:100)", 4754, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:101)", 4755, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:101)", 4756, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:102)", 4757, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.__L4758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxType.java:103)", 4758, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sandbox.domain.SandBoxType.initPerturbationLocation0();
    }
}

