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


public class BLCDateUtils {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.BLCDateUtils.class);

    public static final java.lang.String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.s";

    public static java.lang.String convertDateToUTC(java.util.Date date) {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(org.broadleafcommerce.common.util.BLCDateUtils.DEFAULT_DATE_FORMAT);
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return dateFormat.format(date);
    }

    public static java.lang.String formatDateAsString(java.util.Date date) {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MMM d, Y @ hh:mma");
        java.text.DateFormatSymbols symbols = new java.text.DateFormatSymbols(java.util.Locale.getDefault());
        symbols.setAmPmStrings(new java.lang.String[]{ "am", "pm" });
        formatter.setDateFormatSymbols(symbols);
        return formatter.format(date);
    }

    public static java.util.Date parseStringToDate(java.lang.String dateString) {
        return org.broadleafcommerce.common.util.BLCDateUtils.parseStringToDate(dateString, org.broadleafcommerce.common.util.BLCDateUtils.DEFAULT_DATE_FORMAT);
    }

    public static java.util.Date parseStringToDate(java.lang.String dateString, java.lang.String dateFormat) {
        java.util.Date parsedDate = null;
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCDateUtils.__L6101, org.apache.commons.lang3.StringUtils.isNotEmpty(dateString))) {
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(dateFormat);
                parsedDate = formatter.parse(dateString);
            }
        } catch (java.text.ParseException e) {
            org.broadleafcommerce.common.util.BLCDateUtils.LOG.warn(("The date string could not be parsed into the given format: " + dateFormat), e);
        }
        return parsedDate;
    }

    public static java.lang.String formatDate(java.util.Date date) {
        return org.broadleafcommerce.common.util.BLCDateUtils.formatDate(date, org.broadleafcommerce.common.util.BLCDateUtils.DEFAULT_DATE_FORMAT);
    }

    public static java.lang.String formatDate(java.util.Date date, java.lang.String format) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCDateUtils.__L6102, (date == null))) {
            return null;
        }
        return new java.text.SimpleDateFormat(format).format(date);
    }

    public static perturbation.location.PerturbationLocation __L6101;

    public static perturbation.location.PerturbationLocation __L6102;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCDateUtils.__L6101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCDateUtils.java:72)", 6101, "Boolean");
        org.broadleafcommerce.common.util.BLCDateUtils.__L6102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCDateUtils.java:87)", 6102, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCDateUtils.initPerturbationLocation0();
    }
}

