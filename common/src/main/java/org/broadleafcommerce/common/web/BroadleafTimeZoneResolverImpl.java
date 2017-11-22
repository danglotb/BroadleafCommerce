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
package org.broadleafcommerce.common.web;


@org.springframework.stereotype.Component("blTimeZoneResolver")
public class BroadleafTimeZoneResolverImpl implements org.broadleafcommerce.common.web.BroadleafTimeZoneResolver {
    private final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.class);

    public static java.lang.String TIMEZONE_VAR = "blTimeZone";

    public static java.lang.String TIMEZONE_CODE_PARAM = "blTimeZoneCode";

    @java.lang.Override
    public java.util.TimeZone resolveTimeZone(org.springframework.web.context.request.WebRequest request) {
        java.util.TimeZone timeZone = null;
        timeZone = ((java.util.TimeZone) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.TIMEZONE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7994, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST))));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7997, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7995, (timeZone == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7996, ((org.broadleafcommerce.common.util.BLCRequestUtils.getURLorHeaderParameter(request, org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.TIMEZONE_CODE_PARAM)) != null)))))) {
            java.lang.String timeZoneCode = org.broadleafcommerce.common.util.BLCRequestUtils.getURLorHeaderParameter(request, org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.TIMEZONE_CODE_PARAM);
            timeZone = java.util.TimeZone.getTimeZone(timeZoneCode);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7998, LOG.isTraceEnabled())) {
                LOG.trace(((("Attempt to find TimeZone by param " + timeZoneCode) + " resulted in ") + timeZone));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8001, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7999, (timeZone == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8000, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request)))))) {
            timeZone = ((java.util.TimeZone) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.TIMEZONE_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8002, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8003, LOG.isTraceEnabled())) {
                LOG.trace(("Attempt to find timezone from session resulted in " + timeZone));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8004, (timeZone == null))) {
            timeZone = java.util.TimeZone.getDefault();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8005, LOG.isTraceEnabled())) {
                LOG.trace(("timezone set to default timezone " + timeZone));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8006, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            request.setAttribute(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.TIMEZONE_VAR, timeZone, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8007, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
        }
        return timeZone;
    }

    public static perturbation.location.PerturbationLocation __L7994;

    public static perturbation.location.PerturbationLocation __L7995;

    public static perturbation.location.PerturbationLocation __L7996;

    public static perturbation.location.PerturbationLocation __L7997;

    public static perturbation.location.PerturbationLocation __L7998;

    public static perturbation.location.PerturbationLocation __L7999;

    public static perturbation.location.PerturbationLocation __L8000;

    public static perturbation.location.PerturbationLocation __L8001;

    public static perturbation.location.PerturbationLocation __L8002;

    public static perturbation.location.PerturbationLocation __L8003;

    public static perturbation.location.PerturbationLocation __L8004;

    public static perturbation.location.PerturbationLocation __L8005;

    public static perturbation.location.PerturbationLocation __L8006;

    public static perturbation.location.PerturbationLocation __L8007;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:52)", 7994, "Numerical");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:55)", 7995, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:55)", 7996, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:55)", 7997, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:59)", 7998, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L7999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:65)", 7999, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:65)", 8000, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:65)", 8001, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:67)", 8002, "Numerical");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:68)", 8003, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:74)", 8004, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:77)", 8005, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:82)", 8006, "Boolean");
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.__L8007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafTimeZoneResolverImpl.java:83)", 8007, "Numerical");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafTimeZoneResolverImpl.initPerturbationLocation0();
    }
}

