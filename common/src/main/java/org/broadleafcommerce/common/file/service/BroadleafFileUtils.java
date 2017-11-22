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
package org.broadleafcommerce.common.file.service;


public class BroadleafFileUtils {
    @java.lang.Deprecated
    public static java.lang.String buildFilePath(java.lang.String directory, java.lang.String fileName) {
        return org.broadleafcommerce.common.file.service.BroadleafFileUtils.appendUnixPaths(directory, fileName);
    }

    @java.lang.Deprecated
    public static java.lang.String removeLeadingSlash(java.lang.String fileName) {
        return org.broadleafcommerce.common.file.service.BroadleafFileUtils.removeLeadingUnixSlash(fileName);
    }

    @java.lang.Deprecated
    public static java.lang.String addLeadingSlash(java.lang.String fileName) {
        return org.broadleafcommerce.common.file.service.BroadleafFileUtils.addLeadingUnixSlash(fileName);
    }

    public static java.lang.String appendUnixPaths(java.lang.String directory, java.lang.String fileName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2617, directory.endsWith("/"))) {
            return directory + (org.broadleafcommerce.common.file.service.BroadleafFileUtils.removeLeadingUnixSlash(fileName));
        }else {
            return directory + (org.broadleafcommerce.common.file.service.BroadleafFileUtils.addLeadingUnixSlash(fileName));
        }
    }

    public static java.lang.String removeLeadingUnixSlash(java.lang.String fileName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2618, fileName.startsWith("/"))) {
            return fileName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2619, 1));
        }
        return fileName;
    }

    public static java.lang.String addLeadingUnixSlash(java.lang.String fileName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2620, fileName.startsWith("/"))) {
            return fileName;
        }
        return "/" + fileName;
    }

    public static perturbation.location.PerturbationLocation __L2617;

    public static perturbation.location.PerturbationLocation __L2618;

    public static perturbation.location.PerturbationLocation __L2619;

    public static perturbation.location.PerturbationLocation __L2620;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileUtils.java:63)", 2617, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileUtils.java:75)", 2618, "Boolean");
        org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileUtils.java:76)", 2619, "Numerical");
        org.broadleafcommerce.common.file.service.BroadleafFileUtils.__L2620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/BroadleafFileUtils.java:86)", 2620, "Boolean");
    }

    static {
        org.broadleafcommerce.common.file.service.BroadleafFileUtils.initPerturbationLocation0();
    }
}

