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
package org.broadleafcommerce.common.enumeration.service;


@org.springframework.stereotype.Service("blDataDrivenEnumerationService")
public class DataDrivenEnumerationServiceImpl implements org.broadleafcommerce.common.enumeration.service.DataDrivenEnumerationService {
    @javax.annotation.Resource(name = "blDataDrivenEnumerationDao")
    protected org.broadleafcommerce.common.enumeration.dao.DataDrivenEnumerationDao dao;

    @java.lang.Override
    public org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration findEnumByKey(java.lang.String enumKey) {
        return dao.readEnumByKey(enumKey);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue findEnumValueByKey(java.lang.String enumKey, java.lang.String enumValueKey) {
        return dao.readEnumValueByKey(enumKey, enumValueKey);
    }
}

