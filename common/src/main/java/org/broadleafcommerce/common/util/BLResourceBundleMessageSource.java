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


@java.lang.Deprecated
public class BLResourceBundleMessageSource extends org.springframework.context.support.ResourceBundleMessageSource implements org.springframework.beans.factory.InitializingBean {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.BLResourceBundleMessageSource.class);

    public BLResourceBundleMessageSource(java.lang.String[] basenames, org.broadleafcommerce.common.util.ResourceBundleExtensionPoint resourceBundleExtensionPoint) {
        super();
        java.util.List<java.lang.String> bundles = new java.util.ArrayList<java.lang.String>();
        if (resourceBundleExtensionPoint != null) {
            java.lang.String[] bundleNames = resourceBundleExtensionPoint.getBasenameExtensions();
            if (bundleNames != null) {
                for (int i = 0; i < (bundleNames.length); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLResourceBundleMessageSource.__L6227, (i++))) {
                    bundles.add(bundleNames[i]);
                }
            }
            if (basenames != null) {
                for (int i = 0; i < (basenames.length); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLResourceBundleMessageSource.__L6228, (i++))) {
                    bundles.add(basenames[i]);
                }
            }
        }
        setBasenames(bundles.toArray(new java.lang.String[0]));
    }

    @java.lang.Override
    public void afterPropertiesSet() throws java.lang.Exception {
        org.broadleafcommerce.common.util.BLResourceBundleMessageSource.LOG.fatal(("***INCORRECT CONFIGURATION***\n" + (((("This class should no longer be used as it does not merge property files together. If this is being used\n" + "in the admin application then this configuration is definitely an error as no properties will be resolved.\n") + "It is possible that the frontend application is not seriously effected by using this class but you should\n") + "modify your configuration to instead use org.broadleafcommerce.common.util.BroadleafMergeResourceBundleMessageSource\n") + "instead as soon as possible.")));
    }

    public static perturbation.location.PerturbationLocation __L6227;

    public static perturbation.location.PerturbationLocation __L6228;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLResourceBundleMessageSource.__L6227 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLResourceBundleMessageSource.java:43)", 6227, "Numerical");
        org.broadleafcommerce.common.util.BLResourceBundleMessageSource.__L6228 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLResourceBundleMessageSource.java:48)", 6228, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.BLResourceBundleMessageSource.initPerturbationLocation0();
    }
}

