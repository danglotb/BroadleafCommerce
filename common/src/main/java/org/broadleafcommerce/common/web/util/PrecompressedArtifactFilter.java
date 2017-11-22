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
package org.broadleafcommerce.common.web.util;


public class PrecompressedArtifactFilter extends org.springframework.web.filter.GenericFilterBean {
    private boolean useWhileInDefaultEnvironment = true;

    @javax.annotation.Resource(name = "blPrecompressedArtifactFileExtensionWhitelist")
    java.util.List<java.lang.String> fileExtensionWhitelist;

    @javax.annotation.Resource
    org.springframework.core.env.Environment environment;

    @java.lang.Override
    public void doFilter(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse, javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        javax.servlet.http.HttpServletRequest request = ((javax.servlet.http.HttpServletRequest) (servletRequest));
        javax.servlet.http.HttpServletResponse response = ((javax.servlet.http.HttpServletResponse) (servletResponse));
        checkOutput : {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7628, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7626, org.apache.commons.lang.ArrayUtils.isNotEmpty(environment.getActiveProfiles()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7627, useWhileInDefaultEnvironment))))) {
                java.lang.String path = getResourcePath(request);
                java.lang.String gzipPath = path + ".gz";
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7629, useGzipCompression(request, response, path, gzipPath))) {
                    java.io.File output = new java.io.File(getServletContext().getRealPath(gzipPath));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7630, output.exists())) {
                        response.addHeader("Content-Encoding", "gzip");
                        javax.servlet.ServletOutputStream sos = servletResponse.getOutputStream();
                        java.io.BufferedInputStream bis = null;
                        try {
                            bis = new java.io.BufferedInputStream(new java.io.FileInputStream(output));
                            boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7631, false);
                            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7633, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7632, eof))))) {
                                int temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7634, bis.read());
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7637, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7635, temp)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7636, 0))))) {
                                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7638, true);
                                }else {
                                    sos.write(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7639, temp));
                                }
                            } 
                        } finally {
                            sos.flush();
                            try {
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7640, (bis != null))) {
                                    bis.close();
                                }
                            } catch (java.lang.Exception e) {
                            }
                        }
                        break checkOutput;
                    }
                }
            }
            chain.doFilter(request, response);
        }
    }

    public java.lang.String getResourcePath(javax.servlet.http.HttpServletRequest request) {
        java.lang.String path = ((java.lang.String) (request.getAttribute("javax.servlet.include.servlet_path")));
        java.lang.String info = ((java.lang.String) (request.getAttribute("javax.servlet.include.path_info")));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7641, (path == null))) {
            path = request.getServletPath();
            info = request.getPathInfo();
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7642, (info != null))) {
            path += info;
        }
        return path;
    }

    protected boolean useGzipCompression(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, java.lang.String path, java.lang.String gzipPath) throws java.net.MalformedURLException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7643, (gzipPath == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7644, false);
        }
        java.lang.String temp = path.toLowerCase();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7646, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7645, fileExtensionInWhitelist(temp)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7647, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7648, ((getServletContext().getResource(gzipPath)) == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7649, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7650, response.containsHeader("Content-Encoding"))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7651, false);
        }
        java.lang.String s = request.getParameter("gzip");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7652, "false".equals(s))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7653, false);
        }
        java.util.Enumeration<?> e = request.getHeaders("Accept-Encoding");
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7654, e.hasMoreElements())) {
            java.lang.String name = ((java.lang.String) (e.nextElement()));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7655, name.contains("gzip"))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7656, true);
            }
        } 
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7657, true);
    }

    protected boolean fileExtensionInWhitelist(java.lang.String path) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7661, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7658, (path == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7660, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7659, path.contains("."))))))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7662, false);
        }
        path = path.toLowerCase();
        boolean inWhitelist = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7663, false);
        for (java.lang.String validFileExtension : fileExtensionWhitelist) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7664, path.endsWith(validFileExtension))) {
                inWhitelist = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7665, true);
                break;
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7666, inWhitelist);
    }

    public boolean isUseWhileInDefaultEnvironment() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7667, useWhileInDefaultEnvironment);
    }

    public void setUseWhileInDefaultEnvironment(boolean useWhileInDefaultEnvironment) {
        this.useWhileInDefaultEnvironment = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7668, useWhileInDefaultEnvironment);
    }

    public static perturbation.location.PerturbationLocation __L7626;

    public static perturbation.location.PerturbationLocation __L7627;

    public static perturbation.location.PerturbationLocation __L7628;

    public static perturbation.location.PerturbationLocation __L7629;

    public static perturbation.location.PerturbationLocation __L7630;

    public static perturbation.location.PerturbationLocation __L7631;

    public static perturbation.location.PerturbationLocation __L7632;

    public static perturbation.location.PerturbationLocation __L7633;

    public static perturbation.location.PerturbationLocation __L7634;

    public static perturbation.location.PerturbationLocation __L7635;

    public static perturbation.location.PerturbationLocation __L7636;

    public static perturbation.location.PerturbationLocation __L7637;

    public static perturbation.location.PerturbationLocation __L7638;

    public static perturbation.location.PerturbationLocation __L7639;

    public static perturbation.location.PerturbationLocation __L7640;

    public static perturbation.location.PerturbationLocation __L7641;

    public static perturbation.location.PerturbationLocation __L7642;

    public static perturbation.location.PerturbationLocation __L7643;

    public static perturbation.location.PerturbationLocation __L7644;

    public static perturbation.location.PerturbationLocation __L7645;

    public static perturbation.location.PerturbationLocation __L7646;

    public static perturbation.location.PerturbationLocation __L7647;

    public static perturbation.location.PerturbationLocation __L7648;

    public static perturbation.location.PerturbationLocation __L7649;

    public static perturbation.location.PerturbationLocation __L7650;

    public static perturbation.location.PerturbationLocation __L7651;

    public static perturbation.location.PerturbationLocation __L7652;

    public static perturbation.location.PerturbationLocation __L7653;

    public static perturbation.location.PerturbationLocation __L7654;

    public static perturbation.location.PerturbationLocation __L7655;

    public static perturbation.location.PerturbationLocation __L7656;

    public static perturbation.location.PerturbationLocation __L7657;

    public static perturbation.location.PerturbationLocation __L7658;

    public static perturbation.location.PerturbationLocation __L7659;

    public static perturbation.location.PerturbationLocation __L7660;

    public static perturbation.location.PerturbationLocation __L7661;

    public static perturbation.location.PerturbationLocation __L7662;

    public static perturbation.location.PerturbationLocation __L7663;

    public static perturbation.location.PerturbationLocation __L7664;

    public static perturbation.location.PerturbationLocation __L7665;

    public static perturbation.location.PerturbationLocation __L7666;

    public static perturbation.location.PerturbationLocation __L7667;

    public static perturbation.location.PerturbationLocation __L7668;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:59)", 7626, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:59)", 7627, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:59)", 7628, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:62)", 7629, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:64)", 7630, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:70)", 7631, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:71)", 7632, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:71)", 7633, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:72)", 7634, "Numerical");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:73)", 7635, "Numerical");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:73)", 7636, "Numerical");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:73)", 7637, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:74)", 7638, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:76)", 7639, "Numerical");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:82)", 7640, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:123)", 7641, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:128)", 7642, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:146)", 7643, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:147)", 7644, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:152)", 7645, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:152)", 7646, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:153)", 7647, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:156)", 7648, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:157)", 7649, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:161)", 7650, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:162)", 7651, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:167)", 7652, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:168)", 7653, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:173)", 7654, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:175)", 7655, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:176)", 7656, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:180)", 7657, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:184)", 7658, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:184)", 7659, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:184)", 7660, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:184)", 7661, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:185)", 7662, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:189)", 7663, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:192)", 7664, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:193)", 7665, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:198)", 7666, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:202)", 7667, "Boolean");
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.__L7668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/util/PrecompressedArtifactFilter.java:206)", 7668, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.util.PrecompressedArtifactFilter.initPerturbationLocation0();
    }
}

