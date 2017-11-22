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


public class EntityMarkerClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.class);

    protected java.util.HashSet<java.lang.String> transformedEntityClassNames = new java.util.HashSet<java.lang.String>();

    protected java.util.HashSet<java.lang.String> transformedNonEntityClassNames = new java.util.HashSet<java.lang.String>();

    @javax.annotation.Resource(name = "blDirectCopyIgnorePatterns")
    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> ignorePatterns = new java.util.ArrayList<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern>();

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1902, (className == null))) {
            return null;
        }
        java.lang.String convertedClassName = className.replace('/', '.');
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1903, isIgnored(convertedClassName))) {
            return null;
        }
        try {
            javassist.bytecode.ClassFile classFile = new javassist.bytecode.ClassFile(new java.io.DataInputStream(new java.io.ByteArrayInputStream(classfileBuffer)));
            java.util.List<?> attributes = classFile.getAttributes();
            java.util.Iterator<?> itr = attributes.iterator();
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1904, itr.hasNext())) {
                java.lang.Object object = itr.next();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1905, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                    boolean containsTypeLevelAnnotation = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1906, containsTypeLevelPersistenceAnnotation(((javassist.bytecode.AnnotationsAttribute) (object)).getAnnotations()));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1907, containsTypeLevelAnnotation)) {
                        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.LOG.debug((("Marking " + convertedClassName) + " as transformed"));
                        transformedEntityClassNames.add(convertedClassName);
                    }else {
                        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.LOG.debug((("Marking " + convertedClassName) + " as picked up by the transformer but not detected as an entity"));
                        transformedNonEntityClassNames.add(convertedClassName);
                    }
                }
            } 
        } catch (java.lang.Exception e) {
            org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.LOG.error(e);
            throw new java.lang.instrument.IllegalClassFormatException((("Unable to mark " + convertedClassName) + " as transformed."));
        }
        return null;
    }

    protected boolean containsTypeLevelPersistenceAnnotation(javassist.bytecode.annotation.Annotation[] annotations) {
        for (javassist.bytecode.annotation.Annotation annotation : annotations) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1912, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1910, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1908, annotation.getTypeName().equals(javax.persistence.Entity.class.getName()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1909, annotation.getTypeName().equals(javax.persistence.Embeddable.class.getName())))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1911, annotation.getTypeName().equals(javax.persistence.MappedSuperclass.class.getName())))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1913, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1914, false);
    }

    protected boolean isIgnored(java.lang.String convertedClassName) {
        boolean isValidPattern = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1915, true);
        java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> matchedPatterns = new java.util.ArrayList<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern>();
        for (org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern pattern : ignorePatterns) {
            boolean isPatternMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1916, false);
            for (java.lang.String patternString : pattern.getPatterns()) {
                isPatternMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1917, convertedClassName.matches(patternString));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1918, isPatternMatch)) {
                    break;
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1919, isPatternMatch)) {
                matchedPatterns.add(pattern);
            }
            isValidPattern = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1923, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1922, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1920, isPatternMatch)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1921, ((pattern.getTemplateTokenPatterns()) == null))))))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1925, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1924, isValidPattern))))) {
                break;
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1927, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1926, isValidPattern))));
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    public java.util.HashSet<java.lang.String> getTransformedEntityClassNames() {
        return transformedEntityClassNames;
    }

    public java.util.HashSet<java.lang.String> getTransformedNonEntityClassNames() {
        return transformedNonEntityClassNames;
    }

    public java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> getIgnorePatterns() {
        return ignorePatterns;
    }

    public void setIgnorePatterns(java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> ignorePatterns) {
        this.ignorePatterns = ignorePatterns;
    }

    public static perturbation.location.PerturbationLocation __L1902;

    public static perturbation.location.PerturbationLocation __L1903;

    public static perturbation.location.PerturbationLocation __L1904;

    public static perturbation.location.PerturbationLocation __L1905;

    public static perturbation.location.PerturbationLocation __L1906;

    public static perturbation.location.PerturbationLocation __L1907;

    public static perturbation.location.PerturbationLocation __L1908;

    public static perturbation.location.PerturbationLocation __L1909;

    public static perturbation.location.PerturbationLocation __L1910;

    public static perturbation.location.PerturbationLocation __L1911;

    public static perturbation.location.PerturbationLocation __L1912;

    public static perturbation.location.PerturbationLocation __L1913;

    public static perturbation.location.PerturbationLocation __L1914;

    public static perturbation.location.PerturbationLocation __L1915;

    public static perturbation.location.PerturbationLocation __L1916;

    public static perturbation.location.PerturbationLocation __L1917;

    public static perturbation.location.PerturbationLocation __L1918;

    public static perturbation.location.PerturbationLocation __L1919;

    public static perturbation.location.PerturbationLocation __L1920;

    public static perturbation.location.PerturbationLocation __L1921;

    public static perturbation.location.PerturbationLocation __L1922;

    public static perturbation.location.PerturbationLocation __L1923;

    public static perturbation.location.PerturbationLocation __L1924;

    public static perturbation.location.PerturbationLocation __L1925;

    public static perturbation.location.PerturbationLocation __L1926;

    public static perturbation.location.PerturbationLocation __L1927;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:69)", 1902, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:75)", 1903, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:83)", 1904, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:85)", 1905, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:86)", 1906, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:87)", 1907, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:114)", 1908, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:115)", 1909, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:114)", 1910, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:116)", 1911, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:114)", 1912, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:117)", 1913, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:120)", 1914, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:124)", 1915, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:127)", 1916, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:129)", 1917, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:130)", 1918, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:134)", 1919, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:137)", 1920, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:137)", 1921, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:137)", 1922, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:137)", 1923, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:138)", 1924, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:138)", 1925, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:143)", 1926, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.__L1927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/convert/EntityMarkerClassTransformer.java:143)", 1927, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.convert.EntityMarkerClassTransformer.initPerturbationLocation0();
    }
}

