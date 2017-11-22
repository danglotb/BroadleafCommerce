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


public class MergeHandlerAdapter implements org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler {
    public org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] getChildren() {
        return null;
    }

    public java.lang.String getName() {
        return null;
    }

    public int getPriority() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandlerAdapter.__L1362, 0);
    }

    public java.lang.String getXPath() {
        return null;
    }

    public org.w3c.dom.Node[] merge(java.util.List<org.w3c.dom.Node> nodeList1, java.util.List<org.w3c.dom.Node> nodeList2, java.util.List<org.w3c.dom.Node> exhaustedNodes) {
        return null;
    }

    public void setChildren(org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler[] children) {
    }

    public void setName(java.lang.String name) {
    }

    public void setPriority(int priority) {
    }

    public void setXPath(java.lang.String xpath) {
    }

    public static perturbation.location.PerturbationLocation __L1362;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandlerAdapter.__L1362 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/extensibility/context/merge/handlers/MergeHandlerAdapter.java:44)", 1362, "Numerical");
    }

    static {
        org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandlerAdapter.initPerturbationLocation0();
    }
}

