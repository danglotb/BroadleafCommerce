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


public class MergeXmlConfigResource {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.class);

    public org.springframework.core.io.Resource getMergedConfigResource(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] sources) throws org.springframework.beans.BeansException {
        org.springframework.core.io.Resource configResource = null;
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream merged = null;
        try {
            merged = merge(sources);
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1750, false);
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1752, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1751, eof))))) {
                int temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1753, merged.read());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1757, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1754, temp)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1756, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1755, 1)))))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1758, true);
                }else {
                    baos.write(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1759, temp));
                }
            } 
            configResource = new org.springframework.core.io.ByteArrayResource(baos.toByteArray());
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1760, org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.isDebugEnabled())) {
                org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.debug(("Merged config: \n" + (org.broadleafcommerce.common.util.StringUtil.sanitize(serialize(configResource)))));
            }
        } catch (org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } catch (org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } catch (java.io.IOException e) {
            throw new org.springframework.beans.FatalBeanException("Unable to merge source and patch locations", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1761, (merged != null))) {
                try {
                    merged.close();
                } catch (java.lang.Throwable e) {
                    org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
                }
            }
        }
        return configResource;
    }

    protected org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream merge(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] sources) throws org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException, org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1764, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1762, sources.length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1763, 1)))))
            return sources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1765, 0)];

        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream response = null;
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[] pair = new org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1766, 2)];
        pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1767, 0)] = sources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1768, 0)];
        for (int j = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1769, 1); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1772, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1770, j)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1771, sources.length)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1773, (j++))) {
            pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1774, 1)] = sources[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1775, j)];
            response = mergeItems(pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1776, 0)], pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1777, 1)]);
            try {
                pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1778, 0)].close();
            } catch (java.lang.Throwable e) {
                org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
            }
            try {
                pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1779, 1)].close();
            } catch (java.lang.Throwable e) {
                org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
            }
            pair[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1780, 0)] = response;
        }
        return response;
    }

    protected org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream mergeItems(org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream sourceLocationFirst, org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream sourceLocationSecond) throws org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException, org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException {
        org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream response = new org.broadleafcommerce.common.extensibility.context.merge.MergeManager().merge(sourceLocationFirst, sourceLocationSecond);
        return response;
    }

    public java.lang.String serialize(org.springframework.core.io.Resource resource) {
        java.lang.String response = "";
        try {
            response = serialize(resource.getInputStream());
        } catch (java.io.IOException e) {
            org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
        }
        return response;
    }

    public java.lang.String serialize(java.io.InputStream in) {
        java.io.InputStreamReader reader = null;
        int temp;
        java.lang.StringBuilder item = new java.lang.StringBuilder();
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1781, false);
        try {
            reader = new java.io.InputStreamReader(in);
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1783, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1782, eof))))) {
                temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1784, reader.read());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1788, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1785, temp)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1787, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1786, 1)))))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1789, true);
                }else {
                    item.append(perturbation.PerturbationEngine.pchar(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1790, ((char) (temp))));
                }
            } 
        } catch (java.io.IOException e) {
            org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
        } finally {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1791, (reader != null))) {
                try {
                    reader.close();
                } catch (java.lang.Throwable e) {
                    org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
                }
            }
        }
        return item.toString();
    }

    protected byte[] buildArrayFromStream(java.io.InputStream source) throws java.io.IOException {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        boolean eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1792, false);
        try {
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1794, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1793, eof))))) {
                int temp = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1795, source.read());
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1799, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1796, temp)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1798, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1797, 1)))))))) {
                    eof = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1800, true);
                }else {
                    baos.write(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1801, temp));
                }
            } 
        } finally {
            try {
                source.close();
            } catch (java.lang.Throwable e) {
                org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.LOG.error("Unable to merge source and patch locations", e);
            }
        }
        return baos.toByteArray();
    }

    public static perturbation.location.PerturbationLocation __L1750;

    public static perturbation.location.PerturbationLocation __L1751;

    public static perturbation.location.PerturbationLocation __L1752;

    public static perturbation.location.PerturbationLocation __L1753;

    public static perturbation.location.PerturbationLocation __L1754;

    public static perturbation.location.PerturbationLocation __L1755;

    public static perturbation.location.PerturbationLocation __L1756;

    public static perturbation.location.PerturbationLocation __L1757;

    public static perturbation.location.PerturbationLocation __L1758;

    public static perturbation.location.PerturbationLocation __L1759;

    public static perturbation.location.PerturbationLocation __L1760;

    public static perturbation.location.PerturbationLocation __L1761;

    public static perturbation.location.PerturbationLocation __L1762;

    public static perturbation.location.PerturbationLocation __L1763;

    public static perturbation.location.PerturbationLocation __L1764;

    public static perturbation.location.PerturbationLocation __L1765;

    public static perturbation.location.PerturbationLocation __L1766;

    public static perturbation.location.PerturbationLocation __L1767;

    public static perturbation.location.PerturbationLocation __L1768;

    public static perturbation.location.PerturbationLocation __L1769;

    public static perturbation.location.PerturbationLocation __L1770;

    public static perturbation.location.PerturbationLocation __L1771;

    public static perturbation.location.PerturbationLocation __L1772;

    public static perturbation.location.PerturbationLocation __L1773;

    public static perturbation.location.PerturbationLocation __L1774;

    public static perturbation.location.PerturbationLocation __L1775;

    public static perturbation.location.PerturbationLocation __L1776;

    public static perturbation.location.PerturbationLocation __L1777;

    public static perturbation.location.PerturbationLocation __L1778;

    public static perturbation.location.PerturbationLocation __L1779;

    public static perturbation.location.PerturbationLocation __L1780;

    public static perturbation.location.PerturbationLocation __L1781;

    public static perturbation.location.PerturbationLocation __L1782;

    public static perturbation.location.PerturbationLocation __L1783;

    public static perturbation.location.PerturbationLocation __L1784;

    public static perturbation.location.PerturbationLocation __L1785;

    public static perturbation.location.PerturbationLocation __L1786;

    public static perturbation.location.PerturbationLocation __L1787;

    public static perturbation.location.PerturbationLocation __L1788;

    public static perturbation.location.PerturbationLocation __L1789;

    public static perturbation.location.PerturbationLocation __L1790;

    public static perturbation.location.PerturbationLocation __L1791;

    public static perturbation.location.PerturbationLocation __L1792;

    public static perturbation.location.PerturbationLocation __L1793;

    public static perturbation.location.PerturbationLocation __L1794;

    public static perturbation.location.PerturbationLocation __L1795;

    public static perturbation.location.PerturbationLocation __L1796;

    public static perturbation.location.PerturbationLocation __L1797;

    public static perturbation.location.PerturbationLocation __L1798;

    public static perturbation.location.PerturbationLocation __L1799;

    public static perturbation.location.PerturbationLocation __L1800;

    public static perturbation.location.PerturbationLocation __L1801;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1750 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:52)", 1750, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1751 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:53)", 1751, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1752 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:53)", 1752, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1753 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:54)", 1753, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1754 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:55)", 1754, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1755 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:55)", 1755, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1756 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:55)", 1756, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1757 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:55)", 1757, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1758 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:56)", 1758, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1759 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:58)", 1759, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1760 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:63)", 1760, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1761 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:73)", 1761, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1762 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:84)", 1762, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1763 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:84)", 1763, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1764 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:84)", 1764, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1765 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:84)", 1765, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1766 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:87)", 1766, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1767 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:88)", 1767, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1768 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:88)", 1768, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1769 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:89)", 1769, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1770 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:89)", 1770, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1771 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:89)", 1771, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1772 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:89)", 1772, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1773 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:89)", 1773, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1774 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:90)", 1774, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1775 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:90)", 1775, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1776 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:91)", 1776, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1777 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:91)", 1777, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1778 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:93)", 1778, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1779 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:98)", 1779, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1780 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:102)", 1780, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1781 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:129)", 1781, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1782 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:132)", 1782, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1783 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:132)", 1783, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1784 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:133)", 1784, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1785 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:134)", 1785, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1786 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:134)", 1786, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1787 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:134)", 1787, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1788 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:134)", 1788, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1789 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:135)", 1789, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1790 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:137)", 1790, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1791 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:143)", 1791, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1792 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:155)", 1792, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1793 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:157)", 1793, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1794 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:157)", 1794, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1795 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:158)", 1795, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1796 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:159)", 1796, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1797 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:159)", 1797, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1798 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:159)", 1798, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1799 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:159)", 1799, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1800 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:160)", 1800, "Boolean");
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.__L1801 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/MergeXmlConfigResource.java:162)", 1801, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.MergeXmlConfigResource.initPerturbationLocation0();
    }
}

