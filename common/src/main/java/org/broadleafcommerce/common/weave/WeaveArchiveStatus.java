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
package org.broadleafcommerce.common.weave;


public final class WeaveArchiveStatus implements org.broadleafcommerce.common.persistence.Status {
    @javax.persistence.Embedded
    protected org.broadleafcommerce.common.persistence.ArchiveStatus archiveStatus;

    @java.lang.Override
    public void setArchived(java.lang.Character archived) {
        getEmbeddableArchiveStatus(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7043, true)).setArchived(archived);
    }

    private org.broadleafcommerce.common.persistence.ArchiveStatus getEmbeddableArchiveStatus(boolean assign) {
        org.broadleafcommerce.common.persistence.ArchiveStatus temp = archiveStatus;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7044, (temp == null))) {
            temp = new org.broadleafcommerce.common.persistence.ArchiveStatus();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7045, assign)) {
                archiveStatus = temp;
            }
        }
        return temp;
    }

    @java.lang.Override
    public java.lang.Character getArchived() {
        return getEmbeddableArchiveStatus(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7046, false)).getArchived();
    }

    @java.lang.Override
    public boolean isActive() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7047, ('Y' != (getArchived())));
    }

    public static perturbation.location.PerturbationLocation __L7043;

    public static perturbation.location.PerturbationLocation __L7044;

    public static perturbation.location.PerturbationLocation __L7045;

    public static perturbation.location.PerturbationLocation __L7046;

    public static perturbation.location.PerturbationLocation __L7047;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/WeaveArchiveStatus.java:37)", 7043, "Boolean");
        org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/WeaveArchiveStatus.java:42)", 7044, "Boolean");
        org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/WeaveArchiveStatus.java:44)", 7045, "Boolean");
        org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/WeaveArchiveStatus.java:53)", 7046, "Boolean");
        org.broadleafcommerce.common.weave.WeaveArchiveStatus.__L7047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/WeaveArchiveStatus.java:58)", 7047, "Boolean");
    }

    static {
        org.broadleafcommerce.common.weave.WeaveArchiveStatus.initPerturbationLocation0();
    }
}

