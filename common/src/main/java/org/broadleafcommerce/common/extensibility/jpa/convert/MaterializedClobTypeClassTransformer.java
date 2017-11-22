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


public class MaterializedClobTypeClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    @javax.annotation.Resource(name = "blDirectCopyIgnorePatterns")
    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> ignorePatterns = new java.util.ArrayList<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern>();

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties properties, java.lang.Object o) throws java.lang.Exception {
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1928, (className == null))) {
            return null;
        }
        java.lang.String convertedClassName = className.replace('/', '.');
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1929, isIgnored(convertedClassName))) {
            return null;
        }
        try {
            boolean transformed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1930, false);
            javassist.bytecode.ClassFile classFile = new javassist.bytecode.ClassFile(new java.io.DataInputStream(new java.io.ByteArrayInputStream(classfileBuffer)));
            boolean containsTypeLevelAnnotation = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1931, false);
            {
                java.util.List<?> attributes = classFile.getAttributes();
                java.util.Iterator<?> itr = attributes.iterator();
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1932, itr.hasNext())) {
                    java.lang.Object object = itr.next();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1933, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                        containsTypeLevelAnnotation = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1934, containsTypeLevelPersistenceAnnotation(((javassist.bytecode.AnnotationsAttribute) (object)).getAnnotations()));
                    }
                } 
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1935, containsTypeLevelAnnotation)) {
                java.util.List<javassist.bytecode.FieldInfo> fieldInfos = classFile.getFields();
                javassist.bytecode.ConstPool constantPool = classFile.getConstPool();
                for (javassist.bytecode.FieldInfo myField : fieldInfos) {
                    java.util.List<?> attributes = myField.getAttributes();
                    java.util.Iterator<?> itr = attributes.iterator();
                    javassist.bytecode.AnnotationsAttribute annotationsAttribute = new javassist.bytecode.AnnotationsAttribute(constantPool, javassist.bytecode.AnnotationsAttribute.visibleTag);
                    while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1936, itr.hasNext())) {
                        java.lang.Object object = itr.next();
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1937, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                            javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                            javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                            for (javassist.bytecode.annotation.Annotation annotation : items) {
                                java.lang.String typeName = annotation.getTypeName();
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1938, typeName.equals(org.hibernate.annotations.Type.class.getName()))) {
                                    javassist.bytecode.annotation.StringMemberValue annot = ((javassist.bytecode.annotation.StringMemberValue) (annotation.getMemberValue("type")));
                                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1941, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1939, (annot != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1940, annot.getValue().equals(org.hibernate.type.StringClobType.class.getName())))))) {
                                        javassist.bytecode.annotation.Annotation clobType = new javassist.bytecode.annotation.Annotation(org.hibernate.annotations.Type.class.getName(), constantPool);
                                        javassist.bytecode.annotation.StringMemberValue type = new javassist.bytecode.annotation.StringMemberValue(constantPool);
                                        type.setValue(org.hibernate.type.MaterializedClobType.class.getName());
                                        clobType.addMemberValue("type", type);
                                        annotationsAttribute.addAnnotation(clobType);
                                        transformed = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1942, true);
                                    }else {
                                        annotationsAttribute.addAnnotation(annotation);
                                    }
                                }else {
                                    annotationsAttribute.addAnnotation(annotation);
                                }
                            }
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1943, transformed)) {
                                itr.remove();
                            }
                        }
                    } 
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1944, transformed)) {
                        myField.addAttribute(annotationsAttribute);
                    }
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1945, transformed)) {
                java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                java.io.DataOutputStream os = new java.io.DataOutputStream(bos);
                classFile.write(os);
                os.close();
                return bos.toByteArray();
            }else {
                return null;
            }
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new java.lang.instrument.IllegalClassFormatException(((("Unable to convert " + convertedClassName) + " to sandbox: ") + (ex.getMessage())));
        }
    }

    protected boolean isIgnored(java.lang.String convertedClassName) {
        boolean isValidPattern = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1946, true);
        java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> matchedPatterns = new java.util.ArrayList<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern>();
        for (org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern pattern : ignorePatterns) {
            boolean isPatternMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1947, false);
            for (java.lang.String patternString : pattern.getPatterns()) {
                isPatternMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1948, convertedClassName.matches(patternString));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1949, isPatternMatch)) {
                    break;
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1950, isPatternMatch)) {
                matchedPatterns.add(pattern);
            }
            isValidPattern = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1954, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1953, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1951, isPatternMatch)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1952, ((pattern.getTemplateTokenPatterns()) == null))))))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1956, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1955, isValidPattern))))) {
                break;
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1958, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1957, isValidPattern))));
    }

    protected boolean containsTypeLevelPersistenceAnnotation(javassist.bytecode.annotation.Annotation[] annotations) {
        for (javassist.bytecode.annotation.Annotation annotation : annotations) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1963, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1961, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1959, annotation.getTypeName().equals(javax.persistence.Entity.class.getName()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1960, annotation.getTypeName().equals(javax.persistence.Embeddable.class.getName())))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1962, annotation.getTypeName().equals(javax.persistence.MappedSuperclass.class.getName())))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1964, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1965, false);
    }

    public static perturbation.location.PerturbationLocation __L1928;

    public static perturbation.location.PerturbationLocation __L1929;

    public static perturbation.location.PerturbationLocation __L1930;

    public static perturbation.location.PerturbationLocation __L1931;

    public static perturbation.location.PerturbationLocation __L1932;

    public static perturbation.location.PerturbationLocation __L1933;

    public static perturbation.location.PerturbationLocation __L1934;

    public static perturbation.location.PerturbationLocation __L1935;

    public static perturbation.location.PerturbationLocation __L1936;

    public static perturbation.location.PerturbationLocation __L1937;

    public static perturbation.location.PerturbationLocation __L1938;

    public static perturbation.location.PerturbationLocation __L1939;

    public static perturbation.location.PerturbationLocation __L1940;

    public static perturbation.location.PerturbationLocation __L1941;

    public static perturbation.location.PerturbationLocation __L1942;

    public static perturbation.location.PerturbationLocation __L1943;

    public static perturbation.location.PerturbationLocation __L1944;

    public static perturbation.location.PerturbationLocation __L1945;

    public static perturbation.location.PerturbationLocation __L1946;

    public static perturbation.location.PerturbationLocation __L1947;

    public static perturbation.location.PerturbationLocation __L1948;

    public static perturbation.location.PerturbationLocation __L1949;

    public static perturbation.location.PerturbationLocation __L1950;

    public static perturbation.location.PerturbationLocation __L1951;

    public static perturbation.location.PerturbationLocation __L1952;

    public static perturbation.location.PerturbationLocation __L1953;

    public static perturbation.location.PerturbationLocation __L1954;

    public static perturbation.location.PerturbationLocation __L1955;

    public static perturbation.location.PerturbationLocation __L1956;

    public static perturbation.location.PerturbationLocation __L1957;

    public static perturbation.location.PerturbationLocation __L1958;

    public static perturbation.location.PerturbationLocation __L1959;

    public static perturbation.location.PerturbationLocation __L1960;

    public static perturbation.location.PerturbationLocation __L1961;

    public static perturbation.location.PerturbationLocation __L1962;

    public static perturbation.location.PerturbationLocation __L1963;

    public static perturbation.location.PerturbationLocation __L1964;

    public static perturbation.location.PerturbationLocation __L1965;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:87)", 1928, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:91)", 1929, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:95)", 1930, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:97)", 1931, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:101)", 1932, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:103)", 1933, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:104)", 1934, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:108)", 1935, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:115)", 1936, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:117)", 1937, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:122)", 1938, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:124)", 1939, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:124)", 1940, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:124)", 1941, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:130)", 1942, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:138)", 1943, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:143)", 1944, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:149)", 1945, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:166)", 1946, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:169)", 1947, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:171)", 1948, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:172)", 1949, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:176)", 1950, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:179)", 1951, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:179)", 1952, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:179)", 1953, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:179)", 1954, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:180)", 1955, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:180)", 1956, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:185)", 1957, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:185)", 1958, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:190)", 1959, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:191)", 1960, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:190)", 1961, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:192)", 1962, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:190)", 1963, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:193)", 1964, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.__L1965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/MaterializedClobTypeClassTransformer.java:196)", 1965, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.convert.MaterializedClobTypeClassTransformer.initPerturbationLocation0();
    }
}

