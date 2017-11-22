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
package org.broadleafcommerce.common.resource;


public class GeneratedResource extends org.springframework.core.io.AbstractResource implements java.io.Serializable {
    private static final long serialVersionUID = 7044543270746433688L;

    protected long timeGenerated;

    protected java.lang.String hashRepresentation;

    protected final byte[] source;

    protected final java.lang.String description;

    public GeneratedResource() {
        this(new byte[]{  }, null);
    }

    public GeneratedResource(byte[] source, java.lang.String description) {
        org.springframework.util.Assert.notNull(source);
        this.source = source;
        this.description = description;
        timeGenerated = java.lang.System.currentTimeMillis();
    }

    @java.lang.Override
    public java.lang.String getFilename() {
        return getDescription();
    }

    @java.lang.Override
    public long lastModified() throws java.io.IOException {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.resource.GeneratedResource.__L4604, timeGenerated);
    }

    public java.lang.String getHashRepresentation() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4605, org.apache.commons.lang3.StringUtils.isBlank(hashRepresentation)) ? java.lang.String.valueOf(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.resource.GeneratedResource.__L4606, timeGenerated)) : hashRepresentation;
    }

    public void setHashRepresentation(java.lang.String hashRepresentation) {
        this.hashRepresentation = hashRepresentation;
    }

    @java.lang.Override
    public java.lang.String getDescription() {
        return description;
    }

    @java.lang.Override
    public java.io.InputStream getInputStream() throws java.io.IOException {
        return new java.io.ByteArrayInputStream(source);
    }

    @java.lang.Override
    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.GeneratedResource.__L4607, 1);
    }

    public byte[] getBytes() {
        return source;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object res) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4608, (res == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4609, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4611, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4610, getClass().isAssignableFrom(res.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4612, false);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.GeneratedResource.__L4613, java.util.Arrays.equals(source, ((org.broadleafcommerce.common.resource.GeneratedResource) (res)).source));
    }

    public static perturbation.location.PerturbationLocation __L4604;

    public static perturbation.location.PerturbationLocation __L4605;

    public static perturbation.location.PerturbationLocation __L4606;

    public static perturbation.location.PerturbationLocation __L4607;

    public static perturbation.location.PerturbationLocation __L4608;

    public static perturbation.location.PerturbationLocation __L4609;

    public static perturbation.location.PerturbationLocation __L4610;

    public static perturbation.location.PerturbationLocation __L4611;

    public static perturbation.location.PerturbationLocation __L4612;

    public static perturbation.location.PerturbationLocation __L4613;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.resource.GeneratedResource.__L4604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:76)", 4604, "Numerical");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:80)", 4605, "Boolean");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:80)", 4606, "Numerical");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:99)", 4607, "Numerical");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:108)", 4608, "Boolean");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:108)", 4609, "Boolean");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:109)", 4610, "Boolean");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:109)", 4611, "Boolean");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:110)", 4612, "Boolean");
        org.broadleafcommerce.common.resource.GeneratedResource.__L4613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/GeneratedResource.java:113)", 4613, "Boolean");
    }

    static {
        org.broadleafcommerce.common.resource.GeneratedResource.initPerturbationLocation0();
    }
}

