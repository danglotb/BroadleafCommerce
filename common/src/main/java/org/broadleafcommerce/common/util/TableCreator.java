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


public class TableCreator {
    public static class Col {
        java.lang.String title;

        int width;

        public Col(java.lang.String title) {
            this.title = title;
            this.width = title.length();
        }

        public Col(java.lang.String title, int width) {
            this.title = title;
            this.width = width;
        }
    }

    protected org.broadleafcommerce.common.util.TableCreator.Col[] cols;

    protected int rowWidth;

    protected java.lang.StringBuilder sb;

    protected int globalRowHeaderWidth = 20;

    public TableCreator(org.broadleafcommerce.common.util.TableCreator.Col[] cols) {
        this.cols = cols;
        this.rowWidth = calculateRowWidth();
        this.sb = new java.lang.StringBuilder("\r\n");
        addSeparator();
        addRow(cols);
        addSeparator();
    }

    protected int calculateRowWidth() {
        int length = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6728, 1);
        for (org.broadleafcommerce.common.util.TableCreator.Col col : cols) {
            length += perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6731, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6729, col.width)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6730, 3))));
        }
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6732, length);
    }

    public org.broadleafcommerce.common.util.TableCreator addSeparator() {
        sb.append(org.apache.commons.lang3.StringUtils.leftPad("", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6733, rowWidth), '-')).append("\r\n");
        return this;
    }

    public org.broadleafcommerce.common.util.TableCreator addRow(org.broadleafcommerce.common.util.TableCreator.Col[] cols) {
        java.lang.String[] data = new java.lang.String[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6734, cols.length)];
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6735, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TableCreator.__L6738, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6736, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6737, cols.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6739, (i++))) {
            data[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6740, i)] = cols[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6741, i)].title;
        }
        return addRow(data);
    }

    public org.broadleafcommerce.common.util.TableCreator addRow(java.lang.Object[] data) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TableCreator.__L6744, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6742, data.length)) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6743, cols.length))))) {
            throw new java.lang.IllegalArgumentException(((((("Wrong number of data elements. Needed [" + (cols.length)) + "] ") + "but received [") + (data.length)) + "]"));
        }
        sb.append('|');
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6745, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.TableCreator.__L6748, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6746, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6747, data.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6749, (i++))) {
            java.lang.String trimmed = org.apache.commons.lang3.StringUtils.left(java.lang.String.valueOf(data[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6750, i)]), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6752, cols[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6751, i)].width));
            sb.append(' ').append(org.apache.commons.lang3.StringUtils.rightPad(trimmed, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6754, cols[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6753, i)].width))).append(" |");
        }
        sb.append("\r\n");
        return this;
    }

    public org.broadleafcommerce.common.util.TableCreator addRow(java.lang.String rowHeader, java.lang.Object rowData) {
        java.lang.String trimmed = org.apache.commons.lang3.StringUtils.left(rowHeader, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6755, globalRowHeaderWidth));
        sb.append("| ").append(org.apache.commons.lang3.StringUtils.rightPad(trimmed, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6756, globalRowHeaderWidth))).append(org.apache.commons.lang3.StringUtils.rightPad(java.lang.String.valueOf(rowData), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6761, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6759, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6757, rowWidth)) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6758, globalRowHeaderWidth))))) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6760, 3)))))).append("|\r\n");
        return this;
    }

    public org.broadleafcommerce.common.util.TableCreator withGlobalRowHeaderWidth(int width) {
        this.globalRowHeaderWidth = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.TableCreator.__L6762, width);
        return this;
    }

    public java.lang.String toString() {
        return sb.toString();
    }

    public static perturbation.location.PerturbationLocation __L6728;

    public static perturbation.location.PerturbationLocation __L6729;

    public static perturbation.location.PerturbationLocation __L6730;

    public static perturbation.location.PerturbationLocation __L6731;

    public static perturbation.location.PerturbationLocation __L6732;

    public static perturbation.location.PerturbationLocation __L6733;

    public static perturbation.location.PerturbationLocation __L6734;

    public static perturbation.location.PerturbationLocation __L6735;

    public static perturbation.location.PerturbationLocation __L6736;

    public static perturbation.location.PerturbationLocation __L6737;

    public static perturbation.location.PerturbationLocation __L6738;

    public static perturbation.location.PerturbationLocation __L6739;

    public static perturbation.location.PerturbationLocation __L6740;

    public static perturbation.location.PerturbationLocation __L6741;

    public static perturbation.location.PerturbationLocation __L6742;

    public static perturbation.location.PerturbationLocation __L6743;

    public static perturbation.location.PerturbationLocation __L6744;

    public static perturbation.location.PerturbationLocation __L6745;

    public static perturbation.location.PerturbationLocation __L6746;

    public static perturbation.location.PerturbationLocation __L6747;

    public static perturbation.location.PerturbationLocation __L6748;

    public static perturbation.location.PerturbationLocation __L6749;

    public static perturbation.location.PerturbationLocation __L6750;

    public static perturbation.location.PerturbationLocation __L6751;

    public static perturbation.location.PerturbationLocation __L6752;

    public static perturbation.location.PerturbationLocation __L6753;

    public static perturbation.location.PerturbationLocation __L6754;

    public static perturbation.location.PerturbationLocation __L6755;

    public static perturbation.location.PerturbationLocation __L6756;

    public static perturbation.location.PerturbationLocation __L6757;

    public static perturbation.location.PerturbationLocation __L6758;

    public static perturbation.location.PerturbationLocation __L6759;

    public static perturbation.location.PerturbationLocation __L6760;

    public static perturbation.location.PerturbationLocation __L6761;

    public static perturbation.location.PerturbationLocation __L6762;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.TableCreator.__L6728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:41)", 6728, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:43)", 6729, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:43)", 6730, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:43)", 6731, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:45)", 6732, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:49)", 6733, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:54)", 6734, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:55)", 6735, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:55)", 6736, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:55)", 6737, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:55)", 6738, "Boolean");
        org.broadleafcommerce.common.util.TableCreator.__L6739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:55)", 6739, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:56)", 6740, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:56)", 6741, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:62)", 6742, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:62)", 6743, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6744 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:62)", 6744, "Boolean");
        org.broadleafcommerce.common.util.TableCreator.__L6745 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:69)", 6745, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6746 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:69)", 6746, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6747 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:69)", 6747, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6748 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:69)", 6748, "Boolean");
        org.broadleafcommerce.common.util.TableCreator.__L6749 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:69)", 6749, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:70)", 6750, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:70)", 6751, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:70)", 6752, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:71)", 6753, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:71)", 6754, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:80)", 6755, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:82)", 6756, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:83)", 6757, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:83)", 6758, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:83)", 6759, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:83)", 6760, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:83)", 6761, "Numerical");
        org.broadleafcommerce.common.util.TableCreator.__L6762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/TableCreator.java:89)", 6762, "Numerical");
    }

    static {
        org.broadleafcommerce.common.util.TableCreator.initPerturbationLocation0();
    }
}

