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
package org.broadleafcommerce.common.file.domain;


public class FileWorkArea {
    protected java.lang.String filePathLocation;

    public java.lang.String getFilePathLocation() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.domain.FileWorkArea.__L2496, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.domain.FileWorkArea.__L2495, filePathLocation.endsWith(java.io.File.separator)))))) {
            return (filePathLocation) + (java.io.File.separator);
        }else {
            return filePathLocation;
        }
    }

    public void setFilePathLocation(java.lang.String filePathLocation) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.domain.FileWorkArea.__L2498, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.domain.FileWorkArea.__L2497, filePathLocation.endsWith(java.io.File.separator)))))) {
            this.filePathLocation = filePathLocation + (java.io.File.separator);
        }else {
            this.filePathLocation = filePathLocation;
        }
    }

    public static perturbation.location.PerturbationLocation __L2495;

    public static perturbation.location.PerturbationLocation __L2496;

    public static perturbation.location.PerturbationLocation __L2497;

    public static perturbation.location.PerturbationLocation __L2498;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.domain.FileWorkArea.__L2495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/domain/FileWorkArea.java:39)", 2495, "Boolean");
        org.broadleafcommerce.common.file.domain.FileWorkArea.__L2496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/domain/FileWorkArea.java:39)", 2496, "Boolean");
        org.broadleafcommerce.common.file.domain.FileWorkArea.__L2497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/domain/FileWorkArea.java:47)", 2497, "Boolean");
        org.broadleafcommerce.common.file.domain.FileWorkArea.__L2498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/domain/FileWorkArea.java:47)", 2498, "Boolean");
    }

    static {
        org.broadleafcommerce.common.file.domain.FileWorkArea.initPerturbationLocation0();
    }
}

