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
package org.broadleafcommerce.common.security.util;


public class PasswordUtils {
    private static final java.util.Random RANDOM = new java.security.SecureRandom();

    private static final java.lang.String CHARS = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";

    public static java.lang.String generateSecurePassword(int requiredLength) {
        int start = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordUtils.__L4909, 0);
        int end = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordUtils.__L4910, org.broadleafcommerce.common.security.util.PasswordUtils.CHARS.length());
        boolean letters = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordUtils.__L4911, true);
        boolean numbers = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordUtils.__L4912, true);
        java.lang.String password = org.apache.commons.lang.RandomStringUtils.random(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordUtils.__L4913, requiredLength), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordUtils.__L4914, start), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordUtils.__L4915, end), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordUtils.__L4916, letters), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordUtils.__L4917, numbers), org.broadleafcommerce.common.security.util.PasswordUtils.CHARS.toCharArray(), org.broadleafcommerce.common.security.util.PasswordUtils.RANDOM);
        return password;
    }

    public static perturbation.location.PerturbationLocation __L4909;

    public static perturbation.location.PerturbationLocation __L4910;

    public static perturbation.location.PerturbationLocation __L4911;

    public static perturbation.location.PerturbationLocation __L4912;

    public static perturbation.location.PerturbationLocation __L4913;

    public static perturbation.location.PerturbationLocation __L4914;

    public static perturbation.location.PerturbationLocation __L4915;

    public static perturbation.location.PerturbationLocation __L4916;

    public static perturbation.location.PerturbationLocation __L4917;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:33)", 4909, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:34)", 4910, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:35)", 4911, "Boolean");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:36)", 4912, "Boolean");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:38)", 4913, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:38)", 4914, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:38)", 4915, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:38)", 4916, "Boolean");
        org.broadleafcommerce.common.security.util.PasswordUtils.__L4917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordUtils.java:38)", 4917, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.util.PasswordUtils.initPerturbationLocation0();
    }
}

