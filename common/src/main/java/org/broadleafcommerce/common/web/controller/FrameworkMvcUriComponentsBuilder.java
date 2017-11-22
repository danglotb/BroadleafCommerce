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
package org.broadleafcommerce.common.web.controller;


public class FrameworkMvcUriComponentsBuilder {
    private static class ControllerMethodInvocationInterceptor implements org.aopalliance.intercept.MethodInterceptor , org.springframework.cglib.proxy.MethodInterceptor {
        private static final java.lang.reflect.Method getControllerMethod = org.springframework.util.ReflectionUtils.findMethod(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class, "getControllerMethod");

        private static final java.lang.reflect.Method getArgumentValues = org.springframework.util.ReflectionUtils.findMethod(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class, "getArgumentValues");

        private static final java.lang.reflect.Method getControllerType = org.springframework.util.ReflectionUtils.findMethod(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class, "getControllerType");

        private java.lang.reflect.Method controllerMethod;

        private java.lang.Object[] argumentValues;

        private java.lang.Class<?> controllerType;

        ControllerMethodInvocationInterceptor(java.lang.Class<?> controllerType) {
            this.controllerType = controllerType;
        }

        @java.lang.Override
        public java.lang.Object intercept(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] args, org.springframework.cglib.proxy.MethodProxy proxy) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7086, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.getControllerMethod.equals(method))) {
                return this.controllerMethod;
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7087, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.getArgumentValues.equals(method))) {
                    return this.argumentValues;
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7088, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.getControllerType.equals(method))) {
                        return this.controllerType;
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7089, org.springframework.util.ReflectionUtils.isObjectMethod(method))) {
                            return org.springframework.util.ReflectionUtils.invokeMethod(method, obj, args);
                        }else {
                            this.controllerMethod = method;
                            this.argumentValues = args;
                            java.lang.Class<?> returnType = method.getReturnType();
                            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7090, ((void.class) == returnType)) ? null : returnType.cast(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.initProxy(returnType, this));
                        }



        }

        @java.lang.Override
        public java.lang.Object invoke(org.aopalliance.intercept.MethodInvocation inv) throws java.lang.Throwable {
            return intercept(inv.getThis(), inv.getMethod(), inv.getArguments(), null);
        }

        public static perturbation.location.PerturbationLocation __L7086;

        public static perturbation.location.PerturbationLocation __L7087;

        public static perturbation.location.PerturbationLocation __L7088;

        public static perturbation.location.PerturbationLocation __L7089;

        public static perturbation.location.PerturbationLocation __L7090;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:752)", 7086, "Boolean");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:755)", 7087, "Boolean");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:758)", 7088, "Boolean");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:761)", 7089, "Boolean");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.__L7090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:768)", 7090, "Boolean");
        }

        static {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor.initPerturbationLocation0();
        }
    }

    public interface MethodInvocationInfo {
        java.lang.reflect.Method getControllerMethod();

        java.lang.Object[] getArgumentValues();

        java.lang.Class<?> getControllerType();
    }

    public static class MethodArgumentBuilder {
        private final java.lang.Class<?> controllerType;

        private final java.lang.reflect.Method method;

        private final java.lang.Object[] argumentValues;

        private final org.springframework.web.util.UriComponentsBuilder baseUrl;

        public MethodArgumentBuilder(java.lang.Class<?> controllerType, java.lang.reflect.Method method) {
            this(null, controllerType, method);
        }

        public MethodArgumentBuilder(org.springframework.web.util.UriComponentsBuilder baseUrl, java.lang.Class<?> controllerType, java.lang.reflect.Method method) {
            org.springframework.util.Assert.notNull(controllerType, "'controllerType' is required");
            org.springframework.util.Assert.notNull(method, "'method' is required");
            this.baseUrl = (baseUrl != null) ? baseUrl : org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.initBaseUrl();
            this.controllerType = controllerType;
            this.method = method;
            this.argumentValues = new java.lang.Object[method.getParameterTypes().length];
            for (int i = 0; i < (this.argumentValues.length); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7091, (i++))) {
                this.argumentValues[i] = null;
            }
        }

        @java.lang.Deprecated
        public MethodArgumentBuilder(java.lang.reflect.Method method) {
            this(method.getDeclaringClass(), method);
        }

        private static org.springframework.web.util.UriComponentsBuilder initBaseUrl() {
            org.springframework.web.util.UriComponentsBuilder builder = org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentServletMapping();
            return org.springframework.web.util.UriComponentsBuilder.fromPath(builder.build().getPath());
        }

        public org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder arg(int index, java.lang.Object value) {
            this.argumentValues[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7092, index)] = value;
            return this;
        }

        public java.lang.String build() {
            return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(this.baseUrl, this.controllerType, this.method, this.argumentValues).build(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7093, false)).encode().toUriString();
        }

        public java.lang.String buildAndExpand(java.lang.Object... uriVars) {
            return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(this.baseUrl, this.controllerType, this.method, this.argumentValues).build(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7094, false)).expand(uriVars).encode().toString();
        }

        public static perturbation.location.PerturbationLocation __L7091;

        public static perturbation.location.PerturbationLocation __L7092;

        public static perturbation.location.PerturbationLocation __L7093;

        public static perturbation.location.PerturbationLocation __L7094;

        private static void initPerturbationLocation0() {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:816)", 7091, "Numerical");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:836)", 7092, "Numerical");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:842)", 7093, "Boolean");
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.__L7094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:847)", 7094, "Boolean");
        }

        static {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder.initPerturbationLocation0();
        }
    }

    public static final java.lang.String MVC_URI_COMPONENTS_CONTRIBUTOR_BEAN_NAME = "mvcUriComponentsContributor";

    private static final org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.class);

    private static final org.springframework.objenesis.SpringObjenesis objenesis = new org.springframework.objenesis.SpringObjenesis();

    private static final org.springframework.util.PathMatcher pathMatcher = new org.springframework.util.AntPathMatcher();

    private static final org.springframework.core.ParameterNameDiscoverer parameterNameDiscoverer = new org.springframework.core.DefaultParameterNameDiscoverer();

    private static final org.springframework.web.method.support.CompositeUriComponentsContributor defaultUriComponentsContributor;

    private final org.springframework.web.util.UriComponentsBuilder baseUrl;

    protected FrameworkMvcUriComponentsBuilder(org.springframework.web.util.UriComponentsBuilder baseUrl) {
        org.springframework.util.Assert.notNull(baseUrl, "'baseUrl' is required");
        this.baseUrl = baseUrl;
    }

    public static org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder relativeTo(org.springframework.web.util.UriComponentsBuilder baseUrl) {
        return new org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder(baseUrl);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromController(java.lang.Class<?> controllerType) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromController(null, controllerType);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromController(org.springframework.web.util.UriComponentsBuilder builder, java.lang.Class<?> controllerType) {
        builder = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getBaseUrlToUse(builder);
        java.lang.String mapping = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getTypeRequestMapping(controllerType);
        return builder.path(mapping);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromMethodName(java.lang.Class<?> controllerType, java.lang.String methodName, java.lang.Object... args) {
        java.lang.reflect.Method method = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getMethod(controllerType, methodName, args);
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(null, controllerType, method, args);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromMethodName(org.springframework.web.util.UriComponentsBuilder builder, java.lang.Class<?> controllerType, java.lang.String methodName, java.lang.Object... args) {
        java.lang.reflect.Method method = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getMethod(controllerType, methodName, args);
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(builder, controllerType, method, args);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromMethodCall(java.lang.Object info) {
        org.springframework.util.Assert.isInstanceOf(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class, info, "MethodInvocationInfo required");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo invocationInfo = ((org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo) (info));
        java.lang.Class<?> controllerType = invocationInfo.getControllerType();
        java.lang.reflect.Method method = invocationInfo.getControllerMethod();
        java.lang.Object[] arguments = invocationInfo.getArgumentValues();
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(null, controllerType, method, arguments);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromMethodCall(org.springframework.web.util.UriComponentsBuilder builder, java.lang.Object info) {
        org.springframework.util.Assert.isInstanceOf(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class, info, "MethodInvocationInfo required");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo invocationInfo = ((org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo) (info));
        java.lang.Class<?> controllerType = invocationInfo.getControllerType();
        java.lang.reflect.Method method = invocationInfo.getControllerMethod();
        java.lang.Object[] arguments = invocationInfo.getArgumentValues();
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(builder, controllerType, method, arguments);
    }

    public static org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder fromMappingName(java.lang.String mappingName) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMappingName(null, mappingName);
    }

    public static org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder fromMappingName(org.springframework.web.util.UriComponentsBuilder builder, java.lang.String name) {
        org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping handlerMapping = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getRequestMappingInfoHandlerMapping();
        java.util.List<org.springframework.web.method.HandlerMethod> handlerMethods = handlerMapping.getHandlerMethodsForMappingName(name);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7095, (handlerMethods == null))) {
            throw new java.lang.IllegalArgumentException(("Mapping mappingName not found: " + name));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7098, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7096, handlerMethods.size())) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7097, 1))))) {
            throw new java.lang.IllegalArgumentException(((("No unique match for mapping mappingName " + name) + ": ") + handlerMethods));
        }
        org.springframework.web.method.HandlerMethod handlerMethod = handlerMethods.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7099, 0));
        java.lang.Class<?> controllerType = handlerMethod.getBeanType();
        java.lang.reflect.Method method = handlerMethod.getMethod();
        return new org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder(builder, controllerType, method);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromMethod(java.lang.Class<?> controllerType, java.lang.reflect.Method method, java.lang.Object... args) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(null, controllerType, method, args);
    }

    public static org.springframework.web.util.UriComponentsBuilder fromMethod(org.springframework.web.util.UriComponentsBuilder baseUrl, java.lang.Class<?> controllerType, java.lang.reflect.Method method, java.lang.Object... args) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(baseUrl, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7100, (controllerType != null)) ? controllerType : method.getDeclaringClass()), method, args);
    }

    @java.lang.Deprecated
    public static org.springframework.web.util.UriComponentsBuilder fromMethod(java.lang.reflect.Method method, java.lang.Object... args) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodInternal(null, method.getDeclaringClass(), method, args);
    }

    private static org.springframework.web.util.UriComponentsBuilder fromMethodInternal(org.springframework.web.util.UriComponentsBuilder baseUrl, java.lang.Class<?> controllerType, java.lang.reflect.Method method, java.lang.Object... args) {
        baseUrl = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getBaseUrlToUse(baseUrl);
        java.lang.String typePath = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getTypeRequestMapping(controllerType);
        java.lang.String methodPath = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getMethodRequestMapping(method);
        java.lang.String path = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.pathMatcher.combine(typePath, methodPath);
        baseUrl.path(path);
        org.springframework.web.util.UriComponents uriComponents = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.applyContributors(baseUrl, method, args);
        return org.springframework.web.util.UriComponentsBuilder.newInstance().uriComponents(uriComponents);
    }

    private static org.springframework.web.util.UriComponentsBuilder getBaseUrlToUse(org.springframework.web.util.UriComponentsBuilder baseUrl) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7101, (baseUrl != null))) {
            return baseUrl.cloneBuilder();
        }else {
            return org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentServletMapping();
        }
    }

    private static java.lang.String getTypeRequestMapping(java.lang.Class<?> controllerType) {
        org.springframework.util.Assert.notNull(controllerType, "'controllerType' must not be null");
        java.lang.String[] paths;
        org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping frameworkMapping = controllerType.getAnnotation(org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping.class);
        org.springframework.web.bind.annotation.RequestMapping requestMapping = controllerType.getAnnotation(org.springframework.web.bind.annotation.RequestMapping.class);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7102, (frameworkMapping != null))) {
            paths = frameworkMapping.path();
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7103, (requestMapping != null))) {
                paths = requestMapping.path();
            }else {
                return "/";
            }

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7107, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7104, org.springframework.util.ObjectUtils.isEmpty(paths))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7106, org.springframework.util.StringUtils.isEmpty(paths[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7105, 0)])))))) {
            return "/";
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7112, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7110, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7108, paths.length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7109, 1))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7111, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.isWarnEnabled()))))) {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.warn((("Multiple paths on controller " + (controllerType.getName())) + ", using first one"));
        }
        return paths[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7113, 0)];
    }

    private static java.lang.String getMethodRequestMapping(java.lang.reflect.Method method) {
        org.springframework.util.Assert.notNull(method, "'method' must not be null");
        java.lang.String[] paths;
        org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping frameworkMapping = method.getAnnotation(org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping.class);
        org.springframework.web.bind.annotation.RequestMapping requestMapping = method.getAnnotation(org.springframework.web.bind.annotation.RequestMapping.class);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7114, (frameworkMapping != null))) {
            paths = frameworkMapping.path();
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7115, (requestMapping != null))) {
                paths = requestMapping.path();
            }else {
                throw new java.lang.IllegalArgumentException(("No @RequestMapping or @FrameworkMapping on: " + (method.toGenericString())));
            }

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7119, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7116, org.springframework.util.ObjectUtils.isEmpty(paths))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7118, org.springframework.util.StringUtils.isEmpty(paths[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7117, 0)])))))) {
            return "/";
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7124, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7122, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7120, paths.length)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7121, 1))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7123, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.isWarnEnabled()))))) {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.warn((("Multiple paths on method " + (method.toGenericString())) + ", using first one"));
        }
        return paths[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7125, 0)];
    }

    private static java.lang.reflect.Method getMethod(java.lang.Class<?> controllerType, final java.lang.String methodName, final java.lang.Object... args) {
        org.springframework.util.ReflectionUtils.MethodFilter selector = new org.springframework.util.ReflectionUtils.MethodFilter() {
            @java.lang.Override
            public boolean matches(java.lang.reflect.Method method) {
                java.lang.String name = method.getName();
                int argLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7126, method.getParameterTypes().length);
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7131, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7127, name.equals(methodName))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7130, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7128, argLength)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7129, args.length)))))));
            }
        };
        java.util.Set<java.lang.reflect.Method> methods = org.springframework.core.MethodIntrospector.selectMethods(controllerType, selector);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7134, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7132, methods.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7133, 1))))) {
            return methods.iterator().next();
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7137, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7135, methods.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7136, 1))))) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Found two methods named '%s' accepting arguments %s in controller %s: [%s]", methodName, java.util.Arrays.asList(args), controllerType.getName(), methods));
            }else {
                throw new java.lang.IllegalArgumentException(((((("No method named '" + methodName) + "' with ") + (args.length)) + " arguments found in controller ") + (controllerType.getName())));
            }

    }

    private static org.springframework.web.util.UriComponents applyContributors(org.springframework.web.util.UriComponentsBuilder builder, java.lang.reflect.Method method, java.lang.Object... args) {
        org.springframework.web.method.support.CompositeUriComponentsContributor contributor = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getConfiguredUriComponentsContributor();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7138, (contributor == null))) {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.debug("Using default CompositeUriComponentsContributor");
            contributor = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.defaultUriComponentsContributor;
        }
        int paramCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7139, method.getParameterTypes().length);
        int argCount = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7140, args.length);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7143, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7141, paramCount)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7142, argCount))))) {
            throw new java.lang.IllegalArgumentException(((("Number of method parameters " + paramCount) + " does not match number of argument values ") + argCount));
        }
        final java.util.Map<java.lang.String, java.lang.Object> uriVars = new java.util.HashMap<>();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7144, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7147, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7145, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7146, paramCount)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7148, (i++))) {
            org.springframework.core.MethodParameter param = new org.springframework.core.annotation.SynthesizingMethodParameter(method, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7149, i));
            param.initParameterNameDiscovery(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.parameterNameDiscoverer);
            contributor.contributeMethodArgument(param, args[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7150, i)], builder, uriVars);
        }
        return builder.build().expand(new org.springframework.web.util.UriComponents.UriTemplateVariables() {
            @java.lang.Override
            public java.lang.Object getValue(java.lang.String name) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7151, uriVars.containsKey(name)) ? uriVars.get(name) : org.springframework.web.util.UriComponents.UriTemplateVariables.SKIP_VALUE;
            }
        });
    }

    private static org.springframework.web.method.support.CompositeUriComponentsContributor getConfiguredUriComponentsContributor() {
        org.springframework.web.context.WebApplicationContext wac = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getWebApplicationContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7152, (wac == null))) {
            return null;
        }
        try {
            return wac.getBean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MVC_URI_COMPONENTS_CONTRIBUTOR_BEAN_NAME, org.springframework.web.method.support.CompositeUriComponentsContributor.class);
        } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException ex) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7153, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.isDebugEnabled())) {
                org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.debug((("No CompositeUriComponentsContributor bean with name '" + (org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MVC_URI_COMPONENTS_CONTRIBUTOR_BEAN_NAME)) + "'"));
            }
            return null;
        }
    }

    private static org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping getRequestMappingInfoHandlerMapping() {
        org.springframework.web.context.WebApplicationContext wac = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.getWebApplicationContext();
        org.springframework.util.Assert.notNull(wac, "Cannot lookup handler method mappings without WebApplicationContext");
        try {
            return wac.getBean(org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.class);
        } catch (org.springframework.beans.factory.NoUniqueBeanDefinitionException ex) {
            throw new java.lang.IllegalStateException("More than one RequestMappingInfoHandlerMapping beans found", ex);
        } catch (org.springframework.beans.factory.NoSuchBeanDefinitionException ex) {
            throw new java.lang.IllegalStateException("No RequestMappingInfoHandlerMapping bean", ex);
        }
    }

    private static org.springframework.web.context.WebApplicationContext getWebApplicationContext() {
        org.springframework.web.context.request.RequestAttributes requestAttributes = org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7154, (requestAttributes == null))) {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.debug("No request bound to the current thread: not in a DispatcherServlet request?");
            return null;
        }
        javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes) (requestAttributes)).getRequest();
        org.springframework.web.context.WebApplicationContext wac = ((org.springframework.web.context.WebApplicationContext) (request.getAttribute(org.springframework.web.servlet.DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE)));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7155, (wac == null))) {
            org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.debug("No WebApplicationContext found: not in a DispatcherServlet request?");
            return null;
        }
        return wac;
    }

    public static <T> T on(java.lang.Class<T> controllerType) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.controller(controllerType);
    }

    public static <T> T controller(java.lang.Class<T> controllerType) {
        org.springframework.util.Assert.notNull(controllerType, "'controllerType' must not be null");
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.initProxy(controllerType, new org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor(controllerType));
    }

    @java.lang.SuppressWarnings("unchecked")
    private static <T> T initProxy(java.lang.Class<?> type, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.ControllerMethodInvocationInterceptor interceptor) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7156, type.isInterface())) {
            org.springframework.aop.framework.ProxyFactory factory = new org.springframework.aop.framework.ProxyFactory(org.springframework.aop.target.EmptyTargetSource.INSTANCE);
            factory.addInterface(type);
            factory.addInterface(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class);
            factory.addAdvice(interceptor);
            return ((T) (factory.getProxy()));
        }else {
            org.springframework.cglib.proxy.Enhancer enhancer = new org.springframework.cglib.proxy.Enhancer();
            enhancer.setSuperclass(type);
            enhancer.setInterfaces(new java.lang.Class<?>[]{ org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodInvocationInfo.class });
            enhancer.setNamingPolicy(org.springframework.cglib.core.SpringNamingPolicy.INSTANCE);
            enhancer.setCallbackType(org.springframework.cglib.proxy.MethodInterceptor.class);
            java.lang.Class<?> proxyClass = enhancer.createClass();
            java.lang.Object proxy = null;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7157, org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.objenesis.isWorthTrying())) {
                try {
                    proxy = org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.objenesis.newInstance(proxyClass, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7158, enhancer.getUseCache()));
                } catch (org.springframework.objenesis.ObjenesisException ex) {
                    org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.logger.debug(("Unable to instantiate controller proxy using Objenesis, " + "falling back to regular construction"), ex);
                }
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7159, (proxy == null))) {
                try {
                    proxy = proxyClass.newInstance();
                } catch (java.lang.Throwable ex) {
                    throw new java.lang.IllegalStateException(("Unable to instantiate controller proxy using Objenesis, " + "and regular controller instantiation via default constructor fails as well"), ex);
                }
            }
            ((org.springframework.cglib.proxy.Factory) (proxy)).setCallbacks(new org.springframework.cglib.proxy.Callback[]{ interceptor });
            return ((T) (proxy));
        }
    }

    public org.springframework.web.util.UriComponentsBuilder withController(java.lang.Class<?> controllerType) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromController(this.baseUrl, controllerType);
    }

    public org.springframework.web.util.UriComponentsBuilder withMethodName(java.lang.Class<?> controllerType, java.lang.String methodName, java.lang.Object... args) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodName(this.baseUrl, controllerType, methodName, args);
    }

    public org.springframework.web.util.UriComponentsBuilder withMethodCall(java.lang.Object invocationInfo) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethodCall(this.baseUrl, invocationInfo);
    }

    public org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.MethodArgumentBuilder withMappingName(java.lang.String mappingName) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMappingName(this.baseUrl, mappingName);
    }

    public org.springframework.web.util.UriComponentsBuilder withMethod(java.lang.Class<?> controllerType, java.lang.reflect.Method method, java.lang.Object... args) {
        return org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.fromMethod(this.baseUrl, controllerType, method, args);
    }

    public static perturbation.location.PerturbationLocation __L7095;

    public static perturbation.location.PerturbationLocation __L7096;

    public static perturbation.location.PerturbationLocation __L7097;

    public static perturbation.location.PerturbationLocation __L7098;

    public static perturbation.location.PerturbationLocation __L7099;

    public static perturbation.location.PerturbationLocation __L7100;

    public static perturbation.location.PerturbationLocation __L7101;

    public static perturbation.location.PerturbationLocation __L7102;

    public static perturbation.location.PerturbationLocation __L7103;

    public static perturbation.location.PerturbationLocation __L7104;

    public static perturbation.location.PerturbationLocation __L7105;

    public static perturbation.location.PerturbationLocation __L7106;

    public static perturbation.location.PerturbationLocation __L7107;

    public static perturbation.location.PerturbationLocation __L7108;

    public static perturbation.location.PerturbationLocation __L7109;

    public static perturbation.location.PerturbationLocation __L7110;

    public static perturbation.location.PerturbationLocation __L7111;

    public static perturbation.location.PerturbationLocation __L7112;

    public static perturbation.location.PerturbationLocation __L7113;

    public static perturbation.location.PerturbationLocation __L7114;

    public static perturbation.location.PerturbationLocation __L7115;

    public static perturbation.location.PerturbationLocation __L7116;

    public static perturbation.location.PerturbationLocation __L7117;

    public static perturbation.location.PerturbationLocation __L7118;

    public static perturbation.location.PerturbationLocation __L7119;

    public static perturbation.location.PerturbationLocation __L7120;

    public static perturbation.location.PerturbationLocation __L7121;

    public static perturbation.location.PerturbationLocation __L7122;

    public static perturbation.location.PerturbationLocation __L7123;

    public static perturbation.location.PerturbationLocation __L7124;

    public static perturbation.location.PerturbationLocation __L7125;

    public static perturbation.location.PerturbationLocation __L7126;

    public static perturbation.location.PerturbationLocation __L7127;

    public static perturbation.location.PerturbationLocation __L7128;

    public static perturbation.location.PerturbationLocation __L7129;

    public static perturbation.location.PerturbationLocation __L7130;

    public static perturbation.location.PerturbationLocation __L7131;

    public static perturbation.location.PerturbationLocation __L7132;

    public static perturbation.location.PerturbationLocation __L7133;

    public static perturbation.location.PerturbationLocation __L7134;

    public static perturbation.location.PerturbationLocation __L7135;

    public static perturbation.location.PerturbationLocation __L7136;

    public static perturbation.location.PerturbationLocation __L7137;

    public static perturbation.location.PerturbationLocation __L7138;

    public static perturbation.location.PerturbationLocation __L7139;

    public static perturbation.location.PerturbationLocation __L7140;

    public static perturbation.location.PerturbationLocation __L7141;

    public static perturbation.location.PerturbationLocation __L7142;

    public static perturbation.location.PerturbationLocation __L7143;

    public static perturbation.location.PerturbationLocation __L7144;

    public static perturbation.location.PerturbationLocation __L7145;

    public static perturbation.location.PerturbationLocation __L7146;

    public static perturbation.location.PerturbationLocation __L7147;

    public static perturbation.location.PerturbationLocation __L7148;

    public static perturbation.location.PerturbationLocation __L7149;

    public static perturbation.location.PerturbationLocation __L7150;

    public static perturbation.location.PerturbationLocation __L7151;

    public static perturbation.location.PerturbationLocation __L7152;

    public static perturbation.location.PerturbationLocation __L7153;

    public static perturbation.location.PerturbationLocation __L7154;

    public static perturbation.location.PerturbationLocation __L7155;

    public static perturbation.location.PerturbationLocation __L7156;

    public static perturbation.location.PerturbationLocation __L7157;

    public static perturbation.location.PerturbationLocation __L7158;

    public static perturbation.location.PerturbationLocation __L7159;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:358)", 7095, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:361)", 7096, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:361)", 7097, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:361)", 7098, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:365)", 7099, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:407)", 7100, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:434)", 7101, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:450)", 7102, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:453)", 7103, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:460)", 7104, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:460)", 7105, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:460)", 7106, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:460)", 7107, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:463)", 7108, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:463)", 7109, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:463)", 7110, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:463)", 7111, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:463)", 7112, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:466)", 7113, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:477)", 7114, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:480)", 7115, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:487)", 7116, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:487)", 7117, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:487)", 7118, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:487)", 7119, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:490)", 7120, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:490)", 7121, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:490)", 7122, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:490)", 7123, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:490)", 7124, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:493)", 7125, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:501)", 7126, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:502)", 7127, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:502)", 7128, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:502)", 7129, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:502)", 7130, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:502)", 7131, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:506)", 7132, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:506)", 7133, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:506)", 7134, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:509)", 7135, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:509)", 7136, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:509)", 7137, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:522)", 7138, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:527)", 7139, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:528)", 7140, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:529)", 7141, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:529)", 7142, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:529)", 7143, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:535)", 7144, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:535)", 7145, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:535)", 7146, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:535)", 7147, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:535)", 7148, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:536)", 7149, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:538)", 7150, "Numerical");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:545)", 7151, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:552)", 7152, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:559)", 7153, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:583)", 7154, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:591)", 7155, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:639)", 7156, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:657)", 7157, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:659)", 7158, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.__L7159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkMvcUriComponentsBuilder.java:667)", 7159, "Boolean");
    }

    static {
        defaultUriComponentsContributor = new org.springframework.web.method.support.CompositeUriComponentsContributor(new org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver(), new org.springframework.web.method.annotation.RequestParamMethodArgumentResolver(false));
    }

    static {
        org.broadleafcommerce.common.web.controller.FrameworkMvcUriComponentsBuilder.initPerturbationLocation0();
    }
}

