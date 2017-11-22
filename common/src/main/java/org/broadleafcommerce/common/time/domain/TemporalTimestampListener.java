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
package org.broadleafcommerce.common.time.domain;


public class TemporalTimestampListener {
    @javax.persistence.PrePersist
    @javax.persistence.PreUpdate
    public void setTimestamps(java.lang.Object entity) throws java.lang.Exception {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5616, entity.getClass().isAnnotationPresent(javax.persistence.Entity.class))) {
            java.lang.reflect.Field[] fields = entity.getClass().getDeclaredFields();
            setTimestamps(fields, entity);
        }
    }

    private void setTimestamps(java.lang.reflect.Field[] fields, java.lang.Object entity) throws java.lang.Exception {
        java.util.Calendar cal = null;
        for (java.lang.reflect.Field field : fields) {
            java.lang.Class<?> type = field.getType();
            javax.persistence.Temporal temporalAnnotation = field.getAnnotation(javax.persistence.Temporal.class);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5617, (temporalAnnotation != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5618, field.isAnnotationPresent(javax.persistence.Column.class))) {
                    field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5619, true));
                    try {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5622, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5620, javax.persistence.TemporalType.TIMESTAMP.equals(temporalAnnotation.value()))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5621, field.isAnnotationPresent(org.broadleafcommerce.common.time.domain.AutoPopulate.class)))))) {
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5625, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5623, ((field.get(entity)) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5624, field.getAnnotation(org.broadleafcommerce.common.time.domain.AutoPopulate.class).autoUpdateValue()))))) {
                                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5626, type.isAssignableFrom(java.util.Date.class))) {
                                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5627, (cal == null))) {
                                        cal = org.broadleafcommerce.common.time.SystemTime.asCalendar();
                                    }
                                    field.set(entity, cal.getTime());
                                }else
                                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5628, type.isAssignableFrom(java.util.Calendar.class))) {
                                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5629, (cal == null))) {
                                            cal = org.broadleafcommerce.common.time.SystemTime.asCalendar();
                                        }
                                        field.set(entity, cal);
                                    }

                            }
                        }
                    } finally {
                        field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5630, false));
                    }
                }
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5631, field.isAnnotationPresent(javax.persistence.Embedded.class))) {
                    field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5632, true));
                    try {
                        setTimestamps(field.getType().getDeclaredFields(), field.get(entity));
                    } finally {
                        field.setAccessible(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5633, false));
                    }
                }

        }
    }

    public static perturbation.location.PerturbationLocation __L5616;

    public static perturbation.location.PerturbationLocation __L5617;

    public static perturbation.location.PerturbationLocation __L5618;

    public static perturbation.location.PerturbationLocation __L5619;

    public static perturbation.location.PerturbationLocation __L5620;

    public static perturbation.location.PerturbationLocation __L5621;

    public static perturbation.location.PerturbationLocation __L5622;

    public static perturbation.location.PerturbationLocation __L5623;

    public static perturbation.location.PerturbationLocation __L5624;

    public static perturbation.location.PerturbationLocation __L5625;

    public static perturbation.location.PerturbationLocation __L5626;

    public static perturbation.location.PerturbationLocation __L5627;

    public static perturbation.location.PerturbationLocation __L5628;

    public static perturbation.location.PerturbationLocation __L5629;

    public static perturbation.location.PerturbationLocation __L5630;

    public static perturbation.location.PerturbationLocation __L5631;

    public static perturbation.location.PerturbationLocation __L5632;

    public static perturbation.location.PerturbationLocation __L5633;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:38)", 5616, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:50)", 5617, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:51)", 5618, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:52)", 5619, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:54)", 5620, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:54)", 5621, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:54)", 5622, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:55)", 5623, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:55)", 5624, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:55)", 5625, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:56)", 5626, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:57)", 5627, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:61)", 5628, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:62)", 5629, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:70)", 5630, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:73)", 5631, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:74)", 5632, "Boolean");
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.__L5633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/domain/TemporalTimestampListener.java:79)", 5633, "Boolean");
    }

    static {
        org.broadleafcommerce.common.time.domain.TemporalTimestampListener.initPerturbationLocation0();
    }
}

