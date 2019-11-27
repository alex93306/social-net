package org.mycompany.manager;

import org.mycompany.entity.AppUser;

public interface EmailManager {
    void sendSimpleEmail(String to, String subject, String message);

    void sendTemplateEmail(String to, String subject);

    // sendBeforeConfirEmail
    void sendVerificationEmail(AppUser appUser);

    // sendBeforePasswordChanged
    void sendResetPasswordEmail(AppUser appUser);

    // sendAfterSuccessPasswordChanged
    void sendPasswordChangedEmail(AppUser appUser);

    // sendAfterSuccessRegister
    void sendSuccessRegisterEmail(AppUser appUser);
}
