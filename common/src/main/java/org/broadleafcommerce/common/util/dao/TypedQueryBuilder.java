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


public class TypedQueryBuilder<T> {
    protected java.lang.Class<T> rootClass;

    protected java.lang.String rootAlias;

    protected java.util.List<org.broadleafcommerce.common.util.dao.TQRestriction> restrictions = new java.util.ArrayList<org.broadleafcommerce.common.util.dao.TQRestriction>();

    protected java.util.List<org.broadleafcommerce.common.util.dao.TQJoin> joins = new java.util.ArrayList<org.broadleafcommerce.common.util.dao.TQJoin>();

    protected java.util.List<org.broadleafcommerce.common.util.dao.TQOrder> orders = new java.util.ArrayList<org.broadleafcommerce.common.util.dao.TQOrder>();

    protected java.util.Map<java.lang.String, java.lang.Object> paramMap = new java.util.HashMap<java.lang.String, java.lang.Object>();

    public TypedQueryBuilder(java.lang.Class<T> rootClass, java.lang.String rootAlias) {
        this.rootClass = rootClass;
        this.rootAlias = rootAlias;
    }

    public org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T> addRestriction(java.lang.String expression, java.lang.String operation, java.lang.Object parameter) {
        restrictions.add(new org.broadleafcommerce.common.util.dao.TQRestriction(expression, operation, parameter));
        return this;
    }

    public org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T> addRestriction(org.broadleafcommerce.common.util.dao.TQRestriction restriction) {
        restrictions.add(restriction);
        return this;
    }

    public org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T> addJoin(org.broadleafcommerce.common.util.dao.TQJoin join) {
        joins.add(join);
        return this;
    }

    public org.broadleafcommerce.common.util.dao.TypedQueryBuilder<T> addOrder(org.broadleafcommerce.common.util.dao.TQOrder order) {
        orders.add(order);
        return this;
    }

    public java.lang.String toQueryString() {
        return toQueryString(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5917, false));
    }

    public java.lang.String toQueryString(boolean count) {
        java.lang.StringBuilder sb = getSelectClause(new java.lang.StringBuilder(), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5918, count)).append(" FROM ").append(rootClass.getName()).append(" ").append(rootAlias);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5919, org.apache.commons.collections.CollectionUtils.isNotEmpty(joins))) {
            for (org.broadleafcommerce.common.util.dao.TQJoin join : joins) {
                sb.append(" JOIN");
                sb.append(" ");
                sb.append(join.toQl());
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5920, org.apache.commons.collections.CollectionUtils.isNotEmpty(restrictions))) {
            sb.append(" WHERE ");
            for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5921, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5924, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5922, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5923, restrictions.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5925, (i++))) {
                org.broadleafcommerce.common.util.dao.TQRestriction r = restrictions.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5926, i));
                sb.append(r.toQl(("p" + i), paramMap));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5931, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5927, i)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5930, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5928, restrictions.size())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5929, 1)))))))) {
                    sb.append(" AND ");
                }
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5932, org.apache.commons.collections.CollectionUtils.isNotEmpty(orders))) {
            sb.append(" ORDER BY");
            for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5933, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5936, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5934, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5935, orders.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5937, (j++))) {
                sb.append(" ");
                sb.append(orders.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5938, j)).toQl());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5943, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5939, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5942, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5940, orders.size())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5941, 1)))))))) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    protected java.lang.StringBuilder getSelectClause(java.lang.StringBuilder sb, boolean count) {
        sb.append("SELECT ");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5944, count)) {
            return sb.append("COUNT(*)");
        }else {
            return sb.append(rootAlias);
        }
    }

    public javax.persistence.TypedQuery<T> toQuery(javax.persistence.EntityManager em) {
        javax.persistence.TypedQuery<T> q = em.createQuery(toQueryString(), rootClass);
        fillParameterMap(q);
        return q;
    }

    public javax.persistence.TypedQuery<java.lang.Long> toCountQuery(javax.persistence.EntityManager em) {
        javax.persistence.TypedQuery<java.lang.Long> q = em.createQuery(toQueryString(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5945, true)), java.lang.Long.class);
        fillParameterMap(q);
        return q;
    }

    protected void fillParameterMap(javax.persistence.TypedQuery<?> q) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : paramMap.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5946, ((entry.getValue()) != null))) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getParamMap() {
        return paramMap;
    }

    public static perturbation.location.PerturbationLocation __L5917;

    public static perturbation.location.PerturbationLocation __L5918;

    public static perturbation.location.PerturbationLocation __L5919;

    public static perturbation.location.PerturbationLocation __L5920;

    public static perturbation.location.PerturbationLocation __L5921;

    public static perturbation.location.PerturbationLocation __L5922;

    public static perturbation.location.PerturbationLocation __L5923;

    public static perturbation.location.PerturbationLocation __L5924;

    public static perturbation.location.PerturbationLocation __L5925;

    public static perturbation.location.PerturbationLocation __L5926;

    public static perturbation.location.PerturbationLocation __L5927;

    public static perturbation.location.PerturbationLocation __L5928;

    public static perturbation.location.PerturbationLocation __L5929;

    public static perturbation.location.PerturbationLocation __L5930;

    public static perturbation.location.PerturbationLocation __L5931;

    public static perturbation.location.PerturbationLocation __L5932;

    public static perturbation.location.PerturbationLocation __L5933;

    public static perturbation.location.PerturbationLocation __L5934;

    public static perturbation.location.PerturbationLocation __L5935;

    public static perturbation.location.PerturbationLocation __L5936;

    public static perturbation.location.PerturbationLocation __L5937;

    public static perturbation.location.PerturbationLocation __L5938;

    public static perturbation.location.PerturbationLocation __L5939;

    public static perturbation.location.PerturbationLocation __L5940;

    public static perturbation.location.PerturbationLocation __L5941;

    public static perturbation.location.PerturbationLocation __L5942;

    public static perturbation.location.PerturbationLocation __L5943;

    public static perturbation.location.PerturbationLocation __L5944;

    public static perturbation.location.PerturbationLocation __L5945;

    public static perturbation.location.PerturbationLocation __L5946;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5917 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:104)", 5917, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:120)", 5918, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:122)", 5919, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:129)", 5920, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:131)", 5921, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:131)", 5922, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:131)", 5923, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:131)", 5924, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:131)", 5925, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:132)", 5926, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:134)", 5927, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:134)", 5928, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:134)", 5929, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:134)", 5930, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:134)", 5931, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:139)", 5932, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:141)", 5933, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:141)", 5934, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:141)", 5935, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:141)", 5936, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:141)", 5937, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:143)", 5938, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:144)", 5939, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:144)", 5940, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:144)", 5941, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:144)", 5942, "Numerical");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:144)", 5943, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:159)", 5944, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:180)", 5945, "Boolean");
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.__L5946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TypedQueryBuilder.java:187)", 5946, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.dao.TypedQueryBuilder.initPerturbationLocation0();
    }
}

