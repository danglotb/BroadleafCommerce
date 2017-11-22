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
package org.broadleafcommerce.common.extensibility.jpa.copy;


public class RemoveAnnotationClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer , org.springframework.beans.factory.BeanFactoryAware {
    private static final org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.class);

    protected java.lang.String moduleName;

    protected java.util.List<java.lang.String> classNames = new java.util.ArrayList<java.lang.String>();

    protected java.lang.String annotationClass;

    protected java.lang.String conditionalPropertyName;

    protected org.springframework.beans.factory.config.ConfigurableBeanFactory beanFactory;

    public RemoveAnnotationClassTransformer(java.lang.String moduleName) {
        this.moduleName = moduleName;
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    @java.lang.Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) throws org.springframework.beans.BeansException {
        this.beanFactory = ((org.springframework.beans.factory.config.ConfigurableBeanFactory) (beanFactory));
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2152, (className == null))) {
            return null;
        }
        javassist.CtClass clazz = null;
        try {
            java.lang.String convertedClassName = className.replace('/', '.');
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2158, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2156, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2154, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2153, classNames.isEmpty()))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2155, classNames.contains(convertedClassName)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2157, (((conditionalPropertyName) == null) || (isPropertyEnabled(conditionalPropertyName)))))))) {
                javassist.ClassPool classPool = javassist.ClassPool.getDefault();
                clazz = classPool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2159, false));
                clazz.defrost();
                javassist.bytecode.ClassFile classFile = clazz.getClassFile();
                javassist.bytecode.ConstPool constantPool = classFile.getConstPool();
                {
                    java.util.List<?> attributes = classFile.getAttributes();
                    javassist.bytecode.AnnotationsAttribute annotationsAttribute = stripAnnotation(constantPool, attributes);
                    classFile.addAttribute(annotationsAttribute);
                }
                {
                    java.util.List<javassist.bytecode.FieldInfo> fieldInfos = classFile.getFields();
                    for (javassist.bytecode.FieldInfo myField : fieldInfos) {
                        java.util.List<?> attributes = myField.getAttributes();
                        javassist.bytecode.AnnotationsAttribute annotationsAttribute = stripAnnotation(constantPool, attributes);
                        myField.addAttribute(annotationsAttribute);
                    }
                }
                return clazz.toBytecode();
            }
        } catch (java.lang.ClassCircularityError error) {
            error.printStackTrace();
            throw error;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Unable to transform class", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2160, (clazz != null))) {
                try {
                    clazz.detach();
                } catch (java.lang.Exception e) {
                }
            }
        }
        return null;
    }

    protected javassist.bytecode.AnnotationsAttribute stripAnnotation(javassist.bytecode.ConstPool constantPool, java.util.List<?> attributes) {
        java.util.Iterator<?> itr = attributes.iterator();
        javassist.bytecode.AnnotationsAttribute annotationsAttribute = new javassist.bytecode.AnnotationsAttribute(constantPool, javassist.bytecode.AnnotationsAttribute.visibleTag);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2161, itr.hasNext())) {
            java.lang.Object object = itr.next();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2162, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                for (javassist.bytecode.annotation.Annotation annotation : items) {
                    java.lang.String typeName = annotation.getTypeName();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2163, typeName.equals(annotationClass))) {
                        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.logger.debug(java.lang.String.format("Stripping out %s annotation", annotationClass));
                        continue;
                    }
                    annotationsAttribute.addAnnotation(annotation);
                }
                itr.remove();
            }
        } 
        return annotationsAttribute;
    }

    protected java.lang.Boolean isPropertyEnabled(java.lang.String propertyName) {
        java.lang.Boolean shouldProceed;
        try {
            java.lang.String value = beanFactory.resolveEmbeddedValue((("${" + propertyName) + ":false}"));
            shouldProceed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2164, java.lang.Boolean.parseBoolean(value));
        } catch (java.lang.Exception e) {
            shouldProceed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2165, false);
        }
        return shouldProceed;
    }

    public java.util.List<java.lang.String> getClassNames() {
        return classNames;
    }

    public void setClassNames(java.util.List<java.lang.String> classNames) {
        this.classNames = classNames;
    }

    public java.lang.String getAnnotationClass() {
        return annotationClass;
    }

    public void setAnnotationClass(java.lang.String annotationClass) {
        this.annotationClass = annotationClass;
    }

    public java.lang.String getConditionalPropertyName() {
        return conditionalPropertyName;
    }

    public void setConditionalPropertyName(java.lang.String conditionalPropertyName) {
        this.conditionalPropertyName = conditionalPropertyName;
    }

    public static perturbation.location.PerturbationLocation __L2152;

    public static perturbation.location.PerturbationLocation __L2153;

    public static perturbation.location.PerturbationLocation __L2154;

    public static perturbation.location.PerturbationLocation __L2155;

    public static perturbation.location.PerturbationLocation __L2156;

    public static perturbation.location.PerturbationLocation __L2157;

    public static perturbation.location.PerturbationLocation __L2158;

    public static perturbation.location.PerturbationLocation __L2159;

    public static perturbation.location.PerturbationLocation __L2160;

    public static perturbation.location.PerturbationLocation __L2161;

    public static perturbation.location.PerturbationLocation __L2162;

    public static perturbation.location.PerturbationLocation __L2163;

    public static perturbation.location.PerturbationLocation __L2164;

    public static perturbation.location.PerturbationLocation __L2165;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:78)", 2152, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:88)", 2153, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:88)", 2154, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:89)", 2155, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:88)", 2156, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:90)", 2157, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:88)", 2158, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:96)", 2159, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:123)", 2160, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:139)", 2161, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:141)", 2162, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:146)", 2163, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:162)", 2164, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.__L2165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/RemoveAnnotationClassTransformer.java:164)", 2165, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.copy.RemoveAnnotationClassTransformer.initPerturbationLocation0();
    }
}

