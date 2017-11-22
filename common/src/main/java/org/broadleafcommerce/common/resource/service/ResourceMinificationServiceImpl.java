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
package org.broadleafcommerce.common.resource.service;


@org.springframework.stereotype.Service("blResourceMinificationService")
public class ResourceMinificationServiceImpl implements org.broadleafcommerce.common.resource.service.ResourceMinificationService {
    protected static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.class);

    public static java.lang.String CSS_TYPE = "css";

    public static java.lang.String JS_TYPE = "js";

    @org.springframework.beans.factory.annotation.Value("${minify.linebreak}")
    protected int linebreak;

    @org.springframework.beans.factory.annotation.Value("${minify.munge}")
    protected boolean munge;

    @org.springframework.beans.factory.annotation.Value("${minify.verbose}")
    protected boolean verbose;

    @org.springframework.beans.factory.annotation.Value("${minify.preserveAllSemiColons}")
    protected boolean preserveAllSemiColons;

    @org.springframework.beans.factory.annotation.Value("${minify.disableOptimizations}")
    protected boolean disableOptimizations;

    @java.lang.Override
    public boolean getEnabled() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4572, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("minify.enabled"));
    }

    @java.lang.Override
    public boolean getAllowSingleMinification() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4573, org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty("minify.allowSingleMinification"));
    }

    @java.lang.Override
    public byte[] minify(java.lang.String filename, byte[] bytes) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4575, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4574, getEnabled()))))) {
            org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.trace("Minification is disabled, returning original resource");
            return bytes;
        }
        org.springframework.core.io.Resource modifiedResource = minify(new org.springframework.core.io.ByteArrayResource(bytes), filename);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4576, (modifiedResource instanceof org.broadleafcommerce.common.resource.GeneratedResource))) {
            return ((org.broadleafcommerce.common.resource.GeneratedResource) (modifiedResource)).getBytes();
        }else {
            return bytes;
        }
    }

    @java.lang.Override
    public org.springframework.core.io.Resource minify(org.springframework.core.io.Resource originalResource) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4578, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4577, getEnabled()))))) {
            org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.trace("Minification is disabled, returning original resource");
            return originalResource;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4579, ((originalResource.getFilename()) == null))) {
            org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.warn("Attempted to modify resource without a filename, returning non-minified resource");
            return originalResource;
        }
        return minify(originalResource, originalResource.getFilename());
    }

    @java.lang.Override
    public org.springframework.core.io.Resource minify(org.springframework.core.io.Resource originalResource, java.lang.String filename) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4581, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4580, getEnabled()))))) {
            org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.trace("Minification is disabled, returning original resource");
            return originalResource;
        }
        java.lang.String type = getFileType(originalResource, filename);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4582, (type == null))) {
            org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.info(("Unsupported minification resource: " + filename));
            return originalResource;
        }
        byte[] minifiedBytes = null;
        try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(originalResource.getInputStream(), "utf-8"));java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.OutputStreamWriter(baos, "utf-8"))) {
            minify(in, out, filename, type);
            out.flush();
            minifiedBytes = baos.toByteArray();
        } catch (java.lang.Exception e) {
            org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.warn("Could not minify resources, returned unminified bytes", e);
            return originalResource;
        }
        return new org.broadleafcommerce.common.resource.GeneratedResource(minifiedBytes, filename);
    }

    protected void minify(java.io.BufferedReader in, java.io.BufferedWriter out, java.lang.String filename, java.lang.String type) throws java.io.IOException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4583, org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.JS_TYPE.equals(type))) {
            com.yahoo.platform.yui.compressor.JavaScriptCompressor jsc = new com.yahoo.platform.yui.compressor.JavaScriptCompressor(in, getLogBasedErrorReporter(filename));
            jsc.compress(out, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4584, linebreak), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4585, munge), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4586, verbose), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4587, preserveAllSemiColons), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4588, disableOptimizations));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4589, org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.CSS_TYPE.equals(type))) {
                com.yahoo.platform.yui.compressor.CssCompressor cssc = new com.yahoo.platform.yui.compressor.CssCompressor(in);
                cssc.compress(out, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4590, 100));
            }

    }

    protected java.lang.String getFileType(org.springframework.core.io.Resource originalResource, java.lang.String filename) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4591, filename.contains(".js"))) {
            return org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.JS_TYPE;
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4592, filename.contains(".css"))) {
                return org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.CSS_TYPE;
            }

        return null;
    }

    protected org.mozilla.javascript.ErrorReporter getLogBasedErrorReporter(final java.lang.String filename) {
        return new org.mozilla.javascript.ErrorReporter() {
            @java.lang.Override
            public void warning(java.lang.String message, java.lang.String sourceName, int line, java.lang.String lineSource, int lineOffset) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4595, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4593, line)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4594, 0))))) {
                    org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.warn(message);
                }else {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4596, (sourceName == null))) {
                        sourceName = filename;
                    }
                    org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.warn(((((((((sourceName + " - ") + lineSource) + " - ") + line) + ':') + lineOffset) + " - ") + message));
                }
            }

            @java.lang.Override
            public void error(java.lang.String message, java.lang.String sourceName, int line, java.lang.String lineSource, int lineOffset) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4599, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4597, line)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4598, 0))))) {
                    org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.error(message);
                }else {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4600, (sourceName == null))) {
                        sourceName = filename;
                    }
                    org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.LOG.error(((((((((sourceName + " - ") + lineSource) + " - ") + line) + ':') + lineOffset) + " - ") + message));
                }
            }

            @java.lang.Override
            public org.mozilla.javascript.EvaluatorException runtimeError(java.lang.String message, java.lang.String sourceName, int line, java.lang.String lineSource, int lineOffset) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4601, (sourceName == null))) {
                    sourceName = filename;
                }
                error(message, sourceName, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4602, line), lineSource, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4603, lineOffset));
                return new org.mozilla.javascript.EvaluatorException(message);
            }
        };
    }

    public static perturbation.location.PerturbationLocation __L4572;

    public static perturbation.location.PerturbationLocation __L4573;

    public static perturbation.location.PerturbationLocation __L4574;

    public static perturbation.location.PerturbationLocation __L4575;

    public static perturbation.location.PerturbationLocation __L4576;

    public static perturbation.location.PerturbationLocation __L4577;

    public static perturbation.location.PerturbationLocation __L4578;

    public static perturbation.location.PerturbationLocation __L4579;

    public static perturbation.location.PerturbationLocation __L4580;

    public static perturbation.location.PerturbationLocation __L4581;

    public static perturbation.location.PerturbationLocation __L4582;

    public static perturbation.location.PerturbationLocation __L4583;

    public static perturbation.location.PerturbationLocation __L4584;

    public static perturbation.location.PerturbationLocation __L4585;

    public static perturbation.location.PerturbationLocation __L4586;

    public static perturbation.location.PerturbationLocation __L4587;

    public static perturbation.location.PerturbationLocation __L4588;

    public static perturbation.location.PerturbationLocation __L4589;

    public static perturbation.location.PerturbationLocation __L4590;

    public static perturbation.location.PerturbationLocation __L4591;

    public static perturbation.location.PerturbationLocation __L4592;

    public static perturbation.location.PerturbationLocation __L4593;

    public static perturbation.location.PerturbationLocation __L4594;

    public static perturbation.location.PerturbationLocation __L4595;

    public static perturbation.location.PerturbationLocation __L4596;

    public static perturbation.location.PerturbationLocation __L4597;

    public static perturbation.location.PerturbationLocation __L4598;

    public static perturbation.location.PerturbationLocation __L4599;

    public static perturbation.location.PerturbationLocation __L4600;

    public static perturbation.location.PerturbationLocation __L4601;

    public static perturbation.location.PerturbationLocation __L4602;

    public static perturbation.location.PerturbationLocation __L4603;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:69)", 4572, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:74)", 4573, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:79)", 4574, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:79)", 4575, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:86)", 4576, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:95)", 4577, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:95)", 4578, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:100)", 4579, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:109)", 4580, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:109)", 4581, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:115)", 4582, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:139)", 4583, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:141)", 4584, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:141)", 4585, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:141)", 4586, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:141)", 4587, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:141)", 4588, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:142)", 4589, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:144)", 4590, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:155)", 4591, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:157)", 4592, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:167)", 4593, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:167)", 4594, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:167)", 4595, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:170)", 4596, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:179)", 4597, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:179)", 4598, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:179)", 4599, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:182)", 4600, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:192)", 4601, "Boolean");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:195)", 4602, "Numerical");
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.__L4603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/resource/service/ResourceMinificationServiceImpl.java:195)", 4603, "Numerical");
    }

    static {
        org.broadleafcommerce.common.resource.service.ResourceMinificationServiceImpl.initPerturbationLocation0();
    }
}

