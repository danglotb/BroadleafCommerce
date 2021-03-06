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
package org.broadleafcommerce.common.config;


@java.lang.annotation.Target({ java.lang.annotation.ElementType.TYPE })
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.context.annotation.Import({ org.broadleafcommerce.common.config.EnableBroadleafServletAutoConfiguration.BroadleafServletAutoConfiguration.class, org.broadleafcommerce.common.config.EnableBroadleafAdminServletAutoConfiguration.BroadleafAdminServletAutoConfiguration.class, org.broadleafcommerce.common.config.EnableBroadleafAdminServletAutoConfiguration.BroadleafAdminServletAutoConfigurationOverrides.class })
public @interface EnableBroadleafAdminServletAutoConfiguration {
    @org.springframework.context.annotation.Import(org.broadleafcommerce.common.config.EnableBroadleafServletAutoConfiguration.BroadleafServletAutoConfiguration.class)
    @org.springframework.context.annotation.ImportResource(locations = { "classpath*:/blc-config/admin/framework/bl-*-applicationContext-servlet.xml", "classpath*:/blc-config/admin/early/bl-*-applicationContext-servlet.xml", "classpath*:/blc-config/admin/bl-*-applicationContext-servlet.xml", "classpath*:/blc-config/admin/late/bl-*-applicationContext-servlet.xml" }, reader = org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader.class)
    class BroadleafAdminServletAutoConfiguration {}

    @org.springframework.context.annotation.ImportResource("classpath:/override-contexts/admin-servlet-autoconfiguration-overrides.xml")
    class BroadleafAdminServletAutoConfigurationOverrides {}
}

