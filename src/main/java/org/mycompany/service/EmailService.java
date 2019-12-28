package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.thymeleaf.context.Context;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String message);

    void sendTemplateEmail(String to, String subject, String templateName, Context context);

    // sendBeforeConfirEmail
    void sendVerificationEmail(AppUser appUser, String token);

    // sendBeforePasswordChanged
    //todo: javadocs
    void sendResetPasswordEmail(AppUser appUser, String token);

    // sendAfterSuccessPasswordChanged
    void sendPasswordChangedEmail(AppUser appUser);

    // sendAfterSuccessRegister
    void sendSuccessRegisterEmail(AppUser appUser);
}
