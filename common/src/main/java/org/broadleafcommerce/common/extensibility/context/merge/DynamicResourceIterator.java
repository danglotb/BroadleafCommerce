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
package org.broadleafcommerce.common.extensibility.context.merge;


public class DynamicResourceIterator extends java.util.ArrayList<org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream> {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.class);

    private int position = 0;

    private int embeddedInsertPosition = 0;

    public org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream nextResource() {
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream ris = get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1586, position));
        perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1587, ((position)++));
        embeddedInsertPosition = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1588, position);
        return ris;
    }

    public int getPosition() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1589, position);
    }

    public void addEmbeddedResource(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream ris) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1592, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1590, embeddedInsertPosition)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1591, size()))))) {
            add(ris);
        }else {
            add(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1593, embeddedInsertPosition), ris);
        }
        perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1594, ((embeddedInsertPosition)++));
    }

    public boolean hasNext() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1597, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1595, position)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1596, size()))));
    }

    @java.lang.Override
    public boolean add(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream resourceInputStream) {
        byte[] sourceArray;
        try {
            sourceArray = buildArrayFromStream(resourceInputStream);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream ris = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(new java.io.ByteArrayInputStream(sourceArray), null, resourceInputStream.getNames());
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1598, super.add(ris));
    }

    @java.lang.Override
    public boolean addAll(java.util.Collection<? extends org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream> c) {
        for (org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream ris : c) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1600, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1599, add(ris)))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1601, false);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1602, true);
    }

    @java.lang.Override
    public void add(int index, org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream resourceInputStream) {
        byte[] sourceArray;
        try {
            sourceArray = buildArrayFromStream(resourceInputStream);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream ris = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream(new java.io.ByteArrayInputStream(sourceArray), null, resourceInputStream.getNames());
        super.add(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1603, index), ris);
    }

    protected byte[] buildArrayFromStream(java.io.InputStream source) throws java.io.IOException {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1604, false);
        try {
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1606, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1605, eof))))) {
                int temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1607, source.read());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1611, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1608, temp)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1610, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1609, 1)))))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1612, true);
                }else {
                    baos.write(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1613, temp));
                }
            } 
        } finally {
            try {
                source.close();
            } catch (java.lang.Throwable e) {
                org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.LOG.error("Unable to merge source and patch locations", e);
            }
        }
        return baos.toByteArray();
    }

    public static perturbation.location.PerturbationLocation __L1586;

    public static perturbation.location.PerturbationLocation __L1587;

    public static perturbation.location.PerturbationLocation __L1588;

    public static perturbation.location.PerturbationLocation __L1589;

    public static perturbation.location.PerturbationLocation __L1590;

    public static perturbation.location.PerturbationLocation __L1591;

    public static perturbation.location.PerturbationLocation __L1592;

    public static perturbation.location.PerturbationLocation __L1593;

    public static perturbation.location.PerturbationLocation __L1594;

    public static perturbation.location.PerturbationLocation __L1595;

    public static perturbation.location.PerturbationLocation __L1596;

    public static perturbation.location.PerturbationLocation __L1597;

    public static perturbation.location.PerturbationLocation __L1598;

    public static perturbation.location.PerturbationLocation __L1599;

    public static perturbation.location.PerturbationLocation __L1600;

    public static perturbation.location.PerturbationLocation __L1601;

    public static perturbation.location.PerturbationLocation __L1602;

    public static perturbation.location.PerturbationLocation __L1603;

    public static perturbation.location.PerturbationLocation __L1604;

    public static perturbation.location.PerturbationLocation __L1605;

    public static perturbation.location.PerturbationLocation __L1606;

    public static perturbation.location.PerturbationLocation __L1607;

    public static perturbation.location.PerturbationLocation __L1608;

    public static perturbation.location.PerturbationLocation __L1609;

    public static perturbation.location.PerturbationLocation __L1610;

    public static perturbation.location.PerturbationLocation __L1611;

    public static perturbation.location.PerturbationLocation __L1612;

    public static perturbation.location.PerturbationLocation __L1613;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:45)", 1586, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:46)", 1587, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:47)", 1588, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:52)", 1589, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:56)", 1590, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:56)", 1591, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:56)", 1592, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:59)", 1593, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:61)", 1594, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:65)", 1595, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:65)", 1596, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:65)", 1597, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:77)", 1598, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:83)", 1599, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:83)", 1600, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:84)", 1601, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:87)", 1602, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:99)", 1603, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:104)", 1604, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:106)", 1605, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:106)", 1606, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:107)", 1607, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:108)", 1608, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:108)", 1609, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:108)", 1610, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:108)", 1611, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:109)", 1612, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.__L1613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/DynamicResourceIterator.java:111)", 1613, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.DynamicResourceIterator.initPerturbationLocation0();
    }
}

