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


public interface IdGeneration extends java.io.Serializable {
    public java.lang.String getType();

    public void setType(java.lang.String type);

    public java.lang.Long getBegin();

    public void setBegin(java.lang.Long begin);

    public java.lang.Long getEnd();

    public void setEnd(java.lang.Long end);

    public java.lang.Long getBatchStart();

    public void setBatchStart(java.lang.Long batchStart);

    public java.lang.Long getBatchSize();

    public void setBatchSize(java.lang.Long batchSize);

    public java.lang.Integer getVersion();
}

