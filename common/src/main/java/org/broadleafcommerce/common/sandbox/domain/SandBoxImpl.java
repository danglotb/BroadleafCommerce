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
@javax.persistence.Table(name = "BLC_SANDBOX")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSandBoxElements")
@org.hibernate.annotations.SQLDelete(sql = "UPDATE BLC_SANDBOX SET ARCHIVED = 'Y' WHERE SANDBOX_ID = ?")
@org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform({ @org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformMember(templateTokens = org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransformTypes.AUDITABLE_ONLY) })
public class SandBoxImpl implements org.broadleafcommerce.common.admin.domain.AdminMainEntity , org.broadleafcommerce.common.sandbox.domain.SandBox {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.class);

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "SandBoxId")
    @org.hibernate.annotations.GenericGenerator(name = "SandBoxId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "SandBoxImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.sandbox.domain.SandBoxImpl") })
    @javax.persistence.Column(name = "SANDBOX_ID")
    @org.broadleafcommerce.common.presentation.AdminPresentation(visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL)
    protected java.lang.Long id;

    @javax.persistence.Column(name = "SANDBOX_NAME")
    @org.hibernate.annotations.Index(name = "SANDBOX_NAME_INDEX", columnNames = { "SANDBOX_NAME" })
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SandBoxImpl_Name", group = org.broadleafcommerce.common.sandbox.domain.SandboxAdminPresentation.GroupName.Description, prominent = true, gridOrder = 2000, order = 1000, validationConfigurations = { @org.broadleafcommerce.common.presentation.ValidationConfiguration(validationImplementation = "blSandBoxNameValidator") })
    protected java.lang.String name;

    @javax.persistence.Column(name = "AUTHOR")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SandBoxImpl_Author", group = org.broadleafcommerce.common.sandbox.domain.SandboxAdminPresentation.GroupName.Description, gridOrder = 3000, order = 3000, visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.FORM_HIDDEN)
    protected java.lang.Long author;

    @javax.persistence.Column(name = "SANDBOX_TYPE")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SandBoxImpl_SandBox_Type", group = org.broadleafcommerce.common.sandbox.domain.SandboxAdminPresentation.GroupName.Description, visibility = org.broadleafcommerce.common.presentation.client.VisibilityEnum.HIDDEN_ALL, readOnly = true, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.sandbox.domain.SandBoxType")
    protected java.lang.String sandboxType = org.broadleafcommerce.common.sandbox.domain.SandBoxType.APPROVAL.getType();

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.class)
    @javax.persistence.JoinColumn(name = "PARENT_SANDBOX_ID")
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSandBoxElements")
    protected org.broadleafcommerce.common.sandbox.domain.SandBox parentSandBox;

    @javax.persistence.OneToMany(mappedBy = "parentSandBox", targetEntity = org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.class)
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE, region = "blSandBoxElements")
    protected java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> childSandBoxes;

    @javax.persistence.Column(name = "COLOR")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "SandBoxImpl_Color", group = org.broadleafcommerce.common.sandbox.domain.SandboxAdminPresentation.GroupName.Description, prominent = true, gridOrder = 1000, fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.COLOR, order = 2000)
    protected java.lang.String color;

    @javax.persistence.Column(name = "DESCRIPTION")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = org.broadleafcommerce.common.sandbox.domain.SandboxAdminPresentation.GroupName.Description, group = org.broadleafcommerce.common.sandbox.domain.SandboxAdminPresentation.GroupName.Description, prominent = true, gridOrder = 4000, order = 4000)
    protected java.lang.String description;

    @javax.persistence.Column(name = "GO_LIVE_DATE")
    protected java.util.Date goLiveDate;

    @javax.persistence.Embedded
    protected org.broadleafcommerce.common.persistence.ArchiveStatus archiveStatus = new org.broadleafcommerce.common.persistence.ArchiveStatus();

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getName() {
        return name;
    }

    @java.lang.Override
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBoxType getSandBoxType() {
        return org.broadleafcommerce.common.sandbox.domain.SandBoxType.getInstance(sandboxType);
    }

    @java.lang.Override
    public void setSandBoxType(final org.broadleafcommerce.common.sandbox.domain.SandBoxType sandboxType) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4708, (sandboxType != null))) {
            this.sandboxType = sandboxType.getType();
        }
    }

    @java.lang.Override
    public java.lang.Long getAuthor() {
        return author;
    }

    @java.lang.Override
    public void setAuthor(java.lang.Long author) {
        this.author = author;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox getParentSandBox() {
        return parentSandBox;
    }

    @java.lang.Override
    public void setParentSandBox(org.broadleafcommerce.common.sandbox.domain.SandBox parentSandBox) {
        this.parentSandBox = parentSandBox;
    }

    @java.lang.Override
    public java.lang.String getColor() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4709, org.apache.commons.lang3.StringUtils.isNotBlank(color))) {
            return color;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4710, ((parentSandBox) != null))) {
            return parentSandBox.getColor();
        }
        return null;
    }

    @java.lang.Override
    public void setColor(java.lang.String color) {
        this.color = color;
    }

    @java.lang.Override
    public java.util.Date getGoLiveDate() {
        return goLiveDate;
    }

    @java.lang.Override
    public void setGoLiveDate(java.util.Date goLiveDate) {
        this.goLiveDate = goLiveDate;
    }

    public java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> getChildSandBoxes() {
        return childSandBoxes;
    }

    public void setChildSandBoxes(java.util.List<org.broadleafcommerce.common.sandbox.domain.SandBox> childSandBoxes) {
        this.childSandBoxes = childSandBoxes;
    }

    @java.lang.Override
    public java.util.List<java.lang.Long> getSandBoxIdsForUpwardHierarchy(boolean includeInherited) {
        return getSandBoxIdsForUpwardHierarchy(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4711, includeInherited), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4712, true));
    }

    @java.lang.Override
    public java.util.List<java.lang.Long> getSandBoxIdsForUpwardHierarchy(boolean includeInherited, boolean includeCurrent) {
        java.util.List<java.lang.Long> ids = new java.util.ArrayList<java.lang.Long>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4713, includeCurrent)) {
            ids.add(this.getId());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4714, includeInherited)) {
            org.broadleafcommerce.common.sandbox.domain.SandBox current = this;
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4715, ((current.getParentSandBox()) != null))) {
                current = current.getParentSandBox();
                ids.add(current.getId());
            } 
            java.util.Collections.reverse(ids);
        }
        return ids;
    }

    @java.lang.Override
    public int hashCode() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4718, new org.apache.commons.lang3.builder.HashCodeBuilder(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4716, 1), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4717, 31)).append(author).append(id).append(name).append(color).append(goLiveDate).toHashCode());
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4721, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4719, (obj != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4720, getClass().isAssignableFrom(obj.getClass())))))) {
            org.broadleafcommerce.common.sandbox.domain.SandBoxImpl other = ((org.broadleafcommerce.common.sandbox.domain.SandBoxImpl) (obj));
            return new org.apache.commons.lang3.builder.EqualsBuilder().append(author, other.author).append(id, other.id).append(name, other.name).append(color, other.color).append(goLiveDate, other.goLiveDate).build();
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4722, false);
    }

    @java.lang.Override
    public java.lang.String getMainEntityName() {
        return getName();
    }

    @java.lang.Override
    public boolean getIsInDefaultHierarchy() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4723, org.broadleafcommerce.common.sandbox.domain.SandBoxType.DEFAULT.equals(getSandBoxType()))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4724, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4725, ((getParentSandBox()) != null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4726, getParentSandBox().getIsInDefaultHierarchy());
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4727, false);
    }

    @java.lang.Override
    public void setArchived(java.lang.Character archived) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4728, ((archiveStatus) == null))) {
            archiveStatus = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }
        archiveStatus.setArchived(archived);
    }

    @java.lang.Override
    public java.lang.Character getArchived() {
        org.broadleafcommerce.common.persistence.ArchiveStatus temp;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4729, ((archiveStatus) == null))) {
            temp = new org.broadleafcommerce.common.persistence.ArchiveStatus();
        }else {
            temp = archiveStatus;
        }
        return temp.getArchived();
    }

    @java.lang.Override
    public boolean isActive() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4730, ('Y' != (getArchived())));
    }

    public static perturbation.location.PerturbationLocation __L4708;

    public static perturbation.location.PerturbationLocation __L4709;

    public static perturbation.location.PerturbationLocation __L4710;

    public static perturbation.location.PerturbationLocation __L4711;

    public static perturbation.location.PerturbationLocation __L4712;

    public static perturbation.location.PerturbationLocation __L4713;

    public static perturbation.location.PerturbationLocation __L4714;

    public static perturbation.location.PerturbationLocation __L4715;

    public static perturbation.location.PerturbationLocation __L4716;

    public static perturbation.location.PerturbationLocation __L4717;

    public static perturbation.location.PerturbationLocation __L4718;

    public static perturbation.location.PerturbationLocation __L4719;

    public static perturbation.location.PerturbationLocation __L4720;

    public static perturbation.location.PerturbationLocation __L4721;

    public static perturbation.location.PerturbationLocation __L4722;

    public static perturbation.location.PerturbationLocation __L4723;

    public static perturbation.location.PerturbationLocation __L4724;

    public static perturbation.location.PerturbationLocation __L4725;

    public static perturbation.location.PerturbationLocation __L4726;

    public static perturbation.location.PerturbationLocation __L4727;

    public static perturbation.location.PerturbationLocation __L4728;

    public static perturbation.location.PerturbationLocation __L4729;

    public static perturbation.location.PerturbationLocation __L4730;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:162)", 4708, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:189)", 4709, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:193)", 4710, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:225)", 4711, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:225)", 4712, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:231)", 4713, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:234)", 4714, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:236)", 4715, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:247)", 4716, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:247)", 4717, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:247)", 4718, "Numerical");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:258)", 4719, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:258)", 4720, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:258)", 4721, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:268)", 4722, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:278)", 4723, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:279)", 4724, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:282)", 4725, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:283)", 4726, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:286)", 4727, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:291)", 4728, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:300)", 4729, "Boolean");
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.__L4730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/sandbox/domain/SandBoxImpl.java:310)", 4730, "Boolean");
    }

    static {
        org.broadleafcommerce.common.sandbox.domain.SandBoxImpl.initPerturbationLocation0();
    }
}

