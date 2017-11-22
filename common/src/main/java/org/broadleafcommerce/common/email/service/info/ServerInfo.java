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
package org.broadleafcommerce.common.email.service.info;


public class ServerInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.String serverName;

    private java.lang.Integer serverPort;

    private java.lang.Integer securePort;

    private java.lang.String appName;

    public java.lang.String getSecureHost() {
        java.lang.StringBuffer sb = new java.lang.StringBuffer();
        sb.append(serverName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1126, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1125, securePort.equals(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1124, 443))))))) {
            sb.append(":");
            sb.append(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1127, securePort));
        }
        return sb.toString();
    }

    public java.lang.String getHost() {
        java.lang.StringBuffer sb = new java.lang.StringBuffer();
        sb.append(serverName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1130, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1129, serverPort.equals(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1128, 80))))))) {
            sb.append(":");
            sb.append(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1131, serverPort));
        }
        return sb.toString();
    }

    public java.lang.String getServerName() {
        return serverName;
    }

    public void setServerName(java.lang.String serverName) {
        this.serverName = serverName;
    }

    public java.lang.Integer getServerPort() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1132, serverPort);
    }

    public void setServerPort(java.lang.Integer serverPort) {
        this.serverPort = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1133, serverPort);
    }

    public java.lang.Integer getSecurePort() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1134, securePort);
    }

    public void setSecurePort(java.lang.Integer securePort) {
        this.securePort = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.info.ServerInfo.__L1135, securePort);
    }

    public java.lang.String getAppName() {
        return appName;
    }

    public void setAppName(java.lang.String appName) {
        this.appName = appName;
    }

    public static perturbation.location.PerturbationLocation __L1124;

    public static perturbation.location.PerturbationLocation __L1125;

    public static perturbation.location.PerturbationLocation __L1126;

    public static perturbation.location.PerturbationLocation __L1127;

    public static perturbation.location.PerturbationLocation __L1128;

    public static perturbation.location.PerturbationLocation __L1129;

    public static perturbation.location.PerturbationLocation __L1130;

    public static perturbation.location.PerturbationLocation __L1131;

    public static perturbation.location.PerturbationLocation __L1132;

    public static perturbation.location.PerturbationLocation __L1133;

    public static perturbation.location.PerturbationLocation __L1134;

    public static perturbation.location.PerturbationLocation __L1135;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:38)", 1124, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:38)", 1125, "Boolean");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:38)", 1126, "Boolean");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:40)", 1127, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:48)", 1128, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:48)", 1129, "Boolean");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:48)", 1130, "Boolean");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:50)", 1131, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:73)", 1132, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:80)", 1133, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:87)", 1134, "Numerical");
        org.broadleafcommerce.common.email.service.info.ServerInfo.__L1135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/info/ServerInfo.java:94)", 1135, "Numerical");
    }

    static {
        org.broadleafcommerce.common.email.service.info.ServerInfo.initPerturbationLocation0();
    }
}

