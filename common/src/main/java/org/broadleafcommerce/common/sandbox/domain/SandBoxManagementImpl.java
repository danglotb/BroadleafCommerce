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
package org.broadleafcommerce.common.sandbox.domain;


@javax.persistence.Entity
@javax.persistence.Inheritance(strategy = javax.persistence.InheritanceType.JOINED)
@javax.persistence.Table(name = "BLC_SANDBOX_MGMT")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSandBoxElements")
@org.broadleafcommerce.common.presentation.AdminPresentationClass(populateToOneFields = org.broadleafcommerce.common.presentation.PopulateToOneFieldsEnum.TRUE)
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTITENANT_SITE), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY), @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.MULTI_PHASE_ADD) })
public class SandBoxManagementImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.sandbox.domain.SandBoxManagement {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl.class);

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "SandBoxMgmtId")
    @org.hibernate.annotations.GenericGenerator(name = "SandBoxMgmtId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SandBoxManagementImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.sandbox.domain.SandBoxManagementImpl") })
    @javax.persistence.Column(name = "SANDBOX_MGMT_ID")
    protected java.lang.Long id;

    @javax.persistence.OneToOne(targetEntity = org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.class, cascade = { javax.persistence.CascadeType.ALL }, optional = false)
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSandBoxElements")
    @org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.ALL })
    @javax.persistence.JoinColumn(name = "SANDBOX_ID")
    protected org.broadleafcommerce.common.sandbox.domain.SandBox sandBox;

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return sandBox.getName();
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox getSandBox() {
        return sandBox;
    }

    @java.lang.Override
    public void setSandBox(org.broadleafcommerce.common.sandbox.domain.SandBox sandBox) {
        this.sandBox = sandBox;
    }
}

