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
@javax.persistence.Table(name = "BLC_EMAIL_TRACKING")
public class EmailTrackingImpl implements org.broadleafcommerce.common.email.domain.EmailTracking {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "EmailTrackingId")
    @org.hibernate.annotations.GenericGenerator(name = "EmailTrackingId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "EmailTrackingImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.email.domain.EmailTrackingImpl") })
    @javax.persistence.Column(name = "EMAIL_TRACKING_ID")
    protected java.lang.Long id;

    @javax.persistence.Column(name = "EMAIL_ADDRESS")
    @org.hibernate.annotations.Index(name = "EMAILTRACKING_INDEX", columnNames = { "EMAIL_ADDRESS" })
    protected java.lang.String emailAddress;

    @javax.persistence.Column(name = "DATE_SENT")
    protected java.util.Date dateSent;

    @javax.persistence.Column(name = "TYPE")
    protected java.lang.String type;

    @javax.persistence.OneToMany(mappedBy = "emailTracking", targetEntity = org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.class)
    protected java.util.Set<org.broadleafcommerce.common.email.domain.EmailTrackingClicks> emailTrackingClicks = new java.util.HashSet<org.broadleafcommerce.common.email.domain.EmailTrackingClicks>();

    @javax.persistence.OneToMany(mappedBy = "emailTracking", targetEntity = org.broadleafcommerce.common.email.domain.EmailTrackingOpensImpl.class)
    protected java.util.Set<org.broadleafcommerce.common.email.domain.EmailTrackingOpens> emailTrackingOpens = new java.util.HashSet<org.broadleafcommerce.common.email.domain.EmailTrackingOpens>();

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }

    @java.lang.Override
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @java.lang.Override
    public java.util.Date getDateSent() {
        return dateSent;
    }

    @java.lang.Override
    public void setDateSent(java.util.Date dateSent) {
        this.dateSent = dateSent;
    }

    @java.lang.Override
    public java.lang.String getType() {
        return type;
    }

    @java.lang.Override
    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.util.Set<org.broadleafcommerce.common.email.domain.EmailTrackingClicks> getEmailTrackingClicks() {
        return emailTrackingClicks;
    }

    public void setEmailTrackingClicks(java.util.Set<org.broadleafcommerce.common.email.domain.EmailTrackingClicks> emailTrackingClicks) {
        this.emailTrackingClicks = emailTrackingClicks;
    }

    public java.util.Set<org.broadleafcommerce.common.email.domain.EmailTrackingOpens> getEmailTrackingOpens() {
        return emailTrackingOpens;
    }

    public void setEmailTrackingOpens(java.util.Set<org.broadleafcommerce.common.email.domain.EmailTrackingOpens> emailTrackingOpens) {
        this.emailTrackingOpens = emailTrackingOpens;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L975, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L976, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L984, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L979, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L977, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L978, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L983, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L980, ((dateSent) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L981, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L982, dateSent.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L992, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L987, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L985, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L986, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L991, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L988, ((emailAddress) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L989, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L990, emailAddress.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1000, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L995, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L993, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L994, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L999, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L996, ((emailTrackingClicks) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L997, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L998, emailTrackingClicks.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1008, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1003, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1001, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1002, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1007, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1004, ((emailTrackingOpens) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1005, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1006, emailTrackingOpens.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1016, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1011, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1009, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1010, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1015, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1012, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1013, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1014, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1017, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1018, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1019, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1020, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1021, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1023, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1022, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1024, false);

        org.broadleafcommerce.common.email.domain.EmailTrackingImpl other = ((org.broadleafcommerce.common.email.domain.EmailTrackingImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1027, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1025, ((id) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1026, ((other.id) != null)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1028, id.equals(other.id));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1029, ((dateSent) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1030, ((other.dateSent) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1031, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1033, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1032, dateSent.equals(other.dateSent))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1034, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1035, ((emailAddress) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1036, ((other.emailAddress) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1037, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1039, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1038, emailAddress.equals(other.emailAddress))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1040, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1041, ((emailTrackingClicks) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1042, ((other.emailTrackingClicks) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1043, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1045, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1044, emailTrackingClicks.equals(other.emailTrackingClicks))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1046, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1047, ((emailTrackingOpens) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1048, ((other.emailTrackingOpens) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1049, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1051, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1050, emailTrackingOpens.equals(other.emailTrackingOpens))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1052, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1053, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1054, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1055, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1057, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1056, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1058, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1059, true);
    }

    public static perturbation.location.PerturbationLocation __L975;

    public static perturbation.location.PerturbationLocation __L976;

    public static perturbation.location.PerturbationLocation __L977;

    public static perturbation.location.PerturbationLocation __L978;

    public static perturbation.location.PerturbationLocation __L979;

    public static perturbation.location.PerturbationLocation __L980;

    public static perturbation.location.PerturbationLocation __L981;

    public static perturbation.location.PerturbationLocation __L982;

    public static perturbation.location.PerturbationLocation __L983;

    public static perturbation.location.PerturbationLocation __L984;

    public static perturbation.location.PerturbationLocation __L985;

    public static perturbation.location.PerturbationLocation __L986;

    public static perturbation.location.PerturbationLocation __L987;

    public static perturbation.location.PerturbationLocation __L988;

    public static perturbation.location.PerturbationLocation __L989;

    public static perturbation.location.PerturbationLocation __L990;

    public static perturbation.location.PerturbationLocation __L991;

    public static perturbation.location.PerturbationLocation __L992;

    public static perturbation.location.PerturbationLocation __L993;

    public static perturbation.location.PerturbationLocation __L994;

    public static perturbation.location.PerturbationLocation __L995;

    public static perturbation.location.PerturbationLocation __L996;

    public static perturbation.location.PerturbationLocation __L997;

    public static perturbation.location.PerturbationLocation __L998;

    public static perturbation.location.PerturbationLocation __L999;

    public static perturbation.location.PerturbationLocation __L1000;

    public static perturbation.location.PerturbationLocation __L1001;

    public static perturbation.location.PerturbationLocation __L1002;

    public static perturbation.location.PerturbationLocation __L1003;

    public static perturbation.location.PerturbationLocation __L1004;

    public static perturbation.location.PerturbationLocation __L1005;

    public static perturbation.location.PerturbationLocation __L1006;

    public static perturbation.location.PerturbationLocation __L1007;

    public static perturbation.location.PerturbationLocation __L1008;

    public static perturbation.location.PerturbationLocation __L1009;

    public static perturbation.location.PerturbationLocation __L1010;

    public static perturbation.location.PerturbationLocation __L1011;

    public static perturbation.location.PerturbationLocation __L1012;

    public static perturbation.location.PerturbationLocation __L1013;

    public static perturbation.location.PerturbationLocation __L1014;

    public static perturbation.location.PerturbationLocation __L1015;

    public static perturbation.location.PerturbationLocation __L1016;

    public static perturbation.location.PerturbationLocation __L1017;

    public static perturbation.location.PerturbationLocation __L1018;

    public static perturbation.location.PerturbationLocation __L1019;

    public static perturbation.location.PerturbationLocation __L1020;

    public static perturbation.location.PerturbationLocation __L1021;

    public static perturbation.location.PerturbationLocation __L1022;

    public static perturbation.location.PerturbationLocation __L1023;

    public static perturbation.location.PerturbationLocation __L1024;

    public static perturbation.location.PerturbationLocation __L1025;

    public static perturbation.location.PerturbationLocation __L1026;

    public static perturbation.location.PerturbationLocation __L1027;

    public static perturbation.location.PerturbationLocation __L1028;

    public static perturbation.location.PerturbationLocation __L1029;

    public static perturbation.location.PerturbationLocation __L1030;

    public static perturbation.location.PerturbationLocation __L1031;

    public static perturbation.location.PerturbationLocation __L1032;

    public static perturbation.location.PerturbationLocation __L1033;

    public static perturbation.location.PerturbationLocation __L1034;

    public static perturbation.location.PerturbationLocation __L1035;

    public static perturbation.location.PerturbationLocation __L1036;

    public static perturbation.location.PerturbationLocation __L1037;

    public static perturbation.location.PerturbationLocation __L1038;

    public static perturbation.location.PerturbationLocation __L1039;

    public static perturbation.location.PerturbationLocation __L1040;

    public static perturbation.location.PerturbationLocation __L1041;

    public static perturbation.location.PerturbationLocation __L1042;

    public static perturbation.location.PerturbationLocation __L1043;

    public static perturbation.location.PerturbationLocation __L1044;

    public static perturbation.location.PerturbationLocation __L1045;

    public static perturbation.location.PerturbationLocation __L1046;

    public static perturbation.location.PerturbationLocation __L1047;

    public static perturbation.location.PerturbationLocation __L1048;

    public static perturbation.location.PerturbationLocation __L1049;

    public static perturbation.location.PerturbationLocation __L1050;

    public static perturbation.location.PerturbationLocation __L1051;

    public static perturbation.location.PerturbationLocation __L1052;

    public static perturbation.location.PerturbationLocation __L1053;

    public static perturbation.location.PerturbationLocation __L1054;

    public static perturbation.location.PerturbationLocation __L1055;

    public static perturbation.location.PerturbationLocation __L1056;

    public static perturbation.location.PerturbationLocation __L1057;

    public static perturbation.location.PerturbationLocation __L1058;

    public static perturbation.location.PerturbationLocation __L1059;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:168)", 975, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:169)", 976, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 977, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 978, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 979, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 980, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 981, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 982, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 983, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:170)", 984, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 985, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 986, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 987, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 988, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 989, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 990, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 991, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:171)", 992, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 993, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 994, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 995, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 996, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 997, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 998, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 999, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:172)", 1000, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1001, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1002, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1003, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1004, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1005, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1006, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1007, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:173)", 1008, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1009, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1010, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1011, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1012, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1013, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1014, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1015, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:174)", 1016, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:175)", 1017, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:180)", 1018, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:181)", 1019, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:182)", 1020, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:183)", 1021, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:184)", 1022, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:184)", 1023, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:185)", 1024, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:188)", 1025, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:188)", 1026, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:188)", 1027, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:189)", 1028, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:192)", 1029, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:193)", 1030, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:194)", 1031, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:195)", 1032, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:195)", 1033, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:196)", 1034, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:197)", 1035, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:198)", 1036, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:199)", 1037, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:200)", 1038, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:200)", 1039, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1040 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:201)", 1040, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1041 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:202)", 1041, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1042 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:203)", 1042, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:204)", 1043, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:205)", 1044, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:205)", 1045, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:206)", 1046, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:207)", 1047, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:208)", 1048, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:209)", 1049, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:210)", 1050, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:210)", 1051, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:211)", 1052, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:212)", 1053, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:213)", 1054, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:214)", 1055, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:215)", 1056, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:215)", 1057, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:216)", 1058, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.__L1059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingImpl.java:217)", 1059, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.domain.EmailTrackingImpl.initPerturbationLocation0();
    }
}

