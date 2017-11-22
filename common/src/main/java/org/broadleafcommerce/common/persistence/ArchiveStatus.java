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


@javax.persistence.Embeddable
public class ArchiveStatus implements java.io.Serializable , org.broadleafcommerce.common.sandbox.SandBoxNonProductionSkip {
    @javax.persistence.Column(name = "ARCHIVED")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "archived", visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL, group = "ArchiveStatus")
    protected java.lang.Character archived = 'N';

    public java.lang.Character getArchived() {
        return archived;
    }

    public void setArchived(java.lang.Character archived) {
        this.archived = archived;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4319, ((this) == o)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4320, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4321, (o == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4322, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4324, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4323, getClass().isAssignableFrom(o.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4325, false);

        org.broadleafcommerce.common.persistence.ArchiveStatus that = ((org.broadleafcommerce.common.persistence.ArchiveStatus) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4330, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4326, ((archived) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4328, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4327, archived.equals(that.archived))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4329, ((that.archived) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4331, false);

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4332, true);
    }

    @java.lang.Override
    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4336, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4333, ((archived) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4334, archived.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.ArchiveStatus.__L4335, 0)));
    }

    public static perturbation.location.PerturbationLocation __L4319;

    public static perturbation.location.PerturbationLocation __L4320;

    public static perturbation.location.PerturbationLocation __L4321;

    public static perturbation.location.PerturbationLocation __L4322;

    public static perturbation.location.PerturbationLocation __L4323;

    public static perturbation.location.PerturbationLocation __L4324;

    public static perturbation.location.PerturbationLocation __L4325;

    public static perturbation.location.PerturbationLocation __L4326;

    public static perturbation.location.PerturbationLocation __L4327;

    public static perturbation.location.PerturbationLocation __L4328;

    public static perturbation.location.PerturbationLocation __L4329;

    public static perturbation.location.PerturbationLocation __L4330;

    public static perturbation.location.PerturbationLocation __L4331;

    public static perturbation.location.PerturbationLocation __L4332;

    public static perturbation.location.PerturbationLocation __L4333;

    public static perturbation.location.PerturbationLocation __L4334;

    public static perturbation.location.PerturbationLocation __L4335;

    public static perturbation.location.PerturbationLocation __L4336;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4319 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:49)", 4319, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4320 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:49)", 4320, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4321 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:50)", 4321, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4322 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:50)", 4322, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4323 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:51)", 4323, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4324 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:51)", 4324, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4325 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:51)", 4325, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4326 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:55)", 4326, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4327 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:55)", 4327, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4328 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:55)", 4328, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4329 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:55)", 4329, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4330 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:55)", 4330, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4331 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:55)", 4331, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4332 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:57)", 4332, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4333 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:62)", 4333, "Boolean");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4334 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:62)", 4334, "Numerical");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4335 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:62)", 4335, "Numerical");
        org.broadleafcommerce.common.persistence.ArchiveStatus.__L4336 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/ArchiveStatus.java:62)", 4336, "Numerical");
    }

    static {
        org.broadleafcommerce.common.persistence.ArchiveStatus.initPerturbationLocation0();
    }
}

