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
package org.broadleafcommerce.common.extensibility.jpa.copy;


public abstract class AbstractClassTransformer implements org.springframework.beans.factory.InitializingBean {
    protected static final java.util.Set<java.lang.String> alreadyLoadedClasses = new java.util.HashSet<java.lang.String>();

    protected java.util.List<java.lang.String> preLoadClassNamePatterns = new java.util.ArrayList<java.lang.String>();

    @java.lang.Override
    public void afterPropertiesSet() throws java.lang.Exception {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1969, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1966, ((preLoadClassNamePatterns) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1968, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1967, preLoadClassNamePatterns.isEmpty())))))))) {
            synchronized(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.alreadyLoadedClasses) {
                for (java.lang.String className : preLoadClassNamePatterns) {
                    try {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1971, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1970, org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.alreadyLoadedClasses.contains(className)))))) {
                            java.lang.Class.forName(className);
                            org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.alreadyLoadedClasses.add(className);
                        }
                    } catch (java.lang.ClassNotFoundException e) {
                        throw new java.lang.RuntimeException((("Unable to force load class with name " + className) + " in the DirectCopyClassTransformer"), e);
                    }
                }
            }
        }
    }

    public void setPreLoadClassNamePatterns(java.util.List<java.lang.String> fullyQualifiedClassNames) {
        this.preLoadClassNamePatterns = fullyQualifiedClassNames;
    }

    public static perturbation.location.PerturbationLocation __L1966;

    public static perturbation.location.PerturbationLocation __L1967;

    public static perturbation.location.PerturbationLocation __L1968;

    public static perturbation.location.PerturbationLocation __L1969;

    public static perturbation.location.PerturbationLocation __L1970;

    public static perturbation.location.PerturbationLocation __L1971;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AbstractClassTransformer.java:41)", 1966, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AbstractClassTransformer.java:41)", 1967, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AbstractClassTransformer.java:41)", 1968, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AbstractClassTransformer.java:41)", 1969, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AbstractClassTransformer.java:45)", 1970, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.__L1971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AbstractClassTransformer.java:45)", 1971, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer.initPerturbationLocation0();
    }
}

