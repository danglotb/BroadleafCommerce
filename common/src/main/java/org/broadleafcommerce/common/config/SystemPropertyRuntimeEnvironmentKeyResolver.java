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


@java.lang.Deprecated
public class SystemPropertyRuntimeEnvironmentKeyResolver implements org.broadleafcommerce.common.config.RuntimeEnvironmentKeyResolver {
    protected java.lang.String environmentKey = "runtime.environment";

    public SystemPropertyRuntimeEnvironmentKeyResolver() {
    }

    @java.lang.Override
    public java.lang.String resolveRuntimeEnvironmentKey() {
        return java.lang.System.getProperty(environmentKey);
    }

    public void setEnvironmentKey(java.lang.String environmentKey) {
        this.environmentKey = environmentKey;
    }
}

