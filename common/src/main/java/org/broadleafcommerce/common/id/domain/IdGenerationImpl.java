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
package org.broadleafcommerce.common.id.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_ID_GENERATION")
public class IdGenerationImpl implements org.broadleafcommerce.common.id.domain.IdGeneration {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.Column(name = "ID_TYPE", nullable = false)
    protected java.lang.String type;

    @javax.persistence.Column(name = "ID_MIN", nullable = true)
    protected java.lang.Long begin;

    @javax.persistence.Column(name = "ID_MAX", nullable = true)
    protected java.lang.Long end;

    @javax.persistence.Column(name = "BATCH_START", nullable = false)
    protected java.lang.Long batchStart;

    @javax.persistence.Column(name = "BATCH_SIZE", nullable = false)
    protected java.lang.Long batchSize;

    @javax.persistence.Version
    protected java.lang.Integer version;

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.Long getBegin() {
        return begin;
    }

    public void setBegin(java.lang.Long begin) {
        this.begin = begin;
    }

    public java.lang.Long getEnd() {
        return end;
    }

    public void setEnd(java.lang.Long end) {
        this.end = end;
    }

    public java.lang.Long getBatchStart() {
        return batchStart;
    }

    public void setBatchStart(java.lang.Long batchStart) {
        this.batchStart = batchStart;
    }

    public java.lang.Long getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(java.lang.Long batchSize) {
        this.batchSize = batchSize;
    }

    public java.lang.Integer getVersion() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3158, version);
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3159, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3160, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3168, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3163, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3161, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3162, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3167, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3164, ((batchSize) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3165, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3166, batchSize.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3176, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3171, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3169, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3170, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3175, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3172, ((batchStart) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3173, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3174, batchStart.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3184, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3179, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3177, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3178, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3183, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3180, ((begin) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3181, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3182, begin.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3192, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3187, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3185, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3186, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3191, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3188, ((end) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3189, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3190, end.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3200, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3195, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3193, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3194, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3199, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3196, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3197, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3198, type.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3208, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3203, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3201, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3202, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3207, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3204, ((version) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3205, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3206, version.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3209, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3210, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3211, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3212, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3213, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3215, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3214, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3216, false);

        org.broadleafcommerce.common.id.domain.IdGenerationImpl other = ((org.broadleafcommerce.common.id.domain.IdGenerationImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3217, ((batchSize) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3218, ((other.batchSize) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3219, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3221, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3220, batchSize.equals(other.batchSize))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3222, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3223, ((batchStart) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3224, ((other.batchStart) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3225, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3227, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3226, batchStart.equals(other.batchStart))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3228, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3229, ((begin) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3230, ((other.begin) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3231, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3233, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3232, begin.equals(other.begin))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3234, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3235, ((end) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3236, ((other.end) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3237, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3239, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3238, end.equals(other.end))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3240, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3241, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3242, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3243, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3245, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3244, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3246, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3247, ((version) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3248, ((other.version) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3249, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3252, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3251, version.equals(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3250, other.version)))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3253, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3254, true);
    }

    public static perturbation.location.PerturbationLocation __L3158;

    public static perturbation.location.PerturbationLocation __L3159;

    public static perturbation.location.PerturbationLocation __L3160;

    public static perturbation.location.PerturbationLocation __L3161;

    public static perturbation.location.PerturbationLocation __L3162;

    public static perturbation.location.PerturbationLocation __L3163;

    public static perturbation.location.PerturbationLocation __L3164;

    public static perturbation.location.PerturbationLocation __L3165;

    public static perturbation.location.PerturbationLocation __L3166;

    public static perturbation.location.PerturbationLocation __L3167;

    public static perturbation.location.PerturbationLocation __L3168;

    public static perturbation.location.PerturbationLocation __L3169;

    public static perturbation.location.PerturbationLocation __L3170;

    public static perturbation.location.PerturbationLocation __L3171;

    public static perturbation.location.PerturbationLocation __L3172;

    public static perturbation.location.PerturbationLocation __L3173;

    public static perturbation.location.PerturbationLocation __L3174;

    public static perturbation.location.PerturbationLocation __L3175;

    public static perturbation.location.PerturbationLocation __L3176;

    public static perturbation.location.PerturbationLocation __L3177;

    public static perturbation.location.PerturbationLocation __L3178;

    public static perturbation.location.PerturbationLocation __L3179;

    public static perturbation.location.PerturbationLocation __L3180;

    public static perturbation.location.PerturbationLocation __L3181;

    public static perturbation.location.PerturbationLocation __L3182;

    public static perturbation.location.PerturbationLocation __L3183;

    public static perturbation.location.PerturbationLocation __L3184;

    public static perturbation.location.PerturbationLocation __L3185;

    public static perturbation.location.PerturbationLocation __L3186;

    public static perturbation.location.PerturbationLocation __L3187;

    public static perturbation.location.PerturbationLocation __L3188;

    public static perturbation.location.PerturbationLocation __L3189;

    public static perturbation.location.PerturbationLocation __L3190;

    public static perturbation.location.PerturbationLocation __L3191;

    public static perturbation.location.PerturbationLocation __L3192;

    public static perturbation.location.PerturbationLocation __L3193;

    public static perturbation.location.PerturbationLocation __L3194;

    public static perturbation.location.PerturbationLocation __L3195;

    public static perturbation.location.PerturbationLocation __L3196;

    public static perturbation.location.PerturbationLocation __L3197;

    public static perturbation.location.PerturbationLocation __L3198;

    public static perturbation.location.PerturbationLocation __L3199;

    public static perturbation.location.PerturbationLocation __L3200;

    public static perturbation.location.PerturbationLocation __L3201;

    public static perturbation.location.PerturbationLocation __L3202;

    public static perturbation.location.PerturbationLocation __L3203;

    public static perturbation.location.PerturbationLocation __L3204;

    public static perturbation.location.PerturbationLocation __L3205;

    public static perturbation.location.PerturbationLocation __L3206;

    public static perturbation.location.PerturbationLocation __L3207;

    public static perturbation.location.PerturbationLocation __L3208;

    public static perturbation.location.PerturbationLocation __L3209;

    public static perturbation.location.PerturbationLocation __L3210;

    public static perturbation.location.PerturbationLocation __L3211;

    public static perturbation.location.PerturbationLocation __L3212;

    public static perturbation.location.PerturbationLocation __L3213;

    public static perturbation.location.PerturbationLocation __L3214;

    public static perturbation.location.PerturbationLocation __L3215;

    public static perturbation.location.PerturbationLocation __L3216;

    public static perturbation.location.PerturbationLocation __L3217;

    public static perturbation.location.PerturbationLocation __L3218;

    public static perturbation.location.PerturbationLocation __L3219;

    public static perturbation.location.PerturbationLocation __L3220;

    public static perturbation.location.PerturbationLocation __L3221;

    public static perturbation.location.PerturbationLocation __L3222;

    public static perturbation.location.PerturbationLocation __L3223;

    public static perturbation.location.PerturbationLocation __L3224;

    public static perturbation.location.PerturbationLocation __L3225;

    public static perturbation.location.PerturbationLocation __L3226;

    public static perturbation.location.PerturbationLocation __L3227;

    public static perturbation.location.PerturbationLocation __L3228;

    public static perturbation.location.PerturbationLocation __L3229;

    public static perturbation.location.PerturbationLocation __L3230;

    public static perturbation.location.PerturbationLocation __L3231;

    public static perturbation.location.PerturbationLocation __L3232;

    public static perturbation.location.PerturbationLocation __L3233;

    public static perturbation.location.PerturbationLocation __L3234;

    public static perturbation.location.PerturbationLocation __L3235;

    public static perturbation.location.PerturbationLocation __L3236;

    public static perturbation.location.PerturbationLocation __L3237;

    public static perturbation.location.PerturbationLocation __L3238;

    public static perturbation.location.PerturbationLocation __L3239;

    public static perturbation.location.PerturbationLocation __L3240;

    public static perturbation.location.PerturbationLocation __L3241;

    public static perturbation.location.PerturbationLocation __L3242;

    public static perturbation.location.PerturbationLocation __L3243;

    public static perturbation.location.PerturbationLocation __L3244;

    public static perturbation.location.PerturbationLocation __L3245;

    public static perturbation.location.PerturbationLocation __L3246;

    public static perturbation.location.PerturbationLocation __L3247;

    public static perturbation.location.PerturbationLocation __L3248;

    public static perturbation.location.PerturbationLocation __L3249;

    public static perturbation.location.PerturbationLocation __L3250;

    public static perturbation.location.PerturbationLocation __L3251;

    public static perturbation.location.PerturbationLocation __L3252;

    public static perturbation.location.PerturbationLocation __L3253;

    public static perturbation.location.PerturbationLocation __L3254;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:95)", 3158, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:100)", 3159, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:101)", 3160, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3161, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3162, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3163, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3164, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3165, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3166, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3167, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:102)", 3168, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3169, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3170, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3171 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3171, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3172 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3172, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3173 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3173, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3174 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3174, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3175, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:103)", 3176, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3177, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3178, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3179, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3180, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3181, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3182, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3183, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:104)", 3184, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3185, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3186, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3187, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3188, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3189, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3190, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3191, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:105)", 3192, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3193, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3194, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3195, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3196, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3197, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3198, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3199, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:106)", 3200, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3201, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3202, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3203, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3204, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3205, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3206, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3207, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:107)", 3208, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:108)", 3209, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:113)", 3210, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:114)", 3211, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:115)", 3212, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:116)", 3213, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3214 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:117)", 3214, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3215 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:117)", 3215, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3216 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:118)", 3216, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3217 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:120)", 3217, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3218 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:121)", 3218, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3219 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:122)", 3219, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3220 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:123)", 3220, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3221 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:123)", 3221, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3222 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:124)", 3222, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3223 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:125)", 3223, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3224 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:126)", 3224, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3225 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:127)", 3225, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3226 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:128)", 3226, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:128)", 3227, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:129)", 3228, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3229 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:130)", 3229, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3230 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:131)", 3230, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3231 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:132)", 3231, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3232 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:133)", 3232, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3233 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:133)", 3233, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3234 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:134)", 3234, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3235 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:135)", 3235, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3236 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:136)", 3236, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3237 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:137)", 3237, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3238 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:138)", 3238, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3239 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:138)", 3239, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3240 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:139)", 3240, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3241 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:140)", 3241, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3242 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:141)", 3242, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3243 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:142)", 3243, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:143)", 3244, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:143)", 3245, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:144)", 3246, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:145)", 3247, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:146)", 3248, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:147)", 3249, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:148)", 3250, "Numerical");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:148)", 3251, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:148)", 3252, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:149)", 3253, "Boolean");
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.__L3254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/id/domain/IdGenerationImpl.java:150)", 3254, "Boolean");
    }

    static {
        org.broadleafcommerce.common.id.domain.IdGenerationImpl.initPerturbationLocation0();
    }
}

