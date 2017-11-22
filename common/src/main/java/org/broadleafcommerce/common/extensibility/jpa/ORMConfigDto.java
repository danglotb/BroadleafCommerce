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
package org.broadleafcommerce.common.extensibility.jpa;


public class ORMConfigDto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected java.lang.String puName;

    protected java.util.List<java.lang.String> classNames = new java.util.ArrayList<>();

    protected java.util.List<java.lang.String> mappingFiles = new java.util.ArrayList<>();

    public ORMConfigDto(java.lang.String puName) {
        this.puName = puName;
    }

    public java.lang.String getPuName() {
        return puName;
    }

    public org.broadleafcommerce.common.extensibility.jpa.ORMConfigDto addClassName(java.lang.String className) {
        this.classNames.add(className);
        return this;
    }

    public org.broadleafcommerce.common.extensibility.jpa.ORMConfigDto setClassNames(java.util.List<java.lang.String> classNames) {
        this.classNames = classNames;
        return this;
    }

    @javax.annotation.Nullable
    public java.util.List<java.lang.String> getClassNames() {
        return classNames;
    }

    public org.broadleafcommerce.common.extensibility.jpa.ORMConfigDto addMappingFile(java.lang.String mappingFile) {
        this.mappingFiles.add(mappingFile);
        return this;
    }

    public org.broadleafcommerce.common.extensibility.jpa.ORMConfigDto setMappingFiles(java.util.List<java.lang.String> mappingFiles) {
        this.mappingFiles = mappingFiles;
        return this;
    }

    public java.util.List<java.lang.String> getMappingFiles() {
        return mappingFiles;
    }
}

