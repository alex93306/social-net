package org.mycompany;

import org.mycompany.config.RootConfig;
import org.mycompany.manager.EmailManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUtil {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        EmailManager mailSender = (EmailManager) applicationContext.getBean("emailManagerImpl");
        mailSender.sendResetPasswordEmail("alex93306@gmail.com");
    }
}
