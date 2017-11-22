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
public class PreviewStatus implements java.io.Serializable , org.broadleafcommerce.common.persistence.Previewable {
    @javax.persistence.Column(name = "IS_PREVIEW")
    @org.broadleafcommerce.common.presentation.AdminPresentation(excluded = true)
    protected java.lang.Boolean isPreview;

    @java.lang.Override
    public java.lang.Boolean getPreview() {
        return isPreview;
    }

    @java.lang.Override
    public void setPreview(java.lang.Boolean preview) {
        isPreview = preview;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4366, ((this) == o)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4367, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4368, (o == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4369, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4371, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4370, getClass().isAssignableFrom(o.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4372, false);

        org.broadleafcommerce.common.persistence.PreviewStatus that = ((org.broadleafcommerce.common.persistence.PreviewStatus) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4377, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4373, ((isPreview) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4375, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4374, isPreview.equals(that.isPreview))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4376, ((that.isPreview) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4378, false);

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4379, true);
    }

    @java.lang.Override
    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.PreviewStatus.__L4383, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.PreviewStatus.__L4380, ((isPreview) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.PreviewStatus.__L4381, isPreview.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.PreviewStatus.__L4382, 0)));
    }

    public static perturbation.location.PerturbationLocation __L4366;

    public static perturbation.location.PerturbationLocation __L4367;

    public static perturbation.location.PerturbationLocation __L4368;

    public static perturbation.location.PerturbationLocation __L4369;

    public static perturbation.location.PerturbationLocation __L4370;

    public static perturbation.location.PerturbationLocation __L4371;

    public static perturbation.location.PerturbationLocation __L4372;

    public static perturbation.location.PerturbationLocation __L4373;

    public static perturbation.location.PerturbationLocation __L4374;

    public static perturbation.location.PerturbationLocation __L4375;

    public static perturbation.location.PerturbationLocation __L4376;

    public static perturbation.location.PerturbationLocation __L4377;

    public static perturbation.location.PerturbationLocation __L4378;

    public static perturbation.location.PerturbationLocation __L4379;

    public static perturbation.location.PerturbationLocation __L4380;

    public static perturbation.location.PerturbationLocation __L4381;

    public static perturbation.location.PerturbationLocation __L4382;

    public static perturbation.location.PerturbationLocation __L4383;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:49)", 4366, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:49)", 4367, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:50)", 4368, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:50)", 4369, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:51)", 4370, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:51)", 4371, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:51)", 4372, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:55)", 4373, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:55)", 4374, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4375 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:55)", 4375, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4376 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:55)", 4376, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4377 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:55)", 4377, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4378 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:55)", 4378, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4379 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:57)", 4379, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4380 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:62)", 4380, "Boolean");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4381 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:62)", 4381, "Numerical");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4382 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:62)", 4382, "Numerical");
        org.broadleafcommerce.common.persistence.PreviewStatus.__L4383 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/PreviewStatus.java:62)", 4383, "Numerical");
    }

    static {
        org.broadleafcommerce.common.persistence.PreviewStatus.initPerturbationLocation0();
    }
}

