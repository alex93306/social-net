package org.mycompany.manager;

public interface EmailManager {
    void sendEmail(String to, String subject, String message);

    void sendConfirmEmail(String to, String verifyKey);

    void sendResetPasswordEmail(String to);

    void sendPasswordChangedEmail(String to);
}
