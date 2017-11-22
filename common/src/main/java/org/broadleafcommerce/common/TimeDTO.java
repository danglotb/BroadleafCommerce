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
package org.broadleafcommerce.common;


public class TimeDTO {
    @org.broadleafcommerce.common.presentation.AdminPresentation(excluded = true)
    private java.util.Calendar cal;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TimeDTO_Hour_Of_Day", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.time.HourOfDayType")
    private java.lang.Integer hour;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TimeDTO_Day_Of_Week", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.time.DayOfWeekType")
    private java.lang.Integer dayOfWeek;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TimeDTO_Month", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.time.MonthType")
    private java.lang.Integer month;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TimeDTO_Day_Of_Month", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.time.DayOfMonthType")
    private java.lang.Integer dayOfMonth;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TimeDTO_Minute", fieldType = org.broadleafcommerce.common.presentation.client.SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration = "org.broadleafcommerce.common.time.MinuteType")
    private java.lang.Integer minute;

    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "TimeDTO_Date")
    private java.util.Date date;

    public TimeDTO() {
        cal = org.broadleafcommerce.common.time.SystemTime.asCalendar();
    }

    public TimeDTO(java.util.Calendar cal) {
        this.cal = cal;
    }

    public org.broadleafcommerce.common.time.HourOfDayType getHour() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.TimeDTO.__L8010, ((hour) == null))) {
            hour = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8012, cal.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8011, java.util.Calendar.HOUR_OF_DAY)));
        }
        return org.broadleafcommerce.common.time.HourOfDayType.getInstance(hour.toString());
    }

    public org.broadleafcommerce.common.time.DayOfWeekType getDayOfWeek() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.TimeDTO.__L8013, ((dayOfWeek) == null))) {
            dayOfWeek = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8015, cal.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8014, java.util.Calendar.DAY_OF_WEEK)));
        }
        return org.broadleafcommerce.common.time.DayOfWeekType.getInstance(dayOfWeek.toString());
    }

    public org.broadleafcommerce.common.time.DayOfMonthType getDayOfMonth() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.TimeDTO.__L8016, ((dayOfMonth) == null))) {
            dayOfMonth = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8018, cal.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8017, java.util.Calendar.DAY_OF_MONTH)));
        }
        return org.broadleafcommerce.common.time.DayOfMonthType.getInstance(dayOfMonth.toString());
    }

    public org.broadleafcommerce.common.time.MonthType getMonth() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.TimeDTO.__L8019, ((month) == null))) {
            month = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8021, cal.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8020, java.util.Calendar.MONTH)));
        }
        return org.broadleafcommerce.common.time.MonthType.getInstance(month.toString());
    }

    public org.broadleafcommerce.common.time.MinuteType getMinute() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.TimeDTO.__L8022, ((minute) == null))) {
            minute = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8024, cal.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8023, java.util.Calendar.MINUTE)));
        }
        return org.broadleafcommerce.common.time.MinuteType.getInstance(minute.toString());
    }

    public java.util.Date getDate() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.TimeDTO.__L8025, ((date) == null))) {
            date = cal.getTime();
        }
        return date;
    }

    public void setCal(java.util.Calendar cal) {
        this.cal = cal;
    }

    public void setHour(org.broadleafcommerce.common.time.HourOfDayType hour) {
        this.hour = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8026, java.lang.Integer.valueOf(hour.getType()));
    }

    public void setDayOfWeek(org.broadleafcommerce.common.time.DayOfWeekType dayOfWeek) {
        this.dayOfWeek = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8027, java.lang.Integer.valueOf(dayOfWeek.getType()));
    }

    public void setMonth(org.broadleafcommerce.common.time.MonthType month) {
        this.month = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8028, java.lang.Integer.valueOf(month.getType()));
    }

    public void setDayOfMonth(org.broadleafcommerce.common.time.DayOfMonthType dayOfMonth) {
        this.dayOfMonth = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8029, java.lang.Integer.valueOf(dayOfMonth.getType()));
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public void setMinute(org.broadleafcommerce.common.time.MinuteType minute) {
        this.minute = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.TimeDTO.__L8030, java.lang.Integer.valueOf(minute.getType()));
    }

    public static perturbation.location.PerturbationLocation __L8010;

    public static perturbation.location.PerturbationLocation __L8011;

    public static perturbation.location.PerturbationLocation __L8012;

    public static perturbation.location.PerturbationLocation __L8013;

    public static perturbation.location.PerturbationLocation __L8014;

    public static perturbation.location.PerturbationLocation __L8015;

    public static perturbation.location.PerturbationLocation __L8016;

    public static perturbation.location.PerturbationLocation __L8017;

    public static perturbation.location.PerturbationLocation __L8018;

    public static perturbation.location.PerturbationLocation __L8019;

    public static perturbation.location.PerturbationLocation __L8020;

    public static perturbation.location.PerturbationLocation __L8021;

    public static perturbation.location.PerturbationLocation __L8022;

    public static perturbation.location.PerturbationLocation __L8023;

    public static perturbation.location.PerturbationLocation __L8024;

    public static perturbation.location.PerturbationLocation __L8025;

    public static perturbation.location.PerturbationLocation __L8026;

    public static perturbation.location.PerturbationLocation __L8027;

    public static perturbation.location.PerturbationLocation __L8028;

    public static perturbation.location.PerturbationLocation __L8029;

    public static perturbation.location.PerturbationLocation __L8030;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.TimeDTO.__L8010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:71)", 8010, "Boolean");
        org.broadleafcommerce.common.TimeDTO.__L8011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:72)", 8011, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:72)", 8012, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:82)", 8013, "Boolean");
        org.broadleafcommerce.common.TimeDTO.__L8014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:83)", 8014, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:83)", 8015, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:92)", 8016, "Boolean");
        org.broadleafcommerce.common.TimeDTO.__L8017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:93)", 8017, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:93)", 8018, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:102)", 8019, "Boolean");
        org.broadleafcommerce.common.TimeDTO.__L8020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:103)", 8020, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:103)", 8021, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:109)", 8022, "Boolean");
        org.broadleafcommerce.common.TimeDTO.__L8023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:110)", 8023, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:110)", 8024, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:116)", 8025, "Boolean");
        org.broadleafcommerce.common.TimeDTO.__L8026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:127)", 8026, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:132)", 8027, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:136)", 8028, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:140)", 8029, "Numerical");
        org.broadleafcommerce.common.TimeDTO.__L8030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/TimeDTO.java:148)", 8030, "Numerical");
    }

    static {
        org.broadleafcommerce.common.TimeDTO.initPerturbationLocation0();
    }
}

