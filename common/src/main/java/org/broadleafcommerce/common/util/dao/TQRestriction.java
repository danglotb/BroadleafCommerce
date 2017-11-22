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


public class TQRestriction {
    public enum Mode {
        OR, AND;}

    protected java.lang.String expression;

    protected java.lang.String operation;

    protected java.lang.Object parameter;

    protected org.broadleafcommerce.common.util.dao.TQRestriction.Mode joinMode;

    protected java.util.List<org.broadleafcommerce.common.util.dao.TQRestriction> restrictions = new java.util.ArrayList<org.broadleafcommerce.common.util.dao.TQRestriction>();

    public TQRestriction(java.lang.String expression, java.lang.String operation) {
        this.expression = expression;
        this.operation = operation.toLowerCase();
    }

    public TQRestriction(java.lang.String expression, java.lang.String operation, java.lang.Object parameter) {
        this(expression, operation);
        this.parameter = parameter;
    }

    public TQRestriction(org.broadleafcommerce.common.util.dao.TQRestriction.Mode joinMode) {
        this.joinMode = joinMode;
    }

    public org.broadleafcommerce.common.util.dao.TQRestriction addChildRestriction(org.broadleafcommerce.common.util.dao.TQRestriction r) {
        restrictions.add(r);
        return this;
    }

    public java.lang.String toQl(java.lang.String parameterName, java.util.Map<java.lang.String, java.lang.Object> paramMap) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5899, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5897, ((expression) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5898, ((operation) != null)))))) {
            sb.append(expression).append(" ").append(operation);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5900, ((parameter) != null))) {
                sb.append(' ');
                java.lang.String pname = ':' + parameterName;
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5903, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5901, operation.equals("in"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5902, operation.equals("not in")))))) {
                    pname = ("(" + pname) + ")";
                }
                sb.append(pname);
                paramMap.put(parameterName, parameter);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5904, org.apache.commons.collections.CollectionUtils.isNotEmpty(restrictions))) {
            for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5905, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5908, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5906, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5907, restrictions.size())))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5909, (i++))) {
                org.broadleafcommerce.common.util.dao.TQRestriction r = restrictions.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5910, i));
                java.lang.String internalParamName = (parameterName + "_") + i;
                sb.append(r.toQl(internalParamName, paramMap));
                paramMap.put(internalParamName, r.parameter);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5915, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5913, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5911, restrictions.size())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5912, 1))))) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.dao.TQRestriction.__L5914, i))))) {
                    sb.append((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.dao.TQRestriction.__L5916, ((joinMode) == (org.broadleafcommerce.common.util.dao.TQRestriction.Mode.OR))) ? " OR " : " AND "));
                }
            }
        }
        return sb.append(")").toString();
    }

    public static perturbation.location.PerturbationLocation __L5897;

    public static perturbation.location.PerturbationLocation __L5898;

    public static perturbation.location.PerturbationLocation __L5899;

    public static perturbation.location.PerturbationLocation __L5900;

    public static perturbation.location.PerturbationLocation __L5901;

    public static perturbation.location.PerturbationLocation __L5902;

    public static perturbation.location.PerturbationLocation __L5903;

    public static perturbation.location.PerturbationLocation __L5904;

    public static perturbation.location.PerturbationLocation __L5905;

    public static perturbation.location.PerturbationLocation __L5906;

    public static perturbation.location.PerturbationLocation __L5907;

    public static perturbation.location.PerturbationLocation __L5908;

    public static perturbation.location.PerturbationLocation __L5909;

    public static perturbation.location.PerturbationLocation __L5910;

    public static perturbation.location.PerturbationLocation __L5911;

    public static perturbation.location.PerturbationLocation __L5912;

    public static perturbation.location.PerturbationLocation __L5913;

    public static perturbation.location.PerturbationLocation __L5914;

    public static perturbation.location.PerturbationLocation __L5915;

    public static perturbation.location.PerturbationLocation __L5916;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5897 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:98)", 5897, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5898 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:98)", 5898, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5899 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:98)", 5899, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5900 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:101)", 5900, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5901 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:104)", 5901, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5902 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:104)", 5902, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:104)", 5903, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:112)", 5904, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:113)", 5905, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:113)", 5906, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:113)", 5907, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:113)", 5908, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5909 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:113)", 5909, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5910 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:114)", 5910, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5911 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:120)", 5911, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5912 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:120)", 5912, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5913 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:120)", 5913, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5914 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:120)", 5914, "Numerical");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5915 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:120)", 5915, "Boolean");
        org.broadleafcommerce.common.util.dao.TQRestriction.__L5916 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/dao/TQRestriction.java:121)", 5916, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.dao.TQRestriction.initPerturbationLocation0();
    }
}

