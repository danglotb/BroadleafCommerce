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
package org.broadleafcommerce.common.persistence;


public class TargetModeType implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.persistence.TargetModeType> TYPES = new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.persistence.TargetModeType>();

    public static final org.broadleafcommerce.common.persistence.TargetModeType SANDBOX = new org.broadleafcommerce.common.persistence.TargetModeType("sandbox", "entity manager target for the sandbox datasource");

    public static final org.broadleafcommerce.common.persistence.TargetModeType STAGE = new org.broadleafcommerce.common.persistence.TargetModeType("stage", "entity manager target for the stage datasource");

    public static final org.broadleafcommerce.common.persistence.TargetModeType PRODUCTION = new org.broadleafcommerce.common.persistence.TargetModeType("production", "entity manager target for the production datasource");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.persistence.TargetModeType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.persistence.TargetModeType.TYPES.get(type);
    }

    public static java.util.Map<java.lang.String, org.broadleafcommerce.common.persistence.TargetModeType> getTypes() {
        return org.broadleafcommerce.common.persistence.TargetModeType.TYPES;
    }

    public TargetModeType() {
    }

    public TargetModeType(final java.lang.String type, final java.lang.String friendlyType) {
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
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4459, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4458, org.broadleafcommerce.common.persistence.TargetModeType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.persistence.TargetModeType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4460, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4461, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4469, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4464, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4462, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4463, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4468, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4465, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4466, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4467, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.TargetModeType.__L4470, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4471, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4472, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4473, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4474, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4476, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4475, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4477, false);

        org.broadleafcommerce.common.persistence.TargetModeType other = ((org.broadleafcommerce.common.persistence.TargetModeType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4478, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4479, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4480, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4482, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4481, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4483, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.TargetModeType.__L4484, true);
    }

    public static perturbation.location.PerturbationLocation __L4458;

    public static perturbation.location.PerturbationLocation __L4459;

    public static perturbation.location.PerturbationLocation __L4460;

    public static perturbation.location.PerturbationLocation __L4461;

    public static perturbation.location.PerturbationLocation __L4462;

    public static perturbation.location.PerturbationLocation __L4463;

    public static perturbation.location.PerturbationLocation __L4464;

    public static perturbation.location.PerturbationLocation __L4465;

    public static perturbation.location.PerturbationLocation __L4466;

    public static perturbation.location.PerturbationLocation __L4467;

    public static perturbation.location.PerturbationLocation __L4468;

    public static perturbation.location.PerturbationLocation __L4469;

    public static perturbation.location.PerturbationLocation __L4470;

    public static perturbation.location.PerturbationLocation __L4471;

    public static perturbation.location.PerturbationLocation __L4472;

    public static perturbation.location.PerturbationLocation __L4473;

    public static perturbation.location.PerturbationLocation __L4474;

    public static perturbation.location.PerturbationLocation __L4475;

    public static perturbation.location.PerturbationLocation __L4476;

    public static perturbation.location.PerturbationLocation __L4477;

    public static perturbation.location.PerturbationLocation __L4478;

    public static perturbation.location.PerturbationLocation __L4479;

    public static perturbation.location.PerturbationLocation __L4480;

    public static perturbation.location.PerturbationLocation __L4481;

    public static perturbation.location.PerturbationLocation __L4482;

    public static perturbation.location.PerturbationLocation __L4483;

    public static perturbation.location.PerturbationLocation __L4484;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.TargetModeType.__L4458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:69)", 4458, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:69)", 4459, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:76)", 4460, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:77)", 4461, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4462, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4463, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4464, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4465, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4466, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4467, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4468, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:78)", 4469, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:79)", 4470, "Numerical");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:84)", 4471, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:85)", 4472, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:86)", 4473, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:87)", 4474, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:88)", 4475, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:88)", 4476, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:89)", 4477, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:91)", 4478, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:92)", 4479, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:93)", 4480, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:94)", 4481, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:94)", 4482, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:95)", 4483, "Boolean");
        org.broadleafcommerce.common.persistence.TargetModeType.__L4484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/TargetModeType.java:96)", 4484, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.TargetModeType.initPerturbationLocation0();
    }
}

