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
package org.broadleafcommerce.common.structure.dto;


public class ItemCriteriaDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.Integer qty;

    protected java.lang.String matchRule;

    public java.lang.Integer getQty() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.__L5568, qty);
    }

    public void setQty(java.lang.Integer qty) {
        this.qty = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.__L5569, qty);
    }

    public java.lang.String getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(java.lang.String matchRule) {
        this.matchRule = matchRule;
    }

    public org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO getClone() {
        org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO clonedDto = new org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO();
        clonedDto.setQty(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.__L5570, qty));
        clonedDto.setMatchRule(matchRule);
        return clonedDto;
    }

    public static perturbation.location.PerturbationLocation __L5568;

    public static perturbation.location.PerturbationLocation __L5569;

    public static perturbation.location.PerturbationLocation __L5570;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.__L5568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/ItemCriteriaDTO.java:39)", 5568, "Numerical");
        org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.__L5569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/ItemCriteriaDTO.java:43)", 5569, "Numerical");
        org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.__L5570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/ItemCriteriaDTO.java:56)", 5570, "Numerical");
    }

    static {
        org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO.initPerturbationLocation0();
    }
}

