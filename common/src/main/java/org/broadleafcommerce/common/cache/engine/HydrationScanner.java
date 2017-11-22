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
package org.broadleafcommerce.common.cache.engine;


public class HydrationScanner implements org.objectweb.asm.AnnotationVisitor , org.objectweb.asm.ClassVisitor , org.objectweb.asm.FieldVisitor {
    private static final int CLASSSTAGE = 0;

    private static final int FIELDSTAGE = 1;

    private java.lang.String cacheRegion;

    private java.util.Map<java.lang.String, java.lang.reflect.Method[]> idMutators = new java.util.HashMap<java.lang.String, java.lang.reflect.Method[]>();

    private java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor> cacheMutators = new java.util.HashMap<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor>();

    @java.lang.SuppressWarnings("unchecked")
    private final java.lang.Class entityClass;

    @java.lang.SuppressWarnings("unchecked")
    private final java.lang.Class topEntityClass;

    private int stage = org.broadleafcommerce.common.cache.engine.HydrationScanner.CLASSSTAGE;

    @java.lang.SuppressWarnings("unchecked")
    private java.lang.Class clazz;

    private java.lang.String annotation;

    private java.lang.String fieldName;

    @java.lang.SuppressWarnings("unchecked")
    private java.lang.Class fieldClass;

    @java.lang.SuppressWarnings("unchecked")
    public HydrationScanner(java.lang.Class topEntityClass, java.lang.Class entityClass) {
        this.topEntityClass = topEntityClass;
        this.entityClass = entityClass;
    }

    public void init() {
        try {
            java.io.InputStream in = org.broadleafcommerce.common.cache.engine.HydrationScanner.class.getClassLoader().getResourceAsStream(((topEntityClass.getName().replace('.', '/')) + ".class"));
            new org.objectweb.asm.ClassReader(in).accept(this, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L175, org.objectweb.asm.ClassReader.SKIP_DEBUG));
            in = org.broadleafcommerce.common.cache.engine.HydrationScanner.class.getClassLoader().getResourceAsStream(((entityClass.getName().replace('.', '/')) + ".class"));
            new org.objectweb.asm.ClassReader(in).accept(this, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L176, org.objectweb.asm.ClassReader.SKIP_DEBUG));
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public java.lang.String getCacheRegion() {
        return cacheRegion;
    }

    public java.util.Map<java.lang.String, java.lang.reflect.Method[]> getIdMutators() {
        return idMutators;
    }

    public java.util.Map<java.lang.String, org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor> getCacheMutators() {
        return cacheMutators;
    }

    public org.objectweb.asm.AnnotationVisitor visitAnnotation(java.lang.String arg0, boolean arg1) {
        org.objectweb.asm.Type annotationType = org.objectweb.asm.Type.getType(arg0);
        switch (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L177, stage)) {
            case org.broadleafcommerce.common.cache.engine.HydrationScanner.CLASSSTAGE :
                {
                    if (annotationType.getClassName().equals(org.hibernate.annotations.Cache.class.getName())) {
                        annotation = org.hibernate.annotations.Cache.class.getName();
                    }
                    break;
                }
            case org.broadleafcommerce.common.cache.engine.HydrationScanner.FIELDSTAGE :
                {
                    if (annotationType.getClassName().equals(javax.persistence.Id.class.getName())) {
                        idMutators.put(fieldName, retrieveMutators());
                    }
                    if (annotationType.getClassName().equals(org.broadleafcommerce.common.cache.Hydrated.class.getName())) {
                        annotation = org.broadleafcommerce.common.cache.Hydrated.class.getName();
                    }
                    break;
                }
            default :
                {
                    annotation = null;
                    fieldName = null;
                    break;
                }
        }
        return this;
    }

    private java.lang.reflect.Method[] retrieveMutators() {
        java.lang.String mutatorName = (fieldName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L178, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L179, 1)).toUpperCase()) + (fieldName.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L180, 1), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L181, fieldName.length())));
        java.lang.reflect.Method getMethod = null;
        try {
            getMethod = clazz.getMethod(("get" + mutatorName), new java.lang.Class[]{  });
        } catch (java.lang.Exception e) {
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L182, (getMethod == null))) {
            try {
                getMethod = clazz.getMethod(("is" + mutatorName), new java.lang.Class[]{  });
            } catch (java.lang.Exception e) {
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L183, (getMethod == null))) {
            try {
                getMethod = clazz.getMethod(fieldName, new java.lang.Class[]{  });
            } catch (java.lang.Exception e) {
            }
        }
        java.lang.reflect.Method setMethod = null;
        try {
            setMethod = clazz.getMethod(("set" + mutatorName), new java.lang.Class[]{ fieldClass });
        } catch (java.lang.Exception e) {
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L186, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L184, (getMethod == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L185, (setMethod == null)))))) {
            throw new java.lang.RuntimeException((((((((((("Unable to find a getter and setter method for the AdminPresentation field: " + (fieldName)) + ". Make sure you have a getter method entitled: get") + mutatorName) + "(), or is") + mutatorName) + "(), or ") + (fieldName)) + "(). Make sure you have a setter method entitled: set") + mutatorName) + "(..)."));
        }
        return new java.lang.reflect.Method[]{ getMethod, setMethod };
    }

    public void visitAttribute(org.objectweb.asm.Attribute arg0) {
    }

    public void visitEnd() {
    }

    public void visit(int arg0, int arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String[] arg5) {
        try {
            clazz = java.lang.Class.forName(arg2.replaceAll("/", "."));
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        }
        stage = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L187, org.broadleafcommerce.common.cache.engine.HydrationScanner.CLASSSTAGE);
    }

    public org.objectweb.asm.FieldVisitor visitField(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.Object arg4) {
        stage = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L188, org.broadleafcommerce.common.cache.engine.HydrationScanner.FIELDSTAGE);
        fieldName = arg1;
        org.objectweb.asm.Type fieldType = org.objectweb.asm.Type.getType(arg2);
        switch (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L189, fieldType.getSort())) {
            case org.objectweb.asm.Type.BOOLEAN :
                fieldClass = boolean.class;
                break;
            case org.objectweb.asm.Type.BYTE :
                fieldClass = byte.class;
                break;
            case org.objectweb.asm.Type.CHAR :
                fieldClass = char.class;
                break;
            case org.objectweb.asm.Type.DOUBLE :
                fieldClass = double.class;
                break;
            case org.objectweb.asm.Type.FLOAT :
                fieldClass = float.class;
                break;
            case org.objectweb.asm.Type.INT :
                fieldClass = int.class;
                break;
            case org.objectweb.asm.Type.LONG :
                fieldClass = long.class;
                break;
            case org.objectweb.asm.Type.SHORT :
                fieldClass = short.class;
                break;
            case org.objectweb.asm.Type.OBJECT :
                try {
                    fieldClass = java.lang.Class.forName(org.objectweb.asm.Type.getType(arg2).getClassName());
                } catch (java.lang.ClassNotFoundException e) {
                    throw new java.lang.RuntimeException(e);
                }
                break;
        }
        return this;
    }

    public void visitInnerClass(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3) {
    }

    public org.objectweb.asm.MethodVisitor visitMethod(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String[] arg4) {
        return new org.objectweb.asm.commons.EmptyVisitor();
    }

    public void visitOuterClass(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
    }

    public void visitSource(java.lang.String arg0, java.lang.String arg1) {
    }

    public void visit(java.lang.String arg0, java.lang.Object arg1) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L192, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L190, org.hibernate.annotations.Cache.class.getName().equals(annotation))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L191, "region".equals(arg0)))))) {
            cacheRegion = ((java.lang.String) (arg1));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L195, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L193, org.broadleafcommerce.common.cache.Hydrated.class.getName().equals(annotation))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.cache.engine.HydrationScanner.__L194, "factoryMethod".equals(arg0)))))) {
            org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor itemDescriptor = new org.broadleafcommerce.common.cache.engine.HydrationItemDescriptor();
            itemDescriptor.setFactoryMethod(((java.lang.String) (arg1)));
            itemDescriptor.setMutators(retrieveMutators());
            cacheMutators.put(fieldName, itemDescriptor);
        }
    }

    public org.objectweb.asm.AnnotationVisitor visitAnnotation(java.lang.String arg0, java.lang.String arg1) {
        return this;
    }

    public org.objectweb.asm.AnnotationVisitor visitArray(java.lang.String arg0) {
        return this;
    }

    public void visitEnum(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
    }

    public static perturbation.location.PerturbationLocation __L175;

    public static perturbation.location.PerturbationLocation __L176;

    public static perturbation.location.PerturbationLocation __L177;

    public static perturbation.location.PerturbationLocation __L178;

    public static perturbation.location.PerturbationLocation __L179;

    public static perturbation.location.PerturbationLocation __L180;

    public static perturbation.location.PerturbationLocation __L181;

    public static perturbation.location.PerturbationLocation __L182;

    public static perturbation.location.PerturbationLocation __L183;

    public static perturbation.location.PerturbationLocation __L184;

    public static perturbation.location.PerturbationLocation __L185;

    public static perturbation.location.PerturbationLocation __L186;

    public static perturbation.location.PerturbationLocation __L187;

    public static perturbation.location.PerturbationLocation __L188;

    public static perturbation.location.PerturbationLocation __L189;

    public static perturbation.location.PerturbationLocation __L190;

    public static perturbation.location.PerturbationLocation __L191;

    public static perturbation.location.PerturbationLocation __L192;

    public static perturbation.location.PerturbationLocation __L193;

    public static perturbation.location.PerturbationLocation __L194;

    public static perturbation.location.PerturbationLocation __L195;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L175 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:73)", 175, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L176 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:75)", 176, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L177 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:96)", 177, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L178 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:122)", 178, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L179 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:122)", 179, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L180 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:122)", 180, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L181 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:122)", 181, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:129)", 182, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:136)", 183, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:149)", 184, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:149)", 185, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:149)", 186, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:171)", 187, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:175)", 188, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:178)", 189, "Numerical");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:232)", 190, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:232)", 191, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:232)", 192, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:235)", 193, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:235)", 194, "Boolean");
        org.broadleafcommerce.common.cache.engine.HydrationScanner.__L195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/cache/engine/HydrationScanner.java:235)", 195, "Boolean");
    }

    static {
        org.broadleafcommerce.common.cache.engine.HydrationScanner.initPerturbationLocation0();
    }
}

