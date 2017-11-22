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
@javax.persistence.Table(name = "BLC_EMAIL_TRACKING_CLICKS")
public class EmailTrackingClicksImpl implements org.broadleafcommerce.common.email.domain.EmailTrackingClicks {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(generator = "ClickId")
    @org.hibernate.annotations.GenericGenerator(name = "ClickId", strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator", parameters = { @org.hibernate.annotations.Parameter(name = "segment_value", value = "EmailTrackingClicksImpl"), @org.hibernate.annotations.Parameter(name = "entity_name", value = "org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl") })
    @javax.persistence.Column(name = "CLICK_ID")
    protected java.lang.Long id;

    @javax.persistence.ManyToOne(optional = false, targetEntity = org.broadleafcommerce.common.email.domain.EmailTrackingImpl.class)
    @javax.persistence.JoinColumn(name = "EMAIL_TRACKING_ID")
    @org.hibernate.annotations.Index(name = "TRACKINGCLICKS_TRACKING_INDEX", columnNames = { "EMAIL_TRACKING_ID" })
    protected org.broadleafcommerce.common.email.domain.EmailTracking emailTracking;

    @javax.persistence.Column(nullable = false, name = "DATE_CLICKED")
    protected java.util.Date dateClicked;

    @javax.persistence.Column(name = "CUSTOMER_ID")
    @org.hibernate.annotations.Index(name = "TRACKINGCLICKS_CUSTOMER_INDEX", columnNames = { "CUSTOMER_ID" })
    protected java.lang.String customerId;

    @javax.persistence.Column(name = "DESTINATION_URI")
    protected java.lang.String destinationUri;

    @javax.persistence.Column(name = "QUERY_STRING")
    protected java.lang.String queryString;

    @java.lang.Override
    public java.lang.Long getId() {
        return id;
    }

    @java.lang.Override
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.util.Date getDateClicked() {
        return dateClicked;
    }

    @java.lang.Override
    public void setDateClicked(java.util.Date dateClicked) {
        this.dateClicked = dateClicked;
    }

    @java.lang.Override
    public java.lang.String getDestinationUri() {
        return destinationUri;
    }

    @java.lang.Override
    public void setDestinationUri(java.lang.String destinationUri) {
        this.destinationUri = destinationUri;
    }

    @java.lang.Override
    public java.lang.String getQueryString() {
        return queryString;
    }

    @java.lang.Override
    public void setQueryString(java.lang.String queryString) {
        this.queryString = queryString;
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
    public java.lang.String getCustomerId() {
        return customerId;
    }

    @java.lang.Override
    public void setCustomerId(java.lang.String customerId) {
        this.customerId = customerId;
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L904, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L905, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L913, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L908, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L906, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L907, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L912, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L909, ((customerId) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L910, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L911, customerId.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L921, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L916, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L914, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L915, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L920, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L917, ((dateClicked) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L918, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L919, dateClicked.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L929, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L924, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L922, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L923, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L928, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L925, ((destinationUri) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L926, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L927, destinationUri.hashCode()))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L937, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L932, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L930, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L931, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L936, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L933, ((emailTracking) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L934, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L935, emailTracking.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L938, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L939, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L940, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L941, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L942, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L944, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L943, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L945, false);

        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl other = ((org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L948, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L946, ((id) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L947, ((other.id) != null)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L949, id.equals(other.id));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L950, ((customerId) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L951, ((other.customerId) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L952, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L954, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L953, customerId.equals(other.customerId))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L955, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L956, ((dateClicked) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L957, ((other.dateClicked) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L958, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L960, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L959, dateClicked.equals(other.dateClicked))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L961, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L962, ((destinationUri) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L963, ((other.destinationUri) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L964, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L966, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L965, destinationUri.equals(other.destinationUri))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L967, false);


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L968, ((emailTracking) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L969, ((other.emailTracking) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L970, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L972, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L971, emailTracking.equals(other.emailTracking))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L973, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L974, true);
    }

    public static perturbation.location.PerturbationLocation __L904;

    public static perturbation.location.PerturbationLocation __L905;

    public static perturbation.location.PerturbationLocation __L906;

    public static perturbation.location.PerturbationLocation __L907;

    public static perturbation.location.PerturbationLocation __L908;

    public static perturbation.location.PerturbationLocation __L909;

    public static perturbation.location.PerturbationLocation __L910;

    public static perturbation.location.PerturbationLocation __L911;

    public static perturbation.location.PerturbationLocation __L912;

    public static perturbation.location.PerturbationLocation __L913;

    public static perturbation.location.PerturbationLocation __L914;

    public static perturbation.location.PerturbationLocation __L915;

    public static perturbation.location.PerturbationLocation __L916;

    public static perturbation.location.PerturbationLocation __L917;

    public static perturbation.location.PerturbationLocation __L918;

    public static perturbation.location.PerturbationLocation __L919;

    public static perturbation.location.PerturbationLocation __L920;

    public static perturbation.location.PerturbationLocation __L921;

    public static perturbation.location.PerturbationLocation __L922;

    public static perturbation.location.PerturbationLocation __L923;

    public static perturbation.location.PerturbationLocation __L924;

    public static perturbation.location.PerturbationLocation __L925;

    public static perturbation.location.PerturbationLocation __L926;

    public static perturbation.location.PerturbationLocation __L927;

    public static perturbation.location.PerturbationLocation __L928;

    public static perturbation.location.PerturbationLocation __L929;

    public static perturbation.location.PerturbationLocation __L930;

    public static perturbation.location.PerturbationLocation __L931;

    public static perturbation.location.PerturbationLocation __L932;

    public static perturbation.location.PerturbationLocation __L933;

    public static perturbation.location.PerturbationLocation __L934;

    public static perturbation.location.PerturbationLocation __L935;

    public static perturbation.location.PerturbationLocation __L936;

    public static perturbation.location.PerturbationLocation __L937;

    public static perturbation.location.PerturbationLocation __L938;

    public static perturbation.location.PerturbationLocation __L939;

    public static perturbation.location.PerturbationLocation __L940;

    public static perturbation.location.PerturbationLocation __L941;

    public static perturbation.location.PerturbationLocation __L942;

    public static perturbation.location.PerturbationLocation __L943;

    public static perturbation.location.PerturbationLocation __L944;

    public static perturbation.location.PerturbationLocation __L945;

    public static perturbation.location.PerturbationLocation __L946;

    public static perturbation.location.PerturbationLocation __L947;

    public static perturbation.location.PerturbationLocation __L948;

    public static perturbation.location.PerturbationLocation __L949;

    public static perturbation.location.PerturbationLocation __L950;

    public static perturbation.location.PerturbationLocation __L951;

    public static perturbation.location.PerturbationLocation __L952;

    public static perturbation.location.PerturbationLocation __L953;

    public static perturbation.location.PerturbationLocation __L954;

    public static perturbation.location.PerturbationLocation __L955;

    public static perturbation.location.PerturbationLocation __L956;

    public static perturbation.location.PerturbationLocation __L957;

    public static perturbation.location.PerturbationLocation __L958;

    public static perturbation.location.PerturbationLocation __L959;

    public static perturbation.location.PerturbationLocation __L960;

    public static perturbation.location.PerturbationLocation __L961;

    public static perturbation.location.PerturbationLocation __L962;

    public static perturbation.location.PerturbationLocation __L963;

    public static perturbation.location.PerturbationLocation __L964;

    public static perturbation.location.PerturbationLocation __L965;

    public static perturbation.location.PerturbationLocation __L966;

    public static perturbation.location.PerturbationLocation __L967;

    public static perturbation.location.PerturbationLocation __L968;

    public static perturbation.location.PerturbationLocation __L969;

    public static perturbation.location.PerturbationLocation __L970;

    public static perturbation.location.PerturbationLocation __L971;

    public static perturbation.location.PerturbationLocation __L972;

    public static perturbation.location.PerturbationLocation __L973;

    public static perturbation.location.PerturbationLocation __L974;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:174)", 904, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:175)", 905, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 906, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 907, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 908, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 909, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 910, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 911, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 912, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:176)", 913, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 914, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 915, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 916, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 917, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 918, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 919, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 920, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:177)", 921, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 922, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 923, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 924, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 925, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 926, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 927, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 928, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:178)", 929, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 930, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 931, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 932, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 933, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 934, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 935, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 936, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:179)", 937, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:180)", 938, "Numerical");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:185)", 939, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:186)", 940, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:187)", 941, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:188)", 942, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:189)", 943, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:189)", 944, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:190)", 945, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:193)", 946, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:193)", 947, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:193)", 948, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:194)", 949, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:197)", 950, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:198)", 951, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:199)", 952, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:200)", 953, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:200)", 954, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:201)", 955, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:202)", 956, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:203)", 957, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:204)", 958, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:205)", 959, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:205)", 960, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:206)", 961, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:207)", 962, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:208)", 963, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:209)", 964, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:210)", 965, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:210)", 966, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:211)", 967, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:212)", 968, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:213)", 969, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:214)", 970, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:215)", 971, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:215)", 972, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:216)", 973, "Boolean");
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.__L974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/domain/EmailTrackingClicksImpl.java:217)", 974, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.domain.EmailTrackingClicksImpl.initPerturbationLocation0();
    }
}

