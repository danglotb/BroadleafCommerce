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


public class ConditionalDirectCopyTransformMemberDto implements java.io.Serializable {
    protected java.lang.String[] templateTokens;

    protected boolean renameMethodOverlaps = false;

    protected boolean skipOverlaps = false;

    protected java.lang.String conditionalProperty;

    public java.lang.String[] getTemplateTokens() {
        return templateTokens;
    }

    public void setTemplateTokens(java.lang.String[] templateTokens) {
        this.templateTokens = templateTokens;
    }

    public boolean isRenameMethodOverlaps() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7033, renameMethodOverlaps);
    }

    public void setRenameMethodOverlaps(boolean renameMethodOverlaps) {
        this.renameMethodOverlaps = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7034, renameMethodOverlaps);
    }

    public boolean isSkipOverlaps() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7035, skipOverlaps);
    }

    public void setSkipOverlaps(boolean skipOverlaps) {
        this.skipOverlaps = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7036, skipOverlaps);
    }

    public java.lang.String getConditionalProperty() {
        return conditionalProperty;
    }

    public void setConditionalProperty(java.lang.String conditionalProperty) {
        this.conditionalProperty = conditionalProperty;
    }

    public static perturbation.location.PerturbationLocation __L7033;

    public static perturbation.location.PerturbationLocation __L7034;

    public static perturbation.location.PerturbationLocation __L7035;

    public static perturbation.location.PerturbationLocation __L7036;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformMemberDto.java:55)", 7033, "Boolean");
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformMemberDto.java:59)", 7034, "Boolean");
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformMemberDto.java:63)", 7035, "Boolean");
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.__L7036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/weave/ConditionalDirectCopyTransformMemberDto.java:67)", 7036, "Boolean");
    }

    static {
        org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto.initPerturbationLocation0();
    }
}

