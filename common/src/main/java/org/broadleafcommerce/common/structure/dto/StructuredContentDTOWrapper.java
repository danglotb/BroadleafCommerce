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


public class StructuredContentDTOWrapper extends org.broadleafcommerce.common.structure.dto.StructuredContentDTO {
    private static final long serialVersionUID = 1L;

    private org.broadleafcommerce.common.structure.dto.StructuredContentDTO structuredContentDTO;

    private java.lang.Integer priority;

    public StructuredContentDTOWrapper(org.broadleafcommerce.common.structure.dto.StructuredContentDTO structuredContentDTO) {
        this.structuredContentDTO = structuredContentDTO;
    }

    public boolean equals(java.lang.Object arg0) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5577, structuredContentDTO.equals(arg0));
    }

    public java.lang.Object getPropertyValue(java.lang.String propertyName) {
        return structuredContentDTO.getPropertyValue(propertyName);
    }

    public java.lang.Long getId() {
        return structuredContentDTO.getId();
    }

    public java.lang.String getContentName() {
        return structuredContentDTO.getContentName();
    }

    public java.lang.String getContentType() {
        return structuredContentDTO.getContentType();
    }

    public java.lang.String getLocaleCode() {
        return structuredContentDTO.getLocaleCode();
    }

    public java.lang.Integer getPriority() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5578, ((priority) != null))) {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5579, priority);
        }else {
            return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5580, structuredContentDTO.getPriority());
        }
    }

    public java.util.Map getValues() {
        return structuredContentDTO.getValues();
    }

    public java.lang.String getRuleExpression() {
        return structuredContentDTO.getRuleExpression();
    }

    public java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> getItemCriteriaDTOList() {
        return structuredContentDTO.getItemCriteriaDTOList();
    }

    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5581, structuredContentDTO.hashCode());
    }

    public void setId(java.lang.Long id) {
        structuredContentDTO.setId(id);
    }

    public void setContentName(java.lang.String contentName) {
        structuredContentDTO.setContentName(contentName);
    }

    public void setContentType(java.lang.String contentType) {
        structuredContentDTO.setContentType(contentType);
    }

    public void setLocaleCode(java.lang.String localeCode) {
        structuredContentDTO.setLocaleCode(localeCode);
    }

    public void setPriority(java.lang.Integer priority) {
        structuredContentDTO.setPriority(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5582, priority));
    }

    public void setValues(java.util.Map values) {
        structuredContentDTO.setValues(values);
    }

    public void setRuleExpression(java.lang.String ruleExpression) {
        structuredContentDTO.setRuleExpression(ruleExpression);
    }

    public void setItemCriteriaDTOList(java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> itemCriteriaDTOList) {
        structuredContentDTO.setItemCriteriaDTOList(itemCriteriaDTOList);
    }

    public java.lang.String toString() {
        return structuredContentDTO.toString();
    }

    public static perturbation.location.PerturbationLocation __L5577;

    public static perturbation.location.PerturbationLocation __L5578;

    public static perturbation.location.PerturbationLocation __L5579;

    public static perturbation.location.PerturbationLocation __L5580;

    public static perturbation.location.PerturbationLocation __L5581;

    public static perturbation.location.PerturbationLocation __L5582;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTOWrapper.java:39)", 5577, "Boolean");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTOWrapper.java:63)", 5578, "Boolean");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTOWrapper.java:64)", 5579, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTOWrapper.java:66)", 5580, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTOWrapper.java:83)", 5581, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.__L5582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTOWrapper.java:103)", 5582, "Numerical");
    }

    static {
        org.broadleafcommerce.common.structure.dto.StructuredContentDTOWrapper.initPerturbationLocation0();
    }
}

