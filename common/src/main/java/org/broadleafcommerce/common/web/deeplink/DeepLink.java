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
package org.broadleafcommerce.common.web.deeplink;


public class DeepLink {
    protected java.lang.String adminBaseUrl;

    protected java.lang.String urlFragment;

    protected java.lang.String displayText;

    protected java.lang.Object sourceObject;

    public org.broadleafcommerce.common.web.deeplink.DeepLink withAdminBaseUrl(java.lang.String adminBaseUrl) {
        setAdminBaseUrl(adminBaseUrl);
        return this;
    }

    public org.broadleafcommerce.common.web.deeplink.DeepLink withUrlFragment(java.lang.String urlFragment) {
        setUrlFragment(urlFragment);
        return this;
    }

    public org.broadleafcommerce.common.web.deeplink.DeepLink withDisplayText(java.lang.String displayText) {
        setDisplayText(displayText);
        return this;
    }

    public org.broadleafcommerce.common.web.deeplink.DeepLink withSourceObject(java.lang.Object sourceObject) {
        setSourceObject(sourceObject);
        return this;
    }

    public void setAdminBaseUrl(java.lang.String adminBaseUrl) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7163, ((adminBaseUrl.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7162, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7160, adminBaseUrl.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7161, 1)))))) == '/'))) {
            adminBaseUrl = adminBaseUrl.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7164, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7167, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7165, adminBaseUrl.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7166, 1)))));
        }
        this.adminBaseUrl = adminBaseUrl;
    }

    public void setUrlFragment(java.lang.String urlFragment) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7169, ((urlFragment.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7168, 0))) == '/'))) {
            urlFragment = urlFragment.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.deeplink.DeepLink.__L7170, 1));
        }
        this.urlFragment = urlFragment;
    }

    public java.lang.String getFullUrl() {
        return ((adminBaseUrl) + "/") + (urlFragment);
    }

    public java.lang.String getAdminBaseUrl() {
        return adminBaseUrl;
    }

    public java.lang.String getUrlFragment() {
        return urlFragment;
    }

    public java.lang.String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(java.lang.String displayText) {
        this.displayText = displayText;
    }

    public java.lang.Object getSourceObject() {
        return sourceObject;
    }

    public void setSourceObject(java.lang.Object sourceObject) {
        this.sourceObject = sourceObject;
    }

    public static perturbation.location.PerturbationLocation __L7160;

    public static perturbation.location.PerturbationLocation __L7161;

    public static perturbation.location.PerturbationLocation __L7162;

    public static perturbation.location.PerturbationLocation __L7163;

    public static perturbation.location.PerturbationLocation __L7164;

    public static perturbation.location.PerturbationLocation __L7165;

    public static perturbation.location.PerturbationLocation __L7166;

    public static perturbation.location.PerturbationLocation __L7167;

    public static perturbation.location.PerturbationLocation __L7168;

    public static perturbation.location.PerturbationLocation __L7169;

    public static perturbation.location.PerturbationLocation __L7170;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:62)", 7160, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:62)", 7161, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:62)", 7162, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:62)", 7163, "Boolean");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:63)", 7164, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7165 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:63)", 7165, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7166 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:63)", 7166, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7167 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:63)", 7167, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7168 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:69)", 7168, "Numerical");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7169 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:69)", 7169, "Boolean");
        org.broadleafcommerce.common.web.deeplink.DeepLink.__L7170 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/deeplink/DeepLink.java:70)", 7170, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.deeplink.DeepLink.initPerturbationLocation0();
    }
}

