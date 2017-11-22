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


public class BLCFieldUtils {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.BLCFieldUtils.class);

    protected org.hibernate.SessionFactory sessionFactory;

    protected boolean includeUnqualifiedPolymorphicEntities;

    protected boolean useCache;

    protected org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao ejb3ConfigurationDao;

    protected org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;

    protected org.broadleafcommerce.common.util.dao.DynamicDaoHelper helper;

    public BLCFieldUtils(org.hibernate.SessionFactory sessionFactory, boolean includeUnqualifiedPolymorphicEntities, boolean useCache, org.broadleafcommerce.common.util.dao.EJB3ConfigurationDao ejb3ConfigurationDao, org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration, org.broadleafcommerce.common.util.dao.DynamicDaoHelper helper) {
        this.sessionFactory = sessionFactory;
        this.includeUnqualifiedPolymorphicEntities = includeUnqualifiedPolymorphicEntities;
        this.useCache = useCache;
        this.ejb3ConfigurationDao = ejb3ConfigurationDao;
        this.entityConfiguration = entityConfiguration;
        this.helper = helper;
    }

    public static java.lang.reflect.Field getSingleField(java.lang.Class<?> clazz, java.lang.String fieldName) throws java.lang.IllegalStateException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (java.lang.NoSuchFieldException nsf) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6103, ((clazz.getSuperclass()) != null))) {
                return org.broadleafcommerce.common.util.BLCFieldUtils.getSingleField(clazz.getSuperclass(), fieldName);
            }
            return null;
        }
    }

    public java.lang.reflect.Field getField(java.lang.Class<?> clazz, java.lang.String fieldName) throws java.lang.IllegalStateException {
        java.lang.String[] tokens = fieldName.split("\\.");
        java.lang.reflect.Field field = null;
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6104, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6107, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6105, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6106, tokens.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6108, (j++))) {
            java.lang.String propertyName = tokens[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6109, j)];
            java.lang.Class<?>[] myEntities = helper.getUpDownInheritance(clazz, sessionFactory, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6110, includeUnqualifiedPolymorphicEntities), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6111, useCache), ejb3ConfigurationDao);
            java.lang.Class<?> myClass;
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6112, org.apache.commons.lang.ArrayUtils.isEmpty(myEntities))) {
                myClass = clazz;
            }else {
                myClass = getClassForField(helper, propertyName, null, myEntities);
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6113, (myClass == null))) {
                java.lang.String message = java.lang.String.format("Unable to find the field (%s) anywhere in the inheritance hierarchy for (%s)", org.broadleafcommerce.common.util.StringUtil.sanitize(propertyName), org.broadleafcommerce.common.util.StringUtil.sanitize(clazz.getName()));
                org.broadleafcommerce.common.util.BLCFieldUtils.LOG.debug(message);
                return null;
            }
            field = org.broadleafcommerce.common.util.BLCFieldUtils.getSingleField(myClass, propertyName);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6120, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6114, (field != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6119, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6115, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6118, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6116, tokens.length)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6117, 1))))))))))) {
                java.lang.Class<?>[] fieldEntities = helper.getUpDownInheritance(field.getType(), sessionFactory, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6121, includeUnqualifiedPolymorphicEntities), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6122, useCache), ejb3ConfigurationDao);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6124, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6123, org.apache.commons.lang.ArrayUtils.isEmpty(fieldEntities)))))) {
                    clazz = getClassForField(helper, tokens[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6127, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6125, j)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6126, 1))))], field, fieldEntities);
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6128, (clazz == null))) {
                        return null;
                    }
                }else {
                    clazz = field.getType();
                }
            }else {
                break;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6129, (field != null))) {
            field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6130, true));
        }
        return field;
    }

    protected java.lang.Class<?> getClassForField(org.broadleafcommerce.common.util.dao.DynamicDaoHelper helper, java.lang.String token, java.lang.reflect.Field field, java.lang.Class<?>[] entities) {
        java.lang.Class<?> clazz;
        java.util.List<java.lang.Class<?>> matchedClasses = new java.util.ArrayList<java.lang.Class<?>>();
        for (java.lang.Class<?> entity : entities) {
            java.lang.reflect.Field peekAheadField = null;
            try {
                peekAheadField = entity.getDeclaredField(token);
            } catch (java.lang.NoSuchFieldException nsf) {
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6131, (peekAheadField != null))) {
                matchedClasses.add(entity);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6134, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6132, matchedClasses.size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6133, 1))))) {
            java.lang.String message = (((((("Found the property (" + (org.broadleafcommerce.common.util.StringUtil.sanitize(token))) + ") in more than one class of an inheritance hierarchy. ") + "This may lead to unwanted behavior, as the system does not know which class was intended. Do not ") + "use the same property name in different levels of the inheritance hierarchy. Defaulting to the ") + "first class found (") + (org.broadleafcommerce.common.util.StringUtil.sanitize(matchedClasses.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6135, 0)).getName()))) + ")";
            org.broadleafcommerce.common.util.BLCFieldUtils.LOG.warn(message);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6136, matchedClasses.isEmpty())) {
            return null;
        }
        java.lang.Class<?> myClass = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6137, (field != null))) ? field.getType() : entities[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6138, 0)];
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6140, ((org.broadleafcommerce.common.util.BLCFieldUtils.getSingleField(matchedClasses.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6139, 0)), token)) != null))) {
            clazz = matchedClasses.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6141, 0));
            java.lang.Class<?>[] entities2 = helper.getUpDownInheritance(clazz, sessionFactory, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6142, includeUnqualifiedPolymorphicEntities), perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6143, useCache), ejb3ConfigurationDao);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6151, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6149, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6145, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6144, org.apache.commons.lang.ArrayUtils.isEmpty(entities2)))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6148, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6146, matchedClasses.size())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.BLCFieldUtils.__L6147, 1)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.BLCFieldUtils.__L6150, clazz.isInterface()))))) {
                try {
                    clazz = entityConfiguration.lookupEntityClass(myClass.getName());
                } catch (java.lang.Exception e) {
                }
            }
        }else {
            clazz = myClass;
        }
        return clazz;
    }

    public static perturbation.location.PerturbationLocation __L6103;

    public static perturbation.location.PerturbationLocation __L6104;

    public static perturbation.location.PerturbationLocation __L6105;

    public static perturbation.location.PerturbationLocation __L6106;

    public static perturbation.location.PerturbationLocation __L6107;

    public static perturbation.location.PerturbationLocation __L6108;

    public static perturbation.location.PerturbationLocation __L6109;

    public static perturbation.location.PerturbationLocation __L6110;

    public static perturbation.location.PerturbationLocation __L6111;

    public static perturbation.location.PerturbationLocation __L6112;

    public static perturbation.location.PerturbationLocation __L6113;

    public static perturbation.location.PerturbationLocation __L6114;

    public static perturbation.location.PerturbationLocation __L6115;

    public static perturbation.location.PerturbationLocation __L6116;

    public static perturbation.location.PerturbationLocation __L6117;

    public static perturbation.location.PerturbationLocation __L6118;

    public static perturbation.location.PerturbationLocation __L6119;

    public static perturbation.location.PerturbationLocation __L6120;

    public static perturbation.location.PerturbationLocation __L6121;

    public static perturbation.location.PerturbationLocation __L6122;

    public static perturbation.location.PerturbationLocation __L6123;

    public static perturbation.location.PerturbationLocation __L6124;

    public static perturbation.location.PerturbationLocation __L6125;

    public static perturbation.location.PerturbationLocation __L6126;

    public static perturbation.location.PerturbationLocation __L6127;

    public static perturbation.location.PerturbationLocation __L6128;

    public static perturbation.location.PerturbationLocation __L6129;

    public static perturbation.location.PerturbationLocation __L6130;

    public static perturbation.location.PerturbationLocation __L6131;

    public static perturbation.location.PerturbationLocation __L6132;

    public static perturbation.location.PerturbationLocation __L6133;

    public static perturbation.location.PerturbationLocation __L6134;

    public static perturbation.location.PerturbationLocation __L6135;

    public static perturbation.location.PerturbationLocation __L6136;

    public static perturbation.location.PerturbationLocation __L6137;

    public static perturbation.location.PerturbationLocation __L6138;

    public static perturbation.location.PerturbationLocation __L6139;

    public static perturbation.location.PerturbationLocation __L6140;

    public static perturbation.location.PerturbationLocation __L6141;

    public static perturbation.location.PerturbationLocation __L6142;

    public static perturbation.location.PerturbationLocation __L6143;

    public static perturbation.location.PerturbationLocation __L6144;

    public static perturbation.location.PerturbationLocation __L6145;

    public static perturbation.location.PerturbationLocation __L6146;

    public static perturbation.location.PerturbationLocation __L6147;

    public static perturbation.location.PerturbationLocation __L6148;

    public static perturbation.location.PerturbationLocation __L6149;

    public static perturbation.location.PerturbationLocation __L6150;

    public static perturbation.location.PerturbationLocation __L6151;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6103 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:84)", 6103, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6104 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:105)", 6104, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6105 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:105)", 6105, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6106 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:105)", 6106, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6107 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:105)", 6107, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:105)", 6108, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:106)", 6109, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:107)", 6110, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:107)", 6111, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:109)", 6112, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:114)", 6113, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6114, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6115, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6116, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6117, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6118, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6119, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:120)", 6120, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:121)", 6121, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:121)", 6122, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6123 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:122)", 6123, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6124 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:122)", 6124, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6125 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:123)", 6125, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6126 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:123)", 6126, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6127 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:123)", 6127, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6128 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:124)", 6128, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6129 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:136)", 6129, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6130 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:137)", 6130, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6131 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:152)", 6131, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6132 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:156)", 6132, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6133 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:156)", 6133, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6134 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:156)", 6134, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6135 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:160)", 6135, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6136 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:163)", 6136, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6137 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:167)", 6137, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6138 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:167)", 6138, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6139 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:168)", 6139, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6140 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:168)", 6140, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6141 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:169)", 6141, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6142 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:170)", 6142, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6143 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:170)", 6143, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6144 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6144, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6145 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6145, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6146 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6146, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6147 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6147, "Numerical");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6148 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6148, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6149 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6149, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6150 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6150, "Boolean");
        org.broadleafcommerce.common.util.BLCFieldUtils.__L6151 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/BLCFieldUtils.java:171)", 6151, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.BLCFieldUtils.initPerturbationLocation0();
    }
}

