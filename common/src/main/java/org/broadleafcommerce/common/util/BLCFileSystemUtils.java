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
package org.broadleafcommerce.common.util;


public class BLCFileSystemUtils {
    private static final java.lang.String CLASSPATH = "classpath:";

    public static java.lang.String getClasspathFileContents(java.lang.String filePath) {
        java.lang.String contents = null;
        try {
            java.io.InputStream stream = org.broadleafcommerce.common.util.BLCFileSystemUtils.getClasspathFileInputStream(filePath);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6152, (stream != null))) {
                contents = org.apache.commons.io.IOUtils.toString(stream);
            }
            return contents;
        } catch (java.io.IOException e) {
            return null;
        }
    }

    public static java.io.InputStream getClasspathFileInputStream(java.lang.String filePath) {
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6153, filePath.startsWith(org.broadleafcommerce.common.util.BLCFileSystemUtils.CLASSPATH))) {
                filePath = filePath.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6154, org.broadleafcommerce.common.util.BLCFileSystemUtils.CLASSPATH.length()));
            }
            org.springframework.core.io.Resource resource = new org.springframework.core.io.ClassPathResource(filePath);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6155, resource.exists())) {
                return resource.getInputStream();
            }
            return null;
        } catch (java.io.IOException e) {
            return null;
        }
    }

    public static perturbation.location.PerturbationLocation __L6152;

    public static perturbation.location.PerturbationLocation __L6153;

    public static perturbation.location.PerturbationLocation __L6154;

    public static perturbation.location.PerturbationLocation __L6155;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFileSystemUtils.java:40)", 6152, "Boolean");
        org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFileSystemUtils.java:52)", 6153, "Boolean");
        org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFileSystemUtils.java:54)", 6154, "Numerical");
        org.broadleafcommerce.common.util.BLCFileSystemUtils.__L6155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFileSystemUtils.java:58)", 6155, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCFileSystemUtils.initPerturbationLocation0();
    }
}

