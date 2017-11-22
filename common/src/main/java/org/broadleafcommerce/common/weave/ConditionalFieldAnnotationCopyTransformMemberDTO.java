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


public class ConditionalFieldAnnotationCopyTransformMemberDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.String[] templateNames;

    protected java.lang.String conditionalProperty;

    public java.lang.String[] getTemplateNames() {
        return templateNames;
    }

    public void setTemplateNames(java.lang.String[] templateNames) {
        this.templateNames = templateNames;
    }

    public java.lang.String getConditionalProperty() {
        return conditionalProperty;
    }

    public void setConditionalProperty(java.lang.String propertyName) {
        this.conditionalProperty = propertyName;
    }
}

