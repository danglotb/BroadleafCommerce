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
package org.broadleafcommerce.common.vendor.service;


public abstract class AbstractVendorService {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.vendor.service.AbstractVendorService.class);

    private static final java.lang.String POST_METHOD = "POST";

    protected java.io.InputStream postMessage(java.util.Map<java.lang.String, java.lang.String> content, java.net.URL destination, java.lang.String encodeCharset) throws java.io.IOException {
        java.net.HttpURLConnection connection = ((java.net.HttpURLConnection) (destination.openConnection()));
        connection.setDoInput(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7026, true));
        connection.setDoOutput(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7027, true));
        connection.setRequestMethod(org.broadleafcommerce.common.vendor.service.AbstractVendorService.POST_METHOD);
        java.io.OutputStreamWriter osw = null;
        try {
            osw = new java.io.OutputStreamWriter(connection.getOutputStream());
            boolean isFirst = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7028, true);
            for (java.lang.String key : content.keySet()) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7030, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7029, isFirst))))) {
                    osw.write("&");
                }
                isFirst = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7031, false);
                java.lang.String value = content.get(key);
                osw.write(java.net.URLEncoder.encode(key, encodeCharset));
                osw.write("=");
                osw.write(java.net.URLEncoder.encode(value, encodeCharset));
            }
            osw.flush();
            osw.close();
        } catch (java.io.IOException e) {
            org.broadleafcommerce.common.vendor.service.AbstractVendorService.LOG.error(("Problem closing the OuputStream to destination: " + (destination.toExternalForm())), e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7032, (osw != null))) {
                try {
                    osw.close();
                } catch (java.lang.Throwable e) {
                }
            }
        }
        return new java.io.BufferedInputStream(connection.getInputStream());
    }

    public static perturbation.location.PerturbationLocation __L7026;

    public static perturbation.location.PerturbationLocation __L7027;

    public static perturbation.location.PerturbationLocation __L7028;

    public static perturbation.location.PerturbationLocation __L7029;

    public static perturbation.location.PerturbationLocation __L7030;

    public static perturbation.location.PerturbationLocation __L7031;

    public static perturbation.location.PerturbationLocation __L7032;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:39)", 7026, "Boolean");
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:40)", 7027, "Boolean");
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:46)", 7028, "Boolean");
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:48)", 7029, "Boolean");
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:48)", 7030, "Boolean");
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:51)", 7031, "Boolean");
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.__L7032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/vendor/service/AbstractVendorService.java:63)", 7032, "Boolean");
    }

    static {
        org.broadleafcommerce.common.vendor.service.AbstractVendorService.initPerturbationLocation0();
    }
}

