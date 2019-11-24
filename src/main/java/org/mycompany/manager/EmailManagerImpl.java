package org.mycompany.manager;

import org.mycompany.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class EmailManagerImpl implements EmailManager {
    @Autowired
    //todo: maybe rename all classes to Mail instead Email
    private MailSender mailSender;

    @Autowired
    MessageSource messageSource;

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
    public void sendConfirmEmail(AppUser appUser) {

    }

    @Override
    public void sendResetPasswordEmail(AppUser appUser) {
        //todo: add locale or language to user instead of using default
        String subject = messageSource.getMessage("resetPassword.email.subject", new Object[0], Locale.getDefault());
        String text = "Reset Password text " + appUser.getUUID();
        sendEmail(appUser.getEmail(), subject, text);
    }

    @Override
    public void sendPasswordChangedEmail(AppUser appUser) {
        //todo: implement
    }

    @Override
    public void sendSuccessRegisterEmail(AppUser appUser) {
        //todo: implement
    }
}
