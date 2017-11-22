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


@java.lang.Deprecated
public class AnnotationsCopyClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    protected org.broadleafcommerce.common.logging.SupportLogger logger;

    protected java.lang.String moduleName;

    protected java.util.Map<java.lang.String, java.lang.String> xformTemplates = new java.util.HashMap<java.lang.String, java.lang.String>();

    protected static java.util.List<java.lang.String> transformedMethods = new java.util.ArrayList<java.lang.String>();

    public AnnotationsCopyClassTransformer(java.lang.String moduleName) {
        this.moduleName = moduleName;
        logger = org.broadleafcommerce.common.logging.SupportLogManager.getLogger(moduleName, this.getClass());
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1972, (className == null))) {
            return null;
        }
        java.lang.String convertedClassName = className.replace('/', '.');
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1973, xformTemplates.containsKey(convertedClassName))) {
            java.lang.String xformKey = convertedClassName;
            java.lang.String[] xformVals = xformTemplates.get(xformKey).split(",");
            logger.lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent.START, java.lang.String.format("Transform - Copying annotations into [%s] from [%s]", xformKey, org.apache.commons.lang.StringUtils.join(xformVals, ",")));
            javassist.CtClass clazz = null;
            try {
                javassist.ClassPool classPool = javassist.ClassPool.getDefault();
                clazz = classPool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1974, false));
                clazz.defrost();
                for (java.lang.String xformVal : xformVals) {
                    java.lang.String trimmed = xformVal.trim();
                    classPool.appendClassPath(new javassist.LoaderClassPath(java.lang.Class.forName(trimmed).getClassLoader()));
                    javassist.CtClass template = classPool.get(trimmed);
                    javassist.CtField[] fieldsToCopy = template.getDeclaredFields();
                    for (javassist.CtField field : fieldsToCopy) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1975, field.hasAnnotation(org.broadleafcommerce.common.extensibility.jpa.copy.NonCopied.class))) {
                            logger.debug(java.lang.String.format("Not copying annotation from field [%s]", field.getName()));
                        }else {
                            logger.debug(java.lang.String.format("Copying annotation from field [%s]", field.getName()));
                            javassist.bytecode.ConstPool constPool = clazz.getClassFile().getConstPool();
                            javassist.CtField fieldFromMainClass = clazz.getField(field.getName());
                            for (java.lang.Object o : field.getFieldInfo().getAttributes()) {
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1976, (o instanceof javassist.bytecode.AnnotationsAttribute))) {
                                    javassist.bytecode.AnnotationsAttribute templateAnnotations = ((javassist.bytecode.AnnotationsAttribute) (o));
                                    javassist.bytecode.AnnotationsAttribute copied = ((javassist.bytecode.AnnotationsAttribute) (templateAnnotations.copy(constPool, null)));
                                    for (java.lang.Object attribute : fieldFromMainClass.getFieldInfo().getAttributes()) {
                                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1977, (attribute instanceof javassist.bytecode.AnnotationsAttribute))) {
                                            for (javassist.bytecode.annotation.Annotation annotation : copied.getAnnotations()) {
                                                ((javassist.bytecode.AnnotationsAttribute) (attribute)).addAnnotation(annotation);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                logger.lifecycle(org.broadleafcommerce.common.logging.LifeCycleEvent.END, java.lang.String.format("Transform - Copying annotations into [%s] from [%s]", xformKey, org.apache.commons.lang.StringUtils.join(xformVals, ",")));
                return clazz.toBytecode();
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException("Unable to transform class", e);
            } finally {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1978, (clazz != null))) {
                    clazz.detach();
                }
            }
        }
        return null;
    }

    protected java.lang.String getImplementationType(java.lang.String className) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1979, className.equals("java.util.List"))) {
            return "java.util.ArrayList";
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1980, className.equals("java.util.Map"))) {
                return "java.util.HashMap";
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1981, className.equals("java.util.Set"))) {
                    return "java.util.HashSet";
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1982, className.contains("["))) {
                        return null;
                    }



        return className;
    }

    protected java.lang.String methodDescription(javassist.CtMethod method) {
        return ((((method.getDeclaringClass().getName()) + "|") + (method.getName())) + "|") + (method.getSignature());
    }

    public java.util.Map<java.lang.String, java.lang.String> getXformTemplates() {
        return xformTemplates;
    }

    public void setXformTemplates(java.util.Map<java.lang.String, java.lang.String> xformTemplates) {
        this.xformTemplates = xformTemplates;
    }

    public static perturbation.location.PerturbationLocation __L1972;

    public static perturbation.location.PerturbationLocation __L1973;

    public static perturbation.location.PerturbationLocation __L1974;

    public static perturbation.location.PerturbationLocation __L1975;

    public static perturbation.location.PerturbationLocation __L1976;

    public static perturbation.location.PerturbationLocation __L1977;

    public static perturbation.location.PerturbationLocation __L1978;

    public static perturbation.location.PerturbationLocation __L1979;

    public static perturbation.location.PerturbationLocation __L1980;

    public static perturbation.location.PerturbationLocation __L1981;

    public static perturbation.location.PerturbationLocation __L1982;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:74)", 1972, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:79)", 1973, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:88)", 1974, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:101)", 1975, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:111)", 1976, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:118)", 1977, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:136)", 1978, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:155)", 1979, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:157)", 1980, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:159)", 1981, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.__L1982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/AnnotationsCopyClassTransformer.java:161)", 1982, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.copy.AnnotationsCopyClassTransformer.initPerturbationLocation0();
    }
}

