package org.mycompany;

import org.mycompany.config.RootConfig;
import org.mycompany.config.WebConfig;
import org.mycompany.manager.EmailManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.MailSender;

public class TestUtil {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        EmailManager mailSender = (EmailManager) applicationContext.getBean("emailManagerImpl");
        mailSender.sendConfirmEmail("alex93306@gmail.com", "324234");
    }
}
