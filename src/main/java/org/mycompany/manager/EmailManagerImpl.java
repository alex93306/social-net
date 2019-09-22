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
    public void sendEmail(String to, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@spitter.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendConfirmMail(String to, String verifyKey) {
        String message = "To activate account click <a href='/" + verifyKey;
        sendEmail(to, message);
    }

}
