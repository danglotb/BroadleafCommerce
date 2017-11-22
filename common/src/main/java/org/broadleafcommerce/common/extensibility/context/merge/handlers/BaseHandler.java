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
package org.broadleafcommerce.common.extensibility.context.merge.handlers;


public abstract class BaseHandler implements java.lang.Comparable<java.lang.Object> , org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler {
    protected int priority;

    protected java.lang.String xpath;

    protected org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] children = new org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[]{  };

    protected java.lang.String name;

    public int getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1301, priority);
    }

    public java.lang.String getXPath() {
        return xpath;
    }

    public void setPriority(int priority) {
        this.priority = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1302, priority);
    }

    public void setXPath(java.lang.String xpath) {
        this.xpath = xpath;
    }

    public int compareTo(java.lang.Object arg0) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1306, new java.lang.Integer(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1303, getPriority())).compareTo(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1305, new java.lang.Integer(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1304, ((org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler) (arg0)).getPriority())))));
    }

    public org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] getChildren() {
        return children;
    }

    public void setChildren(org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] children) {
        this.children = children;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public static perturbation.location.PerturbationLocation __L1301;

    public static perturbation.location.PerturbationLocation __L1302;

    public static perturbation.location.PerturbationLocation __L1303;

    public static perturbation.location.PerturbationLocation __L1304;

    public static perturbation.location.PerturbationLocation __L1305;

    public static perturbation.location.PerturbationLocation __L1306;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1301 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/BaseHandler.java:33)", 1301, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1302 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/BaseHandler.java:41)", 1302, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1303 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/BaseHandler.java:49)", 1303, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1304 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/BaseHandler.java:49)", 1304, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1305 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/BaseHandler.java:49)", 1305, "Numerical");
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.__L1306 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/BaseHandler.java:49)", 1306, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.BaseHandler.initPerturbationLocation0();
    }
}

