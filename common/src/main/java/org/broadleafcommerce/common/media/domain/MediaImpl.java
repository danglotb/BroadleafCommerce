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


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_MEDIA")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.SANDBOX, skipOverlaps = true), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_CATALOG) })
public class MediaImpl implements org.broadleafcommerce.common.copy.MultiTenantCloneable<org.broadleafcommerce.common.media.domain.MediaImpl> , org.broadleafcommerce.common.media.domain.Media {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "MediaId")
    @org.hibernate.annotations.GenericGenerator(name = "MediaId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "MediaImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.media.domain.MediaImpl") })
    @javax.persistence.Column(name = "MEDIA_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "URL", nullable = false)
    @org.hibernate.annotations.Index(name = "MEDIA_URL_INDEX", columnNames = { "URL" })
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "MediaImpl_Media_Url", order = 1, gridOrder = 4, prominent = true, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.ASSET_LOOKUP)
    protected java.lang.String url;

    @javax.persistence.Column(name = "TITLE")
    @org.hibernate.annotations.Index(name = "MEDIA_TITLE_INDEX", columnNames = { "TITLE" })
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "MediaImpl_Media_Title", order = 2, gridOrder = 2, prominent = true)
    protected java.lang.String title;

    @javax.persistence.Column(name = "ALT_TEXT")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "MediaImpl_Media_Alt_Text", order = 3, gridOrder = 3, prominent = true)
    protected java.lang.String altText;

    @javax.persistence.Column(name = "TAGS")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "MediaImpl_Media_Tags")
    protected java.lang.String tags;

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
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
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3464, false);
    }

    @java.lang.Override
    public <T> T unwrap(java.lang.Class<T> unwrapType) {
        throw new org.broadleafcommerce.common.util.UnknownUnwrapTypeException(unwrapType);
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3465, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3466, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3474, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3469, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3467, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3468, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3473, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3470, ((title) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3471, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3472, title.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3482, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3477, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3475, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3476, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3481, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3478, ((altText) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3479, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3480, altText.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3490, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3485, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3483, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3484, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3489, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3486, ((tags) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3487, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3488, tags.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3498, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3493, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3491, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3492, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3497, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3494, ((url) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3495, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3496, url.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.media.domain.MediaImpl.__L3499, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3500, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3501, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3502, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3503, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3505, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3504, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3506, false);

        org.broadleafcommerce.common.media.domain.MediaImpl other = ((org.broadleafcommerce.common.media.domain.MediaImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3509, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3507, ((id) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3508, ((other.id) != null)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3510, id.equals(other.id));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3511, ((title) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3512, ((other.title) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3513, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3515, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3514, title.equals(other.title))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3516, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3517, ((altText) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3518, ((other.altText) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3519, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3521, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3520, altText.equals(other.altText))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3522, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3523, ((tags) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3524, ((other.tags) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3525, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3527, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3526, tags.equals(other.tags))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3528, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3529, ((url) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3530, ((other.url) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3531, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3533, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3532, url.equals(other.url))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3534, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3535, true);
    }

    @java.lang.Override
    public <G extends org.broadleafcommerce.common.media.domain.MediaImpl> org.broadleafcommerce.common.copy.CreateResponse<G> createOrRetrieveCopyInstance(org.broadleafcommerce.common.copy.MultiTenantCopyContext context) throws java.lang.CloneNotSupportedException {
        org.broadleafcommerce.common.copy.CreateResponse<G> createResponse = context.createOrRetrieveCopyInstance(this);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.media.domain.MediaImpl.__L3536, createResponse.isAlreadyPopulated())) {
            return createResponse;
        }
        org.broadleafcommerce.common.media.domain.MediaImpl cloned = createResponse.getClone();
        cloned.setAltText(altText);
        cloned.setTags(tags);
        cloned.setTitle(title);
        cloned.setUrl(url);
        return createResponse;
    }

    public static perturbation.location.PerturbationLocation __L3464;

    public static perturbation.location.PerturbationLocation __L3465;

    public static perturbation.location.PerturbationLocation __L3466;

    public static perturbation.location.PerturbationLocation __L3467;

    public static perturbation.location.PerturbationLocation __L3468;

    public static perturbation.location.PerturbationLocation __L3469;

    public static perturbation.location.PerturbationLocation __L3470;

    public static perturbation.location.PerturbationLocation __L3471;

    public static perturbation.location.PerturbationLocation __L3472;

    public static perturbation.location.PerturbationLocation __L3473;

    public static perturbation.location.PerturbationLocation __L3474;

    public static perturbation.location.PerturbationLocation __L3475;

    public static perturbation.location.PerturbationLocation __L3476;

    public static perturbation.location.PerturbationLocation __L3477;

    public static perturbation.location.PerturbationLocation __L3478;

    public static perturbation.location.PerturbationLocation __L3479;

    public static perturbation.location.PerturbationLocation __L3480;

    public static perturbation.location.PerturbationLocation __L3481;

    public static perturbation.location.PerturbationLocation __L3482;

    public static perturbation.location.PerturbationLocation __L3483;

    public static perturbation.location.PerturbationLocation __L3484;

    public static perturbation.location.PerturbationLocation __L3485;

    public static perturbation.location.PerturbationLocation __L3486;

    public static perturbation.location.PerturbationLocation __L3487;

    public static perturbation.location.PerturbationLocation __L3488;

    public static perturbation.location.PerturbationLocation __L3489;

    public static perturbation.location.PerturbationLocation __L3490;

    public static perturbation.location.PerturbationLocation __L3491;

    public static perturbation.location.PerturbationLocation __L3492;

    public static perturbation.location.PerturbationLocation __L3493;

    public static perturbation.location.PerturbationLocation __L3494;

    public static perturbation.location.PerturbationLocation __L3495;

    public static perturbation.location.PerturbationLocation __L3496;

    public static perturbation.location.PerturbationLocation __L3497;

    public static perturbation.location.PerturbationLocation __L3498;

    public static perturbation.location.PerturbationLocation __L3499;

    public static perturbation.location.PerturbationLocation __L3500;

    public static perturbation.location.PerturbationLocation __L3501;

    public static perturbation.location.PerturbationLocation __L3502;

    public static perturbation.location.PerturbationLocation __L3503;

    public static perturbation.location.PerturbationLocation __L3504;

    public static perturbation.location.PerturbationLocation __L3505;

    public static perturbation.location.PerturbationLocation __L3506;

    public static perturbation.location.PerturbationLocation __L3507;

    public static perturbation.location.PerturbationLocation __L3508;

    public static perturbation.location.PerturbationLocation __L3509;

    public static perturbation.location.PerturbationLocation __L3510;

    public static perturbation.location.PerturbationLocation __L3511;

    public static perturbation.location.PerturbationLocation __L3512;

    public static perturbation.location.PerturbationLocation __L3513;

    public static perturbation.location.PerturbationLocation __L3514;

    public static perturbation.location.PerturbationLocation __L3515;

    public static perturbation.location.PerturbationLocation __L3516;

    public static perturbation.location.PerturbationLocation __L3517;

    public static perturbation.location.PerturbationLocation __L3518;

    public static perturbation.location.PerturbationLocation __L3519;

    public static perturbation.location.PerturbationLocation __L3520;

    public static perturbation.location.PerturbationLocation __L3521;

    public static perturbation.location.PerturbationLocation __L3522;

    public static perturbation.location.PerturbationLocation __L3523;

    public static perturbation.location.PerturbationLocation __L3524;

    public static perturbation.location.PerturbationLocation __L3525;

    public static perturbation.location.PerturbationLocation __L3526;

    public static perturbation.location.PerturbationLocation __L3527;

    public static perturbation.location.PerturbationLocation __L3528;

    public static perturbation.location.PerturbationLocation __L3529;

    public static perturbation.location.PerturbationLocation __L3530;

    public static perturbation.location.PerturbationLocation __L3531;

    public static perturbation.location.PerturbationLocation __L3532;

    public static perturbation.location.PerturbationLocation __L3533;

    public static perturbation.location.PerturbationLocation __L3534;

    public static perturbation.location.PerturbationLocation __L3535;

    public static perturbation.location.PerturbationLocation __L3536;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:139)", 3464, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:149)", 3465, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:150)", 3466, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3467, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3468, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3469 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3469, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3470 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3470, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3471 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3471, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3472 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3472, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3473, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:151)", 3474, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3475, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3476, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3477, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3478, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3479, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3480, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3481, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:152)", 3482, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3483, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3484, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3485, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3486, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3487, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3488, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3489, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:153)", 3490, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3491, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3492, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3493, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3494, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3495, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3496, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3497 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3497, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3498 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:154)", 3498, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3499 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:155)", 3499, "Numerical");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3500 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:160)", 3500, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3501 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:161)", 3501, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3502 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:162)", 3502, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3503 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:163)", 3503, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3504 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:164)", 3504, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3505 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:164)", 3505, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3506 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:165)", 3506, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3507 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:168)", 3507, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3508 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:168)", 3508, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3509 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:168)", 3509, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3510 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:169)", 3510, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3511 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:172)", 3511, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3512 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:173)", 3512, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3513 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:174)", 3513, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3514 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:175)", 3514, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3515 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:175)", 3515, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3516 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:176)", 3516, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3517 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:177)", 3517, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3518 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:178)", 3518, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3519 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:179)", 3519, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3520 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:180)", 3520, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3521 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:180)", 3521, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3522 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:181)", 3522, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3523 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:182)", 3523, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3524 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:183)", 3524, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3525 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:184)", 3525, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3526 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:185)", 3526, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3527 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:185)", 3527, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3528 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:186)", 3528, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3529 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:187)", 3529, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3530 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:188)", 3530, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3531 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:189)", 3531, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3532 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:190)", 3532, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3533 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:190)", 3533, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3534 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:191)", 3534, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3535 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:192)", 3535, "Boolean");
        org.broadleafcommerce.common.media.domain.MediaImpl.__L3536 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/media/domain/MediaImpl.java:198)", 3536, "Boolean");
    }

    static {
        org.broadleafcommerce.common.media.domain.MediaImpl.initPerturbationLocation0();
    }
}

