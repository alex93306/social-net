package org.mycompany.manager;

import org.mycompany.entity.AppUser;

public interface EmailManager {
    void sendEmail(String to, String subject, String message);

    // sendBeforeConfirEmail
    void sendConfirmEmail(AppUser appUser);

    // sendBeforePasswordChanged
    void sendResetPasswordEmail(AppUser appUser);

    // sendAfterSuccessPasswordChanged
    void sendPasswordChangedEmail(AppUser appUser);

    // sendAfterSuccessRegister
    void sendSuccessRegisterEmail(AppUser appUser);
}
