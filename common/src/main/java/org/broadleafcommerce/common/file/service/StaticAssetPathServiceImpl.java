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
package org.broadleafcommerce.common.file.service;


@org.springframework.stereotype.Service("blStaticAssetPathService")
public class StaticAssetPathServiceImpl implements org.broadleafcommerce.common.file.service.StaticAssetPathService {
    @org.springframework.beans.factory.annotation.Value("${asset.server.url.prefix.internal}")
    protected java.lang.String staticAssetUrlPrefix;

    @org.springframework.beans.factory.annotation.Value("${asset.server.url.prefix}")
    protected java.lang.String staticAssetEnvironmentUrlPrefix;

    @org.springframework.beans.factory.annotation.Value("${asset.server.url.prefix.secure}")
    protected java.lang.String staticAssetEnvironmentSecureUrlPrefix;

    @java.lang.Override
    public java.lang.String convertAllAssetPathsInContent(java.lang.String content, boolean secureRequest) {
        java.lang.String returnValue = content;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2679, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2677, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2675, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2673, org.apache.commons.lang.StringUtils.isNotBlank(content))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2674, org.apache.commons.lang.StringUtils.isNotBlank(getStaticAssetUrlPrefix())))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2676, org.apache.commons.lang.StringUtils.isNotBlank(getStaticAssetEnvironmentUrlPrefix())))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2678, content.contains(getStaticAssetUrlPrefix())))))) {
            final java.lang.String envPrefix;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2680, secureRequest)) {
                envPrefix = getStaticAssetEnvironmentSecureUrlPrefix();
            }else {
                envPrefix = getStaticAssetEnvironmentUrlPrefix();
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2681, (envPrefix != null))) {
                java.lang.String trailing = "";
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2682, envPrefix.endsWith(java.io.File.separator))) {
                    trailing = java.io.File.separator;
                }
                returnValue = returnValue.replaceAll(((getStaticAssetUrlPrefix()) + trailing), envPrefix);
                returnValue = returnValue.replaceAll(((java.io.File.separator) + envPrefix), envPrefix);
            }
        }
        return returnValue;
    }

    @java.lang.Override
    public java.lang.String convertAssetPath(java.lang.String assetPath, java.lang.String contextPath, boolean secureRequest) {
        java.lang.String returnValue = assetPath;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2688, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2685, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2683, (assetPath != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2684, ((getStaticAssetEnvironmentUrlPrefix()) != null)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2687, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2686, "".equals(getStaticAssetEnvironmentUrlPrefix()))))))))) {
            java.lang.String envPrefix;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2689, secureRequest)) {
                envPrefix = getStaticAssetEnvironmentSecureUrlPrefix();
            }else {
                envPrefix = getStaticAssetEnvironmentUrlPrefix();
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2690, (envPrefix != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2691, returnValue.startsWith("/"))) {
                    returnValue = returnValue.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2692, 1));
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2693, returnValue.startsWith(getStaticAssetUrlPrefix()))) {
                    returnValue = returnValue.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2694, getStaticAssetUrlPrefix().trim().length()));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2695, returnValue.startsWith("/"))) {
                        returnValue = returnValue.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2696, 1));
                    }
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2697, envPrefix.endsWith(((getStaticAssetUrlPrefix()) + "/")))) {
                        envPrefix = envPrefix.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2698, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2703, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2701, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2699, envPrefix.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2700, getStaticAssetUrlPrefix().length()))))) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2702, 1)))));
                    }

                returnValue = envPrefix + returnValue;
            }
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2707, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2704, (returnValue != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2706, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2705, org.apache.velocity.tools.view.ImportSupport.isAbsoluteUrl(returnValue))))))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2709, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2708, returnValue.startsWith("/")))))) {
                    returnValue = "/" + returnValue;
                }
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2713, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2710, (contextPath != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2712, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2711, contextPath.equals(""))))))))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2715, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2714, contextPath.equals("/")))))) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2716, contextPath.endsWith("/"))) {
                            returnValue = returnValue.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2717, 1));
                        }
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2718, contextPath.startsWith("/"))) {
                            returnValue = contextPath + returnValue;
                        }else {
                            returnValue = ("/" + contextPath) + returnValue;
                        }
                    }
                }
            }
        }
        return returnValue;
    }

    @java.lang.Override
    public java.lang.String getStaticAssetUrlPrefix() {
        return staticAssetUrlPrefix;
    }

    @java.lang.Override
    public void setStaticAssetUrlPrefix(java.lang.String staticAssetUrlPrefix) {
        this.staticAssetUrlPrefix = staticAssetUrlPrefix;
    }

    @java.lang.Override
    public java.lang.String getStaticAssetEnvironmentUrlPrefix() {
        return fixEnvironmentUrlPrefix(staticAssetEnvironmentUrlPrefix);
    }

    @java.lang.Override
    public void setStaticAssetEnvironmentUrlPrefix(java.lang.String staticAssetEnvironmentUrlPrefix) {
        this.staticAssetEnvironmentUrlPrefix = staticAssetEnvironmentUrlPrefix;
    }

    @java.lang.Override
    public java.lang.String getStaticAssetEnvironmentSecureUrlPrefix() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2719, org.apache.commons.lang.StringUtils.isEmpty(staticAssetEnvironmentSecureUrlPrefix))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2725, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2721, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2720, org.apache.commons.lang.StringUtils.isEmpty(staticAssetEnvironmentUrlPrefix)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2724, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2722, staticAssetEnvironmentUrlPrefix.indexOf("http:"))) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2723, 0)))))))) {
                staticAssetEnvironmentSecureUrlPrefix = staticAssetEnvironmentUrlPrefix.replace("http:", "https:");
            }
        }
        return fixEnvironmentUrlPrefix(staticAssetEnvironmentSecureUrlPrefix);
    }

    public void setStaticAssetEnvironmentSecureUrlPrefix(java.lang.String staticAssetEnvironmentSecureUrlPrefix) {
        this.staticAssetEnvironmentSecureUrlPrefix = staticAssetEnvironmentSecureUrlPrefix;
    }

    private java.lang.String fixEnvironmentUrlPrefix(java.lang.String urlPrefix) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2726, (urlPrefix != null))) {
            urlPrefix = urlPrefix.trim();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2727, "".equals(urlPrefix))) {
                urlPrefix = null;
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2728, urlPrefix.equals(staticAssetUrlPrefix))) {
                    urlPrefix = null;
                }

        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2732, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2729, (urlPrefix != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2731, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2730, urlPrefix.endsWith("/"))))))))) {
            urlPrefix = urlPrefix + "/";
        }
        return urlPrefix;
    }

    public static perturbation.location.PerturbationLocation __L2673;

    public static perturbation.location.PerturbationLocation __L2674;

    public static perturbation.location.PerturbationLocation __L2675;

    public static perturbation.location.PerturbationLocation __L2676;

    public static perturbation.location.PerturbationLocation __L2677;

    public static perturbation.location.PerturbationLocation __L2678;

    public static perturbation.location.PerturbationLocation __L2679;

    public static perturbation.location.PerturbationLocation __L2680;

    public static perturbation.location.PerturbationLocation __L2681;

    public static perturbation.location.PerturbationLocation __L2682;

    public static perturbation.location.PerturbationLocation __L2683;

    public static perturbation.location.PerturbationLocation __L2684;

    public static perturbation.location.PerturbationLocation __L2685;

    public static perturbation.location.PerturbationLocation __L2686;

    public static perturbation.location.PerturbationLocation __L2687;

    public static perturbation.location.PerturbationLocation __L2688;

    public static perturbation.location.PerturbationLocation __L2689;

    public static perturbation.location.PerturbationLocation __L2690;

    public static perturbation.location.PerturbationLocation __L2691;

    public static perturbation.location.PerturbationLocation __L2692;

    public static perturbation.location.PerturbationLocation __L2693;

    public static perturbation.location.PerturbationLocation __L2694;

    public static perturbation.location.PerturbationLocation __L2695;

    public static perturbation.location.PerturbationLocation __L2696;

    public static perturbation.location.PerturbationLocation __L2697;

    public static perturbation.location.PerturbationLocation __L2698;

    public static perturbation.location.PerturbationLocation __L2699;

    public static perturbation.location.PerturbationLocation __L2700;

    public static perturbation.location.PerturbationLocation __L2701;

    public static perturbation.location.PerturbationLocation __L2702;

    public static perturbation.location.PerturbationLocation __L2703;

    public static perturbation.location.PerturbationLocation __L2704;

    public static perturbation.location.PerturbationLocation __L2705;

    public static perturbation.location.PerturbationLocation __L2706;

    public static perturbation.location.PerturbationLocation __L2707;

    public static perturbation.location.PerturbationLocation __L2708;

    public static perturbation.location.PerturbationLocation __L2709;

    public static perturbation.location.PerturbationLocation __L2710;

    public static perturbation.location.PerturbationLocation __L2711;

    public static perturbation.location.PerturbationLocation __L2712;

    public static perturbation.location.PerturbationLocation __L2713;

    public static perturbation.location.PerturbationLocation __L2714;

    public static perturbation.location.PerturbationLocation __L2715;

    public static perturbation.location.PerturbationLocation __L2716;

    public static perturbation.location.PerturbationLocation __L2717;

    public static perturbation.location.PerturbationLocation __L2718;

    public static perturbation.location.PerturbationLocation __L2719;

    public static perturbation.location.PerturbationLocation __L2720;

    public static perturbation.location.PerturbationLocation __L2721;

    public static perturbation.location.PerturbationLocation __L2722;

    public static perturbation.location.PerturbationLocation __L2723;

    public static perturbation.location.PerturbationLocation __L2724;

    public static perturbation.location.PerturbationLocation __L2725;

    public static perturbation.location.PerturbationLocation __L2726;

    public static perturbation.location.PerturbationLocation __L2727;

    public static perturbation.location.PerturbationLocation __L2728;

    public static perturbation.location.PerturbationLocation __L2729;

    public static perturbation.location.PerturbationLocation __L2730;

    public static perturbation.location.PerturbationLocation __L2731;

    public static perturbation.location.PerturbationLocation __L2732;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:68)", 2673, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:69)", 2674, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:68)", 2675, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:70)", 2676, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:68)", 2677, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:71)", 2678, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:68)", 2679, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:74)", 2680, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:80)", 2681, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:82)", 2682, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:134)", 2683, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:134)", 2684, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:134)", 2685, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:134)", 2686, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:134)", 2687, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:134)", 2688, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:136)", 2689, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:141)", 2690, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:143)", 2691, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:144)", 2692, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:148)", 2693, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:149)", 2694, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:152)", 2695, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:153)", 2696, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:155)", 2697, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:156)", 2698, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:156)", 2699, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:156)", 2700, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:156)", 2701, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:156)", 2702, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:156)", 2703, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:161)", 2704, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:161)", 2705, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:161)", 2706, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:161)", 2707, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:162)", 2708, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:162)", 2709, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:167)", 2710, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:167)", 2711, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:167)", 2712, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:167)", 2713, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:168)", 2714, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:168)", 2715, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:170)", 2716, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:171)", 2717, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:173)", 2718, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:208)", 2719, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:209)", 2720, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:209)", 2721, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:209)", 2722, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:209)", 2723, "Numerical");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:209)", 2724, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:209)", 2725, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:228)", 2726, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:230)", 2727, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:233)", 2728, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:239)", 2729, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:239)", 2730, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:239)", 2731, "Boolean");
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.__L2732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/StaticAssetPathServiceImpl.java:239)", 2732, "Boolean");
    }

    static {
        org.broadleafcommerce.common.file.service.StaticAssetPathServiceImpl.initPerturbationLocation0();
    }
}

