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


@org.springframework.stereotype.Service("blDefaultFileServiceProvider")
public class FileSystemFileServiceProvider implements org.broadleafcommerce.common.file.service.FileServiceProvider {
    @org.springframework.beans.factory.annotation.Value("${asset.server.file.system.path}")
    protected java.lang.String fileSystemBaseDirectory;

    @org.springframework.beans.factory.annotation.Value("${asset.server.max.generated.file.system.directories}")
    protected int maxGeneratedDirectoryDepth;

    @javax.annotation.Resource(name = "blBroadleafFileServiceExtensionManager")
    protected org.broadleafcommerce.common.file.service.BroadleafFileServiceExtensionManager extensionManager;

    private static final java.lang.String DEFAULT_STORAGE_DIRECTORY = java.lang.System.getProperty("java.io.tmpdir");

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.class);

    protected java.lang.String baseDirectory;

    @java.lang.Override
    public java.io.File getResource(java.lang.String url) {
        return getResource(url, org.broadleafcommerce.common.file.service.type.FileApplicationType.ALL);
    }

    @java.lang.Override
    public java.io.File getResource(java.lang.String url, org.broadleafcommerce.common.file.service.type.FileApplicationType applicationType) {
        java.lang.String fileName = buildResourceName(url);
        java.lang.String baseDirectory = getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2621, true));
        org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String> holder = new org.broadleafcommerce.common.extension.ExtensionResultHolder<java.lang.String>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2622, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultStatusType result = extensionManager.getProxy().processPathForSite(baseDirectory, fileName, holder);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2624, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2623, org.broadleafcommerce.common.extension.ExtensionResultStatusType.NOT_HANDLED.equals(result)))))) {
                return new java.io.File(holder.getResult());
            }
        }
        java.lang.String filePath = org.apache.commons.io.FilenameUtils.normalize((((getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2625, false))) + (java.io.File.separator)) + fileName));
        return new java.io.File(filePath);
    }

    @java.lang.Override
    @java.lang.Deprecated
    public void addOrUpdateResources(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> files, boolean removeFilesFromWorkArea) {
        addOrUpdateResourcesForPaths(workArea, files, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2626, removeFilesFromWorkArea));
    }

    @java.lang.Override
    public java.util.List<java.lang.String> addOrUpdateResourcesForPaths(org.broadleafcommerce.common.file.domain.FileWorkArea workArea, java.util.List<java.io.File> files, boolean removeFilesFromWorkArea) {
        java.util.List<java.lang.String> result = new java.util.ArrayList<java.lang.String>();
        for (java.io.File srcFile : files) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2628, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2627, srcFile.getAbsolutePath().startsWith(workArea.getFilePathLocation())))))) {
                throw new org.broadleafcommerce.common.file.FileServiceException(((("Attempt to update file " + (srcFile.getAbsolutePath())) + " that is not in the passed in WorkArea ") + (workArea.getFilePathLocation())));
            }
            java.lang.String fileName = srcFile.getAbsolutePath().substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2629, workArea.getFilePathLocation().length()));
            java.lang.String url = org.apache.commons.io.FilenameUtils.separatorsToUnix(fileName);
            java.lang.String resourceName = buildResourceName(url);
            java.lang.String destinationFilePath = org.apache.commons.io.FilenameUtils.normalize((((getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2630, false))) + (java.io.File.separator)) + resourceName));
            java.io.File destFile = new java.io.File(destinationFilePath);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2632, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2631, destFile.getParentFile().exists()))))) {
                destFile.getParentFile().mkdirs();
            }
            try {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2633, removeFilesFromWorkArea)) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2634, destFile.exists())) {
                        org.apache.commons.io.FileUtils.deleteQuietly(destFile);
                    }
                    org.apache.commons.io.FileUtils.moveFile(srcFile, destFile);
                }else {
                    org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
                }
                result.add(fileName);
            } catch (java.io.IOException ioe) {
                throw new org.broadleafcommerce.common.file.FileServiceException(((((("Error copying resource named " + fileName) + " from workArea ") + (workArea.getFilePathLocation())) + " to ") + resourceName), ioe);
            }
        }
        return result;
    }

    @java.lang.Override
    public boolean removeResource(java.lang.String name) {
        java.lang.String resourceName = buildResourceName(name);
        java.lang.String filePathToRemove = org.apache.commons.io.FilenameUtils.normalize((((getBaseDirectory(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2635, false))) + (java.io.File.separator)) + resourceName));
        java.io.File fileToRemove = new java.io.File(filePathToRemove);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2636, fileToRemove.delete());
    }

    protected java.lang.String buildResourceName(java.lang.String url) {
        java.lang.String fileHash = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2638, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2637, url.startsWith("/")))))) {
            fileHash = org.apache.commons.codec.digest.DigestUtils.md5Hex(("/" + url));
        }else {
            fileHash = org.apache.commons.codec.digest.DigestUtils.md5Hex(url);
        }
        java.lang.String resourceName = "";
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2639, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2642, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2640, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2641, maxGeneratedDirectoryDepth)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2643, (i++))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2646, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2644, i)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2645, 4))))) {
                org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.LOG.warn(("Property maxGeneratedDirectoryDepth set to high, ignoring values past 4 - value set to" + (maxGeneratedDirectoryDepth)));
                break;
            }
            resourceName = org.apache.commons.io.FilenameUtils.concat(resourceName, fileHash.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2649, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2647, i)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2648, 2)))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2654, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2652, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2650, i)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2651, 1))))) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2653, 2))))));
        }
        return org.apache.commons.io.FilenameUtils.concat(resourceName, org.apache.commons.io.FilenameUtils.getName(url));
    }

    protected java.lang.String getBaseDirectory(boolean skipSite) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2655, ((baseDirectory) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2656, org.apache.commons.lang3.StringUtils.isNotBlank(fileSystemBaseDirectory))) {
                baseDirectory = fileSystemBaseDirectory;
            }else {
                baseDirectory = org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.DEFAULT_STORAGE_DIRECTORY;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2658, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2657, skipSite))))) {
            return getSiteDirectory(baseDirectory);
        }else {
            return baseDirectory;
        }
    }

    protected java.lang.String getSiteDirectory(java.lang.String baseDirectory) {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2659, (brc != null))) {
            org.broadleafcommerce.common.site.domain.Site site = brc.getSite();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2660, (site != null))) {
                java.lang.String siteDirectory = "site-" + (site.getId());
                java.lang.String siteHash = org.apache.commons.codec.digest.DigestUtils.md5Hex(siteDirectory);
                java.lang.String sitePath = org.apache.commons.io.FilenameUtils.concat(siteHash.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2661, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2662, 2)), siteDirectory);
                return org.apache.commons.io.FilenameUtils.concat(baseDirectory, sitePath);
            }
        }
        return baseDirectory;
    }

    public static perturbation.location.PerturbationLocation __L2621;

    public static perturbation.location.PerturbationLocation __L2622;

    public static perturbation.location.PerturbationLocation __L2623;

    public static perturbation.location.PerturbationLocation __L2624;

    public static perturbation.location.PerturbationLocation __L2625;

    public static perturbation.location.PerturbationLocation __L2626;

    public static perturbation.location.PerturbationLocation __L2627;

    public static perturbation.location.PerturbationLocation __L2628;

    public static perturbation.location.PerturbationLocation __L2629;

    public static perturbation.location.PerturbationLocation __L2630;

    public static perturbation.location.PerturbationLocation __L2631;

    public static perturbation.location.PerturbationLocation __L2632;

    public static perturbation.location.PerturbationLocation __L2633;

    public static perturbation.location.PerturbationLocation __L2634;

    public static perturbation.location.PerturbationLocation __L2635;

    public static perturbation.location.PerturbationLocation __L2636;

    public static perturbation.location.PerturbationLocation __L2637;

    public static perturbation.location.PerturbationLocation __L2638;

    public static perturbation.location.PerturbationLocation __L2639;

    public static perturbation.location.PerturbationLocation __L2640;

    public static perturbation.location.PerturbationLocation __L2641;

    public static perturbation.location.PerturbationLocation __L2642;

    public static perturbation.location.PerturbationLocation __L2643;

    public static perturbation.location.PerturbationLocation __L2644;

    public static perturbation.location.PerturbationLocation __L2645;

    public static perturbation.location.PerturbationLocation __L2646;

    public static perturbation.location.PerturbationLocation __L2647;

    public static perturbation.location.PerturbationLocation __L2648;

    public static perturbation.location.PerturbationLocation __L2649;

    public static perturbation.location.PerturbationLocation __L2650;

    public static perturbation.location.PerturbationLocation __L2651;

    public static perturbation.location.PerturbationLocation __L2652;

    public static perturbation.location.PerturbationLocation __L2653;

    public static perturbation.location.PerturbationLocation __L2654;

    public static perturbation.location.PerturbationLocation __L2655;

    public static perturbation.location.PerturbationLocation __L2656;

    public static perturbation.location.PerturbationLocation __L2657;

    public static perturbation.location.PerturbationLocation __L2658;

    public static perturbation.location.PerturbationLocation __L2659;

    public static perturbation.location.PerturbationLocation __L2660;

    public static perturbation.location.PerturbationLocation __L2661;

    public static perturbation.location.PerturbationLocation __L2662;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:80)", 2621, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:82)", 2622, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:84)", 2623, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:84)", 2624, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:88)", 2625, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:95)", 2626, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:102)", 2627, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:102)", 2628, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:107)", 2629, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:112)", 2630, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:114)", 2631, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:114)", 2632, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:119)", 2633, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:120)", 2634, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:139)", 2635, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:141)", 2636, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:174)", 2637, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:174)", 2638, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:181)", 2639, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:181)", 2640, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:181)", 2641, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:181)", 2642, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:181)", 2643, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:182)", 2644, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:182)", 2645, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:182)", 2646, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2647, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2648, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2649, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2650, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2651, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2652, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2653, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:187)", 2654, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:199)", 2655, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:200)", 2656, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:206)", 2657, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:206)", 2658, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:223)", 2659, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:225)", 2660, "Boolean");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:228)", 2661, "Numerical");
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.__L2662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/file/service/FileSystemFileServiceProvider.java:228)", 2662, "Numerical");
    }

    static {
        org.broadleafcommerce.common.file.service.FileSystemFileServiceProvider.initPerturbationLocation0();
    }
}

