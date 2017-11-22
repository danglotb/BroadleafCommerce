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
package org.broadleafcommerce.common.util.xml;


public class ISO8601DateAdapter extends javax.xml.bind.annotation.adapters.XmlAdapter<java.lang.String, java.util.Date> {
    protected java.text.SimpleDateFormat isoFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @java.lang.Override
    public java.lang.String marshal(java.util.Date arg0) throws java.lang.Exception {
        java.text.SimpleDateFormat fmt = ((java.text.SimpleDateFormat) (isoFormat.clone()));
        return fmt.format(arg0);
    }

    @java.lang.Override
    public java.util.Date unmarshal(java.lang.String arg0) throws java.lang.Exception {
        java.text.SimpleDateFormat fmt = ((java.text.SimpleDateFormat) (isoFormat.clone()));
        return fmt.parse(arg0);
    }
}

