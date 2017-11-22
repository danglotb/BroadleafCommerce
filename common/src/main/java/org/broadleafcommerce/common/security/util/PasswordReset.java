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
package org.broadleafcommerce.common.security.util;


public class PasswordReset implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.String username;

    private java.lang.String email;

    private boolean passwordChangeRequired = false;

    private int passwordLength = 22;

    private boolean sendResetEmailReliableAsync = false;

    public PasswordReset() {
    }

    public PasswordReset(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public boolean getPasswordChangeRequired() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordReset.__L4903, passwordChangeRequired);
    }

    public void setPasswordChangeRequired(boolean passwordChangeRequired) {
        this.passwordChangeRequired = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordReset.__L4904, passwordChangeRequired);
    }

    public int getPasswordLength() {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordReset.__L4905, passwordLength);
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.PasswordReset.__L4906, passwordLength);
    }

    public boolean isSendResetEmailReliableAsync() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordReset.__L4907, sendResetEmailReliableAsync);
    }

    public void setSendResetEmailReliableAsync(boolean sendResetEmailReliableAsync) {
        this.sendResetEmailReliableAsync = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.PasswordReset.__L4908, sendResetEmailReliableAsync);
    }

    public static perturbation.location.PerturbationLocation __L4903;

    public static perturbation.location.PerturbationLocation __L4904;

    public static perturbation.location.PerturbationLocation __L4905;

    public static perturbation.location.PerturbationLocation __L4906;

    public static perturbation.location.PerturbationLocation __L4907;

    public static perturbation.location.PerturbationLocation __L4908;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.util.PasswordReset.__L4903 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordReset.java:61)", 4903, "Boolean");
        org.broadleafcommerce.common.security.util.PasswordReset.__L4904 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordReset.java:65)", 4904, "Boolean");
        org.broadleafcommerce.common.security.util.PasswordReset.__L4905 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordReset.java:69)", 4905, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordReset.__L4906 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordReset.java:73)", 4906, "Numerical");
        org.broadleafcommerce.common.security.util.PasswordReset.__L4907 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordReset.java:77)", 4907, "Boolean");
        org.broadleafcommerce.common.security.util.PasswordReset.__L4908 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/PasswordReset.java:81)", 4908, "Boolean");
    }

    static {
        org.broadleafcommerce.common.security.util.PasswordReset.initPerturbationLocation0();
    }
}

