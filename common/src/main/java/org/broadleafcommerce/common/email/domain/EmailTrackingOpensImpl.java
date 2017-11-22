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
package org.broadleafcommerce.common.email.domain;


@javax.persistence.Entity
@javax.persistence.Table(name = "BLC_EMAIL_TRACKING_OPENS")
public class EmailTrackingOpensImpl implements org.broadleafcommerce.common.email.domain.EmailTrackingOpens {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "OpenId")
    @org.hibernate.annotations.GenericGenerator(name = "OpenId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "EmailTrackingOpensImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl") })
    @javax.persistence.Column(name = "OPEN_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "DATE_OPENED")
    protected java.util.Date dateOpened;

    @javax.persistence.Column(name = "USER_AGENT")
    protected java.lang.String userAgent;

    @javax.persistence.ManyToOne(targetEntity = org.broadleafcommerce.common.email.domain.EmailTrackingImpl.class)
    @javax.persistence.JoinColumn(name = "EMAIL_TRACKING_ID")
    @org.hibernate.annotations.Index(name = "TRACKINGOPEN_TRACKING", columnNames = { "EMAIL_TRACKING_ID" })
    protected org.broadleafcommerce.common.email.domain.EmailTracking emailTracking;

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.util.Date getDateOpened() {
        return dateOpened;
    }

    @java.lang.Override
    public void setDateOpened(java.util.Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    @java.lang.Override
    public java.lang.String getUserAgent() {
        return userAgent;
    }

    @java.lang.Override
    public void setUserAgent(java.lang.String userAgent) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1062, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1060, userAgent.length())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1061, 255))))) {
            userAgent = userAgent.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1063, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1064, 254));
        }
        this.userAgent = userAgent;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.email.domain.EmailTracking getEmailTracking() {
        return emailTracking;
    }

    @java.lang.Override
    public void setEmailTracking(org.broadleafcommerce.common.email.domain.EmailTracking emailTracking) {
        this.emailTracking = emailTracking;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1065, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1066, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1074, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1069, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1067, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1068, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1073, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1070, ((dateOpened) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1071, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1072, dateOpened.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1082, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1077, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1075, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1076, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1081, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1078, ((emailTracking) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1079, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1080, emailTracking.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1090, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1085, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1083, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1084, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1089, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1086, ((userAgent) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1087, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1088, userAgent.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1091, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1092, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1093, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1094, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1095, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1097, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1096, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1098, false);

        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl other = ((org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1099, ((id) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1100, ((other.id) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1101, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1103, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1102, id.equals(other.id))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1104, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1105, ((dateOpened) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1106, ((other.dateOpened) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1107, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1109, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1108, dateOpened.equals(other.dateOpened))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1110, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1111, ((emailTracking) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1112, ((other.emailTracking) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1113, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1115, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1114, emailTracking.equals(other.emailTracking))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1116, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1117, ((userAgent) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1118, ((other.userAgent) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1119, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1121, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1120, userAgent.equals(other.userAgent))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1122, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1123, true);
    }

    public static perturbation.location.PerturbationLocation __L1060;

    public static perturbation.location.PerturbationLocation __L1061;

    public static perturbation.location.PerturbationLocation __L1062;

    public static perturbation.location.PerturbationLocation __L1063;

    public static perturbation.location.PerturbationLocation __L1064;

    public static perturbation.location.PerturbationLocation __L1065;

    public static perturbation.location.PerturbationLocation __L1066;

    public static perturbation.location.PerturbationLocation __L1067;

    public static perturbation.location.PerturbationLocation __L1068;

    public static perturbation.location.PerturbationLocation __L1069;

    public static perturbation.location.PerturbationLocation __L1070;

    public static perturbation.location.PerturbationLocation __L1071;

    public static perturbation.location.PerturbationLocation __L1072;

    public static perturbation.location.PerturbationLocation __L1073;

    public static perturbation.location.PerturbationLocation __L1074;

    public static perturbation.location.PerturbationLocation __L1075;

    public static perturbation.location.PerturbationLocation __L1076;

    public static perturbation.location.PerturbationLocation __L1077;

    public static perturbation.location.PerturbationLocation __L1078;

    public static perturbation.location.PerturbationLocation __L1079;

    public static perturbation.location.PerturbationLocation __L1080;

    public static perturbation.location.PerturbationLocation __L1081;

    public static perturbation.location.PerturbationLocation __L1082;

    public static perturbation.location.PerturbationLocation __L1083;

    public static perturbation.location.PerturbationLocation __L1084;

    public static perturbation.location.PerturbationLocation __L1085;

    public static perturbation.location.PerturbationLocation __L1086;

    public static perturbation.location.PerturbationLocation __L1087;

    public static perturbation.location.PerturbationLocation __L1088;

    public static perturbation.location.PerturbationLocation __L1089;

    public static perturbation.location.PerturbationLocation __L1090;

    public static perturbation.location.PerturbationLocation __L1091;

    public static perturbation.location.PerturbationLocation __L1092;

    public static perturbation.location.PerturbationLocation __L1093;

    public static perturbation.location.PerturbationLocation __L1094;

    public static perturbation.location.PerturbationLocation __L1095;

    public static perturbation.location.PerturbationLocation __L1096;

    public static perturbation.location.PerturbationLocation __L1097;

    public static perturbation.location.PerturbationLocation __L1098;

    public static perturbation.location.PerturbationLocation __L1099;

    public static perturbation.location.PerturbationLocation __L1100;

    public static perturbation.location.PerturbationLocation __L1101;

    public static perturbation.location.PerturbationLocation __L1102;

    public static perturbation.location.PerturbationLocation __L1103;

    public static perturbation.location.PerturbationLocation __L1104;

    public static perturbation.location.PerturbationLocation __L1105;

    public static perturbation.location.PerturbationLocation __L1106;

    public static perturbation.location.PerturbationLocation __L1107;

    public static perturbation.location.PerturbationLocation __L1108;

    public static perturbation.location.PerturbationLocation __L1109;

    public static perturbation.location.PerturbationLocation __L1110;

    public static perturbation.location.PerturbationLocation __L1111;

    public static perturbation.location.PerturbationLocation __L1112;

    public static perturbation.location.PerturbationLocation __L1113;

    public static perturbation.location.PerturbationLocation __L1114;

    public static perturbation.location.PerturbationLocation __L1115;

    public static perturbation.location.PerturbationLocation __L1116;

    public static perturbation.location.PerturbationLocation __L1117;

    public static perturbation.location.PerturbationLocation __L1118;

    public static perturbation.location.PerturbationLocation __L1119;

    public static perturbation.location.PerturbationLocation __L1120;

    public static perturbation.location.PerturbationLocation __L1121;

    public static perturbation.location.PerturbationLocation __L1122;

    public static perturbation.location.PerturbationLocation __L1123;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:114)", 1060, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:114)", 1061, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:114)", 1062, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:115)", 1063, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:115)", 1064, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:138)", 1065, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:139)", 1066, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1067, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1068, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1069, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1070, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1071, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1072, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1073, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:140)", 1074, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1075 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1075, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1076, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1077, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1078, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1079, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1080, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1081, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:141)", 1082, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1083, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1084, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1085, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1086, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1087, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1088, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1089, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:142)", 1090, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1091 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:143)", 1091, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1092 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:148)", 1092, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1093 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:149)", 1093, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1094 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:150)", 1094, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1095 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:151)", 1095, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1096 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:152)", 1096, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1097 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:152)", 1097, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1098 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:153)", 1098, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1099 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:156)", 1099, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1100 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:157)", 1100, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1101 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:158)", 1101, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1102 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:159)", 1102, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:159)", 1103, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:160)", 1104, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:161)", 1105, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:162)", 1106, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:163)", 1107, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:164)", 1108, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:164)", 1109, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:165)", 1110, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:166)", 1111, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:167)", 1112, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:168)", 1113, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:169)", 1114, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:169)", 1115, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:170)", 1116, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:171)", 1117, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:172)", 1118, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:173)", 1119, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:174)", 1120, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:174)", 1121, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:175)", 1122, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.__L1123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingOpensImpl.java:176)", 1123, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.initPerturbationLocation0();
    }
}

