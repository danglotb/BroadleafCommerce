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


public class QueryConfigurationClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    private static boolean isExecuted = false;

    protected java.util.List<javax.persistence.NamedQuery> namedQueries;

    protected java.util.List<javax.persistence.NamedNativeQuery> nativeQueries;

    protected java.util.List<java.lang.String> managedClassNames;

    public QueryConfigurationClassTransformer(java.util.List<javax.persistence.NamedQuery> namedQueries, java.util.List<javax.persistence.NamedNativeQuery> nativeQueries, java.util.List<java.lang.String> managedClassNames) {
        this.namedQueries = namedQueries;
        this.nativeQueries = nativeQueries;
        this.managedClassNames = managedClassNames;
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2356, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2354, (className == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2355, org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.isExecuted))))) {
            return null;
        }
        java.lang.String convertedClassName = className.replace('/', '.');
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2357, managedClassNames.contains(convertedClassName))) {
            try {
                javassist.bytecode.ClassFile classFile = new javassist.bytecode.ClassFile(new java.io.DataInputStream(new java.io.ByteArrayInputStream(classfileBuffer)));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2358, org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.isExecuted)) {
                    return null;
                }
                javassist.bytecode.ConstPool constantPool = classFile.getConstPool();
                javassist.ClassPool pool = javassist.ClassPool.getDefault();
                pool.importPackage("javax.persistence");
                pool.importPackage("java.lang");
                java.util.List<?> attributes = classFile.getAttributes();
                java.util.Iterator<?> itr = attributes.iterator();
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2359, itr.hasNext())) {
                    java.lang.Object object = itr.next();
                    processClassLevelAnnotations(constantPool, pool, object);
                } 
                java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                java.io.DataOutputStream os = new java.io.DataOutputStream(bos);
                classFile.write(os);
                os.close();
                org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.isExecuted = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2360, true);
                return bos.toByteArray();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                throw new java.lang.instrument.IllegalClassFormatException(((("Unable to convert " + convertedClassName) + " to a SingleTable inheritance strategy: ") + (e.getMessage())));
            }
        }else {
            return null;
        }
    }

    protected void processClassLevelAnnotations(javassist.bytecode.ConstPool constantPool, javassist.ClassPool pool, java.lang.Object object) throws javassist.NotFoundException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2361, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
            javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
            javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
            java.util.List<javassist.bytecode.annotation.Annotation> newItems = new java.util.ArrayList<javassist.bytecode.annotation.Annotation>();
            javassist.bytecode.annotation.ArrayMemberValue namedQueryArray = new javassist.bytecode.annotation.ArrayMemberValue(constantPool);
            javassist.bytecode.annotation.ArrayMemberValue nativeQueryArray = new javassist.bytecode.annotation.ArrayMemberValue(constantPool);
            for (javassist.bytecode.annotation.Annotation annotation : items) {
                java.lang.String typeName = annotation.getTypeName();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2362, typeName.equals(javax.persistence.NamedQueries.class.getName()))) {
                    namedQueryArray = ((javassist.bytecode.annotation.ArrayMemberValue) (annotation.getMemberValue("value")));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2363, typeName.equals(javax.persistence.NamedNativeQueries.class.getName()))) {
                        nativeQueryArray = ((javassist.bytecode.annotation.ArrayMemberValue) (annotation.getMemberValue("value")));
                    }else {
                        newItems.add(annotation);
                    }

            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2365, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2364, namedQueries.isEmpty()))))) {
                prepareNamedQueries(constantPool, pool, namedQueryArray);
                javassist.bytecode.annotation.Annotation namedQueriesAnnotation = new javassist.bytecode.annotation.Annotation(javax.persistence.NamedQueries.class.getName(), constantPool);
                namedQueriesAnnotation.addMemberValue("value", namedQueryArray);
                newItems.add(namedQueriesAnnotation);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2367, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2366, nativeQueries.isEmpty()))))) {
                prepareNativeQueries(constantPool, pool, nativeQueryArray);
                javassist.bytecode.annotation.Annotation nativeQueriesAnnotation = new javassist.bytecode.annotation.Annotation(javax.persistence.NamedQueries.class.getName(), constantPool);
                nativeQueriesAnnotation.addMemberValue("value", nativeQueryArray);
                newItems.add(nativeQueriesAnnotation);
            }
            attr.setAnnotations(newItems.toArray(new javassist.bytecode.annotation.Annotation[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2368, newItems.size())]));
        }
    }

    protected void prepareNativeQueries(javassist.bytecode.ConstPool constantPool, javassist.ClassPool pool, javassist.bytecode.annotation.ArrayMemberValue queryArray) throws javassist.NotFoundException {
        java.util.List<javassist.bytecode.annotation.MemberValue> values;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2369, ((queryArray.getValue()) != null))) {
            values = new java.util.ArrayList<javassist.bytecode.annotation.MemberValue>(java.util.Arrays.asList(queryArray.getValue()));
        }else {
            values = new java.util.ArrayList<javassist.bytecode.annotation.MemberValue>();
        }
        for (javax.persistence.NamedNativeQuery query : nativeQueries) {
            javassist.bytecode.annotation.Annotation namedQuery = new javassist.bytecode.annotation.Annotation(javax.persistence.NamedNativeQuery.class.getName(), constantPool);
            javassist.bytecode.annotation.StringMemberValue name = new javassist.bytecode.annotation.StringMemberValue(constantPool);
            name.setValue(query.name());
            namedQuery.addMemberValue("name", name);
            javassist.bytecode.annotation.StringMemberValue queryString = new javassist.bytecode.annotation.StringMemberValue(constantPool);
            queryString.setValue(query.query());
            namedQuery.addMemberValue("query", queryString);
            javassist.bytecode.annotation.ClassMemberValue resultClass = new javassist.bytecode.annotation.ClassMemberValue(constantPool);
            resultClass.setValue(query.resultClass().getName());
            namedQuery.addMemberValue("resultClass", resultClass);
            javassist.bytecode.annotation.StringMemberValue resultSetMapping = new javassist.bytecode.annotation.StringMemberValue(constantPool);
            resultSetMapping.setValue(query.resultSetMapping());
            namedQuery.addMemberValue("resultSetMapping", resultSetMapping);
            java.util.List<javassist.bytecode.annotation.AnnotationMemberValue> queryHints = new java.util.ArrayList<javassist.bytecode.annotation.AnnotationMemberValue>();
            for (javax.persistence.QueryHint hint : query.hints()) {
                prepareQueryHints(constantPool, queryHints, hint);
            }
            javassist.bytecode.annotation.ArrayMemberValue hintArray = new javassist.bytecode.annotation.ArrayMemberValue(constantPool);
            hintArray.setValue(queryHints.toArray(new javassist.bytecode.annotation.AnnotationMemberValue[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2370, queryHints.size())]));
            namedQuery.addMemberValue("hints", hintArray);
            javassist.bytecode.annotation.AnnotationMemberValue queryAnnotation = new javassist.bytecode.annotation.AnnotationMemberValue(namedQuery, constantPool);
            values.add(queryAnnotation);
        }
        queryArray.setValue(values.toArray(new javassist.bytecode.annotation.MemberValue[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2371, values.size())]));
    }

    protected void prepareNamedQueries(javassist.bytecode.ConstPool constantPool, javassist.ClassPool pool, javassist.bytecode.annotation.ArrayMemberValue queryArray) throws javassist.NotFoundException {
        java.util.List<javassist.bytecode.annotation.MemberValue> values;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2372, ((queryArray.getValue()) != null))) {
            values = new java.util.ArrayList<javassist.bytecode.annotation.MemberValue>(java.util.Arrays.asList(queryArray.getValue()));
        }else {
            values = new java.util.ArrayList<javassist.bytecode.annotation.MemberValue>();
        }
        for (javax.persistence.NamedQuery query : namedQueries) {
            javassist.bytecode.annotation.Annotation namedQuery = new javassist.bytecode.annotation.Annotation(javax.persistence.NamedQuery.class.getName(), constantPool);
            javassist.bytecode.annotation.StringMemberValue name = new javassist.bytecode.annotation.StringMemberValue(constantPool);
            name.setValue(query.name());
            namedQuery.addMemberValue("name", name);
            javassist.bytecode.annotation.StringMemberValue queryString = new javassist.bytecode.annotation.StringMemberValue(constantPool);
            queryString.setValue(query.query());
            namedQuery.addMemberValue("query", queryString);
            javassist.bytecode.annotation.EnumMemberValue lockMode = ((javassist.bytecode.annotation.EnumMemberValue) (javassist.bytecode.annotation.Annotation.createMemberValue(constantPool, pool.makeClass("LockModeType"))));
            lockMode.setType(javax.persistence.LockModeType.class.getName());
            lockMode.setValue(query.lockMode().toString());
            namedQuery.addMemberValue("lockMode", lockMode);
            java.util.List<javassist.bytecode.annotation.AnnotationMemberValue> queryHints = new java.util.ArrayList<javassist.bytecode.annotation.AnnotationMemberValue>();
            for (javax.persistence.QueryHint hint : query.hints()) {
                prepareQueryHints(constantPool, queryHints, hint);
            }
            javassist.bytecode.annotation.ArrayMemberValue hintArray = new javassist.bytecode.annotation.ArrayMemberValue(constantPool);
            hintArray.setValue(queryHints.toArray(new javassist.bytecode.annotation.AnnotationMemberValue[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2373, queryHints.size())]));
            namedQuery.addMemberValue("hints", hintArray);
            javassist.bytecode.annotation.AnnotationMemberValue queryAnnotation = new javassist.bytecode.annotation.AnnotationMemberValue(namedQuery, constantPool);
            values.add(queryAnnotation);
        }
        queryArray.setValue(values.toArray(new javassist.bytecode.annotation.MemberValue[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2374, values.size())]));
    }

    protected void prepareQueryHints(javassist.bytecode.ConstPool constantPool, java.util.List<javassist.bytecode.annotation.AnnotationMemberValue> queryHints, javax.persistence.QueryHint hint) {
        javassist.bytecode.annotation.Annotation queryHint = new javassist.bytecode.annotation.Annotation(javax.persistence.QueryHint.class.getName(), constantPool);
        javassist.bytecode.annotation.StringMemberValue hintName = new javassist.bytecode.annotation.StringMemberValue(constantPool);
        hintName.setValue(hint.name());
        queryHint.addMemberValue("name", hintName);
        javassist.bytecode.annotation.StringMemberValue hintValue = new javassist.bytecode.annotation.StringMemberValue(constantPool);
        hintValue.setValue(hint.value());
        queryHint.addMemberValue("value", hintValue);
        javassist.bytecode.annotation.AnnotationMemberValue hintAnnotation = new javassist.bytecode.annotation.AnnotationMemberValue(queryHint, constantPool);
        queryHints.add(hintAnnotation);
    }

    public static perturbation.location.PerturbationLocation __L2354;

    public static perturbation.location.PerturbationLocation __L2355;

    public static perturbation.location.PerturbationLocation __L2356;

    public static perturbation.location.PerturbationLocation __L2357;

    public static perturbation.location.PerturbationLocation __L2358;

    public static perturbation.location.PerturbationLocation __L2359;

    public static perturbation.location.PerturbationLocation __L2360;

    public static perturbation.location.PerturbationLocation __L2361;

    public static perturbation.location.PerturbationLocation __L2362;

    public static perturbation.location.PerturbationLocation __L2363;

    public static perturbation.location.PerturbationLocation __L2364;

    public static perturbation.location.PerturbationLocation __L2365;

    public static perturbation.location.PerturbationLocation __L2366;

    public static perturbation.location.PerturbationLocation __L2367;

    public static perturbation.location.PerturbationLocation __L2368;

    public static perturbation.location.PerturbationLocation __L2369;

    public static perturbation.location.PerturbationLocation __L2370;

    public static perturbation.location.PerturbationLocation __L2371;

    public static perturbation.location.PerturbationLocation __L2372;

    public static perturbation.location.PerturbationLocation __L2373;

    public static perturbation.location.PerturbationLocation __L2374;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:85)", 2354, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:85)", 2355, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2356 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:85)", 2356, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:89)", 2357, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2358 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:92)", 2358, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2359 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:101)", 2359, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2360 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:111)", 2360, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2361 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:133)", 2361, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:141)", 2362, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2363 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:143)", 2363, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2364 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:150)", 2364, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2365 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:150)", 2365, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2366 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:158)", 2366, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2367 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:158)", 2367, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2368 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:166)", 2368, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2369 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:180)", 2369, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2370 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:210)", 2370, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2371 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:217)", 2371, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2372 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:230)", 2372, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2373 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:257)", 2373, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.__L2374 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/QueryConfigurationClassTransformer.java:264)", 2374, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.QueryConfigurationClassTransformer.initPerturbationLocation0();
    }
}

