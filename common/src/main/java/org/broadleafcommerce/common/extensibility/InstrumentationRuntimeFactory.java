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
package org.broadleafcommerce.common.extensibility;


@java.lang.Deprecated
public class InstrumentationRuntimeFactory {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.class);

    private static final java.lang.String IBM_VM_CLASS = "com.ibm.tools.attach.VirtualMachine";

    private static final java.lang.String SUN_VM_CLASS = "com.sun.tools.attach.VirtualMachine";

    private static boolean isIBM = false;

    private static java.lang.instrument.Instrumentation inst;

    public static void agentmain(java.lang.String agentArgs, java.lang.instrument.Instrumentation instrumentation) {
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.inst = instrumentation;
    }

    public static synchronized java.lang.instrument.Instrumentation getInstrumentation() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2386, ((org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.inst) != null))) {
            return org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.inst;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2387, java.lang.System.getProperty("java.vendor").toUpperCase().contains("IBM"))) {
            org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.isIBM = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2388, true);
        }
        java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java.lang.Object>() {
            public java.lang.Object run() {
                try {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2390, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2389, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.class.getClassLoader().equals(java.lang.ClassLoader.getSystemClassLoader())))))) {
                        return null;
                    }
                } catch (java.lang.Throwable t) {
                    return null;
                }
                java.io.File toolsJar = null;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2392, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2391, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.isIBM))))) {
                    toolsJar = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.findToolsJar();
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2393, (toolsJar == null))) {
                        return null;
                    }
                }
                java.lang.Class<?> vmClass = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.loadVMClass(toolsJar);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2394, (vmClass == null))) {
                    return null;
                }
                java.lang.String agentPath = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.getAgentJar();
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2395, (agentPath == null))) {
                    return null;
                }
                org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.loadAgent(agentPath, vmClass);
                return null;
            }
        });
        return org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.inst;
    }

    private static java.io.File findToolsJar() {
        java.lang.String javaHome = java.lang.System.getProperty("java.home");
        java.io.File javaHomeFile = new java.io.File(javaHome);
        java.io.File toolsJarFile = new java.io.File(javaHomeFile, (("lib" + (java.io.File.separator)) + "tools.jar"));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2397, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2396, toolsJarFile.exists()))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2398, javaHomeFile.getAbsolutePath().endsWith(((java.io.File.separator) + "jre")))) {
                javaHomeFile = javaHomeFile.getParentFile();
                toolsJarFile = new java.io.File(javaHomeFile, (("lib" + (java.io.File.separator)) + "tools.jar"));
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2399, java.lang.System.getProperty("os.name").toLowerCase().contains("mac"))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2400, javaHomeFile.getAbsolutePath().endsWith(((java.io.File.separator) + "Home")))) {
                        javaHomeFile = javaHomeFile.getParentFile();
                        toolsJarFile = new java.io.File(javaHomeFile, (("Classes" + (java.io.File.separator)) + "classes.jar"));
                    }
                }

        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2402, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2401, toolsJarFile.exists()))))) {
            return null;
        }else {
            return toolsJarFile;
        }
    }

    private static java.lang.String createAgentJar() throws java.io.IOException {
        java.io.File file = java.io.File.createTempFile(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.class.getName(), ".jar");
        file.deleteOnExit();
        java.util.zip.ZipOutputStream zout = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(file));
        zout.putNextEntry(new java.util.zip.ZipEntry("META-INF/MANIFEST.MF"));
        java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.OutputStreamWriter(zout));
        writer.println(("Agent-Class: " + (org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.class.getName())));
        writer.println("Can-Redefine-Classes: true");
        writer.println(("Can-Retransform-Classes: " + (java.lang.Boolean.toString(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2404, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2403, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.isIBM))))))));
        writer.close();
        return file.getAbsolutePath();
    }

    private static java.lang.String getAgentJar() {
        java.io.File agentJarFile = null;
        java.security.CodeSource cs = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.class.getProtectionDomain().getCodeSource();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2405, (cs != null))) {
            java.net.URL loc = cs.getLocation();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2406, (loc != null))) {
                agentJarFile = new java.io.File(loc.getFile());
            }
        }
        boolean createJar = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2407, false);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2412, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2410, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2408, (cs == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2409, (agentJarFile == null)))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2411, agentJarFile.isDirectory()))))) {
            createJar = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2413, true);
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2415, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2414, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.validateAgentJarManifest(agentJarFile, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.class.getName())))))) {
                createJar = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2416, true);
            }

        java.lang.String agentJar;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2417, createJar)) {
            try {
                agentJar = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.createAgentJar();
            } catch (java.io.IOException ioe) {
                agentJar = null;
            }
        }else {
            agentJar = agentJarFile.getAbsolutePath();
        }
        return agentJar;
    }

    private static void loadAgent(java.lang.String agentJar, java.lang.Class<?> vmClass) {
        try {
            java.lang.management.RuntimeMXBean runtime = java.lang.management.ManagementFactory.getRuntimeMXBean();
            java.lang.String pid = runtime.getName();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2418, pid.contains("@")))
                pid = pid.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2419, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2420, pid.indexOf("@")));

            java.lang.Object vm = vmClass.getMethod("attach", new java.lang.Class<?>[]{ java.lang.String.class }).invoke(null, pid);
            vmClass.getMethod("loadAgent", new java.lang.Class[]{ java.lang.String.class }).invoke(vm, agentJar);
            vmClass.getMethod("detach", new java.lang.Class[]{  }).invoke(vm);
        } catch (java.lang.Throwable t) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2421, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.LOG.trace("Problem loading the agent", t);
            }
        }
    }

    private static java.lang.Class<?> loadVMClass(java.io.File toolsJar) {
        try {
            java.lang.ClassLoader loader = java.lang.Thread.currentThread().getContextClassLoader();
            java.lang.String cls = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.SUN_VM_CLASS;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2422, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.isIBM)) {
                cls = org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.IBM_VM_CLASS;
            }else {
                loader = new java.net.URLClassLoader(new java.net.URL[]{ toolsJar.toURI().toURL() }, loader);
            }
            return loader.loadClass(cls);
        } catch (java.lang.Exception e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2423, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.LOG.trace("Failed to load the virtual machine class", e);
            }
        }
        return null;
    }

    private static boolean validateAgentJarManifest(java.io.File agentJarFile, java.lang.String agentClassName) {
        try {
            java.util.jar.JarFile jar = new java.util.jar.JarFile(agentJarFile);
            java.util.jar.Manifest manifest = jar.getManifest();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2424, (manifest == null))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2425, false);
            }
            java.util.jar.Attributes attributes = manifest.getMainAttributes();
            java.lang.String ac = attributes.getValue("Agent-Class");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2428, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2426, (ac != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2427, ac.equals(agentClassName)))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2429, true);
            }
        } catch (java.lang.Exception e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2430, org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.LOG.isTraceEnabled())) {
                org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.LOG.trace("Unexpected exception occured.", e);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2431, false);
    }

    public static perturbation.location.PerturbationLocation __L2386;

    public static perturbation.location.PerturbationLocation __L2387;

    public static perturbation.location.PerturbationLocation __L2388;

    public static perturbation.location.PerturbationLocation __L2389;

    public static perturbation.location.PerturbationLocation __L2390;

    public static perturbation.location.PerturbationLocation __L2391;

    public static perturbation.location.PerturbationLocation __L2392;

    public static perturbation.location.PerturbationLocation __L2393;

    public static perturbation.location.PerturbationLocation __L2394;

    public static perturbation.location.PerturbationLocation __L2395;

    public static perturbation.location.PerturbationLocation __L2396;

    public static perturbation.location.PerturbationLocation __L2397;

    public static perturbation.location.PerturbationLocation __L2398;

    public static perturbation.location.PerturbationLocation __L2399;

    public static perturbation.location.PerturbationLocation __L2400;

    public static perturbation.location.PerturbationLocation __L2401;

    public static perturbation.location.PerturbationLocation __L2402;

    public static perturbation.location.PerturbationLocation __L2403;

    public static perturbation.location.PerturbationLocation __L2404;

    public static perturbation.location.PerturbationLocation __L2405;

    public static perturbation.location.PerturbationLocation __L2406;

    public static perturbation.location.PerturbationLocation __L2407;

    public static perturbation.location.PerturbationLocation __L2408;

    public static perturbation.location.PerturbationLocation __L2409;

    public static perturbation.location.PerturbationLocation __L2410;

    public static perturbation.location.PerturbationLocation __L2411;

    public static perturbation.location.PerturbationLocation __L2412;

    public static perturbation.location.PerturbationLocation __L2413;

    public static perturbation.location.PerturbationLocation __L2414;

    public static perturbation.location.PerturbationLocation __L2415;

    public static perturbation.location.PerturbationLocation __L2416;

    public static perturbation.location.PerturbationLocation __L2417;

    public static perturbation.location.PerturbationLocation __L2418;

    public static perturbation.location.PerturbationLocation __L2419;

    public static perturbation.location.PerturbationLocation __L2420;

    public static perturbation.location.PerturbationLocation __L2421;

    public static perturbation.location.PerturbationLocation __L2422;

    public static perturbation.location.PerturbationLocation __L2423;

    public static perturbation.location.PerturbationLocation __L2424;

    public static perturbation.location.PerturbationLocation __L2425;

    public static perturbation.location.PerturbationLocation __L2426;

    public static perturbation.location.PerturbationLocation __L2427;

    public static perturbation.location.PerturbationLocation __L2428;

    public static perturbation.location.PerturbationLocation __L2429;

    public static perturbation.location.PerturbationLocation __L2430;

    public static perturbation.location.PerturbationLocation __L2431;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2386 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:77)", 2386, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2387 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:81)", 2387, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2388 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:82)", 2388, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2389 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:88)", 2389, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2390 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:88)", 2390, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2391 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:98)", 2391, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2392 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:98)", 2392, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2393 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:101)", 2393, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2394 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:107)", 2394, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2395 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:111)", 2395, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2396 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:127)", 2396, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2397 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:127)", 2397, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2398 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:129)", 2398, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2399 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:132)", 2399, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2400 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:134)", 2400, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2401 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:142)", 2401, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2402 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:142)", 2402, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2403 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:162)", 2403, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2404 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:162)", 2404, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2405 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:175)", 2405, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2406 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:177)", 2406, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2407 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:184)", 2407, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2408 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:185)", 2408, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2409 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:185)", 2409, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2410 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:185)", 2410, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2411 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:186)", 2411, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:185)", 2412, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:187)", 2413, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:188)", 2414, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:188)", 2415, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:190)", 2416, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:194)", 2417, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:217)", 2418, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:218)", 2419, "Numerical");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:218)", 2420, "Numerical");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:227)", 2421, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:237)", 2422, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:244)", 2423, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:256)", 2424, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:257)", 2425, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:261)", 2426, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:261)", 2427, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:261)", 2428, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:262)", 2429, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:265)", 2430, "Boolean");
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.__L2431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/InstrumentationRuntimeFactory.java:269)", 2431, "Boolean");
    }

    static {
        org.broadleafcommerce.common.extensibility.InstrumentationRuntimeFactory.initPerturbationLocation0();
    }
}

