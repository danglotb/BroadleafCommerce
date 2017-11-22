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
package org.broadleafcommerce.common.util;


public class DependencyLicenseCopy extends org.apache.tools.ant.taskdefs.Copy {
    protected java.io.File licenseDir = null;

    protected java.util.Vector<org.apache.tools.ant.types.ResourceCollection> rcs = new java.util.Vector<org.apache.tools.ant.types.ResourceCollection>();

    @java.lang.SuppressWarnings("unchecked")
    public void execute() throws org.apache.tools.ant.BuildException {
        super.execute();
        try {
            for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6244, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6247, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6245, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6246, rcs.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6248, (i++))) {
                org.apache.tools.ant.types.ResourceCollection rc = ((org.apache.tools.ant.types.ResourceCollection) (rcs.elementAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6249, i))));
                java.util.Iterator<org.apache.tools.ant.types.Resource> resources = rc.iterator();
                while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6250, resources.hasNext())) {
                    org.apache.tools.ant.types.Resource r = ((org.apache.tools.ant.types.Resource) (resources.next()));
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6252, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6251, r.isExists()))))) {
                        continue;
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6253, (r instanceof org.apache.tools.ant.types.resources.FileResource))) {
                        org.apache.tools.ant.types.resources.FileResource fr = ((org.apache.tools.ant.types.resources.FileResource) (r));
                        java.lang.String baseDir = fr.getBaseDir().getAbsolutePath();
                        java.lang.String file = fr.getFile().getAbsolutePath();
                        file = file.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6254, baseDir.length()), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6255, file.length()));
                        java.lang.String[] parts = file.split("/");
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6258, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6256, parts.length)) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6257, 1))))) {
                            parts = file.split("\\\\");
                        }
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6261, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6259, parts.length)) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6260, 1))))) {
                            throw new org.apache.tools.ant.BuildException(("Unable to recognize the path separator for src file: " + file));
                        }
                        java.lang.String[] specificParts = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6264, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6262, parts.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6263, 1))))];
                        java.lang.System.arraycopy(parts, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6265, 0), specificParts, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6266, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6267, specificParts.length));
                        java.lang.String specificFilePart = (org.apache.commons.lang.StringUtils.join(specificParts, '/')) + "/license.txt";
                        java.io.File specificFile = new java.io.File(licenseDir, specificFilePart);
                        java.io.File specificDestinationFile = new java.io.File(destDir, specificFilePart);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6268, specificFile.exists())) {
                            fileUtils.copyFile(specificFile, specificDestinationFile);
                            continue;
                        }
                        java.lang.String[] generalParts = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6269, 3)];
                        java.lang.System.arraycopy(parts, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6270, 0), generalParts, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6271, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6272, 3));
                        java.lang.String generalFilePart = (org.apache.commons.lang.StringUtils.join(generalParts, '/')) + "/license.txt";
                        java.io.File generalFile = new java.io.File(licenseDir, generalFilePart);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6273, generalFile.exists())) {
                            fileUtils.copyFile(generalFile, specificDestinationFile);
                            continue;
                        }
                        java.lang.String[] moreGeneralParts = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6274, 2)];
                        java.lang.System.arraycopy(parts, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6275, 0), moreGeneralParts, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6276, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6277, 2));
                        java.lang.String moreGeneralFilePart = (org.apache.commons.lang.StringUtils.join(moreGeneralParts, '/')) + "/license.txt";
                        java.io.File moreGeneralFile = new java.io.File(licenseDir, moreGeneralFilePart);
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6278, moreGeneralFile.exists())) {
                            fileUtils.copyFile(moreGeneralFile, specificDestinationFile);
                        }
                    }
                } 
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection res) {
        super.add(res);
        rcs.add(res);
    }

    public java.io.File getLicenseDir() {
        return licenseDir;
    }

    public void setLicenseDir(java.io.File licenseDir) {
        this.licenseDir = licenseDir;
    }

    public static perturbation.location.PerturbationLocation __L6244;

    public static perturbation.location.PerturbationLocation __L6245;

    public static perturbation.location.PerturbationLocation __L6246;

    public static perturbation.location.PerturbationLocation __L6247;

    public static perturbation.location.PerturbationLocation __L6248;

    public static perturbation.location.PerturbationLocation __L6249;

    public static perturbation.location.PerturbationLocation __L6250;

    public static perturbation.location.PerturbationLocation __L6251;

    public static perturbation.location.PerturbationLocation __L6252;

    public static perturbation.location.PerturbationLocation __L6253;

    public static perturbation.location.PerturbationLocation __L6254;

    public static perturbation.location.PerturbationLocation __L6255;

    public static perturbation.location.PerturbationLocation __L6256;

    public static perturbation.location.PerturbationLocation __L6257;

    public static perturbation.location.PerturbationLocation __L6258;

    public static perturbation.location.PerturbationLocation __L6259;

    public static perturbation.location.PerturbationLocation __L6260;

    public static perturbation.location.PerturbationLocation __L6261;

    public static perturbation.location.PerturbationLocation __L6262;

    public static perturbation.location.PerturbationLocation __L6263;

    public static perturbation.location.PerturbationLocation __L6264;

    public static perturbation.location.PerturbationLocation __L6265;

    public static perturbation.location.PerturbationLocation __L6266;

    public static perturbation.location.PerturbationLocation __L6267;

    public static perturbation.location.PerturbationLocation __L6268;

    public static perturbation.location.PerturbationLocation __L6269;

    public static perturbation.location.PerturbationLocation __L6270;

    public static perturbation.location.PerturbationLocation __L6271;

    public static perturbation.location.PerturbationLocation __L6272;

    public static perturbation.location.PerturbationLocation __L6273;

    public static perturbation.location.PerturbationLocation __L6274;

    public static perturbation.location.PerturbationLocation __L6275;

    public static perturbation.location.PerturbationLocation __L6276;

    public static perturbation.location.PerturbationLocation __L6277;

    public static perturbation.location.PerturbationLocation __L6278;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6244 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:41)", 6244, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6245 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:41)", 6245, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6246 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:41)", 6246, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6247 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:41)", 6247, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6248 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:41)", 6248, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6249 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:42)", 6249, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6250 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:44)", 6250, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6251 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:46)", 6251, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6252 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:46)", 6252, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6253 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:49)", 6253, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6254 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:53)", 6254, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6255 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:53)", 6255, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6256 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:55)", 6256, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6257 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:55)", 6257, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6258 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:55)", 6258, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6259 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:58)", 6259, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6260 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:58)", 6260, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6261 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:58)", 6261, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6262 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:61)", 6262, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6263 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:61)", 6263, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6264 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:61)", 6264, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6265 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:62)", 6265, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6266 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:62)", 6266, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6267 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:62)", 6267, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6268 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:66)", 6268, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6269 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:71)", 6269, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6270 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:72)", 6270, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6271 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:72)", 6271, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6272 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:72)", 6272, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6273 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:75)", 6273, "Boolean");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6274 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:80)", 6274, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6275 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:81)", 6275, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6276 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:81)", 6276, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6277 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:81)", 6277, "Numerical");
        org.broadleafcommerce.common.util.DependencyLicenseCopy.__L6278 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/DependencyLicenseCopy.java:84)", 6278, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.DependencyLicenseCopy.initPerturbationLocation0();
    }
}

