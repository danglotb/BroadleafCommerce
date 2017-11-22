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
package org.broadleafcommerce.common.web.expression;


@org.springframework.stereotype.Component("blBRCVariableExpression")
@org.broadleafcommerce.presentation.condition.ConditionalOnTemplating
public class BRCVariableExpression implements org.broadleafcommerce.common.web.expression.BroadleafVariableExpression {
    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier("blCrossAppAuthService")
    protected org.broadleafcommerce.common.crossapp.service.CrossAppAuthService crossAppAuthService;

    @java.lang.Override
    public java.lang.String getName() {
        return "brc";
    }

    public org.broadleafcommerce.common.sandbox.domain.SandBox getSandbox() {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7182, (brc != null))) {
            return brc.getSandBox();
        }
        return null;
    }

    public org.broadleafcommerce.common.site.domain.Site getSite() {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7183, (brc != null))) {
            return brc.getNonPersistentSite();
        }
        return null;
    }

    public org.broadleafcommerce.common.site.domain.Site getCurrentProfile() {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7184, (brc != null))) {
            return brc.getCurrentProfile();
        }
        return null;
    }

    public org.broadleafcommerce.common.site.domain.Catalog getCurrentCatalog() {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7185, (brc != null))) {
            return brc.getCurrentCatalog();
        }
        return null;
    }

    public java.util.Date getCurrentTime() {
        return org.broadleafcommerce.common.time.SystemTime.asDate(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7186, true));
    }

    public java.lang.Object get(java.lang.String propertyName) {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7187, (brc != null))) {
            try {
                return org.apache.commons.beanutils.PropertyUtils.getProperty(brc, propertyName);
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        return null;
    }

    public boolean isCsrMode() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7191, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7188, ((crossAppAuthService) == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7189, false) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7190, crossAppAuthService.hasCsrPermission())));
    }

    public boolean isQuoteMode() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7195, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7192, ((crossAppAuthService) == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7193, false) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7194, crossAppAuthService.hasQuotePermission())));
    }

    public boolean isSandboxMode() {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7199, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7196, (brc == null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7197, false) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7198, ((brc.getSandBox()) != null))));
    }

    public java.lang.Object getAdditionalProperty(java.lang.String propertyName) {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7200, (brc != null))) {
            return brc.getAdditionalProperties().get(propertyName);
        }
        return null;
    }

    public static perturbation.location.PerturbationLocation __L7182;

    public static perturbation.location.PerturbationLocation __L7183;

    public static perturbation.location.PerturbationLocation __L7184;

    public static perturbation.location.PerturbationLocation __L7185;

    public static perturbation.location.PerturbationLocation __L7186;

    public static perturbation.location.PerturbationLocation __L7187;

    public static perturbation.location.PerturbationLocation __L7188;

    public static perturbation.location.PerturbationLocation __L7189;

    public static perturbation.location.PerturbationLocation __L7190;

    public static perturbation.location.PerturbationLocation __L7191;

    public static perturbation.location.PerturbationLocation __L7192;

    public static perturbation.location.PerturbationLocation __L7193;

    public static perturbation.location.PerturbationLocation __L7194;

    public static perturbation.location.PerturbationLocation __L7195;

    public static perturbation.location.PerturbationLocation __L7196;

    public static perturbation.location.PerturbationLocation __L7197;

    public static perturbation.location.PerturbationLocation __L7198;

    public static perturbation.location.PerturbationLocation __L7199;

    public static perturbation.location.PerturbationLocation __L7200;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7182 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:55)", 7182, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7183 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:63)", 7183, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7184 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:71)", 7184, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7185 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:79)", 7185, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7186 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:86)", 7186, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7187 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:91)", 7187, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7188 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:102)", 7188, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7189 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:102)", 7189, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7190 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:102)", 7190, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7191 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:102)", 7191, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7192 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:106)", 7192, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7193 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:106)", 7193, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7194 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:106)", 7194, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7195 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:106)", 7195, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7196 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:111)", 7196, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7197 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:111)", 7197, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7198 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:111)", 7198, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7199 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:111)", 7199, "Boolean");
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.__L7200 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/expression/BRCVariableExpression.java:116)", 7200, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.expression.BRCVariableExpression.initPerturbationLocation0();
    }
}

