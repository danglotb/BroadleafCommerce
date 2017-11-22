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
package org.broadleafcommerce.common.util;


public class UpdateExecutor {
    @java.lang.Deprecated
    public static int executeUpdateQuery(javax.persistence.EntityManager em, java.lang.String template, java.lang.Object[] params, org.hibernate.type.Type[] types, java.util.List<java.lang.Long> ids) {
        int response = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6820, 0);
        java.util.List<java.lang.Long[]> runs = org.broadleafcommerce.common.util.UpdateExecutor.buildRuns(ids);
        for (java.lang.Long[] run : runs) {
            java.lang.String queryString = java.lang.String.format(template, org.broadleafcommerce.common.util.UpdateExecutor.buildInClauseTemplate(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6821, run.length)));
            org.hibernate.SQLQuery query = em.unwrap(org.hibernate.Session.class).createSQLQuery(queryString);
            int counter = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6822, 0);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6824, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6823, org.apache.commons.lang.ArrayUtils.isEmpty(params)))))) {
                for (java.lang.Object param : params) {
                    query.setParameter(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6825, counter), param, types[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6826, counter)]);
                    perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6827, (counter++));
                }
            }
            for (java.lang.Long id : run) {
                query.setLong(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6828, counter), id);
                perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6829, (counter++));
            }
            response += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6830, query.executeUpdate());
        }
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6831, response);
    }

    public static int executeUpdateQuery(javax.persistence.EntityManager em, java.lang.String template, java.lang.String tableSpace, java.lang.Object[] params, org.hibernate.type.Type[] types, java.util.List<java.lang.Long> ids) {
        int response = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6832, 0);
        java.util.List<java.lang.Long[]> runs = org.broadleafcommerce.common.util.UpdateExecutor.buildRuns(ids);
        for (java.lang.Long[] run : runs) {
            java.lang.String queryString = java.lang.String.format(template, org.broadleafcommerce.common.util.UpdateExecutor.buildInClauseTemplate(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6833, run.length)));
            org.hibernate.SQLQuery query = em.unwrap(org.hibernate.Session.class).createSQLQuery(queryString);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6834, (tableSpace != null))) {
                query.addSynchronizedQuerySpace(tableSpace);
            }
            int counter = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6835, 0);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6837, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6836, org.apache.commons.lang.ArrayUtils.isEmpty(params)))))) {
                for (java.lang.Object param : params) {
                    query.setParameter(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6838, counter), param, types[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6839, counter)]);
                    perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6840, (counter++));
                }
            }
            for (java.lang.Long id : run) {
                query.setLong(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6841, counter), id);
                perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6842, (counter++));
            }
            response += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6843, query.executeUpdate());
        }
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6844, response);
    }

    public static void executeTargetedCacheInvalidation(javax.persistence.EntityManager em, java.lang.Class<?> entityType, java.util.List<java.lang.Long> ids) {
        org.hibernate.Session session = em.unwrap(org.hibernate.Session.class);
        for (java.lang.Long id : ids) {
            session.getSessionFactory().getCache().evictEntity(entityType, id);
        }
        org.hibernate.metadata.ClassMetadata metadata = session.getSessionFactory().getClassMetadata(entityType);
        java.lang.String tableName = ((org.hibernate.persister.entity.AbstractEntityPersister) (metadata)).getTableName();
        org.hibernate.cache.spi.UpdateTimestampsCache timestampsCache = em.unwrap(org.hibernate.engine.spi.SessionImplementor.class).getFactory().getUpdateTimestampsCache();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6845, (timestampsCache != null))) {
            timestampsCache.invalidate(new java.io.Serializable[]{ tableName });
        }
    }

    private static java.lang.String buildInClauseTemplate(int length) {
        java.lang.String[] temp = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6846, length)];
        java.util.Arrays.fill(temp, "?");
        return org.apache.commons.lang3.StringUtils.join(temp, ",");
    }

    private static java.util.List<java.lang.Long[]> buildRuns(java.util.List<java.lang.Long> ids) {
        java.util.List<java.lang.Long[]> runs = new java.util.ArrayList<java.lang.Long[]>();
        java.lang.Long[] all = ids.toArray(new java.lang.Long[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6847, ids.size())]);
        int test = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6848, all.length);
        int pos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6849, 0);
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6850, false);
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6852, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6851, eof))))) {
            int arraySize;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6855, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6853, test)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6854, 800))))) {
                arraySize = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6856, test);
                eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6857, true);
            }else {
                arraySize = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6858, 800);
                test -= perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6859, arraySize);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6862, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6860, test)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6861, 0))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.UpdateExecutor.__L6863, true);
                }
            }
            java.lang.Long[] temp = new java.lang.Long[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6864, arraySize)];
            java.lang.System.arraycopy(all, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6865, pos), temp, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6866, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6867, arraySize));
            pos += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.UpdateExecutor.__L6868, arraySize);
            runs.add(temp);
        } 
        return runs;
    }

    public static perturbation.location.PerturbationLocation __L6820;

    public static perturbation.location.PerturbationLocation __L6821;

    public static perturbation.location.PerturbationLocation __L6822;

    public static perturbation.location.PerturbationLocation __L6823;

    public static perturbation.location.PerturbationLocation __L6824;

    public static perturbation.location.PerturbationLocation __L6825;

    public static perturbation.location.PerturbationLocation __L6826;

    public static perturbation.location.PerturbationLocation __L6827;

    public static perturbation.location.PerturbationLocation __L6828;

    public static perturbation.location.PerturbationLocation __L6829;

    public static perturbation.location.PerturbationLocation __L6830;

    public static perturbation.location.PerturbationLocation __L6831;

    public static perturbation.location.PerturbationLocation __L6832;

    public static perturbation.location.PerturbationLocation __L6833;

    public static perturbation.location.PerturbationLocation __L6834;

    public static perturbation.location.PerturbationLocation __L6835;

    public static perturbation.location.PerturbationLocation __L6836;

    public static perturbation.location.PerturbationLocation __L6837;

    public static perturbation.location.PerturbationLocation __L6838;

    public static perturbation.location.PerturbationLocation __L6839;

    public static perturbation.location.PerturbationLocation __L6840;

    public static perturbation.location.PerturbationLocation __L6841;

    public static perturbation.location.PerturbationLocation __L6842;

    public static perturbation.location.PerturbationLocation __L6843;

    public static perturbation.location.PerturbationLocation __L6844;

    public static perturbation.location.PerturbationLocation __L6845;

    public static perturbation.location.PerturbationLocation __L6846;

    public static perturbation.location.PerturbationLocation __L6847;

    public static perturbation.location.PerturbationLocation __L6848;

    public static perturbation.location.PerturbationLocation __L6849;

    public static perturbation.location.PerturbationLocation __L6850;

    public static perturbation.location.PerturbationLocation __L6851;

    public static perturbation.location.PerturbationLocation __L6852;

    public static perturbation.location.PerturbationLocation __L6853;

    public static perturbation.location.PerturbationLocation __L6854;

    public static perturbation.location.PerturbationLocation __L6855;

    public static perturbation.location.PerturbationLocation __L6856;

    public static perturbation.location.PerturbationLocation __L6857;

    public static perturbation.location.PerturbationLocation __L6858;

    public static perturbation.location.PerturbationLocation __L6859;

    public static perturbation.location.PerturbationLocation __L6860;

    public static perturbation.location.PerturbationLocation __L6861;

    public static perturbation.location.PerturbationLocation __L6862;

    public static perturbation.location.PerturbationLocation __L6863;

    public static perturbation.location.PerturbationLocation __L6864;

    public static perturbation.location.PerturbationLocation __L6865;

    public static perturbation.location.PerturbationLocation __L6866;

    public static perturbation.location.PerturbationLocation __L6867;

    public static perturbation.location.PerturbationLocation __L6868;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.UpdateExecutor.__L6820 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:78)", 6820, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6821 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:81)", 6821, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6822 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:83)", 6822, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6823 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:84)", 6823, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6824 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:84)", 6824, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6825 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:86)", 6825, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6826 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:86)", 6826, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6827 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:87)", 6827, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6828 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:91)", 6828, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6829 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:92)", 6829, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:94)", 6830, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:96)", 6831, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:115)", 6832, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:118)", 6833, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:121)", 6834, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:124)", 6835, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:125)", 6836, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:125)", 6837, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:127)", 6838, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:127)", 6839, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:128)", 6840, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:132)", 6841, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6842 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:133)", 6842, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6843 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:135)", 6843, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6844 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:137)", 6844, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6845 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:155)", 6845, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6846 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:167)", 6846, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6847 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:182)", 6847, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6848 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:183)", 6848, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6849 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:184)", 6849, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6850 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:185)", 6850, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6851 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:186)", 6851, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6852 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:186)", 6852, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6853 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:188)", 6853, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6854 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:188)", 6854, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6855 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:188)", 6855, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6856 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:189)", 6856, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6857 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:190)", 6857, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6858 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:192)", 6858, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6859 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:193)", 6859, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6860 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:194)", 6860, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6861 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:194)", 6861, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6862 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:194)", 6862, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6863 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:195)", 6863, "Boolean");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6864 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:198)", 6864, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6865 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:199)", 6865, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6866 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:199)", 6866, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6867 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:199)", 6867, "Numerical");
        org.broadleafcommerce.common.util.UpdateExecutor.__L6868 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/UpdateExecutor.java:200)", 6868, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.UpdateExecutor.initPerturbationLocation0();
    }
}

