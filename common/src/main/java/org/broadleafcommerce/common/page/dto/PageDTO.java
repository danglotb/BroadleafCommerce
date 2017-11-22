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
package org.broadleafcommerce.common.page.dto;


public class PageDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.Long id;

    protected java.lang.String description;

    protected java.lang.String localeCode;

    protected java.lang.String templatePath;

    protected java.lang.String url;

    protected java.lang.Integer priority;

    protected java.util.Map<java.lang.String, java.lang.Object> pageFields = new java.util.HashMap<java.lang.String, java.lang.Object>();

    protected java.lang.String ruleExpression;

    protected java.util.List<org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO> itemCriteriaDTOList;

    protected java.util.Map<java.lang.String, java.lang.String> pageAttributes = new java.util.HashMap<java.lang.String, java.lang.String>();

    protected java.util.Map<java.lang.String, java.lang.Object> foreignPageFields = new java.util.HashMap<java.lang.String, java.lang.Object>();

    public java.lang.Object getPropertyValue(java.lang.String propertyName) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.page.dto.PageDTO.__L3722, getPageFields().containsKey(propertyName))) {
            return getPageFields().get(propertyName);
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.page.dto.PageDTO.__L3723, getPageAttributes().containsKey(propertyName))) {
                return getPageAttributes().get(propertyName);
            }else {
                try {
                    return org.apache.commons.beanutils.BeanUtils.getProperty(this, propertyName);
                } catch (java.lang.Exception e) {
                    return null;
                }
            }

    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(java.lang.String localeCode) {
        this.localeCode = localeCode;
    }

    public java.lang.String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(java.lang.String templatePath) {
        this.templatePath = templatePath;
    }

    public java.lang.String getUrl() {
        return url;
    }

    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getPageFields() {
        return pageFields;
    }

    public void setPageFields(java.util.Map<java.lang.String, java.lang.Object> pageFields) {
        this.pageFields = pageFields;
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

    public java.lang.Integer getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.page.dto.PageDTO.__L3724, priority);
    }

    public void setPriority(java.lang.Integer priority) {
        this.priority = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.page.dto.PageDTO.__L3725, priority);
    }

    public java.util.Map<java.lang.String, java.lang.String> getPageAttributes() {
        return pageAttributes;
    }

    public void setPageAttributes(java.util.Map<java.lang.String, java.lang.String> pageAttributes) {
        this.pageAttributes = pageAttributes;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getForeignPageFields() {
        return foreignPageFields;
    }

    public void setForeignPageFields(java.util.Map<java.lang.String, java.lang.Object> foreignPageFields) {
        this.foreignPageFields = foreignPageFields;
    }

    public void copy(org.broadleafcommerce.common.page.dto.PageDTO original) {
        description = original.description;
        id = original.id;
        localeCode = original.localeCode;
        templatePath = original.templatePath;
        url = original.url;
        priority = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.page.dto.PageDTO.__L3726, original.priority);
        pageFields = new java.util.HashMap<java.lang.String, java.lang.Object>(original.pageFields);
        ruleExpression = original.ruleExpression;
        itemCriteriaDTOList = original.itemCriteriaDTOList;
        pageAttributes = original.pageAttributes;
    }

    public static perturbation.location.PerturbationLocation __L3722;

    public static perturbation.location.PerturbationLocation __L3723;

    public static perturbation.location.PerturbationLocation __L3724;

    public static perturbation.location.PerturbationLocation __L3725;

    public static perturbation.location.PerturbationLocation __L3726;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.page.dto.PageDTO.__L3722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/page/dto/PageDTO.java:58)", 3722, "Boolean");
        org.broadleafcommerce.common.page.dto.PageDTO.__L3723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/page/dto/PageDTO.java:60)", 3723, "Boolean");
        org.broadleafcommerce.common.page.dto.PageDTO.__L3724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/page/dto/PageDTO.java:136)", 3724, "Numerical");
        org.broadleafcommerce.common.page.dto.PageDTO.__L3725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/page/dto/PageDTO.java:140)", 3725, "Numerical");
        org.broadleafcommerce.common.page.dto.PageDTO.__L3726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/page/dto/PageDTO.java:165)", 3726, "Numerical");
    }

    static {
        org.broadleafcommerce.common.page.dto.PageDTO.initPerturbationLocation0();
    }
}

