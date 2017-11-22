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


@org.springframework.stereotype.Component
public class FrameworkControllerHandlerMapping extends org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping {
    public static final int REQUEST_MAPPING_ORDER = (org.springframework.core.Ordered.LOWEST_PRECEDENCE) - 2;

    public FrameworkControllerHandlerMapping() {
        setOrder(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.REQUEST_MAPPING_ORDER);
    }

    @java.lang.Override
    protected boolean isHandler(java.lang.Class<?> beanType) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7082, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7080, ((beanType.getAnnotation(org.broadleafcommerce.common.web.controller.annotation.FrameworkController.class)) != null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7081, ((beanType.getAnnotation(org.broadleafcommerce.common.web.controller.annotation.FrameworkRestController.class)) != null)))));
    }

    @java.lang.Override
    protected org.springframework.web.servlet.mvc.method.RequestMappingInfo getMappingForMethod(java.lang.reflect.Method method, java.lang.Class<?> handlerType) {
        org.springframework.web.servlet.mvc.method.RequestMappingInfo requestMappingInfo = createRequestMappingInfo(method);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7083, (requestMappingInfo != null))) {
            org.springframework.web.servlet.mvc.method.RequestMappingInfo typeInfo = createRequestMappingInfo(handlerType);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7084, (typeInfo != null))) {
                requestMappingInfo = typeInfo.combine(requestMappingInfo);
            }
        }
        return requestMappingInfo;
    }

    private org.springframework.web.servlet.mvc.method.RequestMappingInfo createRequestMappingInfo(java.lang.reflect.AnnotatedElement element) {
        org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping frameworkMapping = element.getAnnotation(org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping.class);
        frameworkMapping = org.springframework.core.annotation.AnnotationUtils.synthesizeAnnotation(frameworkMapping, null);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7085, (frameworkMapping != null)) ? createRequestMappingInfo(convertFrameworkMappingToRequestMapping(frameworkMapping), null) : null;
    }

    private org.springframework.web.bind.annotation.RequestMapping convertFrameworkMappingToRequestMapping(final org.broadleafcommerce.common.web.controller.annotation.FrameworkMapping frameworkMapping) {
        return new org.springframework.web.bind.annotation.RequestMapping() {
            @java.lang.Override
            public java.lang.String name() {
                return frameworkMapping.name();
            }

            @java.lang.Override
            public java.lang.String[] value() {
                return frameworkMapping.value();
            }

            @java.lang.Override
            public java.lang.String[] path() {
                return frameworkMapping.path();
            }

            @java.lang.Override
            public org.springframework.web.bind.annotation.RequestMethod[] method() {
                return frameworkMapping.method();
            }

            @java.lang.Override
            public java.lang.String[] params() {
                return frameworkMapping.params();
            }

            @java.lang.Override
            public java.lang.String[] headers() {
                return frameworkMapping.headers();
            }

            @java.lang.Override
            public java.lang.String[] consumes() {
                return frameworkMapping.consumes();
            }

            @java.lang.Override
            public java.lang.String[] produces() {
                return frameworkMapping.produces();
            }

            @java.lang.Override
            public java.lang.Class<? extends java.lang.annotation.Annotation> annotationType() {
                return org.springframework.web.bind.annotation.RequestMapping.class;
            }
        };
    }

    public static perturbation.location.PerturbationLocation __L7080;

    public static perturbation.location.PerturbationLocation __L7081;

    public static perturbation.location.PerturbationLocation __L7082;

    public static perturbation.location.PerturbationLocation __L7083;

    public static perturbation.location.PerturbationLocation __L7084;

    public static perturbation.location.PerturbationLocation __L7085;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkControllerHandlerMapping.java:84)", 7080, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkControllerHandlerMapping.java:84)", 7081, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkControllerHandlerMapping.java:84)", 7082, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkControllerHandlerMapping.java:91)", 7083, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkControllerHandlerMapping.java:93)", 7084, "Boolean");
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.__L7085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/controller/FrameworkControllerHandlerMapping.java:104)", 7085, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.controller.FrameworkControllerHandlerMapping.initPerturbationLocation0();
    }
}

