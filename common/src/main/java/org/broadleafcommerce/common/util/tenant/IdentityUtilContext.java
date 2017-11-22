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
package org.broadleafcommerce.common.util.tenant;


public class IdentityUtilContext extends java.util.Stack<org.broadleafcommerce.common.util.tenant.IdentityUtilContext> {
    private static final long serialVersionUID = 1819548808605962648L;

    private static final java.lang.ThreadLocal<org.broadleafcommerce.common.util.tenant.IdentityUtilContext> IDENTITYUTILCONTEXT = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(org.broadleafcommerce.common.util.tenant.IdentityUtilContext.class);

    protected org.broadleafcommerce.common.site.domain.Site identifier;

    public static org.broadleafcommerce.common.util.tenant.IdentityUtilContext getUtilContext() {
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext anyIdentityUtilContext = org.broadleafcommerce.common.util.tenant.IdentityUtilContext.IDENTITYUTILCONTEXT.get();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6071, (anyIdentityUtilContext != null))) {
            return anyIdentityUtilContext.peek();
        }
        return anyIdentityUtilContext;
    }

    public static void setUtilContext(org.broadleafcommerce.common.util.tenant.IdentityUtilContext identityUtilContext) {
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext anyIdentityUtilContext = org.broadleafcommerce.common.util.tenant.IdentityUtilContext.IDENTITYUTILCONTEXT.get();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6072, (anyIdentityUtilContext != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6073, (identityUtilContext == null))) {
                anyIdentityUtilContext.pop();
                return ;
            }else {
                anyIdentityUtilContext.push(identityUtilContext);
                return ;
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6074, (identityUtilContext == null))) {
            org.broadleafcommerce.common.classloader.release.ThreadLocalManager.remove(org.broadleafcommerce.common.util.tenant.IdentityUtilContext.IDENTITYUTILCONTEXT);
        }else {
            identityUtilContext.push(identityUtilContext);
            org.broadleafcommerce.common.util.tenant.IdentityUtilContext.IDENTITYUTILCONTEXT.set(identityUtilContext);
        }
    }

    public org.broadleafcommerce.common.site.domain.Site getIdentifier() {
        return identifier;
    }

    public void setIdentifier(org.broadleafcommerce.common.site.domain.Site identifier) {
        this.identifier = identifier;
    }

    public static perturbation.location.PerturbationLocation __L6071;

    public static perturbation.location.PerturbationLocation __L6072;

    public static perturbation.location.PerturbationLocation __L6073;

    public static perturbation.location.PerturbationLocation __L6074;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityUtilContext.java:40)", 6071, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityUtilContext.java:48)", 6072, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityUtilContext.java:49)", 6073, "Boolean");
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext.__L6074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/tenant/IdentityUtilContext.java:57)", 6074, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.tenant.IdentityUtilContext.initPerturbationLocation0();
    }
}

