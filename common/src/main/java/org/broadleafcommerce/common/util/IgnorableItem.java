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


public class IgnorableItem {
    private java.lang.String key;

    private java.lang.String value;

    private java.util.regex.Pattern compiled;

    public java.lang.String getKey() {
        return key;
    }

    public void setKey(java.lang.String key) {
        this.key = key;
    }

    public java.lang.String getValue() {
        return value;
    }

    public void setValue(java.lang.String value) {
        this.value = value;
    }

    public java.util.regex.Pattern getCompiled() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.IgnorableItem.__L6357, ((compiled) == null))) {
            compiled = java.util.regex.Pattern.compile(value);
        }
        return compiled;
    }

    public static perturbation.location.PerturbationLocation __L6357;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.IgnorableItem.__L6357 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/IgnorableItem.java:52)", 6357, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.IgnorableItem.initPerturbationLocation0();
    }
}

