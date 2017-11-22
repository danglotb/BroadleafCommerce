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
package org.broadleafcommerce.common.email.service.message;


public class EmailPropertyType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.email.service.message.EmailPropertyType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.email.service.message.EmailPropertyType>();

    public static final org.broadleafcommerce.common.email.service.message.EmailPropertyType USER = new org.broadleafcommerce.common.email.service.message.EmailPropertyType("user", "User");

    public static final org.broadleafcommerce.common.email.service.message.EmailPropertyType INFO = new org.broadleafcommerce.common.email.service.message.EmailPropertyType("info", "Info");

    public static final org.broadleafcommerce.common.email.service.message.EmailPropertyType SERVERINFO = new org.broadleafcommerce.common.email.service.message.EmailPropertyType("serverInfo", "Server Info");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.email.service.message.EmailPropertyType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.email.service.message.EmailPropertyType.TYPES.get(type);
    }

    public EmailPropertyType() {
    }

    public EmailPropertyType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1139, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1138, org.broadleafcommerce.common.email.service.message.EmailPropertyType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.email.service.message.EmailPropertyType.TYPES.put(type, this);
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1140, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1141, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1149, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1144, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1142, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1143, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1148, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1145, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1146, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1147, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1150, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1151, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1152, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1153, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1154, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1156, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1155, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1157, false);

        org.broadleafcommerce.common.email.service.message.EmailPropertyType other = ((org.broadleafcommerce.common.email.service.message.EmailPropertyType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1158, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1159, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1160, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1162, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1161, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1163, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1164, true);
    }

    public static perturbation.location.PerturbationLocation __L1138;

    public static perturbation.location.PerturbationLocation __L1139;

    public static perturbation.location.PerturbationLocation __L1140;

    public static perturbation.location.PerturbationLocation __L1141;

    public static perturbation.location.PerturbationLocation __L1142;

    public static perturbation.location.PerturbationLocation __L1143;

    public static perturbation.location.PerturbationLocation __L1144;

    public static perturbation.location.PerturbationLocation __L1145;

    public static perturbation.location.PerturbationLocation __L1146;

    public static perturbation.location.PerturbationLocation __L1147;

    public static perturbation.location.PerturbationLocation __L1148;

    public static perturbation.location.PerturbationLocation __L1149;

    public static perturbation.location.PerturbationLocation __L1150;

    public static perturbation.location.PerturbationLocation __L1151;

    public static perturbation.location.PerturbationLocation __L1152;

    public static perturbation.location.PerturbationLocation __L1153;

    public static perturbation.location.PerturbationLocation __L1154;

    public static perturbation.location.PerturbationLocation __L1155;

    public static perturbation.location.PerturbationLocation __L1156;

    public static perturbation.location.PerturbationLocation __L1157;

    public static perturbation.location.PerturbationLocation __L1158;

    public static perturbation.location.PerturbationLocation __L1159;

    public static perturbation.location.PerturbationLocation __L1160;

    public static perturbation.location.PerturbationLocation __L1161;

    public static perturbation.location.PerturbationLocation __L1162;

    public static perturbation.location.PerturbationLocation __L1163;

    public static perturbation.location.PerturbationLocation __L1164;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:68)", 1138, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:68)", 1139, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:75)", 1140, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:76)", 1141, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1142, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1143, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1144, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1145, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1146, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1147, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1148, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:77)", 1149, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:78)", 1150, "Numerical");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:83)", 1151, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1152 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:84)", 1152, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1153 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:85)", 1153, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1154 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:86)", 1154, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1155 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:87)", 1155, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1156 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:87)", 1156, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1157 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:88)", 1157, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1158 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:90)", 1158, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1159 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:91)", 1159, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1160 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:92)", 1160, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1161 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:93)", 1161, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1162 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:93)", 1162, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1163 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:94)", 1163, "Boolean");
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.__L1164 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/message/EmailPropertyType.java:95)", 1164, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.service.message.EmailPropertyType.initPerturbationLocation0();
    }
}

