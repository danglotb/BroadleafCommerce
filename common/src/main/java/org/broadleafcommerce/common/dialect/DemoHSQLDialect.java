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
package org.broadleafcommerce.common.dialect;


public class DemoHSQLDialect extends org.hibernate.dialect.HSQLDialect {
    @java.lang.Override
    public boolean dropConstraints() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dialect.DemoHSQLDialect.__L860, false);
    }

    @java.lang.Override
    public java.lang.String getCascadeConstraintsString() {
        return " cascade ";
    }

    @java.lang.Override
    public boolean supportsIfExistsBeforeTableName() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dialect.DemoHSQLDialect.__L861, true);
    }

    @java.lang.Override
    public boolean supportsIfExistsAfterTableName() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.dialect.DemoHSQLDialect.__L862, false);
    }

    public static perturbation.location.PerturbationLocation __L860;

    public static perturbation.location.PerturbationLocation __L861;

    public static perturbation.location.PerturbationLocation __L862;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.dialect.DemoHSQLDialect.__L860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dialect/DemoHSQLDialect.java:36)", 860, "Boolean");
        org.broadleafcommerce.common.dialect.DemoHSQLDialect.__L861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dialect/DemoHSQLDialect.java:53)", 861, "Boolean");
        org.broadleafcommerce.common.dialect.DemoHSQLDialect.__L862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/dialect/DemoHSQLDialect.java:61)", 862, "Boolean");
    }

    static {
        org.broadleafcommerce.common.dialect.DemoHSQLDialect.initPerturbationLocation0();
    }
}

