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


public class StructuredContentDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.Long id;

    protected java.lang.String contentName;

    protected java.lang.String contentType;

    protected java.lang.String localeCode;

    protected java.lang.Integer priority;

    protected java.util.Map<java.lang.String, java.lang.Object> values = new java.util.HashMap<java.lang.String, java.lang.Object>();

    protected java.lang.String ruleExpression;

    protected java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> itemCriteriaDTOList;

    public java.lang.Object getPropertyValue(java.lang.String propertyName) {
        try {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5571, getValues().containsKey(propertyName)) ? getValues().get(propertyName) : org.apache.commons.beanutils.BeanUtils.getProperty(this, propertyName);
        } catch (java.lang.Exception e) {
            return null;
        }
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getContentName() {
        return contentName;
    }

    public void setContentName(java.lang.String contentName) {
        values.put("contentName", contentName);
        this.contentName = contentName;
    }

    public java.lang.String getContentType() {
        return contentType;
    }

    public void setContentType(java.lang.String contentType) {
        values.put("contentType", contentType);
        this.contentType = contentType;
    }

    public java.lang.String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(java.lang.String localeCode) {
        values.put("localeCode", localeCode);
        this.localeCode = localeCode;
    }

    public java.lang.Integer getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5572, priority);
    }

    public void setPriority(java.lang.Integer priority) {
        values.put("priority", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5573, priority));
        this.priority = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5574, priority);
    }

    public java.util.Map<java.lang.String, java.lang.Object> getValues() {
        return values;
    }

    public void setValues(java.util.Map<java.lang.String, java.lang.Object> values) {
        this.values = values;
    }

    public java.lang.String getRuleExpression() {
        return ruleExpression;
    }

    public void setRuleExpression(java.lang.String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

    public java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> getItemCriteriaDTOList() {
        return itemCriteriaDTOList;
    }

    public void setItemCriteriaDTOList(java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> itemCriteriaDTOList) {
        this.itemCriteriaDTOList = itemCriteriaDTOList;
    }

    public org.broadleafcommerce.common.structure.dto.StructuredContentDTO getClone() {
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO clonedDto = new org.broadleafcommerce.common.structure.dto.StructuredContentDTO();
        clonedDto.setId(id);
        clonedDto.setContentName(contentName);
        clonedDto.setContentType(contentType);
        clonedDto.setLocaleCode(localeCode);
        clonedDto.setPriority(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5575, priority));
        clonedDto.setValues(new java.util.HashMap<java.lang.String, java.lang.Object>(values));
        clonedDto.setRuleExpression(ruleExpression);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5576, ((itemCriteriaDTOList) != null))) {
            java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> itemCriteriaDTOs = new java.util.ArrayList<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO>();
            for (org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO itemCriteriaDto : itemCriteriaDTOList) {
                itemCriteriaDTOs.add(itemCriteriaDto.getClone());
            }
            clonedDto.setItemCriteriaDTOList(itemCriteriaDTOs);
        }
        return clonedDto;
    }

    public static perturbation.location.PerturbationLocation __L5571;

    public static perturbation.location.PerturbationLocation __L5572;

    public static perturbation.location.PerturbationLocation __L5573;

    public static perturbation.location.PerturbationLocation __L5574;

    public static perturbation.location.PerturbationLocation __L5575;

    public static perturbation.location.PerturbationLocation __L5576;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTO.java:58)", 5571, "Boolean");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTO.java:100)", 5572, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTO.java:104)", 5573, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTO.java:105)", 5574, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTO.java:138)", 5575, "Numerical");
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.__L5576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/structure/dto/StructuredContentDTO.java:141)", 5576, "Boolean");
    }

    static {
        org.broadleafcommerce.common.structure.dto.StructuredContentDTO.initPerturbationLocation0();
    }
}

