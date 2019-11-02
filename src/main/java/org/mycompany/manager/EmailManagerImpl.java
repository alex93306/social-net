package org.mycompany.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailManagerImpl implements EmailManager {
    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@spitter.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendConfirmEmail(String to, String verifyKey) {
        String subject = "Confirmation email";



        String text = "text";
        sendEmail(to, subject, text);
    }

    @Override
    public void sendResetPasswordEmail(String to) {

    }

    @Override
    public void sendPasswordChangedEmail(String to) {
        String subject = "The password was changed!";
        sendEmail(to, subject, subject);
    }
}
