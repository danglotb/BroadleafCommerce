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
package org.broadleafcommerce.common.audit;


@javax.persistence.Embeddable
public class Auditable implements java.io.Serializable {
    public static class Presentation {
        public static class Tab {
            public static class Name {
                public static final java.lang.String Audit = "Auditable_Tab";
            }

            public static class Order {
                public static final int Audit = 99000;
            }
        }

        public static class Group {
            public static class Name {
                public static final java.lang.String Audit = "Auditable_Audit";
            }

            public static class Order {
                public static final int Audit = 1000;
            }
        }
    }

    private static final long serialVersionUID = 1L;

    @javax.persistence.Column(name = "DATE_CREATED", updatable = false)
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "Auditable_Date_Created", order = 1000, tab = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Name.Audit, tabOrder = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Order.Audit, group = "Auditable_Audit", groupOrder = 1000, readOnly = true)
    protected java.util.Date dateCreated;

    @javax.persistence.Column(name = "CREATED_BY", updatable = false)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "Auditable_Created_By", order = 2000, tab = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Name.Audit, tabOrder = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Order.Audit, group = "Auditable_Audit", readOnly = true)
    protected java.lang.Long createdBy;

    @javax.persistence.Column(name = "DATE_UPDATED")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "Auditable_Date_Updated", order = 3000, tab = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Name.Audit, tabOrder = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Order.Audit, group = "Auditable_Audit", readOnly = true)
    protected java.util.Date dateUpdated;

    @javax.persistence.Column(name = "UPDATED_BY")
    @org.broadleafcommerce.common.presentation.AdminPresentation(friendlyName = "Auditable_Updated_By", order = 4000, tab = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Name.Audit, tabOrder = org.broadleafcommerce.common.audit.Auditable.Presentation.Tab.Order.Audit, group = "Auditable_Audit", readOnly = true)
    protected java.lang.Long updatedBy;

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public java.lang.Long getCreatedBy() {
        return createdBy;
    }

    public java.util.Date getDateUpdated() {
        return dateUpdated;
    }

    public java.lang.Long getUpdatedBy() {
        return updatedBy;
    }

    public void setDateCreated(java.util.Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setCreatedBy(java.lang.Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setDateUpdated(java.util.Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setUpdatedBy(java.lang.Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L6, ((this) == o)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L7, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L8, (o == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L9, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L11, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L10, getClass().isAssignableFrom(o.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L12, false);

        org.broadleafcommerce.common.audit.Auditable auditable = ((org.broadleafcommerce.common.audit.Auditable) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L17, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L13, ((createdBy) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L15, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L14, createdBy.equals(auditable.createdBy))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L16, ((auditable.createdBy) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L18, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L23, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L19, ((dateCreated) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L21, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L20, dateCreated.equals(auditable.dateCreated))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L22, ((auditable.dateCreated) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L24, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L29, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L25, ((dateUpdated) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L27, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L26, dateUpdated.equals(auditable.dateUpdated))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L28, ((auditable.dateUpdated) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L30, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L35, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L31, ((updatedBy) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L33, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L32, updatedBy.equals(auditable.updatedBy))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L34, ((auditable.updatedBy) != null)))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L36, false);

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L37, true);
    }

    @java.lang.Override
    public int hashCode() {
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L41, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L38, ((dateCreated) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L39, dateCreated.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L40, 0)));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L49, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L44, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L42, 31)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L43, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L48, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L45, ((createdBy) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L46, createdBy.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L47, 0))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L57, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L52, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L50, 31)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L51, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L56, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L53, ((dateUpdated) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L54, dateUpdated.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L55, 0))))));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L65, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L60, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L58, 31)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L59, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L64, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.audit.Auditable.__L61, ((updatedBy) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L62, updatedBy.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L63, 0))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.audit.Auditable.__L66, result);
    }

    public static perturbation.location.PerturbationLocation __L6;

    public static perturbation.location.PerturbationLocation __L7;

    public static perturbation.location.PerturbationLocation __L8;

    public static perturbation.location.PerturbationLocation __L9;

    public static perturbation.location.PerturbationLocation __L10;

    public static perturbation.location.PerturbationLocation __L11;

    public static perturbation.location.PerturbationLocation __L12;

    public static perturbation.location.PerturbationLocation __L13;

    public static perturbation.location.PerturbationLocation __L14;

    public static perturbation.location.PerturbationLocation __L15;

    public static perturbation.location.PerturbationLocation __L16;

    public static perturbation.location.PerturbationLocation __L17;

    public static perturbation.location.PerturbationLocation __L18;

    public static perturbation.location.PerturbationLocation __L19;

    public static perturbation.location.PerturbationLocation __L20;

    public static perturbation.location.PerturbationLocation __L21;

    public static perturbation.location.PerturbationLocation __L22;

    public static perturbation.location.PerturbationLocation __L23;

    public static perturbation.location.PerturbationLocation __L24;

    public static perturbation.location.PerturbationLocation __L25;

    public static perturbation.location.PerturbationLocation __L26;

    public static perturbation.location.PerturbationLocation __L27;

    public static perturbation.location.PerturbationLocation __L28;

    public static perturbation.location.PerturbationLocation __L29;

    public static perturbation.location.PerturbationLocation __L30;

    public static perturbation.location.PerturbationLocation __L31;

    public static perturbation.location.PerturbationLocation __L32;

    public static perturbation.location.PerturbationLocation __L33;

    public static perturbation.location.PerturbationLocation __L34;

    public static perturbation.location.PerturbationLocation __L35;

    public static perturbation.location.PerturbationLocation __L36;

    public static perturbation.location.PerturbationLocation __L37;

    public static perturbation.location.PerturbationLocation __L38;

    public static perturbation.location.PerturbationLocation __L39;

    public static perturbation.location.PerturbationLocation __L40;

    public static perturbation.location.PerturbationLocation __L41;

    public static perturbation.location.PerturbationLocation __L42;

    public static perturbation.location.PerturbationLocation __L43;

    public static perturbation.location.PerturbationLocation __L44;

    public static perturbation.location.PerturbationLocation __L45;

    public static perturbation.location.PerturbationLocation __L46;

    public static perturbation.location.PerturbationLocation __L47;

    public static perturbation.location.PerturbationLocation __L48;

    public static perturbation.location.PerturbationLocation __L49;

    public static perturbation.location.PerturbationLocation __L50;

    public static perturbation.location.PerturbationLocation __L51;

    public static perturbation.location.PerturbationLocation __L52;

    public static perturbation.location.PerturbationLocation __L53;

    public static perturbation.location.PerturbationLocation __L54;

    public static perturbation.location.PerturbationLocation __L55;

    public static perturbation.location.PerturbationLocation __L56;

    public static perturbation.location.PerturbationLocation __L57;

    public static perturbation.location.PerturbationLocation __L58;

    public static perturbation.location.PerturbationLocation __L59;

    public static perturbation.location.PerturbationLocation __L60;

    public static perturbation.location.PerturbationLocation __L61;

    public static perturbation.location.PerturbationLocation __L62;

    public static perturbation.location.PerturbationLocation __L63;

    public static perturbation.location.PerturbationLocation __L64;

    public static perturbation.location.PerturbationLocation __L65;

    public static perturbation.location.PerturbationLocation __L66;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.audit.Auditable.__L6 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:99)", 6, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L7 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:99)", 7, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L8 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:100)", 8, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L9 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:100)", 9, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L10 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:101)", 10, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L11 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:101)", 11, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L12 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:101)", 12, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L13 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:105)", 13, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L14 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:105)", 14, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L15 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:105)", 15, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L16 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:105)", 16, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L17 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:105)", 17, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L18 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:105)", 18, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L19 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:106)", 19, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L20 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:106)", 20, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L21 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:106)", 21, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L22 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:106)", 22, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L23 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:106)", 23, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L24 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:107)", 24, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L25 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:108)", 25, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L26 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:108)", 26, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L27 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:108)", 27, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L28 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:108)", 28, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L29 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:108)", 29, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L30 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:109)", 30, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L31 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:110)", 31, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L32 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:110)", 32, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L33 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:110)", 33, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L34 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:110)", 34, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L35 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:110)", 35, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L36 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:110)", 36, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L37 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:112)", 37, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L38 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:117)", 38, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L39 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:117)", 39, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L40 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:117)", 40, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L41 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:117)", 41, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L42 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 42, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L43 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 43, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L44 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 44, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L45 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 45, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L46 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 46, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L47 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 47, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L48 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 48, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L49 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:118)", 49, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L50 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 50, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L51 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 51, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L52 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 52, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L53 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 53, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L54 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 54, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L55 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 55, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L56 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 56, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L57 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:119)", 57, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L58 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 58, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L59 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 59, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L60 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 60, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L61 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 61, "Boolean");
        org.broadleafcommerce.common.audit.Auditable.__L62 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 62, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L63 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 63, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L64 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 64, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L65 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:120)", 65, "Numerical");
        org.broadleafcommerce.common.audit.Auditable.__L66 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/audit/Auditable.java:121)", 66, "Numerical");
    }

    static {
        org.broadleafcommerce.common.audit.Auditable.initPerturbationLocation0();
    }
}

