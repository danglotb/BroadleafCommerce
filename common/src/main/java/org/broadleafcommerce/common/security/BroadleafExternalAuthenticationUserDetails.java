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
package org.broadleafcommerce.common.security;


public class BroadleafExternalAuthenticationUserDetails extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private java.lang.String firstName;

    private java.lang.String lastName;

    private java.lang.String email;

    private org.broadleafcommerce.common.site.domain.Site site;

    public BroadleafExternalAuthenticationUserDetails(java.lang.String username, java.lang.String password, java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }

    public BroadleafExternalAuthenticationUserDetails(java.lang.String username, java.lang.String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public org.broadleafcommerce.common.site.domain.Site getSite() {
        return site;
    }

    public void setSite(org.broadleafcommerce.common.site.domain.Site site) {
        this.site = site;
    }
}

