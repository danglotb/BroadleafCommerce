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
package org.broadleafcommerce.common.media.domain;


public class MediaDto implements org.broadleafcommerce.common.media.domain.Media {
    private static final long serialVersionUID = 1L;

    protected long id;

    protected java.lang.String url = "";

    protected java.lang.String title = "";

    protected java.lang.String altText = "";

    protected java.lang.String tags = "";

    @java.lang.Override
    public java.lang.Long getId() {
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.media.domain.MediaDto.__L3462, id);
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = ((long) (id));
    }

    @java.lang.Override
    public java.lang.String getUrl() {
        return url;
    }

    @java.lang.Override
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    @java.lang.Override
    public java.lang.String getTitle() {
        return title;
    }

    @java.lang.Override
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    @java.lang.Override
    public java.lang.String getAltText() {
        return altText;
    }

    @java.lang.Override
    public void setAltText(java.lang.String altText) {
        this.altText = altText;
    }

    @java.lang.Override
    public java.lang.String getTags() {
        return tags;
    }

    @java.lang.Override
    public void setTags(java.lang.String tags) {
        this.tags = tags;
    }

    @java.lang.Override
    public boolean isUnwrappableAs(java.lang.Class unwrapType) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaDto.__L3463, false);
    }

    @java.lang.Override
    public <T> T unwrap(java.lang.Class<T> unwrapType) {
        throw new org.broadleafcommerce.common.util.UnknownUnwrapTypeException(unwrapType);
    }

    public static perturbation.location.PerturbationLocation __L3462;

    public static perturbation.location.PerturbationLocation __L3463;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.media.domain.MediaDto.__L3462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaDto.java:39)", 3462, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaDto.__L3463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaDto.java:89)", 3463, "Boolean");
    }

    static {
        org.broadleafcommerce.common.media.domain.MediaDto.initPerturbationLocation0();
    }
}

