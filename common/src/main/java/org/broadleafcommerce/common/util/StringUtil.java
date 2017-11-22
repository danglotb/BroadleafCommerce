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


public class StringUtil {
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.util.StringUtil.class);

    public static long getChecksum(java.lang.String test) {
        try {
            byte[] buffer = test.getBytes();
            java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(buffer);
            java.util.zip.CheckedInputStream cis = new java.util.zip.CheckedInputStream(bais, new java.util.zip.Adler32());
            byte[] readBuffer = new byte[perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StringUtil.__L6695, buffer.length)];
            cis.read(readBuffer);
            return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StringUtil.__L6696, cis.getChecksum().getValue());
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static boolean segmentInclusion(java.lang.String bigger, java.lang.String included) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6699, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6697, org.apache.commons.lang.StringUtils.isEmpty(bigger))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6698, org.apache.commons.lang.StringUtils.isEmpty(included)))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6700, false);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6703, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6701, bigger.equals(included))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6702, org.broadleafcommerce.common.util.StringUtil.validateStartsWith(bigger, included)))));
    }

    private static boolean validateStartsWith(java.lang.String value, java.lang.String prefix) {
        boolean isIncluded = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6704, value.startsWith(prefix));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6708, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6705, isIncluded)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6707, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6706, prefix.endsWith("."))))))))) {
            isIncluded = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6709, value.startsWith((prefix + ".")));
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6710, isIncluded);
    }

    public static double determineSimilarity(java.lang.String test1, java.lang.String test2) {
        java.lang.String first = new java.lang.String(test1);
        first = first.replaceAll("[ \\t\\n\\r\\f\\v\\/\'-]", "");
        java.lang.Long originalChecksum = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StringUtil.__L6711, ((long) (org.broadleafcommerce.common.util.StringUtil.getChecksum(first))));
        java.lang.String second = new java.lang.String(test2);
        second = second.replaceAll("[ \\t\\n\\r\\f\\v\\/\'-]", "");
        java.lang.Long myChecksum = perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.util.StringUtil.__L6712, ((long) (org.broadleafcommerce.common.util.StringUtil.getChecksum(second))));
        org.broadleafcommerce.common.util.StatCalc calc = new org.broadleafcommerce.common.util.StatCalc();
        calc.enter(originalChecksum);
        calc.enter(myChecksum);
        return calc.getStandardDeviation();
    }

    public static java.lang.String cleanseUrlString(java.lang.String input) {
        return org.broadleafcommerce.common.util.StringUtil.removeSpecialCharacters(org.broadleafcommerce.common.util.StringUtil.decodeUrl(input));
    }

    public static java.lang.String decodeUrl(java.lang.String encodedUrl) {
        try {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6713, (encodedUrl == null)) ? null : java.net.URLDecoder.decode(encodedUrl, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            org.broadleafcommerce.common.util.StringUtil.LOG.warn("Could not decode URL.", e);
            return encodedUrl;
        }
    }

    public static java.lang.String removeSpecialCharacters(java.lang.String input) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6714, (input != null))) {
            input = input.replaceAll("[ \\r\\n]", "");
        }
        return input;
    }

    public static java.lang.String extractFieldNameFromExpression(java.lang.String expression) {
        return expression.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StringUtil.__L6717, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StringUtil.__L6715, expression.indexOf('['))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StringUtil.__L6716, 1)))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.StringUtil.__L6718, expression.lastIndexOf(']')));
    }

    public static java.lang.String getMapAsJson(java.util.Map<java.lang.String, java.lang.Object> objectMap) {
        java.lang.String nullString = "null";
        java.lang.StringBuffer sb = new java.lang.StringBuffer("{");
        boolean firstIteration = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6719, true);
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : objectMap.entrySet()) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6721, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6720, firstIteration))))) {
                sb.append(',');
            }
            sb.append(org.codehaus.jettison.json.JSONObject.quote(entry.getKey()));
            sb.append(':');
            java.lang.Object value = entry.getValue();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6722, (value == null))) {
                sb.append(nullString);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6723, (value instanceof java.lang.Boolean))) {
                    sb.append(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6724, ((java.lang.Boolean) (value)).booleanValue()));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6725, (value instanceof java.lang.String))) {
                        sb.append(org.codehaus.jettison.json.JSONObject.quote(value.toString()));
                    }else {
                        sb.append(value.toString());
                    }


            firstIteration = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6726, false);
        }
        sb.append("}");
        return sb.toString();
    }

    public static java.lang.String removeNonNumerics(java.lang.String value) {
        return value.replaceAll("[^\\d.]+", "").trim();
    }

    public static java.lang.String sanitize(java.lang.String string) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.StringUtil.__L6727, (string == null))) {
            return "NULL";
        }
        java.lang.String sanitized = string.replace('\n', '_').replace('\r', '_');
        return org.owasp.esapi.ESAPI.encoder().encodeForHTML(sanitized);
    }

    public static perturbation.location.PerturbationLocation __L6695;

    public static perturbation.location.PerturbationLocation __L6696;

    public static perturbation.location.PerturbationLocation __L6697;

    public static perturbation.location.PerturbationLocation __L6698;

    public static perturbation.location.PerturbationLocation __L6699;

    public static perturbation.location.PerturbationLocation __L6700;

    public static perturbation.location.PerturbationLocation __L6701;

    public static perturbation.location.PerturbationLocation __L6702;

    public static perturbation.location.PerturbationLocation __L6703;

    public static perturbation.location.PerturbationLocation __L6704;

    public static perturbation.location.PerturbationLocation __L6705;

    public static perturbation.location.PerturbationLocation __L6706;

    public static perturbation.location.PerturbationLocation __L6707;

    public static perturbation.location.PerturbationLocation __L6708;

    public static perturbation.location.PerturbationLocation __L6709;

    public static perturbation.location.PerturbationLocation __L6710;

    public static perturbation.location.PerturbationLocation __L6711;

    public static perturbation.location.PerturbationLocation __L6712;

    public static perturbation.location.PerturbationLocation __L6713;

    public static perturbation.location.PerturbationLocation __L6714;

    public static perturbation.location.PerturbationLocation __L6715;

    public static perturbation.location.PerturbationLocation __L6716;

    public static perturbation.location.PerturbationLocation __L6717;

    public static perturbation.location.PerturbationLocation __L6718;

    public static perturbation.location.PerturbationLocation __L6719;

    public static perturbation.location.PerturbationLocation __L6720;

    public static perturbation.location.PerturbationLocation __L6721;

    public static perturbation.location.PerturbationLocation __L6722;

    public static perturbation.location.PerturbationLocation __L6723;

    public static perturbation.location.PerturbationLocation __L6724;

    public static perturbation.location.PerturbationLocation __L6725;

    public static perturbation.location.PerturbationLocation __L6726;

    public static perturbation.location.PerturbationLocation __L6727;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.StringUtil.__L6695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:48)", 6695, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:50)", 6696, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:72)", 6697, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:72)", 6698, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:72)", 6699, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:73)", 6700, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:75)", 6701, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:75)", 6702, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:75)", 6703, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:79)", 6704, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:81)", 6705, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:81)", 6706, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:81)", 6707, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:81)", 6708, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:82)", 6709, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:84)", 6710, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:90)", 6711, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:93)", 6712, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:110)", 6713, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:119)", 6714, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:132)", 6715, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:132)", 6716, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:132)", 6717, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:132)", 6718, "Numerical");
        org.broadleafcommerce.common.util.StringUtil.__L6719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:138)", 6719, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:141)", 6720, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:141)", 6721, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:147)", 6722, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:149)", 6723, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:150)", 6724, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:151)", 6725, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:156)", 6726, "Boolean");
        org.broadleafcommerce.common.util.StringUtil.__L6727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/StringUtil.java:184)", 6727, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.StringUtil.initPerturbationLocation0();
    }
}

