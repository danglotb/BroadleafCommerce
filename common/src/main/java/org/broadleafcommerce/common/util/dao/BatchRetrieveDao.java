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
package org.broadleafcommerce.common.util.dao;


public class BatchRetrieveDao {
    private int inClauseBatchSize = 300;

    @java.lang.SuppressWarnings("unchecked")
    public <T> java.util.List<T> batchExecuteReadQuery(javax.persistence.Query query, java.util.List<?> params, java.lang.String parameterName) {
        java.util.List<T> response = new java.util.ArrayList<T>();
        int start = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5807, 0);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5810, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5808, start)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5809, params.size()))))) {
            java.util.List<?> batchParams = params.subList(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5811, start), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5817, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5814, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5812, params.size())) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5813, inClauseBatchSize)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5815, params.size()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5816, inClauseBatchSize))));
            query.setParameter(parameterName, batchParams);
            response.addAll(query.getResultList());
            start += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5818, inClauseBatchSize);
        } 
        return response;
    }

    public int getInClauseBatchSize() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5819, inClauseBatchSize);
    }

    public void setInClauseBatchSize(int inClauseBatchSize) {
        this.inClauseBatchSize = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5820, inClauseBatchSize);
    }

    public static perturbation.location.PerturbationLocation __L5807;

    public static perturbation.location.PerturbationLocation __L5808;

    public static perturbation.location.PerturbationLocation __L5809;

    public static perturbation.location.PerturbationLocation __L5810;

    public static perturbation.location.PerturbationLocation __L5811;

    public static perturbation.location.PerturbationLocation __L5812;

    public static perturbation.location.PerturbationLocation __L5813;

    public static perturbation.location.PerturbationLocation __L5814;

    public static perturbation.location.PerturbationLocation __L5815;

    public static perturbation.location.PerturbationLocation __L5816;

    public static perturbation.location.PerturbationLocation __L5817;

    public static perturbation.location.PerturbationLocation __L5818;

    public static perturbation.location.PerturbationLocation __L5819;

    public static perturbation.location.PerturbationLocation __L5820;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:37)", 5807, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:38)", 5808, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:38)", 5809, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:38)", 5810, "Boolean");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5811, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5812, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5813, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5814, "Boolean");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5815, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5816, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:39)", 5817, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:42)", 5818, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:48)", 5819, "Numerical");
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.__L5820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/BatchRetrieveDao.java:52)", 5820, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.dao.BatchRetrieveDao.initPerturbationLocation0();
    }
}

