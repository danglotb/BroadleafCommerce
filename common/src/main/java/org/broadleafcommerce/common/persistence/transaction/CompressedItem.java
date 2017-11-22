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
package org.broadleafcommerce.common.persistence.transaction;


public class CompressedItem {
    protected byte[] compressed;

    protected boolean decompressInToString = true;

    public static byte[] compress(final java.lang.String str) throws java.io.IOException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4112, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4108, (str == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4111, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4109, str.length())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4110, 0)))))))) {
            return null;
        }
        java.io.ByteArrayOutputStream obj = new java.io.ByteArrayOutputStream();
        java.util.zip.GZIPOutputStream gzip = new java.util.zip.GZIPOutputStream(obj);
        gzip.write(str.getBytes("UTF-8"));
        gzip.close();
        return obj.toByteArray();
    }

    public static java.lang.String decompress(final byte[] compressed) throws java.io.IOException {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4117, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4113, (compressed == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4116, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4114, compressed.length)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4115, 0)))))))) {
            return "";
        }
        java.util.zip.GZIPInputStream gis = new java.util.zip.GZIPInputStream(new java.io.ByteArrayInputStream(compressed));
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(gis, "UTF-8"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String line;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4118, ((line = bufferedReader.readLine()) != null))) {
            sb.append(line);
            sb.append("\n");
        } 
        return sb.toString();
    }

    public CompressedItem(java.lang.String start, boolean decompressInToString) throws java.io.IOException {
        this.decompressInToString = decompressInToString;
        this.compressed = org.broadleafcommerce.common.persistence.transaction.CompressedItem.compress(start);
    }

    public CompressedItem(byte[] compressed, boolean decompressInToString) {
        this.decompressInToString = decompressInToString;
        this.compressed = compressed;
    }

    public java.lang.String decompress() throws java.io.IOException {
        return org.broadleafcommerce.common.persistence.transaction.CompressedItem.decompress(compressed);
    }

    public boolean isDecompressInToString() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4119, decompressInToString);
    }

    public void setDecompressInToString(boolean decompressInToString) {
        this.decompressInToString = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4120, decompressInToString);
    }

    public byte[] getCompressed() {
        return compressed;
    }

    @java.lang.Override
    public java.lang.String toString() {
        java.lang.String response = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4121, decompressInToString)) {
            try {
                response = org.broadleafcommerce.common.persistence.transaction.CompressedItem.decompress(compressed);
            } catch (java.io.IOException e) {
            }
        }else {
            response = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4122, ((compressed) != null))) ? new java.lang.String(org.springframework.security.crypto.codec.Base64.encode(compressed)) : "" + "\n";
        }
        return response;
    }

    public static perturbation.location.PerturbationLocation __L4108;

    public static perturbation.location.PerturbationLocation __L4109;

    public static perturbation.location.PerturbationLocation __L4110;

    public static perturbation.location.PerturbationLocation __L4111;

    public static perturbation.location.PerturbationLocation __L4112;

    public static perturbation.location.PerturbationLocation __L4113;

    public static perturbation.location.PerturbationLocation __L4114;

    public static perturbation.location.PerturbationLocation __L4115;

    public static perturbation.location.PerturbationLocation __L4116;

    public static perturbation.location.PerturbationLocation __L4117;

    public static perturbation.location.PerturbationLocation __L4118;

    public static perturbation.location.PerturbationLocation __L4119;

    public static perturbation.location.PerturbationLocation __L4120;

    public static perturbation.location.PerturbationLocation __L4121;

    public static perturbation.location.PerturbationLocation __L4122;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4108 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:38)", 4108, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4109 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:38)", 4109, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4110 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:38)", 4110, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4111 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:38)", 4111, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4112 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:38)", 4112, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4113 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:49)", 4113, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4114 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:49)", 4114, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4115 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:49)", 4115, "Numerical");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4116 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:49)", 4116, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4117 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:49)", 4117, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4118 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:56)", 4118, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4119 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:81)", 4119, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4120 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:85)", 4120, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4121 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:95)", 4121, "Boolean");
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.__L4122 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/persistence/transaction/CompressedItem.java:102)", 4122, "Boolean");
    }

    static {
        org.broadleafcommerce.common.persistence.transaction.CompressedItem.initPerturbationLocation0();
    }
}

