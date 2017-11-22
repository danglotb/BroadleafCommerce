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


@org.springframework.stereotype.Service("blBLCMessageUtils")
public class BLCMessageUtils implements org.springframework.context.ApplicationContextAware {
    protected static org.springframework.context.ApplicationContext applicationContext;

    public static java.lang.String getMessage(java.lang.String code) {
        return org.broadleafcommerce.common.util.BLCMessageUtils.getMessage(code, ((java.lang.Object) (null)));
    }

    public static java.lang.String getMessage(java.lang.String code, java.lang.Object... args) {
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        return org.broadleafcommerce.common.util.BLCMessageUtils.getMessageSource().getMessage(code, args, brc.getJavaLocale());
    }

    protected static org.springframework.context.MessageSource getMessageSource() {
        return ((org.springframework.context.MessageSource) (org.broadleafcommerce.common.util.BLCMessageUtils.applicationContext.getBean("messageSource")));
    }

    @java.lang.Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
        org.broadleafcommerce.common.util.BLCMessageUtils.applicationContext = applicationContext;
    }
}

