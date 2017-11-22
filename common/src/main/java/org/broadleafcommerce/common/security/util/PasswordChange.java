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


public class PasswordChange extends org.broadleafcommerce.common.security.util.PasswordReset {
    private static final long serialVersionUID = 1L;

    private java.lang.String currentPassword;

    private java.lang.String newPassword;

    private java.lang.String newPasswordConfirm;

    private java.lang.String challengeQuestion;

    private java.lang.String challengeAnswer;

    public PasswordChange(java.lang.String username) {
        super(username);
    }

    public java.lang.String getChallengeQuestion() {
        return challengeQuestion;
    }

    public void setChallengeQuestion(java.lang.String challengeQuestion) {
        this.challengeQuestion = challengeQuestion;
    }

    public java.lang.String getChallengeAnswer() {
        return challengeAnswer;
    }

    public void setChallengeAnswer(java.lang.String challengeAnswer) {
        this.challengeAnswer = challengeAnswer;
    }

    public java.lang.String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(java.lang.String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public java.lang.String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(java.lang.String newPassword) {
        this.newPassword = newPassword;
    }

    public java.lang.String getNewPasswordConfirm() {
        return newPasswordConfirm;
    }

    public void setNewPasswordConfirm(java.lang.String newPasswordConfirm) {
        this.newPasswordConfirm = newPasswordConfirm;
    }
}

