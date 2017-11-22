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
package org.broadleafcommerce.common.security;


public final class RandomGenerator {
    private static final char[] CHARSET = new char[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private RandomGenerator() {
    }

    @java.lang.Override
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        throw new java.lang.CloneNotSupportedException();
    }

    public static java.lang.String generateRandomId(java.lang.String prng, int len) throws java.security.NoSuchAlgorithmException {
        return org.broadleafcommerce.common.security.RandomGenerator.generateRandomId(java.security.SecureRandom.getInstance(prng), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5145, len));
    }

    public static java.lang.String generateRandomId(java.security.SecureRandom sr, int len) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5146, 1); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.RandomGenerator.__L5151, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5147, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5150, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5148, len)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5149, 1))))))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5152, (i++))) {
            int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5154, sr.nextInt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5153, org.broadleafcommerce.common.security.RandomGenerator.CHARSET.length)));
            char c = org.broadleafcommerce.common.security.RandomGenerator.CHARSET[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5155, index)];
            sb.append(c);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.RandomGenerator.__L5168, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.RandomGenerator.__L5164, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.RandomGenerator.__L5160, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5158, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5156, i)) % (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5157, 4))))) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5159, 0))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.RandomGenerator.__L5163, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5161, i)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5162, 0)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.RandomGenerator.__L5167, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5165, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.RandomGenerator.__L5166, len)))))))) {
                sb.append('-');
            }
        }
        return sb.toString();
    }

    public static perturbation.location.PerturbationLocation __L5145;

    public static perturbation.location.PerturbationLocation __L5146;

    public static perturbation.location.PerturbationLocation __L5147;

    public static perturbation.location.PerturbationLocation __L5148;

    public static perturbation.location.PerturbationLocation __L5149;

    public static perturbation.location.PerturbationLocation __L5150;

    public static perturbation.location.PerturbationLocation __L5151;

    public static perturbation.location.PerturbationLocation __L5152;

    public static perturbation.location.PerturbationLocation __L5153;

    public static perturbation.location.PerturbationLocation __L5154;

    public static perturbation.location.PerturbationLocation __L5155;

    public static perturbation.location.PerturbationLocation __L5156;

    public static perturbation.location.PerturbationLocation __L5157;

    public static perturbation.location.PerturbationLocation __L5158;

    public static perturbation.location.PerturbationLocation __L5159;

    public static perturbation.location.PerturbationLocation __L5160;

    public static perturbation.location.PerturbationLocation __L5161;

    public static perturbation.location.PerturbationLocation __L5162;

    public static perturbation.location.PerturbationLocation __L5163;

    public static perturbation.location.PerturbationLocation __L5164;

    public static perturbation.location.PerturbationLocation __L5165;

    public static perturbation.location.PerturbationLocation __L5166;

    public static perturbation.location.PerturbationLocation __L5167;

    public static perturbation.location.PerturbationLocation __L5168;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.RandomGenerator.__L5145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:70)", 5145, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5146, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5147, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5148, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5149, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5150, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5151, "Boolean");
        org.broadleafcommerce.common.security.RandomGenerator.__L5152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:76)", 5152, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:77)", 5153, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:77)", 5154, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:78)", 5155, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5156, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5157, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5158, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5159, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5160, "Boolean");
        org.broadleafcommerce.common.security.RandomGenerator.__L5161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5161, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5162, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5163, "Boolean");
        org.broadleafcommerce.common.security.RandomGenerator.__L5164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5164, "Boolean");
        org.broadleafcommerce.common.security.RandomGenerator.__L5165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5165, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5166, "Numerical");
        org.broadleafcommerce.common.security.RandomGenerator.__L5167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5167, "Boolean");
        org.broadleafcommerce.common.security.RandomGenerator.__L5168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/RandomGenerator.java:81)", 5168, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.RandomGenerator.initPerturbationLocation0();
    }
}

