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
package org.broadleafcommerce.common.web;


public class SandBoxContext {
    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.web.SandBoxContext> SANDBOXCONTEXT = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.web.SandBoxContext.class);

    protected java.lang.Long sandBoxId;

    protected java.lang.Boolean previewMode = ((boolean) (false));

    public static org.broadleafcommerce.common.web.SandBoxContext getSandBoxContext() {
        return org.broadleafcommerce.common.web.SandBoxContext.SANDBOXCONTEXT.get();
    }

    public static void setSandBoxContext(org.broadleafcommerce.common.web.SandBoxContext sandBoxContext) {
        org.broadleafcommerce.common.web.SandBoxContext.SANDBOXCONTEXT.set(sandBoxContext);
    }

    public java.lang.Long getSandBoxId() {
        return sandBoxId;
    }

    public void setSandBoxId(java.lang.Long sandBoxId) {
        this.sandBoxId = sandBoxId;
    }

    public java.lang.Boolean getPreviewMode() {
        return previewMode;
    }

    public void setPreviewMode(java.lang.Boolean previewMode) {
        this.previewMode = previewMode;
    }

    public org.broadleafcommerce.common.web.SandBoxContext clone() {
        org.broadleafcommerce.common.web.SandBoxContext myContext = new org.broadleafcommerce.common.web.SandBoxContext();
        myContext.setSandBoxId(getSandBoxId());
        myContext.setPreviewMode(getPreviewMode());
        return myContext;
    }
}

