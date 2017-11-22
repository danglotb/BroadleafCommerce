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
package org.broadleafcommerce.common.email.service;


@org.springframework.stereotype.Service("blEmailTrackingManager")
public class EmailTrackingManagerImpl implements org.broadleafcommerce.common.email.service.EmailTrackingManager {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.class);

    @javax.annotation.Resource(name = "blEmailReportingDao")
    protected org.broadleafcommerce.common.email.dao.EmailReportingDao emailReportingDao;

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(org.broadleafcommerce.common.util.TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public java.lang.Long createTrackedEmail(java.lang.String emailAddress, java.lang.String type, java.lang.String extraValue) {
        return emailReportingDao.createTracking(emailAddress, type, extraValue);
    }

    @java.lang.Override
    @org.springframework.transaction.annotation.Transactional(org.broadleafcommerce.common.util.TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public void recordClick(java.lang.Long emailId, java.util.Map<java.lang.String, java.lang.String> parameterMap, java.lang.String customerId, java.util.Map<java.lang.String, java.lang.String> extraValues) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1194, org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.LOG.debug((("recordClick() => Click detected for Email[" + emailId) + "]"));
        }
        java.util.Iterator<java.lang.String> keys = parameterMap.keySet().iterator();
        java.util.ArrayList<java.lang.String> queryParms = new java.util.ArrayList<java.lang.String>();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1195, keys.hasNext())) {
            java.lang.String p = keys.next();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1197, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1196, p.equals("email_id")))))) {
                queryParms.add(p);
            }
        } 
        java.lang.String newQuery = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1199, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1198, queryParms.isEmpty()))))) {
            java.lang.String[] p = queryParms.toArray(new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1200, queryParms.size())]);
            java.util.Arrays.sort(p);
            java.lang.StringBuffer newQueryParms = new java.lang.StringBuffer();
            for (int cnt = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1201, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1204, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1202, cnt)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1203, p.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1205, (cnt++))) {
                newQueryParms.append(p[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1206, cnt)]);
                newQueryParms.append("=");
                newQueryParms.append(parameterMap.get(p[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1207, cnt)]));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1212, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1208, cnt)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1211, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1209, p.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1210, 1)))))))) {
                    newQueryParms.append("&");
                }
            }
            newQuery = newQueryParms.toString();
        }
        emailReportingDao.recordClick(emailId, customerId, extraValues.get("requestUri"), newQuery);
    }

    @java.lang.Override
    public void recordOpen(java.lang.Long emailId, java.util.Map<java.lang.String, java.lang.String> extraValues) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1213, org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.LOG.isDebugEnabled())) {
            org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.LOG.debug(("Recording open for email id: " + emailId));
        }
        emailReportingDao.recordOpen(emailId, extraValues.get("userAgent"));
    }

    public static perturbation.location.PerturbationLocation __L1194;

    public static perturbation.location.PerturbationLocation __L1195;

    public static perturbation.location.PerturbationLocation __L1196;

    public static perturbation.location.PerturbationLocation __L1197;

    public static perturbation.location.PerturbationLocation __L1198;

    public static perturbation.location.PerturbationLocation __L1199;

    public static perturbation.location.PerturbationLocation __L1200;

    public static perturbation.location.PerturbationLocation __L1201;

    public static perturbation.location.PerturbationLocation __L1202;

    public static perturbation.location.PerturbationLocation __L1203;

    public static perturbation.location.PerturbationLocation __L1204;

    public static perturbation.location.PerturbationLocation __L1205;

    public static perturbation.location.PerturbationLocation __L1206;

    public static perturbation.location.PerturbationLocation __L1207;

    public static perturbation.location.PerturbationLocation __L1208;

    public static perturbation.location.PerturbationLocation __L1209;

    public static perturbation.location.PerturbationLocation __L1210;

    public static perturbation.location.PerturbationLocation __L1211;

    public static perturbation.location.PerturbationLocation __L1212;

    public static perturbation.location.PerturbationLocation __L1213;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:54)", 1194, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:61)", 1195, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:64)", 1196, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:64)", 1197, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:71)", 1198, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:71)", 1199, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:73)", 1200, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1201 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:77)", 1201, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1202 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:77)", 1202, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1203 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:77)", 1203, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1204 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:77)", 1204, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1205 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:77)", 1205, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1206 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:78)", 1206, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1207 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:80)", 1207, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1208 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:81)", 1208, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1209 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:81)", 1209, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1210 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:81)", 1210, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1211 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:81)", 1211, "Numerical");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1212 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:81)", 1212, "Boolean");
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.__L1213 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/email/service/EmailTrackingManagerImpl.java:99)", 1213, "Boolean");
    }

    static {
        org.broadleafcommerce.common.email.service.EmailTrackingManagerImpl.initPerturbationLocation0();
    }
}

