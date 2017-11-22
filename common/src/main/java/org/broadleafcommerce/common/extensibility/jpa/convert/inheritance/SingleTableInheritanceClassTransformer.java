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
package org.broadleafcommerce.common.extensibility.jpa.convert.inheritance;


public class SingleTableInheritanceClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    public static final java.lang.String SINGLE_TABLE_ENTITIES = "broadleaf.ejb.entities.override_single_table";

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.class);

    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo> infos = new java.util.ArrayList<org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo>();

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1835, ((java.lang.String) (key)).equals(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.SINGLE_TABLE_ENTITIES))) {
            java.lang.String[] classes = org.springframework.util.StringUtils.tokenizeToStringArray(props.getProperty(((java.lang.String) (key))), org.springframework.context.ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
            for (java.lang.String clazz : classes) {
                java.lang.String keyName;
                int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1836, clazz.lastIndexOf("."));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1839, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1837, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1838, 0))))) {
                    keyName = clazz.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1842, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1840, pos)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1841, 1)))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1843, clazz.length()));
                }else {
                    keyName = clazz;
                }
                org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo info = new org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo();
                info.setClassName(clazz);
                java.lang.String discriminatorName = props.getProperty((("broadleaf.ejb." + keyName) + ".discriminator.name"));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1844, (discriminatorName != null))) {
                    info.setDiscriminatorName(discriminatorName);
                    java.lang.String type = props.getProperty((("broadleaf.ejb." + keyName) + ".discriminator.type"));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1845, (type != null))) {
                        info.setDiscriminatorType(javax.persistence.DiscriminatorType.valueOf(type));
                    }
                    java.lang.String length = props.getProperty((("broadleaf.ejb." + keyName) + ".discriminator.length"));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1846, (length != null))) {
                        info.setDiscriminatorLength(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1847, java.lang.Integer.parseInt(length)));
                    }
                }
                infos.remove(info);
                infos.add(info);
            }
        }
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1848, (className == null))) {
            return null;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1849, infos.isEmpty())) {
            return null;
        }
        java.lang.String convertedClassName = className.replace('/', '.');
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo key = new org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo();
        key.setClassName(convertedClassName);
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1850, infos.indexOf(key));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1853, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1851, pos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1852, 0))))) {
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1854, org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.LOG.isDebugEnabled())) {
                    org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.LOG.debug((("Converting " + convertedClassName) + " to a SingleTable inheritance strategy."));
                }
                org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceInfo myInfo = infos.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1855, pos));
                javassist.bytecode.ClassFile classFile = new javassist.bytecode.ClassFile(new java.io.DataInputStream(new java.io.ByteArrayInputStream(classfileBuffer)));
                javassist.bytecode.ConstPool constantPool = classFile.getConstPool();
                javassist.bytecode.AnnotationsAttribute annotationsAttribute = new javassist.bytecode.AnnotationsAttribute(constantPool, javassist.bytecode.AnnotationsAttribute.visibleTag);
                java.util.List<?> attributes = classFile.getAttributes();
                java.util.Iterator<?> itr = attributes.iterator();
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1856, itr.hasNext())) {
                    java.lang.Object object = itr.next();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1857, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                        javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                        javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                        for (javassist.bytecode.annotation.Annotation annotation : items) {
                            java.lang.String typeName = annotation.getTypeName();
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1859, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1858, typeName.equals(javax.persistence.Inheritance.class.getName())))))) {
                                annotationsAttribute.addAnnotation(annotation);
                            }
                        }
                        itr.remove();
                    }
                } 
                javassist.bytecode.annotation.Annotation inheritance = new javassist.bytecode.annotation.Annotation(javax.persistence.Inheritance.class.getName(), constantPool);
                javassist.ClassPool pool = javassist.ClassPool.getDefault();
                pool.importPackage("javax.persistence");
                pool.importPackage("java.lang");
                javassist.bytecode.annotation.EnumMemberValue strategy = ((javassist.bytecode.annotation.EnumMemberValue) (javassist.bytecode.annotation.Annotation.createMemberValue(constantPool, pool.makeClass("InheritanceType"))));
                strategy.setType(javax.persistence.InheritanceType.class.getName());
                strategy.setValue(javax.persistence.InheritanceType.SINGLE_TABLE.name());
                inheritance.addMemberValue("strategy", strategy);
                annotationsAttribute.addAnnotation(inheritance);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1860, ((myInfo.getDiscriminatorName()) != null))) {
                    javassist.bytecode.annotation.Annotation discriminator = new javassist.bytecode.annotation.Annotation(javax.persistence.DiscriminatorColumn.class.getName(), constantPool);
                    javassist.bytecode.annotation.StringMemberValue name = new javassist.bytecode.annotation.StringMemberValue(constantPool);
                    name.setValue(myInfo.getDiscriminatorName());
                    discriminator.addMemberValue("name", name);
                    javassist.bytecode.annotation.EnumMemberValue discriminatorType = ((javassist.bytecode.annotation.EnumMemberValue) (javassist.bytecode.annotation.Annotation.createMemberValue(constantPool, pool.makeClass("DiscriminatorType"))));
                    discriminatorType.setType(javax.persistence.DiscriminatorType.class.getName());
                    discriminatorType.setValue(myInfo.getDiscriminatorType().name());
                    discriminator.addMemberValue("discriminatorType", discriminatorType);
                    javassist.bytecode.annotation.IntegerMemberValue length = new javassist.bytecode.annotation.IntegerMemberValue(constantPool);
                    length.setValue(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1861, myInfo.getDiscriminatorLength()));
                    discriminator.addMemberValue("length", length);
                    annotationsAttribute.addAnnotation(discriminator);
                }
                classFile.addAttribute(annotationsAttribute);
                java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                java.io.DataOutputStream os = new java.io.DataOutputStream(bos);
                classFile.write(os);
                os.close();
                return bos.toByteArray();
            } catch (java.lang.Exception ex) {
                ex.printStackTrace();
                throw new java.lang.instrument.IllegalClassFormatException(((("Unable to convert " + convertedClassName) + " to a SingleTable inheritance strategy: ") + (ex.getMessage())));
            }
        }else {
            return null;
        }
    }

    public static perturbation.location.PerturbationLocation __L1835;

    public static perturbation.location.PerturbationLocation __L1836;

    public static perturbation.location.PerturbationLocation __L1837;

    public static perturbation.location.PerturbationLocation __L1838;

    public static perturbation.location.PerturbationLocation __L1839;

    public static perturbation.location.PerturbationLocation __L1840;

    public static perturbation.location.PerturbationLocation __L1841;

    public static perturbation.location.PerturbationLocation __L1842;

    public static perturbation.location.PerturbationLocation __L1843;

    public static perturbation.location.PerturbationLocation __L1844;

    public static perturbation.location.PerturbationLocation __L1845;

    public static perturbation.location.PerturbationLocation __L1846;

    public static perturbation.location.PerturbationLocation __L1847;

    public static perturbation.location.PerturbationLocation __L1848;

    public static perturbation.location.PerturbationLocation __L1849;

    public static perturbation.location.PerturbationLocation __L1850;

    public static perturbation.location.PerturbationLocation __L1851;

    public static perturbation.location.PerturbationLocation __L1852;

    public static perturbation.location.PerturbationLocation __L1853;

    public static perturbation.location.PerturbationLocation __L1854;

    public static perturbation.location.PerturbationLocation __L1855;

    public static perturbation.location.PerturbationLocation __L1856;

    public static perturbation.location.PerturbationLocation __L1857;

    public static perturbation.location.PerturbationLocation __L1858;

    public static perturbation.location.PerturbationLocation __L1859;

    public static perturbation.location.PerturbationLocation __L1860;

    public static perturbation.location.PerturbationLocation __L1861;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:66)", 1835, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:70)", 1836, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:71)", 1837, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:71)", 1838, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:71)", 1839, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:72)", 1840, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:72)", 1841, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:72)", 1842, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1843 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:72)", 1843, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1844 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:79)", 1844, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:82)", 1845, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:86)", 1846, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:87)", 1847, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:99)", 1848, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:103)", 1849, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:109)", 1850, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:110)", 1851, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:110)", 1852, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:110)", 1853, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:112)", 1854, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:115)", 1855, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:121)", 1856, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:123)", 1857, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:128)", 1858, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:128)", 1859, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:144)", 1860, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.__L1861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/inheritance/SingleTableInheritanceClassTransformer.java:154)", 1861, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.convert.inheritance.SingleTableInheritanceClassTransformer.initPerturbationLocation0();
    }
}

