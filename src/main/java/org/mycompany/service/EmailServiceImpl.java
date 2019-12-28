package org.mycompany.service;

import org.mycompany.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String HTML_SUFFIX = ".html";

    @Autowired private JavaMailSender mailSender;
    @Autowired private TemplateEngine thymleafEngine;

    @Override
    public void sendSimpleEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@spitter.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendTemplateEmail(String to, String subject, String templateName, Context context) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setTo(to);
            helper.setSubject(subject);
            String text = thymleafEngine.process(templateName + HTML_SUFFIX, context);
            helper.setText(text, true);
        } catch (Exception e) {
//            todo:
            e.printStackTrace();
        }

        mailSender.send(mimeMessage);
    }

    @Override
    public void sendVerificationEmail(AppUser appUser, String token) {
        Context context = new Context();
        context.setVariable("token", token);

        //todo: template create
        //todo: subject code
        //todo: fill template
        //todo: locale
        sendTemplateEmail(appUser.getEmail(), "verificationEmail.subject", "confirmEmail", context);
    }

    @Override
    public void sendResetPasswordEmail(AppUser appUser, String token) {
        Context context = new Context();
        //todo:
        context.setVariable("firstName", "alex");
        context.setVariable("token", token);

        //todo: template create
        //todo: subject code
        //todo: fill template
        //todo: locale
        sendTemplateEmail(appUser.getEmail(), "successRegister.subject", "resetPassword", context);
    }

    @Override
    public void sendPasswordChangedEmail(AppUser appUser) {
        Context context = new Context();
        context.setVariable("firstName", appUser.getFirstName());

        //todo: template create
        //todo: subject code
        //todo: fill template
        //todo: locale
        sendTemplateEmail(appUser.getEmail(), "passwordChanged.subject", "passwordChanged", context);
    }

    @Override
    public void sendSuccessRegisterEmail(AppUser appUser) {
        Context context = new Context();
        context.setVariable("firstName", appUser.getFirstName());

        //todo: template create
        //todo: subject code
        //todo: fill template
        //todo: locale
        sendTemplateEmail(appUser.getEmail(), "successRegister.subject", "successRegister", context);
    }
}
