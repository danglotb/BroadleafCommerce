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
package org.broadleafcommerce.common.web.boot.support;


public class SpringBootBootstrappingServletContextListener implements javax.servlet.ServletContextListener {
    public static final java.lang.String APPLICATION_CLASS = "listenerContextInitializerClass";

    protected org.springframework.web.context.ContextLoaderListener delegateListener;

    @java.lang.Override
    public void contextInitialized(javax.servlet.ServletContextEvent event) {
        try {
            javax.servlet.ServletContext servletContext = event.getServletContext();
            java.lang.Class<org.springframework.web.WebApplicationInitializer> initializerClass = getInitializerClass(servletContext);
            org.springframework.web.WebApplicationInitializer initializer = createInitializer(initializerClass);
            initializer.onStartup(servletContext);
            org.springframework.web.context.WebApplicationContext rootContext = ((org.springframework.web.context.WebApplicationContext) (servletContext.getAttribute(org.springframework.web.context.WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE)));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7048, (rootContext != null))) {
                delegateListener = new org.springframework.web.context.ContextLoaderListener(rootContext) {
                    @java.lang.Override
                    public void contextInitialized(javax.servlet.ServletContextEvent event) {
                    }
                };
            }
        } catch (javax.servlet.ServletException | java.lang.ClassNotFoundException | java.lang.LinkageError | java.security.PrivilegedActionException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @java.lang.Override
    public void contextDestroyed(javax.servlet.ServletContextEvent event) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7049, ((delegateListener) != null))) {
            delegateListener.contextDestroyed(event);
        }
    }

    @java.lang.SuppressWarnings("unchecked")
    protected java.lang.Class<org.springframework.web.WebApplicationInitializer> getInitializerClass(javax.servlet.ServletContext ctx) throws java.lang.ClassNotFoundException, java.lang.LinkageError {
        java.lang.String clazz = ctx.getInitParameter(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.APPLICATION_CLASS);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7050, org.apache.commons.lang3.StringUtils.isBlank(clazz))) {
            throw new java.lang.IllegalStateException(java.lang.String.format("A %s context-param must be defined that points to your main @SpringBootApplicatino class", org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.APPLICATION_CLASS));
        }
        java.lang.Class<?> initializerClass = org.springframework.util.ClassUtils.forName(clazz, this.getClass().getClassLoader());
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7052, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7051, org.springframework.web.WebApplicationInitializer.class.isAssignableFrom(initializerClass)))))) {
            throw new java.lang.IllegalStateException(java.lang.String.format("The %s context-param must be an instance of ServletContextInitializer. Consider extending from %s", org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.APPLICATION_CLASS, org.broadleafcommerce.common.web.boot.support.BroadleafBootServletContextInitializer.class.getName()));
        }
        return ((java.lang.Class<org.springframework.web.WebApplicationInitializer>) (initializerClass));
    }

    protected org.springframework.web.WebApplicationInitializer createInitializer(final java.lang.Class<org.springframework.web.WebApplicationInitializer> initializerClass) throws java.security.PrivilegedActionException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7053, ((java.lang.System.getSecurityManager()) != null))) {
            return java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<org.springframework.web.WebApplicationInitializer>() {
                @java.lang.Override
                public org.springframework.web.WebApplicationInitializer run() {
                    return org.springframework.beans.BeanUtils.instantiateClass(initializerClass);
                }
            }, java.security.AccessController.getContext());
        }else {
            return org.springframework.beans.BeanUtils.instantiate(initializerClass);
        }
    }

    public static perturbation.location.PerturbationLocation __L7048;

    public static perturbation.location.PerturbationLocation __L7049;

    public static perturbation.location.PerturbationLocation __L7050;

    public static perturbation.location.PerturbationLocation __L7051;

    public static perturbation.location.PerturbationLocation __L7052;

    public static perturbation.location.PerturbationLocation __L7053;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/boot/support/SpringBootBootstrappingServletContextListener.java:94)", 7048, "Boolean");
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/boot/support/SpringBootBootstrappingServletContextListener.java:109)", 7049, "Boolean");
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/boot/support/SpringBootBootstrappingServletContextListener.java:117)", 7050, "Boolean");
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/boot/support/SpringBootBootstrappingServletContextListener.java:121)", 7051, "Boolean");
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/boot/support/SpringBootBootstrappingServletContextListener.java:121)", 7052, "Boolean");
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.__L7053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/boot/support/SpringBootBootstrappingServletContextListener.java:129)", 7053, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.boot.support.SpringBootBootstrappingServletContextListener.initPerturbationLocation0();
    }
}

