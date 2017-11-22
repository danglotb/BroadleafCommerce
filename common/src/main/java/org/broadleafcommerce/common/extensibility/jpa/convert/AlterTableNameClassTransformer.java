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
package org.broadleafcommerce.common.extensibility.jpa.convert;


public class AlterTableNameClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.class);

    protected java.lang.String tableName;

    protected java.lang.String targetedClass;

    public AlterTableNameClassTransformer() {
        this(null, null);
    }

    public AlterTableNameClassTransformer(java.lang.String tableName) {
        this(tableName, null);
    }

    public AlterTableNameClassTransformer(java.lang.String tableName, java.lang.String targetedClass) {
        this.tableName = tableName;
        this.targetedClass = targetedClass;
        if (org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.LOG.isDebugEnabled()) {
            org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.LOG.debug(((("Constructed table name Transformer. Targeted Class:" + targetedClass) + " Table Name: ") + tableName));
        }
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1893, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1891, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1889, (className == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1890, org.apache.commons.lang3.StringUtils.isBlank(getTargetedClass())))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1892, org.apache.commons.lang3.StringUtils.isBlank(getTableName())))))) {
            return null;
        }
        byte[] classBytes = null;
        java.lang.String convertedClassName = className.replace('/', '.');
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1894, convertedClassName.equalsIgnoreCase(getTargetedClass()))) {
            try {
                java.lang.String targetValue = getTableName();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1895, org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.LOG.debug((("Altering " + convertedClassName) + " table name"));
                }
                javassist.bytecode.ClassFile classFile = new javassist.bytecode.ClassFile(new java.io.DataInputStream(new java.io.ByteArrayInputStream(classfileBuffer)));
                javassist.bytecode.ConstPool constantPool = classFile.getConstPool();
                alterTableAnnotation(classFile, targetValue, constantPool);
                java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                java.io.DataOutputStream os = new java.io.DataOutputStream(bos);
                classFile.write(os);
                os.close();
                classBytes = bos.toByteArray();
            } catch (java.lang.Exception ex) {
                ex.printStackTrace();
                throw new java.lang.instrument.IllegalClassFormatException(((("Unable to convert " + convertedClassName) + " to a SingleTable inheritance strategy: ") + (ex.getMessage())));
            }
        }
        return classBytes;
    }

    protected void alterTableAnnotation(javassist.bytecode.ClassFile classFile, java.lang.String tableName, javassist.bytecode.ConstPool constantPool) throws javassist.NotFoundException {
        java.util.List<?> classFileAttributes = classFile.getAttributes();
        java.util.Iterator<?> classItr = classFileAttributes.iterator();
        javassist.bytecode.AnnotationsAttribute attr = null;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1896, classItr.hasNext())) {
            java.lang.Object object = classItr.next();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1897, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                for (javassist.bytecode.annotation.Annotation annotation : items) {
                    java.lang.String typeName = annotation.getTypeName();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1898, typeName.equals(javax.persistence.Table.class.getName()))) {
                        java.util.Set<java.lang.String> keys = annotation.getMemberNames();
                        for (java.lang.String key : keys) {
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1899, key.equalsIgnoreCase("name"))) {
                                javassist.bytecode.annotation.StringMemberValue value = ((javassist.bytecode.annotation.StringMemberValue) (annotation.getMemberValue(key)));
                                java.lang.String oldTableName = value.getValue();
                                value.setValue(tableName);
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1900, org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.LOG.isDebugEnabled())) {
                                    org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.LOG.debug((((((("Altering " + (classFile.getName())) + " table name from: ") + oldTableName) + "") + " to: ") + (value.getValue())));
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                attr.setAnnotations(items);
                break;
            }
        } 
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1901, (attr != null))) {
            classItr.remove();
            classFile.addAttribute(attr);
        }
    }

    public java.lang.String getTableName() {
        return tableName;
    }

    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }

    public java.lang.String getTargetedClass() {
        return targetedClass;
    }

    public void setTargetedClass(java.lang.String targetedClass) {
        this.targetedClass = targetedClass;
    }

    public static perturbation.location.PerturbationLocation __L1889;

    public static perturbation.location.PerturbationLocation __L1890;

    public static perturbation.location.PerturbationLocation __L1891;

    public static perturbation.location.PerturbationLocation __L1892;

    public static perturbation.location.PerturbationLocation __L1893;

    public static perturbation.location.PerturbationLocation __L1894;

    public static perturbation.location.PerturbationLocation __L1895;

    public static perturbation.location.PerturbationLocation __L1896;

    public static perturbation.location.PerturbationLocation __L1897;

    public static perturbation.location.PerturbationLocation __L1898;

    public static perturbation.location.PerturbationLocation __L1899;

    public static perturbation.location.PerturbationLocation __L1900;

    public static perturbation.location.PerturbationLocation __L1901;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1889 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:110)", 1889, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1890 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:110)", 1890, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1891 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:110)", 1891, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1892 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:110)", 1892, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1893 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:110)", 1893, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1894 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:116)", 1894, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1895 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:120)", 1895, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1896 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:156)", 1896, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:158)", 1897, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:163)", 1898, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:166)", 1899, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:170)", 1900, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.__L1901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/AlterTableNameClassTransformer.java:184)", 1901, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer.initPerturbationLocation0();
    }
}

