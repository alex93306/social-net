package org.mycompany.manager;

public interface EmailManager {
    void sendEmail(String to, String message);

    void sendConfirmMail(String to, String verifyKey);
}
