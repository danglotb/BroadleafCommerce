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
package org.broadleafcommerce.common.demo;


public class MTCondition implements org.springframework.context.annotation.Condition {
    public static final java.lang.String[] CONDITION_CLASSES = new java.lang.String[]{ "com.broadleafcommerce.tenant.persistence.CatalogFilterEnabler" };

    @java.lang.Override
    public boolean matches(org.springframework.context.annotation.ConditionContext context, org.springframework.core.type.AnnotatedTypeMetadata metadata) {
        boolean present = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L848, false);
        int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.MTCondition.__L849, 0);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L855, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L851, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L850, present))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L854, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.MTCondition.__L852, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.MTCondition.__L853, org.broadleafcommerce.common.demo.MTCondition.CONDITION_CLASSES.length)))))))) {
            present = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L857, org.springframework.util.ClassUtils.isPresent(org.broadleafcommerce.common.demo.MTCondition.CONDITION_CLASSES[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.MTCondition.__L856, i)], context.getClassLoader()));
            perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.MTCondition.__L858, (i++));
        } 
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.MTCondition.__L859, present);
    }

    public static perturbation.location.PerturbationLocation __L848;

    public static perturbation.location.PerturbationLocation __L849;

    public static perturbation.location.PerturbationLocation __L850;

    public static perturbation.location.PerturbationLocation __L851;

    public static perturbation.location.PerturbationLocation __L852;

    public static perturbation.location.PerturbationLocation __L853;

    public static perturbation.location.PerturbationLocation __L854;

    public static perturbation.location.PerturbationLocation __L855;

    public static perturbation.location.PerturbationLocation __L856;

    public static perturbation.location.PerturbationLocation __L857;

    public static perturbation.location.PerturbationLocation __L858;

    public static perturbation.location.PerturbationLocation __L859;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.demo.MTCondition.__L848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:37)", 848, "Boolean");
        org.broadleafcommerce.common.demo.MTCondition.__L849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:38)", 849, "Numerical");
        org.broadleafcommerce.common.demo.MTCondition.__L850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:39)", 850, "Boolean");
        org.broadleafcommerce.common.demo.MTCondition.__L851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:39)", 851, "Boolean");
        org.broadleafcommerce.common.demo.MTCondition.__L852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:39)", 852, "Numerical");
        org.broadleafcommerce.common.demo.MTCondition.__L853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:39)", 853, "Numerical");
        org.broadleafcommerce.common.demo.MTCondition.__L854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:39)", 854, "Boolean");
        org.broadleafcommerce.common.demo.MTCondition.__L855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:39)", 855, "Boolean");
        org.broadleafcommerce.common.demo.MTCondition.__L856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:40)", 856, "Numerical");
        org.broadleafcommerce.common.demo.MTCondition.__L857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:40)", 857, "Boolean");
        org.broadleafcommerce.common.demo.MTCondition.__L858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:41)", 858, "Numerical");
        org.broadleafcommerce.common.demo.MTCondition.__L859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/MTCondition.java:43)", 859, "Boolean");
    }

    static {
        org.broadleafcommerce.common.demo.MTCondition.initPerturbationLocation0();
    }
}

