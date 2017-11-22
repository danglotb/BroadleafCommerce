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


public class FormatUtil {
    public static final java.lang.String DATE_FORMAT = "yyyy.MM.dd HH:mm:ss";

    public static final java.lang.String DATE_FORMAT_WITH_TIMEZONE = "yyyy.MM.dd HH:mm:ss Z";

    public static java.text.SimpleDateFormat getDateFormat() {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(org.broadleafcommerce.common.util.FormatUtil.DATE_FORMAT);
        formatter.setTimeZone(org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getTimeZone());
        return formatter;
    }

    public static java.text.SimpleDateFormat getTimeZoneFormat() {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(org.broadleafcommerce.common.util.FormatUtil.DATE_FORMAT_WITH_TIMEZONE);
        formatter.setTimeZone(org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getTimeZone());
        return formatter;
    }

    public static java.lang.String formatDateUsingW3C(java.util.Date date) {
        java.lang.String w3cDate = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(date);
        return w3cDate = ((w3cDate.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.FormatUtil.__L6352, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.FormatUtil.__L6353, 22))) + ":") + (w3cDate.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.FormatUtil.__L6354, 22), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.FormatUtil.__L6355, 24)));
    }

    public static perturbation.location.PerturbationLocation __L6352;

    public static perturbation.location.PerturbationLocation __L6353;

    public static perturbation.location.PerturbationLocation __L6354;

    public static perturbation.location.PerturbationLocation __L6355;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.FormatUtil.__L6352 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/FormatUtil.java:63)", 6352, "Numerical");
        org.broadleafcommerce.common.util.FormatUtil.__L6353 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/FormatUtil.java:63)", 6353, "Numerical");
        org.broadleafcommerce.common.util.FormatUtil.__L6354 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/FormatUtil.java:63)", 6354, "Numerical");
        org.broadleafcommerce.common.util.FormatUtil.__L6355 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/FormatUtil.java:63)", 6355, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.FormatUtil.initPerturbationLocation0();
    }
}

