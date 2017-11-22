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


public class ConditionalFieldAnnotationsClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    @javax.annotation.Resource(name = "blConditionalFieldAnnotationsTransformersManager")
    protected org.broadleafcommerce.common.weave.ConditionalFieldAnnotationCopyTransformersManager manager;

    protected org.broadleafcommerce.common.logging.SupportLogger logger;

    protected java.lang.String moduleName;

    public ConditionalFieldAnnotationsClassTransformer(java.lang.String moduleName) {
        this.moduleName = moduleName;
        logger = org.broadleafcommerce.common.logging.SupportLogManager.getLogger(moduleName, this.getClass());
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1983, (className == null))) {
            return null;
        }
        java.lang.String convertedClassName = className.replace('/', '.');
        org.broadleafcommerce.common.weave.ConditionalFieldAnnotationCopyTransformMemberDTO dto = manager.getTransformMember(convertedClassName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1990, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1986, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1984, (dto == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1985, ((dto.getTemplateNames()) == null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1989, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1987, dto.getTemplateNames().length)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1988, 1)))))))) {
            return null;
        }
        javassist.CtClass clazz = null;
        try {
            java.lang.String[] xformVals = dto.getTemplateNames();
            javassist.ClassPool classPool = javassist.ClassPool.getDefault();
            clazz = classPool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1991, false));
            clazz.defrost();
            for (java.lang.String xformVal : xformVals) {
                java.lang.String trimmed = xformVal.trim();
                classPool.appendClassPath(new javassist.LoaderClassPath(java.lang.Class.forName(trimmed).getClassLoader()));
                javassist.CtClass template = classPool.get(trimmed);
                javassist.CtField[] fieldsToCopy = template.getDeclaredFields();
                for (javassist.CtField field : fieldsToCopy) {
                    javassist.bytecode.ConstPool constPool = clazz.getClassFile().getConstPool();
                    javassist.CtField fieldFromMainClass = clazz.getField(field.getName());
                    javassist.bytecode.AnnotationsAttribute copied = null;
                    for (java.lang.Object o : field.getFieldInfo().getAttributes()) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1992, (o instanceof javassist.bytecode.AnnotationsAttribute))) {
                            javassist.bytecode.AnnotationsAttribute templateAnnotations = ((javassist.bytecode.AnnotationsAttribute) (o));
                            copied = ((javassist.bytecode.AnnotationsAttribute) (templateAnnotations.copy(constPool, null)));
                            break;
                        }
                    }
                    for (java.lang.Object attribute : fieldFromMainClass.getFieldInfo().getAttributes()) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1993, (attribute instanceof javassist.bytecode.AnnotationsAttribute))) {
                            javassist.bytecode.annotation.Annotation[] annotations = null;
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1994, (copied != null))) {
                                java.util.ArrayList<javassist.bytecode.annotation.Annotation> annotationsList = new java.util.ArrayList<javassist.bytecode.annotation.Annotation>();
                                for (javassist.bytecode.annotation.Annotation annotation : copied.getAnnotations()) {
                                    annotationsList.add(annotation);
                                }
                                annotations = new javassist.bytecode.annotation.Annotation[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1995, annotationsList.size())];
                                int count = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1996, 0);
                                for (javassist.bytecode.annotation.Annotation annotation : annotationsList) {
                                    annotations[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1997, count)] = annotation;
                                    perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1998, (count++));
                                }
                                ((javassist.bytecode.AnnotationsAttribute) (attribute)).setAnnotations(annotations);
                            }else {
                                ((javassist.bytecode.AnnotationsAttribute) (attribute)).setAnnotations(new javassist.bytecode.annotation.Annotation[]{  });
                            }
                            break;
                        }
                    }
                }
            }
            return clazz.toBytecode();
        } catch (java.lang.ClassCircularityError error) {
            error.printStackTrace();
            throw error;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Unable to transform class", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1999, (clazz != null))) {
                try {
                    clazz.detach();
                } catch (java.lang.Exception e) {
                }
            }
        }
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    public static perturbation.location.PerturbationLocation __L1983;

    public static perturbation.location.PerturbationLocation __L1984;

    public static perturbation.location.PerturbationLocation __L1985;

    public static perturbation.location.PerturbationLocation __L1986;

    public static perturbation.location.PerturbationLocation __L1987;

    public static perturbation.location.PerturbationLocation __L1988;

    public static perturbation.location.PerturbationLocation __L1989;

    public static perturbation.location.PerturbationLocation __L1990;

    public static perturbation.location.PerturbationLocation __L1991;

    public static perturbation.location.PerturbationLocation __L1992;

    public static perturbation.location.PerturbationLocation __L1993;

    public static perturbation.location.PerturbationLocation __L1994;

    public static perturbation.location.PerturbationLocation __L1995;

    public static perturbation.location.PerturbationLocation __L1996;

    public static perturbation.location.PerturbationLocation __L1997;

    public static perturbation.location.PerturbationLocation __L1998;

    public static perturbation.location.PerturbationLocation __L1999;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:83)", 1983, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1984, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1985, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1986, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1987, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1988, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1989, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:90)", 1990, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:102)", 1991, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:122)", 1992, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:132)", 1993, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:135)", 1994, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:142)", 1995, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:143)", 1996, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:145)", 1997, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:146)", 1998, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.__L1999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/ConditionalFieldAnnotationsClassTransformer.java:169)", 1999, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.copy.ConditionalFieldAnnotationsClassTransformer.initPerturbationLocation0();
    }
}

