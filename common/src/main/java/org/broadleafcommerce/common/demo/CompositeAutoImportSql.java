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
package org.broadleafcommerce.common.demo;


@org.springframework.stereotype.Component("blCompositeAutoImportSql")
public class CompositeAutoImportSql {
    @org.springframework.beans.factory.annotation.Autowired(required = false)
    protected java.util.List<org.broadleafcommerce.common.demo.AutoImportSql> importSqlList = new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>();

    public java.lang.String compileSqlFilePathList(java.lang.String persistenceUnit) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (org.broadleafcommerce.common.demo.AutoImportSql sql : importSqlList) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L774, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L772, persistenceUnit.equals(sql.getPersistenceUnit()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L773, org.broadleafcommerce.common.demo.AutoImportPersistenceUnit.ALL.equals(sql.getPersistenceUnit())))))) {
                sb.append(sql.getSqlFilePath());
                sb.append(",");
            }
        }
        java.lang.String response = sb.toString();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L775, response.endsWith(","))) {
            response = response.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L776, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L779, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L777, response.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L778, 1)))));
        }
        return response;
    }

    public java.util.Map<java.lang.String, java.util.List<org.broadleafcommerce.common.demo.AutoImportSql>> constructAutoImportSqlMapForPU(java.lang.String persistenceUnit) {
        java.util.Map<java.lang.String, java.util.List<org.broadleafcommerce.common.demo.AutoImportSql>> sqlMap = new java.util.LinkedHashMap<>();
        sqlMap.put("AutoImportStage.PRIMARY_EARLY", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_MODULE_SECURITY", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_POST_MODULE_SECURITY", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_PRE_BASIC_DATA", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_BASIC_DATA", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_POST_BASIC_DATA", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.ALL_TABLE_SEQUENCE", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        sqlMap.put("AutoImportStage.PRIMARY_LATE", new java.util.ArrayList<org.broadleafcommerce.common.demo.AutoImportSql>());
        for (org.broadleafcommerce.common.demo.AutoImportSql sql : importSqlList) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L782, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L780, persistenceUnit.equals(sql.getPersistenceUnit()))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L781, org.broadleafcommerce.common.demo.AutoImportPersistenceUnit.ALL.equals(sql.getPersistenceUnit())))))) {
                int order = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L783, sql.getOrder());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L786, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L784, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L785, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_FRAMEWORK_SECURITY))))) {
                    sqlMap.get("AutoImportStage.PRIMARY_EARLY").add(sql);
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L793, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L789, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L787, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L788, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_FRAMEWORK_SECURITY))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L792, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L790, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L791, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_PRE_MODULE_SECURITY)))))))) {
                        sqlMap.get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY").add(sql);
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L800, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L796, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L794, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L795, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_PRE_MODULE_SECURITY))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L799, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L797, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L798, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_MODULE_SECURITY)))))))) {
                            sqlMap.get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY").add(sql);
                        }else
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L807, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L803, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L801, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L802, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_MODULE_SECURITY))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L806, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L804, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L805, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_POST_MODULE_SECURITY)))))))) {
                                sqlMap.get("AutoImportStage.PRIMARY_MODULE_SECURITY").add(sql);
                            }else
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L814, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L810, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L808, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L809, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_POST_MODULE_SECURITY))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L813, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L811, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L812, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_PRE_BASIC_DATA)))))))) {
                                    sqlMap.get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY").add(sql);
                                }else
                                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L821, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L817, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L815, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L816, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_PRE_BASIC_DATA))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L820, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L818, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L819, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_BASIC_DATA)))))))) {
                                        sqlMap.get("AutoImportStage.PRIMARY_PRE_BASIC_DATA").add(sql);
                                    }else
                                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L828, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L824, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L822, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L823, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_BASIC_DATA))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L827, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L825, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L826, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_POST_BASIC_DATA)))))))) {
                                            sqlMap.get("AutoImportStage.PRIMARY_BASIC_DATA").add(sql);
                                        }else
                                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L835, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L831, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L829, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L830, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_POST_BASIC_DATA))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L834, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L832, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L833, org.broadleafcommerce.common.demo.AutoImportStage.ALL_TABLE_SEQUENCE)))))))) {
                                                sqlMap.get("AutoImportStage.PRIMARY_POST_BASIC_DATA").add(sql);
                                            }else
                                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L842, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L838, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L836, order)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L837, org.broadleafcommerce.common.demo.AutoImportStage.ALL_TABLE_SEQUENCE))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L841, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L839, order)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L840, org.broadleafcommerce.common.demo.AutoImportStage.PRIMARY_LATE)))))))) {
                                                    sqlMap.get("AutoImportStage.ALL_TABLE_SEQUENCE").add(sql);
                                                }else {
                                                    sqlMap.get("AutoImportStage.PRIMARY_LATE").add(sql);
                                                }








            }
        }
        return sqlMap;
    }

    public static perturbation.location.PerturbationLocation __L772;

    public static perturbation.location.PerturbationLocation __L773;

    public static perturbation.location.PerturbationLocation __L774;

    public static perturbation.location.PerturbationLocation __L775;

    public static perturbation.location.PerturbationLocation __L776;

    public static perturbation.location.PerturbationLocation __L777;

    public static perturbation.location.PerturbationLocation __L778;

    public static perturbation.location.PerturbationLocation __L779;

    public static perturbation.location.PerturbationLocation __L780;

    public static perturbation.location.PerturbationLocation __L781;

    public static perturbation.location.PerturbationLocation __L782;

    public static perturbation.location.PerturbationLocation __L783;

    public static perturbation.location.PerturbationLocation __L784;

    public static perturbation.location.PerturbationLocation __L785;

    public static perturbation.location.PerturbationLocation __L786;

    public static perturbation.location.PerturbationLocation __L787;

    public static perturbation.location.PerturbationLocation __L788;

    public static perturbation.location.PerturbationLocation __L789;

    public static perturbation.location.PerturbationLocation __L790;

    public static perturbation.location.PerturbationLocation __L791;

    public static perturbation.location.PerturbationLocation __L792;

    public static perturbation.location.PerturbationLocation __L793;

    public static perturbation.location.PerturbationLocation __L794;

    public static perturbation.location.PerturbationLocation __L795;

    public static perturbation.location.PerturbationLocation __L796;

    public static perturbation.location.PerturbationLocation __L797;

    public static perturbation.location.PerturbationLocation __L798;

    public static perturbation.location.PerturbationLocation __L799;

    public static perturbation.location.PerturbationLocation __L800;

    public static perturbation.location.PerturbationLocation __L801;

    public static perturbation.location.PerturbationLocation __L802;

    public static perturbation.location.PerturbationLocation __L803;

    public static perturbation.location.PerturbationLocation __L804;

    public static perturbation.location.PerturbationLocation __L805;

    public static perturbation.location.PerturbationLocation __L806;

    public static perturbation.location.PerturbationLocation __L807;

    public static perturbation.location.PerturbationLocation __L808;

    public static perturbation.location.PerturbationLocation __L809;

    public static perturbation.location.PerturbationLocation __L810;

    public static perturbation.location.PerturbationLocation __L811;

    public static perturbation.location.PerturbationLocation __L812;

    public static perturbation.location.PerturbationLocation __L813;

    public static perturbation.location.PerturbationLocation __L814;

    public static perturbation.location.PerturbationLocation __L815;

    public static perturbation.location.PerturbationLocation __L816;

    public static perturbation.location.PerturbationLocation __L817;

    public static perturbation.location.PerturbationLocation __L818;

    public static perturbation.location.PerturbationLocation __L819;

    public static perturbation.location.PerturbationLocation __L820;

    public static perturbation.location.PerturbationLocation __L821;

    public static perturbation.location.PerturbationLocation __L822;

    public static perturbation.location.PerturbationLocation __L823;

    public static perturbation.location.PerturbationLocation __L824;

    public static perturbation.location.PerturbationLocation __L825;

    public static perturbation.location.PerturbationLocation __L826;

    public static perturbation.location.PerturbationLocation __L827;

    public static perturbation.location.PerturbationLocation __L828;

    public static perturbation.location.PerturbationLocation __L829;

    public static perturbation.location.PerturbationLocation __L830;

    public static perturbation.location.PerturbationLocation __L831;

    public static perturbation.location.PerturbationLocation __L832;

    public static perturbation.location.PerturbationLocation __L833;

    public static perturbation.location.PerturbationLocation __L834;

    public static perturbation.location.PerturbationLocation __L835;

    public static perturbation.location.PerturbationLocation __L836;

    public static perturbation.location.PerturbationLocation __L837;

    public static perturbation.location.PerturbationLocation __L838;

    public static perturbation.location.PerturbationLocation __L839;

    public static perturbation.location.PerturbationLocation __L840;

    public static perturbation.location.PerturbationLocation __L841;

    public static perturbation.location.PerturbationLocation __L842;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:40)", 772, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:40)", 773, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:40)", 774, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:46)", 775, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:47)", 776, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:47)", 777, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:47)", 778, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:47)", 779, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:66)", 780, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:66)", 781, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:66)", 782, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:67)", 783, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:68)", 784, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:68)", 785, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:68)", 786, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:70)", 787, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:70)", 788, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:70)", 789, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:71)", 790, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:71)", 791, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:71)", 792, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:70)", 793, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:73)", 794, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:73)", 795, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:73)", 796, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:74)", 797, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:74)", 798, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:74)", 799, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:73)", 800, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:76)", 801, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L802 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:76)", 802, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L803 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:76)", 803, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L804 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:77)", 804, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L805 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:77)", 805, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L806 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:77)", 806, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L807 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:76)", 807, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L808 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:79)", 808, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L809 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:79)", 809, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L810 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:79)", 810, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L811 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:80)", 811, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L812 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:80)", 812, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L813 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:80)", 813, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L814 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:79)", 814, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L815 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:82)", 815, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L816 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:82)", 816, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L817 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:82)", 817, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L818 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:83)", 818, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L819 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:83)", 819, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:83)", 820, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:82)", 821, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:85)", 822, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:85)", 823, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:85)", 824, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:86)", 825, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:86)", 826, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:86)", 827, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:85)", 828, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:88)", 829, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:88)", 830, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:88)", 831, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:89)", 832, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:89)", 833, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:89)", 834, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:88)", 835, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:91)", 836, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:91)", 837, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:91)", 838, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:92)", 839, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:92)", 840, "Numerical");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:92)", 841, "Boolean");
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.__L842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/demo/CompositeAutoImportSql.java:91)", 842, "Boolean");
    }

    static {
        org.broadleafcommerce.common.demo.CompositeAutoImportSql.initPerturbationLocation0();
    }
}

