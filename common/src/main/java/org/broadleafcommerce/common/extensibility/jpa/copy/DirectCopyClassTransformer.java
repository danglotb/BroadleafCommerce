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


public class DirectCopyClassTransformer extends org.broadleafcommerce.common.extensibility.jpa.copy.AbstractClassTransformer implements org.broadleafcommerce.common.extensibility.jpa.convert.BroadleafClassTransformer {
    private class XFormParams {
        java.lang.String[] xformVals = null;

        java.lang.Boolean[] xformSkipOverlaps = null;

        java.lang.Boolean[] xformRenameMethodOverlaps = null;

        public java.lang.String[] getXformVals() {
            return xformVals;
        }

        public void setXformVals(java.lang.String[] xformVals) {
            this.xformVals = xformVals;
        }

        public java.lang.Boolean[] getXformSkipOverlaps() {
            return xformSkipOverlaps;
        }

        public void setXformSkipOverlaps(java.lang.Boolean[] xformSkipOverlaps) {
            this.xformSkipOverlaps = xformSkipOverlaps;
        }

        public java.lang.Boolean[] getXformRenameMethodOverlaps() {
            return xformRenameMethodOverlaps;
        }

        public void setXformRenameMethodOverlaps(java.lang.Boolean[] xformRenameMethodOverlaps) {
            this.xformRenameMethodOverlaps = xformRenameMethodOverlaps;
        }

        public boolean isEmpty() {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2004, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2000, ((xformVals) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2003, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2001, xformVals.length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2002, 0)))))));
        }
    }

    protected static java.util.List<java.lang.String> transformedMethods = new java.util.ArrayList<>();

    protected static java.util.List<java.lang.String> annotationTransformedClasses = new java.util.ArrayList<>();

    private static final org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.class);

    protected java.lang.String moduleName;

    protected java.util.Map<java.lang.String, java.lang.String> xformTemplates = new java.util.HashMap<>();

    protected java.lang.Boolean renameMethodOverlaps = ((boolean) (false));

    protected java.lang.String renameMethodPrefix = "__";

    protected java.lang.Boolean skipOverlaps = ((boolean) (true));

    protected java.util.Map<java.lang.String, java.lang.String> templateTokens = new java.util.HashMap<>();

    @javax.annotation.Resource(name = "blDirectCopyIgnorePatterns")
    protected java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> ignorePatterns = new java.util.ArrayList<>();

    @javax.annotation.Resource(name = "blConditionalDirectCopyTransformersManager")
    protected org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformersManager conditionalDirectCopyTransformersManager;

    public DirectCopyClassTransformer(java.lang.String moduleName) {
        this.moduleName = moduleName;
    }

    @java.lang.Override
    public void compileJPAProperties(java.util.Properties props, java.lang.Object key) throws java.lang.Exception {
    }

    @java.lang.Override
    public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2005, (className == null))) {
            return null;
        }
        javassist.CtClass clazz = null;
        try {
            boolean mySkipOverlaps = skipOverlaps;
            boolean myRenameMethodOverlaps = renameMethodOverlaps;
            java.lang.String convertedClassName = className.replace('/', '.');
            javassist.ClassPool classPool = null;
            java.lang.String xformKey = convertedClassName;
            java.util.Set<java.lang.String> buildXFormVals = new java.util.HashSet<>();
            java.lang.Boolean[] xformSkipOverlaps = null;
            java.lang.Boolean[] xformRenameMethodOverlaps = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2007, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2006, xformTemplates.isEmpty()))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2008, xformTemplates.containsKey(xformKey))) {
                    buildXFormVals.addAll(java.util.Arrays.asList(xformTemplates.get(xformKey).split(",")));
                    classPool = javassist.ClassPool.getDefault();
                    clazz = classPool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2009, false));
                }
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2010, org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.annotationTransformedClasses.contains(convertedClassName))) {
                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.warn(((((convertedClassName + " has already been transformed by a previous instance of DirectCopyTransfomer. ") + "Skipping this annotation based transformation. Generally, annotation-based transformation is handled ") + "by bean id blAnnotationDirectCopyClassTransformer with template tokens being added to ") + "blDirectCopyTransformTokenMap via EarlyStageMergeBeanPostProcessor."));
                }
                boolean isValidPattern = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2011, true);
                java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> matchedPatterns = new java.util.ArrayList<>();
                for (org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern pattern : ignorePatterns) {
                    boolean isPatternMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2012, false);
                    for (java.lang.String patternString : pattern.getPatterns()) {
                        isPatternMatch = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2013, convertedClassName.matches(patternString));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2014, isPatternMatch)) {
                            break;
                        }
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2015, isPatternMatch)) {
                        matchedPatterns.add(pattern);
                    }
                    isValidPattern = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2019, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2018, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2016, isPatternMatch)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2017, ((pattern.getTemplateTokenPatterns()) == null))))))));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2021, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2020, isValidPattern))))) {
                        return null;
                    }
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2022, isValidPattern)) {
                    classPool = javassist.ClassPool.getDefault();
                    clazz = classPool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2023, false));
                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams params = reviewDirectCopyTransformAnnotations(clazz, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2024, mySkipOverlaps), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2025, myRenameMethodOverlaps), matchedPatterns);
                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams conditionalParams = reviewConditionalDirectCopyTransforms(convertedClassName, matchedPatterns);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2029, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2026, (conditionalParams != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2028, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2027, conditionalParams.isEmpty())))))))) {
                        params = combineXFormParams(params, conditionalParams);
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2034, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2030, ((params.getXformVals()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2033, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2031, params.getXformVals().length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2032, 0)))))))) {
                        buildXFormVals.addAll(java.util.Arrays.asList(params.getXformVals()));
                    }
                    xformSkipOverlaps = params.getXformSkipOverlaps();
                    xformRenameMethodOverlaps = params.getXformRenameMethodOverlaps();
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2037, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2035, buildXFormVals.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2036, 0))))) {
                java.lang.String[] xformVals = buildXFormVals.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2038, buildXFormVals.size())]);
                org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("[%s] - Transform - Copying into [%s] from [%s]", org.broadleafcommerce.common.logging.LifeCycleEvent.END, xformKey, org.apache.commons.lang3.StringUtils.join(xformVals, ",")));
                clazz.defrost();
                int index = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2039, 0);
                for (java.lang.String xformVal : xformVals) {
                    java.lang.String trimmed = xformVal.trim();
                    classPool.appendClassPath(new javassist.LoaderClassPath(java.lang.Class.forName(trimmed).getClassLoader()));
                    javassist.CtClass template = classPool.get(trimmed);
                    javassist.CtClass[] interfacesToCopy = template.getInterfaces();
                    for (javassist.CtClass i : interfacesToCopy) {
                        checkInterfaces : {
                            javassist.CtClass[] myInterfaces = clazz.getInterfaces();
                            for (javassist.CtClass myInterface : myInterfaces) {
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2040, myInterface.getName().equals(i.getName()))) {
                                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2042, ((xformSkipOverlaps != null) && (xformSkipOverlaps[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2041, index)])))) {
                                        break checkInterfaces;
                                    }else {
                                        throw new java.lang.RuntimeException(("Duplicate interface detected " + (myInterface.getName())));
                                    }
                                }
                            }
                            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Adding interface [%s]", i.getName()));
                            clazz.addInterface(i);
                        }
                    }
                    javassist.bytecode.ClassFile classFile = clazz.getClassFile();
                    javassist.bytecode.ClassFile templateFile = template.getClassFile();
                    javassist.bytecode.ConstPool constantPool = classFile.getConstPool();
                    buildClassLevelAnnotations(classFile, templateFile, constantPool);
                    javassist.CtField[] fieldsToCopy = template.getDeclaredFields();
                    for (javassist.CtField field : fieldsToCopy) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2043, field.hasAnnotation(org.broadleafcommerce.common.extensibility.jpa.copy.NonCopied.class))) {
                            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Not adding field [%s]", field.getName()));
                        }else {
                            try {
                                javassist.CtField ctField = clazz.getDeclaredField(field.getName());
                                java.lang.String originalSignature = ctField.getSignature();
                                java.lang.String mySignature = field.getSignature();
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2045, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2044, originalSignature.equals(mySignature)))))) {
                                    throw new java.lang.IllegalArgumentException((((((((((((("Field with name (" + (field.getName())) + ") and signature ") + "(") + (field.getSignature())) + ") is targeted for weaving into (") + (clazz.getName())) + "). ") + "An incompatible field of the same name and signature of (") + (ctField.getSignature())) + ") ") + "already exists. The field in the target class should be updated to a different name, ") + "or made to have a matching type."));
                                }
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2047, ((xformSkipOverlaps != null) && (xformSkipOverlaps[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2046, index)])))) {
                                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Skipping overlapped field [%s]", field.getName()));
                                    continue;
                                }
                                clazz.removeField(ctField);
                            } catch (javassist.NotFoundException e) {
                            }
                            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Adding field [%s]", field.getName()));
                            javassist.CtField copiedField = new javassist.CtField(field, clazz);
                            boolean defaultConstructorFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2048, false);
                            java.lang.String implClass = getImplementationType(field.getType().getName());
                            try {
                                javassist.CtConstructor[] implConstructors = classPool.get(implClass).getConstructors();
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2049, (implConstructors != null))) {
                                    for (javassist.CtConstructor cons : implConstructors) {
                                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2052, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2050, cons.getParameterTypes().length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2051, 0))))) {
                                            defaultConstructorFound = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2053, true);
                                            break;
                                        }
                                    }
                                }
                            } catch (javassist.NotFoundException e) {
                            }
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2054, defaultConstructorFound)) {
                                clazz.addField(copiedField, (("new " + implClass) + "()"));
                            }else {
                                clazz.addField(copiedField);
                            }
                        }
                    }
                    javassist.CtMethod[] methodsToCopy = template.getDeclaredMethods();
                    for (javassist.CtMethod method : methodsToCopy) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2055, method.hasAnnotation(org.broadleafcommerce.common.extensibility.jpa.copy.NonCopied.class))) {
                            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Not adding method [%s]", method.getName()));
                        }else {
                            try {
                                javassist.CtClass[] paramTypes = method.getParameterTypes();
                                javassist.CtMethod originalMethod = clazz.getDeclaredMethod(method.getName(), paramTypes);
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2057, ((xformSkipOverlaps != null) && (xformSkipOverlaps[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2056, index)])))) {
                                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Skipping overlapped method [%s]", methodDescription(originalMethod)));
                                    continue;
                                }
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2058, org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.transformedMethods.contains(methodDescription(originalMethod)))) {
                                    throw new java.lang.RuntimeException(("Method already replaced " + (methodDescription(originalMethod))));
                                }else {
                                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Marking as replaced [%s]", methodDescription(originalMethod)));
                                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.transformedMethods.add(methodDescription(originalMethod));
                                }
                                org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Removing method [%s]", method.getName()));
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2060, ((xformRenameMethodOverlaps != null) && (xformRenameMethodOverlaps[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2059, index)])))) {
                                    originalMethod.setName(((renameMethodPrefix) + (method.getName())));
                                }else {
                                    clazz.removeMethod(originalMethod);
                                }
                            } catch (javassist.NotFoundException e) {
                            }
                            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("Adding method [%s]", method.getName()));
                            javassist.CtMethod copiedMethod = new javassist.CtMethod(method, clazz, null);
                            clazz.addMethod(copiedMethod);
                        }
                    }
                    perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2061, (index++));
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2062, xformTemplates.isEmpty())) {
                    org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.annotationTransformedClasses.add(convertedClassName);
                }
                org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug(java.lang.String.format("[%s] - Transform - Copying into [%s] from [%s]", org.broadleafcommerce.common.logging.LifeCycleEvent.END, xformKey, org.apache.commons.lang3.StringUtils.join(xformVals, ",")));
                return clazz.toBytecode();
            }
        } catch (java.lang.ClassCircularityError error) {
            error.printStackTrace();
            throw error;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Unable to transform class", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2063, (clazz != null))) {
                try {
                    clazz.detach();
                } catch (java.lang.Exception e) {
                }
            }
        }
        return null;
    }

    protected org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams combineXFormParams(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams defaultParams, org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams conditionalParams) {
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams response = new org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams();
        java.util.Map<java.lang.String, java.lang.Boolean> templateSkipMap = new java.util.LinkedHashMap<>();
        java.util.List<java.lang.String> templates = new java.util.ArrayList<>();
        java.util.List<java.lang.Boolean> skips = new java.util.ArrayList<>();
        java.util.List<java.lang.Boolean> renames = new java.util.ArrayList<>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2065, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2064, defaultParams.isEmpty()))))) {
            for (int iter = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2066, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2069, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2067, iter)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2068, defaultParams.getXformVals().length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2070, (iter++))) {
                java.lang.String defaultParam = defaultParams.getXformVals()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2071, iter)];
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2073, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2072, templateSkipMap.containsKey(defaultParam)))))) {
                    templateSkipMap.put(defaultParam, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2074, true));
                    templates.add(defaultParam);
                    skips.add(defaultParams.getXformSkipOverlaps()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2075, iter)]);
                    renames.add(defaultParams.getXformRenameMethodOverlaps()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2076, iter)]);
                }
            }
        }
        for (int iter = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2077, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2080, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2078, iter)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2079, conditionalParams.getXformVals().length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2081, (iter++))) {
            java.lang.String conditionalValue = conditionalParams.getXformVals()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2082, iter)];
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2084, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2083, templateSkipMap.containsKey(conditionalValue)))))) {
                templates.add(conditionalValue);
                skips.add(conditionalParams.getXformSkipOverlaps()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2085, iter)]);
                renames.add(conditionalParams.getXformRenameMethodOverlaps()[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2086, iter)]);
            }
        }
        response.setXformVals(templates.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2087, templates.size())]));
        response.setXformSkipOverlaps(skips.toArray(new java.lang.Boolean[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2088, skips.size())]));
        response.setXformRenameMethodOverlaps(renames.toArray(new java.lang.Boolean[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2089, renames.size())]));
        return response;
    }

    protected org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams reviewDirectCopyTransformAnnotations(javassist.CtClass clazz, boolean mySkipOverlaps, boolean myRenameMethodOverlaps, java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> matchedPatterns) {
        java.util.List<?> attributes = clazz.getClassFile().getAttributes();
        java.util.Iterator<?> itr = attributes.iterator();
        java.util.List<java.lang.String> templates = new java.util.ArrayList<>();
        java.util.List<java.lang.Boolean> skips = new java.util.ArrayList<>();
        java.util.List<java.lang.Boolean> renames = new java.util.ArrayList<>();
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams response = new org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams();
        check : {
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2090, itr.hasNext())) {
                java.lang.Object object = itr.next();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2091, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                    javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                    javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                    for (javassist.bytecode.annotation.Annotation annotation : items) {
                        java.lang.String typeName = annotation.getTypeName();
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2092, typeName.equals(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyTransform.class.getName()))) {
                            javassist.bytecode.annotation.ArrayMemberValue arrayMember = ((javassist.bytecode.annotation.ArrayMemberValue) (annotation.getMemberValue("value")));
                            for (javassist.bytecode.annotation.MemberValue arrayMemberValue : arrayMember.getValue()) {
                                javassist.bytecode.annotation.AnnotationMemberValue member = ((javassist.bytecode.annotation.AnnotationMemberValue) (arrayMemberValue));
                                javassist.bytecode.annotation.Annotation memberAnnot = member.getValue();
                                javassist.bytecode.annotation.ArrayMemberValue annot = ((javassist.bytecode.annotation.ArrayMemberValue) (memberAnnot.getMemberValue("templateTokens")));
                                java.util.List<java.lang.String> addedTemplates = new java.util.ArrayList<>();
                                for (javassist.bytecode.annotation.MemberValue memberValue : annot.getValue()) {
                                    java.lang.String val = ((javassist.bytecode.annotation.StringMemberValue) (memberValue)).getValue();
                                    addedTemplates.addAll(reviewTemplateTokens(matchedPatterns, val));
                                }
                                templates.addAll(addedTemplates);
                                javassist.bytecode.annotation.BooleanMemberValue skipAnnot = ((javassist.bytecode.annotation.BooleanMemberValue) (memberAnnot.getMemberValue("skipOverlaps")));
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2093, (skipAnnot != null))) {
                                    for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2094, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2097, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2095, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2096, addedTemplates.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2098, (j++))) {
                                        skips.add(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2099, skipAnnot.getValue()));
                                    }
                                }else {
                                    for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2100, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2103, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2101, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2102, addedTemplates.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2104, (j++))) {
                                        skips.add(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2105, mySkipOverlaps));
                                    }
                                }
                                javassist.bytecode.annotation.BooleanMemberValue renameAnnot = ((javassist.bytecode.annotation.BooleanMemberValue) (memberAnnot.getMemberValue("renameMethodOverlaps")));
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2106, (renameAnnot != null))) {
                                    for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2107, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2110, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2108, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2109, addedTemplates.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2111, (j++))) {
                                        renames.add(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2112, renameAnnot.getValue()));
                                    }
                                }else {
                                    for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2113, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2116, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2114, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2115, addedTemplates.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2117, (j++))) {
                                        renames.add(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2118, myRenameMethodOverlaps));
                                    }
                                }
                            }
                            response.setXformVals(templates.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2119, templates.size())]));
                            response.setXformSkipOverlaps(skips.toArray(new java.lang.Boolean[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2120, skips.size())]));
                            response.setXformRenameMethodOverlaps(renames.toArray(new java.lang.Boolean[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2121, renames.size())]));
                            break check;
                        }
                    }
                }
            } 
        }
        return response;
    }

    protected org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams reviewConditionalDirectCopyTransforms(java.lang.String convertedClassName, java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> matchedPatterns) {
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams response = new org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.XFormParams();
        java.util.List<java.lang.String> templates = new java.util.ArrayList<>();
        java.util.List<java.lang.Boolean> skips = new java.util.ArrayList<>();
        java.util.List<java.lang.Boolean> renames = new java.util.ArrayList<>();
        if (conditionalDirectCopyTransformersManager.isEntityEnabled(convertedClassName)) {
            org.broadleafcommerce.common.weave.ConditionalDirectCopyTransformMemberDto dto = conditionalDirectCopyTransformersManager.getTransformMember(convertedClassName);
            java.util.List<java.lang.String> addedTemplates = new java.util.ArrayList<>();
            for (java.lang.String templateToken : dto.getTemplateTokens()) {
                addedTemplates.addAll(reviewTemplateTokens(matchedPatterns, templateToken));
            }
            templates.addAll(addedTemplates);
            for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2122, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2125, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2123, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2124, addedTemplates.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2126, (j++))) {
                skips.add(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2127, dto.isSkipOverlaps()));
                renames.add(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2128, dto.isRenameMethodOverlaps()));
            }
            response.setXformVals(templates.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2129, templates.size())]));
            response.setXformSkipOverlaps(skips.toArray(new java.lang.Boolean[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2130, skips.size())]));
            response.setXformRenameMethodOverlaps(renames.toArray(new java.lang.Boolean[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2131, renames.size())]));
        }
        return response;
    }

    protected java.util.List<java.lang.String> reviewTemplateTokens(java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> matchedPatterns, java.lang.String val) {
        java.util.List<java.lang.String> addedTemplates = new java.util.ArrayList<>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2134, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2132, (val != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2133, templateTokens.containsKey(val)))))) {
            templateCheck : {
                for (org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern matchedPattern : matchedPatterns) {
                    for (java.lang.String ignoreToken : matchedPattern.getTemplateTokenPatterns()) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2135, val.matches(ignoreToken))) {
                            break templateCheck;
                        }
                    }
                }
                java.lang.String[] templateVals = templateTokens.get(val).split(",");
                addedTemplates.addAll(java.util.Arrays.asList(templateVals));
            }
        }
        return addedTemplates;
    }

    protected void buildClassLevelAnnotations(javassist.bytecode.ClassFile classFile, javassist.bytecode.ClassFile templateClassFile, javassist.bytecode.ConstPool constantPool) throws javassist.NotFoundException {
        java.util.List<?> templateAttributes = templateClassFile.getAttributes();
        java.util.Iterator<?> templateItr = templateAttributes.iterator();
        javassist.bytecode.annotation.Annotation templateEntityListeners = null;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2136, templateItr.hasNext())) {
            java.lang.Object object = templateItr.next();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2137, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                for (javassist.bytecode.annotation.Annotation annotation : items) {
                    java.lang.String typeName = annotation.getTypeName();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2138, typeName.equals(javax.persistence.EntityListeners.class.getName()))) {
                        templateEntityListeners = annotation;
                    }
                }
            }
        } 
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2139, (templateEntityListeners != null))) {
            javassist.bytecode.AnnotationsAttribute annotationsAttribute = new javassist.bytecode.AnnotationsAttribute(constantPool, javassist.bytecode.AnnotationsAttribute.visibleTag);
            java.util.List<?> attributes = classFile.getAttributes();
            java.util.Iterator<?> itr = attributes.iterator();
            javassist.bytecode.annotation.Annotation existingEntityListeners = null;
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2140, itr.hasNext())) {
                java.lang.Object object = itr.next();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2141, javassist.bytecode.AnnotationsAttribute.class.isAssignableFrom(object.getClass()))) {
                    javassist.bytecode.AnnotationsAttribute attr = ((javassist.bytecode.AnnotationsAttribute) (object));
                    javassist.bytecode.annotation.Annotation[] items = attr.getAnnotations();
                    for (javassist.bytecode.annotation.Annotation annotation : items) {
                        java.lang.String typeName = annotation.getTypeName();
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2142, typeName.equals(javax.persistence.EntityListeners.class.getName()))) {
                            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug("Stripping out previous EntityListeners annotation at the class level - will merge into new EntityListeners");
                            existingEntityListeners = annotation;
                            continue;
                        }
                        annotationsAttribute.addAnnotation(annotation);
                    }
                    itr.remove();
                }
            } 
            javassist.bytecode.annotation.Annotation entityListeners = getEntityListeners(constantPool, existingEntityListeners, templateEntityListeners);
            annotationsAttribute.addAnnotation(entityListeners);
            classFile.addAttribute(annotationsAttribute);
        }
    }

    protected javassist.bytecode.annotation.Annotation getEntityListeners(javassist.bytecode.ConstPool constantPool, javassist.bytecode.annotation.Annotation existingEntityListeners, javassist.bytecode.annotation.Annotation templateEntityListeners) {
        javassist.bytecode.annotation.Annotation listeners = new javassist.bytecode.annotation.Annotation(javax.persistence.EntityListeners.class.getName(), constantPool);
        javassist.bytecode.annotation.ArrayMemberValue listenerArray = new javassist.bytecode.annotation.ArrayMemberValue(constantPool);
        java.util.Set<javassist.bytecode.annotation.MemberValue> listenerMemberValues = new java.util.HashSet<>();
        {
            javassist.bytecode.annotation.ArrayMemberValue templateListenerValues = ((javassist.bytecode.annotation.ArrayMemberValue) (templateEntityListeners.getMemberValue("value")));
            listenerMemberValues.addAll(java.util.Arrays.asList(templateListenerValues.getValue()));
            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug("Adding template values to new EntityListeners");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2143, (existingEntityListeners != null))) {
            javassist.bytecode.annotation.ArrayMemberValue oldListenerValues = ((javassist.bytecode.annotation.ArrayMemberValue) (existingEntityListeners.getMemberValue("value")));
            listenerMemberValues.addAll(java.util.Arrays.asList(oldListenerValues.getValue()));
            org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.logger.debug("Adding previous values to new EntityListeners");
        }
        listenerArray.setValue(listenerMemberValues.toArray(new javassist.bytecode.annotation.MemberValue[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2144, listenerMemberValues.size())]));
        listeners.addMemberValue("value", listenerArray);
        return listeners;
    }

    protected java.lang.String getImplementationType(java.lang.String className) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2145, className.equals("java.util.List"))) {
            return "java.util.ArrayList";
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2146, className.equals("java.util.Map"))) {
                return "java.util.HashMap";
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2147, className.equals("java.util.Set"))) {
                    return "java.util.HashSet";
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2148, className.contains("["))) {
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

    public org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer addXformTemplate(java.lang.String classToTransform, java.lang.String contributingClass) {
        xformTemplates.put(classToTransform, contributingClass);
        return this;
    }

    public void setXformTemplates(java.util.Map<java.lang.String, java.lang.String> xformTemplates) {
        this.xformTemplates = xformTemplates;
    }

    public java.lang.Boolean getRenameMethodOverlaps() {
        return renameMethodOverlaps;
    }

    public void setRenameMethodOverlaps(java.lang.Boolean renameMethodOverlaps) {
        this.renameMethodOverlaps = renameMethodOverlaps;
    }

    public java.lang.String getRenameMethodPrefix() {
        return renameMethodPrefix;
    }

    public void setRenameMethodPrefix(java.lang.String renameMethodPrefix) {
        this.renameMethodPrefix = renameMethodPrefix;
    }

    public java.lang.Boolean getSkipOverlaps() {
        return skipOverlaps;
    }

    public void setSkipOverlaps(java.lang.Boolean skipOverlaps) {
        this.skipOverlaps = skipOverlaps;
    }

    public java.util.Map<java.lang.String, java.lang.String> getTemplateTokens() {
        return templateTokens;
    }

    public void setTemplateTokens(java.util.Map<java.lang.String, java.lang.String> templateTokens) {
        this.templateTokens = templateTokens;
    }

    public java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> getIgnorePatterns() {
        return ignorePatterns;
    }

    public void setIgnorePatterns(java.util.List<org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern> ignorePatterns) {
        this.ignorePatterns = ignorePatterns;
    }

    public static perturbation.location.PerturbationLocation __L2000;

    public static perturbation.location.PerturbationLocation __L2001;

    public static perturbation.location.PerturbationLocation __L2002;

    public static perturbation.location.PerturbationLocation __L2003;

    public static perturbation.location.PerturbationLocation __L2004;

    public static perturbation.location.PerturbationLocation __L2005;

    public static perturbation.location.PerturbationLocation __L2006;

    public static perturbation.location.PerturbationLocation __L2007;

    public static perturbation.location.PerturbationLocation __L2008;

    public static perturbation.location.PerturbationLocation __L2009;

    public static perturbation.location.PerturbationLocation __L2010;

    public static perturbation.location.PerturbationLocation __L2011;

    public static perturbation.location.PerturbationLocation __L2012;

    public static perturbation.location.PerturbationLocation __L2013;

    public static perturbation.location.PerturbationLocation __L2014;

    public static perturbation.location.PerturbationLocation __L2015;

    public static perturbation.location.PerturbationLocation __L2016;

    public static perturbation.location.PerturbationLocation __L2017;

    public static perturbation.location.PerturbationLocation __L2018;

    public static perturbation.location.PerturbationLocation __L2019;

    public static perturbation.location.PerturbationLocation __L2020;

    public static perturbation.location.PerturbationLocation __L2021;

    public static perturbation.location.PerturbationLocation __L2022;

    public static perturbation.location.PerturbationLocation __L2023;

    public static perturbation.location.PerturbationLocation __L2024;

    public static perturbation.location.PerturbationLocation __L2025;

    public static perturbation.location.PerturbationLocation __L2026;

    public static perturbation.location.PerturbationLocation __L2027;

    public static perturbation.location.PerturbationLocation __L2028;

    public static perturbation.location.PerturbationLocation __L2029;

    public static perturbation.location.PerturbationLocation __L2030;

    public static perturbation.location.PerturbationLocation __L2031;

    public static perturbation.location.PerturbationLocation __L2032;

    public static perturbation.location.PerturbationLocation __L2033;

    public static perturbation.location.PerturbationLocation __L2034;

    public static perturbation.location.PerturbationLocation __L2035;

    public static perturbation.location.PerturbationLocation __L2036;

    public static perturbation.location.PerturbationLocation __L2037;

    public static perturbation.location.PerturbationLocation __L2038;

    public static perturbation.location.PerturbationLocation __L2039;

    public static perturbation.location.PerturbationLocation __L2040;

    public static perturbation.location.PerturbationLocation __L2041;

    public static perturbation.location.PerturbationLocation __L2042;

    public static perturbation.location.PerturbationLocation __L2043;

    public static perturbation.location.PerturbationLocation __L2044;

    public static perturbation.location.PerturbationLocation __L2045;

    public static perturbation.location.PerturbationLocation __L2046;

    public static perturbation.location.PerturbationLocation __L2047;

    public static perturbation.location.PerturbationLocation __L2048;

    public static perturbation.location.PerturbationLocation __L2049;

    public static perturbation.location.PerturbationLocation __L2050;

    public static perturbation.location.PerturbationLocation __L2051;

    public static perturbation.location.PerturbationLocation __L2052;

    public static perturbation.location.PerturbationLocation __L2053;

    public static perturbation.location.PerturbationLocation __L2054;

    public static perturbation.location.PerturbationLocation __L2055;

    public static perturbation.location.PerturbationLocation __L2056;

    public static perturbation.location.PerturbationLocation __L2057;

    public static perturbation.location.PerturbationLocation __L2058;

    public static perturbation.location.PerturbationLocation __L2059;

    public static perturbation.location.PerturbationLocation __L2060;

    public static perturbation.location.PerturbationLocation __L2061;

    public static perturbation.location.PerturbationLocation __L2062;

    public static perturbation.location.PerturbationLocation __L2063;

    public static perturbation.location.PerturbationLocation __L2064;

    public static perturbation.location.PerturbationLocation __L2065;

    public static perturbation.location.PerturbationLocation __L2066;

    public static perturbation.location.PerturbationLocation __L2067;

    public static perturbation.location.PerturbationLocation __L2068;

    public static perturbation.location.PerturbationLocation __L2069;

    public static perturbation.location.PerturbationLocation __L2070;

    public static perturbation.location.PerturbationLocation __L2071;

    public static perturbation.location.PerturbationLocation __L2072;

    public static perturbation.location.PerturbationLocation __L2073;

    public static perturbation.location.PerturbationLocation __L2074;

    public static perturbation.location.PerturbationLocation __L2075;

    public static perturbation.location.PerturbationLocation __L2076;

    public static perturbation.location.PerturbationLocation __L2077;

    public static perturbation.location.PerturbationLocation __L2078;

    public static perturbation.location.PerturbationLocation __L2079;

    public static perturbation.location.PerturbationLocation __L2080;

    public static perturbation.location.PerturbationLocation __L2081;

    public static perturbation.location.PerturbationLocation __L2082;

    public static perturbation.location.PerturbationLocation __L2083;

    public static perturbation.location.PerturbationLocation __L2084;

    public static perturbation.location.PerturbationLocation __L2085;

    public static perturbation.location.PerturbationLocation __L2086;

    public static perturbation.location.PerturbationLocation __L2087;

    public static perturbation.location.PerturbationLocation __L2088;

    public static perturbation.location.PerturbationLocation __L2089;

    public static perturbation.location.PerturbationLocation __L2090;

    public static perturbation.location.PerturbationLocation __L2091;

    public static perturbation.location.PerturbationLocation __L2092;

    public static perturbation.location.PerturbationLocation __L2093;

    public static perturbation.location.PerturbationLocation __L2094;

    public static perturbation.location.PerturbationLocation __L2095;

    public static perturbation.location.PerturbationLocation __L2096;

    public static perturbation.location.PerturbationLocation __L2097;

    public static perturbation.location.PerturbationLocation __L2098;

    public static perturbation.location.PerturbationLocation __L2099;

    public static perturbation.location.PerturbationLocation __L2100;

    public static perturbation.location.PerturbationLocation __L2101;

    public static perturbation.location.PerturbationLocation __L2102;

    public static perturbation.location.PerturbationLocation __L2103;

    public static perturbation.location.PerturbationLocation __L2104;

    public static perturbation.location.PerturbationLocation __L2105;

    public static perturbation.location.PerturbationLocation __L2106;

    public static perturbation.location.PerturbationLocation __L2107;

    public static perturbation.location.PerturbationLocation __L2108;

    public static perturbation.location.PerturbationLocation __L2109;

    public static perturbation.location.PerturbationLocation __L2110;

    public static perturbation.location.PerturbationLocation __L2111;

    public static perturbation.location.PerturbationLocation __L2112;

    public static perturbation.location.PerturbationLocation __L2113;

    public static perturbation.location.PerturbationLocation __L2114;

    public static perturbation.location.PerturbationLocation __L2115;

    public static perturbation.location.PerturbationLocation __L2116;

    public static perturbation.location.PerturbationLocation __L2117;

    public static perturbation.location.PerturbationLocation __L2118;

    public static perturbation.location.PerturbationLocation __L2119;

    public static perturbation.location.PerturbationLocation __L2120;

    public static perturbation.location.PerturbationLocation __L2121;

    public static perturbation.location.PerturbationLocation __L2122;

    public static perturbation.location.PerturbationLocation __L2123;

    public static perturbation.location.PerturbationLocation __L2124;

    public static perturbation.location.PerturbationLocation __L2125;

    public static perturbation.location.PerturbationLocation __L2126;

    public static perturbation.location.PerturbationLocation __L2127;

    public static perturbation.location.PerturbationLocation __L2128;

    public static perturbation.location.PerturbationLocation __L2129;

    public static perturbation.location.PerturbationLocation __L2130;

    public static perturbation.location.PerturbationLocation __L2131;

    public static perturbation.location.PerturbationLocation __L2132;

    public static perturbation.location.PerturbationLocation __L2133;

    public static perturbation.location.PerturbationLocation __L2134;

    public static perturbation.location.PerturbationLocation __L2135;

    public static perturbation.location.PerturbationLocation __L2136;

    public static perturbation.location.PerturbationLocation __L2137;

    public static perturbation.location.PerturbationLocation __L2138;

    public static perturbation.location.PerturbationLocation __L2139;

    public static perturbation.location.PerturbationLocation __L2140;

    public static perturbation.location.PerturbationLocation __L2141;

    public static perturbation.location.PerturbationLocation __L2142;

    public static perturbation.location.PerturbationLocation __L2143;

    public static perturbation.location.PerturbationLocation __L2144;

    public static perturbation.location.PerturbationLocation __L2145;

    public static perturbation.location.PerturbationLocation __L2146;

    public static perturbation.location.PerturbationLocation __L2147;

    public static perturbation.location.PerturbationLocation __L2148;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:677)", 2000, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:677)", 2001, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:677)", 2002, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:677)", 2003, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:677)", 2004, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:103)", 2005, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:119)", 2006, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:119)", 2007, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:120)", 2008, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:123)", 2009, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:126)", 2010, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:132)", 2011, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:135)", 2012, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:137)", 2013, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:138)", 2014, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:142)", 2015, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:145)", 2016, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:145)", 2017, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:145)", 2018, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:145)", 2019, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:146)", 2020, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:146)", 2021, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:150)", 2022, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:152)", 2023, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:153)", 2024, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:153)", 2025, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:155)", 2026, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:155)", 2027, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:155)", 2028, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:155)", 2029, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:158)", 2030, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:158)", 2031, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:158)", 2032, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:158)", 2033, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:158)", 2034, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:165)", 2035, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:165)", 2036, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:165)", 2037, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:166)", 2038, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:172)", 2039, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2040 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:185)", 2040, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2041 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:186)", 2041, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2042 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:186)", 2042, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:208)", 2043, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:215)", 2044, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:215)", 2045, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:222)", 2046, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:222)", 2047, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:233)", 2048, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:241)", 2049, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:243)", 2050, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:243)", 2051, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:243)", 2052, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:244)", 2053, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:254)", 2054, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:265)", 2055, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:272)", 2056, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:272)", 2057, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:277)", 2058, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:285)", 2059, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:285)", 2060, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:299)", 2061, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:302)", 2062, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:315)", 2063, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:344)", 2064, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:344)", 2065, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:345)", 2066, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:345)", 2067, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:345)", 2068, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:345)", 2069, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:345)", 2070, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:346)", 2071, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:347)", 2072, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:347)", 2073, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:348)", 2074, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2075 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:350)", 2075, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:351)", 2076, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:357)", 2077, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:357)", 2078, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:357)", 2079, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:357)", 2080, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:357)", 2081, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:358)", 2082, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:359)", 2083, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:359)", 2084, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:361)", 2085, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:362)", 2086, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:368)", 2087, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:369)", 2088, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:370)", 2089, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:390)", 2090, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:392)", 2091, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:397)", 2092, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:410)", 2093, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:411)", 2094, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:411)", 2095, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:411)", 2096, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:411)", 2097, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:411)", 2098, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:412)", 2099, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:415)", 2100, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:415)", 2101, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:415)", 2102, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:415)", 2103, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:415)", 2104, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:416)", 2105, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:420)", 2106, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:421)", 2107, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:421)", 2108, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:421)", 2109, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:421)", 2110, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:421)", 2111, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:422)", 2112, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:425)", 2113, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:425)", 2114, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:425)", 2115, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:425)", 2116, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:425)", 2117, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:426)", 2118, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:430)", 2119, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:431)", 2120, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:432)", 2121, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:462)", 2122, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:462)", 2123, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:462)", 2124, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:462)", 2125, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:462)", 2126, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:463)", 2127, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:464)", 2128, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:466)", 2129, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:467)", 2130, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:468)", 2131, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:475)", 2132, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:475)", 2133, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:475)", 2134, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:479)", 2135, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:495)", 2136, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:497)", 2137, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:502)", 2138, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:509)", 2139, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:514)", 2140, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:516)", 2141, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:521)", 2142, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:548)", 2143, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:553)", 2144, "Numerical");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:570)", 2145, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:572)", 2146, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:574)", 2147, "Boolean");
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.__L2148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/jpa/copy/DirectCopyClassTransformer.java:576)", 2148, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyClassTransformer.initPerturbationLocation0();
    }
}

