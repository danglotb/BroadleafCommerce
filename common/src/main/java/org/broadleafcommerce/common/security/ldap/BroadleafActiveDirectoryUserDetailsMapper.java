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
package org.broadleafcommerce.common.security.ldap;


@java.lang.Deprecated
public class BroadleafActiveDirectoryUserDetailsMapper extends org.springframework.security.ldap.userdetails.LdapUserDetailsMapper {
    protected boolean useEmailAddressAsUsername = true;

    protected boolean additiveRoleNameSubstitutions = false;

    protected java.util.Map<java.lang.String, java.lang.String[]> roleNameSubstitutions;

    @java.lang.Override
    public org.springframework.security.core.userdetails.UserDetails mapUserFromContext(org.springframework.ldap.core.DirContextOperations ctx, java.lang.String username, java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
        java.util.Collection<org.springframework.security.core.GrantedAuthority> newAuthorities = new java.util.HashSet<org.springframework.security.core.GrantedAuthority>();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4833, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4830, ((roleNameSubstitutions) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4832, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4831, roleNameSubstitutions.isEmpty())))))))) {
            for (org.springframework.security.core.GrantedAuthority authority : authorities) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4834, roleNameSubstitutions.containsKey(authority.getAuthority()))) {
                    java.lang.String[] roles = roleNameSubstitutions.get(authority.getAuthority());
                    for (java.lang.String role : roles) {
                        newAuthorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority(role.trim()));
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4835, additiveRoleNameSubstitutions)) {
                        newAuthorities.add(authority);
                    }
                }else {
                    newAuthorities.add(authority);
                }
            }
        }else {
            newAuthorities.addAll(authorities);
        }
        java.lang.String email = ((java.lang.String) (ctx.getObjectAttribute("mail")));
        org.springframework.security.core.userdetails.UserDetails userDetails = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4836, useEmailAddressAsUsername)) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4837, (email != null))) {
                userDetails = super.mapUserFromContext(ctx, email, newAuthorities);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4838, (userDetails == null))) {
            userDetails = super.mapUserFromContext(ctx, username, newAuthorities);
        }
        java.lang.String password = userDetails.getPassword();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4839, (password == null))) {
            password = userDetails.getUsername();
        }
        org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails broadleafUser = new org.broadleafcommerce.common.security.BroadleafExternalAuthenticationUserDetails(userDetails.getUsername(), password, userDetails.getAuthorities());
        broadleafUser.setFirstName(((java.lang.String) (ctx.getObjectAttribute("givenName"))));
        broadleafUser.setLastName(((java.lang.String) (ctx.getObjectAttribute("sn"))));
        broadleafUser.setEmail(email);
        return broadleafUser;
    }

    public void setUseEmailAddressAsUsername(boolean value) {
        this.useEmailAddressAsUsername = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4840, value);
    }

    public void setRoleNameSubstitutions(java.util.Map<java.lang.String, java.lang.String[]> roleNameSubstitutions) {
        this.roleNameSubstitutions = roleNameSubstitutions;
    }

    public void setAdditiveRoleNameSubstitutions(boolean additiveRoleNameSubstitutions) {
        this.additiveRoleNameSubstitutions = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4841, additiveRoleNameSubstitutions);
    }

    public static perturbation.location.PerturbationLocation __L4830;

    public static perturbation.location.PerturbationLocation __L4831;

    public static perturbation.location.PerturbationLocation __L4832;

    public static perturbation.location.PerturbationLocation __L4833;

    public static perturbation.location.PerturbationLocation __L4834;

    public static perturbation.location.PerturbationLocation __L4835;

    public static perturbation.location.PerturbationLocation __L4836;

    public static perturbation.location.PerturbationLocation __L4837;

    public static perturbation.location.PerturbationLocation __L4838;

    public static perturbation.location.PerturbationLocation __L4839;

    public static perturbation.location.PerturbationLocation __L4840;

    public static perturbation.location.PerturbationLocation __L4841;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4830 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:56)", 4830, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4831 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:56)", 4831, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4832 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:56)", 4832, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4833 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:56)", 4833, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4834 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:58)", 4834, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4835 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:63)", 4835, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4836 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:76)", 4836, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4837 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:77)", 4837, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4838 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:82)", 4838, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4839 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:87)", 4839, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4840 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:105)", 4840, "Boolean");
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.__L4841 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/ldap/BroadleafActiveDirectoryUserDetailsMapper.java:136)", 4841, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.ldap.BroadleafActiveDirectoryUserDetailsMapper.initPerturbationLocation0();
    }
}

